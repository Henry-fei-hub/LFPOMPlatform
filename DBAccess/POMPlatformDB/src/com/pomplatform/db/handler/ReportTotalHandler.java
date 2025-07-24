package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseReportTotal;
import com.pomplatform.db.dao.ReportTotal;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class ReportTotalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReportTotalHandler.class);

	public static BaseReportTotal getReportTotalById( 
		java.lang.Integer report_total_id
	) throws Exception
	{
		ReportTotal dao = new ReportTotal();
		dao.setReportTotalId(report_total_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReportTotalExists( com.pomplatform.db.bean.BaseReportTotal bean, String additional ) throws Exception {

		ReportTotal dao = new ReportTotal();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReportTotal( com.pomplatform.db.bean.BaseReportTotal bean, String additional ) throws Exception {

		ReportTotal dao = new ReportTotal();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReportTotal> queryReportTotal( com.pomplatform.db.bean.BaseReportTotal bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReportTotal dao = new ReportTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReportTotal> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReportTotal> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReportTotal addToReportTotal ( BaseReportTotal reporttotal )  throws Exception {
		return addToReportTotal ( reporttotal , false);
	}

	public static BaseReportTotal addToReportTotal ( BaseReportTotal reporttotal, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReportTotal dao = new ReportTotal();
		dao.setDataFromBase(reporttotal);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReportTotal addUpdateReportTotal ( BaseReportTotal reporttotal ) throws Exception {
		return addUpdateReportTotal ( reporttotal , false);
	}

	public static BaseReportTotal addUpdateReportTotal ( BaseReportTotal reporttotal, boolean singleTransaction  ) throws Exception {
		if(reporttotal.getReportTotalId() == null) return addToReportTotal(reporttotal);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReportTotal dao = new ReportTotal();
		dao.setDataFromBase(reporttotal);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reporttotal); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReportTotal ( BaseReportTotal bean ) throws Exception {
		ReportTotal dao = new ReportTotal();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReportTotal updateReportTotal ( BaseReportTotal reporttotal ) throws Exception {
		ReportTotal dao = new ReportTotal();
		dao.setReportTotalId( reporttotal.getReportTotalId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reporttotal);
			result = dao.update();
		}
		return result == 1 ? reporttotal : null ;
	}

	public static BaseReportTotal updateReportTotalDirect( BaseReportTotal reporttotal ) throws Exception {
		ReportTotal dao = new ReportTotal();
		int result = 0;
		dao.setDataFromBase(reporttotal);
		result = dao.update();
		return result == 1 ? reporttotal : null ;
	}

	public static int setDeleteConditions(BaseReportTotal bean, ReportTotal dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReportTotalId() != null) {
			dao.setConditionReportTotalId("=", bean.getReportTotalId());
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
			if(bean.getMinEmpNum() != null) {
				dao.setConditionMinEmpNum("=", bean.getMinEmpNum());
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

	public static int setConditions(BaseReportTotal bean, ReportTotal dao){
		int count = 0;
		if(bean.getReportTotalId() != null) {
			dao.setConditionReportTotalId("=", bean.getReportTotalId());
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
		if(bean.getMonthRevenue() != null) {
			dao.setConditionMonthRevenue("=", bean.getMonthRevenue());
			count++;
		}
		if(bean.getTotalRevenue() != null) {
			dao.setConditionTotalRevenue("=", bean.getTotalRevenue());
			count++;
		}
		if(bean.getMonthCapitalPlate() != null) {
			dao.setConditionMonthCapitalPlate("=", bean.getMonthCapitalPlate());
			count++;
		}
		if(bean.getTotalCapitalPlate() != null) {
			dao.setConditionTotalCapitalPlate("=", bean.getTotalCapitalPlate());
			count++;
		}
		if(bean.getMonthCapitalProject() != null) {
			dao.setConditionMonthCapitalProject("=", bean.getMonthCapitalProject());
			count++;
		}
		if(bean.getTotalCapitalProject() != null) {
			dao.setConditionTotalCapitalProject("=", bean.getTotalCapitalProject());
			count++;
		}
		if(bean.getMonthSureIntegralPlate() != null) {
			dao.setConditionMonthSureIntegralPlate("=", bean.getMonthSureIntegralPlate());
			count++;
		}
		if(bean.getTotalSureIntegralPlate() != null) {
			dao.setConditionTotalSureIntegralPlate("=", bean.getTotalSureIntegralPlate());
			count++;
		}
		if(bean.getMonthSureIntegralProject() != null) {
			dao.setConditionMonthSureIntegralProject("=", bean.getMonthSureIntegralProject());
			count++;
		}
		if(bean.getTotalSureIntegralProject() != null) {
			dao.setConditionTotalSureIntegralProject("=", bean.getTotalSureIntegralProject());
			count++;
		}
		if(bean.getMonthSalary() != null) {
			dao.setConditionMonthSalary("=", bean.getMonthSalary());
			count++;
		}
		if(bean.getTotalSalary() != null) {
			dao.setConditionTotalSalary("=", bean.getTotalSalary());
			count++;
		}
		if(bean.getMonthCostPlate() != null) {
			dao.setConditionMonthCostPlate("=", bean.getMonthCostPlate());
			count++;
		}
		if(bean.getTotalCostPlate() != null) {
			dao.setConditionTotalCostPlate("=", bean.getTotalCostPlate());
			count++;
		}
		if(bean.getMonthCostProject() != null) {
			dao.setConditionMonthCostProject("=", bean.getMonthCostProject());
			count++;
		}
		if(bean.getTotalCostProject() != null) {
			dao.setConditionTotalCostProject("=", bean.getTotalCostProject());
			count++;
		}
		if(bean.getMonthCostProjectBefore() != null) {
			dao.setConditionMonthCostProjectBefore("=", bean.getMonthCostProjectBefore());
			count++;
		}
		if(bean.getTotalCostProjectBefore() != null) {
			dao.setConditionTotalCostProjectBefore("=", bean.getTotalCostProjectBefore());
			count++;
		}
		if(bean.getMonthNewContract() != null) {
			dao.setConditionMonthNewContract("=", bean.getMonthNewContract());
			count++;
		}
		if(bean.getTotalNewContract() != null) {
			dao.setConditionTotalNewContract("=", bean.getTotalNewContract());
			count++;
		}
		if(bean.getContractTotal() != null) {
			dao.setConditionContractTotal("=", bean.getContractTotal());
			count++;
		}
		if(bean.getAverageEmpNum() != null) {
			dao.setConditionAverageEmpNum("=", bean.getAverageEmpNum());
			count++;
		}
		if(bean.getMinEmpNum() != null) {
			dao.setConditionMinEmpNum("=", bean.getMinEmpNum());
			count++;
		}
		if(bean.getYearAverageEmpRevenue() != null) {
			dao.setConditionYearAverageEmpRevenue("=", bean.getYearAverageEmpRevenue());
			count++;
		}
		if(bean.getYearCapital() != null) {
			dao.setConditionYearCapital("=", bean.getYearCapital());
			count++;
		}
		if(bean.getBenefit() != null) {
			dao.setConditionBenefit("=", bean.getBenefit());
			count++;
		}
		if(bean.getYearRevenue() != null) {
			dao.setConditionYearRevenue("=", bean.getYearRevenue());
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
		BaseReportTotal bean = new BaseReportTotal();
		bean.setDataFromJSON(json);
		ReportTotal dao = new ReportTotal();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReportTotal> rlist = new BaseCollection<>();
		BaseReportTotal bean = new BaseReportTotal();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReportTotal dao = new ReportTotal();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReportTotal> result = dao.conditionalLoad(addtion);
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
		BaseReportTotal bean = new BaseReportTotal();
		bean.setDataFromJSON(json);
		ReportTotal dao = new ReportTotal();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReportTotal bean = new BaseReportTotal();
		bean.setDataFromJSON(json);
		ReportTotal dao = new ReportTotal();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReportTotal bean = new BaseReportTotal();
		bean.setDataFromJSON(json);
		ReportTotal dao = new ReportTotal();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReportTotal bean = new BaseReportTotal();
		bean.setDataFromJSON(json);
		ReportTotal dao = new ReportTotal();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


