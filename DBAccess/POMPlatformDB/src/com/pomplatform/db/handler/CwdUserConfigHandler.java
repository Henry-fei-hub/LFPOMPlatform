package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdUserConfig;
import com.pomplatform.db.dao.CwdUserConfig;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdUserConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdUserConfigHandler.class);

	public static BaseCwdUserConfig getCwdUserConfigById( 
		java.lang.Integer user_config_id
	) throws Exception
	{
		CwdUserConfig dao = new CwdUserConfig();
		dao.setUserConfigId(user_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdUserConfigExists( com.pomplatform.db.bean.BaseCwdUserConfig bean, String additional ) throws Exception {

		CwdUserConfig dao = new CwdUserConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdUserConfig( com.pomplatform.db.bean.BaseCwdUserConfig bean, String additional ) throws Exception {

		CwdUserConfig dao = new CwdUserConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdUserConfig> queryCwdUserConfig( com.pomplatform.db.bean.BaseCwdUserConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdUserConfig dao = new CwdUserConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdUserConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdUserConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdUserConfig addToCwdUserConfig ( BaseCwdUserConfig cwduserconfig )  throws Exception {
		return addToCwdUserConfig ( cwduserconfig , false);
	}

	public static BaseCwdUserConfig addToCwdUserConfig ( BaseCwdUserConfig cwduserconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdUserConfig dao = new CwdUserConfig();
		dao.setDataFromBase(cwduserconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdUserConfig addUpdateCwdUserConfig ( BaseCwdUserConfig cwduserconfig ) throws Exception {
		return addUpdateCwdUserConfig ( cwduserconfig , false);
	}

	public static BaseCwdUserConfig addUpdateCwdUserConfig ( BaseCwdUserConfig cwduserconfig, boolean singleTransaction  ) throws Exception {
		if(cwduserconfig.getUserConfigId() == null) return addToCwdUserConfig(cwduserconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdUserConfig dao = new CwdUserConfig();
		dao.setDataFromBase(cwduserconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwduserconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdUserConfig ( BaseCwdUserConfig bean ) throws Exception {
		CwdUserConfig dao = new CwdUserConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdUserConfig updateCwdUserConfig ( BaseCwdUserConfig cwduserconfig ) throws Exception {
		CwdUserConfig dao = new CwdUserConfig();
		dao.setUserConfigId( cwduserconfig.getUserConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwduserconfig);
			result = dao.update();
		}
		return result == 1 ? cwduserconfig : null ;
	}

	public static BaseCwdUserConfig updateCwdUserConfigDirect( BaseCwdUserConfig cwduserconfig ) throws Exception {
		CwdUserConfig dao = new CwdUserConfig();
		int result = 0;
		dao.setDataFromBase(cwduserconfig);
		result = dao.update();
		return result == 1 ? cwduserconfig : null ;
	}

	public static int setDeleteConditions(BaseCwdUserConfig bean, CwdUserConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getUserConfigId() != null) {
			dao.setConditionUserConfigId("=", bean.getUserConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getMacAddress() != null) {
				dao.setConditionMacAddress("=", bean.getMacAddress());
				count++;
			}
			if(bean.getIpAddress() != null) {
				dao.setConditionIpAddress("=", bean.getIpAddress());
				count++;
			}
			if(bean.getNameOfHost() != null) {
				dao.setConditionNameOfHost("=", bean.getNameOfHost());
				count++;
			}
			if(bean.getOsType() != null) {
				dao.setConditionOsType("=", bean.getOsType());
				count++;
			}
			if(bean.getWorkDir() != null) {
				dao.setConditionWorkDir("=", bean.getWorkDir());
				count++;
			}
			if(bean.getLabel() != null) {
				dao.setConditionLabel("=", bean.getLabel());
				count++;
			}
			if(bean.getIsDefault() != null) {
				dao.setConditionIsDefault("=", bean.getIsDefault());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdUserConfig bean, CwdUserConfig dao){
		int count = 0;
		if(bean.getUserConfigId() != null) {
			dao.setConditionUserConfigId("=", bean.getUserConfigId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getMacAddress() != null) {
			if(bean.getMacAddress().indexOf("%") >= 0)
				dao.setConditionMacAddress("like", bean.getMacAddress());
			else
				dao.setConditionMacAddress("=", bean.getMacAddress());
			count++;
		}
		if(bean.getIpAddress() != null) {
			if(bean.getIpAddress().indexOf("%") >= 0)
				dao.setConditionIpAddress("like", bean.getIpAddress());
			else
				dao.setConditionIpAddress("=", bean.getIpAddress());
			count++;
		}
		if(bean.getNameOfHost() != null) {
			if(bean.getNameOfHost().indexOf("%") >= 0)
				dao.setConditionNameOfHost("like", bean.getNameOfHost());
			else
				dao.setConditionNameOfHost("=", bean.getNameOfHost());
			count++;
		}
		if(bean.getOsType() != null) {
			dao.setConditionOsType("=", bean.getOsType());
			count++;
		}
		if(bean.getWorkDir() != null) {
			if(bean.getWorkDir().indexOf("%") >= 0)
				dao.setConditionWorkDir("like", bean.getWorkDir());
			else
				dao.setConditionWorkDir("=", bean.getWorkDir());
			count++;
		}
		if(bean.getLabel() != null) {
			if(bean.getLabel().indexOf("%") >= 0)
				dao.setConditionLabel("like", bean.getLabel());
			else
				dao.setConditionLabel("=", bean.getLabel());
			count++;
		}
		if(bean.getIsDefault() != null) {
			dao.setConditionIsDefault("=", bean.getIsDefault());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		bean.setDataFromJSON(json);
		CwdUserConfig dao = new CwdUserConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdUserConfig> rlist = new BaseCollection<>();
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdUserConfig dao = new CwdUserConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdUserConfig> result = dao.conditionalLoad(addtion);
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
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		bean.setDataFromJSON(json);
		CwdUserConfig dao = new CwdUserConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		bean.setDataFromJSON(json);
		CwdUserConfig dao = new CwdUserConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		bean.setDataFromJSON(json);
		CwdUserConfig dao = new CwdUserConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdUserConfig bean = new BaseCwdUserConfig();
		bean.setDataFromJSON(json);
		CwdUserConfig dao = new CwdUserConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


