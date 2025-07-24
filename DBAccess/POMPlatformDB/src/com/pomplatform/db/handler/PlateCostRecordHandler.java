package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.dao.PlateCostRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateCostRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateCostRecordHandler.class);

	public static BasePlateCostRecord getPlateCostRecordById( 
		java.lang.Integer plate_cost_record_id
	) throws Exception
	{
		PlateCostRecord dao = new PlateCostRecord();
		dao.setPlateCostRecordId(plate_cost_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateCostRecordExists( com.pomplatform.db.bean.BasePlateCostRecord bean, String additional ) throws Exception {

		PlateCostRecord dao = new PlateCostRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateCostRecord( com.pomplatform.db.bean.BasePlateCostRecord bean, String additional ) throws Exception {

		PlateCostRecord dao = new PlateCostRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateCostRecord> queryPlateCostRecord( com.pomplatform.db.bean.BasePlateCostRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateCostRecord dao = new PlateCostRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateCostRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateCostRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateCostRecord addToPlateCostRecord ( BasePlateCostRecord platecostrecord )  throws Exception {
		return addToPlateCostRecord ( platecostrecord , false);
	}

	public static BasePlateCostRecord addToPlateCostRecord ( BasePlateCostRecord platecostrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateCostRecord dao = new PlateCostRecord();
		dao.setDataFromBase(platecostrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateCostRecord addUpdatePlateCostRecord ( BasePlateCostRecord platecostrecord ) throws Exception {
		return addUpdatePlateCostRecord ( platecostrecord , false);
	}

	public static BasePlateCostRecord addUpdatePlateCostRecord ( BasePlateCostRecord platecostrecord, boolean singleTransaction  ) throws Exception {
		if(platecostrecord.getPlateCostRecordId() == null) return addToPlateCostRecord(platecostrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateCostRecord dao = new PlateCostRecord();
		dao.setDataFromBase(platecostrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(platecostrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateCostRecord ( BasePlateCostRecord bean ) throws Exception {
		PlateCostRecord dao = new PlateCostRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateCostRecord updatePlateCostRecord ( BasePlateCostRecord platecostrecord ) throws Exception {
		PlateCostRecord dao = new PlateCostRecord();
		dao.setPlateCostRecordId( platecostrecord.getPlateCostRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(platecostrecord);
			result = dao.update();
		}
		return result == 1 ? platecostrecord : null ;
	}

	public static BasePlateCostRecord updatePlateCostRecordDirect( BasePlateCostRecord platecostrecord ) throws Exception {
		PlateCostRecord dao = new PlateCostRecord();
		int result = 0;
		dao.setDataFromBase(platecostrecord);
		result = dao.update();
		return result == 1 ? platecostrecord : null ;
	}

	public static int setDeleteConditions(BasePlateCostRecord bean, PlateCostRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateCostRecordId() != null) {
			dao.setConditionPlateCostRecordId("=", bean.getPlateCostRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsSettlement() != null) {
				dao.setConditionIsSettlement("=", bean.getIsSettlement());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getBusinessId() != null) {
				dao.setConditionBusinessId("=", bean.getBusinessId());
				count++;
			}
			if(bean.getProcessId() != null) {
				dao.setConditionProcessId("=", bean.getProcessId());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateCostRecord bean, PlateCostRecord dao){
		int count = 0;
		if(bean.getPlateCostRecordId() != null) {
			dao.setConditionPlateCostRecordId("=", bean.getPlateCostRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCostIntegral() != null) {
			dao.setConditionCostIntegral("=", bean.getCostIntegral());
			count++;
		}
		if(bean.getSalaryIntegral() != null) {
			dao.setConditionSalaryIntegral("=", bean.getSalaryIntegral());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getIsSettlement() != null) {
			dao.setConditionIsSettlement("=", bean.getIsSettlement());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getCostDate() != null) {
			dao.setConditionCostDate(">=", bean.getCostDate());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getBusinessId() != null) {
			dao.setConditionBusinessId("=", bean.getBusinessId());
			count++;
		}
		if(bean.getProcessId() != null) {
			dao.setConditionProcessId("=", bean.getProcessId());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateCostRecord bean = new BasePlateCostRecord();
		bean.setDataFromJSON(json);
		PlateCostRecord dao = new PlateCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateCostRecord> rlist = new BaseCollection<>();
		BasePlateCostRecord bean = new BasePlateCostRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateCostRecord dao = new PlateCostRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateCostRecord> result = dao.conditionalLoad(addtion);
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
		BasePlateCostRecord bean = new BasePlateCostRecord();
		bean.setDataFromJSON(json);
		PlateCostRecord dao = new PlateCostRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateCostRecord bean = new BasePlateCostRecord();
		bean.setDataFromJSON(json);
		PlateCostRecord dao = new PlateCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateCostRecord bean = new BasePlateCostRecord();
		bean.setDataFromJSON(json);
		PlateCostRecord dao = new PlateCostRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateCostRecord bean = new BasePlateCostRecord();
		bean.setDataFromJSON(json);
		PlateCostRecord dao = new PlateCostRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


