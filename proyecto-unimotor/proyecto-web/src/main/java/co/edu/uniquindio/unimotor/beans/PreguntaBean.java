package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Pregunta;

@Named
@ViewScoped
public class PreguntaBean implements Serializable {

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	@Inject
	@ManagedProperty(value = "#{seguridadBean.usuario}")
	private Usuario usuario;
	
	private List<Pregunta> preguntas;
	
	@PostConstruct
	public void inicializar() {
		if(usuario!=null) {
			preguntas = unimotorEJB.obtenerListaPreguntasUsuario(usuario.getId());
			mostrar();
		}
	}
	
	public String irARespuestas(Integer id) {
		return "/respuesta?faces-redirect=true&amp;pregunta="+id;

	}
	
	public String mostrar() {
		return "/usuario/misPreguntas?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}
	
	
}
