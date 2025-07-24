package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyArea;
import com.pomplatform.db.dao.CompanyArea;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyAreaHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyAreaHandler.class);

	public static BaseCompanyArea getCompanyAreaById( 
		java.lang.Integer company_area_id
	) throws Exception
	{
		CompanyArea dao = new CompanyArea();
		dao.setCompanyAreaId(company_area_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyAreaExists( com.pomplatform.db.bean.BaseCompanyArea bean, String additional ) throws Exception {

		CompanyArea dao = new CompanyArea();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyArea( com.pomplatform.db.bean.BaseCompanyArea bean, String additional ) throws Exception {

		CompanyArea dao = new CompanyArea();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyArea> queryCompanyArea( com.pomplatform.db.bean.BaseCompanyArea bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyArea dao = new CompanyArea();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyArea> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyArea> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyArea addToCompanyArea ( BaseCompanyArea companyarea )  throws Exception {
		return addToCompanyArea ( companyarea , false);
	}

	public static BaseCompanyArea addToCompanyArea ( BaseCompanyArea companyarea, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyArea dao = new CompanyArea();
		dao.setDataFromBase(companyarea);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyArea addUpdateCompanyArea ( BaseCompanyArea companyarea ) throws Exception {
		return addUpdateCompanyArea ( companyarea , false);
	}

	public static BaseCompanyArea addUpdateCompanyArea ( BaseCompanyArea companyarea, boolean singleTransaction  ) throws Exception {
		if(companyarea.getCompanyAreaId() == null) return addToCompanyArea(companyarea);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyArea dao = new CompanyArea();
		dao.setDataFromBase(companyarea);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyarea); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyArea ( BaseCompanyArea bean ) throws Exception {
		CompanyArea dao = new CompanyArea();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyArea updateCompanyArea ( BaseCompanyArea companyarea ) throws Exception {
		CompanyArea dao = new CompanyArea();
		dao.setCompanyAreaId( companyarea.getCompanyAreaId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyarea);
			result = dao.update();
		}
		return result == 1 ? companyarea : null ;
	}

	public static BaseCompanyArea updateCompanyAreaDirect( BaseCompanyArea companyarea ) throws Exception {
		CompanyArea dao = new CompanyArea();
		int result = 0;
		dao.setDataFromBase(companyarea);
		result = dao.update();
		return result == 1 ? companyarea : null ;
	}

	public static int setDeleteConditions(BaseCompanyArea bean, CompanyArea dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyAreaId() != null) {
			dao.setConditionCompanyAreaId("=", bean.getCompanyAreaId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getAreaId() != null) {
				dao.setConditionAreaId("=", bean.getAreaId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyArea bean, CompanyArea dao){
		int count = 0;
		if(bean.getCompanyAreaId() != null) {
			dao.setConditionCompanyAreaId("=", bean.getCompanyAreaId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyArea bean = new BaseCompanyArea();
		bean.setDataFromJSON(json);
		CompanyArea dao = new CompanyArea();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyArea> rlist = new BaseCollection<>();
		BaseCompanyArea bean = new BaseCompanyArea();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyArea dao = new CompanyArea();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyArea> result = dao.conditionalLoad(addtion);
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
		BaseCompanyArea bean = new BaseCompanyArea();
		bean.setDataFromJSON(json);
		CompanyArea dao = new CompanyArea();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyArea bean = new BaseCompanyArea();
		bean.setDataFromJSON(json);
		CompanyArea dao = new CompanyArea();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyArea bean = new BaseCompanyArea();
		bean.setDataFromJSON(json);
		CompanyArea dao = new CompanyArea();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyArea bean = new BaseCompanyArea();
		bean.setDataFromJSON(json);
		CompanyArea dao = new CompanyArea();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


