/*
*  Database Fixer for Handwritten Names Dataset 
*  Copyright (c) 2017 Iker García and Eritz Yerga
*  https://github.com/ikergarcia1996/Handwritten-Names-Recognition
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class fix {

	
	static int actualLine = 1;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("./first_and_last_names.csv"));
		PrintWriter writer = new PrintWriter("./first_and_last_names_fix.csv", "UTF-8");
		String line = br.readLine();
		writer.println(line);
		line = br.readLine();
		
		while (line!=null)
		{
			if (line.length()>0)
			{
				if (Character.isDigit(line.charAt(0)))
				{	
					if (line.endsWith("\""))
					writer.println(line);
					else
					writer.print(line);
				}
				else
				{
					if(line.endsWith("\""))
					{	
						writer.print("\"");
						line = line.substring(line.indexOf(","), line.length());
						writer.println(line);
					}
				}
			}
			line = br.readLine();
			actualLine++;
			if(actualLine%1000==0)
				System.out.println(actualLine);
			
			
		
		}
		br.close();
		writer.close();
	}

}
