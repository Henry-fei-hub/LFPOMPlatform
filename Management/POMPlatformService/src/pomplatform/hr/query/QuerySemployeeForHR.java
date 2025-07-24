package pomplatform.hr.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.hr.bean.BaseSemployeeForHR;
import pomplatform.hr.bean.ConditionSemployeeForHR;

public class QuerySemployeeForHR extends AbstractQuery<BaseSemployeeForHR, ConditionSemployeeForHR>
{

	private static final Logger __logger = Logger.getLogger(QuerySemployeeForHR.class);

	public QuerySemployeeForHR() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseSemployeeForHR> executeQuery( KeyValuePair[] replacements, ConditionSemployeeForHR condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPlateId(), 
				condition.getDutyId(), 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getDepartmentId(), 
				condition.getRoleId(), 
				condition.getGradeId(), 
				condition.getStatus(), 
				condition.getIsDepartment(), 
				condition.getGender()
			);
	}

	@Override
	public BaseSemployeeForHR generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSemployeeForHR __base = new BaseSemployeeForHR();
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
                if((val = __data[count++]) != null) __base.setDirectLeader(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setInt(count++, (java.lang.Integer)args[0]);
		if(args[1] != null) __statement.setInt(count++, (java.lang.Integer)args[1]);
		if(args[2] != null) __statement.setString(count++, (java.lang.String)args[2]);
		if(args[3] != null) __statement.setString(count++, (java.lang.String)args[3]);
		if(args[4] != null) __statement.setInt(count++, (java.lang.Integer)args[4]);
		if(args[5] != null) __statement.setInt(count++, (java.lang.Integer)args[5]);
		if(args[6] != null) __statement.setInt(count++, (java.lang.Integer)args[6]);
		if(args[7] != null) __statement.setInt(count++, (java.lang.Integer)args[7]);
		if(args[8] != null) __statement.setBoolean(count++, (java.lang.Boolean)args[8]);
		if(args[9] != null) __statement.setInt(count++, (java.lang.Integer)args[9]);
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

	private final static String __SQLText = "select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, concat(s.image_path,case when e.photo is null then 'photo_view.png' else e.photo end) as photo,e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.alternate_field1, e.alternate_field2, e.alternate_field3, e.locked, e.plate_id, e.duty_id, e.user_acct, e.employee_name_en, e.education, e.degree, e.nationality, e.married_status, e.health, e.work_address, e.registered_address,e.direct_leader from employees e left join system_config s on s.system_config_id = 1 where e.plate_id = ? and e.duty_id = ? and e.employee_no = ? and e.employee_name = ? and e.department_id in (select child_id from department_ids where department_id = ? ) and e.role_id = ? and e.grade_id = ? and e.status = ? and e.is_department = ? and e.gender = ? " ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,alternate_field1,alternate_field2,alternate_field3,locked,plate_id,duty_id,user_acct,employee_name_en,education,degree,nationality,married_status,health,work_address,registered_address,direct_leader";
	private final static String[] fieldNames = { "plate_id", "duty_id", "employee_no", "employee_name", "department_id", "role_id", "grade_id", "status", "is_department", "gender"};
}
