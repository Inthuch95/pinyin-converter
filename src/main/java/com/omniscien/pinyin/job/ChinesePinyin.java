package com.omniscien.pinyin.job;

import java.util.Arrays;
import java.util.Scanner;

import com.omniscien.pinyin.converter.PinyinConverter;

public class ChinesePinyin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	
	/**
	 * Takes an EN-ZH parallel corpus in the form [EN sentence]\t[ZH sentence] from stdin and convert ZH text to pinyin
	 */
	private static void run() {
		// Progress tracking variables
        int iDotNLCount = 1000;
        int iDotCount = 10;
        int iFileCount = 0;
		try {
			// Initialise converter
			PinyinConverter pinyinConverter = new PinyinConverter(); 
			
			// Read input from stdin
	        Scanner scanner = new Scanner(System.in);
	        String pinyinText = "";
			String line = "";
			String source = "";
			String target = "";
			while (scanner.hasNext()) {
				try {
					// Print progress
	        		if (iFileCount % iDotNLCount == 0) {
	                    if (iFileCount > 0) {
	                        System.err.print("\n");
	                    }
	                    System.err.print(iFileCount + " ");
	                }
	                if (iFileCount % iDotCount == 0) {
	                    System.err.print(".");
	                }
	                iFileCount++;
	                
	                // Process each line in corpus
					line = scanner.nextLine();
					if ((Arrays.asList(line.split("\t"))).size() == 2) {
						// Get source and target
						source = line.split("\t")[0];
						target = line.split("\t")[1];
						// Convert to pinyin
						pinyinText = pinyinConverter.convertToPinyin(target);
						System.out.println(source + "\t" + pinyinText.trim().replaceAll(" +", " "));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
