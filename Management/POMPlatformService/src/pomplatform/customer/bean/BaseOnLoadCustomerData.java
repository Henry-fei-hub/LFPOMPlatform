package pomplatform.customer.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadCustomerData extends GenericBase implements BaseFactory<BaseOnLoadCustomerData>, Comparable<BaseOnLoadCustomerData> 
{


	public static BaseOnLoadCustomerData newInstance(){
		return new BaseOnLoadCustomerData();
	}

	@Override
	public BaseOnLoadCustomerData make(){
		BaseOnLoadCustomerData b = new BaseOnLoadCustomerData();
		return b;
	}

	public final static java.lang.String CS_CUSTOMER_ID = "customer_id" ;
	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_COMPANY_ADDRESS = "company_address" ;
	public final static java.lang.String CS_COMPANY_MOBILE = "company_mobile" ;
	public final static java.lang.String CS_CUSTOMER_TYPE = "customer_type" ;
	public final static java.lang.String CS_CUSTOMER_LEVEL = "customer_level" ;
	public final static java.lang.String CS_REPORT_EMPLOYEE_ID = "report_employee_id" ;
	public final static java.lang.String CS_IS_SURE = "is_sure" ;
	public final static java.lang.String CS_IS_WAREHOUS = "is_warehous" ;
	public final static java.lang.String CS_IS_APPLY_QUOTE = "is_apply_quote" ;
	public final static java.lang.String CS_COMPANY_PROVINCE = "company_province" ;
	public final static java.lang.String CS_COMPANY_CITY = "company_city" ;
	public final static java.lang.String CS_POST_CODE = "post_code" ;
	public final static java.lang.String CS_WEB_SITE = "web_site" ;
	public final static java.lang.String CS_COMPANY_FAX = "company_fax" ;
	public final static java.lang.String CS_COMPANY_STOCK_CODE = "company_stock_code" ;
	public final static java.lang.String CS_COMPANY_EMPLOYEE_NUM = "company_employee_num" ;
	public final static java.lang.String CS_COMPANY_SETUP = "company_setup" ;
	public final static java.lang.String CS_COMPANY_NATURE = "company_nature" ;
	public final static java.lang.String CS_COMPANY_QUALIFICATION = "company_qualification" ;
	public final static java.lang.String CS_COMPANY_ORGANIZATIONAL = "company_organizational" ;
	public final static java.lang.String CS_COMPANY_BRIEF = "company_brief" ;
	public final static java.lang.String CS_COMPANY_PARENT_NAME = "company_parent_name" ;
	public final static java.lang.String CS_COMPANY_PARENT_ADDRESS = "company_parent_address" ;
	public final static java.lang.String CS_COMPANY_CHILD_NAME = "company_child_name" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,客户名称,客户地址,联系电话,客户类型,客户等级,报备人员,是否确认,是否入库,是否已提供战略报价,省份,城市,邮编,网站,传真,股票代码,公司人数,公司成立日期,企业性质,企业资质,组织架构,公司简介,客户集团公司名称,客户集团公司地址,分支机构,父级编码,3设计合作单位),操作人,创建时间,备注";

	public java.lang.Integer getCustomerId() {
		return this.__customer_id;
	}

	public void setCustomerId( java.lang.Integer value ) {
		this.__customer_id = value;
	}

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getCompanyAddress() {
		return this.__company_address;
	}

	public void setCompanyAddress( java.lang.String value ) {
		this.__company_address = value;
	}

	public java.lang.String getCompanyMobile() {
		return this.__company_mobile;
	}

	public void setCompanyMobile( java.lang.String value ) {
		this.__company_mobile = value;
	}

	public java.lang.Integer getCustomerType() {
		return this.__customer_type;
	}

	public void setCustomerType( java.lang.Integer value ) {
		this.__customer_type = value;
	}

	public java.lang.Integer getCustomerLevel() {
		return this.__customer_level;
	}

	public void setCustomerLevel( java.lang.Integer value ) {
		this.__customer_level = value;
	}

	public java.lang.Integer getReportEmployeeId() {
		return this.__report_employee_id;
	}

	public void setReportEmployeeId( java.lang.Integer value ) {
		this.__report_employee_id = value;
	}

	public java.lang.Boolean getIsSure() {
		return this.__is_sure;
	}

	public void setIsSure( java.lang.Boolean value ) {
		this.__is_sure = value;
	}

	public java.lang.Boolean getIsWarehous() {
		return this.__is_warehous;
	}

	public void setIsWarehous( java.lang.Boolean value ) {
		this.__is_warehous = value;
	}

	public java.lang.Boolean getIsApplyQuote() {
		return this.__is_apply_quote;
	}

	public void setIsApplyQuote( java.lang.Boolean value ) {
		this.__is_apply_quote = value;
	}

	public java.lang.String getCompanyProvince() {
		return this.__company_province;
	}

	public void setCompanyProvince( java.lang.String value ) {
		this.__company_province = value;
	}

	public java.lang.String getCompanyCity() {
		return this.__company_city;
	}

	public void setCompanyCity( java.lang.String value ) {
		this.__company_city = value;
	}

	public java.lang.String getPostCode() {
		return this.__post_code;
	}

	public void setPostCode( java.lang.String value ) {
		this.__post_code = value;
	}

	public java.lang.String getWebSite() {
		return this.__web_site;
	}

	public void setWebSite( java.lang.String value ) {
		this.__web_site = value;
	}

	public java.lang.String getCompanyFax() {
		return this.__company_fax;
	}

	public void setCompanyFax( java.lang.String value ) {
		this.__company_fax = value;
	}

	public java.lang.String getCompanyStockCode() {
		return this.__company_stock_code;
	}

	public void setCompanyStockCode( java.lang.String value ) {
		this.__company_stock_code = value;
	}

	public java.lang.Integer getCompanyEmployeeNum() {
		return this.__company_employee_num;
	}

	public void setCompanyEmployeeNum( java.lang.Integer value ) {
		this.__company_employee_num = value;
	}

	public java.util.Date getCompanySetup() {
		return this.__company_setup;
	}

	public void setCompanySetup( java.util.Date value ) {
		this.__company_setup = value;
	}

	public java.lang.String getCompanyNature() {
		return this.__company_nature;
	}

	public void setCompanyNature( java.lang.String value ) {
		this.__company_nature = value;
	}

	public java.lang.String getCompanyQualification() {
		return this.__company_qualification;
	}

	public void setCompanyQualification( java.lang.String value ) {
		this.__company_qualification = value;
	}

	public java.lang.String getCompanyOrganizational() {
		return this.__company_organizational;
	}

	public void setCompanyOrganizational( java.lang.String value ) {
		this.__company_organizational = value;
	}

	public java.lang.String getCompanyBrief() {
		return this.__company_brief;
	}

	public void setCompanyBrief( java.lang.String value ) {
		this.__company_brief = value;
	}

	public java.lang.String getCompanyParentName() {
		return this.__company_parent_name;
	}

	public void setCompanyParentName( java.lang.String value ) {
		this.__company_parent_name = value;
	}

	public java.lang.String getCompanyParentAddress() {
		return this.__company_parent_address;
	}

	public void setCompanyParentAddress( java.lang.String value ) {
		this.__company_parent_address = value;
	}

	public java.lang.String getCompanyChildName() {
		return this.__company_child_name;
	}

	public void setCompanyChildName( java.lang.String value ) {
		this.__company_child_name = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
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

	public void cloneCopy(BaseOnLoadCustomerData __bean){
		__bean.setCustomerId(getCustomerId());
		__bean.setCustomerName(getCustomerName());
		__bean.setCompanyAddress(getCompanyAddress());
		__bean.setCompanyMobile(getCompanyMobile());
		__bean.setCustomerType(getCustomerType());
		__bean.setCustomerLevel(getCustomerLevel());
		__bean.setReportEmployeeId(getReportEmployeeId());
		__bean.setIsSure(getIsSure());
		__bean.setIsWarehous(getIsWarehous());
		__bean.setIsApplyQuote(getIsApplyQuote());
		__bean.setCompanyProvince(getCompanyProvince());
		__bean.setCompanyCity(getCompanyCity());
		__bean.setPostCode(getPostCode());
		__bean.setWebSite(getWebSite());
		__bean.setCompanyFax(getCompanyFax());
		__bean.setCompanyStockCode(getCompanyStockCode());
		__bean.setCompanyEmployeeNum(getCompanyEmployeeNum());
		__bean.setCompanySetup(getCompanySetup());
		__bean.setCompanyNature(getCompanyNature());
		__bean.setCompanyQualification(getCompanyQualification());
		__bean.setCompanyOrganizational(getCompanyOrganizational());
		__bean.setCompanyBrief(getCompanyBrief());
		__bean.setCompanyParentName(getCompanyParentName());
		__bean.setCompanyParentAddress(getCompanyParentAddress());
		__bean.setCompanyChildName(getCompanyChildName());
		__bean.setParentId(getParentId());
		__bean.setType(getType());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setCreateTime(getCreateTime());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCustomerId() == null ? "" : getCustomerId());
		sb.append(",");
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCompanyAddress() == null ? "" : getCompanyAddress());
		sb.append(",");
		sb.append(getCompanyMobile() == null ? "" : getCompanyMobile());
		sb.append(",");
		String strCustomerType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_151", String.valueOf(getCustomerType()));
		sb.append(strCustomerType == null ? "" : strCustomerType);
		sb.append(",");
		String strCustomerLevel = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_145", String.valueOf(getCustomerLevel()));
		sb.append(strCustomerLevel == null ? "" : strCustomerLevel);
		sb.append(",");
		String strReportEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getReportEmployeeId()));
		sb.append(strReportEmployeeId == null ? "" : strReportEmployeeId);
		sb.append(",");
		sb.append(getIsSure() == null ? "" : getIsSure());
		sb.append(",");
		sb.append(getIsWarehous() == null ? "" : getIsWarehous());
		sb.append(",");
		sb.append(getIsApplyQuote() == null ? "" : getIsApplyQuote());
		sb.append(",");
		sb.append(getCompanyProvince() == null ? "" : getCompanyProvince());
		sb.append(",");
		sb.append(getCompanyCity() == null ? "" : getCompanyCity());
		sb.append(",");
		sb.append(getPostCode() == null ? "" : getPostCode());
		sb.append(",");
		sb.append(getWebSite() == null ? "" : getWebSite());
		sb.append(",");
		sb.append(getCompanyFax() == null ? "" : getCompanyFax());
		sb.append(",");
		sb.append(getCompanyStockCode() == null ? "" : getCompanyStockCode());
		sb.append(",");
		sb.append(getCompanyEmployeeNum() == null ? "" : getCompanyEmployeeNum());
		sb.append(",");
		sb.append(getCompanySetup() == null ? "" : sdf.format(getCompanySetup()));
		sb.append(",");
		sb.append(getCompanyNature() == null ? "" : getCompanyNature());
		sb.append(",");
		sb.append(getCompanyQualification() == null ? "" : getCompanyQualification());
		sb.append(",");
		sb.append(getCompanyOrganizational() == null ? "" : getCompanyOrganizational());
		sb.append(",");
		sb.append(getCompanyBrief() == null ? "" : getCompanyBrief());
		sb.append(",");
		sb.append(getCompanyParentName() == null ? "" : getCompanyParentName());
		sb.append(",");
		sb.append(getCompanyParentAddress() == null ? "" : getCompanyParentAddress());
		sb.append(",");
		sb.append(getCompanyChildName() == null ? "" : getCompanyChildName());
		sb.append(",");
		sb.append(getParentId() == null ? "" : getParentId());
		sb.append(",");
		String strType = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_124", String.valueOf(getType()));
		sb.append(strType == null ? "" : strType);
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadCustomerData o) {
		return __customer_id == null ? -1 : __customer_id.compareTo(o.getCustomerId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__customer_id);
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__company_address);
		hash = 97 * hash + Objects.hashCode(this.__company_mobile);
		hash = 97 * hash + Objects.hashCode(this.__customer_type);
		hash = 97 * hash + Objects.hashCode(this.__customer_level);
		hash = 97 * hash + Objects.hashCode(this.__report_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__is_sure);
		hash = 97 * hash + Objects.hashCode(this.__is_warehous);
		hash = 97 * hash + Objects.hashCode(this.__is_apply_quote);
		hash = 97 * hash + Objects.hashCode(this.__company_province);
		hash = 97 * hash + Objects.hashCode(this.__company_city);
		hash = 97 * hash + Objects.hashCode(this.__post_code);
		hash = 97 * hash + Objects.hashCode(this.__web_site);
		hash = 97 * hash + Objects.hashCode(this.__company_fax);
		hash = 97 * hash + Objects.hashCode(this.__company_stock_code);
		hash = 97 * hash + Objects.hashCode(this.__company_employee_num);
		hash = 97 * hash + Objects.hashCode(this.__company_setup);
		hash = 97 * hash + Objects.hashCode(this.__company_nature);
		hash = 97 * hash + Objects.hashCode(this.__company_qualification);
		hash = 97 * hash + Objects.hashCode(this.__company_organizational);
		hash = 97 * hash + Objects.hashCode(this.__company_brief);
		hash = 97 * hash + Objects.hashCode(this.__company_parent_name);
		hash = 97 * hash + Objects.hashCode(this.__company_parent_address);
		hash = 97 * hash + Objects.hashCode(this.__company_child_name);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadCustomerData o = (BaseOnLoadCustomerData)obj;
		if(!Objects.equals(this.__customer_id, o.getCustomerId())) return false;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__company_address, o.getCompanyAddress())) return false;
		if(!Objects.equals(this.__company_mobile, o.getCompanyMobile())) return false;
		if(!Objects.equals(this.__customer_type, o.getCustomerType())) return false;
		if(!Objects.equals(this.__customer_level, o.getCustomerLevel())) return false;
		if(!Objects.equals(this.__report_employee_id, o.getReportEmployeeId())) return false;
		if(!Objects.equals(this.__is_sure, o.getIsSure())) return false;
		if(!Objects.equals(this.__is_warehous, o.getIsWarehous())) return false;
		if(!Objects.equals(this.__is_apply_quote, o.getIsApplyQuote())) return false;
		if(!Objects.equals(this.__company_province, o.getCompanyProvince())) return false;
		if(!Objects.equals(this.__company_city, o.getCompanyCity())) return false;
		if(!Objects.equals(this.__post_code, o.getPostCode())) return false;
		if(!Objects.equals(this.__web_site, o.getWebSite())) return false;
		if(!Objects.equals(this.__company_fax, o.getCompanyFax())) return false;
		if(!Objects.equals(this.__company_stock_code, o.getCompanyStockCode())) return false;
		if(!Objects.equals(this.__company_employee_num, o.getCompanyEmployeeNum())) return false;
		if(!Objects.equals(this.__company_setup, o.getCompanySetup())) return false;
		if(!Objects.equals(this.__company_nature, o.getCompanyNature())) return false;
		if(!Objects.equals(this.__company_qualification, o.getCompanyQualification())) return false;
		if(!Objects.equals(this.__company_organizational, o.getCompanyOrganizational())) return false;
		if(!Objects.equals(this.__company_brief, o.getCompanyBrief())) return false;
		if(!Objects.equals(this.__company_parent_name, o.getCompanyParentName())) return false;
		if(!Objects.equals(this.__company_parent_address, o.getCompanyParentAddress())) return false;
		if(!Objects.equals(this.__company_child_name, o.getCompanyChildName())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCustomerId() != null) sb.append(__wrapNumber(count++, "customerId", getCustomerId()));
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCompanyAddress() != null) sb.append(__wrapString(count++, "companyAddress", getCompanyAddress()));
		if(getCompanyMobile() != null) sb.append(__wrapString(count++, "companyMobile", getCompanyMobile()));
		if(getCustomerType() != null) sb.append(__wrapNumber(count++, "customerType", getCustomerType()));
		if(getCustomerLevel() != null) sb.append(__wrapNumber(count++, "customerLevel", getCustomerLevel()));
		if(getReportEmployeeId() != null) sb.append(__wrapNumber(count++, "reportEmployeeId", getReportEmployeeId()));
		if(getIsSure() != null) sb.append(__wrapBoolean(count++, "isSure", getIsSure()));
		if(getIsWarehous() != null) sb.append(__wrapBoolean(count++, "isWarehous", getIsWarehous()));
		if(getIsApplyQuote() != null) sb.append(__wrapBoolean(count++, "isApplyQuote", getIsApplyQuote()));
		if(getCompanyProvince() != null) sb.append(__wrapString(count++, "companyProvince", getCompanyProvince()));
		if(getCompanyCity() != null) sb.append(__wrapString(count++, "companyCity", getCompanyCity()));
		if(getPostCode() != null) sb.append(__wrapString(count++, "postCode", getPostCode()));
		if(getWebSite() != null) sb.append(__wrapString(count++, "webSite", getWebSite()));
		if(getCompanyFax() != null) sb.append(__wrapString(count++, "companyFax", getCompanyFax()));
		if(getCompanyStockCode() != null) sb.append(__wrapString(count++, "companyStockCode", getCompanyStockCode()));
		if(getCompanyEmployeeNum() != null) sb.append(__wrapNumber(count++, "companyEmployeeNum", getCompanyEmployeeNum()));
		if(getCompanySetup() != null) sb.append(__wrapDate(count++, "companySetup", getCompanySetup()));
		if(getCompanyNature() != null) sb.append(__wrapString(count++, "companyNature", getCompanyNature()));
		if(getCompanyQualification() != null) sb.append(__wrapString(count++, "companyQualification", getCompanyQualification()));
		if(getCompanyOrganizational() != null) sb.append(__wrapString(count++, "companyOrganizational", getCompanyOrganizational()));
		if(getCompanyBrief() != null) sb.append(__wrapString(count++, "companyBrief", getCompanyBrief()));
		if(getCompanyParentName() != null) sb.append(__wrapString(count++, "companyParentName", getCompanyParentName()));
		if(getCompanyParentAddress() != null) sb.append(__wrapString(count++, "companyParentAddress", getCompanyParentAddress()));
		if(getCompanyChildName() != null) sb.append(__wrapString(count++, "companyChildName", getCompanyChildName()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("customerId")) != null) setCustomerId(__getInt(val)); 
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("companyAddress")) != null) setCompanyAddress(__getString(val));
		if((val = values.get("companyMobile")) != null) setCompanyMobile(__getString(val));
		if((val = values.get("customerType")) != null) setCustomerType(__getInt(val)); 
		if((val = values.get("customerLevel")) != null) setCustomerLevel(__getInt(val)); 
		if((val = values.get("reportEmployeeId")) != null) setReportEmployeeId(__getInt(val)); 
		if((val = values.get("isSure")) != null) setIsSure(__getBoolean(val));
		if((val = values.get("isWarehous")) != null) setIsWarehous(__getBoolean(val));
		if((val = values.get("isApplyQuote")) != null) setIsApplyQuote(__getBoolean(val));
		if((val = values.get("companyProvince")) != null) setCompanyProvince(__getString(val));
		if((val = values.get("companyCity")) != null) setCompanyCity(__getString(val));
		if((val = values.get("postCode")) != null) setPostCode(__getString(val));
		if((val = values.get("webSite")) != null) setWebSite(__getString(val));
		if((val = values.get("companyFax")) != null) setCompanyFax(__getString(val));
		if((val = values.get("companyStockCode")) != null) setCompanyStockCode(__getString(val));
		if((val = values.get("companyEmployeeNum")) != null) setCompanyEmployeeNum(__getInt(val)); 
		if((val = values.get("companySetup")) != null) setCompanySetup(__getDate(val)); 
		if((val = values.get("companyNature")) != null) setCompanyNature(__getString(val));
		if((val = values.get("companyQualification")) != null) setCompanyQualification(__getString(val));
		if((val = values.get("companyOrganizational")) != null) setCompanyOrganizational(__getString(val));
		if((val = values.get("companyBrief")) != null) setCompanyBrief(__getString(val));
		if((val = values.get("companyParentName")) != null) setCompanyParentName(__getString(val));
		if((val = values.get("companyParentAddress")) != null) setCompanyParentAddress(__getString(val));
		if((val = values.get("companyChildName")) != null) setCompanyChildName(__getString(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __customer_id ;
	protected java.lang.String  __customer_name ;
	protected java.lang.String  __company_address ;
	protected java.lang.String  __company_mobile ;
	protected java.lang.Integer  __customer_type ;
	protected java.lang.Integer  __customer_level ;
	protected java.lang.Integer  __report_employee_id ;
	protected java.lang.Boolean  __is_sure ;
	protected java.lang.Boolean  __is_warehous ;
	protected java.lang.Boolean  __is_apply_quote ;
	protected java.lang.String  __company_province ;
	protected java.lang.String  __company_city ;
	protected java.lang.String  __post_code ;
	protected java.lang.String  __web_site ;
	protected java.lang.String  __company_fax ;
	protected java.lang.String  __company_stock_code ;
	protected java.lang.Integer  __company_employee_num ;
	protected java.util.Date  __company_setup ;
	protected java.lang.String  __company_nature ;
	protected java.lang.String  __company_qualification ;
	protected java.lang.String  __company_organizational ;
	protected java.lang.String  __company_brief ;
	protected java.lang.String  __company_parent_name ;
	protected java.lang.String  __company_parent_address ;
	protected java.lang.String  __company_child_name ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __type ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __create_time ;
	protected java.lang.String  __remark ;
}
