package pomplatform.k3voucher.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.k3voucher.bean.BaseBankTransVoucherInfo;
import pomplatform.k3voucher.bean.ConditionBankTransVoucherInfo;

public class QueryBankTransVoucherInfo extends AbstractQuery<BaseBankTransVoucherInfo, ConditionBankTransVoucherInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryBankTransVoucherInfo.class);

	public QueryBankTransVoucherInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cm.card_manage_id");
	}

	@Override
	public BaseCollection<BaseBankTransVoucherInfo> executeQuery( KeyValuePair[] replacements, ConditionBankTransVoucherInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyId(), 
				condition.getTransYear(), 
				condition.getTransMonth()
			);
	}

	@Override
	public BaseBankTransVoucherInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseBankTransVoucherInfo __base = new BaseBankTransVoucherInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCardManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDebit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCredit(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT cm.card_manage_id, cti.trscod as trans_code, cti.trsamtd as debit, cti.trsamtc as credit, concat(to_char(cti.trans_date, 'YYYYMMDD'), cti.naryur) as remark FROM cmbc_trans_info cti LEFT JOIN cmbc_accout_info cai ON cti.bank_account = cai.accnbr LEFT JOIN company_records cr ON cai.accnam = cr.company_name LEFT JOIN card_manages cm on cti.bank_account = cm.bank_account WHERE cr.company_record_id = ? and extract(year from cti.trans_date) = ? and extract(month from cti.trans_date) = ? and cti.trscod in ('FEZZ', 'FENC', 'IINT')" ;
	private final static String RESULTSETFIELDLIST = "card_manage_id,trans_code,debit,credit,remark";
	private final static String[] fieldNames = { "company_id", "trans_year", "trans_month"};
}
