package ar.edu.unju.fi.tpe1.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.tpe1.model.Ganador;

@Component
public class ListaGanador {
	private List<Ganador> listaGanadores;
	
	/*
	 * Constructor no parametrizado
	 */
	public ListaGanador() {
		listaGanadores = new ArrayList<>();
		
		listaGanadores.add(new Ganador("Dragon Age: Inquisition","BioWare",2014));
		listaGanadores.add(new Ganador("The Witcher 3: Wild Hunt","CD PROJEKT RED",2015));
		listaGanadores.add(new Ganador("Overwatch","Blizzard",2016));
		listaGanadores.add(new Ganador("The legend of Zelda: BW","Nintendo",2017));
		listaGanadores.add(new Ganador("God of War","Santa Monica Studio",2018));
		listaGanadores.add(new Ganador("Sekiro: Shadows Die Twice","FromSoftware",2019));
		listaGanadores.add(new Ganador("The Last of Us Parte II","Naughty Dog",2020));
		listaGanadores.add(new Ganador("It Takes Two","Hazelight Studios",2021));
	}
	
	/*
	 * Metodos accesores
	 */
	public List<Ganador> getListaGanadores() {
		return listaGanadores;
	}

	public void setListaGanadores(List<Ganador> listaGanadores) {
		this.listaGanadores = listaGanadores;
	}
}