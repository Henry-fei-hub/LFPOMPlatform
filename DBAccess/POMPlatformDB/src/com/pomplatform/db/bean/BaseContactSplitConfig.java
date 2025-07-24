package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseContactSplitConfig extends GenericBase implements BaseFactory<BaseContactSplitConfig>, Comparable<BaseContactSplitConfig> 
{


	public static BaseContactSplitConfig newInstance(){
		return new BaseContactSplitConfig();
	}

	@Override
	public BaseContactSplitConfig make(){
		BaseContactSplitConfig b = new BaseContactSplitConfig();
		return b;
	}

	public final static java.lang.String CS_CONTACT_SPLIT_CONFIG_ID = "contact_split_config_id" ;
	public final static java.lang.String CS_NAME = "name" ;
	public final static java.lang.String CS_PROGRAMME = "programme" ;
	public final static java.lang.String CS_DEEPEN = "deepen" ;
	public final static java.lang.String CS_ELECTROMECHANICAL = "electromechanical" ;
	public final static java.lang.String CS_LIGHTING = "lighting" ;
	public final static java.lang.String CS_SERVICE = "service" ;
	public final static java.lang.String CS_REMARK = "remark" ;

	public final static java.lang.String ALL_CAPTIONS = "主键,合同分类名称,方案占比,深化占比,机电配合占比,灯光配合占比,驻场服务占比,备注";

	public java.lang.Integer getContactSplitConfigId() {
		return this.__contact_split_config_id;
	}

	public void setContactSplitConfigId( java.lang.Integer value ) {
		this.__contact_split_config_id = value;
	}

	public java.lang.String getName() {
		return this.__name;
	}

	public void setName( java.lang.String value ) {
		this.__name = value;
	}

	public java.math.BigDecimal getProgramme() {
		return this.__programme;
	}

	public void setProgramme( java.math.BigDecimal value ) {
		this.__programme = value;
	}

	public java.math.BigDecimal getDeepen() {
		return this.__deepen;
	}

	public void setDeepen( java.math.BigDecimal value ) {
		this.__deepen = value;
	}

	public java.math.BigDecimal getElectromechanical() {
		return this.__electromechanical;
	}

	public void setElectromechanical( java.math.BigDecimal value ) {
		this.__electromechanical = value;
	}

	public java.math.BigDecimal getLighting() {
		return this.__lighting;
	}

	public void setLighting( java.math.BigDecimal value ) {
		this.__lighting = value;
	}

	public java.math.BigDecimal getService() {
		return this.__service;
	}

	public void setService( java.math.BigDecimal value ) {
		this.__service = value;
	}

	public java.lang.String getRemark() {
		return this.__remark;
	}

	public void setRemark( java.lang.String value ) {
		this.__remark = value;
	}

	public void cloneCopy(BaseContactSplitConfig __bean){
		__bean.setContactSplitConfigId(getContactSplitConfigId());
		__bean.setName(getName());
		__bean.setProgramme(getProgramme());
		__bean.setDeepen(getDeepen());
		__bean.setElectromechanical(getElectromechanical());
		__bean.setLighting(getLighting());
		__bean.setService(getService());
		__bean.setRemark(getRemark());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getContactSplitConfigId() == null ? "" : getContactSplitConfigId());
		sb.append(",");
		sb.append(getName() == null ? "" : getName());
		sb.append(",");
		sb.append(getProgramme() == null ? "" : getProgramme());
		sb.append(",");
		sb.append(getDeepen() == null ? "" : getDeepen());
		sb.append(",");
		sb.append(getElectromechanical() == null ? "" : getElectromechanical());
		sb.append(",");
		sb.append(getLighting() == null ? "" : getLighting());
		sb.append(",");
		sb.append(getService() == null ? "" : getService());
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseContactSplitConfig o) {
		return __contact_split_config_id == null ? -1 : __contact_split_config_id.compareTo(o.getContactSplitConfigId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__contact_split_config_id);
		hash = 97 * hash + Objects.hashCode(this.__name);
		hash = 97 * hash + Objects.hashCode(this.__programme);
		hash = 97 * hash + Objects.hashCode(this.__deepen);
		hash = 97 * hash + Objects.hashCode(this.__electromechanical);
		hash = 97 * hash + Objects.hashCode(this.__lighting);
		hash = 97 * hash + Objects.hashCode(this.__service);
		hash = 97 * hash + Objects.hashCode(this.__remark);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseContactSplitConfig o = (BaseContactSplitConfig)obj;
		if(!Objects.equals(this.__contact_split_config_id, o.getContactSplitConfigId())) return false;
		if(!Objects.equals(this.__name, o.getName())) return false;
		if(!Objects.equals(this.__programme, o.getProgramme())) return false;
		if(!Objects.equals(this.__deepen, o.getDeepen())) return false;
		if(!Objects.equals(this.__electromechanical, o.getElectromechanical())) return false;
		if(!Objects.equals(this.__lighting, o.getLighting())) return false;
		if(!Objects.equals(this.__service, o.getService())) return false;
		if(!Objects.equals(this.__remark, o.getRemark())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getContactSplitConfigId() != null) sb.append(__wrapNumber(count++, "contactSplitConfigId", getContactSplitConfigId()));
		if(getName() != null) sb.append(__wrapString(count++, "name", getName()));
		if(getProgramme() != null) sb.append(__wrapDecimal(count++, "programme", getProgramme()));
		if(getDeepen() != null) sb.append(__wrapDecimal(count++, "deepen", getDeepen()));
		if(getElectromechanical() != null) sb.append(__wrapDecimal(count++, "electromechanical", getElectromechanical()));
		if(getLighting() != null) sb.append(__wrapDecimal(count++, "lighting", getLighting()));
		if(getService() != null) sb.append(__wrapDecimal(count++, "service", getService()));
		if(getRemark() != null) sb.append(__wrapString(count++, "remark", getRemark()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("contactSplitConfigId")) != null) setContactSplitConfigId(__getInt(val)); 
		if((val = values.get("name")) != null) setName(__getString(val));
		if((val = values.get("programme")) != null) setProgramme(__getDecimal(val));  
		if((val = values.get("deepen")) != null) setDeepen(__getDecimal(val));  
		if((val = values.get("electromechanical")) != null) setElectromechanical(__getDecimal(val));  
		if((val = values.get("lighting")) != null) setLighting(__getDecimal(val));  
		if((val = values.get("service")) != null) setService(__getDecimal(val));  
		if((val = values.get("remark")) != null) setRemark(__getString(val));
	}

	protected java.lang.Integer  __contact_split_config_id ;
	protected java.lang.String  __name ;
	protected java.math.BigDecimal  __programme ;
	protected java.math.BigDecimal  __deepen ;
	protected java.math.BigDecimal  __electromechanical ;
	protected java.math.BigDecimal  __lighting ;
	protected java.math.BigDecimal  __service ;
	protected java.lang.String  __remark ;
}
