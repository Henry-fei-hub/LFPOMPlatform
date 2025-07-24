package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.dao.ProjectAttachment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProjectAttachmentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProjectAttachmentHandler.class);

	public static BaseProjectAttachment getProjectAttachmentById( 
		java.lang.Integer project_attachment_id
	) throws Exception
	{
		ProjectAttachment dao = new ProjectAttachment();
		dao.setProjectAttachmentId(project_attachment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProjectAttachmentExists( com.pomplatform.db.bean.BaseProjectAttachment bean, String additional ) throws Exception {

		ProjectAttachment dao = new ProjectAttachment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProjectAttachment( com.pomplatform.db.bean.BaseProjectAttachment bean, String additional ) throws Exception {

		ProjectAttachment dao = new ProjectAttachment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProjectAttachment> queryProjectAttachment( com.pomplatform.db.bean.BaseProjectAttachment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProjectAttachment dao = new ProjectAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProjectAttachment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProjectAttachment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProjectAttachment addToProjectAttachment ( BaseProjectAttachment projectattachment )  throws Exception {
		return addToProjectAttachment ( projectattachment , false);
	}

	public static BaseProjectAttachment addToProjectAttachment ( BaseProjectAttachment projectattachment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProjectAttachment dao = new ProjectAttachment();
		dao.setDataFromBase(projectattachment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProjectAttachment addUpdateProjectAttachment ( BaseProjectAttachment projectattachment ) throws Exception {
		return addUpdateProjectAttachment ( projectattachment , false);
	}

	public static BaseProjectAttachment addUpdateProjectAttachment ( BaseProjectAttachment projectattachment, boolean singleTransaction  ) throws Exception {
		if(projectattachment.getProjectAttachmentId() == null) return addToProjectAttachment(projectattachment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProjectAttachment dao = new ProjectAttachment();
		dao.setDataFromBase(projectattachment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(projectattachment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProjectAttachment ( BaseProjectAttachment bean ) throws Exception {
		ProjectAttachment dao = new ProjectAttachment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProjectAttachment updateProjectAttachment ( BaseProjectAttachment projectattachment ) throws Exception {
		ProjectAttachment dao = new ProjectAttachment();
		dao.setProjectAttachmentId( projectattachment.getProjectAttachmentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(projectattachment);
			result = dao.update();
		}
		return result == 1 ? projectattachment : null ;
	}

	public static BaseProjectAttachment updateProjectAttachmentDirect( BaseProjectAttachment projectattachment ) throws Exception {
		ProjectAttachment dao = new ProjectAttachment();
		int result = 0;
		dao.setDataFromBase(projectattachment);
		result = dao.update();
		return result == 1 ? projectattachment : null ;
	}

	public static int setDeleteConditions(BaseProjectAttachment bean, ProjectAttachment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProjectAttachmentId() != null) {
			dao.setConditionProjectAttachmentId("=", bean.getProjectAttachmentId());
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
			if(bean.getAttachmentFile() != null) {
				dao.setConditionAttachmentFile("=", bean.getAttachmentFile());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsHandle() != null) {
				dao.setConditionIsHandle("=", bean.getIsHandle());
				count++;
			}
			if(bean.getIsSameContract() != null) {
				dao.setConditionIsSameContract("=", bean.getIsSameContract());
				count++;
			}
			if(bean.getIsSameStage() != null) {
				dao.setConditionIsSameStage("=", bean.getIsSameStage());
				count++;
			}
			if(bean.getIsHasSign() != null) {
				dao.setConditionIsHasSign("=", bean.getIsHasSign());
				count++;
			}
			if(bean.getIsHasSeal() != null) {
				dao.setConditionIsHasSeal("=", bean.getIsHasSeal());
				count++;
			}
			if(bean.getIsSure() != null) {
				dao.setConditionIsSure("=", bean.getIsSure());
				count++;
			}
			if(bean.getIsQualified() != null) {
				dao.setConditionIsQualified("=", bean.getIsQualified());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getIsEmailSure() != null) {
				dao.setConditionIsEmailSure("=", bean.getIsEmailSure());
				count++;
			}
			if(bean.getIsOtherSure() != null) {
				dao.setConditionIsOtherSure("=", bean.getIsOtherSure());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProjectAttachment bean, ProjectAttachment dao){
		int count = 0;
		if(bean.getProjectAttachmentId() != null) {
			dao.setConditionProjectAttachmentId("=", bean.getProjectAttachmentId());
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
		if(bean.getUploadTime() != null) {
			dao.setConditionUploadTime(">=", bean.getUploadTime());
			count++;
		}
		if(bean.getAttachmentFile() != null) {
			if(bean.getAttachmentFile().indexOf("%") >= 0)
				dao.setConditionAttachmentFile("like", bean.getAttachmentFile());
			else
				dao.setConditionAttachmentFile("=", bean.getAttachmentFile());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsHandle() != null) {
			dao.setConditionIsHandle("=", bean.getIsHandle());
			count++;
		}
		if(bean.getIsSameContract() != null) {
			dao.setConditionIsSameContract("=", bean.getIsSameContract());
			count++;
		}
		if(bean.getIsSameStage() != null) {
			dao.setConditionIsSameStage("=", bean.getIsSameStage());
			count++;
		}
		if(bean.getIsHasSign() != null) {
			dao.setConditionIsHasSign("=", bean.getIsHasSign());
			count++;
		}
		if(bean.getIsHasSeal() != null) {
			dao.setConditionIsHasSeal("=", bean.getIsHasSeal());
			count++;
		}
		if(bean.getIsSure() != null) {
			dao.setConditionIsSure("=", bean.getIsSure());
			count++;
		}
		if(bean.getIsQualified() != null) {
			dao.setConditionIsQualified("=", bean.getIsQualified());
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
		if(bean.getIsEmailSure() != null) {
			dao.setConditionIsEmailSure("=", bean.getIsEmailSure());
			count++;
		}
		if(bean.getIsOtherSure() != null) {
			dao.setConditionIsOtherSure("=", bean.getIsOtherSure());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProjectAttachment bean = new BaseProjectAttachment();
		bean.setDataFromJSON(json);
		ProjectAttachment dao = new ProjectAttachment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProjectAttachment> rlist = new BaseCollection<>();
		BaseProjectAttachment bean = new BaseProjectAttachment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProjectAttachment dao = new ProjectAttachment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProjectAttachment> result = dao.conditionalLoad(addtion);
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
		BaseProjectAttachment bean = new BaseProjectAttachment();
		bean.setDataFromJSON(json);
		ProjectAttachment dao = new ProjectAttachment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProjectAttachment bean = new BaseProjectAttachment();
		bean.setDataFromJSON(json);
		ProjectAttachment dao = new ProjectAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProjectAttachment bean = new BaseProjectAttachment();
		bean.setDataFromJSON(json);
		ProjectAttachment dao = new ProjectAttachment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProjectAttachment bean = new BaseProjectAttachment();
		bean.setDataFromJSON(json);
		ProjectAttachment dao = new ProjectAttachment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


