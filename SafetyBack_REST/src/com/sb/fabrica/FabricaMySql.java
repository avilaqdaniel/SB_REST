package com.sb.fabrica;

import com.sb.dao.MySqlSafetyBackDAO;
import com.sb.dao.SafetyBackDAO;

public class FabricaMySql extends Fabrica{

	@Override
	public SafetyBackDAO getSafetyBackDAO() {
		return new MySqlSafetyBackDAO();
	}

}
