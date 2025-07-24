package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseApproveProjectStageStorage;
import com.pomplatform.db.dao.ApproveProjectStageStorage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ApproveProjectStageStorageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ApproveProjectStageStorageHandler.class);

	public static BaseApproveProjectStageStorage getApproveProjectStageStorageById( 
		java.lang.Integer approve_project_stage_storage_id
	) throws Exception
	{
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setApproveProjectStageStorageId(approve_project_stage_storage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isApproveProjectStageStorageExists( com.pomplatform.db.bean.BaseApproveProjectStageStorage bean, String additional ) throws Exception {

		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countApproveProjectStageStorage( com.pomplatform.db.bean.BaseApproveProjectStageStorage bean, String additional ) throws Exception {

		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseApproveProjectStageStorage> queryApproveProjectStageStorage( com.pomplatform.db.bean.BaseApproveProjectStageStorage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseApproveProjectStageStorage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseApproveProjectStageStorage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseApproveProjectStageStorage addToApproveProjectStageStorage ( BaseApproveProjectStageStorage approveprojectstagestorage )  throws Exception {
		return addToApproveProjectStageStorage ( approveprojectstagestorage , false);
	}

	public static BaseApproveProjectStageStorage addToApproveProjectStageStorage ( BaseApproveProjectStageStorage approveprojectstagestorage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setDataFromBase(approveprojectstagestorage);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseApproveProjectStageStorage addUpdateApproveProjectStageStorage ( BaseApproveProjectStageStorage approveprojectstagestorage ) throws Exception {
		return addUpdateApproveProjectStageStorage ( approveprojectstagestorage , false);
	}

	public static BaseApproveProjectStageStorage addUpdateApproveProjectStageStorage ( BaseApproveProjectStageStorage approveprojectstagestorage, boolean singleTransaction  ) throws Exception {
		if(approveprojectstagestorage.getApproveProjectStageStorageId() == null) return addToApproveProjectStageStorage(approveprojectstagestorage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setDataFromBase(approveprojectstagestorage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(approveprojectstagestorage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteApproveProjectStageStorage ( BaseApproveProjectStageStorage bean ) throws Exception {
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseApproveProjectStageStorage updateApproveProjectStageStorage ( BaseApproveProjectStageStorage approveprojectstagestorage ) throws Exception {
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setApproveProjectStageStorageId( approveprojectstagestorage.getApproveProjectStageStorageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(approveprojectstagestorage);
			result = dao.update();
		}
		return result == 1 ? approveprojectstagestorage : null ;
	}

	public static BaseApproveProjectStageStorage updateApproveProjectStageStorageDirect( BaseApproveProjectStageStorage approveprojectstagestorage ) throws Exception {
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		int result = 0;
		dao.setDataFromBase(approveprojectstagestorage);
		result = dao.update();
		return result == 1 ? approveprojectstagestorage : null ;
	}

	public static int setDeleteConditions(BaseApproveProjectStageStorage bean, ApproveProjectStageStorage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getApproveProjectStageStorageId() != null) {
			dao.setConditionApproveProjectStageStorageId("=", bean.getApproveProjectStageStorageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getPlateManagerId() != null) {
				dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
				count++;
			}
			if(bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseApproveProjectStageStorage bean, ApproveProjectStageStorage dao){
		int count = 0;
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getPlateManagerId() != null) {
			dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
			count++;
		}
		if(bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if(bean.getApproveProjectStageStorageId() != null) {
			dao.setConditionApproveProjectStageStorageId("=", bean.getApproveProjectStageStorageId());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseApproveProjectStageStorage> rlist = new BaseCollection<>();
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseApproveProjectStageStorage> result = dao.conditionalLoad(addtion);
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
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseApproveProjectStageStorage bean = new BaseApproveProjectStageStorage();
		bean.setDataFromJSON(json);
		ApproveProjectStageStorage dao = new ApproveProjectStageStorage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


