package pomplatform.projectEmployee.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.projectEmployee.bean.BaseProjectEmployeeAudit;
import pomplatform.projectEmployee.bean.ConditionProjectEmployeeAudit;

public class QueryProjectEmployeeAudit extends AbstractQuery<BaseProjectEmployeeAudit, ConditionProjectEmployeeAudit>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectEmployeeAudit.class);

	public QueryProjectEmployeeAudit() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pe.project_employee_id");
	}

	@Override
	public BaseCollection<BaseProjectEmployeeAudit> executeQuery( KeyValuePair[] replacements, ConditionProjectEmployeeAudit condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getFlag(), 
				condition.getProjectPlateId(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName()
			);
	}

	@Override
	public BaseProjectEmployeeAudit generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectEmployeeAudit __base = new BaseProjectEmployeeAudit();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeePlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlanIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
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

	private final static String __SQLText = "select pe.project_employee_id, pe.project_id, p.plate_id, p.contract_code, p.project_name, pe.stage_id, pe.employee_id, e.employee_no, e.employee_name, e.plate_id as employee_plate_id, COALESCE(pe.plan_integral, 0) as plan_integral, COALESCE(sum(psd.real_amount), 0) as sure_integral from project_employees pe LEFT JOIN employees e on pe.employee_id = e.employee_id LEFT JOIN projects p on pe.project_id = p.project_id LEFT JOIN project_settlements ps on pe.project_id = ps.project_id and pe.stage_id = ps.stage_id and ps.settlement_status = 2 LEFT JOIN project_settlement_details psd on ps.settlement_id = psd.settlement_id and pe.employee_id = psd.employee_id where e.plate_id in ( WITH RECURSIVE T (plate_id) as ( select plate_id from plate_records where plate_id = ? union all select pr.plate_id from plate_records pr join T on pr.parent_id = T.plate_id ) select plate_id from T ) and pe.flag = ? and e.plate_id != p.plate_id and p.plate_id = ? and p.contract_code like ? and p.project_name like ? and e.employee_no like ? and e.employee_name like ? group by pe.project_employee_id, pe.project_id, p.plate_id, p.contract_code, p.project_name, pe.stage_id, pe.employee_id, e.employee_no, e.employee_name, e.plate_id, pe.plan_integral order by pe.project_id, pe.employee_id" ;
	private final static String RESULTSETFIELDLIST = "project_employee_id,project_id,plate_id,contract_code,project_name,stage_id,employee_id,employee_no,employee_name,employee_plate_id,plan_integral,sure_integral";
	private final static String[] fieldNames = { "plate_id", "flag", "project_plate_id", "contract_code", "project_name", "employee_no", "employee_name"};
}
