package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.IPago;

public class PagoEfectivo implements IPago {
	private LocalDate fechaPago;
	private Double montoPagado;
	
	public PagoEfectivo () {}

	public PagoEfectivo(LocalDate fechaPago, Double montoPagado) {
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}
	
	@Override
	public String toString() {
		return "------ Pago Efectivo ------"+"\n"+"Fecha de pago: " + fechaPago +"\n"+"Monto pagado: " + montoPagado;
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
		double porcentaje = 0.10;
		double descuento = monto * porcentaje;
		this.montoPagado += monto - descuento;
		return 0;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("------ Pago Efectivo ------");
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
	}
}
