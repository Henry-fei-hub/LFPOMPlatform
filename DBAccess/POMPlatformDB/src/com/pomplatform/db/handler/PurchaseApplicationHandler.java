package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchaseApplication;
import com.pomplatform.db.dao.PurchaseApplication;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchaseApplicationHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchaseApplicationHandler.class);

	public static BasePurchaseApplication getPurchaseApplicationById( 
		java.lang.Integer purchase_application_id
	) throws Exception
	{
		PurchaseApplication dao = new PurchaseApplication();
		dao.setPurchaseApplicationId(purchase_application_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchaseApplicationExists( com.pomplatform.db.bean.BasePurchaseApplication bean, String additional ) throws Exception {

		PurchaseApplication dao = new PurchaseApplication();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchaseApplication( com.pomplatform.db.bean.BasePurchaseApplication bean, String additional ) throws Exception {

		PurchaseApplication dao = new PurchaseApplication();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchaseApplication> queryPurchaseApplication( com.pomplatform.db.bean.BasePurchaseApplication bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchaseApplication dao = new PurchaseApplication();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchaseApplication> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchaseApplication> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchaseApplication addToPurchaseApplication ( BasePurchaseApplication purchaseapplication )  throws Exception {
		return addToPurchaseApplication ( purchaseapplication , false);
	}

	public static BasePurchaseApplication addToPurchaseApplication ( BasePurchaseApplication purchaseapplication, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchaseApplication dao = new PurchaseApplication();
		dao.setDataFromBase(purchaseapplication);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchaseApplication addUpdatePurchaseApplication ( BasePurchaseApplication purchaseapplication ) throws Exception {
		return addUpdatePurchaseApplication ( purchaseapplication , false);
	}

	public static BasePurchaseApplication addUpdatePurchaseApplication ( BasePurchaseApplication purchaseapplication, boolean singleTransaction  ) throws Exception {
		if(purchaseapplication.getPurchaseApplicationId() == null) return addToPurchaseApplication(purchaseapplication);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchaseApplication dao = new PurchaseApplication();
		dao.setDataFromBase(purchaseapplication);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchaseapplication); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchaseApplication ( BasePurchaseApplication bean ) throws Exception {
		PurchaseApplication dao = new PurchaseApplication();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchaseApplication updatePurchaseApplication ( BasePurchaseApplication purchaseapplication ) throws Exception {
		PurchaseApplication dao = new PurchaseApplication();
		dao.setPurchaseApplicationId( purchaseapplication.getPurchaseApplicationId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchaseapplication);
			result = dao.update();
		}
		return result == 1 ? purchaseapplication : null ;
	}

	public static BasePurchaseApplication updatePurchaseApplicationDirect( BasePurchaseApplication purchaseapplication ) throws Exception {
		PurchaseApplication dao = new PurchaseApplication();
		int result = 0;
		dao.setDataFromBase(purchaseapplication);
		result = dao.update();
		return result == 1 ? purchaseapplication : null ;
	}

	public static int setDeleteConditions(BasePurchaseApplication bean, PurchaseApplication dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseApplicationId() != null) {
			dao.setConditionPurchaseApplicationId("=", bean.getPurchaseApplicationId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMajorTitle() != null) {
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
				count++;
			}
			if(bean.getApplyDepartmentId() != null) {
				dao.setConditionApplyDepartmentId("=", bean.getApplyDepartmentId());
				count++;
			}
			if(bean.getApplyReason() != null) {
				dao.setConditionApplyReason("=", bean.getApplyReason());
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
		}
		return count;
	}

	public static int setConditions(BasePurchaseApplication bean, PurchaseApplication dao){
		int count = 0;
		if(bean.getPurchaseApplicationId() != null) {
			dao.setConditionPurchaseApplicationId("=", bean.getPurchaseApplicationId());
			count++;
		}
		if(bean.getMajorTitle() != null) {
			if(bean.getMajorTitle().indexOf("%") >= 0)
				dao.setConditionMajorTitle("like", bean.getMajorTitle());
			else
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
			count++;
		}
		if(bean.getApplyDepartmentId() != null) {
			dao.setConditionApplyDepartmentId("=", bean.getApplyDepartmentId());
			count++;
		}
		if(bean.getPurchaseAmount() != null) {
			dao.setConditionPurchaseAmount("=", bean.getPurchaseAmount());
			count++;
		}
		if(bean.getApplyReason() != null) {
			if(bean.getApplyReason().indexOf("%") >= 0)
				dao.setConditionApplyReason("like", bean.getApplyReason());
			else
				dao.setConditionApplyReason("=", bean.getApplyReason());
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
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchaseApplication bean = new BasePurchaseApplication();
		bean.setDataFromJSON(json);
		PurchaseApplication dao = new PurchaseApplication();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseApplication> rlist = new BaseCollection<>();
		BasePurchaseApplication bean = new BasePurchaseApplication();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseApplication dao = new PurchaseApplication();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseApplication> result = dao.conditionalLoad(addtion);
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
		BasePurchaseApplication bean = new BasePurchaseApplication();
		bean.setDataFromJSON(json);
		PurchaseApplication dao = new PurchaseApplication();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseApplication bean = new BasePurchaseApplication();
		bean.setDataFromJSON(json);
		PurchaseApplication dao = new PurchaseApplication();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseApplication bean = new BasePurchaseApplication();
		bean.setDataFromJSON(json);
		PurchaseApplication dao = new PurchaseApplication();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseApplication bean = new BasePurchaseApplication();
		bean.setDataFromJSON(json);
		PurchaseApplication dao = new PurchaseApplication();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


