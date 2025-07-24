package pomplatform.report.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseEmployeeCostAnalysy;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseReportTotal;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.EmployeeCostAnalysy;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.ReportTotal;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.payment.bean.BaseOnLoadContractSaveAmount;
import pomplatform.payment.bean.ConditionOnLoadContractSaveAmount;
import pomplatform.payment.query.QueryOnLoadContractSaveAmount;
import pomplatform.report.bean.BaseReportCapitalTotal;
import pomplatform.report.bean.BaseReportCostTotal;
import pomplatform.report.bean.BaseReportEmployeeWorkYears;
import pomplatform.report.bean.BaseReportEmployeeWorkYearsByDepartment;
import pomplatform.report.bean.BaseReportNewContractTotal;
import pomplatform.report.bean.BaseReportOfGenderPlateMonth;
import pomplatform.report.bean.BaseReportOfSalaryTotal;
import pomplatform.report.bean.BaseReportOfSumRevenueYearRecords;
import pomplatform.report.bean.BaseReportOnEmployeeNumTotal;
import pomplatform.report.bean.BaseReportSureIntegralTotal;
import pomplatform.report.bean.BaseReportYearEmpWorkYears;
import pomplatform.report.bean.BaseSumSalaryAndInsuranceCost;
import pomplatform.report.bean.ConditionReportCapitalTotal;
import pomplatform.report.bean.ConditionReportCostTotal;
import pomplatform.report.bean.ConditionReportEmployeeWorkYears;
import pomplatform.report.bean.ConditionReportEmployeeWorkYearsByDepartment;
import pomplatform.report.bean.ConditionReportNewContractTotal;
import pomplatform.report.bean.ConditionReportOfGenderPlateMonth;
import pomplatform.report.bean.ConditionReportOfSalaryTotal;
import pomplatform.report.bean.ConditionReportOfSumRevenueYearRecords;
import pomplatform.report.bean.ConditionReportOnEmployeeNumTotal;
import pomplatform.report.bean.ConditionReportSureIntegralTotal;
import pomplatform.report.bean.ConditionSumSalaryAndInsuranceCost;
import pomplatform.report.query.QueryReportCapitalTotal;
import pomplatform.report.query.QueryReportCostTotal;
import pomplatform.report.query.QueryReportEmployeeWorkYears;
import pomplatform.report.query.QueryReportEmployeeWorkYearsByDepartment;
import pomplatform.report.query.QueryReportNewContractTotal;
import pomplatform.report.query.QueryReportOfGenderPlateMonth;
import pomplatform.report.query.QueryReportOfSalaryTotal;
import pomplatform.report.query.QueryReportOfSumRevenueYearRecords;
import pomplatform.report.query.QueryReportOnEmployeeNumTotal;
import pomplatform.report.query.QueryReportSureIntegralTotal;
import pomplatform.report.query.QuerySumSalaryAndInsuranceCost;

/**
 * 报表功用process
 * 
 * @author lxf
 */
public class OnReportProcess implements GenericProcessor {
	private final Logger __logger = Logger.getLogger("");
	// 操作类型
	private static final String OPT_TYPE = "optType";
	// 计算报表总表数据
	private static final String ON_ACCOUNT_REPORT_TOTAL = "onAccountReportTotal";
	// 性别分析总表 加载部门月数据
	private static final String ON_LOAD_PLATE_GENDER_DATA = "onLoadPlateGenderData";
	// 加载年度员工司龄数据集
	private static final String ON_LOAD_YEAR_EMP_WORK_YEARS = "onLoadYearEmpWorkYears";
	// 根据业务部门id加载年度员工司龄数据集
	private static final String ON_LOAD_YEAR_EMP_WORK_YEARS_BY_DEPARTMENT = "onLoadYearEmpWorkYearsByDepartment";
	// 加载月度员工司龄数据集
	private static final String ON_LOAD_MONTH_EMP_WORK_YEARS = "onLoadMonthEmpWorkYears";
	// 计算人工成本对比分析表的数据
	private static final String SUM_SALARY_AND_INSURANCE_COST = "sumSalaryAndInsuranceCost";
	// 人工成本对比分析表数据加锁
	private static final String LOCK_SALARY_AND_INSURANCE_COST = "lockSalaryAndInsuranceCost";

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(param, OPT_TYPE);
		if (ON_ACCOUNT_REPORT_TOTAL.equals(optType)) {
			return onAccountReportTotal(param);
		}else if(ON_LOAD_PLATE_GENDER_DATA.equals(optType)){
			return onLoadPlateGenderData(param);
		}else if(ON_LOAD_YEAR_EMP_WORK_YEARS.equals(optType)){
			return onLoadYearEmpWorkYears(param);
		} else if(ON_LOAD_MONTH_EMP_WORK_YEARS.equals(optType)){
			return onLoadMonthEmpWorkYears(param);
		}else if(SUM_SALARY_AND_INSURANCE_COST.equals(optType)){
			return sumSalaryAndInsuranceCost(param);
		}else if(LOCK_SALARY_AND_INSURANCE_COST.equals(optType)){
			return lockSalaryAndInsuranceCost(param);
		}else if(ON_LOAD_YEAR_EMP_WORK_YEARS_BY_DEPARTMENT.equals(optType)){
			return onLoadYearEmpWorkYearsByDepartment(param);
		}
		
