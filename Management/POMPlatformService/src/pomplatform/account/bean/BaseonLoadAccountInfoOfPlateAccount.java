package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseonLoadAccountInfoOfPlateAccount extends GenericBase implements BaseFactory<BaseonLoadAccountInfoOfPlateAccount>, Comparable<BaseonLoadAccountInfoOfPlateAccount> 
{


	public static BaseonLoadAccountInfoOfPlateAccount newInstance(){
		return new BaseonLoadAccountInfoOfPlateAccount();
	}

	@Override
	public BaseonLoadAccountInfoOfPlateAccount make(){
		BaseonLoadAccountInfoOfPlateAccount b = new BaseonLoadAccountInfoOfPlateAccount();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_NAME = "business_type_name" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_TYPE_PARENT_ID = "type_parent_id" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,业务类型,业务功能名称,积分,ID";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public java.lang.String getBusinessTypeName() {
		return this.__business_type_name;
	}

	public void setBusinessTypeName( java.lang.String value ) {
		this.__business_type_name = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.lang.Integer getTypeParentId() {
		return this.__type_parent_id;
	}

	public void setTypeParentId( java.lang.Integer value ) {
		this.__type_parent_id = value;
	}

	public void cloneCopy(BaseonLoadAccountInfoOfPlateAccount __bean){
		__bean.setPlateId(getPlateId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setBusinessTypeName(getBusinessTypeName());
		__bean.setIntegral(getIntegral());
		__bean.setTypeParentId(getTypeParentId());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getBusinessTypeName() == null ? "" : getBusinessTypeName());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getTypeParentId() == null ? "" : getTypeParentId());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseonLoadAccountInfoOfPlateAccount o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_name);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__type_parent_id);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseonLoadAccountInfoOfPlateAccount o = (BaseonLoadAccountInfoOfPlateAccount)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__business_type_name, o.getBusinessTypeName())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__type_parent_id, o.getTypeParentId())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getBusinessTypeName() != null) sb.append(__wrapString(count++, "businessTypeName", getBusinessTypeName()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getTypeParentId() != null) sb.append(__wrapNumber(count++, "typeParentId", getTypeParentId()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("businessTypeName")) != null) setBusinessTypeName(__getString(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("typeParentId")) != null) setTypeParentId(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_type_id ;
	protected java.lang.String  __business_type_name ;
	protected java.math.BigDecimal  __integral ;
	protected java.lang.Integer  __type_parent_id ;
}
