package flujoscaracteres;

import java.io.*;

public class CopiaLineas {

	public static void main(String[] args) throws IOException {
		// Once again, we create and initialize two objects
		// BufferedReader and PrintWriter for String Streams
		BufferedReader in = null;
		PrintWriter out = null;

		try {
			in = new BufferedReader( new FileReader("/Users/josedg/desktop/archivo.txt"));
			out = new PrintWriter( new FileWriter("/Users/josedg/desktop/copia.txt"));
			
			String linea;
			
			while ((linea = in.readLine()) != null) {
				out.println(linea);
			}
			
		} finally {
			if (in != null) {
				in.close();
			}
			if (out != null) {
				out.close();
			}
		}
		
	}

}
