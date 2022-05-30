package ar.edu.unju.fi.tpe1.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	@Size(min = 3, max = 100, message = "Su nombre debe tener entre 4 a 100 caracteres")
	@NotEmpty(message = "Su nombre no puede estar vacio")
	private String nombre;
	@NotEmpty(message = "La direccion de correo electronico no puede estar vacia")
	@Email
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent(message = "Ingrese una fecha valida")
	private LocalDate fechaNacimiento;
	
	/*
	 * Constructor no parametrizado
	 */
	public Usuario() {
		
	}
	
	/*
	 * Constructor parametrizado
	 */
	public Usuario(String nombre, String email, LocalDate fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	/*
	 * Metodo que calcula la edad del Usuario
	 */
	public int getEdad() {
		LocalDate fhoy = LocalDate.now();
		
		Period edad = Period.between(this.fechaNacimiento, fhoy);
		
		return edad.getYears();
	}
	
	/*
	 * Metodos accesores
	 */
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
}