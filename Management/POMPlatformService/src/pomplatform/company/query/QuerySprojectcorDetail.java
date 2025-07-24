package pomplatform.company.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.company.bean.BaseSprojectcorDetail;
import pomplatform.company.bean.ConditionSprojectcorDetail;

public class QuerySprojectcorDetail extends AbstractQuery<BaseSprojectcorDetail, ConditionSprojectcorDetail>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectcorDetail.class);

	public QuerySprojectcorDetail() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("contract_id");
	}

	@Override
	public BaseCollection<BaseSprojectcorDetail> executeQuery( KeyValuePair[] replacements, ConditionSprojectcorDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractId()
			);
	}

	@Override
	public BaseSprojectcorDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectcorDetail __base = new BaseSprojectcorDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSheetAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalIntegral(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "SELECT contract_id,project_id,contract_code,project_code,project_name,sheet_amount,total_integral FROM projects WHERE contract_id = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,project_id,contract_code,project_code,project_name,sheet_amount,total_integral";
	private final static String[] fieldNames = { "contract_id"};
}
