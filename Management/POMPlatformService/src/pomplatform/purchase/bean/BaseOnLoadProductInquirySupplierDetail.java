package pomplatform.purchase.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadProductInquirySupplierDetail extends GenericBase implements BaseFactory<BaseOnLoadProductInquirySupplierDetail>, Comparable<BaseOnLoadProductInquirySupplierDetail> 
{


	public static BaseOnLoadProductInquirySupplierDetail newInstance(){
		return new BaseOnLoadProductInquirySupplierDetail();
	}

	@Override
	public BaseOnLoadProductInquirySupplierDetail make(){
		BaseOnLoadProductInquirySupplierDetail b = new BaseOnLoadProductInquirySupplierDetail();
		return b;
	}

	public final static java.lang.String CS_PRODUCT_INQUIRY_SUPPLIER_DETAIL_ID = "product_inquiry_supplier_detail_id" ;
	public final static java.lang.String CS_SUPPLIER_ID = "supplier_id" ;
	public final static java.lang.String CS_PRODUCT_INQUIRY_DETAIL_ID = "product_inquiry_detail_id" ;
	public final static java.lang.String CS_PRODUCT_PRICE = "product_price" ;
	public final static java.lang.String CS_TOTAL_PRICE = "total_price" ;
	public final static java.lang.String CS_TAX_POINTS = "tax_points" ;
	public final static java.lang.String CS_PRIORITY_LEVEL = "priority_level" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_INQUIRY_DATE = "inquiry_date" ;
	public final static java.lang.String CS_CREATE_TIME = "create_time" ;
	public final static java.lang.String CS_OPERATOR_ID = "operator_id" ;
	public final static java.lang.String CS_SUPPLIER_CONTACT_ID = "supplier_contact_id" ;
	public final static java.lang.String CS_IS_SELECT = "is_select" ;
	public final static java.lang.String CS_CONTACT_NAME = "contact_name" ;
	public final static java.lang.String CS_CONTACT_POSITION = "contact_position" ;
	public final static java.lang.String CS_CONTACT_GENDER = "contact_gender" ;
	public final static java.lang.String CS_CONTACT_PHONE = "contact_phone" ;
	public final static java.lang.String CS_CONTACT_EMAIL = "contact_email" ;
	public final static java.lang.String CS_CONTACT_FAX = "contact_fax" ;
	public final static java.lang.String CS_CONTACT_TYPE = "contact_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,供应商主键,询价详情表主键,单价,总价,含税点,优先级别,备注,询价日期,创建日期,操作人,供应商联系人主键,是否选中为最终报价 true 是,联系人姓名,联系人职位,2女),联系人电话,联系人邮箱,联系人传真,2其他)";

	public java.lang.Integer getProductInquirySupplierDetailId() {
		return this.__product_inquiry_supplier_detail_id;
	}

	public void setProductInquirySupplierDetailId( java.lang.Integer value ) {
		this.__product_inquiry_supplier_detail_id = value;
	}

	public java.lang.Integer getSupplierId() {
		return this.__supplier_id;
	}

	public void setSupplierId( java.lang.Integer value ) {
		this.__supplier_id = value;
	}

	public java.lang.Integer getProductInquiryDetailId() {
		return this.__product_inquiry_detail_id;
	}

	public void setProductInquiryDetailId( java.lang.Integer value ) {
		this.__product_inquiry_detail_id = value;
	}

	public java.math.BigDecimal getProductPrice() {
		return this.__product_price;
	}

	public void setProductPrice( java.math.BigDecimal value ) {
		this.__product_price = value;
	}

	public java.math.BigDecimal getTotalPrice() {
		return this.__total_price;
	}

	public void setTotalPrice( java.math.BigDecimal value ) {
		this.__total_price = value;
	}

	public java.math.BigDecimal getTaxPoints() {
		return this.__tax_points;
	}

	public void setTaxPoints( java.math.BigDecimal value ) {
		this.__tax_points = value;
	}

	public java.lang.Integer getPriorityLevel() {
		return this.__priority_level;
	}

	public void setPriorityLevel( java.lang.Integer value ) {
		this.__priority_level = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getInquiryDate() {
		return this.__inquiry_date;
	}

	public void setInquiryDate( java.util.Date value ) {
		this.__inquiry_date = value;
	}

	public java.util.Date getCreateTime() {
		return this.__create_time;
	}

	public void setCreateTime( java.util.Date value ) {
		this.__create_time = value;
	}

	public java.lang.Integer getOperatorId() {
		return this.__operator_id;
	}

	public void setOperatorId( java.lang.Integer value ) {
		this.__operator_id = value;
	}

	public java.lang.Integer getSupplierContactId() {
		return this.__supplier_contact_id;
	}

	public void setSupplierContactId( java.lang.Integer value ) {
		this.__supplier_contact_id = value;
	}

	public java.lang.Boolean getIsSelect() {
		return this.__is_select;
	}

	public void setIsSelect( java.lang.Boolean value ) {
		this.__is_select = value;
	}

	public java.lang.String getContactName() {
		return this.__contact_name;
	}

	public void setContactName( java.lang.String value ) {
		this.__contact_name = value;
	}

	public java.lang.String getContactPosition() {
		return this.__contact_position;
	}

	public void setContactPosition( java.lang.String value ) {
		this.__contact_position = value;
	}

	public java.lang.Integer getContactGender() {
		return this.__contact_gender;
	}

	public void setContactGender( java.lang.Integer value ) {
		this.__contact_gender = value;
	}

	public java.lang.String getContactPhone() {
		return this.__contact_phone;
	}

	public void setContactPhone( java.lang.String value ) {
		this.__contact_phone = value;
	}

	public java.lang.String getContactEmail() {
		return this.__contact_email;
	}

	public void setContactEmail( java.lang.String value ) {
		this.__contact_email = value;
	}

	public java.lang.String getContactFax() {
		return this.__contact_fax;
	}

	public void setContactFax( java.lang.String value ) {
		this.__contact_fax = value;
	}

	public java.lang.Integer getContactType() {
		return this.__contact_type;
	}

	public void setContactType( java.lang.Integer value ) {
		this.__contact_type = value;
	}

	public void cloneCopy(BaseOnLoadProductInquirySupplierDetail __bean){
		__bean.setProductInquirySupplierDetailId(getProductInquirySupplierDetailId());
		__bean.setSupplierId(getSupplierId());
		__bean.setProductInquiryDetailId(getProductInquiryDetailId());
		__bean.setProductPrice(getProductPrice());
		__bean.setTotalPrice(getTotalPrice());
		__bean.setTaxPoints(getTaxPoints());
		__bean.setPriorityLevel(getPriorityLevel());
		__bean.setRemark(getRemark());
		__bean.setInquiryDate(getInquiryDate());
		__bean.setCreateTime(getCreateTime());
		__bean.setOperatorId(getOperatorId());
		__bean.setSupplierContactId(getSupplierContactId());
		__bean.setIsSelect(getIsSelect());
		__bean.setContactName(getContactName());
		__bean.setContactPosition(getContactPosition());
		__bean.setContactGender(getContactGender());
		__bean.setContactPhone(getContactPhone());
		__bean.setContactEmail(getContactEmail());
		__bean.setContactFax(getContactFax());
		__bean.setContactType(getContactType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getProductInquirySupplierDetailId() == null ? "" : getProductInquirySupplierDetailId());
		sb.append(",");
		sb.append(getSupplierId() == null ? "" : getSupplierId());
		sb.append(",");
		sb.append(getProductInquiryDetailId() == null ? "" : getProductInquiryDetailId());
		sb.append(",");
		sb.append(getProductPrice() == null ? "" : getProductPrice());
		sb.append(",");
		sb.append(getTotalPrice() == null ? "" : getTotalPrice());
		sb.append(",");
		sb.append(getTaxPoints() == null ? "" : getTaxPoints());
		sb.append(",");
		sb.append(getPriorityLevel() == null ? "" : getPriorityLevel());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getInquiryDate() == null ? "" : sdf.format(getInquiryDate()));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getOperatorId() == null ? "" : getOperatorId());
		sb.append(",");
		sb.append(getSupplierContactId() == null ? "" : getSupplierContactId());
		sb.append(",");
		sb.append(getIsSelect() == null ? "" : getIsSelect());
		sb.append(",");
		sb.append(getContactName() == null ? "" : getContactName());
		sb.append(",");
		sb.append(getContactPosition() == null ? "" : getContactPosition());
		sb.append(",");
		sb.append(getContactGender() == null ? "" : getContactGender());
		sb.append(",");
		sb.append(getContactPhone() == null ? "" : getContactPhone());
		sb.append(",");
		sb.append(getContactEmail() == null ? "" : getContactEmail());
		sb.append(",");
		sb.append(getContactFax() == null ? "" : getContactFax());
		sb.append(",");
		sb.append(getContactType() == null ? "" : getContactType());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadProductInquirySupplierDetail o) {
		return __product_inquiry_supplier_detail_id == null ? -1 : __product_inquiry_supplier_detail_id.compareTo(o.getProductInquirySupplierDetailId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_supplier_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_id);
		hash = 97 * hash + Objects.hashCode(this.__product_inquiry_detail_id);
		hash = 97 * hash + Objects.hashCode(this.__product_price);
		hash = 97 * hash + Objects.hashCode(this.__total_price);
		hash = 97 * hash + Objects.hashCode(this.__tax_points);
		hash = 97 * hash + Objects.hashCode(this.__priority_level);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__inquiry_date);
		hash = 97 * hash + Objects.hashCode(this.__create_time);
		hash = 97 * hash + Objects.hashCode(this.__operator_id);
		hash = 97 * hash + Objects.hashCode(this.__supplier_contact_id);
		hash = 97 * hash + Objects.hashCode(this.__is_select);
		hash = 97 * hash + Objects.hashCode(this.__contact_name);
		hash = 97 * hash + Objects.hashCode(this.__contact_position);
		hash = 97 * hash + Objects.hashCode(this.__contact_gender);
		hash = 97 * hash + Objects.hashCode(this.__contact_phone);
		hash = 97 * hash + Objects.hashCode(this.__contact_email);
		hash = 97 * hash + Objects.hashCode(this.__contact_fax);
		hash = 97 * hash + Objects.hashCode(this.__contact_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadProductInquirySupplierDetail o = (BaseOnLoadProductInquirySupplierDetail)obj;
		if(!Objects.equals(this.__product_inquiry_supplier_detail_id, o.getProductInquirySupplierDetailId())) return false;
		if(!Objects.equals(this.__supplier_id, o.getSupplierId())) return false;
		if(!Objects.equals(this.__product_inquiry_detail_id, o.getProductInquiryDetailId())) return false;
		if(!Objects.equals(this.__product_price, o.getProductPrice())) return false;
		if(!Objects.equals(this.__total_price, o.getTotalPrice())) return false;
		if(!Objects.equals(this.__tax_points, o.getTaxPoints())) return false;
		if(!Objects.equals(this.__priority_level, o.getPriorityLevel())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__inquiry_date, o.getInquiryDate())) return false;
		if(!Objects.equals(this.__create_time, o.getCreateTime())) return false;
		if(!Objects.equals(this.__operator_id, o.getOperatorId())) return false;
		if(!Objects.equals(this.__supplier_contact_id, o.getSupplierContactId())) return false;
		if(!Objects.equals(this.__is_select, o.getIsSelect())) return false;
		if(!Objects.equals(this.__contact_name, o.getContactName())) return false;
		if(!Objects.equals(this.__contact_position, o.getContactPosition())) return false;
		if(!Objects.equals(this.__contact_gender, o.getContactGender())) return false;
		if(!Objects.equals(this.__contact_phone, o.getContactPhone())) return false;
		if(!Objects.equals(this.__contact_email, o.getContactEmail())) return false;
		if(!Objects.equals(this.__contact_fax, o.getContactFax())) return false;
		if(!Objects.equals(this.__contact_type, o.getContactType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getProductInquirySupplierDetailId() != null) sb.append(__wrapNumber(count++, "productInquirySupplierDetailId", getProductInquirySupplierDetailId()));
		if(getSupplierId() != null) sb.append(__wrapNumber(count++, "supplierId", getSupplierId()));
		if(getProductInquiryDetailId() != null) sb.append(__wrapNumber(count++, "productInquiryDetailId", getProductInquiryDetailId()));
		if(getProductPrice() != null) sb.append(__wrapDecimal(count++, "productPrice", getProductPrice()));
		if(getTotalPrice() != null) sb.append(__wrapDecimal(count++, "totalPrice", getTotalPrice()));
		if(getTaxPoints() != null) sb.append(__wrapDecimal(count++, "taxPoints", getTaxPoints()));
		if(getPriorityLevel() != null) sb.append(__wrapNumber(count++, "priorityLevel", getPriorityLevel()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getInquiryDate() != null) sb.append(__wrapDate(count++, "inquiryDate", getInquiryDate()));
		if(getCreateTime() != null) sb.append(__wrapDate(count++, "createTime", getCreateTime()));
		if(getOperatorId() != null) sb.append(__wrapNumber(count++, "operatorId", getOperatorId()));
		if(getSupplierContactId() != null) sb.append(__wrapNumber(count++, "supplierContactId", getSupplierContactId()));
		if(getIsSelect() != null) sb.append(__wrapBoolean(count++, "isSelect", getIsSelect()));
		if(getContactName() != null) sb.append(__wrapString(count++, "contactName", getContactName()));
		if(getContactPosition() != null) sb.append(__wrapString(count++, "contactPosition", getContactPosition()));
		if(getContactGender() != null) sb.append(__wrapNumber(count++, "contactGender", getContactGender()));
		if(getContactPhone() != null) sb.append(__wrapString(count++, "contactPhone", getContactPhone()));
		if(getContactEmail() != null) sb.append(__wrapString(count++, "contactEmail", getContactEmail()));
		if(getContactFax() != null) sb.append(__wrapString(count++, "contactFax", getContactFax()));
		if(getContactType() != null) sb.append(__wrapNumber(count++, "contactType", getContactType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("productInquirySupplierDetailId")) != null) setProductInquirySupplierDetailId(__getInt(val)); 
		if((val = values.get("supplierId")) != null) setSupplierId(__getInt(val)); 
		if((val = values.get("productInquiryDetailId")) != null) setProductInquiryDetailId(__getInt(val)); 
		if((val = values.get("productPrice")) != null) setProductPrice(__getDecimal(val));  
		if((val = values.get("totalPrice")) != null) setTotalPrice(__getDecimal(val));  
		if((val = values.get("taxPoints")) != null) setTaxPoints(__getDecimal(val));  
		if((val = values.get("priorityLevel")) != null) setPriorityLevel(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("inquiryDate")) != null) setInquiryDate(__getDate(val)); 
		if((val = values.get("createTime")) != null) setCreateTime(__getDate(val)); 
		if((val = values.get("operatorId")) != null) setOperatorId(__getInt(val)); 
		if((val = values.get("supplierContactId")) != null) setSupplierContactId(__getInt(val)); 
		if((val = values.get("isSelect")) != null) setIsSelect(__getBoolean(val));
		if((val = values.get("contactName")) != null) setContactName(__getString(val));
		if((val = values.get("contactPosition")) != null) setContactPosition(__getString(val));
		if((val = values.get("contactGender")) != null) setContactGender(__getInt(val)); 
		if((val = values.get("contactPhone")) != null) setContactPhone(__getString(val));
		if((val = values.get("contactEmail")) != null) setContactEmail(__getString(val));
		if((val = values.get("contactFax")) != null) setContactFax(__getString(val));
		if((val = values.get("contactType")) != null) setContactType(__getInt(val)); 
	}

	protected java.lang.Integer  __product_inquiry_supplier_detail_id ;
	protected java.lang.Integer  __supplier_id ;
	protected java.lang.Integer  __product_inquiry_detail_id ;
	protected java.math.BigDecimal  __product_price ;
	protected java.math.BigDecimal  __total_price ;
	protected java.math.BigDecimal  __tax_points ;
	protected java.lang.Integer  __priority_level ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __inquiry_date ;
	protected java.util.Date  __create_time ;
	protected java.lang.Integer  __operator_id ;
	protected java.lang.Integer  __supplier_contact_id ;
	protected java.lang.Boolean  __is_select ;
	protected java.lang.String  __contact_name ;
	protected java.lang.String  __contact_position ;
	protected java.lang.Integer  __contact_gender ;
	protected java.lang.String  __contact_phone ;
	protected java.lang.String  __contact_email ;
	protected java.lang.String  __contact_fax ;
	protected java.lang.Integer  __contact_type ;
}
