package pomplatform.report.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseReportYearEmpWorkYears extends GenericBase implements BaseFactory<BaseReportYearEmpWorkYears>, Comparable<BaseReportYearEmpWorkYears> 
{


	public static BaseReportYearEmpWorkYears newInstance(){
		return new BaseReportYearEmpWorkYears();
	}

	@Override
	public BaseReportYearEmpWorkYears make(){
		BaseReportYearEmpWorkYears b = new BaseReportYearEmpWorkYears();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_ONE_INNER = "one_inner" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT = "one_inner_percent" ;
	public final static java.lang.String CS_THREE_INNER = "three_inner" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT = "three_inner_percent" ;
	public final static java.lang.String CS_FIVE_INNER = "five_inner" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT = "five_inner_percent" ;
	public final static java.lang.String CS_TEN_INNER = "ten_inner" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT = "ten_inner_percent" ;
	public final static java.lang.String CS_TEN_ADD = "ten_add" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT = "ten_add_percent" ;
	public final static java.lang.String CS_TOTAL = "total" ;
	public final static java.lang.String CS_ONE_INNER_TWO = "one_inner_two" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_TWO = "one_inner_percent_two" ;
	public final static java.lang.String CS_THREE_INNER_TWO = "three_inner_two" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_TWO = "three_inner_percent_two" ;
	public final static java.lang.String CS_FIVE_INNER_TWO = "five_inner_two" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_TWO = "five_inner_percent_two" ;
	public final static java.lang.String CS_TEN_INNER_TWO = "ten_inner_two" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_TWO = "ten_inner_percent_two" ;
	public final static java.lang.String CS_TEN_ADD_TWO = "ten_add_two" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_TWO = "ten_add_percent_two" ;
	public final static java.lang.String CS_TOTAL_TWO = "total_two" ;
	public final static java.lang.String CS_ONE_INNER_THREE = "one_inner_three" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_THREE = "one_inner_percent_three" ;
	public final static java.lang.String CS_THREE_INNER_THREE = "three_inner_three" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_THREE = "three_inner_percent_three" ;
	public final static java.lang.String CS_FIVE_INNER_THREE = "five_inner_three" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_THREE = "five_inner_percent_three" ;
	public final static java.lang.String CS_TEN_INNER_THREE = "ten_inner_three" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_THREE = "ten_inner_percent_three" ;
	public final static java.lang.String CS_TEN_ADD_THREE = "ten_add_three" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_THREE = "ten_add_percent_three" ;
	public final static java.lang.String CS_TOTAL_THREE = "total_three" ;
	public final static java.lang.String CS_ONE_INNER_FOUR = "one_inner_four" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_FOUR = "one_inner_percent_four" ;
	public final static java.lang.String CS_THREE_INNER_FOUR = "three_inner_four" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_FOUR = "three_inner_percent_four" ;
	public final static java.lang.String CS_FIVE_INNER_FOUR = "five_inner_four" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_FOUR = "five_inner_percent_four" ;
	public final static java.lang.String CS_TEN_INNER_FOUR = "ten_inner_four" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_FOUR = "ten_inner_percent_four" ;
	public final static java.lang.String CS_TEN_ADD_FOUR = "ten_add_four" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_FOUR = "ten_add_percent_four" ;
	public final static java.lang.String CS_TOTAL_FOUR = "total_four" ;
	public final static java.lang.String CS_ONE_INNER_FIVE = "one_inner_five" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_FIVE = "one_inner_percent_five" ;
	public final static java.lang.String CS_THREE_INNER_FIVE = "three_inner_five" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_FIVE = "three_inner_percent_five" ;
	public final static java.lang.String CS_FIVE_INNER_FIVE = "five_inner_five" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_FIVE = "five_inner_percent_five" ;
	public final static java.lang.String CS_TEN_INNER_FIVE = "ten_inner_five" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_FIVE = "ten_inner_percent_five" ;
	public final static java.lang.String CS_TEN_ADD_FIVE = "ten_add_five" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_FIVE = "ten_add_percent_five" ;
	public final static java.lang.String CS_TOTAL_FIVE = "total_five" ;
	public final static java.lang.String CS_ONE_INNER_SIX = "one_inner_six" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_SIX = "one_inner_percent_six" ;
	public final static java.lang.String CS_THREE_INNER_SIX = "three_inner_six" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_SIX = "three_inner_percent_six" ;
	public final static java.lang.String CS_FIVE_INNER_SIX = "five_inner_six" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_SIX = "five_inner_percent_six" ;
	public final static java.lang.String CS_TEN_INNER_SIX = "ten_inner_six" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_SIX = "ten_inner_percent_six" ;
	public final static java.lang.String CS_TEN_ADD_SIX = "ten_add_six" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_SIX = "ten_add_percent_six" ;
	public final static java.lang.String CS_TOTAL_SIX = "total_six" ;
	public final static java.lang.String CS_ONE_INNER_SEVEN = "one_inner_seven" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_SEVEN = "one_inner_percent_seven" ;
	public final static java.lang.String CS_THREE_INNER_SEVEN = "three_inner_seven" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_SEVEN = "three_inner_percent_seven" ;
	public final static java.lang.String CS_FIVE_INNER_SEVEN = "five_inner_seven" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_SEVEN = "five_inner_percent_seven" ;
	public final static java.lang.String CS_TEN_INNER_SEVEN = "ten_inner_seven" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_SEVEN = "ten_inner_percent_seven" ;
	public final static java.lang.String CS_TEN_ADD_SEVEN = "ten_add_seven" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_SEVEN = "ten_add_percent_seven" ;
	public final static java.lang.String CS_TOTAL_SEVEN = "total_seven" ;
	public final static java.lang.String CS_ONE_INNER_EIGHT = "one_inner_eight" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_EIGHT = "one_inner_percent_eight" ;
	public final static java.lang.String CS_THREE_INNER_EIGHT = "three_inner_eight" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_EIGHT = "three_inner_percent_eight" ;
	public final static java.lang.String CS_FIVE_INNER_EIGHT = "five_inner_eight" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_EIGHT = "five_inner_percent_eight" ;
	public final static java.lang.String CS_TEN_INNER_EIGHT = "ten_inner_eight" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_EIGHT = "ten_inner_percent_eight" ;
	public final static java.lang.String CS_TEN_ADD_EIGHT = "ten_add_eight" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_EIGHT = "ten_add_percent_eight" ;
	public final static java.lang.String CS_TOTAL_EIGHT = "total_eight" ;
	public final static java.lang.String CS_ONE_INNER_NINE = "one_inner_nine" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_NINE = "one_inner_percent_nine" ;
	public final static java.lang.String CS_THREE_INNER_NINE = "three_inner_nine" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_NINE = "three_inner_percent_nine" ;
	public final static java.lang.String CS_FIVE_INNER_NINE = "five_inner_nine" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_NINE = "five_inner_percent_nine" ;
	public final static java.lang.String CS_TEN_INNER_NINE = "ten_inner_nine" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_NINE = "ten_inner_percent_nine" ;
	public final static java.lang.String CS_TEN_ADD_NINE = "ten_add_nine" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_NINE = "ten_add_percent_nine" ;
	public final static java.lang.String CS_TOTAL_NINE = "total_nine" ;
	public final static java.lang.String CS_ONE_INNER_TEN = "one_inner_ten" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_TEN = "one_inner_percent_ten" ;
	public final static java.lang.String CS_THREE_INNER_TEN = "three_inner_ten" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_TEN = "three_inner_percent_ten" ;
	public final static java.lang.String CS_FIVE_INNER_TEN = "five_inner_ten" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_TEN = "five_inner_percent_ten" ;
	public final static java.lang.String CS_TEN_INNER_TEN = "ten_inner_ten" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_TEN = "ten_inner_percent_ten" ;
	public final static java.lang.String CS_TEN_ADD_TEN = "ten_add_ten" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_TEN = "ten_add_percent_ten" ;
	public final static java.lang.String CS_TOTAL_TEN = "total_ten" ;
	public final static java.lang.String CS_ONE_INNER_ELEVEN = "one_inner_eleven" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_ELEVEN = "one_inner_percent_eleven" ;
	public final static java.lang.String CS_THREE_INNER_ELEVEN = "three_inner_eleven" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_ELEVEN = "three_inner_percent_eleven" ;
	public final static java.lang.String CS_FIVE_INNER_ELEVEN = "five_inner_eleven" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_ELEVEN = "five_inner_percent_eleven" ;
	public final static java.lang.String CS_TEN_INNER_ELEVEN = "ten_inner_eleven" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_ELEVEN = "ten_inner_percent_eleven" ;
	public final static java.lang.String CS_TEN_ADD_ELEVEN = "ten_add_eleven" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_ELEVEN = "ten_add_percent_eleven" ;
	public final static java.lang.String CS_TOTAL_ELEVEN = "total_eleven" ;
	public final static java.lang.String CS_ONE_INNER_TWELF = "one_inner_twelf" ;
	public final static java.lang.String CS_ONE_INNER_PERCENT_TWELF = "one_inner_percent_twelf" ;
	public final static java.lang.String CS_THREE_INNER_TWELF = "three_inner_twelf" ;
	public final static java.lang.String CS_THREE_INNER_PERCENT_TWELF = "three_inner_percent_twelf" ;
	public final static java.lang.String CS_FIVE_INNER_TWELF = "five_inner_twelf" ;
	public final static java.lang.String CS_FIVE_INNER_PERCENT_TWELF = "five_inner_percent_twelf" ;
	public final static java.lang.String CS_TEN_INNER_TWELF = "ten_inner_twelf" ;
	public final static java.lang.String CS_TEN_INNER_PERCENT_TWELF = "ten_inner_percent_twelf" ;
	public final static java.lang.String CS_TEN_ADD_TWELF = "ten_add_twelf" ;
	public final static java.lang.String CS_TEN_ADD_PERCENT_TWELF = "ten_add_percent_twelf" ;
	public final static java.lang.String CS_TOTAL_TWELF = "total_twelf" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,归属部门,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计,1年以下人数,1年以下占比,1~3年人数,1~3年占比,3~5年人数,3~5年占比,5~10年人数,5~10年占比,10年及以上人数,10年及以上占比,人数合计";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( java.lang.Integer value ) {
		this.__plate_id = value;
	}
	
	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getOneInner() {
		return this.__one_inner;
	}

	public void setOneInner( java.lang.Integer value ) {
		this.__one_inner = value;
	}

	public java.lang.String getOneInnerPercent() {
		return this.__one_inner_percent;
	}

	public void setOneInnerPercent( java.lang.String value ) {
		this.__one_inner_percent = value;
	}

	public java.lang.Integer getThreeInner() {
		return this.__three_inner;
	}

	public void setThreeInner( java.lang.Integer value ) {
		this.__three_inner = value;
	}

	public java.lang.String getThreeInnerPercent() {
		return this.__three_inner_percent;
	}

	public void setThreeInnerPercent( java.lang.String value ) {
		this.__three_inner_percent = value;
	}

	public java.lang.Integer getFiveInner() {
		return this.__five_inner;
	}

	public void setFiveInner( java.lang.Integer value ) {
		this.__five_inner = value;
	}

	public java.lang.String getFiveInnerPercent() {
		return this.__five_inner_percent;
	}

	public void setFiveInnerPercent( java.lang.String value ) {
		this.__five_inner_percent = value;
	}

	public java.lang.Integer getTenInner() {
		return this.__ten_inner;
	}

	public void setTenInner( java.lang.Integer value ) {
		this.__ten_inner = value;
	}

	public java.lang.String getTenInnerPercent() {
		return this.__ten_inner_percent;
	}

	public void setTenInnerPercent( java.lang.String value ) {
		this.__ten_inner_percent = value;
	}

	public java.lang.Integer getTenAdd() {
		return this.__ten_add;
	}

	public void setTenAdd( java.lang.Integer value ) {
		this.__ten_add = value;
	}

	public java.lang.String getTenAddPercent() {
		return this.__ten_add_percent;
	}

	public void setTenAddPercent( java.lang.String value ) {
		this.__ten_add_percent = value;
	}

	public java.lang.Integer getTotal() {
		return this.__total;
	}

	public void setTotal( java.lang.Integer value ) {
		this.__total = value;
	}

	public java.lang.Integer getOneInnerTwo() {
		return this.__one_inner_two;
	}

	public void setOneInnerTwo( java.lang.Integer value ) {
		this.__one_inner_two = value;
	}

	public java.lang.String getOneInnerPercentTwo() {
		return this.__one_inner_percent_two;
	}

	public void setOneInnerPercentTwo( java.lang.String value ) {
		this.__one_inner_percent_two = value;
	}

	public java.lang.Integer getThreeInnerTwo() {
		return this.__three_inner_two;
	}

	public void setThreeInnerTwo( java.lang.Integer value ) {
		this.__three_inner_two = value;
	}

	public java.lang.String getThreeInnerPercentTwo() {
		return this.__three_inner_percent_two;
	}

	public void setThreeInnerPercentTwo( java.lang.String value ) {
		this.__three_inner_percent_two = value;
	}

	public java.lang.Integer getFiveInnerTwo() {
		return this.__five_inner_two;
	}

	public void setFiveInnerTwo( java.lang.Integer value ) {
		this.__five_inner_two = value;
	}

	public java.lang.String getFiveInnerPercentTwo() {
		return this.__five_inner_percent_two;
	}

	public void setFiveInnerPercentTwo( java.lang.String value ) {
		this.__five_inner_percent_two = value;
	}

	public java.lang.Integer getTenInnerTwo() {
		return this.__ten_inner_two;
	}

	public void setTenInnerTwo( java.lang.Integer value ) {
		this.__ten_inner_two = value;
	}

	public java.lang.String getTenInnerPercentTwo() {
		return this.__ten_inner_percent_two;
	}

	public void setTenInnerPercentTwo( java.lang.String value ) {
		this.__ten_inner_percent_two = value;
	}

	public java.lang.Integer getTenAddTwo() {
		return this.__ten_add_two;
	}

	public void setTenAddTwo( java.lang.Integer value ) {
		this.__ten_add_two = value;
	}

	public java.lang.String getTenAddPercentTwo() {
		return this.__ten_add_percent_two;
	}

	public void setTenAddPercentTwo( java.lang.String value ) {
		this.__ten_add_percent_two = value;
	}

	public java.lang.Integer getTotalTwo() {
		return this.__total_two;
	}

	public void setTotalTwo( java.lang.Integer value ) {
		this.__total_two = value;
	}

	public java.lang.Integer getOneInnerThree() {
		return this.__one_inner_three;
	}

	public void setOneInnerThree( java.lang.Integer value ) {
		this.__one_inner_three = value;
	}

	public java.lang.String getOneInnerPercentThree() {
		return this.__one_inner_percent_three;
	}

	public void setOneInnerPercentThree( java.lang.String value ) {
		this.__one_inner_percent_three = value;
	}

	public java.lang.Integer getThreeInnerThree() {
		return this.__three_inner_three;
	}

	public void setThreeInnerThree( java.lang.Integer value ) {
		this.__three_inner_three = value;
	}

	public java.lang.String getThreeInnerPercentThree() {
		return this.__three_inner_percent_three;
	}

	public void setThreeInnerPercentThree( java.lang.String value ) {
		this.__three_inner_percent_three = value;
	}

	public java.lang.Integer getFiveInnerThree() {
		return this.__five_inner_three;
	}

	public void setFiveInnerThree( java.lang.Integer value ) {
		this.__five_inner_three = value;
	}

	public java.lang.String getFiveInnerPercentThree() {
		return this.__five_inner_percent_three;
	}

	public void setFiveInnerPercentThree( java.lang.String value ) {
		this.__five_inner_percent_three = value;
	}

	public java.lang.Integer getTenInnerThree() {
		return this.__ten_inner_three;
	}

	public void setTenInnerThree( java.lang.Integer value ) {
		this.__ten_inner_three = value;
	}

	public java.lang.String getTenInnerPercentThree() {
		return this.__ten_inner_percent_three;
	}

	public void setTenInnerPercentThree( java.lang.String value ) {
		this.__ten_inner_percent_three = value;
	}

	public java.lang.Integer getTenAddThree() {
		return this.__ten_add_three;
	}

	public void setTenAddThree( java.lang.Integer value ) {
		this.__ten_add_three = value;
	}

	public java.lang.String getTenAddPercentThree() {
		return this.__ten_add_percent_three;
	}

	public void setTenAddPercentThree( java.lang.String value ) {
		this.__ten_add_percent_three = value;
	}

	public java.lang.Integer getTotalThree() {
		return this.__total_three;
	}

	public void setTotalThree( java.lang.Integer value ) {
		this.__total_three = value;
	}

	public java.lang.Integer getOneInnerFour() {
		return this.__one_inner_four;
	}

	public void setOneInnerFour( java.lang.Integer value ) {
		this.__one_inner_four = value;
	}

	public java.lang.String getOneInnerPercentFour() {
		return this.__one_inner_percent_four;
	}

	public void setOneInnerPercentFour( java.lang.String value ) {
		this.__one_inner_percent_four = value;
	}

	public java.lang.Integer getThreeInnerFour() {
		return this.__three_inner_four;
	}

	public void setThreeInnerFour( java.lang.Integer value ) {
		this.__three_inner_four = value;
	}

	public java.lang.String getThreeInnerPercentFour() {
		return this.__three_inner_percent_four;
	}

	public void setThreeInnerPercentFour( java.lang.String value ) {
		this.__three_inner_percent_four = value;
	}

	public java.lang.Integer getFiveInnerFour() {
		return this.__five_inner_four;
	}

	public void setFiveInnerFour( java.lang.Integer value ) {
		this.__five_inner_four = value;
	}

	public java.lang.String getFiveInnerPercentFour() {
		return this.__five_inner_percent_four;
	}

	public void setFiveInnerPercentFour( java.lang.String value ) {
		this.__five_inner_percent_four = value;
	}

	public java.lang.Integer getTenInnerFour() {
		return this.__ten_inner_four;
	}

	public void setTenInnerFour( java.lang.Integer value ) {
		this.__ten_inner_four = value;
	}

	public java.lang.String getTenInnerPercentFour() {
		return this.__ten_inner_percent_four;
	}

	public void setTenInnerPercentFour( java.lang.String value ) {
		this.__ten_inner_percent_four = value;
	}

	public java.lang.Integer getTenAddFour() {
		return this.__ten_add_four;
	}

	public void setTenAddFour( java.lang.Integer value ) {
		this.__ten_add_four = value;
	}

	public java.lang.String getTenAddPercentFour() {
		return this.__ten_add_percent_four;
	}

	public void setTenAddPercentFour( java.lang.String value ) {
		this.__ten_add_percent_four = value;
	}

	public java.lang.Integer getTotalFour() {
		return this.__total_four;
	}

	public void setTotalFour( java.lang.Integer value ) {
		this.__total_four = value;
	}

	public java.lang.Integer getOneInnerFive() {
		return this.__one_inner_five;
	}

	public void setOneInnerFive( java.lang.Integer value ) {
		this.__one_inner_five = value;
	}

	public java.lang.String getOneInnerPercentFive() {
		return this.__one_inner_percent_five;
	}

	public void setOneInnerPercentFive( java.lang.String value ) {
		this.__one_inner_percent_five = value;
	}

	public java.lang.Integer getThreeInnerFive() {
		return this.__three_inner_five;
	}

	public void setThreeInnerFive( java.lang.Integer value ) {
		this.__three_inner_five = value;
	}

	public java.lang.String getThreeInnerPercentFive() {
		return this.__three_inner_percent_five;
	}

	public void setThreeInnerPercentFive( java.lang.String value ) {
		this.__three_inner_percent_five = value;
	}

	public java.lang.Integer getFiveInnerFive() {
		return this.__five_inner_five;
	}

	public void setFiveInnerFive( java.lang.Integer value ) {
		this.__five_inner_five = value;
	}

	public java.lang.String getFiveInnerPercentFive() {
		return this.__five_inner_percent_five;
	}

	public void setFiveInnerPercentFive( java.lang.String value ) {
		this.__five_inner_percent_five = value;
	}

	public java.lang.Integer getTenInnerFive() {
		return this.__ten_inner_five;
	}

	public void setTenInnerFive( java.lang.Integer value ) {
		this.__ten_inner_five = value;
	}

	public java.lang.String getTenInnerPercentFive() {
		return this.__ten_inner_percent_five;
	}

	public void setTenInnerPercentFive( java.lang.String value ) {
		this.__ten_inner_percent_five = value;
	}

	public java.lang.Integer getTenAddFive() {
		return this.__ten_add_five;
	}

	public void setTenAddFive( java.lang.Integer value ) {
		this.__ten_add_five = value;
	}

	public java.lang.String getTenAddPercentFive() {
		return this.__ten_add_percent_five;
	}

	public void setTenAddPercentFive( java.lang.String value ) {
		this.__ten_add_percent_five = value;
	}

	public java.lang.Integer getTotalFive() {
		return this.__total_five;
	}

	public void setTotalFive( java.lang.Integer value ) {
		this.__total_five = value;
	}

	public java.lang.Integer getOneInnerSix() {
		return this.__one_inner_six;
	}

	public void setOneInnerSix( java.lang.Integer value ) {
		this.__one_inner_six = value;
	}

	public java.lang.String getOneInnerPercentSix() {
		return this.__one_inner_percent_six;
	}

	public void setOneInnerPercentSix( java.lang.String value ) {
		this.__one_inner_percent_six = value;
	}

	public java.lang.Integer getThreeInnerSix() {
		return this.__three_inner_six;
	}

	public void setThreeInnerSix( java.lang.Integer value ) {
		this.__three_inner_six = value;
	}

	public java.lang.String getThreeInnerPercentSix() {
		return this.__three_inner_percent_six;
	}

	public void setThreeInnerPercentSix( java.lang.String value ) {
		this.__three_inner_percent_six = value;
	}

	public java.lang.Integer getFiveInnerSix() {
		return this.__five_inner_six;
	}

	public void setFiveInnerSix( java.lang.Integer value ) {
		this.__five_inner_six = value;
	}

	public java.lang.String getFiveInnerPercentSix() {
		return this.__five_inner_percent_six;
	}

	public void setFiveInnerPercentSix( java.lang.String value ) {
		this.__five_inner_percent_six = value;
	}

	public java.lang.Integer getTenInnerSix() {
		return this.__ten_inner_six;
	}

	public void setTenInnerSix( java.lang.Integer value ) {
		this.__ten_inner_six = value;
	}

	public java.lang.String getTenInnerPercentSix() {
		return this.__ten_inner_percent_six;
	}

	public void setTenInnerPercentSix( java.lang.String value ) {
		this.__ten_inner_percent_six = value;
	}

	public java.lang.Integer getTenAddSix() {
		return this.__ten_add_six;
	}

	public void setTenAddSix( java.lang.Integer value ) {
		this.__ten_add_six = value;
	}

	public java.lang.String getTenAddPercentSix() {
		return this.__ten_add_percent_six;
	}

	public void setTenAddPercentSix( java.lang.String value ) {
		this.__ten_add_percent_six = value;
	}

	public java.lang.Integer getTotalSix() {
		return this.__total_six;
	}

	public void setTotalSix( java.lang.Integer value ) {
		this.__total_six = value;
	}

	public java.lang.Integer getOneInnerSeven() {
		return this.__one_inner_seven;
	}

	public void setOneInnerSeven( java.lang.Integer value ) {
		this.__one_inner_seven = value;
	}

	public java.lang.String getOneInnerPercentSeven() {
		return this.__one_inner_percent_seven;
	}

	public void setOneInnerPercentSeven( java.lang.String value ) {
		this.__one_inner_percent_seven = value;
	}

	public java.lang.Integer getThreeInnerSeven() {
		return this.__three_inner_seven;
	}

	public void setThreeInnerSeven( java.lang.Integer value ) {
		this.__three_inner_seven = value;
	}

	public java.lang.String getThreeInnerPercentSeven() {
		return this.__three_inner_percent_seven;
	}

	public void setThreeInnerPercentSeven( java.lang.String value ) {
		this.__three_inner_percent_seven = value;
	}

	public java.lang.Integer getFiveInnerSeven() {
		return this.__five_inner_seven;
	}

	public void setFiveInnerSeven( java.lang.Integer value ) {
		this.__five_inner_seven = value;
	}

	public java.lang.String getFiveInnerPercentSeven() {
		return this.__five_inner_percent_seven;
	}

	public void setFiveInnerPercentSeven( java.lang.String value ) {
		this.__five_inner_percent_seven = value;
	}

	public java.lang.Integer getTenInnerSeven() {
		return this.__ten_inner_seven;
	}

	public void setTenInnerSeven( java.lang.Integer value ) {
		this.__ten_inner_seven = value;
	}

	public java.lang.String getTenInnerPercentSeven() {
		return this.__ten_inner_percent_seven;
	}

	public void setTenInnerPercentSeven( java.lang.String value ) {
		this.__ten_inner_percent_seven = value;
	}

	public java.lang.Integer getTenAddSeven() {
		return this.__ten_add_seven;
	}

	public void setTenAddSeven( java.lang.Integer value ) {
		this.__ten_add_seven = value;
	}

	public java.lang.String getTenAddPercentSeven() {
		return this.__ten_add_percent_seven;
	}

	public void setTenAddPercentSeven( java.lang.String value ) {
		this.__ten_add_percent_seven = value;
	}

	public java.lang.Integer getTotalSeven() {
		return this.__total_seven;
	}

	public void setTotalSeven( java.lang.Integer value ) {
		this.__total_seven = value;
	}

	public java.lang.Integer getOneInnerEight() {
		return this.__one_inner_eight;
	}

	public void setOneInnerEight( java.lang.Integer value ) {
		this.__one_inner_eight = value;
	}

	public java.lang.String getOneInnerPercentEight() {
		return this.__one_inner_percent_eight;
	}

	public void setOneInnerPercentEight( java.lang.String value ) {
		this.__one_inner_percent_eight = value;
	}

	public java.lang.Integer getThreeInnerEight() {
		return this.__three_inner_eight;
	}

	public void setThreeInnerEight( java.lang.Integer value ) {
		this.__three_inner_eight = value;
	}

	public java.lang.String getThreeInnerPercentEight() {
		return this.__three_inner_percent_eight;
	}

	public void setThreeInnerPercentEight( java.lang.String value ) {
		this.__three_inner_percent_eight = value;
	}

	public java.lang.Integer getFiveInnerEight() {
		return this.__five_inner_eight;
	}

	public void setFiveInnerEight( java.lang.Integer value ) {
		this.__five_inner_eight = value;
	}

	public java.lang.String getFiveInnerPercentEight() {
		return this.__five_inner_percent_eight;
	}

	public void setFiveInnerPercentEight( java.lang.String value ) {
		this.__five_inner_percent_eight = value;
	}

	public java.lang.Integer getTenInnerEight() {
		return this.__ten_inner_eight;
	}

	public void setTenInnerEight( java.lang.Integer value ) {
		this.__ten_inner_eight = value;
	}

	public java.lang.String getTenInnerPercentEight() {
		return this.__ten_inner_percent_eight;
	}

	public void setTenInnerPercentEight( java.lang.String value ) {
		this.__ten_inner_percent_eight = value;
	}

	public java.lang.Integer getTenAddEight() {
		return this.__ten_add_eight;
	}

	public void setTenAddEight( java.lang.Integer value ) {
		this.__ten_add_eight = value;
	}

	public java.lang.String getTenAddPercentEight() {
		return this.__ten_add_percent_eight;
	}

	public void setTenAddPercentEight( java.lang.String value ) {
		this.__ten_add_percent_eight = value;
	}

	public java.lang.Integer getTotalEight() {
		return this.__total_eight;
	}

	public void setTotalEight( java.lang.Integer value ) {
		this.__total_eight = value;
	}

	public java.lang.Integer getOneInnerNine() {
		return this.__one_inner_nine;
	}

	public void setOneInnerNine( java.lang.Integer value ) {
		this.__one_inner_nine = value;
	}

	public java.lang.String getOneInnerPercentNine() {
		return this.__one_inner_percent_nine;
	}

	public void setOneInnerPercentNine( java.lang.String value ) {
		this.__one_inner_percent_nine = value;
	}

	public java.lang.Integer getThreeInnerNine() {
		return this.__three_inner_nine;
	}

	public void setThreeInnerNine( java.lang.Integer value ) {
		this.__three_inner_nine = value;
	}

	public java.lang.String getThreeInnerPercentNine() {
		return this.__three_inner_percent_nine;
	}

	public void setThreeInnerPercentNine( java.lang.String value ) {
		this.__three_inner_percent_nine = value;
	}

	public java.lang.Integer getFiveInnerNine() {
		return this.__five_inner_nine;
	}

	public void setFiveInnerNine( java.lang.Integer value ) {
		this.__five_inner_nine = value;
	}

	public java.lang.String getFiveInnerPercentNine() {
		return this.__five_inner_percent_nine;
	}

	public void setFiveInnerPercentNine( java.lang.String value ) {
		this.__five_inner_percent_nine = value;
	}

	public java.lang.Integer getTenInnerNine() {
		return this.__ten_inner_nine;
	}

	public void setTenInnerNine( java.lang.Integer value ) {
		this.__ten_inner_nine = value;
	}

	public java.lang.String getTenInnerPercentNine() {
		return this.__ten_inner_percent_nine;
	}

	public void setTenInnerPercentNine( java.lang.String value ) {
		this.__ten_inner_percent_nine = value;
	}

	public java.lang.Integer getTenAddNine() {
		return this.__ten_add_nine;
	}

	public void setTenAddNine( java.lang.Integer value ) {
		this.__ten_add_nine = value;
	}

	public java.lang.String getTenAddPercentNine() {
		return this.__ten_add_percent_nine;
	}

	public void setTenAddPercentNine( java.lang.String value ) {
		this.__ten_add_percent_nine = value;
	}

	public java.lang.Integer getTotalNine() {
		return this.__total_nine;
	}

	public void setTotalNine( java.lang.Integer value ) {
		this.__total_nine = value;
	}

	public java.lang.Integer getOneInnerTen() {
		return this.__one_inner_ten;
	}

	public void setOneInnerTen( java.lang.Integer value ) {
		this.__one_inner_ten = value;
	}

	public java.lang.String getOneInnerPercentTen() {
		return this.__one_inner_percent_ten;
	}

	public void setOneInnerPercentTen( java.lang.String value ) {
		this.__one_inner_percent_ten = value;
	}

	public java.lang.Integer getThreeInnerTen() {
		return this.__three_inner_ten;
	}

	public void setThreeInnerTen( java.lang.Integer value ) {
		this.__three_inner_ten = value;
	}

	public java.lang.String getThreeInnerPercentTen() {
		return this.__three_inner_percent_ten;
	}

	public void setThreeInnerPercentTen( java.lang.String value ) {
		this.__three_inner_percent_ten = value;
	}

	public java.lang.Integer getFiveInnerTen() {
		return this.__five_inner_ten;
	}

	public void setFiveInnerTen( java.lang.Integer value ) {
		this.__five_inner_ten = value;
	}

	public java.lang.String getFiveInnerPercentTen() {
		return this.__five_inner_percent_ten;
	}

	public void setFiveInnerPercentTen( java.lang.String value ) {
		this.__five_inner_percent_ten = value;
	}

	public java.lang.Integer getTenInnerTen() {
		return this.__ten_inner_ten;
	}

	public void setTenInnerTen( java.lang.Integer value ) {
		this.__ten_inner_ten = value;
	}

	public java.lang.String getTenInnerPercentTen() {
		return this.__ten_inner_percent_ten;
	}

	public void setTenInnerPercentTen( java.lang.String value ) {
		this.__ten_inner_percent_ten = value;
	}

	public java.lang.Integer getTenAddTen() {
		return this.__ten_add_ten;
	}

	public void setTenAddTen( java.lang.Integer value ) {
		this.__ten_add_ten = value;
	}

	public java.lang.String getTenAddPercentTen() {
		return this.__ten_add_percent_ten;
	}

	public void setTenAddPercentTen( java.lang.String value ) {
		this.__ten_add_percent_ten = value;
	}

	public java.lang.Integer getTotalTen() {
		return this.__total_ten;
	}

	public void setTotalTen( java.lang.Integer value ) {
		this.__total_ten = value;
	}

	public java.lang.Integer getOneInnerEleven() {
		return this.__one_inner_eleven;
	}

	public void setOneInnerEleven( java.lang.Integer value ) {
		this.__one_inner_eleven = value;
	}

	public java.lang.String getOneInnerPercentEleven() {
		return this.__one_inner_percent_eleven;
	}

	public void setOneInnerPercentEleven( java.lang.String value ) {
		this.__one_inner_percent_eleven = value;
	}

	public java.lang.Integer getThreeInnerEleven() {
		return this.__three_inner_eleven;
	}

	public void setThreeInnerEleven( java.lang.Integer value ) {
		this.__three_inner_eleven = value;
	}

	public java.lang.String getThreeInnerPercentEleven() {
		return this.__three_inner_percent_eleven;
	}

	public void setThreeInnerPercentEleven( java.lang.String value ) {
		this.__three_inner_percent_eleven = value;
	}

	public java.lang.Integer getFiveInnerEleven() {
		return this.__five_inner_eleven;
	}

	public void setFiveInnerEleven( java.lang.Integer value ) {
		this.__five_inner_eleven = value;
	}

	public java.lang.String getFiveInnerPercentEleven() {
		return this.__five_inner_percent_eleven;
	}

	public void setFiveInnerPercentEleven( java.lang.String value ) {
		this.__five_inner_percent_eleven = value;
	}

	public java.lang.Integer getTenInnerEleven() {
		return this.__ten_inner_eleven;
	}

	public void setTenInnerEleven( java.lang.Integer value ) {
		this.__ten_inner_eleven = value;
	}

	public java.lang.String getTenInnerPercentEleven() {
		return this.__ten_inner_percent_eleven;
	}

	public void setTenInnerPercentEleven( java.lang.String value ) {
		this.__ten_inner_percent_eleven = value;
	}

	public java.lang.Integer getTenAddEleven() {
		return this.__ten_add_eleven;
	}

	public void setTenAddEleven( java.lang.Integer value ) {
		this.__ten_add_eleven = value;
	}

	public java.lang.String getTenAddPercentEleven() {
		return this.__ten_add_percent_eleven;
	}

	public void setTenAddPercentEleven( java.lang.String value ) {
		this.__ten_add_percent_eleven = value;
	}

	public java.lang.Integer getTotalEleven() {
		return this.__total_eleven;
	}

	public void setTotalEleven( java.lang.Integer value ) {
		this.__total_eleven = value;
	}

	public java.lang.Integer getOneInnerTwelf() {
		return this.__one_inner_twelf;
	}

	public void setOneInnerTwelf( java.lang.Integer value ) {
		this.__one_inner_twelf = value;
	}

	public java.lang.String getOneInnerPercentTwelf() {
		return this.__one_inner_percent_twelf;
	}

	public void setOneInnerPercentTwelf( java.lang.String value ) {
		this.__one_inner_percent_twelf = value;
	}

	public java.lang.Integer getThreeInnerTwelf() {
		return this.__three_inner_twelf;
	}

	public void setThreeInnerTwelf( java.lang.Integer value ) {
		this.__three_inner_twelf = value;
	}

	public java.lang.String getThreeInnerPercentTwelf() {
		return this.__three_inner_percent_twelf;
	}

	public void setThreeInnerPercentTwelf( java.lang.String value ) {
		this.__three_inner_percent_twelf = value;
	}

	public java.lang.Integer getFiveInnerTwelf() {
		return this.__five_inner_twelf;
	}

	public void setFiveInnerTwelf( java.lang.Integer value ) {
		this.__five_inner_twelf = value;
	}

	public java.lang.String getFiveInnerPercentTwelf() {
		return this.__five_inner_percent_twelf;
	}

	public void setFiveInnerPercentTwelf( java.lang.String value ) {
		this.__five_inner_percent_twelf = value;
	}

	public java.lang.Integer getTenInnerTwelf() {
		return this.__ten_inner_twelf;
	}

	public void setTenInnerTwelf( java.lang.Integer value ) {
		this.__ten_inner_twelf = value;
	}

	public java.lang.String getTenInnerPercentTwelf() {
		return this.__ten_inner_percent_twelf;
	}

	public void setTenInnerPercentTwelf( java.lang.String value ) {
		this.__ten_inner_percent_twelf = value;
	}

	public java.lang.Integer getTenAddTwelf() {
		return this.__ten_add_twelf;
	}

	public void setTenAddTwelf( java.lang.Integer value ) {
		this.__ten_add_twelf = value;
	}

	public java.lang.String getTenAddPercentTwelf() {
		return this.__ten_add_percent_twelf;
	}

	public void setTenAddPercentTwelf( java.lang.String value ) {
		this.__ten_add_percent_twelf = value;
	}

	public java.lang.Integer getTotalTwelf() {
		return this.__total_twelf;
	}

	public void setTotalTwelf( java.lang.Integer value ) {
		this.__total_twelf = value;
	}

	public void cloneCopy(BaseReportYearEmpWorkYears __bean){
		__bean.setPlateId(getPlateId());
		__bean.setDepartmentId(getDepartmentId());
		__bean.setOneInner(getOneInner());
		__bean.setOneInnerPercent(getOneInnerPercent());
		__bean.setThreeInner(getThreeInner());
		__bean.setThreeInnerPercent(getThreeInnerPercent());
		__bean.setFiveInner(getFiveInner());
		__bean.setFiveInnerPercent(getFiveInnerPercent());
		__bean.setTenInner(getTenInner());
		__bean.setTenInnerPercent(getTenInnerPercent());
		__bean.setTenAdd(getTenAdd());
		__bean.setTenAddPercent(getTenAddPercent());
		__bean.setTotal(getTotal());
		__bean.setOneInnerTwo(getOneInnerTwo());
		__bean.setOneInnerPercentTwo(getOneInnerPercentTwo());
		__bean.setThreeInnerTwo(getThreeInnerTwo());
		__bean.setThreeInnerPercentTwo(getThreeInnerPercentTwo());
		__bean.setFiveInnerTwo(getFiveInnerTwo());
		__bean.setFiveInnerPercentTwo(getFiveInnerPercentTwo());
		__bean.setTenInnerTwo(getTenInnerTwo());
		__bean.setTenInnerPercentTwo(getTenInnerPercentTwo());
		__bean.setTenAddTwo(getTenAddTwo());
		__bean.setTenAddPercentTwo(getTenAddPercentTwo());
		__bean.setTotalTwo(getTotalTwo());
		__bean.setOneInnerThree(getOneInnerThree());
		__bean.setOneInnerPercentThree(getOneInnerPercentThree());
		__bean.setThreeInnerThree(getThreeInnerThree());
		__bean.setThreeInnerPercentThree(getThreeInnerPercentThree());
		__bean.setFiveInnerThree(getFiveInnerThree());
		__bean.setFiveInnerPercentThree(getFiveInnerPercentThree());
		__bean.setTenInnerThree(getTenInnerThree());
		__bean.setTenInnerPercentThree(getTenInnerPercentThree());
		__bean.setTenAddThree(getTenAddThree());
		__bean.setTenAddPercentThree(getTenAddPercentThree());
		__bean.setTotalThree(getTotalThree());
		__bean.setOneInnerFour(getOneInnerFour());
		__bean.setOneInnerPercentFour(getOneInnerPercentFour());
		__bean.setThreeInnerFour(getThreeInnerFour());
		__bean.setThreeInnerPercentFour(getThreeInnerPercentFour());
		__bean.setFiveInnerFour(getFiveInnerFour());
		__bean.setFiveInnerPercentFour(getFiveInnerPercentFour());
		__bean.setTenInnerFour(getTenInnerFour());
		__bean.setTenInnerPercentFour(getTenInnerPercentFour());
		__bean.setTenAddFour(getTenAddFour());
		__bean.setTenAddPercentFour(getTenAddPercentFour());
		__bean.setTotalFour(getTotalFour());
		__bean.setOneInnerFive(getOneInnerFive());
		__bean.setOneInnerPercentFive(getOneInnerPercentFive());
		__bean.setThreeInnerFive(getThreeInnerFive());
		__bean.setThreeInnerPercentFive(getThreeInnerPercentFive());
		__bean.setFiveInnerFive(getFiveInnerFive());
		__bean.setFiveInnerPercentFive(getFiveInnerPercentFive());
		__bean.setTenInnerFive(getTenInnerFive());
		__bean.setTenInnerPercentFive(getTenInnerPercentFive());
		__bean.setTenAddFive(getTenAddFive());
		__bean.setTenAddPercentFive(getTenAddPercentFive());
		__bean.setTotalFive(getTotalFive());
		__bean.setOneInnerSix(getOneInnerSix());
		__bean.setOneInnerPercentSix(getOneInnerPercentSix());
		__bean.setThreeInnerSix(getThreeInnerSix());
		__bean.setThreeInnerPercentSix(getThreeInnerPercentSix());
		__bean.setFiveInnerSix(getFiveInnerSix());
		__bean.setFiveInnerPercentSix(getFiveInnerPercentSix());
		__bean.setTenInnerSix(getTenInnerSix());
		__bean.setTenInnerPercentSix(getTenInnerPercentSix());
		__bean.setTenAddSix(getTenAddSix());
		__bean.setTenAddPercentSix(getTenAddPercentSix());
		__bean.setTotalSix(getTotalSix());
		__bean.setOneInnerSeven(getOneInnerSeven());
		__bean.setOneInnerPercentSeven(getOneInnerPercentSeven());
		__bean.setThreeInnerSeven(getThreeInnerSeven());
		__bean.setThreeInnerPercentSeven(getThreeInnerPercentSeven());
		__bean.setFiveInnerSeven(getFiveInnerSeven());
		__bean.setFiveInnerPercentSeven(getFiveInnerPercentSeven());
		__bean.setTenInnerSeven(getTenInnerSeven());
		__bean.setTenInnerPercentSeven(getTenInnerPercentSeven());
		__bean.setTenAddSeven(getTenAddSeven());
		__bean.setTenAddPercentSeven(getTenAddPercentSeven());
		__bean.setTotalSeven(getTotalSeven());
		__bean.setOneInnerEight(getOneInnerEight());
		__bean.setOneInnerPercentEight(getOneInnerPercentEight());
		__bean.setThreeInnerEight(getThreeInnerEight());
		__bean.setThreeInnerPercentEight(getThreeInnerPercentEight());
		__bean.setFiveInnerEight(getFiveInnerEight());
		__bean.setFiveInnerPercentEight(getFiveInnerPercentEight());
		__bean.setTenInnerEight(getTenInnerEight());
		__bean.setTenInnerPercentEight(getTenInnerPercentEight());
		__bean.setTenAddEight(getTenAddEight());
		__bean.setTenAddPercentEight(getTenAddPercentEight());
		__bean.setTotalEight(getTotalEight());
		__bean.setOneInnerNine(getOneInnerNine());
		__bean.setOneInnerPercentNine(getOneInnerPercentNine());
		__bean.setThreeInnerNine(getThreeInnerNine());
		__bean.setThreeInnerPercentNine(getThreeInnerPercentNine());
		__bean.setFiveInnerNine(getFiveInnerNine());
		__bean.setFiveInnerPercentNine(getFiveInnerPercentNine());
		__bean.setTenInnerNine(getTenInnerNine());
		__bean.setTenInnerPercentNine(getTenInnerPercentNine());
		__bean.setTenAddNine(getTenAddNine());
		__bean.setTenAddPercentNine(getTenAddPercentNine());
		__bean.setTotalNine(getTotalNine());
		__bean.setOneInnerTen(getOneInnerTen());
		__bean.setOneInnerPercentTen(getOneInnerPercentTen());
		__bean.setThreeInnerTen(getThreeInnerTen());
		__bean.setThreeInnerPercentTen(getThreeInnerPercentTen());
		__bean.setFiveInnerTen(getFiveInnerTen());
		__bean.setFiveInnerPercentTen(getFiveInnerPercentTen());
		__bean.setTenInnerTen(getTenInnerTen());
		__bean.setTenInnerPercentTen(getTenInnerPercentTen());
		__bean.setTenAddTen(getTenAddTen());
		__bean.setTenAddPercentTen(getTenAddPercentTen());
		__bean.setTotalTen(getTotalTen());
		__bean.setOneInnerEleven(getOneInnerEleven());
		__bean.setOneInnerPercentEleven(getOneInnerPercentEleven());
		__bean.setThreeInnerEleven(getThreeInnerEleven());
		__bean.setThreeInnerPercentEleven(getThreeInnerPercentEleven());
		__bean.setFiveInnerEleven(getFiveInnerEleven());
		__bean.setFiveInnerPercentEleven(getFiveInnerPercentEleven());
		__bean.setTenInnerEleven(getTenInnerEleven());
		__bean.setTenInnerPercentEleven(getTenInnerPercentEleven());
		__bean.setTenAddEleven(getTenAddEleven());
		__bean.setTenAddPercentEleven(getTenAddPercentEleven());
		__bean.setTotalEleven(getTotalEleven());
		__bean.setOneInnerTwelf(getOneInnerTwelf());
		__bean.setOneInnerPercentTwelf(getOneInnerPercentTwelf());
		__bean.setThreeInnerTwelf(getThreeInnerTwelf());
		__bean.setThreeInnerPercentTwelf(getThreeInnerPercentTwelf());
		__bean.setFiveInnerTwelf(getFiveInnerTwelf());
		__bean.setFiveInnerPercentTwelf(getFiveInnerPercentTwelf());
		__bean.setTenInnerTwelf(getTenInnerTwelf());
		__bean.setTenInnerPercentTwelf(getTenInnerPercentTwelf());
		__bean.setTenAddTwelf(getTenAddTwelf());
		__bean.setTenAddPercentTwelf(getTenAddPercentTwelf());
		__bean.setTotalTwelf(getTotalTwelf());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getOneInner() == null ? "" : getOneInner());
		sb.append(",");
		sb.append(getOneInnerPercent() == null ? "" : getOneInnerPercent());
		sb.append(",");
		sb.append(getThreeInner() == null ? "" : getThreeInner());
		sb.append(",");
		sb.append(getThreeInnerPercent() == null ? "" : getThreeInnerPercent());
		sb.append(",");
		sb.append(getFiveInner() == null ? "" : getFiveInner());
		sb.append(",");
		sb.append(getFiveInnerPercent() == null ? "" : getFiveInnerPercent());
		sb.append(",");
		sb.append(getTenInner() == null ? "" : getTenInner());
		sb.append(",");
		sb.append(getTenInnerPercent() == null ? "" : getTenInnerPercent());
		sb.append(",");
		sb.append(getTenAdd() == null ? "" : getTenAdd());
		sb.append(",");
		sb.append(getTenAddPercent() == null ? "" : getTenAddPercent());
		sb.append(",");
		sb.append(getTotal() == null ? "" : getTotal());
		sb.append(",");
		sb.append(getOneInnerTwo() == null ? "" : getOneInnerTwo());
		sb.append(",");
		sb.append(getOneInnerPercentTwo() == null ? "" : getOneInnerPercentTwo());
		sb.append(",");
		sb.append(getThreeInnerTwo() == null ? "" : getThreeInnerTwo());
		sb.append(",");
		sb.append(getThreeInnerPercentTwo() == null ? "" : getThreeInnerPercentTwo());
		sb.append(",");
		sb.append(getFiveInnerTwo() == null ? "" : getFiveInnerTwo());
		sb.append(",");
		sb.append(getFiveInnerPercentTwo() == null ? "" : getFiveInnerPercentTwo());
		sb.append(",");
		sb.append(getTenInnerTwo() == null ? "" : getTenInnerTwo());
		sb.append(",");
		sb.append(getTenInnerPercentTwo() == null ? "" : getTenInnerPercentTwo());
		sb.append(",");
		sb.append(getTenAddTwo() == null ? "" : getTenAddTwo());
		sb.append(",");
		sb.append(getTenAddPercentTwo() == null ? "" : getTenAddPercentTwo());
		sb.append(",");
		sb.append(getTotalTwo() == null ? "" : getTotalTwo());
		sb.append(",");
		sb.append(getOneInnerThree() == null ? "" : getOneInnerThree());
		sb.append(",");
		sb.append(getOneInnerPercentThree() == null ? "" : getOneInnerPercentThree());
		sb.append(",");
		sb.append(getThreeInnerThree() == null ? "" : getThreeInnerThree());
		sb.append(",");
		sb.append(getThreeInnerPercentThree() == null ? "" : getThreeInnerPercentThree());
		sb.append(",");
		sb.append(getFiveInnerThree() == null ? "" : getFiveInnerThree());
		sb.append(",");
		sb.append(getFiveInnerPercentThree() == null ? "" : getFiveInnerPercentThree());
		sb.append(",");
		sb.append(getTenInnerThree() == null ? "" : getTenInnerThree());
		sb.append(",");
		sb.append(getTenInnerPercentThree() == null ? "" : getTenInnerPercentThree());
		sb.append(",");
		sb.append(getTenAddThree() == null ? "" : getTenAddThree());
		sb.append(",");
		sb.append(getTenAddPercentThree() == null ? "" : getTenAddPercentThree());
		sb.append(",");
		sb.append(getTotalThree() == null ? "" : getTotalThree());
		sb.append(",");
		sb.append(getOneInnerFour() == null ? "" : getOneInnerFour());
		sb.append(",");
		sb.append(getOneInnerPercentFour() == null ? "" : getOneInnerPercentFour());
		sb.append(",");
		sb.append(getThreeInnerFour() == null ? "" : getThreeInnerFour());
		sb.append(",");
		sb.append(getThreeInnerPercentFour() == null ? "" : getThreeInnerPercentFour());
		sb.append(",");
		sb.append(getFiveInnerFour() == null ? "" : getFiveInnerFour());
		sb.append(",");
		sb.append(getFiveInnerPercentFour() == null ? "" : getFiveInnerPercentFour());
		sb.append(",");
		sb.append(getTenInnerFour() == null ? "" : getTenInnerFour());
		sb.append(",");
		sb.append(getTenInnerPercentFour() == null ? "" : getTenInnerPercentFour());
		sb.append(",");
		sb.append(getTenAddFour() == null ? "" : getTenAddFour());
		sb.append(",");
		sb.append(getTenAddPercentFour() == null ? "" : getTenAddPercentFour());
		sb.append(",");
		sb.append(getTotalFour() == null ? "" : getTotalFour());
		sb.append(",");
		sb.append(getOneInnerFive() == null ? "" : getOneInnerFive());
		sb.append(",");
		sb.append(getOneInnerPercentFive() == null ? "" : getOneInnerPercentFive());
		sb.append(",");
		sb.append(getThreeInnerFive() == null ? "" : getThreeInnerFive());
		sb.append(",");
		sb.append(getThreeInnerPercentFive() == null ? "" : getThreeInnerPercentFive());
		sb.append(",");
		sb.append(getFiveInnerFive() == null ? "" : getFiveInnerFive());
		sb.append(",");
		sb.append(getFiveInnerPercentFive() == null ? "" : getFiveInnerPercentFive());
		sb.append(",");
		sb.append(getTenInnerFive() == null ? "" : getTenInnerFive());
		sb.append(",");
		sb.append(getTenInnerPercentFive() == null ? "" : getTenInnerPercentFive());
		sb.append(",");
		sb.append(getTenAddFive() == null ? "" : getTenAddFive());
		sb.append(",");
		sb.append(getTenAddPercentFive() == null ? "" : getTenAddPercentFive());
		sb.append(",");
		sb.append(getTotalFive() == null ? "" : getTotalFive());
		sb.append(",");
		sb.append(getOneInnerSix() == null ? "" : getOneInnerSix());
		sb.append(",");
		sb.append(getOneInnerPercentSix() == null ? "" : getOneInnerPercentSix());
		sb.append(",");
		sb.append(getThreeInnerSix() == null ? "" : getThreeInnerSix());
		sb.append(",");
		sb.append(getThreeInnerPercentSix() == null ? "" : getThreeInnerPercentSix());
		sb.append(",");
		sb.append(getFiveInnerSix() == null ? "" : getFiveInnerSix());
		sb.append(",");
		sb.append(getFiveInnerPercentSix() == null ? "" : getFiveInnerPercentSix());
		sb.append(",");
		sb.append(getTenInnerSix() == null ? "" : getTenInnerSix());
		sb.append(",");
		sb.append(getTenInnerPercentSix() == null ? "" : getTenInnerPercentSix());
		sb.append(",");
		sb.append(getTenAddSix() == null ? "" : getTenAddSix());
		sb.append(",");
		sb.append(getTenAddPercentSix() == null ? "" : getTenAddPercentSix());
		sb.append(",");
		sb.append(getTotalSix() == null ? "" : getTotalSix());
		sb.append(",");
		sb.append(getOneInnerSeven() == null ? "" : getOneInnerSeven());
		sb.append(",");
		sb.append(getOneInnerPercentSeven() == null ? "" : getOneInnerPercentSeven());
		sb.append(",");
		sb.append(getThreeInnerSeven() == null ? "" : getThreeInnerSeven());
		sb.append(",");
		sb.append(getThreeInnerPercentSeven() == null ? "" : getThreeInnerPercentSeven());
		sb.append(",");
		sb.append(getFiveInnerSeven() == null ? "" : getFiveInnerSeven());
		sb.append(",");
		sb.append(getFiveInnerPercentSeven() == null ? "" : getFiveInnerPercentSeven());
		sb.append(",");
		sb.append(getTenInnerSeven() == null ? "" : getTenInnerSeven());
		sb.append(",");
		sb.append(getTenInnerPercentSeven() == null ? "" : getTenInnerPercentSeven());
		sb.append(",");
		sb.append(getTenAddSeven() == null ? "" : getTenAddSeven());
		sb.append(",");
		sb.append(getTenAddPercentSeven() == null ? "" : getTenAddPercentSeven());
		sb.append(",");
		sb.append(getTotalSeven() == null ? "" : getTotalSeven());
		sb.append(",");
		sb.append(getOneInnerEight() == null ? "" : getOneInnerEight());
		sb.append(",");
		sb.append(getOneInnerPercentEight() == null ? "" : getOneInnerPercentEight());
		sb.append(",");
		sb.append(getThreeInnerEight() == null ? "" : getThreeInnerEight());
		sb.append(",");
		sb.append(getThreeInnerPercentEight() == null ? "" : getThreeInnerPercentEight());
		sb.append(",");
		sb.append(getFiveInnerEight() == null ? "" : getFiveInnerEight());
		sb.append(",");
		sb.append(getFiveInnerPercentEight() == null ? "" : getFiveInnerPercentEight());
		sb.append(",");
		sb.append(getTenInnerEight() == null ? "" : getTenInnerEight());
		sb.append(",");
		sb.append(getTenInnerPercentEight() == null ? "" : getTenInnerPercentEight());
		sb.append(",");
		sb.append(getTenAddEight() == null ? "" : getTenAddEight());
		sb.append(",");
		sb.append(getTenAddPercentEight() == null ? "" : getTenAddPercentEight());
		sb.append(",");
		sb.append(getTotalEight() == null ? "" : getTotalEight());
		sb.append(",");
		sb.append(getOneInnerNine() == null ? "" : getOneInnerNine());
		sb.append(",");
		sb.append(getOneInnerPercentNine() == null ? "" : getOneInnerPercentNine());
		sb.append(",");
		sb.append(getThreeInnerNine() == null ? "" : getThreeInnerNine());
		sb.append(",");
		sb.append(getThreeInnerPercentNine() == null ? "" : getThreeInnerPercentNine());
		sb.append(",");
		sb.append(getFiveInnerNine() == null ? "" : getFiveInnerNine());
		sb.append(",");
		sb.append(getFiveInnerPercentNine() == null ? "" : getFiveInnerPercentNine());
		sb.append(",");
		sb.append(getTenInnerNine() == null ? "" : getTenInnerNine());
		sb.append(",");
		sb.append(getTenInnerPercentNine() == null ? "" : getTenInnerPercentNine());
		sb.append(",");
		sb.append(getTenAddNine() == null ? "" : getTenAddNine());
		sb.append(",");
		sb.append(getTenAddPercentNine() == null ? "" : getTenAddPercentNine());
		sb.append(",");
		sb.append(getTotalNine() == null ? "" : getTotalNine());
		sb.append(",");
		sb.append(getOneInnerTen() == null ? "" : getOneInnerTen());
		sb.append(",");
		sb.append(getOneInnerPercentTen() == null ? "" : getOneInnerPercentTen());
		sb.append(",");
		sb.append(getThreeInnerTen() == null ? "" : getThreeInnerTen());
		sb.append(",");
		sb.append(getThreeInnerPercentTen() == null ? "" : getThreeInnerPercentTen());
		sb.append(",");
		sb.append(getFiveInnerTen() == null ? "" : getFiveInnerTen());
		sb.append(",");
		sb.append(getFiveInnerPercentTen() == null ? "" : getFiveInnerPercentTen());
		sb.append(",");
		sb.append(getTenInnerTen() == null ? "" : getTenInnerTen());
		sb.append(",");
		sb.append(getTenInnerPercentTen() == null ? "" : getTenInnerPercentTen());
		sb.append(",");
		sb.append(getTenAddTen() == null ? "" : getTenAddTen());
		sb.append(",");
		sb.append(getTenAddPercentTen() == null ? "" : getTenAddPercentTen());
		sb.append(",");
		sb.append(getTotalTen() == null ? "" : getTotalTen());
		sb.append(",");
		sb.append(getOneInnerEleven() == null ? "" : getOneInnerEleven());
		sb.append(",");
		sb.append(getOneInnerPercentEleven() == null ? "" : getOneInnerPercentEleven());
		sb.append(",");
		sb.append(getThreeInnerEleven() == null ? "" : getThreeInnerEleven());
		sb.append(",");
		sb.append(getThreeInnerPercentEleven() == null ? "" : getThreeInnerPercentEleven());
		sb.append(",");
		sb.append(getFiveInnerEleven() == null ? "" : getFiveInnerEleven());
		sb.append(",");
		sb.append(getFiveInnerPercentEleven() == null ? "" : getFiveInnerPercentEleven());
		sb.append(",");
		sb.append(getTenInnerEleven() == null ? "" : getTenInnerEleven());
		sb.append(",");
		sb.append(getTenInnerPercentEleven() == null ? "" : getTenInnerPercentEleven());
		sb.append(",");
		sb.append(getTenAddEleven() == null ? "" : getTenAddEleven());
		sb.append(",");
		sb.append(getTenAddPercentEleven() == null ? "" : getTenAddPercentEleven());
		sb.append(",");
		sb.append(getTotalEleven() == null ? "" : getTotalEleven());
		sb.append(",");
		sb.append(getOneInnerTwelf() == null ? "" : getOneInnerTwelf());
		sb.append(",");
		sb.append(getOneInnerPercentTwelf() == null ? "" : getOneInnerPercentTwelf());
		sb.append(",");
		sb.append(getThreeInnerTwelf() == null ? "" : getThreeInnerTwelf());
		sb.append(",");
		sb.append(getThreeInnerPercentTwelf() == null ? "" : getThreeInnerPercentTwelf());
		sb.append(",");
		sb.append(getFiveInnerTwelf() == null ? "" : getFiveInnerTwelf());
		sb.append(",");
		sb.append(getFiveInnerPercentTwelf() == null ? "" : getFiveInnerPercentTwelf());
		sb.append(",");
		sb.append(getTenInnerTwelf() == null ? "" : getTenInnerTwelf());
		sb.append(",");
		sb.append(getTenInnerPercentTwelf() == null ? "" : getTenInnerPercentTwelf());
		sb.append(",");
		sb.append(getTenAddTwelf() == null ? "" : getTenAddTwelf());
		sb.append(",");
		sb.append(getTenAddPercentTwelf() == null ? "" : getTenAddPercentTwelf());
		sb.append(",");
		sb.append(getTotalTwelf() == null ? "" : getTotalTwelf());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportYearEmpWorkYears o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__one_inner);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__three_inner);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__five_inner);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent);
		hash = 97 * hash + Objects.hashCode(this.__ten_add);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent);
		hash = 97 * hash + Objects.hashCode(this.__total);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_two);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_two);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_two);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_two);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_two);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_two);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_two);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_two);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_two);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_two);
		hash = 97 * hash + Objects.hashCode(this.__total_two);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_three);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_three);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_three);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_three);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_three);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_three);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_three);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_three);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_three);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_three);
		hash = 97 * hash + Objects.hashCode(this.__total_three);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_four);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_four);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_four);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_four);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_four);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_four);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_four);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_four);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_four);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_four);
		hash = 97 * hash + Objects.hashCode(this.__total_four);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_five);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_five);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_five);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_five);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_five);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_five);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_five);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_five);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_five);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_five);
		hash = 97 * hash + Objects.hashCode(this.__total_five);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_six);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_six);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_six);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_six);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_six);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_six);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_six);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_six);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_six);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_six);
		hash = 97 * hash + Objects.hashCode(this.__total_six);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_seven);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_seven);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_seven);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_seven);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_seven);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_seven);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_seven);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_seven);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_seven);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_seven);
		hash = 97 * hash + Objects.hashCode(this.__total_seven);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_eight);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_eight);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_eight);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_eight);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_eight);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_eight);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_eight);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_eight);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_eight);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_eight);
		hash = 97 * hash + Objects.hashCode(this.__total_eight);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_nine);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_nine);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_nine);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_nine);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_nine);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_nine);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_nine);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_nine);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_nine);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_nine);
		hash = 97 * hash + Objects.hashCode(this.__total_nine);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_ten);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_ten);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_ten);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_ten);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_ten);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_ten);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_ten);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_ten);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_ten);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_ten);
		hash = 97 * hash + Objects.hashCode(this.__total_ten);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_eleven);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_eleven);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_eleven);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_eleven);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_eleven);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_eleven);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_eleven);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_eleven);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_eleven);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_eleven);
		hash = 97 * hash + Objects.hashCode(this.__total_eleven);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_twelf);
		hash = 97 * hash + Objects.hashCode(this.__one_inner_percent_twelf);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_twelf);
		hash = 97 * hash + Objects.hashCode(this.__three_inner_percent_twelf);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_twelf);
		hash = 97 * hash + Objects.hashCode(this.__five_inner_percent_twelf);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_twelf);
		hash = 97 * hash + Objects.hashCode(this.__ten_inner_percent_twelf);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_twelf);
		hash = 97 * hash + Objects.hashCode(this.__ten_add_percent_twelf);
		hash = 97 * hash + Objects.hashCode(this.__total_twelf);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportYearEmpWorkYears o = (BaseReportYearEmpWorkYears)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__one_inner, o.getOneInner())) return false;
		if(!Objects.equals(this.__one_inner_percent, o.getOneInnerPercent())) return false;
		if(!Objects.equals(this.__three_inner, o.getThreeInner())) return false;
		if(!Objects.equals(this.__three_inner_percent, o.getThreeInnerPercent())) return false;
		if(!Objects.equals(this.__five_inner, o.getFiveInner())) return false;
		if(!Objects.equals(this.__five_inner_percent, o.getFiveInnerPercent())) return false;
		if(!Objects.equals(this.__ten_inner, o.getTenInner())) return false;
		if(!Objects.equals(this.__ten_inner_percent, o.getTenInnerPercent())) return false;
		if(!Objects.equals(this.__ten_add, o.getTenAdd())) return false;
		if(!Objects.equals(this.__ten_add_percent, o.getTenAddPercent())) return false;
		if(!Objects.equals(this.__total, o.getTotal())) return false;
		if(!Objects.equals(this.__one_inner_two, o.getOneInnerTwo())) return false;
		if(!Objects.equals(this.__one_inner_percent_two, o.getOneInnerPercentTwo())) return false;
		if(!Objects.equals(this.__three_inner_two, o.getThreeInnerTwo())) return false;
		if(!Objects.equals(this.__three_inner_percent_two, o.getThreeInnerPercentTwo())) return false;
		if(!Objects.equals(this.__five_inner_two, o.getFiveInnerTwo())) return false;
		if(!Objects.equals(this.__five_inner_percent_two, o.getFiveInnerPercentTwo())) return false;
		if(!Objects.equals(this.__ten_inner_two, o.getTenInnerTwo())) return false;
		if(!Objects.equals(this.__ten_inner_percent_two, o.getTenInnerPercentTwo())) return false;
		if(!Objects.equals(this.__ten_add_two, o.getTenAddTwo())) return false;
		if(!Objects.equals(this.__ten_add_percent_two, o.getTenAddPercentTwo())) return false;
		if(!Objects.equals(this.__total_two, o.getTotalTwo())) return false;
		if(!Objects.equals(this.__one_inner_three, o.getOneInnerThree())) return false;
		if(!Objects.equals(this.__one_inner_percent_three, o.getOneInnerPercentThree())) return false;
		if(!Objects.equals(this.__three_inner_three, o.getThreeInnerThree())) return false;
		if(!Objects.equals(this.__three_inner_percent_three, o.getThreeInnerPercentThree())) return false;
		if(!Objects.equals(this.__five_inner_three, o.getFiveInnerThree())) return false;
		if(!Objects.equals(this.__five_inner_percent_three, o.getFiveInnerPercentThree())) return false;
		if(!Objects.equals(this.__ten_inner_three, o.getTenInnerThree())) return false;
		if(!Objects.equals(this.__ten_inner_percent_three, o.getTenInnerPercentThree())) return false;
		if(!Objects.equals(this.__ten_add_three, o.getTenAddThree())) return false;
		if(!Objects.equals(this.__ten_add_percent_three, o.getTenAddPercentThree())) return false;
		if(!Objects.equals(this.__total_three, o.getTotalThree())) return false;
		if(!Objects.equals(this.__one_inner_four, o.getOneInnerFour())) return false;
		if(!Objects.equals(this.__one_inner_percent_four, o.getOneInnerPercentFour())) return false;
		if(!Objects.equals(this.__three_inner_four, o.getThreeInnerFour())) return false;
		if(!Objects.equals(this.__three_inner_percent_four, o.getThreeInnerPercentFour())) return false;
		if(!Objects.equals(this.__five_inner_four, o.getFiveInnerFour())) return false;
		if(!Objects.equals(this.__five_inner_percent_four, o.getFiveInnerPercentFour())) return false;
		if(!Objects.equals(this.__ten_inner_four, o.getTenInnerFour())) return false;
		if(!Objects.equals(this.__ten_inner_percent_four, o.getTenInnerPercentFour())) return false;
		if(!Objects.equals(this.__ten_add_four, o.getTenAddFour())) return false;
		if(!Objects.equals(this.__ten_add_percent_four, o.getTenAddPercentFour())) return false;
		if(!Objects.equals(this.__total_four, o.getTotalFour())) return false;
		if(!Objects.equals(this.__one_inner_five, o.getOneInnerFive())) return false;
		if(!Objects.equals(this.__one_inner_percent_five, o.getOneInnerPercentFive())) return false;
		if(!Objects.equals(this.__three_inner_five, o.getThreeInnerFive())) return false;
		if(!Objects.equals(this.__three_inner_percent_five, o.getThreeInnerPercentFive())) return false;
		if(!Objects.equals(this.__five_inner_five, o.getFiveInnerFive())) return false;
		if(!Objects.equals(this.__five_inner_percent_five, o.getFiveInnerPercentFive())) return false;
		if(!Objects.equals(this.__ten_inner_five, o.getTenInnerFive())) return false;
		if(!Objects.equals(this.__ten_inner_percent_five, o.getTenInnerPercentFive())) return false;
		if(!Objects.equals(this.__ten_add_five, o.getTenAddFive())) return false;
		if(!Objects.equals(this.__ten_add_percent_five, o.getTenAddPercentFive())) return false;
		if(!Objects.equals(this.__total_five, o.getTotalFive())) return false;
		if(!Objects.equals(this.__one_inner_six, o.getOneInnerSix())) return false;
		if(!Objects.equals(this.__one_inner_percent_six, o.getOneInnerPercentSix())) return false;
		if(!Objects.equals(this.__three_inner_six, o.getThreeInnerSix())) return false;
		if(!Objects.equals(this.__three_inner_percent_six, o.getThreeInnerPercentSix())) return false;
		if(!Objects.equals(this.__five_inner_six, o.getFiveInnerSix())) return false;
		if(!Objects.equals(this.__five_inner_percent_six, o.getFiveInnerPercentSix())) return false;
		if(!Objects.equals(this.__ten_inner_six, o.getTenInnerSix())) return false;
		if(!Objects.equals(this.__ten_inner_percent_six, o.getTenInnerPercentSix())) return false;
		if(!Objects.equals(this.__ten_add_six, o.getTenAddSix())) return false;
		if(!Objects.equals(this.__ten_add_percent_six, o.getTenAddPercentSix())) return false;
		if(!Objects.equals(this.__total_six, o.getTotalSix())) return false;
		if(!Objects.equals(this.__one_inner_seven, o.getOneInnerSeven())) return false;
		if(!Objects.equals(this.__one_inner_percent_seven, o.getOneInnerPercentSeven())) return false;
		if(!Objects.equals(this.__three_inner_seven, o.getThreeInnerSeven())) return false;
		if(!Objects.equals(this.__three_inner_percent_seven, o.getThreeInnerPercentSeven())) return false;
		if(!Objects.equals(this.__five_inner_seven, o.getFiveInnerSeven())) return false;
		if(!Objects.equals(this.__five_inner_percent_seven, o.getFiveInnerPercentSeven())) return false;
		if(!Objects.equals(this.__ten_inner_seven, o.getTenInnerSeven())) return false;
		if(!Objects.equals(this.__ten_inner_percent_seven, o.getTenInnerPercentSeven())) return false;
		if(!Objects.equals(this.__ten_add_seven, o.getTenAddSeven())) return false;
		if(!Objects.equals(this.__ten_add_percent_seven, o.getTenAddPercentSeven())) return false;
		if(!Objects.equals(this.__total_seven, o.getTotalSeven())) return false;
		if(!Objects.equals(this.__one_inner_eight, o.getOneInnerEight())) return false;
		if(!Objects.equals(this.__one_inner_percent_eight, o.getOneInnerPercentEight())) return false;
		if(!Objects.equals(this.__three_inner_eight, o.getThreeInnerEight())) return false;
		if(!Objects.equals(this.__three_inner_percent_eight, o.getThreeInnerPercentEight())) return false;
		if(!Objects.equals(this.__five_inner_eight, o.getFiveInnerEight())) return false;
		if(!Objects.equals(this.__five_inner_percent_eight, o.getFiveInnerPercentEight())) return false;
		if(!Objects.equals(this.__ten_inner_eight, o.getTenInnerEight())) return false;
		if(!Objects.equals(this.__ten_inner_percent_eight, o.getTenInnerPercentEight())) return false;
		if(!Objects.equals(this.__ten_add_eight, o.getTenAddEight())) return false;
		if(!Objects.equals(this.__ten_add_percent_eight, o.getTenAddPercentEight())) return false;
		if(!Objects.equals(this.__total_eight, o.getTotalEight())) return false;
		if(!Objects.equals(this.__one_inner_nine, o.getOneInnerNine())) return false;
		if(!Objects.equals(this.__one_inner_percent_nine, o.getOneInnerPercentNine())) return false;
		if(!Objects.equals(this.__three_inner_nine, o.getThreeInnerNine())) return false;
		if(!Objects.equals(this.__three_inner_percent_nine, o.getThreeInnerPercentNine())) return false;
		if(!Objects.equals(this.__five_inner_nine, o.getFiveInnerNine())) return false;
		if(!Objects.equals(this.__five_inner_percent_nine, o.getFiveInnerPercentNine())) return false;
		if(!Objects.equals(this.__ten_inner_nine, o.getTenInnerNine())) return false;
		if(!Objects.equals(this.__ten_inner_percent_nine, o.getTenInnerPercentNine())) return false;
		if(!Objects.equals(this.__ten_add_nine, o.getTenAddNine())) return false;
		if(!Objects.equals(this.__ten_add_percent_nine, o.getTenAddPercentNine())) return false;
		if(!Objects.equals(this.__total_nine, o.getTotalNine())) return false;
		if(!Objects.equals(this.__one_inner_ten, o.getOneInnerTen())) return false;
		if(!Objects.equals(this.__one_inner_percent_ten, o.getOneInnerPercentTen())) return false;
		if(!Objects.equals(this.__three_inner_ten, o.getThreeInnerTen())) return false;
		if(!Objects.equals(this.__three_inner_percent_ten, o.getThreeInnerPercentTen())) return false;
		if(!Objects.equals(this.__five_inner_ten, o.getFiveInnerTen())) return false;
		if(!Objects.equals(this.__five_inner_percent_ten, o.getFiveInnerPercentTen())) return false;
		if(!Objects.equals(this.__ten_inner_ten, o.getTenInnerTen())) return false;
		if(!Objects.equals(this.__ten_inner_percent_ten, o.getTenInnerPercentTen())) return false;
		if(!Objects.equals(this.__ten_add_ten, o.getTenAddTen())) return false;
		if(!Objects.equals(this.__ten_add_percent_ten, o.getTenAddPercentTen())) return false;
		if(!Objects.equals(this.__total_ten, o.getTotalTen())) return false;
		if(!Objects.equals(this.__one_inner_eleven, o.getOneInnerEleven())) return false;
		if(!Objects.equals(this.__one_inner_percent_eleven, o.getOneInnerPercentEleven())) return false;
		if(!Objects.equals(this.__three_inner_eleven, o.getThreeInnerEleven())) return false;
		if(!Objects.equals(this.__three_inner_percent_eleven, o.getThreeInnerPercentEleven())) return false;
		if(!Objects.equals(this.__five_inner_eleven, o.getFiveInnerEleven())) return false;
		if(!Objects.equals(this.__five_inner_percent_eleven, o.getFiveInnerPercentEleven())) return false;
		if(!Objects.equals(this.__ten_inner_eleven, o.getTenInnerEleven())) return false;
		if(!Objects.equals(this.__ten_inner_percent_eleven, o.getTenInnerPercentEleven())) return false;
		if(!Objects.equals(this.__ten_add_eleven, o.getTenAddEleven())) return false;
		if(!Objects.equals(this.__ten_add_percent_eleven, o.getTenAddPercentEleven())) return false;
		if(!Objects.equals(this.__total_eleven, o.getTotalEleven())) return false;
		if(!Objects.equals(this.__one_inner_twelf, o.getOneInnerTwelf())) return false;
		if(!Objects.equals(this.__one_inner_percent_twelf, o.getOneInnerPercentTwelf())) return false;
		if(!Objects.equals(this.__three_inner_twelf, o.getThreeInnerTwelf())) return false;
		if(!Objects.equals(this.__three_inner_percent_twelf, o.getThreeInnerPercentTwelf())) return false;
		if(!Objects.equals(this.__five_inner_twelf, o.getFiveInnerTwelf())) return false;
		if(!Objects.equals(this.__five_inner_percent_twelf, o.getFiveInnerPercentTwelf())) return false;
		if(!Objects.equals(this.__ten_inner_twelf, o.getTenInnerTwelf())) return false;
		if(!Objects.equals(this.__ten_inner_percent_twelf, o.getTenInnerPercentTwelf())) return false;
		if(!Objects.equals(this.__ten_add_twelf, o.getTenAddTwelf())) return false;
		if(!Objects.equals(this.__ten_add_percent_twelf, o.getTenAddPercentTwelf())) return false;
		if(!Objects.equals(this.__total_twelf, o.getTotalTwelf())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getOneInner() != null) sb.append(__wrapNumber(count++, "oneInner", getOneInner()));
		if(getOneInnerPercent() != null) sb.append(__wrapString(count++, "oneInnerPercent", getOneInnerPercent()));
		if(getThreeInner() != null) sb.append(__wrapNumber(count++, "threeInner", getThreeInner()));
		if(getThreeInnerPercent() != null) sb.append(__wrapString(count++, "threeInnerPercent", getThreeInnerPercent()));
		if(getFiveInner() != null) sb.append(__wrapNumber(count++, "fiveInner", getFiveInner()));
		if(getFiveInnerPercent() != null) sb.append(__wrapString(count++, "fiveInnerPercent", getFiveInnerPercent()));
		if(getTenInner() != null) sb.append(__wrapNumber(count++, "tenInner", getTenInner()));
		if(getTenInnerPercent() != null) sb.append(__wrapString(count++, "tenInnerPercent", getTenInnerPercent()));
		if(getTenAdd() != null) sb.append(__wrapNumber(count++, "tenAdd", getTenAdd()));
		if(getTenAddPercent() != null) sb.append(__wrapString(count++, "tenAddPercent", getTenAddPercent()));
		if(getTotal() != null) sb.append(__wrapNumber(count++, "total", getTotal()));
		if(getOneInnerTwo() != null) sb.append(__wrapNumber(count++, "oneInnerTwo", getOneInnerTwo()));
		if(getOneInnerPercentTwo() != null) sb.append(__wrapString(count++, "oneInnerPercentTwo", getOneInnerPercentTwo()));
		if(getThreeInnerTwo() != null) sb.append(__wrapNumber(count++, "threeInnerTwo", getThreeInnerTwo()));
		if(getThreeInnerPercentTwo() != null) sb.append(__wrapString(count++, "threeInnerPercentTwo", getThreeInnerPercentTwo()));
		if(getFiveInnerTwo() != null) sb.append(__wrapNumber(count++, "fiveInnerTwo", getFiveInnerTwo()));
		if(getFiveInnerPercentTwo() != null) sb.append(__wrapString(count++, "fiveInnerPercentTwo", getFiveInnerPercentTwo()));
		if(getTenInnerTwo() != null) sb.append(__wrapNumber(count++, "tenInnerTwo", getTenInnerTwo()));
		if(getTenInnerPercentTwo() != null) sb.append(__wrapString(count++, "tenInnerPercentTwo", getTenInnerPercentTwo()));
		if(getTenAddTwo() != null) sb.append(__wrapNumber(count++, "tenAddTwo", getTenAddTwo()));
		if(getTenAddPercentTwo() != null) sb.append(__wrapString(count++, "tenAddPercentTwo", getTenAddPercentTwo()));
		if(getTotalTwo() != null) sb.append(__wrapNumber(count++, "totalTwo", getTotalTwo()));
		if(getOneInnerThree() != null) sb.append(__wrapNumber(count++, "oneInnerThree", getOneInnerThree()));
		if(getOneInnerPercentThree() != null) sb.append(__wrapString(count++, "oneInnerPercentThree", getOneInnerPercentThree()));
		if(getThreeInnerThree() != null) sb.append(__wrapNumber(count++, "threeInnerThree", getThreeInnerThree()));
		if(getThreeInnerPercentThree() != null) sb.append(__wrapString(count++, "threeInnerPercentThree", getThreeInnerPercentThree()));
		if(getFiveInnerThree() != null) sb.append(__wrapNumber(count++, "fiveInnerThree", getFiveInnerThree()));
		if(getFiveInnerPercentThree() != null) sb.append(__wrapString(count++, "fiveInnerPercentThree", getFiveInnerPercentThree()));
		if(getTenInnerThree() != null) sb.append(__wrapNumber(count++, "tenInnerThree", getTenInnerThree()));
		if(getTenInnerPercentThree() != null) sb.append(__wrapString(count++, "tenInnerPercentThree", getTenInnerPercentThree()));
		if(getTenAddThree() != null) sb.append(__wrapNumber(count++, "tenAddThree", getTenAddThree()));
		if(getTenAddPercentThree() != null) sb.append(__wrapString(count++, "tenAddPercentThree", getTenAddPercentThree()));
		if(getTotalThree() != null) sb.append(__wrapNumber(count++, "totalThree", getTotalThree()));
		if(getOneInnerFour() != null) sb.append(__wrapNumber(count++, "oneInnerFour", getOneInnerFour()));
		if(getOneInnerPercentFour() != null) sb.append(__wrapString(count++, "oneInnerPercentFour", getOneInnerPercentFour()));
		if(getThreeInnerFour() != null) sb.append(__wrapNumber(count++, "threeInnerFour", getThreeInnerFour()));
		if(getThreeInnerPercentFour() != null) sb.append(__wrapString(count++, "threeInnerPercentFour", getThreeInnerPercentFour()));
		if(getFiveInnerFour() != null) sb.append(__wrapNumber(count++, "fiveInnerFour", getFiveInnerFour()));
		if(getFiveInnerPercentFour() != null) sb.append(__wrapString(count++, "fiveInnerPercentFour", getFiveInnerPercentFour()));
		if(getTenInnerFour() != null) sb.append(__wrapNumber(count++, "tenInnerFour", getTenInnerFour()));
		if(getTenInnerPercentFour() != null) sb.append(__wrapString(count++, "tenInnerPercentFour", getTenInnerPercentFour()));
		if(getTenAddFour() != null) sb.append(__wrapNumber(count++, "tenAddFour", getTenAddFour()));
		if(getTenAddPercentFour() != null) sb.append(__wrapString(count++, "tenAddPercentFour", getTenAddPercentFour()));
		if(getTotalFour() != null) sb.append(__wrapNumber(count++, "totalFour", getTotalFour()));
		if(getOneInnerFive() != null) sb.append(__wrapNumber(count++, "oneInnerFive", getOneInnerFive()));
		if(getOneInnerPercentFive() != null) sb.append(__wrapString(count++, "oneInnerPercentFive", getOneInnerPercentFive()));
		if(getThreeInnerFive() != null) sb.append(__wrapNumber(count++, "threeInnerFive", getThreeInnerFive()));
		if(getThreeInnerPercentFive() != null) sb.append(__wrapString(count++, "threeInnerPercentFive", getThreeInnerPercentFive()));
		if(getFiveInnerFive() != null) sb.append(__wrapNumber(count++, "fiveInnerFive", getFiveInnerFive()));
		if(getFiveInnerPercentFive() != null) sb.append(__wrapString(count++, "fiveInnerPercentFive", getFiveInnerPercentFive()));
		if(getTenInnerFive() != null) sb.append(__wrapNumber(count++, "tenInnerFive", getTenInnerFive()));
		if(getTenInnerPercentFive() != null) sb.append(__wrapString(count++, "tenInnerPercentFive", getTenInnerPercentFive()));
		if(getTenAddFive() != null) sb.append(__wrapNumber(count++, "tenAddFive", getTenAddFive()));
		if(getTenAddPercentFive() != null) sb.append(__wrapString(count++, "tenAddPercentFive", getTenAddPercentFive()));
		if(getTotalFive() != null) sb.append(__wrapNumber(count++, "totalFive", getTotalFive()));
		if(getOneInnerSix() != null) sb.append(__wrapNumber(count++, "oneInnerSix", getOneInnerSix()));
		if(getOneInnerPercentSix() != null) sb.append(__wrapString(count++, "oneInnerPercentSix", getOneInnerPercentSix()));
		if(getThreeInnerSix() != null) sb.append(__wrapNumber(count++, "threeInnerSix", getThreeInnerSix()));
		if(getThreeInnerPercentSix() != null) sb.append(__wrapString(count++, "threeInnerPercentSix", getThreeInnerPercentSix()));
		if(getFiveInnerSix() != null) sb.append(__wrapNumber(count++, "fiveInnerSix", getFiveInnerSix()));
		if(getFiveInnerPercentSix() != null) sb.append(__wrapString(count++, "fiveInnerPercentSix", getFiveInnerPercentSix()));
		if(getTenInnerSix() != null) sb.append(__wrapNumber(count++, "tenInnerSix", getTenInnerSix()));
		if(getTenInnerPercentSix() != null) sb.append(__wrapString(count++, "tenInnerPercentSix", getTenInnerPercentSix()));
		if(getTenAddSix() != null) sb.append(__wrapNumber(count++, "tenAddSix", getTenAddSix()));
		if(getTenAddPercentSix() != null) sb.append(__wrapString(count++, "tenAddPercentSix", getTenAddPercentSix()));
		if(getTotalSix() != null) sb.append(__wrapNumber(count++, "totalSix", getTotalSix()));
		if(getOneInnerSeven() != null) sb.append(__wrapNumber(count++, "oneInnerSeven", getOneInnerSeven()));
		if(getOneInnerPercentSeven() != null) sb.append(__wrapString(count++, "oneInnerPercentSeven", getOneInnerPercentSeven()));
		if(getThreeInnerSeven() != null) sb.append(__wrapNumber(count++, "threeInnerSeven", getThreeInnerSeven()));
		if(getThreeInnerPercentSeven() != null) sb.append(__wrapString(count++, "threeInnerPercentSeven", getThreeInnerPercentSeven()));
		if(getFiveInnerSeven() != null) sb.append(__wrapNumber(count++, "fiveInnerSeven", getFiveInnerSeven()));
		if(getFiveInnerPercentSeven() != null) sb.append(__wrapString(count++, "fiveInnerPercentSeven", getFiveInnerPercentSeven()));
		if(getTenInnerSeven() != null) sb.append(__wrapNumber(count++, "tenInnerSeven", getTenInnerSeven()));
		if(getTenInnerPercentSeven() != null) sb.append(__wrapString(count++, "tenInnerPercentSeven", getTenInnerPercentSeven()));
		if(getTenAddSeven() != null) sb.append(__wrapNumber(count++, "tenAddSeven", getTenAddSeven()));
		if(getTenAddPercentSeven() != null) sb.append(__wrapString(count++, "tenAddPercentSeven", getTenAddPercentSeven()));
		if(getTotalSeven() != null) sb.append(__wrapNumber(count++, "totalSeven", getTotalSeven()));
		if(getOneInnerEight() != null) sb.append(__wrapNumber(count++, "oneInnerEight", getOneInnerEight()));
		if(getOneInnerPercentEight() != null) sb.append(__wrapString(count++, "oneInnerPercentEight", getOneInnerPercentEight()));
		if(getThreeInnerEight() != null) sb.append(__wrapNumber(count++, "threeInnerEight", getThreeInnerEight()));
		if(getThreeInnerPercentEight() != null) sb.append(__wrapString(count++, "threeInnerPercentEight", getThreeInnerPercentEight()));
		if(getFiveInnerEight() != null) sb.append(__wrapNumber(count++, "fiveInnerEight", getFiveInnerEight()));
		if(getFiveInnerPercentEight() != null) sb.append(__wrapString(count++, "fiveInnerPercentEight", getFiveInnerPercentEight()));
		if(getTenInnerEight() != null) sb.append(__wrapNumber(count++, "tenInnerEight", getTenInnerEight()));
		if(getTenInnerPercentEight() != null) sb.append(__wrapString(count++, "tenInnerPercentEight", getTenInnerPercentEight()));
		if(getTenAddEight() != null) sb.append(__wrapNumber(count++, "tenAddEight", getTenAddEight()));
		if(getTenAddPercentEight() != null) sb.append(__wrapString(count++, "tenAddPercentEight", getTenAddPercentEight()));
		if(getTotalEight() != null) sb.append(__wrapNumber(count++, "totalEight", getTotalEight()));
		if(getOneInnerNine() != null) sb.append(__wrapNumber(count++, "oneInnerNine", getOneInnerNine()));
		if(getOneInnerPercentNine() != null) sb.append(__wrapString(count++, "oneInnerPercentNine", getOneInnerPercentNine()));
		if(getThreeInnerNine() != null) sb.append(__wrapNumber(count++, "threeInnerNine", getThreeInnerNine()));
		if(getThreeInnerPercentNine() != null) sb.append(__wrapString(count++, "threeInnerPercentNine", getThreeInnerPercentNine()));
		if(getFiveInnerNine() != null) sb.append(__wrapNumber(count++, "fiveInnerNine", getFiveInnerNine()));
		if(getFiveInnerPercentNine() != null) sb.append(__wrapString(count++, "fiveInnerPercentNine", getFiveInnerPercentNine()));
		if(getTenInnerNine() != null) sb.append(__wrapNumber(count++, "tenInnerNine", getTenInnerNine()));
		if(getTenInnerPercentNine() != null) sb.append(__wrapString(count++, "tenInnerPercentNine", getTenInnerPercentNine()));
		if(getTenAddNine() != null) sb.append(__wrapNumber(count++, "tenAddNine", getTenAddNine()));
		if(getTenAddPercentNine() != null) sb.append(__wrapString(count++, "tenAddPercentNine", getTenAddPercentNine()));
		if(getTotalNine() != null) sb.append(__wrapNumber(count++, "totalNine", getTotalNine()));
		if(getOneInnerTen() != null) sb.append(__wrapNumber(count++, "oneInnerTen", getOneInnerTen()));
		if(getOneInnerPercentTen() != null) sb.append(__wrapString(count++, "oneInnerPercentTen", getOneInnerPercentTen()));
		if(getThreeInnerTen() != null) sb.append(__wrapNumber(count++, "threeInnerTen", getThreeInnerTen()));
		if(getThreeInnerPercentTen() != null) sb.append(__wrapString(count++, "threeInnerPercentTen", getThreeInnerPercentTen()));
		if(getFiveInnerTen() != null) sb.append(__wrapNumber(count++, "fiveInnerTen", getFiveInnerTen()));
		if(getFiveInnerPercentTen() != null) sb.append(__wrapString(count++, "fiveInnerPercentTen", getFiveInnerPercentTen()));
		if(getTenInnerTen() != null) sb.append(__wrapNumber(count++, "tenInnerTen", getTenInnerTen()));
		if(getTenInnerPercentTen() != null) sb.append(__wrapString(count++, "tenInnerPercentTen", getTenInnerPercentTen()));
		if(getTenAddTen() != null) sb.append(__wrapNumber(count++, "tenAddTen", getTenAddTen()));
		if(getTenAddPercentTen() != null) sb.append(__wrapString(count++, "tenAddPercentTen", getTenAddPercentTen()));
		if(getTotalTen() != null) sb.append(__wrapNumber(count++, "totalTen", getTotalTen()));
		if(getOneInnerEleven() != null) sb.append(__wrapNumber(count++, "oneInnerEleven", getOneInnerEleven()));
		if(getOneInnerPercentEleven() != null) sb.append(__wrapString(count++, "oneInnerPercentEleven", getOneInnerPercentEleven()));
		if(getThreeInnerEleven() != null) sb.append(__wrapNumber(count++, "threeInnerEleven", getThreeInnerEleven()));
		if(getThreeInnerPercentEleven() != null) sb.append(__wrapString(count++, "threeInnerPercentEleven", getThreeInnerPercentEleven()));
		if(getFiveInnerEleven() != null) sb.append(__wrapNumber(count++, "fiveInnerEleven", getFiveInnerEleven()));
		if(getFiveInnerPercentEleven() != null) sb.append(__wrapString(count++, "fiveInnerPercentEleven", getFiveInnerPercentEleven()));
		if(getTenInnerEleven() != null) sb.append(__wrapNumber(count++, "tenInnerEleven", getTenInnerEleven()));
		if(getTenInnerPercentEleven() != null) sb.append(__wrapString(count++, "tenInnerPercentEleven", getTenInnerPercentEleven()));
		if(getTenAddEleven() != null) sb.append(__wrapNumber(count++, "tenAddEleven", getTenAddEleven()));
		if(getTenAddPercentEleven() != null) sb.append(__wrapString(count++, "tenAddPercentEleven", getTenAddPercentEleven()));
		if(getTotalEleven() != null) sb.append(__wrapNumber(count++, "totalEleven", getTotalEleven()));
		if(getOneInnerTwelf() != null) sb.append(__wrapNumber(count++, "oneInnerTwelf", getOneInnerTwelf()));
		if(getOneInnerPercentTwelf() != null) sb.append(__wrapString(count++, "oneInnerPercentTwelf", getOneInnerPercentTwelf()));
		if(getThreeInnerTwelf() != null) sb.append(__wrapNumber(count++, "threeInnerTwelf", getThreeInnerTwelf()));
		if(getThreeInnerPercentTwelf() != null) sb.append(__wrapString(count++, "threeInnerPercentTwelf", getThreeInnerPercentTwelf()));
		if(getFiveInnerTwelf() != null) sb.append(__wrapNumber(count++, "fiveInnerTwelf", getFiveInnerTwelf()));
		if(getFiveInnerPercentTwelf() != null) sb.append(__wrapString(count++, "fiveInnerPercentTwelf", getFiveInnerPercentTwelf()));
		if(getTenInnerTwelf() != null) sb.append(__wrapNumber(count++, "tenInnerTwelf", getTenInnerTwelf()));
		if(getTenInnerPercentTwelf() != null) sb.append(__wrapString(count++, "tenInnerPercentTwelf", getTenInnerPercentTwelf()));
		if(getTenAddTwelf() != null) sb.append(__wrapNumber(count++, "tenAddTwelf", getTenAddTwelf()));
		if(getTenAddPercentTwelf() != null) sb.append(__wrapString(count++, "tenAddPercentTwelf", getTenAddPercentTwelf()));
		if(getTotalTwelf() != null) sb.append(__wrapNumber(count++, "totalTwelf", getTotalTwelf()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("oneInner")) != null) setOneInner(__getInt(val)); 
		if((val = values.get("oneInnerPercent")) != null) setOneInnerPercent(__getString(val));
		if((val = values.get("threeInner")) != null) setThreeInner(__getInt(val)); 
		if((val = values.get("threeInnerPercent")) != null) setThreeInnerPercent(__getString(val));
		if((val = values.get("fiveInner")) != null) setFiveInner(__getInt(val)); 
		if((val = values.get("fiveInnerPercent")) != null) setFiveInnerPercent(__getString(val));
		if((val = values.get("tenInner")) != null) setTenInner(__getInt(val)); 
		if((val = values.get("tenInnerPercent")) != null) setTenInnerPercent(__getString(val));
		if((val = values.get("tenAdd")) != null) setTenAdd(__getInt(val)); 
		if((val = values.get("tenAddPercent")) != null) setTenAddPercent(__getString(val));
		if((val = values.get("total")) != null) setTotal(__getInt(val)); 
		if((val = values.get("oneInnerTwo")) != null) setOneInnerTwo(__getInt(val)); 
		if((val = values.get("oneInnerPercentTwo")) != null) setOneInnerPercentTwo(__getString(val));
		if((val = values.get("threeInnerTwo")) != null) setThreeInnerTwo(__getInt(val)); 
		if((val = values.get("threeInnerPercentTwo")) != null) setThreeInnerPercentTwo(__getString(val));
		if((val = values.get("fiveInnerTwo")) != null) setFiveInnerTwo(__getInt(val)); 
		if((val = values.get("fiveInnerPercentTwo")) != null) setFiveInnerPercentTwo(__getString(val));
		if((val = values.get("tenInnerTwo")) != null) setTenInnerTwo(__getInt(val)); 
		if((val = values.get("tenInnerPercentTwo")) != null) setTenInnerPercentTwo(__getString(val));
		if((val = values.get("tenAddTwo")) != null) setTenAddTwo(__getInt(val)); 
		if((val = values.get("tenAddPercentTwo")) != null) setTenAddPercentTwo(__getString(val));
		if((val = values.get("totalTwo")) != null) setTotalTwo(__getInt(val)); 
		if((val = values.get("oneInnerThree")) != null) setOneInnerThree(__getInt(val)); 
		if((val = values.get("oneInnerPercentThree")) != null) setOneInnerPercentThree(__getString(val));
		if((val = values.get("threeInnerThree")) != null) setThreeInnerThree(__getInt(val)); 
		if((val = values.get("threeInnerPercentThree")) != null) setThreeInnerPercentThree(__getString(val));
		if((val = values.get("fiveInnerThree")) != null) setFiveInnerThree(__getInt(val)); 
		if((val = values.get("fiveInnerPercentThree")) != null) setFiveInnerPercentThree(__getString(val));
		if((val = values.get("tenInnerThree")) != null) setTenInnerThree(__getInt(val)); 
		if((val = values.get("tenInnerPercentThree")) != null) setTenInnerPercentThree(__getString(val));
		if((val = values.get("tenAddThree")) != null) setTenAddThree(__getInt(val)); 
		if((val = values.get("tenAddPercentThree")) != null) setTenAddPercentThree(__getString(val));
		if((val = values.get("totalThree")) != null) setTotalThree(__getInt(val)); 
		if((val = values.get("oneInnerFour")) != null) setOneInnerFour(__getInt(val)); 
		if((val = values.get("oneInnerPercentFour")) != null) setOneInnerPercentFour(__getString(val));
		if((val = values.get("threeInnerFour")) != null) setThreeInnerFour(__getInt(val)); 
		if((val = values.get("threeInnerPercentFour")) != null) setThreeInnerPercentFour(__getString(val));
		if((val = values.get("fiveInnerFour")) != null) setFiveInnerFour(__getInt(val)); 
		if((val = values.get("fiveInnerPercentFour")) != null) setFiveInnerPercentFour(__getString(val));
		if((val = values.get("tenInnerFour")) != null) setTenInnerFour(__getInt(val)); 
		if((val = values.get("tenInnerPercentFour")) != null) setTenInnerPercentFour(__getString(val));
		if((val = values.get("tenAddFour")) != null) setTenAddFour(__getInt(val)); 
		if((val = values.get("tenAddPercentFour")) != null) setTenAddPercentFour(__getString(val));
		if((val = values.get("totalFour")) != null) setTotalFour(__getInt(val)); 
		if((val = values.get("oneInnerFive")) != null) setOneInnerFive(__getInt(val)); 
		if((val = values.get("oneInnerPercentFive")) != null) setOneInnerPercentFive(__getString(val));
		if((val = values.get("threeInnerFive")) != null) setThreeInnerFive(__getInt(val)); 
		if((val = values.get("threeInnerPercentFive")) != null) setThreeInnerPercentFive(__getString(val));
		if((val = values.get("fiveInnerFive")) != null) setFiveInnerFive(__getInt(val)); 
		if((val = values.get("fiveInnerPercentFive")) != null) setFiveInnerPercentFive(__getString(val));
		if((val = values.get("tenInnerFive")) != null) setTenInnerFive(__getInt(val)); 
		if((val = values.get("tenInnerPercentFive")) != null) setTenInnerPercentFive(__getString(val));
		if((val = values.get("tenAddFive")) != null) setTenAddFive(__getInt(val)); 
		if((val = values.get("tenAddPercentFive")) != null) setTenAddPercentFive(__getString(val));
		if((val = values.get("totalFive")) != null) setTotalFive(__getInt(val)); 
		if((val = values.get("oneInnerSix")) != null) setOneInnerSix(__getInt(val)); 
		if((val = values.get("oneInnerPercentSix")) != null) setOneInnerPercentSix(__getString(val));
		if((val = values.get("threeInnerSix")) != null) setThreeInnerSix(__getInt(val)); 
		if((val = values.get("threeInnerPercentSix")) != null) setThreeInnerPercentSix(__getString(val));
		if((val = values.get("fiveInnerSix")) != null) setFiveInnerSix(__getInt(val)); 
		if((val = values.get("fiveInnerPercentSix")) != null) setFiveInnerPercentSix(__getString(val));
		if((val = values.get("tenInnerSix")) != null) setTenInnerSix(__getInt(val)); 
		if((val = values.get("tenInnerPercentSix")) != null) setTenInnerPercentSix(__getString(val));
		if((val = values.get("tenAddSix")) != null) setTenAddSix(__getInt(val)); 
		if((val = values.get("tenAddPercentSix")) != null) setTenAddPercentSix(__getString(val));
		if((val = values.get("totalSix")) != null) setTotalSix(__getInt(val)); 
		if((val = values.get("oneInnerSeven")) != null) setOneInnerSeven(__getInt(val)); 
		if((val = values.get("oneInnerPercentSeven")) != null) setOneInnerPercentSeven(__getString(val));
		if((val = values.get("threeInnerSeven")) != null) setThreeInnerSeven(__getInt(val)); 
		if((val = values.get("threeInnerPercentSeven")) != null) setThreeInnerPercentSeven(__getString(val));
		if((val = values.get("fiveInnerSeven")) != null) setFiveInnerSeven(__getInt(val)); 
		if((val = values.get("fiveInnerPercentSeven")) != null) setFiveInnerPercentSeven(__getString(val));
		if((val = values.get("tenInnerSeven")) != null) setTenInnerSeven(__getInt(val)); 
		if((val = values.get("tenInnerPercentSeven")) != null) setTenInnerPercentSeven(__getString(val));
		if((val = values.get("tenAddSeven")) != null) setTenAddSeven(__getInt(val)); 
		if((val = values.get("tenAddPercentSeven")) != null) setTenAddPercentSeven(__getString(val));
		if((val = values.get("totalSeven")) != null) setTotalSeven(__getInt(val)); 
		if((val = values.get("oneInnerEight")) != null) setOneInnerEight(__getInt(val)); 
		if((val = values.get("oneInnerPercentEight")) != null) setOneInnerPercentEight(__getString(val));
		if((val = values.get("threeInnerEight")) != null) setThreeInnerEight(__getInt(val)); 
		if((val = values.get("threeInnerPercentEight")) != null) setThreeInnerPercentEight(__getString(val));
		if((val = values.get("fiveInnerEight")) != null) setFiveInnerEight(__getInt(val)); 
		if((val = values.get("fiveInnerPercentEight")) != null) setFiveInnerPercentEight(__getString(val));
		if((val = values.get("tenInnerEight")) != null) setTenInnerEight(__getInt(val)); 
		if((val = values.get("tenInnerPercentEight")) != null) setTenInnerPercentEight(__getString(val));
		if((val = values.get("tenAddEight")) != null) setTenAddEight(__getInt(val)); 
		if((val = values.get("tenAddPercentEight")) != null) setTenAddPercentEight(__getString(val));
		if((val = values.get("totalEight")) != null) setTotalEight(__getInt(val)); 
		if((val = values.get("oneInnerNine")) != null) setOneInnerNine(__getInt(val)); 
		if((val = values.get("oneInnerPercentNine")) != null) setOneInnerPercentNine(__getString(val));
		if((val = values.get("threeInnerNine")) != null) setThreeInnerNine(__getInt(val)); 
		if((val = values.get("threeInnerPercentNine")) != null) setThreeInnerPercentNine(__getString(val));
		if((val = values.get("fiveInnerNine")) != null) setFiveInnerNine(__getInt(val)); 
		if((val = values.get("fiveInnerPercentNine")) != null) setFiveInnerPercentNine(__getString(val));
		if((val = values.get("tenInnerNine")) != null) setTenInnerNine(__getInt(val)); 
		if((val = values.get("tenInnerPercentNine")) != null) setTenInnerPercentNine(__getString(val));
		if((val = values.get("tenAddNine")) != null) setTenAddNine(__getInt(val)); 
		if((val = values.get("tenAddPercentNine")) != null) setTenAddPercentNine(__getString(val));
		if((val = values.get("totalNine")) != null) setTotalNine(__getInt(val)); 
		if((val = values.get("oneInnerTen")) != null) setOneInnerTen(__getInt(val)); 
		if((val = values.get("oneInnerPercentTen")) != null) setOneInnerPercentTen(__getString(val));
		if((val = values.get("threeInnerTen")) != null) setThreeInnerTen(__getInt(val)); 
		if((val = values.get("threeInnerPercentTen")) != null) setThreeInnerPercentTen(__getString(val));
		if((val = values.get("fiveInnerTen")) != null) setFiveInnerTen(__getInt(val)); 
		if((val = values.get("fiveInnerPercentTen")) != null) setFiveInnerPercentTen(__getString(val));
		if((val = values.get("tenInnerTen")) != null) setTenInnerTen(__getInt(val)); 
		if((val = values.get("tenInnerPercentTen")) != null) setTenInnerPercentTen(__getString(val));
		if((val = values.get("tenAddTen")) != null) setTenAddTen(__getInt(val)); 
		if((val = values.get("tenAddPercentTen")) != null) setTenAddPercentTen(__getString(val));
		if((val = values.get("totalTen")) != null) setTotalTen(__getInt(val)); 
		if((val = values.get("oneInnerEleven")) != null) setOneInnerEleven(__getInt(val)); 
		if((val = values.get("oneInnerPercentEleven")) != null) setOneInnerPercentEleven(__getString(val));
		if((val = values.get("threeInnerEleven")) != null) setThreeInnerEleven(__getInt(val)); 
		if((val = values.get("threeInnerPercentEleven")) != null) setThreeInnerPercentEleven(__getString(val));
		if((val = values.get("fiveInnerEleven")) != null) setFiveInnerEleven(__getInt(val)); 
		if((val = values.get("fiveInnerPercentEleven")) != null) setFiveInnerPercentEleven(__getString(val));
		if((val = values.get("tenInnerEleven")) != null) setTenInnerEleven(__getInt(val)); 
		if((val = values.get("tenInnerPercentEleven")) != null) setTenInnerPercentEleven(__getString(val));
		if((val = values.get("tenAddEleven")) != null) setTenAddEleven(__getInt(val)); 
		if((val = values.get("tenAddPercentEleven")) != null) setTenAddPercentEleven(__getString(val));
		if((val = values.get("totalEleven")) != null) setTotalEleven(__getInt(val)); 
		if((val = values.get("oneInnerTwelf")) != null) setOneInnerTwelf(__getInt(val)); 
		if((val = values.get("oneInnerPercentTwelf")) != null) setOneInnerPercentTwelf(__getString(val));
		if((val = values.get("threeInnerTwelf")) != null) setThreeInnerTwelf(__getInt(val)); 
		if((val = values.get("threeInnerPercentTwelf")) != null) setThreeInnerPercentTwelf(__getString(val));
		if((val = values.get("fiveInnerTwelf")) != null) setFiveInnerTwelf(__getInt(val)); 
		if((val = values.get("fiveInnerPercentTwelf")) != null) setFiveInnerPercentTwelf(__getString(val));
		if((val = values.get("tenInnerTwelf")) != null) setTenInnerTwelf(__getInt(val)); 
		if((val = values.get("tenInnerPercentTwelf")) != null) setTenInnerPercentTwelf(__getString(val));
		if((val = values.get("tenAddTwelf")) != null) setTenAddTwelf(__getInt(val)); 
		if((val = values.get("tenAddPercentTwelf")) != null) setTenAddPercentTwelf(__getString(val));
		if((val = values.get("totalTwelf")) != null) setTotalTwelf(__getInt(val)); 
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __one_inner ;
	protected java.lang.String  __one_inner_percent ;
	protected java.lang.Integer  __three_inner ;
	protected java.lang.String  __three_inner_percent ;
	protected java.lang.Integer  __five_inner ;
	protected java.lang.String  __five_inner_percent ;
	protected java.lang.Integer  __ten_inner ;
	protected java.lang.String  __ten_inner_percent ;
	protected java.lang.Integer  __ten_add ;
	protected java.lang.String  __ten_add_percent ;
	protected java.lang.Integer  __total ;
	protected java.lang.Integer  __one_inner_two ;
	protected java.lang.String  __one_inner_percent_two ;
	protected java.lang.Integer  __three_inner_two ;
	protected java.lang.String  __three_inner_percent_two ;
	protected java.lang.Integer  __five_inner_two ;
	protected java.lang.String  __five_inner_percent_two ;
	protected java.lang.Integer  __ten_inner_two ;
	protected java.lang.String  __ten_inner_percent_two ;
	protected java.lang.Integer  __ten_add_two ;
	protected java.lang.String  __ten_add_percent_two ;
	protected java.lang.Integer  __total_two ;
	protected java.lang.Integer  __one_inner_three ;
	protected java.lang.String  __one_inner_percent_three ;
	protected java.lang.Integer  __three_inner_three ;
	protected java.lang.String  __three_inner_percent_three ;
	protected java.lang.Integer  __five_inner_three ;
	protected java.lang.String  __five_inner_percent_three ;
	protected java.lang.Integer  __ten_inner_three ;
	protected java.lang.String  __ten_inner_percent_three ;
	protected java.lang.Integer  __ten_add_three ;
	protected java.lang.String  __ten_add_percent_three ;
	protected java.lang.Integer  __total_three ;
	protected java.lang.Integer  __one_inner_four ;
	protected java.lang.String  __one_inner_percent_four ;
	protected java.lang.Integer  __three_inner_four ;
	protected java.lang.String  __three_inner_percent_four ;
	protected java.lang.Integer  __five_inner_four ;
	protected java.lang.String  __five_inner_percent_four ;
	protected java.lang.Integer  __ten_inner_four ;
	protected java.lang.String  __ten_inner_percent_four ;
	protected java.lang.Integer  __ten_add_four ;
	protected java.lang.String  __ten_add_percent_four ;
	protected java.lang.Integer  __total_four ;
	protected java.lang.Integer  __one_inner_five ;
	protected java.lang.String  __one_inner_percent_five ;
	protected java.lang.Integer  __three_inner_five ;
	protected java.lang.String  __three_inner_percent_five ;
	protected java.lang.Integer  __five_inner_five ;
	protected java.lang.String  __five_inner_percent_five ;
	protected java.lang.Integer  __ten_inner_five ;
	protected java.lang.String  __ten_inner_percent_five ;
	protected java.lang.Integer  __ten_add_five ;
	protected java.lang.String  __ten_add_percent_five ;
	protected java.lang.Integer  __total_five ;
	protected java.lang.Integer  __one_inner_six ;
	protected java.lang.String  __one_inner_percent_six ;
	protected java.lang.Integer  __three_inner_six ;
	protected java.lang.String  __three_inner_percent_six ;
	protected java.lang.Integer  __five_inner_six ;
	protected java.lang.String  __five_inner_percent_six ;
	protected java.lang.Integer  __ten_inner_six ;
	protected java.lang.String  __ten_inner_percent_six ;
	protected java.lang.Integer  __ten_add_six ;
	protected java.lang.String  __ten_add_percent_six ;
	protected java.lang.Integer  __total_six ;
	protected java.lang.Integer  __one_inner_seven ;
	protected java.lang.String  __one_inner_percent_seven ;
	protected java.lang.Integer  __three_inner_seven ;
	protected java.lang.String  __three_inner_percent_seven ;
	protected java.lang.Integer  __five_inner_seven ;
	protected java.lang.String  __five_inner_percent_seven ;
	protected java.lang.Integer  __ten_inner_seven ;
	protected java.lang.String  __ten_inner_percent_seven ;
	protected java.lang.Integer  __ten_add_seven ;
	protected java.lang.String  __ten_add_percent_seven ;
	protected java.lang.Integer  __total_seven ;
	protected java.lang.Integer  __one_inner_eight ;
	protected java.lang.String  __one_inner_percent_eight ;
	protected java.lang.Integer  __three_inner_eight ;
	protected java.lang.String  __three_inner_percent_eight ;
	protected java.lang.Integer  __five_inner_eight ;
	protected java.lang.String  __five_inner_percent_eight ;
	protected java.lang.Integer  __ten_inner_eight ;
	protected java.lang.String  __ten_inner_percent_eight ;
	protected java.lang.Integer  __ten_add_eight ;
	protected java.lang.String  __ten_add_percent_eight ;
	protected java.lang.Integer  __total_eight ;
	protected java.lang.Integer  __one_inner_nine ;
	protected java.lang.String  __one_inner_percent_nine ;
	protected java.lang.Integer  __three_inner_nine ;
	protected java.lang.String  __three_inner_percent_nine ;
	protected java.lang.Integer  __five_inner_nine ;
	protected java.lang.String  __five_inner_percent_nine ;
	protected java.lang.Integer  __ten_inner_nine ;
	protected java.lang.String  __ten_inner_percent_nine ;
	protected java.lang.Integer  __ten_add_nine ;
	protected java.lang.String  __ten_add_percent_nine ;
	protected java.lang.Integer  __total_nine ;
	protected java.lang.Integer  __one_inner_ten ;
	protected java.lang.String  __one_inner_percent_ten ;
	protected java.lang.Integer  __three_inner_ten ;
	protected java.lang.String  __three_inner_percent_ten ;
	protected java.lang.Integer  __five_inner_ten ;
	protected java.lang.String  __five_inner_percent_ten ;
	protected java.lang.Integer  __ten_inner_ten ;
	protected java.lang.String  __ten_inner_percent_ten ;
	protected java.lang.Integer  __ten_add_ten ;
	protected java.lang.String  __ten_add_percent_ten ;
	protected java.lang.Integer  __total_ten ;
	protected java.lang.Integer  __one_inner_eleven ;
	protected java.lang.String  __one_inner_percent_eleven ;
	protected java.lang.Integer  __three_inner_eleven ;
	protected java.lang.String  __three_inner_percent_eleven ;
	protected java.lang.Integer  __five_inner_eleven ;
	protected java.lang.String  __five_inner_percent_eleven ;
	protected java.lang.Integer  __ten_inner_eleven ;
	protected java.lang.String  __ten_inner_percent_eleven ;
	protected java.lang.Integer  __ten_add_eleven ;
	protected java.lang.String  __ten_add_percent_eleven ;
	protected java.lang.Integer  __total_eleven ;
	protected java.lang.Integer  __one_inner_twelf ;
	protected java.lang.String  __one_inner_percent_twelf ;
	protected java.lang.Integer  __three_inner_twelf ;
	protected java.lang.String  __three_inner_percent_twelf ;
	protected java.lang.Integer  __five_inner_twelf ;
	protected java.lang.String  __five_inner_percent_twelf ;
	protected java.lang.Integer  __ten_inner_twelf ;
	protected java.lang.String  __ten_inner_percent_twelf ;
	protected java.lang.Integer  __ten_add_twelf ;
	protected java.lang.String  __ten_add_percent_twelf ;
	protected java.lang.Integer  __total_twelf ;
}

