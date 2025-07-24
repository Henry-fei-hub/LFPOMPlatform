package pomplatform.project.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.project.bean.BaseSprojectpricechangedrecordcppor;
import pomplatform.project.bean.ConditionSprojectpricechangedrecordcppor;

public class QuerySprojectpricechangedrecordcppor extends AbstractQuery<BaseSprojectpricechangedrecordcppor, ConditionSprojectpricechangedrecordcppor>
{

	private static final Logger __logger = Logger.getLogger(QuerySprojectpricechangedrecordcppor.class);

	public QuerySprojectpricechangedrecordcppor() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ppcr.project_price_changed_record_id");
	}

	@Override
	public BaseCollection<BaseSprojectpricechangedrecordcppor> executeQuery( KeyValuePair[] replacements, ConditionSprojectpricechangedrecordcppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getContractCode(), 
				condition.getProjectPriceChangedRecordId(), 
				condition.getProjectId(), 
				condition.getPlateId(), 
				condition.getDepartmentId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getRecordDate(), 
				condition.getRecordTime(), 
				condition.getSubsidiesType(), 
				condition.getOperateEmployeeId()
			);
	}

	@Override
	public BaseSprojectpricechangedrecordcppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSprojectpricechangedrecordcppor __base = new BaseSprojectpricechangedrecordcppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectPriceChangedRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRecordDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRecordTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSubsidiesType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setString(count++, GenericBase.__getString(args[6]));
		if(args[7] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
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

	private final static String __SQLText = "select ppcr.project_price_changed_record_id, ppcr.project_id, ppcr.contract_code, ppcr.plate_id, ppcr.department_id, ppcr.year, ppcr.month, ppcr.record_date, ppcr.record_time, ppcr.money, ppcr.subsidies_type, ppcr.operate_employee_id, ppcr.remark from project_price_changed_records ppcr where ppcr.contract_code like ? and ppcr.project_price_changed_record_id = ? and ppcr.project_id = ? and ppcr.plate_id = ? and ppcr.department_id = ? and ppcr.year = ? and ppcr.month = ? and ppcr.record_date = ? and ppcr.record_time = ? and ppcr.subsidies_type = ? and ppcr.operate_employee_id = ? order by ppcr.record_time desc" ;
	private final static String RESULTSETFIELDLIST = "project_price_changed_record_id,project_id,contract_code,plate_id,department_id,year,month,record_date,record_time,money,subsidies_type,operate_employee_id,remark";
	private final static String[] fieldNames = { "contract_code", "project_price_changed_record_id", "project_id", "plate_id", "department_id", "year", "month", "record_date", "record_time", "subsidies_type", "operate_employee_id"};
}
