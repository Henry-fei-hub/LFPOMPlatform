package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchaseOrderItem;
import com.pomplatform.db.dao.PurchaseOrderItem;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchaseOrderItemHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchaseOrderItemHandler.class);

	public static BasePurchaseOrderItem getPurchaseOrderItemById( 
		java.lang.Integer purchase_order_item_id
	) throws Exception
	{
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setPurchaseOrderItemId(purchase_order_item_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchaseOrderItemExists( com.pomplatform.db.bean.BasePurchaseOrderItem bean, String additional ) throws Exception {

		PurchaseOrderItem dao = new PurchaseOrderItem();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchaseOrderItem( com.pomplatform.db.bean.BasePurchaseOrderItem bean, String additional ) throws Exception {

		PurchaseOrderItem dao = new PurchaseOrderItem();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchaseOrderItem> queryPurchaseOrderItem( com.pomplatform.db.bean.BasePurchaseOrderItem bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchaseOrderItem dao = new PurchaseOrderItem();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchaseOrderItem> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchaseOrderItem> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchaseOrderItem addToPurchaseOrderItem ( BasePurchaseOrderItem purchaseorderitem )  throws Exception {
		return addToPurchaseOrderItem ( purchaseorderitem , false);
	}

	public static BasePurchaseOrderItem addToPurchaseOrderItem ( BasePurchaseOrderItem purchaseorderitem, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setDataFromBase(purchaseorderitem);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchaseOrderItem addUpdatePurchaseOrderItem ( BasePurchaseOrderItem purchaseorderitem ) throws Exception {
		return addUpdatePurchaseOrderItem ( purchaseorderitem , false);
	}

	public static BasePurchaseOrderItem addUpdatePurchaseOrderItem ( BasePurchaseOrderItem purchaseorderitem, boolean singleTransaction  ) throws Exception {
		if(purchaseorderitem.getPurchaseOrderItemId() == null) return addToPurchaseOrderItem(purchaseorderitem);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setDataFromBase(purchaseorderitem);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchaseorderitem); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchaseOrderItem ( BasePurchaseOrderItem bean ) throws Exception {
		PurchaseOrderItem dao = new PurchaseOrderItem();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchaseOrderItem updatePurchaseOrderItem ( BasePurchaseOrderItem purchaseorderitem ) throws Exception {
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setPurchaseOrderItemId( purchaseorderitem.getPurchaseOrderItemId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchaseorderitem);
			result = dao.update();
		}
		return result == 1 ? purchaseorderitem : null ;
	}

	public static BasePurchaseOrderItem updatePurchaseOrderItemDirect( BasePurchaseOrderItem purchaseorderitem ) throws Exception {
		PurchaseOrderItem dao = new PurchaseOrderItem();
		int result = 0;
		dao.setDataFromBase(purchaseorderitem);
		result = dao.update();
		return result == 1 ? purchaseorderitem : null ;
	}

	public static int setDeleteConditions(BasePurchaseOrderItem bean, PurchaseOrderItem dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseOrderItemId() != null) {
			dao.setConditionPurchaseOrderItemId("=", bean.getPurchaseOrderItemId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getProductId() != null) {
				dao.setConditionProductId("=", bean.getProductId());
				count++;
			}
			if(bean.getProductNumber() != null) {
				dao.setConditionProductNumber("=", bean.getProductNumber());
				count++;
			}
			if(bean.getProductUnit() != null) {
				dao.setConditionProductUnit("=", bean.getProductUnit());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchaseOrderItem bean, PurchaseOrderItem dao){
		int count = 0;
		if(bean.getPurchaseOrderItemId() != null) {
			dao.setConditionPurchaseOrderItemId("=", bean.getPurchaseOrderItemId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getProductNumber() != null) {
			dao.setConditionProductNumber("=", bean.getProductNumber());
			count++;
		}
		if(bean.getProductUnit() != null) {
			if(bean.getProductUnit().indexOf("%") >= 0)
				dao.setConditionProductUnit("like", bean.getProductUnit());
			else
				dao.setConditionProductUnit("=", bean.getProductUnit());
			count++;
		}
		if(bean.getProductPrice() != null) {
			dao.setConditionProductPrice("=", bean.getProductPrice());
			count++;
		}
		if(bean.getTotalPrice() != null) {
			dao.setConditionTotalPrice("=", bean.getTotalPrice());
			count++;
		}
		if(bean.getTaxPoints() != null) {
			dao.setConditionTaxPoints("=", bean.getTaxPoints());
			count++;
		}
		if(bean.getTaxPrice() != null) {
			dao.setConditionTaxPrice("=", bean.getTaxPrice());
			count++;
		}
		if(bean.getFinalPrice() != null) {
			dao.setConditionFinalPrice("=", bean.getFinalPrice());
			count++;
		}
		if(bean.getPlanArrivalDate() != null) {
			dao.setConditionPlanArrivalDate(">=", bean.getPlanArrivalDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		bean.setDataFromJSON(json);
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseOrderItem> rlist = new BaseCollection<>();
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseOrderItem dao = new PurchaseOrderItem();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseOrderItem> result = dao.conditionalLoad(addtion);
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
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		bean.setDataFromJSON(json);
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		bean.setDataFromJSON(json);
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		bean.setDataFromJSON(json);
		PurchaseOrderItem dao = new PurchaseOrderItem();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseOrderItem bean = new BasePurchaseOrderItem();
		bean.setDataFromJSON(json);
		PurchaseOrderItem dao = new PurchaseOrderItem();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


