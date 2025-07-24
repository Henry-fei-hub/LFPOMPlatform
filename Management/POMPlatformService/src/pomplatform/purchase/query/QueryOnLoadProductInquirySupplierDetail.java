package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseOnLoadProductInquirySupplierDetail;
import pomplatform.purchase.bean.ConditionOnLoadProductInquirySupplierDetail;

public class QueryOnLoadProductInquirySupplierDetail extends AbstractQuery<BaseOnLoadProductInquirySupplierDetail, ConditionOnLoadProductInquirySupplierDetail>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadProductInquirySupplierDetail.class);

	public QueryOnLoadProductInquirySupplierDetail() throws java.sql.SQLException 
	{
		setParameterNumber(7);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("pisd.product_inquiry_supplier_detail_id");
	}

	@Override
	public BaseCollection<BaseOnLoadProductInquirySupplierDetail> executeQuery( KeyValuePair[] replacements, ConditionOnLoadProductInquirySupplierDetail condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getPriorityLevel(), 
				condition.getRemark(), 
				condition.getSupplierContactId(), 
				condition.getProductInquirySupplierDetailId(), 
				condition.getSupplierId(), 
				condition.getProductInquiryDetailId(), 
				condition.getOperatorId()
			);
	}

	@Override
	public BaseOnLoadProductInquirySupplierDetail generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadProductInquirySupplierDetail __base = new BaseOnLoadProductInquirySupplierDetail();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setProductInquirySupplierDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductInquiryDetailId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTotalPrice(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setTaxPoints(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPriorityLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setInquiryDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setOperatorId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierContactId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsSelect(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setContactName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPosition(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactGender(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactFax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactType(GenericBase.__getInt(val));
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
		if(args[2] != null) __statement.setInt(count++, GenericBase.__getInt(args[2]));
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setInt(count++, GenericBase.__getInt(args[5]));
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

	private final static String __SQLText = "SELECT pisd.product_inquiry_supplier_detail_id, pisd.supplier_id, pisd.product_inquiry_detail_id, pisd.product_price, pisd.total_price, pisd.tax_points, pisd.priority_level, pisd.remark, pisd.inquiry_date, pisd.create_time, pisd.operator_id, pisd.supplier_contact_id, pisd.is_select, sc.contact_name, sc.contact_position, sc.contact_gender, sc.contact_phone, sc.contact_email, sc.contact_fax, sc.contact_type FROM product_inquiry_supplier_details pisd LEFT JOIN supplier_contacts sc ON sc.supplier_contact_id = pisd.supplier_contact_id WHERE pisd.priority_level = ? AND pisd.remark LIKE ? AND pisd.supplier_contact_id = ? AND pisd.product_inquiry_supplier_detail_id = ? AND pisd.supplier_id = ? AND pisd.product_inquiry_detail_id = ? AND pisd.operator_id = ?" ;
	private final static String RESULTSETFIELDLIST = "product_inquiry_supplier_detail_id,supplier_id,product_inquiry_detail_id,product_price,total_price,tax_points,priority_level,remark,inquiry_date,create_time,operator_id,supplier_contact_id,is_select,contact_name,contact_position,contact_gender,contact_phone,contact_email,contact_fax,contact_type";
	private final static String[] fieldNames = { "priority_level", "remark", "supplier_contact_id", "product_inquiry_supplier_detail_id", "supplier_id", "product_inquiry_detail_id", "operator_id"};
}
