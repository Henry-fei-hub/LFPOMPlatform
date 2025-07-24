package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProjectStageProcessRecord;
import java.util.List;
import com.pomplatform.db.dao.ProjectStageProcessRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProjectStageProcessRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectStageProcessRecordHandler.class);

	public static BaseProjectStageProcessRecord getProjectStageProcessRecordById( 
		java.lang.Integer project_stage_process_record_id
	) throws Exception
	{
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setProjectStageProcessRecordId(project_stage_process_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectStageProcessRecordExists( com.pomplatform.db.bean.BaseProjectStageProcessRecord bean, String additional ) throws Exception {

		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectStageProcessRecord( com.pomplatform.db.bean.BaseProjectStageProcessRecord bean, String additional ) throws Exception {

		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectStageProcessRecord> queryProjectStageProcessRecord( com.pomplatform.db.bean.BaseProjectStageProcessRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectStageProcessRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectStageProcessRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectStageProcessRecord addToProjectStageProcessRecord ( BaseProjectStageProcessRecord projectstageprocessrecord )  throws Exception {
		return addToProjectStageProcessRecord ( projectstageprocessrecord , false);
	}

	public static BaseProjectStageProcessRecord addToProjectStageProcessRecord ( BaseProjectStageProcessRecord projectstageprocessrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setDataFromBase(projectstageprocessrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectStageProcessRecord addUpdateProjectStageProcessRecord ( BaseProjectStageProcessRecord projectstageprocessrecord ) throws Exception {
		return addUpdateProjectStageProcessRecord ( projectstageprocessrecord , false);
	}

	public static BaseProjectStageProcessRecord addUpdateProjectStageProcessRecord ( BaseProjectStageProcessRecord projectstageprocessrecord, boolean singleTransaction  ) throws Exception {
		if(projectstageprocessrecord.getProjectStageProcessRecordId() == null) return addToProjectStageProcessRecord(projectstageprocessrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setDataFromBase(projectstageprocessrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectstageprocessrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectStageProcessRecord ( BaseProjectStageProcessRecord bean ) throws Exception {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectStageProcessRecord updateProjectStageProcessRecord ( BaseProjectStageProcessRecord projectstageprocessrecord ) throws Exception {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setProjectStageProcessRecordId( projectstageprocessrecord.getProjectStageProcessRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectstageprocessrecord);
			result = dao.update();
		}
		return result == 1 ? projectstageprocessrecord : null ;
	}

	public static BaseProjectStageProcessRecord updateProjectStageProcessRecordDirect( BaseProjectStageProcessRecord projectstageprocessrecord ) throws Exception {
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		int result = 0;
		dao.setDataFromBase(projectstageprocessrecord);
		result = dao.update();
		return result == 1 ? projectstageprocessrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectStageProcessRecord bean, ProjectStageProcessRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectStageProcessRecordId() != null) {
			dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getFileId() != null) {
				dao.setConditionFileId("=", bean.getFileId());
				count++;
			}
			if(bean.getFileUrl() != null) {
				dao.setConditionFileUrl("=", bean.getFileUrl());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectStageProcessRecord bean, ProjectStageProcessRecord dao){
		int count = 0;
		if(bean.getProjectStageProcessRecordId() != null) {
			dao.setConditionProjectStageProcessRecordId("=", bean.getProjectStageProcessRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectAmountSum() != null) {
			dao.setConditionProjectAmountSum("=", bean.getProjectAmountSum());
			count++;
		}
		if(bean.getApplyAmount() != null) {
			dao.setConditionApplyAmount("=", bean.getApplyAmount());
			count++;
		}
		if(bean.getFileId() != null) {
			dao.setConditionFileId("=", bean.getFileId());
			count++;
		}
		if(bean.getFileUrl() != null) {
			if(bean.getFileUrl().indexOf("%") >= 0)
				dao.setConditionFileUrl("like", bean.getFileUrl());
			else
				dao.setConditionFileUrl("=", bean.getFileUrl());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getCurrentApplyRate() != null) {
			dao.setConditionCurrentApplyRate("=", bean.getCurrentApplyRate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectStageProcessRecord> rlist = new BaseCollection<>();
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectStageProcessRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectStageProcessRecord bean = new BaseProjectStageProcessRecord();
		bean.setDataFromJSON(json);
		ProjectStageProcessRecord dao = new ProjectStageProcessRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


