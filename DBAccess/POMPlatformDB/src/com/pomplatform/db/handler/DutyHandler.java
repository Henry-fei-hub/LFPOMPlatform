package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseDuty;
import com.pomplatform.db.dao.Duty;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class DutyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(DutyHandler.class);

	public static BaseDuty getDutyById( 
		java.lang.Integer duty_id
	) throws Exception
	{
		Duty dao = new Duty();
		dao.setDutyId(duty_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isDutyExists( com.pomplatform.db.bean.BaseDuty bean, String additional ) throws Exception {

		Duty dao = new Duty();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countDuty( com.pomplatform.db.bean.BaseDuty bean, String additional ) throws Exception {

		Duty dao = new Duty();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseDuty> queryDuty( com.pomplatform.db.bean.BaseDuty bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Duty dao = new Duty();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseDuty> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseDuty> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseDuty addToDuty ( BaseDuty duty )  throws Exception {
		return addToDuty ( duty , false);
	}

	public static BaseDuty addToDuty ( BaseDuty duty, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Duty dao = new Duty();
		dao.setDataFromBase(duty);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseDuty addUpdateDuty ( BaseDuty duty ) throws Exception {
		return addUpdateDuty ( duty , false);
	}

	public static BaseDuty addUpdateDuty ( BaseDuty duty, boolean singleTransaction  ) throws Exception {
		if(duty.getDutyId() == null) return addToDuty(duty);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Duty dao = new Duty();
		dao.setDataFromBase(duty);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(duty); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteDuty ( BaseDuty bean ) throws Exception {
		Duty dao = new Duty();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseDuty updateDuty ( BaseDuty duty ) throws Exception {
		Duty dao = new Duty();
		dao.setDutyId( duty.getDutyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(duty);
			result = dao.update();
		}
		return result == 1 ? duty : null ;
	}

	public static BaseDuty updateDutyDirect( BaseDuty duty ) throws Exception {
		Duty dao = new Duty();
		int result = 0;
		dao.setDataFromBase(duty);
		result = dao.update();
		return result == 1 ? duty : null ;
	}

	public static int setDeleteConditions(BaseDuty bean, Duty dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getDutyId() != null) {
			dao.setConditionDutyId("=", bean.getDutyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getDutyName() != null) {
				dao.setConditionDutyName("=", bean.getDutyName());
				count++;
			}
			if(bean.getDescription() != null) {
				dao.setConditionDescription("=", bean.getDescription());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOriginalId() != null) {
				dao.setConditionOriginalId("=", bean.getOriginalId());
				count++;
			}
			if(bean.getParentDutyId() != null) {
				dao.setConditionParentDutyId("=", bean.getParentDutyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseDuty bean, Duty dao){
		int count = 0;
		if(bean.getDutyId() != null) {
			dao.setConditionDutyId("=", bean.getDutyId());
			count++;
		}
		if(bean.getDutyName() != null) {
			if(bean.getDutyName().indexOf("%") >= 0)
				dao.setConditionDutyName("like", bean.getDutyName());
			else
				dao.setConditionDutyName("=", bean.getDutyName());
			count++;
		}
		if(bean.getDescription() != null) {
			if(bean.getDescription().indexOf("%") >= 0)
				dao.setConditionDescription("like", bean.getDescription());
			else
				dao.setConditionDescription("=", bean.getDescription());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOriginalId() != null) {
			dao.setConditionOriginalId("=", bean.getOriginalId());
			count++;
		}
		if(bean.getParentDutyId() != null) {
			dao.setConditionParentDutyId("=", bean.getParentDutyId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseDuty bean = new BaseDuty();
		bean.setDataFromJSON(json);
		Duty dao = new Duty();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseDuty> rlist = new BaseCollection<>();
		BaseDuty bean = new BaseDuty();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Duty dao = new Duty();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseDuty> result = dao.conditionalLoad(addtion);
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
		BaseDuty bean = new BaseDuty();
		bean.setDataFromJSON(json);
		Duty dao = new Duty();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseDuty bean = new BaseDuty();
		bean.setDataFromJSON(json);
		Duty dao = new Duty();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseDuty bean = new BaseDuty();
		bean.setDataFromJSON(json);
		Duty dao = new Duty();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseDuty bean = new BaseDuty();
		bean.setDataFromJSON(json);
		Duty dao = new Duty();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


