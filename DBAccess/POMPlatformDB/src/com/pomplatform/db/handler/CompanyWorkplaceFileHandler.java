package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyWorkplaceFile;
import com.pomplatform.db.dao.CompanyWorkplaceFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyWorkplaceFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyWorkplaceFileHandler.class);

	public static BaseCompanyWorkplaceFile getCompanyWorkplaceFileById( 
		java.lang.Integer company_workplace_file
	) throws Exception
	{
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setCompanyWorkplaceFile(company_workplace_file);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyWorkplaceFileExists( com.pomplatform.db.bean.BaseCompanyWorkplaceFile bean, String additional ) throws Exception {

		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyWorkplaceFile( com.pomplatform.db.bean.BaseCompanyWorkplaceFile bean, String additional ) throws Exception {

		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyWorkplaceFile> queryCompanyWorkplaceFile( com.pomplatform.db.bean.BaseCompanyWorkplaceFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyWorkplaceFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyWorkplaceFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyWorkplaceFile addToCompanyWorkplaceFile ( BaseCompanyWorkplaceFile companyworkplacefile )  throws Exception {
		return addToCompanyWorkplaceFile ( companyworkplacefile , false);
	}

	public static BaseCompanyWorkplaceFile addToCompanyWorkplaceFile ( BaseCompanyWorkplaceFile companyworkplacefile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setDataFromBase(companyworkplacefile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyWorkplaceFile addUpdateCompanyWorkplaceFile ( BaseCompanyWorkplaceFile companyworkplacefile ) throws Exception {
		return addUpdateCompanyWorkplaceFile ( companyworkplacefile , false);
	}

	public static BaseCompanyWorkplaceFile addUpdateCompanyWorkplaceFile ( BaseCompanyWorkplaceFile companyworkplacefile, boolean singleTransaction  ) throws Exception {
		if(companyworkplacefile.getCompanyWorkplaceFile() == null) return addToCompanyWorkplaceFile(companyworkplacefile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setDataFromBase(companyworkplacefile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyworkplacefile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyWorkplaceFile ( BaseCompanyWorkplaceFile bean ) throws Exception {
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyWorkplaceFile updateCompanyWorkplaceFile ( BaseCompanyWorkplaceFile companyworkplacefile ) throws Exception {
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setCompanyWorkplaceFile( companyworkplacefile.getCompanyWorkplaceFile() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyworkplacefile);
			result = dao.update();
		}
		return result == 1 ? companyworkplacefile : null ;
	}

	public static BaseCompanyWorkplaceFile updateCompanyWorkplaceFileDirect( BaseCompanyWorkplaceFile companyworkplacefile ) throws Exception {
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		int result = 0;
		dao.setDataFromBase(companyworkplacefile);
		result = dao.update();
		return result == 1 ? companyworkplacefile : null ;
	}

	public static int setDeleteConditions(BaseCompanyWorkplaceFile bean, CompanyWorkplaceFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyWorkplaceFile() != null) {
			dao.setConditionCompanyWorkplaceFile("=", bean.getCompanyWorkplaceFile());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getWorkplaceId() != null) {
				dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
				count++;
			}
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyWorkplaceFile bean, CompanyWorkplaceFile dao){
		int count = 0;
		if(bean.getCompanyWorkplaceFile() != null) {
			dao.setConditionCompanyWorkplaceFile("=", bean.getCompanyWorkplaceFile());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getLastModifyTime() != null) {
			dao.setConditionLastModifyTime(">=", bean.getLastModifyTime());
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
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		bean.setDataFromJSON(json);
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyWorkplaceFile> rlist = new BaseCollection<>();
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyWorkplaceFile> result = dao.conditionalLoad(addtion);
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
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		bean.setDataFromJSON(json);
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		bean.setDataFromJSON(json);
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		bean.setDataFromJSON(json);
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyWorkplaceFile bean = new BaseCompanyWorkplaceFile();
		bean.setDataFromJSON(json);
		CompanyWorkplaceFile dao = new CompanyWorkplaceFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


