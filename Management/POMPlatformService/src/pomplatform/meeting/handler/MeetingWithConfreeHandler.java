package pomplatform.meeting.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.meeting.bean.BaseMeetingWithConfree;
import pomplatform.meeting.dao.MeetingWithConfree;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.date.util.TimeSpanCalculator;

public class MeetingWithConfreeHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(MeetingWithConfreeHandler.class);

	public static BaseMeetingWithConfree getMeetingWithCById(Integer meeting_record_chart_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseMeetingWithConfree result;
			MeetingWithConfree dao = new MeetingWithConfree();
			dao.setMeetingRecordChartId(meeting_record_chart_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get MeetingWithConfree By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isMeetingWithCExists(BaseMeetingWithConfree bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query MeetingWithConfree List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countMeetingWithC(BaseMeetingWithConfree bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query MeetingWithConfree List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseMeetingWithConfree> queryMeetingWithC(BaseMeetingWithConfree bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseMeetingWithConfree> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseMeetingWithConfree> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query MeetingWithConfree List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseMeetingWithConfree addToMeetingWithC (BaseMeetingWithConfree meetingwithc ) {
		return addToMeetingWithC ( meetingwithc , false);
	}

	public static BaseMeetingWithConfree addToMeetingWithC (BaseMeetingWithConfree meetingwithc, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			MeetingWithConfree dao = new MeetingWithConfree();
			dao.setDataFromBase(meetingwithc);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to MeetingWithConfree time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseMeetingWithConfree addUpdateMeetingWithC (BaseMeetingWithConfree meetingwithc ) {
		return addUpdateMeetingWithC ( meetingwithc , false);
	}

	public static BaseMeetingWithConfree addUpdateMeetingWithC (BaseMeetingWithConfree meetingwithc, boolean singleTransaction  ) {
		if(meetingwithc.getMeetingRecordChartId() == null) return addToMeetingWithC(meetingwithc);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			MeetingWithConfree dao = new MeetingWithConfree();
			dao.setDataFromBase(meetingwithc);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(meetingwithc); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to MeetingWithConfree time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseMeetingWithConfree deleteMeetingWithC (BaseMeetingWithConfree bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete MeetingWithConfree time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseMeetingWithConfree updateMeetingWithC (BaseMeetingWithConfree meetingwithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			dao.setMeetingRecordChartId( meetingwithc.getMeetingRecordChartId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(meetingwithc);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update MeetingWithConfree time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? meetingwithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseMeetingWithConfree updateMeetingWithCDirect(BaseMeetingWithConfree meetingwithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			MeetingWithConfree dao = new MeetingWithConfree();
			int result = 0;
			dao.setDataFromBase(meetingwithc);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update MeetingWithConfree time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? meetingwithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseMeetingWithConfree bean, MeetingWithConfree dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRecordChartId() != null) {
			dao.setMeetingRecordChartId(bean.getMeetingRecordChartId());
			dao.setConditionMeetingRecordChartId("=", bean.getMeetingRecordChartId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRoomId() != null) {
				dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getMeetingTheme() != null) {
				dao.setConditionMeetingTheme("=", bean.getMeetingTheme());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingWithConfree bean, MeetingWithConfree dao){
		int count = 0;
		if(bean.getMeetingRecordChartId() != null) {
			dao.setConditionMeetingRecordChartId("=", bean.getMeetingRecordChartId());
			count++;
		}
		if(bean.getMeetingRoomId() != null) {
			dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getMeetingTheme() != null) {
			if(bean.getMeetingTheme().indexOf("%") >= 0)
				dao.setConditionMeetingTheme("like", bean.getMeetingTheme());
			else
				dao.setConditionMeetingTheme("=", bean.getMeetingTheme());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		bean.setDataFromJSON(json);
		MeetingWithConfree dao = new MeetingWithConfree();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingWithConfree> rlist = new BaseCollection<>();
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingWithConfree dao = new MeetingWithConfree();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingWithConfree> result = dao.conditionalLoadExt(addtion);
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
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		bean.setDataFromJSON(json);
		MeetingWithConfree dao = new MeetingWithConfree();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		bean.setDataFromJSON(json);
		int num = 0;
		MeetingWithConfree dao = new MeetingWithConfree();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		bean.setDataFromJSON(json);
		MeetingWithConfree dao = new MeetingWithConfree();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingWithConfree bean = new BaseMeetingWithConfree();
		bean.setDataFromJSON(json);
		MeetingWithConfree dao = new MeetingWithConfree();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


