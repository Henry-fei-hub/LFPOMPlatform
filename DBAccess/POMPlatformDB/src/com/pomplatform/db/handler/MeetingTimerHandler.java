package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingTimer;
import java.util.List;
import com.pomplatform.db.dao.MeetingTimer;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingTimerHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingTimerHandler.class);

	public static BaseMeetingTimer getMeetingTimerById( 
		java.lang.Integer meeting_timer_id
	) throws Exception
	{
		MeetingTimer dao = new MeetingTimer();
		dao.setMeetingTimerId(meeting_timer_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingTimerExists( com.pomplatform.db.bean.BaseMeetingTimer bean, String additional ) throws Exception {

		MeetingTimer dao = new MeetingTimer();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingTimer( com.pomplatform.db.bean.BaseMeetingTimer bean, String additional ) throws Exception {

		MeetingTimer dao = new MeetingTimer();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingTimer> queryMeetingTimer( com.pomplatform.db.bean.BaseMeetingTimer bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingTimer dao = new MeetingTimer();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingTimer> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingTimer> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingTimer addToMeetingTimer ( BaseMeetingTimer meetingtimer )  throws Exception {
		return addToMeetingTimer ( meetingtimer , false);
	}

	public static BaseMeetingTimer addToMeetingTimer ( BaseMeetingTimer meetingtimer, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingTimer dao = new MeetingTimer();
		dao.setDataFromBase(meetingtimer);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingTimer addUpdateMeetingTimer ( BaseMeetingTimer meetingtimer ) throws Exception {
		return addUpdateMeetingTimer ( meetingtimer , false);
	}

	public static BaseMeetingTimer addUpdateMeetingTimer ( BaseMeetingTimer meetingtimer, boolean singleTransaction  ) throws Exception {
		if(meetingtimer.getMeetingTimerId() == null) return addToMeetingTimer(meetingtimer);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingTimer dao = new MeetingTimer();
		dao.setDataFromBase(meetingtimer);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingtimer); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingTimer ( BaseMeetingTimer bean ) throws Exception {
		MeetingTimer dao = new MeetingTimer();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingTimer updateMeetingTimer ( BaseMeetingTimer meetingtimer ) throws Exception {
		MeetingTimer dao = new MeetingTimer();
		dao.setMeetingTimerId( meetingtimer.getMeetingTimerId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingtimer);
			result = dao.update();
		}
		return result == 1 ? meetingtimer : null ;
	}

	public static BaseMeetingTimer updateMeetingTimerDirect( BaseMeetingTimer meetingtimer ) throws Exception {
		MeetingTimer dao = new MeetingTimer();
		int result = 0;
		dao.setDataFromBase(meetingtimer);
		result = dao.update();
		return result == 1 ? meetingtimer : null ;
	}

	public static int setDeleteConditions(BaseMeetingTimer bean, MeetingTimer dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingTimerId() != null) {
			dao.setConditionMeetingTimerId("=", bean.getMeetingTimerId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRoomTime() != null) {
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
				count++;
			}
			if(bean.getTimeFlag() != null) {
				dao.setConditionTimeFlag("=", bean.getTimeFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingTimer bean, MeetingTimer dao){
		int count = 0;
		if(bean.getMeetingTimerId() != null) {
			dao.setConditionMeetingTimerId("=", bean.getMeetingTimerId());
			count++;
		}
		if(bean.getMeetingRoomTime() != null) {
			if(bean.getMeetingRoomTime().indexOf("%") >= 0)
				dao.setConditionMeetingRoomTime("like", bean.getMeetingRoomTime());
			else
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
			count++;
		}
		if(bean.getTimeFlag() != null) {
			dao.setConditionTimeFlag("=", bean.getTimeFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingTimer bean = new BaseMeetingTimer();
		bean.setDataFromJSON(json);
		MeetingTimer dao = new MeetingTimer();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingTimer> rlist = new BaseCollection<>();
		BaseMeetingTimer bean = new BaseMeetingTimer();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingTimer dao = new MeetingTimer();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingTimer> result = dao.conditionalLoad(addtion);
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
		BaseMeetingTimer bean = new BaseMeetingTimer();
		bean.setDataFromJSON(json);
		MeetingTimer dao = new MeetingTimer();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingTimer bean = new BaseMeetingTimer();
		bean.setDataFromJSON(json);
		MeetingTimer dao = new MeetingTimer();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingTimer bean = new BaseMeetingTimer();
		bean.setDataFromJSON(json);
		MeetingTimer dao = new MeetingTimer();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingTimer bean = new BaseMeetingTimer();
		bean.setDataFromJSON(json);
		MeetingTimer dao = new MeetingTimer();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


