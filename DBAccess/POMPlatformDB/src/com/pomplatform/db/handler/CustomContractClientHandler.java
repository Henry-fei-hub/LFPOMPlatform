package com.pomplatform.db.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseClient;
import com.pomplatform.db.bean.BaseContractClient;
import com.pomplatform.db.dao.Client;
import com.pomplatform.db.dao.ContractClient;

public class CustomContractClientHandler extends ClientHandler {

	private static final Logger __logger = Logger.getLogger(CustomContractClientHandler.class);


	@Override
	public String save(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		//插入关联表数据
		BaseContractClient ccBean = new BaseContractClient();
		ccBean.setDataFromJSON(json);
		ccBean.setClientId(dao.getClientId());
		ContractClient ccdao = new ContractClient();
		ccdao.setDataFromBase(ccBean);
		ccdao.save();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseClient bean = new BaseClient();
		bean.setDataFromJSON(json);
		Client dao = new Client();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		//删除关联表数据
		ContractClient ccDao = new ContractClient();
		ccDao.setConditionClientId("=", bean.getClientId());
		ccDao.conditionalDelete();
		
		return bean.toOneLineJSON(num, null);
	}

}


