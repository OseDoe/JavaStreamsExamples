package characterstream;

import java.io.*;

public class CopiaCaracteres {

	public static void main(String[] args) throws IOException {
		// As usual we initialize and create the Stream objects
		// Since we are working with characters this time, FileReader and FileWriter are needed
		FileReader in = null;
		FileWriter out = null;
		
		try {
			in = new FileReader("/Users/josedg/desktop/archivo.txt");
			out = new FileWriter("/Users/josedg/desktop/copia.txt");
			
			int c;
			
			while ( ( c=in.read() ) != -1 ) {
				out.write(c);
			}
			
		} finally {
			if ( in != null ) {
				in.close();
			}
			if ( out != null ) {
				out.close();
			}
		}

	}

}
