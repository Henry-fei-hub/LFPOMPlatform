package pomplatform.preProjectRecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjectRecord.bean.BaseSpreProjectRecordRrtor;
import pomplatform.preProjectRecord.bean.ConditionSpreProjectRecordRrtor;

public class QuerySpreProjectRecordRrtor extends AbstractQuery<BaseSpreProjectRecordRrtor, ConditionSpreProjectRecordRrtor>
{

	private static final Logger __logger = Logger.getLogger(QuerySpreProjectRecordRrtor.class);

	public QuerySpreProjectRecordRrtor() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ppr.pre_project_record_id");
	}

	@Override
	public BaseCollection<BaseSpreProjectRecordRrtor> executeQuery( KeyValuePair[] replacements, ConditionSpreProjectRecordRrtor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getRelevantEmployees(), 
				condition.getRemark(), 
				condition.getTrackCode(), 
				condition.getPreProjectRecordId(), 
				condition.getTrackDate(), 
				condition.getInformationType(), 
				condition.getRegisterEmployee(), 
				condition.getRegisterDate(), 
				condition.getPreProjectId(), 
				condition.getMainProjectId()
			);
	}

	@Override
	public BaseSpreProjectRecordRrtor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpreProjectRecordRrtor __base = new BaseSpreProjectRecordRrtor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTrackDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInformationType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisterEmployee(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisterDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setTrackCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRelevantEmployeesDisplayValue(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setWinRate(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractSignStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignPrice(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
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

	private final static String __SQLText = "select ppr.pre_project_record_id, ppr.relevant_employees, ppr.track_date, ppr.information_type, ppr.remark, ppr.attachment_name, ppr.register_employee, ppr.register_date, ppr.track_code, ppr.main_project_id, ppr.file_name, ppr.relevant_employees_display_value, ppr.pre_project_id, ppr.win_rate, ppr.contract_sign_status, ppr.contract_amount, ppr.design_price from pre_project_records ppr where ppr.relevant_employees like ? and ppr.remark like ? and ppr.track_code like ? and ppr.pre_project_record_id = ? and ppr.track_date = ? and ppr.information_type = ? and ppr.register_employee = ? and ppr.register_date = ? and ppr.pre_project_id = ? and ppr.main_project_id = ? order by ppr.track_date desc" ;
	private final static String RESULTSETFIELDLIST = "pre_project_record_id,relevant_employees,track_date,information_type,remark,attachment_name,register_employee,register_date,track_code,main_project_id,file_name,relevant_employees_display_value,pre_project_id,win_rate,contract_sign_status,contract_amount,design_price";
	private final static String[] fieldNames = { "relevant_employees", "remark", "track_code", "pre_project_record_id", "track_date", "information_type", "register_employee", "register_date","pre_project_id","main_project_id"};
}
