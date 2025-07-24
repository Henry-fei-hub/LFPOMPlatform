package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseHolidayBlessManage;
import com.pomplatform.db.dao.HolidayBlessManage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class HolidayBlessManageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(HolidayBlessManageHandler.class);

	public static BaseHolidayBlessManage getHolidayBlessManageById( 
		java.lang.Integer holiday_bless_manage_id
	) throws Exception
	{
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setHolidayBlessManageId(holiday_bless_manage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isHolidayBlessManageExists( com.pomplatform.db.bean.BaseHolidayBlessManage bean, String additional ) throws Exception {

		HolidayBlessManage dao = new HolidayBlessManage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countHolidayBlessManage( com.pomplatform.db.bean.BaseHolidayBlessManage bean, String additional ) throws Exception {

		HolidayBlessManage dao = new HolidayBlessManage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseHolidayBlessManage> queryHolidayBlessManage( com.pomplatform.db.bean.BaseHolidayBlessManage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		HolidayBlessManage dao = new HolidayBlessManage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseHolidayBlessManage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseHolidayBlessManage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseHolidayBlessManage addToHolidayBlessManage ( BaseHolidayBlessManage holidayblessmanage )  throws Exception {
		return addToHolidayBlessManage ( holidayblessmanage , false);
	}

	public static BaseHolidayBlessManage addToHolidayBlessManage ( BaseHolidayBlessManage holidayblessmanage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setDataFromBase(holidayblessmanage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseHolidayBlessManage addUpdateHolidayBlessManage ( BaseHolidayBlessManage holidayblessmanage ) throws Exception {
		return addUpdateHolidayBlessManage ( holidayblessmanage , false);
	}

	public static BaseHolidayBlessManage addUpdateHolidayBlessManage ( BaseHolidayBlessManage holidayblessmanage, boolean singleTransaction  ) throws Exception {
		if(holidayblessmanage.getHolidayBlessManageId() == null) return addToHolidayBlessManage(holidayblessmanage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setDataFromBase(holidayblessmanage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(holidayblessmanage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteHolidayBlessManage ( BaseHolidayBlessManage bean ) throws Exception {
		HolidayBlessManage dao = new HolidayBlessManage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseHolidayBlessManage updateHolidayBlessManage ( BaseHolidayBlessManage holidayblessmanage ) throws Exception {
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setHolidayBlessManageId( holidayblessmanage.getHolidayBlessManageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(holidayblessmanage);
			result = dao.update();
		}
		return result == 1 ? holidayblessmanage : null ;
	}

	public static BaseHolidayBlessManage updateHolidayBlessManageDirect( BaseHolidayBlessManage holidayblessmanage ) throws Exception {
		HolidayBlessManage dao = new HolidayBlessManage();
		int result = 0;
		dao.setDataFromBase(holidayblessmanage);
		result = dao.update();
		return result == 1 ? holidayblessmanage : null ;
	}

	public static int setDeleteConditions(BaseHolidayBlessManage bean, HolidayBlessManage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getHolidayBlessManageId() != null) {
			dao.setConditionHolidayBlessManageId("=", bean.getHolidayBlessManageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getHolidayName() != null) {
				dao.setConditionHolidayName("=", bean.getHolidayName());
				count++;
			}
			if(bean.getHolidayType() != null) {
				dao.setConditionHolidayType("=", bean.getHolidayType());
				count++;
			}
			if(bean.getSendObject() != null) {
				dao.setConditionSendObject("=", bean.getSendObject());
				count++;
			}
			if(bean.getObjectType() != null) {
				dao.setConditionObjectType("=", bean.getObjectType());
				count++;
			}
			if(bean.getBlessWords() != null) {
				dao.setConditionBlessWords("=", bean.getBlessWords());
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
		}
		return count;
	}

	public static int setConditions(BaseHolidayBlessManage bean, HolidayBlessManage dao){
		int count = 0;
		if(bean.getHolidayBlessManageId() != null) {
			dao.setConditionHolidayBlessManageId("=", bean.getHolidayBlessManageId());
			count++;
		}
		if(bean.getHolidayName() != null) {
			if(bean.getHolidayName().indexOf("%") >= 0)
				dao.setConditionHolidayName("like", bean.getHolidayName());
			else
				dao.setConditionHolidayName("=", bean.getHolidayName());
			count++;
		}
		if(bean.getHolidayDate() != null) {
			dao.setConditionHolidayDate(">=", bean.getHolidayDate());
			count++;
		}
		if(bean.getHolidayType() != null) {
			dao.setConditionHolidayType("=", bean.getHolidayType());
			count++;
		}
		if(bean.getSendObject() != null) {
			dao.setConditionSendObject("=", bean.getSendObject());
			count++;
		}
		if(bean.getObjectType() != null) {
			dao.setConditionObjectType("=", bean.getObjectType());
			count++;
		}
		if(bean.getBlessWords() != null) {
			if(bean.getBlessWords().indexOf("%") >= 0)
				dao.setConditionBlessWords("like", bean.getBlessWords());
			else
				dao.setConditionBlessWords("=", bean.getBlessWords());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		bean.setDataFromJSON(json);
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseHolidayBlessManage> rlist = new BaseCollection<>();
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		HolidayBlessManage dao = new HolidayBlessManage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseHolidayBlessManage> result = dao.conditionalLoad(addtion);
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
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		bean.setDataFromJSON(json);
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		bean.setDataFromJSON(json);
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		bean.setDataFromJSON(json);
		HolidayBlessManage dao = new HolidayBlessManage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseHolidayBlessManage bean = new BaseHolidayBlessManage();
		bean.setDataFromJSON(json);
		HolidayBlessManage dao = new HolidayBlessManage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


