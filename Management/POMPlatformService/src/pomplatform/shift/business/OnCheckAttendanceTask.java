package pomplatform.shift.business;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeDayCheck;

import delicacy.common.BaseHelpUtils;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;

public class OnCheckAttendanceTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnCheckAttendanceTask.class);

    @Override
    public void run() {
        __logger.debug("开始检索昨日考勤异常人员数据");
        try {
        	//获取当前系统日期
        	Date currentDate = new Date();
        	Calendar ca = Calendar.getInstance();
        	ca.setTime(currentDate);
        	ca.add(Calendar.DAY_OF_MONTH,-1);
        	Date recordDate = ca.getTime();
        	EmployeeDayCheck dao = new EmployeeDayCheck();
        	dao.setConditionRecordDate("=",recordDate);
        	dao.setConditionStatus(">",1);//异常
        	List<BaseEmployeeDayCheck> list = dao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
        		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日");
        		for(BaseEmployeeDayCheck e : list){
        			int employeeId = e.getEmployeeId();
        			ERPWeixinUtils.sendWXMsgToUser(employeeId,String.format(WeixinStatics.MSG_ATTENDANCE,sf.format(recordDate)));
        		}
        	}
		}catch (Exception e) {
			e.printStackTrace();
		}
        
    }

}
