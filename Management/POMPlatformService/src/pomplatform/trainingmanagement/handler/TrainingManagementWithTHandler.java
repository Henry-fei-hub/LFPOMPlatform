package pomplatform.trainingmanagement.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.trainingmanagement.bean.BaseTrainingManagementWithT;
import pomplatform.trainingmanagement.dao.TrainingManagementWithT;
import com.pomplatform.db.dao.TrainingManagementDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class TrainingManagementWithTHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(TrainingManagementWithTHandler.class);

	public static BaseTrainingManagementWithT getTrainingManagementWithTById(  )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseTrainingManagementWithT result;
			TrainingManagementWithT dao = new TrainingManagementWithT();
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get TrainingManagementWithT By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isTrainingManagementWithTExists( pomplatform.trainingmanagement.bean.BaseTrainingManagementWithT bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query TrainingManagementWithT List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countTrainingManagementWithT( pomplatform.trainingmanagement.bean.BaseTrainingManagementWithT bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query TrainingManagementWithT List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseTrainingManagementWithT> queryTrainingManagementWithT( BaseTrainingManagementWithT bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseTrainingManagementWithT> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseTrainingManagementWithT> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query TrainingManagementWithT List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTrainingManagementWithT addToTrainingManagementWithT ( BaseTrainingManagementWithT trainingmanagementwitht ) {
		return addToTrainingManagementWithT ( trainingmanagementwitht , false);
	}

	public static BaseTrainingManagementWithT addToTrainingManagementWithT ( BaseTrainingManagementWithT trainingmanagementwitht, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			dao.setDataFromBase(trainingmanagementwitht);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to TrainingManagementWithT time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTrainingManagementWithT addUpdateTrainingManagementWithT ( BaseTrainingManagementWithT trainingmanagementwitht ) {
		return addUpdateTrainingManagementWithT ( trainingmanagementwitht , false);
	}

	public static BaseTrainingManagementWithT addUpdateTrainingManagementWithT ( BaseTrainingManagementWithT trainingmanagementwitht, boolean singleTransaction  ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			dao.setDataFromBase(trainingmanagementwitht);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(trainingmanagementwitht); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to TrainingManagementWithT time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTrainingManagementWithT deleteTrainingManagementWithT ( BaseTrainingManagementWithT bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete TrainingManagementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTrainingManagementWithT updateTrainingManagementWithT ( BaseTrainingManagementWithT trainingmanagementwitht ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(trainingmanagementwitht);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update TrainingManagementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? trainingmanagementwitht : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseTrainingManagementWithT updateTrainingManagementWithTDirect( BaseTrainingManagementWithT trainingmanagementwitht ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			TrainingManagementWithT dao = new TrainingManagementWithT();
			int result = 0;
			dao.setDataFromBase(trainingmanagementwitht);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update TrainingManagementWithT time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? trainingmanagementwitht : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseTrainingManagementWithT bean, TrainingManagementWithT dao){
		int count = 0;
		boolean foundKey = false;
		if(!foundKey) {
			if(bean.getTrainingManagementId() != null) {
				dao.setConditionTrainingManagementId("=", bean.getTrainingManagementId());
				count++;
			}
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

	public static int setConditions(BaseTrainingManagementWithT bean, TrainingManagementWithT dao){
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
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		bean.setDataFromJSON(json);
		TrainingManagementWithT dao = new TrainingManagementWithT();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseTrainingManagementWithT> rlist = new BaseCollection<>();
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		TrainingManagementWithT dao = new TrainingManagementWithT();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseTrainingManagementWithT> result = dao.conditionalLoadExt(addtion);
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
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		bean.setDataFromJSON(json);
		TrainingManagementWithT dao = new TrainingManagementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		bean.setDataFromJSON(json);
		int num = 0;
		TrainingManagementWithT dao = new TrainingManagementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		bean.setDataFromJSON(json);
		TrainingManagementWithT dao = new TrainingManagementWithT();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseTrainingManagementWithT bean = new BaseTrainingManagementWithT();
		bean.setDataFromJSON(json);
		TrainingManagementWithT dao = new TrainingManagementWithT();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


