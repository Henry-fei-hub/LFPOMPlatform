package pomplatform.contractsRecords.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractsRecords.bean.BaseContractsRecords;
import pomplatform.contractsRecords.bean.ConditionContractsRecords;

public class QueryContractsRecords extends AbstractQuery<BaseContractsRecords, ConditionContractsRecords>
{

	private static final Logger __logger = Logger.getLogger(QueryContractsRecords.class);

	public QueryContractsRecords() throws java.sql.SQLException 
	{
		setParameterNumber(16);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contracts_records_id");
	}

	@Override
	public BaseCollection<BaseContractsRecords> executeQuery( KeyValuePair[] replacements, ConditionContractsRecords condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getContractAmount(), 
				condition.getContractStatus(), 
				condition.getRemark(), 
				condition.getRegisterEmployee(), 
				condition.getRelevantEmployees(), 
				condition.getRelevantEmployeesName(), 
				condition.getCustomerName(), 
				condition.getContractCode(), 
				condition.getTrackDateStart(), 
				condition.getTrackDateEnd(), 
				condition.getTrackType(), 
				condition.getInfoCode(), 
				condition.getCustomerName(), 
				condition.getProjectName(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseContractsRecords generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractsRecords __base = new BaseContractsRecords();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractsRecordsId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegisterEmployee(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployeesName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrackType(GenericBase.__getInt(val));
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
		if(args[1] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setString(count++, GenericBase.__getString(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[9]));
		if(args[10] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
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

	private final static String __SQLText = "SELECT c.contracts_records_id, p.pre_project_id, p.info_code, p.project_name, c.contract_id, ct.contract_name, c.contract_amount, c.contract_status, c.remark, c.track_date, c.register_employee, c.register_date, c.relevant_employees, c.relevant_employees_name, c.customer_name, c.contract_code,c.track_type FROM ( SELECT cr.contracts_records_id, cr.contract_id, cr.contract_name, cr.contract_amount, cr.contract_status, cr.remark, cr.track_date, cr.register_employee, cr.register_date, cr.relevant_employees, cr.relevant_employees_name, cr.customer_name, cr.contract_code, cr.contract_date, cr.sending_date, cr.track_type, cr.info_code from ( SELECT MAX(contracts_records_id) AS contracts_records_id FROM contracts_records GROUP BY contract_id, info_code ) A, contracts_records cr where cr.contracts_records_id =a.contracts_records_id AND cr.contract_id =? AND cr.contract_amount =? AND cr.contract_status =? AND cr.remark like ? AND cr.register_employee =? AND cr.relevant_employees =? AND cr.relevant_employees_name =?_name AND cr.customer_name LIKE ? AND cr.contract_code LIKE ? AND cr.track_date BETWEEN ? AND ? AND cr.track_type=? AND cr.info_code LIKE ? AND cr.customer_name like ? ) c LEFT JOIN pre_projects p on p.info_code=c.info_code LEFT JOIN contracts ct ON c.contract_id=ct.contract_id where p.project_name like ? and ct.contract_name LIKE ? ORDER BY c.contracts_records_id desc" ;
	private final static String RESULTSETFIELDLIST = "contracts_records_id,pre_project_id,info_code,project_name,contract_id,contract_name,contract_amount,contract_status,remark,track_date,register_employee,register_date,relevant_employees,relevant_employees_name,customer_name,contract_code,track_type";
	private final static String[] fieldNames = { "contract_id", "contract_amount", "contract_status", "remark", "register_employee", "relevant_employees", "relevant_employees_name", "customer_name", "contract_code", "track_date_start", "track_date_end", "track_type", "info_code", "customer_name", "project_name", "contract_name"};
}
