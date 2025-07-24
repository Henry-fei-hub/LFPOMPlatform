package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCollaborativeFeeDetailOfPlateAccount extends GenericBase implements BaseFactory<BaseCollaborativeFeeDetailOfPlateAccount>, Comparable<BaseCollaborativeFeeDetailOfPlateAccount> 
{


	public static BaseCollaborativeFeeDetailOfPlateAccount newInstance(){
		return new BaseCollaborativeFeeDetailOfPlateAccount();
	}

	@Override
	public BaseCollaborativeFeeDetailOfPlateAccount make(){
		BaseCollaborativeFeeDetailOfPlateAccount b = new BaseCollaborativeFeeDetailOfPlateAccount();
		return b;
	}

	public final static java.lang.String CS_FROM_PLATE_ID = "from_plate_id" ;
	public final static java.lang.String CS_TO_PLATE_ID = "to_plate_id" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "积分提取部门,积分发放部门,积分,日期,备注";

	public java.lang.Integer getFromPlateId() {
		return this.__from_plate_id;
	}

	public void setFromPlateId( java.lang.Integer value ) {
		this.__from_plate_id = value;
	}

	public java.lang.Integer getToPlateId() {
		return this.__to_plate_id;
	}

	public void setToPlateId( java.lang.Integer value ) {
		this.__to_plate_id = value;
	}

	public java.math.BigDecimal getIntegral() {
		return this.__integral;
	}

	public void setIntegral( java.math.BigDecimal value ) {
		this.__integral = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate( java.util.Date value ) {
		this.__record_date = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseCollaborativeFeeDetailOfPlateAccount __bean){
		__bean.setFromPlateId(getFromPlateId());
		__bean.setToPlateId(getToPlateId());
		__bean.setIntegral(getIntegral());
		__bean.setRecordDate(getRecordDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strFromPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getFromPlateId()));
		sb.append(strFromPlateId == null ? "" : strFromPlateId);
		sb.append(",");
		String strToPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getToPlateId()));
		sb.append(strToPlateId == null ? "" : strToPlateId);
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCollaborativeFeeDetailOfPlateAccount o) {
		return __from_plate_id == null ? -1 : __from_plate_id.compareTo(o.getFromPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__from_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__to_plate_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCollaborativeFeeDetailOfPlateAccount o = (BaseCollaborativeFeeDetailOfPlateAccount)obj;
		if(!Objects.equals(this.__from_plate_id, o.getFromPlateId())) return false;
		if(!Objects.equals(this.__to_plate_id, o.getToPlateId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getFromPlateId() != null) sb.append(__wrapNumber(count++, "fromPlateId", getFromPlateId()));
		if(getToPlateId() != null) sb.append(__wrapNumber(count++, "toPlateId", getToPlateId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("fromPlateId")) != null) setFromPlateId(__getInt(val)); 
		if((val = values.get("toPlateId")) != null) setToPlateId(__getInt(val)); 
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __from_plate_id ;
	protected java.lang.Integer  __to_plate_id ;
	protected java.math.BigDecimal  __integral ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __remark ;
}
