package org.iit.selenium.mmpspark;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReaderEx {
	
	public static void main(String[] args) throws IOException {
		
		String filePath = System.getProperty("user.dir")+"//config//Selenium.txt";
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream br = new BufferedInputStream(fis);	
//		FileReader fr = new FileReader(f);
//		BufferedReader br = new BufferedReader(fr);
		int str;
		while((str=br.read()) != -1)
		{
			System.out.print((char)str);
		}
		
	}

}
