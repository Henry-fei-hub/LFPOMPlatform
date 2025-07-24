package pomplatform.salary.business;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;

/**
 * 更新司龄和年龄
 * @author liubin
 *
 */
public class OnCalculateForemanAndAge extends TimerTask {
	
	private static final Long YEARTIME = 365*24*60*60*1000l;
	private static final Long MONTHTIME = 30*24*60*60*1000l;
	@Override
	public void run() {
		try {
			ThreadConnection.beginTransaction();
			//检索每一个员工更新司龄和年龄
			Employee employeesDao = new Employee();
//			employeesDao.setConditionEmployeeId("=",2257);
			employeesDao.setConditionStatus("=",0);//只检索在职的
 			List<BaseEmployee> employees = employeesDao.conditionalLoad();
			if (employees.size() <= 0) {
				throw new SQLException("数据查询异常");
			}
			//遍历所有的员工计算员工的司龄和年龄
			for (BaseEmployee baseEmployee : employees) {
				employeesDao.clear();
				//获取员工的出生日期
				Date birth = baseEmployee.getBirth();
				//获取员工的入职日期
				Date onboardDate = baseEmployee.getOnboardDate();
				Long currentTime = System.currentTimeMillis();
				//计算年龄
				if (!BaseHelpUtils.isNullOrEmpty(birth)) {
					Long birthTime = birth.getTime();
					Long tempTime1 = currentTime - birthTime;
					int age = (int)(tempTime1 / YEARTIME );
//					baseEmployee.setAge(age);
					employeesDao.setAge(age);
				}
				//计算司龄
				if (!BaseHelpUtils.isNullOrEmpty(onboardDate)) {
					Long onboardDateTime = onboardDate.getTime();
					Long tempTime2 = currentTime - onboardDateTime;
					int ss1 = (int)(tempTime2 / MONTHTIME);
					//计算年分
					int year = ss1 / 12;
					//计算月
					int month = ss1 % 12;
//					baseEmployee.setForeman(year+"年"+month+"月");
					employeesDao.setForeman(year+"年"+month+"月");
				}
				employeesDao.setConditionEmployeeId("=", baseEmployee.getEmployeeId());
				employeesDao.conditionalUpdate();
//				employeesDao.setDataFromBase(baseEmployee);
//				employeesDao.update();
			}
			ThreadConnection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			ThreadConnection.rollback();
		}
	}
	
	
	public static void main(String[] args) {
		OnCalculateForemanAndAge ss = new OnCalculateForemanAndAge();
		ss.run();
	}

}
	

