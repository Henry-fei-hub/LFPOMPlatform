package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyWorkplaceServer;
import com.pomplatform.db.dao.CompanyWorkplaceServer;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyWorkplaceServerHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyWorkplaceServerHandler.class);

	public static BaseCompanyWorkplaceServer getCompanyWorkplaceServerById( 
		java.lang.Integer workplace_server_id
	) throws Exception
	{
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setWorkplaceServerId(workplace_server_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyWorkplaceServerExists( com.pomplatform.db.bean.BaseCompanyWorkplaceServer bean, String additional ) throws Exception {

		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyWorkplaceServer( com.pomplatform.db.bean.BaseCompanyWorkplaceServer bean, String additional ) throws Exception {

		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyWorkplaceServer> queryCompanyWorkplaceServer( com.pomplatform.db.bean.BaseCompanyWorkplaceServer bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyWorkplaceServer> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyWorkplaceServer> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyWorkplaceServer addToCompanyWorkplaceServer ( BaseCompanyWorkplaceServer companyworkplaceserver )  throws Exception {
		return addToCompanyWorkplaceServer ( companyworkplaceserver , false);
	}

	public static BaseCompanyWorkplaceServer addToCompanyWorkplaceServer ( BaseCompanyWorkplaceServer companyworkplaceserver, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setDataFromBase(companyworkplaceserver);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyWorkplaceServer addUpdateCompanyWorkplaceServer ( BaseCompanyWorkplaceServer companyworkplaceserver ) throws Exception {
		return addUpdateCompanyWorkplaceServer ( companyworkplaceserver , false);
	}

	public static BaseCompanyWorkplaceServer addUpdateCompanyWorkplaceServer ( BaseCompanyWorkplaceServer companyworkplaceserver, boolean singleTransaction  ) throws Exception {
		if(companyworkplaceserver.getWorkplaceServerId() == null) return addToCompanyWorkplaceServer(companyworkplaceserver);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setDataFromBase(companyworkplaceserver);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyworkplaceserver); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyWorkplaceServer ( BaseCompanyWorkplaceServer bean ) throws Exception {
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyWorkplaceServer updateCompanyWorkplaceServer ( BaseCompanyWorkplaceServer companyworkplaceserver ) throws Exception {
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setWorkplaceServerId( companyworkplaceserver.getWorkplaceServerId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyworkplaceserver);
			result = dao.update();
		}
		return result == 1 ? companyworkplaceserver : null ;
	}

	public static BaseCompanyWorkplaceServer updateCompanyWorkplaceServerDirect( BaseCompanyWorkplaceServer companyworkplaceserver ) throws Exception {
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		int result = 0;
		dao.setDataFromBase(companyworkplaceserver);
		result = dao.update();
		return result == 1 ? companyworkplaceserver : null ;
	}

	public static int setDeleteConditions(BaseCompanyWorkplaceServer bean, CompanyWorkplaceServer dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getWorkplaceServerId() != null) {
			dao.setConditionWorkplaceServerId("=", bean.getWorkplaceServerId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getWorkplaceId() != null) {
				dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
				count++;
			}
			if(bean.getIntranetServerAddress() != null) {
				dao.setConditionIntranetServerAddress("=", bean.getIntranetServerAddress());
				count++;
			}
			if(bean.getIntranetServerPort() != null) {
				dao.setConditionIntranetServerPort("=", bean.getIntranetServerPort());
				count++;
			}
			if(bean.getExternalServerAddress() != null) {
				dao.setConditionExternalServerAddress("=", bean.getExternalServerAddress());
				count++;
			}
			if(bean.getExternalServerPort() != null) {
				dao.setConditionExternalServerPort("=", bean.getExternalServerPort());
				count++;
			}
			if(bean.getExternalServerUseable() != null) {
				dao.setConditionExternalServerUseable("=", bean.getExternalServerUseable());
				count++;
			}
			if(bean.getUrl() != null) {
				dao.setConditionUrl("=", bean.getUrl());
				count++;
			}
			if(bean.getActive() != null) {
				dao.setConditionActive("=", bean.getActive());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyWorkplaceServer bean, CompanyWorkplaceServer dao){
		int count = 0;
		if(bean.getWorkplaceServerId() != null) {
			dao.setConditionWorkplaceServerId("=", bean.getWorkplaceServerId());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
			count++;
		}
		if(bean.getIntranetServerAddress() != null) {
			if(bean.getIntranetServerAddress().indexOf("%") >= 0)
				dao.setConditionIntranetServerAddress("like", bean.getIntranetServerAddress());
			else
				dao.setConditionIntranetServerAddress("=", bean.getIntranetServerAddress());
			count++;
		}
		if(bean.getIntranetServerPort() != null) {
			dao.setConditionIntranetServerPort("=", bean.getIntranetServerPort());
			count++;
		}
		if(bean.getExternalServerAddress() != null) {
			if(bean.getExternalServerAddress().indexOf("%") >= 0)
				dao.setConditionExternalServerAddress("like", bean.getExternalServerAddress());
			else
				dao.setConditionExternalServerAddress("=", bean.getExternalServerAddress());
			count++;
		}
		if(bean.getExternalServerPort() != null) {
			dao.setConditionExternalServerPort("=", bean.getExternalServerPort());
			count++;
		}
		if(bean.getExternalServerUseable() != null) {
			dao.setConditionExternalServerUseable("=", bean.getExternalServerUseable());
			count++;
		}
		if(bean.getUrl() != null) {
			if(bean.getUrl().indexOf("%") >= 0)
				dao.setConditionUrl("like", bean.getUrl());
			else
				dao.setConditionUrl("=", bean.getUrl());
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
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		bean.setDataFromJSON(json);
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyWorkplaceServer> rlist = new BaseCollection<>();
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyWorkplaceServer> result = dao.conditionalLoad(addtion);
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
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		bean.setDataFromJSON(json);
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		bean.setDataFromJSON(json);
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		bean.setDataFromJSON(json);
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyWorkplaceServer bean = new BaseCompanyWorkplaceServer();
		bean.setDataFromJSON(json);
		CompanyWorkplaceServer dao = new CompanyWorkplaceServer();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


