package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Respuesta
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TODOS_RESPUESTAS", query = "select r from Respuesta r")
})
public class Respuesta implements Serializable {

	   
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
	@JoinColumn(name="pregunta_id",nullable=false)
	private Pregunta pregunta;
	
	private static final long serialVersionUID = 1L;

	public Respuesta() {
		super();
	}
	
	public Respuesta(Integer id, String descripcion, Date fecha, Pregunta pregunta) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.pregunta = pregunta;
	}

	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Pregunta getPregunta() {
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
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
		Respuesta other = (Respuesta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Respuesta [id=" + id + ", descripcion=" + descripcion + ", fecha=" + fecha + ", pregunta=" + pregunta
				+ "]";
	}
   
}
