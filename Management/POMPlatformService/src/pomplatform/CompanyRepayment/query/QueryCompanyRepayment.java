package pomplatform.CompanyRepayment.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.CompanyRepayment.bean.BaseCompanyRepayment;
import pomplatform.CompanyRepayment.bean.ConditionCompanyRepayment;

public class QueryCompanyRepayment extends AbstractQuery<BaseCompanyRepayment, ConditionCompanyRepayment>
{

	private static final Logger __logger = Logger.getLogger(QueryCompanyRepayment.class);

	public QueryCompanyRepayment() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.plate_id");
	}

	@Override
	public BaseCollection<BaseCompanyRepayment> executeQuery( KeyValuePair[] replacements, ConditionCompanyRepayment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId()
			);
	}

	@Override
	public BaseCompanyRepayment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCompanyRepayment __base = new BaseCompanyRepayment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateOfArrears(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT a.plate_id,coalesce(a.company_loan ,0)+coalesce( b.company_repayment,0) AS plate_of_arrears FROM (SELECT plate_id,sum(integral) AS company_loan FROM company_integral_records where flag=1 GROUP BY plate_id,flag) AS a LEFT JOIN (SELECT plate_id,-sum(integral) AS company_repayment FROM company_integral_records WHERE flag=2 GROUP BY plate_id,flag) AS b ON a.plate_id=b.plate_id WHERE a.plate_id= ?" ;
	private final static String RESULTSETFIELDLIST = "plate_id,plate_of_arrears";
	private final static String[] fieldNames = { "plate_id"};
}
