package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractCommissionDetail;
import pomplatform.contract.bean.ConditionContractCommissionDetail;

public class QueryContractCommissionDetail extends AbstractQuery<BaseContractCommissionDetail, ConditionContractCommissionDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryContractCommissionDetail.class);

	public QueryContractCommissionDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cc.contract_commission_detail_id");
	}

	@Override
	public BaseCollection<BaseContractCommissionDetail> executeQuery( KeyValuePair[] replacements, ConditionContractCommissionDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseContractCommissionDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractCommissionDetail __base = new BaseContractCommissionDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractCommissionDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRate(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBillingRatio(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setIsOriginal(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsSubProject(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT cc.contract_commission_detail_id, cc.contract_id, cc.contract_code, cc.plate_id, cc.year, cc.month, cc.rate, cc.contract_name, cc.billing_ratio, cc.amount, cc.is_original, cc.is_sub_project, p.plate_name FROM contract_commission_details cc LEFT JOIN plate_records p ON cc.plate_id = p.plate_id where contract_code =? and contract_name like ? and cc.plate_id =? and year =? and month =?" ;
	private final static String RESULTSETFIELDLIST = "contract_commission_detail_id,contract_id,contract_code,plate_id,year,month,rate,contract_name,billing_ratio,amount,is_original,is_sub_project,plate_name";
	private final static String[] fieldNames = { "contract_code", "contract_name", "plate_id", "year", "month"};
}
