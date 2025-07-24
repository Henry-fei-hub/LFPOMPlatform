package pomplatform.OnRevenue.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.OnRevenue.bean.BaseAllSheetDataOfRevenue;
import pomplatform.OnRevenue.bean.ConditionAllSheetDataOfRevenue;

public class QueryAllSheetDataOfRevenue extends AbstractQuery<BaseAllSheetDataOfRevenue, ConditionAllSheetDataOfRevenue>
{

	private static final Logger __logger = Logger.getLogger(QueryAllSheetDataOfRevenue.class);

	public QueryAllSheetDataOfRevenue() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseAllSheetDataOfRevenue> executeQuery( KeyValuePair[] replacements, ConditionAllSheetDataOfRevenue condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId(), 
				condition.getBusinessStateRecordId()
			);
	}

	@Override
	public BaseAllSheetDataOfRevenue generateBase(Object[] __data) throws java.sql.SQLException {
		BaseAllSheetDataOfRevenue __base = new BaseAllSheetDataOfRevenue();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessStateRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAccountWeightRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBeforeContractTotal(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
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

	private final static String __SQLText = "select a.project_id,a.plate_id,a.project_code,a.contract_code as sub_contract_code,a.project_name,b.sub_contract_id,b.business_state_record_id,c.account_weight_record_id ,c.business_code,c.business_integral,c.before_contract_total,c.business_name,c.contract_id,d.contract_code,d.signing_money_sum from projects a left join sub_contracts b on a.contract_code = b.sub_contract_code left join business_state_records c on b.business_state_record_id = c.business_state_record_id left join contracts d on c.contract_id = d.contract_id where c.contract_id = ? and b.business_state_record_id = ?" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,project_code,sub_contract_code,project_name,sub_contract_id,business_state_record_id,account_weight_record_id,business_code,business_integral,before_contract_total,business_name,contract_id,contract_code,signing_money_sum";
	private final static String[] fieldNames = { "contract_id", "business_state_record_id"};
}
