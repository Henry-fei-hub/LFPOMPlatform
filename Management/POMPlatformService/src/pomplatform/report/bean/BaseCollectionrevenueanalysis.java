package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseCollectionrevenueanalysis extends GenericBase implements BaseFactory<BaseCollectionrevenueanalysis>, Comparable<BaseCollectionrevenueanalysis> 
{


	public static BaseCollectionrevenueanalysis newInstance(){
		return new BaseCollectionrevenueanalysis();
	}

	@Override
	public BaseCollectionrevenueanalysis make(){
		BaseCollectionrevenueanalysis b = new BaseCollectionrevenueanalysis();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_JANUARY_REVENUE = "january_revenue" ;
	public final static java.lang.String CS_FEBRUARY_REVENUE = "february_revenue" ;
	public final static java.lang.String CS_MARCH_REVENUE = "march_revenue" ;
	public final static java.lang.String CS_APRIL_REVENUE = "april_revenue" ;
	public final static java.lang.String CS_MAY_REVENUE = "may_revenue" ;
	public final static java.lang.String CS_JUNE_REVENUE = "june_revenue" ;
	public final static java.lang.String CS_JULY_REVENUE = "july_revenue" ;
	public final static java.lang.String CS_AUGUST_REVENUE = "august_revenue" ;
	public final static java.lang.String CS_SEPTEMBER_REVENUE = "september_revenue" ;
	public final static java.lang.String CS_OCTOBER_REVENUE = "october_revenue" ;
	public final static java.lang.String CS_NOVEMBER_REVENUE = "november_revenue" ;
	public final static java.lang.String CS_DECEMBER_REVENUE = "december_revenue" ;
	public final static java.lang.String CS_TOTAL = "total" ;
	public final static java.lang.String CS_JANUARY_AMOUNT = "january_amount" ;
	public final static java.lang.String CS_FEBRUARY_AMOUNT = "february_amount" ;
	public final static java.lang.String CS_MARCH_AMOUNT = "march_amount" ;
	public final static java.lang.String CS_APRIL_AMOUNT = "april_amount" ;
	public final static java.lang.String CS_MAY_AMOUNT = "may_amount" ;
	public final static java.lang.String CS_JUNE_AMOUNT = "june_amount" ;
	public final static java.lang.String CS_JULY_AMOUNT = "july_amount" ;
	public final static java.lang.String CS_AUGUST_AMOUNT = "august_amount" ;
	public final static java.lang.String CS_SEPTEMBER_AMOUNT = "september_amount" ;
	public final static java.lang.String CS_OCTOBER_AMOUNT = "october_amount" ;
	public final static java.lang.String CS_NOVEMBER_AMOUNT = "november_amount" ;
	public final static java.lang.String CS_DECEMBER_AMOUNT = "december_amount" ;
	public final static java.lang.String CS_TOTAL_AMOUNT = "total_amount" ;
	public final static java.lang.String CS_JANUARY_LEFT = "january_left" ;
	public final static java.lang.String CS_FEBRUARY_LEFT = "february_left" ;
	public final static java.lang.String CS_MARCH_LEFT = "march_left" ;
	public final static java.lang.String CS_APRIL_LEFT = "april_left" ;
	public final static java.lang.String CS_MAY_LEFT = "may_left" ;
	public final static java.lang.String CS_JUNE_LEFT = "june_left" ;
	public final static java.lang.String CS_JULY_LEFT = "july_left" ;
	public final static java.lang.String CS_AUGUST_LEFT = "august_left" ;
	public final static java.lang.String CS_SEPTEMBER_LEFT = "september_left" ;
	public final static java.lang.String CS_OCTOBER_LEFT = "october_left" ;
	public final static java.lang.String CS_NOVEMBER_LEFT = "november_left" ;
	public final static java.lang.String CS_DECEMBER_LEFT = "december_left" ;
	public final static java.lang.String CS_TOTAL_LEFT = "total_left" ;
	public final static java.lang.String CS_STR1 = "str1" ;
	public final static java.lang.String CS_STR2 = "str2" ;
	public final static java.lang.String CS_STR3 = "str3" ;
	public final static java.lang.String CS_STR4 = "str4" ;
	public final static java.lang.String CS_STR5 = "str5" ;
	public final static java.lang.String CS_STR6 = "str6" ;
	public final static java.lang.String CS_STR7 = "str7" ;
	public final static java.lang.String CS_STR8 = "str8" ;
	public final static java.lang.String CS_STR9 = "str9" ;
	public final static java.lang.String CS_STR10 = "str10" ;
	public final static java.lang.String CS_STR11 = "str11" ;
	public final static java.lang.String CS_STR12 = "str12" ;
	public final static java.lang.String CS_STR = "str" ;

	public final static java.lang.String ALL_CAPTIONS = "板块,年份,1月,2月,3月,4月,5月,6月,7月,8月,9月,10月,11月,12月,,,,,,,,,,,,,,项目总金额,,,,,,,,,,,,,,,,,,,,,,,,,,";

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

	public java.math.BigDecimal getJanuaryRevenue() {
		return this.__january_revenue;
	}

	public void setJanuaryRevenue( java.math.BigDecimal value ) {
		this.__january_revenue = value;
	}

	public java.math.BigDecimal getFebruaryRevenue() {
		return this.__february_revenue;
	}

	public void setFebruaryRevenue( java.math.BigDecimal value ) {
		this.__february_revenue = value;
	}

	public java.math.BigDecimal getMarchRevenue() {
		return this.__march_revenue;
	}

	public void setMarchRevenue( java.math.BigDecimal value ) {
		this.__march_revenue = value;
	}

	public java.math.BigDecimal getAprilRevenue() {
		return this.__april_revenue;
	}

	public void setAprilRevenue( java.math.BigDecimal value ) {
		this.__april_revenue = value;
	}

	public java.math.BigDecimal getMayRevenue() {
		return this.__may_revenue;
	}

	public void setMayRevenue( java.math.BigDecimal value ) {
		this.__may_revenue = value;
	}

	public java.math.BigDecimal getJuneRevenue() {
		return this.__june_revenue;
	}

	public void setJuneRevenue( java.math.BigDecimal value ) {
		this.__june_revenue = value;
	}

	public java.math.BigDecimal getJulyRevenue() {
		return this.__july_revenue;
	}

	public void setJulyRevenue( java.math.BigDecimal value ) {
		this.__july_revenue = value;
	}

	public java.math.BigDecimal getAugustRevenue() {
		return this.__august_revenue;
	}

	public void setAugustRevenue( java.math.BigDecimal value ) {
		this.__august_revenue = value;
	}

	public java.math.BigDecimal getSeptemberRevenue() {
		return this.__september_revenue;
	}

	public void setSeptemberRevenue( java.math.BigDecimal value ) {
		this.__september_revenue = value;
	}

	public java.math.BigDecimal getOctoberRevenue() {
		return this.__october_revenue;
	}

	public void setOctoberRevenue( java.math.BigDecimal value ) {
		this.__october_revenue = value;
	}

	public java.math.BigDecimal getNovemberRevenue() {
		return this.__november_revenue;
	}

	public void setNovemberRevenue( java.math.BigDecimal value ) {
		this.__november_revenue = value;
	}

	public java.math.BigDecimal getDecemberRevenue() {
		return this.__december_revenue;
	}

	public void setDecemberRevenue( java.math.BigDecimal value ) {
		this.__december_revenue = value;
	}

	public java.math.BigDecimal getTotal() {
		return this.__total;
	}

	public void setTotal( java.math.BigDecimal value ) {
		this.__total = value;
	}

	public java.math.BigDecimal getJanuaryAmount() {
		return this.__january_amount;
	}

	public void setJanuaryAmount( java.math.BigDecimal value ) {
		this.__january_amount = value;
	}

	public java.math.BigDecimal getFebruaryAmount() {
		return this.__february_amount;
	}

	public void setFebruaryAmount( java.math.BigDecimal value ) {
		this.__february_amount = value;
	}

	public java.math.BigDecimal getMarchAmount() {
		return this.__march_amount;
	}

	public void setMarchAmount( java.math.BigDecimal value ) {
		this.__march_amount = value;
	}

	public java.math.BigDecimal getAprilAmount() {
		return this.__april_amount;
	}

	public void setAprilAmount( java.math.BigDecimal value ) {
		this.__april_amount = value;
	}

	public java.math.BigDecimal getMayAmount() {
		return this.__may_amount;
	}

	public void setMayAmount( java.math.BigDecimal value ) {
		this.__may_amount = value;
	}

	public java.math.BigDecimal getJuneAmount() {
		return this.__june_amount;
	}

	public void setJuneAmount( java.math.BigDecimal value ) {
		this.__june_amount = value;
	}

	public java.math.BigDecimal getJulyAmount() {
		return this.__july_amount;
	}

	public void setJulyAmount( java.math.BigDecimal value ) {
		this.__july_amount = value;
	}

	public java.math.BigDecimal getAugustAmount() {
		return this.__august_amount;
	}

	public void setAugustAmount( java.math.BigDecimal value ) {
		this.__august_amount = value;
	}

	public java.math.BigDecimal getSeptemberAmount() {
		return this.__september_amount;
	}

	public void setSeptemberAmount( java.math.BigDecimal value ) {
		this.__september_amount = value;
	}

	public java.math.BigDecimal getOctoberAmount() {
		return this.__october_amount;
	}

	public void setOctoberAmount( java.math.BigDecimal value ) {
		this.__october_amount = value;
	}

	public java.math.BigDecimal getNovemberAmount() {
		return this.__november_amount;
	}

	public void setNovemberAmount( java.math.BigDecimal value ) {
		this.__november_amount = value;
	}

	public java.math.BigDecimal getDecemberAmount() {
		return this.__december_amount;
	}

	public void setDecemberAmount( java.math.BigDecimal value ) {
		this.__december_amount = value;
	}

	public java.math.BigDecimal getTotalAmount() {
		return this.__total_amount;
	}

	public void setTotalAmount( java.math.BigDecimal value ) {
		this.__total_amount = value;
	}

	public java.math.BigDecimal getJanuaryLeft() {
		return this.__january_left;
	}

	public void setJanuaryLeft( java.math.BigDecimal value ) {
		this.__january_left = value;
	}

	public java.math.BigDecimal getFebruaryLeft() {
		return this.__february_left;
	}

	public void setFebruaryLeft( java.math.BigDecimal value ) {
		this.__february_left = value;
	}

	public java.math.BigDecimal getMarchLeft() {
		return this.__march_left;
	}

	public void setMarchLeft( java.math.BigDecimal value ) {
		this.__march_left = value;
	}

	public java.math.BigDecimal getAprilLeft() {
		return this.__april_left;
	}

	public void setAprilLeft( java.math.BigDecimal value ) {
		this.__april_left = value;
	}

	public java.math.BigDecimal getMayLeft() {
		return this.__may_left;
	}

	public void setMayLeft( java.math.BigDecimal value ) {
		this.__may_left = value;
	}

	public java.math.BigDecimal getJuneLeft() {
		return this.__june_left;
	}

	public void setJuneLeft( java.math.BigDecimal value ) {
		this.__june_left = value;
	}

	public java.math.BigDecimal getJulyLeft() {
		return this.__july_left;
	}

	public void setJulyLeft( java.math.BigDecimal value ) {
		this.__july_left = value;
	}

	public java.math.BigDecimal getAugustLeft() {
		return this.__august_left;
	}

	public void setAugustLeft( java.math.BigDecimal value ) {
		this.__august_left = value;
	}

	public java.math.BigDecimal getSeptemberLeft() {
		return this.__september_left;
	}

	public void setSeptemberLeft( java.math.BigDecimal value ) {
		this.__september_left = value;
	}

	public java.math.BigDecimal getOctoberLeft() {
		return this.__october_left;
	}

	public void setOctoberLeft( java.math.BigDecimal value ) {
		this.__october_left = value;
	}

	public java.math.BigDecimal getNovemberLeft() {
		return this.__november_left;
	}

	public void setNovemberLeft( java.math.BigDecimal value ) {
		this.__november_left = value;
	}

	public java.math.BigDecimal getDecemberLeft() {
		return this.__december_left;
	}

	public void setDecemberLeft( java.math.BigDecimal value ) {
		this.__december_left = value;
	}

	public java.math.BigDecimal getTotalLeft() {
		return this.__total_left;
	}

	public void setTotalLeft( java.math.BigDecimal value ) {
		this.__total_left = value;
	}

	public java.lang.String getStr1() {
		return this.__str1;
	}

	public void setStr1( java.lang.String value ) {
		this.__str1 = value;
	}

	public java.lang.String getStr2() {
		return this.__str2;
	}

	public void setStr2( java.lang.String value ) {
		this.__str2 = value;
	}

	public java.lang.String getStr3() {
		return this.__str3;
	}

	public void setStr3( java.lang.String value ) {
		this.__str3 = value;
	}

	public java.lang.String getStr4() {
		return this.__str4;
	}

	public void setStr4( java.lang.String value ) {
		this.__str4 = value;
	}

	public java.lang.String getStr5() {
		return this.__str5;
	}

	public void setStr5( java.lang.String value ) {
		this.__str5 = value;
	}

	public java.lang.String getStr6() {
		return this.__str6;
	}

	public void setStr6( java.lang.String value ) {
		this.__str6 = value;
	}

	public java.lang.String getStr7() {
		return this.__str7;
	}

	public void setStr7( java.lang.String value ) {
		this.__str7 = value;
	}

	public java.lang.String getStr8() {
		return this.__str8;
	}

	public void setStr8( java.lang.String value ) {
		this.__str8 = value;
	}

	public java.lang.String getStr9() {
		return this.__str9;
	}

	public void setStr9( java.lang.String value ) {
		this.__str9 = value;
	}

	public java.lang.String getStr10() {
		return this.__str10;
	}

	public void setStr10( java.lang.String value ) {
		this.__str10 = value;
	}

	public java.lang.String getStr11() {
		return this.__str11;
	}

	public void setStr11( java.lang.String value ) {
		this.__str11 = value;
	}

	public java.lang.String getStr12() {
		return this.__str12;
	}

	public void setStr12( java.lang.String value ) {
		this.__str12 = value;
	}

	public java.lang.String getStr() {
		return this.__str;
	}

	public void setStr( java.lang.String value ) {
		this.__str = value;
	}

	public void cloneCopy(BaseCollectionrevenueanalysis __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setJanuaryRevenue(getJanuaryRevenue());
		__bean.setFebruaryRevenue(getFebruaryRevenue());
		__bean.setMarchRevenue(getMarchRevenue());
		__bean.setAprilRevenue(getAprilRevenue());
		__bean.setMayRevenue(getMayRevenue());
		__bean.setJuneRevenue(getJuneRevenue());
		__bean.setJulyRevenue(getJulyRevenue());
		__bean.setAugustRevenue(getAugustRevenue());
		__bean.setSeptemberRevenue(getSeptemberRevenue());
		__bean.setOctoberRevenue(getOctoberRevenue());
		__bean.setNovemberRevenue(getNovemberRevenue());
		__bean.setDecemberRevenue(getDecemberRevenue());
		__bean.setTotal(getTotal());
		__bean.setJanuaryAmount(getJanuaryAmount());
		__bean.setFebruaryAmount(getFebruaryAmount());
		__bean.setMarchAmount(getMarchAmount());
		__bean.setAprilAmount(getAprilAmount());
		__bean.setMayAmount(getMayAmount());
		__bean.setJuneAmount(getJuneAmount());
		__bean.setJulyAmount(getJulyAmount());
		__bean.setAugustAmount(getAugustAmount());
		__bean.setSeptemberAmount(getSeptemberAmount());
		__bean.setOctoberAmount(getOctoberAmount());
		__bean.setNovemberAmount(getNovemberAmount());
		__bean.setDecemberAmount(getDecemberAmount());
		__bean.setTotalAmount(getTotalAmount());
		__bean.setJanuaryLeft(getJanuaryLeft());
		__bean.setFebruaryLeft(getFebruaryLeft());
		__bean.setMarchLeft(getMarchLeft());
		__bean.setAprilLeft(getAprilLeft());
		__bean.setMayLeft(getMayLeft());
		__bean.setJuneLeft(getJuneLeft());
		__bean.setJulyLeft(getJulyLeft());
		__bean.setAugustLeft(getAugustLeft());
		__bean.setSeptemberLeft(getSeptemberLeft());
		__bean.setOctoberLeft(getOctoberLeft());
		__bean.setNovemberLeft(getNovemberLeft());
		__bean.setDecemberLeft(getDecemberLeft());
		__bean.setTotalLeft(getTotalLeft());
		__bean.setStr1(getStr1());
		__bean.setStr2(getStr2());
		__bean.setStr3(getStr3());
		__bean.setStr4(getStr4());
		__bean.setStr5(getStr5());
		__bean.setStr6(getStr6());
		__bean.setStr7(getStr7());
		__bean.setStr8(getStr8());
		__bean.setStr9(getStr9());
		__bean.setStr10(getStr10());
		__bean.setStr11(getStr11());
		__bean.setStr12(getStr12());
		__bean.setStr(getStr());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getJanuaryRevenue() == null ? "" : getJanuaryRevenue());
		sb.append(",");
		sb.append(getFebruaryRevenue() == null ? "" : getFebruaryRevenue());
		sb.append(",");
		sb.append(getMarchRevenue() == null ? "" : getMarchRevenue());
		sb.append(",");
		sb.append(getAprilRevenue() == null ? "" : getAprilRevenue());
		sb.append(",");
		sb.append(getMayRevenue() == null ? "" : getMayRevenue());
		sb.append(",");
		sb.append(getJuneRevenue() == null ? "" : getJuneRevenue());
		sb.append(",");
		sb.append(getJulyRevenue() == null ? "" : getJulyRevenue());
		sb.append(",");
		sb.append(getAugustRevenue() == null ? "" : getAugustRevenue());
		sb.append(",");
		sb.append(getSeptemberRevenue() == null ? "" : getSeptemberRevenue());
		sb.append(",");
		sb.append(getOctoberRevenue() == null ? "" : getOctoberRevenue());
		sb.append(",");
		sb.append(getNovemberRevenue() == null ? "" : getNovemberRevenue());
		sb.append(",");
		sb.append(getDecemberRevenue() == null ? "" : getDecemberRevenue());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		sb.append(",");
		sb.append(getJanuaryAmount() == null ? "" : getJanuaryAmount());
		sb.append(",");
		sb.append(getFebruaryAmount() == null ? "" : getFebruaryAmount());
		sb.append(",");
		sb.append(getMarchAmount() == null ? "" : getMarchAmount());
		sb.append(",");
		sb.append(getAprilAmount() == null ? "" : getAprilAmount());
		sb.append(",");
		sb.append(getMayAmount() == null ? "" : getMayAmount());
		sb.append(",");
		sb.append(getJuneAmount() == null ? "" : getJuneAmount());
		sb.append(",");
		sb.append(getJulyAmount() == null ? "" : getJulyAmount());
		sb.append(",");
		sb.append(getAugustAmount() == null ? "" : getAugustAmount());
		sb.append(",");
		sb.append(getSeptemberAmount() == null ? "" : getSeptemberAmount());
		sb.append(",");
		sb.append(getOctoberAmount() == null ? "" : getOctoberAmount());
		sb.append(",");
		sb.append(getNovemberAmount() == null ? "" : getNovemberAmount());
		sb.append(",");
		sb.append(getDecemberAmount() == null ? "" : getDecemberAmount());
		sb.append(",");
		sb.append(getTotalAmount() == null ? "" : getTotalAmount());
		sb.append(",");
		sb.append(getJanuaryLeft() == null ? "" : getJanuaryLeft());
		sb.append(",");
		sb.append(getFebruaryLeft() == null ? "" : getFebruaryLeft());
		sb.append(",");
		sb.append(getMarchLeft() == null ? "" : getMarchLeft());
		sb.append(",");
		sb.append(getAprilLeft() == null ? "" : getAprilLeft());
		sb.append(",");
		sb.append(getMayLeft() == null ? "" : getMayLeft());
		sb.append(",");
		sb.append(getJuneLeft() == null ? "" : getJuneLeft());
		sb.append(",");
		sb.append(getJulyLeft() == null ? "" : getJulyLeft());
		sb.append(",");
		sb.append(getAugustLeft() == null ? "" : getAugustLeft());
		sb.append(",");
		sb.append(getSeptemberLeft() == null ? "" : getSeptemberLeft());
		sb.append(",");
		sb.append(getOctoberLeft() == null ? "" : getOctoberLeft());
		sb.append(",");
		sb.append(getNovemberLeft() == null ? "" : getNovemberLeft());
		sb.append(",");
		sb.append(getDecemberLeft() == null ? "" : getDecemberLeft());
		sb.append(",");
		sb.append(getTotalLeft() == null ? "" : getTotalLeft());
		sb.append(",");
		sb.append(getStr1() == null ? "" : getStr1());
		sb.append(",");
		sb.append(getStr2() == null ? "" : getStr2());
		sb.append(",");
		sb.append(getStr3() == null ? "" : getStr3());
		sb.append(",");
		sb.append(getStr4() == null ? "" : getStr4());
		sb.append(",");
		sb.append(getStr5() == null ? "" : getStr5());
		sb.append(",");
		sb.append(getStr6() == null ? "" : getStr6());
		sb.append(",");
		sb.append(getStr7() == null ? "" : getStr7());
		sb.append(",");
		sb.append(getStr8() == null ? "" : getStr8());
		sb.append(",");
		sb.append(getStr9() == null ? "" : getStr9());
		sb.append(",");
		sb.append(getStr10() == null ? "" : getStr10());
		sb.append(",");
		sb.append(getStr11() == null ? "" : getStr11());
		sb.append(",");
		sb.append(getStr12() == null ? "" : getStr12());
		sb.append(",");
		sb.append(getStr() == null ? "" : getStr());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseCollectionrevenueanalysis o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__january_revenue);
		hash = 97 * hash + Objects.hashCode(this.__february_revenue);
		hash = 97 * hash + Objects.hashCode(this.__march_revenue);
		hash = 97 * hash + Objects.hashCode(this.__april_revenue);
		hash = 97 * hash + Objects.hashCode(this.__may_revenue);
		hash = 97 * hash + Objects.hashCode(this.__june_revenue);
		hash = 97 * hash + Objects.hashCode(this.__july_revenue);
		hash = 97 * hash + Objects.hashCode(this.__august_revenue);
		hash = 97 * hash + Objects.hashCode(this.__september_revenue);
		hash = 97 * hash + Objects.hashCode(this.__october_revenue);
		hash = 97 * hash + Objects.hashCode(this.__november_revenue);
		hash = 97 * hash + Objects.hashCode(this.__december_revenue);
		hash = 97 * hash + Objects.hashCode(this.__total);
		hash = 97 * hash + Objects.hashCode(this.__january_amount);
		hash = 97 * hash + Objects.hashCode(this.__february_amount);
		hash = 97 * hash + Objects.hashCode(this.__march_amount);
		hash = 97 * hash + Objects.hashCode(this.__april_amount);
		hash = 97 * hash + Objects.hashCode(this.__may_amount);
		hash = 97 * hash + Objects.hashCode(this.__june_amount);
		hash = 97 * hash + Objects.hashCode(this.__july_amount);
		hash = 97 * hash + Objects.hashCode(this.__august_amount);
		hash = 97 * hash + Objects.hashCode(this.__september_amount);
		hash = 97 * hash + Objects.hashCode(this.__october_amount);
		hash = 97 * hash + Objects.hashCode(this.__november_amount);
		hash = 97 * hash + Objects.hashCode(this.__december_amount);
		hash = 97 * hash + Objects.hashCode(this.__total_amount);
		hash = 97 * hash + Objects.hashCode(this.__january_left);
		hash = 97 * hash + Objects.hashCode(this.__february_left);
		hash = 97 * hash + Objects.hashCode(this.__march_left);
		hash = 97 * hash + Objects.hashCode(this.__april_left);
		hash = 97 * hash + Objects.hashCode(this.__may_left);
		hash = 97 * hash + Objects.hashCode(this.__june_left);
		hash = 97 * hash + Objects.hashCode(this.__july_left);
		hash = 97 * hash + Objects.hashCode(this.__august_left);
		hash = 97 * hash + Objects.hashCode(this.__september_left);
		hash = 97 * hash + Objects.hashCode(this.__october_left);
		hash = 97 * hash + Objects.hashCode(this.__november_left);
		hash = 97 * hash + Objects.hashCode(this.__december_left);
		hash = 97 * hash + Objects.hashCode(this.__total_left);
		hash = 97 * hash + Objects.hashCode(this.__str1);
		hash = 97 * hash + Objects.hashCode(this.__str2);
		hash = 97 * hash + Objects.hashCode(this.__str3);
		hash = 97 * hash + Objects.hashCode(this.__str4);
		hash = 97 * hash + Objects.hashCode(this.__str5);
		hash = 97 * hash + Objects.hashCode(this.__str6);
		hash = 97 * hash + Objects.hashCode(this.__str7);
		hash = 97 * hash + Objects.hashCode(this.__str8);
		hash = 97 * hash + Objects.hashCode(this.__str9);
		hash = 97 * hash + Objects.hashCode(this.__str10);
		hash = 97 * hash + Objects.hashCode(this.__str11);
		hash = 97 * hash + Objects.hashCode(this.__str12);
		hash = 97 * hash + Objects.hashCode(this.__str);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseCollectionrevenueanalysis o = (BaseCollectionrevenueanalysis)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__january_revenue, o.getJanuaryRevenue())) return false;
		if(!Objects.equals(this.__february_revenue, o.getFebruaryRevenue())) return false;
		if(!Objects.equals(this.__march_revenue, o.getMarchRevenue())) return false;
		if(!Objects.equals(this.__april_revenue, o.getAprilRevenue())) return false;
		if(!Objects.equals(this.__may_revenue, o.getMayRevenue())) return false;
		if(!Objects.equals(this.__june_revenue, o.getJuneRevenue())) return false;
		if(!Objects.equals(this.__july_revenue, o.getJulyRevenue())) return false;
		if(!Objects.equals(this.__august_revenue, o.getAugustRevenue())) return false;
		if(!Objects.equals(this.__september_revenue, o.getSeptemberRevenue())) return false;
		if(!Objects.equals(this.__october_revenue, o.getOctoberRevenue())) return false;
		if(!Objects.equals(this.__november_revenue, o.getNovemberRevenue())) return false;
		if(!Objects.equals(this.__december_revenue, o.getDecemberRevenue())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		if(!Objects.equals(this.__january_amount, o.getJanuaryAmount())) return false;
		if(!Objects.equals(this.__february_amount, o.getFebruaryAmount())) return false;
		if(!Objects.equals(this.__march_amount, o.getMarchAmount())) return false;
		if(!Objects.equals(this.__april_amount, o.getAprilAmount())) return false;
		if(!Objects.equals(this.__may_amount, o.getMayAmount())) return false;
		if(!Objects.equals(this.__june_amount, o.getJuneAmount())) return false;
		if(!Objects.equals(this.__july_amount, o.getJulyAmount())) return false;
		if(!Objects.equals(this.__august_amount, o.getAugustAmount())) return false;
		if(!Objects.equals(this.__september_amount, o.getSeptemberAmount())) return false;
		if(!Objects.equals(this.__october_amount, o.getOctoberAmount())) return false;
		if(!Objects.equals(this.__november_amount, o.getNovemberAmount())) return false;
		if(!Objects.equals(this.__december_amount, o.getDecemberAmount())) return false;
		if(!Objects.equals(this.__total_amount, o.getTotalAmount())) return false;
		if(!Objects.equals(this.__january_left, o.getJanuaryLeft())) return false;
		if(!Objects.equals(this.__february_left, o.getFebruaryLeft())) return false;
		if(!Objects.equals(this.__march_left, o.getMarchLeft())) return false;
		if(!Objects.equals(this.__april_left, o.getAprilLeft())) return false;
		if(!Objects.equals(this.__may_left, o.getMayLeft())) return false;
		if(!Objects.equals(this.__june_left, o.getJuneLeft())) return false;
		if(!Objects.equals(this.__july_left, o.getJulyLeft())) return false;
		if(!Objects.equals(this.__august_left, o.getAugustLeft())) return false;
		if(!Objects.equals(this.__september_left, o.getSeptemberLeft())) return false;
		if(!Objects.equals(this.__october_left, o.getOctoberLeft())) return false;
		if(!Objects.equals(this.__november_left, o.getNovemberLeft())) return false;
		if(!Objects.equals(this.__december_left, o.getDecemberLeft())) return false;
		if(!Objects.equals(this.__total_left, o.getTotalLeft())) return false;
		if(!Objects.equals(this.__str1, o.getStr1())) return false;
		if(!Objects.equals(this.__str2, o.getStr2())) return false;
		if(!Objects.equals(this.__str3, o.getStr3())) return false;
		if(!Objects.equals(this.__str4, o.getStr4())) return false;
		if(!Objects.equals(this.__str5, o.getStr5())) return false;
		if(!Objects.equals(this.__str6, o.getStr6())) return false;
		if(!Objects.equals(this.__str7, o.getStr7())) return false;
		if(!Objects.equals(this.__str8, o.getStr8())) return false;
		if(!Objects.equals(this.__str9, o.getStr9())) return false;
		if(!Objects.equals(this.__str10, o.getStr10())) return false;
		if(!Objects.equals(this.__str11, o.getStr11())) return false;
		if(!Objects.equals(this.__str12, o.getStr12())) return false;
		if(!Objects.equals(this.__str, o.getStr())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getJanuaryRevenue() != null) sb.append(__wrapDecimal(count++, "januaryRevenue", getJanuaryRevenue()));
		if(getFebruaryRevenue() != null) sb.append(__wrapDecimal(count++, "februaryRevenue", getFebruaryRevenue()));
		if(getMarchRevenue() != null) sb.append(__wrapDecimal(count++, "marchRevenue", getMarchRevenue()));
		if(getAprilRevenue() != null) sb.append(__wrapDecimal(count++, "aprilRevenue", getAprilRevenue()));
		if(getMayRevenue() != null) sb.append(__wrapDecimal(count++, "mayRevenue", getMayRevenue()));
		if(getJuneRevenue() != null) sb.append(__wrapDecimal(count++, "juneRevenue", getJuneRevenue()));
		if(getJulyRevenue() != null) sb.append(__wrapDecimal(count++, "julyRevenue", getJulyRevenue()));
		if(getAugustRevenue() != null) sb.append(__wrapDecimal(count++, "augustRevenue", getAugustRevenue()));
		if(getSeptemberRevenue() != null) sb.append(__wrapDecimal(count++, "septemberRevenue", getSeptemberRevenue()));
		if(getOctoberRevenue() != null) sb.append(__wrapDecimal(count++, "octoberRevenue", getOctoberRevenue()));
		if(getNovemberRevenue() != null) sb.append(__wrapDecimal(count++, "novemberRevenue", getNovemberRevenue()));
		if(getDecemberRevenue() != null) sb.append(__wrapDecimal(count++, "decemberRevenue", getDecemberRevenue()));
		if(getTotal() != null) sb.append(__wrapDecimal(count++, "total", getTotal()));
		if(getJanuaryAmount() != null) sb.append(__wrapDecimal(count++, "januaryAmount", getJanuaryAmount()));
		if(getFebruaryAmount() != null) sb.append(__wrapDecimal(count++, "februaryAmount", getFebruaryAmount()));
		if(getMarchAmount() != null) sb.append(__wrapDecimal(count++, "marchAmount", getMarchAmount()));
		if(getAprilAmount() != null) sb.append(__wrapDecimal(count++, "aprilAmount", getAprilAmount()));
		if(getMayAmount() != null) sb.append(__wrapDecimal(count++, "mayAmount", getMayAmount()));
		if(getJuneAmount() != null) sb.append(__wrapDecimal(count++, "juneAmount", getJuneAmount()));
		if(getJulyAmount() != null) sb.append(__wrapDecimal(count++, "julyAmount", getJulyAmount()));
		if(getAugustAmount() != null) sb.append(__wrapDecimal(count++, "augustAmount", getAugustAmount()));
		if(getSeptemberAmount() != null) sb.append(__wrapDecimal(count++, "septemberAmount", getSeptemberAmount()));
		if(getOctoberAmount() != null) sb.append(__wrapDecimal(count++, "octoberAmount", getOctoberAmount()));
		if(getNovemberAmount() != null) sb.append(__wrapDecimal(count++, "novemberAmount", getNovemberAmount()));
		if(getDecemberAmount() != null) sb.append(__wrapDecimal(count++, "decemberAmount", getDecemberAmount()));
		if(getTotalAmount() != null) sb.append(__wrapDecimal(count++, "totalAmount", getTotalAmount()));
		if(getJanuaryLeft() != null) sb.append(__wrapDecimal(count++, "januaryLeft", getJanuaryLeft()));
		if(getFebruaryLeft() != null) sb.append(__wrapDecimal(count++, "februaryLeft", getFebruaryLeft()));
		if(getMarchLeft() != null) sb.append(__wrapDecimal(count++, "marchLeft", getMarchLeft()));
		if(getAprilLeft() != null) sb.append(__wrapDecimal(count++, "aprilLeft", getAprilLeft()));
		if(getMayLeft() != null) sb.append(__wrapDecimal(count++, "mayLeft", getMayLeft()));
		if(getJuneLeft() != null) sb.append(__wrapDecimal(count++, "juneLeft", getJuneLeft()));
		if(getJulyLeft() != null) sb.append(__wrapDecimal(count++, "julyLeft", getJulyLeft()));
		if(getAugustLeft() != null) sb.append(__wrapDecimal(count++, "augustLeft", getAugustLeft()));
		if(getSeptemberLeft() != null) sb.append(__wrapDecimal(count++, "septemberLeft", getSeptemberLeft()));
		if(getOctoberLeft() != null) sb.append(__wrapDecimal(count++, "octoberLeft", getOctoberLeft()));
		if(getNovemberLeft() != null) sb.append(__wrapDecimal(count++, "novemberLeft", getNovemberLeft()));
		if(getDecemberLeft() != null) sb.append(__wrapDecimal(count++, "decemberLeft", getDecemberLeft()));
		if(getTotalLeft() != null) sb.append(__wrapDecimal(count++, "totalLeft", getTotalLeft()));
		if(getStr1() != null) sb.append(__wrapString(count++, "str1", getStr1()));
		if(getStr2() != null) sb.append(__wrapString(count++, "str2", getStr2()));
		if(getStr3() != null) sb.append(__wrapString(count++, "str3", getStr3()));
		if(getStr4() != null) sb.append(__wrapString(count++, "str4", getStr4()));
		if(getStr5() != null) sb.append(__wrapString(count++, "str5", getStr5()));
		if(getStr6() != null) sb.append(__wrapString(count++, "str6", getStr6()));
		if(getStr7() != null) sb.append(__wrapString(count++, "str7", getStr7()));
		if(getStr8() != null) sb.append(__wrapString(count++, "str8", getStr8()));
		if(getStr9() != null) sb.append(__wrapString(count++, "str9", getStr9()));
		if(getStr10() != null) sb.append(__wrapString(count++, "str10", getStr10()));
		if(getStr11() != null) sb.append(__wrapString(count++, "str11", getStr11()));
		if(getStr12() != null) sb.append(__wrapString(count++, "str12", getStr12()));
		if(getStr() != null) sb.append(__wrapString(count++, "str", getStr()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("januaryRevenue")) != null) setJanuaryRevenue(__getDecimal(val));  
		if((val = values.get("februaryRevenue")) != null) setFebruaryRevenue(__getDecimal(val));  
		if((val = values.get("marchRevenue")) != null) setMarchRevenue(__getDecimal(val));  
		if((val = values.get("aprilRevenue")) != null) setAprilRevenue(__getDecimal(val));  
		if((val = values.get("mayRevenue")) != null) setMayRevenue(__getDecimal(val));  
		if((val = values.get("juneRevenue")) != null) setJuneRevenue(__getDecimal(val));  
		if((val = values.get("julyRevenue")) != null) setJulyRevenue(__getDecimal(val));  
		if((val = values.get("augustRevenue")) != null) setAugustRevenue(__getDecimal(val));  
		if((val = values.get("septemberRevenue")) != null) setSeptemberRevenue(__getDecimal(val));  
		if((val = values.get("octoberRevenue")) != null) setOctoberRevenue(__getDecimal(val));  
		if((val = values.get("novemberRevenue")) != null) setNovemberRevenue(__getDecimal(val));  
		if((val = values.get("decemberRevenue")) != null) setDecemberRevenue(__getDecimal(val));  
		if((val = values.get("total")) != null) setTotal(__getDecimal(val));  
		if((val = values.get("januaryAmount")) != null) setJanuaryAmount(__getDecimal(val));  
		if((val = values.get("februaryAmount")) != null) setFebruaryAmount(__getDecimal(val));  
		if((val = values.get("marchAmount")) != null) setMarchAmount(__getDecimal(val));  
		if((val = values.get("aprilAmount")) != null) setAprilAmount(__getDecimal(val));  
		if((val = values.get("mayAmount")) != null) setMayAmount(__getDecimal(val));  
		if((val = values.get("juneAmount")) != null) setJuneAmount(__getDecimal(val));  
		if((val = values.get("julyAmount")) != null) setJulyAmount(__getDecimal(val));  
		if((val = values.get("augustAmount")) != null) setAugustAmount(__getDecimal(val));  
		if((val = values.get("septemberAmount")) != null) setSeptemberAmount(__getDecimal(val));  
		if((val = values.get("octoberAmount")) != null) setOctoberAmount(__getDecimal(val));  
		if((val = values.get("novemberAmount")) != null) setNovemberAmount(__getDecimal(val));  
		if((val = values.get("decemberAmount")) != null) setDecemberAmount(__getDecimal(val));  
		if((val = values.get("totalAmount")) != null) setTotalAmount(__getDecimal(val));  
		if((val = values.get("januaryLeft")) != null) setJanuaryLeft(__getDecimal(val));  
		if((val = values.get("februaryLeft")) != null) setFebruaryLeft(__getDecimal(val));  
		if((val = values.get("marchLeft")) != null) setMarchLeft(__getDecimal(val));  
		if((val = values.get("aprilLeft")) != null) setAprilLeft(__getDecimal(val));  
		if((val = values.get("mayLeft")) != null) setMayLeft(__getDecimal(val));  
		if((val = values.get("juneLeft")) != null) setJuneLeft(__getDecimal(val));  
		if((val = values.get("julyLeft")) != null) setJulyLeft(__getDecimal(val));  
		if((val = values.get("augustLeft")) != null) setAugustLeft(__getDecimal(val));  
		if((val = values.get("septemberLeft")) != null) setSeptemberLeft(__getDecimal(val));  
		if((val = values.get("octoberLeft")) != null) setOctoberLeft(__getDecimal(val));  
		if((val = values.get("novemberLeft")) != null) setNovemberLeft(__getDecimal(val));  
		if((val = values.get("decemberLeft")) != null) setDecemberLeft(__getDecimal(val));  
		if((val = values.get("totalLeft")) != null) setTotalLeft(__getDecimal(val));  
		if((val = values.get("str1")) != null) setStr1(__getString(val));
		if((val = values.get("str2")) != null) setStr2(__getString(val));
		if((val = values.get("str3")) != null) setStr3(__getString(val));
		if((val = values.get("str4")) != null) setStr4(__getString(val));
		if((val = values.get("str5")) != null) setStr5(__getString(val));
		if((val = values.get("str6")) != null) setStr6(__getString(val));
		if((val = values.get("str7")) != null) setStr7(__getString(val));
		if((val = values.get("str8")) != null) setStr8(__getString(val));
		if((val = values.get("str9")) != null) setStr9(__getString(val));
		if((val = values.get("str10")) != null) setStr10(__getString(val));
		if((val = values.get("str11")) != null) setStr11(__getString(val));
		if((val = values.get("str12")) != null) setStr12(__getString(val));
		if((val = values.get("str")) != null) setStr(__getString(val));
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __january_revenue ;
	protected java.math.BigDecimal  __february_revenue ;
	protected java.math.BigDecimal  __march_revenue ;
	protected java.math.BigDecimal  __april_revenue ;
	protected java.math.BigDecimal  __may_revenue ;
	protected java.math.BigDecimal  __june_revenue ;
	protected java.math.BigDecimal  __july_revenue ;
	protected java.math.BigDecimal  __august_revenue ;
	protected java.math.BigDecimal  __september_revenue ;
	protected java.math.BigDecimal  __october_revenue ;
	protected java.math.BigDecimal  __november_revenue ;
	protected java.math.BigDecimal  __december_revenue ;
	protected java.math.BigDecimal  __total ;
	protected java.math.BigDecimal  __january_amount ;
	protected java.math.BigDecimal  __february_amount ;
	protected java.math.BigDecimal  __march_amount ;
	protected java.math.BigDecimal  __april_amount ;
	protected java.math.BigDecimal  __may_amount ;
	protected java.math.BigDecimal  __june_amount ;
	protected java.math.BigDecimal  __july_amount ;
	protected java.math.BigDecimal  __august_amount ;
	protected java.math.BigDecimal  __september_amount ;
	protected java.math.BigDecimal  __october_amount ;
	protected java.math.BigDecimal  __november_amount ;
	protected java.math.BigDecimal  __december_amount ;
	protected java.math.BigDecimal  __total_amount ;
	protected java.math.BigDecimal  __january_left ;
	protected java.math.BigDecimal  __february_left ;
	protected java.math.BigDecimal  __march_left ;
	protected java.math.BigDecimal  __april_left ;
	protected java.math.BigDecimal  __may_left ;
	protected java.math.BigDecimal  __june_left ;
	protected java.math.BigDecimal  __july_left ;
	protected java.math.BigDecimal  __august_left ;
	protected java.math.BigDecimal  __september_left ;
	protected java.math.BigDecimal  __october_left ;
	protected java.math.BigDecimal  __november_left ;
	protected java.math.BigDecimal  __december_left ;
	protected java.math.BigDecimal  __total_left ;
	protected java.lang.String  __str1 ;
	protected java.lang.String  __str2 ;
	protected java.lang.String  __str3 ;
	protected java.lang.String  __str4 ;
	protected java.lang.String  __str5 ;
	protected java.lang.String  __str6 ;
	protected java.lang.String  __str7 ;
	protected java.lang.String  __str8 ;
	protected java.lang.String  __str9 ;
	protected java.lang.String  __str10 ;
	protected java.lang.String  __str11 ;
	protected java.lang.String  __str12 ;
	protected java.lang.String  __str ;
}
