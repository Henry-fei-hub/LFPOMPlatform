package pomplatform.stage.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadMainProjectStageByParentId extends GenericBase implements BaseFactory<BaseOnLoadMainProjectStageByParentId>, Comparable<BaseOnLoadMainProjectStageByParentId> 
{


	public static BaseOnLoadMainProjectStageByParentId newInstance(){
		return new BaseOnLoadMainProjectStageByParentId();
	}

	@Override
	public BaseOnLoadMainProjectStageByParentId make(){
		BaseOnLoadMainProjectStageByParentId b = new BaseOnLoadMainProjectStageByParentId();
		return b;
	}

	public final static java.lang.String CS_DIC_TYPE_VALUE_ID = "dic_type_value_id" ;
	public final static java.lang.String CS_DIC_TYPE_VALUE = "dic_type_value" ;
	public final static java.lang.String CS_PERCENT = "percent" ;

	public final static java.lang.String ALL_CAPTIONS = "数据编码,数据值,阶段比例";

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

	public java.math.BigDecimal getPercent() {
		return this.__percent;
	}

	public void setPercent( java.math.BigDecimal value ) {
		this.__percent = value;
	}

	public void cloneCopy(BaseOnLoadMainProjectStageByParentId __bean){
		__bean.setDicTypeValueId(getDicTypeValueId());
		__bean.setDicTypeValue(getDicTypeValue());
		__bean.setPercent(getPercent());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDicTypeValueId() == null ? "" : getDicTypeValueId());
		sb.append(",");
		sb.append(getDicTypeValue() == null ? "" : getDicTypeValue());
		sb.append(",");
		sb.append(getPercent() == null ? "" : getPercent());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadMainProjectStageByParentId o) {
		return __dic_type_value_id == null ? -1 : __dic_type_value_id.compareTo(o.getDicTypeValueId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value_id);
		hash = 97 * hash + Objects.hashCode(this.__dic_type_value);
		hash = 97 * hash + Objects.hashCode(this.__percent);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadMainProjectStageByParentId o = (BaseOnLoadMainProjectStageByParentId)obj;
		if(!Objects.equals(this.__dic_type_value_id, o.getDicTypeValueId())) return false;
		if(!Objects.equals(this.__dic_type_value, o.getDicTypeValue())) return false;
		if(!Objects.equals(this.__percent, o.getPercent())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDicTypeValueId() != null) sb.append(__wrapNumber(count++, "dicTypeValueId", getDicTypeValueId()));
		if(getDicTypeValue() != null) sb.append(__wrapString(count++, "dicTypeValue", getDicTypeValue()));
		if(getPercent() != null) sb.append(__wrapDecimal(count++, "percent", getPercent()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDicTypeValueId() != null) res.put("dicTypeValueId", getDicTypeValueId());
		if(getDicTypeValue() != null) res.put("dicTypeValue", getDicTypeValue());
		if(getPercent() != null) res.put("percent", getPercent());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("dicTypeValueId")) != null) setDicTypeValueId(__getInt(val)); 
		if((val = values.get("dicTypeValue")) != null) setDicTypeValue(__getString(val));
		if((val = values.get("percent")) != null) setPercent(__getDecimal(val));  
	}

	protected java.lang.Integer  __dic_type_value_id ;
	protected java.lang.String  __dic_type_value ;
	protected java.math.BigDecimal  __percent ;
}
