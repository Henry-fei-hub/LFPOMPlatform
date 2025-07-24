package pomplatform.check.handler;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import pomplatform.checking.bean.BaseEmployeeCheckStatus;
import pomplatform.checking.bean.BaseEmployeeRealtimeChecking;
import pomplatform.checking.bean.BaseEmployeeShouldAndFactCheck;
import pomplatform.checking.bean.BaseEmployeeShouldCheckinPersonNum;
import pomplatform.checking.bean.BaseEmployeecheckinPerson;
import pomplatform.checking.bean.BaseEmployeecheckinoutStatusCount;
import pomplatform.checking.bean.BaseMemployeecheckinouteeseor;
import pomplatform.checking.bean.BaseSemployeecheckinoutupdatetimeor;
import pomplatform.checking.bean.ConditionEmployeeCheckStatus;
import pomplatform.checking.bean.ConditionEmployeeRealtimeChecking;
import pomplatform.checking.bean.ConditionEmployeeShouldAndFactCheck;
import pomplatform.checking.bean.ConditionEmployeeShouldCheckinPersonNum;
import pomplatform.checking.bean.ConditionEmployeecheckinPerson;
import pomplatform.checking.bean.ConditionEmployeecheckinoutStatusCount;
import pomplatform.checking.bean.ConditionMemployeecheckinouteeseor;
import pomplatform.checking.bean.ConditionSemployeecheckinoutupdatetimeor;
import pomplatform.checking.query.QueryEmployeeCheckStatus;
import pomplatform.checking.query.QueryEmployeeRealtimeChecking;
import pomplatform.checking.query.QueryEmployeeShouldAndFactCheck;
import pomplatform.checking.query.QueryEmployeeShouldCheckinPersonNum;
import pomplatform.checking.query.QueryEmployeecheckinPerson;
import pomplatform.checking.query.QueryEmployeecheckinoutStatusCount;
import pomplatform.checking.query.QueryMemployeecheckinouteeseor;
import pomplatform.checking.query.QuerySemployeecheckinoutupdatetimeor;

/**
 *
 * @author 
 */
public class EmployeeCheckinout implements GenericProcessor {
	private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //
    private static final String ON_LOAD_EMPLOYEE_CHECKINOUT = "onLoadEmployeeCheckinout";
    private static final String EMPLOYEE_SHOULD_AND_FACT_CHECK_NUM = "EmployeeShouldAndFactCheckNum";
    private static final String EMPLOYEE_STATUS_COUNT = "EmployeeStatusCount";
    
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        Date startDate = new Date(BaseHelpUtils.getLongValue(param.get("startDate")));
        Date endDate = new Date(BaseHelpUtils.getLongValue(param.get("endDate")));
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_LOAD_EMPLOYEE_CHECKINOUT.equals(optType)){
        	return onLoadEmployeeCheckinout(param,startDate,endDate);
        }else if(EMPLOYEE_SHOULD_AND_FACT_CHECK_NUM.equals(optType)){
        	return EmployeeShouldAndFactCheckNum(param);
        }else if(EMPLOYEE_STATUS_COUNT.equals(optType)){
        	return EmployeeStatusCount(param);
        }
        return null;
	}
	
	
	//加载当日各考勤状态的人数
	 private String EmployeeStatusCount(Map<String, Object> param) throws SQLException {
		 ConditionEmployeeCheckStatus condition = new ConditionEmployeeCheckStatus();
		if(param.get("departmentId") != null){
			int departmentId = BaseHelpUtils.getIntValue(param.get("departmentId"));
			condition.setDepartmentId(departmentId);
		}
		condition.setStartDate(GenericBase.__getDate(param.get("startDate")));
		condition.setEndDate(GenericBase.__getDate(param.get("endDate")));
		QueryEmployeeCheckStatus q = new QueryEmployeeCheckStatus();
		BaseCollection<BaseEmployeeCheckStatus> res = q.executeQuery(null, condition);
		return res.toJSON();
	}


	//加载应出勤人数和实际出勤人数
	private String EmployeeShouldAndFactCheckNum(Map<String, Object> param) throws SQLException {
		ConditionEmployeeShouldAndFactCheck condition = new ConditionEmployeeShouldAndFactCheck();
		if(param.get("departmentId") != null){
			int departmentId = BaseHelpUtils.getIntValue(param.get("departmentId"));
			condition.setDepartmentId(departmentId);
		}
		condition.setStartDate(GenericBase.__getDate(param.get("startDate")));
		condition.setEndDate(GenericBase.__getDate(param.get("endDate")));
		QueryEmployeeShouldAndFactCheck q = new QueryEmployeeShouldAndFactCheck();
		BaseCollection<BaseEmployeeShouldAndFactCheck> res = q.executeQuery(null, condition);
		return res.toJSON();
	}

	
	private String onLoadEmployeeCheckinout(Map<String,Object> param,Date startDate,Date endDate) throws SQLException {
		ConditionEmployeeRealtimeChecking condition = new ConditionEmployeeRealtimeChecking();
		if(param.get("employeeId") != null){
			int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
			condition.setEmployeeId(employeeId);
		}
		if(param.get("departmentId") != null){
			int departmentId = BaseHelpUtils.getIntValue(param.get("departmentId"));
			condition.setDepartmentId(departmentId);
		}
		if(param.get("status") != null){
			int status = BaseHelpUtils.getIntValue(param.get("status"));
			condition.setStatus(status);
		}
		if(param.get("startDate") != null){
			condition.setStartDate(startDate);
		}
		if(param.get("endDate") != null){
			condition.setEndDate(endDate);
		}
		
		QueryEmployeeRealtimeChecking d = new QueryEmployeeRealtimeChecking();
		BaseCollection<BaseEmployeeRealtimeChecking> res = d.executeQuery(null, condition);
		return res.toJSON();
	}

}
