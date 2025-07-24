package pomplatform.operation.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseMprojectemployeeppor;
import pomplatform.operation.bean.ConditionMprojectemployeeppor;

public class QueryMprojectemployeeppor extends AbstractQuery<BaseMprojectemployeeppor, ConditionMprojectemployeeppor>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectemployeeppor.class);

	public QueryMprojectemployeeppor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_employee_id");
	}

	@Override
	public BaseCollection<BaseMprojectemployeeppor> executeQuery( KeyValuePair[] replacements, ConditionMprojectemployeeppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getStageId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseMprojectemployeeppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectemployeeppor __base = new BaseMprojectemployeeppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStageProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWorkContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLeftIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, java.lang.Object ... args) throws java.sql.SQLException {

		int index = 0;
		for(int ii = 0; ii < args.length; ii++){
			if(args[ii] == null) continue;
			index++;
			__logger.info(String.format("%1$s = [%2$s]", fieldNames[ii], args[ii]));
		}
		if( index > 0 ) __logger.info("=================================================");
		if(args[0] != null) __statement.setInt(count++, GenericBase.__getInt(args[0]));
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		return count;
	}

	@Override
	public String getSQLText() {
		__logger.info(__SQLText);
		return __SQLText;
	}

	@Override
	public String getFieldList(){
		return RESULTSETFIELDLIST;
	}

//	private final static String __SQLText = "SELECT a.project_employee_id,a.project_id,p.project_manage_id,p.contract_code AS sheet_code,p.project_name AS sheet_name ,a.employee_id,e.employee_no,e.employee_name,a.plan_integral,c.real_integral,b.stage_sure_integral,c.sure_integral ,c.cost,b.stage_project_cost,c.project_cost,c.real_amount,e.status,a.work_content FROM project_employees a LEFT JOIN ( SELECT ps.project_id,ps.stage_id,psd.employee_id,SUM(psd.real_amount) AS stage_sure_integral, SUM(psd.project_cost) AS stage_project_cost FROM project_settlements ps LEFT JOIN project_settlement_details psd ON ps.project_id = psd.project_id AND ps.settlement_id = psd.settlement_id WHERE ps.settlement_status = 2 GROUP BY ps.project_id,ps.stage_id,psd.employee_id ) b ON a.project_id = b.project_id AND a.stage_id = b.stage_id AND a.employee_id = b.employee_id LEFT JOIN ( SELECT project_id,employee_id ,SUM(CASE WHEN settlement_status = 2 THEN real_amount ELSE 0 END) AS sure_integral,SUM(CASE WHEN settlement_status = 2 THEN project_cost ELSE 0 END) AS project_cost,SUM(CASE WHEN settlement_status = 1 THEN real_amount ELSE 0 END) AS real_integral,SUM(CASE WHEN settlement_status = 1 THEN project_cost ELSE 0 END) AS COST,SUM(final_amount) AS real_amount FROM project_settlement_details GROUP BY project_id,employee_id) c ON a.project_id = c.project_id AND a.employee_id = c.employee_id LEFT JOIN projects p ON a.project_id = p.project_id LEFT JOIN employees e ON a.employee_id = e.employee_id WHERE a.project_id = ? AND a.stage_id = ? AND a.employee_id = ?" ;
//	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,project_manage_id,sheet_code,sheet_name,employee_id,employee_no,employee_name,plan_integral,real_integral,stage_sure_integral,sure_integral,cost,stage_project_cost,project_cost,real_amount,status,work_content";
	private final static String __SQLText = "SELECT A.project_employee_id, A.project_id, P.project_manage_id, P.contract_code AS sheet_code, P.project_name AS sheet_name, A.employee_id, e.employee_no, e.employee_name, (case when A.plan_integral ISNULL then 0 else A.plan_integral end) as plan_integral , (case when C.real_integral ISNULL then 0 else C.real_integral end) as real_integral , (case when b.stage_sure_integral ISNULL then 0 else b.stage_sure_integral end) as stage_sure_integral , (case when C.sure_integral ISNULL then 0 else C.sure_integral end) as sure_integral , (case when C.COST ISNULL then 0 else C.COST end) as COST , (case when b.stage_project_cost ISNULL then 0 else b.stage_project_cost end) as stage_project_cost , (case when C.project_cost ISNULL then 0 else C.project_cost end) as project_cost , (case when C.real_amount ISNULL then 0 else C.real_amount end) as real_amount , e.status, A.work_content, ((case when A.plan_integral ISNULL then 0 else A.plan_integral end)-(case when b.stage_sure_integral ISNULL then 0 else b.stage_sure_integral end)) as left_integral, a.flag FROM project_employees A LEFT JOIN ( SELECT ps.project_id, ps.stage_id, psd.employee_id, SUM ( psd.real_amount ) AS stage_sure_integral, SUM ( psd.project_cost ) AS stage_project_cost FROM project_settlements ps LEFT JOIN project_settlement_details psd ON ps.project_id = psd.project_id AND ps.settlement_id = psd.settlement_id WHERE ps.settlement_status = 2 GROUP BY ps.project_id, ps.stage_id, psd.employee_id ) b ON A.project_id = b.project_id AND A.stage_id = b.stage_id AND A.employee_id = b.employee_id LEFT JOIN ( SELECT project_id, employee_id, SUM ( CASE WHEN settlement_status = 2 THEN real_amount ELSE 0 END ) AS sure_integral, SUM ( CASE WHEN settlement_status = 2 THEN project_cost ELSE 0 END ) AS project_cost, SUM ( CASE WHEN settlement_status = 1 THEN real_amount ELSE 0 END ) AS real_integral, SUM ( CASE WHEN settlement_status = 1 THEN project_cost ELSE 0 END ) AS COST, SUM ( final_amount ) AS real_amount FROM project_settlement_details GROUP BY project_id, employee_id ) C ON A.project_id = C.project_id AND A.employee_id = C.employee_id LEFT JOIN projects P ON A.project_id = P.project_id LEFT JOIN employees e ON A.employee_id = e.employee_id   WHERE a.project_id = ? AND a.stage_id = ? AND a.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,project_manage_id,sheet_code,sheet_name,employee_id,employee_no,employee_name,plan_integral,real_integral,stage_sure_integral,sure_integral,cost,stage_project_cost,project_cost,real_amount,status,work_content,left_integral,flag";
	private final static String[] fieldNames = { "project_id", "stage_id", "employee_id"};
}
