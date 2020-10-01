package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity

public class Usuario implements Serializable {
		   
	@Id
	@Column(name="id",length=10)
	private String id;
	
	@Column(name="nombre",length=100,nullable=false)
	private String nombre;
	
	@Column(name="correo",nullable=false,unique=true)
	private String correo;
	
	@Column(name="contrasena",length=30,nullable=false)
	private String contrasena;
	
	@Column(name="direccion",length=150)
	private String direccion;
	
	@ElementCollection
	@JoinColumn(name="telefonos_usuario",nullable=false)
	private Map<String,Integer> telefonos;

	@ManyToOne
	@JoinColumn(name="ciudad_id",nullable=false)
	private Ciudad ciudad;
	
	@OneToMany(mappedBy = "usuario")
	private List<Favorito> favoritos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Vehiculo> vehiculos;
	
	@OneToMany(mappedBy = "usuario")
	private List<Pregunta> preguntas;
	
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}
	
	public Usuario(String id, String nombre, String correo, String contrasena, String direccion, Ciudad ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.direccion = direccion;

		this.ciudad = ciudad;
	}

	public Map<String, Integer> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Map<String, Integer> telefonos) {
		this.telefonos = telefonos;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Favorito> getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(List<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public List<Pregunta> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}

	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}   
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}   
	
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}   
	
	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}   
	
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
