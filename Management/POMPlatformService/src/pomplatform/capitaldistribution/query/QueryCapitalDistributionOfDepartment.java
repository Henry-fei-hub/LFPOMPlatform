package pomplatform.capitaldistribution.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitaldistribution.bean.BaseCapitalDistributionOfDepartment;
import pomplatform.capitaldistribution.bean.ConditionCapitalDistributionOfDepartment;

public class QueryCapitalDistributionOfDepartment extends AbstractQuery<BaseCapitalDistributionOfDepartment, ConditionCapitalDistributionOfDepartment>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalDistributionOfDepartment.class);

	public QueryCapitalDistributionOfDepartment() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.capital_distribution_id");
	}

	@Override
	public BaseCollection<BaseCapitalDistributionOfDepartment> executeQuery( KeyValuePair[] replacements, ConditionCapitalDistributionOfDepartment condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getPlateId(), 
				condition.getStartDate(), 
				condition.getEndDate(),
				condition.getCapitalId()
			);
	}

	@Override
	public BaseCapitalDistributionOfDepartment generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalDistributionOfDepartment __base = new BaseCapitalDistributionOfDepartment();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHappenDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalDistributionAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setLeftAmount(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT aa.*, (aa.total_amount - aa.total_distribution_amount) as left_amount from (SELECT a.capital_distribution_id, b.contract_code, a.contract_id, a.type, a.capital_id, a.plate_id, a.total_amount, a.distribution_amount, c.happen_date, a.create_time, c.remark, a.project_id,d.project_manage_id, sum(a.distribution_amount) as total_distribution_amount from capital_distributions a LEFT JOIN contracts b on a.contract_id = b.contract_id LEFT JOIN capitals c on a.capital_id = c.capital_id LEFT JOIN projects d ON a.project_id = d.project_id WHERE b.contract_code like ? and b.contract_name like ? and a.plate_id = ? and c.happen_date >= ? and c.happen_date < ? and a.capital_id = ? and a.delete_flag = 0 group by a.capital_distribution_id, b.contract_code, a.contract_id, a.type, a.capital_id, a.plate_id, a.total_amount, a.distribution_amount, c.happen_date, a.create_time, c.remark, a.project_id,d.project_manage_id) aa ORDER BY aa.create_time desc, aa.contract_code" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_id,contract_code,contract_id,type,capital_id,id,total_amount,distribution_amount,happen_date,create_time,remark,project_id,project_manage_id,total_distribution_amount,left_amount";
	private final static String[] fieldNames = { "contract_code", "contract_name", "plate_id", "start_date", "end_date", "capital_id"};
}
