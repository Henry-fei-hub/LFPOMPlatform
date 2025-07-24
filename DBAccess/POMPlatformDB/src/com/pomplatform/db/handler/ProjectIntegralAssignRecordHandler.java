package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectIntegralAssignRecord;
import com.pomplatform.db.dao.ProjectIntegralAssignRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectIntegralAssignRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectIntegralAssignRecordHandler.class);

	public static BaseProjectIntegralAssignRecord getProjectIntegralAssignRecordById( 
		java.lang.Integer project_integral_assign_record_id
	) throws Exception
	{
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setProjectIntegralAssignRecordId(project_integral_assign_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectIntegralAssignRecordExists( com.pomplatform.db.bean.BaseProjectIntegralAssignRecord bean, String additional ) throws Exception {

		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectIntegralAssignRecord( com.pomplatform.db.bean.BaseProjectIntegralAssignRecord bean, String additional ) throws Exception {

		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectIntegralAssignRecord> queryProjectIntegralAssignRecord( com.pomplatform.db.bean.BaseProjectIntegralAssignRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectIntegralAssignRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectIntegralAssignRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectIntegralAssignRecord addToProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord projectintegralassignrecord )  throws Exception {
		return addToProjectIntegralAssignRecord ( projectintegralassignrecord , false);
	}

	public static BaseProjectIntegralAssignRecord addToProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord projectintegralassignrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setDataFromBase(projectintegralassignrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectIntegralAssignRecord addUpdateProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord projectintegralassignrecord ) throws Exception {
		return addUpdateProjectIntegralAssignRecord ( projectintegralassignrecord , false);
	}

	public static BaseProjectIntegralAssignRecord addUpdateProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord projectintegralassignrecord, boolean singleTransaction  ) throws Exception {
		if(projectintegralassignrecord.getProjectIntegralAssignRecordId() == null) return addToProjectIntegralAssignRecord(projectintegralassignrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setDataFromBase(projectintegralassignrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectintegralassignrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord bean ) throws Exception {
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectIntegralAssignRecord updateProjectIntegralAssignRecord ( BaseProjectIntegralAssignRecord projectintegralassignrecord ) throws Exception {
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setProjectIntegralAssignRecordId( projectintegralassignrecord.getProjectIntegralAssignRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectintegralassignrecord);
			result = dao.update();
		}
		return result == 1 ? projectintegralassignrecord : null ;
	}

	public static BaseProjectIntegralAssignRecord updateProjectIntegralAssignRecordDirect( BaseProjectIntegralAssignRecord projectintegralassignrecord ) throws Exception {
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		int result = 0;
		dao.setDataFromBase(projectintegralassignrecord);
		result = dao.update();
		return result == 1 ? projectintegralassignrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectIntegralAssignRecord bean, ProjectIntegralAssignRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectIntegralAssignRecordId() != null) {
			dao.setConditionProjectIntegralAssignRecordId("=", bean.getProjectIntegralAssignRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getPlateEmployeeId() != null) {
				dao.setConditionPlateEmployeeId("=", bean.getPlateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectIntegralAssignRecord bean, ProjectIntegralAssignRecord dao){
		int count = 0;
		if(bean.getProjectIntegralAssignRecordId() != null) {
			dao.setConditionProjectIntegralAssignRecordId("=", bean.getProjectIntegralAssignRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getBeforeReserveIntegral() != null) {
			dao.setConditionBeforeReserveIntegral("=", bean.getBeforeReserveIntegral());
			count++;
		}
		if(bean.getAfterReserveIntegral() != null) {
			dao.setConditionAfterReserveIntegral("=", bean.getAfterReserveIntegral());
			count++;
		}
		if(bean.getAssignIntegral() != null) {
			dao.setConditionAssignIntegral("=", bean.getAssignIntegral());
			count++;
		}
		if(bean.getAssignDate() != null) {
			dao.setConditionAssignDate(">=", bean.getAssignDate());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getPlateEmployeeId() != null) {
			dao.setConditionPlateEmployeeId("=", bean.getPlateEmployeeId());
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
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectIntegralAssignRecord> rlist = new BaseCollection<>();
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectIntegralAssignRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectIntegralAssignRecord bean = new BaseProjectIntegralAssignRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralAssignRecord dao = new ProjectIntegralAssignRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


