package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance;
import com.pomplatform.db.dao.InputTaxInvoiceLinkFinance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InputTaxInvoiceLinkFinanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InputTaxInvoiceLinkFinanceHandler.class);

	public static BaseInputTaxInvoiceLinkFinance getInputTaxInvoiceLinkFinanceById( 
		java.lang.Integer input_tax_invoice_link_finance_id
	) throws Exception
	{
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setInputTaxInvoiceLinkFinanceId(input_tax_invoice_link_finance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInputTaxInvoiceLinkFinanceExists( com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance bean, String additional ) throws Exception {

		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInputTaxInvoiceLinkFinance( com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance bean, String additional ) throws Exception {

		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInputTaxInvoiceLinkFinance> queryInputTaxInvoiceLinkFinance( com.pomplatform.db.bean.BaseInputTaxInvoiceLinkFinance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInputTaxInvoiceLinkFinance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInputTaxInvoiceLinkFinance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInputTaxInvoiceLinkFinance addToInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance )  throws Exception {
		return addToInputTaxInvoiceLinkFinance ( inputtaxinvoicelinkfinance , false);
	}

	public static BaseInputTaxInvoiceLinkFinance addToInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setDataFromBase(inputtaxinvoicelinkfinance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInputTaxInvoiceLinkFinance addUpdateInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance ) throws Exception {
		return addUpdateInputTaxInvoiceLinkFinance ( inputtaxinvoicelinkfinance , false);
	}

	public static BaseInputTaxInvoiceLinkFinance addUpdateInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance, boolean singleTransaction  ) throws Exception {
		if(inputtaxinvoicelinkfinance.getInputTaxInvoiceLinkFinanceId() == null) return addToInputTaxInvoiceLinkFinance(inputtaxinvoicelinkfinance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setDataFromBase(inputtaxinvoicelinkfinance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(inputtaxinvoicelinkfinance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance bean ) throws Exception {
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInputTaxInvoiceLinkFinance updateInputTaxInvoiceLinkFinance ( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance ) throws Exception {
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setInputTaxInvoiceLinkFinanceId( inputtaxinvoicelinkfinance.getInputTaxInvoiceLinkFinanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(inputtaxinvoicelinkfinance);
			result = dao.update();
		}
		return result == 1 ? inputtaxinvoicelinkfinance : null ;
	}

	public static BaseInputTaxInvoiceLinkFinance updateInputTaxInvoiceLinkFinanceDirect( BaseInputTaxInvoiceLinkFinance inputtaxinvoicelinkfinance ) throws Exception {
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		int result = 0;
		dao.setDataFromBase(inputtaxinvoicelinkfinance);
		result = dao.update();
		return result == 1 ? inputtaxinvoicelinkfinance : null ;
	}

	public static int setDeleteConditions(BaseInputTaxInvoiceLinkFinance bean, InputTaxInvoiceLinkFinance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInputTaxInvoiceLinkFinanceId() != null) {
			dao.setConditionInputTaxInvoiceLinkFinanceId("=", bean.getInputTaxInvoiceLinkFinanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAddType() != null) {
				dao.setConditionAddType("=", bean.getAddType());
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
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOtherRemark() != null) {
				dao.setConditionOtherRemark("=", bean.getOtherRemark());
				count++;
			}
			if(bean.getRandomCode() != null) {
				dao.setConditionRandomCode("=", bean.getRandomCode());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInputTaxInvoiceLinkFinance bean, InputTaxInvoiceLinkFinance dao){
		int count = 0;
		if(bean.getInputTaxInvoiceLinkFinanceId() != null) {
			dao.setConditionInputTaxInvoiceLinkFinanceId("=", bean.getInputTaxInvoiceLinkFinanceId());
			count++;
		}
		if(bean.getAddType() != null) {
			dao.setConditionAddType("=", bean.getAddType());
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
		if(bean.getInvoiceDate() != null) {
			dao.setConditionInvoiceDate(">=", bean.getInvoiceDate());
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
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOtherRemark() != null) {
			if(bean.getOtherRemark().indexOf("%") >= 0)
				dao.setConditionOtherRemark("like", bean.getOtherRemark());
			else
				dao.setConditionOtherRemark("=", bean.getOtherRemark());
			count++;
		}
		if(bean.getRandomCode() != null) {
			if(bean.getRandomCode().indexOf("%") >= 0)
				dao.setConditionRandomCode("like", bean.getRandomCode());
			else
				dao.setConditionRandomCode("=", bean.getRandomCode());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		bean.setDataFromJSON(json);
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInputTaxInvoiceLinkFinance> rlist = new BaseCollection<>();
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInputTaxInvoiceLinkFinance> result = dao.conditionalLoad(addtion);
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
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		bean.setDataFromJSON(json);
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		bean.setDataFromJSON(json);
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		bean.setDataFromJSON(json);
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInputTaxInvoiceLinkFinance bean = new BaseInputTaxInvoiceLinkFinance();
		bean.setDataFromJSON(json);
		InputTaxInvoiceLinkFinance dao = new InputTaxInvoiceLinkFinance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


