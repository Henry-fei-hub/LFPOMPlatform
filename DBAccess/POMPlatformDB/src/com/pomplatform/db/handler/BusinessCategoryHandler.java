package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBusinessCategory;
import com.pomplatform.db.dao.BusinessCategory;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class BusinessCategoryHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(BusinessCategoryHandler.class);

	public static BaseBusinessCategory getBusinessCategoryById( 
		java.lang.Integer business_category_id
	) throws Exception
	{
		BusinessCategory dao = new BusinessCategory();
		dao.setBusinessCategoryId(business_category_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isBusinessCategoryExists( com.pomplatform.db.bean.BaseBusinessCategory bean, String additional ) throws Exception {

		BusinessCategory dao = new BusinessCategory();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countBusinessCategory( com.pomplatform.db.bean.BaseBusinessCategory bean, String additional ) throws Exception {

		BusinessCategory dao = new BusinessCategory();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseBusinessCategory> queryBusinessCategory( com.pomplatform.db.bean.BaseBusinessCategory bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		BusinessCategory dao = new BusinessCategory();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseBusinessCategory> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseBusinessCategory> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseBusinessCategory addToBusinessCategory ( BaseBusinessCategory businesscategory )  throws Exception {
		return addToBusinessCategory ( businesscategory , false);
	}

	public static BaseBusinessCategory addToBusinessCategory ( BaseBusinessCategory businesscategory, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		BusinessCategory dao = new BusinessCategory();
		dao.setDataFromBase(businesscategory);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseBusinessCategory addUpdateBusinessCategory ( BaseBusinessCategory businesscategory ) throws Exception {
		return addUpdateBusinessCategory ( businesscategory , false);
	}

	public static BaseBusinessCategory addUpdateBusinessCategory ( BaseBusinessCategory businesscategory, boolean singleTransaction  ) throws Exception {
		if(businesscategory.getBusinessCategoryId() == null) return addToBusinessCategory(businesscategory);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		BusinessCategory dao = new BusinessCategory();
		dao.setDataFromBase(businesscategory);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(businesscategory); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteBusinessCategory ( BaseBusinessCategory bean ) throws Exception {
		BusinessCategory dao = new BusinessCategory();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseBusinessCategory updateBusinessCategory ( BaseBusinessCategory businesscategory ) throws Exception {
		BusinessCategory dao = new BusinessCategory();
		dao.setBusinessCategoryId( businesscategory.getBusinessCategoryId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(businesscategory);
			result = dao.update();
		}
		return result == 1 ? businesscategory : null ;
	}

	public static BaseBusinessCategory updateBusinessCategoryDirect( BaseBusinessCategory businesscategory ) throws Exception {
		BusinessCategory dao = new BusinessCategory();
		int result = 0;
		dao.setDataFromBase(businesscategory);
		result = dao.update();
		return result == 1 ? businesscategory : null ;
	}

	public static int setDeleteConditions(BaseBusinessCategory bean, BusinessCategory dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBusinessCategoryId() != null) {
			dao.setConditionBusinessCategoryId("=", bean.getBusinessCategoryId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessCategoryName() != null) {
				dao.setConditionBusinessCategoryName("=", bean.getBusinessCategoryName());
				count++;
			}
			if(bean.getBusinessCategoryCode() != null) {
				dao.setConditionBusinessCategoryCode("=", bean.getBusinessCategoryCode());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBusinessCategory bean, BusinessCategory dao){
		int count = 0;
		if(bean.getBusinessCategoryId() != null) {
			dao.setConditionBusinessCategoryId("=", bean.getBusinessCategoryId());
			count++;
		}
		if(bean.getBusinessCategoryName() != null) {
			if(bean.getBusinessCategoryName().indexOf("%") >= 0)
				dao.setConditionBusinessCategoryName("like", bean.getBusinessCategoryName());
			else
				dao.setConditionBusinessCategoryName("=", bean.getBusinessCategoryName());
			count++;
		}
		if(bean.getBusinessCategoryCode() != null) {
			if(bean.getBusinessCategoryCode().indexOf("%") >= 0)
				dao.setConditionBusinessCategoryCode("like", bean.getBusinessCategoryCode());
			else
				dao.setConditionBusinessCategoryCode("=", bean.getBusinessCategoryCode());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBusinessCategory bean = new BaseBusinessCategory();
		bean.setDataFromJSON(json);
		BusinessCategory dao = new BusinessCategory();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBusinessCategory> rlist = new BaseCollection<>();
		BaseBusinessCategory bean = new BaseBusinessCategory();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BusinessCategory dao = new BusinessCategory();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBusinessCategory> result = dao.conditionalLoad(addtion);
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
		BaseBusinessCategory bean = new BaseBusinessCategory();
		bean.setDataFromJSON(json);
		BusinessCategory dao = new BusinessCategory();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBusinessCategory bean = new BaseBusinessCategory();
		bean.setDataFromJSON(json);
		BusinessCategory dao = new BusinessCategory();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBusinessCategory bean = new BaseBusinessCategory();
		bean.setDataFromJSON(json);
		BusinessCategory dao = new BusinessCategory();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBusinessCategory bean = new BaseBusinessCategory();
		bean.setDataFromJSON(json);
		BusinessCategory dao = new BusinessCategory();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


