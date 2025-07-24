package pomplatform.salary.business;

import java.io.StringReader;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryOfWorkYear;

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
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;

/**
 * 
 * @author 
 */
public class ToCalculateWorkYears implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");
	protected BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
	
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        if(!BaseHelpUtils.isNullOrEmpty(params)){
        	//获取年月份
			int year = BaseHelpUtils.getIntValue(params.get("year"));
			int month = BaseHelpUtils.getIntValue(params.get("month"));
			Date currentDate = DateUtil.getLastDay(DateUtil.generateDate(year, month,1));
			
			int i = 0,j = 0;
			SalaryOfWorkYear dao = new SalaryOfWorkYear();
			//获取上一个月年月份
			Calendar ca = Calendar.getInstance();
			ca.setTime(currentDate);
			ca.add(Calendar.MONTH, -1);
			int lastYear = ca.get(Calendar.YEAR);
			int lastMonth = ca.get(Calendar.MONTH)+1;
			//获取上一个月所有员工的工龄工资
			dao.setConditionYear("=",lastYear);
			dao.setConditionMonth("=",lastMonth);
			List<BaseSalaryOfWorkYear> lastResult = dao.conditionalLoad();
			//定义map存放所有员工上月的工龄工资
			Map<Integer,Integer> workMontyMap = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(lastResult) && lastResult.size() > 0){
				for(BaseSalaryOfWorkYear e : lastResult){
					int employeeId = e.getEmployeeId();
					int workMoney = BaseHelpUtils.getIntValue(e.getWorkMoney());
					workMontyMap.put(employeeId,workMoney);
				}
			}
			
			int posiMonth,posiYear,workMoney=0,workTime=0,lastWorkTime = 0;
			BaseSalaryOfWorkYear result;
			Employee eDao = new Employee();
			eDao.setConditionEmployeeId(">",0);
			eDao.setConditionStatus("=",0);//只检索在职的
			List<BaseEmployee> bes = eDao.conditionalLoad("order by "+BaseEmployee.CS_EMPLOYEE_NO+" asc");
			ThreadConnection.beginTransaction();
			for(BaseEmployee e : bes){
				int employeeId = e.getEmployeeId();
				//获取转正日期
				Date positiveDate = e.getPositiveDate();
				if(!BaseHelpUtils.isNullOrEmpty(positiveDate)){
					posiMonth = DateUtil.getMonth(positiveDate);
					posiYear = DateUtil.getYear(positiveDate);
					//根据转正日期计算上一个月的工龄
					lastWorkTime = lastYear - posiYear;
					if(lastMonth < posiMonth){
						lastWorkTime -= 1;
					}
					if(lastWorkTime < 0){
						lastWorkTime = 0;
					}
					//根据转正日期计算上本月的工龄
					workTime = year - posiYear;
					if(month < posiMonth){
						workTime -= 1;
					}
					if(workTime < 0){
						workTime = 0;
					}
					//获取上月的工龄工资
					int lastWorkMoney = BaseHelpUtils.getIntValue(workMontyMap.get(employeeId));
					//获取工龄工资状态:1:年薪制(没有工龄工资);2:经理级(每年150);3:普通员工(每年100)
					int workYearType = BaseHelpUtils.getIntValue(e.getWorkYearType());
					/**
					 * a.如果上月计算的工龄==本月计算的工龄，则本月工龄工资==上月工龄工资
					 * b.如果工龄满8年了，则本月工龄工资==上月工龄工资
					 * c.如果工龄工资类型小于2，说明是年薪制的高管或者没设置的工龄工资状态的员工，则本月工龄工资==上月工龄工资
					 */
					if(lastWorkTime == workTime || workTime > 8 || workYearType < 2){
						workMoney = lastWorkMoney;
					}else{
						//计算正常员工的工龄工资
						if(workYearType == 2){//经理级，则本月工龄工资==上月工龄工资+单年工龄工资(150)
							workMoney = lastWorkMoney + 150;
						}else if(workYearType == 3){//普通员工，则本月工龄工资==上月工龄工资+单年工龄工资(100)
							workMoney = lastWorkMoney + 100;
						}
					}
				}else{
					workMoney = 0;
				}
				dao.clear();
				dao.setConditionEmployeeId("=",employeeId);
				dao.setConditionYear("=", year);
				dao.setConditionMonth("=", month);
				result = dao.executeQueryOneRow();
				//如果没有该年该月记录，则插入该月工龄工资记录
				if(BaseHelpUtils.isNullOrEmpty(result)){
					dao.setEmployeeId(employeeId);
					dao.setYear(year);
					dao.setMonth(month);
					dao.setWorkYears(workTime+"年");
					dao.setWorkMoney(workMoney+"");
					dao.save();
					i++;
				}else{
					dao.setWorkYears(workTime+"年");
					dao.setWorkMoney(workMoney+"");
					dao.conditionalUpdate();
					j++;
				}
			}
			__logger.info("dd----------------------"+i+"  "+j);
			ThreadConnection.commit();
        	BaseCollection<GenericBase> bc = new BaseCollection<>();
        	return bc.toJSON(0, null);
		}else{
			return null;
		}
    }
    
}
