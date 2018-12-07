package org.niravra.finalproject.mahout;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataCleansing {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("/Users/niravrakar/Desktop/CosmicData1.csv"));
	BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/niravrakar/Desktop/CosmicData2.csv"));
	
	String line;
	while((line = br.readLine()) != null) {
		String[] values = line.split(",", -1);
		bw.write(values[0] + "," + values[1] + "," + values[2] + "\n");
	}
	
	br.close();
	bw.close();
	}
}
