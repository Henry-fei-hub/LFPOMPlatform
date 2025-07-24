package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyWorkplace;
import com.pomplatform.db.dao.CompanyWorkplace;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyWorkplaceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyWorkplaceHandler.class);

	public static BaseCompanyWorkplace getCompanyWorkplaceById( 
		java.lang.Integer company_workplace_id
	) throws Exception
	{
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setCompanyWorkplaceId(company_workplace_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyWorkplaceExists( com.pomplatform.db.bean.BaseCompanyWorkplace bean, String additional ) throws Exception {

		CompanyWorkplace dao = new CompanyWorkplace();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyWorkplace( com.pomplatform.db.bean.BaseCompanyWorkplace bean, String additional ) throws Exception {

		CompanyWorkplace dao = new CompanyWorkplace();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyWorkplace> queryCompanyWorkplace( com.pomplatform.db.bean.BaseCompanyWorkplace bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyWorkplace dao = new CompanyWorkplace();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyWorkplace> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyWorkplace> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyWorkplace addToCompanyWorkplace ( BaseCompanyWorkplace companyworkplace )  throws Exception {
		return addToCompanyWorkplace ( companyworkplace , false);
	}

	public static BaseCompanyWorkplace addToCompanyWorkplace ( BaseCompanyWorkplace companyworkplace, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setDataFromBase(companyworkplace);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyWorkplace addUpdateCompanyWorkplace ( BaseCompanyWorkplace companyworkplace ) throws Exception {
		return addUpdateCompanyWorkplace ( companyworkplace , false);
	}

	public static BaseCompanyWorkplace addUpdateCompanyWorkplace ( BaseCompanyWorkplace companyworkplace, boolean singleTransaction  ) throws Exception {
		if(companyworkplace.getCompanyWorkplaceId() == null) return addToCompanyWorkplace(companyworkplace);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setDataFromBase(companyworkplace);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyworkplace); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyWorkplace ( BaseCompanyWorkplace bean ) throws Exception {
		CompanyWorkplace dao = new CompanyWorkplace();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyWorkplace updateCompanyWorkplace ( BaseCompanyWorkplace companyworkplace ) throws Exception {
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setCompanyWorkplaceId( companyworkplace.getCompanyWorkplaceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyworkplace);
			result = dao.update();
		}
		return result == 1 ? companyworkplace : null ;
	}

	public static BaseCompanyWorkplace updateCompanyWorkplaceDirect( BaseCompanyWorkplace companyworkplace ) throws Exception {
		CompanyWorkplace dao = new CompanyWorkplace();
		int result = 0;
		dao.setDataFromBase(companyworkplace);
		result = dao.update();
		return result == 1 ? companyworkplace : null ;
	}

	public static int setDeleteConditions(BaseCompanyWorkplace bean, CompanyWorkplace dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyWorkplaceId() != null) {
			dao.setConditionCompanyWorkplaceId("=", bean.getCompanyWorkplaceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getWorkplaceName() != null) {
				dao.setConditionWorkplaceName("=", bean.getWorkplaceName());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getProvinceId() != null) {
				dao.setConditionProvinceId("=", bean.getProvinceId());
				count++;
			}
			if(bean.getCityId() != null) {
				dao.setConditionCityId("=", bean.getCityId());
				count++;
			}
			if(bean.getActive() != null) {
				dao.setConditionActive("=", bean.getActive());
				count++;
			}
			if(bean.getWorkplaceDir() != null) {
				dao.setConditionWorkplaceDir("=", bean.getWorkplaceDir());
				count++;
			}
			if(bean.getWorkplaceType() != null) {
				dao.setConditionWorkplaceType("=", bean.getWorkplaceType());
				count++;
			}
			if(bean.getHasInit() != null) {
				dao.setConditionHasInit("=", bean.getHasInit());
				count++;
			}
			if(bean.getBackupDir() != null) {
				dao.setConditionBackupDir("=", bean.getBackupDir());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyWorkplace bean, CompanyWorkplace dao){
		int count = 0;
		if(bean.getCompanyWorkplaceId() != null) {
			dao.setConditionCompanyWorkplaceId("=", bean.getCompanyWorkplaceId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getWorkplaceName() != null) {
			if(bean.getWorkplaceName().indexOf("%") >= 0)
				dao.setConditionWorkplaceName("like", bean.getWorkplaceName());
			else
				dao.setConditionWorkplaceName("=", bean.getWorkplaceName());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getCityId() != null) {
			dao.setConditionCityId("=", bean.getCityId());
			count++;
		}
		if(bean.getActive() != null) {
			dao.setConditionActive("=", bean.getActive());
			count++;
		}
		if(bean.getWorkplaceDir() != null) {
			if(bean.getWorkplaceDir().indexOf("%") >= 0)
				dao.setConditionWorkplaceDir("like", bean.getWorkplaceDir());
			else
				dao.setConditionWorkplaceDir("=", bean.getWorkplaceDir());
			count++;
		}
		if(bean.getWorkplaceType() != null) {
			dao.setConditionWorkplaceType("=", bean.getWorkplaceType());
			count++;
		}
		if(bean.getHasInit() != null) {
			dao.setConditionHasInit("=", bean.getHasInit());
			count++;
		}
		if(bean.getBackupDir() != null) {
			if(bean.getBackupDir().indexOf("%") >= 0)
				dao.setConditionBackupDir("like", bean.getBackupDir());
			else
				dao.setConditionBackupDir("=", bean.getBackupDir());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		bean.setDataFromJSON(json);
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyWorkplace> rlist = new BaseCollection<>();
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyWorkplace dao = new CompanyWorkplace();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyWorkplace> result = dao.conditionalLoad(addtion);
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
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		bean.setDataFromJSON(json);
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		bean.setDataFromJSON(json);
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		bean.setDataFromJSON(json);
		CompanyWorkplace dao = new CompanyWorkplace();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyWorkplace bean = new BaseCompanyWorkplace();
		bean.setDataFromJSON(json);
		CompanyWorkplace dao = new CompanyWorkplace();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


