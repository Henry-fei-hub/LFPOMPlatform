package pomplatform.salaryemployeeevaluationrmmor.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeMonthCheck;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluation;
import com.pomplatform.db.bean.BaseSalaryEmployeeEvaluationGrade;
import com.pomplatform.db.bean.BaseSalaryEmployeePerformance;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.SalaryEmployeeEvaluation;
import com.pomplatform.db.dao.SalaryEmployeeEvaluationGrade;
import com.pomplatform.db.dao.SalaryEmployeePerformance;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.salarydecrypt.bean.BaseDecryptEmployeePaymentMonthDetails;
import pomplatform.salarydecrypt.bean.ConditionDecryptEmployeePaymentMonthDetails;
import pomplatform.salarydecrypt.query.QueryDecryptEmployeePaymentMonthDetails;

public class CustomEmployeePerformanceProcess implements GenericProcessor{
	
	private final static String STATISTICAL_PERFORMANCE = "statisticalPerformance";//获取上一次申请的确认函的备注

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case STATISTICAL_PERFORMANCE:
				return statisticalPerformance(result);
			}
		}
		return null;
	}
	
	public static String statisticalPerformance(Map<String, Object> params) throws SQLException, ParseException{
		ThreadConnection.beginTransaction();
		int status = 1;
		String errorMsg = "";
		
		BaseCollection<BasePersonnelBusines> bc = new BaseCollection<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfM = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date happenDate = GenericBase.__getDate(params.get("searchDate"));
		Calendar cale = Calendar.getInstance();
		cale.setTime(happenDate);
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);  
		cale.set(Calendar.HOUR_OF_DAY, 0);
		cale.set(Calendar.MINUTE, 0);
		cale.set(Calendar.SECOND, 0);
		cale.set(Calendar.MILLISECOND, 0);
		Date firstDate = cale.getTime();
		cale.add(Calendar.MONTH, 1);  
        cale.set(Calendar.DAY_OF_MONTH, 0);  
        Date lastDate = cale.getTime();
		
		int year = DateUtil.getYear(happenDate);
		int month = DateUtil.getMonth(happenDate);
		int day = 1;
