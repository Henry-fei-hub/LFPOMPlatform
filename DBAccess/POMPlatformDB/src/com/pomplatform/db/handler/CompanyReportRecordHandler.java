package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyReportRecord;
import com.pomplatform.db.dao.CompanyReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyReportRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyReportRecordHandler.class);

	public static BaseCompanyReportRecord getCompanyReportRecordById( 
		java.lang.Integer company_report_record_id
	) throws Exception
	{
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setCompanyReportRecordId(company_report_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyReportRecordExists( com.pomplatform.db.bean.BaseCompanyReportRecord bean, String additional ) throws Exception {

		CompanyReportRecord dao = new CompanyReportRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyReportRecord( com.pomplatform.db.bean.BaseCompanyReportRecord bean, String additional ) throws Exception {

		CompanyReportRecord dao = new CompanyReportRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyReportRecord> queryCompanyReportRecord( com.pomplatform.db.bean.BaseCompanyReportRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyReportRecord dao = new CompanyReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyReportRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyReportRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyReportRecord addToCompanyReportRecord ( BaseCompanyReportRecord companyreportrecord )  throws Exception {
		return addToCompanyReportRecord ( companyreportrecord , false);
	}

	public static BaseCompanyReportRecord addToCompanyReportRecord ( BaseCompanyReportRecord companyreportrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setDataFromBase(companyreportrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyReportRecord addUpdateCompanyReportRecord ( BaseCompanyReportRecord companyreportrecord ) throws Exception {
		return addUpdateCompanyReportRecord ( companyreportrecord , false);
	}

	public static BaseCompanyReportRecord addUpdateCompanyReportRecord ( BaseCompanyReportRecord companyreportrecord, boolean singleTransaction  ) throws Exception {
		if(companyreportrecord.getCompanyReportRecordId() == null) return addToCompanyReportRecord(companyreportrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setDataFromBase(companyreportrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyreportrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyReportRecord ( BaseCompanyReportRecord bean ) throws Exception {
		CompanyReportRecord dao = new CompanyReportRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyReportRecord updateCompanyReportRecord ( BaseCompanyReportRecord companyreportrecord ) throws Exception {
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setCompanyReportRecordId( companyreportrecord.getCompanyReportRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyreportrecord);
			result = dao.update();
		}
		return result == 1 ? companyreportrecord : null ;
	}

	public static BaseCompanyReportRecord updateCompanyReportRecordDirect( BaseCompanyReportRecord companyreportrecord ) throws Exception {
		CompanyReportRecord dao = new CompanyReportRecord();
		int result = 0;
		dao.setDataFromBase(companyreportrecord);
		result = dao.update();
		return result == 1 ? companyreportrecord : null ;
	}

	public static int setDeleteConditions(BaseCompanyReportRecord bean, CompanyReportRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyReportRecordId() != null) {
			dao.setConditionCompanyReportRecordId("=", bean.getCompanyReportRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPercent() != null) {
				dao.setConditionPercent("=", bean.getPercent());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyReportRecord bean, CompanyReportRecord dao){
		int count = 0;
		if(bean.getCompanyReportRecordId() != null) {
			dao.setConditionCompanyReportRecordId("=", bean.getCompanyReportRecordId());
			count++;
		}
		if(bean.getPercent() != null) {
			if(bean.getPercent().indexOf("%") >= 0)
				dao.setConditionPercent("like", bean.getPercent());
			else
				dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getSigningMoneySum() != null) {
			dao.setConditionSigningMoneySum("=", bean.getSigningMoneySum());
			count++;
		}
		if(bean.getSheetTotalIntegral() != null) {
			dao.setConditionSheetTotalIntegral("=", bean.getSheetTotalIntegral());
			count++;
		}
		if(bean.getCompanySubsidy() != null) {
			dao.setConditionCompanySubsidy("=", bean.getCompanySubsidy());
			count++;
		}
		if(bean.getWinIntegral() != null) {
			dao.setConditionWinIntegral("=", bean.getWinIntegral());
			count++;
		}
		if(bean.getComplaintIntegral() != null) {
			dao.setConditionComplaintIntegral("=", bean.getComplaintIntegral());
			count++;
		}
		if(bean.getProjectIntegralExtract() != null) {
			dao.setConditionProjectIntegralExtract("=", bean.getProjectIntegralExtract());
			count++;
		}
		if(bean.getAwardSend() != null) {
			dao.setConditionAwardSend("=", bean.getAwardSend());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		bean.setDataFromJSON(json);
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyReportRecord> rlist = new BaseCollection<>();
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyReportRecord dao = new CompanyReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyReportRecord> result = dao.conditionalLoad(addtion);
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
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		bean.setDataFromJSON(json);
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		bean.setDataFromJSON(json);
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		bean.setDataFromJSON(json);
		CompanyReportRecord dao = new CompanyReportRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyReportRecord bean = new BaseCompanyReportRecord();
		bean.setDataFromJSON(json);
		CompanyReportRecord dao = new CompanyReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


