package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.dao.CompanyRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompanyRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompanyRecordHandler.class);

	public static BaseCompanyRecord getCompanyRecordById( 
		java.lang.Integer company_record_id
	) throws Exception
	{
		CompanyRecord dao = new CompanyRecord();
		dao.setCompanyRecordId(company_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompanyRecordExists( com.pomplatform.db.bean.BaseCompanyRecord bean, String additional ) throws Exception {

		CompanyRecord dao = new CompanyRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompanyRecord( com.pomplatform.db.bean.BaseCompanyRecord bean, String additional ) throws Exception {

		CompanyRecord dao = new CompanyRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompanyRecord> queryCompanyRecord( com.pomplatform.db.bean.BaseCompanyRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompanyRecord dao = new CompanyRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompanyRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompanyRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompanyRecord addToCompanyRecord ( BaseCompanyRecord companyrecord )  throws Exception {
		return addToCompanyRecord ( companyrecord , false);
	}

	public static BaseCompanyRecord addToCompanyRecord ( BaseCompanyRecord companyrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompanyRecord dao = new CompanyRecord();
		dao.setDataFromBase(companyrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompanyRecord addUpdateCompanyRecord ( BaseCompanyRecord companyrecord ) throws Exception {
		return addUpdateCompanyRecord ( companyrecord , false);
	}

	public static BaseCompanyRecord addUpdateCompanyRecord ( BaseCompanyRecord companyrecord, boolean singleTransaction  ) throws Exception {
		if(companyrecord.getCompanyRecordId() == null) return addToCompanyRecord(companyrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompanyRecord dao = new CompanyRecord();
		dao.setDataFromBase(companyrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(companyrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompanyRecord ( BaseCompanyRecord bean ) throws Exception {
		CompanyRecord dao = new CompanyRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompanyRecord updateCompanyRecord ( BaseCompanyRecord companyrecord ) throws Exception {
		CompanyRecord dao = new CompanyRecord();
		dao.setCompanyRecordId( companyrecord.getCompanyRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(companyrecord);
			result = dao.update();
		}
		return result == 1 ? companyrecord : null ;
	}

	public static BaseCompanyRecord updateCompanyRecordDirect( BaseCompanyRecord companyrecord ) throws Exception {
		CompanyRecord dao = new CompanyRecord();
		int result = 0;
		dao.setDataFromBase(companyrecord);
		result = dao.update();
		return result == 1 ? companyrecord : null ;
	}

	public static int setDeleteConditions(BaseCompanyRecord bean, CompanyRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyRecordId() != null) {
			dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyName() != null) {
				dao.setConditionCompanyName("=", bean.getCompanyName());
				count++;
			}
			if(bean.getCompanyCode() != null) {
				dao.setConditionCompanyCode("=", bean.getCompanyCode());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getCompanyNameSimple() != null) {
				dao.setConditionCompanyNameSimple("=", bean.getCompanyNameSimple());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyRecord bean, CompanyRecord dao){
		int count = 0;
		if(bean.getCompanyRecordId() != null) {
			dao.setConditionCompanyRecordId("=", bean.getCompanyRecordId());
			count++;
		}
		if(bean.getCompanyName() != null) {
			if(bean.getCompanyName().indexOf("%") >= 0)
				dao.setConditionCompanyName("like", bean.getCompanyName());
			else
				dao.setConditionCompanyName("=", bean.getCompanyName());
			count++;
		}
		if(bean.getCompanyCode() != null) {
			if(bean.getCompanyCode().indexOf("%") >= 0)
				dao.setConditionCompanyCode("like", bean.getCompanyCode());
			else
				dao.setConditionCompanyCode("=", bean.getCompanyCode());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getCompanyNameSimple() != null) {
			if(bean.getCompanyNameSimple().indexOf("%") >= 0)
				dao.setConditionCompanyNameSimple("like", bean.getCompanyNameSimple());
			else
				dao.setConditionCompanyNameSimple("=", bean.getCompanyNameSimple());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyRecord bean = new BaseCompanyRecord();
		bean.setDataFromJSON(json);
		CompanyRecord dao = new CompanyRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyRecord> rlist = new BaseCollection<>();
		BaseCompanyRecord bean = new BaseCompanyRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyRecord dao = new CompanyRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyRecord> result = dao.conditionalLoad(addtion);
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
		BaseCompanyRecord bean = new BaseCompanyRecord();
		bean.setDataFromJSON(json);
		CompanyRecord dao = new CompanyRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyRecord bean = new BaseCompanyRecord();
		bean.setDataFromJSON(json);
		CompanyRecord dao = new CompanyRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyRecord bean = new BaseCompanyRecord();
		bean.setDataFromJSON(json);
		CompanyRecord dao = new CompanyRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyRecord bean = new BaseCompanyRecord();
		bean.setDataFromJSON(json);
		CompanyRecord dao = new CompanyRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


