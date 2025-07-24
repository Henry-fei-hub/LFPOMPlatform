package pomplatform.workflow.personnel.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.personnel.bean.BaseOnLoadAuditListOfPersonnel;
import pomplatform.workflow.personnel.bean.ConditionOnLoadAuditListOfPersonnel;
public class QueryOnLoadAuditListOfPersonnel extends AbstractQuery<BaseOnLoadAuditListOfPersonnel, ConditionOnLoadAuditListOfPersonnel>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAuditListOfPersonnel.class);

	public QueryOnLoadAuditListOfPersonnel() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spia.process_instance_activity_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAuditListOfPersonnel> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAuditListOfPersonnel condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getCompanyId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId()
			);
	}

	@Override
	public BaseOnLoadAuditListOfPersonnel generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAuditListOfPersonnel __base = new BaseOnLoadAuditListOfPersonnel();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNodeType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setNextActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMainActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setActivityType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT spia.process_instance_activity_id, spia.business_id, spia.business_name, spia.process_activity_id, spia.process_id, spia.process_instance_id, spia.node_type, spia.activity_id, spia.next_activity_id, spia.main_activity_id, spia.instance_activity_create_time, spia.instance_activity_start_time, spia.operate_time, spia.process_comment, spia.status, spia.activity_type, spia.back_view_name, a.personnel_business_id, a.process_type, a.employee_id, a.employee_no, a.department_id, a.company_id, a.type, a.start_date, a.start_date_detail, a.end_date, a.end_date_detail, a.days, a.reason, a.remark, a.address, a.plan, a.transportation, a.fee, a.unit, a.contact_person, a.create_time, a.delete_flag, a.next_auditor, a.sub_type, a.hours, a.company_province, a.target_province, a.number_of_baby, a.attachment, a.is_completed, a.sub_type_str, a.project_type, a.project_id, a.project_name, a.project_code, a.parent_id, a.is_remote_city, a.provide_accommodation, a.living_expenses, a.housing_finance, a.drafter, a.card, a.duty_id, a.equivalent_number, a.link_id, a.severance, a.salary_1, a.salary_2, a.original_pay, a.month_pay, a.basic_proportion_str, a.basic_proportion, a.month_basic_pay, a.month_performance_pay, a.foreman_pay, a.other_subsidy, a.total_pay, a.annual_performance, a.cost_attribution, a.certification_time, a.project_ids, a.payment_sequence_id, a.budget_management_id, a.budget_attachment_id, a.stage_id, b.status AS emp_status FROM system_process_instance_activities spia LEFT JOIN personnel_business A ON spia.business_id = A.personnel_business_id AND spia.process_type = A.process_type LEFT JOIN employees b ON A.employee_id = b.employee_id WHERE spia.process_type =? AND spia.status =? AND spia.employee_id =? AND spia.activity_type IN ( 2, 3 ) AND A.company_id =? AND b.employee_name LIKE ? AND A.employee_no LIKE ? AND A.department_id IN ( SELECT child_id FROM department_ids WHERE department_id =? ) AND A.delete_flag = 0 ORDER BY spia.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "process_instance_activity_id,business_id,business_name,process_activity_id,process_id,process_instance_id,node_type,activity_id,next_activity_id,main_activity_id,instance_activity_create_time,instance_activity_start_time,operate_time,process_comment,status,activity_type,back_view_name,personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,type,start_date,start_date_detail,end_date,end_date_detail,days,reason,remark,address,plan,transportation,fee,unit,contact_person,create_time,delete_flag,next_auditor,sub_type,hours,company_province,target_province,number_of_baby,attachment,is_completed,sub_type_str,project_type,project_id,project_name,project_code,parent_id,is_remote_city,provide_accommodation,living_expenses,housing_finance,drafter,card,duty_id,equivalent_number,link_id,severance,salary_1,salary_2,original_pay,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,other_subsidy,total_pay,annual_performance,cost_attribution,certification_time,project_ids,payment_sequence_id,budget_management_id,budget_attachment_id,stage_id,emp_status";
	private final static String[] fieldNames = { "process_type", "status", "employee_id", "company_id", "employee_name", "employee_no", "department_id"};
}
