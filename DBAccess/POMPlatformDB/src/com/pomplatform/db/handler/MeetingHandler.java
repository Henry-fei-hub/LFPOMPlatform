package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeeting;
import java.util.List;
import com.pomplatform.db.dao.Meeting;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingHandler.class);

	public static BaseMeeting getMeetingById( 
		java.lang.Integer meeting_record_chart_id
	) throws Exception
	{
		Meeting dao = new Meeting();
		dao.setMeetingRecordChartId(meeting_record_chart_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingExists( com.pomplatform.db.bean.BaseMeeting bean, String additional ) throws Exception {

		Meeting dao = new Meeting();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeeting( com.pomplatform.db.bean.BaseMeeting bean, String additional ) throws Exception {

		Meeting dao = new Meeting();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeeting> queryMeeting( com.pomplatform.db.bean.BaseMeeting bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Meeting dao = new Meeting();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeeting> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeeting> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeeting addToMeeting ( BaseMeeting meeting )  throws Exception {
		return addToMeeting ( meeting , false);
	}

	public static BaseMeeting addToMeeting ( BaseMeeting meeting, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Meeting dao = new Meeting();
		dao.setDataFromBase(meeting);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeeting addUpdateMeeting ( BaseMeeting meeting ) throws Exception {
		return addUpdateMeeting ( meeting , false);
	}

	public static BaseMeeting addUpdateMeeting ( BaseMeeting meeting, boolean singleTransaction  ) throws Exception {
		if(meeting.getMeetingRecordChartId() == null) return addToMeeting(meeting);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Meeting dao = new Meeting();
		dao.setDataFromBase(meeting);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meeting); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeeting ( BaseMeeting bean ) throws Exception {
		Meeting dao = new Meeting();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeeting updateMeeting ( BaseMeeting meeting ) throws Exception {
		Meeting dao = new Meeting();
		dao.setMeetingRecordChartId( meeting.getMeetingRecordChartId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meeting);
			result = dao.update();
		}
		return result == 1 ? meeting : null ;
	}

	public static BaseMeeting updateMeetingDirect( BaseMeeting meeting ) throws Exception {
		Meeting dao = new Meeting();
		int result = 0;
		dao.setDataFromBase(meeting);
		result = dao.update();
		return result == 1 ? meeting : null ;
	}

	public static int setDeleteConditions(BaseMeeting bean, Meeting dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRecordChartId() != null) {
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
			if(bean.getMeetingRoomTimeId() != null) {
				dao.setConditionMeetingRoomTimeId("=", bean.getMeetingRoomTimeId());
				count++;
			}
			if(bean.getMeetingRoomTime() != null) {
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
				count++;
			}
			if(bean.getMeetingRelevanceId() != null) {
				dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
				count++;
			}
			if(bean.getEndTimeTwo() != null) {
				dao.setConditionEndTimeTwo("=", bean.getEndTimeTwo());
				count++;
			}
			if(bean.getMeetingStatus() != null) {
				dao.setConditionMeetingStatus("=", bean.getMeetingStatus());
				count++;
			}
			if(bean.getStartTimes() != null) {
				dao.setConditionStartTimes("=", bean.getStartTimes());
				count++;
			}
			if(bean.getEndTimes() != null) {
				dao.setConditionEndTimes("=", bean.getEndTimes());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeeting bean, Meeting dao){
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
		if(bean.getMeetingRoomTimeId() != null) {
			dao.setConditionMeetingRoomTimeId("=", bean.getMeetingRoomTimeId());
			count++;
		}
		if(bean.getMeetingRoomTime() != null) {
			if(bean.getMeetingRoomTime().indexOf("%") >= 0)
				dao.setConditionMeetingRoomTime("like", bean.getMeetingRoomTime());
			else
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
			count++;
		}
		if(bean.getMeetingRelevanceId() != null) {
			dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
			count++;
		}
		if(bean.getEndTimeTwo() != null) {
			dao.setConditionEndTimeTwo("=", bean.getEndTimeTwo());
			count++;
		}
		if(bean.getMeetingTime() != null) {
			dao.setConditionMeetingTime(">=", bean.getMeetingTime());
			count++;
		}
		if(bean.getMeetingStatus() != null) {
			dao.setConditionMeetingStatus("=", bean.getMeetingStatus());
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
		if(bean.getStartTimes() != null) {
			dao.setConditionStartTimes("=", bean.getStartTimes());
			count++;
		}
		if(bean.getEndTimes() != null) {
			dao.setConditionEndTimes("=", bean.getEndTimes());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeeting bean = new BaseMeeting();
		bean.setDataFromJSON(json);
		Meeting dao = new Meeting();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeeting> rlist = new BaseCollection<>();
		BaseMeeting bean = new BaseMeeting();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Meeting dao = new Meeting();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeeting> result = dao.conditionalLoad(addtion);
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
		BaseMeeting bean = new BaseMeeting();
		bean.setDataFromJSON(json);
		Meeting dao = new Meeting();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeeting bean = new BaseMeeting();
		bean.setDataFromJSON(json);
		Meeting dao = new Meeting();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeeting bean = new BaseMeeting();
		bean.setDataFromJSON(json);
		Meeting dao = new Meeting();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeeting bean = new BaseMeeting();
		bean.setDataFromJSON(json);
		Meeting dao = new Meeting();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


