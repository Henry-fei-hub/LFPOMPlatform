package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseProductAttribute;
import com.pomplatform.db.dao.ProductAttribute;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ProductAttributeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductAttributeHandler.class);

	public static BaseProductAttribute getProductAttributeById( 
		java.lang.Integer product_attribute_id
	) throws Exception
	{
		ProductAttribute dao = new ProductAttribute();
		dao.setProductAttributeId(product_attribute_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductAttributeExists( com.pomplatform.db.bean.BaseProductAttribute bean, String additional ) throws Exception {

		ProductAttribute dao = new ProductAttribute();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductAttribute( com.pomplatform.db.bean.BaseProductAttribute bean, String additional ) throws Exception {

		ProductAttribute dao = new ProductAttribute();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductAttribute> queryProductAttribute( com.pomplatform.db.bean.BaseProductAttribute bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductAttribute dao = new ProductAttribute();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductAttribute> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductAttribute> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductAttribute addToProductAttribute ( BaseProductAttribute productattribute )  throws Exception {
		return addToProductAttribute ( productattribute , false);
	}

	public static BaseProductAttribute addToProductAttribute ( BaseProductAttribute productattribute, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductAttribute dao = new ProductAttribute();
		dao.setDataFromBase(productattribute);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductAttribute addUpdateProductAttribute ( BaseProductAttribute productattribute ) throws Exception {
		return addUpdateProductAttribute ( productattribute , false);
	}

	public static BaseProductAttribute addUpdateProductAttribute ( BaseProductAttribute productattribute, boolean singleTransaction  ) throws Exception {
		if(productattribute.getProductAttributeId() == null) return addToProductAttribute(productattribute);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductAttribute dao = new ProductAttribute();
		dao.setDataFromBase(productattribute);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productattribute); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductAttribute ( BaseProductAttribute bean ) throws Exception {
		ProductAttribute dao = new ProductAttribute();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductAttribute updateProductAttribute ( BaseProductAttribute productattribute ) throws Exception {
		ProductAttribute dao = new ProductAttribute();
		dao.setProductAttributeId( productattribute.getProductAttributeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productattribute);
			result = dao.update();
		}
		return result == 1 ? productattribute : null ;
	}

	public static BaseProductAttribute updateProductAttributeDirect( BaseProductAttribute productattribute ) throws Exception {
		ProductAttribute dao = new ProductAttribute();
		int result = 0;
		dao.setDataFromBase(productattribute);
		result = dao.update();
		return result == 1 ? productattribute : null ;
	}

	public static int setDeleteConditions(BaseProductAttribute bean, ProductAttribute dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductAttributeId() != null) {
			dao.setConditionProductAttributeId("=", bean.getProductAttributeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProductId() != null) {
				dao.setConditionProductId("=", bean.getProductId());
				count++;
			}
			if(bean.getAttributeType() != null) {
				dao.setConditionAttributeType("=", bean.getAttributeType());
				count++;
			}
			if(bean.getAttributeName() != null) {
				dao.setConditionAttributeName("=", bean.getAttributeName());
				count++;
			}
			if(bean.getAttributeValue() != null) {
				dao.setConditionAttributeValue("=", bean.getAttributeValue());
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

	public static int setConditions(BaseProductAttribute bean, ProductAttribute dao){
		int count = 0;
		if(bean.getProductAttributeId() != null) {
			dao.setConditionProductAttributeId("=", bean.getProductAttributeId());
			count++;
		}
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getAttributeType() != null) {
			dao.setConditionAttributeType("=", bean.getAttributeType());
			count++;
		}
		if(bean.getAttributeName() != null) {
			if(bean.getAttributeName().indexOf("%") >= 0)
				dao.setConditionAttributeName("like", bean.getAttributeName());
			else
				dao.setConditionAttributeName("=", bean.getAttributeName());
			count++;
		}
		if(bean.getAttributeValue() != null) {
			if(bean.getAttributeValue().indexOf("%") >= 0)
				dao.setConditionAttributeValue("like", bean.getAttributeValue());
			else
				dao.setConditionAttributeValue("=", bean.getAttributeValue());
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
		BaseProductAttribute bean = new BaseProductAttribute();
		bean.setDataFromJSON(json);
		ProductAttribute dao = new ProductAttribute();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductAttribute> rlist = new BaseCollection<>();
		BaseProductAttribute bean = new BaseProductAttribute();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductAttribute dao = new ProductAttribute();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductAttribute> result = dao.conditionalLoad(addtion);
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
		BaseProductAttribute bean = new BaseProductAttribute();
		bean.setDataFromJSON(json);
		ProductAttribute dao = new ProductAttribute();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductAttribute bean = new BaseProductAttribute();
		bean.setDataFromJSON(json);
		ProductAttribute dao = new ProductAttribute();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductAttribute bean = new BaseProductAttribute();
		bean.setDataFromJSON(json);
		ProductAttribute dao = new ProductAttribute();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductAttribute bean = new BaseProductAttribute();
		bean.setDataFromJSON(json);
		ProductAttribute dao = new ProductAttribute();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


