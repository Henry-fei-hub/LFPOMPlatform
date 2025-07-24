package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectAdvanceRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectAdvanceRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectAdvanceRecordHandler.class);

	public static BaseProjectAdvanceRecord getProjectAdvanceRecordById( 
		java.lang.Integer project_advance_record_id
	) throws Exception
	{
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setProjectAdvanceRecordId(project_advance_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectAdvanceRecordExists( com.pomplatform.db.bean.BaseProjectAdvanceRecord bean, String additional ) throws Exception {

		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectAdvanceRecord( com.pomplatform.db.bean.BaseProjectAdvanceRecord bean, String additional ) throws Exception {

		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectAdvanceRecord> queryProjectAdvanceRecord( com.pomplatform.db.bean.BaseProjectAdvanceRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectAdvanceRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectAdvanceRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectAdvanceRecord addToProjectAdvanceRecord ( BaseProjectAdvanceRecord projectadvancerecord )  throws Exception {
		return addToProjectAdvanceRecord ( projectadvancerecord , false);
	}

	public static BaseProjectAdvanceRecord addToProjectAdvanceRecord ( BaseProjectAdvanceRecord projectadvancerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setDataFromBase(projectadvancerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectAdvanceRecord addUpdateProjectAdvanceRecord ( BaseProjectAdvanceRecord projectadvancerecord ) throws Exception {
		return addUpdateProjectAdvanceRecord ( projectadvancerecord , false);
	}

	public static BaseProjectAdvanceRecord addUpdateProjectAdvanceRecord ( BaseProjectAdvanceRecord projectadvancerecord, boolean singleTransaction  ) throws Exception {
		if(projectadvancerecord.getProjectAdvanceRecordId() == null) return addToProjectAdvanceRecord(projectadvancerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setDataFromBase(projectadvancerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectadvancerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectAdvanceRecord ( BaseProjectAdvanceRecord bean ) throws Exception {
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectAdvanceRecord updateProjectAdvanceRecord ( BaseProjectAdvanceRecord projectadvancerecord ) throws Exception {
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setProjectAdvanceRecordId( projectadvancerecord.getProjectAdvanceRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectadvancerecord);
			result = dao.update();
		}
		return result == 1 ? projectadvancerecord : null ;
	}

	public static BaseProjectAdvanceRecord updateProjectAdvanceRecordDirect( BaseProjectAdvanceRecord projectadvancerecord ) throws Exception {
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		int result = 0;
		dao.setDataFromBase(projectadvancerecord);
		result = dao.update();
		return result == 1 ? projectadvancerecord : null ;
	}

	public static int setDeleteConditions(BaseProjectAdvanceRecord bean, ProjectAdvanceRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectAdvanceRecordId() != null) {
			dao.setConditionProjectAdvanceRecordId("=", bean.getProjectAdvanceRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
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
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectAdvanceRecord bean, ProjectAdvanceRecord dao){
		int count = 0;
		if(bean.getProjectAdvanceRecordId() != null) {
			dao.setConditionProjectAdvanceRecordId("=", bean.getProjectAdvanceRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getAdvanceIntegral() != null) {
			dao.setConditionAdvanceIntegral("=", bean.getAdvanceIntegral());
			count++;
		}
		if(bean.getLeftIntegral() != null) {
			dao.setConditionLeftIntegral("=", bean.getLeftIntegral());
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
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectAdvanceRecord> rlist = new BaseCollection<>();
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectAdvanceRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectAdvanceRecord bean = new BaseProjectAdvanceRecord();
		bean.setDataFromJSON(json);
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


