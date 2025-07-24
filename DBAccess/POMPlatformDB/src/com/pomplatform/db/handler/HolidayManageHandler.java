package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseHolidayManage;
import java.util.List;
import com.pomplatform.db.dao.HolidayManage;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class HolidayManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(HolidayManageHandler.class);

	public static BaseHolidayManage getHolidayManageById( 
		java.lang.Integer holiday_manage_id
	) throws Exception
	{
		HolidayManage dao = new HolidayManage();
		dao.setHolidayManageId(holiday_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isHolidayManageExists( com.pomplatform.db.bean.BaseHolidayManage bean, String additional ) throws Exception {

		HolidayManage dao = new HolidayManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countHolidayManage( com.pomplatform.db.bean.BaseHolidayManage bean, String additional ) throws Exception {

		HolidayManage dao = new HolidayManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseHolidayManage> queryHolidayManage( com.pomplatform.db.bean.BaseHolidayManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		HolidayManage dao = new HolidayManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseHolidayManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseHolidayManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseHolidayManage addToHolidayManage ( BaseHolidayManage holidaymanage )  throws Exception {
		return addToHolidayManage ( holidaymanage , false);
	}

	public static BaseHolidayManage addToHolidayManage ( BaseHolidayManage holidaymanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		HolidayManage dao = new HolidayManage();
		dao.setDataFromBase(holidaymanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseHolidayManage addUpdateHolidayManage ( BaseHolidayManage holidaymanage ) throws Exception {
		return addUpdateHolidayManage ( holidaymanage , false);
	}

	public static BaseHolidayManage addUpdateHolidayManage ( BaseHolidayManage holidaymanage, boolean singleTransaction  ) throws Exception {
		if(holidaymanage.getHolidayManageId() == null) return addToHolidayManage(holidaymanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		HolidayManage dao = new HolidayManage();
		dao.setDataFromBase(holidaymanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(holidaymanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteHolidayManage ( BaseHolidayManage bean ) throws Exception {
		HolidayManage dao = new HolidayManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseHolidayManage updateHolidayManage ( BaseHolidayManage holidaymanage ) throws Exception {
		HolidayManage dao = new HolidayManage();
		dao.setHolidayManageId( holidaymanage.getHolidayManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(holidaymanage);
			result = dao.update();
		}
		return result == 1 ? holidaymanage : null ;
	}

	public static BaseHolidayManage updateHolidayManageDirect( BaseHolidayManage holidaymanage ) throws Exception {
		HolidayManage dao = new HolidayManage();
		int result = 0;
		dao.setDataFromBase(holidaymanage);
		result = dao.update();
		return result == 1 ? holidaymanage : null ;
	}

	public static int setDeleteConditions(BaseHolidayManage bean, HolidayManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getHolidayManageId() != null) {
			dao.setConditionHolidayManageId("=", bean.getHolidayManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getDescription() != null) {
				dao.setConditionDescription("=", bean.getDescription());
				count++;
			}
			if(bean.getIsWorkDay() != null) {
				dao.setConditionIsWorkDay("=", bean.getIsWorkDay());
				count++;
			}
			if(bean.getIsCountOvertime() != null) {
				dao.setConditionIsCountOvertime("=", bean.getIsCountOvertime());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseHolidayManage bean, HolidayManage dao){
		int count = 0;
		if(bean.getHolidayManageId() != null) {
			dao.setConditionHolidayManageId("=", bean.getHolidayManageId());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getStartTime() != null) {
			dao.setConditionStartTime(">=", bean.getStartTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		if(bean.getDescription() != null) {
			if(bean.getDescription().indexOf("%") >= 0)
				dao.setConditionDescription("like", bean.getDescription());
			else
				dao.setConditionDescription("=", bean.getDescription());
			count++;
		}
		if(bean.getIsWorkDay() != null) {
			dao.setConditionIsWorkDay("=", bean.getIsWorkDay());
			count++;
		}
		if(bean.getIsCountOvertime() != null) {
			dao.setConditionIsCountOvertime("=", bean.getIsCountOvertime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseHolidayManage bean = new BaseHolidayManage();
		bean.setDataFromJSON(json);
		HolidayManage dao = new HolidayManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseHolidayManage> rlist = new BaseCollection<>();
		BaseHolidayManage bean = new BaseHolidayManage();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		HolidayManage dao = new HolidayManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseHolidayManage> result = dao.conditionalLoad(addtion);
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
		BaseHolidayManage bean = new BaseHolidayManage();
		bean.setDataFromJSON(json);
		HolidayManage dao = new HolidayManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseHolidayManage bean = new BaseHolidayManage();
		bean.setDataFromJSON(json);
		HolidayManage dao = new HolidayManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseHolidayManage bean = new BaseHolidayManage();
		bean.setDataFromJSON(json);
		HolidayManage dao = new HolidayManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseHolidayManage bean = new BaseHolidayManage();
		bean.setDataFromJSON(json);
		HolidayManage dao = new HolidayManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


