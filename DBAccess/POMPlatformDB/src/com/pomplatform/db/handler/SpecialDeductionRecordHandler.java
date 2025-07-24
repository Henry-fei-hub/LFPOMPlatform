package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSpecialDeductionRecord;
import com.pomplatform.db.dao.SpecialDeductionRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SpecialDeductionRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionRecordHandler.class);

	public static BaseSpecialDeductionRecord getSpecialDeductionRecordById( 
		java.lang.Integer special_deduction_record_id
	) throws Exception
	{
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setSpecialDeductionRecordId(special_deduction_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSpecialDeductionRecordExists( com.pomplatform.db.bean.BaseSpecialDeductionRecord bean, String additional ) throws Exception {

		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSpecialDeductionRecord( com.pomplatform.db.bean.BaseSpecialDeductionRecord bean, String additional ) throws Exception {

		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSpecialDeductionRecord> querySpecialDeductionRecord( com.pomplatform.db.bean.BaseSpecialDeductionRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSpecialDeductionRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSpecialDeductionRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSpecialDeductionRecord addToSpecialDeductionRecord ( BaseSpecialDeductionRecord specialdeductionrecord )  throws Exception {
		return addToSpecialDeductionRecord ( specialdeductionrecord , false);
	}

	public static BaseSpecialDeductionRecord addToSpecialDeductionRecord ( BaseSpecialDeductionRecord specialdeductionrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setDataFromBase(specialdeductionrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSpecialDeductionRecord addUpdateSpecialDeductionRecord ( BaseSpecialDeductionRecord specialdeductionrecord ) throws Exception {
		return addUpdateSpecialDeductionRecord ( specialdeductionrecord , false);
	}

	public static BaseSpecialDeductionRecord addUpdateSpecialDeductionRecord ( BaseSpecialDeductionRecord specialdeductionrecord, boolean singleTransaction  ) throws Exception {
		if(specialdeductionrecord.getSpecialDeductionRecordId() == null) return addToSpecialDeductionRecord(specialdeductionrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setDataFromBase(specialdeductionrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(specialdeductionrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSpecialDeductionRecord ( BaseSpecialDeductionRecord bean ) throws Exception {
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSpecialDeductionRecord updateSpecialDeductionRecord ( BaseSpecialDeductionRecord specialdeductionrecord ) throws Exception {
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setSpecialDeductionRecordId( specialdeductionrecord.getSpecialDeductionRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(specialdeductionrecord);
			result = dao.update();
		}
		return result == 1 ? specialdeductionrecord : null ;
	}

	public static BaseSpecialDeductionRecord updateSpecialDeductionRecordDirect( BaseSpecialDeductionRecord specialdeductionrecord ) throws Exception {
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		int result = 0;
		dao.setDataFromBase(specialdeductionrecord);
		result = dao.update();
		return result == 1 ? specialdeductionrecord : null ;
	}

	public static int setDeleteConditions(BaseSpecialDeductionRecord bean, SpecialDeductionRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSpecialDeductionRecordId() != null) {
			dao.setConditionSpecialDeductionRecordId("=", bean.getSpecialDeductionRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeId() != null) {
				dao.setConditionEmployeId("=", bean.getEmployeId());
				count++;
			}
			if(bean.getEmployeeName() != null) {
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getDeparmentId() != null) {
				dao.setConditionDeparmentId("=", bean.getDeparmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSpecialDeductionRecord bean, SpecialDeductionRecord dao){
		int count = 0;
		if(bean.getSpecialDeductionRecordId() != null) {
			dao.setConditionSpecialDeductionRecordId("=", bean.getSpecialDeductionRecordId());
			count++;
		}
		if(bean.getEmployeId() != null) {
			dao.setConditionEmployeId("=", bean.getEmployeId());
			count++;
		}
		if(bean.getEmployeeName() != null) {
			if(bean.getEmployeeName().indexOf("%") >= 0)
				dao.setConditionEmployeeName("like", bean.getEmployeeName());
			else
				dao.setConditionEmployeeName("=", bean.getEmployeeName());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getDeparmentId() != null) {
			dao.setConditionDeparmentId("=", bean.getDeparmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		bean.setDataFromJSON(json);
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSpecialDeductionRecord> rlist = new BaseCollection<>();
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSpecialDeductionRecord> result = dao.conditionalLoad(addtion);
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
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		bean.setDataFromJSON(json);
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		bean.setDataFromJSON(json);
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		bean.setDataFromJSON(json);
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSpecialDeductionRecord bean = new BaseSpecialDeductionRecord();
		bean.setDataFromJSON(json);
		SpecialDeductionRecord dao = new SpecialDeductionRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


