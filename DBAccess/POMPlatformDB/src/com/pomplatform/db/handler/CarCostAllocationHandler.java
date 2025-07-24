package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCarCostAllocation;
import com.pomplatform.db.dao.CarCostAllocation;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CarCostAllocationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CarCostAllocationHandler.class);

	public static BaseCarCostAllocation getCarCostAllocationById( 
		java.lang.Integer car_cost_allocation_id
	) throws Exception
	{
		CarCostAllocation dao = new CarCostAllocation();
		dao.setCarCostAllocationId(car_cost_allocation_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCarCostAllocationExists( com.pomplatform.db.bean.BaseCarCostAllocation bean, String additional ) throws Exception {

		CarCostAllocation dao = new CarCostAllocation();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCarCostAllocation( com.pomplatform.db.bean.BaseCarCostAllocation bean, String additional ) throws Exception {

		CarCostAllocation dao = new CarCostAllocation();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCarCostAllocation> queryCarCostAllocation( com.pomplatform.db.bean.BaseCarCostAllocation bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CarCostAllocation dao = new CarCostAllocation();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCarCostAllocation> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCarCostAllocation> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCarCostAllocation addToCarCostAllocation ( BaseCarCostAllocation carcostallocation )  throws Exception {
		return addToCarCostAllocation ( carcostallocation , false);
	}

	public static BaseCarCostAllocation addToCarCostAllocation ( BaseCarCostAllocation carcostallocation, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CarCostAllocation dao = new CarCostAllocation();
		dao.setDataFromBase(carcostallocation);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCarCostAllocation addUpdateCarCostAllocation ( BaseCarCostAllocation carcostallocation ) throws Exception {
		return addUpdateCarCostAllocation ( carcostallocation , false);
	}

	public static BaseCarCostAllocation addUpdateCarCostAllocation ( BaseCarCostAllocation carcostallocation, boolean singleTransaction  ) throws Exception {
		if(carcostallocation.getCarCostAllocationId() == null) return addToCarCostAllocation(carcostallocation);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CarCostAllocation dao = new CarCostAllocation();
		dao.setDataFromBase(carcostallocation);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(carcostallocation); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCarCostAllocation ( BaseCarCostAllocation bean ) throws Exception {
		CarCostAllocation dao = new CarCostAllocation();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCarCostAllocation updateCarCostAllocation ( BaseCarCostAllocation carcostallocation ) throws Exception {
		CarCostAllocation dao = new CarCostAllocation();
		dao.setCarCostAllocationId( carcostallocation.getCarCostAllocationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(carcostallocation);
			result = dao.update();
		}
		return result == 1 ? carcostallocation : null ;
	}

	public static BaseCarCostAllocation updateCarCostAllocationDirect( BaseCarCostAllocation carcostallocation ) throws Exception {
		CarCostAllocation dao = new CarCostAllocation();
		int result = 0;
		dao.setDataFromBase(carcostallocation);
		result = dao.update();
		return result == 1 ? carcostallocation : null ;
	}

	public static int setDeleteConditions(BaseCarCostAllocation bean, CarCostAllocation dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCarCostAllocationId() != null) {
			dao.setConditionCarCostAllocationId("=", bean.getCarCostAllocationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
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

	public static int setConditions(BaseCarCostAllocation bean, CarCostAllocation dao){
		int count = 0;
		if(bean.getCarCostAllocationId() != null) {
			dao.setConditionCarCostAllocationId("=", bean.getCarCostAllocationId());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
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
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
			count++;
		}
		if(bean.getCostAllocation() != null) {
			dao.setConditionCostAllocation("=", bean.getCostAllocation());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		bean.setDataFromJSON(json);
		CarCostAllocation dao = new CarCostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCarCostAllocation> rlist = new BaseCollection<>();
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CarCostAllocation dao = new CarCostAllocation();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCarCostAllocation> result = dao.conditionalLoad(addtion);
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
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		bean.setDataFromJSON(json);
		CarCostAllocation dao = new CarCostAllocation();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		bean.setDataFromJSON(json);
		CarCostAllocation dao = new CarCostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		bean.setDataFromJSON(json);
		CarCostAllocation dao = new CarCostAllocation();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCarCostAllocation bean = new BaseCarCostAllocation();
		bean.setDataFromJSON(json);
		CarCostAllocation dao = new CarCostAllocation();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


