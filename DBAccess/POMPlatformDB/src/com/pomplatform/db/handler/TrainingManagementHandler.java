package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTrainingManagement;
import com.pomplatform.db.dao.TrainingManagement;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TrainingManagementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TrainingManagementHandler.class);

	public static BaseTrainingManagement getTrainingManagementById( 
		java.lang.Integer training_management_id
	) throws Exception
	{
		TrainingManagement dao = new TrainingManagement();
		dao.setTrainingManagementId(training_management_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTrainingManagementExists( com.pomplatform.db.bean.BaseTrainingManagement bean, String additional ) throws Exception {

		TrainingManagement dao = new TrainingManagement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTrainingManagement( com.pomplatform.db.bean.BaseTrainingManagement bean, String additional ) throws Exception {

		TrainingManagement dao = new TrainingManagement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTrainingManagement> queryTrainingManagement( com.pomplatform.db.bean.BaseTrainingManagement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TrainingManagement dao = new TrainingManagement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTrainingManagement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTrainingManagement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTrainingManagement addToTrainingManagement ( BaseTrainingManagement trainingmanagement )  throws Exception {
		return addToTrainingManagement ( trainingmanagement , false);
	}

	public static BaseTrainingManagement addToTrainingManagement ( BaseTrainingManagement trainingmanagement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TrainingManagement dao = new TrainingManagement();
		dao.setDataFromBase(trainingmanagement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTrainingManagement addUpdateTrainingManagement ( BaseTrainingManagement trainingmanagement ) throws Exception {
		return addUpdateTrainingManagement ( trainingmanagement , false);
	}

	public static BaseTrainingManagement addUpdateTrainingManagement ( BaseTrainingManagement trainingmanagement, boolean singleTransaction  ) throws Exception {
		if(trainingmanagement.getTrainingManagementId() == null) return addToTrainingManagement(trainingmanagement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TrainingManagement dao = new TrainingManagement();
		dao.setDataFromBase(trainingmanagement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(trainingmanagement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTrainingManagement ( BaseTrainingManagement bean ) throws Exception {
		TrainingManagement dao = new TrainingManagement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTrainingManagement updateTrainingManagement ( BaseTrainingManagement trainingmanagement ) throws Exception {
		TrainingManagement dao = new TrainingManagement();
		dao.setTrainingManagementId( trainingmanagement.getTrainingManagementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(trainingmanagement);
			result = dao.update();
		}
		return result == 1 ? trainingmanagement : null ;
	}

	public static BaseTrainingManagement updateTrainingManagementDirect( BaseTrainingManagement trainingmanagement ) throws Exception {
		TrainingManagement dao = new TrainingManagement();
		int result = 0;
		dao.setDataFromBase(trainingmanagement);
		result = dao.update();
		return result == 1 ? trainingmanagement : null ;
	}

	public static int setDeleteConditions(BaseTrainingManagement bean, TrainingManagement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTrainingManagementId() != null) {
			dao.setConditionTrainingManagementId("=", bean.getTrainingManagementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSubject() != null) {
				dao.setConditionSubject("=", bean.getSubject());
				count++;
			}
			if(bean.getCompereType() != null) {
				dao.setConditionCompereType("=", bean.getCompereType());
				count++;
			}
			if(bean.getCompere() != null) {
				dao.setConditionCompere("=", bean.getCompere());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSignInDelay() != null) {
				dao.setConditionSignInDelay("=", bean.getSignInDelay());
				count++;
			}
			if(bean.getSignOutDelay() != null) {
				dao.setConditionSignOutDelay("=", bean.getSignOutDelay());
				count++;
			}
			if(bean.getCourseScore() != null) {
				dao.setConditionCourseScore("=", bean.getCourseScore());
				count++;
			}
			if(bean.getDetail() != null) {
				dao.setConditionDetail("=", bean.getDetail());
				count++;
			}
			if(bean.getCreatePersonId() != null) {
				dao.setConditionCreatePersonId("=", bean.getCreatePersonId());
				count++;
			}
			if(bean.getFileManageId() != null) {
				dao.setConditionFileManageId("=", bean.getFileManageId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getSite() != null) {
				dao.setConditionSite("=", bean.getSite());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getIsSite() != null) {
				dao.setConditionIsSite("=", bean.getIsSite());
				count++;
			}
			if(bean.getTrainingType() != null) {
				dao.setConditionTrainingType("=", bean.getTrainingType());
				count++;
			}
			if(bean.getTrainingFee() != null) {
				dao.setConditionTrainingFee("=", bean.getTrainingFee());
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
			if(bean.getIsSend() != null) {
				dao.setConditionIsSend("=", bean.getIsSend());
				count++;
			}
			if(bean.getPlateids() != null) {
				dao.setConditionPlateids("=", bean.getPlateids());
				count++;
			}
			if(bean.getDepartmentids() != null) {
				dao.setConditionDepartmentids("=", bean.getDepartmentids());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTrainingManagement bean, TrainingManagement dao){
		int count = 0;
		if(bean.getTrainingManagementId() != null) {
			dao.setConditionTrainingManagementId("=", bean.getTrainingManagementId());
			count++;
		}
		if(bean.getSubject() != null) {
			if(bean.getSubject().indexOf("%") >= 0)
				dao.setConditionSubject("like", bean.getSubject());
			else
				dao.setConditionSubject("=", bean.getSubject());
			count++;
		}
		if(bean.getStartTime() != null) {
			dao.setConditionStartTime(">=", bean.getStartTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getCompereType() != null) {
			dao.setConditionCompereType("=", bean.getCompereType());
			count++;
		}
		if(bean.getCompere() != null) {
			if(bean.getCompere().indexOf("%") >= 0)
				dao.setConditionCompere("like", bean.getCompere());
			else
				dao.setConditionCompere("=", bean.getCompere());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getSignInDelay() != null) {
			dao.setConditionSignInDelay("=", bean.getSignInDelay());
			count++;
		}
		if(bean.getSignOutDelay() != null) {
			dao.setConditionSignOutDelay("=", bean.getSignOutDelay());
			count++;
		}
		if(bean.getCourseScore() != null) {
			dao.setConditionCourseScore("=", bean.getCourseScore());
			count++;
		}
		if(bean.getDetail() != null) {
			if(bean.getDetail().indexOf("%") >= 0)
				dao.setConditionDetail("like", bean.getDetail());
			else
				dao.setConditionDetail("=", bean.getDetail());
			count++;
		}
		if(bean.getCreatePersonId() != null) {
			dao.setConditionCreatePersonId("=", bean.getCreatePersonId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getFileManageId() != null) {
			dao.setConditionFileManageId("=", bean.getFileManageId());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getSite() != null) {
			if(bean.getSite().indexOf("%") >= 0)
				dao.setConditionSite("like", bean.getSite());
			else
				dao.setConditionSite("=", bean.getSite());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getIsSite() != null) {
			dao.setConditionIsSite("=", bean.getIsSite());
			count++;
		}
		if(bean.getTrainingType() != null) {
			dao.setConditionTrainingType("=", bean.getTrainingType());
			count++;
		}
		if(bean.getTrainingFee() != null) {
			dao.setConditionTrainingFee("=", bean.getTrainingFee());
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
		if(bean.getIsSend() != null) {
			dao.setConditionIsSend("=", bean.getIsSend());
			count++;
		}
		if(bean.getPlateids() != null) {
			if(bean.getPlateids().indexOf("%") >= 0)
				dao.setConditionPlateids("like", bean.getPlateids());
			else
				dao.setConditionPlateids("=", bean.getPlateids());
			count++;
		}
		if(bean.getDepartmentids() != null) {
			if(bean.getDepartmentids().indexOf("%") >= 0)
				dao.setConditionDepartmentids("like", bean.getDepartmentids());
			else
				dao.setConditionDepartmentids("=", bean.getDepartmentids());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTrainingManagement> rlist = new BaseCollection<>();
		BaseTrainingManagement bean = new BaseTrainingManagement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TrainingManagement dao = new TrainingManagement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTrainingManagement> result = dao.conditionalLoad(addtion);
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
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTrainingManagement bean = new BaseTrainingManagement();
		bean.setDataFromJSON(json);
		TrainingManagement dao = new TrainingManagement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


