package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Respuesta
 *
 */
@Entity

public class Respuesta implements Serializable {

	   
	@Id
	@Column(name="id",length=100)
	private String id;
	
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
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
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
   
}
