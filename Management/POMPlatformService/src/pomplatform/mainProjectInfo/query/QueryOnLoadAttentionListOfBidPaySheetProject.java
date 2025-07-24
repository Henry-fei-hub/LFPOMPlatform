package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseOnLoadAttentionListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadAttentionListOfBidPaySheetProject;

public class QueryOnLoadAttentionListOfBidPaySheetProject extends AbstractQuery<BaseOnLoadAttentionListOfBidPaySheetProject, ConditionOnLoadAttentionListOfBidPaySheetProject>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadAttentionListOfBidPaySheetProject.class);

	public QueryOnLoadAttentionListOfBidPaySheetProject() throws java.sql.SQLException 
	{
		setParameterNumber(4);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spa.system_process_attention_id");
	}

	@Override
	public BaseCollection<BaseOnLoadAttentionListOfBidPaySheetProject> executeQuery( KeyValuePair[] replacements, ConditionOnLoadAttentionListOfBidPaySheetProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getStatus(), 
				condition.getEmployeeId(), 
				condition.getEmployeeName(), 
				condition.getEmployeeNo()
			);
	}

	@Override
	public BaseOnLoadAttentionListOfBidPaySheetProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadAttentionListOfBidPaySheetProject __base = new BaseOnLoadAttentionListOfBidPaySheetProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSystemProcessAttentionId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBackViewName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setInstanceActivityStartTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessComment(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlan(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvideAccommodation(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHousingFinance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
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
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
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

	private final static String __SQLText = "SELECT spa.system_process_attention_id, spa.business_id, spa.business_name, spa.process_activity_id, spa.process_id, spa.process_instance_id, spa.back_view_name, spa.instance_activity_id, spa.instance_activity_create_time, spa.instance_activity_start_time, spa.status, spa.operate_time, spa.process_comment, pb.personnel_business_id, pb.employee_id, pb.employee_no, pb.start_date, pb.start_date_detail, pb.end_date_detail, pb.reason, pb.remark, pb.address, pb.plan, pb.project_id, pb.project_name, pb.project_code, pb.provide_accommodation, pb.living_expenses, pb.housing_finance, pb.duty_id, pb.link_id, pb.severance, pb.attachment_id, pb.attachment_name , b.status AS emp_status FROM system_process_attentions spa LEFT JOIN personnel_business pb ON spa.business_id = pb.personnel_business_id AND spa.process_type = pb.process_type LEFT JOIN employees b ON pb.employee_id = b.employee_id WHERE spa.status =? AND spa.process_type =73 AND spa.employee_id =? AND b.employee_name LIKE ? AND b.employee_no LIKE ? AND pb.delete_flag = 0 ORDER BY spa.instance_activity_create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "system_process_attention_id,business_id,business_name,process_activity_id,process_id,process_instance_id,back_view_name,instance_activity_id,instance_activity_create_time,instance_activity_start_time,status,operate_time,process_comment,personnel_business_id,employee_id,employee_no,start_date,start_date_detail,end_date_detail,reason,remark,address,plan,project_id,project_name,project_code,provide_accommodation,living_expenses,housing_finance,duty_id,link_id,severance,attachment_id,attachment_name,emp_status";
	private final static String[] fieldNames = { "status", "employee_id", "employee_name", "employee_no"};
}
