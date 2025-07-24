package pomplatform.contractincome.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseGetInvoiceContactsInfo extends GenericBase implements BaseFactory<BaseGetInvoiceContactsInfo>, Comparable<BaseGetInvoiceContactsInfo> 
{


	public static BaseGetInvoiceContactsInfo newInstance(){
		return new BaseGetInvoiceContactsInfo();
	}

	@Override
	public BaseGetInvoiceContactsInfo make(){
		BaseGetInvoiceContactsInfo b = new BaseGetInvoiceContactsInfo();
		return b;
	}

	public final static java.lang.String CS_CUSTOMER_NAME = "customer_name" ;
	public final static java.lang.String CS_CUSTOMER_PHONE = "customer_phone" ;
	public final static java.lang.String CS_EMAIL = "email" ;
	public final static java.lang.String CS_LANDLINE = "landline" ;
	public final static java.lang.String CS_FAX = "fax" ;

	public final static java.lang.String ALL_CAPTIONS = "联系人,联系电话,邮箱,座机,传真";

	public java.lang.String getCustomerName() {
		return this.__customer_name;
	}

	public void setCustomerName( java.lang.String value ) {
		this.__customer_name = value;
	}

	public java.lang.String getCustomerPhone() {
		return this.__customer_phone;
	}

	public void setCustomerPhone( java.lang.String value ) {
		this.__customer_phone = value;
	}

	public java.lang.String getEmail() {
		return this.__email;
	}

	public void setEmail( java.lang.String value ) {
		this.__email = value;
	}

	public java.lang.String getLandline() {
		return this.__landline;
	}

	public void setLandline( java.lang.String value ) {
		this.__landline = value;
	}

	public java.lang.String getFax() {
		return this.__fax;
	}

	public void setFax( java.lang.String value ) {
		this.__fax = value;
	}

	public void cloneCopy(BaseGetInvoiceContactsInfo __bean){
		__bean.setCustomerName(getCustomerName());
		__bean.setCustomerPhone(getCustomerPhone());
		__bean.setEmail(getEmail());
		__bean.setLandline(getLandline());
		__bean.setFax(getFax());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getCustomerName() == null ? "" : getCustomerName());
		sb.append(",");
		sb.append(getCustomerPhone() == null ? "" : getCustomerPhone());
		sb.append(",");
		sb.append(getEmail() == null ? "" : getEmail());
		sb.append(",");
		sb.append(getLandline() == null ? "" : getLandline());
		sb.append(",");
		sb.append(getFax() == null ? "" : getFax());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGetInvoiceContactsInfo o) {
		return __customer_name == null ? -1 : __customer_name.compareTo(o.getCustomerName());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__customer_name);
		hash = 97 * hash + Objects.hashCode(this.__customer_phone);
		hash = 97 * hash + Objects.hashCode(this.__email);
		hash = 97 * hash + Objects.hashCode(this.__landline);
		hash = 97 * hash + Objects.hashCode(this.__fax);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGetInvoiceContactsInfo o = (BaseGetInvoiceContactsInfo)obj;
		if(!Objects.equals(this.__customer_name, o.getCustomerName())) return false;
		if(!Objects.equals(this.__customer_phone, o.getCustomerPhone())) return false;
		if(!Objects.equals(this.__email, o.getEmail())) return false;
		if(!Objects.equals(this.__landline, o.getLandline())) return false;
		if(!Objects.equals(this.__fax, o.getFax())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getCustomerName() != null) sb.append(__wrapString(count++, "customerName", getCustomerName()));
		if(getCustomerPhone() != null) sb.append(__wrapString(count++, "customerPhone", getCustomerPhone()));
		if(getEmail() != null) sb.append(__wrapString(count++, "email", getEmail()));
		if(getLandline() != null) sb.append(__wrapString(count++, "landline", getLandline()));
		if(getFax() != null) sb.append(__wrapString(count++, "fax", getFax()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getCustomerName() != null) res.put("customerName", getCustomerName());
		if(getCustomerPhone() != null) res.put("customerPhone", getCustomerPhone());
		if(getEmail() != null) res.put("email", getEmail());
		if(getLandline() != null) res.put("landline", getLandline());
		if(getFax() != null) res.put("fax", getFax());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("customerName")) != null) setCustomerName(__getString(val));
		if((val = values.get("customerPhone")) != null) setCustomerPhone(__getString(val));
		if((val = values.get("email")) != null) setEmail(__getString(val));
		if((val = values.get("landline")) != null) setLandline(__getString(val));
		if((val = values.get("fax")) != null) setFax(__getString(val));
	}

	protected java.lang.String  __customer_name ;
	protected java.lang.String  __customer_phone ;
	protected java.lang.String  __email ;
	protected java.lang.String  __landline ;
	protected java.lang.String  __fax ;
}
