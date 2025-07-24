package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseOnLoadApplyListOfPersonnel;
import pomplatform.workflow.personnel.bean.ConditionOnLoadApplyListOfPersonnel;

public class QueryOnLoadApplyListOfPersonnel extends AbstractQuery<BaseOnLoadApplyListOfPersonnel, ConditionOnLoadApplyListOfPersonnel>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfPersonnel.class);

	public QueryOnLoadApplyListOfPersonnel() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfPersonnel> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfPersonnel condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfPersonnel generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfPersonnel __base = new BaseOnLoadApplyListOfPersonnel();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
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
		if((val = __data[count++]) != null) __base.setDrafter(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCard(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEquivalentNumber(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setSalary1(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSalary2(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOriginalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonthPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportionStr(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBasicProportion(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setMonthBasicPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMonthPerformancePay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setForemanPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setOtherSubsidy(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalPay(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAnnualPerformance(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCostAttribution(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCertificationTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProjectIds(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPaymentSequenceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetManagementId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBudgetAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStageId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmpStatus(GenericBase.__getInt(val));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.complete_time, A.personnel_business_id, A.process_type, A.employee_id, A.employee_no, A.department_id, A.company_id, A.TYPE, A.start_date, A.start_date_detail, A.end_date, A.end_date_detail, A.days, A.reason, A.remark, A.address, A.plan, A.transportation, A.fee, A.unit, A.contact_person, A.create_time, A.delete_flag, A.next_auditor, A.sub_type, A.hours, A.company_province, A.target_province, A.number_of_baby, A.attachment, A.is_completed, A.sub_type_str, A.project_type, A.project_id, A.project_name, A.project_code, A.parent_id, A.is_remote_city, A.provide_accommodation, A.living_expenses, A.housing_finance, A.drafter, A.card, A.duty_id, A.equivalent_number, A.link_id, A.severance, A.salary_1, A.salary_2, A.original_pay, A.month_pay, A.basic_proportion_str, A.basic_proportion, A.month_basic_pay, A.month_performance_pay, A.foreman_pay, A.other_subsidy, A.total_pay, A.annual_performance, A.cost_attribution, A.certification_time, A.project_ids, A.payment_sequence_id, A.budget_management_id, A.budget_attachment_id, A.stage_id, b.status AS emp_status FROM system_process_instances spi LEFT JOIN personnel_business A ON spi.business_id = A.personnel_business_id AND spi.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spi.process_type =? AND spi.process_status IN ( 0, 1 ) AND A.drafter =? AND A.company_id =? AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND A.delete_flag = 0 AND spi.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,complete_time,personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,type,start_date,start_date_detail,end_date,end_date_detail,days,reason,remark,address,plan,transportation,fee,unit,contact_person,create_time,delete_flag,next_auditor,sub_type,hours,company_province,target_province,number_of_baby,attachment,is_completed,sub_type_str,project_type,project_id,project_name,project_code,parent_id,is_remote_city,provide_accommodation,living_expenses,housing_finance,drafter,card,duty_id,equivalent_number,link_id,severance,salary_1,salary_2,original_pay,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,other_subsidy,total_pay,annual_performance,cost_attribution,certification_time,project_ids,payment_sequence_id,budget_management_id,budget_attachment_id,stage_id,emp_status";
	private final static String[] fieldNames = { "process_type", "employee_id", "company_id", "employee_name", "employee_no", "department_id"};}
