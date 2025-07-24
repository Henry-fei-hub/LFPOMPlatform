package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseResetCost;
import com.pomplatform.db.dao.ResetCost;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ResetCostHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ResetCostHandler.class);

	public static BaseResetCost getResetCostById( 
		java.lang.Integer reset_cost_id
	) throws Exception
	{
		ResetCost dao = new ResetCost();
		dao.setResetCostId(reset_cost_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isResetCostExists( com.pomplatform.db.bean.BaseResetCost bean, String additional ) throws Exception {

		ResetCost dao = new ResetCost();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countResetCost( com.pomplatform.db.bean.BaseResetCost bean, String additional ) throws Exception {

		ResetCost dao = new ResetCost();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseResetCost> queryResetCost( com.pomplatform.db.bean.BaseResetCost bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ResetCost dao = new ResetCost();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseResetCost> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseResetCost> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseResetCost addToResetCost ( BaseResetCost resetcost )  throws Exception {
		return addToResetCost ( resetcost , false);
	}

	public static BaseResetCost addToResetCost ( BaseResetCost resetcost, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ResetCost dao = new ResetCost();
		dao.setDataFromBase(resetcost);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseResetCost addUpdateResetCost ( BaseResetCost resetcost ) throws Exception {
		return addUpdateResetCost ( resetcost , false);
	}

	public static BaseResetCost addUpdateResetCost ( BaseResetCost resetcost, boolean singleTransaction  ) throws Exception {
		if(resetcost.getResetCostId() == null) return addToResetCost(resetcost);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ResetCost dao = new ResetCost();
		dao.setDataFromBase(resetcost);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(resetcost); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteResetCost ( BaseResetCost bean ) throws Exception {
		ResetCost dao = new ResetCost();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseResetCost updateResetCost ( BaseResetCost resetcost ) throws Exception {
		ResetCost dao = new ResetCost();
		dao.setResetCostId( resetcost.getResetCostId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(resetcost);
			result = dao.update();
		}
		return result == 1 ? resetcost : null ;
	}

	public static BaseResetCost updateResetCostDirect( BaseResetCost resetcost ) throws Exception {
		ResetCost dao = new ResetCost();
		int result = 0;
		dao.setDataFromBase(resetcost);
		result = dao.update();
		return result == 1 ? resetcost : null ;
	}

	public static int setDeleteConditions(BaseResetCost bean, ResetCost dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getResetCostId() != null) {
			dao.setConditionResetCostId("=", bean.getResetCostId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
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
			if(bean.getCostType() != null) {
				dao.setConditionCostType("=", bean.getCostType());
				count++;
			}
			if(bean.getLinkId() != null) {
				dao.setConditionLinkId("=", bean.getLinkId());
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
			if(bean.getDrafter() != null) {
				dao.setConditionDrafter("=", bean.getDrafter());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getCurrency() != null) {
				dao.setConditionCurrency("=", bean.getCurrency());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseResetCost bean, ResetCost dao){
		int count = 0;
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
		if(bean.getCostType() != null) {
			dao.setConditionCostType("=", bean.getCostType());
			count++;
		}
		if(bean.getLinkId() != null) {
			dao.setConditionLinkId("=", bean.getLinkId());
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
		if(bean.getDrafter() != null) {
			dao.setConditionDrafter("=", bean.getDrafter());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getCurrency() != null) {
			dao.setConditionCurrency("=", bean.getCurrency());
			count++;
		}
		if(bean.getExchangeRate() != null) {
			dao.setConditionExchangeRate("=", bean.getExchangeRate());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseResetCost bean = new BaseResetCost();
		bean.setDataFromJSON(json);
		ResetCost dao = new ResetCost();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseResetCost> rlist = new BaseCollection<>();
		BaseResetCost bean = new BaseResetCost();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ResetCost dao = new ResetCost();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseResetCost> result = dao.conditionalLoad(addtion);
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
		BaseResetCost bean = new BaseResetCost();
		bean.setDataFromJSON(json);
		ResetCost dao = new ResetCost();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseResetCost bean = new BaseResetCost();
		bean.setDataFromJSON(json);
		ResetCost dao = new ResetCost();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseResetCost bean = new BaseResetCost();
		bean.setDataFromJSON(json);
		ResetCost dao = new ResetCost();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseResetCost bean = new BaseResetCost();
		bean.setDataFromJSON(json);
		ResetCost dao = new ResetCost();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


