/**
 * @author josedg
 * @description App that will use the classes Scanner, File, and FileWriter to create and write on an archive
 */

package streamapp;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class StreamDemo {


	
	public static void main(String[] args) {
		
		try {
			// Open Scanner to introduce the path 
			Scanner scan = new Scanner(System.in);
			System.out.println("Type the absolute path, name and extension of the file you wish to create,");
			System.out.println("in the form /folder1/folder2/file.extension: (don't forger the first /)");
			String path = scan.nextLine();
			
			// Use the path specified by the user
			File file1 = new File(path);
			if (file1.createNewFile()) {
				System.out.println("'" + file1 + "' has been successfully created.");
			} else {
				System.out.println("'" + file1 + "' already exists.");
			}
			
			// Now we prompt the user to write inside the file
			System.out.println("Now insert the text you want inside the file");
			String sentence = scan.nextLine();
			scan.close();
			FileWriter out = new FileWriter(path, true);
			for (int i=0; i < sentence.length(); i++) {
				out.write(sentence.charAt(i));
			}
			out.close();
			
		} catch (IOException exc) {
			exc.printStackTrace();
		}
		
	}

}
