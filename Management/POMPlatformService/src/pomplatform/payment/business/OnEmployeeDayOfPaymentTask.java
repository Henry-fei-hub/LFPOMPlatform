package pomplatform.payment.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import delicacy.connection.ThreadConnection;

/**
 *
 * @lxf 
 */
public class OnEmployeeDayOfPaymentTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnEmployeeDayOfPaymentTask.class);

    @Override
    public void run() {
        __logger.debug("开始计算员工日薪");
        try {
        	ThreadConnection.beginTransaction();
        	//获取当前系统日期
        	Date currentDate = new Date();
        	Calendar ca = Calendar.getInstance();
        	ca.setTime(currentDate);
        	//计算上一天的日薪数据
        	ca.add(Calendar.DAY_OF_MONTH,-1);
        	currentDate = ca.getTime();
        	OnPaymentManageProcess process = new OnPaymentManageProcess();
        	process.onSalaryDayAccount(0, currentDate,currentDate);
        	ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    public static void main(String[] args) {
//    	OnEmployeeDayOfPaymentTask ss = new OnEmployeeDayOfPaymentTask();
//    	ss.run();
	}

}
