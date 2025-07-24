package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingRoomTime;
import java.util.List;
import com.pomplatform.db.dao.MeetingRoomTime;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingRoomTimeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingRoomTimeHandler.class);

	public static BaseMeetingRoomTime getMeetingRoomTimeById( 
		java.lang.Integer meeting_room_time_id
	) throws Exception
	{
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setMeetingRoomTimeId(meeting_room_time_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingRoomTimeExists( com.pomplatform.db.bean.BaseMeetingRoomTime bean, String additional ) throws Exception {

		MeetingRoomTime dao = new MeetingRoomTime();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingRoomTime( com.pomplatform.db.bean.BaseMeetingRoomTime bean, String additional ) throws Exception {

		MeetingRoomTime dao = new MeetingRoomTime();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingRoomTime> queryMeetingRoomTime( com.pomplatform.db.bean.BaseMeetingRoomTime bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingRoomTime dao = new MeetingRoomTime();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingRoomTime> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingRoomTime> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingRoomTime addToMeetingRoomTime ( BaseMeetingRoomTime meetingroomtime )  throws Exception {
		return addToMeetingRoomTime ( meetingroomtime , false);
	}

	public static BaseMeetingRoomTime addToMeetingRoomTime ( BaseMeetingRoomTime meetingroomtime, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setDataFromBase(meetingroomtime);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingRoomTime addUpdateMeetingRoomTime ( BaseMeetingRoomTime meetingroomtime ) throws Exception {
		return addUpdateMeetingRoomTime ( meetingroomtime , false);
	}

	public static BaseMeetingRoomTime addUpdateMeetingRoomTime ( BaseMeetingRoomTime meetingroomtime, boolean singleTransaction  ) throws Exception {
		if(meetingroomtime.getMeetingRoomTimeId() == null) return addToMeetingRoomTime(meetingroomtime);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setDataFromBase(meetingroomtime);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingroomtime); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingRoomTime ( BaseMeetingRoomTime bean ) throws Exception {
		MeetingRoomTime dao = new MeetingRoomTime();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingRoomTime updateMeetingRoomTime ( BaseMeetingRoomTime meetingroomtime ) throws Exception {
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setMeetingRoomTimeId( meetingroomtime.getMeetingRoomTimeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingroomtime);
			result = dao.update();
		}
		return result == 1 ? meetingroomtime : null ;
	}

	public static BaseMeetingRoomTime updateMeetingRoomTimeDirect( BaseMeetingRoomTime meetingroomtime ) throws Exception {
		MeetingRoomTime dao = new MeetingRoomTime();
		int result = 0;
		dao.setDataFromBase(meetingroomtime);
		result = dao.update();
		return result == 1 ? meetingroomtime : null ;
	}

	public static int setDeleteConditions(BaseMeetingRoomTime bean, MeetingRoomTime dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRoomTimeId() != null) {
			dao.setConditionMeetingRoomTimeId("=", bean.getMeetingRoomTimeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRoomTime() != null) {
				dao.setConditionMeetingRoomTime("=", bean.getMeetingRoomTime());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingRoomTime bean, MeetingRoomTime dao){
		int count = 0;
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		bean.setDataFromJSON(json);
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingRoomTime> rlist = new BaseCollection<>();
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingRoomTime dao = new MeetingRoomTime();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingRoomTime> result = dao.conditionalLoad(addtion);
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
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		bean.setDataFromJSON(json);
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		bean.setDataFromJSON(json);
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		bean.setDataFromJSON(json);
		MeetingRoomTime dao = new MeetingRoomTime();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingRoomTime bean = new BaseMeetingRoomTime();
		bean.setDataFromJSON(json);
		MeetingRoomTime dao = new MeetingRoomTime();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


