package pomplatform.preprojecttransferrecordpors.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preprojecttransferrecordpors.bean.BaseForPreproJectTransFerrecordpor;
import pomplatform.preprojecttransferrecordpors.bean.ConditionForPreproJectTransFerrecordpor;

public class QueryForPreproJectTransFerrecordpor extends AbstractQuery<BaseForPreproJectTransFerrecordpor, ConditionForPreproJectTransFerrecordpor>
{

	private static final Logger __logger = Logger.getLogger(QueryForPreproJectTransFerrecordpor.class);

	public QueryForPreproJectTransFerrecordpor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pre_project_transfer_record_id");
	}

	@Override
	public BaseCollection<BaseForPreproJectTransFerrecordpor> executeQuery( KeyValuePair[] replacements, ConditionForPreproJectTransFerrecordpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPreProjectId(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseForPreproJectTransFerrecordpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseForPreproJectTransFerrecordpor __base = new BaseForPreproJectTransFerrecordpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransferEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "SELECT pre_project_transfer_record_id,pre_project_id,employee_id,transfer_employee_id,operate_employee_id,operate_time FROM pre_project_transfer_records p WHERE p.pre_project_id=? and p.employee_id=?" ;
	private final static String RESULTSETFIELDLIST = "pre_project_transfer_record_id,pre_project_id,employee_id,transfer_employee_id,operate_employee_id,operate_time";
	private final static String[] fieldNames = { "pre_project_id", "employee_id"};
}
