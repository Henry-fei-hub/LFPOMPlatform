package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOperatingReportRecord;
import com.pomplatform.db.dao.OperatingReportRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OperatingReportRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OperatingReportRecordHandler.class);

	public static BaseOperatingReportRecord getOperatingReportRecordById( 
		java.lang.Integer operating_report_record_id
	) throws Exception
	{
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setOperatingReportRecordId(operating_report_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOperatingReportRecordExists( com.pomplatform.db.bean.BaseOperatingReportRecord bean, String additional ) throws Exception {

		OperatingReportRecord dao = new OperatingReportRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOperatingReportRecord( com.pomplatform.db.bean.BaseOperatingReportRecord bean, String additional ) throws Exception {

		OperatingReportRecord dao = new OperatingReportRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOperatingReportRecord> queryOperatingReportRecord( com.pomplatform.db.bean.BaseOperatingReportRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OperatingReportRecord dao = new OperatingReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOperatingReportRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOperatingReportRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOperatingReportRecord addToOperatingReportRecord ( BaseOperatingReportRecord operatingreportrecord )  throws Exception {
		return addToOperatingReportRecord ( operatingreportrecord , false);
	}

	public static BaseOperatingReportRecord addToOperatingReportRecord ( BaseOperatingReportRecord operatingreportrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setDataFromBase(operatingreportrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOperatingReportRecord addUpdateOperatingReportRecord ( BaseOperatingReportRecord operatingreportrecord ) throws Exception {
		return addUpdateOperatingReportRecord ( operatingreportrecord , false);
	}

	public static BaseOperatingReportRecord addUpdateOperatingReportRecord ( BaseOperatingReportRecord operatingreportrecord, boolean singleTransaction  ) throws Exception {
		if(operatingreportrecord.getOperatingReportRecordId() == null) return addToOperatingReportRecord(operatingreportrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setDataFromBase(operatingreportrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(operatingreportrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOperatingReportRecord ( BaseOperatingReportRecord bean ) throws Exception {
		OperatingReportRecord dao = new OperatingReportRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOperatingReportRecord updateOperatingReportRecord ( BaseOperatingReportRecord operatingreportrecord ) throws Exception {
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setOperatingReportRecordId( operatingreportrecord.getOperatingReportRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(operatingreportrecord);
			result = dao.update();
		}
		return result == 1 ? operatingreportrecord : null ;
	}

	public static BaseOperatingReportRecord updateOperatingReportRecordDirect( BaseOperatingReportRecord operatingreportrecord ) throws Exception {
		OperatingReportRecord dao = new OperatingReportRecord();
		int result = 0;
		dao.setDataFromBase(operatingreportrecord);
		result = dao.update();
		return result == 1 ? operatingreportrecord : null ;
	}

	public static int setDeleteConditions(BaseOperatingReportRecord bean, OperatingReportRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOperatingReportRecordId() != null) {
			dao.setConditionOperatingReportRecordId("=", bean.getOperatingReportRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOperatingReportRecord bean, OperatingReportRecord dao){
		int count = 0;
		if(bean.getOperatingReportRecordId() != null) {
			dao.setConditionOperatingReportRecordId("=", bean.getOperatingReportRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getSureIntegral() != null) {
			dao.setConditionSureIntegral("=", bean.getSureIntegral());
			count++;
		}
		if(bean.getCompanySubsidy() != null) {
			dao.setConditionCompanySubsidy("=", bean.getCompanySubsidy());
			count++;
		}
		if(bean.getAchieveOtherPlateIntegral() != null) {
			dao.setConditionAchieveOtherPlateIntegral("=", bean.getAchieveOtherPlateIntegral());
			count++;
		}
		if(bean.getSalaryCost() != null) {
			dao.setConditionSalaryCost("=", bean.getSalaryCost());
			count++;
		}
		if(bean.getPlateCost() != null) {
			dao.setConditionPlateCost("=", bean.getPlateCost());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
			count++;
		}
		if(bean.getPayCommonPlateIntegral() != null) {
			dao.setConditionPayCommonPlateIntegral("=", bean.getPayCommonPlateIntegral());
			count++;
		}
		if(bean.getPayOtherPlateIntegral() != null) {
			dao.setConditionPayOtherPlateIntegral("=", bean.getPayOtherPlateIntegral());
			count++;
		}
		if(bean.getAchieveIntegral() != null) {
			dao.setConditionAchieveIntegral("=", bean.getAchieveIntegral());
			count++;
		}
		if(bean.getAwardSend() != null) {
			dao.setConditionAwardSend("=", bean.getAwardSend());
			count++;
		}
		if(bean.getLeftAchieveIntegral() != null) {
			dao.setConditionLeftAchieveIntegral("=", bean.getLeftAchieveIntegral());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		bean.setDataFromJSON(json);
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOperatingReportRecord> rlist = new BaseCollection<>();
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OperatingReportRecord dao = new OperatingReportRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOperatingReportRecord> result = dao.conditionalLoad(addtion);
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
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		bean.setDataFromJSON(json);
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		bean.setDataFromJSON(json);
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		bean.setDataFromJSON(json);
		OperatingReportRecord dao = new OperatingReportRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
		bean.setDataFromJSON(json);
		OperatingReportRecord dao = new OperatingReportRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


