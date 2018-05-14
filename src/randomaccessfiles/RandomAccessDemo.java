package randomaccessfiles;

import java.io.*;

public class RandomAccessDemo {

	public static void main(String[] args) {
		 
		double data[] = {19.4, 10.1, 123.54, 33.0, 87.9, 75.25};
		double d;
		
		// We create and initialize the RandomAccessFile (a file in the src/ folder)
		try (RandomAccessFile file = new RandomAccessFile("random.dat", "rw")) {
			// Write values in file
			for (int i=0; i < data.length; i++) {
				file.writeDouble(data[i]);
			}
			
			// Read specific values
			file.seek(0); // Looks for the first double
			d = file.readDouble();
			System.out.println("First value is " + d);
			
			file.seek(8); // Looks for the second double
			d = file.readDouble();
			System.out.println("Second value is " + d);
			
			file.seek(8 * 3); // Looks for the fourth double 
			d = file.readDouble();
			System.out.println("Fourth value is " + d);
			
			System.out.println();
			
			// Now we have to read alternative values
			System.out.println("Here is every other value: ");
			for (int i=0; i < data.length; i += 2) {
				file.seek(8*i);
				d = file.readDouble();
				System.out.println(d + " ");
				
			}
		} catch (IOException exc) {
			System.out.println("I/O Error: " + exc);
		}
		
	}
	
}
