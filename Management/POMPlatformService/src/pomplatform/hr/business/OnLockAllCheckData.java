package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeMonthCheck;

import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;

/**
 *
 * @author 
 */
public class OnLockAllCheckData extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLockAllCheckData.class);

    @Override
    public void run() {
        __logger.debug("每月5号晚上12点加锁所有员工上月考勤数据");
        try {
        	ThreadConnection.beginTransaction();
        	if(DateUtil.getDay() == 6){//获取当前日期，如果是6号（5号晚上12点即为6号），对考勤数据加锁
        		int month = DateUtil.getMonth();//获取当前月
        		int lastMonth = 0;//上个月
        		int year = DateUtil.getYear();
        		if(month == 1){
        			lastMonth = 12;
        			year--;
        		}else{
        			lastMonth = month - 1;
        		}
        		if(lastMonth > 0){
        			//加锁上月考勤详情数据
        			EmployeeDayCheck ddao = new EmployeeDayCheck();
        			ddao.setConditionYear("=", year);
        			ddao.setConditionMonth("=", lastMonth);
        			ddao.setConditionIsLocked("=", Boolean.FALSE);
        			ddao.setIsLocked(true);
        			ddao.conditionalUpdate();
        			
        			//加锁上月考勤总表数据
        			EmployeeMonthCheck mdao = new EmployeeMonthCheck();
        			mdao.setConditionYear("=", year);
        			mdao.setConditionMonth("=", lastMonth);
        			mdao.setConditionIsLocked("=", Boolean.FALSE);
        			mdao.setIsLocked(true);
        			mdao.conditionalUpdate();
        		}
        	}
			ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
    
    public static void main(String[] args) {
    	OnLockAllCheckData ss = new OnLockAllCheckData();
    	ss.run();
	}
}
