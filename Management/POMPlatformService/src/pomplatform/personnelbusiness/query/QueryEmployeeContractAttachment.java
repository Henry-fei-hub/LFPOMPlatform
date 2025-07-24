package pomplatform.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.personnelbusiness.bean.BaseEmployeeContractAttachment;
import pomplatform.personnelbusiness.bean.ConditionEmployeeContractAttachment;

public class QueryEmployeeContractAttachment extends AbstractQuery<BaseEmployeeContractAttachment, ConditionEmployeeContractAttachment>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeContractAttachment.class);

	public QueryEmployeeContractAttachment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("eca.employee_contract_attachment_id");
	}

	@Override
	public BaseCollection<BaseEmployeeContractAttachment> executeQuery( KeyValuePair[] replacements, ConditionEmployeeContractAttachment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseEmployeeContractAttachment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeContractAttachment __base = new BaseEmployeeContractAttachment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeContractAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSignType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWillEnd(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select eca.employee_contract_attachment_id, eca.employee_id, eca.attachment_name, eca.attachment_url, eca.operate_employee_id, eca.operate_time, eca.contract_type, eca.sign_type, eca.start_date, eca.end_date, eca.will_end, eca.attachment_id from employee_contract_attachments eca where eca.employee_id = ?" ;
	private final static String RESULTSETFIELDLIST = "employee_contract_attachment_id,employee_id,attachment_name,attachment_url,operate_employee_id,operate_time,contract_type,sign_type,start_date,end_date,will_end,attachment_id";
	private final static String[] fieldNames = { "employee_id"};
}
