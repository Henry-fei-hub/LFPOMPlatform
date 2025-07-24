package pomplatform.hr.business;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeDayPlateRecord;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.bonusPayment.bean.BaseMemployeeaccountrecordeeeor;
import pomplatform.bonusPayment.bean.ConditionMemployeeaccountrecordeeeor;
import pomplatform.bonusPayment.query.QueryMemployeeaccountrecordeeeor;

/**
 *
 * @author 
 */
public class OnAddEmployeeDayPlateRecord extends TimerTask {

    private static final Logger __logger = Logger.getLogger(OnAddEmployeeDayPlateRecord.class);

    @Override
    public void run() {
        __logger.debug("新增员工每日所在业务部门记录");
        try {
        	Employee edao = new Employee();
        	edao.setConditionStatus("=", 0);
        	edao.setConditionEmployeeId(">",0);
        	List<BaseEmployee> list = edao.conditionalLoad();
        	
        	EmployeeDayPlateRecord dao = new EmployeeDayPlateRecord();
        	BaseEmployeeDayPlateRecord bean = new BaseEmployeeDayPlateRecord();
        	
        	Date currentDate = new Date();
        	Calendar cal = Calendar.getInstance();
        	cal.setTime(currentDate);
        	int year = cal.get(Calendar.YEAR);
        	int month = cal.get(Calendar.MONTH)+1;
        	
        	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
        		for(BaseEmployee e : list){
        			int employeeId = e.getEmployeeId();
        			dao.clear();
        			dao.setConditionEmployeeId("=", employeeId);
        			dao.setConditionRecordDate("=", currentDate);
        			bean = dao.executeQueryOneRow();
        			if(!BaseHelpUtils.isNullOrEmpty(bean)){
        				bean.setEmployeeId(employeeId);
        				bean.setEmployeeNo(e.getEmployeeNo());
        				bean.setEmployeeName(e.getEmployeeName());
        				bean.setCompanyId(e.getCompanyId());
        				bean.setPlateId(e.getPlateId());
        				bean.setDepartmentId(e.getDepartmentId());
        				bean.setOnboardStatus(e.getOnboardStatus());
        				bean.setRecordDate(currentDate);
        				bean.setYear(year);
        				bean.setMonth(month);
        				dao.clear();
        				dao.setDataFromBase(bean);
        				dao.update();
        			}else{
        				bean = new BaseEmployeeDayPlateRecord();
        				bean.setEmployeeId(employeeId);
        				bean.setEmployeeNo(e.getEmployeeNo());
        				bean.setEmployeeName(e.getEmployeeName());
        				bean.setCompanyId(e.getCompanyId());
        				bean.setPlateId(e.getPlateId());
        				bean.setDepartmentId(e.getDepartmentId());
        				bean.setOnboardStatus(e.getOnboardStatus());
        				bean.setRecordDate(currentDate);
        				bean.setYear(year);
        				bean.setMonth(month);
        				dao.clear();
        				dao.setDataFromBase(bean);
        				dao.save();
        			}
        		}
        	}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
        
    }
    
    public static void main(String[] args) {
    	
    	
    }
}
