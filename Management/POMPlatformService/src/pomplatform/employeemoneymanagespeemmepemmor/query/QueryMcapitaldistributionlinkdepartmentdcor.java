package pomplatform.employeemoneymanagespeemmepemmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseMcapitaldistributionlinkdepartmentdcor;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionMcapitaldistributionlinkdepartmentdcor;

public class QueryMcapitaldistributionlinkdepartmentdcor extends AbstractQuery<BaseMcapitaldistributionlinkdepartmentdcor, ConditionMcapitaldistributionlinkdepartmentdcor>
{

	private static final Logger __logger = Logger.getLogger(QueryMcapitaldistributionlinkdepartmentdcor.class);

	public QueryMcapitaldistributionlinkdepartmentdcor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("cd.capital_distribution_link_department_id");
	}

	@Override
	public BaseCollection<BaseMcapitaldistributionlinkdepartmentdcor> executeQuery( KeyValuePair[] replacements, ConditionMcapitaldistributionlinkdepartmentdcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCapitalId()
			);
	}

	@Override
	public BaseMcapitaldistributionlinkdepartmentdcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMcapitaldistributionlinkdepartmentdcor __base = new BaseMcapitaldistributionlinkdepartmentdcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCapitalDistributionLinkDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCapitalDistributionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCapitalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT cd.capital_distribution_link_department_id, cd.capital_distribution_id, cd.department_id, cd.money, de.department_name, cd.capital_id, cd.create_time FROM capital_distribution_link_departments cd LEFT JOIN departments de ON de.department_id = cd.department_id WHERE cd.capital_id = ?" ;
	private final static String RESULTSETFIELDLIST = "capital_distribution_link_department_id,capital_distribution_id,department_id,money,department_name,capital_id,create_time";
	private final static String[] fieldNames = { "capital_id"};
}
