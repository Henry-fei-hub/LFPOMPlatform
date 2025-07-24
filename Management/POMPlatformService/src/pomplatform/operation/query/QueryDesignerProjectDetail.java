package pomplatform.operation.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.operation.bean.BaseDesignerProjectDetail;
import pomplatform.operation.bean.ConditionDesignerProjectDetail;

public class QueryDesignerProjectDetail extends AbstractQuery<BaseDesignerProjectDetail, ConditionDesignerProjectDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryDesignerProjectDetail.class);

	public QueryDesignerProjectDetail() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pe.project_id");
	}

	@Override
	public BaseCollection<BaseDesignerProjectDetail> executeQuery( KeyValuePair[] replacements, ConditionDesignerProjectDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseDesignerProjectDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDesignerProjectDetail __base = new BaseDesignerProjectDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSheetCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectCost(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRealAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRealAmounts(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAdvancedIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCount(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT pe.project_id, P.project_manage_id, P.contract_code AS sheet_code, P.project_name AS sheet_name, pe.employee_id, e.employee_no, e.employee_name, pe.plan_integral, COALESCE (( SELECT real_amount FROM project_settlement_details WHERE project_id = pe.project_id AND employee_id = pe.employee_id AND settlement_status = 1 ), 0 ) AS real_integral, COALESCE ( psd.sure_integral, 0 ) AS sure_integral, COALESCE (( SELECT project_cost FROM project_settlement_details WHERE project_id = pe.project_id AND employee_id = pe.employee_id AND settlement_status = 1 ), 0 ) AS COST, COALESCE ( psd.project_cost, 0 ) AS project_cost, COALESCE ( psd.real_amount, 0 ) AS real_amount, P.project_flag, ( COALESCE ( psd.sure_integral, 0 ) - COALESCE ( psd.project_cost, 0 ) + COALESCE ( pr.advanced_integral, 0 )) AS real_amounts, COALESCE ( pr.advanced_integral, 0 ) AS advanced_integral, pe.alternate_field2, a.count FROM ( SELECT project_id, employee_id, SUM ( COALESCE ( plan_integral, 0 )) AS plan_integral, alternate_field2 FROM project_employees GROUP BY project_id, employee_id, alternate_field2 ) pe LEFT JOIN projects P ON pe.project_id = P.project_id LEFT JOIN employees e ON pe.employee_id = e.employee_id LEFT JOIN ( SELECT project_id, employee_id, SUM ( COALESCE ( real_amount, 0 )) AS sure_integral, SUM ( COALESCE ( project_cost, 0 )) AS project_cost, SUM ( COALESCE ( final_amount, 0 )) AS real_amount FROM project_settlement_details WHERE settlement_status = 2 GROUP BY project_id, employee_id ) psd ON pe.project_id = psd.project_id AND pe.employee_id = psd.employee_id LEFT JOIN ( SELECT SUM ( COALESCE ( advanced_integral, 0 )) AS advanced_integral, project_id, employee_id FROM project_employee_advance_records GROUP BY project_id, employee_id ) pr ON pr.project_id = pe.project_id AND pr.employee_id = pe.employee_id left join ( select count(1) as count,project_id ,employee_id from project_employee_audit_records where employee_id =? and status =1 group by project_id,employee_id )as a on a.project_id =pe.project_id and pe.employee_id = a.employee_id WHERE pe.employee_id =? AND P.project_type <> 30 ORDER BY pe.project_id DESC" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_manage_id,sheet_code,sheet_name,employee_id,employee_no,employee_name,plan_integral,real_integral,sure_integral,cost,project_cost,real_amount,project_flag,real_amounts,advanced_integral,alternate_field2,count";
	private final static String[] fieldNames = { "employee_id", "employee_id"};
}
