package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Vehiculo
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_VEHICULOS_TRANSMISION" , query = "select v from Vehiculo v where v.transmision = :transmision"),
	@NamedQuery(name = "TODOS_VEHICULOS_ANIO" , query = "select v from Vehiculo v where v.anio between :inicio and :fin"),
	@NamedQuery(name = "MODELO_VEHICULO_PLACA" , query = "select v.modelo.nombre , v.precio , v.anio from Vehiculo v where v.placa = :placa"),

	@NamedQuery(name = "LISTA_VEHICULOS", query = "select v from Vehiculo v"),
	@NamedQuery(name = "BUSCAR_VEHICULO_PLACA" , query = "select v from Vehiculo v where v.placa = :placa"),
	@NamedQuery(name = "LISTA_VEHICULO_NOMBRE", query = "select v from Vehiculo v where v.nombre like :nombre" ),
	@NamedQuery(name = "LISTA_VEHICULOS_USUARIO", query = "select v from Vehiculo v where v.usuario.id = :id" ),
	@NamedQuery(name = "LISTA_CARACTERISTICAS_VEHICULO" , query="select c from Vehiculo v join v.caracteristicas c where v.id= :id")
	
})
public class Vehiculo implements Serializable {

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Size(max=100, message="el nombre no puede tener mas de 100 caracteres")
	@NotBlank(message = "El nombre no puede estar vacio")
	@Column(name="nombre",nullable=false,length=100)
	private String nombre;
	
	@Size(max=6, message="la placa no puede tener mas de 6 caracteres")
	@NotBlank(message = "La placa no puede estar vacia")
	@Column(name="placa",nullable=false,length=6)
	private String placa;
	
	@NotNull(message = "El precio no puede estar vacio")
	@Positive(message = "El precio no puede ser negativo o 0.0")
	@Column(name="precio",nullable=false)
	private double precio;
	
	@Size(max=255, message="la placa no puede tener mas de 255 caracteres")
	@Column(name="descripcion",length=255)
	private String descripcion;
	
	@NotNull(message = "El kilometraje no puede estar vacio")
	@Column(name="kilometraje",nullable=false)
	private int kilometraje;
	
	@Positive(message = "El año no puede ser negativo o 0")
	@Column(name="anio",nullable=false)
	private int anio;
	
	@Size(max=20, message="El color no puede tener mas de 20 caracteres")
	@NotBlank(message = "El color no puede estar vacio")
	@Column(name="color",nullable=false ,length=20)
	private String color;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_publicacion",nullable=false)
	private Date fechaPublicacion;
	
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

	

	public Vehiculo(Integer id, String nombre, String placa, double precio, String descripcion, int kilometraje,
			int anio, String color, TipoCombustible tipoCombustible, TipoVehiculo tipoVehiculo, Transmision transmision,
			Modelo modelo, Ciudad ciudad, Usuario usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.placa = placa;
		this.precio = precio;
		this.descripcion = descripcion;
		this.kilometraje = kilometraje;
		this.anio = anio;
		this.color = color;
		this.tipoCombustible = tipoCombustible;
		this.tipoVehiculo = tipoVehiculo;
		this.transmision = transmision;
		this.modelo = modelo;
		this.ciudad = ciudad;
		this.usuario = usuario;
	}
	
	public String getFotoPrincipal() {
		if(!fotos.isEmpty()) {
			return fotos.get(0);
		}
		return "default.png";
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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
	public int getKilometraje() {
		return this.kilometraje;
	}

	public void setKilometraje(int kilometraje) {
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

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", nombre=" + nombre + ", placa=" + placa + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", kilometraje=" + kilometraje + ", anio=" + anio + ", color="
				+ color + ", tipoCombustible=" + tipoCombustible + ", tipoVehiculo=" + tipoVehiculo + ", transmision="
				+ transmision + ", modelo=" + modelo + ", ciudad=" + ciudad + ", usuario=" + usuario + "]";
	}

	



	
	
	
   
}
