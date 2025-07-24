package pomplatform.payment.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.dao.EmployeePaymentMonthDetail;
import com.pomplatform.db.dao.SalaryOfWorkYear;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.payment.bean.BaseOnLoadEmployeePayment;
import pomplatform.payment.bean.ConditionOnLoadEmployeePayment;
import pomplatform.payment.query.QueryOnLoadEmployeePayment;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;

/**
 * 
 * @author 
 */
public class ToCalculateEmployeePaymentMonth implements GenericProcessor {
	protected BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
	
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        if(!BaseHelpUtils.isNullOrEmpty(params)){
        	try {
        		int year = BaseHelpUtils.getIntValue(params.get("year"));
    			int month = BaseHelpUtils.getIntValue(params.get("month"));
    			Date currentDate = DateUtil.generateDate(year, month,1);
    			//取当月第一天
    			Date firstDay = DateUtil.createFirstDayOfMonth(year,month);
    			//取当月最后一天
    		    Date lastDate = DateUtil.getLastDay(currentDate);
    		    
    		    String first = DateUtil.formatDateString(firstDay);
    		    String last = DateUtil.formatDateString(lastDate);
    		    
    		    Employee eDao = new Employee();
    			String sql = " company_id <> 8 and (status = 0 or (status = 1 and resignation_date >= '"+ first +"')) and onboard_date <= '" + last+"'";
    			EmployeePaymentMonthDetail monthDao = new EmployeePaymentMonthDetail();
    			List<BaseEmployee> eList = eDao.conditionalLoad(sql);
    			QueryOnLoadEmployeePayment dao = new QueryOnLoadEmployeePayment();
    			SalaryOfWorkYear sDao = new SalaryOfWorkYear();
    			String employeeIds = "";
    			int count = 0;
    			//替换sql
    			KeyValuePair[] keyValues = new KeyValuePair[]{new KeyValuePair()};
    			keyValues[0].setKey("2017-08-01");
    			keyValues[0].setValue(first);
    			StringBuffer log = new StringBuffer("日志：");
    			for (BaseEmployee baseEmployee : eList) {
    				ConditionOnLoadEmployeePayment condition = new ConditionOnLoadEmployeePayment();
    				condition.setEmployeeId(baseEmployee.getEmployeeId());
    				condition.setCurrentPage(1);
    				condition.setPageLines(1);
    				BaseCollection<BaseOnLoadEmployeePayment> result = dao.executeQuery(keyValues, condition);
    				List<BaseOnLoadEmployeePayment> list = result.getCollections();
    				if (!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
    					
    					BaseOnLoadEmployeePayment e = list.get(0);
    					Date changeDate = e.getChangeDate();
    					//如果调薪日期还没到，那么用调薪之前的工资进行计算
    					if(changeDate.after(lastDate) && list.size() > 1){
    						e = list.get(1);
    					}
    					int employeeId = e.getEmployeeId();
    					// 获取当月月薪数据
    					monthDao.clear();
    					monthDao.setConditionEmployeeId("=", employeeId);
    					monthDao.setConditionYear("=", year);
    					monthDao.setConditionMonth("=", month);
    					if (monthDao.countRows() > 0) {
    						continue;
    					}
    					// 根据年份、月份、员工id获取当月工龄工资
    					sDao.clear();
    					sDao.setConditionYear("=", year);
    					sDao.setConditionMonth("=", month);
    					sDao.setConditionEmployeeId("=", employeeId);
    					BaseSalaryOfWorkYear sBean = sDao.executeQueryOneRow();
    					// 工龄工资
    					String foremanPay = "0";
    					if (!BaseHelpUtils.isNullOrEmpty(sBean)) {
    						foremanPay = BaseHelpUtils.isNullOrEmpty(sBean.getWorkMoney()) ? "0" : sBean.getWorkMoney();
    					}
    					monthDao.clear();
    					monthDao.setEmployeeId(employeeId);
    					monthDao.setYear(year);
    					monthDao.setMonth(month);
    					monthDao.setMonthPay(e.getMonthPay() != null ? e.getMonthPay() + "" : "0");
    					monthDao.setBasicProportionStr(e.getBasicProportionStr() != null ? e.getBasicProportionStr() : "0");
    					monthDao.setBasicProportion(e.getBasicProportion() != null ? e.getBasicProportion() : BigDecimal.ZERO);
    					monthDao.setMonthBasicPay(e.getMonthBasicPay() != null ? e.getMonthBasicPay() + "" : "0");
    					monthDao.setMonthPerformancePay(
    							e.getMonthPerformancePay() != null ? e.getMonthPerformancePay() + "" : "0");
    					monthDao.setForemanPay(foremanPay);
    					monthDao.setOtherSubsidy(e.getOtherSubsidy() != null ? e.getOtherSubsidy() + "" : "0");
    					monthDao.setTotalPay(e.getTotalPay() != null ? e.getTotalPay() + "" : "0");
    					monthDao.setAnnualPerformance(
    							e.getAnnualPerformance() != null ? e.getAnnualPerformance() + "" : "0");
    					monthDao.setCostAttribution(e.getCostAttribution());
    				    monthDao.save();
    					count ++;
    				}else{
    					employeeIds += baseEmployee.getEmployeeId() + ",";
    				}
    			}
    			System.out.println("---------------"+log);
    			System.out.println("未成功计算月薪的员工id-----------"+employeeIds);
    			System.out.println("计算成功人数-----------------------"+count);
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        	BaseCollection<GenericBase> bc = new BaseCollection<>();
        	return bc.toJSON(0, null);
		}else{
			return null;
		}
    }
    
}
