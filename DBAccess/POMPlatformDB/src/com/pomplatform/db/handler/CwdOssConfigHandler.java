package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCwdOssConfig;
import com.pomplatform.db.dao.CwdOssConfig;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CwdOssConfigHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CwdOssConfigHandler.class);

	public static BaseCwdOssConfig getCwdOssConfigById( 
		java.lang.Integer oss_config_id
	) throws Exception
	{
		CwdOssConfig dao = new CwdOssConfig();
		dao.setOssConfigId(oss_config_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCwdOssConfigExists( com.pomplatform.db.bean.BaseCwdOssConfig bean, String additional ) throws Exception {

		CwdOssConfig dao = new CwdOssConfig();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCwdOssConfig( com.pomplatform.db.bean.BaseCwdOssConfig bean, String additional ) throws Exception {

		CwdOssConfig dao = new CwdOssConfig();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCwdOssConfig> queryCwdOssConfig( com.pomplatform.db.bean.BaseCwdOssConfig bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CwdOssConfig dao = new CwdOssConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCwdOssConfig> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCwdOssConfig> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCwdOssConfig addToCwdOssConfig ( BaseCwdOssConfig cwdossconfig )  throws Exception {
		return addToCwdOssConfig ( cwdossconfig , false);
	}

	public static BaseCwdOssConfig addToCwdOssConfig ( BaseCwdOssConfig cwdossconfig, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CwdOssConfig dao = new CwdOssConfig();
		dao.setDataFromBase(cwdossconfig);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCwdOssConfig addUpdateCwdOssConfig ( BaseCwdOssConfig cwdossconfig ) throws Exception {
		return addUpdateCwdOssConfig ( cwdossconfig , false);
	}

	public static BaseCwdOssConfig addUpdateCwdOssConfig ( BaseCwdOssConfig cwdossconfig, boolean singleTransaction  ) throws Exception {
		if(cwdossconfig.getOssConfigId() == null) return addToCwdOssConfig(cwdossconfig);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CwdOssConfig dao = new CwdOssConfig();
		dao.setDataFromBase(cwdossconfig);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cwdossconfig); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCwdOssConfig ( BaseCwdOssConfig bean ) throws Exception {
		CwdOssConfig dao = new CwdOssConfig();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCwdOssConfig updateCwdOssConfig ( BaseCwdOssConfig cwdossconfig ) throws Exception {
		CwdOssConfig dao = new CwdOssConfig();
		dao.setOssConfigId( cwdossconfig.getOssConfigId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cwdossconfig);
			result = dao.update();
		}
		return result == 1 ? cwdossconfig : null ;
	}

	public static BaseCwdOssConfig updateCwdOssConfigDirect( BaseCwdOssConfig cwdossconfig ) throws Exception {
		CwdOssConfig dao = new CwdOssConfig();
		int result = 0;
		dao.setDataFromBase(cwdossconfig);
		result = dao.update();
		return result == 1 ? cwdossconfig : null ;
	}

	public static int setDeleteConditions(BaseCwdOssConfig bean, CwdOssConfig dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOssConfigId() != null) {
			dao.setConditionOssConfigId("=", bean.getOssConfigId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOssAddress() != null) {
				dao.setConditionOssAddress("=", bean.getOssAddress());
				count++;
			}
			if(bean.getOssBucket() != null) {
				dao.setConditionOssBucket("=", bean.getOssBucket());
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
		}
		return count;
	}

	public static int setConditions(BaseCwdOssConfig bean, CwdOssConfig dao){
		int count = 0;
		if(bean.getOssConfigId() != null) {
			dao.setConditionOssConfigId("=", bean.getOssConfigId());
			count++;
		}
		if(bean.getOssAddress() != null) {
			if(bean.getOssAddress().indexOf("%") >= 0)
				dao.setConditionOssAddress("like", bean.getOssAddress());
			else
				dao.setConditionOssAddress("=", bean.getOssAddress());
			count++;
		}
		if(bean.getOssBucket() != null) {
			if(bean.getOssBucket().indexOf("%") >= 0)
				dao.setConditionOssBucket("like", bean.getOssBucket());
			else
				dao.setConditionOssBucket("=", bean.getOssBucket());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		bean.setDataFromJSON(json);
		CwdOssConfig dao = new CwdOssConfig();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCwdOssConfig> rlist = new BaseCollection<>();
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CwdOssConfig dao = new CwdOssConfig();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCwdOssConfig> result = dao.conditionalLoad(addtion);
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
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		bean.setDataFromJSON(json);
		CwdOssConfig dao = new CwdOssConfig();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		bean.setDataFromJSON(json);
		CwdOssConfig dao = new CwdOssConfig();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		bean.setDataFromJSON(json);
		CwdOssConfig dao = new CwdOssConfig();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCwdOssConfig bean = new BaseCwdOssConfig();
		bean.setDataFromJSON(json);
		CwdOssConfig dao = new CwdOssConfig();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


