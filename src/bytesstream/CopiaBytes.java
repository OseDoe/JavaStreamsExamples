package bytesstream;

import java.io.*;

public class CopiaBytes {
	// We need to take into consideration the IOExcception when working with streams
	public static void main(String[] args) throws IOException {
		// When we are working with Bytes Streams, we need two objects:
		// FileInputStream and FileOutputStream
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
		
			in = new FileInputStream("/Users/josedg/desktop/archivo.txt");
			out = new FileOutputStream("/Users/josedg/desktop/copia.txt");
			
			int c; // Saves every var in a Int type var
			
			while ((c=in.read())!=-1) {
				out.write(c); // Writes the byte, one at a time
			}
			
		} finally {
			// Once the input and output are done, check that they are not empty
			// And close the stream to avoid memory leaking
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}

}
