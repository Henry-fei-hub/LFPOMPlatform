package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseLeaveTypeLinkArea;
import com.pomplatform.db.dao.LeaveTypeLinkArea;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class LeaveTypeLinkAreaHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(LeaveTypeLinkAreaHandler.class);

	public static BaseLeaveTypeLinkArea getLeaveTypeLinkAreaById( 
		java.lang.Integer leave_type_link_area_id
	) throws Exception
	{
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setLeaveTypeLinkAreaId(leave_type_link_area_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isLeaveTypeLinkAreaExists( com.pomplatform.db.bean.BaseLeaveTypeLinkArea bean, String additional ) throws Exception {

		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countLeaveTypeLinkArea( com.pomplatform.db.bean.BaseLeaveTypeLinkArea bean, String additional ) throws Exception {

		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseLeaveTypeLinkArea> queryLeaveTypeLinkArea( com.pomplatform.db.bean.BaseLeaveTypeLinkArea bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseLeaveTypeLinkArea> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseLeaveTypeLinkArea> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseLeaveTypeLinkArea addToLeaveTypeLinkArea ( BaseLeaveTypeLinkArea leavetypelinkarea )  throws Exception {
		return addToLeaveTypeLinkArea ( leavetypelinkarea , false);
	}

	public static BaseLeaveTypeLinkArea addToLeaveTypeLinkArea ( BaseLeaveTypeLinkArea leavetypelinkarea, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setDataFromBase(leavetypelinkarea);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseLeaveTypeLinkArea addUpdateLeaveTypeLinkArea ( BaseLeaveTypeLinkArea leavetypelinkarea ) throws Exception {
		return addUpdateLeaveTypeLinkArea ( leavetypelinkarea , false);
	}

	public static BaseLeaveTypeLinkArea addUpdateLeaveTypeLinkArea ( BaseLeaveTypeLinkArea leavetypelinkarea, boolean singleTransaction  ) throws Exception {
		if(leavetypelinkarea.getLeaveTypeLinkAreaId() == null) return addToLeaveTypeLinkArea(leavetypelinkarea);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setDataFromBase(leavetypelinkarea);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(leavetypelinkarea); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteLeaveTypeLinkArea ( BaseLeaveTypeLinkArea bean ) throws Exception {
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseLeaveTypeLinkArea updateLeaveTypeLinkArea ( BaseLeaveTypeLinkArea leavetypelinkarea ) throws Exception {
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setLeaveTypeLinkAreaId( leavetypelinkarea.getLeaveTypeLinkAreaId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(leavetypelinkarea);
			result = dao.update();
		}
		return result == 1 ? leavetypelinkarea : null ;
	}

	public static BaseLeaveTypeLinkArea updateLeaveTypeLinkAreaDirect( BaseLeaveTypeLinkArea leavetypelinkarea ) throws Exception {
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		int result = 0;
		dao.setDataFromBase(leavetypelinkarea);
		result = dao.update();
		return result == 1 ? leavetypelinkarea : null ;
	}

	public static int setDeleteConditions(BaseLeaveTypeLinkArea bean, LeaveTypeLinkArea dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getLeaveTypeLinkAreaId() != null) {
			dao.setConditionLeaveTypeLinkAreaId("=", bean.getLeaveTypeLinkAreaId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getLeaveTypeId() != null) {
				dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
				count++;
			}
			if(bean.getAreaId() != null) {
				dao.setConditionAreaId("=", bean.getAreaId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseLeaveTypeLinkArea bean, LeaveTypeLinkArea dao){
		int count = 0;
		if(bean.getLeaveTypeLinkAreaId() != null) {
			dao.setConditionLeaveTypeLinkAreaId("=", bean.getLeaveTypeLinkAreaId());
			count++;
		}
		if(bean.getLeaveTypeId() != null) {
			dao.setConditionLeaveTypeId("=", bean.getLeaveTypeId());
			count++;
		}
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
		}
		if(bean.getDays() != null) {
			dao.setConditionDays("=", bean.getDays());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		bean.setDataFromJSON(json);
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseLeaveTypeLinkArea> rlist = new BaseCollection<>();
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseLeaveTypeLinkArea> result = dao.conditionalLoad(addtion);
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
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		bean.setDataFromJSON(json);
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		bean.setDataFromJSON(json);
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		bean.setDataFromJSON(json);
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseLeaveTypeLinkArea bean = new BaseLeaveTypeLinkArea();
		bean.setDataFromJSON(json);
		LeaveTypeLinkArea dao = new LeaveTypeLinkArea();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


