package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBusinessLineRecord;
import com.pomplatform.db.dao.BusinessLineRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BusinessLineRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BusinessLineRecordHandler.class);

	public static BaseBusinessLineRecord getBusinessLineRecordById( 
		java.lang.Integer business_line_record_id
	) throws Exception
	{
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setBusinessLineRecordId(business_line_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBusinessLineRecordExists( com.pomplatform.db.bean.BaseBusinessLineRecord bean, String additional ) throws Exception {

		BusinessLineRecord dao = new BusinessLineRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBusinessLineRecord( com.pomplatform.db.bean.BaseBusinessLineRecord bean, String additional ) throws Exception {

		BusinessLineRecord dao = new BusinessLineRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBusinessLineRecord> queryBusinessLineRecord( com.pomplatform.db.bean.BaseBusinessLineRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BusinessLineRecord dao = new BusinessLineRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBusinessLineRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBusinessLineRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBusinessLineRecord addToBusinessLineRecord ( BaseBusinessLineRecord businesslinerecord )  throws Exception {
		return addToBusinessLineRecord ( businesslinerecord , false);
	}

	public static BaseBusinessLineRecord addToBusinessLineRecord ( BaseBusinessLineRecord businesslinerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setDataFromBase(businesslinerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBusinessLineRecord addUpdateBusinessLineRecord ( BaseBusinessLineRecord businesslinerecord ) throws Exception {
		return addUpdateBusinessLineRecord ( businesslinerecord , false);
	}

	public static BaseBusinessLineRecord addUpdateBusinessLineRecord ( BaseBusinessLineRecord businesslinerecord, boolean singleTransaction  ) throws Exception {
		if(businesslinerecord.getBusinessLineRecordId() == null) return addToBusinessLineRecord(businesslinerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setDataFromBase(businesslinerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(businesslinerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBusinessLineRecord ( BaseBusinessLineRecord bean ) throws Exception {
		BusinessLineRecord dao = new BusinessLineRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBusinessLineRecord updateBusinessLineRecord ( BaseBusinessLineRecord businesslinerecord ) throws Exception {
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setBusinessLineRecordId( businesslinerecord.getBusinessLineRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(businesslinerecord);
			result = dao.update();
		}
		return result == 1 ? businesslinerecord : null ;
	}

	public static BaseBusinessLineRecord updateBusinessLineRecordDirect( BaseBusinessLineRecord businesslinerecord ) throws Exception {
		BusinessLineRecord dao = new BusinessLineRecord();
		int result = 0;
		dao.setDataFromBase(businesslinerecord);
		result = dao.update();
		return result == 1 ? businesslinerecord : null ;
	}

	public static int setDeleteConditions(BaseBusinessLineRecord bean, BusinessLineRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBusinessLineRecordId() != null) {
			dao.setConditionBusinessLineRecordId("=", bean.getBusinessLineRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessLineId() != null) {
				dao.setConditionBusinessLineId("=", bean.getBusinessLineId());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBusinessLineRecord bean, BusinessLineRecord dao){
		int count = 0;
		if(bean.getBusinessLineId() != null) {
			dao.setConditionBusinessLineId("=", bean.getBusinessLineId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getBusinessAmount() != null) {
			dao.setConditionBusinessAmount("=", bean.getBusinessAmount());
			count++;
		}
		if(bean.getBusinessLineRecordId() != null) {
			dao.setConditionBusinessLineRecordId("=", bean.getBusinessLineRecordId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		bean.setDataFromJSON(json);
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBusinessLineRecord> rlist = new BaseCollection<>();
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BusinessLineRecord dao = new BusinessLineRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBusinessLineRecord> result = dao.conditionalLoad(addtion);
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
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		bean.setDataFromJSON(json);
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		bean.setDataFromJSON(json);
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		bean.setDataFromJSON(json);
		BusinessLineRecord dao = new BusinessLineRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBusinessLineRecord bean = new BaseBusinessLineRecord();
		bean.setDataFromJSON(json);
		BusinessLineRecord dao = new BusinessLineRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


