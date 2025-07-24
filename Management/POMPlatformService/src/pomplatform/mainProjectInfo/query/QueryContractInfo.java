package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseContractInfo;
import pomplatform.mainProjectInfo.bean.ConditionContractInfo;

public class QueryContractInfo extends AbstractQuery<BaseContractInfo, ConditionContractInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryContractInfo.class);

	public QueryContractInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c0.contract_id");
	}

	@Override
	public BaseCollection<BaseContractInfo> executeQuery( KeyValuePair[] replacements, ConditionContractInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getProjectCode()
			);
	}

	@Override
	public BaseContractInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseContractInfo __base = new BaseContractInfo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractFollower(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setString(count++, (java.lang.String)args[0]);
		if(args[1] != null) __statement.setString(count++, (java.lang.String)args[1]);
		if(args[2] != null) __statement.setString(count++, (java.lang.String)args[2]);
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

	private final static String __SQLText = "select c0.contract_id, c0.contract_code, c0.contract_name, c0.customer_name, c0.start_date, c0.end_date, c0.status, c0.signing_company_name, c0.project_code, c0.contract_type, c0.business_type, c0.project_type, c0.project_level, c0.total_project_time, c0.signing_money_sum, c0.design_areas, c0.contract_price, c0.project_address, c0.contract_follower, c0.remark, c0.contract_date from contracts c0 where c0.contract_code = ? and c0.contract_name = ? and c0.project_code = ?" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,signing_company_name,project_code,contract_type,business_type,project_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date";
	private final static String[] fieldNames = { "contract_code", "contract_name", "project_code"};
}
