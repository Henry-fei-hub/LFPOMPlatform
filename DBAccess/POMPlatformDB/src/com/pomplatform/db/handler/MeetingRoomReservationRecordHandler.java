package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingRoomReservationRecord;
import java.util.List;
import com.pomplatform.db.dao.MeetingRoomReservationRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingRoomReservationRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingRoomReservationRecordHandler.class);

	public static BaseMeetingRoomReservationRecord getMeetingRoomReservationRecordById( 
		java.lang.Integer meeting_room_reservation_record_id
	) throws Exception
	{
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setMeetingRoomReservationRecordId(meeting_room_reservation_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingRoomReservationRecordExists( com.pomplatform.db.bean.BaseMeetingRoomReservationRecord bean, String additional ) throws Exception {

		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingRoomReservationRecord( com.pomplatform.db.bean.BaseMeetingRoomReservationRecord bean, String additional ) throws Exception {

		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingRoomReservationRecord> queryMeetingRoomReservationRecord( com.pomplatform.db.bean.BaseMeetingRoomReservationRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingRoomReservationRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingRoomReservationRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingRoomReservationRecord addToMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord meetingroomreservationrecord )  throws Exception {
		return addToMeetingRoomReservationRecord ( meetingroomreservationrecord , false);
	}

	public static BaseMeetingRoomReservationRecord addToMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord meetingroomreservationrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setDataFromBase(meetingroomreservationrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingRoomReservationRecord addUpdateMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord meetingroomreservationrecord ) throws Exception {
		return addUpdateMeetingRoomReservationRecord ( meetingroomreservationrecord , false);
	}

	public static BaseMeetingRoomReservationRecord addUpdateMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord meetingroomreservationrecord, boolean singleTransaction  ) throws Exception {
		if(meetingroomreservationrecord.getMeetingRoomReservationRecordId() == null) return addToMeetingRoomReservationRecord(meetingroomreservationrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setDataFromBase(meetingroomreservationrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingroomreservationrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord bean ) throws Exception {
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingRoomReservationRecord updateMeetingRoomReservationRecord ( BaseMeetingRoomReservationRecord meetingroomreservationrecord ) throws Exception {
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setMeetingRoomReservationRecordId( meetingroomreservationrecord.getMeetingRoomReservationRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingroomreservationrecord);
			result = dao.update();
		}
		return result == 1 ? meetingroomreservationrecord : null ;
	}

	public static BaseMeetingRoomReservationRecord updateMeetingRoomReservationRecordDirect( BaseMeetingRoomReservationRecord meetingroomreservationrecord ) throws Exception {
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		int result = 0;
		dao.setDataFromBase(meetingroomreservationrecord);
		result = dao.update();
		return result == 1 ? meetingroomreservationrecord : null ;
	}

	public static int setDeleteConditions(BaseMeetingRoomReservationRecord bean, MeetingRoomReservationRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRoomReservationRecordId() != null) {
			dao.setConditionMeetingRoomReservationRecordId("=", bean.getMeetingRoomReservationRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRoomId() != null) {
				dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
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
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingRoomReservationRecord bean, MeetingRoomReservationRecord dao){
		int count = 0;
		if(bean.getMeetingRoomReservationRecordId() != null) {
			dao.setConditionMeetingRoomReservationRecordId("=", bean.getMeetingRoomReservationRecordId());
			count++;
		}
		if(bean.getMeetingRoomId() != null) {
			dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
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
		if(bean.getMeetingDate() != null) {
			dao.setConditionMeetingDate(">=", bean.getMeetingDate());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		bean.setDataFromJSON(json);
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingRoomReservationRecord> rlist = new BaseCollection<>();
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingRoomReservationRecord> result = dao.conditionalLoad(addtion);
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
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		bean.setDataFromJSON(json);
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		bean.setDataFromJSON(json);
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		bean.setDataFromJSON(json);
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingRoomReservationRecord bean = new BaseMeetingRoomReservationRecord();
		bean.setDataFromJSON(json);
		MeetingRoomReservationRecord dao = new MeetingRoomReservationRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


