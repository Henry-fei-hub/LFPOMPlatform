package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingDefinition;
import java.util.List;
import com.pomplatform.db.dao.MeetingDefinition;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingDefinitionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingDefinitionHandler.class);

	public static BaseMeetingDefinition getMeetingDefinitionById( 
		java.lang.Integer meeting_define_id
	) throws Exception
	{
		MeetingDefinition dao = new MeetingDefinition();
		dao.setMeetingDefineId(meeting_define_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingDefinitionExists( com.pomplatform.db.bean.BaseMeetingDefinition bean, String additional ) throws Exception {

		MeetingDefinition dao = new MeetingDefinition();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingDefinition( com.pomplatform.db.bean.BaseMeetingDefinition bean, String additional ) throws Exception {

		MeetingDefinition dao = new MeetingDefinition();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingDefinition> queryMeetingDefinition( com.pomplatform.db.bean.BaseMeetingDefinition bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingDefinition dao = new MeetingDefinition();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingDefinition> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingDefinition> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingDefinition addToMeetingDefinition ( BaseMeetingDefinition meetingdefinition )  throws Exception {
		return addToMeetingDefinition ( meetingdefinition , false);
	}

	public static BaseMeetingDefinition addToMeetingDefinition ( BaseMeetingDefinition meetingdefinition, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingDefinition dao = new MeetingDefinition();
		dao.setDataFromBase(meetingdefinition);
		int result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingDefinition addUpdateMeetingDefinition ( BaseMeetingDefinition meetingdefinition ) throws Exception {
		return addUpdateMeetingDefinition ( meetingdefinition , false);
	}

	public static BaseMeetingDefinition addUpdateMeetingDefinition ( BaseMeetingDefinition meetingdefinition, boolean singleTransaction  ) throws Exception {
		if(meetingdefinition.getMeetingDefineId() == null) return addToMeetingDefinition(meetingdefinition);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingDefinition dao = new MeetingDefinition();
		dao.setDataFromBase(meetingdefinition);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingdefinition); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save(false);
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingDefinition ( BaseMeetingDefinition bean ) throws Exception {
		MeetingDefinition dao = new MeetingDefinition();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingDefinition updateMeetingDefinition ( BaseMeetingDefinition meetingdefinition ) throws Exception {
		MeetingDefinition dao = new MeetingDefinition();
		dao.setMeetingDefineId( meetingdefinition.getMeetingDefineId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingdefinition);
			result = dao.update();
		}
		return result == 1 ? meetingdefinition : null ;
	}

	public static BaseMeetingDefinition updateMeetingDefinitionDirect( BaseMeetingDefinition meetingdefinition ) throws Exception {
		MeetingDefinition dao = new MeetingDefinition();
		int result = 0;
		dao.setDataFromBase(meetingdefinition);
		result = dao.update();
		return result == 1 ? meetingdefinition : null ;
	}

	public static int setDeleteConditions(BaseMeetingDefinition bean, MeetingDefinition dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingDefineId() != null) {
			dao.setConditionMeetingDefineId("=", bean.getMeetingDefineId());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getCompanyRecordId() != null) {
				dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
				count++;
			}
			if(bean.getMeetingRoomMaster() != null) {
				dao.setConditionMeetingRoomMaster("=", bean.getMeetingRoomMaster());
				count++;
			}
			if(bean.getMinAppointmentTime() != null) {
				dao.setConditionMinAppointmentTime("=", bean.getMinAppointmentTime());
				count++;
			}
			if(bean.getOvertime() != null) {
				dao.setConditionOvertime("=", bean.getOvertime());
				count++;
			}
			if(bean.getRemindTime() != null) {
				dao.setConditionRemindTime("=", bean.getRemindTime());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingDefinition bean, MeetingDefinition dao){
		int count = 0;
		if(bean.getMeetingDefineId() != null) {
			dao.setConditionMeetingDefineId("=", bean.getMeetingDefineId());
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
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getCompanyRecordId() != null) {
			dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
			count++;
		}
		if(bean.getMeetingRoomMaster() != null) {
			if(bean.getMeetingRoomMaster().indexOf("%") >= 0)
				dao.setConditionMeetingRoomMaster("like", bean.getMeetingRoomMaster());
			else
				dao.setConditionMeetingRoomMaster("=", bean.getMeetingRoomMaster());
			count++;
		}
		if(bean.getMinAppointmentTime() != null) {
			dao.setConditionMinAppointmentTime("=", bean.getMinAppointmentTime());
			count++;
		}
		if(bean.getOvertime() != null) {
			dao.setConditionOvertime("=", bean.getOvertime());
			count++;
		}
		if(bean.getRemindTime() != null) {
			dao.setConditionRemindTime("=", bean.getRemindTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		bean.setDataFromJSON(json);
		MeetingDefinition dao = new MeetingDefinition();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingDefinition> rlist = new BaseCollection<>();
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingDefinition dao = new MeetingDefinition();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingDefinition> result = dao.conditionalLoad(addtion);
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
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		bean.setDataFromJSON(json);
		MeetingDefinition dao = new MeetingDefinition();
		dao.setDataFromBase(bean);
		int num = dao.save(false);
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		bean.setDataFromJSON(json);
		MeetingDefinition dao = new MeetingDefinition();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		bean.setDataFromJSON(json);
		MeetingDefinition dao = new MeetingDefinition();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingDefinition bean = new BaseMeetingDefinition();
		bean.setDataFromJSON(json);
		MeetingDefinition dao = new MeetingDefinition();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(false); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


