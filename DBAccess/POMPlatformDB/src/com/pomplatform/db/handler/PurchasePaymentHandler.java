package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchasePayment;
import com.pomplatform.db.dao.PurchasePayment;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchasePaymentHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchasePaymentHandler.class);

	public static BasePurchasePayment getPurchasePaymentById( 
		java.lang.Integer purchase_payment_id
	) throws Exception
	{
		PurchasePayment dao = new PurchasePayment();
		dao.setPurchasePaymentId(purchase_payment_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchasePaymentExists( com.pomplatform.db.bean.BasePurchasePayment bean, String additional ) throws Exception {

		PurchasePayment dao = new PurchasePayment();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchasePayment( com.pomplatform.db.bean.BasePurchasePayment bean, String additional ) throws Exception {

		PurchasePayment dao = new PurchasePayment();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchasePayment> queryPurchasePayment( com.pomplatform.db.bean.BasePurchasePayment bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchasePayment dao = new PurchasePayment();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchasePayment> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchasePayment> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchasePayment addToPurchasePayment ( BasePurchasePayment purchasepayment )  throws Exception {
		return addToPurchasePayment ( purchasepayment , false);
	}

	public static BasePurchasePayment addToPurchasePayment ( BasePurchasePayment purchasepayment, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchasePayment dao = new PurchasePayment();
		dao.setDataFromBase(purchasepayment);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchasePayment addUpdatePurchasePayment ( BasePurchasePayment purchasepayment ) throws Exception {
		return addUpdatePurchasePayment ( purchasepayment , false);
	}

	public static BasePurchasePayment addUpdatePurchasePayment ( BasePurchasePayment purchasepayment, boolean singleTransaction  ) throws Exception {
		if(purchasepayment.getPurchasePaymentId() == null) return addToPurchasePayment(purchasepayment);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchasePayment dao = new PurchasePayment();
		dao.setDataFromBase(purchasepayment);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchasepayment); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchasePayment ( BasePurchasePayment bean ) throws Exception {
		PurchasePayment dao = new PurchasePayment();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchasePayment updatePurchasePayment ( BasePurchasePayment purchasepayment ) throws Exception {
		PurchasePayment dao = new PurchasePayment();
		dao.setPurchasePaymentId( purchasepayment.getPurchasePaymentId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchasepayment);
			result = dao.update();
		}
		return result == 1 ? purchasepayment : null ;
	}

	public static BasePurchasePayment updatePurchasePaymentDirect( BasePurchasePayment purchasepayment ) throws Exception {
		PurchasePayment dao = new PurchasePayment();
		int result = 0;
		dao.setDataFromBase(purchasepayment);
		result = dao.update();
		return result == 1 ? purchasepayment : null ;
	}

	public static int setDeleteConditions(BasePurchasePayment bean, PurchasePayment dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchasePaymentId() != null) {
			dao.setConditionPurchasePaymentId("=", bean.getPurchasePaymentId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getPaymentName() != null) {
				dao.setConditionPaymentName("=", bean.getPaymentName());
				count++;
			}
			if(bean.getPaymentCondition() != null) {
				dao.setConditionPaymentCondition("=", bean.getPaymentCondition());
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
			if(bean.getPurchasePaymentStatus() != null) {
				dao.setConditionPurchasePaymentStatus("=", bean.getPurchasePaymentStatus());
				count++;
			}
			if(bean.getPersonInCharge() != null) {
				dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
			if(bean.getProcessBusinessId() != null) {
				dao.setConditionProcessBusinessId("=", bean.getProcessBusinessId());
				count++;
			}
			if(bean.getDealStatus() != null) {
				dao.setConditionDealStatus("=", bean.getDealStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchasePayment bean, PurchasePayment dao){
		int count = 0;
		if(bean.getPurchasePaymentId() != null) {
			dao.setConditionPurchasePaymentId("=", bean.getPurchasePaymentId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getPaymentDate() != null) {
			dao.setConditionPaymentDate(">=", bean.getPaymentDate());
			count++;
		}
		if(bean.getPaymentName() != null) {
			if(bean.getPaymentName().indexOf("%") >= 0)
				dao.setConditionPaymentName("like", bean.getPaymentName());
			else
				dao.setConditionPaymentName("=", bean.getPaymentName());
			count++;
		}
		if(bean.getPaymentCondition() != null) {
			if(bean.getPaymentCondition().indexOf("%") >= 0)
				dao.setConditionPaymentCondition("like", bean.getPaymentCondition());
			else
				dao.setConditionPaymentCondition("=", bean.getPaymentCondition());
			count++;
		}
		if(bean.getPaymentRatio() != null) {
			dao.setConditionPaymentRatio("=", bean.getPaymentRatio());
			count++;
		}
		if(bean.getPaymentAmount() != null) {
			dao.setConditionPaymentAmount("=", bean.getPaymentAmount());
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
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		if(bean.getPurchasePaymentStatus() != null) {
			dao.setConditionPurchasePaymentStatus("=", bean.getPurchasePaymentStatus());
			count++;
		}
		if(bean.getPersonInCharge() != null) {
			dao.setConditionPersonInCharge("=", bean.getPersonInCharge());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getRealPaymentDate() != null) {
			dao.setConditionRealPaymentDate(">=", bean.getRealPaymentDate());
			count++;
		}
		if(bean.getRealPaymentAmount() != null) {
			dao.setConditionRealPaymentAmount("=", bean.getRealPaymentAmount());
			count++;
		}
		if(bean.getProcessBusinessId() != null) {
			dao.setConditionProcessBusinessId("=", bean.getProcessBusinessId());
			count++;
		}
		if(bean.getDealStatus() != null) {
			dao.setConditionDealStatus("=", bean.getDealStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchasePayment bean = new BasePurchasePayment();
		bean.setDataFromJSON(json);
		PurchasePayment dao = new PurchasePayment();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchasePayment> rlist = new BaseCollection<>();
		BasePurchasePayment bean = new BasePurchasePayment();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchasePayment dao = new PurchasePayment();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchasePayment> result = dao.conditionalLoad(addtion);
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
		BasePurchasePayment bean = new BasePurchasePayment();
		bean.setDataFromJSON(json);
		PurchasePayment dao = new PurchasePayment();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchasePayment bean = new BasePurchasePayment();
		bean.setDataFromJSON(json);
		PurchasePayment dao = new PurchasePayment();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchasePayment bean = new BasePurchasePayment();
		bean.setDataFromJSON(json);
		PurchasePayment dao = new PurchasePayment();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchasePayment bean = new BasePurchasePayment();
		bean.setDataFromJSON(json);
		PurchasePayment dao = new PurchasePayment();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


