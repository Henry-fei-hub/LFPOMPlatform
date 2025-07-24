package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompany;
import com.pomplatform.db.dao.Company;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyHandler.class);

	public static BaseCompany getCompanyById( 
		java.lang.Integer company_id
	) throws Exception
	{
		Company dao = new Company();
		dao.setCompanyId(company_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyExists( com.pomplatform.db.bean.BaseCompany bean, String additional ) throws Exception {

		Company dao = new Company();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompany( com.pomplatform.db.bean.BaseCompany bean, String additional ) throws Exception {

		Company dao = new Company();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompany> queryCompany( com.pomplatform.db.bean.BaseCompany bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Company dao = new Company();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompany> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompany> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompany addToCompany ( BaseCompany company )  throws Exception {
		return addToCompany ( company , false);
	}

	public static BaseCompany addToCompany ( BaseCompany company, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Company dao = new Company();
		dao.setDataFromBase(company);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompany addUpdateCompany ( BaseCompany company ) throws Exception {
		return addUpdateCompany ( company , false);
	}

	public static BaseCompany addUpdateCompany ( BaseCompany company, boolean singleTransaction  ) throws Exception {
		if(company.getCompanyId() == null) return addToCompany(company);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Company dao = new Company();
		dao.setDataFromBase(company);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(company); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompany ( BaseCompany bean ) throws Exception {
		Company dao = new Company();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompany updateCompany ( BaseCompany company ) throws Exception {
		Company dao = new Company();
		dao.setCompanyId( company.getCompanyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(company);
			result = dao.update();
		}
		return result == 1 ? company : null ;
	}

	public static BaseCompany updateCompanyDirect( BaseCompany company ) throws Exception {
		Company dao = new Company();
		int result = 0;
		dao.setDataFromBase(company);
		result = dao.update();
		return result == 1 ? company : null ;
	}

	public static int setDeleteConditions(BaseCompany bean, Company dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyName() != null) {
				dao.setConditionCompanyName("=", bean.getCompanyName());
				count++;
			}
			if(bean.getCompanyAddress() != null) {
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompany bean, Company dao){
		int count = 0;
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyName() != null) {
			if(bean.getCompanyName().indexOf("%") >= 0)
				dao.setConditionCompanyName("like", bean.getCompanyName());
			else
				dao.setConditionCompanyName("=", bean.getCompanyName());
			count++;
		}
		if(bean.getCompanyAddress() != null) {
			if(bean.getCompanyAddress().indexOf("%") >= 0)
				dao.setConditionCompanyAddress("like", bean.getCompanyAddress());
			else
				dao.setConditionCompanyAddress("=", bean.getCompanyAddress());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompany bean = new BaseCompany();
		bean.setDataFromJSON(json);
		Company dao = new Company();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompany> rlist = new BaseCollection<>();
		BaseCompany bean = new BaseCompany();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Company dao = new Company();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompany> result = dao.conditionalLoad(addtion);
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
		BaseCompany bean = new BaseCompany();
		bean.setDataFromJSON(json);
		Company dao = new Company();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompany bean = new BaseCompany();
		bean.setDataFromJSON(json);
		Company dao = new Company();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompany bean = new BaseCompany();
		bean.setDataFromJSON(json);
		Company dao = new Company();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompany bean = new BaseCompany();
		bean.setDataFromJSON(json);
		Company dao = new Company();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


