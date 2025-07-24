package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchasePlan;
import com.pomplatform.db.dao.PurchasePlan;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchasePlanHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchasePlanHandler.class);

	public static BasePurchasePlan getPurchasePlanById( 
		java.lang.Integer purchase_plan_id
	) throws Exception
	{
		PurchasePlan dao = new PurchasePlan();
		dao.setPurchasePlanId(purchase_plan_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchasePlanExists( com.pomplatform.db.bean.BasePurchasePlan bean, String additional ) throws Exception {

		PurchasePlan dao = new PurchasePlan();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchasePlan( com.pomplatform.db.bean.BasePurchasePlan bean, String additional ) throws Exception {

		PurchasePlan dao = new PurchasePlan();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchasePlan> queryPurchasePlan( com.pomplatform.db.bean.BasePurchasePlan bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchasePlan dao = new PurchasePlan();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchasePlan> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchasePlan> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchasePlan addToPurchasePlan ( BasePurchasePlan purchaseplan )  throws Exception {
		return addToPurchasePlan ( purchaseplan , false);
	}

	public static BasePurchasePlan addToPurchasePlan ( BasePurchasePlan purchaseplan, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchasePlan dao = new PurchasePlan();
		dao.setDataFromBase(purchaseplan);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchasePlan addUpdatePurchasePlan ( BasePurchasePlan purchaseplan ) throws Exception {
		return addUpdatePurchasePlan ( purchaseplan , false);
	}

	public static BasePurchasePlan addUpdatePurchasePlan ( BasePurchasePlan purchaseplan, boolean singleTransaction  ) throws Exception {
		if(purchaseplan.getPurchasePlanId() == null) return addToPurchasePlan(purchaseplan);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchasePlan dao = new PurchasePlan();
		dao.setDataFromBase(purchaseplan);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchaseplan); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchasePlan ( BasePurchasePlan bean ) throws Exception {
		PurchasePlan dao = new PurchasePlan();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchasePlan updatePurchasePlan ( BasePurchasePlan purchaseplan ) throws Exception {
		PurchasePlan dao = new PurchasePlan();
		dao.setPurchasePlanId( purchaseplan.getPurchasePlanId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchaseplan);
			result = dao.update();
		}
		return result == 1 ? purchaseplan : null ;
	}

	public static BasePurchasePlan updatePurchasePlanDirect( BasePurchasePlan purchaseplan ) throws Exception {
		PurchasePlan dao = new PurchasePlan();
		int result = 0;
		dao.setDataFromBase(purchaseplan);
		result = dao.update();
		return result == 1 ? purchaseplan : null ;
	}

	public static int setDeleteConditions(BasePurchasePlan bean, PurchasePlan dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchasePlanId() != null) {
			dao.setConditionPurchasePlanId("=", bean.getPurchasePlanId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonInCharge() != null) {
				dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getOriPersonnelBusinessId() != null) {
				dao.setConditionOriPersonnelBusinessId("=", bean.getOriPersonnelBusinessId());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getIsComplete() != null) {
				dao.setConditionIsComplete("=", bean.getIsComplete());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getDealStatus() != null) {
				dao.setConditionDealStatus("=", bean.getDealStatus());
				count++;
			}
			if(bean.getPurchaseContractId() != null) {
				dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
				count++;
			}
			if(bean.getToPersonnelBusinessId() != null) {
				dao.setConditionToPersonnelBusinessId("=", bean.getToPersonnelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchasePlan bean, PurchasePlan dao){
		int count = 0;
		if(bean.getPurchasePlanId() != null) {
			dao.setConditionPurchasePlanId("=", bean.getPurchasePlanId());
			count++;
		}
		if(bean.getPersonInCharge() != null) {
			dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getOriPersonnelBusinessId() != null) {
			dao.setConditionOriPersonnelBusinessId("=", bean.getOriPersonnelBusinessId());
			count++;
		}
		if(bean.getPurchaseDate() != null) {
			dao.setConditionPurchaseDate(">=", bean.getPurchaseDate());
			count++;
		}
		if(bean.getPurchaseAmount() != null) {
			dao.setConditionPurchaseAmount("=", bean.getPurchaseAmount());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getTaxAmount() != null) {
			dao.setConditionTaxAmount("=", bean.getTaxAmount());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getIsComplete() != null) {
			dao.setConditionIsComplete("=", bean.getIsComplete());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getDealStatus() != null) {
			dao.setConditionDealStatus("=", bean.getDealStatus());
			count++;
		}
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		if(bean.getToPersonnelBusinessId() != null) {
			dao.setConditionToPersonnelBusinessId("=", bean.getToPersonnelBusinessId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchasePlan bean = new BasePurchasePlan();
		bean.setDataFromJSON(json);
		PurchasePlan dao = new PurchasePlan();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchasePlan> rlist = new BaseCollection<>();
		BasePurchasePlan bean = new BasePurchasePlan();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchasePlan dao = new PurchasePlan();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchasePlan> result = dao.conditionalLoad(addtion);
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
		BasePurchasePlan bean = new BasePurchasePlan();
		bean.setDataFromJSON(json);
		PurchasePlan dao = new PurchasePlan();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchasePlan bean = new BasePurchasePlan();
		bean.setDataFromJSON(json);
		PurchasePlan dao = new PurchasePlan();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchasePlan bean = new BasePurchasePlan();
		bean.setDataFromJSON(json);
		PurchasePlan dao = new PurchasePlan();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchasePlan bean = new BasePurchasePlan();
		bean.setDataFromJSON(json);
		PurchasePlan dao = new PurchasePlan();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


