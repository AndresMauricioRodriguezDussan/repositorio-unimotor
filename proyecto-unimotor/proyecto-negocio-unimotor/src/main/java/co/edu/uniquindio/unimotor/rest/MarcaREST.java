package co.edu.uniquindio.unimotor.rest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.edu.uniquindio.unimotor.ejb.UnimotorEJB;
import co.edu.uniquindio.unimotor.entidades.Marca;

@Path("/marcas")
public class MarcaREST {

	@EJB
	private UnimotorEJB unimotorEJB;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response obtenerMarcas(){
		return Response.status(500).entity(unimotorEJB.obtenerListaMarca()).build();
	}
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response obtenerMarca( @PathParam("id") Integer id) {
		try {
			Marca marca = unimotorEJB.obtenerMarca(id);
			return Response.status(200).entity(marca).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response registrarMarca(Marca marca) {
		try {
			unimotorEJB.guardarMarca(marca);
			return Response.status(200).entity("{ \"mensaje\" : \"la marca se registro correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
			
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response actualizarMarca(Marca marca) {
		try {
			unimotorEJB.actualizarMarca(marca);
			return Response.status(200).entity("{ \"mensaje\" : \"la marca se actualizo correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response eliminarMarca(@PathParam("id") Integer id) {
		try {
			unimotorEJB.eliminarMarca(id);
			return Response.status(200).entity("{ \"mensaje\" : \"la marca se elimino correctamente\"  }").type(MediaType.APPLICATION_JSON).build();
		} catch (Exception e) {
			return Response.status(500).entity("{ \"mensaje\" : \""+e.getMessage()+"\"  }").build();
		}
	}
}
