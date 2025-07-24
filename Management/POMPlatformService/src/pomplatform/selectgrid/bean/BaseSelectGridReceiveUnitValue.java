package pomplatform.selectgrid.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseSelectGridReceiveUnitValue extends GenericBase implements BaseFactory<BaseSelectGridReceiveUnitValue>, Comparable<BaseSelectGridReceiveUnitValue> 
{


	public static BaseSelectGridReceiveUnitValue newInstance(){
		return new BaseSelectGridReceiveUnitValue();
	}

	@Override
	public BaseSelectGridReceiveUnitValue make(){
		BaseSelectGridReceiveUnitValue b = new BaseSelectGridReceiveUnitValue();
		return b;
	}

	public final static java.lang.String CS_RECEIVE_UNIT_MANAGE_ID = "receive_unit_manage_id" ;
	public final static java.lang.String CS_RECEIVE_UNIT = "receive_unit" ;
	public final static java.lang.String CS_BANK_ACCOUNT = "bank_account" ;
	public final static java.lang.String CS_BANK_NAME = "bank_name" ;
	public final static java.lang.String CS_RECEIVE_UNIT_ADDRESS = "receive_unit_address" ;
	public final static java.lang.String CS_OPERATE_EMPLOYEE_ID = "operate_employee_id" ;
	public final static java.lang.String CS_OPERATE_TIME = "operate_time" ;
	public final static java.lang.String CS_ORIGIN = "origin" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,收款单位,银行账号,开户行,收款单位所在地,操作人,操作时间,来源";

	public java.lang.Integer getReceiveUnitManageId() {
		return this.__receive_unit_manage_id;
	}

	public void setReceiveUnitManageId( java.lang.Integer value ) {
		this.__receive_unit_manage_id = value;
	}

	public java.lang.String getReceiveUnit() {
		return this.__receive_unit;
	}

	public void setReceiveUnit( java.lang.String value ) {
		this.__receive_unit = value;
	}

	public java.lang.String getBankAccount() {
		return this.__bank_account;
	}

	public void setBankAccount( java.lang.String value ) {
		this.__bank_account = value;
	}

	public java.lang.String getBankName() {
		return this.__bank_name;
	}

	public void setBankName( java.lang.String value ) {
		this.__bank_name = value;
	}

	public java.lang.String getReceiveUnitAddress() {
		return this.__receive_unit_address;
	}

	public void setReceiveUnitAddress( java.lang.String value ) {
		this.__receive_unit_address = value;
	}

	public java.lang.Integer getOperateEmployeeId() {
		return this.__operate_employee_id;
	}

	public void setOperateEmployeeId( java.lang.Integer value ) {
		this.__operate_employee_id = value;
	}

	public java.util.Date getOperateTime() {
		return this.__operate_time;
	}

	public void setOperateTime( java.util.Date value ) {
		this.__operate_time = value;
	}

	public java.lang.Integer getOrigin() {
		return this.__origin;
	}

	public void setOrigin( java.lang.Integer value ) {
		this.__origin = value;
	}

	public void cloneCopy(BaseSelectGridReceiveUnitValue __bean){
		__bean.setReceiveUnitManageId(getReceiveUnitManageId());
		__bean.setReceiveUnit(getReceiveUnit());
		__bean.setBankAccount(getBankAccount());
		__bean.setBankName(getBankName());
		__bean.setReceiveUnitAddress(getReceiveUnitAddress());
		__bean.setOperateEmployeeId(getOperateEmployeeId());
		__bean.setOperateTime(getOperateTime());
		__bean.setOrigin(getOrigin());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getReceiveUnitManageId() == null ? "" : getReceiveUnitManageId());
		sb.append(",");
		sb.append(getReceiveUnit() == null ? "" : getReceiveUnit());
		sb.append(",");
		sb.append(getBankAccount() == null ? "" : getBankAccount());
		sb.append(",");
		sb.append(getBankName() == null ? "" : getBankName());
		sb.append(",");
		sb.append(getReceiveUnitAddress() == null ? "" : getReceiveUnitAddress());
		sb.append(",");
		sb.append(getOperateEmployeeId() == null ? "" : getOperateEmployeeId());
		sb.append(",");
		sb.append(getOperateTime() == null ? "" : sdf.format(getOperateTime()));
		sb.append(",");
		sb.append(getOrigin() == null ? "" : getOrigin());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSelectGridReceiveUnitValue o) {
		return __receive_unit_manage_id == null ? -1 : __receive_unit_manage_id.compareTo(o.getReceiveUnitManageId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_manage_id);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit);
		hash = 97 * hash + Objects.hashCode(this.__bank_account);
		hash = 97 * hash + Objects.hashCode(this.__bank_name);
		hash = 97 * hash + Objects.hashCode(this.__receive_unit_address);
		hash = 97 * hash + Objects.hashCode(this.__operate_employee_id);
		hash = 97 * hash + Objects.hashCode(this.__operate_time);
		hash = 97 * hash + Objects.hashCode(this.__origin);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseSelectGridReceiveUnitValue o = (BaseSelectGridReceiveUnitValue)obj;
		if(!Objects.equals(this.__receive_unit_manage_id, o.getReceiveUnitManageId())) return false;
		if(!Objects.equals(this.__receive_unit, o.getReceiveUnit())) return false;
		if(!Objects.equals(this.__bank_account, o.getBankAccount())) return false;
		if(!Objects.equals(this.__bank_name, o.getBankName())) return false;
		if(!Objects.equals(this.__receive_unit_address, o.getReceiveUnitAddress())) return false;
		if(!Objects.equals(this.__operate_employee_id, o.getOperateEmployeeId())) return false;
		if(!Objects.equals(this.__operate_time, o.getOperateTime())) return false;
		if(!Objects.equals(this.__origin, o.getOrigin())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getReceiveUnitManageId() != null) sb.append(__wrapNumber(count++, "receiveUnitManageId", getReceiveUnitManageId()));
		if(getReceiveUnit() != null) sb.append(__wrapString(count++, "receiveUnit", getReceiveUnit()));
		if(getBankAccount() != null) sb.append(__wrapString(count++, "bankAccount", getBankAccount()));
		if(getBankName() != null) sb.append(__wrapString(count++, "bankName", getBankName()));
		if(getReceiveUnitAddress() != null) sb.append(__wrapString(count++, "receiveUnitAddress", getReceiveUnitAddress()));
		if(getOperateEmployeeId() != null) sb.append(__wrapNumber(count++, "operateEmployeeId", getOperateEmployeeId()));
		if(getOperateTime() != null) sb.append(__wrapDate(count++, "operateTime", getOperateTime()));
		if(getOrigin() != null) sb.append(__wrapNumber(count++, "origin", getOrigin()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("receiveUnitManageId")) != null) setReceiveUnitManageId(__getInt(val)); 
		if((val = values.get("receiveUnit")) != null) setReceiveUnit(__getString(val));
		if((val = values.get("bankAccount")) != null) setBankAccount(__getString(val));
		if((val = values.get("bankName")) != null) setBankName(__getString(val));
		if((val = values.get("receiveUnitAddress")) != null) setReceiveUnitAddress(__getString(val));
		if((val = values.get("operateEmployeeId")) != null) setOperateEmployeeId(__getInt(val)); 
		if((val = values.get("operateTime")) != null) setOperateTime(__getDate(val)); 
		if((val = values.get("origin")) != null) setOrigin(__getInt(val)); 
	}

	protected java.lang.Integer  __receive_unit_manage_id ;
	protected java.lang.String  __receive_unit ;
	protected java.lang.String  __bank_account ;
	protected java.lang.String  __bank_name ;
	protected java.lang.String  __receive_unit_address ;
	protected java.lang.Integer  __operate_employee_id ;
	protected java.util.Date  __operate_time ;
	protected java.lang.Integer  __origin ;
}
