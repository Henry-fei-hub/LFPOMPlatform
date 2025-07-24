package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectIntegralChangeRecord;
import com.pomplatform.db.dao.ProjectIntegralChangeRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectIntegralChangeRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectIntegralChangeRecordHandler.class);

	public static BaseProjectIntegralChangeRecord getProjectIntegralChangeRecordById( 
		java.lang.Integer project_integral_change_record_id
	) throws Exception
	{
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setProjectIntegralChangeRecordId(project_integral_change_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectIntegralChangeRecordExists( com.pomplatform.db.bean.BaseProjectIntegralChangeRecord bean, String additional ) throws Exception {

		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectIntegralChangeRecord( com.pomplatform.db.bean.BaseProjectIntegralChangeRecord bean, String additional ) throws Exception {

		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectIntegralChangeRecord> queryProjectIntegralChangeRecord( com.pomplatform.db.bean.BaseProjectIntegralChangeRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectIntegralChangeRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectIntegralChangeRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectIntegralChangeRecord addToProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord projectintegralchangerecord )  throws Exception {
		return addToProjectIntegralChangeRecord ( projectintegralchangerecord , false);
	}

	public static BaseProjectIntegralChangeRecord addToProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord projectintegralchangerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setDataFromBase(projectintegralchangerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectIntegralChangeRecord addUpdateProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord projectintegralchangerecord ) throws Exception {
		return addUpdateProjectIntegralChangeRecord ( projectintegralchangerecord , false);
	}

	public static BaseProjectIntegralChangeRecord addUpdateProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord projectintegralchangerecord, boolean singleTransaction  ) throws Exception {
		if(projectintegralchangerecord.getProjectIntegralChangeRecordId() == null) return addToProjectIntegralChangeRecord(projectintegralchangerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setDataFromBase(projectintegralchangerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectintegralchangerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord bean ) throws Exception {
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectIntegralChangeRecord updateProjectIntegralChangeRecord ( BaseProjectIntegralChangeRecord projectintegralchangerecord ) throws Exception {
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setProjectIntegralChangeRecordId( projectintegralchangerecord.getProjectIntegralChangeRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectintegralchangerecord);
			result = dao.update();
		}
		return result == 1 ? projectintegralchangerecord : null ;
	}

	public static BaseProjectIntegralChangeRecord updateProjectIntegralChangeRecordDirect( BaseProjectIntegralChangeRecord projectintegralchangerecord ) throws Exception {
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		int result = 0;
		dao.setDataFromBase(projectintegralchangerecord);
		result = dao.update();
		return result == 1 ? projectintegralchangerecord : null ;
	}

	public static int setDeleteConditions(BaseProjectIntegralChangeRecord bean, ProjectIntegralChangeRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectIntegralChangeRecordId() != null) {
			dao.setConditionProjectIntegralChangeRecordId("=", bean.getProjectIntegralChangeRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
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

	public static int setConditions(BaseProjectIntegralChangeRecord bean, ProjectIntegralChangeRecord dao){
		int count = 0;
		if(bean.getProjectIntegralChangeRecordId() != null) {
			dao.setConditionProjectIntegralChangeRecordId("=", bean.getProjectIntegralChangeRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getBeforeProjectIntegral() != null) {
			dao.setConditionBeforeProjectIntegral("=", bean.getBeforeProjectIntegral());
			count++;
		}
		if(bean.getAfterProjectIntegral() != null) {
			dao.setConditionAfterProjectIntegral("=", bean.getAfterProjectIntegral());
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
		if(bean.getTransferIntegral() != null) {
			dao.setConditionTransferIntegral("=", bean.getTransferIntegral());
			count++;
		}
		if(bean.getTransferDate() != null) {
			dao.setConditionTransferDate(">=", bean.getTransferDate());
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
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectIntegralChangeRecord> rlist = new BaseCollection<>();
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectIntegralChangeRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectIntegralChangeRecord bean = new BaseProjectIntegralChangeRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralChangeRecord dao = new ProjectIntegralChangeRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


