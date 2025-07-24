package pomplatform.projectintegralchangerecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectintegralchangerecord.bean.BaseMprojectintegralchangerecord;
import pomplatform.projectintegralchangerecord.bean.ConditionMprojectintegralchangerecord;

public class QueryMprojectintegralchangerecord extends AbstractQuery<BaseMprojectintegralchangerecord, ConditionMprojectintegralchangerecord>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectintegralchangerecord.class);

	public QueryMprojectintegralchangerecord() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("(case when b.photo is null then concat(c.image_path");
	}

	@Override
	public BaseCollection<BaseMprojectintegralchangerecord> executeQuery( KeyValuePair[] replacements, ConditionMprojectintegralchangerecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getPlateEmployeeId()
			);
	}

	@Override
	public BaseMprojectintegralchangerecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectintegralchangerecord __base = new BaseMprojectintegralchangerecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralChangeRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBeforeProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAfterProjectIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBeforeReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAfterReserveIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTransferIntegral(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTransferDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateEmployeeId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setInt(count++, (java.lang.Integer)args[2]);
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

	private final static String __SQLText = "select (case when b.photo is null then concat(c.image_path,'photo_view.png') else b.photo end) as photo ,a.* from project_integral_change_records a left join employees b on a.plate_employee_id = b. employee_id left join system_config c on c.system_config_id = 1 where a.project_id = ? and a.plate_id = ? and a.plate_employee_id = ? order by a.project_integral_change_record_id desc,a.plate_id asc" ;
	private final static String RESULTSETFIELDLIST = "photo,project_integral_change_record_id,project_id,before_project_integral,after_project_integral,before_reserve_integral,after_reserve_integral,transfer_integral,transfer_date,plate_id,plate_employee_id,remark";
	private final static String[] fieldNames = { "project_id", "plate_id", "plate_employee_id"};
}
