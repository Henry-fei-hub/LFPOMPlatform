package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOfGenderPlateMonth extends GenericBase implements BaseFactory<BaseReportOfGenderPlateMonth>, Comparable<BaseReportOfGenderPlateMonth> 
{


	public static BaseReportOfGenderPlateMonth newInstance(){
		return new BaseReportOfGenderPlateMonth();
	}

	@Override
	public BaseReportOfGenderPlateMonth make(){
		BaseReportOfGenderPlateMonth b = new BaseReportOfGenderPlateMonth();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_MALE_PROPORTION_STR = "male_proportion_str" ;
	public final static java.lang.String CS_FEMALE_PROPORTION_STR = "female_proportion_str" ;
	public final static java.lang.String CS_MALE_PROPORTION = "male_proportion" ;
	public final static java.lang.String CS_FEMALE_PROPORTION = "female_proportion" ;
	public final static java.lang.String CS_MALE = "male" ;
	public final static java.lang.String CS_MALE_PER = "male_per" ;
	public final static java.lang.String CS_FEMALE = "female" ;
	public final static java.lang.String CS_FEMALE_PER = "female_per" ;
	public final static java.lang.String CS_TOTAL = "total" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,男性理想比例(显示用),女性理想比例(显示用),男性理想比例,女性理想比例,男,男性比例(%),女,女性比例(%),合计";

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

	public java.math.BigDecimal getMale() {
		return this.__male;
	}

	public void setMale( java.math.BigDecimal value ) {
		this.__male = value;
	}

	public java.math.BigDecimal getMalePer() {
		return this.__male_per;
	}

	public void setMalePer( java.math.BigDecimal value ) {
		this.__male_per = value;
	}

	public java.math.BigDecimal getFemale() {
		return this.__female;
	}

	public void setFemale( java.math.BigDecimal value ) {
		this.__female = value;
	}

	public java.math.BigDecimal getFemalePer() {
		return this.__female_per;
	}

	public void setFemalePer( java.math.BigDecimal value ) {
		this.__female_per = value;
	}

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public void cloneCopy(BaseReportOfGenderPlateMonth __bean){
		__bean.setPlateId(getPlateId());
		__bean.setMaleProportionStr(getMaleProportionStr());
		__bean.setFemaleProportionStr(getFemaleProportionStr());
		__bean.setMaleProportion(getMaleProportion());
		__bean.setFemaleProportion(getFemaleProportion());
		__bean.setMale(getMale());
		__bean.setMalePer(getMalePer());
		__bean.setFemale(getFemale());
		__bean.setFemalePer(getFemalePer());
		__bean.setTotal(getTotal());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
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
		sb.append(",");
		sb.append(getMale() == null ? "" : getMale());
		sb.append(",");
		sb.append(getMalePer() == null ? "" : getMalePer());
		sb.append(",");
		sb.append(getFemale() == null ? "" : getFemale());
		sb.append(",");
		sb.append(getFemalePer() == null ? "" : getFemalePer());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOfGenderPlateMonth o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__male_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__female_proportion_str);
		hash = 97 * hash + Objects.hashCode(this.__male_proportion);
		hash = 97 * hash + Objects.hashCode(this.__female_proportion);
		hash = 97 * hash + Objects.hashCode(this.__male);
		hash = 97 * hash + Objects.hashCode(this.__male_per);
		hash = 97 * hash + Objects.hashCode(this.__female);
		hash = 97 * hash + Objects.hashCode(this.__female_per);
		hash = 97 * hash + Objects.hashCode(this.__total);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOfGenderPlateMonth o = (BaseReportOfGenderPlateMonth)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__male_proportion_str, o.getMaleProportionStr())) return false;
		if(!Objects.equals(this.__female_proportion_str, o.getFemaleProportionStr())) return false;
		if(!Objects.equals(this.__male_proportion, o.getMaleProportion())) return false;
		if(!Objects.equals(this.__female_proportion, o.getFemaleProportion())) return false;
		if(!Objects.equals(this.__male, o.getMale())) return false;
		if(!Objects.equals(this.__male_per, o.getMalePer())) return false;
		if(!Objects.equals(this.__female, o.getFemale())) return false;
		if(!Objects.equals(this.__female_per, o.getFemalePer())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getMaleProportionStr() != null) sb.append(__wrapString(count++, "maleProportionStr", getMaleProportionStr()));
		if(getFemaleProportionStr() != null) sb.append(__wrapString(count++, "femaleProportionStr", getFemaleProportionStr()));
		if(getMaleProportion() != null) sb.append(__wrapDecimal(count++, "maleProportion", getMaleProportion()));
		if(getFemaleProportion() != null) sb.append(__wrapDecimal(count++, "femaleProportion", getFemaleProportion()));
		if(getMale() != null) sb.append(__wrapDecimal(count++, "male", getMale()));
		if(getMalePer() != null) sb.append(__wrapDecimal(count++, "malePer", getMalePer()));
		if(getFemale() != null) sb.append(__wrapDecimal(count++, "female", getFemale()));
		if(getFemalePer() != null) sb.append(__wrapDecimal(count++, "femalePer", getFemalePer()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("maleProportionStr")) != null) setMaleProportionStr(__getString(val));
		if((val = values.get("femaleProportionStr")) != null) setFemaleProportionStr(__getString(val));
		if((val = values.get("maleProportion")) != null) setMaleProportion(__getDecimal(val));  
		if((val = values.get("femaleProportion")) != null) setFemaleProportion(__getDecimal(val));  
		if((val = values.get("male")) != null) setMale(__getDecimal(val));  
		if((val = values.get("malePer")) != null) setMalePer(__getDecimal(val));  
		if((val = values.get("female")) != null) setFemale(__getDecimal(val));  
		if((val = values.get("femalePer")) != null) setFemalePer(__getDecimal(val));  
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.String  __male_proportion_str ;
	protected java.lang.String  __female_proportion_str ;
	protected java.math.BigDecimal  __male_proportion ;
	protected java.math.BigDecimal  __female_proportion ;
	protected java.math.BigDecimal  __male ;
	protected java.math.BigDecimal  __male_per ;
	protected java.math.BigDecimal  __female ;
	protected java.math.BigDecimal  __female_per ;
	protected java.math.BigDecimal  __total ;
}
