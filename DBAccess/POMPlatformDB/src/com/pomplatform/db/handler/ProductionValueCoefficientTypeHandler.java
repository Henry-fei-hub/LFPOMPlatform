package com.pomplatform.db.handler;

import delicacy.json.BasicHandler;
import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProductionValueCoefficientType;
import java.util.List;
import com.pomplatform.db.dao.ProductionValueCoefficientType;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProductionValueCoefficientTypeHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProductionValueCoefficientTypeHandler.class);

	public static BaseProductionValueCoefficientType getProductionValueCoefficientTypeById( 
		java.lang.Integer production_value_coefficient_type_id
	) throws Exception
	{
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setProductionValueCoefficientTypeId(production_value_coefficient_type_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProductionValueCoefficientTypeExists( com.pomplatform.db.bean.BaseProductionValueCoefficientType bean, String additional ) throws Exception {

		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProductionValueCoefficientType( com.pomplatform.db.bean.BaseProductionValueCoefficientType bean, String additional ) throws Exception {

		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProductionValueCoefficientType> queryProductionValueCoefficientType( com.pomplatform.db.bean.BaseProductionValueCoefficientType bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseProductionValueCoefficientType> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProductionValueCoefficientType> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProductionValueCoefficientType addToProductionValueCoefficientType ( BaseProductionValueCoefficientType productionvaluecoefficienttype )  throws Exception {
		return addToProductionValueCoefficientType ( productionvaluecoefficienttype , false);
	}

	public static BaseProductionValueCoefficientType addToProductionValueCoefficientType ( BaseProductionValueCoefficientType productionvaluecoefficienttype, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setDataFromBase(productionvaluecoefficienttype);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProductionValueCoefficientType addUpdateProductionValueCoefficientType ( BaseProductionValueCoefficientType productionvaluecoefficienttype ) throws Exception {
		return addUpdateProductionValueCoefficientType ( productionvaluecoefficienttype , false);
	}

	public static BaseProductionValueCoefficientType addUpdateProductionValueCoefficientType ( BaseProductionValueCoefficientType productionvaluecoefficienttype, boolean singleTransaction  ) throws Exception {
		if(productionvaluecoefficienttype.getProductionValueCoefficientTypeId() == null) return addToProductionValueCoefficientType(productionvaluecoefficienttype);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setDataFromBase(productionvaluecoefficienttype);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(productionvaluecoefficienttype); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProductionValueCoefficientType ( BaseProductionValueCoefficientType bean ) throws Exception {
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProductionValueCoefficientType updateProductionValueCoefficientType ( BaseProductionValueCoefficientType productionvaluecoefficienttype ) throws Exception {
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setProductionValueCoefficientTypeId( productionvaluecoefficienttype.getProductionValueCoefficientTypeId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(productionvaluecoefficienttype);
			result = dao.update();
		}
		return result == 1 ? productionvaluecoefficienttype : null ;
	}

	public static BaseProductionValueCoefficientType updateProductionValueCoefficientTypeDirect( BaseProductionValueCoefficientType productionvaluecoefficienttype ) throws Exception {
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		int result = 0;
		dao.setDataFromBase(productionvaluecoefficienttype);
		result = dao.update();
		return result == 1 ? productionvaluecoefficienttype : null ;
	}

	public static int setDeleteConditions(BaseProductionValueCoefficientType bean, ProductionValueCoefficientType dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductionValueCoefficientTypeId() != null) {
			dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCoefficientType() != null) {
				dao.setConditionCoefficientType("=", bean.getCoefficientType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductionValueCoefficientType bean, ProductionValueCoefficientType dao){
		int count = 0;
		if(bean.getProductionValueCoefficientTypeId() != null) {
			dao.setConditionProductionValueCoefficientTypeId("=", bean.getProductionValueCoefficientTypeId());
			count++;
		}
		if(bean.getCoefficientType() != null) {
			if(bean.getCoefficientType().indexOf("%") >= 0)
				dao.setConditionCoefficientType("like", bean.getCoefficientType());
			else
				dao.setConditionCoefficientType("=", bean.getCoefficientType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		bean.setDataFromJSON(json);
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductionValueCoefficientType> rlist = new BaseCollection<>();
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(String.valueOf(new BasicHandler()));
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductionValueCoefficientType> result = dao.conditionalLoad(addtion);
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
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		bean.setDataFromJSON(json);
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		bean.setDataFromJSON(json);
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		bean.setDataFromJSON(json);
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductionValueCoefficientType bean = new BaseProductionValueCoefficientType();
		bean.setDataFromJSON(json);
		ProductionValueCoefficientType dao = new ProductionValueCoefficientType();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


