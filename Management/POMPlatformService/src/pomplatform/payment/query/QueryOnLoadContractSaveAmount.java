package pomplatform.payment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.payment.bean.BaseOnLoadContractSaveAmount;
import pomplatform.payment.bean.ConditionOnLoadContractSaveAmount;

public class QueryOnLoadContractSaveAmount extends AbstractQuery<BaseOnLoadContractSaveAmount, ConditionOnLoadContractSaveAmount>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadContractSaveAmount.class);

	public QueryOnLoadContractSaveAmount() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("b.revenue_plate_id as plate_id");
	}

	@Override
	public BaseCollection<BaseOnLoadContractSaveAmount> executeQuery( KeyValuePair[] replacements, ConditionOnLoadContractSaveAmount condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getYear()
			);
	}

	@Override
	public BaseOnLoadContractSaveAmount generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadContractSaveAmount __base = new BaseOnLoadContractSaveAmount();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractSave(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select b.revenue_plate_id as plate_id,a.year ,round(sum(((CASE WHEN a.sheet_amount > 0 THEN a.sheet_amount ELSE b.sheet_amount END)-total_tax_revenue)/1.06),2) as contract_save from revenue_statistical_records a LEFT JOIN projects b on a.project_id = b.project_id where b.revenue_plate_id > 0 and b.revenue_plate_id = ? and a.year = ? GROUP BY b.revenue_plate_id,a.year ORDER BY b.revenue_plate_id,a.year" ;
	private final static String RESULTSETFIELDLIST = "plate_id,year,contract_save";
	private final static String[] fieldNames = { "plate_id", "year"};
}
