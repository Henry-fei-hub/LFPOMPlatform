package com.pomplatform.db.handler;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.CapitalDistribution;

import delicacy.common.GenericDao;
/**
 * 录入回款时，这笔款的指定了合同，
 * 1：会将这笔金额回款到发票上去，成功的会上去了，改一下这笔款是否绑定发票的状态
 * 2：有合同阶段回款到合同阶段上去，成功的会上去了，改一下这笔款是否绑定合同阶段的状态
 * @author wull
 *
 */
public class CustomCapitalHandler extends CapitalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CustomCapitalHandler.class);
//	@Override
//	public String save(String json) throws Exception{
//		BaseCapital bean = new BaseCapital();
//		bean.setDataFromJSON(json);
//		Capital dao = new Capital();
//		dao.setDataFromBase(bean);
//		int num = dao.save();
//		dao.setDataToBase(bean);
//		return bean.toOneLineJSON(num, null);
//	}
	
	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { 
			dao.setDataFromBase(bean); 
			ret = dao.save(); 
			bean = dao.generateBase(); 
		}else if(dao.load()) { 
			dao.setDataFromBase(bean); 
			ret = dao.update(); 
			if(dao.getMoneyAttribute() == 1){
				CapitalDistribution distribution = new CapitalDistribution();
				distribution.setConditionCapitalId("=", dao.getCapitalId());
				distribution.setTotalAmount(dao.getBorrowMoney());
				distribution.conditionalUpdate();
			}
			bean = dao.generateBase(); 
		}
		return bean.toOneLineJSON(ret, null);
	}
	
	@Override
	public String update(String json) throws Exception {
		BaseCapital bean = new BaseCapital();
		bean.setDataFromJSON(json);
		Capital dao = new Capital();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			dao.setDataFromBase(bean); 
			num = dao.update(); 
			if(dao.getMoneyAttribute() == 1){
				CapitalDistribution distribution = new CapitalDistribution();
				distribution.setConditionCapitalId("=", dao.getCapitalId());
				distribution.setTotalAmount(dao.getBorrowMoney());
				distribution.conditionalUpdate();
			}
		}
		return bean.toOneLineJSON(num, null);
	}
}


