package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseInsuranceAndHousingFundK3Voucher;
import pomplatform.k3voucher.bean.ConditionInsuranceAndHousingFundK3Voucher;

public class QueryInsuranceAndHousingFundK3Voucher extends AbstractQuery<BaseInsuranceAndHousingFundK3Voucher, ConditionInsuranceAndHousingFundK3Voucher>
{

	private static final Logger __logger = Logger.getLogger(QueryInsuranceAndHousingFundK3Voucher.class);

	public QueryInsuranceAndHousingFundK3Voucher() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("k3_voucher_id");
	}

	@Override
	public BaseCollection<BaseInsuranceAndHousingFundK3Voucher> executeQuery( KeyValuePair[] replacements, ConditionInsuranceAndHousingFundK3Voucher condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getLocked(), 
				condition.getVoucherType(),
				condition.getProjectId(),
				condition.getYear(), 
				condition.getMonth() 
			);
	}

	@Override
	public BaseInsuranceAndHousingFundK3Voucher generateBase(Object[] __data) throws java.sql.SQLException {
		BaseInsuranceAndHousingFundK3Voucher __base = new BaseInsuranceAndHousingFundK3Voucher();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setK3VoucherId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSequenceNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInternalSequenceNumber(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCodeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDebitSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreditSide(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSimplifyRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setVestingDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
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
		if(args[1] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT k3_voucher_id, company_id, sequence_number, internal_sequence_number, code_type, code_id, code, name, debit_side, credit_side, simplify_remark, vesting_date, locked from k3_vouchers where company_id = ? and locked = ? and voucher_type = ? and project_id = ? and EXTRACT(YEAR from vesting_date) = ? and EXTRACT(MONTH from vesting_date) = ?" ;
	private final static String RESULTSETFIELDLIST = "k3_voucher_id,company_id,sequence_number,internal_sequence_number,code_type,code_id,code,name,debit_side,credit_side,simplify_remark,vesting_date,locked";
	private final static String[] fieldNames = { "company_id", "locked", "voucher_type", "project_id", "year", "month"};
}
