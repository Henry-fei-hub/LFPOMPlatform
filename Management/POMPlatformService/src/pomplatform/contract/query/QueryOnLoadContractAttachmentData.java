package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseOnLoadContractAttachmentData;
import pomplatform.contract.bean.ConditionOnLoadContractAttachmentData;

public class QueryOnLoadContractAttachmentData extends AbstractQuery<BaseOnLoadContractAttachmentData, ConditionOnLoadContractAttachmentData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractAttachmentData.class);

	public QueryOnLoadContractAttachmentData() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("abc.contract_attachment_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractAttachmentData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractAttachmentData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getAttachmentName(), 
				condition.getAttachmentCode(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseOnLoadContractAttachmentData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractAttachmentData __base = new BaseOnLoadContractAttachmentData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setUploadEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUploadTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsLink(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
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

	private final static String __SQLText = "SELECT abc.contract_attachment_id,abc.file_id,abc.attachment_code,abc.attachment_name,abc.upload_employee_id,abc.upload_time,abc.remark,abc.is_link,abc.file_url,abc.signing_money_sum,abc.company_id FROM ( SELECT a.*,b.contract_id,c.contract_code,c.contract_name,CASE WHEN b.contract_attachment_id > 0 THEN true ELSE FALSE END is_link,d.file_url from contract_attachments a LEFT JOIN contract_link_attachments b ON a.contract_attachment_id = b.contract_attachment_id LEFT JOIN contracts c ON b.contract_id = c.contract_id LEFT JOIN file_manages d ON a.file_id = d.file_id ) AS abc WHERE contract_code LIKE ? AND contract_name LIKE ? AND attachment_name LIKE ? AND attachment_code LIKE ? AND upload_time BETWEEN ? AND ? GROUP BY abc.contract_attachment_id,abc.file_id,abc.attachment_code,abc.attachment_name,abc.upload_employee_id,abc.upload_time,abc.remark,abc.is_link,abc.file_url,abc.signing_money_sum,abc.company_id ORDER BY abc.upload_time DESC" ;
	private final static String RESULTSETFIELDLIST = "contract_attachment_id,file_id,attachment_code,attachment_name,upload_employee_id,upload_time,remark,is_link,file_url,signing_money_sum,company_id";
	private final static String[] fieldNames = { "contract_code", "contract_name", "attachment_name", "attachment_code", "start_date", "end_date"};
}
