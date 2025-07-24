package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchaseOrder;
import com.pomplatform.db.dao.PurchaseOrder;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchaseOrderHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchaseOrderHandler.class);

	public static BasePurchaseOrder getPurchaseOrderById( 
		java.lang.Integer purchase_order_id
	) throws Exception
	{
		PurchaseOrder dao = new PurchaseOrder();
		dao.setPurchaseOrderId(purchase_order_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchaseOrderExists( com.pomplatform.db.bean.BasePurchaseOrder bean, String additional ) throws Exception {

		PurchaseOrder dao = new PurchaseOrder();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchaseOrder( com.pomplatform.db.bean.BasePurchaseOrder bean, String additional ) throws Exception {

		PurchaseOrder dao = new PurchaseOrder();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchaseOrder> queryPurchaseOrder( com.pomplatform.db.bean.BasePurchaseOrder bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchaseOrder dao = new PurchaseOrder();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchaseOrder> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchaseOrder> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchaseOrder addToPurchaseOrder ( BasePurchaseOrder purchaseorder )  throws Exception {
		return addToPurchaseOrder ( purchaseorder , false);
	}

	public static BasePurchaseOrder addToPurchaseOrder ( BasePurchaseOrder purchaseorder, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchaseOrder dao = new PurchaseOrder();
		dao.setDataFromBase(purchaseorder);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchaseOrder addUpdatePurchaseOrder ( BasePurchaseOrder purchaseorder ) throws Exception {
		return addUpdatePurchaseOrder ( purchaseorder , false);
	}

	public static BasePurchaseOrder addUpdatePurchaseOrder ( BasePurchaseOrder purchaseorder, boolean singleTransaction  ) throws Exception {
		if(purchaseorder.getPurchaseOrderId() == null) return addToPurchaseOrder(purchaseorder);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchaseOrder dao = new PurchaseOrder();
		dao.setDataFromBase(purchaseorder);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchaseorder); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchaseOrder ( BasePurchaseOrder bean ) throws Exception {
		PurchaseOrder dao = new PurchaseOrder();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchaseOrder updatePurchaseOrder ( BasePurchaseOrder purchaseorder ) throws Exception {
		PurchaseOrder dao = new PurchaseOrder();
		dao.setPurchaseOrderId( purchaseorder.getPurchaseOrderId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchaseorder);
			result = dao.update();
		}
		return result == 1 ? purchaseorder : null ;
	}

	public static BasePurchaseOrder updatePurchaseOrderDirect( BasePurchaseOrder purchaseorder ) throws Exception {
		PurchaseOrder dao = new PurchaseOrder();
		int result = 0;
		dao.setDataFromBase(purchaseorder);
		result = dao.update();
		return result == 1 ? purchaseorder : null ;
	}

	public static int setDeleteConditions(BasePurchaseOrder bean, PurchaseOrder dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseOrderId() != null) {
			dao.setConditionPurchaseOrderId("=", bean.getPurchaseOrderId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOrderCode() != null) {
				dao.setConditionOrderCode("=", bean.getOrderCode());
				count++;
			}
			if(bean.getOrderName() != null) {
				dao.setConditionOrderName("=", bean.getOrderName());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getOrderRequirement() != null) {
				dao.setConditionOrderRequirement("=", bean.getOrderRequirement());
				count++;
			}
			if(bean.getContactName() != null) {
				dao.setConditionContactName("=", bean.getContactName());
				count++;
			}
			if(bean.getContactPhone() != null) {
				dao.setConditionContactPhone("=", bean.getContactPhone());
				count++;
			}
			if(bean.getContactGender() != null) {
				dao.setConditionContactGender("=", bean.getContactGender());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getOrderEmployeeId() != null) {
				dao.setConditionOrderEmployeeId("=", bean.getOrderEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchaseOrder bean, PurchaseOrder dao){
		int count = 0;
		if(bean.getPurchaseOrderId() != null) {
			dao.setConditionPurchaseOrderId("=", bean.getPurchaseOrderId());
			count++;
		}
		if(bean.getOrderCode() != null) {
			if(bean.getOrderCode().indexOf("%") >= 0)
				dao.setConditionOrderCode("like", bean.getOrderCode());
			else
				dao.setConditionOrderCode("=", bean.getOrderCode());
			count++;
		}
		if(bean.getOrderName() != null) {
			if(bean.getOrderName().indexOf("%") >= 0)
				dao.setConditionOrderName("like", bean.getOrderName());
			else
				dao.setConditionOrderName("=", bean.getOrderName());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getOrderRequirement() != null) {
			if(bean.getOrderRequirement().indexOf("%") >= 0)
				dao.setConditionOrderRequirement("like", bean.getOrderRequirement());
			else
				dao.setConditionOrderRequirement("=", bean.getOrderRequirement());
			count++;
		}
		if(bean.getContactName() != null) {
			if(bean.getContactName().indexOf("%") >= 0)
				dao.setConditionContactName("like", bean.getContactName());
			else
				dao.setConditionContactName("=", bean.getContactName());
			count++;
		}
		if(bean.getContactPhone() != null) {
			if(bean.getContactPhone().indexOf("%") >= 0)
				dao.setConditionContactPhone("like", bean.getContactPhone());
			else
				dao.setConditionContactPhone("=", bean.getContactPhone());
			count++;
		}
		if(bean.getContactGender() != null) {
			dao.setConditionContactGender("=", bean.getContactGender());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getOrderEmployeeId() != null) {
			dao.setConditionOrderEmployeeId("=", bean.getOrderEmployeeId());
			count++;
		}
		if(bean.getOrderTime() != null) {
			dao.setConditionOrderTime(">=", bean.getOrderTime());
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
		BasePurchaseOrder bean = new BasePurchaseOrder();
		bean.setDataFromJSON(json);
		PurchaseOrder dao = new PurchaseOrder();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseOrder> rlist = new BaseCollection<>();
		BasePurchaseOrder bean = new BasePurchaseOrder();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseOrder dao = new PurchaseOrder();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseOrder> result = dao.conditionalLoad(addtion);
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
		BasePurchaseOrder bean = new BasePurchaseOrder();
		bean.setDataFromJSON(json);
		PurchaseOrder dao = new PurchaseOrder();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseOrder bean = new BasePurchaseOrder();
		bean.setDataFromJSON(json);
		PurchaseOrder dao = new PurchaseOrder();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseOrder bean = new BasePurchaseOrder();
		bean.setDataFromJSON(json);
		PurchaseOrder dao = new PurchaseOrder();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseOrder bean = new BasePurchaseOrder();
		bean.setDataFromJSON(json);
		PurchaseOrder dao = new PurchaseOrder();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


