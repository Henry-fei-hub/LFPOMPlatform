package pomplatform.workflow.contractstatus.query;

import org.apache.log4j.Logger;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.contractstatus.bean.BaseContractStatus;
import pomplatform.workflow.contractstatus.bean.ConditionContractStatus;

public class QueryContractStatus extends AbstractQuery<BaseContractStatus, ConditionContractStatus>
{

	private static final Logger __logger = Logger.getLogger(QueryContractStatus.class);

	public QueryContractStatus() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_log_id");
	}

	@Override
	public BaseCollection<BaseContractStatus> executeQuery( KeyValuePair[] replacements, ConditionContractStatus condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractLogId()
			);
	}

	@Override
	public BaseContractStatus generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractStatus __base = new BaseContractStatus();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractLogId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOriginalStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNewStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContent(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperator(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileName(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.contract_log_id, a.contract_id, b.contract_code, b.contract_name, a.original_status, a.new_status, a.content, a.remark, a.operator, a.operate_time, a.delete_flag, a.attachment_id, c.file_name, c.file_url from contract_logs a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN file_manages c on a.attachment_id = c.file_id where a.contract_log_id = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_log_id,contract_id,contract_code,contract_name,original_status,new_status,content,remark,operator,operate_time,delete_flag,attachment_id,file_name,file_url";
	private final static String[] fieldNames = { "contract_log_id"};
}
