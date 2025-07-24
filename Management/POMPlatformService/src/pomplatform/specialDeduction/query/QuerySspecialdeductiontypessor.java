package pomplatform.specialDeduction.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.specialDeduction.bean.BaseSspecialdeductiontypessor;
import pomplatform.specialDeduction.bean.ConditionSspecialdeductiontypessor;

public class QuerySspecialdeductiontypessor extends AbstractQuery<BaseSspecialdeductiontypessor, ConditionSspecialdeductiontypessor>
{

	private static final Logger __logger = Logger.getLogger(QuerySspecialdeductiontypessor.class);

	public QuerySspecialdeductiontypessor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("sdt.special_deduction_type_id");
	}

	@Override
	public BaseCollection<BaseSspecialdeductiontypessor> executeQuery( KeyValuePair[] replacements, ConditionSspecialdeductiontypessor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSpecialDeductionTypeName(), 
				condition.getSpecialDeductionTypeId()
			);
	}

	@Override
	public BaseSspecialdeductiontypessor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSspecialdeductiontypessor __base = new BaseSspecialdeductiontypessor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSpecialDeductionTypeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setScopeApplication(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRangeApplication(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAmountDescription(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDateDescription(GenericBase.__getString(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
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

	private final static String __SQLText = "select sdt.special_deduction_type_id, sdt.special_deduction_type_name, sdt.scope_application, sdt.range_application, sdt.amount_description, sdt.date_description, sdt.is_enable, sdt.remark from special_deduction_types sdt where sdt.special_deduction_type_name like ? and sdt.special_deduction_type_id = ?" ;
	private final static String RESULTSETFIELDLIST = "special_deduction_type_id,special_deduction_type_name,scope_application,range_application,amount_description,date_description,is_enable,remark";
	private final static String[] fieldNames = { "special_deduction_type_name", "special_deduction_type_id"};
}