		return null;
	}
	
	/**
	 * 人工成本对比分析表数据加锁
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	private String lockSalaryAndInsuranceCost(Map<String, Object> param) throws SQLException {
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		ThreadConnection.beginTransaction();
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		dao.setConditionYear("=", year);
		dao.setConditionMonth("=", month);
		if(dao.countRows() > 0){
			dao.setIsLocked(true);
			dao.conditionalUpdate();
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
	}

	/**
	 * 计算人工成本对比分析表的数据
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	private String sumSalaryAndInsuranceCost(Map<String, Object> param) throws SQLException {
		int month = BaseHelpUtils.getIntValue(param.get("month"));
		int year = BaseHelpUtils.getIntValue(param.get("year"));
		int lastMonth = month - 1;
		ThreadConnection.beginTransaction();
		ConditionSumSalaryAndInsuranceCost condition = new ConditionSumSalaryAndInsuranceCost();
		QuerySumSalaryAndInsuranceCost q = new QuerySumSalaryAndInsuranceCost();
		condition.setYear(year);
		condition.setMonth(month);
		condition.setLastMonth(lastMonth);
		BaseCollection<BaseSumSalaryAndInsuranceCost> list = q.executeQuery(null, condition);
		
		EmployeeCostAnalysy dao = new EmployeeCostAnalysy();
		BaseEmployeeCostAnalysy bean = null;
		String errorMsg = "";
		int status = 1;
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.getCollections().size() > 0){
			for(BaseSumSalaryAndInsuranceCost e : list.getCollections()){
				dao.clear();
				dao.setConditionYear("=", year);
				dao.setConditionMonth("=", month);
				dao.setConditionPlateId("=",e.getPlateId());
				bean = dao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(bean)){
					bean.setThisMonthPay(e.getThisPay());
					bean.setLastMonthPay(e.getLastPay());
					bean.setPayRaise(e.getPayRaise());
					bean.setThisMonthInsurance(e.getThisInsurance());
					bean.setLastMonthInsurance(e.getLastInsurance());
					bean.setInsuranceRaise(e.getInsuranceRaise());
					dao.setDataFromBase(bean);
					dao.update();
				}else{
					bean = new BaseEmployeeCostAnalysy();
					bean.setPlateId(e.getPlateId());
					bean.setYear(year);
					bean.setMonth(month);
					bean.setThisMonthPay(e.getThisPay());
					bean.setLastMonthPay(e.getLastPay());
					bean.setPayRaise(e.getPayRaise());
					bean.setThisMonthInsurance(e.getThisInsurance());
					bean.setLastMonthInsurance(e.getLastInsurance());
					bean.setInsuranceRaise(e.getInsuranceRaise());
					dao.setDataFromBase(bean);
					dao.save();
				}
			}
		}else{
			errorMsg = year+"年"+month+"月无应发工资及社保公积金数据";
			status = -1;
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(status, errorMsg);
	}


	/**
	 * 加载年度员工司龄数据集
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public String onLoadYearEmpWorkYears(Map<String, Object> param) throws SQLException, ParseException{
		ConditionReportEmployeeWorkYears condition = new ConditionReportEmployeeWorkYears();
		//获取年份
		int year = BaseHelpUtils.getIntValue(param, "year");
		if(year == 0){
			throw new SQLException("操作异常:年份不可为空");
		}
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR,year);
		QueryReportEmployeeWorkYears dao = new QueryReportEmployeeWorkYears();
	
		Map<Integer,BaseReportYearEmpWorkYears> map = new HashMap<>();
		//开始遍历每一个月的数据集
		for(int month=0;month<12;month++){
			ca.set(Calendar.MONTH,month);
			Date startDate = DateUtil.getFirstDay(ca.getTime());
			Date endDate = DateUtil.getLastDay(ca.getTime());
			condition.setStartDate(startDate);
			condition.setEndDate(endDate);
			if(!BaseHelpUtils.isNullOrEmpty(plateId)&&plateId>0) {
				condition.setPlateId(plateId);
			}
			BaseCollection<BaseReportEmployeeWorkYears> result = dao.executeQuery(null, condition);
			if(!BaseHelpUtils.isNullOrEmpty(result)){
				for(BaseReportEmployeeWorkYears e : result.getCollections()){
					BaseReportYearEmpWorkYears bean = map.get(e.getPlateId());
					if(BaseHelpUtils.isNullOrEmpty(bean)){
						bean = new BaseReportYearEmpWorkYears();
						bean.setPlateId(e.getPlateId());
					}
					if(month == 0){
						bean.setOneInner(e.getOneInner());
						bean.setOneInnerPercent(e.getOneInnerPercent());
						bean.setThreeInner(e.getThreeInner());
						bean.setThreeInnerPercent(e.getThreeInnerPercent());
						bean.setFiveInner(e.getFiveInner());
						bean.setFiveInnerPercent(e.getFiveInnerPercent());
						bean.setTenInner(e.getTenInner());
						bean.setTenInnerPercent(e.getTenInnerPercent());
						bean.setTenAdd(e.getTenAdd());
						bean.setTenAddPercent(e.getTenAddPercent());
						bean.setTotal(e.getTotal());
					}else if(month == 1){
						bean.setOneInnerTwo(e.getOneInner());
						bean.setOneInnerPercentTwo(e.getOneInnerPercent());
						bean.setThreeInnerTwo(e.getThreeInner());
						bean.setThreeInnerPercentTwo(e.getThreeInnerPercent());
						bean.setFiveInnerTwo(e.getFiveInner());
						bean.setFiveInnerPercentTwo(e.getFiveInnerPercent());
						bean.setTenInnerTwo(e.getTenInner());
						bean.setTenInnerPercentTwo(e.getTenInnerPercent());
						bean.setTenAddTwo(e.getTenAdd());
						bean.setTenAddPercentTwo(e.getTenAddPercent());
						bean.setTotalTwo(e.getTotal());
					}else if(month == 2){
						bean.setOneInnerThree(e.getOneInner());
						bean.setOneInnerPercentThree(e.getOneInnerPercent());
						bean.setThreeInnerThree(e.getThreeInner());
						bean.setThreeInnerPercentThree(e.getThreeInnerPercent());
						bean.setFiveInnerThree(e.getFiveInner());
						bean.setFiveInnerPercentThree(e.getFiveInnerPercent());
						bean.setTenInnerThree(e.getTenInner());
						bean.setTenInnerPercentThree(e.getTenInnerPercent());
						bean.setTenAddThree(e.getTenAdd());
						bean.setTenAddPercentThree(e.getTenAddPercent());
						bean.setTotalThree(e.getTotal());
					}else if(month == 3){
						bean.setOneInnerFour(e.getOneInner());
						bean.setOneInnerPercentFour(e.getOneInnerPercent());
						bean.setThreeInnerFour(e.getThreeInner());
						bean.setThreeInnerPercentFour(e.getThreeInnerPercent());
						bean.setFiveInnerFour(e.getFiveInner());
						bean.setFiveInnerPercentFour(e.getFiveInnerPercent());
						bean.setTenInnerFour(e.getTenInner());
						bean.setTenInnerPercentFour(e.getTenInnerPercent());
						bean.setTenAddFour(e.getTenAdd());
						bean.setTenAddPercentFour(e.getTenAddPercent());
						bean.setTotalFour(e.getTotal());
					}else if(month == 4){
						bean.setOneInnerFive(e.getOneInner());
						bean.setOneInnerPercentFive(e.getOneInnerPercent());
						bean.setThreeInnerFive(e.getThreeInner());
						bean.setThreeInnerPercentFive(e.getThreeInnerPercent());
						bean.setFiveInnerFive(e.getFiveInner());
						bean.setFiveInnerPercentFive(e.getFiveInnerPercent());
						bean.setTenInnerFive(e.getTenInner());
						bean.setTenInnerPercentFive(e.getTenInnerPercent());
						bean.setTenAddFive(e.getTenAdd());
						bean.setTenAddPercentFive(e.getTenAddPercent());
						bean.setTotalFive(e.getTotal());
					}else if(month == 5){
						bean.setOneInnerSix(e.getOneInner());
						bean.setOneInnerPercentSix(e.getOneInnerPercent());
						bean.setThreeInnerSix(e.getThreeInner());
						bean.setThreeInnerPercentSix(e.getThreeInnerPercent());
						bean.setFiveInnerSix(e.getFiveInner());
						bean.setFiveInnerPercentSix(e.getFiveInnerPercent());
						bean.setTenInnerSix(e.getTenInner());
						bean.setTenInnerPercentSix(e.getTenInnerPercent());
						bean.setTenAddSix(e.getTenAdd());
						bean.setTenAddPercentSix(e.getTenAddPercent());
						bean.setTotalSix(e.getTotal());
					}else if(month == 6){
						bean.setOneInnerSeven(e.getOneInner());
						bean.setOneInnerPercentSeven(e.getOneInnerPercent());
						bean.setThreeInnerSeven(e.getThreeInner());
						bean.setThreeInnerPercentSeven(e.getThreeInnerPercent());
						bean.setFiveInnerSeven(e.getFiveInner());
						bean.setFiveInnerPercentSeven(e.getFiveInnerPercent());
						bean.setTenInnerSeven(e.getTenInner());
						bean.setTenInnerPercentSeven(e.getTenInnerPercent());
						bean.setTenAddSeven(e.getTenAdd());
						bean.setTenAddPercentSeven(e.getTenAddPercent());
						bean.setTotalSeven(e.getTotal());
					}else if(month == 7){
						bean.setOneInnerEight(e.getOneInner());
						bean.setOneInnerPercentEight(e.getOneInnerPercent());
						bean.setThreeInnerEight(e.getThreeInner());
						bean.setThreeInnerPercentEight(e.getThreeInnerPercent());
						bean.setFiveInnerEight(e.getFiveInner());
						bean.setFiveInnerPercentEight(e.getFiveInnerPercent());
						bean.setTenInnerEight(e.getTenInner());
						bean.setTenInnerPercentEight(e.getTenInnerPercent());
						bean.setTenAddEight(e.getTenAdd());
						bean.setTenAddPercentEight(e.getTenAddPercent());
						bean.setTotalEight(e.getTotal());
					}else if(month == 8){
						bean.setOneInnerNine(e.getOneInner());
						bean.setOneInnerPercentNine(e.getOneInnerPercent());
						bean.setThreeInnerNine(e.getThreeInner());
						bean.setThreeInnerPercentNine(e.getThreeInnerPercent());
						bean.setFiveInnerNine(e.getFiveInner());
						bean.setFiveInnerPercentNine(e.getFiveInnerPercent());
						bean.setTenInnerNine(e.getTenInner());
						bean.setTenInnerPercentNine(e.getTenInnerPercent());
						bean.setTenAddNine(e.getTenAdd());
						bean.setTenAddPercentNine(e.getTenAddPercent());
						bean.setTotalNine(e.getTotal());
					}else if(month == 9){
						bean.setOneInnerTen(e.getOneInner());
						bean.setOneInnerPercentTen(e.getOneInnerPercent());
						bean.setThreeInnerTen(e.getThreeInner());
						bean.setThreeInnerPercentTen(e.getThreeInnerPercent());
						bean.setFiveInnerTen(e.getFiveInner());
						bean.setFiveInnerPercentTen(e.getFiveInnerPercent());
						bean.setTenInnerTen(e.getTenInner());
						bean.setTenInnerPercentTen(e.getTenInnerPercent());
						bean.setTenAddTen(e.getTenAdd());
						bean.setTenAddPercentTen(e.getTenAddPercent());
						bean.setTotalTen(e.getTotal());
					}else if(month == 10){
						bean.setOneInnerEleven(e.getOneInner());
						bean.setOneInnerPercentEleven(e.getOneInnerPercent());
						bean.setThreeInnerEleven(e.getThreeInner());
						bean.setThreeInnerPercentEleven(e.getThreeInnerPercent());
						bean.setFiveInnerEleven(e.getFiveInner());
						bean.setFiveInnerPercentEleven(e.getFiveInnerPercent());
						bean.setTenInnerEleven(e.getTenInner());
						bean.setTenInnerPercentEleven(e.getTenInnerPercent());
						bean.setTenAddEleven(e.getTenAdd());
						bean.setTenAddPercentEleven(e.getTenAddPercent());
						bean.setTotalEleven(e.getTotal());
					}else if(month == 11){
						bean.setOneInnerTwelf(e.getOneInner());
						bean.setOneInnerPercentTwelf(e.getOneInnerPercent());
						bean.setThreeInnerTwelf(e.getThreeInner());
						bean.setThreeInnerPercentTwelf(e.getThreeInnerPercent());
						bean.setFiveInnerTwelf(e.getFiveInner());
						bean.setFiveInnerPercentTwelf(e.getFiveInnerPercent());
						bean.setTenInnerTwelf(e.getTenInner());
						bean.setTenInnerPercentTwelf(e.getTenInnerPercent());
						bean.setTenAddTwelf(e.getTenAdd());
						bean.setTenAddPercentTwelf(e.getTenAddPercent());
						bean.setTotalTwelf(e.getTotal());
					}
					map.put(e.getPlateId(),bean);
				}
			}
		}
		BaseCollection<BaseReportYearEmpWorkYears> backResult = new BaseCollection<>();
		List<BaseReportYearEmpWorkYears> backList = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0){
			for(int id : map.keySet()){
				backList.add(map.get(id));
			}
		}
		backResult.setCollections(backList);
		return backResult.toJSON(0,"");
	}
	
	/**
	 * 加载月度员工司龄数据集
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public String onLoadMonthEmpWorkYears(Map<String, Object> param) throws SQLException, ParseException{
		//获取年份
		int year = BaseHelpUtils.getIntValue(param, "year");
		if(year == 0){
			throw new SQLException("操作异常:年份不可为空");
		}
		//获取月份
		int month = BaseHelpUtils.getIntValue(param, "month");
		if(month == 0){
			throw new SQLException("操作异常:月份不可为空");
		}
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		//获取类型
		int plateType = BaseHelpUtils.getIntValue(param, "plateType");
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR,year);
		ca.set(Calendar.MONTH,month-1);
		QueryReportEmployeeWorkYears dao = new QueryReportEmployeeWorkYears();
		ConditionReportEmployeeWorkYears condition = new ConditionReportEmployeeWorkYears();
		Date startDate = DateUtil.getFirstDay(ca.getTime());
		Date endDate = DateUtil.getLastDay(ca.getTime());
		condition.setStartDate(startDate);
		condition.setEndDate(endDate);
		if(plateId > 0){
			condition.setPlateId(plateId);
		}
		if(plateType > 0){
			condition.setPlateType(plateType);
		}
		BaseCollection<BaseReportEmployeeWorkYears> result = dao.executeQuery(null, condition);
		return result.toJSON(0,"");
	}

	/**
	 * 性别分析总表 加载部门月数据
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	private String onLoadPlateGenderData(Map<String, Object> param) throws SQLException, ParseException {
		int year = BaseHelpUtils.getIntValue(param, "year");
		int month = BaseHelpUtils.getIntValue(param, "month");
		Date createDate = DateUtil.createFirstDayOfMonth(year, month);//根据年份月份生成日期
		Date theDate = DateUtil.getLastDay(createDate);//根据日期获取最后一天
		QueryReportOfGenderPlateMonth q = new QueryReportOfGenderPlateMonth();
		ConditionReportOfGenderPlateMonth condition = new ConditionReportOfGenderPlateMonth();
		condition.setTheDate(theDate);
		if(!BaseHelpUtils.isNullOrEmpty(param.get("plateType"))){
			condition.setPlateType(BaseHelpUtils.getIntValue(param.get("plateType")));
		}
		BaseCollection<BaseReportOfGenderPlateMonth> list = q.executeQuery(null, condition);
		
		return list.toJSON(0, null);
	}

	/**
	 * 计算报表总表数据
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public String onAccountReportTotal(Map<String, Object> param) throws SQLException {
		//获取年份
		int year = BaseHelpUtils.getIntValue(param, "year");
		//获取业务部门数据集
		PlateRecord plateDao = new PlateRecord();
		plateDao.setConditionEnabled("=",Boolean.TRUE);
		List<BasePlateRecord> plateList = plateDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(plateList) && plateList.size() > 0){
			ThreadConnection.beginTransaction();
			//获取当前系统日期的月份
			Date currentDate = new Date();
			int month = DateUtil.getMonth(currentDate);
			//根据年份去加载报表总表的数据集
			ReportTotal dao = new ReportTotal();
			dao.setConditionYear("=",year);
			List<BaseReportTotal> list = dao.conditionalLoad();
			//定义map来存放该年度每个业务部门已保存的数据集
			Map<Integer,BaseReportTotal> map = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
				for(BaseReportTotal e : list){
					map.put(e.getPlateId(),e);
				}
			}
			//检索本年度不含税的营收
			Map<Integer,Map<String,BigDecimal>> revenueMap = getReportRevenue(year, month);
			//检索本年度现金流
			Map<Integer,Map<String,BigDecimal>> capitalMap = getReportCapital(year, month);
			//检索本年度确认积分
			Map<Integer,Map<String,BigDecimal>> sureIntegralMap = getReportSureIntegral(year, month);
			//检索本年度薪酬
			Map<Integer,Map<String,BigDecimal>> salaryMap = getReportSalary(year, month);
			//检索本年度新签合同
			Map<Integer,Map<String,BigDecimal>> contractMap = getReportContract(year, month);
			//获取年度平均人数
			Map<Integer,BigDecimal> empNumMap = getReportEmpNum(year);
			//获取合同存量
			Map<Integer,BigDecimal> contractSaveMap = getReportContractSave(year);
			//获取项目陈本
			Map<Integer,Map<String,BigDecimal>> projectCostMap = getReportCost(year, month,1);
			//获取前期项目成本
			Map<Integer,Map<String,BigDecimal>> projectBeforeCostMap = getReportCost(year, month,2);
			//获取部门成本
			Map<Integer,Map<String,BigDecimal>> plateCostMap = getReportCost(year, month,3);
			
			BaseReportTotal bean = null;
			//循环每一个业务部门的数据集
			for(BasePlateRecord e : plateList){
				//获取业务部门ID
				int plateId = e.getPlateId();
				bean = map.get(plateId);
				if(BaseHelpUtils.isNullOrEmpty(bean)){
					bean = new BaseReportTotal();
					bean.setPlateId(plateId);
					bean.setYear(year);
				}
				//获取本月营收和累计营收
				Map<String,BigDecimal> reMap = revenueMap.get(plateId);
				BigDecimal totalRevenue = BigDecimal.ZERO;
				BigDecimal currentRevenue = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(reMap)){
					totalRevenue = BaseHelpUtils.getBigDecimalValue(reMap.get("totalRevenue"));
					currentRevenue = BaseHelpUtils.getBigDecimalValue(reMap.get("currentRevenue"));
				}
				bean.setMonthRevenue(currentRevenue);
				bean.setTotalRevenue(totalRevenue);
				//获取本月现金流和累计现金流
				Map<String,BigDecimal> caMap = capitalMap.get(plateId);
				BigDecimal totalCapitalPlate = BigDecimal.ZERO;
				BigDecimal currentCapitalPlate = BigDecimal.ZERO;
				BigDecimal totalCapitalProject = BigDecimal.ZERO;
				BigDecimal currentCapitalProject = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(caMap)){
					totalCapitalPlate = BaseHelpUtils.getBigDecimalValue(caMap.get("totalCapitalPlate"));
					currentCapitalPlate = BaseHelpUtils.getBigDecimalValue(caMap.get("currentCapitalPlate"));
					totalCapitalProject = BaseHelpUtils.getBigDecimalValue(caMap.get("totalCapitalProject"));
					currentCapitalProject = BaseHelpUtils.getBigDecimalValue(caMap.get("currentCapitalProject"));
				}
				bean.setTotalCapitalPlate(totalCapitalPlate);
				bean.setMonthCapitalPlate(currentCapitalPlate);
				bean.setTotalCapitalProject(totalCapitalProject);
				bean.setMonthCapitalProject(currentCapitalProject);
				//获取本月薪酬积分和累计薪酬积分
				Map<String,BigDecimal> saMap = salaryMap.get(plateId);
				BigDecimal totalSalary = BigDecimal.ZERO;
				BigDecimal currentSalary = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(saMap)){
					totalSalary = BaseHelpUtils.getBigDecimalValue(saMap.get("totalSalary"));
					currentSalary = BaseHelpUtils.getBigDecimalValue(saMap.get("currentSalary"));
				}
				bean.setTotalSalary(totalSalary);
				bean.setMonthSalary(currentSalary);
				
				//获取本月确认积分和累计确认积分
				Map<String,BigDecimal> siMap = sureIntegralMap.get(plateId);
				BigDecimal totalSureIntegralPlate = BigDecimal.ZERO;
				BigDecimal currentSureIntegralPlate = BigDecimal.ZERO;
				BigDecimal totalSureIntegralProject = BigDecimal.ZERO;
				BigDecimal currentSureIntegralProject = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(siMap)){
					totalSureIntegralPlate = BaseHelpUtils.getBigDecimalValue(siMap.get("totalSureIntegralPlate"));
					currentSureIntegralPlate = BaseHelpUtils.getBigDecimalValue(siMap.get("currentSureIntegralPlate"));
					totalSureIntegralProject = BaseHelpUtils.getBigDecimalValue(siMap.get("totalSureIntegralProject"));
					currentSureIntegralProject = BaseHelpUtils.getBigDecimalValue(siMap.get("currentSureIntegralProject"));
				}
				bean.setTotalSureIntegralPlate(totalSureIntegralPlate);
				bean.setMonthSureIntegralPlate(currentSureIntegralPlate);
				bean.setTotalSureIntegralProject(totalSureIntegralProject);
				bean.setMonthSureIntegralProject(currentSureIntegralProject);
				
				
				//获取本月新签合同和累计新签合同
				Map<String,BigDecimal> conMap = contractMap.get(plateId);
				BigDecimal totalContract = BigDecimal.ZERO;
				BigDecimal currentContract = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(conMap)){
					totalContract = BaseHelpUtils.getBigDecimalValue(conMap.get("totalContract"));
					currentContract = BaseHelpUtils.getBigDecimalValue(conMap.get("currentContract"));
				}
				bean.setTotalNewContract(totalContract);
				bean.setMonthNewContract(currentContract);
				
				//获取平均人数
				BigDecimal averageNum = BaseHelpUtils.getBigDecimalValue(empNumMap.get(plateId));
				bean.setAverageEmpNum(averageNum);
				//合同存量
				BigDecimal contractSave = BaseHelpUtils.getBigDecimalValue(contractSaveMap.get(plateId));
				bean.setContractTotal(contractSave);
				
				//获取本月项目成本和累计项目成本
				Map<String,BigDecimal> pcMap = projectCostMap.get(plateId);
				BigDecimal totalProjectCost = BigDecimal.ZERO;
				BigDecimal currentProjectCost = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(pcMap)){
					totalProjectCost = BaseHelpUtils.getBigDecimalValue(pcMap.get("totalCost"));
					currentProjectCost = BaseHelpUtils.getBigDecimalValue(pcMap.get("currentCost"));
				}
				bean.setTotalCostProject(totalProjectCost);
				bean.setMonthCapitalProject(currentProjectCost);
				
				//获取本月前期项目成本和累计前期项目成本
				Map<String,BigDecimal> pbcMap = projectBeforeCostMap.get(plateId);
				BigDecimal totalProjectBeforeCost = BigDecimal.ZERO;
				BigDecimal currentProjectBeforeCost = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(pbcMap)){
					totalProjectBeforeCost = BaseHelpUtils.getBigDecimalValue(pbcMap.get("totalCost"));
					currentProjectBeforeCost = BaseHelpUtils.getBigDecimalValue(pbcMap.get("currentCost"));
				}
				bean.setTotalCostProjectBefore(totalProjectBeforeCost);
				bean.setMonthCostProjectBefore(currentProjectBeforeCost);
				
				//获取本月部门成本和累计部门成本
				Map<String,BigDecimal> platecMap = plateCostMap.get(plateId);
				BigDecimal totalPlateCost = BigDecimal.ZERO;
				BigDecimal currentPlateCost = BigDecimal.ZERO;
				if(!BaseHelpUtils.isNullOrEmpty(platecMap)){
					totalPlateCost = BaseHelpUtils.getBigDecimalValue(platecMap.get("totalCost"));
					currentPlateCost = BaseHelpUtils.getBigDecimalValue(platecMap.get("currentCost"));
				}
				bean.setTotalCostPlate(totalPlateCost);
				bean.setMonthCostPlate(currentPlateCost);
				
				dao.clear();
				//获取主键ID
				int reportTotalId = BaseHelpUtils.getIntValue(bean.getReportTotalId());
				if(reportTotalId > 0){
					dao.setReportTotalId(reportTotalId);
					if(dao.load()){
						dao.setDataFromBase(bean);
						dao.update();
					}
				}else{
					dao.setDataFromBase(bean);
					dao.save();
				}
			}
			
			ThreadConnection.commit();
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
	}
	
	/**
	 * 检索成本
	 * @param type:1:项目成本;2:前期项目成本;3:部门成本
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportCost(int year,int month,int type) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> costMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportCostTotal dao = new QueryReportCostTotal();
		ConditionReportCostTotal con = new ConditionReportCostTotal();
		con.setYear(year);
		con.setFeeType(type);
		BaseCollection<BaseReportCostTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportCostTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalCost = BigDecimal.ZERO;
				BigDecimal currentCost = BigDecimal.ZERO;
				BigDecimal january = BaseHelpUtils.getBigDecimalValue(e.getJanuary());//1月
				BigDecimal february = BaseHelpUtils.getBigDecimalValue(e.getFebruary());//2月
				BigDecimal march = BaseHelpUtils.getBigDecimalValue(e.getMarch());//3月
				BigDecimal april = BaseHelpUtils.getBigDecimalValue(e.getApril());//4月
				BigDecimal may = BaseHelpUtils.getBigDecimalValue(e.getMay());//5月
				BigDecimal june = BaseHelpUtils.getBigDecimalValue(e.getJune());//6月
				BigDecimal july = BaseHelpUtils.getBigDecimalValue(e.getJuly());//7月
				BigDecimal august = BaseHelpUtils.getBigDecimalValue(e.getAugust());//8月
				BigDecimal september = BaseHelpUtils.getBigDecimalValue(e.getSeptember());//9月
				BigDecimal october = BaseHelpUtils.getBigDecimalValue(e.getOctober());//10月
				BigDecimal november = BaseHelpUtils.getBigDecimalValue(e.getNovember());//11月
				BigDecimal december = BaseHelpUtils.getBigDecimalValue(e.getDecember());//12月
				totalCost = january.add(february).add(march).add(april).add(may).add(june)
				.add(july).add(august).add(september).add(october).add(november).add(december);
				switch (month) {
				case 1:
					currentCost = january;
					break;
				case 2:
					currentCost = february;
					break;
				case 3:
					currentCost = march;
					break;
				case 4:
					currentCost = april;
					break;
				case 5:
					currentCost = may;
					break;
				case 6:
					currentCost = june;
					break;
				case 7:
					currentCost = july;
					break;
				case 8:
					currentCost = august;
					break;
				case 9:
					currentCost = september;
					break;
				case 10:
					currentCost = october;
					break;
				case 11:
					currentCost = november;
					break;
				case 12:
					currentCost = december;
					break;

				default:
					break;
				}
				map.put("totalCost", totalCost);
				map.put("currentCost", currentCost);
				costMap.put(plateId,map);
			}
		}
		return costMap;
	}
	
	
	/**
	 * 获取合同存量
	 * @param year
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,BigDecimal> getReportContractSave(int year) throws SQLException{
		Map<Integer,BigDecimal> contractSaveMap = new HashMap<>();
		QueryOnLoadContractSaveAmount dao = new QueryOnLoadContractSaveAmount();
		ConditionOnLoadContractSaveAmount con = new ConditionOnLoadContractSaveAmount();
		con.setYear(year);
		BaseCollection<BaseOnLoadContractSaveAmount> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseOnLoadContractSaveAmount e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				BigDecimal contractSave = e.getContractSave()==null?BigDecimal.ZERO:e.getContractSave();
				contractSaveMap.put(plateId,contractSave);
			}
		}
		return contractSaveMap;
	}
	
	/**
	 * 检索本年度平均人数
	 * 【（月初+月末）/2之和】/月数
	 * @param year
	 * @param
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,BigDecimal> getReportEmpNum(int year) throws SQLException{
		Map<Integer,BigDecimal> empNumMap = new HashMap<>();
		QueryReportOnEmployeeNumTotal dao = new QueryReportOnEmployeeNumTotal();
		ConditionReportOnEmployeeNumTotal con = new ConditionReportOnEmployeeNumTotal();
		con.setYear(year);
		BaseCollection<BaseReportOnEmployeeNumTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportOnEmployeeNumTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				BigDecimal averageNum = BigDecimal.ZERO;
				//获取本年度每月的平均人数
				BigDecimal oneAverageNum = BaseHelpUtils.getBigDecimalValue(e.getOneAverageNum());//1月
				BigDecimal twoAverageNum = BaseHelpUtils.getBigDecimalValue(e.getTwoAverageNum());//2月
				BigDecimal threeAverageNum = BaseHelpUtils.getBigDecimalValue(e.getThreeAverageNum());//3月
				BigDecimal fourAverageNum = BaseHelpUtils.getBigDecimalValue(e.getFourAverageNum());//4月
				BigDecimal fiveAverageNum = BaseHelpUtils.getBigDecimalValue(e.getFiveAverageNum());//5月
				BigDecimal sixAverageNum = BaseHelpUtils.getBigDecimalValue(e.getSixAverageNum());//6月
				BigDecimal sevenAverageNum = BaseHelpUtils.getBigDecimalValue(e.getSevenAverageNum());//7月
				BigDecimal eightAverageNum = BaseHelpUtils.getBigDecimalValue(e.getEightAverageNum());//8月
				BigDecimal nineAverageNum = BaseHelpUtils.getBigDecimalValue(e.getNineAverageNum());//9月
				BigDecimal tenAverageNum = BaseHelpUtils.getBigDecimalValue(e.getTenAverageNum());//10月
				BigDecimal elevenAverageNum = BaseHelpUtils.getBigDecimalValue(e.getElevenAverageNum());//11月
				BigDecimal twelfAverageNum = BaseHelpUtils.getBigDecimalValue(e.getTwelfAverageNum());//12月
				averageNum = oneAverageNum.add(twoAverageNum).add(threeAverageNum).add(fourAverageNum).add(fiveAverageNum).add(sixAverageNum)
				.add(sevenAverageNum).add(eightAverageNum).add(nineAverageNum).add(tenAverageNum).add(elevenAverageNum).add(twelfAverageNum).divide(BigDecimal.valueOf(12),2,BigDecimal.ROUND_HALF_UP);
				empNumMap.put(plateId,averageNum);
			}
		}
		return empNumMap;
	}

	/**
	 * 检索本年度不含税的营收
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportRevenue(int year,int month) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> revenueMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportOfSumRevenueYearRecords dao = new QueryReportOfSumRevenueYearRecords();
		ConditionReportOfSumRevenueYearRecords con = new ConditionReportOfSumRevenueYearRecords();
		con.setYear(year);
		BaseCollection<BaseReportOfSumRevenueYearRecords> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportOfSumRevenueYearRecords e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalRevenue = BigDecimal.ZERO;
				BigDecimal currentRevenue = BigDecimal.ZERO;
				//获取本年度每月的营收数据
				BigDecimal januaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getJanuaryRevenue());//1月
				BigDecimal februaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getFebruaryRevenue());//2月
				BigDecimal marchRevenue = BaseHelpUtils.getBigDecimalValue(e.getMarchRevenue());//3月
				BigDecimal aprilRevenue = BaseHelpUtils.getBigDecimalValue(e.getAprilRevenue());//4月
				BigDecimal mayRevenue = BaseHelpUtils.getBigDecimalValue(e.getMayRevenue());//5月
				BigDecimal juneRevenue = BaseHelpUtils.getBigDecimalValue(e.getJuneRevenue());//6月
				BigDecimal julyRevenue = BaseHelpUtils.getBigDecimalValue(e.getJulyRevenue());//7月
				BigDecimal augustRevenue = BaseHelpUtils.getBigDecimalValue(e.getAugustRevenue());//8月
				BigDecimal septemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getSeptemberRevenue());//9月
				BigDecimal octoberRevenue = BaseHelpUtils.getBigDecimalValue(e.getOctoberRevenue());//10月
				BigDecimal novemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getNovemberRevenue());//11月
				BigDecimal decemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getDecemberRevenue());//12月
				totalRevenue = januaryRevenue.add(februaryRevenue).add(marchRevenue).add(aprilRevenue).add(mayRevenue).add(juneRevenue)
				.add(julyRevenue).add(augustRevenue).add(septemberRevenue).add(octoberRevenue).add(novemberRevenue).add(decemberRevenue);
				switch (month) {
				case 1:
					currentRevenue = januaryRevenue;
					break;
				case 2:
					currentRevenue = februaryRevenue;
					break;
				case 3:
					currentRevenue = marchRevenue;
					break;
				case 4:
					currentRevenue = aprilRevenue;
					break;
				case 5:
					currentRevenue = mayRevenue;
					break;
				case 6:
					currentRevenue = juneRevenue;
					break;
				case 7:
					currentRevenue = julyRevenue;
					break;
				case 8:
					currentRevenue = augustRevenue;
					break;
				case 9:
					currentRevenue = septemberRevenue;
					break;
				case 10:
					currentRevenue = octoberRevenue;
					break;
				case 11:
					currentRevenue = novemberRevenue;
					break;
				case 12:
					currentRevenue = decemberRevenue;
					break;

				default:
					break;
				}
				map.put("totalRevenue", totalRevenue);
				map.put("currentRevenue", currentRevenue);
				revenueMap.put(plateId,map);
			}
		}
		return revenueMap;
	}
	
	/**
	 * 检索本年度现金流
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportCapital(int year,int month) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> capitalMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportCapitalTotal dao = new QueryReportCapitalTotal();
		ConditionReportCapitalTotal con = new ConditionReportCapitalTotal();
		con.setYear(year);
		BaseCollection<BaseReportCapitalTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportCapitalTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalCapitalPlate = BigDecimal.ZERO;
				BigDecimal currentCapitalPlate = BigDecimal.ZERO;
				BigDecimal totalCapitalProject = BigDecimal.ZERO;
				BigDecimal currentCapitalProject = BigDecimal.ZERO;
				//获取本年度每月的营收数据
				BigDecimal januaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getJanuaryRevenue());//1月
				BigDecimal januaryRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJanuaryRevenue());//1月
				
				BigDecimal februaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getFebruaryRevenue());//2月
				BigDecimal februaryRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateFebruaryRevenue());//2月
				
				BigDecimal marchRevenue = BaseHelpUtils.getBigDecimalValue(e.getMarchRevenue());//3月
				BigDecimal marchRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateMarchRevenue());//3月
				
				BigDecimal aprilRevenue = BaseHelpUtils.getBigDecimalValue(e.getAprilRevenue());//4月
				BigDecimal aprilRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateAprilRevenue());//4月
				
				BigDecimal mayRevenue = BaseHelpUtils.getBigDecimalValue(e.getMayRevenue());//5月
				BigDecimal mayRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateMayRevenue());//5月
				
				BigDecimal juneRevenue = BaseHelpUtils.getBigDecimalValue(e.getJuneRevenue());//6月
				BigDecimal juneRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJuneRevenue());//6月
				
				BigDecimal julyRevenue = BaseHelpUtils.getBigDecimalValue(e.getJulyRevenue());//7月
				BigDecimal julyRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJulyRevenue());//7月
				
				BigDecimal augustRevenue = BaseHelpUtils.getBigDecimalValue(e.getAugustRevenue());//8月
				BigDecimal augustRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateAugustRevenue());//8月
				
				BigDecimal septemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getSeptemberRevenue());//9月
				BigDecimal septemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateSeptemberRevenue());//9月
				
				BigDecimal octoberRevenue = BaseHelpUtils.getBigDecimalValue(e.getOctoberRevenue());//10月
				BigDecimal octoberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateOctoberRevenue());//10月
				
				BigDecimal novemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getNovemberRevenue());//11月
				BigDecimal novemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateNovemberRevenue());//11月
				
				BigDecimal decemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getDecemberRevenue());//12月
				BigDecimal decemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateDecemberRevenue());//12月
				
				totalCapitalProject = januaryRevenue.add(februaryRevenue).add(marchRevenue).add(aprilRevenue).add(mayRevenue).add(juneRevenue)
				.add(julyRevenue).add(augustRevenue).add(septemberRevenue).add(octoberRevenue).add(novemberRevenue).add(decemberRevenue);
				switch (month) {
				case 1:
					currentCapitalProject = januaryRevenue;
					currentCapitalPlate = januaryRevenuePlate;
					break;
				case 2:
					currentCapitalProject = februaryRevenue;
					currentCapitalPlate = februaryRevenuePlate;
					break;
				case 3:
					currentCapitalProject = marchRevenue;
					currentCapitalPlate = marchRevenuePlate;
					break;
				case 4:
					currentCapitalProject = aprilRevenue;
					currentCapitalPlate = aprilRevenuePlate;
					break;
				case 5:
					currentCapitalProject = mayRevenue;
					currentCapitalPlate = mayRevenuePlate;
					break;
				case 6:
					currentCapitalProject = juneRevenue;
					currentCapitalPlate = juneRevenuePlate;
					break;
				case 7:
					currentCapitalProject = julyRevenue;
					currentCapitalPlate = julyRevenuePlate;
					break;
				case 8:
					currentCapitalProject = augustRevenue;
					currentCapitalPlate = augustRevenuePlate;
					break;
				case 9:
					currentCapitalProject = septemberRevenue;
					currentCapitalPlate = septemberRevenuePlate;
					break;
				case 10:
					currentCapitalProject = octoberRevenue;
					currentCapitalPlate = octoberRevenuePlate;
					break;
				case 11:
					currentCapitalProject = novemberRevenue;
					currentCapitalPlate = novemberRevenuePlate;
					break;
				case 12:
					currentCapitalProject = decemberRevenue;
					currentCapitalPlate = decemberRevenuePlate;
					break;

				default:
					break;
				}
				map.put("totalCapitalProject", totalCapitalProject);
				map.put("currentCapitalProject", currentCapitalProject);
				map.put("totalCapitalPlate", totalCapitalPlate);
				map.put("currentCapitalPlate", currentCapitalPlate);
				capitalMap.put(plateId,map);
			}
		}
		return capitalMap;
	}
	
	/**
	 * 检索本年度确认积分
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportSureIntegral(int year,int month) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> sureIntegralMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportSureIntegralTotal dao = new QueryReportSureIntegralTotal();
		ConditionReportSureIntegralTotal con = new ConditionReportSureIntegralTotal();
		con.setYear(year);
		BaseCollection<BaseReportSureIntegralTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportSureIntegralTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalSureIntegralPlate = BigDecimal.ZERO;
				BigDecimal currentSureIntegralPlate = BigDecimal.ZERO;
				BigDecimal totalSureIntegralProject = BigDecimal.ZERO;
				BigDecimal currentSureIntegralProject = BigDecimal.ZERO;
				//获取本年度每月的营收数据
				BigDecimal januaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getJanuaryRevenue());//1月
				BigDecimal januaryRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJanuaryRevenue());//1月
				
				BigDecimal februaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getFebruaryRevenue());//2月
				BigDecimal februaryRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateFebruaryRevenue());//2月
				
				BigDecimal marchRevenue = BaseHelpUtils.getBigDecimalValue(e.getMarchRevenue());//3月
				BigDecimal marchRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateMarchRevenue());//3月
				
				BigDecimal aprilRevenue = BaseHelpUtils.getBigDecimalValue(e.getAprilRevenue());//4月
				BigDecimal aprilRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateAprilRevenue());//4月
				
				BigDecimal mayRevenue = BaseHelpUtils.getBigDecimalValue(e.getMayRevenue());//5月
				BigDecimal mayRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateMayRevenue());//5月
				
				BigDecimal juneRevenue = BaseHelpUtils.getBigDecimalValue(e.getJuneRevenue());//6月
				BigDecimal juneRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJuneRevenue());//6月
				
				BigDecimal julyRevenue = BaseHelpUtils.getBigDecimalValue(e.getJulyRevenue());//7月
				BigDecimal julyRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateJulyRevenue());//7月
				
				BigDecimal augustRevenue = BaseHelpUtils.getBigDecimalValue(e.getAugustRevenue());//8月
				BigDecimal augustRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateAugustRevenue());//8月
				
				BigDecimal septemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getSeptemberRevenue());//9月
				BigDecimal septemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateSeptemberRevenue());//9月
				
				BigDecimal octoberRevenue = BaseHelpUtils.getBigDecimalValue(e.getOctoberRevenue());//10月
				BigDecimal octoberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateOctoberRevenue());//10月
				
				BigDecimal novemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getNovemberRevenue());//11月
				BigDecimal novemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateNovemberRevenue());//11月
				
				BigDecimal decemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getDecemberRevenue());//12月
				BigDecimal decemberRevenuePlate = BaseHelpUtils.getBigDecimalValue(e.getPlateDecemberRevenue());//12月
				
				totalSureIntegralPlate = januaryRevenuePlate.add(februaryRevenuePlate).add(marchRevenuePlate).add(aprilRevenuePlate).add(mayRevenuePlate).add(juneRevenuePlate)
				.add(julyRevenuePlate).add(augustRevenuePlate).add(septemberRevenuePlate).add(octoberRevenuePlate).add(novemberRevenuePlate).add(decemberRevenuePlate);
				totalSureIntegralProject = januaryRevenue.add(februaryRevenue).add(marchRevenue).add(aprilRevenue).add(mayRevenue).add(juneRevenue)
						.add(julyRevenue).add(augustRevenue).add(septemberRevenue).add(octoberRevenue).add(novemberRevenue).add(decemberRevenue);
				switch (month) {
				case 1:
					currentSureIntegralProject = januaryRevenue;
					currentSureIntegralPlate = januaryRevenuePlate;
					break;
				case 2:
					currentSureIntegralProject = februaryRevenue;
					currentSureIntegralPlate = februaryRevenuePlate;
					break;
				case 3:
					currentSureIntegralProject = marchRevenue;
					currentSureIntegralPlate = marchRevenuePlate;
					break;
				case 4:
					currentSureIntegralProject = aprilRevenue;
					currentSureIntegralPlate = aprilRevenuePlate;
					break;
				case 5:
					currentSureIntegralProject = mayRevenue;
					currentSureIntegralPlate = mayRevenuePlate;
					break;
				case 6:
					currentSureIntegralProject = juneRevenue;
					currentSureIntegralPlate = juneRevenuePlate;
					break;
				case 7:
					currentSureIntegralProject = julyRevenue;
					currentSureIntegralPlate = julyRevenuePlate;
					break;
				case 8:
					currentSureIntegralProject = augustRevenue;
					currentSureIntegralPlate = augustRevenuePlate;
					break;
				case 9:
					currentSureIntegralProject = septemberRevenue;
					currentSureIntegralPlate = septemberRevenuePlate;
					break;
				case 10:
					currentSureIntegralProject = octoberRevenue;
					currentSureIntegralPlate = octoberRevenuePlate;
					break;
				case 11:
					currentSureIntegralProject = novemberRevenue;
					currentSureIntegralPlate = novemberRevenuePlate;
					break;
				case 12:
					currentSureIntegralProject = decemberRevenue;
					currentSureIntegralPlate = decemberRevenuePlate;
					break;

				default:
					break;
				}
				map.put("totalSureIntegralProject", totalSureIntegralProject);
				map.put("currentSureIntegralProject", currentSureIntegralProject);
				map.put("totalSureIntegralPlate", totalSureIntegralPlate);
				map.put("currentSureIntegralPlate", currentSureIntegralPlate);
				sureIntegralMap.put(plateId,map);
			}
		}
		return sureIntegralMap;
	}
	
	/**
	 * 检索本年度薪酬
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportSalary(int year,int month) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> salaryMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportOfSalaryTotal dao = new QueryReportOfSalaryTotal();
		ConditionReportOfSalaryTotal con = new ConditionReportOfSalaryTotal();
		con.setYear(year);
		BaseCollection<BaseReportOfSalaryTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportOfSalaryTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalSalary = BigDecimal.ZERO;
				BigDecimal currentSalary = BigDecimal.ZERO;
				//获取本年度每月的营收数据
				BigDecimal january = BaseHelpUtils.getBigDecimalValue(e.getJanuary());//1月
				BigDecimal february = BaseHelpUtils.getBigDecimalValue(e.getFebruary());//2月
				BigDecimal march = BaseHelpUtils.getBigDecimalValue(e.getMarch());//3月
				BigDecimal april = BaseHelpUtils.getBigDecimalValue(e.getApril());//4月
				BigDecimal may = BaseHelpUtils.getBigDecimalValue(e.getMay());//5月
				BigDecimal june = BaseHelpUtils.getBigDecimalValue(e.getJune());//6月
				BigDecimal july = BaseHelpUtils.getBigDecimalValue(e.getJuly());//7月
				BigDecimal august = BaseHelpUtils.getBigDecimalValue(e.getAugust());//8月
				BigDecimal september = BaseHelpUtils.getBigDecimalValue(e.getSeptember());//9月
				BigDecimal october = BaseHelpUtils.getBigDecimalValue(e.getOctober());//10月
				BigDecimal november = BaseHelpUtils.getBigDecimalValue(e.getNovember());//11月
				BigDecimal december = BaseHelpUtils.getBigDecimalValue(e.getDecember());//12月
				totalSalary = january.add(february).add(march).add(april).add(may).add(june)
				.add(july).add(august).add(september).add(october).add(november).add(december);
				switch (month) {
				case 1:
					currentSalary = january;
					break;
				case 2:
					currentSalary = february;
					break;
				case 3:
					currentSalary = march;
					break;
				case 4:
					currentSalary = april;
					break;
				case 5:
					currentSalary = may;
					break;
				case 6:
					currentSalary = june;
					break;
				case 7:
					currentSalary = july;
					break;
				case 8:
					currentSalary = august;
					break;
				case 9:
					currentSalary = september;
					break;
				case 10:
					currentSalary = october;
					break;
				case 11:
					currentSalary = november;
					break;
				case 12:
					currentSalary = december;
					break;

				default:
					break;
				}
				map.put("totalSalary", totalSalary);
				map.put("currentSalary", currentSalary);
				salaryMap.put(plateId,map);
			}
		}
		return salaryMap;
	}
	
	/**
	 * 检索本年度新签合同
	 * @param year
	 * @param month
	 * @return
	 * @throws SQLException
	 */
	public Map<Integer,Map<String,BigDecimal>> getReportContract(int year,int month) throws SQLException{
		Map<Integer,Map<String,BigDecimal>> contractMap = new HashMap<>();
		Map<String,BigDecimal> map = null;
		QueryReportNewContractTotal dao = new QueryReportNewContractTotal();
		ConditionReportNewContractTotal con = new ConditionReportNewContractTotal();
		con.setYear(year);
		BaseCollection<BaseReportNewContractTotal> result = dao.executeQuery(null, con);
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			for(BaseReportNewContractTotal e : result.getCollections()){
				int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
				map = new HashMap<>();
				BigDecimal totalContract = BigDecimal.ZERO;
				BigDecimal currentContract = BigDecimal.ZERO;
				//获取本年度每月的营收数据
				BigDecimal januaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getJanuaryRevenue());//1月
				BigDecimal februaryRevenue = BaseHelpUtils.getBigDecimalValue(e.getFebruaryRevenue());//2月
				BigDecimal marchRevenue = BaseHelpUtils.getBigDecimalValue(e.getMarchRevenue());//3月
				BigDecimal aprilRevenue = BaseHelpUtils.getBigDecimalValue(e.getAprilRevenue());//4月
				BigDecimal mayRevenue = BaseHelpUtils.getBigDecimalValue(e.getMayRevenue());//5月
				BigDecimal juneRevenue = BaseHelpUtils.getBigDecimalValue(e.getJuneRevenue());//6月
				BigDecimal julyRevenue = BaseHelpUtils.getBigDecimalValue(e.getJulyRevenue());//7月
				BigDecimal augustRevenue = BaseHelpUtils.getBigDecimalValue(e.getAugustRevenue());//8月
				BigDecimal septemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getSeptemberRevenue());//9月
				BigDecimal octoberRevenue = BaseHelpUtils.getBigDecimalValue(e.getOctoberRevenue());//10月
				BigDecimal novemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getNovemberRevenue());//11月
				BigDecimal decemberRevenue = BaseHelpUtils.getBigDecimalValue(e.getDecemberRevenue());//12月
				totalContract = januaryRevenue.add(februaryRevenue).add(marchRevenue).add(aprilRevenue).add(mayRevenue).add(juneRevenue)
				.add(julyRevenue).add(augustRevenue).add(septemberRevenue).add(octoberRevenue).add(novemberRevenue).add(decemberRevenue);
				switch (month) {
				case 1:
					currentContract = januaryRevenue;
					break;
				case 2:
					currentContract = februaryRevenue;
					break;
				case 3:
					currentContract = marchRevenue;
					break;
				case 4:
					currentContract = aprilRevenue;
					break;
				case 5:
					currentContract = mayRevenue;
					break;
				case 6:
					currentContract = juneRevenue;
					break;
				case 7:
					currentContract = julyRevenue;
					break;
				case 8:
					currentContract = augustRevenue;
					break;
				case 9:
					currentContract = septemberRevenue;
					break;
				case 10:
					currentContract = octoberRevenue;
					break;
				case 11:
					currentContract = novemberRevenue;
					break;
				case 12:
					currentContract = decemberRevenue;
					break;

				default:
					break;
				}
				map.put("totalContract", totalContract);
				map.put("currentContract", currentContract);
				contractMap.put(plateId,map);
			}
		}
		return contractMap;
	}
	
	
	/**
	 * 根据业务部门加载年度员工司龄数据集
	 * @param param
	 * @return
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public String onLoadYearEmpWorkYearsByDepartment(Map<String, Object> param) throws SQLException, ParseException{
		//获取年份
		int year = BaseHelpUtils.getIntValue(param, "year");
		if(year == 0){
			throw new SQLException("操作异常:年份不可为空");
		}
		//获取业务部门
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		if(BaseHelpUtils.isNullOrEmpty(plateId)){
			throw new SQLException("操作异常:业务部门不可为空");
		}
/*		Department department =new Department();
		department.setConditionPlateId("=", plateId);
		List<BaseDepartment> departmentList = department.conditionalLoad();
		if(BaseHelpUtils.isNullOrEmpty(departmentList)||departmentList.size()<=0) {
			throw new SQLException("操作异常:业务部门下归属部门为空");
		}*/
		
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR,year);
		QueryReportEmployeeWorkYearsByDepartment dao = new QueryReportEmployeeWorkYearsByDepartment();
		ConditionReportEmployeeWorkYearsByDepartment condition = new ConditionReportEmployeeWorkYearsByDepartment();
		Map<Integer,BaseReportYearEmpWorkYears> map = new HashMap<>();
		//开始遍历每一个月的数据集
		for(int month=0;month<12;month++){
			ca.set(Calendar.MONTH,month);
			Date startDate = DateUtil.getFirstDay(ca.getTime());
			Date endDate = DateUtil.getLastDay(ca.getTime());
			condition.setStartDate(startDate);
			condition.setEndDate(endDate);
			condition.setPlateId(plateId);
//			BaseCollection<BaseReportEmployeeWorkYears> result = dao.executeQuery(null, condition);
			BaseCollection<BaseReportEmployeeWorkYearsByDepartment> result = dao.executeQuery(null, condition);
			if(!BaseHelpUtils.isNullOrEmpty(result)){
				for(BaseReportEmployeeWorkYearsByDepartment e : result.getCollections()){
					BaseReportYearEmpWorkYears bean = map.get(e.getDepartmentId());
					if(BaseHelpUtils.isNullOrEmpty(bean)){
						bean = new BaseReportYearEmpWorkYears();
						bean.setPlateId(plateId);
						bean.setDepartmentId(e.getDepartmentId());
					}
					if(month == 0){
						bean.setOneInner(e.getOneInner());
						bean.setOneInnerPercent(e.getOneInnerPercent());
						bean.setThreeInner(e.getThreeInner());
						bean.setThreeInnerPercent(e.getThreeInnerPercent());
						bean.setFiveInner(e.getFiveInner());
						bean.setFiveInnerPercent(e.getFiveInnerPercent());
						bean.setTenInner(e.getTenInner());
						bean.setTenInnerPercent(e.getTenInnerPercent());
						bean.setTenAdd(e.getTenAdd());
						bean.setTenAddPercent(e.getTenAddPercent());
						bean.setTotal(e.getTotal());
					}else if(month == 1){
						bean.setOneInnerTwo(e.getOneInner());
						bean.setOneInnerPercentTwo(e.getOneInnerPercent());
						bean.setThreeInnerTwo(e.getThreeInner());
						bean.setThreeInnerPercentTwo(e.getThreeInnerPercent());
						bean.setFiveInnerTwo(e.getFiveInner());
						bean.setFiveInnerPercentTwo(e.getFiveInnerPercent());
						bean.setTenInnerTwo(e.getTenInner());
						bean.setTenInnerPercentTwo(e.getTenInnerPercent());
						bean.setTenAddTwo(e.getTenAdd());
						bean.setTenAddPercentTwo(e.getTenAddPercent());
						bean.setTotalTwo(e.getTotal());
					}else if(month == 2){
						bean.setOneInnerThree(e.getOneInner());
						bean.setOneInnerPercentThree(e.getOneInnerPercent());
						bean.setThreeInnerThree(e.getThreeInner());
						bean.setThreeInnerPercentThree(e.getThreeInnerPercent());
						bean.setFiveInnerThree(e.getFiveInner());
						bean.setFiveInnerPercentThree(e.getFiveInnerPercent());
						bean.setTenInnerThree(e.getTenInner());
						bean.setTenInnerPercentThree(e.getTenInnerPercent());
						bean.setTenAddThree(e.getTenAdd());
						bean.setTenAddPercentThree(e.getTenAddPercent());
						bean.setTotalThree(e.getTotal());
					}else if(month == 3){
						bean.setOneInnerFour(e.getOneInner());
						bean.setOneInnerPercentFour(e.getOneInnerPercent());
						bean.setThreeInnerFour(e.getThreeInner());
						bean.setThreeInnerPercentFour(e.getThreeInnerPercent());
						bean.setFiveInnerFour(e.getFiveInner());
						bean.setFiveInnerPercentFour(e.getFiveInnerPercent());
						bean.setTenInnerFour(e.getTenInner());
						bean.setTenInnerPercentFour(e.getTenInnerPercent());
						bean.setTenAddFour(e.getTenAdd());
						bean.setTenAddPercentFour(e.getTenAddPercent());
						bean.setTotalFour(e.getTotal());
					}else if(month == 4){
						bean.setOneInnerFive(e.getOneInner());
						bean.setOneInnerPercentFive(e.getOneInnerPercent());
						bean.setThreeInnerFive(e.getThreeInner());
						bean.setThreeInnerPercentFive(e.getThreeInnerPercent());
						bean.setFiveInnerFive(e.getFiveInner());
						bean.setFiveInnerPercentFive(e.getFiveInnerPercent());
						bean.setTenInnerFive(e.getTenInner());
						bean.setTenInnerPercentFive(e.getTenInnerPercent());
						bean.setTenAddFive(e.getTenAdd());
						bean.setTenAddPercentFive(e.getTenAddPercent());
						bean.setTotalFive(e.getTotal());
					}else if(month == 5){
						bean.setOneInnerSix(e.getOneInner());
						bean.setOneInnerPercentSix(e.getOneInnerPercent());
						bean.setThreeInnerSix(e.getThreeInner());
						bean.setThreeInnerPercentSix(e.getThreeInnerPercent());
						bean.setFiveInnerSix(e.getFiveInner());
						bean.setFiveInnerPercentSix(e.getFiveInnerPercent());
						bean.setTenInnerSix(e.getTenInner());
						bean.setTenInnerPercentSix(e.getTenInnerPercent());
						bean.setTenAddSix(e.getTenAdd());
						bean.setTenAddPercentSix(e.getTenAddPercent());
						bean.setTotalSix(e.getTotal());
					}else if(month == 6){
						bean.setOneInnerSeven(e.getOneInner());
						bean.setOneInnerPercentSeven(e.getOneInnerPercent());
						bean.setThreeInnerSeven(e.getThreeInner());
						bean.setThreeInnerPercentSeven(e.getThreeInnerPercent());
						bean.setFiveInnerSeven(e.getFiveInner());
						bean.setFiveInnerPercentSeven(e.getFiveInnerPercent());
						bean.setTenInnerSeven(e.getTenInner());
						bean.setTenInnerPercentSeven(e.getTenInnerPercent());
						bean.setTenAddSeven(e.getTenAdd());
						bean.setTenAddPercentSeven(e.getTenAddPercent());
						bean.setTotalSeven(e.getTotal());
					}else if(month == 7){
						bean.setOneInnerEight(e.getOneInner());
						bean.setOneInnerPercentEight(e.getOneInnerPercent());
						bean.setThreeInnerEight(e.getThreeInner());
						bean.setThreeInnerPercentEight(e.getThreeInnerPercent());
						bean.setFiveInnerEight(e.getFiveInner());
						bean.setFiveInnerPercentEight(e.getFiveInnerPercent());
						bean.setTenInnerEight(e.getTenInner());
						bean.setTenInnerPercentEight(e.getTenInnerPercent());
						bean.setTenAddEight(e.getTenAdd());
						bean.setTenAddPercentEight(e.getTenAddPercent());
						bean.setTotalEight(e.getTotal());
					}else if(month == 8){
						bean.setOneInnerNine(e.getOneInner());
						bean.setOneInnerPercentNine(e.getOneInnerPercent());
						bean.setThreeInnerNine(e.getThreeInner());
						bean.setThreeInnerPercentNine(e.getThreeInnerPercent());
						bean.setFiveInnerNine(e.getFiveInner());
						bean.setFiveInnerPercentNine(e.getFiveInnerPercent());
						bean.setTenInnerNine(e.getTenInner());
						bean.setTenInnerPercentNine(e.getTenInnerPercent());
						bean.setTenAddNine(e.getTenAdd());
						bean.setTenAddPercentNine(e.getTenAddPercent());
						bean.setTotalNine(e.getTotal());
					}else if(month == 9){
						bean.setOneInnerTen(e.getOneInner());
						bean.setOneInnerPercentTen(e.getOneInnerPercent());
						bean.setThreeInnerTen(e.getThreeInner());
						bean.setThreeInnerPercentTen(e.getThreeInnerPercent());
						bean.setFiveInnerTen(e.getFiveInner());
						bean.setFiveInnerPercentTen(e.getFiveInnerPercent());
						bean.setTenInnerTen(e.getTenInner());
						bean.setTenInnerPercentTen(e.getTenInnerPercent());
						bean.setTenAddTen(e.getTenAdd());
						bean.setTenAddPercentTen(e.getTenAddPercent());
						bean.setTotalTen(e.getTotal());
					}else if(month == 10){
						bean.setOneInnerEleven(e.getOneInner());
						bean.setOneInnerPercentEleven(e.getOneInnerPercent());
						bean.setThreeInnerEleven(e.getThreeInner());
						bean.setThreeInnerPercentEleven(e.getThreeInnerPercent());
						bean.setFiveInnerEleven(e.getFiveInner());
						bean.setFiveInnerPercentEleven(e.getFiveInnerPercent());
						bean.setTenInnerEleven(e.getTenInner());
						bean.setTenInnerPercentEleven(e.getTenInnerPercent());
						bean.setTenAddEleven(e.getTenAdd());
						bean.setTenAddPercentEleven(e.getTenAddPercent());
						bean.setTotalEleven(e.getTotal());
					}else if(month == 11){
						bean.setOneInnerTwelf(e.getOneInner());
						bean.setOneInnerPercentTwelf(e.getOneInnerPercent());
						bean.setThreeInnerTwelf(e.getThreeInner());
						bean.setThreeInnerPercentTwelf(e.getThreeInnerPercent());
						bean.setFiveInnerTwelf(e.getFiveInner());
						bean.setFiveInnerPercentTwelf(e.getFiveInnerPercent());
						bean.setTenInnerTwelf(e.getTenInner());
						bean.setTenInnerPercentTwelf(e.getTenInnerPercent());
						bean.setTenAddTwelf(e.getTenAdd());
						bean.setTenAddPercentTwelf(e.getTenAddPercent());
						bean.setTotalTwelf(e.getTotal());
					}
					map.put(e.getDepartmentId(),bean);
				}
			}
		}
		BaseCollection<BaseReportYearEmpWorkYears> backResult = new BaseCollection<>();
		List<BaseReportYearEmpWorkYears> backList = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0){
			for(int id : map.keySet()){
				backList.add(map.get(id));
			}
		}
		backResult.setCollections(backList);
		return backResult.toJSON(0,"");
	}
	
	public static void main(String[] args) throws SQLException, ParseException {
		OnReportProcess process = new OnReportProcess();
		Map<String,Object> map = new HashMap<>();
		map.put("year",2017);
		map.put("month",8);
		String back = process.onLoadYearEmpWorkYears(map);
		System.out.println(back);
		//检索本年度不含税的营收
//		Map<Integer,Map<String,BigDecimal>> revenueMap = process.getReportRevenue(2017, 7);
//		System.out.println(revenueMap);
	}
}
