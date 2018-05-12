package flujosdatos;

import java.io.*;

public class FlujosDeDatos {

	static final String archivo = "Factura.txt";
	static final double[] precios = { 16.00, 160.00, 25.00, 14.00, 2.50};
	static final int[] cantidad = {4, 2, 1, 4, 50};
	static final String[] items = {"Marcador azul", "Papel A4", "Borrador", "CDROMs", "Sobres"};
	
	public static void main(String[] args) throws IOException {
		
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(archivo) ) );
			for (int i =0; i < precios.length; i++) {
				out.writeDouble(precios[i]);
				out.writeInt(cantidad[i]);
				out.writeUTF(items[i]);
			}
		} finally {
			out.close();
		}
		
		DataInputStream in = null;
		double total = 0.0;
		try {
			in = new DataInputStream(new BufferedInputStream(new FileInputStream(archivo)));
			double precio;
			int cant;
			String item;
			try {
				while (true) {
					precio = in.readDouble();
					cant = in.readInt();
					item = in.readUTF();
					System.out.format(" %4d %25s a $%7.2f c/u $%8.2f%n", cant, item, precio, cant * precio);
					total += cant * precio;
				}
			} catch (EOFException e) { }
			System.out.format("\t\t\t\t\t TOTAL $%8.2f%n", total);
		} finally {
			in.close();
		}

	}

}
