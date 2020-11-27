package co.edu.uniquindio.unimotor.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class InicioBean implements Serializable {

	@EJB
	private UnimotorEJB unimotorEJB;
	private static final long serialVersionUID = 1L;
	private List<Vehiculo> vehiculos;
	
	@PostConstruct
	public void inicializar() {
		vehiculos=unimotorEJB.obtenerListaVehiculo();
	}
	
	public String irADetalle(Integer id) {
		return "/detalleVehiculo?faces-redirect=true&amp;vehiculo="+id;
	}
	
	public String irAEditar(Integer id) {
		return "/editarVehiculo?faces-redirect=true&amp;vehiculo="+id;
	}
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}
}
