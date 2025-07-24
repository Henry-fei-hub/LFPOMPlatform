package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePlateIncomeAndExpenditure;
import com.pomplatform.db.dao.PlateIncomeAndExpenditure;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class PlateIncomeAndExpenditureHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PlateIncomeAndExpenditureHandler.class);

	public static BasePlateIncomeAndExpenditure getPlateIncomeAndExpenditureById( 
		java.lang.Integer plate_income_and_expenditure_id
	) throws Exception
	{
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setPlateIncomeAndExpenditureId(plate_income_and_expenditure_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPlateIncomeAndExpenditureExists( com.pomplatform.db.bean.BasePlateIncomeAndExpenditure bean, String additional ) throws Exception {

		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPlateIncomeAndExpenditure( com.pomplatform.db.bean.BasePlateIncomeAndExpenditure bean, String additional ) throws Exception {

		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePlateIncomeAndExpenditure> queryPlateIncomeAndExpenditure( com.pomplatform.db.bean.BasePlateIncomeAndExpenditure bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePlateIncomeAndExpenditure> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePlateIncomeAndExpenditure> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePlateIncomeAndExpenditure addToPlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure plateincomeandexpenditure )  throws Exception {
		return addToPlateIncomeAndExpenditure ( plateincomeandexpenditure , false);
	}

	public static BasePlateIncomeAndExpenditure addToPlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure plateincomeandexpenditure, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setDataFromBase(plateincomeandexpenditure);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePlateIncomeAndExpenditure addUpdatePlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure plateincomeandexpenditure ) throws Exception {
		return addUpdatePlateIncomeAndExpenditure ( plateincomeandexpenditure , false);
	}

	public static BasePlateIncomeAndExpenditure addUpdatePlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure plateincomeandexpenditure, boolean singleTransaction  ) throws Exception {
		if(plateincomeandexpenditure.getPlateIncomeAndExpenditureId() == null) return addToPlateIncomeAndExpenditure(plateincomeandexpenditure);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setDataFromBase(plateincomeandexpenditure);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(plateincomeandexpenditure); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure bean ) throws Exception {
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePlateIncomeAndExpenditure updatePlateIncomeAndExpenditure ( BasePlateIncomeAndExpenditure plateincomeandexpenditure ) throws Exception {
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setPlateIncomeAndExpenditureId( plateincomeandexpenditure.getPlateIncomeAndExpenditureId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(plateincomeandexpenditure);
			result = dao.update();
		}
		return result == 1 ? plateincomeandexpenditure : null ;
	}

	public static BasePlateIncomeAndExpenditure updatePlateIncomeAndExpenditureDirect( BasePlateIncomeAndExpenditure plateincomeandexpenditure ) throws Exception {
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		int result = 0;
		dao.setDataFromBase(plateincomeandexpenditure);
		result = dao.update();
		return result == 1 ? plateincomeandexpenditure : null ;
	}

	public static int setDeleteConditions(BasePlateIncomeAndExpenditure bean, PlateIncomeAndExpenditure dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPlateIncomeAndExpenditureId() != null) {
			dao.setConditionPlateIncomeAndExpenditureId("=", bean.getPlateIncomeAndExpenditureId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getMonth() != null) {
				dao.setConditionMonth("=", bean.getMonth());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePlateIncomeAndExpenditure bean, PlateIncomeAndExpenditure dao){
		int count = 0;
		if(bean.getPlateIncomeAndExpenditureId() != null) {
			dao.setConditionPlateIncomeAndExpenditureId("=", bean.getPlateIncomeAndExpenditureId());
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
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getContractStock() != null) {
			dao.setConditionContractStock("=", bean.getContractStock());
			count++;
		}
		if(bean.getRevenue() != null) {
			dao.setConditionRevenue("=", bean.getRevenue());
			count++;
		}
		if(bean.getDepartmentConfirmationPoints() != null) {
			dao.setConditionDepartmentConfirmationPoints("=", bean.getDepartmentConfirmationPoints());
			count++;
		}
		if(bean.getEmployeeConfirmationPoints() != null) {
			dao.setConditionEmployeeConfirmationPoints("=", bean.getEmployeeConfirmationPoints());
			count++;
		}
		if(bean.getEmployeeCost() != null) {
			dao.setConditionEmployeeCost("=", bean.getEmployeeCost());
			count++;
		}
		if(bean.getProjectCost() != null) {
			dao.setConditionProjectCost("=", bean.getProjectCost());
			count++;
		}
		if(bean.getPlateCost() != null) {
			dao.setConditionPlateCost("=", bean.getPlateCost());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		bean.setDataFromJSON(json);
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePlateIncomeAndExpenditure> rlist = new BaseCollection<>();
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePlateIncomeAndExpenditure> result = dao.conditionalLoad(addtion);
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
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		bean.setDataFromJSON(json);
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		bean.setDataFromJSON(json);
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		bean.setDataFromJSON(json);
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
		bean.setDataFromJSON(json);
		PlateIncomeAndExpenditure dao = new PlateIncomeAndExpenditure();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


