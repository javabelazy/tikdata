/**
 * 
 */
package codetest.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static codetest.constants.Constants.INPUT_SRC;

/**
 * @author Apple
 *
 */
public class DataReader {
	
	
	public List<String> readData() {
		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(INPUT_SRC))) {
			list = stream.skip(1).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
