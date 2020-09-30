package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vehiculo
 *
 */
@Entity

public class Vehiculo implements Serializable {

	   
	@Id
	@Column(name="id",length=10)
	private String id;
	
	@Column(name="precio",nullable=false)
	private double precio;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="kilometraje",nullable=false)
	private double kilometraje;
	
	@Column(name="anio",nullable=false)
	private int anio;
	
	@Enumerated(EnumType.STRING) 
	@JoinColumn(name="color",nullable=false)
	private Color color;
	
	@Enumerated(EnumType.STRING) 
	@JoinColumn(name="tipo_combustible",nullable=false)
	private TipoCombustible tipoCombustible;
	
	@Enumerated(EnumType.STRING) 
	@JoinColumn(name="tipo_vehiculo",nullable=false)
	private TipoVehiculo tipoVehiculo;
	
	@Enumerated(EnumType.STRING) 
	@JoinColumn(name="transmision",nullable=false)
	private Transmision transmision;
	
	@ElementCollection
	@Column(name="fotos_vehiculo")
	private List<String> fotos;
	
	@ManyToOne
	@JoinColumn(name="modelo_id",nullable=false)
	private Modelo modelo;
	
	@ManyToOne
	@JoinColumn(name="ciudad_id",nullable=false)
	private Ciudad ciudad;

	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Favorito> favoritos;
	
	@OneToMany(mappedBy = "vehiculo")
	private List<Pregunta> preguntas;
	
	@ManyToMany
	private List<Caracteristica> caracteristicas;
	
	
	private static final long serialVersionUID = 1L;

	public Vehiculo() {
		super();
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Transmision getTransmision() {
		return transmision;
	}

	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}

	public List<String> getFotos() {
		return fotos;
	}

	public void setFotos(List<String> fotos) {
		this.fotos = fotos;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public double getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(double kilometraje) {
		this.kilometraje = kilometraje;
	}   
	public int getAnio() {
		return this.anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
}
