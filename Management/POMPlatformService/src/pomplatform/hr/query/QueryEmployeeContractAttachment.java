package pomplatform.hr.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.hr.bean.BaseEmployeeContractAttachment;
import pomplatform.hr.bean.ConditionEmployeeContractAttachment;

public class QueryEmployeeContractAttachment extends AbstractQuery<BaseEmployeeContractAttachment, ConditionEmployeeContractAttachment>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeContractAttachment.class);

	public QueryEmployeeContractAttachment() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("eca.employee_contract_attachment_id");
	}

	@Override
	public BaseCollection<BaseEmployeeContractAttachment> executeQuery( KeyValuePair[] replacements, ConditionEmployeeContractAttachment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getStatus(), 
				condition.getContractType(), 
				condition.getSignType(), 
				condition.getStartDate(), 
				condition.getEndDate(), 
				condition.getWillEnd(),
				condition.getCompanyId()
			);
	}

	@Override
	public BaseEmployeeContractAttachment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeContractAttachment __base = new BaseEmployeeContractAttachment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeContractAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWillEnd(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
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
	private final static String __SQLText = "SELECT eca.employee_contract_attachment_id, eca.attachment_name, e.employee_no, eca.employee_id, e.employee_name, e.plate_id, e.department_id, e.onboard_date, e.status, eca.attachment_url, eca.contract_type, eca.sign_type, eca.start_date, eca.end_date, eca.will_end FROM employee_contract_attachments eca LEFT JOIN employees e ON eca.employee_id = e.employee_id WHERE eca.employee_id =? AND e.plate_id =? AND e.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND e.status =? AND eca.contract_type =? AND eca.sign_type =? AND eca.start_date =? AND eca.end_date =?  AND eca.will_end =? AND e.company_id =? AND eca.delete_flag = 1" ;
	private final static String RESULTSETFIELDLIST = "employee_contract_attachment_id,attachment_name,employee_no,employee_id,employee_name,plate_id,department_id,onboard_date,status,attachment_url,contract_type,sign_type,start_date,end_date,will_end";
	private final static String[] fieldNames = { "employee_id", "plate_id", "department_id", "status", "contract_type", "sign_type", "start_date", "end_date", "will_end" , "company_id"};
}
