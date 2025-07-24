package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import pomplatform.shift.business.OnShiftManageProcess;

/**
 *
 * @author 
 */
public class OnCalculateAllCheckData extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnCalculateAllCheckData.class);

    @Override
    public void run() {
        __logger.debug("每月5号晚上11点计算所有员工上月考勤数据");
        try {
        	if(DateUtil.getDay() == 5){//获取当前日期，如果是5号晚上11点，对考勤数据计算
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
        			OnShiftManageProcess ss = new OnShiftManageProcess();
        			Map<String,Object> param = new HashMap<>();
        			param.put("year", year);
        			param.put("month", lastMonth);
        			ss.onEmployeeMonthCheck(param);
        		}
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
    
    public static void main(String[] args) {
    	OnCalculateAllCheckData ss = new OnCalculateAllCheckData();
    	ss.run();
	}
}
