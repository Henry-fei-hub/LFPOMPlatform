package pomplatform.shift.business;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;

/**
 *
 * @author 
 */
public class OnShiftAccountTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnShiftAccountTask.class);

    @Override
    public void run() {
        __logger.debug("开始计算考勤数据");
        try {
        	//获取当前系统日期
        	Date currentDate = new Date();
        	Calendar ca = Calendar.getInstance();
        	ca.setTime(currentDate);
        	//获取时间点，如果是7点之前，则计算上一天的考勤数据，如果是之后，则计算当天的考勤数据
        	int hours = ca.get(Calendar.HOUR_OF_DAY);
        	if(hours < 7){//计算上一天的考勤数据
        		ca.add(Calendar.DAY_OF_MONTH,-1);
        		currentDate = ca.getTime();
        	}
        	//获取当前日期的年月份
        	int year = DateUtil.getYear(currentDate);
        	int month = DateUtil.getMonth(currentDate);
        	//计算日考勤数据
        	OnShiftManageProcess.processCheckData(currentDate,currentDate,0,year,month);
        	//计算月考勤数据
        	OnShiftManageProcess.employeeCheckMonthAccount(currentDate,currentDate,year, month,0);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    
    public static void main(String[] args) throws Exception {
    	ThreadConnection.beginTransaction();
    	//获取当前系统日期
    	Date currentDate = new Date();
    	Calendar ca = Calendar.getInstance();
    	ca.setTime(currentDate);
    	//获取时间点，如果是7点之前，则计算上一天的考勤数据，如果是之后，则计算当天的考勤数据
    	int hours = ca.get(Calendar.HOUR_OF_DAY);
    	if(hours < 7){//计算上一天的考勤数据
    		ca.add(Calendar.DAY_OF_MONTH,-1);
    		currentDate = ca.getTime();
    	}
    	System.out.println("currentDate==="+currentDate);
    	//获取当前日期的年月份
    	int year = DateUtil.getYear(currentDate);
    	int month = DateUtil.getMonth(currentDate);
    	System.out.println("year==="+year);
    	System.out.println("month==="+month);
    	//计算日考勤数据
    	OnShiftManageProcess.processCheckData(currentDate,currentDate,0,year,month);
    	//计算月考勤数据
    	OnShiftManageProcess.employeeCheckMonthAccount(currentDate,currentDate,year, month,0);
    	ThreadConnection.commit();
	}

}
