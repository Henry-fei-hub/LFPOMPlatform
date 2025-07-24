package pomplatform.rmimburseementinvoice.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.rmimburseementinvoice.bean.BaseMreimbursementinvoiceinformationrsrmmpror;
import pomplatform.rmimburseementinvoice.bean.ConditionMreimbursementinvoiceinformationrsrmmpror;

public class QueryMreimbursementinvoiceinformationrsrmmpror extends AbstractQuery<BaseMreimbursementinvoiceinformationrsrmmpror, ConditionMreimbursementinvoiceinformationrsrmmpror>
{

	private static final Logger __logger = Logger.getLogger(QueryMreimbursementinvoiceinformationrsrmmpror.class);

	public QueryMreimbursementinvoiceinformationrsrmmpror() throws java.sql.SQLException 
	{
		setParameterNumber(5);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("rp.code as package_code");
	}

	@Override
	public BaseCollection<BaseMreimbursementinvoiceinformationrsrmmpror> executeQuery( KeyValuePair[] replacements, ConditionMreimbursementinvoiceinformationrsrmmpror condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getMinCompleteTime(), 
				condition.getMaxCompleteTime(), 
				condition.getPackageCode(), 
				condition.getRmiCode(), 
				condition.getCompanyId()
			);
	}

	@Override
	public BaseMreimbursementinvoiceinformationrsrmmpror generateBase(Object[] __data) throws java.sql.SQLException {
		BaseMreimbursementinvoiceinformationrsrmmpror __base = new BaseMreimbursementinvoiceinformationrsrmmpror();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setPackageCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRmiCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setCompanyId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProcessType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setBusinessId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAircraftQuantity(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setAircraftTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setAircraftTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRailQuantity(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setRailTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setRailTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPtQuantity(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setPtTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setPtTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNormalQuantity(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setNormalTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setNormalTaxAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGiQuantity(GenericBase.__getLong(val));
		if((val = __data[count++]) != null) __base.setGiTotalAmount(GenericBase.__getDecimal(val));
		if((val = __data[count++]) != null) __base.setGiTaxAmount(GenericBase.__getDecimal(val));
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
		if(args[0] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[0]));
		if(args[1] != null) __statement.setTimestamp(count++, generateTimestampFromDate((java.util.Date)args[1]));
		if(args[2] != null) __statement.setString(count++, GenericBase.__getString(args[2]));
		if(args[3] != null) __statement.setString(count++, GenericBase.__getString(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
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

	private final static String __SQLText = "select rp.code as package_code, b.code as rmi_code, rp.company_id, a.* from ( SELECT rii.process_type, rii.business_id, sum( CASE WHEN invoice_type = 1 THEN invoice_quantity END ) AS aircraft_quantity, sum( CASE WHEN invoice_type = 1 THEN total_amount END ) AS aircraft_total_amount, sum( CASE WHEN invoice_type = 1 THEN tax_amount END ) AS aircraft_tax_amount, sum( CASE WHEN invoice_type = 2 THEN invoice_quantity END ) AS rail_quantity, sum( CASE WHEN invoice_type = 2 THEN total_amount END ) AS rail_total_amount, sum( CASE WHEN invoice_type = 2 THEN tax_amount END ) AS rail_tax_amount, sum(case when invoice_type = 3 then invoice_quantity end) as pt_quantity, sum(case when invoice_type = 3 then total_amount end) as pt_total_amount, sum(case when invoice_type = 3 then tax_amount end) as pt_tax_amount, sum(case when invoice_type = 4 then invoice_quantity end) as normal_quantity, sum(case when invoice_type = 4 then total_amount end) as normal_total_amount, sum(case when invoice_type = 4 then tax_amount end) as normal_tax_amount, sum(case when invoice_type = 5 then invoice_quantity end) as gi_quantity, sum(case when invoice_type = 5 then total_amount end) as gi_total_amount, sum(case when invoice_type = 5 then tax_amount end) as gi_tax_amount FROM reimbursement_invoice_informations rii WHERE rii.invoice_type in (1, 2, 3, 4, 5) GROUP BY rii.process_type, rii.business_id, rii.invoice_type ) a left join ( select rpd.process_type_id,rpd.business_id,rpd.code,rpd.reimbursement_package_id from reimbursement_package_details rpd GROUP BY rpd.process_type_id,rpd.business_id,rpd.code,rpd.reimbursement_package_id ) b on b.process_type_id = a.process_type and a.business_id = b.business_id left join system_process_instances spi on b.process_type_id = spi.process_type and spi.business_id = b.business_id left join reimbursement_packages rp on rp.reimbursement_package_id = b.reimbursement_package_id WHERE spi.process_status = 3 and spi.complete_time BETWEEN ? and ? and rp.code like ? and b.code like ? and b.company_id = ? ORDER BY spi.complete_time" ;
	private final static String RESULTSETFIELDLIST = "package_code,rmi_code,company_id,process_type,business_id,aircraft_quantity,aircraft_total_amount,aircraft_tax_amount,rail_quantity,rail_total_amount,rail_tax_amount,pt_quantity,pt_total_amount,pt_tax_amount,normal_quantity,normal_total_amount,normal_tax_amount,gi_quantity,gi_total_amount,gi_tax_amount";
	private final static String[] fieldNames = { "min_complete_time", "max_complete_time", "package_code", "rmi_code", "company_id"};
}
