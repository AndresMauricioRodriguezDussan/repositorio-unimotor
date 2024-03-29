package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pregunta
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_PREGUNTAS", query = "select P from Pregunta p"),
	@NamedQuery(name = "LISTA_PREGUNTAS_VEHICULO", query = "select p from Pregunta p where p.vehiculo.id = :id"),
	@NamedQuery(name = "LISTA_PREGUNTAS_USUARIO", query = "select p from Pregunta p where p.usuario.id = :id"),
	@NamedQuery(name = "LISTA_RESPUESTAS_PREGUNTA" , query="select r from Pregunta p join p.respuestas r where p.id= :id")
})
public class Pregunta implements Serializable {

	   
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="descripcion",nullable=false)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha",nullable=false)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="vehiculo_id",nullable=false)
	private Vehiculo vehiculo;
	
	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pregunta")
	private List<Respuesta> respuestas;
	
	private static final long serialVersionUID = 1L;

	public Pregunta() {
		super();
	}
	
	public Pregunta (String descripcion, Date fecha, Vehiculo vehiculo, Usuario usuario) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.vehiculo = vehiculo;
		this.usuario = usuario;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Date getFecha() {
		return this.fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
		Pregunta other = (Pregunta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pregunta [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", vehiculo=" + vehiculo
				+ ", usuario=" + usuario + "]";
	}
   
	
}
