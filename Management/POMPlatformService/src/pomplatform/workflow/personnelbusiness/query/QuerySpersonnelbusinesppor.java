package pomplatform.workflow.personnelbusiness.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnelbusiness.bean.BaseSpersonnelbusinesppor;
import pomplatform.workflow.personnelbusiness.bean.ConditionSpersonnelbusinesppor;

public class QuerySpersonnelbusinesppor extends AbstractQuery<BaseSpersonnelbusinesppor, ConditionSpersonnelbusinesppor>
{

	private static final Logger __logger = Logger.getLogger(QuerySpersonnelbusinesppor.class);

	public QuerySpersonnelbusinesppor() throws java.sql.SQLException 
	{
		setParameterNumber(2);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseSpersonnelbusinesppor> executeQuery( KeyValuePair[] replacements, ConditionSpersonnelbusinesppor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPersonnelBusinessId(), 
				condition.getProcessType()
			);
	}

	@Override
	public BaseSpersonnelbusinesppor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSpersonnelbusinesppor __base = new BaseSpersonnelbusinesppor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setDays(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlan(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransportation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFee(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUnit(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextAuditor(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSubType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setHours(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCompanyProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTargetProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNumberOfBaby(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsCompleted(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setSubTypeStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsRemoteCity(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProvideAccommodation(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHousingFinance(GenericBase.__getDecimal(val));
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

	private final static String __SQLText = "select pb.personnel_business_id, pb.process_type, pb.employee_id, pb.employee_no, pb.department_id, pb.company_id, pb.type, pb.start_date, pb.start_date_detail, pb.end_date, pb.end_date_detail, pb.days, pb.reason, pb.remark, pb.address, pb.plan, pb.transportation, pb.fee, pb.unit, pb.contact_person, pb.create_time, pb.delete_flag, pb.next_auditor, pb.sub_type, pb.hours, pb.company_province, pb.target_province, pb.number_of_baby, pb.attachment, pb.is_completed, pb.sub_type_str, pb.project_type, pb.project_id, pb.project_name, pb.project_code, pb.parent_id, pb.is_remote_city, pb.provide_accommodation, pb.living_expenses, pb.housing_finance from personnel_business pb where pb.personnel_business_id = ? and pb.process_type = ?" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,type,start_date,start_date_detail,end_date,end_date_detail,days,reason,remark,address,plan,transportation,fee,unit,contact_person,create_time,delete_flag,next_auditor,sub_type,hours,company_province,target_province,number_of_baby,attachment,is_completed,sub_type_str,project_type,project_id,project_name,project_code,parent_id,is_remote_city,provide_accommodation,living_expenses,housing_finance";
	private final static String[] fieldNames = { "personnel_business_id", "process_type"};
}
