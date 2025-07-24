package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOnEmployeeSeniorityTotalByDepartment extends GenericBase implements BaseFactory<BaseReportOnEmployeeSeniorityTotalByDepartment>, Comparable<BaseReportOnEmployeeSeniorityTotalByDepartment> 
{


	public static BaseReportOnEmployeeSeniorityTotalByDepartment newInstance(){
		return new BaseReportOnEmployeeSeniorityTotalByDepartment();
	}

	@Override
	public BaseReportOnEmployeeSeniorityTotalByDepartment make(){
		BaseReportOnEmployeeSeniorityTotalByDepartment b = new BaseReportOnEmployeeSeniorityTotalByDepartment();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_ONE_NUM_1 = "one_num_1" ;
	public final static java.lang.String CS_TWO_NUM_1 = "two_num_1" ;
	public final static java.lang.String CS_THREE_NUM_1 = "three_num_1" ;
	public final static java.lang.String CS_FOUR_NUM_1 = "four_num_1" ;
	public final static java.lang.String CS_FIVE_NUM_1 = "five_num_1" ;
	public final static java.lang.String CS_TOTAL_NUM_1 = "total_num_1" ;
	public final static java.lang.String CS_ONE_NUM_2 = "one_num_2" ;
	public final static java.lang.String CS_TWO_NUM_2 = "two_num_2" ;
	public final static java.lang.String CS_THREE_NUM_2 = "three_num_2" ;
	public final static java.lang.String CS_FOUR_NUM_2 = "four_num_2" ;
	public final static java.lang.String CS_FIVE_NUM_2 = "five_num_2" ;
	public final static java.lang.String CS_TOTAL_NUM_2 = "total_num_2" ;
	public final static java.lang.String CS_ONE_NUM_3 = "one_num_3" ;
	public final static java.lang.String CS_TWO_NUM_3 = "two_num_3" ;
	public final static java.lang.String CS_THREE_NUM_3 = "three_num_3" ;
	public final static java.lang.String CS_FOUR_NUM_3 = "four_num_3" ;
	public final static java.lang.String CS_FIVE_NUM_3 = "five_num_3" ;
	public final static java.lang.String CS_TOTAL_NUM_3 = "total_num_3" ;
	public final static java.lang.String CS_ONE_NUM_4 = "one_num_4" ;
	public final static java.lang.String CS_TWO_NUM_4 = "two_num_4" ;
	public final static java.lang.String CS_THREE_NUM_4 = "three_num_4" ;
	public final static java.lang.String CS_FOUR_NUM_4 = "four_num_4" ;
	public final static java.lang.String CS_FIVE_NUM_4 = "five_num_4" ;
	public final static java.lang.String CS_TOTAL_NUM_4 = "total_num_4" ;
	public final static java.lang.String CS_ONE_NUM_5 = "one_num_5" ;
	public final static java.lang.String CS_TWO_NUM_5 = "two_num_5" ;
	public final static java.lang.String CS_THREE_NUM_5 = "three_num_5" ;
	public final static java.lang.String CS_FOUR_NUM_5 = "four_num_5" ;
	public final static java.lang.String CS_FIVE_NUM_5 = "five_num_5" ;
	public final static java.lang.String CS_TOTAL_NUM_5 = "total_num_5" ;
	public final static java.lang.String CS_ONE_NUM_6 = "one_num_6" ;
	public final static java.lang.String CS_TWO_NUM_6 = "two_num_6" ;
	public final static java.lang.String CS_THREE_NUM_6 = "three_num_6" ;
	public final static java.lang.String CS_FOUR_NUM_6 = "four_num_6" ;
	public final static java.lang.String CS_FIVE_NUM_6 = "five_num_6" ;
	public final static java.lang.String CS_TOTAL_NUM_6 = "total_num_6" ;
	public final static java.lang.String CS_ONE_NUM_7 = "one_num_7" ;
	public final static java.lang.String CS_TWO_NUM_7 = "two_num_7" ;
	public final static java.lang.String CS_THREE_NUM_7 = "three_num_7" ;
	public final static java.lang.String CS_FOUR_NUM_7 = "four_num_7" ;
	public final static java.lang.String CS_FIVE_NUM_7 = "five_num_7" ;
	public final static java.lang.String CS_TOTAL_NUM_7 = "total_num_7" ;
	public final static java.lang.String CS_ONE_NUM_8 = "one_num_8" ;
	public final static java.lang.String CS_TWO_NUM_8 = "two_num_8" ;
	public final static java.lang.String CS_THREE_NUM_8 = "three_num_8" ;
	public final static java.lang.String CS_FOUR_NUM_8 = "four_num_8" ;
	public final static java.lang.String CS_FIVE_NUM_8 = "five_num_8" ;
	public final static java.lang.String CS_TOTAL_NUM_8 = "total_num_8" ;
	public final static java.lang.String CS_ONE_NUM_9 = "one_num_9" ;
	public final static java.lang.String CS_TWO_NUM_9 = "two_num_9" ;
	public final static java.lang.String CS_THREE_NUM_9 = "three_num_9" ;
	public final static java.lang.String CS_FOUR_NUM_9 = "four_num_9" ;
	public final static java.lang.String CS_FIVE_NUM_9 = "five_num_9" ;
	public final static java.lang.String CS_TOTAL_NUM_9 = "total_num_9" ;
	public final static java.lang.String CS_ONE_NUM_10 = "one_num_10" ;
	public final static java.lang.String CS_TWO_NUM_10 = "two_num_10" ;
	public final static java.lang.String CS_THREE_NUM_10 = "three_num_10" ;
	public final static java.lang.String CS_FOUR_NUM_10 = "four_num_10" ;
	public final static java.lang.String CS_FIVE_NUM_10 = "five_num_10" ;
	public final static java.lang.String CS_TOTAL_NUM_10 = "total_num_10" ;
	public final static java.lang.String CS_ONE_NUM_11 = "one_num_11" ;
	public final static java.lang.String CS_TWO_NUM_11 = "two_num_11" ;
	public final static java.lang.String CS_THREE_NUM_11 = "three_num_11" ;
	public final static java.lang.String CS_FOUR_NUM_11 = "four_num_11" ;
	public final static java.lang.String CS_FIVE_NUM_11 = "five_num_11" ;
	public final static java.lang.String CS_TOTAL_NUM_11 = "total_num_11" ;
	public final static java.lang.String CS_ONE_NUM_12 = "one_num_12" ;
	public final static java.lang.String CS_TWO_NUM_12 = "two_num_12" ;
	public final static java.lang.String CS_THREE_NUM_12 = "three_num_12" ;
	public final static java.lang.String CS_FOUR_NUM_12 = "four_num_12" ;
	public final static java.lang.String CS_FIVE_NUM_12 = "five_num_12" ;
	public final static java.lang.String CS_TOTAL_NUM_12 = "total_num_12" ;

	public final static java.lang.String ALL_CAPTIONS = "所属部门,年份,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

	public java.lang.Integer getDepartmentId() {
		return this.__department_id;
	}

	public void setDepartmentId( java.lang.Integer value ) {
		this.__department_id = value;
	}

	public java.lang.Integer getYear() {
		return this.__year;
	}

	public void setYear( java.lang.Integer value ) {
		this.__year = value;
	}

	public java.math.BigDecimal getOneNum1() {
		return this.__one_num_1;
	}

	public void setOneNum1( java.math.BigDecimal value ) {
		this.__one_num_1 = value;
	}

	public java.math.BigDecimal getTwoNum1() {
		return this.__two_num_1;
	}

	public void setTwoNum1( java.math.BigDecimal value ) {
		this.__two_num_1 = value;
	}

	public java.math.BigDecimal getThreeNum1() {
		return this.__three_num_1;
	}

	public void setThreeNum1( java.math.BigDecimal value ) {
		this.__three_num_1 = value;
	}

	public java.math.BigDecimal getFourNum1() {
		return this.__four_num_1;
	}

	public void setFourNum1( java.math.BigDecimal value ) {
		this.__four_num_1 = value;
	}

	public java.math.BigDecimal getFiveNum1() {
		return this.__five_num_1;
	}

	public void setFiveNum1( java.math.BigDecimal value ) {
		this.__five_num_1 = value;
	}

	public java.math.BigDecimal getTotalNum1() {
		return this.__total_num_1;
	}

	public void setTotalNum1( java.math.BigDecimal value ) {
		this.__total_num_1 = value;
	}

	public java.math.BigDecimal getOneNum2() {
		return this.__one_num_2;
	}

	public void setOneNum2( java.math.BigDecimal value ) {
		this.__one_num_2 = value;
	}

	public java.math.BigDecimal getTwoNum2() {
		return this.__two_num_2;
	}

	public void setTwoNum2( java.math.BigDecimal value ) {
		this.__two_num_2 = value;
	}

	public java.math.BigDecimal getThreeNum2() {
		return this.__three_num_2;
	}

	public void setThreeNum2( java.math.BigDecimal value ) {
		this.__three_num_2 = value;
	}

	public java.math.BigDecimal getFourNum2() {
		return this.__four_num_2;
	}

	public void setFourNum2( java.math.BigDecimal value ) {
		this.__four_num_2 = value;
	}

	public java.math.BigDecimal getFiveNum2() {
		return this.__five_num_2;
	}

	public void setFiveNum2( java.math.BigDecimal value ) {
		this.__five_num_2 = value;
	}

	public java.math.BigDecimal getTotalNum2() {
		return this.__total_num_2;
	}

	public void setTotalNum2( java.math.BigDecimal value ) {
		this.__total_num_2 = value;
	}

	public java.math.BigDecimal getOneNum3() {
		return this.__one_num_3;
	}

	public void setOneNum3( java.math.BigDecimal value ) {
		this.__one_num_3 = value;
	}

	public java.math.BigDecimal getTwoNum3() {
		return this.__two_num_3;
	}

	public void setTwoNum3( java.math.BigDecimal value ) {
		this.__two_num_3 = value;
	}

	public java.math.BigDecimal getThreeNum3() {
		return this.__three_num_3;
	}

	public void setThreeNum3( java.math.BigDecimal value ) {
		this.__three_num_3 = value;
	}

	public java.math.BigDecimal getFourNum3() {
		return this.__four_num_3;
	}

	public void setFourNum3( java.math.BigDecimal value ) {
		this.__four_num_3 = value;
	}

	public java.math.BigDecimal getFiveNum3() {
		return this.__five_num_3;
	}

	public void setFiveNum3( java.math.BigDecimal value ) {
		this.__five_num_3 = value;
	}

	public java.math.BigDecimal getTotalNum3() {
		return this.__total_num_3;
	}

	public void setTotalNum3( java.math.BigDecimal value ) {
		this.__total_num_3 = value;
	}

	public java.math.BigDecimal getOneNum4() {
		return this.__one_num_4;
	}

	public void setOneNum4( java.math.BigDecimal value ) {
		this.__one_num_4 = value;
	}

	public java.math.BigDecimal getTwoNum4() {
		return this.__two_num_4;
	}

	public void setTwoNum4( java.math.BigDecimal value ) {
		this.__two_num_4 = value;
	}

	public java.math.BigDecimal getThreeNum4() {
		return this.__three_num_4;
	}

	public void setThreeNum4( java.math.BigDecimal value ) {
		this.__three_num_4 = value;
	}

	public java.math.BigDecimal getFourNum4() {
		return this.__four_num_4;
	}

	public void setFourNum4( java.math.BigDecimal value ) {
		this.__four_num_4 = value;
	}

	public java.math.BigDecimal getFiveNum4() {
		return this.__five_num_4;
	}

	public void setFiveNum4( java.math.BigDecimal value ) {
		this.__five_num_4 = value;
	}

	public java.math.BigDecimal getTotalNum4() {
		return this.__total_num_4;
	}

	public void setTotalNum4( java.math.BigDecimal value ) {
		this.__total_num_4 = value;
	}

	public java.math.BigDecimal getOneNum5() {
		return this.__one_num_5;
	}

	public void setOneNum5( java.math.BigDecimal value ) {
		this.__one_num_5 = value;
	}

	public java.math.BigDecimal getTwoNum5() {
		return this.__two_num_5;
	}

	public void setTwoNum5( java.math.BigDecimal value ) {
		this.__two_num_5 = value;
	}

	public java.math.BigDecimal getThreeNum5() {
		return this.__three_num_5;
	}

	public void setThreeNum5( java.math.BigDecimal value ) {
		this.__three_num_5 = value;
	}

	public java.math.BigDecimal getFourNum5() {
		return this.__four_num_5;
	}

	public void setFourNum5( java.math.BigDecimal value ) {
		this.__four_num_5 = value;
	}

	public java.math.BigDecimal getFiveNum5() {
		return this.__five_num_5;
	}

	public void setFiveNum5( java.math.BigDecimal value ) {
		this.__five_num_5 = value;
	}

	public java.math.BigDecimal getTotalNum5() {
		return this.__total_num_5;
	}

	public void setTotalNum5( java.math.BigDecimal value ) {
		this.__total_num_5 = value;
	}

	public java.math.BigDecimal getOneNum6() {
		return this.__one_num_6;
	}

	public void setOneNum6( java.math.BigDecimal value ) {
		this.__one_num_6 = value;
	}

	public java.math.BigDecimal getTwoNum6() {
		return this.__two_num_6;
	}

	public void setTwoNum6( java.math.BigDecimal value ) {
		this.__two_num_6 = value;
	}

	public java.math.BigDecimal getThreeNum6() {
		return this.__three_num_6;
	}

	public void setThreeNum6( java.math.BigDecimal value ) {
		this.__three_num_6 = value;
	}

	public java.math.BigDecimal getFourNum6() {
		return this.__four_num_6;
	}

	public void setFourNum6( java.math.BigDecimal value ) {
		this.__four_num_6 = value;
	}

	public java.math.BigDecimal getFiveNum6() {
		return this.__five_num_6;
	}

	public void setFiveNum6( java.math.BigDecimal value ) {
		this.__five_num_6 = value;
	}

	public java.math.BigDecimal getTotalNum6() {
		return this.__total_num_6;
	}

	public void setTotalNum6( java.math.BigDecimal value ) {
		this.__total_num_6 = value;
	}

	public java.math.BigDecimal getOneNum7() {
		return this.__one_num_7;
	}

	public void setOneNum7( java.math.BigDecimal value ) {
		this.__one_num_7 = value;
	}

	public java.math.BigDecimal getTwoNum7() {
		return this.__two_num_7;
	}

	public void setTwoNum7( java.math.BigDecimal value ) {
		this.__two_num_7 = value;
	}

	public java.math.BigDecimal getThreeNum7() {
		return this.__three_num_7;
	}

	public void setThreeNum7( java.math.BigDecimal value ) {
		this.__three_num_7 = value;
	}

	public java.math.BigDecimal getFourNum7() {
		return this.__four_num_7;
	}

	public void setFourNum7( java.math.BigDecimal value ) {
		this.__four_num_7 = value;
	}

	public java.math.BigDecimal getFiveNum7() {
		return this.__five_num_7;
	}

	public void setFiveNum7( java.math.BigDecimal value ) {
		this.__five_num_7 = value;
	}

	public java.math.BigDecimal getTotalNum7() {
		return this.__total_num_7;
	}

	public void setTotalNum7( java.math.BigDecimal value ) {
		this.__total_num_7 = value;
	}

	public java.math.BigDecimal getOneNum8() {
		return this.__one_num_8;
	}

	public void setOneNum8( java.math.BigDecimal value ) {
		this.__one_num_8 = value;
	}

	public java.math.BigDecimal getTwoNum8() {
		return this.__two_num_8;
	}

	public void setTwoNum8( java.math.BigDecimal value ) {
		this.__two_num_8 = value;
	}

	public java.math.BigDecimal getThreeNum8() {
		return this.__three_num_8;
	}

	public void setThreeNum8( java.math.BigDecimal value ) {
		this.__three_num_8 = value;
	}

	public java.math.BigDecimal getFourNum8() {
		return this.__four_num_8;
	}

	public void setFourNum8( java.math.BigDecimal value ) {
		this.__four_num_8 = value;
	}

	public java.math.BigDecimal getFiveNum8() {
		return this.__five_num_8;
	}

	public void setFiveNum8( java.math.BigDecimal value ) {
		this.__five_num_8 = value;
	}

	public java.math.BigDecimal getTotalNum8() {
		return this.__total_num_8;
	}

	public void setTotalNum8( java.math.BigDecimal value ) {
		this.__total_num_8 = value;
	}

	public java.math.BigDecimal getOneNum9() {
		return this.__one_num_9;
	}

	public void setOneNum9( java.math.BigDecimal value ) {
		this.__one_num_9 = value;
	}

	public java.math.BigDecimal getTwoNum9() {
		return this.__two_num_9;
	}

	public void setTwoNum9( java.math.BigDecimal value ) {
		this.__two_num_9 = value;
	}

	public java.math.BigDecimal getThreeNum9() {
		return this.__three_num_9;
	}

	public void setThreeNum9( java.math.BigDecimal value ) {
		this.__three_num_9 = value;
	}

	public java.math.BigDecimal getFourNum9() {
		return this.__four_num_9;
	}

	public void setFourNum9( java.math.BigDecimal value ) {
		this.__four_num_9 = value;
	}

	public java.math.BigDecimal getFiveNum9() {
		return this.__five_num_9;
	}

	public void setFiveNum9( java.math.BigDecimal value ) {
		this.__five_num_9 = value;
	}

	public java.math.BigDecimal getTotalNum9() {
		return this.__total_num_9;
	}

	public void setTotalNum9( java.math.BigDecimal value ) {
		this.__total_num_9 = value;
	}

	public java.math.BigDecimal getOneNum10() {
		return this.__one_num_10;
	}

	public void setOneNum10( java.math.BigDecimal value ) {
		this.__one_num_10 = value;
	}

	public java.math.BigDecimal getTwoNum10() {
		return this.__two_num_10;
	}

	public void setTwoNum10( java.math.BigDecimal value ) {
		this.__two_num_10 = value;
	}

	public java.math.BigDecimal getThreeNum10() {
		return this.__three_num_10;
	}

	public void setThreeNum10( java.math.BigDecimal value ) {
		this.__three_num_10 = value;
	}

	public java.math.BigDecimal getFourNum10() {
		return this.__four_num_10;
	}

	public void setFourNum10( java.math.BigDecimal value ) {
		this.__four_num_10 = value;
	}

	public java.math.BigDecimal getFiveNum10() {
		return this.__five_num_10;
	}

	public void setFiveNum10( java.math.BigDecimal value ) {
		this.__five_num_10 = value;
	}

	public java.math.BigDecimal getTotalNum10() {
		return this.__total_num_10;
	}

	public void setTotalNum10( java.math.BigDecimal value ) {
		this.__total_num_10 = value;
	}

	public java.math.BigDecimal getOneNum11() {
		return this.__one_num_11;
	}

	public void setOneNum11( java.math.BigDecimal value ) {
		this.__one_num_11 = value;
	}

	public java.math.BigDecimal getTwoNum11() {
		return this.__two_num_11;
	}

	public void setTwoNum11( java.math.BigDecimal value ) {
		this.__two_num_11 = value;
	}

	public java.math.BigDecimal getThreeNum11() {
		return this.__three_num_11;
	}

	public void setThreeNum11( java.math.BigDecimal value ) {
		this.__three_num_11 = value;
	}

	public java.math.BigDecimal getFourNum11() {
		return this.__four_num_11;
	}

	public void setFourNum11( java.math.BigDecimal value ) {
		this.__four_num_11 = value;
	}

	public java.math.BigDecimal getFiveNum11() {
		return this.__five_num_11;
	}

	public void setFiveNum11( java.math.BigDecimal value ) {
		this.__five_num_11 = value;
	}

	public java.math.BigDecimal getTotalNum11() {
		return this.__total_num_11;
	}

	public void setTotalNum11( java.math.BigDecimal value ) {
		this.__total_num_11 = value;
	}

	public java.math.BigDecimal getOneNum12() {
		return this.__one_num_12;
	}

	public void setOneNum12( java.math.BigDecimal value ) {
		this.__one_num_12 = value;
	}

	public java.math.BigDecimal getTwoNum12() {
		return this.__two_num_12;
	}

	public void setTwoNum12( java.math.BigDecimal value ) {
		this.__two_num_12 = value;
	}

	public java.math.BigDecimal getThreeNum12() {
		return this.__three_num_12;
	}

	public void setThreeNum12( java.math.BigDecimal value ) {
		this.__three_num_12 = value;
	}

	public java.math.BigDecimal getFourNum12() {
		return this.__four_num_12;
	}

	public void setFourNum12( java.math.BigDecimal value ) {
		this.__four_num_12 = value;
	}

	public java.math.BigDecimal getFiveNum12() {
		return this.__five_num_12;
	}

	public void setFiveNum12( java.math.BigDecimal value ) {
		this.__five_num_12 = value;
	}

	public java.math.BigDecimal getTotalNum12() {
		return this.__total_num_12;
	}

	public void setTotalNum12( java.math.BigDecimal value ) {
		this.__total_num_12 = value;
	}

	public void cloneCopy(BaseReportOnEmployeeSeniorityTotalByDepartment __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
		__bean.setOneNum1(getOneNum1());
		__bean.setTwoNum1(getTwoNum1());
		__bean.setThreeNum1(getThreeNum1());
		__bean.setFourNum1(getFourNum1());
		__bean.setFiveNum1(getFiveNum1());
		__bean.setTotalNum1(getTotalNum1());
		__bean.setOneNum2(getOneNum2());
		__bean.setTwoNum2(getTwoNum2());
		__bean.setThreeNum2(getThreeNum2());
		__bean.setFourNum2(getFourNum2());
		__bean.setFiveNum2(getFiveNum2());
		__bean.setTotalNum2(getTotalNum2());
		__bean.setOneNum3(getOneNum3());
		__bean.setTwoNum3(getTwoNum3());
		__bean.setThreeNum3(getThreeNum3());
		__bean.setFourNum3(getFourNum3());
		__bean.setFiveNum3(getFiveNum3());
		__bean.setTotalNum3(getTotalNum3());
		__bean.setOneNum4(getOneNum4());
		__bean.setTwoNum4(getTwoNum4());
		__bean.setThreeNum4(getThreeNum4());
		__bean.setFourNum4(getFourNum4());
		__bean.setFiveNum4(getFiveNum4());
		__bean.setTotalNum4(getTotalNum4());
		__bean.setOneNum5(getOneNum5());
		__bean.setTwoNum5(getTwoNum5());
		__bean.setThreeNum5(getThreeNum5());
		__bean.setFourNum5(getFourNum5());
		__bean.setFiveNum5(getFiveNum5());
		__bean.setTotalNum5(getTotalNum5());
		__bean.setOneNum6(getOneNum6());
		__bean.setTwoNum6(getTwoNum6());
		__bean.setThreeNum6(getThreeNum6());
		__bean.setFourNum6(getFourNum6());
		__bean.setFiveNum6(getFiveNum6());
		__bean.setTotalNum6(getTotalNum6());
		__bean.setOneNum7(getOneNum7());
		__bean.setTwoNum7(getTwoNum7());
		__bean.setThreeNum7(getThreeNum7());
		__bean.setFourNum7(getFourNum7());
		__bean.setFiveNum7(getFiveNum7());
		__bean.setTotalNum7(getTotalNum7());
		__bean.setOneNum8(getOneNum8());
		__bean.setTwoNum8(getTwoNum8());
		__bean.setThreeNum8(getThreeNum8());
		__bean.setFourNum8(getFourNum8());
		__bean.setFiveNum8(getFiveNum8());
		__bean.setTotalNum8(getTotalNum8());
		__bean.setOneNum9(getOneNum9());
		__bean.setTwoNum9(getTwoNum9());
		__bean.setThreeNum9(getThreeNum9());
		__bean.setFourNum9(getFourNum9());
		__bean.setFiveNum9(getFiveNum9());
		__bean.setTotalNum9(getTotalNum9());
		__bean.setOneNum10(getOneNum10());
		__bean.setTwoNum10(getTwoNum10());
		__bean.setThreeNum10(getThreeNum10());
		__bean.setFourNum10(getFourNum10());
		__bean.setFiveNum10(getFiveNum10());
		__bean.setTotalNum10(getTotalNum10());
		__bean.setOneNum11(getOneNum11());
		__bean.setTwoNum11(getTwoNum11());
		__bean.setThreeNum11(getThreeNum11());
		__bean.setFourNum11(getFourNum11());
		__bean.setFiveNum11(getFiveNum11());
		__bean.setTotalNum11(getTotalNum11());
		__bean.setOneNum12(getOneNum12());
		__bean.setTwoNum12(getTwoNum12());
		__bean.setThreeNum12(getThreeNum12());
		__bean.setFourNum12(getFourNum12());
		__bean.setFiveNum12(getFiveNum12());
		__bean.setTotalNum12(getTotalNum12());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getDepartmentId() == null ? "" : getDepartmentId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getOneNum1() == null ? "" : getOneNum1());
		sb.append(",");
		sb.append(getTwoNum1() == null ? "" : getTwoNum1());
		sb.append(",");
		sb.append(getThreeNum1() == null ? "" : getThreeNum1());
		sb.append(",");
		sb.append(getFourNum1() == null ? "" : getFourNum1());
		sb.append(",");
		sb.append(getFiveNum1() == null ? "" : getFiveNum1());
		sb.append(",");
		sb.append(getTotalNum1() == null ? "" : getTotalNum1());
		sb.append(",");
		sb.append(getOneNum2() == null ? "" : getOneNum2());
		sb.append(",");
		sb.append(getTwoNum2() == null ? "" : getTwoNum2());
		sb.append(",");
		sb.append(getThreeNum2() == null ? "" : getThreeNum2());
		sb.append(",");
		sb.append(getFourNum2() == null ? "" : getFourNum2());
		sb.append(",");
		sb.append(getFiveNum2() == null ? "" : getFiveNum2());
		sb.append(",");
		sb.append(getTotalNum2() == null ? "" : getTotalNum2());
		sb.append(",");
		sb.append(getOneNum3() == null ? "" : getOneNum3());
		sb.append(",");
		sb.append(getTwoNum3() == null ? "" : getTwoNum3());
		sb.append(",");
		sb.append(getThreeNum3() == null ? "" : getThreeNum3());
		sb.append(",");
		sb.append(getFourNum3() == null ? "" : getFourNum3());
		sb.append(",");
		sb.append(getFiveNum3() == null ? "" : getFiveNum3());
		sb.append(",");
		sb.append(getTotalNum3() == null ? "" : getTotalNum3());
		sb.append(",");
		sb.append(getOneNum4() == null ? "" : getOneNum4());
		sb.append(",");
		sb.append(getTwoNum4() == null ? "" : getTwoNum4());
		sb.append(",");
		sb.append(getThreeNum4() == null ? "" : getThreeNum4());
		sb.append(",");
		sb.append(getFourNum4() == null ? "" : getFourNum4());
		sb.append(",");
		sb.append(getFiveNum4() == null ? "" : getFiveNum4());
		sb.append(",");
		sb.append(getTotalNum4() == null ? "" : getTotalNum4());
		sb.append(",");
		sb.append(getOneNum5() == null ? "" : getOneNum5());
		sb.append(",");
		sb.append(getTwoNum5() == null ? "" : getTwoNum5());
		sb.append(",");
		sb.append(getThreeNum5() == null ? "" : getThreeNum5());
		sb.append(",");
		sb.append(getFourNum5() == null ? "" : getFourNum5());
		sb.append(",");
		sb.append(getFiveNum5() == null ? "" : getFiveNum5());
		sb.append(",");
		sb.append(getTotalNum5() == null ? "" : getTotalNum5());
		sb.append(",");
		sb.append(getOneNum6() == null ? "" : getOneNum6());
		sb.append(",");
		sb.append(getTwoNum6() == null ? "" : getTwoNum6());
		sb.append(",");
		sb.append(getThreeNum6() == null ? "" : getThreeNum6());
		sb.append(",");
		sb.append(getFourNum6() == null ? "" : getFourNum6());
		sb.append(",");
		sb.append(getFiveNum6() == null ? "" : getFiveNum6());
		sb.append(",");
		sb.append(getTotalNum6() == null ? "" : getTotalNum6());
		sb.append(",");
		sb.append(getOneNum7() == null ? "" : getOneNum7());
		sb.append(",");
		sb.append(getTwoNum7() == null ? "" : getTwoNum7());
		sb.append(",");
		sb.append(getThreeNum7() == null ? "" : getThreeNum7());
		sb.append(",");
		sb.append(getFourNum7() == null ? "" : getFourNum7());
		sb.append(",");
		sb.append(getFiveNum7() == null ? "" : getFiveNum7());
		sb.append(",");
		sb.append(getTotalNum7() == null ? "" : getTotalNum7());
		sb.append(",");
		sb.append(getOneNum8() == null ? "" : getOneNum8());
		sb.append(",");
		sb.append(getTwoNum8() == null ? "" : getTwoNum8());
		sb.append(",");
		sb.append(getThreeNum8() == null ? "" : getThreeNum8());
		sb.append(",");
		sb.append(getFourNum8() == null ? "" : getFourNum8());
		sb.append(",");
		sb.append(getFiveNum8() == null ? "" : getFiveNum8());
		sb.append(",");
		sb.append(getTotalNum8() == null ? "" : getTotalNum8());
		sb.append(",");
		sb.append(getOneNum9() == null ? "" : getOneNum9());
		sb.append(",");
		sb.append(getTwoNum9() == null ? "" : getTwoNum9());
		sb.append(",");
		sb.append(getThreeNum9() == null ? "" : getThreeNum9());
		sb.append(",");
		sb.append(getFourNum9() == null ? "" : getFourNum9());
		sb.append(",");
		sb.append(getFiveNum9() == null ? "" : getFiveNum9());
		sb.append(",");
		sb.append(getTotalNum9() == null ? "" : getTotalNum9());
		sb.append(",");
		sb.append(getOneNum10() == null ? "" : getOneNum10());
		sb.append(",");
		sb.append(getTwoNum10() == null ? "" : getTwoNum10());
		sb.append(",");
		sb.append(getThreeNum10() == null ? "" : getThreeNum10());
		sb.append(",");
		sb.append(getFourNum10() == null ? "" : getFourNum10());
		sb.append(",");
		sb.append(getFiveNum10() == null ? "" : getFiveNum10());
		sb.append(",");
		sb.append(getTotalNum10() == null ? "" : getTotalNum10());
		sb.append(",");
		sb.append(getOneNum11() == null ? "" : getOneNum11());
		sb.append(",");
		sb.append(getTwoNum11() == null ? "" : getTwoNum11());
		sb.append(",");
		sb.append(getThreeNum11() == null ? "" : getThreeNum11());
		sb.append(",");
		sb.append(getFourNum11() == null ? "" : getFourNum11());
		sb.append(",");
		sb.append(getFiveNum11() == null ? "" : getFiveNum11());
		sb.append(",");
		sb.append(getTotalNum11() == null ? "" : getTotalNum11());
		sb.append(",");
		sb.append(getOneNum12() == null ? "" : getOneNum12());
		sb.append(",");
		sb.append(getTwoNum12() == null ? "" : getTwoNum12());
		sb.append(",");
		sb.append(getThreeNum12() == null ? "" : getThreeNum12());
		sb.append(",");
		sb.append(getFourNum12() == null ? "" : getFourNum12());
		sb.append(",");
		sb.append(getFiveNum12() == null ? "" : getFiveNum12());
		sb.append(",");
		sb.append(getTotalNum12() == null ? "" : getTotalNum12());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOnEmployeeSeniorityTotalByDepartment o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__one_num_1);
		hash = 97 * hash + Objects.hashCode(this.__two_num_1);
		hash = 97 * hash + Objects.hashCode(this.__three_num_1);
		hash = 97 * hash + Objects.hashCode(this.__four_num_1);
		hash = 97 * hash + Objects.hashCode(this.__five_num_1);
		hash = 97 * hash + Objects.hashCode(this.__total_num_1);
		hash = 97 * hash + Objects.hashCode(this.__one_num_2);
		hash = 97 * hash + Objects.hashCode(this.__two_num_2);
		hash = 97 * hash + Objects.hashCode(this.__three_num_2);
		hash = 97 * hash + Objects.hashCode(this.__four_num_2);
		hash = 97 * hash + Objects.hashCode(this.__five_num_2);
		hash = 97 * hash + Objects.hashCode(this.__total_num_2);
		hash = 97 * hash + Objects.hashCode(this.__one_num_3);
		hash = 97 * hash + Objects.hashCode(this.__two_num_3);
		hash = 97 * hash + Objects.hashCode(this.__three_num_3);
		hash = 97 * hash + Objects.hashCode(this.__four_num_3);
		hash = 97 * hash + Objects.hashCode(this.__five_num_3);
		hash = 97 * hash + Objects.hashCode(this.__total_num_3);
		hash = 97 * hash + Objects.hashCode(this.__one_num_4);
		hash = 97 * hash + Objects.hashCode(this.__two_num_4);
		hash = 97 * hash + Objects.hashCode(this.__three_num_4);
		hash = 97 * hash + Objects.hashCode(this.__four_num_4);
		hash = 97 * hash + Objects.hashCode(this.__five_num_4);
		hash = 97 * hash + Objects.hashCode(this.__total_num_4);
		hash = 97 * hash + Objects.hashCode(this.__one_num_5);
		hash = 97 * hash + Objects.hashCode(this.__two_num_5);
		hash = 97 * hash + Objects.hashCode(this.__three_num_5);
		hash = 97 * hash + Objects.hashCode(this.__four_num_5);
		hash = 97 * hash + Objects.hashCode(this.__five_num_5);
		hash = 97 * hash + Objects.hashCode(this.__total_num_5);
		hash = 97 * hash + Objects.hashCode(this.__one_num_6);
		hash = 97 * hash + Objects.hashCode(this.__two_num_6);
		hash = 97 * hash + Objects.hashCode(this.__three_num_6);
		hash = 97 * hash + Objects.hashCode(this.__four_num_6);
		hash = 97 * hash + Objects.hashCode(this.__five_num_6);
		hash = 97 * hash + Objects.hashCode(this.__total_num_6);
		hash = 97 * hash + Objects.hashCode(this.__one_num_7);
		hash = 97 * hash + Objects.hashCode(this.__two_num_7);
		hash = 97 * hash + Objects.hashCode(this.__three_num_7);
		hash = 97 * hash + Objects.hashCode(this.__four_num_7);
		hash = 97 * hash + Objects.hashCode(this.__five_num_7);
		hash = 97 * hash + Objects.hashCode(this.__total_num_7);
		hash = 97 * hash + Objects.hashCode(this.__one_num_8);
		hash = 97 * hash + Objects.hashCode(this.__two_num_8);
		hash = 97 * hash + Objects.hashCode(this.__three_num_8);
		hash = 97 * hash + Objects.hashCode(this.__four_num_8);
		hash = 97 * hash + Objects.hashCode(this.__five_num_8);
		hash = 97 * hash + Objects.hashCode(this.__total_num_8);
		hash = 97 * hash + Objects.hashCode(this.__one_num_9);
		hash = 97 * hash + Objects.hashCode(this.__two_num_9);
		hash = 97 * hash + Objects.hashCode(this.__three_num_9);
		hash = 97 * hash + Objects.hashCode(this.__four_num_9);
		hash = 97 * hash + Objects.hashCode(this.__five_num_9);
		hash = 97 * hash + Objects.hashCode(this.__total_num_9);
		hash = 97 * hash + Objects.hashCode(this.__one_num_10);
		hash = 97 * hash + Objects.hashCode(this.__two_num_10);
		hash = 97 * hash + Objects.hashCode(this.__three_num_10);
		hash = 97 * hash + Objects.hashCode(this.__four_num_10);
		hash = 97 * hash + Objects.hashCode(this.__five_num_10);
		hash = 97 * hash + Objects.hashCode(this.__total_num_10);
		hash = 97 * hash + Objects.hashCode(this.__one_num_11);
		hash = 97 * hash + Objects.hashCode(this.__two_num_11);
		hash = 97 * hash + Objects.hashCode(this.__three_num_11);
		hash = 97 * hash + Objects.hashCode(this.__four_num_11);
		hash = 97 * hash + Objects.hashCode(this.__five_num_11);
		hash = 97 * hash + Objects.hashCode(this.__total_num_11);
		hash = 97 * hash + Objects.hashCode(this.__one_num_12);
		hash = 97 * hash + Objects.hashCode(this.__two_num_12);
		hash = 97 * hash + Objects.hashCode(this.__three_num_12);
		hash = 97 * hash + Objects.hashCode(this.__four_num_12);
		hash = 97 * hash + Objects.hashCode(this.__five_num_12);
		hash = 97 * hash + Objects.hashCode(this.__total_num_12);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOnEmployeeSeniorityTotalByDepartment o = (BaseReportOnEmployeeSeniorityTotalByDepartment)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__one_num_1, o.getOneNum1())) return false;
		if(!Objects.equals(this.__two_num_1, o.getTwoNum1())) return false;
		if(!Objects.equals(this.__three_num_1, o.getThreeNum1())) return false;
		if(!Objects.equals(this.__four_num_1, o.getFourNum1())) return false;
		if(!Objects.equals(this.__five_num_1, o.getFiveNum1())) return false;
		if(!Objects.equals(this.__total_num_1, o.getTotalNum1())) return false;
		if(!Objects.equals(this.__one_num_2, o.getOneNum2())) return false;
		if(!Objects.equals(this.__two_num_2, o.getTwoNum2())) return false;
		if(!Objects.equals(this.__three_num_2, o.getThreeNum2())) return false;
		if(!Objects.equals(this.__four_num_2, o.getFourNum2())) return false;
		if(!Objects.equals(this.__five_num_2, o.getFiveNum2())) return false;
		if(!Objects.equals(this.__total_num_2, o.getTotalNum2())) return false;
		if(!Objects.equals(this.__one_num_3, o.getOneNum3())) return false;
		if(!Objects.equals(this.__two_num_3, o.getTwoNum3())) return false;
		if(!Objects.equals(this.__three_num_3, o.getThreeNum3())) return false;
		if(!Objects.equals(this.__four_num_3, o.getFourNum3())) return false;
		if(!Objects.equals(this.__five_num_3, o.getFiveNum3())) return false;
		if(!Objects.equals(this.__total_num_3, o.getTotalNum3())) return false;
		if(!Objects.equals(this.__one_num_4, o.getOneNum4())) return false;
		if(!Objects.equals(this.__two_num_4, o.getTwoNum4())) return false;
		if(!Objects.equals(this.__three_num_4, o.getThreeNum4())) return false;
		if(!Objects.equals(this.__four_num_4, o.getFourNum4())) return false;
		if(!Objects.equals(this.__five_num_4, o.getFiveNum4())) return false;
		if(!Objects.equals(this.__total_num_4, o.getTotalNum4())) return false;
		if(!Objects.equals(this.__one_num_5, o.getOneNum5())) return false;
		if(!Objects.equals(this.__two_num_5, o.getTwoNum5())) return false;
		if(!Objects.equals(this.__three_num_5, o.getThreeNum5())) return false;
		if(!Objects.equals(this.__four_num_5, o.getFourNum5())) return false;
		if(!Objects.equals(this.__five_num_5, o.getFiveNum5())) return false;
		if(!Objects.equals(this.__total_num_5, o.getTotalNum5())) return false;
		if(!Objects.equals(this.__one_num_6, o.getOneNum6())) return false;
		if(!Objects.equals(this.__two_num_6, o.getTwoNum6())) return false;
		if(!Objects.equals(this.__three_num_6, o.getThreeNum6())) return false;
		if(!Objects.equals(this.__four_num_6, o.getFourNum6())) return false;
		if(!Objects.equals(this.__five_num_6, o.getFiveNum6())) return false;
		if(!Objects.equals(this.__total_num_6, o.getTotalNum6())) return false;
		if(!Objects.equals(this.__one_num_7, o.getOneNum7())) return false;
		if(!Objects.equals(this.__two_num_7, o.getTwoNum7())) return false;
		if(!Objects.equals(this.__three_num_7, o.getThreeNum7())) return false;
		if(!Objects.equals(this.__four_num_7, o.getFourNum7())) return false;
		if(!Objects.equals(this.__five_num_7, o.getFiveNum7())) return false;
		if(!Objects.equals(this.__total_num_7, o.getTotalNum7())) return false;
		if(!Objects.equals(this.__one_num_8, o.getOneNum8())) return false;
		if(!Objects.equals(this.__two_num_8, o.getTwoNum8())) return false;
		if(!Objects.equals(this.__three_num_8, o.getThreeNum8())) return false;
		if(!Objects.equals(this.__four_num_8, o.getFourNum8())) return false;
		if(!Objects.equals(this.__five_num_8, o.getFiveNum8())) return false;
		if(!Objects.equals(this.__total_num_8, o.getTotalNum8())) return false;
		if(!Objects.equals(this.__one_num_9, o.getOneNum9())) return false;
		if(!Objects.equals(this.__two_num_9, o.getTwoNum9())) return false;
		if(!Objects.equals(this.__three_num_9, o.getThreeNum9())) return false;
		if(!Objects.equals(this.__four_num_9, o.getFourNum9())) return false;
		if(!Objects.equals(this.__five_num_9, o.getFiveNum9())) return false;
		if(!Objects.equals(this.__total_num_9, o.getTotalNum9())) return false;
		if(!Objects.equals(this.__one_num_10, o.getOneNum10())) return false;
		if(!Objects.equals(this.__two_num_10, o.getTwoNum10())) return false;
		if(!Objects.equals(this.__three_num_10, o.getThreeNum10())) return false;
		if(!Objects.equals(this.__four_num_10, o.getFourNum10())) return false;
		if(!Objects.equals(this.__five_num_10, o.getFiveNum10())) return false;
		if(!Objects.equals(this.__total_num_10, o.getTotalNum10())) return false;
		if(!Objects.equals(this.__one_num_11, o.getOneNum11())) return false;
		if(!Objects.equals(this.__two_num_11, o.getTwoNum11())) return false;
		if(!Objects.equals(this.__three_num_11, o.getThreeNum11())) return false;
		if(!Objects.equals(this.__four_num_11, o.getFourNum11())) return false;
		if(!Objects.equals(this.__five_num_11, o.getFiveNum11())) return false;
		if(!Objects.equals(this.__total_num_11, o.getTotalNum11())) return false;
		if(!Objects.equals(this.__one_num_12, o.getOneNum12())) return false;
		if(!Objects.equals(this.__two_num_12, o.getTwoNum12())) return false;
		if(!Objects.equals(this.__three_num_12, o.getThreeNum12())) return false;
		if(!Objects.equals(this.__four_num_12, o.getFourNum12())) return false;
		if(!Objects.equals(this.__five_num_12, o.getFiveNum12())) return false;
		if(!Objects.equals(this.__total_num_12, o.getTotalNum12())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getOneNum1() != null) sb.append(__wrapDecimal(count++, "oneNum1", getOneNum1()));
		if(getTwoNum1() != null) sb.append(__wrapDecimal(count++, "twoNum1", getTwoNum1()));
		if(getThreeNum1() != null) sb.append(__wrapDecimal(count++, "threeNum1", getThreeNum1()));
		if(getFourNum1() != null) sb.append(__wrapDecimal(count++, "fourNum1", getFourNum1()));
		if(getFiveNum1() != null) sb.append(__wrapDecimal(count++, "fiveNum1", getFiveNum1()));
		if(getTotalNum1() != null) sb.append(__wrapDecimal(count++, "totalNum1", getTotalNum1()));
		if(getOneNum2() != null) sb.append(__wrapDecimal(count++, "oneNum2", getOneNum2()));
		if(getTwoNum2() != null) sb.append(__wrapDecimal(count++, "twoNum2", getTwoNum2()));
		if(getThreeNum2() != null) sb.append(__wrapDecimal(count++, "threeNum2", getThreeNum2()));
		if(getFourNum2() != null) sb.append(__wrapDecimal(count++, "fourNum2", getFourNum2()));
		if(getFiveNum2() != null) sb.append(__wrapDecimal(count++, "fiveNum2", getFiveNum2()));
		if(getTotalNum2() != null) sb.append(__wrapDecimal(count++, "totalNum2", getTotalNum2()));
		if(getOneNum3() != null) sb.append(__wrapDecimal(count++, "oneNum3", getOneNum3()));
		if(getTwoNum3() != null) sb.append(__wrapDecimal(count++, "twoNum3", getTwoNum3()));
		if(getThreeNum3() != null) sb.append(__wrapDecimal(count++, "threeNum3", getThreeNum3()));
		if(getFourNum3() != null) sb.append(__wrapDecimal(count++, "fourNum3", getFourNum3()));
		if(getFiveNum3() != null) sb.append(__wrapDecimal(count++, "fiveNum3", getFiveNum3()));
		if(getTotalNum3() != null) sb.append(__wrapDecimal(count++, "totalNum3", getTotalNum3()));
		if(getOneNum4() != null) sb.append(__wrapDecimal(count++, "oneNum4", getOneNum4()));
		if(getTwoNum4() != null) sb.append(__wrapDecimal(count++, "twoNum4", getTwoNum4()));
		if(getThreeNum4() != null) sb.append(__wrapDecimal(count++, "threeNum4", getThreeNum4()));
		if(getFourNum4() != null) sb.append(__wrapDecimal(count++, "fourNum4", getFourNum4()));
		if(getFiveNum4() != null) sb.append(__wrapDecimal(count++, "fiveNum4", getFiveNum4()));
		if(getTotalNum4() != null) sb.append(__wrapDecimal(count++, "totalNum4", getTotalNum4()));
		if(getOneNum5() != null) sb.append(__wrapDecimal(count++, "oneNum5", getOneNum5()));
		if(getTwoNum5() != null) sb.append(__wrapDecimal(count++, "twoNum5", getTwoNum5()));
		if(getThreeNum5() != null) sb.append(__wrapDecimal(count++, "threeNum5", getThreeNum5()));
		if(getFourNum5() != null) sb.append(__wrapDecimal(count++, "fourNum5", getFourNum5()));
		if(getFiveNum5() != null) sb.append(__wrapDecimal(count++, "fiveNum5", getFiveNum5()));
		if(getTotalNum5() != null) sb.append(__wrapDecimal(count++, "totalNum5", getTotalNum5()));
		if(getOneNum6() != null) sb.append(__wrapDecimal(count++, "oneNum6", getOneNum6()));
		if(getTwoNum6() != null) sb.append(__wrapDecimal(count++, "twoNum6", getTwoNum6()));
		if(getThreeNum6() != null) sb.append(__wrapDecimal(count++, "threeNum6", getThreeNum6()));
		if(getFourNum6() != null) sb.append(__wrapDecimal(count++, "fourNum6", getFourNum6()));
		if(getFiveNum6() != null) sb.append(__wrapDecimal(count++, "fiveNum6", getFiveNum6()));
		if(getTotalNum6() != null) sb.append(__wrapDecimal(count++, "totalNum6", getTotalNum6()));
		if(getOneNum7() != null) sb.append(__wrapDecimal(count++, "oneNum7", getOneNum7()));
		if(getTwoNum7() != null) sb.append(__wrapDecimal(count++, "twoNum7", getTwoNum7()));
		if(getThreeNum7() != null) sb.append(__wrapDecimal(count++, "threeNum7", getThreeNum7()));
		if(getFourNum7() != null) sb.append(__wrapDecimal(count++, "fourNum7", getFourNum7()));
		if(getFiveNum7() != null) sb.append(__wrapDecimal(count++, "fiveNum7", getFiveNum7()));
		if(getTotalNum7() != null) sb.append(__wrapDecimal(count++, "totalNum7", getTotalNum7()));
		if(getOneNum8() != null) sb.append(__wrapDecimal(count++, "oneNum8", getOneNum8()));
		if(getTwoNum8() != null) sb.append(__wrapDecimal(count++, "twoNum8", getTwoNum8()));
		if(getThreeNum8() != null) sb.append(__wrapDecimal(count++, "threeNum8", getThreeNum8()));
		if(getFourNum8() != null) sb.append(__wrapDecimal(count++, "fourNum8", getFourNum8()));
		if(getFiveNum8() != null) sb.append(__wrapDecimal(count++, "fiveNum8", getFiveNum8()));
		if(getTotalNum8() != null) sb.append(__wrapDecimal(count++, "totalNum8", getTotalNum8()));
		if(getOneNum9() != null) sb.append(__wrapDecimal(count++, "oneNum9", getOneNum9()));
		if(getTwoNum9() != null) sb.append(__wrapDecimal(count++, "twoNum9", getTwoNum9()));
		if(getThreeNum9() != null) sb.append(__wrapDecimal(count++, "threeNum9", getThreeNum9()));
		if(getFourNum9() != null) sb.append(__wrapDecimal(count++, "fourNum9", getFourNum9()));
		if(getFiveNum9() != null) sb.append(__wrapDecimal(count++, "fiveNum9", getFiveNum9()));
		if(getTotalNum9() != null) sb.append(__wrapDecimal(count++, "totalNum9", getTotalNum9()));
		if(getOneNum10() != null) sb.append(__wrapDecimal(count++, "oneNum10", getOneNum10()));
		if(getTwoNum10() != null) sb.append(__wrapDecimal(count++, "twoNum10", getTwoNum10()));
		if(getThreeNum10() != null) sb.append(__wrapDecimal(count++, "threeNum10", getThreeNum10()));
		if(getFourNum10() != null) sb.append(__wrapDecimal(count++, "fourNum10", getFourNum10()));
		if(getFiveNum10() != null) sb.append(__wrapDecimal(count++, "fiveNum10", getFiveNum10()));
		if(getTotalNum10() != null) sb.append(__wrapDecimal(count++, "totalNum10", getTotalNum10()));
		if(getOneNum11() != null) sb.append(__wrapDecimal(count++, "oneNum11", getOneNum11()));
		if(getTwoNum11() != null) sb.append(__wrapDecimal(count++, "twoNum11", getTwoNum11()));
		if(getThreeNum11() != null) sb.append(__wrapDecimal(count++, "threeNum11", getThreeNum11()));
		if(getFourNum11() != null) sb.append(__wrapDecimal(count++, "fourNum11", getFourNum11()));
		if(getFiveNum11() != null) sb.append(__wrapDecimal(count++, "fiveNum11", getFiveNum11()));
		if(getTotalNum11() != null) sb.append(__wrapDecimal(count++, "totalNum11", getTotalNum11()));
		if(getOneNum12() != null) sb.append(__wrapDecimal(count++, "oneNum12", getOneNum12()));
		if(getTwoNum12() != null) sb.append(__wrapDecimal(count++, "twoNum12", getTwoNum12()));
		if(getThreeNum12() != null) sb.append(__wrapDecimal(count++, "threeNum12", getThreeNum12()));
		if(getFourNum12() != null) sb.append(__wrapDecimal(count++, "fourNum12", getFourNum12()));
		if(getFiveNum12() != null) sb.append(__wrapDecimal(count++, "fiveNum12", getFiveNum12()));
		if(getTotalNum12() != null) sb.append(__wrapDecimal(count++, "totalNum12", getTotalNum12()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getYear() != null) res.put("year", getYear());
		if(getOneNum1() != null) res.put("oneNum1", getOneNum1());
		if(getTwoNum1() != null) res.put("twoNum1", getTwoNum1());
		if(getThreeNum1() != null) res.put("threeNum1", getThreeNum1());
		if(getFourNum1() != null) res.put("fourNum1", getFourNum1());
		if(getFiveNum1() != null) res.put("fiveNum1", getFiveNum1());
		if(getTotalNum1() != null) res.put("totalNum1", getTotalNum1());
		if(getOneNum2() != null) res.put("oneNum2", getOneNum2());
		if(getTwoNum2() != null) res.put("twoNum2", getTwoNum2());
		if(getThreeNum2() != null) res.put("threeNum2", getThreeNum2());
		if(getFourNum2() != null) res.put("fourNum2", getFourNum2());
		if(getFiveNum2() != null) res.put("fiveNum2", getFiveNum2());
		if(getTotalNum2() != null) res.put("totalNum2", getTotalNum2());
		if(getOneNum3() != null) res.put("oneNum3", getOneNum3());
		if(getTwoNum3() != null) res.put("twoNum3", getTwoNum3());
		if(getThreeNum3() != null) res.put("threeNum3", getThreeNum3());
		if(getFourNum3() != null) res.put("fourNum3", getFourNum3());
		if(getFiveNum3() != null) res.put("fiveNum3", getFiveNum3());
		if(getTotalNum3() != null) res.put("totalNum3", getTotalNum3());
		if(getOneNum4() != null) res.put("oneNum4", getOneNum4());
		if(getTwoNum4() != null) res.put("twoNum4", getTwoNum4());
		if(getThreeNum4() != null) res.put("threeNum4", getThreeNum4());
		if(getFourNum4() != null) res.put("fourNum4", getFourNum4());
		if(getFiveNum4() != null) res.put("fiveNum4", getFiveNum4());
		if(getTotalNum4() != null) res.put("totalNum4", getTotalNum4());
		if(getOneNum5() != null) res.put("oneNum5", getOneNum5());
		if(getTwoNum5() != null) res.put("twoNum5", getTwoNum5());
		if(getThreeNum5() != null) res.put("threeNum5", getThreeNum5());
		if(getFourNum5() != null) res.put("fourNum5", getFourNum5());
		if(getFiveNum5() != null) res.put("fiveNum5", getFiveNum5());
		if(getTotalNum5() != null) res.put("totalNum5", getTotalNum5());
		if(getOneNum6() != null) res.put("oneNum6", getOneNum6());
		if(getTwoNum6() != null) res.put("twoNum6", getTwoNum6());
		if(getThreeNum6() != null) res.put("threeNum6", getThreeNum6());
		if(getFourNum6() != null) res.put("fourNum6", getFourNum6());
		if(getFiveNum6() != null) res.put("fiveNum6", getFiveNum6());
		if(getTotalNum6() != null) res.put("totalNum6", getTotalNum6());
		if(getOneNum7() != null) res.put("oneNum7", getOneNum7());
		if(getTwoNum7() != null) res.put("twoNum7", getTwoNum7());
		if(getThreeNum7() != null) res.put("threeNum7", getThreeNum7());
		if(getFourNum7() != null) res.put("fourNum7", getFourNum7());
		if(getFiveNum7() != null) res.put("fiveNum7", getFiveNum7());
		if(getTotalNum7() != null) res.put("totalNum7", getTotalNum7());
		if(getOneNum8() != null) res.put("oneNum8", getOneNum8());
		if(getTwoNum8() != null) res.put("twoNum8", getTwoNum8());
		if(getThreeNum8() != null) res.put("threeNum8", getThreeNum8());
		if(getFourNum8() != null) res.put("fourNum8", getFourNum8());
		if(getFiveNum8() != null) res.put("fiveNum8", getFiveNum8());
		if(getTotalNum8() != null) res.put("totalNum8", getTotalNum8());
		if(getOneNum9() != null) res.put("oneNum9", getOneNum9());
		if(getTwoNum9() != null) res.put("twoNum9", getTwoNum9());
		if(getThreeNum9() != null) res.put("threeNum9", getThreeNum9());
		if(getFourNum9() != null) res.put("fourNum9", getFourNum9());
		if(getFiveNum9() != null) res.put("fiveNum9", getFiveNum9());
		if(getTotalNum9() != null) res.put("totalNum9", getTotalNum9());
		if(getOneNum10() != null) res.put("oneNum10", getOneNum10());
		if(getTwoNum10() != null) res.put("twoNum10", getTwoNum10());
		if(getThreeNum10() != null) res.put("threeNum10", getThreeNum10());
		if(getFourNum10() != null) res.put("fourNum10", getFourNum10());
		if(getFiveNum10() != null) res.put("fiveNum10", getFiveNum10());
		if(getTotalNum10() != null) res.put("totalNum10", getTotalNum10());
		if(getOneNum11() != null) res.put("oneNum11", getOneNum11());
		if(getTwoNum11() != null) res.put("twoNum11", getTwoNum11());
		if(getThreeNum11() != null) res.put("threeNum11", getThreeNum11());
		if(getFourNum11() != null) res.put("fourNum11", getFourNum11());
		if(getFiveNum11() != null) res.put("fiveNum11", getFiveNum11());
		if(getTotalNum11() != null) res.put("totalNum11", getTotalNum11());
		if(getOneNum12() != null) res.put("oneNum12", getOneNum12());
		if(getTwoNum12() != null) res.put("twoNum12", getTwoNum12());
		if(getThreeNum12() != null) res.put("threeNum12", getThreeNum12());
		if(getFourNum12() != null) res.put("fourNum12", getFourNum12());
		if(getFiveNum12() != null) res.put("fiveNum12", getFiveNum12());
		if(getTotalNum12() != null) res.put("totalNum12", getTotalNum12());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("oneNum1")) != null) setOneNum1(__getDecimal(val));  
		if((val = values.get("twoNum1")) != null) setTwoNum1(__getDecimal(val));  
		if((val = values.get("threeNum1")) != null) setThreeNum1(__getDecimal(val));  
		if((val = values.get("fourNum1")) != null) setFourNum1(__getDecimal(val));  
		if((val = values.get("fiveNum1")) != null) setFiveNum1(__getDecimal(val));  
		if((val = values.get("totalNum1")) != null) setTotalNum1(__getDecimal(val));  
		if((val = values.get("oneNum2")) != null) setOneNum2(__getDecimal(val));  
		if((val = values.get("twoNum2")) != null) setTwoNum2(__getDecimal(val));  
		if((val = values.get("threeNum2")) != null) setThreeNum2(__getDecimal(val));  
		if((val = values.get("fourNum2")) != null) setFourNum2(__getDecimal(val));  
		if((val = values.get("fiveNum2")) != null) setFiveNum2(__getDecimal(val));  
		if((val = values.get("totalNum2")) != null) setTotalNum2(__getDecimal(val));  
		if((val = values.get("oneNum3")) != null) setOneNum3(__getDecimal(val));  
		if((val = values.get("twoNum3")) != null) setTwoNum3(__getDecimal(val));  
		if((val = values.get("threeNum3")) != null) setThreeNum3(__getDecimal(val));  
		if((val = values.get("fourNum3")) != null) setFourNum3(__getDecimal(val));  
		if((val = values.get("fiveNum3")) != null) setFiveNum3(__getDecimal(val));  
		if((val = values.get("totalNum3")) != null) setTotalNum3(__getDecimal(val));  
		if((val = values.get("oneNum4")) != null) setOneNum4(__getDecimal(val));  
		if((val = values.get("twoNum4")) != null) setTwoNum4(__getDecimal(val));  
		if((val = values.get("threeNum4")) != null) setThreeNum4(__getDecimal(val));  
		if((val = values.get("fourNum4")) != null) setFourNum4(__getDecimal(val));  
		if((val = values.get("fiveNum4")) != null) setFiveNum4(__getDecimal(val));  
		if((val = values.get("totalNum4")) != null) setTotalNum4(__getDecimal(val));  
		if((val = values.get("oneNum5")) != null) setOneNum5(__getDecimal(val));  
		if((val = values.get("twoNum5")) != null) setTwoNum5(__getDecimal(val));  
		if((val = values.get("threeNum5")) != null) setThreeNum5(__getDecimal(val));  
		if((val = values.get("fourNum5")) != null) setFourNum5(__getDecimal(val));  
		if((val = values.get("fiveNum5")) != null) setFiveNum5(__getDecimal(val));  
		if((val = values.get("totalNum5")) != null) setTotalNum5(__getDecimal(val));  
		if((val = values.get("oneNum6")) != null) setOneNum6(__getDecimal(val));  
		if((val = values.get("twoNum6")) != null) setTwoNum6(__getDecimal(val));  
		if((val = values.get("threeNum6")) != null) setThreeNum6(__getDecimal(val));  
		if((val = values.get("fourNum6")) != null) setFourNum6(__getDecimal(val));  
		if((val = values.get("fiveNum6")) != null) setFiveNum6(__getDecimal(val));  
		if((val = values.get("totalNum6")) != null) setTotalNum6(__getDecimal(val));  
		if((val = values.get("oneNum7")) != null) setOneNum7(__getDecimal(val));  
		if((val = values.get("twoNum7")) != null) setTwoNum7(__getDecimal(val));  
		if((val = values.get("threeNum7")) != null) setThreeNum7(__getDecimal(val));  
		if((val = values.get("fourNum7")) != null) setFourNum7(__getDecimal(val));  
		if((val = values.get("fiveNum7")) != null) setFiveNum7(__getDecimal(val));  
		if((val = values.get("totalNum7")) != null) setTotalNum7(__getDecimal(val));  
		if((val = values.get("oneNum8")) != null) setOneNum8(__getDecimal(val));  
		if((val = values.get("twoNum8")) != null) setTwoNum8(__getDecimal(val));  
		if((val = values.get("threeNum8")) != null) setThreeNum8(__getDecimal(val));  
		if((val = values.get("fourNum8")) != null) setFourNum8(__getDecimal(val));  
		if((val = values.get("fiveNum8")) != null) setFiveNum8(__getDecimal(val));  
		if((val = values.get("totalNum8")) != null) setTotalNum8(__getDecimal(val));  
		if((val = values.get("oneNum9")) != null) setOneNum9(__getDecimal(val));  
		if((val = values.get("twoNum9")) != null) setTwoNum9(__getDecimal(val));  
		if((val = values.get("threeNum9")) != null) setThreeNum9(__getDecimal(val));  
		if((val = values.get("fourNum9")) != null) setFourNum9(__getDecimal(val));  
		if((val = values.get("fiveNum9")) != null) setFiveNum9(__getDecimal(val));  
		if((val = values.get("totalNum9")) != null) setTotalNum9(__getDecimal(val));  
		if((val = values.get("oneNum10")) != null) setOneNum10(__getDecimal(val));  
		if((val = values.get("twoNum10")) != null) setTwoNum10(__getDecimal(val));  
		if((val = values.get("threeNum10")) != null) setThreeNum10(__getDecimal(val));  
		if((val = values.get("fourNum10")) != null) setFourNum10(__getDecimal(val));  
		if((val = values.get("fiveNum10")) != null) setFiveNum10(__getDecimal(val));  
		if((val = values.get("totalNum10")) != null) setTotalNum10(__getDecimal(val));  
		if((val = values.get("oneNum11")) != null) setOneNum11(__getDecimal(val));  
		if((val = values.get("twoNum11")) != null) setTwoNum11(__getDecimal(val));  
		if((val = values.get("threeNum11")) != null) setThreeNum11(__getDecimal(val));  
		if((val = values.get("fourNum11")) != null) setFourNum11(__getDecimal(val));  
		if((val = values.get("fiveNum11")) != null) setFiveNum11(__getDecimal(val));  
		if((val = values.get("totalNum11")) != null) setTotalNum11(__getDecimal(val));  
		if((val = values.get("oneNum12")) != null) setOneNum12(__getDecimal(val));  
		if((val = values.get("twoNum12")) != null) setTwoNum12(__getDecimal(val));  
		if((val = values.get("threeNum12")) != null) setThreeNum12(__getDecimal(val));  
		if((val = values.get("fourNum12")) != null) setFourNum12(__getDecimal(val));  
		if((val = values.get("fiveNum12")) != null) setFiveNum12(__getDecimal(val));  
		if((val = values.get("totalNum12")) != null) setTotalNum12(__getDecimal(val));  
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __one_num_1 ;
	protected java.math.BigDecimal  __two_num_1 ;
	protected java.math.BigDecimal  __three_num_1 ;
	protected java.math.BigDecimal  __four_num_1 ;
	protected java.math.BigDecimal  __five_num_1 ;
	protected java.math.BigDecimal  __total_num_1 ;
	protected java.math.BigDecimal  __one_num_2 ;
	protected java.math.BigDecimal  __two_num_2 ;
	protected java.math.BigDecimal  __three_num_2 ;
	protected java.math.BigDecimal  __four_num_2 ;
	protected java.math.BigDecimal  __five_num_2 ;
	protected java.math.BigDecimal  __total_num_2 ;
	protected java.math.BigDecimal  __one_num_3 ;
	protected java.math.BigDecimal  __two_num_3 ;
	protected java.math.BigDecimal  __three_num_3 ;
	protected java.math.BigDecimal  __four_num_3 ;
	protected java.math.BigDecimal  __five_num_3 ;
	protected java.math.BigDecimal  __total_num_3 ;
	protected java.math.BigDecimal  __one_num_4 ;
	protected java.math.BigDecimal  __two_num_4 ;
	protected java.math.BigDecimal  __three_num_4 ;
	protected java.math.BigDecimal  __four_num_4 ;
	protected java.math.BigDecimal  __five_num_4 ;
	protected java.math.BigDecimal  __total_num_4 ;
	protected java.math.BigDecimal  __one_num_5 ;
	protected java.math.BigDecimal  __two_num_5 ;
	protected java.math.BigDecimal  __three_num_5 ;
	protected java.math.BigDecimal  __four_num_5 ;
	protected java.math.BigDecimal  __five_num_5 ;
	protected java.math.BigDecimal  __total_num_5 ;
	protected java.math.BigDecimal  __one_num_6 ;
	protected java.math.BigDecimal  __two_num_6 ;
	protected java.math.BigDecimal  __three_num_6 ;
	protected java.math.BigDecimal  __four_num_6 ;
	protected java.math.BigDecimal  __five_num_6 ;
	protected java.math.BigDecimal  __total_num_6 ;
	protected java.math.BigDecimal  __one_num_7 ;
	protected java.math.BigDecimal  __two_num_7 ;
	protected java.math.BigDecimal  __three_num_7 ;
	protected java.math.BigDecimal  __four_num_7 ;
	protected java.math.BigDecimal  __five_num_7 ;
	protected java.math.BigDecimal  __total_num_7 ;
	protected java.math.BigDecimal  __one_num_8 ;
	protected java.math.BigDecimal  __two_num_8 ;
	protected java.math.BigDecimal  __three_num_8 ;
	protected java.math.BigDecimal  __four_num_8 ;
	protected java.math.BigDecimal  __five_num_8 ;
	protected java.math.BigDecimal  __total_num_8 ;
	protected java.math.BigDecimal  __one_num_9 ;
	protected java.math.BigDecimal  __two_num_9 ;
	protected java.math.BigDecimal  __three_num_9 ;
	protected java.math.BigDecimal  __four_num_9 ;
	protected java.math.BigDecimal  __five_num_9 ;
	protected java.math.BigDecimal  __total_num_9 ;
	protected java.math.BigDecimal  __one_num_10 ;
	protected java.math.BigDecimal  __two_num_10 ;
	protected java.math.BigDecimal  __three_num_10 ;
	protected java.math.BigDecimal  __four_num_10 ;
	protected java.math.BigDecimal  __five_num_10 ;
	protected java.math.BigDecimal  __total_num_10 ;
	protected java.math.BigDecimal  __one_num_11 ;
	protected java.math.BigDecimal  __two_num_11 ;
	protected java.math.BigDecimal  __three_num_11 ;
	protected java.math.BigDecimal  __four_num_11 ;
	protected java.math.BigDecimal  __five_num_11 ;
	protected java.math.BigDecimal  __total_num_11 ;
	protected java.math.BigDecimal  __one_num_12 ;
	protected java.math.BigDecimal  __two_num_12 ;
	protected java.math.BigDecimal  __three_num_12 ;
	protected java.math.BigDecimal  __four_num_12 ;
	protected java.math.BigDecimal  __five_num_12 ;
	protected java.math.BigDecimal  __total_num_12 ;
}
