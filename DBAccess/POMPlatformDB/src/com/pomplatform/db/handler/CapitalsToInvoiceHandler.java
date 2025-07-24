package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapitalsToInvoice;
import com.pomplatform.db.dao.CapitalsToInvoice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CapitalsToInvoiceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CapitalsToInvoiceHandler.class);

	public static BaseCapitalsToInvoice getCapitalsToInvoiceById( 
		java.lang.Integer capitals_to_invoice_id
	) throws Exception
	{
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setCapitalsToInvoiceId(capitals_to_invoice_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCapitalsToInvoiceExists( com.pomplatform.db.bean.BaseCapitalsToInvoice bean, String additional ) throws Exception {

		CapitalsToInvoice dao = new CapitalsToInvoice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCapitalsToInvoice( com.pomplatform.db.bean.BaseCapitalsToInvoice bean, String additional ) throws Exception {

		CapitalsToInvoice dao = new CapitalsToInvoice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCapitalsToInvoice> queryCapitalsToInvoice( com.pomplatform.db.bean.BaseCapitalsToInvoice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CapitalsToInvoice dao = new CapitalsToInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCapitalsToInvoice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCapitalsToInvoice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCapitalsToInvoice addToCapitalsToInvoice ( BaseCapitalsToInvoice capitalstoinvoice )  throws Exception {
		return addToCapitalsToInvoice ( capitalstoinvoice , false);
	}

	public static BaseCapitalsToInvoice addToCapitalsToInvoice ( BaseCapitalsToInvoice capitalstoinvoice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setDataFromBase(capitalstoinvoice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCapitalsToInvoice addUpdateCapitalsToInvoice ( BaseCapitalsToInvoice capitalstoinvoice ) throws Exception {
		return addUpdateCapitalsToInvoice ( capitalstoinvoice , false);
	}

	public static BaseCapitalsToInvoice addUpdateCapitalsToInvoice ( BaseCapitalsToInvoice capitalstoinvoice, boolean singleTransaction  ) throws Exception {
		if(capitalstoinvoice.getCapitalsToInvoiceId() == null) return addToCapitalsToInvoice(capitalstoinvoice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setDataFromBase(capitalstoinvoice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(capitalstoinvoice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCapitalsToInvoice ( BaseCapitalsToInvoice bean ) throws Exception {
		CapitalsToInvoice dao = new CapitalsToInvoice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCapitalsToInvoice updateCapitalsToInvoice ( BaseCapitalsToInvoice capitalstoinvoice ) throws Exception {
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setCapitalsToInvoiceId( capitalstoinvoice.getCapitalsToInvoiceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(capitalstoinvoice);
			result = dao.update();
		}
		return result == 1 ? capitalstoinvoice : null ;
	}

	public static BaseCapitalsToInvoice updateCapitalsToInvoiceDirect( BaseCapitalsToInvoice capitalstoinvoice ) throws Exception {
		CapitalsToInvoice dao = new CapitalsToInvoice();
		int result = 0;
		dao.setDataFromBase(capitalstoinvoice);
		result = dao.update();
		return result == 1 ? capitalstoinvoice : null ;
	}

	public static int setDeleteConditions(BaseCapitalsToInvoice bean, CapitalsToInvoice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCapitalsToInvoiceId() != null) {
			dao.setConditionCapitalsToInvoiceId("=", bean.getCapitalsToInvoiceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getInvoiceId() != null) {
				dao.setConditionInvoiceId("=", bean.getInvoiceId());
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

	public static int setConditions(BaseCapitalsToInvoice bean, CapitalsToInvoice dao){
		int count = 0;
		if(bean.getCapitalsToInvoiceId() != null) {
			dao.setConditionCapitalsToInvoiceId("=", bean.getCapitalsToInvoiceId());
			count++;
		}
		if(bean.getInvoiceId() != null) {
			dao.setConditionInvoiceId("=", bean.getInvoiceId());
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
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		bean.setDataFromJSON(json);
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCapitalsToInvoice> rlist = new BaseCollection<>();
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CapitalsToInvoice dao = new CapitalsToInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCapitalsToInvoice> result = dao.conditionalLoad(addtion);
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
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		bean.setDataFromJSON(json);
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		bean.setDataFromJSON(json);
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		bean.setDataFromJSON(json);
		CapitalsToInvoice dao = new CapitalsToInvoice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCapitalsToInvoice bean = new BaseCapitalsToInvoice();
		bean.setDataFromJSON(json);
		CapitalsToInvoice dao = new CapitalsToInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


