package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeCostAnalysy;
import com.pomplatform.db.dao.EmployeeCostAnalysy;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class EmployeeCostAnalysyHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(EmployeeCostAnalysyHandler.class);

	public static BaseEmployeeCostAnalysy getEmployeeCostAnalysyById( 
		java.lang.Integer employee_cost_analysis_id
	) throws Exception
	{
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setEmployeeCostAnalysisId(employee_cost_analysis_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isEmployeeCostAnalysyExists( com.pomplatform.db.bean.BaseEmployeeCostAnalysy bean, String additional ) throws Exception {

		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countEmployeeCostAnalysy( com.pomplatform.db.bean.BaseEmployeeCostAnalysy bean, String additional ) throws Exception {

		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseEmployeeCostAnalysy> queryEmployeeCostAnalysy( com.pomplatform.db.bean.BaseEmployeeCostAnalysy bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseEmployeeCostAnalysy> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseEmployeeCostAnalysy> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseEmployeeCostAnalysy addToEmployeeCostAnalysy ( BaseEmployeeCostAnalysy employeecostanalysy )  throws Exception {
		return addToEmployeeCostAnalysy ( employeecostanalysy , false);
	}

	public static BaseEmployeeCostAnalysy addToEmployeeCostAnalysy ( BaseEmployeeCostAnalysy employeecostanalysy, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setDataFromBase(employeecostanalysy);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseEmployeeCostAnalysy addUpdateEmployeeCostAnalysy ( BaseEmployeeCostAnalysy employeecostanalysy ) throws Exception {
		return addUpdateEmployeeCostAnalysy ( employeecostanalysy , false);
	}

	public static BaseEmployeeCostAnalysy addUpdateEmployeeCostAnalysy ( BaseEmployeeCostAnalysy employeecostanalysy, boolean singleTransaction  ) throws Exception {
		if(employeecostanalysy.getEmployeeCostAnalysisId() == null) return addToEmployeeCostAnalysy(employeecostanalysy);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setDataFromBase(employeecostanalysy);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(employeecostanalysy); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteEmployeeCostAnalysy ( BaseEmployeeCostAnalysy bean ) throws Exception {
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseEmployeeCostAnalysy updateEmployeeCostAnalysy ( BaseEmployeeCostAnalysy employeecostanalysy ) throws Exception {
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setEmployeeCostAnalysisId( employeecostanalysy.getEmployeeCostAnalysisId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(employeecostanalysy);
			result = dao.update();
		}
		return result == 1 ? employeecostanalysy : null ;
	}

	public static BaseEmployeeCostAnalysy updateEmployeeCostAnalysyDirect( BaseEmployeeCostAnalysy employeecostanalysy ) throws Exception {
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		int result = 0;
		dao.setDataFromBase(employeecostanalysy);
		result = dao.update();
		return result == 1 ? employeecostanalysy : null ;
	}

	public static int setDeleteConditions(BaseEmployeeCostAnalysy bean, EmployeeCostAnalysy dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getEmployeeCostAnalysisId() != null) {
			dao.setConditionEmployeeCostAnalysisId("=", bean.getEmployeeCostAnalysisId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
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
			if(bean.getPayRaise() != null) {
				dao.setConditionPayRaise("=", bean.getPayRaise());
				count++;
			}
			if(bean.getInsuranceRaise() != null) {
				dao.setConditionInsuranceRaise("=", bean.getInsuranceRaise());
				count++;
			}
			if(bean.getPayRemark() != null) {
				dao.setConditionPayRemark("=", bean.getPayRemark());
				count++;
			}
			if(bean.getInsuranceRemark() != null) {
				dao.setConditionInsuranceRemark("=", bean.getInsuranceRemark());
				count++;
			}
			if(bean.getIsLocked() != null) {
				dao.setConditionIsLocked("=", bean.getIsLocked());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseEmployeeCostAnalysy bean, EmployeeCostAnalysy dao){
		int count = 0;
		if(bean.getEmployeeCostAnalysisId() != null) {
			dao.setConditionEmployeeCostAnalysisId("=", bean.getEmployeeCostAnalysisId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
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
		if(bean.getThisMonthPay() != null) {
			dao.setConditionThisMonthPay("=", bean.getThisMonthPay());
			count++;
		}
		if(bean.getLastMonthPay() != null) {
			dao.setConditionLastMonthPay("=", bean.getLastMonthPay());
			count++;
		}
		if(bean.getPayRaise() != null) {
			if(bean.getPayRaise().indexOf("%") >= 0)
				dao.setConditionPayRaise("like", bean.getPayRaise());
			else
				dao.setConditionPayRaise("=", bean.getPayRaise());
			count++;
		}
		if(bean.getThisMonthInsurance() != null) {
			dao.setConditionThisMonthInsurance("=", bean.getThisMonthInsurance());
			count++;
		}
		if(bean.getLastMonthInsurance() != null) {
			dao.setConditionLastMonthInsurance("=", bean.getLastMonthInsurance());
			count++;
		}
		if(bean.getInsuranceRaise() != null) {
			if(bean.getInsuranceRaise().indexOf("%") >= 0)
				dao.setConditionInsuranceRaise("like", bean.getInsuranceRaise());
			else
				dao.setConditionInsuranceRaise("=", bean.getInsuranceRaise());
			count++;
		}
		if(bean.getPayRemark() != null) {
			if(bean.getPayRemark().indexOf("%") >= 0)
				dao.setConditionPayRemark("like", bean.getPayRemark());
			else
				dao.setConditionPayRemark("=", bean.getPayRemark());
			count++;
		}
		if(bean.getInsuranceRemark() != null) {
			if(bean.getInsuranceRemark().indexOf("%") >= 0)
				dao.setConditionInsuranceRemark("like", bean.getInsuranceRemark());
			else
				dao.setConditionInsuranceRemark("=", bean.getInsuranceRemark());
			count++;
		}
		if(bean.getIsLocked() != null) {
			dao.setConditionIsLocked("=", bean.getIsLocked());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		bean.setDataFromJSON(json);
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseEmployeeCostAnalysy> rlist = new BaseCollection<>();
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseEmployeeCostAnalysy> result = dao.conditionalLoad(addtion);
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
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		bean.setDataFromJSON(json);
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		bean.setDataFromJSON(json);
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		bean.setDataFromJSON(json);
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseEmployeeCostAnalysy bean = new BaseEmployeeCostAnalysy();
		bean.setDataFromJSON(json);
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


