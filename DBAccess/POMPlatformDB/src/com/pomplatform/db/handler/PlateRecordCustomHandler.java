package com.pomplatform.db.handler;

import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateRecord;

public class PlateRecordCustomHandler extends PlateRecordHandler {

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateRecord bean = new BasePlateRecord();
		bean.setDataFromJSON(json);
		PlateRecord dao = new PlateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) {
			dao.setDataFromBase(bean); 
			ret = dao.save(); 
			int plateId = dao.getPlateRecordId();
			dao.setPlateId(plateId);
			dao.update();
			bean = dao.generateBase(); 
		}
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


