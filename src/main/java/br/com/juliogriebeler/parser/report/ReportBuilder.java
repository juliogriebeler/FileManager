/**
 *
 */
package br.com.juliogriebeler.parser.report;

import br.com.juliogriebeler.parser.exception.ParserRuntimeException;
import br.com.juliogriebeler.parser.util.ParserUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.juliogriebeler.parser.factory.ParserFactory;
import br.com.juliogriebeler.parser.model.Customer;
import br.com.juliogriebeler.parser.model.FileData;
import br.com.juliogriebeler.parser.model.ParsedValue;
import br.com.juliogriebeler.parser.model.Sale;
import br.com.juliogriebeler.parser.model.Seller;
import br.com.juliogriebeler.parser.util.Constants;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juliogriebeler
 */
public class ReportBuilder {

	private static final Logger LOGGER = Logger.getLogger(ReportBuilder.class.getName());

	/**
	 * @param filePath
	 */
	public void readFile(Path filePath) {
		final FileData fileData = new FileData();

		try (Stream<String> stream = Files.lines(filePath, StandardCharsets.UTF_8)) {
			stream.forEach(line -> {

				LOGGER.log(Level.INFO, "Lendo linha: {0} ", line);

				ParsedValue parsedValue = ParserUtil.parseStringValue(line, Constants.LINE_SEPARATOR);

				ParserFactory.getParser(parsedValue.getFirstParam()).parse(fileData, parsedValue);

				writeFile(filePath, fileData);
			});
		} catch (IOException e) {
			LOGGER.log(Level.INFO, "Erro ao ler arquivo {0}", filePath);

			throw new ParserRuntimeException(e);
		}
	}

	/**
	 * @param filePath
	 * @param fileData
	 */
	public void writeFile(Path filePath, FileData fileData) {
		final String fileOut = Constants.DIR_OUT + filePath.getFileName().toString().replace(Constants.FILETYPE_IN, Constants.BLANK_SPACE) + Constants.FILETYPE_OUT;

		final StringBuilder contentOut = new StringBuilder();

		contentOut.append(getTextCustomerQty(fileData));
		contentOut.append(Constants.LINE_BREAK);
		contentOut.append(getTextSellerQty(fileData));
		contentOut.append(Constants.LINE_BREAK);
		contentOut.append(getTextSaleHigestValue(fileData));
		contentOut.append(Constants.LINE_BREAK);
		contentOut.append(getTextWorstSeller(fileData));

		LOGGER.log(Level.INFO, "Gerando arquivo de saída: {0} ", fileOut);

		try {
			Files.write(Paths.get(fileOut), contentOut.toString().getBytes(StandardCharsets.ISO_8859_1));

			LOGGER.log(Level.INFO, "Arquivo gerado com sucesso: {0} ", fileOut);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Ocorreu um erro ao gerar o arquivo {0}", e.getMessage());

			throw new ParserRuntimeException(e);
		}
	}

	/**
	 * @param fileData
	 * @return
	 */
	public String getTextCustomerQty(FileData fileData) {
		final StringBuilder message = new StringBuilder("1. Quantidade de Clientes: ");
		// separa/agrupa os clientes pelo nome e calcula a quantidade
		message.append(
				fileData.getCustomers().stream().map(Customer::getName).distinct().collect(Collectors.toList()).size());

		return message.toString();
	}

	/**
	 * @param fileData
	 * @return separa/agrupa os vendedores pelo nome, calcula a quantidade e retorna
	 *         com a descrição
	 */
	public String getTextSellerQty(FileData fileData) {
		final StringBuilder message = new StringBuilder("2. Quantidade de Vendedores: ");

		message.append(
				fileData.getSellers().stream().map(Seller::getName).distinct().collect(Collectors.toList()).size());

		return message.toString();
	}

	/**
	 * @param fileData
	 * @return busca a venda com valor mais alto e retorna com a descrição
	 */
	public String getTextSaleHigestValue(FileData fileData) {
		final StringBuilder message = new StringBuilder("3. ID da Venda de valor mais alto: ");

		final Sale saleHigestValue = fileData.getSales().stream().max(Comparator.comparing(Sale::getTotalValue))
				.orElse(null);

		if (saleHigestValue != null) {
			message.append(saleHigestValue.getIdSale());
		}

		return message.toString();
	}

	/**
	 * @param fileData
	 * @return busca o vendedor com menos vendas e retorna com a descrição
	 */
	public String getTextWorstSeller(FileData fileData) {
		final StringBuilder message = new StringBuilder("4. Nome do pior Vendedor: ");

		final Map<Seller, Double> map = fileData.getSales().stream()
				.collect(Collectors.groupingBy(Sale::getSeller, Collectors.summingDouble(Sale::getTotalValue)));

		if (!map.isEmpty()) {
			final Comparator<Entry<Seller, Double>> comparator = Map.Entry.comparingByValue();

			Seller worstSeller;

			if (map.entrySet().stream().min(comparator).isPresent()) {
				worstSeller = map.entrySet().stream().min(comparator).orElse(null).getKey();

				if (worstSeller != null) {
					message.append(worstSeller.getName());
				}
			}
		}

		return message.toString();
	}
}
