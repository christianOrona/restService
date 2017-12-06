package com.christianorona.restService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("toys")
public class ToyServices {

	ToyDAO toyDao = new ToyDAO();
	public ToyServices() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Toy> getAllToys() {
		return toyDao.getAllToys();
	}
	
	@POST
	@Path("addToy")
	public Toy addToy(Toy t) {
		
		System.out.println(t);
		toyDao.addToy(t);
		return t;
		
	}
	
	@GET
	@Path("toy/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Toy getToyById(@PathParam("id") String id) {
		return toyDao.getToyById(id);
	}
	
}
