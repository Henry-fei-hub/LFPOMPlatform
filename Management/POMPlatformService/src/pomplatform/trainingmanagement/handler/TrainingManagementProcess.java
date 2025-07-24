package pomplatform.trainingmanagement.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseTrainingManagement;
import com.pomplatform.db.bean.BaseTrainingManagementDetail;
import com.pomplatform.db.dao.TrainingManagement;
import com.pomplatform.db.dao.TrainingManagementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class TrainingManagementProcess implements GenericProcessor {
	//判断是否签到
	private final static String SIGNINFLAG = "signinFlag";
	//判断是否签退
	private final static String SIGNOUTFLAG = "signoutFlag";
	//查询培训管理的信息
	private final static String QUERYTRAININGMANAGEMENT = "queryTrainingManagement";
	//签到
	private final static String SIGNIN = "signin";
	//签退
	private final static String SIGNOUT = "signout";
	//查询所有没有开始的培训
	private final static String SHOWALLNOTSTARTED = "showAllNotStarted";
	//查询所有已经结束的培训
	private final static String SHOWALLALREADYOVER = "showAllEReadyOver";
	//查询所有正在进行的培训
	private final static String SHOWALLUNDERWAY = "showAllUnderWay";
	//根据employeeId查询员工参与的培训
	private final static String SHOWMYTRAINING = "showMyTraining";
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "optType");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case SIGNINFLAG:
				return signinFlag(result);
			case SIGNIN:
				return signin(result);
			case QUERYTRAININGMANAGEMENT:
				return queryTrainingManagement(result);
			case SIGNOUT:
				return signout(result);
			case SHOWALLNOTSTARTED:
				return showAllNotStarted(result);
			case SHOWALLALREADYOVER:
				return showAllEReadyOver(result);
			case SHOWALLUNDERWAY:
				return showAllUnderWay(result);
			case SIGNOUTFLAG:
				return signoutFlag(result);
			case SHOWMYTRAINING:
				return showMyTraining(result);
			default:
				break;
			}
		}
		return null;
	}
	

	/**
	 * 查询参与的培训
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showMyTraining(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<BaseTrainingManagement> bc = new BaseCollection<>();
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result, "employeeId"));
		List<BaseTrainingManagementDetail> trainingManagementDetails = dao.conditionalLoad();
		List<BaseTrainingManagement> lists = new ArrayList<>();
		if (trainingManagementDetails.size() != 0) {
			for (BaseTrainingManagementDetail baseTrainingManagementDetail : trainingManagementDetails) {
				int trainingManagementId = baseTrainingManagementDetail.getTrainingManagementId();
				TrainingManagement trainingManagement = new TrainingManagement();
				trainingManagement.setTrainingManagementId(trainingManagementId);
				trainingManagement.load();
				BaseTrainingManagement baseTrainingManagement = trainingManagement.generateBase();
				lists.add(baseTrainingManagement);
			}
			status = 1;
			bc.setCollections(lists);
		}
		return bc.toJSON(status,"");
	}
	public static void main(String[] args) throws Exception {
		String ss = "{\"optType\": \"showMyTraining\",\"employeeId\":1848}";
		TrainingManagementProcess p = new TrainingManagementProcess();
		System.out.println(p.execute(ss, null));
		
	}

	/**
	 * 判断是否签退
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String signoutFlag(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<BaseTrainingManagementDetail> bc = new BaseCollection<>();
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setConditionTrainingManagementId("=", BaseHelpUtils.getIntValue(result, "trainingManagementId"));
		dao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result, "employeeId"));
		BaseTrainingManagementDetail aa = dao.executeQueryOneRow();
		if (aa != null) {
			int signOutFlag = aa.getSignOutFlag();
			if (signOutFlag == 1) {
				status = 1;
				return bc.toJSON(status,"");
			}
		}
		return bc.toJSON(status,"");
	}


	/**
	 * 查询所有正在进行的会议
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showAllUnderWay(Map<String, Object> result) throws SQLException {
		TrainingManagement dao = new TrainingManagement();
		BaseCollection<BaseTrainingManagement> collection = new BaseCollection<>();
		dao.setConditionStartTime("<", new Date());
		dao.setConditionEndTime(">", new Date());
		List<BaseTrainingManagement> lists = dao.conditionalLoad();
		collection.setCollections(lists);
		return collection.toJSON();
	}


	/**
	 * 查询所有已经结束的培训
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showAllEReadyOver(Map<String, Object> result) throws SQLException {
		TrainingManagement dao = new TrainingManagement();
		BaseCollection<BaseTrainingManagement> collection = new BaseCollection<>();
		dao.setConditionEndTime("<", new Date());
		List<BaseTrainingManagement> lists = dao.conditionalLoad();
		collection.setCollections(lists);
		return collection.toJSON();
	}


	/**
	 * 展示所有的未开始的培训
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String showAllNotStarted(Map<String, Object> result) throws SQLException {
		TrainingManagement dao = new TrainingManagement();
		BaseCollection<BaseTrainingManagement> collection = new BaseCollection<>();
		dao.setConditionStartTime(">", new Date());
		List<BaseTrainingManagement> lists = dao.conditionalLoad();
		collection.setCollections(lists);
		return collection.toJSON();
	}
	

	/**
	 * 签退
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String signout(Map<String, Object> result) throws SQLException {
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bCollection = new BaseCollection<>();
		TrainingManagement tmDao = new TrainingManagement();
		tmDao.setTrainingManagementId(BaseHelpUtils.getIntValue(result.get("trainingManagementId")));
		tmDao.load();
		TrainingManagementDetail tmdeatilDao = new TrainingManagementDetail();
		tmdeatilDao.setConditionTrainingManagementId("=", BaseHelpUtils.getIntValue(result, "trainingManagementId"));
		tmdeatilDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result, "employeeId"));
		BaseTrainingManagementDetail baseTrainingManagementDetail = tmdeatilDao.executeQueryOneRow();
		Integer signOutStatus = baseTrainingManagementDetail.getSignOutFlag();
		BaseTrainingManagement baseTrainingManagement = tmDao.generateBase();
		Long endDate = baseTrainingManagement.getEndTime().getTime();
		Integer signOutDelay = baseTrainingManagement.getSignOutDelay();
		Long currentTime = System.currentTimeMillis();
		if (currentTime - endDate > signOutDelay*60*1000) {
			status = -1 ;
			errorMsg = "已经超过签退时间，无法签退";
			return bCollection.toJSON(status,errorMsg);
		}
		if (endDate - currentTime > 10*60*1000) {
			status = -1 ;
			errorMsg = "还未到签退时间，无法签退";
			return bCollection.toJSON(status,errorMsg);
		}
		if (signOutStatus == 1) {
			status = -1;
			errorMsg = "您已经签退，请不要重复签退";
			return bCollection.toJSON(status,errorMsg);
		}
		
		tmdeatilDao.setSignOutTime(new Date());
		tmdeatilDao.setTrainingContent(BaseHelpUtils.getIntValue(result,"trainingContent"));
		tmdeatilDao.setTrainingMethod(BaseHelpUtils.getIntValue(result,"trainingMethod"));
		tmdeatilDao.setTrainingFrequency(BaseHelpUtils.getIntValue(result,"trainingFrequency"));
		tmdeatilDao.setTrainingPeriod(BaseHelpUtils.getIntValue(result,"trainingPeriod"));
		tmdeatilDao.setSpareTimeTraining(BaseHelpUtils.getIntValue(result,"spareTimeTraining"));
		tmdeatilDao.setCourseEvaluation(BaseHelpUtils.getIntValue(result,"courseEvaluation"));
		tmdeatilDao.setGuidingFunction(BaseHelpUtils.getIntValue(result,"guidingFunction"));
		tmdeatilDao.setSuggest(BaseHelpUtils.getStringValue(result,"suggest"));
		tmdeatilDao.setSignOutFlag(0);
		tmdeatilDao.conditionalUpdate();
		
		return bCollection.toJSON(status,null);
	}


	/**
	 * 根据主键查询TrainingManagement的信息并且返回
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String queryTrainingManagement(Map<String, Object> result) throws SQLException {
		TrainingManagement tmDao = new TrainingManagement();
		tmDao.setTrainingManagementId(BaseHelpUtils.getIntValue(result.get("trainingManagementId")));
		tmDao.load();
		BaseTrainingManagement baseTrainingManagement = tmDao.generateBase();
		return baseTrainingManagement.toJSON();
	}


	/**
	 * 签到
	 * @param result
	 * @return
	 * @throws SQLException 
	 */
	private String signin(Map<String, Object> result) throws SQLException {
		int status = 1;
		String errorMsg = "";
		BaseCollection<GenericBase> bCollection = new BaseCollection<>();
		TrainingManagement tmDao = new TrainingManagement();
		tmDao.setTrainingManagementId(BaseHelpUtils.getIntValue(result.get("trainingManagementId")));
		tmDao.load();
		TrainingManagementDetail tmdeatilDao = new TrainingManagementDetail();
		tmdeatilDao.setConditionTrainingManagementId("=", BaseHelpUtils.getIntValue(result, "trainingManagementId"));
		tmdeatilDao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result, "employeeId"));
		BaseTrainingManagementDetail baseTrainingManagementDetail = tmdeatilDao.executeQueryOneRow();
		BaseTrainingManagement baseTrainingManagement = tmDao.generateBase();
		Long startDate = baseTrainingManagement.getStartTime().getTime();
		Integer signInDelay = baseTrainingManagement.getSignInDelay();
		Long currentTime = System.currentTimeMillis();
		if (baseTrainingManagementDetail != null) {
			status = -1;
			errorMsg = "您已经签到，请不要重复签到";
			return bCollection.toJSON(status,errorMsg);
		}
		if (currentTime - startDate > signInDelay*60*1000) {
			status = -1;
			errorMsg = "已经超过最晚签到时间，不能签到";
			return bCollection.toJSON(status,errorMsg);
		}
		tmdeatilDao.setTrainingManagementId(BaseHelpUtils.getIntValue(result.get("trainingManagementId")));
		tmdeatilDao.setSignInTime(new Date());
		tmdeatilDao.setEmployeeId(BaseHelpUtils.getIntValue(result.get("employeeId")));
		tmdeatilDao.setEmployeeNumber(BaseHelpUtils.getString(result.get("employeeNumber")));
		tmdeatilDao.setDepartmentId(BaseHelpUtils.getIntValue(result.get("departmentId")));
		tmdeatilDao.save();
		return bCollection.toJSON(status,null);
	}


	/**
	 * 判断是否签到
	 * @param result
	 * @throws SQLException 
	 */
	private String signinFlag(Map<String, Object> result) throws SQLException {
		int status = -1;
		BaseCollection<BaseTrainingManagementDetail> bc = new BaseCollection<>();
		TrainingManagementDetail dao = new TrainingManagementDetail();
		dao.setConditionTrainingManagementId("=", BaseHelpUtils.getIntValue(result, "trainingManagementId"));
		dao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(result, "employeeId"));
		BaseTrainingManagementDetail aa = dao.executeQueryOneRow();
		if(aa != null){
			System.out.println("********");
			status = 1;
		}
		return bc.toJSON(status,"111");
	}
	
	
	
	
	

}
