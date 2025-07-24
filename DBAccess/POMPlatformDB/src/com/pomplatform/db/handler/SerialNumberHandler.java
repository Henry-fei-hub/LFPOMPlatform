package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSerialNumber;
import com.pomplatform.db.dao.SerialNumber;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SerialNumberHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SerialNumberHandler.class);

	public static BaseSerialNumber getSerialNumberById( 
		java.lang.Integer serial_number_id
	) throws Exception
	{
		SerialNumber dao = new SerialNumber();
		dao.setSerialNumberId(serial_number_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSerialNumberExists( com.pomplatform.db.bean.BaseSerialNumber bean, String additional ) throws Exception {

		SerialNumber dao = new SerialNumber();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSerialNumber( com.pomplatform.db.bean.BaseSerialNumber bean, String additional ) throws Exception {

		SerialNumber dao = new SerialNumber();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSerialNumber> querySerialNumber( com.pomplatform.db.bean.BaseSerialNumber bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SerialNumber dao = new SerialNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSerialNumber> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSerialNumber> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSerialNumber addToSerialNumber ( BaseSerialNumber serialnumber )  throws Exception {
		return addToSerialNumber ( serialnumber , false);
	}

	public static BaseSerialNumber addToSerialNumber ( BaseSerialNumber serialnumber, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SerialNumber dao = new SerialNumber();
		dao.setDataFromBase(serialnumber);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSerialNumber addUpdateSerialNumber ( BaseSerialNumber serialnumber ) throws Exception {
		return addUpdateSerialNumber ( serialnumber , false);
	}

	public static BaseSerialNumber addUpdateSerialNumber ( BaseSerialNumber serialnumber, boolean singleTransaction  ) throws Exception {
		if(serialnumber.getSerialNumberId() == null) return addToSerialNumber(serialnumber);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SerialNumber dao = new SerialNumber();
		dao.setDataFromBase(serialnumber);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(serialnumber); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSerialNumber ( BaseSerialNumber bean ) throws Exception {
		SerialNumber dao = new SerialNumber();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSerialNumber updateSerialNumber ( BaseSerialNumber serialnumber ) throws Exception {
		SerialNumber dao = new SerialNumber();
		dao.setSerialNumberId( serialnumber.getSerialNumberId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(serialnumber);
			result = dao.update();
		}
		return result == 1 ? serialnumber : null ;
	}

	public static BaseSerialNumber updateSerialNumberDirect( BaseSerialNumber serialnumber ) throws Exception {
		SerialNumber dao = new SerialNumber();
		int result = 0;
		dao.setDataFromBase(serialnumber);
		result = dao.update();
		return result == 1 ? serialnumber : null ;
	}

	public static int setDeleteConditions(BaseSerialNumber bean, SerialNumber dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSerialNumberId() != null) {
			dao.setConditionSerialNumberId("=", bean.getSerialNumberId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getSerialType() != null) {
				dao.setConditionSerialType("=", bean.getSerialType());
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
			if(bean.getDay() != null) {
				dao.setConditionDay("=", bean.getDay());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSerialNumber bean, SerialNumber dao){
		int count = 0;
		if(bean.getSerialNumberId() != null) {
			dao.setConditionSerialNumberId("=", bean.getSerialNumberId());
			count++;
		}
		if(bean.getSerialType() != null) {
			dao.setConditionSerialType("=", bean.getSerialType());
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
		if(bean.getDay() != null) {
			dao.setConditionDay("=", bean.getDay());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
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
		BaseSerialNumber bean = new BaseSerialNumber();
		bean.setDataFromJSON(json);
		SerialNumber dao = new SerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSerialNumber> rlist = new BaseCollection<>();
		BaseSerialNumber bean = new BaseSerialNumber();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SerialNumber dao = new SerialNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSerialNumber> result = dao.conditionalLoad(addtion);
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
		BaseSerialNumber bean = new BaseSerialNumber();
		bean.setDataFromJSON(json);
		SerialNumber dao = new SerialNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSerialNumber bean = new BaseSerialNumber();
		bean.setDataFromJSON(json);
		SerialNumber dao = new SerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSerialNumber bean = new BaseSerialNumber();
		bean.setDataFromJSON(json);
		SerialNumber dao = new SerialNumber();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSerialNumber bean = new BaseSerialNumber();
		bean.setDataFromJSON(json);
		SerialNumber dao = new SerialNumber();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


