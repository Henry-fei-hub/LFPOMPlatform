package pomplatform.financereceivebills.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financereceivebills.bean.BaseMfinancereceivebillspor;
import pomplatform.financereceivebills.bean.ConditionMfinancereceivebillspor;

public class QueryMfinancereceivebillspor extends AbstractQuery<BaseMfinancereceivebillspor, ConditionMfinancereceivebillspor>
{

	private static final Logger __logger = Logger.getLogger(QueryMfinancereceivebillspor.class);

	public QueryMfinancereceivebillspor() throws java.sql.SQLException 
	{
		setParameterNumber(17);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("frb.finance_receive_bill_id");
	}

	@Override
	public BaseCollection<BaseMfinancereceivebillspor> executeQuery( KeyValuePair[] replacements, ConditionMfinancereceivebillspor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFinanceReceiveBillId(), 
				condition.getCompanyId(), 
				condition.getApplicant(), 
				condition.getCode(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getAmount(), 
				condition.getSendee(), 
				condition.getHandlePerson(), 
				condition.getRemark(), 
				condition.getDetailRemark(), 
				condition.getReceiveStatus(), 
				condition.getMinCreateTime(), 
				condition.getMaxCreateTime(), 
				condition.getMinUpdateTime(), 
				condition.getMaxUpdateTime(), 
				condition.getProcessStatus()
			);
	}

	@Override
	public BaseMfinancereceivebillspor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMfinancereceivebillspor __base = new BaseMfinancereceivebillspor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setFinanceReceiveBillId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setApplicant(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSendee(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHandlePerson(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReceiveStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[12]));
		if(args[13] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[13]));
		if(args[14] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[14]));
		if(args[15] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[15]));
		if(args[16] != null) __statement.setInt(count++, GenericBase.__getInt(args[16]));
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

	private final static String __SQLText = "SELECT frb.finance_receive_bill_id, frb.company_id, frb.department_id, frb.applicant, frb.code, frb.process_type, frb.business_id, frb.amount, frb.sendee, frb.handle_person, frb.remark, frb.detail_remark, frb.receive_status, frb.create_time, frb.update_time, spi.process_status, spi.process_id, spi.process_instance_id FROM finance_receive_bills frb LEFT JOIN system_process_instances spi ON spi.process_type = frb.process_type AND spi.business_id = frb.business_id WHERE spi.delete_flag = 0 AND frb.finance_receive_bill_id = ? AND frb.company_id = ? AND frb.applicant = ? AND frb.code LIKE ? AND frb.process_type = ? AND frb.business_id = ? AND frb.amount = ? AND frb.sendee = ? AND frb.handle_person = ? AND frb.remark LIKE ? AND frb.detail_remark LIKE ? AND frb.receive_status = ? AND frb.create_time between ? and ? AND frb.update_time between ? and ? AND spi.process_status = ? ORDER BY frb.update_time DESC" ;
	private final static String RESULTSETFIELDLIST = "finance_receive_bill_id,company_id,department_id,applicant,code,process_type,business_id,amount,sendee,handle_person,remark,detail_remark,receive_status,create_time,update_time,process_status,process_id,process_instance_id";
	private final static String[] fieldNames = { "finance_receive_bill_id", "company_id", "applicant", "code", "process_type", "business_id", "amount", "sendee", "handle_person", "remark", "detail_remark", "receive_status", "min_create_time", "max_create_time", "min_update_time", "max_update_time", "process_status"};
}
