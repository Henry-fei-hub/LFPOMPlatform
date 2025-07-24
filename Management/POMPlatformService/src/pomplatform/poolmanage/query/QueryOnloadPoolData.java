package pomplatform.poolmanage.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.poolmanage.bean.BaseOnloadPoolData;
import pomplatform.poolmanage.bean.ConditionOnloadPoolData;

public class QueryOnloadPoolData extends AbstractQuery<BaseOnloadPoolData, ConditionOnloadPoolData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnloadPoolData.class);

	public QueryOnloadPoolData() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("A .pool_manage_id");
	}

	@Override
	public BaseCollection<BaseOnloadPoolData> executeQuery( KeyValuePair[] replacements, ConditionOnloadPoolData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPoolName(), 
				condition.getRegion(), 
				condition.getBusinessType(), 
				condition.getPoolType()
			);
	}

	@Override
	public BaseOnloadPoolData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnloadPoolData __base = new BaseOnloadPoolData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPoolManageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPoolName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegion(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPoolType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPoolEmployees(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT A .pool_manage_id, A.pool_name, A.region, A.business_type, A.pool_type, ( SELECT array_to_string( ARRAY ( SELECT e.employee_name FROM pool_manage_employees pe LEFT JOIN employees e ON pe.employee_id = e.employee_id WHERE pe.pool_manage_id = A.pool_manage_id ), ',' )) AS pool_employees, A.remark FROM pool_manages A WHERE A.pool_name LIKE ? AND A.region =? AND A.business_type =? AND A.pool_type =? ORDER BY A.pool_manage_id" ;
	private final static String RESULTSETFIELDLIST = "pool_manage_id,pool_name,region,business_type,pool_type,pool_employees,remark";
	private final static String[] fieldNames = { "pool_name", "region", "business_type", "pool_type"};
}
