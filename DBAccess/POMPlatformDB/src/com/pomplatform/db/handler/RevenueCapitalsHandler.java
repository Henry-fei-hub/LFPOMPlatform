package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseRevenueCapitals;
import com.pomplatform.db.dao.RevenueCapitals;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class RevenueCapitalsHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(RevenueCapitalsHandler.class);

	public static BaseRevenueCapitals getRevenueCapitalsById( 
		java.lang.Integer revenue_capitals_id
	) throws Exception
	{
		RevenueCapitals dao = new RevenueCapitals();
		dao.setRevenueCapitalsId(revenue_capitals_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isRevenueCapitalsExists( com.pomplatform.db.bean.BaseRevenueCapitals bean, String additional ) throws Exception {

		RevenueCapitals dao = new RevenueCapitals();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countRevenueCapitals( com.pomplatform.db.bean.BaseRevenueCapitals bean, String additional ) throws Exception {

		RevenueCapitals dao = new RevenueCapitals();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseRevenueCapitals> queryRevenueCapitals( com.pomplatform.db.bean.BaseRevenueCapitals bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		RevenueCapitals dao = new RevenueCapitals();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseRevenueCapitals> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseRevenueCapitals> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseRevenueCapitals addToRevenueCapitals ( BaseRevenueCapitals revenuecapitals )  throws Exception {
		return addToRevenueCapitals ( revenuecapitals , false);
	}

	public static BaseRevenueCapitals addToRevenueCapitals ( BaseRevenueCapitals revenuecapitals, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		RevenueCapitals dao = new RevenueCapitals();
		dao.setDataFromBase(revenuecapitals);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseRevenueCapitals addUpdateRevenueCapitals ( BaseRevenueCapitals revenuecapitals ) throws Exception {
		return addUpdateRevenueCapitals ( revenuecapitals , false);
	}

	public static BaseRevenueCapitals addUpdateRevenueCapitals ( BaseRevenueCapitals revenuecapitals, boolean singleTransaction  ) throws Exception {
		if(revenuecapitals.getRevenueCapitalsId() == null) return addToRevenueCapitals(revenuecapitals);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		RevenueCapitals dao = new RevenueCapitals();
		dao.setDataFromBase(revenuecapitals);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(revenuecapitals); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteRevenueCapitals ( BaseRevenueCapitals bean ) throws Exception {
		RevenueCapitals dao = new RevenueCapitals();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseRevenueCapitals updateRevenueCapitals ( BaseRevenueCapitals revenuecapitals ) throws Exception {
		RevenueCapitals dao = new RevenueCapitals();
		dao.setRevenueCapitalsId( revenuecapitals.getRevenueCapitalsId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(revenuecapitals);
			result = dao.update();
		}
		return result == 1 ? revenuecapitals : null ;
	}

	public static BaseRevenueCapitals updateRevenueCapitalsDirect( BaseRevenueCapitals revenuecapitals ) throws Exception {
		RevenueCapitals dao = new RevenueCapitals();
		int result = 0;
		dao.setDataFromBase(revenuecapitals);
		result = dao.update();
		return result == 1 ? revenuecapitals : null ;
	}

	public static int setDeleteConditions(BaseRevenueCapitals bean, RevenueCapitals dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getRevenueCapitalsId() != null) {
			dao.setConditionRevenueCapitalsId("=", bean.getRevenueCapitalsId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getIsTrue() != null) {
				dao.setConditionIsTrue("=", bean.getIsTrue());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseRevenueCapitals bean, RevenueCapitals dao){
		int count = 0;
		if(bean.getRevenueCapitalsId() != null) {
			dao.setConditionRevenueCapitalsId("=", bean.getRevenueCapitalsId());
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
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getCapitalAmount() != null) {
			dao.setConditionCapitalAmount("=", bean.getCapitalAmount());
			count++;
		}
		if(bean.getRevenueAmount() != null) {
			dao.setConditionRevenueAmount("=", bean.getRevenueAmount());
			count++;
		}
		if(bean.getIsTrue() != null) {
			dao.setConditionIsTrue("=", bean.getIsTrue());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		bean.setDataFromJSON(json);
		RevenueCapitals dao = new RevenueCapitals();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseRevenueCapitals> rlist = new BaseCollection<>();
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		RevenueCapitals dao = new RevenueCapitals();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseRevenueCapitals> result = dao.conditionalLoad(addtion);
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
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		bean.setDataFromJSON(json);
		RevenueCapitals dao = new RevenueCapitals();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		bean.setDataFromJSON(json);
		RevenueCapitals dao = new RevenueCapitals();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		bean.setDataFromJSON(json);
		RevenueCapitals dao = new RevenueCapitals();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseRevenueCapitals bean = new BaseRevenueCapitals();
		bean.setDataFromJSON(json);
		RevenueCapitals dao = new RevenueCapitals();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


