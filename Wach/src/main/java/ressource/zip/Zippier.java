package ressource.zip;


import java.io.IOException;
import java.io.PrintStream;
import java.util.zip.ZipFile;


/**
 * TODO Write the class' description
 *
 * @author
 */
public class Zippier {

    public void printEntries(final PrintStream stream, final String zip) {
        try (ZipFile zipFile = new ZipFile(zip)) {
            zipFile.stream().forEach(stream::println);
        } catch (IOException e) {
            // error while opening a ZIP file
        }
    }
}
