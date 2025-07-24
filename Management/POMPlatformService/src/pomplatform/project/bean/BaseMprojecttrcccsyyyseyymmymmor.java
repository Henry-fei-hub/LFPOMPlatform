package pomplatform.project.bean;

import java.util.Map;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseMprojecttrcccsyyyseyymmymmor extends GenericBase implements BaseFactory<BaseMprojecttrcccsyyyseyymmymmor>, Comparable<BaseMprojecttrcccsyyyseyymmymmor> 
{


	public static BaseMprojecttrcccsyyyseyymmymmor newInstance(){
		return new BaseMprojecttrcccsyyyseyymmymmor();
	}

	@Override
	public BaseMprojecttrcccsyyyseyymmymmor make(){
		BaseMprojecttrcccsyyyseyymmymmor b = new BaseMprojecttrcccsyyyseyymmymmor();
		return b;
	}

	public final static java.lang.String CS_BUSINESS_LINE = "business_line" ;
	public final static java.lang.String CS_SUM_SHEET_AMOUNT = "sum_sheet_amount" ;
	public final static java.lang.String CS_SUM_CURRENT_REVENUE = "sum_current_revenue" ;
	public final static java.lang.String CS_SUM_CURRENT_REVENUE_PROPORTION = "sum_current_revenue_proportion" ;
	public final static java.lang.String CS_TARGET_TYPE_1 = "target_type_1" ;
	public final static java.lang.String CS_TARGET_STR_TYPE_1 = "target_str_type_1" ;
	public final static java.lang.String CS_TARGET_TYPE_1_PROPORTION = "target_type_1_proportion" ;
	public final static java.lang.String CS_RANK_1 = "rank_1" ;
	public final static java.lang.String CS_PERCENTAGE_COMPLETE_1 = "percentage_complete_1" ;
	public final static java.lang.String CS_SUM_DISTRIBUTION_AMOUNT = "sum_distribution_amount" ;
	public final static java.lang.String CS_TARGET_TYPE_2 = "target_type_2" ;
	public final static java.lang.String CS_TARGET_STR_TYPE_2 = "target_str_type_2" ;
	public final static java.lang.String CS_RANK_2 = "rank_2" ;
	public final static java.lang.String CS_PERCENTAGE_COMPLETE_2 = "percentage_complete_2" ;
	public final static java.lang.String CS_BACK_1 = "back_1" ;
	public final static java.lang.String CS_BACK_2 = "back_2" ;
	public final static java.lang.String CS_BACK_3 = "back_3" ;

	public final static java.lang.String ALL_CAPTIONS = "业务条线,,,,,,,,,,,,,,,,";

	public java.lang.Integer getBusinessLine() {
		return this.__business_line;
	}

	public void setBusinessLine( java.lang.Integer value ) {
		this.__business_line = value;
	}

	public java.math.BigDecimal getSumSheetAmount() {
		return this.__sum_sheet_amount;
	}

	public void setSumSheetAmount( java.math.BigDecimal value ) {
		this.__sum_sheet_amount = value;
	}

	public java.math.BigDecimal getSumCurrentRevenue() {
		return this.__sum_current_revenue;
	}

	public void setSumCurrentRevenue( java.math.BigDecimal value ) {
		this.__sum_current_revenue = value;
	}

	public java.lang.String getSumCurrentRevenueProportion() {
		return this.__sum_current_revenue_proportion;
	}

	public void setSumCurrentRevenueProportion( java.lang.String value ) {
		this.__sum_current_revenue_proportion = value;
	}

	public java.math.BigDecimal getTargetType1() {
		return this.__target_type_1;
	}

	public void setTargetType1( java.math.BigDecimal value ) {
		this.__target_type_1 = value;
	}

	public java.lang.String getTargetStrType1() {
		return this.__target_str_type_1;
	}

	public void setTargetStrType1( java.lang.String value ) {
		this.__target_str_type_1 = value;
	}

	public java.lang.String getTargetType1Proportion() {
		return this.__target_type_1_proportion;
	}

	public void setTargetType1Proportion( java.lang.String value ) {
		this.__target_type_1_proportion = value;
	}

	public java.lang.Integer getRank1() {
		return this.__rank_1;
	}

	public void setRank1( java.lang.Integer value ) {
		this.__rank_1 = value;
	}

	public java.lang.String getPercentageComplete1() {
		return this.__percentage_complete_1;
	}

	public void setPercentageComplete1( java.lang.String value ) {
		this.__percentage_complete_1 = value;
	}

	public java.math.BigDecimal getSumDistributionAmount() {
		return this.__sum_distribution_amount;
	}

	public void setSumDistributionAmount( java.math.BigDecimal value ) {
		this.__sum_distribution_amount = value;
	}

	public java.math.BigDecimal getTargetType2() {
		return this.__target_type_2;
	}

	public void setTargetType2( java.math.BigDecimal value ) {
		this.__target_type_2 = value;
	}

	public java.lang.String getTargetStrType2() {
		return this.__target_str_type_2;
	}

	public void setTargetStrType2( java.lang.String value ) {
		this.__target_str_type_2 = value;
	}

	public java.lang.Integer getRank2() {
		return this.__rank_2;
	}

	public void setRank2( java.lang.Integer value ) {
		this.__rank_2 = value;
	}

	public java.lang.String getPercentageComplete2() {
		return this.__percentage_complete_2;
	}

	public void setPercentageComplete2( java.lang.String value ) {
		this.__percentage_complete_2 = value;
	}

	public java.lang.String getBack1() {
		return this.__back_1;
	}

	public void setBack1( java.lang.String value ) {
		this.__back_1 = value;
	}

	public java.lang.String getBack2() {
		return this.__back_2;
	}

	public void setBack2( java.lang.String value ) {
		this.__back_2 = value;
	}

	public java.lang.String getBack3() {
		return this.__back_3;
	}

	public void setBack3( java.lang.String value ) {
		this.__back_3 = value;
	}

	public void cloneCopy(BaseMprojecttrcccsyyyseyymmymmor __bean){
		__bean.setBusinessLine(getBusinessLine());
		__bean.setSumSheetAmount(getSumSheetAmount());
		__bean.setSumCurrentRevenue(getSumCurrentRevenue());
		__bean.setSumCurrentRevenueProportion(getSumCurrentRevenueProportion());
		__bean.setTargetType1(getTargetType1());
		__bean.setTargetStrType1(getTargetStrType1());
		__bean.setTargetType1Proportion(getTargetType1Proportion());
		__bean.setRank1(getRank1());
		__bean.setPercentageComplete1(getPercentageComplete1());
		__bean.setSumDistributionAmount(getSumDistributionAmount());
		__bean.setTargetType2(getTargetType2());
		__bean.setTargetStrType2(getTargetStrType2());
		__bean.setRank2(getRank2());
		__bean.setPercentageComplete2(getPercentageComplete2());
		__bean.setBack1(getBack1());
		__bean.setBack2(getBack2());
		__bean.setBack3(getBack3());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getBusinessLine() == null ? "" : getBusinessLine());
		sb.append(",");
		sb.append(getSumSheetAmount() == null ? "" : getSumSheetAmount());
		sb.append(",");
		sb.append(getSumCurrentRevenue() == null ? "" : getSumCurrentRevenue());
		sb.append(",");
		sb.append(getSumCurrentRevenueProportion() == null ? "" : getSumCurrentRevenueProportion());
		sb.append(",");
		sb.append(getTargetType1() == null ? "" : getTargetType1());
		sb.append(",");
		sb.append(getTargetStrType1() == null ? "" : getTargetStrType1());
		sb.append(",");
		sb.append(getTargetType1Proportion() == null ? "" : getTargetType1Proportion());
		sb.append(",");
		sb.append(getRank1() == null ? "" : getRank1());
		sb.append(",");
		sb.append(getPercentageComplete1() == null ? "" : getPercentageComplete1());
		sb.append(",");
		sb.append(getSumDistributionAmount() == null ? "" : getSumDistributionAmount());
		sb.append(",");
		sb.append(getTargetType2() == null ? "" : getTargetType2());
		sb.append(",");
		sb.append(getTargetStrType2() == null ? "" : getTargetStrType2());
		sb.append(",");
		sb.append(getRank2() == null ? "" : getRank2());
		sb.append(",");
		sb.append(getPercentageComplete2() == null ? "" : getPercentageComplete2());
		sb.append(",");
		sb.append(getBack1() == null ? "" : getBack1());
		sb.append(",");
		sb.append(getBack2() == null ? "" : getBack2());
		sb.append(",");
		sb.append(getBack3() == null ? "" : getBack3());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseMprojecttrcccsyyyseyymmymmor o) {
		return __business_line == null ? -1 : __business_line.compareTo(o.getBusinessLine());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__business_line);
		hash = 97 * hash + Objects.hashCode(this.__sum_sheet_amount);
		hash = 97 * hash + Objects.hashCode(this.__sum_current_revenue);
		hash = 97 * hash + Objects.hashCode(this.__sum_current_revenue_proportion);
		hash = 97 * hash + Objects.hashCode(this.__target_type_1);
		hash = 97 * hash + Objects.hashCode(this.__target_str_type_1);
		hash = 97 * hash + Objects.hashCode(this.__target_type_1_proportion);
		hash = 97 * hash + Objects.hashCode(this.__rank_1);
		hash = 97 * hash + Objects.hashCode(this.__percentage_complete_1);
		hash = 97 * hash + Objects.hashCode(this.__sum_distribution_amount);
		hash = 97 * hash + Objects.hashCode(this.__target_type_2);
		hash = 97 * hash + Objects.hashCode(this.__target_str_type_2);
		hash = 97 * hash + Objects.hashCode(this.__rank_2);
		hash = 97 * hash + Objects.hashCode(this.__percentage_complete_2);
		hash = 97 * hash + Objects.hashCode(this.__back_1);
		hash = 97 * hash + Objects.hashCode(this.__back_2);
		hash = 97 * hash + Objects.hashCode(this.__back_3);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseMprojecttrcccsyyyseyymmymmor o = (BaseMprojecttrcccsyyyseyymmymmor)obj;
		if(!Objects.equals(this.__business_line, o.getBusinessLine())) return false;
		if(!Objects.equals(this.__sum_sheet_amount, o.getSumSheetAmount())) return false;
		if(!Objects.equals(this.__sum_current_revenue, o.getSumCurrentRevenue())) return false;
		if(!Objects.equals(this.__sum_current_revenue_proportion, o.getSumCurrentRevenueProportion())) return false;
		if(!Objects.equals(this.__target_type_1, o.getTargetType1())) return false;
		if(!Objects.equals(this.__target_str_type_1, o.getTargetStrType1())) return false;
		if(!Objects.equals(this.__target_type_1_proportion, o.getTargetType1Proportion())) return false;
		if(!Objects.equals(this.__rank_1, o.getRank1())) return false;
		if(!Objects.equals(this.__percentage_complete_1, o.getPercentageComplete1())) return false;
		if(!Objects.equals(this.__sum_distribution_amount, o.getSumDistributionAmount())) return false;
		if(!Objects.equals(this.__target_type_2, o.getTargetType2())) return false;
		if(!Objects.equals(this.__target_str_type_2, o.getTargetStrType2())) return false;
		if(!Objects.equals(this.__rank_2, o.getRank2())) return false;
		if(!Objects.equals(this.__percentage_complete_2, o.getPercentageComplete2())) return false;
		if(!Objects.equals(this.__back_1, o.getBack1())) return false;
		if(!Objects.equals(this.__back_2, o.getBack2())) return false;
		if(!Objects.equals(this.__back_3, o.getBack3())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getBusinessLine() != null) sb.append(__wrapNumber(count++, "businessLine", getBusinessLine()));
		if(getSumSheetAmount() != null) sb.append(__wrapDecimal(count++, "sumSheetAmount", getSumSheetAmount()));
		if(getSumCurrentRevenue() != null) sb.append(__wrapDecimal(count++, "sumCurrentRevenue", getSumCurrentRevenue()));
		if(getSumCurrentRevenueProportion() != null) sb.append(__wrapString(count++, "sumCurrentRevenueProportion", getSumCurrentRevenueProportion()));
		if(getTargetType1() != null) sb.append(__wrapDecimal(count++, "targetType1", getTargetType1()));
		if(getTargetStrType1() != null) sb.append(__wrapString(count++, "targetStrType1", getTargetStrType1()));
		if(getTargetType1Proportion() != null) sb.append(__wrapString(count++, "targetType1Proportion", getTargetType1Proportion()));
		if(getRank1() != null) sb.append(__wrapNumber(count++, "rank1", getRank1()));
		if(getPercentageComplete1() != null) sb.append(__wrapString(count++, "percentageComplete1", getPercentageComplete1()));
		if(getSumDistributionAmount() != null) sb.append(__wrapDecimal(count++, "sumDistributionAmount", getSumDistributionAmount()));
		if(getTargetType2() != null) sb.append(__wrapDecimal(count++, "targetType2", getTargetType2()));
		if(getTargetStrType2() != null) sb.append(__wrapString(count++, "targetStrType2", getTargetStrType2()));
		if(getRank2() != null) sb.append(__wrapNumber(count++, "rank2", getRank2()));
		if(getPercentageComplete2() != null) sb.append(__wrapString(count++, "percentageComplete2", getPercentageComplete2()));
		if(getBack1() != null) sb.append(__wrapString(count++, "back1", getBack1()));
		if(getBack2() != null) sb.append(__wrapString(count++, "back2", getBack2()));
		if(getBack3() != null) sb.append(__wrapString(count++, "back3", getBack3()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("businessLine")) != null) setBusinessLine(__getInt(val)); 
		if((val = values.get("sumSheetAmount")) != null) setSumSheetAmount(__getDecimal(val));  
		if((val = values.get("sumCurrentRevenue")) != null) setSumCurrentRevenue(__getDecimal(val));  
		if((val = values.get("sumCurrentRevenueProportion")) != null) setSumCurrentRevenueProportion(__getString(val));
		if((val = values.get("targetType1")) != null) setTargetType1(__getDecimal(val));  
		if((val = values.get("targetStrType1")) != null) setTargetStrType1(__getString(val));
		if((val = values.get("targetType1Proportion")) != null) setTargetType1Proportion(__getString(val));
		if((val = values.get("rank1")) != null) setRank1(__getInt(val)); 
		if((val = values.get("percentageComplete1")) != null) setPercentageComplete1(__getString(val));
		if((val = values.get("sumDistributionAmount")) != null) setSumDistributionAmount(__getDecimal(val));  
		if((val = values.get("targetType2")) != null) setTargetType2(__getDecimal(val));  
		if((val = values.get("targetStrType2")) != null) setTargetStrType2(__getString(val));
		if((val = values.get("rank2")) != null) setRank2(__getInt(val)); 
		if((val = values.get("percentageComplete2")) != null) setPercentageComplete2(__getString(val));
		if((val = values.get("back1")) != null) setBack1(__getString(val));
		if((val = values.get("back2")) != null) setBack2(__getString(val));
		if((val = values.get("back3")) != null) setBack3(__getString(val));
	}

	protected java.lang.Integer  __business_line ;
	protected java.math.BigDecimal  __sum_sheet_amount ;
	protected java.math.BigDecimal  __sum_current_revenue ;
	protected java.lang.String  __sum_current_revenue_proportion ;
	protected java.math.BigDecimal  __target_type_1 ;
	protected java.lang.String  __target_str_type_1 ;
	protected java.lang.String  __target_type_1_proportion ;
	protected java.lang.Integer  __rank_1 ;
	protected java.lang.String  __percentage_complete_1 ;
	protected java.math.BigDecimal  __sum_distribution_amount ;
	protected java.math.BigDecimal  __target_type_2 ;
	protected java.lang.String  __target_str_type_2 ;
	protected java.lang.Integer  __rank_2 ;
	protected java.lang.String  __percentage_complete_2 ;
	protected java.lang.String  __back_1 ;
	protected java.lang.String  __back_2 ;
	protected java.lang.String  __back_3 ;
}
