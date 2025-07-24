package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseInputTaxRecord;
import com.pomplatform.db.dao.InputTaxRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class InputTaxRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(InputTaxRecordHandler.class);

	public static BaseInputTaxRecord getInputTaxRecordById( 
		java.lang.Integer input_tax_record_id
	) throws Exception
	{
		InputTaxRecord dao = new InputTaxRecord();
		dao.setInputTaxRecordId(input_tax_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isInputTaxRecordExists( com.pomplatform.db.bean.BaseInputTaxRecord bean, String additional ) throws Exception {

		InputTaxRecord dao = new InputTaxRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countInputTaxRecord( com.pomplatform.db.bean.BaseInputTaxRecord bean, String additional ) throws Exception {

		InputTaxRecord dao = new InputTaxRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseInputTaxRecord> queryInputTaxRecord( com.pomplatform.db.bean.BaseInputTaxRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		InputTaxRecord dao = new InputTaxRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseInputTaxRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseInputTaxRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseInputTaxRecord addToInputTaxRecord ( BaseInputTaxRecord inputtaxrecord )  throws Exception {
		return addToInputTaxRecord ( inputtaxrecord , false);
	}

	public static BaseInputTaxRecord addToInputTaxRecord ( BaseInputTaxRecord inputtaxrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		InputTaxRecord dao = new InputTaxRecord();
		dao.setDataFromBase(inputtaxrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseInputTaxRecord addUpdateInputTaxRecord ( BaseInputTaxRecord inputtaxrecord ) throws Exception {
		return addUpdateInputTaxRecord ( inputtaxrecord , false);
	}

	public static BaseInputTaxRecord addUpdateInputTaxRecord ( BaseInputTaxRecord inputtaxrecord, boolean singleTransaction  ) throws Exception {
		if(inputtaxrecord.getInputTaxRecordId() == null) return addToInputTaxRecord(inputtaxrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		InputTaxRecord dao = new InputTaxRecord();
		dao.setDataFromBase(inputtaxrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(inputtaxrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteInputTaxRecord ( BaseInputTaxRecord bean ) throws Exception {
		InputTaxRecord dao = new InputTaxRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseInputTaxRecord updateInputTaxRecord ( BaseInputTaxRecord inputtaxrecord ) throws Exception {
		InputTaxRecord dao = new InputTaxRecord();
		dao.setInputTaxRecordId( inputtaxrecord.getInputTaxRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(inputtaxrecord);
			result = dao.update();
		}
		return result == 1 ? inputtaxrecord : null ;
	}

	public static BaseInputTaxRecord updateInputTaxRecordDirect( BaseInputTaxRecord inputtaxrecord ) throws Exception {
		InputTaxRecord dao = new InputTaxRecord();
		int result = 0;
		dao.setDataFromBase(inputtaxrecord);
		result = dao.update();
		return result == 1 ? inputtaxrecord : null ;
	}

	public static int setDeleteConditions(BaseInputTaxRecord bean, InputTaxRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getInputTaxRecordId() != null) {
			dao.setConditionInputTaxRecordId("=", bean.getInputTaxRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getInvoiceEndNumber() != null) {
				dao.setConditionInvoiceEndNumber("=", bean.getInvoiceEndNumber());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseInputTaxRecord bean, InputTaxRecord dao){
		int count = 0;
		if(bean.getInputTaxRecordId() != null) {
			dao.setConditionInputTaxRecordId("=", bean.getInputTaxRecordId());
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
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getInputTax() != null) {
			dao.setConditionInputTax("=", bean.getInputTax());
			count++;
		}
		if(bean.getInvoiceEndNumber() != null) {
			if(bean.getInvoiceEndNumber().indexOf("%") >= 0)
				dao.setConditionInvoiceEndNumber("like", bean.getInvoiceEndNumber());
			else
				dao.setConditionInvoiceEndNumber("=", bean.getInvoiceEndNumber());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getOverTime() != null) {
			dao.setConditionOverTime(">=", bean.getOverTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		bean.setDataFromJSON(json);
		InputTaxRecord dao = new InputTaxRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseInputTaxRecord> rlist = new BaseCollection<>();
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		InputTaxRecord dao = new InputTaxRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseInputTaxRecord> result = dao.conditionalLoad(addtion);
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
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		bean.setDataFromJSON(json);
		InputTaxRecord dao = new InputTaxRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		bean.setDataFromJSON(json);
		InputTaxRecord dao = new InputTaxRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		bean.setDataFromJSON(json);
		InputTaxRecord dao = new InputTaxRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseInputTaxRecord bean = new BaseInputTaxRecord();
		bean.setDataFromJSON(json);
		InputTaxRecord dao = new InputTaxRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


