package standardstream;

import java.io.*;

public class EntradaEstandar {

	public static void main(String[] args) throws IOException {
		// Los flujos estandar son el telcado(entrada) y pantalla(salida)
		// Se usaran InputStreamReader encapsulando el System.in
		BufferedReader estandarIn = null;
		estandarIn = new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("Ingrese caracteres y pulse Enter:");
		String linea = estandarIn.readLine();
		System.out.println(linea);
		estandarIn.close();
	}

}
