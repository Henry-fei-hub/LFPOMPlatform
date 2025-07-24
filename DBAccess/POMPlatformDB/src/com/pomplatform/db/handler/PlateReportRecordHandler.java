package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateReportRecord;
import com.pomplatform.db.dao.PlateReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateReportRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateReportRecordHandler.class);

	public static BasePlateReportRecord getPlateReportRecordById( 
		java.lang.Integer plate_report_record_id
	) throws Exception
	{
		PlateReportRecord dao = new PlateReportRecord();
		dao.setPlateReportRecordId(plate_report_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateReportRecordExists( com.pomplatform.db.bean.BasePlateReportRecord bean, String additional ) throws Exception {

		PlateReportRecord dao = new PlateReportRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateReportRecord( com.pomplatform.db.bean.BasePlateReportRecord bean, String additional ) throws Exception {

		PlateReportRecord dao = new PlateReportRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateReportRecord> queryPlateReportRecord( com.pomplatform.db.bean.BasePlateReportRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateReportRecord dao = new PlateReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateReportRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateReportRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateReportRecord addToPlateReportRecord ( BasePlateReportRecord platereportrecord )  throws Exception {
		return addToPlateReportRecord ( platereportrecord , false);
	}

	public static BasePlateReportRecord addToPlateReportRecord ( BasePlateReportRecord platereportrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateReportRecord dao = new PlateReportRecord();
		dao.setDataFromBase(platereportrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateReportRecord addUpdatePlateReportRecord ( BasePlateReportRecord platereportrecord ) throws Exception {
		return addUpdatePlateReportRecord ( platereportrecord , false);
	}

	public static BasePlateReportRecord addUpdatePlateReportRecord ( BasePlateReportRecord platereportrecord, boolean singleTransaction  ) throws Exception {
		if(platereportrecord.getPlateReportRecordId() == null) return addToPlateReportRecord(platereportrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateReportRecord dao = new PlateReportRecord();
		dao.setDataFromBase(platereportrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platereportrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateReportRecord ( BasePlateReportRecord bean ) throws Exception {
		PlateReportRecord dao = new PlateReportRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateReportRecord updatePlateReportRecord ( BasePlateReportRecord platereportrecord ) throws Exception {
		PlateReportRecord dao = new PlateReportRecord();
		dao.setPlateReportRecordId( platereportrecord.getPlateReportRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platereportrecord);
			result = dao.update();
		}
		return result == 1 ? platereportrecord : null ;
	}

	public static BasePlateReportRecord updatePlateReportRecordDirect( BasePlateReportRecord platereportrecord ) throws Exception {
		PlateReportRecord dao = new PlateReportRecord();
		int result = 0;
		dao.setDataFromBase(platereportrecord);
		result = dao.update();
		return result == 1 ? platereportrecord : null ;
	}

	public static int setDeleteConditions(BasePlateReportRecord bean, PlateReportRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateReportRecordId() != null) {
			dao.setConditionPlateReportRecordId("=", bean.getPlateReportRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getIsLock() != null) {
				dao.setConditionIsLock("=", bean.getIsLock());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateReportRecord bean, PlateReportRecord dao){
		int count = 0;
		if(bean.getPlateReportRecordId() != null) {
			dao.setConditionPlateReportRecordId("=", bean.getPlateReportRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getProjectSettlement() != null) {
			dao.setConditionProjectSettlement("=", bean.getProjectSettlement());
			count++;
		}
		if(bean.getCompanySubsidy() != null) {
			dao.setConditionCompanySubsidy("=", bean.getCompanySubsidy());
			count++;
		}
		if(bean.getEmployeeAchieveIntegralReturn() != null) {
			dao.setConditionEmployeeAchieveIntegralReturn("=", bean.getEmployeeAchieveIntegralReturn());
			count++;
		}
		if(bean.getSalaryReturn() != null) {
			dao.setConditionSalaryReturn("=", bean.getSalaryReturn());
			count++;
		}
		if(bean.getSalaryAdvance() != null) {
			dao.setConditionSalaryAdvance("=", bean.getSalaryAdvance());
			count++;
		}
		if(bean.getManagerProjectIntegral() != null) {
			dao.setConditionManagerProjectIntegral("=", bean.getManagerProjectIntegral());
			count++;
		}
		if(bean.getPlateCost() != null) {
			dao.setConditionPlateCost("=", bean.getPlateCost());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getIsLock() != null) {
			dao.setConditionIsLock("=", bean.getIsLock());
			count++;
		}
		if(bean.getProjectAdvance() != null) {
			dao.setConditionProjectAdvance("=", bean.getProjectAdvance());
			count++;
		}
		if(bean.getQualityFee() != null) {
			dao.setConditionQualityFee("=", bean.getQualityFee());
			count++;
		}
		if(bean.getCompanyFee() != null) {
			dao.setConditionCompanyFee("=", bean.getCompanyFee());
			count++;
		}
		if(bean.getViolationCharges() != null) {
			dao.setConditionViolationCharges("=", bean.getViolationCharges());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateReportRecord bean = new BasePlateReportRecord();
		bean.setDataFromJSON(json);
		PlateReportRecord dao = new PlateReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateReportRecord> rlist = new BaseCollection<>();
		BasePlateReportRecord bean = new BasePlateReportRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateReportRecord dao = new PlateReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateReportRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateReportRecord bean = new BasePlateReportRecord();
		bean.setDataFromJSON(json);
		PlateReportRecord dao = new PlateReportRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateReportRecord bean = new BasePlateReportRecord();
		bean.setDataFromJSON(json);
		PlateReportRecord dao = new PlateReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateReportRecord bean = new BasePlateReportRecord();
		bean.setDataFromJSON(json);
		PlateReportRecord dao = new PlateReportRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateReportRecord bean = new BasePlateReportRecord();
		bean.setDataFromJSON(json);
		PlateReportRecord dao = new PlateReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


