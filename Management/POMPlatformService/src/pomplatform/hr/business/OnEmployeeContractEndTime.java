package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.dao.EmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeRole;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;

/**
 *
 * @author 
 */
public class OnEmployeeContractEndTime extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnEmployeeContractEndTime.class);

    @Override
    public void run() {
        __logger.debug("开始计算时间");
        try {
        	ThreadConnection.beginTransaction();
			EmployeeContractAttachment dao = new EmployeeContractAttachment();
			Date currentDate = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(currentDate);
			c.add(Calendar.MONTH, 1);
			Date nextMonthDate = c.getTime();
			List<BaseEmployeeContractAttachment> bes = dao.conditionalLoad();
			int i = 0;
			boolean isEnd = false;
			for(BaseEmployeeContractAttachment e : bes){
				if(!BaseHelpUtils.isNullOrEmpty(e.getEndDate())){
					Date endDate = e.getEndDate();
					if(DateUtil.compareDate(currentDate, endDate)){//表示已经过期的，即合同日期小于当前系统日期
						e.setWillEnd(2);
					}else if(DateUtil.compareDate(endDate, currentDate) && DateUtil.compareDate(nextMonthDate, endDate)){//表示快过期，即合同日期在当前系统日期和当前系统后一个月时间段区间内
						e.setWillEnd(1);
						if(DateUtil.isSameDay(nextMonthDate,endDate)){//正好是一个月，提前发送通知
							isEnd = true;
							i++;
						}
					}
					dao.clear();
					dao.setDataFromBase(e);
					dao.update();
				}
			}
			if(isEnd && i > 0){
				//查找角色为 行政人事助理 的员工id 并发送合同到期提醒
				EmployeeRole emDao = new EmployeeRole();
				emDao.setConditionRoleId("=", 64);
				emDao.setConditionDepartmentId("=", 7);//人资行政部
				List<BaseEmployeeRole> roleList = emDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(roleList) && roleList.size() > 0){
					for(BaseEmployeeRole e : roleList){
						int employeeId = e.getEmployeeId();
						String str = String.format(WeixinStatics.MSG_EMPLOYEE_CONTRACT, i);
						ERPWeixinUtils.sendWXMsgToUser(employeeId, str);
					}
				}
			}
			ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
}
