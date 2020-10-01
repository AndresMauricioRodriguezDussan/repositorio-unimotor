package co.edu.uniquindio.unimotor.entidades;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Modelo
 * @author Andres Mauricio Rodriguez Dussan
 * @date 1/10/2020
 */
@Entity

public class Modelo implements Serializable {

	   
	@Id
	@Column(name="id",length=100)
	private String id;
	
	@Column(name="nombre",nullable=false,length=150)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="marca_id",nullable=false)
	private Marca marca;
	
	@OneToMany(mappedBy = "modelo")
	private List<Vehiculo> vehiculos;
	
	private static final long serialVersionUID = 1L;

	public Modelo() {
		super();
	}
	
	public Modelo(String id, String nombre, Marca marca) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		Modelo other = (Modelo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
   
	
}
