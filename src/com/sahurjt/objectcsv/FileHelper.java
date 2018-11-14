package com.sahurjt.objectcsv;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class FileHelper {

	private static final String NEW_LINE_CHAR = "\n";

	public static List<String> readFileByLine(String filePath) throws IOException, URISyntaxException {
		FileReader reader = new FileReader(getFile(filePath));
		BufferedReader bufferedReader = new BufferedReader(reader);
		List<String> linesInFile = new ArrayList<String>();

		String line;
		while ((line = bufferedReader.readLine()) != null) {
			linesInFile.add(line);
		}

		bufferedReader.close();
		return linesInFile;
	}

	public static String readFileAsString(String filePath) throws IOException, URISyntaxException {
		List<String> linesInFile = readFileByLine(filePath);
		StringBuffer buffer = new StringBuffer();
		for (String line : linesInFile) {
			buffer.append(line + NEW_LINE_CHAR);
		}
		return buffer.toString();
	}


	private static File getFile(String filePath) {
		return new File(filePath);
	}

}
