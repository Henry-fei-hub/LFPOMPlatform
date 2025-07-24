package pomplatform.aboutcontractsrecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.aboutcontractsrecord.bean.BaseAboutContractsRecord;
import pomplatform.aboutcontractsrecord.bean.ConditionAboutContractsRecord;

public class QueryAboutContractsRecord extends AbstractQuery<BaseAboutContractsRecord, ConditionAboutContractsRecord>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutContractsRecord.class);

	public QueryAboutContractsRecord() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cr.contracts_records_id");
	}

	@Override
	public BaseCollection<BaseAboutContractsRecord> executeQuery( KeyValuePair[] replacements, ConditionAboutContractsRecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getInfoCode(), 
				condition.getContractId()
			);
	}

	@Override
	public BaseAboutContractsRecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutContractsRecord __base = new BaseAboutContractsRecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractsRecordsId(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSendingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTrackType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "SELECT cr.contracts_records_id, p.project_name, cr.contract_id, ct.contract_name, cr.contract_amount, cr.contract_status, cr.remark, cr.track_date, cr.register_employee, cr.register_date, cr.relevant_employees, cr.relevant_employees_name, cr.customer_name, cr.contract_code, cr.contract_date, cr.sending_date, cr.track_type, cr.info_code FROM contracts_records cr LEFT JOIN pre_projects p on cr.info_code=p.info_code LEFT JOIN contracts ct ON cr.contract_id = ct.contract_id  where cr.info_code=? AND cr.contract_id=? ORDER BY cr.contracts_records_id" ;
	private final static String RESULTSETFIELDLIST = "contracts_records_id,project_name,contract_id,contract_name,contract_amount,contract_status,remark,track_date,register_employee,register_date,relevant_employees,relevant_employees_name,customer_name,contract_code,contract_date,sending_date,track_type,info_code";
	private final static String[] fieldNames = { "info_code", "contract_id"};
}
