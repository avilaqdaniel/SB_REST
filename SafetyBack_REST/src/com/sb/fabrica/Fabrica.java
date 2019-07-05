package com.sb.fabrica;

import com.sb.dao.SafetyBackDAO;

public abstract class Fabrica {

	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	
	public abstract SafetyBackDAO getSafetyBackDAO();
	
	public static Fabrica getFabrica(int tipo){
		Fabrica salida = null;
		switch(tipo){
			case MYSQL: 
				salida = new FabricaMySql();
				break;
		}
		return salida;
	}
}
