package pomplatform.customer.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.customer.bean.BaseOnLoadCustomerData;
import pomplatform.customer.bean.ConditionOnLoadCustomerData;

public class QueryOnLoadCustomerData extends AbstractQuery<BaseOnLoadCustomerData, ConditionOnLoadCustomerData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadCustomerData.class);

	public QueryOnLoadCustomerData() throws java.sql.SQLException 
	{
		setParameterNumber(13);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("customer_id");
	}

	@Override
	public BaseCollection<BaseOnLoadCustomerData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadCustomerData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getCustomerId(), 
				condition.getCustomerName(), 
				condition.getCompanyAddress(), 
				condition.getCustomerType(), 
				condition.getCustomerLevel(), 
				condition.getReportEmployeeId(), 
				condition.getIsSure(), 
				condition.getIsWarehous(), 
				condition.getIsApplyQuote(), 
				condition.getCompanyProvince(), 
				condition.getCompanyCity(), 
				condition.getParentId(), 
				condition.getType()
			);
	}

	@Override
	public BaseOnLoadCustomerData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadCustomerData __base = new BaseOnLoadCustomerData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setCustomerId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyMobile(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReportEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsSure(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCompanyProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPostCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setWebSite(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyFax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyStockCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyEmployeeNum(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCompanySetup(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCompanyNature(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyQualification(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyOrganizational(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyBrief(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyParentName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyParentAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyChildName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setOperateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
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
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
		if(args[6] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[6]));
		if(args[7] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[7]));
		if(args[8] != null) __statement.setBoolean(count++, GenericBase.__getBoolean(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
		if(args[10] != null) __statement.setString(count++, GenericBase.__getString(args[10]));
		if(args[11] != null) __statement.setInt(count++, GenericBase.__getInt(args[11]));
		if(args[12] != null) __statement.setInt(count++, GenericBase.__getInt(args[12]));
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

	private final static String __SQLText = "select customer_id,customer_name,company_address,company_mobile,customer_type,customer_level,report_employee_id,is_sure,is_warehous,is_apply_quote,company_province,company_city ,post_code,web_site,company_fax,company_stock_code,company_employee_num,company_setup,company_nature,company_qualification,company_organizational,company_brief ,company_parent_name,company_parent_address,company_child_name,parent_id,type,operate_employee_id,create_time,remark from customers where customer_id = ? and customer_name like ? and company_address like ? and customer_type =? and customer_level =? and report_employee_id =? and is_sure =? and is_warehous =? and is_apply_quote =? and company_province =? and company_city =? and parent_id =? and type =? ORDER BY create_time desc,report_employee_id asc" ;
	private final static String RESULTSETFIELDLIST = "customer_id,customer_name,company_address,company_mobile,customer_type,customer_level,report_employee_id,is_sure,is_warehous,is_apply_quote,company_province,company_city,post_code,web_site,company_fax,company_stock_code,company_employee_num,company_setup,company_nature,company_qualification,company_organizational,company_brief,company_parent_name,company_parent_address,company_child_name,parent_id,type,operate_employee_id,create_time,remark";
	private final static String[] fieldNames = { "customer_id", "customer_name", "company_address", "customer_type", "customer_level", "report_employee_id", "is_sure", "is_warehous", "is_apply_quote", "company_province", "company_city", "parent_id", "type"};
}
