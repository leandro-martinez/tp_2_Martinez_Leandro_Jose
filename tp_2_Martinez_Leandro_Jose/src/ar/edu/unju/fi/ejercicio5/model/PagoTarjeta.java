package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

public class PagoTarjeta {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoTarjeta () {}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, Double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
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
}
