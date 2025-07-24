package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseDepartmentIdFindPlate;
import pomplatform.workflow.personnelbusiness.bean.ConditionDepartmentIdFindPlate;

public class QueryDepartmentIdFindPlate extends AbstractQuery<BaseDepartmentIdFindPlate, ConditionDepartmentIdFindPlate>
{

	private static final Logger __logger = Logger.getLogger(QueryDepartmentIdFindPlate.class);

	public QueryDepartmentIdFindPlate() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("*");
	}

	@Override
	public BaseCollection<BaseDepartmentIdFindPlate> executeQuery( KeyValuePair[] replacements, ConditionDepartmentIdFindPlate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseDepartmentIdFindPlate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseDepartmentIdFindPlate __base = new BaseDepartmentIdFindPlate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setManagerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setManagerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setOriginalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHeadcount(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setK3Code(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT * FROM departments WHERE department_id = ?" ;
	private final static String RESULTSETFIELDLIST = "department_id,department_name,abbreviation,manager_id,manager_name,parent_id,enabled,original_id,plate_id,is_headcount,k3_code";
	private final static String[] fieldNames = { "department_id"};
}
