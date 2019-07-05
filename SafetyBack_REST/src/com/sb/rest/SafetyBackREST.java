package com.sb.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sb.bean.Driver;
import com.sb.bean.Parent;
import com.sb.bean.Passenger;
import com.sb.bean.School;
import com.sb.bean.Vehicle;
import com.sb.bean.VehicleBrand;
import com.sb.dao.SafetyBackDAO;
import com.sb.fabrica.Fabrica;

@Path("{sb}")
public class SafetyBackREST {
	
	private static final Log log = LogFactory.getLog(SafetyBackREST.class);
	
	Fabrica fabrica = Fabrica.getFabrica(Fabrica.MYSQL);
	SafetyBackDAO dao = fabrica.getSafetyBackDAO();
	
	@GET
	@Path("/{districts}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response carga() {
		log.info("carga rest ");
		return Response.ok(dao.listaDistrito()).build();
	}
	
	@GET
	@Path("/{brands}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response cargaBrands() {
		log.info("carga rest ");
		return Response.ok(dao.listaMarca()).build();
	}
	
	@GET
	@Path("/{schools}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response cargaSchools() {
		log.info("carga rest ");
		return Response.ok(dao.listaSchool()).build();
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerSchool(School obj) {
		log.info("registrar rest --> ");
		return dao.insertSchool(obj);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerVehicle(Vehicle obj) {
		log.info("registrar rest --> ");
		return dao.insertVehicle(obj);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerVehicleBrand(VehicleBrand obj) {
		log.info("registrar rest --> ");
		return dao.insertVehicleBrand(obj);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerDriver(Driver obj) {
		log.info("registrar rest --> ");
		return dao.insertDriver(obj);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerParent(Parent obj) {
		log.info("registrar rest --> ");
		return dao.insertParent(obj);
	}
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public int registerPassenger(Passenger obj) {
		log.info("registrar rest --> ");
		return dao.insertPassenger(obj);
	}

}
