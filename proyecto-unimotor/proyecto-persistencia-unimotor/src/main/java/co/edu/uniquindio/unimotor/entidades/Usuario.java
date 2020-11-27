package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;
import java.util.Map;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Usuario
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_USUARIOS", query = "select u from Usuario u"),
	@NamedQuery(name= "LISTA_FAVORITOS_USUARIO" , query = "select f.vehiculo from Usuario u , IN (u.favoritos) f where u.correo = :correo"),
	@NamedQuery(name = "LISTA_FAVORITOS_USUARIO_2" , query = "select f.vehiculo.nombre , u.nombre from Usuario u , IN (u.favoritos) f where u.correo = :correo"),
	
	@NamedQuery(name = "CANTIDAD_USUARIOS", query = "select count(u) from Usuario u"),
	@NamedQuery(name = "BUSCAR_CORREO" , query = "select u from Usuario u where u.correo = :correo"),
	@NamedQuery(name = "AUTENTICAR_USUARIO", query = "select u from Usuario u where u.correo = :correo and u.contrasena = :contrasena")
	
	
})
public class Usuario implements Serializable {
		   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Size(max=100, message="el nombre no puede tener mas de 100 caracteres")
	@NotBlank(message = "El nombre no puede estar vacio")
	@Column(name="nombre",length=100,nullable=false)
	private String nombre;
	
	@Email
	@Size(min=5, max=150, message="el email debe tener entre 5 y 150 caracteres")
	@NotBlank(message = "El correo no puede estar vacio")
	@Column(name="correo",length=150,nullable=false,unique=true)
	private String correo;
	
	@Size(max=30)
	@NotBlank(message = "La contraseña no puede estar vacia")
	@Column(name="contrasena",length=30,nullable=false)
	private String contrasena;
	
	@Size(max=250)
	@Column(name="direccion",length=250)
	private String direccion;
	
	@ElementCollection
	@JoinColumn(name="telefonos_usuario",nullable=false)
	private Map<String,String> telefonos;

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
	
	public Usuario(String nombre, String correo, String contrasena, String direccion, Map<String, String> telefonos,
			Ciudad ciudad) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.direccion = direccion;
		this.telefonos = telefonos;
		this.ciudad = ciudad;
	}

	public Map<String, String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Map<String, String> telefonos) {
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
	
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena
				+ ", direccion=" + direccion + ", ciudad=" + ciudad + "]";
	}
	
	
}
