package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductStorage;
import com.pomplatform.db.dao.ProductStorage;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductStorageHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductStorageHandler.class);

	public static BaseProductStorage getProductStorageById( 
		java.lang.Integer product_storage_id
	) throws Exception
	{
		ProductStorage dao = new ProductStorage();
		dao.setProductStorageId(product_storage_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductStorageExists( com.pomplatform.db.bean.BaseProductStorage bean, String additional ) throws Exception {

		ProductStorage dao = new ProductStorage();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductStorage( com.pomplatform.db.bean.BaseProductStorage bean, String additional ) throws Exception {

		ProductStorage dao = new ProductStorage();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductStorage> queryProductStorage( com.pomplatform.db.bean.BaseProductStorage bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductStorage dao = new ProductStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductStorage> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductStorage> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductStorage addToProductStorage ( BaseProductStorage productstorage )  throws Exception {
		return addToProductStorage ( productstorage , false);
	}

	public static BaseProductStorage addToProductStorage ( BaseProductStorage productstorage, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductStorage dao = new ProductStorage();
		dao.setDataFromBase(productstorage);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductStorage addUpdateProductStorage ( BaseProductStorage productstorage ) throws Exception {
		return addUpdateProductStorage ( productstorage , false);
	}

	public static BaseProductStorage addUpdateProductStorage ( BaseProductStorage productstorage, boolean singleTransaction  ) throws Exception {
		if(productstorage.getProductStorageId() == null) return addToProductStorage(productstorage);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductStorage dao = new ProductStorage();
		dao.setDataFromBase(productstorage);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productstorage); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductStorage ( BaseProductStorage bean ) throws Exception {
		ProductStorage dao = new ProductStorage();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductStorage updateProductStorage ( BaseProductStorage productstorage ) throws Exception {
		ProductStorage dao = new ProductStorage();
		dao.setProductStorageId( productstorage.getProductStorageId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productstorage);
			result = dao.update();
		}
		return result == 1 ? productstorage : null ;
	}

	public static BaseProductStorage updateProductStorageDirect( BaseProductStorage productstorage ) throws Exception {
		ProductStorage dao = new ProductStorage();
		int result = 0;
		dao.setDataFromBase(productstorage);
		result = dao.update();
		return result == 1 ? productstorage : null ;
	}

	public static int setDeleteConditions(BaseProductStorage bean, ProductStorage dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductStorageId() != null) {
			dao.setConditionProductStorageId("=", bean.getProductStorageId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getPurchaseContractId() != null) {
				dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
				count++;
			}
			if(bean.getProductId() != null) {
				dao.setConditionProductId("=", bean.getProductId());
				count++;
			}
			if(bean.getStorageId() != null) {
				dao.setConditionStorageId("=", bean.getStorageId());
				count++;
			}
			if(bean.getInOutType() != null) {
				dao.setConditionInOutType("=", bean.getInOutType());
				count++;
			}
			if(bean.getOperateType() != null) {
				dao.setConditionOperateType("=", bean.getOperateType());
				count++;
			}
			if(bean.getProductNumber() != null) {
				dao.setConditionProductNumber("=", bean.getProductNumber());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getIsComplete() != null) {
				dao.setConditionIsComplete("=", bean.getIsComplete());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductStorage bean, ProductStorage dao){
		int count = 0;
		if(bean.getProductStorageId() != null) {
			dao.setConditionProductStorageId("=", bean.getProductStorageId());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getStorageId() != null) {
			dao.setConditionStorageId("=", bean.getStorageId());
			count++;
		}
		if(bean.getInOutType() != null) {
			dao.setConditionInOutType("=", bean.getInOutType());
			count++;
		}
		if(bean.getOperateType() != null) {
			dao.setConditionOperateType("=", bean.getOperateType());
			count++;
		}
		if(bean.getProductNumber() != null) {
			dao.setConditionProductNumber("=", bean.getProductNumber());
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
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
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
		BaseProductStorage bean = new BaseProductStorage();
		bean.setDataFromJSON(json);
		ProductStorage dao = new ProductStorage();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductStorage> rlist = new BaseCollection<>();
		BaseProductStorage bean = new BaseProductStorage();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductStorage dao = new ProductStorage();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductStorage> result = dao.conditionalLoad(addtion);
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
		BaseProductStorage bean = new BaseProductStorage();
		bean.setDataFromJSON(json);
		ProductStorage dao = new ProductStorage();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductStorage bean = new BaseProductStorage();
		bean.setDataFromJSON(json);
		ProductStorage dao = new ProductStorage();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductStorage bean = new BaseProductStorage();
		bean.setDataFromJSON(json);
		ProductStorage dao = new ProductStorage();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductStorage bean = new BaseProductStorage();
		bean.setDataFromJSON(json);
		ProductStorage dao = new ProductStorage();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


