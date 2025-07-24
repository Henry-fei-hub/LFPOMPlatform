package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoiceApplyReceivable;
import com.pomplatform.db.dao.InvoiceApplyReceivable;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoiceApplyReceivableHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoiceApplyReceivableHandler.class);

	public static BaseInvoiceApplyReceivable getInvoiceApplyReceivableById( 
		java.lang.Integer invoice_apply_receivable_id
	) throws Exception
	{
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setInvoiceApplyReceivableId(invoice_apply_receivable_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoiceApplyReceivableExists( com.pomplatform.db.bean.BaseInvoiceApplyReceivable bean, String additional ) throws Exception {

		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoiceApplyReceivable( com.pomplatform.db.bean.BaseInvoiceApplyReceivable bean, String additional ) throws Exception {

		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoiceApplyReceivable> queryInvoiceApplyReceivable( com.pomplatform.db.bean.BaseInvoiceApplyReceivable bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoiceApplyReceivable> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoiceApplyReceivable> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoiceApplyReceivable addToInvoiceApplyReceivable ( BaseInvoiceApplyReceivable invoiceapplyreceivable )  throws Exception {
		return addToInvoiceApplyReceivable ( invoiceapplyreceivable , false);
	}

	public static BaseInvoiceApplyReceivable addToInvoiceApplyReceivable ( BaseInvoiceApplyReceivable invoiceapplyreceivable, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setDataFromBase(invoiceapplyreceivable);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoiceApplyReceivable addUpdateInvoiceApplyReceivable ( BaseInvoiceApplyReceivable invoiceapplyreceivable ) throws Exception {
		return addUpdateInvoiceApplyReceivable ( invoiceapplyreceivable , false);
	}

	public static BaseInvoiceApplyReceivable addUpdateInvoiceApplyReceivable ( BaseInvoiceApplyReceivable invoiceapplyreceivable, boolean singleTransaction  ) throws Exception {
		if(invoiceapplyreceivable.getInvoiceApplyReceivableId() == null) return addToInvoiceApplyReceivable(invoiceapplyreceivable);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setDataFromBase(invoiceapplyreceivable);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoiceapplyreceivable); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoiceApplyReceivable ( BaseInvoiceApplyReceivable bean ) throws Exception {
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoiceApplyReceivable updateInvoiceApplyReceivable ( BaseInvoiceApplyReceivable invoiceapplyreceivable ) throws Exception {
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setInvoiceApplyReceivableId( invoiceapplyreceivable.getInvoiceApplyReceivableId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoiceapplyreceivable);
			result = dao.update();
		}
		return result == 1 ? invoiceapplyreceivable : null ;
	}

	public static BaseInvoiceApplyReceivable updateInvoiceApplyReceivableDirect( BaseInvoiceApplyReceivable invoiceapplyreceivable ) throws Exception {
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		int result = 0;
		dao.setDataFromBase(invoiceapplyreceivable);
		result = dao.update();
		return result == 1 ? invoiceapplyreceivable : null ;
	}

	public static int setDeleteConditions(BaseInvoiceApplyReceivable bean, InvoiceApplyReceivable dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInvoiceApplyReceivableId() != null) {
			dao.setConditionInvoiceApplyReceivableId("=", bean.getInvoiceApplyReceivableId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getInvoiceApplyId() != null) {
				dao.setConditionInvoiceApplyId("=", bean.getInvoiceApplyId());
				count++;
			}
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoiceApplyReceivable bean, InvoiceApplyReceivable dao){
		int count = 0;
		if(bean.getInvoiceApplyReceivableId() != null) {
			dao.setConditionInvoiceApplyReceivableId("=", bean.getInvoiceApplyReceivableId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getInvoiceApplyId() != null) {
			dao.setConditionInvoiceApplyId("=", bean.getInvoiceApplyId());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
			count++;
		}
		if(bean.getReceivableApplyMoney() != null) {
			dao.setConditionReceivableApplyMoney("=", bean.getReceivableApplyMoney());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		bean.setDataFromJSON(json);
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoiceApplyReceivable> rlist = new BaseCollection<>();
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoiceApplyReceivable> result = dao.conditionalLoad(addtion);
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
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		bean.setDataFromJSON(json);
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		bean.setDataFromJSON(json);
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		bean.setDataFromJSON(json);
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoiceApplyReceivable bean = new BaseInvoiceApplyReceivable();
		bean.setDataFromJSON(json);
		InvoiceApplyReceivable dao = new InvoiceApplyReceivable();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


