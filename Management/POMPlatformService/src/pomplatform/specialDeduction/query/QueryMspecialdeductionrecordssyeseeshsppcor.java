package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseMspecialdeductionrecordssyeseeshsppcor;
import pomplatform.specialDeduction.bean.ConditionMspecialdeductionrecordssyeseeshsppcor;

public class QueryMspecialdeductionrecordssyeseeshsppcor extends AbstractQuery<BaseMspecialdeductionrecordssyeseeshsppcor, ConditionMspecialdeductionrecordssyeseeshsppcor>
{

	private static final Logger __logger = Logger.getLogger(QueryMspecialdeductionrecordssyeseeshsppcor.class);

	public QueryMspecialdeductionrecordssyeseeshsppcor() throws java.sql.SQLException 
	{
		setParameterNumber(11);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdr.special_deduction_record_id");
	}

	@Override
	public BaseCollection<BaseMspecialdeductionrecordssyeseeshsppcor> executeQuery( KeyValuePair[] replacements, ConditionMspecialdeductionrecordssyeseeshsppcor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getYear(), 
				condition.getEmployeId(), 
				condition.getSpecialDeductionTypeId(), 
				condition.getEducationType(), 
				condition.getEducationStage(), 
				condition.getSingleChild(), 
				condition.getHouseFirst(), 
				condition.getSchooling(), 
				condition.getProcessStatus(), 
				condition.getPlateId(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseMspecialdeductionrecordssyeseeshsppcor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMspecialdeductionrecordssyeseeshsppcor __base = new BaseMspecialdeductionrecordssyeseeshsppcor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setIsEnable(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSchooling(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeductionPercentage(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEducationType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEducationStage(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setHouseFirst(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSingleChild(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
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

	private final static String __SQLText = "SELECT sdr.special_deduction_record_id, sdr.employe_id, sdr.employee_name, sdr.plate_id, sdr.company_id, sdr.create_date, sdr.is_enable, sdr.remark, sdd.special_deduction_detail_id, sdd.parent_id, sdd.schooling, sdd.start_date, sdd.end_date, sdd.deduction_percentage, sdd.amount, sdd.num, sdd.education_type, sdd.education_stage, sdd.house_first, sdd.single_child, sdd.special_deduction_type_id, sdd.city, spi.process_status FROM special_deduction_records sdr LEFT JOIN special_deduction_details sdd ON sdr.special_deduction_record_id = sdd.parent_id LEFT JOIN system_process_instances spi ON spi.business_id = sdr.special_deduction_record_id WHERE spi.process_type = 58  AND sdr.employee_name =? AND sdr.employe_id =? AND sdd.special_deduction_type_id =? AND sdd.education_type =? AND sdd.education_stage =? AND sdd.single_child =? AND sdd.house_first=? AND sdd.schooling=? AND spi.process_status =? AND sdr.plate_id =? AND sdr.company_id =?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_record_id,employe_id,employee_name,plate_id,company_id,create_date,is_enable,remark,special_deduction_detail_id,parent_id,schooling,start_date,end_date,deduction_percentage,amount,num,education_type,education_stage,house_first,single_child,special_deduction_type_id,city,process_status";
	private final static String[] fieldNames = { "year", "employe_id", "special_deduction_type_id", "education_type", "education_stage", "single_child", "house_first", "schooling", "process_status", "plate_id", "company_id"};
}
