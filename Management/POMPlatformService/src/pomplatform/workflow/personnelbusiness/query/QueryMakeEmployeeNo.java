package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseMakeEmployeeNo;
import pomplatform.workflow.personnelbusiness.bean.ConditionMakeEmployeeNo;

public class QueryMakeEmployeeNo extends AbstractQuery<BaseMakeEmployeeNo, ConditionMakeEmployeeNo>
{

	private static final Logger __logger = Logger.getLogger(QueryMakeEmployeeNo.class);

	public QueryMakeEmployeeNo() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("(SELECT company_code FROM company_records WHERE company_record_id = :company_record_id) AS company_code");
	}

	@Override
	public BaseCollection<BaseMakeEmployeeNo> executeQuery( KeyValuePair[] replacements, ConditionMakeEmployeeNo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCompanyRecordId(), 
				condition.getPlateId(), 
				condition.getPlateId()
			);
	}

	@Override
	public BaseMakeEmployeeNo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMakeEmployeeNo __base = new BaseMakeEmployeeNo();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCompanyCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setInt(count++, GenericBase.__getInt(args[1]));
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
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

	private final static String __SQLText = "SELECT (SELECT company_code FROM company_records WHERE company_record_id = ?) AS company_code, (SELECT hr_code FROM plate_records WHERE plate_id = ?) as plate_code, (SELECT CAST((MAX(CAST((substr(e.employee_no,5,7)) AS INTEGER))+1) AS VARCHAR) FROM employees e LEFT JOIN plate_records pr ON e.plate_id = pr.plate_id WHERE e.employee_id > 0 AND substring(e.employee_no,1,2)~'^[A-Za-z]+$' AND substring(e.employee_no,3,2) = (SELECT hr_code FROM plate_records WHERE plate_id = ?)) AS num" ;
	private final static String RESULTSETFIELDLIST = "company_code,plate_code,num";
	private final static String[] fieldNames = { "company_record_id", "plate_id", "plate_id"};
}
