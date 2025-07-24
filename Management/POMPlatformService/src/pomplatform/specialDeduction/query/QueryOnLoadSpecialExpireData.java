package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseOnLoadSpecialExpireData;
import pomplatform.specialDeduction.bean.ConditionOnLoadSpecialExpireData;

public class QueryOnLoadSpecialExpireData extends AbstractQuery<BaseOnLoadSpecialExpireData, ConditionOnLoadSpecialExpireData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSpecialExpireData.class);

	public QueryOnLoadSpecialExpireData() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSpecialExpireData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSpecialExpireData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeId(), 
				condition.getProcessStatus(), 
				condition.getMonth()
			);
	}

	@Override
	public BaseOnLoadSpecialExpireData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSpecialExpireData __base = new BaseOnLoadSpecialExpireData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeparmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT sdr.special_deduction_record_id, sdr.employe_id, sdr.deparment_id, sdr.plate_id, sdr.company_id, sdd.YEAR, sdd.special_deduction_type_id, sdt.special_deduction_type_name, sdd.create_date, sdd.start_date, sdd.end_date, spi.process_status FROM special_deduction_records sdr LEFT JOIN special_deduction_details sdd ON sdr.special_deduction_record_id = sdd.parent_id LEFT JOIN special_deduction_types sdt on sdt.special_deduction_type_id = sdd.special_deduction_type_id LEFT JOIN system_process_instances spi ON spi.business_id = sdr.special_deduction_record_id WHERE spi.process_type = 58 AND sdr.employee_name =? AND sdr.employe_id =? AND spi.process_status =? AND to_char( sdd.end_date, 'MM' ) =? ORDER BY special_deduction_type_id" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,employe_id,deparment_id,plate_id,company_id,year,special_deduction_type_id,special_deduction_type_name,create_date,start_date,end_date,process_status";
	private final static String[] fieldNames = { "year", "employe_id", "process_status", "month"};
}
