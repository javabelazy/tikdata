/**
 * 
 */
package codetest.util;

import static codetest.constants.Constants.OUTPUT_SRC;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Apple
 *
 */
public class DataWriter {

	public void writeData(String ohclData, String zScoreData) throws IOException {
		Path path = Paths.get(OUTPUT_SRC);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(ohclData.concat(zScoreData));
		}

	}
}
