package pomplatform.client.workflow.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.client.workflow.specialDeduction.bean.BaseSpecialDeductionInformation;
import pomplatform.client.workflow.specialDeduction.bean.ConditionSpecialDeductionInformation;

public class QuerySpecialDeductionInformation extends AbstractQuery<BaseSpecialDeductionInformation, ConditionSpecialDeductionInformation>
{

	private static final Logger __logger = Logger.getLogger(QuerySpecialDeductionInformation.class);

	public QuerySpecialDeductionInformation() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseSpecialDeductionInformation> executeQuery( KeyValuePair[] replacements, ConditionSpecialDeductionInformation condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeId()
			);
	}

	@Override
	public BaseSpecialDeductionInformation generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpecialDeductionInformation __base = new BaseSpecialDeductionInformation();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDeparmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "select sdr.special_deduction_record_id, sdr.employe_id, sdr.employee_name, sdr.start_date, sdr.end_date, sdr.process_type, sdr.deparment_id, sdr.plate_id, sdr.company_id, sdr.create_date, sdr.is_enable, sdr.remark from special_deduction_records sdr where sdr.employe_id = ?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,employe_id,employee_name,start_date,end_date,process_type,deparment_id,plate_id,company_id,create_date,is_enable,remark";
	private final static String[] fieldNames = { "employe_id"};
}
