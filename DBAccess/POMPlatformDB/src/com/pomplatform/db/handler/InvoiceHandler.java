package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInvoice;
import com.pomplatform.db.dao.Invoice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InvoiceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InvoiceHandler.class);

	public static BaseInvoice getInvoiceById( 
		java.lang.Integer invoice_id
	) throws Exception
	{
		Invoice dao = new Invoice();
		dao.setInvoiceId(invoice_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInvoiceExists( com.pomplatform.db.bean.BaseInvoice bean, String additional ) throws Exception {

		Invoice dao = new Invoice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInvoice( com.pomplatform.db.bean.BaseInvoice bean, String additional ) throws Exception {

		Invoice dao = new Invoice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInvoice> queryInvoice( com.pomplatform.db.bean.BaseInvoice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Invoice dao = new Invoice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInvoice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInvoice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInvoice addToInvoice ( BaseInvoice invoice )  throws Exception {
		return addToInvoice ( invoice , false);
	}

	public static BaseInvoice addToInvoice ( BaseInvoice invoice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Invoice dao = new Invoice();
		dao.setDataFromBase(invoice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInvoice addUpdateInvoice ( BaseInvoice invoice ) throws Exception {
		return addUpdateInvoice ( invoice , false);
	}

	public static BaseInvoice addUpdateInvoice ( BaseInvoice invoice, boolean singleTransaction  ) throws Exception {
		if(invoice.getInvoiceId() == null) return addToInvoice(invoice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Invoice dao = new Invoice();
		dao.setDataFromBase(invoice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(invoice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInvoice ( BaseInvoice bean ) throws Exception {
		Invoice dao = new Invoice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInvoice updateInvoice ( BaseInvoice invoice ) throws Exception {
		Invoice dao = new Invoice();
		dao.setInvoiceId( invoice.getInvoiceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(invoice);
			result = dao.update();
		}
		return result == 1 ? invoice : null ;
	}

	public static BaseInvoice updateInvoiceDirect( BaseInvoice invoice ) throws Exception {
		Invoice dao = new Invoice();
		int result = 0;
		dao.setDataFromBase(invoice);
		result = dao.update();
		return result == 1 ? invoice : null ;
	}

	public static int setDeleteConditions(BaseInvoice bean, Invoice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInvoiceId() != null) {
			dao.setConditionInvoiceId("=", bean.getInvoiceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTicketingCompany() != null) {
				dao.setConditionTicketingCompany("=", bean.getTicketingCompany());
				count++;
			}
			if(bean.getInvoiceType() != null) {
				dao.setConditionInvoiceType("=", bean.getInvoiceType());
				count++;
			}
			if(bean.getInvoiceCode() != null) {
				dao.setConditionInvoiceCode("=", bean.getInvoiceCode());
				count++;
			}
			if(bean.getInvoiceNumber() != null) {
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
				count++;
			}
			if(bean.getInvalidRemark() != null) {
				dao.setConditionInvalidRemark("=", bean.getInvalidRemark());
				count++;
			}
			if(bean.getIsInvalidOperator() != null) {
				dao.setConditionIsInvalidOperator("=", bean.getIsInvalidOperator());
				count++;
			}
			if(bean.getStorageOperator() != null) {
				dao.setConditionStorageOperator("=", bean.getStorageOperator());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getBillingOperation() != null) {
				dao.setConditionBillingOperation("=", bean.getBillingOperation());
				count++;
			}
			if(bean.getSign() != null) {
				dao.setConditionSign("=", bean.getSign());
				count++;
			}
			if(bean.getPrimaryInvoiceCode() != null) {
				dao.setConditionPrimaryInvoiceCode("=", bean.getPrimaryInvoiceCode());
				count++;
			}
			if(bean.getPrimaryInvoiceNumber() != null) {
				dao.setConditionPrimaryInvoiceNumber("=", bean.getPrimaryInvoiceNumber());
				count++;
			}
			if(bean.getContractReceivableId() != null) {
				dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
				count++;
			}
			if(bean.getAcknowledgeLetterId() != null) {
				dao.setConditionAcknowledgeLetterId("=", bean.getAcknowledgeLetterId());
				count++;
			}
			if(bean.getInvoiceExpressId() != null) {
				dao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
				count++;
			}
			if(bean.getDisableType() != null) {
				dao.setConditionDisableType("=", bean.getDisableType());
				count++;
			}
			if(bean.getHaveVoucher() != null) {
				dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
				count++;
			}
			if(bean.getIsCapital() != null) {
				dao.setConditionIsCapital("=", bean.getIsCapital());
				count++;
			}
			if(bean.getProjectManagerId() != null) {
				dao.setConditionProjectManagerId("=", bean.getProjectManagerId());
				count++;
			}
			if(bean.getCustomerId() != null) {
				dao.setConditionCustomerId("=", bean.getCustomerId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInvoice bean, Invoice dao){
		int count = 0;
		if(bean.getInvoiceId() != null) {
			dao.setConditionInvoiceId("=", bean.getInvoiceId());
			count++;
		}
		if(bean.getTicketingCompany() != null) {
			dao.setConditionTicketingCompany("=", bean.getTicketingCompany());
			count++;
		}
		if(bean.getInvoiceType() != null) {
			dao.setConditionInvoiceType("=", bean.getInvoiceType());
			count++;
		}
		if(bean.getInvoiceCode() != null) {
			if(bean.getInvoiceCode().indexOf("%") >= 0)
				dao.setConditionInvoiceCode("like", bean.getInvoiceCode());
			else
				dao.setConditionInvoiceCode("=", bean.getInvoiceCode());
			count++;
		}
		if(bean.getInvoiceNumber() != null) {
			if(bean.getInvoiceNumber().indexOf("%") >= 0)
				dao.setConditionInvoiceNumber("like", bean.getInvoiceNumber());
			else
				dao.setConditionInvoiceNumber("=", bean.getInvoiceNumber());
			count++;
		}
		if(bean.getInStockDate() != null) {
			dao.setConditionInStockDate(">=", bean.getInStockDate());
			count++;
		}
		if(bean.getInvalidRemark() != null) {
			if(bean.getInvalidRemark().indexOf("%") >= 0)
				dao.setConditionInvalidRemark("like", bean.getInvalidRemark());
			else
				dao.setConditionInvalidRemark("=", bean.getInvalidRemark());
			count++;
		}
		if(bean.getIsInvalidOperator() != null) {
			dao.setConditionIsInvalidOperator("=", bean.getIsInvalidOperator());
			count++;
		}
		if(bean.getStorageOperator() != null) {
			dao.setConditionStorageOperator("=", bean.getStorageOperator());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getInvoiceAmount() != null) {
			dao.setConditionInvoiceAmount("=", bean.getInvoiceAmount());
			count++;
		}
		if(bean.getTaxRate() != null) {
			dao.setConditionTaxRate("=", bean.getTaxRate());
			count++;
		}
		if(bean.getNoTaxAmount() != null) {
			dao.setConditionNoTaxAmount("=", bean.getNoTaxAmount());
			count++;
		}
		if(bean.getOutputTax() != null) {
			dao.setConditionOutputTax("=", bean.getOutputTax());
			count++;
		}
		if(bean.getBillingOperation() != null) {
			dao.setConditionBillingOperation("=", bean.getBillingOperation());
			count++;
		}
		if(bean.getInvoiceDate() != null) {
			dao.setConditionInvoiceDate(">=", bean.getInvoiceDate());
			count++;
		}
		if(bean.getRegistrationDate() != null) {
			dao.setConditionRegistrationDate(">=", bean.getRegistrationDate());
			count++;
		}
		if(bean.getSign() != null) {
			dao.setConditionSign("=", bean.getSign());
			count++;
		}
		if(bean.getPrimaryInvoiceCode() != null) {
			if(bean.getPrimaryInvoiceCode().indexOf("%") >= 0)
				dao.setConditionPrimaryInvoiceCode("like", bean.getPrimaryInvoiceCode());
			else
				dao.setConditionPrimaryInvoiceCode("=", bean.getPrimaryInvoiceCode());
			count++;
		}
		if(bean.getPrimaryInvoiceNumber() != null) {
			if(bean.getPrimaryInvoiceNumber().indexOf("%") >= 0)
				dao.setConditionPrimaryInvoiceNumber("like", bean.getPrimaryInvoiceNumber());
			else
				dao.setConditionPrimaryInvoiceNumber("=", bean.getPrimaryInvoiceNumber());
			count++;
		}
		if(bean.getContractReceivableId() != null) {
			dao.setConditionContractReceivableId("=", bean.getContractReceivableId());
			count++;
		}
		if(bean.getAcknowledgeLetterId() != null) {
			dao.setConditionAcknowledgeLetterId("=", bean.getAcknowledgeLetterId());
			count++;
		}
		if(bean.getInvoiceExpressId() != null) {
			dao.setConditionInvoiceExpressId("=", bean.getInvoiceExpressId());
			count++;
		}
		if(bean.getDisableType() != null) {
			dao.setConditionDisableType("=", bean.getDisableType());
			count++;
		}
		if(bean.getHaveVoucher() != null) {
			dao.setConditionHaveVoucher("=", bean.getHaveVoucher());
			count++;
		}
		if(bean.getIsCapital() != null) {
			dao.setConditionIsCapital("=", bean.getIsCapital());
			count++;
		}
		if(bean.getCapitalAmount() != null) {
			dao.setConditionCapitalAmount("=", bean.getCapitalAmount());
			count++;
		}
		if(bean.getProjectManagerId() != null) {
			dao.setConditionProjectManagerId("=", bean.getProjectManagerId());
			count++;
		}
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromJSON(json);
		Invoice dao = new Invoice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInvoice> rlist = new BaseCollection<>();
		BaseInvoice bean = new BaseInvoice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Invoice dao = new Invoice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInvoice> result = dao.conditionalLoad(addtion);
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
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromJSON(json);
		Invoice dao = new Invoice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromJSON(json);
		Invoice dao = new Invoice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromJSON(json);
		Invoice dao = new Invoice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInvoice bean = new BaseInvoice();
		bean.setDataFromJSON(json);
		Invoice dao = new Invoice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


