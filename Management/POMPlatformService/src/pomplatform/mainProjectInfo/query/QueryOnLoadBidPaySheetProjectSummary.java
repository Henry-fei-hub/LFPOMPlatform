package pomplatform.mainProjectInfo.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.mainProjectInfo.bean.BaseOnLoadBidPaySheetProjectSummary;
import pomplatform.mainProjectInfo.bean.ConditionOnLoadBidPaySheetProjectSummary;

public class QueryOnLoadBidPaySheetProjectSummary extends AbstractQuery<BaseOnLoadBidPaySheetProjectSummary, ConditionOnLoadBidPaySheetProjectSummary>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadBidPaySheetProjectSummary.class);

	public QueryOnLoadBidPaySheetProjectSummary() throws java.sql.SQLException 
	{
		setParameterNumber(6);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pb.project_name");
	}

	@Override
	public BaseCollection<BaseOnLoadBidPaySheetProjectSummary> executeQuery( KeyValuePair[] replacements, ConditionOnLoadBidPaySheetProjectSummary condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProjectCode(), 
				condition.getProjectName(), 
				condition.getContractId(), 
				condition.getContractCode(), 
				condition.getContractName(), 
				condition.getEmployeeId()
			);
	}

	@Override
	public BaseOnLoadBidPaySheetProjectSummary generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadBidPaySheetProjectSummary __base = new BaseOnLoadBidPaySheetProjectSummary();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTransportation(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectSalesTeam(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setLivingExpenses(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setStartDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEndDateDetail(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSeverance(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setContractCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContractName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPlateId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPersonnelBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setStartDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDutyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLinkId(GenericBase.__getInt(val));
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
		if(args[0] != null) __statement.setString(count++, GenericBase.__getString(args[0]));
		if(args[1] != null) __statement.setString(count++, GenericBase.__getString(args[1]));
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

	private final static String __SQLText = " SELECT pb.project_name, pb.project_code, C.info_code, pb.transportation, M.project_sales_team, pb.living_expenses, pb.start_date_detail, pb.end_date_detail, pb.address, pb.reason, pb.remark, pb.severance, C.contract_code, C.contract_name, P.contract_code AS code, P.project_name AS NAME, P.plate_id, P.total_amount, spi.create_time, spi.complete_time, spi.process_instance_id, spi.process_status, pb.personnel_business_id, pb.employee_id, pb.start_date, pb.duty_id, pb.link_id, pb.attachment_id, pb.attachment_name FROM system_process_instances spi LEFT JOIN personnel_business pb ON spi.business_id = pb.personnel_business_id AND spi.process_type = pb.process_type LEFT JOIN main_projects M ON M.main_project_id = pb.duty_id LEFT JOIN contracts C ON C.contract_id = pb.link_id LEFT JOIN projects P ON P.contract_id = C.contract_id AND P.project_type = 66 WHERE spi.process_type = 73 AND spi.process_status = 3 AND pb.project_code LIKE ? AND pb.project_name LIKE ? AND C.contract_id =? AND C.contract_code LIKE ? AND C.contract_name LIKE ? AND pb.employee_id =? AND pb.delete_flag = 0 ORDER BY spi.create_time DESC" ;
	private final static String RESULTSETFIELDLIST = "project_name,project_code,info_code,transportation,project_sales_team,living_expenses,start_date_detail,end_date_detail,address,reason,remark,severance,contract_code,contract_name,code,name,plate_id,total_amount,create_time,complete_time,process_instance_id,process_status,personnel_business_id,employee_id,start_date,duty_id,link_id,attachment_id,attachment_name";
	private final static String[] fieldNames = { "project_code", "project_name", "contract_id", "contract_code", "contract_name", "employee_id"};
}
