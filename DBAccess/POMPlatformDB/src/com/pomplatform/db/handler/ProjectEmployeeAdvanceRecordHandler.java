package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectEmployeeAdvanceRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectEmployeeAdvanceRecordHandler.class);

	public static BaseProjectEmployeeAdvanceRecord getProjectEmployeeAdvanceRecordById( 
		java.lang.Integer project_employee_advance_record_id
	) throws Exception
	{
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setProjectEmployeeAdvanceRecordId(project_employee_advance_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectEmployeeAdvanceRecordExists( com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord bean, String additional ) throws Exception {

		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectEmployeeAdvanceRecord( com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord bean, String additional ) throws Exception {

		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectEmployeeAdvanceRecord> queryProjectEmployeeAdvanceRecord( com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectEmployeeAdvanceRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectEmployeeAdvanceRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectEmployeeAdvanceRecord addToProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord )  throws Exception {
		return addToProjectEmployeeAdvanceRecord ( projectemployeeadvancerecord , false);
	}

	public static BaseProjectEmployeeAdvanceRecord addToProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setDataFromBase(projectemployeeadvancerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectEmployeeAdvanceRecord addUpdateProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord ) throws Exception {
		return addUpdateProjectEmployeeAdvanceRecord ( projectemployeeadvancerecord , false);
	}

	public static BaseProjectEmployeeAdvanceRecord addUpdateProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord, boolean singleTransaction  ) throws Exception {
		if(projectemployeeadvancerecord.getProjectEmployeeAdvanceRecordId() == null) return addToProjectEmployeeAdvanceRecord(projectemployeeadvancerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setDataFromBase(projectemployeeadvancerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectemployeeadvancerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord bean ) throws Exception {
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectEmployeeAdvanceRecord updateProjectEmployeeAdvanceRecord ( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord ) throws Exception {
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setProjectEmployeeAdvanceRecordId( projectemployeeadvancerecord.getProjectEmployeeAdvanceRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectemployeeadvancerecord);
			result = dao.update();
		}
		return result == 1 ? projectemployeeadvancerecord : null ;
	}

	public static BaseProjectEmployeeAdvanceRecord updateProjectEmployeeAdvanceRecordDirect( BaseProjectEmployeeAdvanceRecord projectemployeeadvancerecord ) throws Exception {
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		int result = 0;
		dao.setDataFromBase(projectemployeeadvancerecord);
		result = dao.update();
		return result == 1 ? projectemployeeadvancerecord : null ;
	}

	public static int setDeleteConditions(BaseProjectEmployeeAdvanceRecord bean, ProjectEmployeeAdvanceRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectEmployeeAdvanceRecordId() != null) {
			dao.setConditionProjectEmployeeAdvanceRecordId("=", bean.getProjectEmployeeAdvanceRecordId());
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

	public static int setConditions(BaseProjectEmployeeAdvanceRecord bean, ProjectEmployeeAdvanceRecord dao){
		int count = 0;
		if(bean.getProjectEmployeeAdvanceRecordId() != null) {
			dao.setConditionProjectEmployeeAdvanceRecordId("=", bean.getProjectEmployeeAdvanceRecordId());
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
		if(bean.getAdvanceIntegral() != null) {
			dao.setConditionAdvanceIntegral("=", bean.getAdvanceIntegral());
			count++;
		}
		if(bean.getAdvancedIntegral() != null) {
			dao.setConditionAdvancedIntegral("=", bean.getAdvancedIntegral());
			count++;
		}
		if(bean.getAdvanceDate() != null) {
			dao.setConditionAdvanceDate(">=", bean.getAdvanceDate());
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
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectEmployeeAdvanceRecord> rlist = new BaseCollection<>();
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectEmployeeAdvanceRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectEmployeeAdvanceRecord bean = new BaseProjectEmployeeAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectEmployeeAdvanceRecord dao = new ProjectEmployeeAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


