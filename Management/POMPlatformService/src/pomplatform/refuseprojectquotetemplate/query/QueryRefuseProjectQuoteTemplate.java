package pomplatform.refuseprojectquotetemplate.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.refuseprojectquotetemplate.bean.BaseRefuseProjectQuoteTemplate;
import pomplatform.refuseprojectquotetemplate.bean.ConditionRefuseProjectQuoteTemplate;

public class QueryRefuseProjectQuoteTemplate extends AbstractQuery<BaseRefuseProjectQuoteTemplate, ConditionRefuseProjectQuoteTemplate>
{

	private static final Logger __logger = Logger.getLogger(QueryRefuseProjectQuoteTemplate.class);

	public QueryRefuseProjectQuoteTemplate() throws java.sql.SQLException 
	{
		setParameterNumber(8);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("spi.process_instance_id");
	}

	@Override
	public BaseCollection<BaseRefuseProjectQuoteTemplate> executeQuery( KeyValuePair[] replacements, ConditionRefuseProjectQuoteTemplate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProcessType(), 
				condition.getProcessStatus(), 
				condition.getProjectName(), 
				condition.getCreateTimeStart(), 
				condition.getCreateTimeEnd(), 
				condition.getEmployeeId(), 
				condition.getOperateEmployeeId(), 
				condition.getBusinessType()
			);
	}

	@Override
	public BaseRefuseProjectQuoteTemplate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseRefuseProjectQuoteTemplate __base = new BaseRefuseProjectQuoteTemplate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProcessInstanceId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessInstanceActivityId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompleteTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setProjectQuoteId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setQuoteStatus(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBasicAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setUpPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPreferentialAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPerferentialPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOtherTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setFinalPercent(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxFinalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getInt(val));
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
		if(args[3] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[3]));
		if(args[4] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
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

	private final static String __SQLText = "SELECT spi.process_instance_id, spi.process_type, spi.business_id, spi.business_name, spi.process_id, spi.process_instance_activity_id, spi.process_status, spi.create_time, spi.complete_time, spi.employee_id, mp.info_code, mp.project_name, mp.province, mp.city, mp.project_type, mp.customer_name, mp.project_origination, mp.contact_name, mp.contact_phone, mp.detail_address, mp.total_building_areas, pq.project_quote_id, pq.project_id, pq.quote_status, pq.basic_amount, pq.total_amount, pq.up_amount, pq.up_percent, pq.preferential_amount, pq.perferential_percent, pq.tax_amount, pq.other_tax_amount, pq.final_amount, pq.final_percent, pq.tax_final_amount, pq.operate_employee_id, pq.operate_time, pq.remark, pq.business_type FROM system_process_instances spi LEFT JOIN project_quotes pq ON spi.business_id = pq.project_quote_id LEFT JOIN pre_projects mp ON mp.pre_project_id = pq.project_id WHERE spi.process_type =? AND spi.process_status = ? AND spi.delete_flag = 0 AND mp.project_name LIKE ? AND spi.create_time BETWEEN ? AND ? AND spi.employee_id =? AND pq.operate_employee_id =?  AND pq.business_type =? ORDER BY spi.create_time" ;
	private final static String RESULTSETFIELDLIST = "process_instance_id,process_type,business_id,business_name,process_id,process_instance_activity_id,process_status,create_time,complete_time,employee_id,info_code,project_name,province,city,project_type,customer_name,project_origination,contact_name,contact_phone,detail_address,total_building_areas,project_quote_id,project_id,quote_status,basic_amount,total_amount,up_amount,up_percent,preferential_amount,perferential_percent,tax_amount,other_tax_amount,final_amount,final_percent,tax_final_amount,operate_employee_id,operate_time,remark,company_id,business_type";
	private final static String[] fieldNames = { "process_type", "process_status", "project_name", "create_time_start", "create_time_end", "employee_id", "operate_employee_id", "business_type"};
}
