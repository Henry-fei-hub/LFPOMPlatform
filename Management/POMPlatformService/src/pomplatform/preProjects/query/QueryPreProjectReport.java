package pomplatform.preProjects.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preProjects.bean.BasePreProjectReport;
import pomplatform.preProjects.bean.ConditionPreProjectReport;

public class QueryPreProjectReport extends AbstractQuery<BasePreProjectReport, ConditionPreProjectReport>
{

	private static final Logger __logger = Logger.getLogger(QueryPreProjectReport.class);

	public QueryPreProjectReport() throws java.sql.SQLException
	{
		setParameterNumber(0);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("a.main_project_id");
	}

	@Override
	public BaseCollection<BasePreProjectReport> executeQuery( KeyValuePair[] replacements, ConditionPreProjectReport condition ) throws java.sql.SQLException {
		return executeQuery(replacements
		);
	}

	@Override
	public BasePreProjectReport generateBase(Object[] __data) throws java.sql.SQLException {
		BasePreProjectReport __base = new BasePreProjectReport();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setMainProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setInfoCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCustomerType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsWarehous(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setIsApplyQuote(GenericBase.__getBoolean(val));
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

	private final static String __SQLText = "SELECT a.main_project_id,a.info_code,a.project_name,a.customer_name,a.province,a.city,a.detail_address,a.project_type,a.total_building_areas,a.project_origination, a.contact_name,a.contact_phone, b.customer_type,b.is_warehous,b.is_apply_quote FROM main_projects a LEFT JOIN customers b ON a.client_id = b.customer_id" ;
	private final static String RESULTSETFIELDLIST = "main_project_id,info_code,project_name,customer_name,province,city,detail_address,project_type,total_building_areas,project_origination,contact_name,contact_phone,customer_type,is_warehous,is_apply_quote";
	private final static String[] fieldNames = { };
}