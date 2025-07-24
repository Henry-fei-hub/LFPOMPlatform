package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseStracktalentsminimumarrangementmmpor;
import pomplatform.project.bean.ConditionStracktalentsminimumarrangementmmpor;

public class QueryStracktalentsminimumarrangementmmpor extends AbstractQuery<BaseStracktalentsminimumarrangementmmpor, ConditionStracktalentsminimumarrangementmmpor>
{

	private static final Logger __logger = Logger.getLogger(QueryStracktalentsminimumarrangementmmpor.class);

	public QueryStracktalentsminimumarrangementmmpor() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ttma.track_talents_minimum_arrangement_id");
	}

	@Override
	public BaseCollection<BaseStracktalentsminimumarrangementmmpor> executeQuery( KeyValuePair[] replacements, ConditionStracktalentsminimumarrangementmmpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinAmount(), 
				condition.getMaxAmount(), 
				condition.getPlateId(), 
				condition.getProjectType()
			);
	}

	@Override
	public BaseStracktalentsminimumarrangementmmpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStracktalentsminimumarrangementmmpor __base = new BaseStracktalentsminimumarrangementmmpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTrackTalentsMinimumArrangementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMinAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHighDesigner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMiddleDesigner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInitialDesigner(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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
		if(args[0] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[0]));
		if(args[1] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[1]));
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

	private final static String __SQLText = "select ttma.track_talents_minimum_arrangement_id, ttma.plate_id, ttma.project_type, ttma.max_amount, ttma.min_amount, ttma.high_designer, ttma.middle_designer, ttma.initial_designer, ttma.operate_employee_id, ttma.operate_time, ttma.remark from track_talents_minimum_arrangements ttma where ttma.min_amount <= ? and ttma.max_amount > ? and ttma.plate_id = ? and ttma.project_type = ?" ;
	private final static String RESULTSETFIELDLIST = "track_talents_minimum_arrangement_id,plate_id,project_type,max_amount,min_amount,high_designer,middle_designer,initial_designer,operate_employee_id,operate_time,remark";
	private final static String[] fieldNames = { "min_amount", "max_amount", "plate_id", "project_type"};
}
