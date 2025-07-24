package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProduct;
import com.pomplatform.db.dao.Product;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductHandler.class);

	public static BaseProduct getProductById( 
		java.lang.Integer product_id
	) throws Exception
	{
		Product dao = new Product();
		dao.setProductId(product_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductExists( com.pomplatform.db.bean.BaseProduct bean, String additional ) throws Exception {

		Product dao = new Product();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProduct( com.pomplatform.db.bean.BaseProduct bean, String additional ) throws Exception {

		Product dao = new Product();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProduct> queryProduct( com.pomplatform.db.bean.BaseProduct bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Product dao = new Product();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProduct> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProduct> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProduct addToProduct ( BaseProduct product )  throws Exception {
		return addToProduct ( product , false);
	}

	public static BaseProduct addToProduct ( BaseProduct product, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Product dao = new Product();
		dao.setDataFromBase(product);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProduct addUpdateProduct ( BaseProduct product ) throws Exception {
		return addUpdateProduct ( product , false);
	}

	public static BaseProduct addUpdateProduct ( BaseProduct product, boolean singleTransaction  ) throws Exception {
		if(product.getProductId() == null) return addToProduct(product);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Product dao = new Product();
		dao.setDataFromBase(product);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(product); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProduct ( BaseProduct bean ) throws Exception {
		Product dao = new Product();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProduct updateProduct ( BaseProduct product ) throws Exception {
		Product dao = new Product();
		dao.setProductId( product.getProductId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(product);
			result = dao.update();
		}
		return result == 1 ? product : null ;
	}

	public static BaseProduct updateProductDirect( BaseProduct product ) throws Exception {
		Product dao = new Product();
		int result = 0;
		dao.setDataFromBase(product);
		result = dao.update();
		return result == 1 ? product : null ;
	}

	public static int setDeleteConditions(BaseProduct bean, Product dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCategoryId() != null) {
				dao.setConditionCategoryId("=", bean.getCategoryId());
				count++;
			}
			if(bean.getProductName() != null) {
				dao.setConditionProductName("=", bean.getProductName());
				count++;
			}
			if(bean.getProductType() != null) {
				dao.setConditionProductType("=", bean.getProductType());
				count++;
			}
			if(bean.getProductModel() != null) {
				dao.setConditionProductModel("=", bean.getProductModel());
				count++;
			}
			if(bean.getProductUnit() != null) {
				dao.setConditionProductUnit("=", bean.getProductUnit());
				count++;
			}
			if(bean.getProductSpecification() != null) {
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
				count++;
			}
			if(bean.getProductSkinsSize() != null) {
				dao.setConditionProductSkinsSize("=", bean.getProductSkinsSize());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProduct bean, Product dao){
		int count = 0;
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getCategoryId() != null) {
			dao.setConditionCategoryId("=", bean.getCategoryId());
			count++;
		}
		if(bean.getProductName() != null) {
			if(bean.getProductName().indexOf("%") >= 0)
				dao.setConditionProductName("like", bean.getProductName());
			else
				dao.setConditionProductName("=", bean.getProductName());
			count++;
		}
		if(bean.getProductType() != null) {
			dao.setConditionProductType("=", bean.getProductType());
			count++;
		}
		if(bean.getProductModel() != null) {
			if(bean.getProductModel().indexOf("%") >= 0)
				dao.setConditionProductModel("like", bean.getProductModel());
			else
				dao.setConditionProductModel("=", bean.getProductModel());
			count++;
		}
		if(bean.getProductUnit() != null) {
			if(bean.getProductUnit().indexOf("%") >= 0)
				dao.setConditionProductUnit("like", bean.getProductUnit());
			else
				dao.setConditionProductUnit("=", bean.getProductUnit());
			count++;
		}
		if(bean.getProductSpecification() != null) {
			if(bean.getProductSpecification().indexOf("%") >= 0)
				dao.setConditionProductSpecification("like", bean.getProductSpecification());
			else
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
			count++;
		}
		if(bean.getProductSkinsSize() != null) {
			if(bean.getProductSkinsSize().indexOf("%") >= 0)
				dao.setConditionProductSkinsSize("like", bean.getProductSkinsSize());
			else
				dao.setConditionProductSkinsSize("=", bean.getProductSkinsSize());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
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
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
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
		BaseProduct bean = new BaseProduct();
		bean.setDataFromJSON(json);
		Product dao = new Product();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProduct> rlist = new BaseCollection<>();
		BaseProduct bean = new BaseProduct();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Product dao = new Product();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProduct> result = dao.conditionalLoad(addtion);
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
		BaseProduct bean = new BaseProduct();
		bean.setDataFromJSON(json);
		Product dao = new Product();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProduct bean = new BaseProduct();
		bean.setDataFromJSON(json);
		Product dao = new Product();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProduct bean = new BaseProduct();
		bean.setDataFromJSON(json);
		Product dao = new Product();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProduct bean = new BaseProduct();
		bean.setDataFromJSON(json);
		Product dao = new Product();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


