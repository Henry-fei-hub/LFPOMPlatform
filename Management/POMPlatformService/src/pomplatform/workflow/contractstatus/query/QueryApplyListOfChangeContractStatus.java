package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseApplyListOfChangeContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionApplyListOfChangeContractStatus;

public class QueryApplyListOfChangeContractStatus extends AbstractQuery<BaseApplyListOfChangeContractStatus, ConditionApplyListOfChangeContractStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryApplyListOfChangeContractStatus.class);

	public QueryApplyListOfChangeContractStatus() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseApplyListOfChangeContractStatus> executeQuery( KeyValuePair[] replacements, ConditionApplyListOfChangeContractStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getDeleteFlag(), 
				condition.getOperator(), 
				condition.getContent(), 
				condition.getContractCode(), 
				condition.getContractName()
			);
	}

	@Override
	public BaseApplyListOfChangeContractStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplyListOfChangeContractStatus __base = new BaseApplyListOfChangeContractStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
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

	private final static String __SQLText = "select spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, cl.contract_id, c.contract_code, c.contract_name, cl.content, cl.remark, cl.attachment_id, fm.file_url from system_process_instances spi LEFT JOIN contract_logs cl on spi.business_id = cl.contract_log_id LEFT JOIN contracts c on cl.contract_id = c.contract_id LEFT JOIN file_manages fm on cl.attachment_id = fm.file_id where spi.process_type = ? and spi.process_status = ? and spi.delete_flag = ? and cl.operator = ? and cl.content like ? and c.contract_code like ? and c.contract_name like ? order by spi.create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,contract_id,contract_code,contract_name,content,remark,attachment_id,file_url";
	private final static String[] fieldNames = { "process_type", "process_status", "delete_flag", "operator", "content", "contract_code", "contract_name"};
}
