package com.sb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sb.bean.District;
import com.sb.bean.Driver;
import com.sb.bean.Filtro;
import com.sb.bean.Parent;
import com.sb.bean.Passenger;
import com.sb.bean.School;
import com.sb.bean.Vehicle;
import com.sb.bean.VehicleBrand;
import com.sb.util.ConectaDB;

public class MySqlSafetyBackDAO implements SafetyBackDAO{
	
	private static final Log log = LogFactory.getLog(MySqlSafetyBackDAO.class);

	@Override
	public int insertParent(Parent bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_parent values(?,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(0, bean.getDni());
			pstm.setString(1, bean.getEmail());
			pstm.setString(2, bean.getPassword());
			pstm.setString(3, bean.getName());
			pstm.setString(4, bean.getPhone());
			pstm.setInt(5, bean.getDistrito().getIdDistrito());
			//pstm.setInt(6, bean.getDistrito());
			pstm.setString(6, bean.getAddress());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public List<District> listaDistrito() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<District> lista = new ArrayList<District>();
		try {
			String sql = "select * from tb_district";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			
			rs = pstm.executeQuery();
			District bean = null;
			while(rs.next()){
				bean = new District();
				bean.setIdDistrito(rs.getInt(1));
				bean.setDistrito(rs.getString(2));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	@Override
	public int insertPassenger(Passenger bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_passenger values(?,?,?,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(0, bean.getPassDni());
			pstm.setString(1, bean.getParent().getDni());
			pstm.setString(2, bean.getVehicle().getVehiclePlate());
			pstm.setInt(3, bean.getSchool().getSchoolId());
			pstm.setString(4, bean.getPassName());
			pstm.setString(5, bean.getPassAddress());
			pstm.setInt(6, bean.getDistrict().getIdDistrito());
			pstm.setInt(7, bean.getPassAge());
			pstm.setString(8, bean.getPassGrade());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public int insertVehicleBrand(VehicleBrand bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_vehicle_brand values(null,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getBrandName());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public List<VehicleBrand> listaMarca() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<VehicleBrand> lista = new ArrayList<VehicleBrand>();
		try {
			String sql = "select * from tb_vehicle_brand";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			
			rs = pstm.executeQuery();
			VehicleBrand bean = null;
			while(rs.next()){
				bean = new VehicleBrand();
				bean.setBrandId(rs.getInt(1));
				bean.setBrandName(rs.getString(2));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	@Override
	public int insertVehicle(Vehicle bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_vehicle values(?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(0, bean.getVehiclePlate());
			pstm.setString(1, bean.getDriver().getDriverDni());
			pstm.setInt(2, bean.getBrand().getBrandId());
			pstm.setInt(3, bean.getSits());
			pstm.setString(4, bean.getSoat());
			pstm.setString(5, bean.getYear());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public int insertDriver(Driver bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_driver values(?,?,?,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(0, bean.getDriverDni());
			pstm.setString(1, bean.getDriverEmail());
			pstm.setString(2, bean.getDriverPass());
			pstm.setString(3, bean.getDriverName());
			pstm.setString(4, bean.getDriverSex());
			pstm.setString(5, bean.getDriverLicence());
			pstm.setString(6, bean.getDrivePhone());
			pstm.setString(7, bean.getDriverAddress());
			pstm.setInt(8, bean.getDistrito().getIdDistrito());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public int insertSchool(School bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tb_school values(null,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getSchoolName());
			pstm.setString(2, bean.getSchoolAddress());
			pstm.setInt(3, bean.getDistrito().getIdDistrito());
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}

	@Override
	public List<School> listaSchool() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<School> lista = new ArrayList<School>();
		try {
			String sql = "select * from tb_school";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			
			rs = pstm.executeQuery();
			School bean = null;
			//District ds = null;
			while(rs.next()){
				bean = new School();
				bean.setSchoolId(rs.getInt(1));
				bean.setSchoolName(rs.getString(2));
				bean.setSchoolAddress(rs.getString(3));
				//bean.setDistrito(rs.getInt(ds.getDistrito()));
				lista.add(bean);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	@Override
	public List<Passenger> listaPassenger() {
		// TODO Auto-generated method stub
				return null;
	}

	@Override
	public List<Passenger> listaPassengerPorVehiculo(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Passenger> listaPassengerSchool(Filtro filtro) {
		// TODO Auto-generated method stub
		return null;
	}

}
