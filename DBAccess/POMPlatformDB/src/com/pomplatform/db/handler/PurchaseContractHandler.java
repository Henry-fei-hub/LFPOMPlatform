package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePurchaseContract;
import com.pomplatform.db.dao.PurchaseContract;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PurchaseContractHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PurchaseContractHandler.class);

	public static BasePurchaseContract getPurchaseContractById( 
		java.lang.Integer purchase_contract_id
	) throws Exception
	{
		PurchaseContract dao = new PurchaseContract();
		dao.setPurchaseContractId(purchase_contract_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPurchaseContractExists( com.pomplatform.db.bean.BasePurchaseContract bean, String additional ) throws Exception {

		PurchaseContract dao = new PurchaseContract();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPurchaseContract( com.pomplatform.db.bean.BasePurchaseContract bean, String additional ) throws Exception {

		PurchaseContract dao = new PurchaseContract();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePurchaseContract> queryPurchaseContract( com.pomplatform.db.bean.BasePurchaseContract bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PurchaseContract dao = new PurchaseContract();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePurchaseContract> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePurchaseContract> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePurchaseContract addToPurchaseContract ( BasePurchaseContract purchasecontract )  throws Exception {
		return addToPurchaseContract ( purchasecontract , false);
	}

	public static BasePurchaseContract addToPurchaseContract ( BasePurchaseContract purchasecontract, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PurchaseContract dao = new PurchaseContract();
		dao.setDataFromBase(purchasecontract);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePurchaseContract addUpdatePurchaseContract ( BasePurchaseContract purchasecontract ) throws Exception {
		return addUpdatePurchaseContract ( purchasecontract , false);
	}

	public static BasePurchaseContract addUpdatePurchaseContract ( BasePurchaseContract purchasecontract, boolean singleTransaction  ) throws Exception {
		if(purchasecontract.getPurchaseContractId() == null) return addToPurchaseContract(purchasecontract);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PurchaseContract dao = new PurchaseContract();
		dao.setDataFromBase(purchasecontract);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(purchasecontract); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePurchaseContract ( BasePurchaseContract bean ) throws Exception {
		PurchaseContract dao = new PurchaseContract();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePurchaseContract updatePurchaseContract ( BasePurchaseContract purchasecontract ) throws Exception {
		PurchaseContract dao = new PurchaseContract();
		dao.setPurchaseContractId( purchasecontract.getPurchaseContractId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(purchasecontract);
			result = dao.update();
		}
		return result == 1 ? purchasecontract : null ;
	}

	public static BasePurchaseContract updatePurchaseContractDirect( BasePurchaseContract purchasecontract ) throws Exception {
		PurchaseContract dao = new PurchaseContract();
		int result = 0;
		dao.setDataFromBase(purchasecontract);
		result = dao.update();
		return result == 1 ? purchasecontract : null ;
	}

	public static int setDeleteConditions(BasePurchaseContract bean, PurchaseContract dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getPurchasePerson() != null) {
				dao.setConditionPurchasePerson("=", bean.getPurchasePerson());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getQualityAssurance() != null) {
				dao.setConditionQualityAssurance("=", bean.getQualityAssurance());
				count++;
			}
			if(bean.getTermOfPayment() != null) {
				dao.setConditionTermOfPayment("=", bean.getTermOfPayment());
				count++;
			}
			if(bean.getAfterSaleRequirements() != null) {
				dao.setConditionAfterSaleRequirements("=", bean.getAfterSaleRequirements());
				count++;
			}
			if(bean.getContractAttachment() != null) {
				dao.setConditionContractAttachment("=", bean.getContractAttachment());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchaseContract bean, PurchaseContract dao){
		int count = 0;
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getPurchasePerson() != null) {
			dao.setConditionPurchasePerson("=", bean.getPurchasePerson());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getQualityAssurance() != null) {
			if(bean.getQualityAssurance().indexOf("%") >= 0)
				dao.setConditionQualityAssurance("like", bean.getQualityAssurance());
			else
				dao.setConditionQualityAssurance("=", bean.getQualityAssurance());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getTermOfPayment() != null) {
			if(bean.getTermOfPayment().indexOf("%") >= 0)
				dao.setConditionTermOfPayment("like", bean.getTermOfPayment());
			else
				dao.setConditionTermOfPayment("=", bean.getTermOfPayment());
			count++;
		}
		if(bean.getAfterSaleRequirements() != null) {
			if(bean.getAfterSaleRequirements().indexOf("%") >= 0)
				dao.setConditionAfterSaleRequirements("like", bean.getAfterSaleRequirements());
			else
				dao.setConditionAfterSaleRequirements("=", bean.getAfterSaleRequirements());
			count++;
		}
		if(bean.getAmountPaid() != null) {
			dao.setConditionAmountPaid("=", bean.getAmountPaid());
			count++;
		}
		if(bean.getAmountUnpaid() != null) {
			dao.setConditionAmountUnpaid("=", bean.getAmountUnpaid());
			count++;
		}
		if(bean.getHaveInvoiceAmount() != null) {
			dao.setConditionHaveInvoiceAmount("=", bean.getHaveInvoiceAmount());
			count++;
		}
		if(bean.getLackInvoiceAmount() != null) {
			dao.setConditionLackInvoiceAmount("=", bean.getLackInvoiceAmount());
			count++;
		}
		if(bean.getContractAttachment() != null) {
			dao.setConditionContractAttachment("=", bean.getContractAttachment());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePurchaseContract bean = new BasePurchaseContract();
		bean.setDataFromJSON(json);
		PurchaseContract dao = new PurchaseContract();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseContract> rlist = new BaseCollection<>();
		BasePurchaseContract bean = new BasePurchaseContract();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseContract dao = new PurchaseContract();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseContract> result = dao.conditionalLoad(addtion);
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
		BasePurchaseContract bean = new BasePurchaseContract();
		bean.setDataFromJSON(json);
		PurchaseContract dao = new PurchaseContract();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseContract bean = new BasePurchaseContract();
		bean.setDataFromJSON(json);
		PurchaseContract dao = new PurchaseContract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseContract bean = new BasePurchaseContract();
		bean.setDataFromJSON(json);
		PurchaseContract dao = new PurchaseContract();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseContract bean = new BasePurchaseContract();
		bean.setDataFromJSON(json);
		PurchaseContract dao = new PurchaseContract();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


