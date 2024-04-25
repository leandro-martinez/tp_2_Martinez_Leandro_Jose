package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(811611,53219.0), 
	SALTA(1441351,155488.0),
	TUCUMAN(1731820,22525.0), 
	CATAMARCA(429562,102602.0), 
	LA_RIOJA(383865,89680.0), 
	SANTIAGO_DEL_ESTERO(1060906,136351.0);
	
	private int cantidadPoblacion;
	private double superficie;
	
	private Provincia(int cantidadPoblacion, double superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public double getSuperficie() {
		return superficie;
	}
	
	public double calcularDensidadPoblacional () {
		return cantidadPoblacion / superficie;
	}
}
