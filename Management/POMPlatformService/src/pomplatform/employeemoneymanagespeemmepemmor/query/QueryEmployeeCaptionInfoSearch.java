package pomplatform.employeemoneymanagespeemmepemmor.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.employeemoneymanagespeemmepemmor.bean.BaseEmployeeCaptionInfoSearch;
import pomplatform.employeemoneymanagespeemmepemmor.bean.ConditionEmployeeCaptionInfoSearch;

public class QueryEmployeeCaptionInfoSearch extends AbstractQuery<BaseEmployeeCaptionInfoSearch, ConditionEmployeeCaptionInfoSearch>
{

	private static final Logger __logger = Logger.getLogger(QueryEmployeeCaptionInfoSearch.class);

	public QueryEmployeeCaptionInfoSearch() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("e.employee_id");
	}

	@Override
	public BaseCollection<BaseEmployeeCaptionInfoSearch> executeQuery( KeyValuePair[] replacements, ConditionEmployeeCaptionInfoSearch condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getEmployeeNo(), 
				condition.getEmployeeName(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getDepartmentId(), 
				condition.getRoleId()
			);
	}

	@Override
	public BaseEmployeeCaptionInfoSearch generateBase(Object[] __data) throws java.sql.SQLException {
		BaseEmployeeCaptionInfoSearch __base = new BaseEmployeeCaptionInfoSearch();
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
		if((val = __data[count++]) != null) __base.setMoney(GenericBase.__getDecimal(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "select e.employee_id, e.employee_no, e.employee_name, e.department_id, e.role_id, e.grade_id, e.employee_password, e.mobile, e.phone, e.qq, e.email, e.onboard_date, e.resignation_date, e.status, e.usable_status, e.is_department, e.photo, e.gender, e.autograph, e.age, e.birth, e.card, e.address, e.alternate_field1, e.alternate_field2, e.alternate_field3, e.locked, e.plate_id, e.duty_id, e.user_acct, e.employee_name_en, e.education, e.degree, e.nationality, e.married_status, e.health, e.work_address, e.registered_address, e.oa_id, e.oa_depart, e.is_headcount, e.is_check, e.direct_leader, e.is_manager, aa.money from employees e LEFT JOIN (SELECT ep.employee_id, SUM(ep.money) AS money FROM (SELECT pbl.employee_or_company_id as employee_id, pbl.pay_money AS money FROM employee_money_manages em LEFT JOIN system_process_instances spi ON spi.business_id = em.employee_money_manage_id AND spi.process_type = 6 LEFT JOIN process_bill_list pbl ON spi.business_id = pbl.business_id and spi.process_type = pbl.process_type and pbl.pay_for = 1 WHERE spi.process_status = 3 AND spi.delete_flag = 0 UNION ALL SELECT pbl.employee_or_company_id AS employee_id, ( 0 - COALESCE (pbl.balance_amount, 0) ) AS money FROM process_bill_list pbl LEFT JOIN system_process_instances spi ON spi.business_id = pbl.business_id AND spi.process_type = pbl.process_type AND pbl.pay_for = 1 WHERE spi.process_status = 3 AND pbl.balance_amount > 0 AND spi.delete_flag = 0 UNION ALL SELECT pb.parent_id AS employee_id, (0 - COALESCE(pb.fee, 0)) AS money FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = 28 	WHERE spi.process_status = 3 AND pb.process_type = 28 AND spi.delete_flag = 0 UNION ALL SELECT eib.employee_id,eib.initial_balance AS money FROM employee_initial_balances eib) ep GROUP BY ep.employee_id) aa ON aa.employee_id = e.employee_id where e.employee_no like ? and e.employee_name like ? and e.status = ? and e.employee_id = ? and e.department_id = ? and e.role_id = ? AND e.employee_id IN (SELECT DISTINCT b.employee_or_company_id as employee_id FROM system_process_instances a LEFT JOIN process_bill_list b on a.process_type = b.process_type and a.business_id = b.business_id and b.pay_for = 1 WHERE (a.process_type = 6 OR (a.process_type != 6 AND b.balance_amount > 0)) AND b.pay_for = 1 AND a.process_status = 3 AND a.delete_flag = 0 UNION ALL SELECT employee_id FROM employee_initial_balances UNION ALL SELECT pb.parent_id AS employee_id FROM personnel_business pb LEFT JOIN system_process_instances spi ON spi.business_id = pb.personnel_business_id AND spi.process_type = 28 WHERE spi.process_status = 3 AND pb.process_type = 28 AND spi.delete_flag = 0) " ;
	private final static String RESULTSETFIELDLIST = "employee_id,employee_no,employee_name,department_id,role_id,grade_id,employee_password,mobile,phone,qq,email,onboard_date,resignation_date,status,usable_status,is_department,photo,gender,autograph,age,birth,card,address,alternate_field1,alternate_field2,alternate_field3,locked,plate_id,duty_id,user_acct,employee_name_en,education,degree,nationality,married_status,health,work_address,registered_address,oa_id,oa_depart,is_headcount,is_check,direct_leader,is_manager,money";
	private final static String[] fieldNames = { "employee_no", "employee_name", "status", "employee_id", "department_id", "role_id"};
}
