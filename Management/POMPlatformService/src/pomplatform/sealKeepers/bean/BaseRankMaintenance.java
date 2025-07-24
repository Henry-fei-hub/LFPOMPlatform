package pomplatform.sealKeepers.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseRankMaintenance extends GenericBase implements BaseFactory<BaseRankMaintenance>, Comparable<BaseRankMaintenance> 
{


	public static BaseRankMaintenance newInstance(){
		return new BaseRankMaintenance();
	}

	@Override
	public BaseRankMaintenance make(){
		BaseRankMaintenance b = new BaseRankMaintenance();
		return b;
	}

	public final static java.lang.String CS_DIC_TYPE_ID = "dic_type_id" ;
	public final static java.lang.String CS_DIC_TYPE_VALUE_ID = "dic_type_value_id" ;
	public final static java.lang.String CS_DIC_TYPE_VALUE = "dic_type_value" ;
	public final static java.lang.String CS_COEFFICIENT = "coefficient" ;

	public final static java.lang.String ALL_CAPTIONS = "列表数据代码,数据编码,数据值,职级系数";

	public java.lang.Integer getDicTypeId() {
		return this.__dic_type_id;
	}

	public void setDicTypeId( java.lang.Integer value ) {
		this.__dic_type_id = value;
	}

	public java.lang.Integer getDicTypeValueId() {
		return this.__dic_type_value_id;
	}

	public void setDicTypeValueId( java.lang.Integer value ) {
		this.__dic_type_value_id = value;
	}

	public java.lang.String getDicTypeValue() {
		return this.__dic_type_value;
	}

	public void setDicTypeValue( java.lang.String value ) {
		this.__dic_type_value = value;
	}

	public java.math.BigDecimal getCoefficient() {
		return this.__coefficient;
	}

	public void setCoefficient( java.math.BigDecimal value ) {
		this.__coefficient = value;
	}

	public void cloneCopy(BaseRankMaintenance __bean){
		__bean.setDicTypeId(getDicTypeId());
		__bean.setDicTypeValueId(getDicTypeValueId());
		__bean.setDicTypeValue(getDicTypeValue());
		__bean.setCoefficient(getCoefficient());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDicTypeId() == null ? "" : getDicTypeId());
		sb.append(",");
		sb.append(getDicTypeValueId() == null ? "" : getDicTypeValueId());
		sb.append(",");
		sb.append(getDicTypeValue() == null ? "" : getDicTypeValue());
		sb.append(",");
		sb.append(getCoefficient() == null ? "" : getCoefficient());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseRankMaintenance o) {
		return __dic_type_id == null ? -1 : __dic_type_id.compareTo(o.getDicTypeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__dic_type_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value);
		hash = 97 * hash + Objects.hashCode(this.__coefficient);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseRankMaintenance o = (BaseRankMaintenance)obj;
		if(!Objects.equals(this.__dic_type_id, o.getDicTypeId())) return false;
		if(!Objects.equals(this.__dic_type_value_id, o.getDicTypeValueId())) return false;
		if(!Objects.equals(this.__dic_type_value, o.getDicTypeValue())) return false;
		if(!Objects.equals(this.__coefficient, o.getCoefficient())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDicTypeId() != null) sb.append(__wrapNumber(count++, "dicTypeId", getDicTypeId()));
		if(getDicTypeValueId() != null) sb.append(__wrapNumber(count++, "dicTypeValueId", getDicTypeValueId()));
		if(getDicTypeValue() != null) sb.append(__wrapString(count++, "dicTypeValue", getDicTypeValue()));
		if(getCoefficient() != null) sb.append(__wrapDecimal(count++, "coefficient", getCoefficient()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDicTypeId() != null) res.put("dicTypeId", getDicTypeId());
		if(getDicTypeValueId() != null) res.put("dicTypeValueId", getDicTypeValueId());
		if(getDicTypeValue() != null) res.put("dicTypeValue", getDicTypeValue());
		if(getCoefficient() != null) res.put("coefficient", getCoefficient());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dicTypeId")) != null) setDicTypeId(__getInt(val)); 
		if((val = values.get("dicTypeValueId")) != null) setDicTypeValueId(__getInt(val)); 
		if((val = values.get("dicTypeValue")) != null) setDicTypeValue(__getString(val));
		if((val = values.get("coefficient")) != null) setCoefficient(__getDecimal(val));  
	}

	protected java.lang.Integer  __dic_type_id ;
	protected java.lang.Integer  __dic_type_value_id ;
	protected java.lang.String  __dic_type_value ;
	protected java.math.BigDecimal  __coefficient ;
}
