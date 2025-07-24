package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadPlateDataOfAccount extends GenericBase implements BaseFactory<BaseOnLoadPlateDataOfAccount>, Comparable<BaseOnLoadPlateDataOfAccount> 
{


	public static BaseOnLoadPlateDataOfAccount newInstance(){
		return new BaseOnLoadPlateDataOfAccount();
	}

	@Override
	public BaseOnLoadPlateDataOfAccount make(){
		BaseOnLoadPlateDataOfAccount b = new BaseOnLoadPlateDataOfAccount();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_TYPE_ID = "business_type_id" ;
	public final static java.lang.String CS_DIC_TYPE_VALUE = "dic_type_value" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,11绩效奖金),数据值,积分";

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

	public java.lang.String getDicTypeValue() {
		return this.__dic_type_value;
	}

	public void setDicTypeValue( java.lang.String value ) {
		this.__dic_type_value = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public void cloneCopy(BaseOnLoadPlateDataOfAccount __bean){
		__bean.setPlateId(getPlateId());
		__bean.setBusinessTypeId(getBusinessTypeId());
		__bean.setDicTypeValue(getDicTypeValue());
		__bean.setIntegral(getIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getBusinessTypeId() == null ? "" : getBusinessTypeId());
		sb.append(",");
		sb.append(getDicTypeValue() == null ? "" : getDicTypeValue());
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadPlateDataOfAccount o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_type_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadPlateDataOfAccount o = (BaseOnLoadPlateDataOfAccount)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_type_id, o.getBusinessTypeId())) return false;
		if(!Objects.equals(this.__dic_type_value, o.getDicTypeValue())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessTypeId() != null) sb.append(__wrapNumber(count++, "businessTypeId", getBusinessTypeId()));
		if(getDicTypeValue() != null) sb.append(__wrapString(count++, "dicTypeValue", getDicTypeValue()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("businessTypeId")) != null) setBusinessTypeId(__getInt(val)); 
		if((val = values.get("dicTypeValue")) != null) setDicTypeValue(__getString(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_type_id ;
	protected java.lang.String  __dic_type_value ;
	protected java.math.BigDecimal  __integral ;
}
