package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectCodeRecord;
import com.pomplatform.db.dao.ProjectCodeRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectCodeRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectCodeRecordHandler.class);

	public static BaseProjectCodeRecord getProjectCodeRecordById( 
		java.lang.Integer project_code_record_id
	) throws Exception
	{
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setProjectCodeRecordId(project_code_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectCodeRecordExists( com.pomplatform.db.bean.BaseProjectCodeRecord bean, String additional ) throws Exception {

		ProjectCodeRecord dao = new ProjectCodeRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectCodeRecord( com.pomplatform.db.bean.BaseProjectCodeRecord bean, String additional ) throws Exception {

		ProjectCodeRecord dao = new ProjectCodeRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectCodeRecord> queryProjectCodeRecord( com.pomplatform.db.bean.BaseProjectCodeRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectCodeRecord dao = new ProjectCodeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectCodeRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectCodeRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectCodeRecord addToProjectCodeRecord ( BaseProjectCodeRecord projectcoderecord )  throws Exception {
		return addToProjectCodeRecord ( projectcoderecord , false);
	}

	public static BaseProjectCodeRecord addToProjectCodeRecord ( BaseProjectCodeRecord projectcoderecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setDataFromBase(projectcoderecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectCodeRecord addUpdateProjectCodeRecord ( BaseProjectCodeRecord projectcoderecord ) throws Exception {
		return addUpdateProjectCodeRecord ( projectcoderecord , false);
	}

	public static BaseProjectCodeRecord addUpdateProjectCodeRecord ( BaseProjectCodeRecord projectcoderecord, boolean singleTransaction  ) throws Exception {
		if(projectcoderecord.getProjectCodeRecordId() == null) return addToProjectCodeRecord(projectcoderecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setDataFromBase(projectcoderecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectcoderecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectCodeRecord ( BaseProjectCodeRecord bean ) throws Exception {
		ProjectCodeRecord dao = new ProjectCodeRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectCodeRecord updateProjectCodeRecord ( BaseProjectCodeRecord projectcoderecord ) throws Exception {
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setProjectCodeRecordId( projectcoderecord.getProjectCodeRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectcoderecord);
			result = dao.update();
		}
		return result == 1 ? projectcoderecord : null ;
	}

	public static BaseProjectCodeRecord updateProjectCodeRecordDirect( BaseProjectCodeRecord projectcoderecord ) throws Exception {
		ProjectCodeRecord dao = new ProjectCodeRecord();
		int result = 0;
		dao.setDataFromBase(projectcoderecord);
		result = dao.update();
		return result == 1 ? projectcoderecord : null ;
	}

	public static int setDeleteConditions(BaseProjectCodeRecord bean, ProjectCodeRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectCodeRecordId() != null) {
			dao.setConditionProjectCodeRecordId("=", bean.getProjectCodeRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
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
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
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
			if(bean.getProjectFlag() != null) {
				dao.setConditionProjectFlag("=", bean.getProjectFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectCodeRecord bean, ProjectCodeRecord dao){
		int count = 0;
		if(bean.getProjectCodeRecordId() != null) {
			dao.setConditionProjectCodeRecordId("=", bean.getProjectCodeRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
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
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
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
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProjectFlag() != null) {
			dao.setConditionProjectFlag("=", bean.getProjectFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		bean.setDataFromJSON(json);
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectCodeRecord> rlist = new BaseCollection<>();
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectCodeRecord dao = new ProjectCodeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectCodeRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		bean.setDataFromJSON(json);
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		bean.setDataFromJSON(json);
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		bean.setDataFromJSON(json);
		ProjectCodeRecord dao = new ProjectCodeRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
		bean.setDataFromJSON(json);
		ProjectCodeRecord dao = new ProjectCodeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


