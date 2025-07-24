package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseStargetrecordbytor;
import pomplatform.project.bean.ConditionStargetrecordbytor;

public class QueryStargetrecordbytor extends AbstractQuery<BaseStargetrecordbytor, ConditionStargetrecordbytor>
{

	private static final Logger __logger = Logger.getLogger(QueryStargetrecordbytor.class);

	public QueryStargetrecordbytor() throws java.sql.SQLException 
	{
		setParameterNumber(3);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("tr.target_record_id");
	}

	@Override
	public BaseCollection<BaseStargetrecordbytor> executeQuery( KeyValuePair[] replacements, ConditionStargetrecordbytor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getBusinessLine(), 
				condition.getYear(), 
				condition.getType()
			);
	}

	@Override
	public BaseStargetrecordbytor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseStargetrecordbytor __base = new BaseStargetrecordbytor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setTargetRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessLine(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTarget(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTargetStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOperateDate(GenericBase.__getDateFromSQL(val));
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

	private final static String __SQLText = "select tr.target_record_id, tr.business_line, tr.year, tr.month, tr.target, tr.target_str, tr.type, tr.remark, tr.operate_date from target_records tr where tr.business_line = ? and tr.year = ? and tr.type = ?" ;
	private final static String RESULTSETFIELDLIST = "target_record_id,business_line,year,month,target,target_str,type,remark,operate_date";
	private final static String[] fieldNames = { "business_line", "year", "type"};
}
