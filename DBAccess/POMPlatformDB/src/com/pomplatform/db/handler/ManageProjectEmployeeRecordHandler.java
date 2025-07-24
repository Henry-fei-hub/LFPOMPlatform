package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;
import com.pomplatform.db.dao.ManageProjectEmployeeRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ManageProjectEmployeeRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ManageProjectEmployeeRecordHandler.class);

	public static BaseManageProjectEmployeeRecord getManageProjectEmployeeRecordById( 
		java.lang.Integer manage_project_employee_record_id
	) throws Exception
	{
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setManageProjectEmployeeRecordId(manage_project_employee_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isManageProjectEmployeeRecordExists( com.pomplatform.db.bean.BaseManageProjectEmployeeRecord bean, String additional ) throws Exception {

		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countManageProjectEmployeeRecord( com.pomplatform.db.bean.BaseManageProjectEmployeeRecord bean, String additional ) throws Exception {

		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseManageProjectEmployeeRecord> queryManageProjectEmployeeRecord( com.pomplatform.db.bean.BaseManageProjectEmployeeRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseManageProjectEmployeeRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseManageProjectEmployeeRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseManageProjectEmployeeRecord addToManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord manageprojectemployeerecord )  throws Exception {
		return addToManageProjectEmployeeRecord ( manageprojectemployeerecord , false);
	}

	public static BaseManageProjectEmployeeRecord addToManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord manageprojectemployeerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setDataFromBase(manageprojectemployeerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseManageProjectEmployeeRecord addUpdateManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord manageprojectemployeerecord ) throws Exception {
		return addUpdateManageProjectEmployeeRecord ( manageprojectemployeerecord , false);
	}

	public static BaseManageProjectEmployeeRecord addUpdateManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord manageprojectemployeerecord, boolean singleTransaction  ) throws Exception {
		if(manageprojectemployeerecord.getManageProjectEmployeeRecordId() == null) return addToManageProjectEmployeeRecord(manageprojectemployeerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setDataFromBase(manageprojectemployeerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(manageprojectemployeerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord bean ) throws Exception {
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseManageProjectEmployeeRecord updateManageProjectEmployeeRecord ( BaseManageProjectEmployeeRecord manageprojectemployeerecord ) throws Exception {
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setManageProjectEmployeeRecordId( manageprojectemployeerecord.getManageProjectEmployeeRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(manageprojectemployeerecord);
			result = dao.update();
		}
		return result == 1 ? manageprojectemployeerecord : null ;
	}

	public static BaseManageProjectEmployeeRecord updateManageProjectEmployeeRecordDirect( BaseManageProjectEmployeeRecord manageprojectemployeerecord ) throws Exception {
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		int result = 0;
		dao.setDataFromBase(manageprojectemployeerecord);
		result = dao.update();
		return result == 1 ? manageprojectemployeerecord : null ;
	}

	public static int setDeleteConditions(BaseManageProjectEmployeeRecord bean, ManageProjectEmployeeRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getManageProjectEmployeeRecordId() != null) {
			dao.setConditionManageProjectEmployeeRecordId("=", bean.getManageProjectEmployeeRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getManageProjectId() != null) {
				dao.setConditionManageProjectId("=", bean.getManageProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsReturn() != null) {
				dao.setConditionIsReturn("=", bean.getIsReturn());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseManageProjectEmployeeRecord bean, ManageProjectEmployeeRecord dao){
		int count = 0;
		if(bean.getManageProjectEmployeeRecordId() != null) {
			dao.setConditionManageProjectEmployeeRecordId("=", bean.getManageProjectEmployeeRecordId());
			count++;
		}
		if(bean.getManageProjectId() != null) {
			dao.setConditionManageProjectId("=", bean.getManageProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getAssignIntegral() != null) {
			dao.setConditionAssignIntegral("=", bean.getAssignIntegral());
			count++;
		}
		if(bean.getAssignedIntegral() != null) {
			dao.setConditionAssignedIntegral("=", bean.getAssignedIntegral());
			count++;
		}
		if(bean.getAssignDate() != null) {
			dao.setConditionAssignDate(">=", bean.getAssignDate());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsReturn() != null) {
			dao.setConditionIsReturn("=", bean.getIsReturn());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		bean.setDataFromJSON(json);
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseManageProjectEmployeeRecord> rlist = new BaseCollection<>();
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseManageProjectEmployeeRecord> result = dao.conditionalLoad(addtion);
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
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		bean.setDataFromJSON(json);
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		bean.setDataFromJSON(json);
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		bean.setDataFromJSON(json);
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseManageProjectEmployeeRecord bean = new BaseManageProjectEmployeeRecord();
		bean.setDataFromJSON(json);
		ManageProjectEmployeeRecord dao = new ManageProjectEmployeeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


