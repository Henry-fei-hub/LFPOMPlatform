package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchaseProductDetail;
import com.pomplatform.db.dao.PurchaseProductDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchaseProductDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchaseProductDetailHandler.class);

	public static BasePurchaseProductDetail getPurchaseProductDetailById( 
		java.lang.Integer purchase_product_detail_id
	) throws Exception
	{
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setPurchaseProductDetailId(purchase_product_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchaseProductDetailExists( com.pomplatform.db.bean.BasePurchaseProductDetail bean, String additional ) throws Exception {

		PurchaseProductDetail dao = new PurchaseProductDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchaseProductDetail( com.pomplatform.db.bean.BasePurchaseProductDetail bean, String additional ) throws Exception {

		PurchaseProductDetail dao = new PurchaseProductDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchaseProductDetail> queryPurchaseProductDetail( com.pomplatform.db.bean.BasePurchaseProductDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchaseProductDetail dao = new PurchaseProductDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchaseProductDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchaseProductDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchaseProductDetail addToPurchaseProductDetail ( BasePurchaseProductDetail purchaseproductdetail )  throws Exception {
		return addToPurchaseProductDetail ( purchaseproductdetail , false);
	}

	public static BasePurchaseProductDetail addToPurchaseProductDetail ( BasePurchaseProductDetail purchaseproductdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setDataFromBase(purchaseproductdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchaseProductDetail addUpdatePurchaseProductDetail ( BasePurchaseProductDetail purchaseproductdetail ) throws Exception {
		return addUpdatePurchaseProductDetail ( purchaseproductdetail , false);
	}

	public static BasePurchaseProductDetail addUpdatePurchaseProductDetail ( BasePurchaseProductDetail purchaseproductdetail, boolean singleTransaction  ) throws Exception {
		if(purchaseproductdetail.getPurchaseProductDetailId() == null) return addToPurchaseProductDetail(purchaseproductdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setDataFromBase(purchaseproductdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchaseproductdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchaseProductDetail ( BasePurchaseProductDetail bean ) throws Exception {
		PurchaseProductDetail dao = new PurchaseProductDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchaseProductDetail updatePurchaseProductDetail ( BasePurchaseProductDetail purchaseproductdetail ) throws Exception {
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setPurchaseProductDetailId( purchaseproductdetail.getPurchaseProductDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchaseproductdetail);
			result = dao.update();
		}
		return result == 1 ? purchaseproductdetail : null ;
	}

	public static BasePurchaseProductDetail updatePurchaseProductDetailDirect( BasePurchaseProductDetail purchaseproductdetail ) throws Exception {
		PurchaseProductDetail dao = new PurchaseProductDetail();
		int result = 0;
		dao.setDataFromBase(purchaseproductdetail);
		result = dao.update();
		return result == 1 ? purchaseproductdetail : null ;
	}

	public static int setDeleteConditions(BasePurchaseProductDetail bean, PurchaseProductDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseProductDetailId() != null) {
			dao.setConditionPurchaseProductDetailId("=", bean.getPurchaseProductDetailId());
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
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getPurchaseContractId() != null) {
				dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchaseProductDetail bean, PurchaseProductDetail dao){
		int count = 0;
		if(bean.getPurchaseProductDetailId() != null) {
			dao.setConditionPurchaseProductDetailId("=", bean.getPurchaseProductDetailId());
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
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		bean.setDataFromJSON(json);
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseProductDetail> rlist = new BaseCollection<>();
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseProductDetail dao = new PurchaseProductDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseProductDetail> result = dao.conditionalLoad(addtion);
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
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		bean.setDataFromJSON(json);
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		bean.setDataFromJSON(json);
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		bean.setDataFromJSON(json);
		PurchaseProductDetail dao = new PurchaseProductDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseProductDetail bean = new BasePurchaseProductDetail();
		bean.setDataFromJSON(json);
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


