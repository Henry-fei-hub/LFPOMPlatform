package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCarTypePrice;
import com.pomplatform.db.dao.CarTypePrice;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CarTypePriceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CarTypePriceHandler.class);

	public static BaseCarTypePrice getCarTypePriceById( 

	) throws Exception
	{
		CarTypePrice dao = new CarTypePrice();
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCarTypePriceExists( com.pomplatform.db.bean.BaseCarTypePrice bean, String additional ) throws Exception {

		CarTypePrice dao = new CarTypePrice();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCarTypePrice( com.pomplatform.db.bean.BaseCarTypePrice bean, String additional ) throws Exception {

		CarTypePrice dao = new CarTypePrice();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCarTypePrice> queryCarTypePrice( com.pomplatform.db.bean.BaseCarTypePrice bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CarTypePrice dao = new CarTypePrice();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCarTypePrice> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCarTypePrice> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCarTypePrice addToCarTypePrice ( BaseCarTypePrice cartypeprice )  throws Exception {
		return addToCarTypePrice ( cartypeprice , false);
	}

	public static BaseCarTypePrice addToCarTypePrice ( BaseCarTypePrice cartypeprice, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CarTypePrice dao = new CarTypePrice();
		dao.setDataFromBase(cartypeprice);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCarTypePrice addUpdateCarTypePrice ( BaseCarTypePrice cartypeprice ) throws Exception {
		return addUpdateCarTypePrice ( cartypeprice , false);
	}

	public static BaseCarTypePrice addUpdateCarTypePrice ( BaseCarTypePrice cartypeprice, boolean singleTransaction  ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CarTypePrice dao = new CarTypePrice();
		dao.setDataFromBase(cartypeprice);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cartypeprice); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCarTypePrice ( BaseCarTypePrice bean ) throws Exception {
		CarTypePrice dao = new CarTypePrice();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCarTypePrice updateCarTypePrice ( BaseCarTypePrice cartypeprice ) throws Exception {
		CarTypePrice dao = new CarTypePrice();
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cartypeprice);
			result = dao.update();
		}
		return result == 1 ? cartypeprice : null ;
	}

	public static BaseCarTypePrice updateCarTypePriceDirect( BaseCarTypePrice cartypeprice ) throws Exception {
		CarTypePrice dao = new CarTypePrice();
		int result = 0;
		dao.setDataFromBase(cartypeprice);
		result = dao.update();
		return result == 1 ? cartypeprice : null ;
	}

	public static int setDeleteConditions(BaseCarTypePrice bean, CarTypePrice dao){
		int count = 0;
		boolean foundKey = false;
		if(!foundKey) {
			if(bean.getCarTypePriceId() != null) {
				dao.setConditionCarTypePriceId("=", bean.getCarTypePriceId());
				count++;
			}
			if(bean.getFromArea() != null) {
				dao.setConditionFromArea("=", bean.getFromArea());
				count++;
			}
			if(bean.getToArea() != null) {
				dao.setConditionToArea("=", bean.getToArea());
				count++;
			}
			if(bean.getCarType() != null) {
				dao.setConditionCarType("=", bean.getCarType());
				count++;
			}
			if(bean.getUseCarPriceId() != null) {
				dao.setConditionUseCarPriceId("=", bean.getUseCarPriceId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCarTypePrice bean, CarTypePrice dao){
		int count = 0;
		if(bean.getCarTypePriceId() != null) {
			dao.setConditionCarTypePriceId("=", bean.getCarTypePriceId());
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
		if(bean.getCarType() != null) {
			dao.setConditionCarType("=", bean.getCarType());
			count++;
		}
		if(bean.getUseCarPriceId() != null) {
			dao.setConditionUseCarPriceId("=", bean.getUseCarPriceId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCarTypePrice bean = new BaseCarTypePrice();
		bean.setDataFromJSON(json);
		CarTypePrice dao = new CarTypePrice();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCarTypePrice> rlist = new BaseCollection<>();
		BaseCarTypePrice bean = new BaseCarTypePrice();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CarTypePrice dao = new CarTypePrice();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCarTypePrice> result = dao.conditionalLoad(addtion);
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
		BaseCarTypePrice bean = new BaseCarTypePrice();
		bean.setDataFromJSON(json);
		CarTypePrice dao = new CarTypePrice();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCarTypePrice bean = new BaseCarTypePrice();
		bean.setDataFromJSON(json);
		CarTypePrice dao = new CarTypePrice();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCarTypePrice bean = new BaseCarTypePrice();
		bean.setDataFromJSON(json);
		CarTypePrice dao = new CarTypePrice();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCarTypePrice bean = new BaseCarTypePrice();
		bean.setDataFromJSON(json);
		CarTypePrice dao = new CarTypePrice();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


