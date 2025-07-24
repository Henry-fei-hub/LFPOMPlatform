package pomplatform.financialtransactionaccount.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.financialtransactionaccount.bean.BaseReceiveUnitRepaymentTrans;
import pomplatform.financialtransactionaccount.bean.ConditionReceiveUnitRepaymentTrans;

public class QueryReceiveUnitRepaymentTrans extends AbstractQuery<BaseReceiveUnitRepaymentTrans, ConditionReceiveUnitRepaymentTrans>
{

	private static final Logger __logger = Logger.getLogger(QueryReceiveUnitRepaymentTrans.class);

	public QueryReceiveUnitRepaymentTrans() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.process_instance_id");
	}

	@Override
	public BaseCollection<BaseReceiveUnitRepaymentTrans> executeQuery( KeyValuePair[] replacements, ConditionReceiveUnitRepaymentTrans condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessInstanceId(), 
				condition.getProcessType(), 
				condition.getBusinessId(), 
				condition.getProcessStatus(), 
				condition.getDeleteFlag()
			);
	}

	@Override
	public BaseReceiveUnitRepaymentTrans generateBase(Object[] __data) throws java.sql.SQLException {
		BaseReceiveUnitRepaymentTrans __base = new BaseReceiveUnitRepaymentTrans();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCurrencyType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSummary(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOriginalCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select a.process_instance_id, a.process_type, a.business_id, a.create_time as record_date, a.process_status, a.complete_time, b.drafter, b.cost_attribution as currency_type, concat('外部公司还款-', c.department_name, case when c.department_name is null then '' else '-' end, d.employee_name, case when d.employee_name is null then '' else '-' end, b.plan, case when b.plan is null then '' else '-' end, b.remark) as summary, b.parent_id, b.fee as original_credit, b.company_id from system_process_instances a LEFT JOIN personnel_business b on a.business_id = b.personnel_business_id LEFT JOIN departments c on b.department_id = c.department_id LEFT JOIN employees d on b.drafter = d.employee_id where a.process_instance_id = ? and a.process_type = ? and a.business_id = ? and a.process_status = ? and a.delete_flag = ?" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,record_date,process_status,complete_time,drafter,currency_type,summary,parent_id,original_credit,company_id";
	private final static String[] fieldNames = { "process_instance_id", "process_type", "business_id", "process_status", "delete_flag"};
}
