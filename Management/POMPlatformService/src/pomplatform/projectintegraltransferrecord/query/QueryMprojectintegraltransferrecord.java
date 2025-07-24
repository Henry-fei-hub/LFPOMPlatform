package pomplatform.projectintegraltransferrecord.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectintegraltransferrecord.bean.BaseMprojectintegraltransferrecord;
import pomplatform.projectintegraltransferrecord.bean.ConditionMprojectintegraltransferrecord;

public class QueryMprojectintegraltransferrecord extends AbstractQuery<BaseMprojectintegraltransferrecord, ConditionMprojectintegraltransferrecord>
{

	private static final Logger __logger = Logger.getLogger(QueryMprojectintegraltransferrecord.class);

	public QueryMprojectintegraltransferrecord() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("(case when b.photo is null then concat(c.image_path");
	}

	@Override
	public BaseCollection<BaseMprojectintegraltransferrecord> executeQuery( KeyValuePair[] replacements, ConditionMprojectintegraltransferrecord condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getFromProjectId(), 
				condition.getToProjectId(), 
				condition.getPlateId(), 
				condition.getPlateEmployeeId()
			);
	}

	@Override
	public BaseMprojectintegraltransferrecord generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMprojectintegraltransferrecord __base = new BaseMprojectintegraltransferrecord();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectIntegralTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setFromProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setToProjectId(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setInt(count++, (java.lang.Integer)args[3]);
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

	private final static String __SQLText = "select (case when b.photo is null then concat(c.image_path,'photo_view.png') else b.photo end) as photo ,a.* from project_integral_transfer_records a left join employees b on a.plate_employee_id = b. employee_id left join system_config c on c.system_config_id = 1 where a.from_project_id = ? and a.to_project_id = ? and a.plate_id = ? and a.plate_employee_id = ? order by a.project_integral_transfer_record_id desc,a.plate_id asc" ;
	private final static String RESULTSETFIELDLIST = "photo,project_integral_transfer_record_id,from_project_id,to_project_id,transfer_integral,transfer_date,plate_id,plate_employee_id,remark";
	private final static String[] fieldNames = { "from_project_id", "to_project_id", "plate_id", "plate_employee_id"};
}
