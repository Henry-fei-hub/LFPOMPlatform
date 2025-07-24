package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryOfWorkYear;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryOfWorkYearHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryOfWorkYearHandler.class);

	public static BaseSalaryOfWorkYear getSalaryOfWorkYearById( 
		java.lang.Integer salary_of_work_year_id
	) throws Exception
	{
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setSalaryOfWorkYearId(salary_of_work_year_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryOfWorkYearExists( com.pomplatform.db.bean.BaseSalaryOfWorkYear bean, String additional ) throws Exception {

		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryOfWorkYear( com.pomplatform.db.bean.BaseSalaryOfWorkYear bean, String additional ) throws Exception {

		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryOfWorkYear> querySalaryOfWorkYear( com.pomplatform.db.bean.BaseSalaryOfWorkYear bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryOfWorkYear> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryOfWorkYear> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryOfWorkYear addToSalaryOfWorkYear ( BaseSalaryOfWorkYear salaryofworkyear )  throws Exception {
		return addToSalaryOfWorkYear ( salaryofworkyear , false);
	}

	public static BaseSalaryOfWorkYear addToSalaryOfWorkYear ( BaseSalaryOfWorkYear salaryofworkyear, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setDataFromBase(salaryofworkyear);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryOfWorkYear addUpdateSalaryOfWorkYear ( BaseSalaryOfWorkYear salaryofworkyear ) throws Exception {
		return addUpdateSalaryOfWorkYear ( salaryofworkyear , false);
	}

	public static BaseSalaryOfWorkYear addUpdateSalaryOfWorkYear ( BaseSalaryOfWorkYear salaryofworkyear, boolean singleTransaction  ) throws Exception {
		if(salaryofworkyear.getSalaryOfWorkYearId() == null) return addToSalaryOfWorkYear(salaryofworkyear);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setDataFromBase(salaryofworkyear);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryofworkyear); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryOfWorkYear ( BaseSalaryOfWorkYear bean ) throws Exception {
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryOfWorkYear updateSalaryOfWorkYear ( BaseSalaryOfWorkYear salaryofworkyear ) throws Exception {
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setSalaryOfWorkYearId( salaryofworkyear.getSalaryOfWorkYearId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryofworkyear);
			result = dao.update();
		}
		return result == 1 ? salaryofworkyear : null ;
	}

	public static BaseSalaryOfWorkYear updateSalaryOfWorkYearDirect( BaseSalaryOfWorkYear salaryofworkyear ) throws Exception {
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		int result = 0;
		dao.setDataFromBase(salaryofworkyear);
		result = dao.update();
		return result == 1 ? salaryofworkyear : null ;
	}

	public static int setDeleteConditions(BaseSalaryOfWorkYear bean, SalaryOfWorkYear dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryOfWorkYearId() != null) {
			dao.setConditionSalaryOfWorkYearId("=", bean.getSalaryOfWorkYearId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getWorkYears() != null) {
				dao.setConditionWorkYears("=", bean.getWorkYears());
				count++;
			}
			if(bean.getWorkMoney() != null) {
				dao.setConditionWorkMoney("=", bean.getWorkMoney());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryOfWorkYear bean, SalaryOfWorkYear dao){
		int count = 0;
		if(bean.getSalaryOfWorkYearId() != null) {
			dao.setConditionSalaryOfWorkYearId("=", bean.getSalaryOfWorkYearId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getYear() != null) {
			dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getMonth() != null) {
			dao.setConditionMonth("=", bean.getMonth());
			count++;
		}
		if(bean.getWorkYears() != null) {
			if(bean.getWorkYears().indexOf("%") >= 0)
				dao.setConditionWorkYears("like", bean.getWorkYears());
			else
				dao.setConditionWorkYears("=", bean.getWorkYears());
			count++;
		}
		if(bean.getWorkMoney() != null) {
			if(bean.getWorkMoney().indexOf("%") >= 0)
				dao.setConditionWorkMoney("like", bean.getWorkMoney());
			else
				dao.setConditionWorkMoney("=", bean.getWorkMoney());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		bean.setDataFromJSON(json);
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryOfWorkYear> rlist = new BaseCollection<>();
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryOfWorkYear> result = dao.conditionalLoad(addtion);
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
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		bean.setDataFromJSON(json);
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}
	
	@Override
	public String update(String json) throws Exception{
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		bean.setDataFromJSON(json);
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		bean.setDataFromJSON(json);
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		bean.setDataFromJSON(json);
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}
	

}


