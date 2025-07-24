package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseOnLoadAttachmentBindContract;
import pomplatform.contract.bean.ConditionOnLoadAttachmentBindContract;

public class QueryOnLoadAttachmentBindContract extends AbstractQuery<BaseOnLoadAttachmentBindContract, ConditionOnLoadAttachmentBindContract>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttachmentBindContract.class);

	public QueryOnLoadAttachmentBindContract() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_link_attachment_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttachmentBindContract> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttachmentBindContract condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractAttachmentId(), 
				condition.getFileId()
			);
	}

	@Override
	public BaseOnLoadAttachmentBindContract generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttachmentBindContract __base = new BaseOnLoadAttachmentBindContract();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractLinkAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFileId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.contract_link_attachment_id,a.contract_attachment_id,a.contract_id,a.file_id,b.contract_code,b.contract_name,b.customer_name,b.signing_company_name AS company_id,b.signing_money_sum FROM contract_link_attachments a LEFT JOIN contracts b ON a.contract_id = b.contract_id WHERE a.contract_attachment_id = ? AND a.file_id = ? ORDER BY a.operate_time DESC" ;
	private final static String RESULTSETFIELDLIST = "contract_link_attachment_id,contract_attachment_id,contract_id,file_id,contract_code,contract_name,customer_name,company_id,signing_money_sum";
	private final static String[] fieldNames = { "contract_attachment_id", "file_id"};
}
