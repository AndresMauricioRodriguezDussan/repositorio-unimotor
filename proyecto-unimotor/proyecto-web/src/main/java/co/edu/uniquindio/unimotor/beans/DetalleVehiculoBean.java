package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotBlank;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Pregunta;
import co.edu.uniquindio.unimotor.entidades.Respuesta;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class DetalleVehiculoBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private Vehiculo vehiculo;
	@NotBlank
	private String pregunta;
	private Boolean favorito;
	
	@Inject
	@ManagedProperty(value="#{param.vehiculo}")
	private String proyectoParam;
	
	private List<Pregunta> preguntas;
	private List<Caracteristica> caracteristicas;
	private List<Respuesta> respuestas;
	
	private Usuario usuario;
	
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void inicializar() {
		if(proyectoParam!=null&&!proyectoParam.isEmpty()) {
			try {
				int codigoV = Integer.parseInt(proyectoParam);
				
				vehiculo = unimotorEJB.obtenerVehiculo(codigoV);
				preguntas = unimotorEJB.obtenerListaPreguntasVehiculo(codigoV);
				caracteristicas = unimotorEJB.obtenerListaCaracteristicaVehiculo(codigoV); 
				//respuestas = unimotorEJB.obtenerListaRespuestasPregunta();
				
			} catch (Exception e) {
				FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
				FacesContext.getCurrentInstance().addMessage("pregunta-vehiculo", msj);
			}
		}
	}
	
	public void hacerPregunta() {
		Pregunta p;
		try {
			p = unimotorEJB.hacerPregunta(usuario,vehiculo,pregunta);
			if(p!=null) {
				preguntas.add(p);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public Boolean getFavorito() {
		return favorito;
	}

	public void setFavorito(Boolean favorito) {
		this.favorito = favorito;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
