package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCashierCompany;
import com.pomplatform.db.dao.CashierCompany;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CashierCompanyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CashierCompanyHandler.class);

	public static BaseCashierCompany getCashierCompanyById( 
		java.lang.Integer cashier_company_id
	) throws Exception
	{
		CashierCompany dao = new CashierCompany();
		dao.setCashierCompanyId(cashier_company_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCashierCompanyExists( com.pomplatform.db.bean.BaseCashierCompany bean, String additional ) throws Exception {

		CashierCompany dao = new CashierCompany();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCashierCompany( com.pomplatform.db.bean.BaseCashierCompany bean, String additional ) throws Exception {

		CashierCompany dao = new CashierCompany();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCashierCompany> queryCashierCompany( com.pomplatform.db.bean.BaseCashierCompany bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CashierCompany dao = new CashierCompany();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCashierCompany> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCashierCompany> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCashierCompany addToCashierCompany ( BaseCashierCompany cashiercompany )  throws Exception {
		return addToCashierCompany ( cashiercompany , false);
	}

	public static BaseCashierCompany addToCashierCompany ( BaseCashierCompany cashiercompany, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CashierCompany dao = new CashierCompany();
		dao.setDataFromBase(cashiercompany);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCashierCompany addUpdateCashierCompany ( BaseCashierCompany cashiercompany ) throws Exception {
		return addUpdateCashierCompany ( cashiercompany , false);
	}

	public static BaseCashierCompany addUpdateCashierCompany ( BaseCashierCompany cashiercompany, boolean singleTransaction  ) throws Exception {
		if(cashiercompany.getCashierCompanyId() == null) return addToCashierCompany(cashiercompany);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CashierCompany dao = new CashierCompany();
		dao.setDataFromBase(cashiercompany);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cashiercompany); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCashierCompany ( BaseCashierCompany bean ) throws Exception {
		CashierCompany dao = new CashierCompany();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCashierCompany updateCashierCompany ( BaseCashierCompany cashiercompany ) throws Exception {
		CashierCompany dao = new CashierCompany();
		dao.setCashierCompanyId( cashiercompany.getCashierCompanyId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cashiercompany);
			result = dao.update();
		}
		return result == 1 ? cashiercompany : null ;
	}

	public static BaseCashierCompany updateCashierCompanyDirect( BaseCashierCompany cashiercompany ) throws Exception {
		CashierCompany dao = new CashierCompany();
		int result = 0;
		dao.setDataFromBase(cashiercompany);
		result = dao.update();
		return result == 1 ? cashiercompany : null ;
	}

	public static int setDeleteConditions(BaseCashierCompany bean, CashierCompany dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCashierCompanyId() != null) {
			dao.setConditionCashierCompanyId("=", bean.getCashierCompanyId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCashierCompany bean, CashierCompany dao){
		int count = 0;
		if(bean.getCashierCompanyId() != null) {
			dao.setConditionCashierCompanyId("=", bean.getCashierCompanyId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
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
		BaseCashierCompany bean = new BaseCashierCompany();
		bean.setDataFromJSON(json);
		CashierCompany dao = new CashierCompany();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCashierCompany> rlist = new BaseCollection<>();
		BaseCashierCompany bean = new BaseCashierCompany();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CashierCompany dao = new CashierCompany();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCashierCompany> result = dao.conditionalLoad(addtion);
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
		BaseCashierCompany bean = new BaseCashierCompany();
		bean.setDataFromJSON(json);
		CashierCompany dao = new CashierCompany();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCashierCompany bean = new BaseCashierCompany();
		bean.setDataFromJSON(json);
		CashierCompany dao = new CashierCompany();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCashierCompany bean = new BaseCashierCompany();
		bean.setDataFromJSON(json);
		CashierCompany dao = new CashierCompany();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCashierCompany bean = new BaseCashierCompany();
		bean.setDataFromJSON(json);
		CashierCompany dao = new CashierCompany();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


