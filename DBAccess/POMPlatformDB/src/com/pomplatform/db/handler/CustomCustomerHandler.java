package com.pomplatform.db.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.K3Code;

import delicacy.connection.ThreadConnection;

public class CustomCustomerHandler extends CustomerHandler{

	private static final Logger __logger = Logger.getLogger(CustomCustomerHandler.class);

	@Override
	public String save(String json) throws Exception{
		ThreadConnection.beginTransaction();
		BaseCustomer bean = new BaseCustomer();
		bean.setDataFromJSON(json);
		Customer dao = new Customer();
		dao.setDataFromBase(bean);
		int num = dao.save();
		K3Code codeDao = new K3Code();
		codeDao.setType(9);
		codeDao.setBusinessId(dao.getCustomerId());
		codeDao.save();
		ThreadConnection.commit();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}
}


