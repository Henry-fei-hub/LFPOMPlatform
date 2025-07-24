package pomplatform.capitalDsitributionemployee.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.capitalDsitributionemployee.bean.BaseCapitalDsitributionemployee;
import pomplatform.capitalDsitributionemployee.bean.ConditionCapitalDsitributionemployee;

public class QueryCapitalDsitributionemployee extends AbstractQuery<BaseCapitalDsitributionemployee, ConditionCapitalDsitributionemployee>
{

	private static final Logger __logger = Logger.getLogger(QueryCapitalDsitributionemployee.class);

	public QueryCapitalDsitributionemployee() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("DISTINCT e.*");
	}

	@Override
	public BaseCollection<BaseCapitalDsitributionemployee> executeQuery( KeyValuePair[] replacements, ConditionCapitalDsitributionemployee condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getPlateId(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getStatus()
			);
	}

	@Override
	public BaseCapitalDsitributionemployee generateBase(Object[] __data) throws java.sql.SQLException {
		BaseCapitalDsitributionemployee __base = new BaseCapitalDsitributionemployee();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRoleId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setGradeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeePassword(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setQq(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOnboardDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setResignationDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUsableStatus(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsDepartment(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPhoto(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAutograph(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAge(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBirth(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAlternateField3(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLocked(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setUserAcct(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNameEn(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEducation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDegree(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setNationality(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMarriedStatus(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHealth(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWorkAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOaId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOaDepart(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsHeadcount(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsCheck(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setDirectLeader(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsManager(GenericBase.__getBoolean(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setString(count++, GenericBase.__getString(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
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

	private final static String __SQLText = "SELECT DISTINCT e.* FROM employees e LEFT JOIN employee_day_plate_records ecpr ON ecpr.employee_id = e.employee_id AND ecpr.plate_id = ? WHERE ecpr.plate_id = ? AND e.employee_id = ? AND e.department_id = ? AND e.employee_name LIKE ? AND e.employee_no LIKE ? AND e.status = ? ORDER BY e.employee_name ASC" ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,alternate_field1,alternate_field2,alternate_field3,locked,plate_id,duty_id,user_acct,employee_name_en,education,degree,nationality,married_status,health,work_address,registered_address,oa_id,oa_depart,is_headcount,is_check,direct_leader,is_manager";
	private final static String[] fieldNames = { "plate_id", "plate_id", "employee_id", "department_id", "employee_name", "employee_no", "status"};
}
