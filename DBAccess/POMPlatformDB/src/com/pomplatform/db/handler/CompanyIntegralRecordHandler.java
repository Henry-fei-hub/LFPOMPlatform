package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyIntegralRecord;
import com.pomplatform.db.dao.CompanyIntegralRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyIntegralRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyIntegralRecordHandler.class);

	public static BaseCompanyIntegralRecord getCompanyIntegralRecordById( 
		java.lang.Integer company_integral_record_id
	) throws Exception
	{
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setCompanyIntegralRecordId(company_integral_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyIntegralRecordExists( com.pomplatform.db.bean.BaseCompanyIntegralRecord bean, String additional ) throws Exception {

		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyIntegralRecord( com.pomplatform.db.bean.BaseCompanyIntegralRecord bean, String additional ) throws Exception {

		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyIntegralRecord> queryCompanyIntegralRecord( com.pomplatform.db.bean.BaseCompanyIntegralRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyIntegralRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyIntegralRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyIntegralRecord addToCompanyIntegralRecord ( BaseCompanyIntegralRecord companyintegralrecord )  throws Exception {
		return addToCompanyIntegralRecord ( companyintegralrecord , false);
	}

	public static BaseCompanyIntegralRecord addToCompanyIntegralRecord ( BaseCompanyIntegralRecord companyintegralrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setDataFromBase(companyintegralrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyIntegralRecord addUpdateCompanyIntegralRecord ( BaseCompanyIntegralRecord companyintegralrecord ) throws Exception {
		return addUpdateCompanyIntegralRecord ( companyintegralrecord , false);
	}

	public static BaseCompanyIntegralRecord addUpdateCompanyIntegralRecord ( BaseCompanyIntegralRecord companyintegralrecord, boolean singleTransaction  ) throws Exception {
		if(companyintegralrecord.getCompanyIntegralRecordId() == null) return addToCompanyIntegralRecord(companyintegralrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setDataFromBase(companyintegralrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyintegralrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyIntegralRecord ( BaseCompanyIntegralRecord bean ) throws Exception {
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyIntegralRecord updateCompanyIntegralRecord ( BaseCompanyIntegralRecord companyintegralrecord ) throws Exception {
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setCompanyIntegralRecordId( companyintegralrecord.getCompanyIntegralRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyintegralrecord);
			result = dao.update();
		}
		return result == 1 ? companyintegralrecord : null ;
	}

	public static BaseCompanyIntegralRecord updateCompanyIntegralRecordDirect( BaseCompanyIntegralRecord companyintegralrecord ) throws Exception {
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		int result = 0;
		dao.setDataFromBase(companyintegralrecord);
		result = dao.update();
		return result == 1 ? companyintegralrecord : null ;
	}

	public static int setDeleteConditions(BaseCompanyIntegralRecord bean, CompanyIntegralRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyIntegralRecordId() != null) {
			dao.setConditionCompanyIntegralRecordId("=", bean.getCompanyIntegralRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyIntegralRecord bean, CompanyIntegralRecord dao){
		int count = 0;
		if(bean.getCompanyIntegralRecordId() != null) {
			dao.setConditionCompanyIntegralRecordId("=", bean.getCompanyIntegralRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getIntegral() != null) {
			dao.setConditionIntegral("=", bean.getIntegral());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		bean.setDataFromJSON(json);
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyIntegralRecord> rlist = new BaseCollection<>();
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyIntegralRecord> result = dao.conditionalLoad(addtion);
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
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		bean.setDataFromJSON(json);
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		bean.setDataFromJSON(json);
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		bean.setDataFromJSON(json);
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
		bean.setDataFromJSON(json);
		CompanyIntegralRecord dao = new CompanyIntegralRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


