package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductCategory;
import com.pomplatform.db.dao.ProductCategory;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductCategoryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductCategoryHandler.class);

	public static BaseProductCategory getProductCategoryById( 
		java.lang.Integer category_id
	) throws Exception
	{
		ProductCategory dao = new ProductCategory();
		dao.setCategoryId(category_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductCategoryExists( com.pomplatform.db.bean.BaseProductCategory bean, String additional ) throws Exception {

		ProductCategory dao = new ProductCategory();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductCategory( com.pomplatform.db.bean.BaseProductCategory bean, String additional ) throws Exception {

		ProductCategory dao = new ProductCategory();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductCategory> queryProductCategory( com.pomplatform.db.bean.BaseProductCategory bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductCategory dao = new ProductCategory();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductCategory> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductCategory> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductCategory addToProductCategory ( BaseProductCategory productcategory )  throws Exception {
		return addToProductCategory ( productcategory , false);
	}

	public static BaseProductCategory addToProductCategory ( BaseProductCategory productcategory, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductCategory dao = new ProductCategory();
		dao.setDataFromBase(productcategory);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductCategory addUpdateProductCategory ( BaseProductCategory productcategory ) throws Exception {
		return addUpdateProductCategory ( productcategory , false);
	}

	public static BaseProductCategory addUpdateProductCategory ( BaseProductCategory productcategory, boolean singleTransaction  ) throws Exception {
		if(productcategory.getCategoryId() == null) return addToProductCategory(productcategory);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductCategory dao = new ProductCategory();
		dao.setDataFromBase(productcategory);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productcategory); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductCategory ( BaseProductCategory bean ) throws Exception {
		ProductCategory dao = new ProductCategory();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductCategory updateProductCategory ( BaseProductCategory productcategory ) throws Exception {
		ProductCategory dao = new ProductCategory();
		dao.setCategoryId( productcategory.getCategoryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productcategory);
			result = dao.update();
		}
		return result == 1 ? productcategory : null ;
	}

	public static BaseProductCategory updateProductCategoryDirect( BaseProductCategory productcategory ) throws Exception {
		ProductCategory dao = new ProductCategory();
		int result = 0;
		dao.setDataFromBase(productcategory);
		result = dao.update();
		return result == 1 ? productcategory : null ;
	}

	public static int setDeleteConditions(BaseProductCategory bean, ProductCategory dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCategoryId() != null) {
			dao.setConditionCategoryId("=", bean.getCategoryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCategoryName() != null) {
				dao.setConditionCategoryName("=", bean.getCategoryName());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
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

	public static int setConditions(BaseProductCategory bean, ProductCategory dao){
		int count = 0;
		if(bean.getCategoryId() != null) {
			dao.setConditionCategoryId("=", bean.getCategoryId());
			count++;
		}
		if(bean.getCategoryName() != null) {
			if(bean.getCategoryName().indexOf("%") >= 0)
				dao.setConditionCategoryName("like", bean.getCategoryName());
			else
				dao.setConditionCategoryName("=", bean.getCategoryName());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
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
		BaseProductCategory bean = new BaseProductCategory();
		bean.setDataFromJSON(json);
		ProductCategory dao = new ProductCategory();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductCategory> rlist = new BaseCollection<>();
		BaseProductCategory bean = new BaseProductCategory();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductCategory dao = new ProductCategory();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductCategory> result = dao.conditionalLoad(addtion);
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
		BaseProductCategory bean = new BaseProductCategory();
		bean.setDataFromJSON(json);
		ProductCategory dao = new ProductCategory();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductCategory bean = new BaseProductCategory();
		bean.setDataFromJSON(json);
		ProductCategory dao = new ProductCategory();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductCategory bean = new BaseProductCategory();
		bean.setDataFromJSON(json);
		ProductCategory dao = new ProductCategory();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductCategory bean = new BaseProductCategory();
		bean.setDataFromJSON(json);
		ProductCategory dao = new ProductCategory();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


