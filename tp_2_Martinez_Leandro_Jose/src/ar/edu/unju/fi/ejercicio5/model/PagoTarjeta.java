package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoTarjeta implements IPago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoTarjeta () {}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public String toString() {
		return "-------Pago con tarjeta------"+"\n"+"Numero de tarjeta: " + numeroTarjeta +"\n"
				+ "Fecha de Pago: " + fechaPago +"\n"+"Monto Pagado: " + montoPagado;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public Double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}

	@Override
	public double realizarPago(double monto) {
		double porcentaje = 0.15;
		double recarga = monto * porcentaje;
		this.montoPagado = monto + recarga;
		return 0;
	}

	@Override
	public void imprimirRecibo() {
		 System.out.println("------ Pago con Tarjeta ------");
	     System.out.println("Numero de tarjeta: " + numeroTarjeta);
	     System.out.println("Fecha de pago: " + fechaPago);
	     System.out.println("Monto pagado: $" + montoPagado);
	}
}
