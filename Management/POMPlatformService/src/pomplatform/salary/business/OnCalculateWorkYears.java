package pomplatform.salary.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.dao.SalaryOfWorkYear;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 *
 * @author 
 */
public class OnCalculateWorkYears extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnCalculateWorkYears.class);

    @Override
    public void run() {
        __logger.debug("开始计算司龄");
        try {
    		//获取当前系统日期
        	Date currentDate = new Date();
			if(DateUtil.isFirstDayOfMonthToday()){
				/**
				 * 计算规则,计算本月工龄工资需参考上月的工龄工资
				 * a.如果已满8年工龄的员工，则本月工龄工资为上月工龄工资
				 * b.如果未满8年工龄的员工，按工龄工资状态计算单年的工龄工资1:年薪制(没有工龄工资);2:经理级(每年150);3:普通员工(每年100)
				 * 即本月工龄工资=上月工龄工资+单年工龄工资
				 */
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
				//获取年月份
				int year = DateUtil.getYear(currentDate);
				int month = DateUtil.getMonth(currentDate);
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
					}else{
						dao.setWorkYears(workTime+"年");
						dao.setWorkMoney(workMoney+"");
						dao.conditionalUpdate();
					}
				}
				ThreadConnection.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
    
    public static void main(String[] args) {
//    	OnCalculateWorkYears ss = new OnCalculateWorkYears();
//    	ss.run();
	}
}
