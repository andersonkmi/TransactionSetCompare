package org.sharpsw.tools.tsc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DataFileExport {
	public void exportData(final List<Long> data, String file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for(Long value : data) {
			StringBuffer buffer = new StringBuffer();
			buffer.append(value);
			writer.write(buffer.toString());
			writer.newLine();
		}
		
		writer.flush();
		writer.close();
	}
}
