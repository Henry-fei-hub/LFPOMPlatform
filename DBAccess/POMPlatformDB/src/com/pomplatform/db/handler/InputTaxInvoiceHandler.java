package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInputTaxInvoice;
import com.pomplatform.db.dao.InputTaxInvoice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InputTaxInvoiceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InputTaxInvoiceHandler.class);

	public static BaseInputTaxInvoice getInputTaxInvoiceById( 
		java.lang.Integer input_tax_invoice_id
	) throws Exception
	{
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setInputTaxInvoiceId(input_tax_invoice_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInputTaxInvoiceExists( com.pomplatform.db.bean.BaseInputTaxInvoice bean, String additional ) throws Exception {

		InputTaxInvoice dao = new InputTaxInvoice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInputTaxInvoice( com.pomplatform.db.bean.BaseInputTaxInvoice bean, String additional ) throws Exception {

		InputTaxInvoice dao = new InputTaxInvoice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInputTaxInvoice> queryInputTaxInvoice( com.pomplatform.db.bean.BaseInputTaxInvoice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InputTaxInvoice dao = new InputTaxInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInputTaxInvoice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInputTaxInvoice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInputTaxInvoice addToInputTaxInvoice ( BaseInputTaxInvoice inputtaxinvoice )  throws Exception {
		return addToInputTaxInvoice ( inputtaxinvoice , false);
	}

	public static BaseInputTaxInvoice addToInputTaxInvoice ( BaseInputTaxInvoice inputtaxinvoice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setDataFromBase(inputtaxinvoice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInputTaxInvoice addUpdateInputTaxInvoice ( BaseInputTaxInvoice inputtaxinvoice ) throws Exception {
		return addUpdateInputTaxInvoice ( inputtaxinvoice , false);
	}

	public static BaseInputTaxInvoice addUpdateInputTaxInvoice ( BaseInputTaxInvoice inputtaxinvoice, boolean singleTransaction  ) throws Exception {
		if(inputtaxinvoice.getInputTaxInvoiceId() == null) return addToInputTaxInvoice(inputtaxinvoice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setDataFromBase(inputtaxinvoice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(inputtaxinvoice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInputTaxInvoice ( BaseInputTaxInvoice bean ) throws Exception {
		InputTaxInvoice dao = new InputTaxInvoice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInputTaxInvoice updateInputTaxInvoice ( BaseInputTaxInvoice inputtaxinvoice ) throws Exception {
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setInputTaxInvoiceId( inputtaxinvoice.getInputTaxInvoiceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(inputtaxinvoice);
			result = dao.update();
		}
		return result == 1 ? inputtaxinvoice : null ;
	}

	public static BaseInputTaxInvoice updateInputTaxInvoiceDirect( BaseInputTaxInvoice inputtaxinvoice ) throws Exception {
		InputTaxInvoice dao = new InputTaxInvoice();
		int result = 0;
		dao.setDataFromBase(inputtaxinvoice);
		result = dao.update();
		return result == 1 ? inputtaxinvoice : null ;
	}

	public static int setDeleteConditions(BaseInputTaxInvoice bean, InputTaxInvoice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInputTaxInvoiceId() != null) {
			dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
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
			if(bean.getOperator() != null) {
				dao.setConditionOperator("=", bean.getOperator());
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
			if(bean.getSalesCode() != null) {
				dao.setConditionSalesCode("=", bean.getSalesCode());
				count++;
			}
			if(bean.getSalesName() != null) {
				dao.setConditionSalesName("=", bean.getSalesName());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getHaveCheck() != null) {
				dao.setConditionHaveCheck("=", bean.getHaveCheck());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInputTaxInvoice bean, InputTaxInvoice dao){
		int count = 0;
		if(bean.getInputTaxInvoiceId() != null) {
			dao.setConditionInputTaxInvoiceId("=", bean.getInputTaxInvoiceId());
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
		if(bean.getOperator() != null) {
			dao.setConditionOperator("=", bean.getOperator());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
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
		if(bean.getSalesCode() != null) {
			if(bean.getSalesCode().indexOf("%") >= 0)
				dao.setConditionSalesCode("like", bean.getSalesCode());
			else
				dao.setConditionSalesCode("=", bean.getSalesCode());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getSalesName() != null) {
			if(bean.getSalesName().indexOf("%") >= 0)
				dao.setConditionSalesName("like", bean.getSalesName());
			else
				dao.setConditionSalesName("=", bean.getSalesName());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getHaveCheck() != null) {
			dao.setConditionHaveCheck("=", bean.getHaveCheck());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		bean.setDataFromJSON(json);
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInputTaxInvoice> rlist = new BaseCollection<>();
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InputTaxInvoice dao = new InputTaxInvoice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInputTaxInvoice> result = dao.conditionalLoad(addtion);
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
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		bean.setDataFromJSON(json);
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		bean.setDataFromJSON(json);
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		bean.setDataFromJSON(json);
		InputTaxInvoice dao = new InputTaxInvoice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInputTaxInvoice bean = new BaseInputTaxInvoice();
		bean.setDataFromJSON(json);
		InputTaxInvoice dao = new InputTaxInvoice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


