package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoicesToContractReceivable;
import com.pomplatform.db.dao.InvoicesToContractReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoicesToContractReceivableHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoicesToContractReceivableHandler.class);

	public static BaseInvoicesToContractReceivable getInvoicesToContractReceivableById( 
		java.lang.Integer center_id
	) throws Exception
	{
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setCenterId(center_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoicesToContractReceivableExists( com.pomplatform.db.bean.BaseInvoicesToContractReceivable bean, String additional ) throws Exception {

		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoicesToContractReceivable( com.pomplatform.db.bean.BaseInvoicesToContractReceivable bean, String additional ) throws Exception {

		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoicesToContractReceivable> queryInvoicesToContractReceivable( com.pomplatform.db.bean.BaseInvoicesToContractReceivable bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoicesToContractReceivable> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoicesToContractReceivable> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoicesToContractReceivable addToInvoicesToContractReceivable ( BaseInvoicesToContractReceivable invoicestocontractreceivable )  throws Exception {
		return addToInvoicesToContractReceivable ( invoicestocontractreceivable , false);
	}

	public static BaseInvoicesToContractReceivable addToInvoicesToContractReceivable ( BaseInvoicesToContractReceivable invoicestocontractreceivable, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setDataFromBase(invoicestocontractreceivable);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoicesToContractReceivable addUpdateInvoicesToContractReceivable ( BaseInvoicesToContractReceivable invoicestocontractreceivable ) throws Exception {
		return addUpdateInvoicesToContractReceivable ( invoicestocontractreceivable , false);
	}

	public static BaseInvoicesToContractReceivable addUpdateInvoicesToContractReceivable ( BaseInvoicesToContractReceivable invoicestocontractreceivable, boolean singleTransaction  ) throws Exception {
		if(invoicestocontractreceivable.getCenterId() == null) return addToInvoicesToContractReceivable(invoicestocontractreceivable);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setDataFromBase(invoicestocontractreceivable);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoicestocontractreceivable); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoicesToContractReceivable ( BaseInvoicesToContractReceivable bean ) throws Exception {
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoicesToContractReceivable updateInvoicesToContractReceivable ( BaseInvoicesToContractReceivable invoicestocontractreceivable ) throws Exception {
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setCenterId( invoicestocontractreceivable.getCenterId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoicestocontractreceivable);
			result = dao.update();
		}
		return result == 1 ? invoicestocontractreceivable : null ;
	}

	public static BaseInvoicesToContractReceivable updateInvoicesToContractReceivableDirect( BaseInvoicesToContractReceivable invoicestocontractreceivable ) throws Exception {
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		int result = 0;
		dao.setDataFromBase(invoicestocontractreceivable);
		result = dao.update();
		return result == 1 ? invoicestocontractreceivable : null ;
	}

	public static int setDeleteConditions(BaseInvoicesToContractReceivable bean, InvoicesToContractReceivable dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCenterId() != null) {
			dao.setConditionCenterId("=", bean.getCenterId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
				count++;
			}
			if(bean.getInvoiceId() != null) {
				dao.setConditionInvoiceId("=", bean.getInvoiceId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoicesToContractReceivable bean, InvoicesToContractReceivable dao){
		int count = 0;
		if(bean.getCenterId() != null) {
			dao.setConditionCenterId("=", bean.getCenterId());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
			count++;
		}
		if(bean.getInvoiceId() != null) {
			dao.setConditionInvoiceId("=", bean.getInvoiceId());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		bean.setDataFromJSON(json);
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoicesToContractReceivable> rlist = new BaseCollection<>();
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoicesToContractReceivable> result = dao.conditionalLoad(addtion);
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
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		bean.setDataFromJSON(json);
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		bean.setDataFromJSON(json);
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		bean.setDataFromJSON(json);
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoicesToContractReceivable bean = new BaseInvoicesToContractReceivable();
		bean.setDataFromJSON(json);
		InvoicesToContractReceivable dao = new InvoicesToContractReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


