package pomplatform.contract.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contract.bean.BaseContractAmountAnalyzeDetail;
import pomplatform.contract.bean.ConditionContractAmountAnalyzeDetail;

public class QueryContractAmountAnalyzeDetail extends AbstractQuery<BaseContractAmountAnalyzeDetail, ConditionContractAmountAnalyzeDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryContractAmountAnalyzeDetail.class);

	public QueryContractAmountAnalyzeDetail() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.contract_id");
	}

	@Override
	public BaseCollection<BaseContractAmountAnalyzeDetail> executeQuery( KeyValuePair[] replacements, ConditionContractAmountAnalyzeDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractSigningStatus(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseContractAmountAnalyzeDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractAmountAnalyzeDetail __base = new BaseContractAmountAnalyzeDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
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

	private final static String __SQLText = "select a.contract_id, a.contract_code, a.contract_date, b.contract_code as project_code, b.project_name, c.plate_name, b.sheet_amount from contracts a LEFT JOIN projects b on a.contract_id = b.contract_id LEFT JOIN plate_records c on b.plate_id = c.plate_id where a.contract_signing_status = ? and extract(year from contract_date) = ? and extract(month from contract_date) = ? and b.plate_id = ? order by a.contract_code" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_date,project_code,project_name,plate_name,sheet_amount";
	private final static String[] fieldNames = { "contract_signing_status", "year", "month", "plate_id"};
}
