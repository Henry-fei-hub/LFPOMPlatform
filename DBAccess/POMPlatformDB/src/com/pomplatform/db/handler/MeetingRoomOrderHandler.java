package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMeetingRoomOrder;
import java.util.List;
import com.pomplatform.db.dao.MeetingRoomOrder;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MeetingRoomOrderHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MeetingRoomOrderHandler.class);

	public static BaseMeetingRoomOrder getMeetingRoomOrderById( 
		java.lang.Integer meeting_room_order_id
	) throws Exception
	{
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setMeetingRoomOrderId(meeting_room_order_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMeetingRoomOrderExists( com.pomplatform.db.bean.BaseMeetingRoomOrder bean, String additional ) throws Exception {

		MeetingRoomOrder dao = new MeetingRoomOrder();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMeetingRoomOrder( com.pomplatform.db.bean.BaseMeetingRoomOrder bean, String additional ) throws Exception {

		MeetingRoomOrder dao = new MeetingRoomOrder();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMeetingRoomOrder> queryMeetingRoomOrder( com.pomplatform.db.bean.BaseMeetingRoomOrder bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MeetingRoomOrder dao = new MeetingRoomOrder();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMeetingRoomOrder> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMeetingRoomOrder> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMeetingRoomOrder addToMeetingRoomOrder ( BaseMeetingRoomOrder meetingroomorder )  throws Exception {
		return addToMeetingRoomOrder ( meetingroomorder , false);
	}

	public static BaseMeetingRoomOrder addToMeetingRoomOrder ( BaseMeetingRoomOrder meetingroomorder, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setDataFromBase(meetingroomorder);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMeetingRoomOrder addUpdateMeetingRoomOrder ( BaseMeetingRoomOrder meetingroomorder ) throws Exception {
		return addUpdateMeetingRoomOrder ( meetingroomorder , false);
	}

	public static BaseMeetingRoomOrder addUpdateMeetingRoomOrder ( BaseMeetingRoomOrder meetingroomorder, boolean singleTransaction  ) throws Exception {
		if(meetingroomorder.getMeetingRoomOrderId() == null) return addToMeetingRoomOrder(meetingroomorder);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setDataFromBase(meetingroomorder);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(meetingroomorder); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMeetingRoomOrder ( BaseMeetingRoomOrder bean ) throws Exception {
		MeetingRoomOrder dao = new MeetingRoomOrder();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMeetingRoomOrder updateMeetingRoomOrder ( BaseMeetingRoomOrder meetingroomorder ) throws Exception {
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setMeetingRoomOrderId( meetingroomorder.getMeetingRoomOrderId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(meetingroomorder);
			result = dao.update();
		}
		return result == 1 ? meetingroomorder : null ;
	}

	public static BaseMeetingRoomOrder updateMeetingRoomOrderDirect( BaseMeetingRoomOrder meetingroomorder ) throws Exception {
		MeetingRoomOrder dao = new MeetingRoomOrder();
		int result = 0;
		dao.setDataFromBase(meetingroomorder);
		result = dao.update();
		return result == 1 ? meetingroomorder : null ;
	}

	public static int setDeleteConditions(BaseMeetingRoomOrder bean, MeetingRoomOrder dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMeetingRoomOrderId() != null) {
			dao.setConditionMeetingRoomOrderId("=", bean.getMeetingRoomOrderId());
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
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getMobile() != null) {
				dao.setConditionMobile("=", bean.getMobile());
				count++;
			}
			if(bean.getMeetingTitle() != null) {
				dao.setConditionMeetingTitle("=", bean.getMeetingTitle());
				count++;
			}
			if(bean.getMeetingMember() != null) {
				dao.setConditionMeetingMember("=", bean.getMeetingMember());
				count++;
			}
			if(bean.getMeetingNum() != null) {
				dao.setConditionMeetingNum("=", bean.getMeetingNum());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMeetingRoomOrder bean, MeetingRoomOrder dao){
		int count = 0;
		if(bean.getMeetingRoomOrderId() != null) {
			dao.setConditionMeetingRoomOrderId("=", bean.getMeetingRoomOrderId());
			count++;
		}
		if(bean.getMeetingRoomId() != null) {
			if(bean.getMeetingRoomId().indexOf("%") >= 0)
				dao.setConditionMeetingRoomId("like", bean.getMeetingRoomId());
			else
				dao.setConditionMeetingRoomId("=", bean.getMeetingRoomId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getMobile() != null) {
			if(bean.getMobile().indexOf("%") >= 0)
				dao.setConditionMobile("like", bean.getMobile());
			else
				dao.setConditionMobile("=", bean.getMobile());
			count++;
		}
		if(bean.getMeetingTitle() != null) {
			if(bean.getMeetingTitle().indexOf("%") >= 0)
				dao.setConditionMeetingTitle("like", bean.getMeetingTitle());
			else
				dao.setConditionMeetingTitle("=", bean.getMeetingTitle());
			count++;
		}
		if(bean.getMeetingMember() != null) {
			if(bean.getMeetingMember().indexOf("%") >= 0)
				dao.setConditionMeetingMember("like", bean.getMeetingMember());
			else
				dao.setConditionMeetingMember("=", bean.getMeetingMember());
			count++;
		}
		if(bean.getMeetingNum() != null) {
			dao.setConditionMeetingNum("=", bean.getMeetingNum());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
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
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		bean.setDataFromJSON(json);
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMeetingRoomOrder> rlist = new BaseCollection<>();
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MeetingRoomOrder dao = new MeetingRoomOrder();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMeetingRoomOrder> result = dao.conditionalLoad(addtion);
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
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		bean.setDataFromJSON(json);
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		bean.setDataFromJSON(json);
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		bean.setDataFromJSON(json);
		MeetingRoomOrder dao = new MeetingRoomOrder();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMeetingRoomOrder bean = new BaseMeetingRoomOrder();
		bean.setDataFromJSON(json);
		MeetingRoomOrder dao = new MeetingRoomOrder();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


