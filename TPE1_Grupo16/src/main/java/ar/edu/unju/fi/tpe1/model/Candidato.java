package ar.edu.unju.fi.tpe1.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Candidato {
	@Size(min = 4, max = 100, message = "El codigo debe tener entre 4 a 100 caracteres")
	@NotEmpty(message = "El codigo no puede estar vacio")
	private String codigo;
	@Size(min = 3, max = 100, message = "El nombre del videojuego debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El nombre del videojuego no puede estar vacio")
	private String nombre;
	@Size(min = 3, max = 100, message = "El nombre de la empresa debe tener entre 3 a 100 caracteres")
	@NotEmpty(message = "El nombre de la empresa no puede estar vacio")
	private String empresa;
	@Size(min = 3, max = 1000, message = "La descripcion debe tener entre 10 a 1000 caracteres")
	@NotEmpty(message = "La descripcion no puede estar vacia")
	private String descripcion;	
	private int cantidadVotos;
	
	/*
	 * Constructor no parametrizado
	 */
	public Candidato() {
		
	}
	
	/*
	 * Constructor parametrizado
	 */
	public Candidato(String codigo, String nombre, String empresa, String descripcion, int cantidadVotos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.cantidadVotos = cantidadVotos;
	}

	/*
	 * Metodos accesores
	 */
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidadVotos() {
		return cantidadVotos;
	}
	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}
}