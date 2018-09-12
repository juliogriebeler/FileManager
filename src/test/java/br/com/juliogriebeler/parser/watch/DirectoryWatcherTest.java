/**
 *
 */
package br.com.juliogriebeler.parser.watch;

import br.com.juliogriebeler.parser.watch.DirectoryWatcher;
import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import br.com.juliogriebeler.parser.util.Constants;

/**
 *
 * @author juliogriebeler
 */
public class DirectoryWatcherTest {

    private DirectoryWatcher service;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        service = new DirectoryWatcher(Constants.DIR_IN);
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.DirectoryWatcherService#DirectoryWatcherService(java.lang.String)}.
     */
    @Test
    public void testDirectoryWatcherService() {
        assertFalse("verify FileStream", service.getFileStream() == null);
        assertFalse("verify RepostBuilder", service.getReportBuilder() == null);
        assertFalse("verify Path", service.getPath() == null);
    }

    /**
     * Test method for
     * {@link br.com.juliogriebeler.service.DirectoryWatcherService#initiateDirectory(java.nio.file.Path)}.
     */
    @Test
    public void testInitiateDirectory() {
        Path path = Paths.get(Constants.DIR_IN);

        service.initiateDirectory(Paths.get(Constants.DIR_IN));

        assertTrue("verify Directory", path.toFile().isDirectory());
    }

}
