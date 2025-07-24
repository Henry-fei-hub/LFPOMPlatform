package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingMonthTime;
import java.util.List;
import com.pomplatform.db.dao.MeetingMonthTime;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingMonthTimeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingMonthTimeHandler.class);

	public static BaseMeetingMonthTime getMeetingMonthTimeById( 
		java.lang.Integer meeting_month_time_id
	) throws Exception
	{
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setMeetingMonthTimeId(meeting_month_time_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingMonthTimeExists( com.pomplatform.db.bean.BaseMeetingMonthTime bean, String additional ) throws Exception {

		MeetingMonthTime dao = new MeetingMonthTime();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingMonthTime( com.pomplatform.db.bean.BaseMeetingMonthTime bean, String additional ) throws Exception {

		MeetingMonthTime dao = new MeetingMonthTime();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingMonthTime> queryMeetingMonthTime( com.pomplatform.db.bean.BaseMeetingMonthTime bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingMonthTime dao = new MeetingMonthTime();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingMonthTime> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingMonthTime> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingMonthTime addToMeetingMonthTime ( BaseMeetingMonthTime meetingmonthtime )  throws Exception {
		return addToMeetingMonthTime ( meetingmonthtime , false);
	}

	public static BaseMeetingMonthTime addToMeetingMonthTime ( BaseMeetingMonthTime meetingmonthtime, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setDataFromBase(meetingmonthtime);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingMonthTime addUpdateMeetingMonthTime ( BaseMeetingMonthTime meetingmonthtime ) throws Exception {
		return addUpdateMeetingMonthTime ( meetingmonthtime , false);
	}

	public static BaseMeetingMonthTime addUpdateMeetingMonthTime ( BaseMeetingMonthTime meetingmonthtime, boolean singleTransaction  ) throws Exception {
		if(meetingmonthtime.getMeetingMonthTimeId() == null) return addToMeetingMonthTime(meetingmonthtime);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setDataFromBase(meetingmonthtime);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingmonthtime); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingMonthTime ( BaseMeetingMonthTime bean ) throws Exception {
		MeetingMonthTime dao = new MeetingMonthTime();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingMonthTime updateMeetingMonthTime ( BaseMeetingMonthTime meetingmonthtime ) throws Exception {
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setMeetingMonthTimeId( meetingmonthtime.getMeetingMonthTimeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingmonthtime);
			result = dao.update();
		}
		return result == 1 ? meetingmonthtime : null ;
	}

	public static BaseMeetingMonthTime updateMeetingMonthTimeDirect( BaseMeetingMonthTime meetingmonthtime ) throws Exception {
		MeetingMonthTime dao = new MeetingMonthTime();
		int result = 0;
		dao.setDataFromBase(meetingmonthtime);
		result = dao.update();
		return result == 1 ? meetingmonthtime : null ;
	}

	public static int setDeleteConditions(BaseMeetingMonthTime bean, MeetingMonthTime dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingMonthTimeId() != null) {
			dao.setConditionMeetingMonthTimeId("=", bean.getMeetingMonthTimeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
		}
		return count;
	}

	public static int setConditions(BaseMeetingMonthTime bean, MeetingMonthTime dao){
		int count = 0;
		if(bean.getMeetingMonthTimeId() != null) {
			dao.setConditionMeetingMonthTimeId("=", bean.getMeetingMonthTimeId());
			count++;
		}
		if(bean.getMeetingMonthDate() != null) {
			dao.setConditionMeetingMonthDate(">=", bean.getMeetingMonthDate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		bean.setDataFromJSON(json);
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingMonthTime> rlist = new BaseCollection<>();
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingMonthTime dao = new MeetingMonthTime();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingMonthTime> result = dao.conditionalLoad(addtion);
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
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		bean.setDataFromJSON(json);
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		bean.setDataFromJSON(json);
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		bean.setDataFromJSON(json);
		MeetingMonthTime dao = new MeetingMonthTime();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingMonthTime bean = new BaseMeetingMonthTime();
		bean.setDataFromJSON(json);
		MeetingMonthTime dao = new MeetingMonthTime();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


