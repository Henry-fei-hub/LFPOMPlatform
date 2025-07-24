package delicacy.employeePlate;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;

import delicacy.common.BaseHelpUtils;
import delicacy.date.util.DateUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;

public class EmployeePlateRecordSyncTask extends TimerTask {

    private static final Logger __logger = Logger.getLogger(EmployeePlateRecordSyncTask.class);

    @Override
    public void run() {
        if (DateUtil.isFirstDayOfMonthToday()) {
            try {
                __logger.debug("每月1号记录所有在职员工的所属业务部门到employee_change_plate_records表中");
                Employee employeeDao = new Employee();
                employeeDao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
                List<BaseEmployee> list = employeeDao.conditionalLoad();
                Calendar date = Calendar.getInstance();
                if (!BaseHelpUtils.isNullOrEmpty(list)) {
                	EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
                	dao.setConditionYear("=", date.get(Calendar.YEAR));
                	dao.setConditionMonth("=", date.get(Calendar.MONTH) + 1);
                	List<BaseEmployeeChangePlateRecord> data = dao.conditionalLoad();
                	Set<Integer> employeeIds = new HashSet<>();
                	for(BaseEmployeeChangePlateRecord bean : data){
                		if(null != bean.getEmployeeId())
                			employeeIds.add(bean.getEmployeeId());
                	}
                    List<BaseEmployeeChangePlateRecord> saveList = new ArrayList<>();
                    for (BaseEmployee bean : list) {
                    	if(employeeIds.contains(bean.getEmployeeId()))
                    		continue;
                        BaseEmployeeChangePlateRecord obj = new BaseEmployeeChangePlateRecord();
                        obj.setEmployeeId(bean.getEmployeeId());
                        obj.setYear(date.get(Calendar.YEAR));
                        obj.setMonth(date.get(Calendar.MONTH) + 1);
                        obj.setPlateId(bean.getPlateId());
                        obj.setChangePlateDate(date.getTime());
                        obj.setCreateTime(date.getTime());
                        obj.setUpdateTime(date.getTime());
                        //将当时的部门id同步过去
                        obj.setDepartmentId(bean.getDepartmentId());
                        saveList.add(obj);
                    }
                    
                    dao.save(saveList);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
