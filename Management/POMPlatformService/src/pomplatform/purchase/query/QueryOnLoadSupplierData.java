package pomplatform.purchase.query;

import org.apache.log4j.Logger;
import delicacy.common.KeyValuePair;
import delicacy.common.AbstractQuery;
import delicacy.common.GenericBase;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import pomplatform.purchase.bean.BaseOnLoadSupplierData;
import pomplatform.purchase.bean.ConditionOnLoadSupplierData;

public class QueryOnLoadSupplierData extends AbstractQuery<BaseOnLoadSupplierData, ConditionOnLoadSupplierData>
{

	private static final Logger __logger = Logger.getLogger(QueryOnLoadSupplierData.class);

	public QueryOnLoadSupplierData() throws java.sql.SQLException 
	{
		setParameterNumber(10);
		setConnection(ThreadConnection.getConnection());
		setOrderByFields("s.supplier_id");
	}

	@Override
	public BaseCollection<BaseOnLoadSupplierData> executeQuery( KeyValuePair[] replacements, ConditionOnLoadSupplierData condition ) throws java.sql.SQLException {
		return executeQuery(replacements, 
				condition.getSupplierCode(), 
				condition.getSupplierName(), 
				condition.getSupplierType(), 
				condition.getSupplierLevel(), 
				condition.getLogisticsType(), 
				condition.getMajorContactPerson(), 
				condition.getCountry(), 
				condition.getProvince(), 
				condition.getCity(), 
				condition.getAddress()
			);
	}

	@Override
	public BaseOnLoadSupplierData generateBase(Object[] __data) throws java.sql.SQLException {
		BaseOnLoadSupplierData __base = new BaseOnLoadSupplierData();
		int count = 0;
		Object val;
		if((val = __data[count++]) != null) __base.setSupplierId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setSupplierType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setSupplierLevel(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setRegisteredAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setRegisteredDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRegisteredCapital(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setProductionAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setMajorContactPerson(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setContactPhone(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setEmail(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setFax(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPaymentMethod(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCountry(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProvince(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCity(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setAddress(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setBankName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPayCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setTaxCode(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setParentId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setMajorBusiness(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartOrderCount(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setProductionCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogisticsCycle(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setLogisticsType(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setIsEnabled(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setCreateEmployeeId(GenericBase.__getInt(val));
		if((val = __data[count++]) != null) __base.setCreateTime(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setRemark(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setAbbreviatedName(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setStartCoworkDate(GenericBase.__getDateFromSQL(val));
		if((val = __data[count++]) != null) __base.setWarrantyPeriod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setIsIncludeInstall(GenericBase.__getBoolean(val));
		if((val = __data[count++]) != null) __base.setAccountPeriod(GenericBase.__getString(val));
		if((val = __data[count++]) != null) __base.setPostCode(GenericBase.__getString(val));
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
		if(args[3] != null) __statement.setInt(count++, GenericBase.__getInt(args[3]));
		if(args[4] != null) __statement.setInt(count++, GenericBase.__getInt(args[4]));
		if(args[5] != null) __statement.setString(count++, GenericBase.__getString(args[5]));
		if(args[6] != null) __statement.setInt(count++, GenericBase.__getInt(args[6]));
		if(args[7] != null) __statement.setInt(count++, GenericBase.__getInt(args[7]));
		if(args[8] != null) __statement.setInt(count++, GenericBase.__getInt(args[8]));
		if(args[9] != null) __statement.setString(count++, GenericBase.__getString(args[9]));
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

	private final static String __SQLText = "select s.supplier_id, s.supplier_code, s.supplier_name, s.supplier_type, s.supplier_level, s.registered_address, s.registered_date, s.registered_capital , s.production_address, s.major_contact_person, s.contact_phone, s.email, s.fax, s.payment_method, s.country, s.province, s.city, s.address , s.bank_name , s.pay_name, s.pay_code, s.tax_code, s.parent_id, s.major_business, s.start_order_count, s.production_cycle, s.logistics_cycle , s.logistics_type, s.is_enabled , s.create_employee_id, s.create_time, s.remark,s.abbreviated_name,s.start_cowork_date,s.warranty_period,s.is_include_install,s.account_period,s.post_code from suppliers s where s.supplier_code like ? AND s.supplier_name like ? AND s.supplier_type = ? AND s.supplier_level = ? and s.logistics_type = ? AND s.major_contact_person LIKE ? AND s.country = ? AND s.province = ? AND s.city = ? AND s.address LIKE ? ORDER BY s.supplier_id DESC" ;
	private final static String RESULTSETFIELDLIST = "supplier_id,supplier_code,supplier_name,supplier_type,supplier_level,registered_address,registered_date,registered_capital,production_address,major_contact_person,contact_phone,email,fax,payment_method,country,province,city,address,bank_name,pay_name,pay_code,tax_code,parent_id,major_business,start_order_count,production_cycle,logistics_cycle,logistics_type,is_enabled,create_employee_id,create_time,remark,abbreviated_name,start_cowork_date,warranty_period,is_include_install,account_period,post_code";
	private final static String[] fieldNames = { "supplier_code", "supplier_name", "supplier_type", "supplier_level", "logistics_type", "major_contact_person", "country", "province", "city", "address"};
}
