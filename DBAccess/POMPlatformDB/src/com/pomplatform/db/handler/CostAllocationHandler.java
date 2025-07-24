package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCostAllocation;
import com.pomplatform.db.dao.CostAllocation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CostAllocationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CostAllocationHandler.class);

	public static BaseCostAllocation getCostAllocationById( 
		java.lang.Integer cost_allocation_id
	) throws Exception
	{
		CostAllocation dao = new CostAllocation();
		dao.setCostAllocationId(cost_allocation_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCostAllocationExists( com.pomplatform.db.bean.BaseCostAllocation bean, String additional ) throws Exception {

		CostAllocation dao = new CostAllocation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCostAllocation( com.pomplatform.db.bean.BaseCostAllocation bean, String additional ) throws Exception {

		CostAllocation dao = new CostAllocation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCostAllocation> queryCostAllocation( com.pomplatform.db.bean.BaseCostAllocation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CostAllocation dao = new CostAllocation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCostAllocation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCostAllocation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCostAllocation addToCostAllocation ( BaseCostAllocation costallocation )  throws Exception {
		return addToCostAllocation ( costallocation , false);
	}

	public static BaseCostAllocation addToCostAllocation ( BaseCostAllocation costallocation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CostAllocation dao = new CostAllocation();
		dao.setDataFromBase(costallocation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCostAllocation addUpdateCostAllocation ( BaseCostAllocation costallocation ) throws Exception {
		return addUpdateCostAllocation ( costallocation , false);
	}

	public static BaseCostAllocation addUpdateCostAllocation ( BaseCostAllocation costallocation, boolean singleTransaction  ) throws Exception {
		if(costallocation.getCostAllocationId() == null) return addToCostAllocation(costallocation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CostAllocation dao = new CostAllocation();
		dao.setDataFromBase(costallocation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(costallocation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCostAllocation ( BaseCostAllocation bean ) throws Exception {
		CostAllocation dao = new CostAllocation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCostAllocation updateCostAllocation ( BaseCostAllocation costallocation ) throws Exception {
		CostAllocation dao = new CostAllocation();
		dao.setCostAllocationId( costallocation.getCostAllocationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(costallocation);
			result = dao.update();
		}
		return result == 1 ? costallocation : null ;
	}

	public static BaseCostAllocation updateCostAllocationDirect( BaseCostAllocation costallocation ) throws Exception {
		CostAllocation dao = new CostAllocation();
		int result = 0;
		dao.setDataFromBase(costallocation);
		result = dao.update();
		return result == 1 ? costallocation : null ;
	}

	public static int setDeleteConditions(BaseCostAllocation bean, CostAllocation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCostAllocationId() != null) {
			dao.setConditionCostAllocationId("=", bean.getCostAllocationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getResetCostId() != null) {
				dao.setConditionResetCostId("=", bean.getResetCostId());
				count++;
			}
			if(bean.getId() != null) {
				dao.setConditionId("=", bean.getId());
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
		}
		return count;
	}

	public static int setConditions(BaseCostAllocation bean, CostAllocation dao){
		int count = 0;
		if(bean.getCostAllocationId() != null) {
			dao.setConditionCostAllocationId("=", bean.getCostAllocationId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getResetCostId() != null) {
			dao.setConditionResetCostId("=", bean.getResetCostId());
			count++;
		}
		if(bean.getId() != null) {
			dao.setConditionId("=", bean.getId());
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
		if(bean.getCost() != null) {
			dao.setConditionCost("=", bean.getCost());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCostAllocation bean = new BaseCostAllocation();
		bean.setDataFromJSON(json);
		CostAllocation dao = new CostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCostAllocation> rlist = new BaseCollection<>();
		BaseCostAllocation bean = new BaseCostAllocation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CostAllocation dao = new CostAllocation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCostAllocation> result = dao.conditionalLoad(addtion);
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
		BaseCostAllocation bean = new BaseCostAllocation();
		bean.setDataFromJSON(json);
		CostAllocation dao = new CostAllocation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCostAllocation bean = new BaseCostAllocation();
		bean.setDataFromJSON(json);
		CostAllocation dao = new CostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCostAllocation bean = new BaseCostAllocation();
		bean.setDataFromJSON(json);
		CostAllocation dao = new CostAllocation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCostAllocation bean = new BaseCostAllocation();
		bean.setDataFromJSON(json);
		CostAllocation dao = new CostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


