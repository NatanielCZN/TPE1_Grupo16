package ar.edu.unju.fi.tpe1.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpe1.model.Usuario;

@Component
public class ListaUsuario {
	private List<Usuario> listaUsuarios;

	/*
	 * Constructor no parametrizado
	 */
	public ListaUsuario() {
		this.listaUsuarios = new ArrayList<>();
		
		this.listaUsuarios.add(new Usuario("Nataniel","natanielarg@gmail.com",LocalDate.of(1995,06,16)));
		this.listaUsuarios.add(new Usuario("Ariel","arielarg@gmail.com",LocalDate.of(1993,12,27)));
		this.listaUsuarios.add(new Usuario("Josemi","josemiarg@gmail.com",LocalDate.of(2000,04,14)));
	}
	
	/*
	 * Metodos accesores
	 */
	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
}