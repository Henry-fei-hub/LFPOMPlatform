package pomplatform.client.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.client.specialDeduction.bean.BaseSspecialdeductionrecordsssor;
import pomplatform.client.specialDeduction.bean.ConditionSspecialdeductionrecordsssor;

public class QuerySspecialdeductionrecordsssor extends AbstractQuery<BaseSspecialdeductionrecordsssor, ConditionSspecialdeductionrecordsssor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductionrecordsssor.class);

	public QuerySspecialdeductionrecordsssor() throws java.sql.SQLException 
	{
		setParameterNumber(19);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductionrecordsssor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductionrecordsssor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getReason(), 
				condition.getRemark(), 
				condition.getProcessType(), 
				condition.getEmployeId(), 
				condition.getDeparmentId(), 
				condition.getCompanyId(), 
				condition.getSpecialDeductionRecordId(), 
				condition.getSpecialDeductionRecordName(), 
				condition.getSpecialDeductionType(), 
				condition.getSpecialDeductionEducation(), 
				condition.getSpecialDeductionSupOld(), 
				condition.getSpecialDeductionId(), 
				condition.getAlternateField1(), 
				condition.getAlternateField2(), 
				condition.getAlternateField3(), 
				condition.getIsEnable(), 
				condition.getStartDate(), 
				condition.getEndDate()
			);
	}

	@Override
	public BaseSspecialdeductionrecordsssor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductionrecordsssor __base = new BaseSspecialdeductionrecordsssor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTime(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionEducation(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEducationAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionSupOld(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupOldAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionFileUrl(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDeparmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setString(count++, GenericBase.__getString(args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setInt(count++, GenericBase.__getInt(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
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

	private final static String __SQLText = "select sdr.special_deduction_record_id, sdr.special_deduction_record_name, sdr.amount, sdr.num, sdr.special_deduction_type, sdr.special_deduction_time, sdr.special_deduction_education, sdr.education_amount, sdr.special_deduction_sup_old, sdr.sup_old_amount, sdr.special_deduction_id, sdr.special_deduction_file_url, sdr.alternate_field1, sdr.alternate_field2, sdr.alternate_field3, sdr.is_enable, sdr.start_date, sdr.end_date, sdr.create_date, sdr.process_type, sdr.employe_id, sdr.employee_no, sdr.deparment_id, sdr.company_id, sdr.reason, sdr.remark from special_deduction_records sdr WHERE sdr.employee_no like ? and sdr.reason like ? and sdr.remark like ? and sdr.process_type = ? and sdr.employe_id = ? and sdr.deparment_id = ? and sdr.company_id = ? and sdr.special_deduction_record_id =? AND sdr.special_deduction_record_name LIKE ? AND sdr.special_deduction_type =? AND sdr.special_deduction_education =? AND sdr.special_deduction_sup_old =? AND sdr.special_deduction_id =? AND sdr.alternate_field1 LIKE ? AND sdr.alternate_field2 LIKE ? AND sdr.alternate_field3 LIKE ? AND sdr.is_enable =? AND to_char(create_date,'yyyy-mm-dd') >=? and to_char(create_date,'yyyy-mm-dd') <=?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,special_deduction_record_name,amount,num,special_deduction_type,special_deduction_time,special_deduction_education,education_amount,special_deduction_sup_old,sup_old_amount,special_deduction_id,special_deduction_file_url,alternate_field1,alternate_field2,alternate_field3,is_enable,start_date,end_date,create_date,process_type,employe_id,employee_no,deparment_id,company_id,reason,remark";
	private final static String[] fieldNames = { "employee_no", "reason", "remark", "process_type", "employe_id", "deparment_id", "company_id", "special_deduction_record_id", "special_deduction_record_name", "special_deduction_type", "special_deduction_education", "special_deduction_sup_old", "special_deduction_id", "alternate_field1", "alternate_field2", "alternate_field3", "is_enable", "start_date", "end_date"};
}
