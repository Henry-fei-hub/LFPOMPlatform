package pomplatform.projectstageauditinfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.projectstageauditinfo.bean.BaseProjectStageAuditInfo;
import pomplatform.projectstageauditinfo.bean.ConditionProjectStageAuditInfo;

public class QueryProjectStageAuditInfo extends AbstractQuery<BaseProjectStageAuditInfo, ConditionProjectStageAuditInfo>
{

	private static final Logger __logger = Logger.getLogger(QueryProjectStageAuditInfo.class);

	public QueryProjectStageAuditInfo() throws java.sql.SQLException 
	{
		setParameterNumber(61);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.personnel_business_id");
	}

	@Override
	public BaseCollection<BaseProjectStageAuditInfo> executeQuery( KeyValuePair[] replacements, ConditionProjectStageAuditInfo condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getEmployeeId(), 
				condition.getEmployeeNo(), 
				condition.getDepartmentId(), 
				condition.getCompanyId(), 
				condition.getType(), 
				condition.getStartDate(), 
				condition.getStartDateDetail(), 
				condition.getEndDate(), 
				condition.getEndDateDetail(), 
				condition.getDays(), 
				condition.getReason(), 
				condition.getRemark(), 
				condition.getAddress(), 
				condition.getPlan(), 
				condition.getTransportation(), 
				condition.getFee(), 
				condition.getUnit(), 
				condition.getContactPerson(), 
				condition.getCreateTime(), 
				condition.getDeleteFlag(), 
				condition.getNextAuditor(), 
				condition.getSubType(), 
				condition.getHours(), 
				condition.getCompanyProvince(), 
				condition.getTargetProvince(), 
				condition.getNumberOfBaby(), 
				condition.getAttachment(), 
				condition.getIsCompleted(), 
				condition.getSubTypeStr(), 
				condition.getProjectType(), 
				condition.getProjectId(), 
				condition.getProjectName(), 
				condition.getProjectCode(), 
				condition.getParentId(), 
				condition.getIsRemoteCity(), 
				condition.getProvideAccommodation(), 
				condition.getLivingExpenses(), 
				condition.getHousingFinance(), 
				condition.getDrafter(), 
				condition.getCard(), 
				condition.getDutyId(), 
				condition.getEquivalentNumber(), 
				condition.getLinkId(), 
				condition.getSeverance(), 
				condition.getSalary1(), 
				condition.getSalary2(), 
				condition.getOriginalPay(), 
				condition.getMonthPay(), 
				condition.getBasicProportionStr(), 
				condition.getBasicProportion(), 
				condition.getMonthBasicPay(), 
				condition.getMonthPerformancePay(), 
				condition.getForemanPay(), 
				condition.getOtherSubsidy(), 
				condition.getTotalPay(), 
				condition.getAnnualPerformance(), 
				condition.getCostAttribution(), 
				condition.getCertificationTime(), 
				condition.getProjectIds(), 
				condition.getStageId()
			);
	}

	@Override
	public BaseProjectStageAuditInfo generateBase(Object[] __data) throws java.sql.SQLException {
		BaseProjectStageAuditInfo __base = new BaseProjectStageAuditInfo();
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[8]));
		if(args[9] != null) __statement.setInt(count++, GenericBase.__getInt(args[9]));
		if(args[10] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[10]));
		if(args[11] != null) __statement.setString(count++, GenericBase.__getString(args[11]));
		if(args[12] != null) __statement.setString(count++, GenericBase.__getString(args[12]));
		if(args[13] != null) __statement.setString(count++, GenericBase.__getString(args[13]));
		if(args[14] != null) __statement.setString(count++, GenericBase.__getString(args[14]));
		if(args[15] != null) __statement.setString(count++, GenericBase.__getString(args[15]));
		if(args[16] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[16]));
		if(args[17] != null) __statement.setString(count++, GenericBase.__getString(args[17]));
		if(args[18] != null) __statement.setString(count++, GenericBase.__getString(args[18]));
		if(args[19] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[19]));
		if(args[20] != null) __statement.setInt(count++, GenericBase.__getInt(args[20]));
		if(args[21] != null) __statement.setInt(count++, GenericBase.__getInt(args[21]));
		if(args[22] != null) __statement.setString(count++, GenericBase.__getString(args[22]));
		if(args[23] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[23]));
		if(args[24] != null) __statement.setInt(count++, GenericBase.__getInt(args[24]));
		if(args[25] != null) __statement.setInt(count++, GenericBase.__getInt(args[25]));
		if(args[26] != null) __statement.setInt(count++, GenericBase.__getInt(args[26]));
		if(args[27] != null) __statement.setString(count++, GenericBase.__getString(args[27]));
		if(args[28] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[28]));
		if(args[29] != null) __statement.setString(count++, GenericBase.__getString(args[29]));
		if(args[30] != null) __statement.setInt(count++, GenericBase.__getInt(args[30]));
		if(args[31] != null) __statement.setInt(count++, GenericBase.__getInt(args[31]));
		if(args[32] != null) __statement.setString(count++, GenericBase.__getString(args[32]));
		if(args[33] != null) __statement.setString(count++, GenericBase.__getString(args[33]));
		if(args[34] != null) __statement.setInt(count++, GenericBase.__getInt(args[34]));
		if(args[35] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[35]));
		if(args[36] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[36]));
		if(args[37] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[37]));
		if(args[38] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[38]));
		if(args[39] != null) __statement.setInt(count++, GenericBase.__getInt(args[39]));
		if(args[40] != null) __statement.setString(count++, GenericBase.__getString(args[40]));
		if(args[41] != null) __statement.setInt(count++, GenericBase.__getInt(args[41]));
		if(args[42] != null) __statement.setString(count++, GenericBase.__getString(args[42]));
		if(args[43] != null) __statement.setInt(count++, GenericBase.__getInt(args[43]));
		if(args[44] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[44]));
		if(args[45] != null) __statement.setString(count++, GenericBase.__getString(args[45]));
		if(args[46] != null) __statement.setString(count++, GenericBase.__getString(args[46]));
		if(args[47] != null) __statement.setString(count++, GenericBase.__getString(args[47]));
		if(args[48] != null) __statement.setString(count++, GenericBase.__getString(args[48]));
		if(args[49] != null) __statement.setString(count++, GenericBase.__getString(args[49]));
		if(args[50] != null) __statement.setBigDecimal(count++, GenericBase.__getDecimal(args[50]));
		if(args[51] != null) __statement.setString(count++, GenericBase.__getString(args[51]));
		if(args[52] != null) __statement.setString(count++, GenericBase.__getString(args[52]));
		if(args[53] != null) __statement.setString(count++, GenericBase.__getString(args[53]));
		if(args[54] != null) __statement.setString(count++, GenericBase.__getString(args[54]));
		if(args[55] != null) __statement.setString(count++, GenericBase.__getString(args[55]));
		if(args[56] != null) __statement.setString(count++, GenericBase.__getString(args[56]));
		if(args[57] != null) __statement.setInt(count++, GenericBase.__getInt(args[57]));
		if(args[58] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[58]));
		if(args[59] != null) __statement.setInt(count++, GenericBase.__getInt(args[59]));
		if(args[60] != null) __statement.setInt(count++, GenericBase.__getInt(args[60]));
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

	private final static String __SQLText = "select pb.personnel_business_id, pb.process_type, pb.employee_id, pb.employee_no, pb.department_id, pb.company_id, pb.type, pb.start_date, pb.start_date_detail, pb.end_date, pb.end_date_detail, pb.days, pb.reason, pb.remark, pb.address, pb.plan, pb.transportation, pb.fee, pb.unit, pb.contact_person, pb.create_time, pb.delete_flag, pb.next_auditor, pb.sub_type, pb.hours, pb.company_province, pb.target_province, pb.number_of_baby, pb.attachment, pb.is_completed, pb.sub_type_str, pb.project_type, pb.project_id, pb.project_name, pb.project_code, pb.parent_id, pb.is_remote_city, pb.provide_accommodation, pb.living_expenses, pb.housing_finance, pb.drafter, pb.card, pb.duty_id, pb.equivalent_number, pb.link_id, pb.severance, pb.salary_1, pb.salary_2, pb.original_pay, pb.month_pay, pb.basic_proportion_str, pb.basic_proportion, pb.month_basic_pay, pb.month_performance_pay, pb.foreman_pay, pb.other_subsidy, pb.total_pay, pb.annual_performance, pb.cost_attribution, pb.certification_time, pb.project_ids, pb.payment_sequence_id, pb.budget_management_id, pb.budget_attachment_id, pb.stage_id from personnel_business pb where pb.process_type = ? and pb.employee_id = ? and pb.employee_no = ? and pb.department_id = ? and pb.company_id = ? and pb.type = ? and pb.start_date = ? and pb.start_date_detail = ?_detail and pb.end_date = ? and pb.end_date_detail = ?_detail and pb.days = ? and pb.reason = ? and pb.remark = ? and pb.address = ? and pb.plan = ? and pb.transportation = ? and pb.fee = ? and pb.unit = ? and pb.contact_person = ? and pb.create_time = ? and pb.delete_flag = ? and pb.next_auditor = ? and pb.sub_type = ? and pb.hours = ? and pb.company_province = ? and pb.target_province = ? and pb.number_of_baby = ? and pb.attachment = ? and pb.is_completed = ? and pb.sub_type_str = ?_str and pb.project_type = ? and pb.project_id = ? and pb.project_name = ? and pb.project_code = ? and pb.parent_id = ? and pb.is_remote_city = ? and pb.provide_accommodation = ? and pb.living_expenses = ? and pb.housing_finance = ? and pb.drafter = ? and pb.card = ? and pb.duty_id = ? and pb.equivalent_number = ? and pb.link_id = ? and pb.severance = ? and pb.salary_1 = ? and pb.salary_2 = ? and pb.original_pay = ? and pb.month_pay = ? and pb.basic_proportion_str = ? and pb.basic_proportion = ? and pb.month_basic_pay = ? and pb.month_performance_pay = ? and pb.foreman_pay = ? and pb.other_subsidy = ? and pb.total_pay = ? and pb.annual_performance = ? and pb.cost_attribution = ? and pb.certification_time = ? and pb.project_ids = ?s and pb.stage_id = ?" ;
	private final static String RESULTSETFIELDLIST = "personnel_business_id,process_type,employee_id,employee_no,department_id,company_id,type,start_date,start_date_detail,end_date,end_date_detail,days,reason,remark,address,plan,transportation,fee,unit,contact_person,create_time,delete_flag,next_auditor,sub_type,hours,company_province,target_province,number_of_baby,attachment,is_completed,sub_type_str,project_type,project_id,project_name,project_code,parent_id,is_remote_city,provide_accommodation,living_expenses,housing_finance,drafter,card,duty_id,equivalent_number,link_id,severance,salary_1,salary_2,original_pay,month_pay,basic_proportion_str,basic_proportion,month_basic_pay,month_performance_pay,foreman_pay,other_subsidy,total_pay,annual_performance,cost_attribution,certification_time,project_ids,payment_sequence_id,budget_management_id,budget_attachment_id,stage_id";
	private final static String[] fieldNames = { "process_type", "employee_id", "employee_no", "department_id", "company_id", "type", "start_date", "start_date_detail", "end_date", "end_date_detail", "days", "reason", "remark", "address", "plan", "transportation", "fee", "unit", "contact_person", "create_time", "delete_flag", "next_auditor", "sub_type", "hours", "company_province", "target_province", "number_of_baby", "attachment", "is_completed", "sub_type_str", "project_type", "project_id", "project_name", "project_code", "parent_id", "is_remote_city", "provide_accommodation", "living_expenses", "housing_finance", "drafter", "card", "duty_id", "equivalent_number", "link_id", "severance", "salary_1", "salary_2", "original_pay", "month_pay", "basic_proportion_str", "basic_proportion", "month_basic_pay", "month_performance_pay", "foreman_pay", "other_subsidy", "total_pay", "annual_performance", "cost_attribution", "certification_time", "project_ids", "stage_id"};
}
