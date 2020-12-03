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

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class FavoritoBean implements Serializable{

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	
	private List<Vehiculo> vehiculos;
	
	@Inject
	@ManagedProperty(value = "#{seguridadBean.usuario}")
	private Usuario usuario;
	
	@PostConstruct
	public void inicializar() {
		if(usuario!=null) {
			vehiculos = unimotorEJB.obtenerListaFavorito(usuario.getId());
			mostrar();
		}
	}
	
	public String mostrar() {
		return "/usuario/misFavorito?faces-redirect=true";
	}
	
	public String eliminarFavorito(Integer id) {
		try {
			unimotorEJB.eliminarVehiculo(id);
			vehiculos = unimotorEJB.obtenerListaVehiculoUsuario(usuario.getId());
			return "/usuario/misPublicaciones?faces-redirect=true";
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
			FacesContext.getCurrentInstance().addMessage("msj_publicacion", msj);
		}
		return "";
	}
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
