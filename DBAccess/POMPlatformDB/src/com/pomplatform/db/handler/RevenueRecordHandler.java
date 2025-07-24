package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueRecord;
import com.pomplatform.db.dao.RevenueRecord;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class RevenueRecordHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RevenueRecordHandler.class);

	public static BaseRevenueRecord getRevenueRecordById( 
		java.lang.Integer revenue_record_id
	) throws Exception
	{
		RevenueRecord dao = new RevenueRecord();
		dao.setRevenueRecordId(revenue_record_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRevenueRecordExists( com.pomplatform.db.bean.BaseRevenueRecord bean, String additional ) throws Exception {

		RevenueRecord dao = new RevenueRecord();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRevenueRecord( com.pomplatform.db.bean.BaseRevenueRecord bean, String additional ) throws Exception {

		RevenueRecord dao = new RevenueRecord();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRevenueRecord> queryRevenueRecord( com.pomplatform.db.bean.BaseRevenueRecord bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RevenueRecord dao = new RevenueRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRevenueRecord> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRevenueRecord> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRevenueRecord addToRevenueRecord ( BaseRevenueRecord revenuerecord )  throws Exception {
		return addToRevenueRecord ( revenuerecord , false);
	}

	public static BaseRevenueRecord addToRevenueRecord ( BaseRevenueRecord revenuerecord, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RevenueRecord dao = new RevenueRecord();
		dao.setDataFromBase(revenuerecord);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRevenueRecord addUpdateRevenueRecord ( BaseRevenueRecord revenuerecord ) throws Exception {
		return addUpdateRevenueRecord ( revenuerecord , false);
	}

	public static BaseRevenueRecord addUpdateRevenueRecord ( BaseRevenueRecord revenuerecord, boolean singleTransaction  ) throws Exception {
		if(revenuerecord.getRevenueRecordId() == null) return addToRevenueRecord(revenuerecord);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RevenueRecord dao = new RevenueRecord();
		dao.setDataFromBase(revenuerecord);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(revenuerecord); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRevenueRecord ( BaseRevenueRecord bean ) throws Exception {
		RevenueRecord dao = new RevenueRecord();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRevenueRecord updateRevenueRecord ( BaseRevenueRecord revenuerecord ) throws Exception {
		RevenueRecord dao = new RevenueRecord();
		dao.setRevenueRecordId( revenuerecord.getRevenueRecordId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(revenuerecord);
			result = dao.update();
		}
		return result == 1 ? revenuerecord : null ;
	}

	public static BaseRevenueRecord updateRevenueRecordDirect( BaseRevenueRecord revenuerecord ) throws Exception {
		RevenueRecord dao = new RevenueRecord();
		int result = 0;
		dao.setDataFromBase(revenuerecord);
		result = dao.update();
		return result == 1 ? revenuerecord : null ;
	}

	public static int setDeleteConditions(BaseRevenueRecord bean, RevenueRecord dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRevenueRecordId() != null) {
			dao.setConditionRevenueRecordId("=", bean.getRevenueRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getCode() != null) {
				dao.setConditionCode("=", bean.getCode());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getFinishPercentView() != null) {
				dao.setConditionFinishPercentView("=", bean.getFinishPercentView());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSigningCompany() != null) {
				dao.setConditionSigningCompany("=", bean.getSigningCompany());
				count++;
			}
			if(bean.getIsFinish() != null) {
				dao.setConditionIsFinish("=", bean.getIsFinish());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
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
			if(bean.getFinishPercentDetailView() != null) {
				dao.setConditionFinishPercentDetailView("=", bean.getFinishPercentDetailView());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRevenueRecord bean, RevenueRecord dao){
		int count = 0;
		if(bean.getRevenueRecordId() != null) {
			dao.setConditionRevenueRecordId("=", bean.getRevenueRecordId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getCode() != null) {
			if(bean.getCode().indexOf("%") >= 0)
				dao.setConditionCode("like", bean.getCode());
			else
				dao.setConditionCode("=", bean.getCode());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getMoney() != null) {
			dao.setConditionMoney("=", bean.getMoney());
			count++;
		}
		if(bean.getFinishPercent() != null) {
			dao.setConditionFinishPercent("=", bean.getFinishPercent());
			count++;
		}
		if(bean.getFinishPercentView() != null) {
			if(bean.getFinishPercentView().indexOf("%") >= 0)
				dao.setConditionFinishPercentView("like", bean.getFinishPercentView());
			else
				dao.setConditionFinishPercentView("=", bean.getFinishPercentView());
			count++;
		}
		if(bean.getRevenueMoney() != null) {
			dao.setConditionRevenueMoney("=", bean.getRevenueMoney());
			count++;
		}
		if(bean.getInvoiceAmount() != null) {
			dao.setConditionInvoiceAmount("=", bean.getInvoiceAmount());
			count++;
		}
		if(bean.getBorrowMoney() != null) {
			dao.setConditionBorrowMoney("=", bean.getBorrowMoney());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSigningCompany() != null) {
			dao.setConditionSigningCompany("=", bean.getSigningCompany());
			count++;
		}
		if(bean.getIsFinish() != null) {
			dao.setConditionIsFinish("=", bean.getIsFinish());
			count++;
		}
		if(bean.getAccountDate() != null) {
			dao.setConditionAccountDate(">=", bean.getAccountDate());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
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
		if(bean.getFinishPercentDetail() != null) {
			dao.setConditionFinishPercentDetail("=", bean.getFinishPercentDetail());
			count++;
		}
		if(bean.getFinishPercentDetailView() != null) {
			if(bean.getFinishPercentDetailView().indexOf("%") >= 0)
				dao.setConditionFinishPercentDetailView("like", bean.getFinishPercentDetailView());
			else
				dao.setConditionFinishPercentDetailView("=", bean.getFinishPercentDetailView());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseRevenueRecord bean = new BaseRevenueRecord();
		bean.setDataFromJSON(json);
		RevenueRecord dao = new RevenueRecord();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRevenueRecord> rlist = new BaseCollection<>();
		BaseRevenueRecord bean = new BaseRevenueRecord();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RevenueRecord dao = new RevenueRecord();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRevenueRecord> result = dao.conditionalLoad(addtion);
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
		BaseRevenueRecord bean = new BaseRevenueRecord();
		bean.setDataFromJSON(json);
		RevenueRecord dao = new RevenueRecord();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRevenueRecord bean = new BaseRevenueRecord();
		bean.setDataFromJSON(json);
		RevenueRecord dao = new RevenueRecord();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRevenueRecord bean = new BaseRevenueRecord();
		bean.setDataFromJSON(json);
		RevenueRecord dao = new RevenueRecord();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRevenueRecord bean = new BaseRevenueRecord();
		bean.setDataFromJSON(json);
		RevenueRecord dao = new RevenueRecord();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


