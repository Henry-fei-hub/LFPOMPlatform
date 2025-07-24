package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractAmountAnalyze;
import pomplatform.contract.bean.ConditionContractAmountAnalyze;

public class QueryContractAmountAnalyze extends AbstractQuery<BaseContractAmountAnalyze, ConditionContractAmountAnalyze>
{

	private static final Logger __logger = Logger.getLogger(QueryContractAmountAnalyze.class);

	public QueryContractAmountAnalyze() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.plate_id");
	}

	@Override
	public BaseCollection<BaseContractAmountAnalyze> executeQuery( KeyValuePair[] replacements, ConditionContractAmountAnalyze condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractSigningStatus(), 
				condition.getYear(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseContractAmountAnalyze generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractAmountAnalyze __base = new BaseContractAmountAnalyze();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractYear(GenericBase.__getDouble(val));
		if((val = __data[count++]) != null) __base.setJanAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFebAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMarAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAprAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMayAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJunAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setJulAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAugAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSeptAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOctAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNovAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDecAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select c.plate_id, c.contract_year, sum(one) as jan_amount, sum(two) as feb_amount, sum(three) as mar_amount, sum(four) as apr_amount, sum(five) as may_amount, sum(six) as jun_amount, sum(seven) as jul_amount, sum(eight) as aug_amount, sum(nine) as sept_amount, sum(ten) as oct_amount, sum(eleven) as nov_amount, sum(twelve) as dec_amount, (sum(one) + sum(two) + sum(three) + sum(four) + sum(five) + sum(six) + sum(seven) + sum(eight) + sum(nine) + sum(ten) + sum(eleven) + sum(twelve)) as total_amount from ( select b.plate_id, extract(year from a.contract_date) as contract_year, case when extract(month from a.contract_date) = 1 then sum(b.sheet_amount) else 0 end as one, case when extract(month from a.contract_date) = 2 then sum(b.sheet_amount) else 0 end as two, case when extract(month from a.contract_date) = 3 then sum(b.sheet_amount) else 0 end as three, case when extract(month from a.contract_date) = 4 then sum(b.sheet_amount) else 0 end as four, case when extract(month from a.contract_date) = 5 then sum(b.sheet_amount) else 0 end as five, case when extract(month from a.contract_date) = 6 then sum(b.sheet_amount) else 0 end as six, case when extract(month from a.contract_date) = 7 then sum(b.sheet_amount) else 0 end as seven, case when extract(month from a.contract_date) = 8 then sum(b.sheet_amount) else 0 end as eight, case when extract(month from a.contract_date) = 9 then sum(b.sheet_amount) else 0 end as nine, case when extract(month from a.contract_date) = 10 then sum(b.sheet_amount) else 0 end as ten, case when extract(month from a.contract_date) = 11 then sum(b.sheet_amount) else 0 end as eleven, case when extract(month from a.contract_date) = 12 then sum(b.sheet_amount) else 0 end as twelve from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id where a.contract_signing_status = ? and extract(year from a.contract_date) = ? and b.plate_id = ? group by b.plate_id, extract(year from a.contract_date), extract(month from a.contract_date) ) c group by c.plate_id, c.contract_year order by c.contract_year desc, c.plate_id" ;
	private final static String RESULTSETFIELDLIST = "plate_id,contract_year,jan_amount,feb_amount,mar_amount,apr_amount,may_amount,jun_amount,jul_amount,aug_amount,sept_amount,oct_amount,nov_amount,dec_amount,total_amount";
	private final static String[] fieldNames = { "contract_signing_status", "year", "plate_id"};
}
