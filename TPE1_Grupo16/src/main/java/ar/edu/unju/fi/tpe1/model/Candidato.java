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
	
	private String image;	
	private int cantidadVotos;
	private float porcentaje;
	
	/*
	 * Constructor no parametrizado
	 */
	public Candidato() {
		this.image = "FNuevo.png";
		this.cantidadVotos = 0;
		this.porcentaje = 0;
	}
	
	/*
	 * Primer constructor parametrizado
	 */
	public Candidato(String codigo, String nombre, String empresa, String descripcion, String image) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.image = image;
		
		this.cantidadVotos = 0;
		this.porcentaje = 0f;
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
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public int getCantidadVotos() {
		return cantidadVotos;
	}
	public void setCantidadVotos(int cantidadVotos) {
		this.cantidadVotos = cantidadVotos;
	}
	
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	@Override
	public String toString() {
		return "Candidato [codigo=" + codigo + ", nombre=" + nombre + ", empresa=" + empresa + ", descripcion="
				+ ", cantidadVotos=" + cantidadVotos + ", porcentaje=" + porcentaje + "%]";
	}	
}