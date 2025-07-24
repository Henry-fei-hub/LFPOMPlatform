package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.EmployeePayment;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.PersonnelBusines;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.dao.Employee;
import pomplatform.clocks.business.ClockMsgProcess;
import pomplatform.common.utils.AccountUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.shift.business.OnShiftManageProcess;

/**
 *
 * @author 
 */
public class OnCloseResignationEmpAccount extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnCloseResignationEmpAccount.class);

    @Override
    public void run() {
        __logger.debug("开始查看离职人员并关闭账号");
        try {
        	ThreadConnection.beginTransaction();
        	PersonnelBusines dao = new PersonnelBusines();
        	dao.setConditionIsCompleted("=", Boolean.TRUE);
        	dao.setConditionProcessType("=", 25);//查找已完成离职流程的员工
        	List<BasePersonnelBusines> list = dao.conditionalLoad();
        	if(!BaseHelpUtils.isNullOrEmpty(list)){
        		Date currentDate = new Date();
        		Employee employeeDao = new Employee();
        		EmployeePayment epDao = new EmployeePayment();
        		EmployeeDayCheck dayCheckDao = new EmployeeDayCheck();
        		EmployeeMonthCheck monthCheckDao = new EmployeeMonthCheck();
        		EmployeeRole rDao = new EmployeeRole();
        		//当离职员工离职后，自动补全离职当前月的每一天的日归属部门
        		EmployeeDayPlateRecord edprDao = new EmployeeDayPlateRecord();
        		Date endDate = null;
        		for(BasePersonnelBusines e : list){
        			int employeeId = e.getEmployeeId();
        			//离职日期
        			Date resignationDate = e.getEndDate();
        			employeeDao.clear();
        			employeeDao.setEmployeeId(employeeId);
        			if(employeeDao.load()){
        				//如果离职日期为今天，或者 离职日期小于今天，但状态为在职的人员，执行关闭账号操作
        				if(DateUtil.isSameDay(currentDate,resignationDate) || 
        						(e.getEndDate().before(currentDate) && employeeDao.getStatus() == 0)){
        					//设置结束日期，即为当前月最后一天
        					endDate = DateUtil.getLastDay(resignationDate);
        					//获取员工所属业务部门，归属部门和公司
        					int plateId = BaseHelpUtils.getIntValue(employeeDao.getPlateId());
        					int departmentId = BaseHelpUtils.getIntValue(employeeDao.getDepartmentId());
        					int companyId = BaseHelpUtils.getIntValue(employeeDao.getCompanyId());
        					String employeeName = BaseHelpUtils.getString(employeeDao.getEmployeeName());
        					String employeeNo = BaseHelpUtils.getString(employeeDao.getEmployeeNo());
        					int onboardStatus = BaseHelpUtils.getIntValue(employeeDao.getOnboardStatus());
        					//获取离职日期的年份和月份
        					int year = DateUtil.getYear(resignationDate);
        					int month = DateUtil.getMonth(resignationDate);
        					for(Date recordDate = resignationDate; recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
        						edprDao.clear();
        						edprDao.setConditionEmployeeId("=",employeeId);
        						edprDao.setConditionRecordDate("=",recordDate);
        						if(!edprDao.isExist()) {
        							edprDao.clear();
        							edprDao.setEmployeeId(employeeId);
        							edprDao.setRecordDate(recordDate);
        							edprDao.setPlateId(plateId);
        							edprDao.setDepartmentId(departmentId);
        							edprDao.setCompanyId(companyId);
        							edprDao.setEmployeeName(employeeName);
        							edprDao.setEmployeeNo(employeeNo);
        							edprDao.setOnboardStatus(onboardStatus);
        							edprDao.setYear(year);
        							edprDao.setMonth(month);
        							edprDao.save();
        						}
        					}
        					
        					//关闭ERP的账户
        					employeeDao.setStatus(StaticUtils.EMPLOYEE_DIMISSION);
        					employeeDao.setResignationDate(resignationDate);
        					employeeDao.update();
        					//关闭薪酬记录表数据
        					epDao.clear();
        					epDao.setConditionEmployeeId("=",employeeId);
        					epDao.setConditionEnabled("=",Boolean.TRUE);
        					if(epDao.countRows() > 0){
        						epDao.setEnabled(Boolean.FALSE);
        						epDao.conditionalUpdate();
        					}
        					//如果这个人的离职有滞后的情况，则根据这个人的离职日期，删除其离职日期之后的计算的考勤数据
        					dayCheckDao.clear();
        					dayCheckDao.setConditionEmployeeId("=",employeeId);
        					dayCheckDao.setConditionRecordDate(">",resignationDate);
        					if(dayCheckDao.countRows() > 0){
        						dayCheckDao.conditionalDelete();
        						//更新总表的数据
        						monthCheckDao.clear();
        						try {
        							OnShiftManageProcess.employeeCheckMonthAccount(resignationDate,resignationDate,year, month, employeeId);
								} catch (Exception e2) {
								}
        					}
        					try {
        						//关闭各个平台的账户
        						UserAccountUtils.deleteUserAccount(employeeId);
							} catch (Exception e2) {
							}
        					try {
        						//删除下发到考勤机的该员工的数据
        						ClockMsgProcess.deleteEmployeeOfAllClock(employeeId);
							} catch (Exception e2) {
							}
        					//删除离职员工的角色信息
        					rDao.setConditionEmployeeId("=", employeeId);
        					rDao.setConditionIsDefault("=", Boolean.FALSE);
        					rDao.conditionalDelete();
        					//注销员工的所有账户
        					AccountUtils.destoryAccount(AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, null);
        				}
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
    
    public static void main(String[] args) {
    	OnCloseResignationEmpAccount ss = new OnCloseResignationEmpAccount();
    	ss.run();
	}
}
