package pomplatform.aboutinputtaxrecordinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.aboutinputtaxrecordinfo.bean.BaseAboutInputTaxRecordInfo;
import pomplatform.aboutinputtaxrecordinfo.bean.ConditionAboutInputTaxRecordInfo;

public class QueryAboutInputTaxRecordInfo extends AbstractQuery<BaseAboutInputTaxRecordInfo, ConditionAboutInputTaxRecordInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryAboutInputTaxRecordInfo.class);

	public QueryAboutInputTaxRecordInfo() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("r.input_tax_record_id");
	}

	@Override
	public BaseCollection<BaseAboutInputTaxRecordInfo> executeQuery( KeyValuePair[] replacements, ConditionAboutInputTaxRecordInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getCode(), 
				condition.getInvoiceEndNumber(), 
				condition.getOperateTime(), 
				condition.getOverTime()
			);
	}

	@Override
	public BaseAboutInputTaxRecordInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAboutInputTaxRecordInfo __base = new BaseAboutInputTaxRecordInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setInputTaxRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInputTax(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setInvoiceEndNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOverTime(GenericBase.__getDateFromSQL(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
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

	private final static String __SQLText = "SELECT r.input_tax_record_id,r.business_id,r.process_type,s.process_type_name,r.code,r.input_tax,r.invoice_end_number,r.operate_time,r.over_time FROM input_tax_records r LEFT JOIN system_process_types s on r.process_type=s.process_type_id WHERE r.process_type=? AND r.code like ? AND r.invoice_end_number like ? AND r.operate_time >= ? and r.over_time <=?" ;
	private final static String RESULTSETFIELDLIST = "input_tax_record_id,business_id,process_type,process_type_name,code,input_tax,invoice_end_number,operate_time,over_time";
	private final static String[] fieldNames = { "process_type", "code", "invoice_end_number", "operate_time", "over_time"};
}
