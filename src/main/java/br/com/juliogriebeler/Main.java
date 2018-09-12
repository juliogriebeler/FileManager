/**
 *
 */
package br.com.juliogriebeler;

import java.util.logging.Logger;

import br.com.juliogriebeler.parser.watch.DirectoryWatcher;
import br.com.juliogriebeler.parser.util.Constants;

/**
 * Classe Main para iniciar a execução da aplicação
 *
 * @author juliogriebeler
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    private Main() {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LOGGER.info("Iniciando o leitor de arquivos");

        final DirectoryWatcher watcher = new DirectoryWatcher(Constants.DIR_IN);

        watcher.readFilesOnce();

        watcher.startWatchingDirectory();
    }

}
