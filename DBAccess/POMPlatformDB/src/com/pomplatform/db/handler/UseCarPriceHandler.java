package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseUseCarPrice;
import com.pomplatform.db.dao.UseCarPrice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class UseCarPriceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(UseCarPriceHandler.class);

	public static BaseUseCarPrice getUseCarPriceById( 
		java.lang.Integer use_car_price_id
	) throws Exception
	{
		UseCarPrice dao = new UseCarPrice();
		dao.setUseCarPriceId(use_car_price_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isUseCarPriceExists( com.pomplatform.db.bean.BaseUseCarPrice bean, String additional ) throws Exception {

		UseCarPrice dao = new UseCarPrice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countUseCarPrice( com.pomplatform.db.bean.BaseUseCarPrice bean, String additional ) throws Exception {

		UseCarPrice dao = new UseCarPrice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseUseCarPrice> queryUseCarPrice( com.pomplatform.db.bean.BaseUseCarPrice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		UseCarPrice dao = new UseCarPrice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseUseCarPrice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseUseCarPrice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseUseCarPrice addToUseCarPrice ( BaseUseCarPrice usecarprice )  throws Exception {
		return addToUseCarPrice ( usecarprice , false);
	}

	public static BaseUseCarPrice addToUseCarPrice ( BaseUseCarPrice usecarprice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		UseCarPrice dao = new UseCarPrice();
		dao.setDataFromBase(usecarprice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseUseCarPrice addUpdateUseCarPrice ( BaseUseCarPrice usecarprice ) throws Exception {
		return addUpdateUseCarPrice ( usecarprice , false);
	}

	public static BaseUseCarPrice addUpdateUseCarPrice ( BaseUseCarPrice usecarprice, boolean singleTransaction  ) throws Exception {
		if(usecarprice.getUseCarPriceId() == null) return addToUseCarPrice(usecarprice);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		UseCarPrice dao = new UseCarPrice();
		dao.setDataFromBase(usecarprice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(usecarprice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteUseCarPrice ( BaseUseCarPrice bean ) throws Exception {
		UseCarPrice dao = new UseCarPrice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseUseCarPrice updateUseCarPrice ( BaseUseCarPrice usecarprice ) throws Exception {
		UseCarPrice dao = new UseCarPrice();
		dao.setUseCarPriceId( usecarprice.getUseCarPriceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(usecarprice);
			result = dao.update();
		}
		return result == 1 ? usecarprice : null ;
	}

	public static BaseUseCarPrice updateUseCarPriceDirect( BaseUseCarPrice usecarprice ) throws Exception {
		UseCarPrice dao = new UseCarPrice();
		int result = 0;
		dao.setDataFromBase(usecarprice);
		result = dao.update();
		return result == 1 ? usecarprice : null ;
	}

	public static int setDeleteConditions(BaseUseCarPrice bean, UseCarPrice dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getUseCarPriceId() != null) {
			dao.setConditionUseCarPriceId("=", bean.getUseCarPriceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFromArea() != null) {
				dao.setConditionFromArea("=", bean.getFromArea());
				count++;
			}
			if(bean.getToArea() != null) {
				dao.setConditionToArea("=", bean.getToArea());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getCarType() != null) {
				dao.setConditionCarType("=", bean.getCarType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseUseCarPrice bean, UseCarPrice dao){
		int count = 0;
		if(bean.getUseCarPriceId() != null) {
			dao.setConditionUseCarPriceId("=", bean.getUseCarPriceId());
			count++;
		}
		if(bean.getFromArea() != null) {
			if(bean.getFromArea().indexOf("%") >= 0)
				dao.setConditionFromArea("like", bean.getFromArea());
			else
				dao.setConditionFromArea("=", bean.getFromArea());
			count++;
		}
		if(bean.getToArea() != null) {
			if(bean.getToArea().indexOf("%") >= 0)
				dao.setConditionToArea("like", bean.getToArea());
			else
				dao.setConditionToArea("=", bean.getToArea());
			count++;
		}
		if(bean.getPrice() != null) {
			dao.setConditionPrice("=", bean.getPrice());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getCarType() != null) {
			dao.setConditionCarType("=", bean.getCarType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseUseCarPrice bean = new BaseUseCarPrice();
		bean.setDataFromJSON(json);
		UseCarPrice dao = new UseCarPrice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseUseCarPrice> rlist = new BaseCollection<>();
		BaseUseCarPrice bean = new BaseUseCarPrice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		UseCarPrice dao = new UseCarPrice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseUseCarPrice> result = dao.conditionalLoad(addtion);
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
		BaseUseCarPrice bean = new BaseUseCarPrice();
		bean.setDataFromJSON(json);
		UseCarPrice dao = new UseCarPrice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseUseCarPrice bean = new BaseUseCarPrice();
		bean.setDataFromJSON(json);
		UseCarPrice dao = new UseCarPrice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseUseCarPrice bean = new BaseUseCarPrice();
		bean.setDataFromJSON(json);
		UseCarPrice dao = new UseCarPrice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseUseCarPrice bean = new BaseUseCarPrice();
		bean.setDataFromJSON(json);
		UseCarPrice dao = new UseCarPrice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


