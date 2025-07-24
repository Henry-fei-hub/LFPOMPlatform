package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseStargetrecordbytor extends GenericBase implements BaseFactory<BaseStargetrecordbytor>, Comparable<BaseStargetrecordbytor> 
{


	public static BaseStargetrecordbytor newInstance(){
		return new BaseStargetrecordbytor();
	}

	@Override
	public BaseStargetrecordbytor make(){
		BaseStargetrecordbytor b = new BaseStargetrecordbytor();
		return b;
	}

	public final static java.lang.String CS_TARGET_RECORD_ID = "target_record_id" ;
	public final static java.lang.String CS_BUSINESS_LINE = "business_line" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_MONTH = "month" ;
	public final static java.lang.String CS_TARGET = "target" ;
	public final static java.lang.String CS_TARGET_STR = "target_str" ;
	public final static java.lang.String CS_TYPE = "type" ;
	public final static java.lang.String CS_REMARK = "remark" ;
	public final static java.lang.String CS_OPERATE_DATE = "operate_date" ;

	public final static java.lang.String ALL_CAPTIONS = "编码,条线类型,年份,月份,指标,指标（万）,指标类型,备注,操作日期";

	public java.lang.Integer getTargetRecordId() {
		return this.__target_record_id;
	}

	public void setTargetRecordId( java.lang.Integer value ) {
		this.__target_record_id = value;
	}

	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Integer getMonth() {
		return this.__month;
	}

	public void setMonth( java.lang.Integer value ) {
		this.__month = value;
	}

	public java.math.BigDecimal getTarget() {
		return this.__target;
	}

	public void setTarget( java.math.BigDecimal value ) {
		this.__target = value;
	}

	public java.lang.String getTargetStr() {
		return this.__target_str;
	}

	public void setTargetStr( java.lang.String value ) {
		this.__target_str = value;
	}

	public java.lang.Integer getType() {
		return this.__type;
	}

	public void setType( java.lang.Integer value ) {
		this.__type = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public java.util.Date getOperateDate() {
		return this.__operate_date;
	}

	public void setOperateDate( java.util.Date value ) {
		this.__operate_date = value;
	}

	public void cloneCopy(BaseStargetrecordbytor __bean){
		__bean.setTargetRecordId(getTargetRecordId());
		__bean.setBusinessLine(getBusinessLine());
		__bean.setYear(getYear());
		__bean.setMonth(getMonth());
		__bean.setTarget(getTarget());
		__bean.setTargetStr(getTargetStr());
		__bean.setType(getType());
		__bean.setRemark(getRemark());
		__bean.setOperateDate(getOperateDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getTargetRecordId() == null ? "" : getTargetRecordId());
		sb.append(",");
		sb.append(getBusinessLine() == null ? "" : getBusinessLine());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getMonth() == null ? "" : getMonth());
		sb.append(",");
		sb.append(getTarget() == null ? "" : getTarget());
		sb.append(",");
		sb.append(getTargetStr() == null ? "" : getTargetStr());
		sb.append(",");
		sb.append(getType() == null ? "" : getType());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		sb.append(",");
		sb.append(getOperateDate() == null ? "" : sdf.format(getOperateDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseStargetrecordbytor o) {
		return __target_record_id == null ? -1 : __target_record_id.compareTo(o.getTargetRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__target_record_id);
		hash = 97 * hash + Objects.hashCode(this.__business_line);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__month);
		hash = 97 * hash + Objects.hashCode(this.__target);
		hash = 97 * hash + Objects.hashCode(this.__target_str);
		hash = 97 * hash + Objects.hashCode(this.__type);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		hash = 97 * hash + Objects.hashCode(this.__operate_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseStargetrecordbytor o = (BaseStargetrecordbytor)obj;
		if(!Objects.equals(this.__target_record_id, o.getTargetRecordId())) return false;
		if(!Objects.equals(this.__business_line, o.getBusinessLine())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__month, o.getMonth())) return false;
		if(!Objects.equals(this.__target, o.getTarget())) return false;
		if(!Objects.equals(this.__target_str, o.getTargetStr())) return false;
		if(!Objects.equals(this.__type, o.getType())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		if(!Objects.equals(this.__operate_date, o.getOperateDate())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getTargetRecordId() != null) sb.append(__wrapNumber(count++, "targetRecordId", getTargetRecordId()));
		if(getBusinessLine() != null) sb.append(__wrapNumber(count++, "businessLine", getBusinessLine()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getMonth() != null) sb.append(__wrapNumber(count++, "month", getMonth()));
		if(getTarget() != null) sb.append(__wrapDecimal(count++, "target", getTarget()));
		if(getTargetStr() != null) sb.append(__wrapString(count++, "targetStr", getTargetStr()));
		if(getType() != null) sb.append(__wrapNumber(count++, "type", getType()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		if(getOperateDate() != null) sb.append(__wrapDate(count++, "operateDate", getOperateDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("targetRecordId")) != null) setTargetRecordId(__getInt(val)); 
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("month")) != null) setMonth(__getInt(val)); 
		if((val = values.get("target")) != null) setTarget(__getDecimal(val));  
		if((val = values.get("targetStr")) != null) setTargetStr(__getString(val));
		if((val = values.get("type")) != null) setType(__getInt(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
		if((val = values.get("operateDate")) != null) setOperateDate(__getDate(val)); 
	}

	protected java.lang.Integer  __target_record_id ;
	protected java.lang.Integer  __business_line ;
	protected java.lang.Integer  __year ;
	protected java.lang.Integer  __month ;
	protected java.math.BigDecimal  __target ;
	protected java.lang.String  __target_str ;
	protected java.lang.Integer  __type ;
	protected java.lang.String  __remark ;
	protected java.util.Date  __operate_date ;
}
