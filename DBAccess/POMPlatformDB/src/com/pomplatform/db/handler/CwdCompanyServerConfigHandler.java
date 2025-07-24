package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdCompanyServerConfig;
import com.pomplatform.db.dao.CwdCompanyServerConfig;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdCompanyServerConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdCompanyServerConfigHandler.class);

	public static BaseCwdCompanyServerConfig getCwdCompanyServerConfigById( 
		java.lang.Integer company_server_config_id
	) throws Exception
	{
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setCompanyServerConfigId(company_server_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdCompanyServerConfigExists( com.pomplatform.db.bean.BaseCwdCompanyServerConfig bean, String additional ) throws Exception {

		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdCompanyServerConfig( com.pomplatform.db.bean.BaseCwdCompanyServerConfig bean, String additional ) throws Exception {

		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdCompanyServerConfig> queryCwdCompanyServerConfig( com.pomplatform.db.bean.BaseCwdCompanyServerConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdCompanyServerConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdCompanyServerConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdCompanyServerConfig addToCwdCompanyServerConfig ( BaseCwdCompanyServerConfig cwdcompanyserverconfig )  throws Exception {
		return addToCwdCompanyServerConfig ( cwdcompanyserverconfig , false);
	}

	public static BaseCwdCompanyServerConfig addToCwdCompanyServerConfig ( BaseCwdCompanyServerConfig cwdcompanyserverconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setDataFromBase(cwdcompanyserverconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdCompanyServerConfig addUpdateCwdCompanyServerConfig ( BaseCwdCompanyServerConfig cwdcompanyserverconfig ) throws Exception {
		return addUpdateCwdCompanyServerConfig ( cwdcompanyserverconfig , false);
	}

	public static BaseCwdCompanyServerConfig addUpdateCwdCompanyServerConfig ( BaseCwdCompanyServerConfig cwdcompanyserverconfig, boolean singleTransaction  ) throws Exception {
		if(cwdcompanyserverconfig.getCompanyServerConfigId() == null) return addToCwdCompanyServerConfig(cwdcompanyserverconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setDataFromBase(cwdcompanyserverconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdcompanyserverconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdCompanyServerConfig ( BaseCwdCompanyServerConfig bean ) throws Exception {
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdCompanyServerConfig updateCwdCompanyServerConfig ( BaseCwdCompanyServerConfig cwdcompanyserverconfig ) throws Exception {
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setCompanyServerConfigId( cwdcompanyserverconfig.getCompanyServerConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdcompanyserverconfig);
			result = dao.update();
		}
		return result == 1 ? cwdcompanyserverconfig : null ;
	}

	public static BaseCwdCompanyServerConfig updateCwdCompanyServerConfigDirect( BaseCwdCompanyServerConfig cwdcompanyserverconfig ) throws Exception {
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		int result = 0;
		dao.setDataFromBase(cwdcompanyserverconfig);
		result = dao.update();
		return result == 1 ? cwdcompanyserverconfig : null ;
	}

	public static int setDeleteConditions(BaseCwdCompanyServerConfig bean, CwdCompanyServerConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyServerConfigId() != null) {
			dao.setConditionCompanyServerConfigId("=", bean.getCompanyServerConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getCwdServerUrl() != null) {
				dao.setConditionCwdServerUrl("=", bean.getCwdServerUrl());
				count++;
			}
			if(bean.getDataServerUrl() != null) {
				dao.setConditionDataServerUrl("=", bean.getDataServerUrl());
				count++;
			}
			if(bean.getOssUrl() != null) {
				dao.setConditionOssUrl("=", bean.getOssUrl());
				count++;
			}
			if(bean.getOssBucket() != null) {
				dao.setConditionOssBucket("=", bean.getOssBucket());
				count++;
			}
			if(bean.getStsUrl() != null) {
				dao.setConditionStsUrl("=", bean.getStsUrl());
				count++;
			}
			if(bean.getOssAccessKeyId() != null) {
				dao.setConditionOssAccessKeyId("=", bean.getOssAccessKeyId());
				count++;
			}
			if(bean.getOssAccessKeySecret() != null) {
				dao.setConditionOssAccessKeySecret("=", bean.getOssAccessKeySecret());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCwdCompanyServerConfig bean, CwdCompanyServerConfig dao){
		int count = 0;
		if(bean.getCompanyServerConfigId() != null) {
			dao.setConditionCompanyServerConfigId("=", bean.getCompanyServerConfigId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getCwdServerUrl() != null) {
			if(bean.getCwdServerUrl().indexOf("%") >= 0)
				dao.setConditionCwdServerUrl("like", bean.getCwdServerUrl());
			else
				dao.setConditionCwdServerUrl("=", bean.getCwdServerUrl());
			count++;
		}
		if(bean.getDataServerUrl() != null) {
			if(bean.getDataServerUrl().indexOf("%") >= 0)
				dao.setConditionDataServerUrl("like", bean.getDataServerUrl());
			else
				dao.setConditionDataServerUrl("=", bean.getDataServerUrl());
			count++;
		}
		if(bean.getOssUrl() != null) {
			if(bean.getOssUrl().indexOf("%") >= 0)
				dao.setConditionOssUrl("like", bean.getOssUrl());
			else
				dao.setConditionOssUrl("=", bean.getOssUrl());
			count++;
		}
		if(bean.getOssBucket() != null) {
			if(bean.getOssBucket().indexOf("%") >= 0)
				dao.setConditionOssBucket("like", bean.getOssBucket());
			else
				dao.setConditionOssBucket("=", bean.getOssBucket());
			count++;
		}
		if(bean.getStsUrl() != null) {
			if(bean.getStsUrl().indexOf("%") >= 0)
				dao.setConditionStsUrl("like", bean.getStsUrl());
			else
				dao.setConditionStsUrl("=", bean.getStsUrl());
			count++;
		}
		if(bean.getOssAccessKeyId() != null) {
			if(bean.getOssAccessKeyId().indexOf("%") >= 0)
				dao.setConditionOssAccessKeyId("like", bean.getOssAccessKeyId());
			else
				dao.setConditionOssAccessKeyId("=", bean.getOssAccessKeyId());
			count++;
		}
		if(bean.getOssAccessKeySecret() != null) {
			if(bean.getOssAccessKeySecret().indexOf("%") >= 0)
				dao.setConditionOssAccessKeySecret("like", bean.getOssAccessKeySecret());
			else
				dao.setConditionOssAccessKeySecret("=", bean.getOssAccessKeySecret());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		bean.setDataFromJSON(json);
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdCompanyServerConfig> rlist = new BaseCollection<>();
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdCompanyServerConfig> result = dao.conditionalLoad(addtion);
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
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		bean.setDataFromJSON(json);
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		bean.setDataFromJSON(json);
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		bean.setDataFromJSON(json);
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdCompanyServerConfig bean = new BaseCwdCompanyServerConfig();
		bean.setDataFromJSON(json);
		CwdCompanyServerConfig dao = new CwdCompanyServerConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


