package pomplatform.sProjectAdvanceRecord.query;

import delicacy.common.AbstractQuery;
import delicacy.common.BaseCollection;
import delicacy.common.GenericBase;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
import pomplatform.sProjectAdvanceRecord.bean.BaseprojectAdvanceDetail;
import pomplatform.sProjectAdvanceRecord.bean.ConditionprojectAdvanceDetail;

public class QueryprojectAdvanceDetail extends AbstractQuery<BaseprojectAdvanceDetail, ConditionprojectAdvanceDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryprojectAdvanceDetail.class);

	public QueryprojectAdvanceDetail() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("par.project_id");
	}

	@Override
	public BaseCollection<BaseprojectAdvanceDetail> executeQuery( KeyValuePair[] replacements, ConditionprojectAdvanceDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getContractCode(), 
				condition.getProjectName(), 
				condition.getFlag()
			);
	}

	@Override
	public BaseprojectAdvanceDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseprojectAdvanceDetail __base = new BaseprojectAdvanceDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAdvanceIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRemainingIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAssignedIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFlag(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "SELECT par.project_id, par.plate_id, p.contract_code, p.project_name, pr.plate_name, sum(par.advance_integral) AS advance_integral, sum(par.left_integral) AS remaining_integral, sum(par.advance_integral) - sum(par.left_integral) AS Assigned_integral, par.flag FROM project_advance_records par LEFT JOIN projects P ON P.project_id = par.project_id LEFT JOIN plate_records pr on pr.plate_id = par.plate_id where par.project_id =? and par.plate_id =? and p.contract_code =? and p.project_name like ? and par.flag =? GROUP BY par.project_id, par.flag, p.contract_code, p.project_name, par.advance_integral, pr.plate_name, par.project_id, par.plate_id, par.left_integral" ;
	private final static String RESULTSETFIELDLIST = "project_id,plate_id,contract_code,project_name,plate_name,advance_integral,remaining_integral,assigned_integral,flag";
	private final static String[] fieldNames = { "project_id", "plate_id", "contract_code", "project_name", "flag"};
}
