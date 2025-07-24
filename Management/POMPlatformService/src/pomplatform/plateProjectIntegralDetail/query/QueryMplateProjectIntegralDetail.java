package pomplatform.plateProjectIntegralDetail.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.plateProjectIntegralDetail.bean.BaseMplateProjectIntegralDetail;
import pomplatform.plateProjectIntegralDetail.bean.ConditionMplateProjectIntegralDetail;

public class QueryMplateProjectIntegralDetail extends AbstractQuery<BaseMplateProjectIntegralDetail, ConditionMplateProjectIntegralDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryMplateProjectIntegralDetail.class);

	public QueryMplateProjectIntegralDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.project_id");
	}

	@Override
	public BaseCollection<BaseMplateProjectIntegralDetail> executeQuery( KeyValuePair[] replacements, ConditionMplateProjectIntegralDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getSubContractCode(), 
				condition.getSubContractName()
			);
	}

	@Override
	public BaseMplateProjectIntegralDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMplateProjectIntegralDetail __base = new BaseMplateProjectIntegralDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSubContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAchieveIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setProjectIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSureIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setCostIntegral(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setSalaryIntegral(GenericBase.__getLong(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setString(count++, (java.lang.String)args[1]);
		if(args[2] != null) __statement.setString(count++, (java.lang.String)args[2]);
		if(args[3] != null) __statement.setString(count++, (java.lang.String)args[3]);
		if(args[4] != null) __statement.setString(count++, (java.lang.String)args[4]);
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

	private final static String __SQLText = "select a.project_id,a.project_code,b.sub_contract_code,b.sub_contract_name,a.project_name ,0 as achieve_integral,round(a.project_integral) as project_integral ,round(a.reserve_integral) as reserve_integral ,round((select sum(real_amount) from project_settlement_details where project_id = a.project_id group by project_id)) as sure_integral ,round((select sum(project_cost) from project_settlement_details where project_id = a.project_id group by project_id)) as cost_integral ,0 as salary_integral from projects a left join sub_contracts b on a.contract_code = b.sub_contract_code where a.plate_id = ? and a.project_code like ? and a.project_name like ? and b.sub_contract_code like ? and b.sub_contract_name like ? order by a.project_id desc" ;
	private final static String RESULTSETFIELDLIST = "project_id,project_code,sub_contract_code,sub_contract_name,project_name,achieve_integral,project_integral,reserve_integral,sure_integral,cost_integral,salary_integral";
	private final static String[] fieldNames = { "plate_id", "project_code", "project_name", "sub_contract_code", "sub_contract_name"};
}
