package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

public class PagoEfectivo {
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoEfectivo () {}

	public PagoEfectivo(LocalDate fechaPago, Double montoPagado) {
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
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
