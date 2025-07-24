package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadSupplierData extends GenericBase implements BaseFactory<BaseOnLoadSupplierData>, Comparable<BaseOnLoadSupplierData> 
{


	public static BaseOnLoadSupplierData newInstance(){
		return new BaseOnLoadSupplierData();
	}

	@Override
	public BaseOnLoadSupplierData make(){
		BaseOnLoadSupplierData b = new BaseOnLoadSupplierData();
		return b;
	}

	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_SUPPLIER_CODE = "supplier_code" ;
	public final static java.lang.String CS_SUPPLIER_NAME = "supplier_name" ;
	public final static java.lang.String CS_SUPPLIER_TYPE = "supplier_type" ;
	public final static java.lang.String CS_SUPPLIER_LEVEL = "supplier_level" ;
	public final static java.lang.String CS_REGISTERED_ADDRESS = "registered_address" ;
	public final static java.lang.String CS_REGISTERED_DATE = "registered_date" ;
	public final static java.lang.String CS_REGISTERED_CAPITAL = "registered_capital" ;
	public final static java.lang.String CS_PRODUCTION_ADDRESS = "production_address" ;
	public final static java.lang.String CS_MAJOR_CONTACT_PERSON = "major_contact_person" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_FAX = "fax" ;
	public final static java.lang.String CS_PAYMENT_METHOD = "payment_method" ;
	public final static java.lang.String CS_COUNTRY = "country" ;
	public final static java.lang.String CS_PROVINCE = "province" ;
	public final static java.lang.String CS_CITY = "city" ;
	public final static java.lang.String CS_ADDRESS = "address" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_PAY_NAME = "pay_name" ;
	public final static java.lang.String CS_PAY_CODE = "pay_code" ;
	public final static java.lang.String CS_TAX_CODE = "tax_code" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_MAJOR_BUSINESS = "major_business" ;
	public final static java.lang.String CS_START_ORDER_COUNT = "start_order_count" ;
	public final static java.lang.String CS_PRODUCTION_CYCLE = "production_cycle" ;
	public final static java.lang.String CS_LOGISTICS_CYCLE = "logistics_cycle" ;
	public final static java.lang.String CS_LOGISTICS_TYPE = "logistics_type" ;
	public final static java.lang.String CS_IS_ENABLED = "is_enabled" ;
	public final static java.lang.String CS_CREATE_EMPLOYEE_ID = "create_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_ABBREVIATED_NAME = "abbreviated_name" ;
	public final static java.lang.String CS_START_COWORK_DATE = "start_cowork_date" ;
	public final static java.lang.String CS_WARRANTY_PERIOD = "warranty_period" ;
	public final static java.lang.String CS_IS_INCLUDE_INSTALL = "is_include_install" ;
	public final static java.lang.String CS_ACCOUNT_PERIOD = "account_period" ;
	public final static java.lang.String CS_POST_CODE = "post_code" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,供应商编号,供应商名称,供应商类型对应字典表system_dictionary_187,供应商级别对应字典表system_dictionary_188,供应商注册地址,供应商注册日期,注册资金,供应商生产地址,主要联系人,联系电话,邮箱,传真,供应商支付方式,供应商所在国家,供应商所在省份,供应商所在城市,供应商详细地址,供应商支付银行名称,供应商支付账户名称,供应商支付账号,税号,父级id,供应商主要业务,起订量,生产周期,物流周期,物流方式对应字典表system_dictionary_189,是否可用,创建人,创建时间,备注,供应商简称,开始合作日期,质保期,是否含安装,账期,邮编";

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.String getSupplierCode() {
		return this.__supplier_code;
	}

	public void setSupplierCode( java.lang.String value ) {
		this.__supplier_code = value;
	}

	public java.lang.String getSupplierName() {
		return this.__supplier_name;
	}

	public void setSupplierName( java.lang.String value ) {
		this.__supplier_name = value;
	}

	public java.lang.Integer getSupplierType() {
		return this.__supplier_type;
	}

	public void setSupplierType( java.lang.Integer value ) {
		this.__supplier_type = value;
	}

	public java.lang.Integer getSupplierLevel() {
		return this.__supplier_level;
	}

	public void setSupplierLevel( java.lang.Integer value ) {
		this.__supplier_level = value;
	}

	public java.lang.String getRegisteredAddress() {
		return this.__registered_address;
	}

	public void setRegisteredAddress( java.lang.String value ) {
		this.__registered_address = value;
	}

	public java.util.Date getRegisteredDate() {
		return this.__registered_date;
	}

	public void setRegisteredDate( java.util.Date value ) {
		this.__registered_date = value;
	}

	public java.lang.String getRegisteredCapital() {
		return this.__registered_capital;
	}

	public void setRegisteredCapital( java.lang.String value ) {
		this.__registered_capital = value;
	}

	public java.lang.String getProductionAddress() {
		return this.__production_address;
	}

	public void setProductionAddress( java.lang.String value ) {
		this.__production_address = value;
	}

	public java.lang.String getMajorContactPerson() {
		return this.__major_contact_person;
	}

	public void setMajorContactPerson( java.lang.String value ) {
		this.__major_contact_person = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.String getFax() {
		return this.__fax;
	}

	public void setFax( java.lang.String value ) {
		this.__fax = value;
	}

	public java.lang.Integer getPaymentMethod() {
		return this.__payment_method;
	}

	public void setPaymentMethod( java.lang.Integer value ) {
		this.__payment_method = value;
	}

	public java.lang.Integer getCountry() {
		return this.__country;
	}

	public void setCountry( java.lang.Integer value ) {
		this.__country = value;
	}

	public java.lang.Integer getProvince() {
		return this.__province;
	}

	public void setProvince( java.lang.Integer value ) {
		this.__province = value;
	}

	public java.lang.Integer getCity() {
		return this.__city;
	}

	public void setCity( java.lang.Integer value ) {
		this.__city = value;
	}

	public java.lang.String getAddress() {
		return this.__address;
	}

	public void setAddress( java.lang.String value ) {
		this.__address = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getPayName() {
		return this.__pay_name;
	}

	public void setPayName( java.lang.String value ) {
		this.__pay_name = value;
	}

	public java.lang.String getPayCode() {
		return this.__pay_code;
	}

	public void setPayCode( java.lang.String value ) {
		this.__pay_code = value;
	}

	public java.lang.String getTaxCode() {
		return this.__tax_code;
	}

	public void setTaxCode( java.lang.String value ) {
		this.__tax_code = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.String getMajorBusiness() {
		return this.__major_business;
	}

	public void setMajorBusiness( java.lang.String value ) {
		this.__major_business = value;
	}

	public java.lang.Integer getStartOrderCount() {
		return this.__start_order_count;
	}

	public void setStartOrderCount( java.lang.Integer value ) {
		this.__start_order_count = value;
	}

	public java.lang.Integer getProductionCycle() {
		return this.__production_cycle;
	}

	public void setProductionCycle( java.lang.Integer value ) {
		this.__production_cycle = value;
	}

	public java.lang.Integer getLogisticsCycle() {
		return this.__logistics_cycle;
	}

	public void setLogisticsCycle( java.lang.Integer value ) {
		this.__logistics_cycle = value;
	}

	public java.lang.Integer getLogisticsType() {
		return this.__logistics_type;
	}

	public void setLogisticsType( java.lang.Integer value ) {
		this.__logistics_type = value;
	}

	public java.lang.Boolean getIsEnabled() {
		return this.__is_enabled;
	}

	public void setIsEnabled( java.lang.Boolean value ) {
		this.__is_enabled = value;
	}

	public java.lang.Integer getCreateEmployeeId() {
		return this.__create_employee_id;
	}

	public void setCreateEmployeeId( java.lang.Integer value ) {
		this.__create_employee_id = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.lang.String getAbbreviatedName() {
		return this.__abbreviated_name;
	}

	public void setAbbreviatedName( java.lang.String value ) {
		this.__abbreviated_name = value;
	}

	public java.util.Date getStartCoworkDate() {
		return this.__start_cowork_date;
	}

	public void setStartCoworkDate( java.util.Date value ) {
		this.__start_cowork_date = value;
	}

	public java.lang.String getWarrantyPeriod() {
		return this.__warranty_period;
	}

	public void setWarrantyPeriod( java.lang.String value ) {
		this.__warranty_period = value;
	}

	public java.lang.Boolean getIsIncludeInstall() {
		return this.__is_include_install;
	}

	public void setIsIncludeInstall( java.lang.Boolean value ) {
		this.__is_include_install = value;
	}

	public java.lang.String getAccountPeriod() {
		return this.__account_period;
	}

	public void setAccountPeriod( java.lang.String value ) {
		this.__account_period = value;
	}

	public java.lang.String getPostCode() {
		return this.__post_code;
	}

	public void setPostCode( java.lang.String value ) {
		this.__post_code = value;
	}

	public void cloneCopy(BaseOnLoadSupplierData __bean){
		__bean.setSupplierId(getSupplierId());
		__bean.setSupplierCode(getSupplierCode());
		__bean.setSupplierName(getSupplierName());
		__bean.setSupplierType(getSupplierType());
		__bean.setSupplierLevel(getSupplierLevel());
		__bean.setRegisteredAddress(getRegisteredAddress());
		__bean.setRegisteredDate(getRegisteredDate());
		__bean.setRegisteredCapital(getRegisteredCapital());
		__bean.setProductionAddress(getProductionAddress());
		__bean.setMajorContactPerson(getMajorContactPerson());
		__bean.setContactPhone(getContactPhone());
		__bean.setEmail(getEmail());
		__bean.setFax(getFax());
		__bean.setPaymentMethod(getPaymentMethod());
		__bean.setCountry(getCountry());
		__bean.setProvince(getProvince());
		__bean.setCity(getCity());
		__bean.setAddress(getAddress());
		__bean.setBankName(getBankName());
		__bean.setPayName(getPayName());
		__bean.setPayCode(getPayCode());
		__bean.setTaxCode(getTaxCode());
		__bean.setParentId(getParentId());
		__bean.setMajorBusiness(getMajorBusiness());
		__bean.setStartOrderCount(getStartOrderCount());
		__bean.setProductionCycle(getProductionCycle());
		__bean.setLogisticsCycle(getLogisticsCycle());
		__bean.setLogisticsType(getLogisticsType());
		__bean.setIsEnabled(getIsEnabled());
		__bean.setCreateEmployeeId(getCreateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
		__bean.setAbbreviatedName(getAbbreviatedName());
		__bean.setStartCoworkDate(getStartCoworkDate());
		__bean.setWarrantyPeriod(getWarrantyPeriod());
		__bean.setIsIncludeInstall(getIsIncludeInstall());
		__bean.setAccountPeriod(getAccountPeriod());
		__bean.setPostCode(getPostCode());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getSupplierCode() == null ? "" : getSupplierCode());
		sb.append(",");
		sb.append(getSupplierName() == null ? "" : getSupplierName());
		sb.append(",");
		String strSupplierType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_187", String.valueOf(getSupplierType()));
		sb.append(strSupplierType == null ? "" : strSupplierType);
		sb.append(",");
		String strSupplierLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_188", String.valueOf(getSupplierLevel()));
		sb.append(strSupplierLevel == null ? "" : strSupplierLevel);
		sb.append(",");
		sb.append(getRegisteredAddress() == null ? "" : getRegisteredAddress());
		sb.append(",");
		sb.append(getRegisteredDate() == null ? "" : sdf.format(getRegisteredDate()));
		sb.append(",");
		sb.append(getRegisteredCapital() == null ? "" : getRegisteredCapital());
		sb.append(",");
		sb.append(getProductionAddress() == null ? "" : getProductionAddress());
		sb.append(",");
		sb.append(getMajorContactPerson() == null ? "" : getMajorContactPerson());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getFax() == null ? "" : getFax());
		sb.append(",");
		sb.append(getPaymentMethod() == null ? "" : getPaymentMethod());
		sb.append(",");
		String strCountry = delicacy.system.executor.SelectValueCache.getSelectValue("countries", String.valueOf(getCountry()));
		sb.append(strCountry == null ? "" : strCountry);
		sb.append(",");
		String strProvince = delicacy.system.executor.SelectValueCache.getSelectValue("", String.valueOf(getProvince()));
		sb.append(strProvince == null ? "" : strProvince);
		sb.append(",");
		sb.append(getCity() == null ? "" : getCity());
		sb.append(",");
		sb.append(getAddress() == null ? "" : getAddress());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getPayName() == null ? "" : getPayName());
		sb.append(",");
		sb.append(getPayCode() == null ? "" : getPayCode());
		sb.append(",");
		sb.append(getTaxCode() == null ? "" : getTaxCode());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		sb.append(getMajorBusiness() == null ? "" : getMajorBusiness());
		sb.append(",");
		sb.append(getStartOrderCount() == null ? "" : getStartOrderCount());
		sb.append(",");
		sb.append(getProductionCycle() == null ? "" : getProductionCycle());
		sb.append(",");
		sb.append(getLogisticsCycle() == null ? "" : getLogisticsCycle());
		sb.append(",");
		String strLogisticsType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_189", String.valueOf(getLogisticsType()));
		sb.append(strLogisticsType == null ? "" : strLogisticsType);
		sb.append(",");
		sb.append(getIsEnabled() == null ? "" : getIsEnabled());
		sb.append(",");
		sb.append(getCreateEmployeeId() == null ? "" : getCreateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getAbbreviatedName() == null ? "" : getAbbreviatedName());
		sb.append(",");
		sb.append(getStartCoworkDate() == null ? "" : sdf.format(getStartCoworkDate()));
		sb.append(",");
		sb.append(getWarrantyPeriod() == null ? "" : getWarrantyPeriod());
		sb.append(",");
		sb.append(getIsIncludeInstall() == null ? "" : getIsIncludeInstall());
		sb.append(",");
		sb.append(getAccountPeriod() == null ? "" : getAccountPeriod());
		sb.append(",");
		sb.append(getPostCode() == null ? "" : getPostCode());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadSupplierData o) {
		return __supplier_id == null ? -1 : __supplier_id.compareTo(o.getSupplierId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_code);
		hash = 97 * hash + Objects.hashCode(this.__supplier_name);
		hash = 97 * hash + Objects.hashCode(this.__supplier_type);
		hash = 97 * hash + Objects.hashCode(this.__supplier_level);
		hash = 97 * hash + Objects.hashCode(this.__registered_address);
		hash = 97 * hash + Objects.hashCode(this.__registered_date);
		hash = 97 * hash + Objects.hashCode(this.__registered_capital);
		hash = 97 * hash + Objects.hashCode(this.__production_address);
		hash = 97 * hash + Objects.hashCode(this.__major_contact_person);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__fax);
		hash = 97 * hash + Objects.hashCode(this.__payment_method);
		hash = 97 * hash + Objects.hashCode(this.__country);
		hash = 97 * hash + Objects.hashCode(this.__province);
		hash = 97 * hash + Objects.hashCode(this.__city);
		hash = 97 * hash + Objects.hashCode(this.__address);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_name);
		hash = 97 * hash + Objects.hashCode(this.__pay_code);
		hash = 97 * hash + Objects.hashCode(this.__tax_code);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__major_business);
		hash = 97 * hash + Objects.hashCode(this.__start_order_count);
		hash = 97 * hash + Objects.hashCode(this.__production_cycle);
		hash = 97 * hash + Objects.hashCode(this.__logistics_cycle);
		hash = 97 * hash + Objects.hashCode(this.__logistics_type);
		hash = 97 * hash + Objects.hashCode(this.__is_enabled);
		hash = 97 * hash + Objects.hashCode(this.__create_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__abbreviated_name);
		hash = 97 * hash + Objects.hashCode(this.__start_cowork_date);
		hash = 97 * hash + Objects.hashCode(this.__warranty_period);
		hash = 97 * hash + Objects.hashCode(this.__is_include_install);
		hash = 97 * hash + Objects.hashCode(this.__account_period);
		hash = 97 * hash + Objects.hashCode(this.__post_code);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadSupplierData o = (BaseOnLoadSupplierData)obj;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__supplier_code, o.getSupplierCode())) return false;
		if(!Objects.equals(this.__supplier_name, o.getSupplierName())) return false;
		if(!Objects.equals(this.__supplier_type, o.getSupplierType())) return false;
		if(!Objects.equals(this.__supplier_level, o.getSupplierLevel())) return false;
		if(!Objects.equals(this.__registered_address, o.getRegisteredAddress())) return false;
		if(!Objects.equals(this.__registered_date, o.getRegisteredDate())) return false;
		if(!Objects.equals(this.__registered_capital, o.getRegisteredCapital())) return false;
		if(!Objects.equals(this.__production_address, o.getProductionAddress())) return false;
		if(!Objects.equals(this.__major_contact_person, o.getMajorContactPerson())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__fax, o.getFax())) return false;
		if(!Objects.equals(this.__payment_method, o.getPaymentMethod())) return false;
		if(!Objects.equals(this.__country, o.getCountry())) return false;
		if(!Objects.equals(this.__province, o.getProvince())) return false;
		if(!Objects.equals(this.__city, o.getCity())) return false;
		if(!Objects.equals(this.__address, o.getAddress())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__pay_name, o.getPayName())) return false;
		if(!Objects.equals(this.__pay_code, o.getPayCode())) return false;
		if(!Objects.equals(this.__tax_code, o.getTaxCode())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__major_business, o.getMajorBusiness())) return false;
		if(!Objects.equals(this.__start_order_count, o.getStartOrderCount())) return false;
		if(!Objects.equals(this.__production_cycle, o.getProductionCycle())) return false;
		if(!Objects.equals(this.__logistics_cycle, o.getLogisticsCycle())) return false;
		if(!Objects.equals(this.__logistics_type, o.getLogisticsType())) return false;
		if(!Objects.equals(this.__is_enabled, o.getIsEnabled())) return false;
		if(!Objects.equals(this.__create_employee_id, o.getCreateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__abbreviated_name, o.getAbbreviatedName())) return false;
		if(!Objects.equals(this.__start_cowork_date, o.getStartCoworkDate())) return false;
		if(!Objects.equals(this.__warranty_period, o.getWarrantyPeriod())) return false;
		if(!Objects.equals(this.__is_include_install, o.getIsIncludeInstall())) return false;
		if(!Objects.equals(this.__account_period, o.getAccountPeriod())) return false;
		if(!Objects.equals(this.__post_code, o.getPostCode())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getSupplierCode() != null) sb.append(__wrapString(count++, "supplierCode", getSupplierCode()));
		if(getSupplierName() != null) sb.append(__wrapString(count++, "supplierName", getSupplierName()));
		if(getSupplierType() != null) sb.append(__wrapNumber(count++, "supplierType", getSupplierType()));
		if(getSupplierLevel() != null) sb.append(__wrapNumber(count++, "supplierLevel", getSupplierLevel()));
		if(getRegisteredAddress() != null) sb.append(__wrapString(count++, "registeredAddress", getRegisteredAddress()));
		if(getRegisteredDate() != null) sb.append(__wrapDate(count++, "registeredDate", getRegisteredDate()));
		if(getRegisteredCapital() != null) sb.append(__wrapString(count++, "registeredCapital", getRegisteredCapital()));
		if(getProductionAddress() != null) sb.append(__wrapString(count++, "productionAddress", getProductionAddress()));
		if(getMajorContactPerson() != null) sb.append(__wrapString(count++, "majorContactPerson", getMajorContactPerson()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getFax() != null) sb.append(__wrapString(count++, "fax", getFax()));
		if(getPaymentMethod() != null) sb.append(__wrapNumber(count++, "paymentMethod", getPaymentMethod()));
		if(getCountry() != null) sb.append(__wrapNumber(count++, "country", getCountry()));
		if(getProvince() != null) sb.append(__wrapNumber(count++, "province", getProvince()));
		if(getCity() != null) sb.append(__wrapNumber(count++, "city", getCity()));
		if(getAddress() != null) sb.append(__wrapString(count++, "address", getAddress()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getPayName() != null) sb.append(__wrapString(count++, "payName", getPayName()));
		if(getPayCode() != null) sb.append(__wrapString(count++, "payCode", getPayCode()));
		if(getTaxCode() != null) sb.append(__wrapString(count++, "taxCode", getTaxCode()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getMajorBusiness() != null) sb.append(__wrapString(count++, "majorBusiness", getMajorBusiness()));
		if(getStartOrderCount() != null) sb.append(__wrapNumber(count++, "startOrderCount", getStartOrderCount()));
		if(getProductionCycle() != null) sb.append(__wrapNumber(count++, "productionCycle", getProductionCycle()));
		if(getLogisticsCycle() != null) sb.append(__wrapNumber(count++, "logisticsCycle", getLogisticsCycle()));
		if(getLogisticsType() != null) sb.append(__wrapNumber(count++, "logisticsType", getLogisticsType()));
		if(getIsEnabled() != null) sb.append(__wrapBoolean(count++, "isEnabled", getIsEnabled()));
		if(getCreateEmployeeId() != null) sb.append(__wrapNumber(count++, "createEmployeeId", getCreateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getAbbreviatedName() != null) sb.append(__wrapString(count++, "abbreviatedName", getAbbreviatedName()));
		if(getStartCoworkDate() != null) sb.append(__wrapDate(count++, "startCoworkDate", getStartCoworkDate()));
		if(getWarrantyPeriod() != null) sb.append(__wrapString(count++, "warrantyPeriod", getWarrantyPeriod()));
		if(getIsIncludeInstall() != null) sb.append(__wrapBoolean(count++, "isIncludeInstall", getIsIncludeInstall()));
		if(getAccountPeriod() != null) sb.append(__wrapString(count++, "accountPeriod", getAccountPeriod()));
		if(getPostCode() != null) sb.append(__wrapString(count++, "postCode", getPostCode()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("supplierCode")) != null) setSupplierCode(__getString(val));
		if((val = values.get("supplierName")) != null) setSupplierName(__getString(val));
		if((val = values.get("supplierType")) != null) setSupplierType(__getInt(val)); 
		if((val = values.get("supplierLevel")) != null) setSupplierLevel(__getInt(val)); 
		if((val = values.get("registeredAddress")) != null) setRegisteredAddress(__getString(val));
		if((val = values.get("registeredDate")) != null) setRegisteredDate(__getDate(val)); 
		if((val = values.get("registeredCapital")) != null) setRegisteredCapital(__getString(val));
		if((val = values.get("productionAddress")) != null) setProductionAddress(__getString(val));
		if((val = values.get("majorContactPerson")) != null) setMajorContactPerson(__getString(val));
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("fax")) != null) setFax(__getString(val));
		if((val = values.get("paymentMethod")) != null) setPaymentMethod(__getInt(val)); 
		if((val = values.get("country")) != null) setCountry(__getInt(val)); 
		if((val = values.get("province")) != null) setProvince(__getInt(val)); 
		if((val = values.get("city")) != null) setCity(__getInt(val)); 
		if((val = values.get("address")) != null) setAddress(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("payName")) != null) setPayName(__getString(val));
		if((val = values.get("payCode")) != null) setPayCode(__getString(val));
		if((val = values.get("taxCode")) != null) setTaxCode(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("majorBusiness")) != null) setMajorBusiness(__getString(val));
		if((val = values.get("startOrderCount")) != null) setStartOrderCount(__getInt(val)); 
		if((val = values.get("productionCycle")) != null) setProductionCycle(__getInt(val)); 
		if((val = values.get("logisticsCycle")) != null) setLogisticsCycle(__getInt(val)); 
		if((val = values.get("logisticsType")) != null) setLogisticsType(__getInt(val)); 
		if((val = values.get("isEnabled")) != null) setIsEnabled(__getBoolean(val));
		if((val = values.get("createEmployeeId")) != null) setCreateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("abbreviatedName")) != null) setAbbreviatedName(__getString(val));
		if((val = values.get("startCoworkDate")) != null) setStartCoworkDate(__getDate(val)); 
		if((val = values.get("warrantyPeriod")) != null) setWarrantyPeriod(__getString(val));
		if((val = values.get("isIncludeInstall")) != null) setIsIncludeInstall(__getBoolean(val));
		if((val = values.get("accountPeriod")) != null) setAccountPeriod(__getString(val));
		if((val = values.get("postCode")) != null) setPostCode(__getString(val));
	}

	protected java.lang.Integer  __supplier_id ;
	protected java.lang.String  __supplier_code ;
	protected java.lang.String  __supplier_name ;
	protected java.lang.Integer  __supplier_type ;
	protected java.lang.Integer  __supplier_level ;
	protected java.lang.String  __registered_address ;
	protected java.util.Date  __registered_date ;
	protected java.lang.String  __registered_capital ;
	protected java.lang.String  __production_address ;
	protected java.lang.String  __major_contact_person ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __email ;
	protected java.lang.String  __fax ;
	protected java.lang.Integer  __payment_method ;
	protected java.lang.Integer  __country ;
	protected java.lang.Integer  __province ;
	protected java.lang.Integer  __city ;
	protected java.lang.String  __address ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __pay_name ;
	protected java.lang.String  __pay_code ;
	protected java.lang.String  __tax_code ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.String  __major_business ;
	protected java.lang.Integer  __start_order_count ;
	protected java.lang.Integer  __production_cycle ;
	protected java.lang.Integer  __logistics_cycle ;
	protected java.lang.Integer  __logistics_type ;
	protected java.lang.Boolean  __is_enabled ;
	protected java.lang.Integer  __create_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
	protected java.lang.String  __abbreviated_name ;
	protected java.util.Date  __start_cowork_date ;
	protected java.lang.String  __warranty_period ;
	protected java.lang.Boolean  __is_include_install ;
	protected java.lang.String  __account_period ;
	protected java.lang.String  __post_code ;
}
