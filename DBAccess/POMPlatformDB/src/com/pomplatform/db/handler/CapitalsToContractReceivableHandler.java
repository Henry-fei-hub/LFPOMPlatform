package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalsToContractReceivable;
import com.pomplatform.db.dao.CapitalsToContractReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalsToContractReceivableHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalsToContractReceivableHandler.class);

	public static BaseCapitalsToContractReceivable getCapitalsToContractReceivableById( 
		java.lang.Integer capitals_to_contract_receivable_id
	) throws Exception
	{
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setCapitalsToContractReceivableId(capitals_to_contract_receivable_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalsToContractReceivableExists( com.pomplatform.db.bean.BaseCapitalsToContractReceivable bean, String additional ) throws Exception {

		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalsToContractReceivable( com.pomplatform.db.bean.BaseCapitalsToContractReceivable bean, String additional ) throws Exception {

		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalsToContractReceivable> queryCapitalsToContractReceivable( com.pomplatform.db.bean.BaseCapitalsToContractReceivable bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalsToContractReceivable> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalsToContractReceivable> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalsToContractReceivable addToCapitalsToContractReceivable ( BaseCapitalsToContractReceivable capitalstocontractreceivable )  throws Exception {
		return addToCapitalsToContractReceivable ( capitalstocontractreceivable , false);
	}

	public static BaseCapitalsToContractReceivable addToCapitalsToContractReceivable ( BaseCapitalsToContractReceivable capitalstocontractreceivable, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setDataFromBase(capitalstocontractreceivable);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalsToContractReceivable addUpdateCapitalsToContractReceivable ( BaseCapitalsToContractReceivable capitalstocontractreceivable ) throws Exception {
		return addUpdateCapitalsToContractReceivable ( capitalstocontractreceivable , false);
	}

	public static BaseCapitalsToContractReceivable addUpdateCapitalsToContractReceivable ( BaseCapitalsToContractReceivable capitalstocontractreceivable, boolean singleTransaction  ) throws Exception {
		if(capitalstocontractreceivable.getCapitalsToContractReceivableId() == null) return addToCapitalsToContractReceivable(capitalstocontractreceivable);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setDataFromBase(capitalstocontractreceivable);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitalstocontractreceivable); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalsToContractReceivable ( BaseCapitalsToContractReceivable bean ) throws Exception {
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalsToContractReceivable updateCapitalsToContractReceivable ( BaseCapitalsToContractReceivable capitalstocontractreceivable ) throws Exception {
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setCapitalsToContractReceivableId( capitalstocontractreceivable.getCapitalsToContractReceivableId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitalstocontractreceivable);
			result = dao.update();
		}
		return result == 1 ? capitalstocontractreceivable : null ;
	}

	public static BaseCapitalsToContractReceivable updateCapitalsToContractReceivableDirect( BaseCapitalsToContractReceivable capitalstocontractreceivable ) throws Exception {
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		int result = 0;
		dao.setDataFromBase(capitalstocontractreceivable);
		result = dao.update();
		return result == 1 ? capitalstocontractreceivable : null ;
	}

	public static int setDeleteConditions(BaseCapitalsToContractReceivable bean, CapitalsToContractReceivable dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalsToContractReceivableId() != null) {
			dao.setConditionCapitalsToContractReceivableId("=", bean.getCapitalsToContractReceivableId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
				count++;
			}
			if(bean.getCapitalId() != null) {
				dao.setConditionCapitalId("=", bean.getCapitalId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCapitalsToContractReceivable bean, CapitalsToContractReceivable dao){
		int count = 0;
		if(bean.getCapitalsToContractReceivableId() != null) {
			dao.setConditionCapitalsToContractReceivableId("=", bean.getCapitalsToContractReceivableId());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
			count++;
		}
		if(bean.getCapitalId() != null) {
			dao.setConditionCapitalId("=", bean.getCapitalId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getStagePercentage() != null) {
			dao.setConditionStagePercentage("=", bean.getStagePercentage());
			count++;
		}
		if(bean.getStageSumMoney() != null) {
			dao.setConditionStageSumMoney("=", bean.getStageSumMoney());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		bean.setDataFromJSON(json);
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalsToContractReceivable> rlist = new BaseCollection<>();
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalsToContractReceivable> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		bean.setDataFromJSON(json);
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		bean.setDataFromJSON(json);
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		bean.setDataFromJSON(json);
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalsToContractReceivable bean = new BaseCapitalsToContractReceivable();
		bean.setDataFromJSON(json);
		CapitalsToContractReceivable dao = new CapitalsToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


