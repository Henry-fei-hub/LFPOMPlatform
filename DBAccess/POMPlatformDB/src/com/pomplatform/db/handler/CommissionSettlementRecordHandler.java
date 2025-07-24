package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCommissionSettlementRecord;
import com.pomplatform.db.dao.CommissionSettlementRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CommissionSettlementRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CommissionSettlementRecordHandler.class);

	public static BaseCommissionSettlementRecord getCommissionSettlementRecordById( 
		java.lang.Integer commission_settlement_record_id
	) throws Exception
	{
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setCommissionSettlementRecordId(commission_settlement_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCommissionSettlementRecordExists( com.pomplatform.db.bean.BaseCommissionSettlementRecord bean, String additional ) throws Exception {

		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCommissionSettlementRecord( com.pomplatform.db.bean.BaseCommissionSettlementRecord bean, String additional ) throws Exception {

		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCommissionSettlementRecord> queryCommissionSettlementRecord( com.pomplatform.db.bean.BaseCommissionSettlementRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCommissionSettlementRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCommissionSettlementRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCommissionSettlementRecord addToCommissionSettlementRecord ( BaseCommissionSettlementRecord commissionsettlementrecord )  throws Exception {
		return addToCommissionSettlementRecord ( commissionsettlementrecord , false);
	}

	public static BaseCommissionSettlementRecord addToCommissionSettlementRecord ( BaseCommissionSettlementRecord commissionsettlementrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setDataFromBase(commissionsettlementrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCommissionSettlementRecord addUpdateCommissionSettlementRecord ( BaseCommissionSettlementRecord commissionsettlementrecord ) throws Exception {
		return addUpdateCommissionSettlementRecord ( commissionsettlementrecord , false);
	}

	public static BaseCommissionSettlementRecord addUpdateCommissionSettlementRecord ( BaseCommissionSettlementRecord commissionsettlementrecord, boolean singleTransaction  ) throws Exception {
		if(commissionsettlementrecord.getCommissionSettlementRecordId() == null) return addToCommissionSettlementRecord(commissionsettlementrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setDataFromBase(commissionsettlementrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(commissionsettlementrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCommissionSettlementRecord ( BaseCommissionSettlementRecord bean ) throws Exception {
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCommissionSettlementRecord updateCommissionSettlementRecord ( BaseCommissionSettlementRecord commissionsettlementrecord ) throws Exception {
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setCommissionSettlementRecordId( commissionsettlementrecord.getCommissionSettlementRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(commissionsettlementrecord);
			result = dao.update();
		}
		return result == 1 ? commissionsettlementrecord : null ;
	}

	public static BaseCommissionSettlementRecord updateCommissionSettlementRecordDirect( BaseCommissionSettlementRecord commissionsettlementrecord ) throws Exception {
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		int result = 0;
		dao.setDataFromBase(commissionsettlementrecord);
		result = dao.update();
		return result == 1 ? commissionsettlementrecord : null ;
	}

	public static int setDeleteConditions(BaseCommissionSettlementRecord bean, CommissionSettlementRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCommissionSettlementRecordId() != null) {
			dao.setConditionCommissionSettlementRecordId("=", bean.getCommissionSettlementRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOrderId() != null) {
				dao.setConditionOrderId("=", bean.getOrderId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getCountType() != null) {
				dao.setConditionCountType("=", bean.getCountType());
				count++;
			}
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getSettlementType() != null) {
				dao.setConditionSettlementType("=", bean.getSettlementType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCommissionSettlementRecord bean, CommissionSettlementRecord dao){
		int count = 0;
		if(bean.getCommissionSettlementRecordId() != null) {
			dao.setConditionCommissionSettlementRecordId("=", bean.getCommissionSettlementRecordId());
			count++;
		}
		if(bean.getOrderId() != null) {
			if(bean.getOrderId().indexOf("%") >= 0)
				dao.setConditionOrderId("like", bean.getOrderId());
			else
				dao.setConditionOrderId("=", bean.getOrderId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getCountType() != null) {
			dao.setConditionCountType("=", bean.getCountType());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getSettlementType() != null) {
			dao.setConditionSettlementType("=", bean.getSettlementType());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getSettlementTime() != null) {
			dao.setConditionSettlementTime(">=", bean.getSettlementTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		bean.setDataFromJSON(json);
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCommissionSettlementRecord> rlist = new BaseCollection<>();
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCommissionSettlementRecord> result = dao.conditionalLoad(addtion);
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
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		bean.setDataFromJSON(json);
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		bean.setDataFromJSON(json);
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		bean.setDataFromJSON(json);
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCommissionSettlementRecord bean = new BaseCommissionSettlementRecord();
		bean.setDataFromJSON(json);
		CommissionSettlementRecord dao = new CommissionSettlementRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


