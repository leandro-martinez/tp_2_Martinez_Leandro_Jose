package ar.edu.unju.fi.ejercicio4.model;

import java.util.Calendar;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private Calendar fechaDeNacimiento;
	private String nacionalidad;
	private int estatura;
	private double peso;
	private Posicion posicion;
	
	public Jugador () {}

	public Jugador(String nombre, String apellido, Calendar fechaDeNacimiento, String nacionalidad, int estatura,
			double peso, Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fechaDeNacimiento=" + fechaDeNacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}
	
	public int calcularEdad () {
		 Calendar fechaActual = Calendar.getInstance();
		 int edad = fechaActual.get(Calendar.YEAR) - this.getFechaDeNacimiento().get(Calendar.YEAR);
		 if (fechaActual.get(Calendar.MONTH) < fechaDeNacimiento.get(Calendar.MONTH) ||
		    (fechaActual.get(Calendar.MONTH) == fechaDeNacimiento.get(Calendar.MONTH) &&
		     fechaActual.get(Calendar.DAY_OF_MONTH) < fechaDeNacimiento.get(Calendar.DAY_OF_MONTH))) {
		        edad--;
		  }
		 return edad;   
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Calendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getEstatura() {
		return estatura;
	}

	public void setEstatura(int estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
}
