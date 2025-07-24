package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonalRegisterAddress;
import com.pomplatform.db.dao.PersonalRegisterAddress;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PersonalRegisterAddressHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PersonalRegisterAddressHandler.class);

	public static BasePersonalRegisterAddress getPersonalRegisterAddressById( 
		java.lang.Integer personal_register_address_id
	) throws Exception
	{
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setPersonalRegisterAddressId(personal_register_address_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPersonalRegisterAddressExists( com.pomplatform.db.bean.BasePersonalRegisterAddress bean, String additional ) throws Exception {

		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPersonalRegisterAddress( com.pomplatform.db.bean.BasePersonalRegisterAddress bean, String additional ) throws Exception {

		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePersonalRegisterAddress> queryPersonalRegisterAddress( com.pomplatform.db.bean.BasePersonalRegisterAddress bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePersonalRegisterAddress> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePersonalRegisterAddress> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePersonalRegisterAddress addToPersonalRegisterAddress ( BasePersonalRegisterAddress personalregisteraddress )  throws Exception {
		return addToPersonalRegisterAddress ( personalregisteraddress , false);
	}

	public static BasePersonalRegisterAddress addToPersonalRegisterAddress ( BasePersonalRegisterAddress personalregisteraddress, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setDataFromBase(personalregisteraddress);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePersonalRegisterAddress addUpdatePersonalRegisterAddress ( BasePersonalRegisterAddress personalregisteraddress ) throws Exception {
		return addUpdatePersonalRegisterAddress ( personalregisteraddress , false);
	}

	public static BasePersonalRegisterAddress addUpdatePersonalRegisterAddress ( BasePersonalRegisterAddress personalregisteraddress, boolean singleTransaction  ) throws Exception {
		if(personalregisteraddress.getPersonalRegisterAddressId() == null) return addToPersonalRegisterAddress(personalregisteraddress);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setDataFromBase(personalregisteraddress);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(personalregisteraddress); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePersonalRegisterAddress ( BasePersonalRegisterAddress bean ) throws Exception {
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePersonalRegisterAddress updatePersonalRegisterAddress ( BasePersonalRegisterAddress personalregisteraddress ) throws Exception {
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setPersonalRegisterAddressId( personalregisteraddress.getPersonalRegisterAddressId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(personalregisteraddress);
			result = dao.update();
		}
		return result == 1 ? personalregisteraddress : null ;
	}

	public static BasePersonalRegisterAddress updatePersonalRegisterAddressDirect( BasePersonalRegisterAddress personalregisteraddress ) throws Exception {
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		int result = 0;
		dao.setDataFromBase(personalregisteraddress);
		result = dao.update();
		return result == 1 ? personalregisteraddress : null ;
	}

	public static int setDeleteConditions(BasePersonalRegisterAddress bean, PersonalRegisterAddress dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPersonalRegisterAddressId() != null) {
			dao.setConditionPersonalRegisterAddressId("=", bean.getPersonalRegisterAddressId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getIpAddress() != null) {
				dao.setConditionIpAddress("=", bean.getIpAddress());
				count++;
			}
			if(bean.getMacAddress() != null) {
				dao.setConditionMacAddress("=", bean.getMacAddress());
				count++;
			}
			if(bean.getWorkplaceId() != null) {
				dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
				count++;
			}
			if(bean.getActive() != null) {
				dao.setConditionActive("=", bean.getActive());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePersonalRegisterAddress bean, PersonalRegisterAddress dao){
		int count = 0;
		if(bean.getPersonalRegisterAddressId() != null) {
			dao.setConditionPersonalRegisterAddressId("=", bean.getPersonalRegisterAddressId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getIpAddress() != null) {
			if(bean.getIpAddress().indexOf("%") >= 0)
				dao.setConditionIpAddress("like", bean.getIpAddress());
			else
				dao.setConditionIpAddress("=", bean.getIpAddress());
			count++;
		}
		if(bean.getMacAddress() != null) {
			if(bean.getMacAddress().indexOf("%") >= 0)
				dao.setConditionMacAddress("like", bean.getMacAddress());
			else
				dao.setConditionMacAddress("=", bean.getMacAddress());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
			count++;
		}
		if(bean.getRegisterTime() != null) {
			dao.setConditionRegisterTime(">=", bean.getRegisterTime());
			count++;
		}
		if(bean.getActive() != null) {
			dao.setConditionActive("=", bean.getActive());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		bean.setDataFromJSON(json);
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePersonalRegisterAddress> rlist = new BaseCollection<>();
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePersonalRegisterAddress> result = dao.conditionalLoad(addtion);
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
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		bean.setDataFromJSON(json);
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		bean.setDataFromJSON(json);
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		bean.setDataFromJSON(json);
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePersonalRegisterAddress bean = new BasePersonalRegisterAddress();
		bean.setDataFromJSON(json);
		PersonalRegisterAddress dao = new PersonalRegisterAddress();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


