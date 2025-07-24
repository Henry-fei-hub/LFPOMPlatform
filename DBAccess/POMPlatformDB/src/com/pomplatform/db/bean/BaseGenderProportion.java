package com.pomplatform.db.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseGenderProportion extends GenericBase implements BaseFactory<BaseGenderProportion>, Comparable<BaseGenderProportion> 
{


	public static BaseGenderProportion newInstance(){
		return new BaseGenderProportion();
	}

	@Override
	public BaseGenderProportion make(){
		BaseGenderProportion b = new BaseGenderProportion();
		return b;
	}

	public final static java.lang.String CS_GENDER_PROPORTION_ID = "gender_proportion_id" ;
	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_MALE_PROPORTION_STR = "male_proportion_str" ;
	public final static java.lang.String CS_FEMALE_PROPORTION_STR = "female_proportion_str" ;
	public final static java.lang.String CS_MALE_PROPORTION = "male_proportion" ;
	public final static java.lang.String CS_FEMALE_PROPORTION = "female_proportion" ;

	public final static java.lang.String ALL_CAPTIONS = "主键编码,业务部门,男性理想比例（显示用）,女性理想比例（显示用）,男性理想比例,女性理想比例";

	public java.lang.Integer getGenderProportionId() {
		return this.__gender_proportion_id;
	}

	public void setGenderProportionId( java.lang.Integer value ) {
		this.__gender_proportion_id = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.String getMaleProportionStr() {
		return this.__male_proportion_str;
	}

	public void setMaleProportionStr( java.lang.String value ) {
		this.__male_proportion_str = value;
	}

	public java.lang.String getFemaleProportionStr() {
		return this.__female_proportion_str;
	}

	public void setFemaleProportionStr( java.lang.String value ) {
		this.__female_proportion_str = value;
	}

	public java.math.BigDecimal getMaleProportion() {
		return this.__male_proportion;
	}

	public void setMaleProportion( java.math.BigDecimal value ) {
		this.__male_proportion = value;
	}

	public java.math.BigDecimal getFemaleProportion() {
		return this.__female_proportion;
	}

	public void setFemaleProportion( java.math.BigDecimal value ) {
		this.__female_proportion = value;
	}

	public void cloneCopy(BaseGenderProportion __bean){
		__bean.setGenderProportionId(getGenderProportionId());
		__bean.setPlateId(getPlateId());
		__bean.setMaleProportionStr(getMaleProportionStr());
		__bean.setFemaleProportionStr(getFemaleProportionStr());
		__bean.setMaleProportion(getMaleProportion());
		__bean.setFemaleProportion(getFemaleProportion());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getGenderProportionId() == null ? "" : getGenderProportionId());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getMaleProportionStr() == null ? "" : getMaleProportionStr());
		sb.append(",");
		sb.append(getFemaleProportionStr() == null ? "" : getFemaleProportionStr());
		sb.append(",");
		sb.append(getMaleProportion() == null ? "" : getMaleProportion());
		sb.append(",");
		sb.append(getFemaleProportion() == null ? "" : getFemaleProportion());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseGenderProportion o) {
		return __gender_proportion_id == null ? -1 : __gender_proportion_id.compareTo(o.getGenderProportionId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__gender_proportion_id);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__male_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__female_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__male_proportion);
		hash = 97 * hash + Objects.hashCode(this.__female_proportion);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseGenderProportion o = (BaseGenderProportion)obj;
		if(!Objects.equals(this.__gender_proportion_id, o.getGenderProportionId())) return false;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__male_proportion_str, o.getMaleProportionStr())) return false;
		if(!Objects.equals(this.__female_proportion_str, o.getFemaleProportionStr())) return false;
		if(!Objects.equals(this.__male_proportion, o.getMaleProportion())) return false;
		if(!Objects.equals(this.__female_proportion, o.getFemaleProportion())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getGenderProportionId() != null) sb.append(__wrapNumber(count++, "genderProportionId", getGenderProportionId()));
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getMaleProportionStr() != null) sb.append(__wrapString(count++, "maleProportionStr", getMaleProportionStr()));
		if(getFemaleProportionStr() != null) sb.append(__wrapString(count++, "femaleProportionStr", getFemaleProportionStr()));
		if(getMaleProportion() != null) sb.append(__wrapDecimal(count++, "maleProportion", getMaleProportion()));
		if(getFemaleProportion() != null) sb.append(__wrapDecimal(count++, "femaleProportion", getFemaleProportion()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("genderProportionId")) != null) setGenderProportionId(__getInt(val)); 
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("maleProportionStr")) != null) setMaleProportionStr(__getString(val));
		if((val = values.get("femaleProportionStr")) != null) setFemaleProportionStr(__getString(val));
		if((val = values.get("maleProportion")) != null) setMaleProportion(__getDecimal(val));  
		if((val = values.get("femaleProportion")) != null) setFemaleProportion(__getDecimal(val));  
	}

	protected java.lang.Integer  __gender_proportion_id ;
	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __male_proportion_str ;
	protected java.lang.String  __female_proportion_str ;
	protected java.math.BigDecimal  __male_proportion ;
	protected java.math.BigDecimal  __female_proportion ;
}
