package co.edu.uniquindio.unimotor.beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.annotation.ManagedProperty;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;


import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Caracteristica;
import co.edu.uniquindio.unimotor.entidades.Ciudad;
import co.edu.uniquindio.unimotor.entidades.Modelo;
import co.edu.uniquindio.unimotor.entidades.TipoCombustible;
import co.edu.uniquindio.unimotor.entidades.TipoVehiculo;
import co.edu.uniquindio.unimotor.entidades.Transmision;
import co.edu.uniquindio.unimotor.entidades.Usuario;
import co.edu.uniquindio.unimotor.entidades.Vehiculo;

@Named
@ViewScoped
public class VehiculoBean implements Serializable {

	@EJB
	private UnimotorEJB unimotorEJB;
	private Vehiculo vehiculo;
	
	@Inject
	@ManagedProperty(value = "#{seguridadBean.usuario}")
	private Usuario usuario;
	private List<Ciudad> ciudades;
	private List<Modelo> modelos;
	private List<Caracteristica> caracteristicas;
	private ArrayList<String> fotos;
	private static final String RUTA_FOTOS="C:\\payara5\\glassfish\\domains\\domain1\\docroot\\unimotor";

	private List<TipoVehiculo> tiposVehiculo;
	private List<TipoCombustible> tiposCombustible;
	private List<Transmision> tiposTransmision;

	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void inicializar() {
		vehiculo = new Vehiculo();
		fotos = new ArrayList<String>();
		ciudades = unimotorEJB.obtenerListaCiudad();
		modelos = unimotorEJB.obtenerListaModelo();
		caracteristicas = unimotorEJB.obtenerListaCaracteristica();

		tiposVehiculo = unimotorEJB.obtenerListaTipoVehiculo();
		tiposCombustible = unimotorEJB.obtenerListaTipoCombustible();
		tiposTransmision = unimotorEJB.obtenerListaTransmision();

	}

	public void registrarVehiculo() {
		try {

			if(!fotos.isEmpty()) {
				vehiculo.setUsuario(usuario);
				vehiculo.setFechaPublicacion(new Date());
				vehiculo.setFotos(fotos);

				unimotorEJB.registrarVehiculo(vehiculo);

				FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_INFO,"Alerta","¡Registro exitoso!");
				FacesContext.getCurrentInstance().addMessage("registro_vehiculos", msj);
			}else {
				FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta","Es necesario subir fotos del vehiculo");
				FacesContext.getCurrentInstance().addMessage("registro_vehiculos", msj);
			}
		} catch (Exception e) {
			FacesMessage msj = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Alerta",e.getMessage());
			FacesContext.getCurrentInstance().addMessage("registro_vehiculos", msj);
		}
	}

	public void subirFotos(FileUploadEvent event) {
		UploadedFile imagen= event.getFile();
		String nombreImagen = subirImagen(imagen);

		if(nombreImagen !=null) {
			fotos.add(nombreImagen);
		}
	}

	public String subirImagen(UploadedFile file) {
		try {
			InputStream input = file.getInputStream();
			String filename = FilenameUtils.getName(file.getFileName());
			String basename = FilenameUtils.getBaseName(filename) + "_";
			String extension = "." + FilenameUtils.getExtension(filename);

			File fileDest = File.createTempFile(basename, extension, new File(RUTA_FOTOS));
			FileOutputStream output = new FileOutputStream(fileDest);

			IOUtils.copy(input, output);

			return fileDest.getName();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public List<TipoVehiculo> getTiposVehiculo() {
		return tiposVehiculo;
	}

	public void setTiposVehiculo(List<TipoVehiculo> tiposVehiculo) {
		this.tiposVehiculo = tiposVehiculo;
	}

	public List<TipoCombustible> getTiposCombustible() {
		return tiposCombustible;
	}

	public void setTiposCombustible(List<TipoCombustible> tiposCombustible) {
		this.tiposCombustible = tiposCombustible;
	}


	public List<Transmision> getTiposTransmision() {
		return tiposTransmision;
	}

	public void setTiposTransmision(List<Transmision> tiposTransmision) {
		this.tiposTransmision = tiposTransmision;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

	public String irARegristroVehiculo() {
		return "/usuario/registrarVehiculo?faces-redirect=true";
	}
	
	public String irAEditarVehiculo() {
		return "/usuario/editarVehiculo?faces-redirect=true";
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(ArrayList<String> fotos) {
		this.fotos = fotos;
	}

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
