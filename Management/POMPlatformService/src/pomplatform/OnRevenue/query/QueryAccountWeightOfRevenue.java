package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseAccountWeightOfRevenue;
import pomplatform.OnRevenue.bean.ConditionAccountWeightOfRevenue;

public class QueryAccountWeightOfRevenue extends AbstractQuery<BaseAccountWeightOfRevenue, ConditionAccountWeightOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryAccountWeightOfRevenue.class);

	public QueryAccountWeightOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("0 as business_state_record_id");
	}

	@Override
	public BaseCollection<BaseAccountWeightOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionAccountWeightOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getAccountWeightRecordId()
			);
	}

	@Override
	public BaseAccountWeightOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAccountWeightOfRevenue __base = new BaseAccountWeightOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountWeightRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSettlementLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAssignIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinishWeightPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHasAttachment(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentPercent(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select 0 as business_state_record_id,account_weight_record_id, type_id,settlement_level,percent,type_name ,0 as assign_integral,0 as sure_integral,0 as finish_percent,0 as finish_weight_percent,0 as has_attachment,0 as attachment_percent from account_weight_records where parent_id in(select account_weight_record_id from account_weight_records where parent_id = ?) ORDER BY settlement_level" ;
	private final static String RESULTSETFIELDLIST = "business_state_record_id,account_weight_record_id,type_id,settlement_level,percent,type_name,assign_integral,sure_integral,finish_percent,finish_weight_percent,has_attachment,attachment_percent";
	private final static String[] fieldNames = { "account_weight_record_id"};
}
