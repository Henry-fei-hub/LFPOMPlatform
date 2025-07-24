package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryOfBonus;
import com.pomplatform.db.dao.SalaryOfBonus;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SalaryOfBonusHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SalaryOfBonusHandler.class);

	public static BaseSalaryOfBonus getSalaryOfBonusById( 
		java.lang.Integer salary_of_bonus_id
	) throws Exception
	{
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setSalaryOfBonusId(salary_of_bonus_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSalaryOfBonusExists( com.pomplatform.db.bean.BaseSalaryOfBonus bean, String additional ) throws Exception {

		SalaryOfBonus dao = new SalaryOfBonus();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSalaryOfBonus( com.pomplatform.db.bean.BaseSalaryOfBonus bean, String additional ) throws Exception {

		SalaryOfBonus dao = new SalaryOfBonus();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSalaryOfBonus> querySalaryOfBonus( com.pomplatform.db.bean.BaseSalaryOfBonus bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SalaryOfBonus dao = new SalaryOfBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSalaryOfBonus> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSalaryOfBonus> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSalaryOfBonus addToSalaryOfBonus ( BaseSalaryOfBonus salaryofbonus )  throws Exception {
		return addToSalaryOfBonus ( salaryofbonus , false);
	}

	public static BaseSalaryOfBonus addToSalaryOfBonus ( BaseSalaryOfBonus salaryofbonus, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setDataFromBase(salaryofbonus);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSalaryOfBonus addUpdateSalaryOfBonus ( BaseSalaryOfBonus salaryofbonus ) throws Exception {
		return addUpdateSalaryOfBonus ( salaryofbonus , false);
	}

	public static BaseSalaryOfBonus addUpdateSalaryOfBonus ( BaseSalaryOfBonus salaryofbonus, boolean singleTransaction  ) throws Exception {
		if(salaryofbonus.getSalaryOfBonusId() == null) return addToSalaryOfBonus(salaryofbonus);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setDataFromBase(salaryofbonus);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(salaryofbonus); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSalaryOfBonus ( BaseSalaryOfBonus bean ) throws Exception {
		SalaryOfBonus dao = new SalaryOfBonus();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSalaryOfBonus updateSalaryOfBonus ( BaseSalaryOfBonus salaryofbonus ) throws Exception {
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setSalaryOfBonusId( salaryofbonus.getSalaryOfBonusId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(salaryofbonus);
			result = dao.update();
		}
		return result == 1 ? salaryofbonus : null ;
	}

	public static BaseSalaryOfBonus updateSalaryOfBonusDirect( BaseSalaryOfBonus salaryofbonus ) throws Exception {
		SalaryOfBonus dao = new SalaryOfBonus();
		int result = 0;
		dao.setDataFromBase(salaryofbonus);
		result = dao.update();
		return result == 1 ? salaryofbonus : null ;
	}

	public static int setDeleteConditions(BaseSalaryOfBonus bean, SalaryOfBonus dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSalaryOfBonusId() != null) {
			dao.setConditionSalaryOfBonusId("=", bean.getSalaryOfBonusId());
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
			if(bean.getShouldBonus() != null) {
				dao.setConditionShouldBonus("=", bean.getShouldBonus());
				count++;
			}
			if(bean.getShouldTax() != null) {
				dao.setConditionShouldTax("=", bean.getShouldTax());
				count++;
			}
			if(bean.getFactBonus() != null) {
				dao.setConditionFactBonus("=", bean.getFactBonus());
				count++;
			}
			if(bean.getOtherBonus() != null) {
				dao.setConditionOtherBonus("=", bean.getOtherBonus());
				count++;
			}
			if(bean.getIsSended() != null) {
				dao.setConditionIsSended("=", bean.getIsSended());
				count++;
			}
			if(bean.getFlag() != null) {
				dao.setConditionFlag("=", bean.getFlag());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
			if(bean.getFlowStatus() != null) {
				dao.setConditionFlowStatus("=", bean.getFlowStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSalaryOfBonus bean, SalaryOfBonus dao){
		int count = 0;
		if(bean.getSalaryOfBonusId() != null) {
			dao.setConditionSalaryOfBonusId("=", bean.getSalaryOfBonusId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getRecordDate() != null) {
			dao.setConditionRecordDate(">=", bean.getRecordDate());
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
		if(bean.getShouldBonus() != null) {
			if(bean.getShouldBonus().indexOf("%") >= 0)
				dao.setConditionShouldBonus("like", bean.getShouldBonus());
			else
				dao.setConditionShouldBonus("=", bean.getShouldBonus());
			count++;
		}
		if(bean.getShouldTax() != null) {
			if(bean.getShouldTax().indexOf("%") >= 0)
				dao.setConditionShouldTax("like", bean.getShouldTax());
			else
				dao.setConditionShouldTax("=", bean.getShouldTax());
			count++;
		}
		if(bean.getFactBonus() != null) {
			if(bean.getFactBonus().indexOf("%") >= 0)
				dao.setConditionFactBonus("like", bean.getFactBonus());
			else
				dao.setConditionFactBonus("=", bean.getFactBonus());
			count++;
		}
		if(bean.getOtherBonus() != null) {
			if(bean.getOtherBonus().indexOf("%") >= 0)
				dao.setConditionOtherBonus("like", bean.getOtherBonus());
			else
				dao.setConditionOtherBonus("=", bean.getOtherBonus());
			count++;
		}
		if(bean.getIsSended() != null) {
			dao.setConditionIsSended("=", bean.getIsSended());
			count++;
		}
		if(bean.getFlag() != null) {
			dao.setConditionFlag("=", bean.getFlag());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getSendTime() != null) {
			dao.setConditionSendTime(">=", bean.getSendTime());
			count++;
		}
		if(bean.getEndTime() != null) {
			dao.setConditionEndTime(">=", bean.getEndTime());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			count++;
		}
		if(bean.getFlowStatus() != null) {
			dao.setConditionFlowStatus("=", bean.getFlowStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		bean.setDataFromJSON(json);
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSalaryOfBonus> rlist = new BaseCollection<>();
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SalaryOfBonus dao = new SalaryOfBonus();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSalaryOfBonus> result = dao.conditionalLoad(addtion);
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
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		bean.setDataFromJSON(json);
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		bean.setDataFromJSON(json);
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		bean.setDataFromJSON(json);
		SalaryOfBonus dao = new SalaryOfBonus();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSalaryOfBonus bean = new BaseSalaryOfBonus();
		bean.setDataFromJSON(json);
		SalaryOfBonus dao = new SalaryOfBonus();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


