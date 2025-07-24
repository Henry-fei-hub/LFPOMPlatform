package pomplatform.account.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseOnLoadCommonOneDetailOfPlateAccount extends GenericBase implements BaseFactory<BaseOnLoadCommonOneDetailOfPlateAccount>, Comparable<BaseOnLoadCommonOneDetailOfPlateAccount> 
{


	public static BaseOnLoadCommonOneDetailOfPlateAccount newInstance(){
		return new BaseOnLoadCommonOneDetailOfPlateAccount();
	}

	@Override
	public BaseOnLoadCommonOneDetailOfPlateAccount make(){
		BaseOnLoadCommonOneDetailOfPlateAccount b = new BaseOnLoadCommonOneDetailOfPlateAccount();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_BUSINESS_ID = "business_id" ;
	public final static java.lang.String CS_INTEGRAL = "integral" ;
	public final static java.lang.String CS_RECORD_DATE = "record_date" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,积分,日期,备注";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getBusinessId() {
		return this.__business_id;
	}

	public void setBusinessId( java.lang.Integer value ) {
		this.__business_id = value;
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

	public void cloneCopy(BaseOnLoadCommonOneDetailOfPlateAccount __bean){
		__bean.setPlateId(getPlateId());
		__bean.setBusinessId(getBusinessId());
		__bean.setIntegral(getIntegral());
		__bean.setRecordDate(getRecordDate());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getIntegral() == null ? "" : getIntegral());
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseOnLoadCommonOneDetailOfPlateAccount o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__business_id);
		hash = 97 * hash + Objects.hashCode(this.__integral);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseOnLoadCommonOneDetailOfPlateAccount o = (BaseOnLoadCommonOneDetailOfPlateAccount)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__business_id, o.getBusinessId())) return false;
		if(!Objects.equals(this.__integral, o.getIntegral())) return false;
		if(!Objects.equals(this.__record_date, o.getRecordDate())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getBusinessId() != null) sb.append(__wrapNumber(count++, "businessId", getBusinessId()));
		if(getIntegral() != null) sb.append(__wrapDecimal(count++, "integral", getIntegral()));
		if(getRecordDate() != null) sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val));
		if((val = values.get("businessId")) != null) setBusinessId(__getInt(val));
		if((val = values.get("integral")) != null) setIntegral(__getDecimal(val));  
		if((val = values.get("recordDate")) != null) setRecordDate(__getDate(val)); 
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __business_id ;
	protected java.math.BigDecimal  __integral ;
	protected java.util.Date  __record_date ;
	protected java.lang.String  __remark ;
}
