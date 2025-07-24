package com.pomplatform.db.handler;

import java.util.Date;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.ReceiveUnitManage;

public class RewriteCapitalHandler extends CapitalHandler{

	private static final Logger __logger = Logger.getLogger(RewriteCapitalHandler.class);
 
	@Override
	public String save(String json) throws Exception{
		
		
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		ReceiveUnitManage rum=new ReceiveUnitManage();
		rum.setConditionReceiveUnit("=", bean.getOtherName());
		BaseReceiveUnitManage baseRe=rum.executeQueryOneRow();
		if(baseRe==null){
			rum.clear();
			BaseReceiveUnitManage rm=new BaseReceiveUnitManage();
			rm.setReceiveUnit(bean.getOtherName());
			rm.setBankAccount(bean.getOtherBankAccount());
			rm.setBankName(bean.getOtherBankName());
			rm.setOperateTime(new Date());
			rm.setOrigin(1);
			rum.setDataFromBase(rm);
			rum.save();
		}
		
		
		
		Capital dao = new Capital();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		ReceiveUnitManage rum=new ReceiveUnitManage();
		rum.setConditionReceiveUnit("=", bean.getOtherName());
		BaseReceiveUnitManage baseRe=rum.executeQueryOneRow();
		if(baseRe==null){
			rum.clear();
			BaseReceiveUnitManage rm=new BaseReceiveUnitManage();
			rm.setReceiveUnit(bean.getOtherName());
			rm.setBankAccount(bean.getOtherBankAccount());
			rm.setBankName(bean.getOtherBankName());
			rm.setOperateTime(new Date());
			rm.setOrigin(1);
			rum.setDataFromBase(rm);
			rum.save();
		}
		
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}
}


