package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Favorito
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity

public class Favorito implements Serializable {

	   
	@Id
	@Column(name ="id",length=10)
	private String id;
	
	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="vehiculo_id",nullable=false)
	private Vehiculo vehiculo;
	
	
	private static final long serialVersionUID = 1L;

	public Favorito() {
		super();
	}
	
	public Favorito(String id, Usuario usuario, Vehiculo vehiculo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.vehiculo = vehiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
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
		Favorito other = (Favorito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
}
