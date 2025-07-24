package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord;
import com.pomplatform.db.dao.ProjectEmployeeIntegralRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectEmployeeIntegralRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeIntegralRecordHandler.class);

	public static BaseProjectEmployeeIntegralRecord getProjectEmployeeIntegralRecordById( 
		java.lang.Integer project_employee_integral_record_id
	) throws Exception
	{
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setProjectEmployeeIntegralRecordId(project_employee_integral_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectEmployeeIntegralRecordExists( com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord bean, String additional ) throws Exception {

		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectEmployeeIntegralRecord( com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord bean, String additional ) throws Exception {

		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectEmployeeIntegralRecord> queryProjectEmployeeIntegralRecord( com.pomplatform.db.bean.BaseProjectEmployeeIntegralRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectEmployeeIntegralRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectEmployeeIntegralRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectEmployeeIntegralRecord addToProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord )  throws Exception {
		return addToProjectEmployeeIntegralRecord ( projectemployeeintegralrecord , false);
	}

	public static BaseProjectEmployeeIntegralRecord addToProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setDataFromBase(projectemployeeintegralrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectEmployeeIntegralRecord addUpdateProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord ) throws Exception {
		return addUpdateProjectEmployeeIntegralRecord ( projectemployeeintegralrecord , false);
	}

	public static BaseProjectEmployeeIntegralRecord addUpdateProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord, boolean singleTransaction  ) throws Exception {
		if(projectemployeeintegralrecord.getProjectEmployeeIntegralRecordId() == null) return addToProjectEmployeeIntegralRecord(projectemployeeintegralrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setDataFromBase(projectemployeeintegralrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectemployeeintegralrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord bean ) throws Exception {
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectEmployeeIntegralRecord updateProjectEmployeeIntegralRecord ( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord ) throws Exception {
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setProjectEmployeeIntegralRecordId( projectemployeeintegralrecord.getProjectEmployeeIntegralRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectemployeeintegralrecord);
			result = dao.update();
		}
		return result == 1 ? projectemployeeintegralrecord : null ;
	}

	public static BaseProjectEmployeeIntegralRecord updateProjectEmployeeIntegralRecordDirect( BaseProjectEmployeeIntegralRecord projectemployeeintegralrecord ) throws Exception {
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		int result = 0;
		dao.setDataFromBase(projectemployeeintegralrecord);
		result = dao.update();
		return result == 1 ? projectemployeeintegralrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectEmployeeIntegralRecord bean, ProjectEmployeeIntegralRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectEmployeeIntegralRecordId() != null) {
			dao.setConditionProjectEmployeeIntegralRecordId("=", bean.getProjectEmployeeIntegralRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getStageId() != null) {
				dao.setConditionStageId("=", bean.getStageId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectEmployeeIntegralRecord bean, ProjectEmployeeIntegralRecord dao){
		int count = 0;
		if(bean.getProjectEmployeeIntegralRecordId() != null) {
			dao.setConditionProjectEmployeeIntegralRecordId("=", bean.getProjectEmployeeIntegralRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getStageId() != null) {
			dao.setConditionStageId("=", bean.getStageId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getInputSureIntegral() != null) {
			dao.setConditionInputSureIntegral("=", bean.getInputSureIntegral());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getSureDate() != null) {
			dao.setConditionSureDate(">=", bean.getSureDate());
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
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectEmployeeIntegralRecord> rlist = new BaseCollection<>();
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectEmployeeIntegralRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectEmployeeIntegralRecord bean = new BaseProjectEmployeeIntegralRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeIntegralRecord dao = new ProjectEmployeeIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


