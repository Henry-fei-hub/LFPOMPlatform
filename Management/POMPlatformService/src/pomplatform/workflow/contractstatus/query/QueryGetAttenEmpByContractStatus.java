package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseGetAttenEmpByContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionGetAttenEmpByContractStatus;

public class QueryGetAttenEmpByContractStatus extends AbstractQuery<BaseGetAttenEmpByContractStatus, ConditionGetAttenEmpByContractStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryGetAttenEmpByContractStatus.class);

	public QueryGetAttenEmpByContractStatus() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_code");
	}

	@Override
	public BaseCollection<BaseGetAttenEmpByContractStatus> executeQuery( KeyValuePair[] replacements, ConditionGetAttenEmpByContractStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRoleId(), 
				condition.getContractSigningStatus(), 
				condition.getSendingDate(), 
				condition.getContractStatus()
			);
	}

	@Override
	public BaseGetAttenEmpByContractStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseGetAttenEmpByContractStatus __base = new BaseGetAttenEmpByContractStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setApplyEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select a.contract_code, a.contract_name, a.sending_date, b.apply_employee_id, d.employee_id from contracts a LEFT JOIN pre_projects b on a.info_code = b.info_code LEFT JOIN employees c on b.apply_employee_id = c.employee_id LEFT JOIN employee_roles d on c.department_id = d.department_id and d.role_id = ? where a.contract_signing_status = ? and a.sending_date < ? and a.contract_status = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_code,contract_name,sending_date,apply_employee_id,employee_id";
	private final static String[] fieldNames = { "role_id", "contract_signing_status", "sending_date", "contract_status"};
}
