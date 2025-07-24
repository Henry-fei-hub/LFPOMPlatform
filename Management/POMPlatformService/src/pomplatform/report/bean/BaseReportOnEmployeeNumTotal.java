package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOnEmployeeNumTotal extends GenericBase implements BaseFactory<BaseReportOnEmployeeNumTotal>, Comparable<BaseReportOnEmployeeNumTotal> 
{


	public static BaseReportOnEmployeeNumTotal newInstance(){
		return new BaseReportOnEmployeeNumTotal();
	}

	@Override
	public BaseReportOnEmployeeNumTotal make(){
		BaseReportOnEmployeeNumTotal b = new BaseReportOnEmployeeNumTotal();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_ONE_BEFOR_NUM = "one_befor_num" ;
	public final static java.lang.String CS_ONE_AFTER_NUM = "one_after_num" ;
	public final static java.lang.String CS_ONE_AVERAGE_NUM = "one_average_num" ;
	public final static java.lang.String CS_TWO_BEFOR_NUM = "two_befor_num" ;
	public final static java.lang.String CS_TWO_AFTER_NUM = "two_after_num" ;
	public final static java.lang.String CS_TWO_AVERAGE_NUM = "two_average_num" ;
	public final static java.lang.String CS_THREE_BEFOR_NUM = "three_befor_num" ;
	public final static java.lang.String CS_THREE_AFTER_NUM = "three_after_num" ;
	public final static java.lang.String CS_THREE_AVERAGE_NUM = "three_average_num" ;
	public final static java.lang.String CS_FOUR_BEFOR_NUM = "four_befor_num" ;
	public final static java.lang.String CS_FOUR_AFTER_NUM = "four_after_num" ;
	public final static java.lang.String CS_FOUR_AVERAGE_NUM = "four_average_num" ;
	public final static java.lang.String CS_FIVE_BEFOR_NUM = "five_befor_num" ;
	public final static java.lang.String CS_FIVE_AFTER_NUM = "five_after_num" ;
	public final static java.lang.String CS_FIVE_AVERAGE_NUM = "five_average_num" ;
	public final static java.lang.String CS_SIX_BEFOR_NUM = "six_befor_num" ;
	public final static java.lang.String CS_SIX_AFTER_NUM = "six_after_num" ;
	public final static java.lang.String CS_SIX_AVERAGE_NUM = "six_average_num" ;
	public final static java.lang.String CS_SEVEN_BEFOR_NUM = "seven_befor_num" ;
	public final static java.lang.String CS_SEVEN_AFTER_NUM = "seven_after_num" ;
	public final static java.lang.String CS_SEVEN_AVERAGE_NUM = "seven_average_num" ;
	public final static java.lang.String CS_EIGHT_BEFOR_NUM = "eight_befor_num" ;
	public final static java.lang.String CS_EIGHT_AFTER_NUM = "eight_after_num" ;
	public final static java.lang.String CS_EIGHT_AVERAGE_NUM = "eight_average_num" ;
	public final static java.lang.String CS_NINE_BEFOR_NUM = "nine_befor_num" ;
	public final static java.lang.String CS_NINE_AFTER_NUM = "nine_after_num" ;
	public final static java.lang.String CS_NINE_AVERAGE_NUM = "nine_average_num" ;
	public final static java.lang.String CS_TEN_BEFOR_NUM = "ten_befor_num" ;
	public final static java.lang.String CS_TEN_AFTER_NUM = "ten_after_num" ;
	public final static java.lang.String CS_TEN_AVERAGE_NUM = "ten_average_num" ;
	public final static java.lang.String CS_ELEVEN_BEFOR_NUM = "eleven_befor_num" ;
	public final static java.lang.String CS_ELEVEN_AFTER_NUM = "eleven_after_num" ;
	public final static java.lang.String CS_ELEVEN_AVERAGE_NUM = "eleven_average_num" ;
	public final static java.lang.String CS_TWELF_BEFOR_NUM = "twelf_befor_num" ;
	public final static java.lang.String CS_TWELF_AFTER_NUM = "twelf_after_num" ;
	public final static java.lang.String CS_TWELF_AVERAGE_NUM = "twelf_average_num" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.lang.Long getOneBeforNum() {
		return this.__one_befor_num;
	}

	public void setOneBeforNum( java.lang.Long value ) {
		this.__one_befor_num = value;
	}

	public java.lang.Long getOneAfterNum() {
		return this.__one_after_num;
	}

	public void setOneAfterNum( java.lang.Long value ) {
		this.__one_after_num = value;
	}

	public java.math.BigDecimal getOneAverageNum() {
		return this.__one_average_num;
	}

	public void setOneAverageNum( java.math.BigDecimal value ) {
		this.__one_average_num = value;
	}

	public java.lang.Long getTwoBeforNum() {
		return this.__two_befor_num;
	}

	public void setTwoBeforNum( java.lang.Long value ) {
		this.__two_befor_num = value;
	}

	public java.lang.Long getTwoAfterNum() {
		return this.__two_after_num;
	}

	public void setTwoAfterNum( java.lang.Long value ) {
		this.__two_after_num = value;
	}

	public java.math.BigDecimal getTwoAverageNum() {
		return this.__two_average_num;
	}

	public void setTwoAverageNum( java.math.BigDecimal value ) {
		this.__two_average_num = value;
	}

	public java.lang.Long getThreeBeforNum() {
		return this.__three_befor_num;
	}

	public void setThreeBeforNum( java.lang.Long value ) {
		this.__three_befor_num = value;
	}

	public java.lang.Long getThreeAfterNum() {
		return this.__three_after_num;
	}

	public void setThreeAfterNum( java.lang.Long value ) {
		this.__three_after_num = value;
	}

	public java.math.BigDecimal getThreeAverageNum() {
		return this.__three_average_num;
	}

	public void setThreeAverageNum( java.math.BigDecimal value ) {
		this.__three_average_num = value;
	}

	public java.lang.Long getFourBeforNum() {
		return this.__four_befor_num;
	}

	public void setFourBeforNum( java.lang.Long value ) {
		this.__four_befor_num = value;
	}

	public java.lang.Long getFourAfterNum() {
		return this.__four_after_num;
	}

	public void setFourAfterNum( java.lang.Long value ) {
		this.__four_after_num = value;
	}

	public java.math.BigDecimal getFourAverageNum() {
		return this.__four_average_num;
	}

	public void setFourAverageNum( java.math.BigDecimal value ) {
		this.__four_average_num = value;
	}

	public java.lang.Long getFiveBeforNum() {
		return this.__five_befor_num;
	}

	public void setFiveBeforNum( java.lang.Long value ) {
		this.__five_befor_num = value;
	}

	public java.lang.Long getFiveAfterNum() {
		return this.__five_after_num;
	}

	public void setFiveAfterNum( java.lang.Long value ) {
		this.__five_after_num = value;
	}

	public java.math.BigDecimal getFiveAverageNum() {
		return this.__five_average_num;
	}

	public void setFiveAverageNum( java.math.BigDecimal value ) {
		this.__five_average_num = value;
	}

	public java.lang.Long getSixBeforNum() {
		return this.__six_befor_num;
	}

	public void setSixBeforNum( java.lang.Long value ) {
		this.__six_befor_num = value;
	}

	public java.lang.Long getSixAfterNum() {
		return this.__six_after_num;
	}

	public void setSixAfterNum( java.lang.Long value ) {
		this.__six_after_num = value;
	}

	public java.math.BigDecimal getSixAverageNum() {
		return this.__six_average_num;
	}

	public void setSixAverageNum( java.math.BigDecimal value ) {
		this.__six_average_num = value;
	}

	public java.lang.Long getSevenBeforNum() {
		return this.__seven_befor_num;
	}

	public void setSevenBeforNum( java.lang.Long value ) {
		this.__seven_befor_num = value;
	}

	public java.lang.Long getSevenAfterNum() {
		return this.__seven_after_num;
	}

	public void setSevenAfterNum( java.lang.Long value ) {
		this.__seven_after_num = value;
	}

	public java.math.BigDecimal getSevenAverageNum() {
		return this.__seven_average_num;
	}

	public void setSevenAverageNum( java.math.BigDecimal value ) {
		this.__seven_average_num = value;
	}

	public java.lang.Long getEightBeforNum() {
		return this.__eight_befor_num;
	}

	public void setEightBeforNum( java.lang.Long value ) {
		this.__eight_befor_num = value;
	}

	public java.lang.Long getEightAfterNum() {
		return this.__eight_after_num;
	}

	public void setEightAfterNum( java.lang.Long value ) {
		this.__eight_after_num = value;
	}

	public java.math.BigDecimal getEightAverageNum() {
		return this.__eight_average_num;
	}

	public void setEightAverageNum( java.math.BigDecimal value ) {
		this.__eight_average_num = value;
	}

	public java.lang.Long getNineBeforNum() {
		return this.__nine_befor_num;
	}

	public void setNineBeforNum( java.lang.Long value ) {
		this.__nine_befor_num = value;
	}

	public java.lang.Long getNineAfterNum() {
		return this.__nine_after_num;
	}

	public void setNineAfterNum( java.lang.Long value ) {
		this.__nine_after_num = value;
	}

	public java.math.BigDecimal getNineAverageNum() {
		return this.__nine_average_num;
	}

	public void setNineAverageNum( java.math.BigDecimal value ) {
		this.__nine_average_num = value;
	}

	public java.lang.Long getTenBeforNum() {
		return this.__ten_befor_num;
	}

	public void setTenBeforNum( java.lang.Long value ) {
		this.__ten_befor_num = value;
	}

	public java.lang.Long getTenAfterNum() {
		return this.__ten_after_num;
	}

	public void setTenAfterNum( java.lang.Long value ) {
		this.__ten_after_num = value;
	}

	public java.math.BigDecimal getTenAverageNum() {
		return this.__ten_average_num;
	}

	public void setTenAverageNum( java.math.BigDecimal value ) {
		this.__ten_average_num = value;
	}

	public java.lang.Long getElevenBeforNum() {
		return this.__eleven_befor_num;
	}

	public void setElevenBeforNum( java.lang.Long value ) {
		this.__eleven_befor_num = value;
	}

	public java.lang.Long getElevenAfterNum() {
		return this.__eleven_after_num;
	}

	public void setElevenAfterNum( java.lang.Long value ) {
		this.__eleven_after_num = value;
	}

	public java.math.BigDecimal getElevenAverageNum() {
		return this.__eleven_average_num;
	}

	public void setElevenAverageNum( java.math.BigDecimal value ) {
		this.__eleven_average_num = value;
	}

	public java.lang.Long getTwelfBeforNum() {
		return this.__twelf_befor_num;
	}

	public void setTwelfBeforNum( java.lang.Long value ) {
		this.__twelf_befor_num = value;
	}

	public java.lang.Long getTwelfAfterNum() {
		return this.__twelf_after_num;
	}

	public void setTwelfAfterNum( java.lang.Long value ) {
		this.__twelf_after_num = value;
	}

	public java.math.BigDecimal getTwelfAverageNum() {
		return this.__twelf_average_num;
	}

	public void setTwelfAverageNum( java.math.BigDecimal value ) {
		this.__twelf_average_num = value;
	}

	public void cloneCopy(BaseReportOnEmployeeNumTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setOneBeforNum(getOneBeforNum());
		__bean.setOneAfterNum(getOneAfterNum());
		__bean.setOneAverageNum(getOneAverageNum());
		__bean.setTwoBeforNum(getTwoBeforNum());
		__bean.setTwoAfterNum(getTwoAfterNum());
		__bean.setTwoAverageNum(getTwoAverageNum());
		__bean.setThreeBeforNum(getThreeBeforNum());
		__bean.setThreeAfterNum(getThreeAfterNum());
		__bean.setThreeAverageNum(getThreeAverageNum());
		__bean.setFourBeforNum(getFourBeforNum());
		__bean.setFourAfterNum(getFourAfterNum());
		__bean.setFourAverageNum(getFourAverageNum());
		__bean.setFiveBeforNum(getFiveBeforNum());
		__bean.setFiveAfterNum(getFiveAfterNum());
		__bean.setFiveAverageNum(getFiveAverageNum());
		__bean.setSixBeforNum(getSixBeforNum());
		__bean.setSixAfterNum(getSixAfterNum());
		__bean.setSixAverageNum(getSixAverageNum());
		__bean.setSevenBeforNum(getSevenBeforNum());
		__bean.setSevenAfterNum(getSevenAfterNum());
		__bean.setSevenAverageNum(getSevenAverageNum());
		__bean.setEightBeforNum(getEightBeforNum());
		__bean.setEightAfterNum(getEightAfterNum());
		__bean.setEightAverageNum(getEightAverageNum());
		__bean.setNineBeforNum(getNineBeforNum());
		__bean.setNineAfterNum(getNineAfterNum());
		__bean.setNineAverageNum(getNineAverageNum());
		__bean.setTenBeforNum(getTenBeforNum());
		__bean.setTenAfterNum(getTenAfterNum());
		__bean.setTenAverageNum(getTenAverageNum());
		__bean.setElevenBeforNum(getElevenBeforNum());
		__bean.setElevenAfterNum(getElevenAfterNum());
		__bean.setElevenAverageNum(getElevenAverageNum());
		__bean.setTwelfBeforNum(getTwelfBeforNum());
		__bean.setTwelfAfterNum(getTwelfAfterNum());
		__bean.setTwelfAverageNum(getTwelfAverageNum());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strBusinessLine = delicacy.system.executor.SelectValueCache.getSelectValue("plate_records", String.valueOf(getPlateId()));
		sb.append(strBusinessLine== null ? "" : strBusinessLine);
		sb.append(",");
/*		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");*/
		sb.append(getOneBeforNum() == null ? "" : getOneBeforNum());
		sb.append(",");
		sb.append(getOneAfterNum() == null ? "" : getOneAfterNum());
		sb.append(",");
		sb.append(getOneAverageNum() == null ? "" : getOneAverageNum());
		sb.append(",");
		sb.append(getTwoBeforNum() == null ? "" : getTwoBeforNum());
		sb.append(",");
		sb.append(getTwoAfterNum() == null ? "" : getTwoAfterNum());
		sb.append(",");
		sb.append(getTwoAverageNum() == null ? "" : getTwoAverageNum());
		sb.append(",");
		sb.append(getThreeBeforNum() == null ? "" : getThreeBeforNum());
		sb.append(",");
		sb.append(getThreeAfterNum() == null ? "" : getThreeAfterNum());
		sb.append(",");
		sb.append(getThreeAverageNum() == null ? "" : getThreeAverageNum());
		sb.append(",");
		sb.append(getFourBeforNum() == null ? "" : getFourBeforNum());
		sb.append(",");
		sb.append(getFourAfterNum() == null ? "" : getFourAfterNum());
		sb.append(",");
		sb.append(getFourAverageNum() == null ? "" : getFourAverageNum());
		sb.append(",");
		sb.append(getFiveBeforNum() == null ? "" : getFiveBeforNum());
		sb.append(",");
		sb.append(getFiveAfterNum() == null ? "" : getFiveAfterNum());
		sb.append(",");
		sb.append(getFiveAverageNum() == null ? "" : getFiveAverageNum());
		sb.append(",");
		sb.append(getSixBeforNum() == null ? "" : getSixBeforNum());
		sb.append(",");
		sb.append(getSixAfterNum() == null ? "" : getSixAfterNum());
		sb.append(",");
		sb.append(getSixAverageNum() == null ? "" : getSixAverageNum());
		sb.append(",");
		sb.append(getSevenBeforNum() == null ? "" : getSevenBeforNum());
		sb.append(",");
		sb.append(getSevenAfterNum() == null ? "" : getSevenAfterNum());
		sb.append(",");
		sb.append(getSevenAverageNum() == null ? "" : getSevenAverageNum());
		sb.append(",");
		sb.append(getEightBeforNum() == null ? "" : getEightBeforNum());
		sb.append(",");
		sb.append(getEightAfterNum() == null ? "" : getEightAfterNum());
		sb.append(",");
		sb.append(getEightAverageNum() == null ? "" : getEightAverageNum());
		sb.append(",");
		sb.append(getNineBeforNum() == null ? "" : getNineBeforNum());
		sb.append(",");
		sb.append(getNineAfterNum() == null ? "" : getNineAfterNum());
		sb.append(",");
		sb.append(getNineAverageNum() == null ? "" : getNineAverageNum());
		sb.append(",");
		sb.append(getTenBeforNum() == null ? "" : getTenBeforNum());
		sb.append(",");
		sb.append(getTenAfterNum() == null ? "" : getTenAfterNum());
		sb.append(",");
		sb.append(getTenAverageNum() == null ? "" : getTenAverageNum());
		sb.append(",");
		sb.append(getElevenBeforNum() == null ? "" : getElevenBeforNum());
		sb.append(",");
		sb.append(getElevenAfterNum() == null ? "" : getElevenAfterNum());
		sb.append(",");
		sb.append(getElevenAverageNum() == null ? "" : getElevenAverageNum());
		sb.append(",");
		sb.append(getTwelfBeforNum() == null ? "" : getTwelfBeforNum());
		sb.append(",");
		sb.append(getTwelfAfterNum() == null ? "" : getTwelfAfterNum());
		sb.append(",");
		sb.append(getTwelfAverageNum() == null ? "" : getTwelfAverageNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOnEmployeeNumTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__one_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__one_after_num);
		hash = 97 * hash + Objects.hashCode(this.__one_average_num);
		hash = 97 * hash + Objects.hashCode(this.__two_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__two_after_num);
		hash = 97 * hash + Objects.hashCode(this.__two_average_num);
		hash = 97 * hash + Objects.hashCode(this.__three_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__three_after_num);
		hash = 97 * hash + Objects.hashCode(this.__three_average_num);
		hash = 97 * hash + Objects.hashCode(this.__four_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__four_after_num);
		hash = 97 * hash + Objects.hashCode(this.__four_average_num);
		hash = 97 * hash + Objects.hashCode(this.__five_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__five_after_num);
		hash = 97 * hash + Objects.hashCode(this.__five_average_num);
		hash = 97 * hash + Objects.hashCode(this.__six_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__six_after_num);
		hash = 97 * hash + Objects.hashCode(this.__six_average_num);
		hash = 97 * hash + Objects.hashCode(this.__seven_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__seven_after_num);
		hash = 97 * hash + Objects.hashCode(this.__seven_average_num);
		hash = 97 * hash + Objects.hashCode(this.__eight_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__eight_after_num);
		hash = 97 * hash + Objects.hashCode(this.__eight_average_num);
		hash = 97 * hash + Objects.hashCode(this.__nine_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__nine_after_num);
		hash = 97 * hash + Objects.hashCode(this.__nine_average_num);
		hash = 97 * hash + Objects.hashCode(this.__ten_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__ten_after_num);
		hash = 97 * hash + Objects.hashCode(this.__ten_average_num);
		hash = 97 * hash + Objects.hashCode(this.__eleven_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__eleven_after_num);
		hash = 97 * hash + Objects.hashCode(this.__eleven_average_num);
		hash = 97 * hash + Objects.hashCode(this.__twelf_befor_num);
		hash = 97 * hash + Objects.hashCode(this.__twelf_after_num);
		hash = 97 * hash + Objects.hashCode(this.__twelf_average_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOnEmployeeNumTotal o = (BaseReportOnEmployeeNumTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__one_befor_num, o.getOneBeforNum())) return false;
		if(!Objects.equals(this.__one_after_num, o.getOneAfterNum())) return false;
		if(!Objects.equals(this.__one_average_num, o.getOneAverageNum())) return false;
		if(!Objects.equals(this.__two_befor_num, o.getTwoBeforNum())) return false;
		if(!Objects.equals(this.__two_after_num, o.getTwoAfterNum())) return false;
		if(!Objects.equals(this.__two_average_num, o.getTwoAverageNum())) return false;
		if(!Objects.equals(this.__three_befor_num, o.getThreeBeforNum())) return false;
		if(!Objects.equals(this.__three_after_num, o.getThreeAfterNum())) return false;
		if(!Objects.equals(this.__three_average_num, o.getThreeAverageNum())) return false;
		if(!Objects.equals(this.__four_befor_num, o.getFourBeforNum())) return false;
		if(!Objects.equals(this.__four_after_num, o.getFourAfterNum())) return false;
		if(!Objects.equals(this.__four_average_num, o.getFourAverageNum())) return false;
		if(!Objects.equals(this.__five_befor_num, o.getFiveBeforNum())) return false;
		if(!Objects.equals(this.__five_after_num, o.getFiveAfterNum())) return false;
		if(!Objects.equals(this.__five_average_num, o.getFiveAverageNum())) return false;
		if(!Objects.equals(this.__six_befor_num, o.getSixBeforNum())) return false;
		if(!Objects.equals(this.__six_after_num, o.getSixAfterNum())) return false;
		if(!Objects.equals(this.__six_average_num, o.getSixAverageNum())) return false;
		if(!Objects.equals(this.__seven_befor_num, o.getSevenBeforNum())) return false;
		if(!Objects.equals(this.__seven_after_num, o.getSevenAfterNum())) return false;
		if(!Objects.equals(this.__seven_average_num, o.getSevenAverageNum())) return false;
		if(!Objects.equals(this.__eight_befor_num, o.getEightBeforNum())) return false;
		if(!Objects.equals(this.__eight_after_num, o.getEightAfterNum())) return false;
		if(!Objects.equals(this.__eight_average_num, o.getEightAverageNum())) return false;
		if(!Objects.equals(this.__nine_befor_num, o.getNineBeforNum())) return false;
		if(!Objects.equals(this.__nine_after_num, o.getNineAfterNum())) return false;
		if(!Objects.equals(this.__nine_average_num, o.getNineAverageNum())) return false;
		if(!Objects.equals(this.__ten_befor_num, o.getTenBeforNum())) return false;
		if(!Objects.equals(this.__ten_after_num, o.getTenAfterNum())) return false;
		if(!Objects.equals(this.__ten_average_num, o.getTenAverageNum())) return false;
		if(!Objects.equals(this.__eleven_befor_num, o.getElevenBeforNum())) return false;
		if(!Objects.equals(this.__eleven_after_num, o.getElevenAfterNum())) return false;
		if(!Objects.equals(this.__eleven_average_num, o.getElevenAverageNum())) return false;
		if(!Objects.equals(this.__twelf_befor_num, o.getTwelfBeforNum())) return false;
		if(!Objects.equals(this.__twelf_after_num, o.getTwelfAfterNum())) return false;
		if(!Objects.equals(this.__twelf_average_num, o.getTwelfAverageNum())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getOneBeforNum() != null) sb.append(__wrapNumber(count++, "oneBeforNum", getOneBeforNum()));
		if(getOneAfterNum() != null) sb.append(__wrapNumber(count++, "oneAfterNum", getOneAfterNum()));
		if(getOneAverageNum() != null) sb.append(__wrapDecimal(count++, "oneAverageNum", getOneAverageNum()));
		if(getTwoBeforNum() != null) sb.append(__wrapNumber(count++, "twoBeforNum", getTwoBeforNum()));
		if(getTwoAfterNum() != null) sb.append(__wrapNumber(count++, "twoAfterNum", getTwoAfterNum()));
		if(getTwoAverageNum() != null) sb.append(__wrapDecimal(count++, "twoAverageNum", getTwoAverageNum()));
		if(getThreeBeforNum() != null) sb.append(__wrapNumber(count++, "threeBeforNum", getThreeBeforNum()));
		if(getThreeAfterNum() != null) sb.append(__wrapNumber(count++, "threeAfterNum", getThreeAfterNum()));
		if(getThreeAverageNum() != null) sb.append(__wrapDecimal(count++, "threeAverageNum", getThreeAverageNum()));
		if(getFourBeforNum() != null) sb.append(__wrapNumber(count++, "fourBeforNum", getFourBeforNum()));
		if(getFourAfterNum() != null) sb.append(__wrapNumber(count++, "fourAfterNum", getFourAfterNum()));
		if(getFourAverageNum() != null) sb.append(__wrapDecimal(count++, "fourAverageNum", getFourAverageNum()));
		if(getFiveBeforNum() != null) sb.append(__wrapNumber(count++, "fiveBeforNum", getFiveBeforNum()));
		if(getFiveAfterNum() != null) sb.append(__wrapNumber(count++, "fiveAfterNum", getFiveAfterNum()));
		if(getFiveAverageNum() != null) sb.append(__wrapDecimal(count++, "fiveAverageNum", getFiveAverageNum()));
		if(getSixBeforNum() != null) sb.append(__wrapNumber(count++, "sixBeforNum", getSixBeforNum()));
		if(getSixAfterNum() != null) sb.append(__wrapNumber(count++, "sixAfterNum", getSixAfterNum()));
		if(getSixAverageNum() != null) sb.append(__wrapDecimal(count++, "sixAverageNum", getSixAverageNum()));
		if(getSevenBeforNum() != null) sb.append(__wrapNumber(count++, "sevenBeforNum", getSevenBeforNum()));
		if(getSevenAfterNum() != null) sb.append(__wrapNumber(count++, "sevenAfterNum", getSevenAfterNum()));
		if(getSevenAverageNum() != null) sb.append(__wrapDecimal(count++, "sevenAverageNum", getSevenAverageNum()));
		if(getEightBeforNum() != null) sb.append(__wrapNumber(count++, "eightBeforNum", getEightBeforNum()));
		if(getEightAfterNum() != null) sb.append(__wrapNumber(count++, "eightAfterNum", getEightAfterNum()));
		if(getEightAverageNum() != null) sb.append(__wrapDecimal(count++, "eightAverageNum", getEightAverageNum()));
		if(getNineBeforNum() != null) sb.append(__wrapNumber(count++, "nineBeforNum", getNineBeforNum()));
		if(getNineAfterNum() != null) sb.append(__wrapNumber(count++, "nineAfterNum", getNineAfterNum()));
		if(getNineAverageNum() != null) sb.append(__wrapDecimal(count++, "nineAverageNum", getNineAverageNum()));
		if(getTenBeforNum() != null) sb.append(__wrapNumber(count++, "tenBeforNum", getTenBeforNum()));
		if(getTenAfterNum() != null) sb.append(__wrapNumber(count++, "tenAfterNum", getTenAfterNum()));
		if(getTenAverageNum() != null) sb.append(__wrapDecimal(count++, "tenAverageNum", getTenAverageNum()));
		if(getElevenBeforNum() != null) sb.append(__wrapNumber(count++, "elevenBeforNum", getElevenBeforNum()));
		if(getElevenAfterNum() != null) sb.append(__wrapNumber(count++, "elevenAfterNum", getElevenAfterNum()));
		if(getElevenAverageNum() != null) sb.append(__wrapDecimal(count++, "elevenAverageNum", getElevenAverageNum()));
		if(getTwelfBeforNum() != null) sb.append(__wrapNumber(count++, "twelfBeforNum", getTwelfBeforNum()));
		if(getTwelfAfterNum() != null) sb.append(__wrapNumber(count++, "twelfAfterNum", getTwelfAfterNum()));
		if(getTwelfAverageNum() != null) sb.append(__wrapDecimal(count++, "twelfAverageNum", getTwelfAverageNum()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("oneBeforNum")) != null) setOneBeforNum(__getLong(val)); 
		if((val = values.get("oneAfterNum")) != null) setOneAfterNum(__getLong(val)); 
		if((val = values.get("oneAverageNum")) != null) setOneAverageNum(__getDecimal(val));  
		if((val = values.get("twoBeforNum")) != null) setTwoBeforNum(__getLong(val)); 
		if((val = values.get("twoAfterNum")) != null) setTwoAfterNum(__getLong(val)); 
		if((val = values.get("twoAverageNum")) != null) setTwoAverageNum(__getDecimal(val));  
		if((val = values.get("threeBeforNum")) != null) setThreeBeforNum(__getLong(val)); 
		if((val = values.get("threeAfterNum")) != null) setThreeAfterNum(__getLong(val)); 
		if((val = values.get("threeAverageNum")) != null) setThreeAverageNum(__getDecimal(val));  
		if((val = values.get("fourBeforNum")) != null) setFourBeforNum(__getLong(val)); 
		if((val = values.get("fourAfterNum")) != null) setFourAfterNum(__getLong(val)); 
		if((val = values.get("fourAverageNum")) != null) setFourAverageNum(__getDecimal(val));  
		if((val = values.get("fiveBeforNum")) != null) setFiveBeforNum(__getLong(val)); 
		if((val = values.get("fiveAfterNum")) != null) setFiveAfterNum(__getLong(val)); 
		if((val = values.get("fiveAverageNum")) != null) setFiveAverageNum(__getDecimal(val));  
		if((val = values.get("sixBeforNum")) != null) setSixBeforNum(__getLong(val)); 
		if((val = values.get("sixAfterNum")) != null) setSixAfterNum(__getLong(val)); 
		if((val = values.get("sixAverageNum")) != null) setSixAverageNum(__getDecimal(val));  
		if((val = values.get("sevenBeforNum")) != null) setSevenBeforNum(__getLong(val)); 
		if((val = values.get("sevenAfterNum")) != null) setSevenAfterNum(__getLong(val)); 
		if((val = values.get("sevenAverageNum")) != null) setSevenAverageNum(__getDecimal(val));  
		if((val = values.get("eightBeforNum")) != null) setEightBeforNum(__getLong(val)); 
		if((val = values.get("eightAfterNum")) != null) setEightAfterNum(__getLong(val)); 
		if((val = values.get("eightAverageNum")) != null) setEightAverageNum(__getDecimal(val));  
		if((val = values.get("nineBeforNum")) != null) setNineBeforNum(__getLong(val)); 
		if((val = values.get("nineAfterNum")) != null) setNineAfterNum(__getLong(val)); 
		if((val = values.get("nineAverageNum")) != null) setNineAverageNum(__getDecimal(val));  
		if((val = values.get("tenBeforNum")) != null) setTenBeforNum(__getLong(val)); 
		if((val = values.get("tenAfterNum")) != null) setTenAfterNum(__getLong(val)); 
		if((val = values.get("tenAverageNum")) != null) setTenAverageNum(__getDecimal(val));  
		if((val = values.get("elevenBeforNum")) != null) setElevenBeforNum(__getLong(val)); 
		if((val = values.get("elevenAfterNum")) != null) setElevenAfterNum(__getLong(val)); 
		if((val = values.get("elevenAverageNum")) != null) setElevenAverageNum(__getDecimal(val));  
		if((val = values.get("twelfBeforNum")) != null) setTwelfBeforNum(__getLong(val)); 
		if((val = values.get("twelfAfterNum")) != null) setTwelfAfterNum(__getLong(val)); 
		if((val = values.get("twelfAverageNum")) != null) setTwelfAverageNum(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Long  __one_befor_num ;
	protected java.lang.Long  __one_after_num ;
	protected java.math.BigDecimal  __one_average_num ;
	protected java.lang.Long  __two_befor_num ;
	protected java.lang.Long  __two_after_num ;
	protected java.math.BigDecimal  __two_average_num ;
	protected java.lang.Long  __three_befor_num ;
	protected java.lang.Long  __three_after_num ;
	protected java.math.BigDecimal  __three_average_num ;
	protected java.lang.Long  __four_befor_num ;
	protected java.lang.Long  __four_after_num ;
	protected java.math.BigDecimal  __four_average_num ;
	protected java.lang.Long  __five_befor_num ;
	protected java.lang.Long  __five_after_num ;
	protected java.math.BigDecimal  __five_average_num ;
	protected java.lang.Long  __six_befor_num ;
	protected java.lang.Long  __six_after_num ;
	protected java.math.BigDecimal  __six_average_num ;
	protected java.lang.Long  __seven_befor_num ;
	protected java.lang.Long  __seven_after_num ;
	protected java.math.BigDecimal  __seven_average_num ;
	protected java.lang.Long  __eight_befor_num ;
	protected java.lang.Long  __eight_after_num ;
	protected java.math.BigDecimal  __eight_average_num ;
	protected java.lang.Long  __nine_befor_num ;
	protected java.lang.Long  __nine_after_num ;
	protected java.math.BigDecimal  __nine_average_num ;
	protected java.lang.Long  __ten_befor_num ;
	protected java.lang.Long  __ten_after_num ;
	protected java.math.BigDecimal  __ten_average_num ;
	protected java.lang.Long  __eleven_befor_num ;
	protected java.lang.Long  __eleven_after_num ;
	protected java.math.BigDecimal  __eleven_average_num ;
	protected java.lang.Long  __twelf_befor_num ;
	protected java.lang.Long  __twelf_after_num ;
	protected java.math.BigDecimal  __twelf_average_num ;
}
