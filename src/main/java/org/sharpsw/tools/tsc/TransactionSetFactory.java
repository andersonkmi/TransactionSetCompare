package org.sharpsw.tools.tsc;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionSetFactory {	
	public List<Long> parse(String fileName) throws IOException {
		List<Long> results = new ArrayList<Long>();
		FileInputStream file = new FileInputStream(fileName);
		DataInputStream stream = new DataInputStream(file);
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		
		String line = "";
		while((line = reader.readLine()) != null) {
			line = line.trim();
			Long transactionNumber = new Long(Long.parseLong(line));
			results.add(transactionNumber);
		}		
		reader.close();
		
		Collections.sort(results);
		
		return results;
	}
} 
