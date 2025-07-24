package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseContractStatusMonth;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatusMonth;

public class QueryContractStatusMonth extends AbstractQuery<BaseContractStatusMonth, ConditionContractStatusMonth>
{

	private static final Logger __logger = Logger.getLogger(QueryContractStatusMonth.class);

	public QueryContractStatusMonth() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("m.* from ( select k.contract_id");
	}

	@Override
	public BaseCollection<BaseContractStatusMonth> executeQuery( KeyValuePair[] replacements, ConditionContractStatusMonth condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getNewStatus(), 
				condition.getRoleId(), 
				condition.getContractMonth()
			);
	}

	@Override
	public BaseContractStatusMonth generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractStatusMonth __base = new BaseContractStatusMonth();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentLeader(GenericBase.__getString(val));
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

	private final static String __SQLText = "select m.* from ( select k.contract_id, extract(year from k.contract_age) * 12 + extract(month from k.contract_age) as contract_month, c.contract_code, c.contract_name, pre.apply_employee_id, array_to_string(ARRAY (SELECT UNNEST (ARRAY_AGG (DISTINCT er.employee_id))),'，') as department_leader from ( select b.contract_id, b.new_status, age(now(), b.operate_time) as contract_age from ( select max(operate_time) as operate_time, contract_id from contract_logs where delete_flag = 0 and (process_status is null or process_status = 3) group by contract_id ) a LEFT JOIN contract_logs b on a.contract_id = b.contract_id and a.operate_time = b.operate_time where b.delete_flag = 0 and (process_status is null or process_status = 3) and b.new_status = ? ) k LEFT JOIN contracts c on k.contract_id = c.contract_id LEFT JOIN pre_projects pre on c.info_code = pre.info_code LEFT JOIN employees e on pre.apply_employee_id = e.employee_id LEFT JOIN employee_roles er on e.department_id = er.department_id and er.role_id = ? group by k.contract_id, k.contract_age, c.contract_code, c.contract_name, pre.apply_employee_id ) m where m.contract_month >= ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_month,contract_code,contract_name,apply_employee_id,department_leader";
	private final static String[] fieldNames = { "new_status", "role_id", "contract_month"};
}
