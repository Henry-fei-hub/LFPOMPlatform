package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBusinessStateRecord;
import com.pomplatform.db.dao.BusinessStateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BusinessStateRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BusinessStateRecordHandler.class);

	public static BaseBusinessStateRecord getBusinessStateRecordById( 
		java.lang.Integer business_state_record_id
	) throws Exception
	{
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setBusinessStateRecordId(business_state_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBusinessStateRecordExists( com.pomplatform.db.bean.BaseBusinessStateRecord bean, String additional ) throws Exception {

		BusinessStateRecord dao = new BusinessStateRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBusinessStateRecord( com.pomplatform.db.bean.BaseBusinessStateRecord bean, String additional ) throws Exception {

		BusinessStateRecord dao = new BusinessStateRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBusinessStateRecord> queryBusinessStateRecord( com.pomplatform.db.bean.BaseBusinessStateRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BusinessStateRecord dao = new BusinessStateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBusinessStateRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBusinessStateRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBusinessStateRecord addToBusinessStateRecord ( BaseBusinessStateRecord businessstaterecord )  throws Exception {
		return addToBusinessStateRecord ( businessstaterecord , false);
	}

	public static BaseBusinessStateRecord addToBusinessStateRecord ( BaseBusinessStateRecord businessstaterecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setDataFromBase(businessstaterecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBusinessStateRecord addUpdateBusinessStateRecord ( BaseBusinessStateRecord businessstaterecord ) throws Exception {
		return addUpdateBusinessStateRecord ( businessstaterecord , false);
	}

	public static BaseBusinessStateRecord addUpdateBusinessStateRecord ( BaseBusinessStateRecord businessstaterecord, boolean singleTransaction  ) throws Exception {
		if(businessstaterecord.getBusinessStateRecordId() == null) return addToBusinessStateRecord(businessstaterecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setDataFromBase(businessstaterecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(businessstaterecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBusinessStateRecord ( BaseBusinessStateRecord bean ) throws Exception {
		BusinessStateRecord dao = new BusinessStateRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBusinessStateRecord updateBusinessStateRecord ( BaseBusinessStateRecord businessstaterecord ) throws Exception {
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setBusinessStateRecordId( businessstaterecord.getBusinessStateRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(businessstaterecord);
			result = dao.update();
		}
		return result == 1 ? businessstaterecord : null ;
	}

	public static BaseBusinessStateRecord updateBusinessStateRecordDirect( BaseBusinessStateRecord businessstaterecord ) throws Exception {
		BusinessStateRecord dao = new BusinessStateRecord();
		int result = 0;
		dao.setDataFromBase(businessstaterecord);
		result = dao.update();
		return result == 1 ? businessstaterecord : null ;
	}

	public static int setDeleteConditions(BaseBusinessStateRecord bean, BusinessStateRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBusinessStateRecordId() != null) {
			dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getBusinessCode() != null) {
				dao.setConditionBusinessCode("=", bean.getBusinessCode());
				count++;
			}
			if(bean.getBusinessName() != null) {
				dao.setConditionBusinessName("=", bean.getBusinessName());
				count++;
			}
			if(bean.getAccountWeightRecordId() != null) {
				dao.setConditionAccountWeightRecordId("=", bean.getAccountWeightRecordId());
				count++;
			}
			if(bean.getSigningCompany() != null) {
				dao.setConditionSigningCompany("=", bean.getSigningCompany());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBusinessStateRecord bean, BusinessStateRecord dao){
		int count = 0;
		if(bean.getBusinessStateRecordId() != null) {
			dao.setConditionBusinessStateRecordId("=", bean.getBusinessStateRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getBusinessCode() != null) {
			if(bean.getBusinessCode().indexOf("%") >= 0)
				dao.setConditionBusinessCode("like", bean.getBusinessCode());
			else
				dao.setConditionBusinessCode("=", bean.getBusinessCode());
			count++;
		}
		if(bean.getBusinessName() != null) {
			if(bean.getBusinessName().indexOf("%") >= 0)
				dao.setConditionBusinessName("like", bean.getBusinessName());
			else
				dao.setConditionBusinessName("=", bean.getBusinessName());
			count++;
		}
		if(bean.getBeforeContractTotal() != null) {
			dao.setConditionBeforeContractTotal("=", bean.getBeforeContractTotal());
			count++;
		}
		if(bean.getBusinessIntegral() != null) {
			dao.setConditionBusinessIntegral("=", bean.getBusinessIntegral());
			count++;
		}
		if(bean.getAccountWeightRecordId() != null) {
			dao.setConditionAccountWeightRecordId("=", bean.getAccountWeightRecordId());
			count++;
		}
		if(bean.getSigningCompany() != null) {
			dao.setConditionSigningCompany("=", bean.getSigningCompany());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		bean.setDataFromJSON(json);
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBusinessStateRecord> rlist = new BaseCollection<>();
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BusinessStateRecord dao = new BusinessStateRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBusinessStateRecord> result = dao.conditionalLoad(addtion);
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
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		bean.setDataFromJSON(json);
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		bean.setDataFromJSON(json);
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		bean.setDataFromJSON(json);
		BusinessStateRecord dao = new BusinessStateRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBusinessStateRecord bean = new BaseBusinessStateRecord();
		bean.setDataFromJSON(json);
		BusinessStateRecord dao = new BusinessStateRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


