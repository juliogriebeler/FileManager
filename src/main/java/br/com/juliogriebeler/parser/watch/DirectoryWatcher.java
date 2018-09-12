/**
 *
 */
package br.com.juliogriebeler.parser.watch;

import br.com.juliogriebeler.parser.exception.ParserRuntimeException;
import br.com.juliogriebeler.parser.report.ReportBuilder;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import br.com.juliogriebeler.parser.util.Constants;

/**
 *
 * @author juliogriebeler
 */
public class DirectoryWatcher {

    private static final Logger LOGGER = Logger.getLogger(DirectoryWatcher.class.getName());

    private Stream<Path> fileStream;
    private Path path;
    private ReportBuilder reportBuilder;

    /**
     *
     * @param dirIn
     */
    public DirectoryWatcher(String dirIn) {
        this.reportBuilder = new ReportBuilder();

        this.path = Paths.get(dirIn);

        this.verifyDirectory(path);

        this.renewFileStream();
    }

    /**
     *
     * @param path
     */
    private void verifyDirectory(Path path) {
        this.initiateDirectory(path);
    }

    /**
     *
     */
    private void renewFileStream() {
        try {
            this.setFileStream(Files.walk(getPath()));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao iniciar varredura do diretorio: {0} ", e.getMessage());

            throw new ParserRuntimeException(e);
        }
    }

    /**
     *
     */
    public void readFilesOnce() {
        try (Stream<Path> streamList = Files.list(Paths.get(getPath().toUri()))) {
            streamList.forEach(file -> getReportBuilder().readFile(file));
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro a leitura dos arquivos no diretorio: {0} ", e.getMessage());

            throw new ParserRuntimeException(e);
        }
    }

    /**
     *
     */
    public void startWatchingDirectory() {
        LOGGER.log(Level.INFO, "Iniciando varredura diretorio");

        try (WatchService service = getPath().getFileSystem().newWatchService()) {
            getPath().register(service, ENTRY_CREATE);

            getPath().register(service, ENTRY_MODIFY);

            iterateOverDirectory(service);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());

            throw new ParserRuntimeException(e);
        }
    }

    /**
     * @param path
     */
    public void initiateDirectory(Path path) {
        if (!path.toFile().exists() || !path.toFile().isDirectory()) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "Diretorio nao existe e não pôde ser criado: {0} ", e.getMessage());

                throw new ParserRuntimeException(e);
            }
        }
    }

    /**
     *
     */
    public void processFile() {
        LOGGER.log(Level.INFO, "Aplicando filter no processamento");

        getFileStream().filter(
                file -> file.toFile().isFile() && file.toFile().getAbsolutePath().endsWith(Constants.FILETYPE_IN))
                .forEach(file -> getReportBuilder().readFile(file));

        this.renewFileStream();
    }

    /**
     * @param watchService
     */
    public void iterateOverDirectory(WatchService watchService) {
        LOGGER.log(Level.INFO, "Iterando diretorio");

        WatchKey watchKey;

        while (true) {
            try {
                watchKey = watchService.take();

                watchKey.pollEvents().stream().forEach(w -> processWatchEntry(w));

                if (!watchKey.reset()) {
                    break;
                }
            } catch (InterruptedException e) {
                LOGGER.log(Level.SEVERE, e.getMessage());

                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * @param watchEvent
     */
    public void processWatchEntry(WatchEvent<?> watchEvent) {
        LOGGER.log(Level.INFO, "Processando entrada");

        if (ENTRY_CREATE.equals(watchEvent.kind()) || ENTRY_MODIFY.equals(watchEvent.kind())) {
            this.processFile();
        }
    }

    /**
     * @return the fileStream
     */
    public Stream<Path> getFileStream() {
        return fileStream;
    }

    /**
     * @param fileStream the fileStream to set
     */
    public void setFileStream(Stream<Path> fileStream) {
        this.fileStream = fileStream;
    }

    /**
     * @return the path
     */
    public Path getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * @return the reportBuilder
     */
    public ReportBuilder getReportBuilder() {
        return reportBuilder;
    }

    /**
     * @param reportBuilder the reportBuilder to set
     */
    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

}
