package home.bo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class PropiedadesBO {

	private Properties prop;
	
	public PropiedadesBO() {
		prop = new Properties();
	}

	public void colocar(String propiedad, String valor) {
		prop.setProperty(propiedad, valor);
	}

	public void borrar(String propiedad) {
		prop.remove(propiedad);
		//prop.clear();
	}

	public String obtener(String propiedad) {
		return prop.getProperty(propiedad);
	}

	public void guardar() {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream("props.dat");
			prop.store(fos, "Propiedades de Ejemplo");
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void cargar() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("props.dat");
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public StringBuilder listarPrpiedades() {
		String propiedad, valor;
		StringBuilder sb = new StringBuilder();
		Enumeration<?> enumera = prop.propertyNames();
		
		while(enumera.hasMoreElements()) {
			propiedad = enumera.nextElement().toString();
			valor = prop.getProperty(propiedad);
					
			sb.append(propiedad).append("\t");
			sb.append(valor).append("\n");
		}
		
		return sb;
	}

}
