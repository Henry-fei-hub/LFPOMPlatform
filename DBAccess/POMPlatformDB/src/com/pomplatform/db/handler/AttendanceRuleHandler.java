package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseAttendanceRule;
import com.pomplatform.db.dao.AttendanceRule;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AttendanceRuleHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AttendanceRuleHandler.class);

	public static BaseAttendanceRule getAttendanceRuleById( 
		java.lang.Integer attendance_rule_id
	) throws Exception
	{
		AttendanceRule dao = new AttendanceRule();
		dao.setAttendanceRuleId(attendance_rule_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAttendanceRuleExists( com.pomplatform.db.bean.BaseAttendanceRule bean, String additional ) throws Exception {

		AttendanceRule dao = new AttendanceRule();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countAttendanceRule( com.pomplatform.db.bean.BaseAttendanceRule bean, String additional ) throws Exception {

		AttendanceRule dao = new AttendanceRule();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseAttendanceRule> queryAttendanceRule( com.pomplatform.db.bean.BaseAttendanceRule bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		AttendanceRule dao = new AttendanceRule();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseAttendanceRule> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseAttendanceRule> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseAttendanceRule addToAttendanceRule ( BaseAttendanceRule attendancerule )  throws Exception {
		return addToAttendanceRule ( attendancerule , false);
	}

	public static BaseAttendanceRule addToAttendanceRule ( BaseAttendanceRule attendancerule, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		AttendanceRule dao = new AttendanceRule();
		dao.setDataFromBase(attendancerule);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseAttendanceRule addUpdateAttendanceRule ( BaseAttendanceRule attendancerule ) throws Exception {
		return addUpdateAttendanceRule ( attendancerule , false);
	}

	public static BaseAttendanceRule addUpdateAttendanceRule ( BaseAttendanceRule attendancerule, boolean singleTransaction  ) throws Exception {
		if(attendancerule.getAttendanceRuleId() == null) return addToAttendanceRule(attendancerule);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		AttendanceRule dao = new AttendanceRule();
		dao.setDataFromBase(attendancerule);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(attendancerule); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteAttendanceRule ( BaseAttendanceRule bean ) throws Exception {
		AttendanceRule dao = new AttendanceRule();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseAttendanceRule updateAttendanceRule ( BaseAttendanceRule attendancerule ) throws Exception {
		AttendanceRule dao = new AttendanceRule();
		dao.setAttendanceRuleId( attendancerule.getAttendanceRuleId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(attendancerule);
			result = dao.update();
		}
		return result == 1 ? attendancerule : null ;
	}

	public static BaseAttendanceRule updateAttendanceRuleDirect( BaseAttendanceRule attendancerule ) throws Exception {
		AttendanceRule dao = new AttendanceRule();
		int result = 0;
		dao.setDataFromBase(attendancerule);
		result = dao.update();
		return result == 1 ? attendancerule : null ;
	}

	public static int setDeleteConditions(BaseAttendanceRule bean, AttendanceRule dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAttendanceRuleId() != null) {
			dao.setConditionAttendanceRuleId("=", bean.getAttendanceRuleId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getRuleName() != null) {
				dao.setConditionRuleName("=", bean.getRuleName());
				count++;
			}
			if(bean.getRuleType() != null) {
				dao.setConditionRuleType("=", bean.getRuleType());
				count++;
			}
			if(bean.getIsEnable() != null) {
				dao.setConditionIsEnable("=", bean.getIsEnable());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseAttendanceRule bean, AttendanceRule dao){
		int count = 0;
		if(bean.getAttendanceRuleId() != null) {
			dao.setConditionAttendanceRuleId("=", bean.getAttendanceRuleId());
			count++;
		}
		if(bean.getRuleName() != null) {
			if(bean.getRuleName().indexOf("%") >= 0)
				dao.setConditionRuleName("like", bean.getRuleName());
			else
				dao.setConditionRuleName("=", bean.getRuleName());
			count++;
		}
		if(bean.getRuleType() != null) {
			dao.setConditionRuleType("=", bean.getRuleType());
			count++;
		}
		if(bean.getIsEnable() != null) {
			dao.setConditionIsEnable("=", bean.getIsEnable());
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
		BaseAttendanceRule bean = new BaseAttendanceRule();
		bean.setDataFromJSON(json);
		AttendanceRule dao = new AttendanceRule();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseAttendanceRule> rlist = new BaseCollection<>();
		BaseAttendanceRule bean = new BaseAttendanceRule();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		AttendanceRule dao = new AttendanceRule();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseAttendanceRule> result = dao.conditionalLoad(addtion);
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
		BaseAttendanceRule bean = new BaseAttendanceRule();
		bean.setDataFromJSON(json);
		AttendanceRule dao = new AttendanceRule();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseAttendanceRule bean = new BaseAttendanceRule();
		bean.setDataFromJSON(json);
		AttendanceRule dao = new AttendanceRule();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseAttendanceRule bean = new BaseAttendanceRule();
		bean.setDataFromJSON(json);
		AttendanceRule dao = new AttendanceRule();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseAttendanceRule bean = new BaseAttendanceRule();
		bean.setDataFromJSON(json);
		AttendanceRule dao = new AttendanceRule();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


