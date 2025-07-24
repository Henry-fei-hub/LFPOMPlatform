package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import java.util.List;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class RevenueStatisticalRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RevenueStatisticalRecordHandler.class);

	public static BaseRevenueStatisticalRecord getRevenueStatisticalRecordById( 
		java.lang.Integer revenue_statistical_record_id
	) throws Exception
	{
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setRevenueStatisticalRecordId(revenue_statistical_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRevenueStatisticalRecordExists( com.pomplatform.db.bean.BaseRevenueStatisticalRecord bean, String additional ) throws Exception {

		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRevenueStatisticalRecord( com.pomplatform.db.bean.BaseRevenueStatisticalRecord bean, String additional ) throws Exception {

		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRevenueStatisticalRecord> queryRevenueStatisticalRecord( com.pomplatform.db.bean.BaseRevenueStatisticalRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRevenueStatisticalRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRevenueStatisticalRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRevenueStatisticalRecord addToRevenueStatisticalRecord ( BaseRevenueStatisticalRecord revenuestatisticalrecord )  throws Exception {
		return addToRevenueStatisticalRecord ( revenuestatisticalrecord , false);
	}

	public static BaseRevenueStatisticalRecord addToRevenueStatisticalRecord ( BaseRevenueStatisticalRecord revenuestatisticalrecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setDataFromBase(revenuestatisticalrecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRevenueStatisticalRecord addUpdateRevenueStatisticalRecord ( BaseRevenueStatisticalRecord revenuestatisticalrecord ) throws Exception {
		return addUpdateRevenueStatisticalRecord ( revenuestatisticalrecord , false);
	}

	public static BaseRevenueStatisticalRecord addUpdateRevenueStatisticalRecord ( BaseRevenueStatisticalRecord revenuestatisticalrecord, boolean singleTransaction  ) throws Exception {
		if(revenuestatisticalrecord.getRevenueStatisticalRecordId() == null) return addToRevenueStatisticalRecord(revenuestatisticalrecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setDataFromBase(revenuestatisticalrecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(revenuestatisticalrecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRevenueStatisticalRecord ( BaseRevenueStatisticalRecord bean ) throws Exception {
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRevenueStatisticalRecord updateRevenueStatisticalRecord ( BaseRevenueStatisticalRecord revenuestatisticalrecord ) throws Exception {
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setRevenueStatisticalRecordId( revenuestatisticalrecord.getRevenueStatisticalRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(revenuestatisticalrecord);
			result = dao.update();
		}
		return result == 1 ? revenuestatisticalrecord : null ;
	}

	public static BaseRevenueStatisticalRecord updateRevenueStatisticalRecordDirect( BaseRevenueStatisticalRecord revenuestatisticalrecord ) throws Exception {
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		int result = 0;
		dao.setDataFromBase(revenuestatisticalrecord);
		result = dao.update();
		return result == 1 ? revenuestatisticalrecord : null ;
	}

	public static int setDeleteConditions(BaseRevenueStatisticalRecord bean, RevenueStatisticalRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRevenueStatisticalRecordId() != null) {
			dao.setConditionRevenueStatisticalRecordId("=", bean.getRevenueStatisticalRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
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
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getRatePercentStr() != null) {
				dao.setConditionRatePercentStr("=", bean.getRatePercentStr());
				count++;
			}
			if(bean.getSheetPercentStr() != null) {
				dao.setConditionSheetPercentStr("=", bean.getSheetPercentStr());
				count++;
			}
			if(bean.getModifyPercentStr() != null) {
				dao.setConditionModifyPercentStr("=", bean.getModifyPercentStr());
				count++;
			}
			if(bean.getTotalPercentStr() != null) {
				dao.setConditionTotalPercentStr("=", bean.getTotalPercentStr());
				count++;
			}
			if(bean.getTotalSurePercentStr() != null) {
				dao.setConditionTotalSurePercentStr("=", bean.getTotalSurePercentStr());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRevenueStatisticalRecord bean, RevenueStatisticalRecord dao){
		int count = 0;
		if(bean.getRevenueStatisticalRecordId() != null) {
			dao.setConditionRevenueStatisticalRecordId("=", bean.getRevenueStatisticalRecordId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
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
		if(bean.getSheetPercent() != null) {
			dao.setConditionSheetPercent("=", bean.getSheetPercent());
			count++;
		}
		if(bean.getModifyPercent() != null) {
			dao.setConditionModifyPercent("=", bean.getModifyPercent());
			count++;
		}
		if(bean.getTotalPercent() != null) {
			dao.setConditionTotalPercent("=", bean.getTotalPercent());
			count++;
		}
		if(bean.getTotalTaxRevenue() != null) {
			dao.setConditionTotalTaxRevenue("=", bean.getTotalTaxRevenue());
			count++;
		}
		if(bean.getTotalRevenue() != null) {
			dao.setConditionTotalRevenue("=", bean.getTotalRevenue());
			count++;
		}
		if(bean.getCurrentRevenue() != null) {
			dao.setConditionCurrentRevenue("=", bean.getCurrentRevenue());
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
		if(bean.getSheetAmount() != null) {
			dao.setConditionSheetAmount("=", bean.getSheetAmount());
			count++;
		}
		if(bean.getRatePercent() != null) {
			dao.setConditionRatePercent("=", bean.getRatePercent());
			count++;
		}
		if(bean.getRatePercentStr() != null) {
			if(bean.getRatePercentStr().indexOf("%") >= 0)
				dao.setConditionRatePercentStr("like", bean.getRatePercentStr());
			else
				dao.setConditionRatePercentStr("=", bean.getRatePercentStr());
			count++;
		}
		if(bean.getSheetPercentStr() != null) {
			if(bean.getSheetPercentStr().indexOf("%") >= 0)
				dao.setConditionSheetPercentStr("like", bean.getSheetPercentStr());
			else
				dao.setConditionSheetPercentStr("=", bean.getSheetPercentStr());
			count++;
		}
		if(bean.getModifyPercentStr() != null) {
			if(bean.getModifyPercentStr().indexOf("%") >= 0)
				dao.setConditionModifyPercentStr("like", bean.getModifyPercentStr());
			else
				dao.setConditionModifyPercentStr("=", bean.getModifyPercentStr());
			count++;
		}
		if(bean.getTotalPercentStr() != null) {
			if(bean.getTotalPercentStr().indexOf("%") >= 0)
				dao.setConditionTotalPercentStr("like", bean.getTotalPercentStr());
			else
				dao.setConditionTotalPercentStr("=", bean.getTotalPercentStr());
			count++;
		}
		if(bean.getTotalSurePercent() != null) {
			dao.setConditionTotalSurePercent("=", bean.getTotalSurePercent());
			count++;
		}
		if(bean.getTotalSurePercentStr() != null) {
			if(bean.getTotalSurePercentStr().indexOf("%") >= 0)
				dao.setConditionTotalSurePercentStr("like", bean.getTotalSurePercentStr());
			else
				dao.setConditionTotalSurePercentStr("=", bean.getTotalSurePercentStr());
			count++;
		}
		if(bean.getTotalSureRevenue() != null) {
			dao.setConditionTotalSureRevenue("=", bean.getTotalSureRevenue());
			count++;
		}
		if(bean.getContractSave() != null) {
			dao.setConditionContractSave("=", bean.getContractSave());
			count++;
		}
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		if(bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if(bean.getContractSaveActive() != null) {
			dao.setConditionContractSaveActive("=", bean.getContractSaveActive());
			count++;
		}
		if(bean.getContractSaveActiveUn() != null) {
			dao.setConditionContractSaveActiveUn("=", bean.getContractSaveActiveUn());
			count++;
		}
		if(bean.getContractSaveActivePause() != null) {
			dao.setConditionContractSaveActivePause("=", bean.getContractSaveActivePause());
			count++;
		}
		if(bean.getContractSaveActiveNever() != null) {
			dao.setConditionContractSaveActiveNever("=", bean.getContractSaveActiveNever());
			count++;
		}
		if(bean.getContractSaveOther() != null) {
			dao.setConditionContractSaveOther("=", bean.getContractSaveOther());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRevenueStatisticalRecord> rlist = new BaseCollection<>();
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRevenueStatisticalRecord> result = dao.conditionalLoad(addtion);
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
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
		bean.setDataFromJSON(json);
		RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


