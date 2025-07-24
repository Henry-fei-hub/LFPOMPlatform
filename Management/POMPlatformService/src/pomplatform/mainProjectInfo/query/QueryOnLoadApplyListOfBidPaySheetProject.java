package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseOnLoadApplyListOfBidPaySheetProject;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadApplyListOfBidPaySheetProject;

public class QueryOnLoadApplyListOfBidPaySheetProject extends AbstractQuery<BaseOnLoadApplyListOfBidPaySheetProject, ConditionOnLoadApplyListOfBidPaySheetProject>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadApplyListOfBidPaySheetProject.class);

	public QueryOnLoadApplyListOfBidPaySheetProject() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseOnLoadApplyListOfBidPaySheetProject> executeQuery( KeyValuePair[] replacements, ConditionOnLoadApplyListOfBidPaySheetProject condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectId(), 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadApplyListOfBidPaySheetProject generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadApplyListOfBidPaySheetProject __base = new BaseOnLoadApplyListOfBidPaySheetProject();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
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
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsRemoteCity(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setProvideAccommodation(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setHousingFinance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAttachmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAttachmentName(GenericBase.__getString(val));
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
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, pb.personnel_business_id, pb.process_type, pb.employee_id, pb.employee_no, pb.start_date, pb.start_date_detail, pb.end_date_detail, pb.reason, pb.remark, pb.address, pb.plan, pb.project_id, pb.project_name, pb.project_code, pb.parent_id, pb.is_remote_city, pb.provide_accommodation, pb.living_expenses, pb.housing_finance, pb.duty_id, pb.link_id, pb.severance, pb.attachment_id, pb.attachment_name FROM system_process_instances spi LEFT JOIN personnel_business pb ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type WHERE spi.process_type = 73 AND spi.process_status IN ( 0, 1 ) and pb.project_id =? and pb.project_code like ? and pb.project_name like ? and pb.link_id=? and pb.employee_no like ? and pb.plan like ? and pb.employee_id=? AND pb.delete_flag = 0  ORDER BY spi.create_time desc" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,personnel_business_id,process_type,employee_id,employee_no,start_date,start_date_detail,end_date_detail,reason,remark,address,plan,project_id,project_name,project_code,parent_id,is_remote_city,provide_accommodation,living_expenses,housing_finance,duty_id,link_id,severance,attachment_id,attachment_name";
	private final static String[] fieldNames = { "project_id", "project_code", "project_name", "contract_id", "contract_code", "contract_name", "employee_id"};
}
