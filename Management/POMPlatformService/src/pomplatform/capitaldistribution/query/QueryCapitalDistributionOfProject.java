package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseCapitalDistributionOfProject;
import pomplatform.capitaldistribution.bean.ConditionCapitalDistributionOfProject;

public class QueryCapitalDistributionOfProject extends AbstractQuery<BaseCapitalDistributionOfProject, ConditionCapitalDistributionOfProject>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalDistributionOfProject.class);

	public QueryCapitalDistributionOfProject() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_distribution_id");
	}

	@Override
	public BaseCollection<BaseCapitalDistributionOfProject> executeQuery( KeyValuePair[] replacements, ConditionCapitalDistributionOfProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getProjectContractCode(), 
				condition.getProjectName(), 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getPlateId(),
				condition.getCapitalId()
			);
	}

	@Override
	public BaseCapitalDistributionOfProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalDistributionOfProject __base = new BaseCapitalDistributionOfProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT a.capital_distribution_id, b.contract_code, a.contract_id, a.type, a.capital_id, a.project_id, d.contract_code as project_contract_code, d.project_name, a.total_amount, a.distribution_amount, c.happen_date, a.create_time, c.remark, a.plate_id from capital_distributions a LEFT JOIN contracts b on a.contract_id = b.contract_id and a.project_id is not null LEFT JOIN capitals c on a.capital_id = c.capital_id LEFT JOIN projects d on a.project_id = d.project_id WHERE b.contract_code like ? and b.contract_name like ? and d.contract_code like ? and d.project_name like ? and c.happen_date >= ? and c.happen_date < ? and a.plate_id = ? and a.capital_id = ? and a.project_id is not null and a.delete_flag = 0 ORDER BY a.create_time desc, b.contract_code, d.contract_code" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_id,contract_code,contract_id,type,capital_id,project_id,project_contract_code,project_name,total_amount,distribution_amount,happen_date,create_time,remark,plate_id";
	private final static String[] fieldNames = { "contract_code", "contract_name", "project_contract_code", "project_name", "start_date", "end_date", "plate_id", "capital_id"};
}
