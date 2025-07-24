package pomplatform.workflow.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.workflow.purchase.bean.BaseSproductinquirytotalpor;
import pomplatform.workflow.purchase.bean.ConditionSproductinquirytotalpor;

public class QuerySproductinquirytotalpor extends AbstractQuery<BaseSproductinquirytotalpor, ConditionSproductinquirytotalpor>
{

	private static final Logger __logger = Logger.getLogger(QuerySproductinquirytotalpor.class);

	public QuerySproductinquirytotalpor() throws java.sql.SQLException 
	{
		setParameterNumber(1);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pit.product_inquiry_total_id");
	}

	@Override
	public BaseCollection<BaseSproductinquirytotalpor> executeQuery( KeyValuePair[] replacements, ConditionSproductinquirytotalpor condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getProductInquiryTotalId()
			);
	}

	@Override
	public BaseSproductinquirytotalpor generateBase(Object[] __data) throws java.sql.SQLException {
		BaseSproductinquirytotalpor __base = new BaseSproductinquirytotalpor();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductInquiryTotalId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMajorTitle(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setReason(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmployeeNo(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setDepartmentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setDeleteFlag(GenericBase.__getInt(val));
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

	private final static String __SQLText = "select pit.product_inquiry_total_id, pit.major_title, pit.process_type, pit.reason, pit.employee_no, pit.department_id, pit.create_employee_id, pit.create_time, pit.delete_flag, pit.remark from product_inquiry_totals pit where pit.product_inquiry_total_id = ?" ;
	private final static String RESULTSETFIELDLIST = "product_inquiry_total_id,major_title,process_type,reason,employee_no,department_id,create_employee_id,create_time,delete_flag,remark";
	private final static String[] fieldNames = { "product_inquiry_total_id"};
}
