package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttendanceRuleTime;
import com.pomplatform.db.dao.AttendanceRuleTime;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttendanceRuleTimeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttendanceRuleTimeHandler.class);

	public static BaseAttendanceRuleTime getAttendanceRuleTimeById( 
		java.lang.Integer attendance_rule_time_id
	) throws Exception
	{
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setAttendanceRuleTimeId(attendance_rule_time_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttendanceRuleTimeExists( com.pomplatform.db.bean.BaseAttendanceRuleTime bean, String additional ) throws Exception {

		AttendanceRuleTime dao = new AttendanceRuleTime();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttendanceRuleTime( com.pomplatform.db.bean.BaseAttendanceRuleTime bean, String additional ) throws Exception {

		AttendanceRuleTime dao = new AttendanceRuleTime();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttendanceRuleTime> queryAttendanceRuleTime( com.pomplatform.db.bean.BaseAttendanceRuleTime bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttendanceRuleTime dao = new AttendanceRuleTime();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttendanceRuleTime> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttendanceRuleTime> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttendanceRuleTime addToAttendanceRuleTime ( BaseAttendanceRuleTime attendanceruletime )  throws Exception {
		return addToAttendanceRuleTime ( attendanceruletime , false);
	}

	public static BaseAttendanceRuleTime addToAttendanceRuleTime ( BaseAttendanceRuleTime attendanceruletime, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setDataFromBase(attendanceruletime);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttendanceRuleTime addUpdateAttendanceRuleTime ( BaseAttendanceRuleTime attendanceruletime ) throws Exception {
		return addUpdateAttendanceRuleTime ( attendanceruletime , false);
	}

	public static BaseAttendanceRuleTime addUpdateAttendanceRuleTime ( BaseAttendanceRuleTime attendanceruletime, boolean singleTransaction  ) throws Exception {
		if(attendanceruletime.getAttendanceRuleTimeId() == null) return addToAttendanceRuleTime(attendanceruletime);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setDataFromBase(attendanceruletime);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attendanceruletime); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttendanceRuleTime ( BaseAttendanceRuleTime bean ) throws Exception {
		AttendanceRuleTime dao = new AttendanceRuleTime();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttendanceRuleTime updateAttendanceRuleTime ( BaseAttendanceRuleTime attendanceruletime ) throws Exception {
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setAttendanceRuleTimeId( attendanceruletime.getAttendanceRuleTimeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attendanceruletime);
			result = dao.update();
		}
		return result == 1 ? attendanceruletime : null ;
	}

	public static BaseAttendanceRuleTime updateAttendanceRuleTimeDirect( BaseAttendanceRuleTime attendanceruletime ) throws Exception {
		AttendanceRuleTime dao = new AttendanceRuleTime();
		int result = 0;
		dao.setDataFromBase(attendanceruletime);
		result = dao.update();
		return result == 1 ? attendanceruletime : null ;
	}

	public static int setDeleteConditions(BaseAttendanceRuleTime bean, AttendanceRuleTime dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttendanceRuleTimeId() != null) {
			dao.setConditionAttendanceRuleTimeId("=", bean.getAttendanceRuleTimeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAttendanceRuleId() != null) {
				dao.setConditionAttendanceRuleId("=", bean.getAttendanceRuleId());
				count++;
			}
			if(bean.getFromTime() != null) {
				dao.setConditionFromTime("=", bean.getFromTime());
				count++;
			}
			if(bean.getIsCrossFrom() != null) {
				dao.setConditionIsCrossFrom("=", bean.getIsCrossFrom());
				count++;
			}
			if(bean.getToTime() != null) {
				dao.setConditionToTime("=", bean.getToTime());
				count++;
			}
			if(bean.getIsCrossTo() != null) {
				dao.setConditionIsCrossTo("=", bean.getIsCrossTo());
				count++;
			}
			if(bean.getMinutes() != null) {
				dao.setConditionMinutes("=", bean.getMinutes());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttendanceRuleTime bean, AttendanceRuleTime dao){
		int count = 0;
		if(bean.getAttendanceRuleTimeId() != null) {
			dao.setConditionAttendanceRuleTimeId("=", bean.getAttendanceRuleTimeId());
			count++;
		}
		if(bean.getAttendanceRuleId() != null) {
			dao.setConditionAttendanceRuleId("=", bean.getAttendanceRuleId());
			count++;
		}
		if(bean.getFromTime() != null) {
			if(bean.getFromTime().indexOf("%") >= 0)
				dao.setConditionFromTime("like", bean.getFromTime());
			else
				dao.setConditionFromTime("=", bean.getFromTime());
			count++;
		}
		if(bean.getIsCrossFrom() != null) {
			dao.setConditionIsCrossFrom("=", bean.getIsCrossFrom());
			count++;
		}
		if(bean.getToTime() != null) {
			if(bean.getToTime().indexOf("%") >= 0)
				dao.setConditionToTime("like", bean.getToTime());
			else
				dao.setConditionToTime("=", bean.getToTime());
			count++;
		}
		if(bean.getIsCrossTo() != null) {
			dao.setConditionIsCrossTo("=", bean.getIsCrossTo());
			count++;
		}
		if(bean.getMinutes() != null) {
			dao.setConditionMinutes("=", bean.getMinutes());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		bean.setDataFromJSON(json);
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttendanceRuleTime> rlist = new BaseCollection<>();
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttendanceRuleTime dao = new AttendanceRuleTime();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttendanceRuleTime> result = dao.conditionalLoad(addtion);
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
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		bean.setDataFromJSON(json);
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		bean.setDataFromJSON(json);
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		bean.setDataFromJSON(json);
		AttendanceRuleTime dao = new AttendanceRuleTime();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttendanceRuleTime bean = new BaseAttendanceRuleTime();
		bean.setDataFromJSON(json);
		AttendanceRuleTime dao = new AttendanceRuleTime();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


