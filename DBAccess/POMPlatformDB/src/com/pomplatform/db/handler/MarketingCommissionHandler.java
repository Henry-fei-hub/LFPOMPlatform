package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMarketingCommission;
import com.pomplatform.db.dao.MarketingCommission;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MarketingCommissionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MarketingCommissionHandler.class);

	public static BaseMarketingCommission getMarketingCommissionById( 
		java.lang.Short marketing_commission_id
	) throws Exception
	{
		MarketingCommission dao = new MarketingCommission();
		dao.setMarketingCommissionId(marketing_commission_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMarketingCommissionExists( com.pomplatform.db.bean.BaseMarketingCommission bean, String additional ) throws Exception {

		MarketingCommission dao = new MarketingCommission();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMarketingCommission( com.pomplatform.db.bean.BaseMarketingCommission bean, String additional ) throws Exception {

		MarketingCommission dao = new MarketingCommission();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMarketingCommission> queryMarketingCommission( com.pomplatform.db.bean.BaseMarketingCommission bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MarketingCommission dao = new MarketingCommission();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMarketingCommission> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMarketingCommission> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMarketingCommission addToMarketingCommission ( BaseMarketingCommission marketingcommission )  throws Exception {
		return addToMarketingCommission ( marketingcommission , false);
	}

	public static BaseMarketingCommission addToMarketingCommission ( BaseMarketingCommission marketingcommission, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MarketingCommission dao = new MarketingCommission();
		dao.setDataFromBase(marketingcommission);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMarketingCommission addUpdateMarketingCommission ( BaseMarketingCommission marketingcommission ) throws Exception {
		return addUpdateMarketingCommission ( marketingcommission , false);
	}

	public static BaseMarketingCommission addUpdateMarketingCommission ( BaseMarketingCommission marketingcommission, boolean singleTransaction  ) throws Exception {
		if(marketingcommission.getMarketingCommissionId() == null) return addToMarketingCommission(marketingcommission);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MarketingCommission dao = new MarketingCommission();
		dao.setDataFromBase(marketingcommission);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(marketingcommission); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMarketingCommission ( BaseMarketingCommission bean ) throws Exception {
		MarketingCommission dao = new MarketingCommission();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMarketingCommission updateMarketingCommission ( BaseMarketingCommission marketingcommission ) throws Exception {
		MarketingCommission dao = new MarketingCommission();
		dao.setMarketingCommissionId( marketingcommission.getMarketingCommissionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(marketingcommission);
			result = dao.update();
		}
		return result == 1 ? marketingcommission : null ;
	}

	public static BaseMarketingCommission updateMarketingCommissionDirect( BaseMarketingCommission marketingcommission ) throws Exception {
		MarketingCommission dao = new MarketingCommission();
		int result = 0;
		dao.setDataFromBase(marketingcommission);
		result = dao.update();
		return result == 1 ? marketingcommission : null ;
	}

	public static int setDeleteConditions(BaseMarketingCommission bean, MarketingCommission dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMarketingCommissionId() != null) {
			dao.setConditionMarketingCommissionId("=", bean.getMarketingCommissionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getSettlementIdentifier() != null) {
				dao.setConditionSettlementIdentifier("=", bean.getSettlementIdentifier());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMarketingCommission bean, MarketingCommission dao){
		int count = 0;
		if(bean.getMarketingCommissionId() != null) {
			dao.setConditionMarketingCommissionId("=", bean.getMarketingCommissionId());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getCommissions() != null) {
			dao.setConditionCommissions(">=", bean.getCommissions());
			count++;
		}
		if(bean.getCommissionsRate() != null) {
			dao.setConditionCommissionsRate("=", bean.getCommissionsRate());
			count++;
		}
		if(bean.getCumulativeRevenue() != null) {
			dao.setConditionCumulativeRevenue("=", bean.getCumulativeRevenue());
			count++;
		}
		if(bean.getDayRevenue() != null) {
			dao.setConditionDayRevenue("=", bean.getDayRevenue());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getSettlementIdentifier() != null) {
			dao.setConditionSettlementIdentifier("=", bean.getSettlementIdentifier());
			count++;
		}
		if(bean.getRealProgress() != null) {
			dao.setConditionRealProgress("=", bean.getRealProgress());
			count++;
		}
		if(bean.getRelativelyProgress() != null) {
			dao.setConditionRelativelyProgress("=", bean.getRelativelyProgress());
			count++;
		}
		if(bean.getIncome() != null) {
			dao.setConditionIncome("=", bean.getIncome());
			count++;
		}
		if(bean.getProjectAmount() != null) {
			dao.setConditionProjectAmount("=", bean.getProjectAmount());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getTotalIncome() != null) {
			dao.setConditionTotalIncome("=", bean.getTotalIncome());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMarketingCommission bean = new BaseMarketingCommission();
		bean.setDataFromJSON(json);
		MarketingCommission dao = new MarketingCommission();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMarketingCommission> rlist = new BaseCollection<>();
		BaseMarketingCommission bean = new BaseMarketingCommission();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MarketingCommission dao = new MarketingCommission();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMarketingCommission> result = dao.conditionalLoad(addtion);
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
		BaseMarketingCommission bean = new BaseMarketingCommission();
		bean.setDataFromJSON(json);
		MarketingCommission dao = new MarketingCommission();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMarketingCommission bean = new BaseMarketingCommission();
		bean.setDataFromJSON(json);
		MarketingCommission dao = new MarketingCommission();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMarketingCommission bean = new BaseMarketingCommission();
		bean.setDataFromJSON(json);
		MarketingCommission dao = new MarketingCommission();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMarketingCommission bean = new BaseMarketingCommission();
		bean.setDataFromJSON(json);
		MarketingCommission dao = new MarketingCommission();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


