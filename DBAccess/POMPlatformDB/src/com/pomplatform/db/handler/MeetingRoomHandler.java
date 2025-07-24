package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingRoom;
import java.util.List;
import com.pomplatform.db.dao.MeetingRoom;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingRoomHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingRoomHandler.class);

	public static BaseMeetingRoom getMeetingRoomById( 
		java.lang.Integer meeting_room_id
	) throws Exception
	{
		MeetingRoom dao = new MeetingRoom();
		dao.setMeetingRoomId(meeting_room_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingRoomExists( com.pomplatform.db.bean.BaseMeetingRoom bean, String additional ) throws Exception {

		MeetingRoom dao = new MeetingRoom();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingRoom( com.pomplatform.db.bean.BaseMeetingRoom bean, String additional ) throws Exception {

		MeetingRoom dao = new MeetingRoom();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingRoom> queryMeetingRoom( com.pomplatform.db.bean.BaseMeetingRoom bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingRoom dao = new MeetingRoom();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingRoom> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingRoom> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingRoom addToMeetingRoom ( BaseMeetingRoom meetingroom )  throws Exception {
		return addToMeetingRoom ( meetingroom , false);
	}

	public static BaseMeetingRoom addToMeetingRoom ( BaseMeetingRoom meetingroom, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingRoom dao = new MeetingRoom();
		dao.setDataFromBase(meetingroom);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingRoom addUpdateMeetingRoom ( BaseMeetingRoom meetingroom ) throws Exception {
		return addUpdateMeetingRoom ( meetingroom , false);
	}

	public static BaseMeetingRoom addUpdateMeetingRoom ( BaseMeetingRoom meetingroom, boolean singleTransaction  ) throws Exception {
		if(meetingroom.getMeetingRoomId() == null) return addToMeetingRoom(meetingroom);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingRoom dao = new MeetingRoom();
		dao.setDataFromBase(meetingroom);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingroom); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingRoom ( BaseMeetingRoom bean ) throws Exception {
		MeetingRoom dao = new MeetingRoom();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingRoom updateMeetingRoom ( BaseMeetingRoom meetingroom ) throws Exception {
		MeetingRoom dao = new MeetingRoom();
		dao.setMeetingRoomId( meetingroom.getMeetingRoomId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingroom);
			result = dao.update();
		}
		return result == 1 ? meetingroom : null ;
	}

	public static BaseMeetingRoom updateMeetingRoomDirect( BaseMeetingRoom meetingroom ) throws Exception {
		MeetingRoom dao = new MeetingRoom();
		int result = 0;
		dao.setDataFromBase(meetingroom);
		result = dao.update();
		return result == 1 ? meetingroom : null ;
	}

	public static int setDeleteConditions(BaseMeetingRoom bean, MeetingRoom dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRoomId() != null) {
			dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMeetingRoomName() != null) {
				dao.setConditionMeetingRoomName("=", bean.getMeetingRoomName());
				count++;
			}
			if(bean.getSite() != null) {
				dao.setConditionSite("=", bean.getSite());
				count++;
			}
			if(bean.getContainNum() != null) {
				dao.setConditionContainNum("=", bean.getContainNum());
				count++;
			}
			if(bean.getCompanyRecordId() != null) {
				dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getMeetingRoomMaster() != null) {
				dao.setConditionMeetingRoomMaster("=", bean.getMeetingRoomMaster());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingRoom bean, MeetingRoom dao){
		int count = 0;
		if(bean.getMeetingRoomId() != null) {
			dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
			count++;
		}
		if(bean.getMeetingRoomName() != null) {
			if(bean.getMeetingRoomName().indexOf("%") >= 0)
				dao.setConditionMeetingRoomName("like", bean.getMeetingRoomName());
			else
				dao.setConditionMeetingRoomName("=", bean.getMeetingRoomName());
			count++;
		}
		if(bean.getSite() != null) {
			if(bean.getSite().indexOf("%") >= 0)
				dao.setConditionSite("like", bean.getSite());
			else
				dao.setConditionSite("=", bean.getSite());
			count++;
		}
		if(bean.getContainNum() != null) {
			dao.setConditionContainNum("=", bean.getContainNum());
			count++;
		}
		if(bean.getCompanyRecordId() != null) {
			dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getMeetingRoomMaster() != null) {
			if(bean.getMeetingRoomMaster().indexOf("%") >= 0)
				dao.setConditionMeetingRoomMaster("like", bean.getMeetingRoomMaster());
			else
				dao.setConditionMeetingRoomMaster("=", bean.getMeetingRoomMaster());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingRoom bean = new BaseMeetingRoom();
		bean.setDataFromJSON(json);
		MeetingRoom dao = new MeetingRoom();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingRoom> rlist = new BaseCollection<>();
		BaseMeetingRoom bean = new BaseMeetingRoom();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingRoom dao = new MeetingRoom();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingRoom> result = dao.conditionalLoad(addtion);
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
		BaseMeetingRoom bean = new BaseMeetingRoom();
		bean.setDataFromJSON(json);
		MeetingRoom dao = new MeetingRoom();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingRoom bean = new BaseMeetingRoom();
		bean.setDataFromJSON(json);
		MeetingRoom dao = new MeetingRoom();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingRoom bean = new BaseMeetingRoom();
		bean.setDataFromJSON(json);
		MeetingRoom dao = new MeetingRoom();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingRoom bean = new BaseMeetingRoom();
		bean.setDataFromJSON(json);
		MeetingRoom dao = new MeetingRoom();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


