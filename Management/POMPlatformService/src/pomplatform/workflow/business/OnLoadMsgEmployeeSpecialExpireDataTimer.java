package pomplatform.workflow.business;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.apache.log4j.Logger;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialExpireData;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordsor;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialExpireData;
import pomplatform.specialDeduction.query.QueryMspecialdeductionrecordsor;
import pomplatform.specialDeduction.query.QueryOnLoadSpecialExpireData;

/**
 *
 * @author 
 */
public class OnLoadMsgEmployeeSpecialExpireDataTimer extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnLoadMsgEmployeeSpecialExpireDataTimer.class);
	
    @SuppressWarnings("deprecation")
	public void run() {
    	 __logger.debug("每月1号中午10点计算所有员工");
		try {
			if(DateUtil.getDay() == 10){//获取当前日期，如果是10号14点则执行
			Date currentDate = new Date();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat simpleDateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat("yyyy-MM");
			int year = currentDate.getYear()+1900;
			int month = currentDate.getMonth() + 2;
			// 查询员工本年度申请得专项扣除
			QueryOnLoadSpecialExpireData qmdDao = new QueryOnLoadSpecialExpireData();
			ConditionOnLoadSpecialExpireData qmdCondition = new ConditionOnLoadSpecialExpireData();
			// 本年度
			qmdCondition.setYear(year + "");
			if(month<10) {
				qmdCondition.setMonth("0"+month);
			}else {
				// 下个月
				qmdCondition.setMonth(month + "");
			}
			// 流程完成
			qmdCondition.setProcessStatus(3);
			// 获取在职员工集合
			Employee eDao = new Employee();
			eDao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
//			eDao.setConditionEmployeeId("=", 2415);
			List<BaseEmployee> employeeList = eDao.conditionalLoad();
			//如果是12进行月跨年通知
			if(month==13) {
				Object[] employeeIds = new Object[employeeList.size()];
				for (int i = 0; i < employeeList.size(); i++) {
					employeeIds[i] = BaseHelpUtils.getIntValue(employeeList.get(i).getEmployeeId());
				}
				// 消息通知内容
				StringBuffer str = new StringBuffer();
				Integer newYear = year+1;
				String str2 = String.format(WeixinStatics.MSG_EMPLOYEE_SPECIAL_EXPIRE_NOTICE, year,newYear,year);
				ERPWeixinUtils.sendWXMsgToUser(str2, employeeIds);
				
			}else {//其余月份进行到期通知
				for (BaseEmployee baseEmployee : employeeList) {
					Integer employeeId = BaseHelpUtils.getIntValue(baseEmployee.getEmployeeId());
					String employeeName =baseEmployee.getEmployeeName();
					// 申请人id
					qmdCondition.setEmployeId(employeeId);
					BaseCollection<BaseOnLoadSpecialExpireData> qmdResult = qmdDao.executeQuery(null, qmdCondition);
					if (!BaseHelpUtils.isNullOrEmpty(qmdResult) && qmdResult.getCollections().size() > 0) {
						// 消息通知内容
						StringBuffer str = new StringBuffer();
						str.append("您好，");
						str.append(employeeName);
						str.append("，您的" + year + "年度的专项扣除：");
						List<BaseOnLoadSpecialExpireData> specialList = qmdResult.getCollections();
						for (BaseOnLoadSpecialExpireData baseOnLoadSpecialExpireData : specialList) {
							// 专项类型
							Integer specialDeductionTypeId = baseOnLoadSpecialExpireData.getSpecialDeductionTypeId();
							String specialDeductionTypeName = baseOnLoadSpecialExpireData.getSpecialDeductionTypeName();
							// 有效结束时间
							String endDate = simpleDateFormat4.format(baseOnLoadSpecialExpireData.getEndDate());
							str.append(specialDeductionTypeName);
							str.append("将于" + endDate + "失效");
							str.append(",");
						}
						str.append("请根据实际情况及时申请符合要求的专项扣除。");
						ERPWeixinUtils.sendWXMsgToUser(employeeId, str.toString());
					}
				}
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    public static void main(String[] args) throws Exception {
    	OnLoadMsgEmployeeSpecialExpireDataTimer query =new OnLoadMsgEmployeeSpecialExpireDataTimer();
    	query.run();
	}
    
}
