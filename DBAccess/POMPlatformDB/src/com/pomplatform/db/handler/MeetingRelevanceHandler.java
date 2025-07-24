package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingRelevance;
import java.util.List;
import com.pomplatform.db.dao.MeetingRelevance;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingRelevanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingRelevanceHandler.class);

	public static BaseMeetingRelevance getMeetingRelevanceById( 
		java.lang.Integer meeting_relevance_id
	) throws Exception
	{
		MeetingRelevance dao = new MeetingRelevance();
		dao.setMeetingRelevanceId(meeting_relevance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingRelevanceExists( com.pomplatform.db.bean.BaseMeetingRelevance bean, String additional ) throws Exception {

		MeetingRelevance dao = new MeetingRelevance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingRelevance( com.pomplatform.db.bean.BaseMeetingRelevance bean, String additional ) throws Exception {

		MeetingRelevance dao = new MeetingRelevance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingRelevance> queryMeetingRelevance( com.pomplatform.db.bean.BaseMeetingRelevance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingRelevance dao = new MeetingRelevance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingRelevance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingRelevance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingRelevance addToMeetingRelevance ( BaseMeetingRelevance meetingrelevance )  throws Exception {
		return addToMeetingRelevance ( meetingrelevance , false);
	}

	public static BaseMeetingRelevance addToMeetingRelevance ( BaseMeetingRelevance meetingrelevance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingRelevance dao = new MeetingRelevance();
		dao.setDataFromBase(meetingrelevance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingRelevance addUpdateMeetingRelevance ( BaseMeetingRelevance meetingrelevance ) throws Exception {
		return addUpdateMeetingRelevance ( meetingrelevance , false);
	}

	public static BaseMeetingRelevance addUpdateMeetingRelevance ( BaseMeetingRelevance meetingrelevance, boolean singleTransaction  ) throws Exception {
		if(meetingrelevance.getMeetingRelevanceId() == null) return addToMeetingRelevance(meetingrelevance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingRelevance dao = new MeetingRelevance();
		dao.setDataFromBase(meetingrelevance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingrelevance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingRelevance ( BaseMeetingRelevance bean ) throws Exception {
		MeetingRelevance dao = new MeetingRelevance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingRelevance updateMeetingRelevance ( BaseMeetingRelevance meetingrelevance ) throws Exception {
		MeetingRelevance dao = new MeetingRelevance();
		dao.setMeetingRelevanceId( meetingrelevance.getMeetingRelevanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingrelevance);
			result = dao.update();
		}
		return result == 1 ? meetingrelevance : null ;
	}

	public static BaseMeetingRelevance updateMeetingRelevanceDirect( BaseMeetingRelevance meetingrelevance ) throws Exception {
		MeetingRelevance dao = new MeetingRelevance();
		int result = 0;
		dao.setDataFromBase(meetingrelevance);
		result = dao.update();
		return result == 1 ? meetingrelevance : null ;
	}

	public static int setDeleteConditions(BaseMeetingRelevance bean, MeetingRelevance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRelevanceId() != null) {
			dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
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
			if(bean.getMeetingRoomTime() != null) {
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
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
			if(bean.getStartTime() != null) {
				dao.setConditionStartTime("=", bean.getStartTime());
				count++;
			}
			if(bean.getEndTime() != null) {
				dao.setConditionEndTime("=", bean.getEndTime());
				count++;
			}
			if(bean.getMeetingRoomName() != null) {
				dao.setConditionMeetingRoomName("=", bean.getMeetingRoomName());
				count++;
			}
			if(bean.getMeetingStatus() != null) {
				dao.setConditionMeetingStatus("=", bean.getMeetingStatus());
				count++;
			}
			if(bean.getWeekTime() != null) {
				dao.setConditionWeekTime("=", bean.getWeekTime());
				count++;
			}
			if(bean.getHowManyWeeks() != null) {
				dao.setConditionHowManyWeeks("=", bean.getHowManyWeeks());
				count++;
			}
			if(bean.getMeetingInfo() != null) {
				dao.setConditionMeetingInfo("=", bean.getMeetingInfo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingRelevance bean, MeetingRelevance dao){
		int count = 0;
		if(bean.getMeetingRelevanceId() != null) {
			dao.setConditionMeetingRelevanceId("=", bean.getMeetingRelevanceId());
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
		if(bean.getMeetingRoomTime() != null) {
			if(bean.getMeetingRoomTime().indexOf("%") >= 0)
				dao.setConditionMeetingRoomTime("like", bean.getMeetingRoomTime());
			else
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		if(bean.getStartTime() != null) {
			dao.setConditionStartTime("=", bean.getStartTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime("=", bean.getEndTime());
			count++;
		}
		if(bean.getMeetingRoomName() != null) {
			if(bean.getMeetingRoomName().indexOf("%") >= 0)
				dao.setConditionMeetingRoomName("like", bean.getMeetingRoomName());
			else
				dao.setConditionMeetingRoomName("=", bean.getMeetingRoomName());
			count++;
		}
		if(bean.getMeetingStatus() != null) {
			dao.setConditionMeetingStatus("=", bean.getMeetingStatus());
			count++;
		}
		if(bean.getWeekTime() != null) {
			dao.setConditionWeekTime("=", bean.getWeekTime());
			count++;
		}
		if(bean.getHowManyWeeks() != null) {
			dao.setConditionHowManyWeeks("=", bean.getHowManyWeeks());
			count++;
		}
		if(bean.getMeetingInfo() != null) {
			if(bean.getMeetingInfo().indexOf("%") >= 0)
				dao.setConditionMeetingInfo("like", bean.getMeetingInfo());
			else
				dao.setConditionMeetingInfo("=", bean.getMeetingInfo());
			count++;
		}
		if(bean.getMeetingTime() != null) {
			dao.setConditionMeetingTime(">=", bean.getMeetingTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		bean.setDataFromJSON(json);
		MeetingRelevance dao = new MeetingRelevance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingRelevance> rlist = new BaseCollection<>();
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingRelevance dao = new MeetingRelevance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingRelevance> result = dao.conditionalLoad(addtion);
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
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		bean.setDataFromJSON(json);
		MeetingRelevance dao = new MeetingRelevance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		bean.setDataFromJSON(json);
		MeetingRelevance dao = new MeetingRelevance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		bean.setDataFromJSON(json);
		MeetingRelevance dao = new MeetingRelevance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingRelevance bean = new BaseMeetingRelevance();
		bean.setDataFromJSON(json);
		MeetingRelevance dao = new MeetingRelevance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


