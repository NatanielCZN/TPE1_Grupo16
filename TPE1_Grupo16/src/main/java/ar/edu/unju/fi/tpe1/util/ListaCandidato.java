package ar.edu.unju.fi.tpe1.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpe1.model.Candidato;

@Component
public class ListaCandidato {
	private List<Candidato> listaCandidatos;
	
	/*
	 * Constructor no parametrizado
	 */
	public ListaCandidato() {
		this.listaCandidatos = new ArrayList<>();
		
		this.listaCandidatos.add(new Candidato("1111","Elden Ring", "FromSoftware Inc.","El nuevo juego de rol y accion de ambientacion fantástica","EldenR.png"));
		this.listaCandidatos.add(new Candidato("2222","Horizon", "Guerrilla Games","Es un videojuego de rol de acción, aventura y mundo abierto","Horizon.png"));
		this.listaCandidatos.add(new Candidato("3333","S.T.A.L.K.E.R. 2","GSC Game World","Descubre la Zona de Exclusión de Chornóbil, un lugar repleto de enemigos peligrosos","STK2.png"));
		this.listaCandidatos.add(new Candidato("4444","Ninguno", "-","Ninguna opcion","FondoN.png"));
	}
	
	/*
	 * Metodos accesores
	 */
	public List<Candidato> getListaCandidatos() {
		return this.listaCandidatos;
	}
	
	public void setListaCandidatos(List<Candidato> listaCandidatos) {
		this.listaCandidatos = listaCandidatos;
	}	
}