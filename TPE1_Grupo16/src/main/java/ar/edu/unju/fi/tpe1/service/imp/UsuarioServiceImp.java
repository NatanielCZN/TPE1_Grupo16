package ar.edu.unju.fi.tpe1.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpe1.model.Usuario;
import ar.edu.unju.fi.tpe1.service.IUsuarioService;
import ar.edu.unju.fi.tpe1.util.ListaUsuario;

@Service("UsuarioServiceImp")
public class UsuarioServiceImp implements IUsuarioService {

	@Autowired
	private ListaUsuario listaUsuario;
	
	@Override
	public Usuario getUsuario() {
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		return this.listaUsuario.getListaUsuarios().add(usuario);
	}

	@Override
	public ListaUsuario getListaUsuario() {
		return this.listaUsuario;
	}

	@Override
	public Usuario getUltimoUsuario() {
		int tam = this.listaUsuario.getListaUsuarios().size();		
		Usuario usr = this.listaUsuario.getListaUsuarios().get(tam-1);		
		return usr;
	}
	
	@Override
	public void descontarVoto() {
		int tam = this.listaUsuario.getListaUsuarios().size();		
		Usuario usr = this.listaUsuario.getListaUsuarios().get(tam-1);		
		usr.setVotosDisponibles(usr.getVotosDisponibles() - 1);
	}
}