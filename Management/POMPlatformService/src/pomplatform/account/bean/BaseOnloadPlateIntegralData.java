package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnloadPlateIntegralData extends GenericBase implements BaseFactory<BaseOnloadPlateIntegralData>, Comparable<BaseOnloadPlateIntegralData> 
{


	public static BaseOnloadPlateIntegralData newInstance(){
		return new BaseOnloadPlateIntegralData();
	}

	@Override
	public BaseOnloadPlateIntegralData make(){
		BaseOnloadPlateIntegralData b = new BaseOnloadPlateIntegralData();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_FLAG = "flag" ;
	public final static java.lang.String CS_INTEGRAL_INT = "integral_int" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,积分,业务功能类型,业务名称,状态,积分";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.lang.Integer getBusinessTypeId() {
		return this.__business_type_id;
	}

	public void setBusinessTypeId( java.lang.Integer value ) {
		this.__business_type_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.lang.Integer getFlag() {
		return this.__flag;
	}

	public void setFlag( java.lang.Integer value ) {
		this.__flag = value;
	}

	public java.math.BigDecimal getIntegralInt() {
		return this.__integral_int;
	}

	public void setIntegralInt( java.math.BigDecimal value ) {
		this.__integral_int = value;
	}

	public void cloneCopy(BaseOnloadPlateIntegralData __bean){
		__bean.setPlateId(getPlateId());
		__bean.setIntegral(getIntegral());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setName(getName());
		__bean.setFlag(getFlag());
		__bean.setIntegralInt(getIntegralInt());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		String strFlag = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_34", String.valueOf(getFlag()));
		sb.append(strFlag == null ? "" : strFlag);
		sb.append(",");
		sb.append(getIntegralInt() == null ? "" : getIntegralInt());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnloadPlateIntegralData o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__flag);
		hash = 97 * hash + Objects.hashCode(this.__integral_int);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnloadPlateIntegralData o = (BaseOnloadPlateIntegralData)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__flag, o.getFlag())) return false;
		if(!Objects.equals(this.__integral_int, o.getIntegralInt())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getFlag() != null) sb.append(__wrapNumber(count++, "flag", getFlag()));
		if(getIntegralInt() != null) sb.append(__wrapDecimal(count++, "integralInt", getIntegralInt()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("flag")) != null) setFlag(__getInt(val)); 
		if((val = values.get("integralInt")) != null) setIntegralInt(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.math.BigDecimal  __integral ;
	protected java.lang.Integer  __business_type_id ;
	protected java.lang.String  __name ;
	protected java.lang.Integer  __flag ;
	protected java.math.BigDecimal  __integral_int ;
}
