package com.sb.dao;

import java.util.List;

import com.sb.bean.District;
import com.sb.bean.Driver;
import com.sb.bean.Filtro;
import com.sb.bean.Parent;
import com.sb.bean.Passenger;
import com.sb.bean.School;
import com.sb.bean.Vehicle;
import com.sb.bean.VehicleBrand;

public interface SafetyBackDAO {
	
	public abstract int insertParent(Parent bean);	
	public abstract int insertPassenger(Passenger bean);	
	public abstract int insertVehicleBrand(VehicleBrand bean);	
	public abstract int insertVehicle(Vehicle bean);
	public abstract int insertDriver(Driver bean);
	public abstract int insertSchool(School bean);
	
	public abstract List<VehicleBrand> listaMarca();
	public abstract List<District> listaDistrito();
	public abstract List<School> listaSchool();
	public abstract List<Passenger> listaPassenger();
	
	public abstract List<Passenger> listaPassengerPorVehiculo(Filtro filtro);
	public abstract List<Passenger> listaPassengerSchool(Filtro filtro);
	
}
