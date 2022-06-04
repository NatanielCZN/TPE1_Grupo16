package ar.edu.unju.fi.tpe1.model;

import org.springframework.stereotype.Component;

@Component
public class Ganador {
	private static int posicion = 0;
	
	private int num;
	private String nombre;
	private String empresa;
	private int anio;
	
	/*
	 * Constructor no parametrizado
	 */
	public Ganador() {
		
	}

	/*
	 * Constructor parametrizado
	 */
	public Ganador(String nombre, String empresa, int anio) {
		super();
		this.nombre = nombre;
		this.empresa = empresa;
		this.anio = anio;
		incrementarPosicion();
		this.num = posicion;
	}
	
	/*
	 * Metodo que autoincrementara la posicion
	 */
	public void incrementarPosicion() {
		posicion++;
	}
	
	/*
	 * Metodos accesores
	 */
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public String toString() {
		return "Ganador [nombre=" + nombre + ", empresa=" + empresa + ", anio=" + anio + "]";
	}
}