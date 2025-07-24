package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseTrainingManagementDetail;
import com.pomplatform.db.dao.TrainingManagementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TrainingManagementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(TrainingManagementDetailHandler.class);

	public static BaseTrainingManagementDetail getTrainingManagementDetailById( 
		java.lang.Integer training_management_detail_id
	) throws Exception
	{
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setTrainingManagementDetailId(training_management_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isTrainingManagementDetailExists( com.pomplatform.db.bean.BaseTrainingManagementDetail bean, String additional ) throws Exception {

		TrainingManagementDetail dao = new TrainingManagementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countTrainingManagementDetail( com.pomplatform.db.bean.BaseTrainingManagementDetail bean, String additional ) throws Exception {

		TrainingManagementDetail dao = new TrainingManagementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseTrainingManagementDetail> queryTrainingManagementDetail( com.pomplatform.db.bean.BaseTrainingManagementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		TrainingManagementDetail dao = new TrainingManagementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseTrainingManagementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseTrainingManagementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseTrainingManagementDetail addToTrainingManagementDetail ( BaseTrainingManagementDetail trainingmanagementdetail )  throws Exception {
		return addToTrainingManagementDetail ( trainingmanagementdetail , false);
	}

	public static BaseTrainingManagementDetail addToTrainingManagementDetail ( BaseTrainingManagementDetail trainingmanagementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setDataFromBase(trainingmanagementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseTrainingManagementDetail addUpdateTrainingManagementDetail ( BaseTrainingManagementDetail trainingmanagementdetail ) throws Exception {
		return addUpdateTrainingManagementDetail ( trainingmanagementdetail , false);
	}

	public static BaseTrainingManagementDetail addUpdateTrainingManagementDetail ( BaseTrainingManagementDetail trainingmanagementdetail, boolean singleTransaction  ) throws Exception {
		if(trainingmanagementdetail.getTrainingManagementDetailId() == null) return addToTrainingManagementDetail(trainingmanagementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setDataFromBase(trainingmanagementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(trainingmanagementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteTrainingManagementDetail ( BaseTrainingManagementDetail bean ) throws Exception {
		TrainingManagementDetail dao = new TrainingManagementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseTrainingManagementDetail updateTrainingManagementDetail ( BaseTrainingManagementDetail trainingmanagementdetail ) throws Exception {
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setTrainingManagementDetailId( trainingmanagementdetail.getTrainingManagementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(trainingmanagementdetail);
			result = dao.update();
		}
		return result == 1 ? trainingmanagementdetail : null ;
	}

	public static BaseTrainingManagementDetail updateTrainingManagementDetailDirect( BaseTrainingManagementDetail trainingmanagementdetail ) throws Exception {
		TrainingManagementDetail dao = new TrainingManagementDetail();
		int result = 0;
		dao.setDataFromBase(trainingmanagementdetail);
		result = dao.update();
		return result == 1 ? trainingmanagementdetail : null ;
	}

	public static int setDeleteConditions(BaseTrainingManagementDetail bean, TrainingManagementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getTrainingManagementDetailId() != null) {
			dao.setConditionTrainingManagementDetailId("=", bean.getTrainingManagementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTrainingManagementId() != null) {
				dao.setConditionTrainingManagementId("=", bean.getTrainingManagementId());
				count++;
			}
			if(bean.getSignOutFlag() != null) {
				dao.setConditionSignOutFlag("=", bean.getSignOutFlag());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNumber() != null) {
				dao.setConditionEmployeeNumber("=", bean.getEmployeeNumber());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getTrainingContent() != null) {
				dao.setConditionTrainingContent("=", bean.getTrainingContent());
				count++;
			}
			if(bean.getTrainingMethod() != null) {
				dao.setConditionTrainingMethod("=", bean.getTrainingMethod());
				count++;
			}
			if(bean.getTrainingFrequency() != null) {
				dao.setConditionTrainingFrequency("=", bean.getTrainingFrequency());
				count++;
			}
			if(bean.getTrainingPeriod() != null) {
				dao.setConditionTrainingPeriod("=", bean.getTrainingPeriod());
				count++;
			}
			if(bean.getSpareTimeTraining() != null) {
				dao.setConditionSpareTimeTraining("=", bean.getSpareTimeTraining());
				count++;
			}
			if(bean.getSuggest() != null) {
				dao.setConditionSuggest("=", bean.getSuggest());
				count++;
			}
			if(bean.getCourseEvaluation() != null) {
				dao.setConditionCourseEvaluation("=", bean.getCourseEvaluation());
				count++;
			}
			if(bean.getGuidingFunction() != null) {
				dao.setConditionGuidingFunction("=", bean.getGuidingFunction());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseTrainingManagementDetail bean, TrainingManagementDetail dao){
		int count = 0;
		if(bean.getTrainingManagementDetailId() != null) {
			dao.setConditionTrainingManagementDetailId("=", bean.getTrainingManagementDetailId());
			count++;
		}
		if(bean.getTrainingManagementId() != null) {
			dao.setConditionTrainingManagementId("=", bean.getTrainingManagementId());
			count++;
		}
		if(bean.getSignInTime() != null) {
			dao.setConditionSignInTime(">=", bean.getSignInTime());
			count++;
		}
		if(bean.getSignOutTime() != null) {
			dao.setConditionSignOutTime(">=", bean.getSignOutTime());
			count++;
		}
		if(bean.getSignOutFlag() != null) {
			dao.setConditionSignOutFlag("=", bean.getSignOutFlag());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNumber() != null) {
			if(bean.getEmployeeNumber().indexOf("%") >= 0)
				dao.setConditionEmployeeNumber("like", bean.getEmployeeNumber());
			else
				dao.setConditionEmployeeNumber("=", bean.getEmployeeNumber());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getTrainingContent() != null) {
			dao.setConditionTrainingContent("=", bean.getTrainingContent());
			count++;
		}
		if(bean.getTrainingMethod() != null) {
			dao.setConditionTrainingMethod("=", bean.getTrainingMethod());
			count++;
		}
		if(bean.getTrainingFrequency() != null) {
			dao.setConditionTrainingFrequency("=", bean.getTrainingFrequency());
			count++;
		}
		if(bean.getTrainingPeriod() != null) {
			dao.setConditionTrainingPeriod("=", bean.getTrainingPeriod());
			count++;
		}
		if(bean.getSpareTimeTraining() != null) {
			dao.setConditionSpareTimeTraining("=", bean.getSpareTimeTraining());
			count++;
		}
		if(bean.getSuggest() != null) {
			if(bean.getSuggest().indexOf("%") >= 0)
				dao.setConditionSuggest("like", bean.getSuggest());
			else
				dao.setConditionSuggest("=", bean.getSuggest());
			count++;
		}
		if(bean.getCourseEvaluation() != null) {
			dao.setConditionCourseEvaluation("=", bean.getCourseEvaluation());
			count++;
		}
		if(bean.getGuidingFunction() != null) {
			dao.setConditionGuidingFunction("=", bean.getGuidingFunction());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		bean.setDataFromJSON(json);
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTrainingManagementDetail> rlist = new BaseCollection<>();
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TrainingManagementDetail dao = new TrainingManagementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTrainingManagementDetail> result = dao.conditionalLoad(addtion);
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
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		bean.setDataFromJSON(json);
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		bean.setDataFromJSON(json);
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		bean.setDataFromJSON(json);
		TrainingManagementDetail dao = new TrainingManagementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTrainingManagementDetail bean = new BaseTrainingManagementDetail();
		bean.setDataFromJSON(json);
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


