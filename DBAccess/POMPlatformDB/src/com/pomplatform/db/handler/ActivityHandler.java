package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseActivity;
import com.pomplatform.db.dao.Activity;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ActivityHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ActivityHandler.class);

	public static BaseActivity getActivityById( 
		java.lang.Integer activitie_id
	) throws Exception
	{
		Activity dao = new Activity();
		dao.setActivitieId(activitie_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isActivityExists( com.pomplatform.db.bean.BaseActivity bean, String additional ) throws Exception {

		Activity dao = new Activity();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countActivity( com.pomplatform.db.bean.BaseActivity bean, String additional ) throws Exception {

		Activity dao = new Activity();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseActivity> queryActivity( com.pomplatform.db.bean.BaseActivity bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Activity dao = new Activity();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseActivity> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseActivity> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseActivity addToActivity ( BaseActivity activity )  throws Exception {
		return addToActivity ( activity , false);
	}

	public static BaseActivity addToActivity ( BaseActivity activity, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Activity dao = new Activity();
		dao.setDataFromBase(activity);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseActivity addUpdateActivity ( BaseActivity activity ) throws Exception {
		return addUpdateActivity ( activity , false);
	}

	public static BaseActivity addUpdateActivity ( BaseActivity activity, boolean singleTransaction  ) throws Exception {
		if(activity.getActivitieId() == null) return addToActivity(activity);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Activity dao = new Activity();
		dao.setDataFromBase(activity);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(activity); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteActivity ( BaseActivity bean ) throws Exception {
		Activity dao = new Activity();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseActivity updateActivity ( BaseActivity activity ) throws Exception {
		Activity dao = new Activity();
		dao.setActivitieId( activity.getActivitieId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(activity);
			result = dao.update();
		}
		return result == 1 ? activity : null ;
	}

	public static BaseActivity updateActivityDirect( BaseActivity activity ) throws Exception {
		Activity dao = new Activity();
		int result = 0;
		dao.setDataFromBase(activity);
		result = dao.update();
		return result == 1 ? activity : null ;
	}

	public static int setDeleteConditions(BaseActivity bean, Activity dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getActivitieId() != null) {
			dao.setConditionActivitieId("=", bean.getActivitieId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getCustomerId() != null) {
				dao.setConditionCustomerId("=", bean.getCustomerId());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getMeetType() != null) {
				dao.setConditionMeetType("=", bean.getMeetType());
				count++;
			}
			if(bean.getMeetAddress() != null) {
				dao.setConditionMeetAddress("=", bean.getMeetAddress());
				count++;
			}
			if(bean.getMeetTitle() != null) {
				dao.setConditionMeetTitle("=", bean.getMeetTitle());
				count++;
			}
			if(bean.getMeetTarget() != null) {
				dao.setConditionMeetTarget("=", bean.getMeetTarget());
				count++;
			}
			if(bean.getContactName() != null) {
				dao.setConditionContactName("=", bean.getContactName());
				count++;
			}
			if(bean.getTheirRequire() != null) {
				dao.setConditionTheirRequire("=", bean.getTheirRequire());
				count++;
			}
			if(bean.getTheirEmployees() != null) {
				dao.setConditionTheirEmployees("=", bean.getTheirEmployees());
				count++;
			}
			if(bean.getOurEmployees() != null) {
				dao.setConditionOurEmployees("=", bean.getOurEmployees());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOurDesignerEmployees() != null) {
				dao.setConditionOurDesignerEmployees("=", bean.getOurDesignerEmployees());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseActivity bean, Activity dao){
		int count = 0;
		if(bean.getActivitieId() != null) {
			dao.setConditionActivitieId("=", bean.getActivitieId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCustomerId() != null) {
			dao.setConditionCustomerId("=", bean.getCustomerId());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getMeetType() != null) {
			dao.setConditionMeetType("=", bean.getMeetType());
			count++;
		}
		if(bean.getMeetTime() != null) {
			dao.setConditionMeetTime(">=", bean.getMeetTime());
			count++;
		}
		if(bean.getMeetAddress() != null) {
			if(bean.getMeetAddress().indexOf("%") >= 0)
				dao.setConditionMeetAddress("like", bean.getMeetAddress());
			else
				dao.setConditionMeetAddress("=", bean.getMeetAddress());
			count++;
		}
		if(bean.getMeetTitle() != null) {
			if(bean.getMeetTitle().indexOf("%") >= 0)
				dao.setConditionMeetTitle("like", bean.getMeetTitle());
			else
				dao.setConditionMeetTitle("=", bean.getMeetTitle());
			count++;
		}
		if(bean.getMeetTarget() != null) {
			if(bean.getMeetTarget().indexOf("%") >= 0)
				dao.setConditionMeetTarget("like", bean.getMeetTarget());
			else
				dao.setConditionMeetTarget("=", bean.getMeetTarget());
			count++;
		}
		if(bean.getContactName() != null) {
			if(bean.getContactName().indexOf("%") >= 0)
				dao.setConditionContactName("like", bean.getContactName());
			else
				dao.setConditionContactName("=", bean.getContactName());
			count++;
		}
		if(bean.getTheirRequire() != null) {
			if(bean.getTheirRequire().indexOf("%") >= 0)
				dao.setConditionTheirRequire("like", bean.getTheirRequire());
			else
				dao.setConditionTheirRequire("=", bean.getTheirRequire());
			count++;
		}
		if(bean.getTheirEmployees() != null) {
			if(bean.getTheirEmployees().indexOf("%") >= 0)
				dao.setConditionTheirEmployees("like", bean.getTheirEmployees());
			else
				dao.setConditionTheirEmployees("=", bean.getTheirEmployees());
			count++;
		}
		if(bean.getOurEmployees() != null) {
			if(bean.getOurEmployees().indexOf("%") >= 0)
				dao.setConditionOurEmployees("like", bean.getOurEmployees());
			else
				dao.setConditionOurEmployees("=", bean.getOurEmployees());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOurDesignerEmployees() != null) {
			if(bean.getOurDesignerEmployees().indexOf("%") >= 0)
				dao.setConditionOurDesignerEmployees("like", bean.getOurDesignerEmployees());
			else
				dao.setConditionOurDesignerEmployees("=", bean.getOurDesignerEmployees());
			count++;
		}
		if(bean.getProvince() != null) {
			if(bean.getProvince().indexOf("%") >= 0)
				dao.setConditionProvince("like", bean.getProvince());
			else
				dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getOutTimeStart() != null) {
			dao.setConditionOutTimeStart(">=", bean.getOutTimeStart());
			count++;
		}
		if(bean.getOutTimeEnd() != null) {
			dao.setConditionOutTimeEnd(">=", bean.getOutTimeEnd());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseActivity bean = new BaseActivity();
		bean.setDataFromJSON(json);
		Activity dao = new Activity();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseActivity> rlist = new BaseCollection<>();
		BaseActivity bean = new BaseActivity();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Activity dao = new Activity();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseActivity> result = dao.conditionalLoad(addtion);
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
		BaseActivity bean = new BaseActivity();
		bean.setDataFromJSON(json);
		Activity dao = new Activity();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseActivity bean = new BaseActivity();
		bean.setDataFromJSON(json);
		Activity dao = new Activity();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseActivity bean = new BaseActivity();
		bean.setDataFromJSON(json);
		Activity dao = new Activity();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseActivity bean = new BaseActivity();
		bean.setDataFromJSON(json);
		Activity dao = new Activity();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


