package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateRecord extends GenericBase implements BaseFactory<BasePlateRecord>, Comparable<BasePlateRecord> 
{


	public static BasePlateRecord newInstance(){
		return new BasePlateRecord();
	}

	@Override
	public BasePlateRecord make(){
		BasePlateRecord b = new BasePlateRecord();
		return b;
	}

	public final static java.lang.String CS_PLATE_RECORD_ID = "plate_record_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_PLATE_CODE = "plate_code" ;
	public final static java.lang.String CS_PLATE_NAME = "plate_name" ;
	public final static java.lang.String CS_ENABLED = "enabled" ;
	public final static java.lang.String CS_PARENT_ID = "parent_id" ;
	public final static java.lang.String CS_PLATE_TYPE = "plate_type" ;
	public final static java.lang.String CS_PLATE_MANAGER_ID = "plate_manager_id" ;
	public final static java.lang.String CS_HR_CODE = "hr_code" ;
	public final static java.lang.String CS_PLATE_VOUCHER_TYPE = "plate_voucher_type" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,业务部门编码,业务部门名称,是否启用,父级编码,3营销部),部门负责人,人事编码, 4其他";

	public java.lang.Integer getPlateRecordId() {
		return this.__plate_record_id;
	}

	public void setPlateRecordId( java.lang.Integer value ) {
		this.__plate_record_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getPlateCode() {
		return this.__plate_code;
	}

	public void setPlateCode( java.lang.String value ) {
		this.__plate_code = value;
	}

	public java.lang.String getPlateName() {
		return this.__plate_name;
	}

	public void setPlateName( java.lang.String value ) {
		this.__plate_name = value;
	}

	public java.lang.Boolean getEnabled() {
		return this.__enabled;
	}

	public void setEnabled( java.lang.Boolean value ) {
		this.__enabled = value;
	}

	public java.lang.Integer getParentId() {
		return this.__parent_id;
	}

	public void setParentId( java.lang.Integer value ) {
		this.__parent_id = value;
	}

	public java.lang.Integer getPlateType() {
		return this.__plate_type;
	}

	public void setPlateType( java.lang.Integer value ) {
		this.__plate_type = value;
	}

	public java.lang.Integer getPlateManagerId() {
		return this.__plate_manager_id;
	}

	public void setPlateManagerId( java.lang.Integer value ) {
		this.__plate_manager_id = value;
	}

	public java.lang.String getHrCode() {
		return this.__hr_code;
	}

	public void setHrCode( java.lang.String value ) {
		this.__hr_code = value;
	}

	public java.lang.Integer getPlateVoucherType() {
		return this.__plate_voucher_type;
	}

	public void setPlateVoucherType( java.lang.Integer value ) {
		this.__plate_voucher_type = value;
	}

	public void cloneCopy(BasePlateRecord __bean){
		__bean.setPlateRecordId(getPlateRecordId());
		__bean.setPlateId(getPlateId());
		__bean.setPlateCode(getPlateCode());
		__bean.setPlateName(getPlateName());
		__bean.setEnabled(getEnabled());
		__bean.setParentId(getParentId());
		__bean.setPlateType(getPlateType());
		__bean.setPlateManagerId(getPlateManagerId());
		__bean.setHrCode(getHrCode());
		__bean.setPlateVoucherType(getPlateVoucherType());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateRecordId() == null ? "" : getPlateRecordId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getPlateCode() == null ? "" : getPlateCode());
		sb.append(",");
		sb.append(getPlateName() == null ? "" : getPlateName());
		sb.append(",");
		sb.append(getEnabled() == null ? "" : getEnabled());
		sb.append(",");
		String strParentId = delicacy.system.executor.SelectValueCache.getSelectValue("contracts_1", String.valueOf(getParentId()));
		sb.append(strParentId == null ? "" : strParentId);
		sb.append(",");
		sb.append(getPlateType() == null ? "" : getPlateType());
		sb.append(",");
		sb.append(getPlateManagerId() == null ? "" : getPlateManagerId());
		sb.append(",");
		sb.append(getHrCode() == null ? "" : getHrCode());
		sb.append(",");
		sb.append(getPlateVoucherType() == null ? "" : getPlateVoucherType());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateRecord o) {
		return __plate_record_id == null ? -1 : __plate_record_id.compareTo(o.getPlateRecordId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_record_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_code);
		hash = 97 * hash + Objects.hashCode(this.__plate_name);
		hash = 97 * hash + Objects.hashCode(this.__enabled);
		hash = 97 * hash + Objects.hashCode(this.__parent_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_type);
		hash = 97 * hash + Objects.hashCode(this.__plate_manager_id);
		hash = 97 * hash + Objects.hashCode(this.__hr_code);
		hash = 97 * hash + Objects.hashCode(this.__plate_voucher_type);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BasePlateRecord o = (BasePlateRecord)obj;
		if(!Objects.equals(this.__plate_record_id, o.getPlateRecordId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__plate_code, o.getPlateCode())) return false;
		if(!Objects.equals(this.__plate_name, o.getPlateName())) return false;
		if(!Objects.equals(this.__enabled, o.getEnabled())) return false;
		if(!Objects.equals(this.__parent_id, o.getParentId())) return false;
		if(!Objects.equals(this.__plate_type, o.getPlateType())) return false;
		if(!Objects.equals(this.__plate_manager_id, o.getPlateManagerId())) return false;
		if(!Objects.equals(this.__hr_code, o.getHrCode())) return false;
		if(!Objects.equals(this.__plate_voucher_type, o.getPlateVoucherType())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateRecordId() != null) sb.append(__wrapNumber(count++, "plateRecordId", getPlateRecordId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getPlateCode() != null) sb.append(__wrapString(count++, "plateCode", getPlateCode()));
		if(getPlateName() != null) sb.append(__wrapString(count++, "plateName", getPlateName()));
		if(getEnabled() != null) sb.append(__wrapBoolean(count++, "enabled", getEnabled()));
		if(getParentId() != null) sb.append(__wrapNumber(count++, "parentId", getParentId()));
		if(getPlateType() != null) sb.append(__wrapNumber(count++, "plateType", getPlateType()));
		if(getPlateManagerId() != null) sb.append(__wrapNumber(count++, "plateManagerId", getPlateManagerId()));
		if(getHrCode() != null) sb.append(__wrapString(count++, "hrCode", getHrCode()));
		if(getPlateVoucherType() != null) sb.append(__wrapNumber(count++, "plateVoucherType", getPlateVoucherType()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateRecordId")) != null) setPlateRecordId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("plateCode")) != null) setPlateCode(__getString(val));
		if((val = values.get("plateName")) != null) setPlateName(__getString(val));
		if((val = values.get("enabled")) != null) setEnabled(__getBoolean(val));
		if((val = values.get("parentId")) != null) setParentId(__getInt(val)); 
		if((val = values.get("plateType")) != null) setPlateType(__getInt(val)); 
		if((val = values.get("plateManagerId")) != null) setPlateManagerId(__getInt(val)); 
		if((val = values.get("hrCode")) != null) setHrCode(__getString(val));
		if((val = values.get("plateVoucherType")) != null) setPlateVoucherType(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_record_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __plate_code ;
	protected java.lang.String  __plate_name ;
	protected java.lang.Boolean  __enabled ;
	protected java.lang.Integer  __parent_id ;
	protected java.lang.Integer  __plate_type ;
	protected java.lang.Integer  __plate_manager_id ;
	protected java.lang.String  __hr_code ;
	protected java.lang.Integer  __plate_voucher_type ;
}
