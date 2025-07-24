package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseApplicationForFiling;
import pomplatform.workflow.personnel.bean.ConditionApplicationForFiling;


public class QueryApplicationForFiling extends AbstractQuery<BaseApplicationForFiling, ConditionApplicationForFiling>
{

	private static final Logger __logger = Logger.getLogger(QueryApplicationForFiling.class);

	public QueryApplicationForFiling() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT e.employee_id");
	}

	@Override
	public BaseCollection<BaseApplicationForFiling> executeQuery( KeyValuePair[] replacements, ConditionApplicationForFiling condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseApplicationForFiling generateBase(Object[] __data) throws java.sql.SQLException {
		BaseApplicationForFiling __base = new BaseApplicationForFiling();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBirth(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setAge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartWorkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setGraduatedSchool(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSpecialty(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCardAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTechnicalAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducationProof(GenericBase.__getString(val));
		return __base;
	}

	@Override
	public int setStatementParameters(int count, Object ... args) throws java.sql.SQLException {

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

	private final static String __SQLText = "select DISTINCT e.employee_id,e.employee_name,e.birth,e.age,e.start_work_date,e.onboard_date,A.graduated_school,A.specialty,e.card_attachment,e.technical_attachment,e.education_proof from employees e LEFT JOIN employee_education_informations A ON e.employee_id =A.employee_id WHERE e.employee_id=?" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_name,birth,age,start_work_date,onboard_date,graduated_school,specialty,card_attachment,technical_attachment,education_proof";
	private final static String[] fieldNames = { "employee_id"};
}
