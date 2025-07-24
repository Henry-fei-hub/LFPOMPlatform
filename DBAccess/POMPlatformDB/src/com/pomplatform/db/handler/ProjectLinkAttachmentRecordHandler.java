package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectLinkAttachmentRecord;
import com.pomplatform.db.dao.ProjectLinkAttachmentRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectLinkAttachmentRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectLinkAttachmentRecordHandler.class);

	public static BaseProjectLinkAttachmentRecord getProjectLinkAttachmentRecordById( 
		java.lang.Integer project_link_attachment_record_id
	) throws Exception
	{
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setProjectLinkAttachmentRecordId(project_link_attachment_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectLinkAttachmentRecordExists( com.pomplatform.db.bean.BaseProjectLinkAttachmentRecord bean, String additional ) throws Exception {

		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectLinkAttachmentRecord( com.pomplatform.db.bean.BaseProjectLinkAttachmentRecord bean, String additional ) throws Exception {

		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectLinkAttachmentRecord> queryProjectLinkAttachmentRecord( com.pomplatform.db.bean.BaseProjectLinkAttachmentRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectLinkAttachmentRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectLinkAttachmentRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectLinkAttachmentRecord addToProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord )  throws Exception {
		return addToProjectLinkAttachmentRecord ( projectlinkattachmentrecord , false);
	}

	public static BaseProjectLinkAttachmentRecord addToProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setDataFromBase(projectlinkattachmentrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectLinkAttachmentRecord addUpdateProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord ) throws Exception {
		return addUpdateProjectLinkAttachmentRecord ( projectlinkattachmentrecord , false);
	}

	public static BaseProjectLinkAttachmentRecord addUpdateProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord, boolean singleTransaction  ) throws Exception {
		if(projectlinkattachmentrecord.getProjectLinkAttachmentRecordId() == null) return addToProjectLinkAttachmentRecord(projectlinkattachmentrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setDataFromBase(projectlinkattachmentrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectlinkattachmentrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord bean ) throws Exception {
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectLinkAttachmentRecord updateProjectLinkAttachmentRecord ( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord ) throws Exception {
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setProjectLinkAttachmentRecordId( projectlinkattachmentrecord.getProjectLinkAttachmentRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectlinkattachmentrecord);
			result = dao.update();
		}
		return result == 1 ? projectlinkattachmentrecord : null ;
	}

	public static BaseProjectLinkAttachmentRecord updateProjectLinkAttachmentRecordDirect( BaseProjectLinkAttachmentRecord projectlinkattachmentrecord ) throws Exception {
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		int result = 0;
		dao.setDataFromBase(projectlinkattachmentrecord);
		result = dao.update();
		return result == 1 ? projectlinkattachmentrecord : null ;
	}

	public static int setDeleteConditions(BaseProjectLinkAttachmentRecord bean, ProjectLinkAttachmentRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectLinkAttachmentRecordId() != null) {
			dao.setConditionProjectLinkAttachmentRecordId("=", bean.getProjectLinkAttachmentRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
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
			if(bean.getAttachmentManageId() != null) {
				dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getSheetCode() != null) {
				dao.setConditionSheetCode("=", bean.getSheetCode());
				count++;
			}
			if(bean.getSheetName() != null) {
				dao.setConditionSheetName("=", bean.getSheetName());
				count++;
			}
			if(bean.getAttachmentCode() != null) {
				dao.setConditionAttachmentCode("=", bean.getAttachmentCode());
				count++;
			}
			if(bean.getAttachmentName() != null) {
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
				count++;
			}
			if(bean.getAttachmentAddress() != null) {
				dao.setConditionAttachmentAddress("=", bean.getAttachmentAddress());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
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
		}
		return count;
	}

	public static int setConditions(BaseProjectLinkAttachmentRecord bean, ProjectLinkAttachmentRecord dao){
		int count = 0;
		if(bean.getProjectLinkAttachmentRecordId() != null) {
			dao.setConditionProjectLinkAttachmentRecordId("=", bean.getProjectLinkAttachmentRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
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
		if(bean.getAttachmentManageId() != null) {
			dao.setConditionAttachmentManageId("=", bean.getAttachmentManageId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getSheetCode() != null) {
			if(bean.getSheetCode().indexOf("%") >= 0)
				dao.setConditionSheetCode("like", bean.getSheetCode());
			else
				dao.setConditionSheetCode("=", bean.getSheetCode());
			count++;
		}
		if(bean.getSheetName() != null) {
			if(bean.getSheetName().indexOf("%") >= 0)
				dao.setConditionSheetName("like", bean.getSheetName());
			else
				dao.setConditionSheetName("=", bean.getSheetName());
			count++;
		}
		if(bean.getAttachmentCode() != null) {
			if(bean.getAttachmentCode().indexOf("%") >= 0)
				dao.setConditionAttachmentCode("like", bean.getAttachmentCode());
			else
				dao.setConditionAttachmentCode("=", bean.getAttachmentCode());
			count++;
		}
		if(bean.getAttachmentName() != null) {
			if(bean.getAttachmentName().indexOf("%") >= 0)
				dao.setConditionAttachmentName("like", bean.getAttachmentName());
			else
				dao.setConditionAttachmentName("=", bean.getAttachmentName());
			count++;
		}
		if(bean.getAttachmentAddress() != null) {
			if(bean.getAttachmentAddress().indexOf("%") >= 0)
				dao.setConditionAttachmentAddress("like", bean.getAttachmentAddress());
			else
				dao.setConditionAttachmentAddress("=", bean.getAttachmentAddress());
			count++;
		}
		if(bean.getUploadTime() != null) {
			dao.setConditionUploadTime(">=", bean.getUploadTime());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		bean.setDataFromJSON(json);
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectLinkAttachmentRecord> rlist = new BaseCollection<>();
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectLinkAttachmentRecord> result = dao.conditionalLoad(addtion);
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
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		bean.setDataFromJSON(json);
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		bean.setDataFromJSON(json);
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		bean.setDataFromJSON(json);
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectLinkAttachmentRecord bean = new BaseProjectLinkAttachmentRecord();
		bean.setDataFromJSON(json);
		ProjectLinkAttachmentRecord dao = new ProjectLinkAttachmentRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


