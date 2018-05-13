/**
 *  Project example for usi9ng Streams
 *  We need to specify the files in the Command Line.
 *  
 *  java comparefiles/CompFile FIRST.TXT SECOND.TXT
 *  the directory to execute said command must be in src
 */
package comparefiles;

import java.io.*;

public class CompFiles {
	public static void main(String[] args) {
		
		int i=0,
			j=0;
		
		// First we need to check that both files has been specified
		if (args.length != 2) {
			System.out.println("Usage: CompFiles f1 f2");
			return;
		}
		
		// Compare the files
		try (FileInputStream f1 = new FileInputStream(args[0]);
				FileInputStream f2 = new FileInputStream(args[1])) {
			// Check content of each file
			do {
				i = f1.read();
				j = f2.read();
				if (i != j) break;
				
			} while (i != -1 && j != -1);
			
			if (i != j ) {
				System.out.println("Files differ.");
			} else {
				System.out.println("Files are the same.");
			} 
		} catch (IOException exc ) {
			System.out.println("I/O Errror: " + exc);
		}	
	}
}