//		String dateStr = year + "-" + month + "-" + day;
		
		//查询出绩效的比例
		SalaryEmployeeEvaluationGrade seegDao = new SalaryEmployeeEvaluationGrade();
		seegDao.setConditionStartDate("<=", happenDate);
		seegDao.setConditionEndDate(">=", happenDate);
		seegDao.setConditionFlag("=", 1);
		List<BaseSalaryEmployeeEvaluationGrade> seegList = seegDao.conditionalLoad();
		
		Map<String, BigDecimal> seegMap = new HashMap<>();
		for (BaseSalaryEmployeeEvaluationGrade baseSalaryEmployeeEvaluationGrade : seegList) {
			seegMap.put(baseSalaryEmployeeEvaluationGrade.getGrade(), baseSalaryEmployeeEvaluationGrade.getProportion());
		}
		if(seegList.size() > 0){
			//查询出当月的绩效
			SalaryEmployeeEvaluation seeDao = new SalaryEmployeeEvaluation();
			seeDao.setConditionYear("=", year);
			seeDao.setConditionMonth("=", month);
			List<BaseSalaryEmployeeEvaluation> seeList = seeDao.conditionalLoad();
			
			//查询出当月员工的考勤
			EmployeeMonthCheck emcDao = new EmployeeMonthCheck();
			emcDao.setConditionYear("=", year);
			emcDao.setConditionMonth("=", month);
			List<BaseEmployeeMonthCheck> emcList = emcDao.conditionalLoad();
			
			//查询出当月员工的工资比例
//			EmployeePayment epDao = new EmployeePayment();
//			epDao.setConditionEnabled("=", true);
//			StringBuilder epSb = new StringBuilder();
//			epSb.append(BaseEmployeePayment.CS_CHANGE_DATE).append(" between '")
//				.append(sdfM.format(firstDate))
//				.append("' and '")
//				.append(sdfM.format(lastDate))
//				.append("'");
//			List<BaseEmployeePayment> epList = epDao.conditionalLoad(epSb.toString());
			
			QueryDecryptEmployeePaymentMonthDetails dao = new QueryDecryptEmployeePaymentMonthDetails();
			dao.setCurrentPage(0);
			dao.setPageLines(1);
			ConditionDecryptEmployeePaymentMonthDetails epC = new ConditionDecryptEmployeePaymentMonthDetails();
			epC.setYear(year);
			epC.setMonth(month);
			BaseCollection<BaseDecryptEmployeePaymentMonthDetails> result = dao.executeQuery( null, epC) ;
			List<BaseDecryptEmployeePaymentMonthDetails> epList = result.getCollections();
			
			//查询出需要进行统计的所有
			PersonnelBusines pbDao = new PersonnelBusines();
			pbDao.setConditionIsCompleted("=", true);
			pbDao.setConditionProcessType("=", 25);//离职申请
			pbDao.setConditionEndDate(">", firstDate);
			List<BasePersonnelBusines> pbList = pbDao.conditionalLoad();
			String ids = "";
			for (int i = 0; i < pbList.size(); i++) {
				if(i != 0){
					ids += ",";
				}
				ids += pbList.get(i).getEmployeeId();
			}
			Employee eDao = new Employee();
//			eDao.setConditionStatus("=", 0);
			String sql = "";
			if(!BaseHelpUtils.isNullOrEmpty(ids)){
				sql = " (1 = 1 or employee_id in (" + ids +")) ";
			}
			if(!BaseHelpUtils.isNullOrEmpty(ids)){
				sql += " and ";
			}
			sql += " company_id <> 8 and (status = 0 or (status = 1 and resignation_date >= '"
					+ sdf.format(firstDate)+ "')) and onboard_date <= '"+ sdf.format(lastDate)+ "' ";
			List<BaseSalaryEmployeePerformance> sepList = new ArrayList<>();
			List<BaseEmployee> eList = eDao.conditionalLoad(sql);
			for (BaseEmployee baseEmployee : eList) {
				Integer employeeId = baseEmployee.getEmployeeId();
				String grade = "A";//等级
				BigDecimal prp = new BigDecimal("1");//比例
				BigDecimal shouldDays = BigDecimal.ZERO;//应到天数
				BigDecimal factDays = BigDecimal.ZERO;//实到天数
				BigDecimal WorkingCoefficient = BigDecimal.ZERO;//工作系数
				//获取该员工当前月考核等级
				BaseSalaryEmployeeEvaluation tmpEeBean = getSalaryEmployeeEvaluation(seeList, employeeId);
				if(null != tmpEeBean){
					grade = tmpEeBean.getGrade();
				}
				if(null != seegMap.get(grade)){
					prp = seegMap.get(grade);
				}
				
				//设置值
				BaseSalaryEmployeePerformance sepBean = new BaseSalaryEmployeePerformance();
				sepBean.setEmployeeId(employeeId);
				sepBean.setEmployeeNo(baseEmployee.getEmployeeNo());
				sepBean.setDepartmentId(baseEmployee.getDepartmentId());
				sepBean.setPlateId(baseEmployee.getPlateId());
				sepBean.setCompanyId(baseEmployee.getCompanyId());
				sepBean.setStatus(baseEmployee.getStatus());
				sepBean.setYear(year);
				sepBean.setMonth(month);
				sepBean.setGrade(grade);
				sepBean.setProportion(prp);
				sepBean.setHappenDate(happenDate);
				//获取员工考勤数据
				BaseEmployeeMonthCheck tmpEmcBean = getEmployeeMonthlyCheck(emcList, employeeId);
				if(null != tmpEmcBean){
					shouldDays = tmpEmcBean.getShouldDays();
					factDays = tmpEmcBean.getFactDays();
					sepBean.setShouldDays(shouldDays);
					sepBean.setFactDays(factDays);
				}
				//获取员工工资 ，计算工作系数 与实发绩效
				BaseDecryptEmployeePaymentMonthDetails tmpEpBean = getEmployeePayment(epList, employeeId);
				if(null != tmpEpBean){
					sepBean.setBasicProportion(tmpEpBean.getBasicProportion());
					sepBean.setBasicProportionStr(tmpEpBean.getBasicProportionStr());
					sepBean.setMonthPay(tmpEpBean.getMonthPay());
					sepBean.setMonthBasicPay(tmpEpBean.getMonthBasicPay());
					sepBean.setMonthPerformancePay(tmpEpBean.getMonthPerformancePay());
					//计算工作系数
					if(baseEmployee.getIsCheck() || baseEmployee.getStatus() == 1){
						if(shouldDays.compareTo(BigDecimal.ZERO) > 0 && factDays.compareTo(BigDecimal.ZERO) > 0){
							WorkingCoefficient = factDays.divide(shouldDays, 2, BigDecimal.ROUND_HALF_UP);
						}
					}else{
						WorkingCoefficient = new BigDecimal("1");
					}
					
					//计算实发绩效
					if(null != tmpEpBean.getMonthPerformancePay()){
						sepBean.setActualPerformancePay(WorkingCoefficient.multiply(prp.multiply(tmpEpBean.getMonthPerformancePayDecrypt())));
					}
					
				}
				sepBean.setWorkingCoefficient(WorkingCoefficient);
				sepList.add(sepBean);
			}
			//删除与插入数据
			if(sepList.size() > 0){
				SalaryEmployeePerformance sepDao = new SalaryEmployeePerformance();
				sepDao.setConditionYear("=", year);
				sepDao.setConditionMonth("=", month);
				sepDao.conditionalDelete();
				sepDao.save(sepList);
			}
		}else{
			status = -1;
			errorMsg = "请配置考核等级与实际系数的比例";
		}
		ThreadConnection.commit();
		return bc.toJSON(status, errorMsg);
	}
	
	public static BaseDecryptEmployeePaymentMonthDetails getEmployeePayment(List<BaseDecryptEmployeePaymentMonthDetails> list, Integer employeeId){
		for (BaseDecryptEmployeePaymentMonthDetails baseEmployeePayment : list) {
			if(Objects.equals(baseEmployeePayment.getEmployeeId(), employeeId)){
				return baseEmployeePayment;
			}
		}
		return null;
		
	}
	
	public static BaseEmployeeMonthCheck getEmployeeMonthlyCheck(List<BaseEmployeeMonthCheck> emcList, Integer employeeId){
		for (BaseEmployeeMonthCheck baseEmployeeMonthlyCheck : emcList) {
			if(Objects.equals(baseEmployeeMonthlyCheck.getEmployeeId(), employeeId)){
				return baseEmployeeMonthlyCheck;
			}
		}
		return null;
	}
	
	public static BaseSalaryEmployeeEvaluation getSalaryEmployeeEvaluation(List<BaseSalaryEmployeeEvaluation> list, Integer employeeId){
		for (BaseSalaryEmployeeEvaluation baseSalaryEmployeeEvaluation : list) {
			if(Objects.equals(baseSalaryEmployeeEvaluation.getEmployeeId(), employeeId)){
				return baseSalaryEmployeeEvaluation;
			}
		}
		return null;
	}
	
	
	public static void main(String[] args) throws SQLException, ParseException {
//		Map<String, Object> params = new HashMap<>();
//		params.put("searchDate", "2017-07-15");
//		statisticalPerformance(params);
//		// 获取当月第一天和最后一天  
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//        String firstday, lastday;  
//        // 获取前月的第一天  
//        Calendar cale = Calendar.getInstance();  
//        cale.add(Calendar.MONTH, 0);  
//        cale.set(Calendar.DAY_OF_MONTH, 1);  
//        firstday = format.format(cale.getTime());  
//        // 获取前月的最后一天  
//        cale = Calendar.getInstance();  
//        cale.add(Calendar.MONTH, 1);  
//        cale.set(Calendar.DAY_OF_MONTH, 0);  
//        lastday = format.format(cale.getTime());  
//        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);  
	}
}
