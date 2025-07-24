package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSspecialdeductionmonthdetailedpor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductionmonthdetailedpor;

public class QuerySspecialdeductionmonthdetailedpor extends AbstractQuery<BaseSspecialdeductionmonthdetailedpor, ConditionSspecialdeductionmonthdetailedpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductionmonthdetailedpor.class);

	public QuerySspecialdeductionmonthdetailedpor() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdmd.special_deduction_month_detail_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductionmonthdetailedpor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductionmonthdetailedpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getPlateId(), 
				condition.getYear(), 
				condition.getMonth(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseSspecialdeductionmonthdetailedpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductionmonthdetailedpor __base = new BaseSspecialdeductionmonthdetailedpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionMonthDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setYear(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeIds(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionDetailIds(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct1(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct2(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct3(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct4(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct5(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSpecialDuduct6(GenericBase.__getDecimal(val));
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
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
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

	private final static String __SQLText = "SELECT sdmd.special_deduction_month_detail_id, sdmd.employee_id, sdmd.employee_no, sdmd.department_id, sdmd.plate_id, sdmd.YEAR, sdmd.MONTH, sdmd.amount, sdmd.create_time, sdmd.special_deduction_type_ids, sdmd.special_deduction_detail_ids, sdmd.special_duduct_1, sdmd.special_duduct_2, sdmd.special_duduct_3, sdmd.special_duduct_4, sdmd.special_duduct_5, sdmd.special_duduct_6 FROM special_deduction_month_details sdmd WHERE sdmd.employee_id =? AND sdmd.department_id =? AND sdmd.plate_id =? AND sdmd.YEAR =? AND sdmd.MONTH =? AND sdmd.employee_no LIKE ?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_month_detail_id,employee_id,employee_no,department_id,plate_id,year,month,amount,create_time,special_deduction_type_ids,special_deduction_detail_ids,special_duduct_1,special_duduct_2,special_duduct_3,special_duduct_4,special_duduct_5,special_duduct_6";
	private final static String[] fieldNames = { "employee_id", "department_id", "plate_id", "YEAR", "MONTH", "employee_no"};
}
