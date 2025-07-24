package com.pomplatform.db.handler;

import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectIntegralTransferRecord;
import com.pomplatform.db.dao.ProjectIntegralTransferRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;

public class ProjectIntegralTransferRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectIntegralTransferRecordHandler.class);

	public static BaseProjectIntegralTransferRecord getProjectIntegralTransferRecordById( 
		java.lang.Integer project_integral_transfer_record_id
	) throws Exception
	{
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setProjectIntegralTransferRecordId(project_integral_transfer_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectIntegralTransferRecordExists( com.pomplatform.db.bean.BaseProjectIntegralTransferRecord bean, String additional ) throws Exception {

		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectIntegralTransferRecord( com.pomplatform.db.bean.BaseProjectIntegralTransferRecord bean, String additional ) throws Exception {

		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectIntegralTransferRecord> queryProjectIntegralTransferRecord( com.pomplatform.db.bean.BaseProjectIntegralTransferRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectIntegralTransferRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectIntegralTransferRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectIntegralTransferRecord addToProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord projectintegraltransferrecord )  throws Exception {
		return addToProjectIntegralTransferRecord ( projectintegraltransferrecord , false);
	}

	public static BaseProjectIntegralTransferRecord addToProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord projectintegraltransferrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setDataFromBase(projectintegraltransferrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectIntegralTransferRecord addUpdateProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord projectintegraltransferrecord ) throws Exception {
		return addUpdateProjectIntegralTransferRecord ( projectintegraltransferrecord , false);
	}

	public static BaseProjectIntegralTransferRecord addUpdateProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord projectintegraltransferrecord, boolean singleTransaction  ) throws Exception {
		if(projectintegraltransferrecord.getProjectIntegralTransferRecordId() == null) return addToProjectIntegralTransferRecord(projectintegraltransferrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setDataFromBase(projectintegraltransferrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectintegraltransferrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord bean ) throws Exception {
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectIntegralTransferRecord updateProjectIntegralTransferRecord ( BaseProjectIntegralTransferRecord projectintegraltransferrecord ) throws Exception {
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setProjectIntegralTransferRecordId( projectintegraltransferrecord.getProjectIntegralTransferRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectintegraltransferrecord);
			result = dao.update();
		}
		return result == 1 ? projectintegraltransferrecord : null ;
	}

	public static BaseProjectIntegralTransferRecord updateProjectIntegralTransferRecordDirect( BaseProjectIntegralTransferRecord projectintegraltransferrecord ) throws Exception {
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		int result = 0;
		dao.setDataFromBase(projectintegraltransferrecord);
		result = dao.update();
		return result == 1 ? projectintegraltransferrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectIntegralTransferRecord bean, ProjectIntegralTransferRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectIntegralTransferRecordId() != null) {
			dao.setConditionProjectIntegralTransferRecordId("=", bean.getProjectIntegralTransferRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFromProjectId() != null) {
				dao.setConditionFromProjectId("=", bean.getFromProjectId());
				count++;
			}
			if(bean.getToProjectId() != null) {
				dao.setConditionToProjectId("=", bean.getToProjectId());
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

	public static int setConditions(BaseProjectIntegralTransferRecord bean, ProjectIntegralTransferRecord dao){
		int count = 0;
		if(bean.getProjectIntegralTransferRecordId() != null) {
			dao.setConditionProjectIntegralTransferRecordId("=", bean.getProjectIntegralTransferRecordId());
			count++;
		}
		if(bean.getFromProjectId() != null) {
			dao.setConditionFromProjectId("=", bean.getFromProjectId());
			count++;
		}
		if(bean.getToProjectId() != null) {
			dao.setConditionToProjectId("=", bean.getToProjectId());
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
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectIntegralTransferRecord> rlist = new BaseCollection<>();
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectIntegralTransferRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectIntegralTransferRecord bean = new BaseProjectIntegralTransferRecord();
		bean.setDataFromJSON(json);
		ProjectIntegralTransferRecord dao = new ProjectIntegralTransferRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


