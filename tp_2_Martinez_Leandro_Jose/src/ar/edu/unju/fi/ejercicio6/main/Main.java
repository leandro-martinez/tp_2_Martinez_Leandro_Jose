package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {
	public static void main(String[] args) {
		FelinoSalvaje felino = new FelinoSalvaje("Tanner", (byte)20, 186f);
		//caso de felino = null
		//felino = null;
		//definición de expresión lambda que define el convertidor de FelinoSalvaje a
		//FelinoDomestico.
		Converter<FelinoSalvaje, FelinoDomestico> converter = 
				x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
		
		// Verificamos que el objeto felino no sea nulo antes de realizar la conversión
		if (Converter.isNotNull(felino)) {
			// Realizamos la conversión
		    FelinoDomestico domestico = converter.convert(felino);
		    // Mostramos los datos del objeto felino doméstico
		    converter.mostrarObjeto(domestico);
		} else {
			System.out.println("El objeto felino es nulo.");
		}
	}

}
