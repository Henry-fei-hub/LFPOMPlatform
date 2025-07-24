package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile;
import com.pomplatform.db.dao.CompanyWorkplacePendingDownloadFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyWorkplacePendingDownloadFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyWorkplacePendingDownloadFileHandler.class);

	public static BaseCompanyWorkplacePendingDownloadFile getCompanyWorkplacePendingDownloadFileById( 
		java.lang.Integer company_workplace_pending_download_file_id
	) throws Exception
	{
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setCompanyWorkplacePendingDownloadFileId(company_workplace_pending_download_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyWorkplacePendingDownloadFileExists( com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile bean, String additional ) throws Exception {

		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyWorkplacePendingDownloadFile( com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile bean, String additional ) throws Exception {

		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyWorkplacePendingDownloadFile> queryCompanyWorkplacePendingDownloadFile( com.pomplatform.db.bean.BaseCompanyWorkplacePendingDownloadFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyWorkplacePendingDownloadFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyWorkplacePendingDownloadFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyWorkplacePendingDownloadFile addToCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile )  throws Exception {
		return addToCompanyWorkplacePendingDownloadFile ( companyworkplacependingdownloadfile , false);
	}

	public static BaseCompanyWorkplacePendingDownloadFile addToCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setDataFromBase(companyworkplacependingdownloadfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyWorkplacePendingDownloadFile addUpdateCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile ) throws Exception {
		return addUpdateCompanyWorkplacePendingDownloadFile ( companyworkplacependingdownloadfile , false);
	}

	public static BaseCompanyWorkplacePendingDownloadFile addUpdateCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile, boolean singleTransaction  ) throws Exception {
		if(companyworkplacependingdownloadfile.getCompanyWorkplacePendingDownloadFileId() == null) return addToCompanyWorkplacePendingDownloadFile(companyworkplacependingdownloadfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setDataFromBase(companyworkplacependingdownloadfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyworkplacependingdownloadfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile bean ) throws Exception {
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyWorkplacePendingDownloadFile updateCompanyWorkplacePendingDownloadFile ( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile ) throws Exception {
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setCompanyWorkplacePendingDownloadFileId( companyworkplacependingdownloadfile.getCompanyWorkplacePendingDownloadFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyworkplacependingdownloadfile);
			result = dao.update();
		}
		return result == 1 ? companyworkplacependingdownloadfile : null ;
	}

	public static BaseCompanyWorkplacePendingDownloadFile updateCompanyWorkplacePendingDownloadFileDirect( BaseCompanyWorkplacePendingDownloadFile companyworkplacependingdownloadfile ) throws Exception {
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		int result = 0;
		dao.setDataFromBase(companyworkplacependingdownloadfile);
		result = dao.update();
		return result == 1 ? companyworkplacependingdownloadfile : null ;
	}

	public static int setDeleteConditions(BaseCompanyWorkplacePendingDownloadFile bean, CompanyWorkplacePendingDownloadFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyWorkplacePendingDownloadFileId() != null) {
			dao.setConditionCompanyWorkplacePendingDownloadFileId("=", bean.getCompanyWorkplacePendingDownloadFileId());
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
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getSrcWorkplaceId() != null) {
				dao.setConditionSrcWorkplaceId("=", bean.getSrcWorkplaceId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyWorkplacePendingDownloadFile bean, CompanyWorkplacePendingDownloadFile dao){
		int count = 0;
		if(bean.getCompanyWorkplacePendingDownloadFileId() != null) {
			dao.setConditionCompanyWorkplacePendingDownloadFileId("=", bean.getCompanyWorkplacePendingDownloadFileId());
			count++;
		}
		if(bean.getWorkplaceId() != null) {
			dao.setConditionWorkplaceId("=", bean.getWorkplaceId());
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
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getSrcWorkplaceId() != null) {
			dao.setConditionSrcWorkplaceId("=", bean.getSrcWorkplaceId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		bean.setDataFromJSON(json);
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyWorkplacePendingDownloadFile> rlist = new BaseCollection<>();
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyWorkplacePendingDownloadFile> result = dao.conditionalLoad(addtion);
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
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		bean.setDataFromJSON(json);
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		bean.setDataFromJSON(json);
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		bean.setDataFromJSON(json);
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyWorkplacePendingDownloadFile bean = new BaseCompanyWorkplacePendingDownloadFile();
		bean.setDataFromJSON(json);
		CompanyWorkplacePendingDownloadFile dao = new CompanyWorkplacePendingDownloadFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


