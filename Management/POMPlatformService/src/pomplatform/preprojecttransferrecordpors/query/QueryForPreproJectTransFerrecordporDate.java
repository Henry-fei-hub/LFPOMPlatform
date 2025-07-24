package pomplatform.preprojecttransferrecordpors.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.preprojecttransferrecordpors.bean.BaseForPreproJectTransFerrecordporDate;
import pomplatform.preprojecttransferrecordpors.bean.ConditionForPreproJectTransFerrecordporDate;

public class QueryForPreproJectTransFerrecordporDate extends AbstractQuery<BaseForPreproJectTransFerrecordporDate, ConditionForPreproJectTransFerrecordporDate>
{

	private static final Logger __logger = Logger.getLogger(QueryForPreproJectTransFerrecordporDate.class);

	public QueryForPreproJectTransFerrecordporDate() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("ppr.pre_project_transfer_record_id");
	}

	@Override
	public BaseCollection<BaseForPreproJectTransFerrecordporDate> executeQuery( KeyValuePair[] replacements, ConditionForPreproJectTransFerrecordporDate condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPreProjectTransferRecordId()
			);
	}

	@Override
	public BaseForPreproJectTransFerrecordporDate generateBase(Object[] __data) throws java.sql.SQLException {
		BaseForPreproJectTransFerrecordporDate __base = new BaseForPreproJectTransFerrecordporDate();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPreProjectTransferRecordId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setTransferEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setPreProjectId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCustomerName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDetailAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectType(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProjectOrigination(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTotalBuildingAreas(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setBusinessType(GenericBase.__getString(val));
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

	private final static String __SQLText = "SELECT ppr.pre_project_transfer_record_id, ppr.employee_id, ppr.transfer_employee_id, ppr.pre_project_id, pp.customer_name, pp.project_name, pp.province, pp.city, pp.detail_address, pp.project_type, pp.project_origination, pp.contact_name, pp.contact_phone, pp.total_building_areas,pp.business_type FROM pre_project_transfer_records ppr LEFT JOIN pre_projects pp ON pp.pre_project_id = ppr.pre_project_id WHERE pre_project_transfer_record_id = ?" ;
	private final static String RESULTSETFIELDLIST = "pre_project_transfer_record_id,employee_id,transfer_employee_id,pre_project_id,customer_name,project_name,province,city,detail_address,project_type,project_origination,contact_name,contact_phone,total_building_areas,business_type";
	private final static String[] fieldNames = { "pre_project_transfer_record_id"};
}
