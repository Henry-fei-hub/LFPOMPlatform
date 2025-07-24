package com.pomplatform.db.handler;

import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.ReceiveUnitManage;

import delicacy.connection.ThreadConnection;

public class CustomReceiveUnitManageHandler extends ReceiveUnitManageHandler {

	private int K3CodeType8 = 8;//收款单位
	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseReceiveUnitManage bean = new BaseReceiveUnitManage();
		bean.setDataFromJSON(json);
		ReceiveUnitManage dao = new ReceiveUnitManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if (dao.isPrimaryKeyNull()) {
			ThreadConnection.beginTransaction();
			dao.setDataFromBase(bean);
			ret = dao.save();
			K3Code k3CodeDao = new K3Code();
			k3CodeDao.setType(K3CodeType8);// 收款单位
			k3CodeDao.setBusinessId(dao.getReceiveUnitManageId());
			k3CodeDao.save();
			ThreadConnection.commit();
			bean = dao.generateBase();
		} else if (dao.load()) {
			dao.setDataFromBase(bean);
			ret = dao.update();
			bean = dao.generateBase();
		}
		return bean.toOneLineJSON(ret, null);
	}

}
