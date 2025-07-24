package pomplatform.contractInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.contractInfo.bean.BaseContractInfo;
import pomplatform.contractInfo.bean.ConditionContractInfo;

public class QueryContractInfo extends AbstractQuery<BaseContractInfo, ConditionContractInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryContractInfo.class);

	public QueryContractInfo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("c.contract_id");
	}

	@Override
	public BaseCollection<BaseContractInfo> executeQuery( KeyValuePair[] replacements, ConditionContractInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getProjectCode(), 
				condition.getBusinessType()
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
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalProjectTime(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSigningMoneySum(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDesignAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractFollower(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSigningCompanyName(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFlowStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setUpdateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select c.contract_id, c.contract_code, c.contract_name, c.customer_name, c.start_date, c.end_date, c.status, c.project_code, c.contract_type, c.business_type, c.project_level, c.total_project_time, c.signing_money_sum, c.design_areas, c.contract_price, c.project_address, c.contract_follower, c.remark, c.contract_date, c.signing_company_name, c.flow_status, c.create_time, c.update_time from contracts c where c.contract_code = ? and c.project_code = ? and c.business_type like ? order by c.update_time desc" ;
	private final static String RESULTSETFIELDLIST = "contract_id,contract_code,contract_name,customer_name,start_date,end_date,status,project_code,contract_type,business_type,project_level,total_project_time,signing_money_sum,design_areas,contract_price,project_address,contract_follower,remark,contract_date,signing_company_name,flow_status,create_time,update_time";
	private final static String[] fieldNames = { "contract_code", "project_code", "business_type"};
}
