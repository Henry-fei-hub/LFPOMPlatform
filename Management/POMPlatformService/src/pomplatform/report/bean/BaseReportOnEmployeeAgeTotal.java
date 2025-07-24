package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOnEmployeeAgeTotal extends GenericBase implements BaseFactory<BaseReportOnEmployeeAgeTotal>, Comparable<BaseReportOnEmployeeAgeTotal> 
{


	public static BaseReportOnEmployeeAgeTotal newInstance(){
		return new BaseReportOnEmployeeAgeTotal();
	}

	@Override
	public BaseReportOnEmployeeAgeTotal make(){
		BaseReportOnEmployeeAgeTotal b = new BaseReportOnEmployeeAgeTotal();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_SIX_NUM_1 = "six_num_1" ;
	public final static java.lang.String CS_SEVEN_NUM_1 = "seven_num_1" ;
	public final static java.lang.String CS_EIGHT_NUM_1 = "eight_num_1" ;
	public final static java.lang.String CS_NINE_NUM_1 = "nine_num_1" ;
	public final static java.lang.String CS_ZERO_NUM_1 = "zero_num_1" ;
	public final static java.lang.String CS_TOTAL_NUM_1 = "total_num_1" ;
	public final static java.lang.String CS_SIX_NUM_2 = "six_num_2" ;
	public final static java.lang.String CS_SEVEN_NUM_2 = "seven_num_2" ;
	public final static java.lang.String CS_EIGHT_NUM_2 = "eight_num_2" ;
	public final static java.lang.String CS_NINE_NUM_2 = "nine_num_2" ;
	public final static java.lang.String CS_ZERO_NUM_2 = "zero_num_2" ;
	public final static java.lang.String CS_TOTAL_NUM_2 = "total_num_2" ;
	public final static java.lang.String CS_SIX_NUM_3 = "six_num_3" ;
	public final static java.lang.String CS_SEVEN_NUM_3 = "seven_num_3" ;
	public final static java.lang.String CS_EIGHT_NUM_3 = "eight_num_3" ;
	public final static java.lang.String CS_NINE_NUM_3 = "nine_num_3" ;
	public final static java.lang.String CS_ZERO_NUM_3 = "zero_num_3" ;
	public final static java.lang.String CS_TOTAL_NUM_3 = "total_num_3" ;
	public final static java.lang.String CS_SIX_NUM_4 = "six_num_4" ;
	public final static java.lang.String CS_SEVEN_NUM_4 = "seven_num_4" ;
	public final static java.lang.String CS_EIGHT_NUM_4 = "eight_num_4" ;
	public final static java.lang.String CS_NINE_NUM_4 = "nine_num_4" ;
	public final static java.lang.String CS_ZERO_NUM_4 = "zero_num_4" ;
	public final static java.lang.String CS_TOTAL_NUM_4 = "total_num_4" ;
	public final static java.lang.String CS_SIX_NUM_5 = "six_num_5" ;
	public final static java.lang.String CS_SEVEN_NUM_5 = "seven_num_5" ;
	public final static java.lang.String CS_EIGHT_NUM_5 = "eight_num_5" ;
	public final static java.lang.String CS_NINE_NUM_5 = "nine_num_5" ;
	public final static java.lang.String CS_ZERO_NUM_5 = "zero_num_5" ;
	public final static java.lang.String CS_TOTAL_NUM_5 = "total_num_5" ;
	public final static java.lang.String CS_SIX_NUM_6 = "six_num_6" ;
	public final static java.lang.String CS_SEVEN_NUM_6 = "seven_num_6" ;
	public final static java.lang.String CS_EIGHT_NUM_6 = "eight_num_6" ;
	public final static java.lang.String CS_NINE_NUM_6 = "nine_num_6" ;
	public final static java.lang.String CS_ZERO_NUM_6 = "zero_num_6" ;
	public final static java.lang.String CS_TOTAL_NUM_6 = "total_num_6" ;
	public final static java.lang.String CS_SIX_NUM_7 = "six_num_7" ;
	public final static java.lang.String CS_SEVEN_NUM_7 = "seven_num_7" ;
	public final static java.lang.String CS_EIGHT_NUM_7 = "eight_num_7" ;
	public final static java.lang.String CS_NINE_NUM_7 = "nine_num_7" ;
	public final static java.lang.String CS_ZERO_NUM_7 = "zero_num_7" ;
	public final static java.lang.String CS_TOTAL_NUM_7 = "total_num_7" ;
	public final static java.lang.String CS_SIX_NUM_8 = "six_num_8" ;
	public final static java.lang.String CS_SEVEN_NUM_8 = "seven_num_8" ;
	public final static java.lang.String CS_EIGHT_NUM_8 = "eight_num_8" ;
	public final static java.lang.String CS_NINE_NUM_8 = "nine_num_8" ;
	public final static java.lang.String CS_ZERO_NUM_8 = "zero_num_8" ;
	public final static java.lang.String CS_TOTAL_NUM_8 = "total_num_8" ;
	public final static java.lang.String CS_SIX_NUM_9 = "six_num_9" ;
	public final static java.lang.String CS_SEVEN_NUM_9 = "seven_num_9" ;
	public final static java.lang.String CS_EIGHT_NUM_9 = "eight_num_9" ;
	public final static java.lang.String CS_NINE_NUM_9 = "nine_num_9" ;
	public final static java.lang.String CS_ZERO_NUM_9 = "zero_num_9" ;
	public final static java.lang.String CS_TOTAL_NUM_9 = "total_num_9" ;
	public final static java.lang.String CS_SIX_NUM_10 = "six_num_10" ;
	public final static java.lang.String CS_SEVEN_NUM_10 = "seven_num_10" ;
	public final static java.lang.String CS_EIGHT_NUM_10 = "eight_num_10" ;
	public final static java.lang.String CS_NINE_NUM_10 = "nine_num_10" ;
	public final static java.lang.String CS_ZERO_NUM_10 = "zero_num_10" ;
	public final static java.lang.String CS_TOTAL_NUM_10 = "total_num_10" ;
	public final static java.lang.String CS_SIX_NUM_11 = "six_num_11" ;
	public final static java.lang.String CS_SEVEN_NUM_11 = "seven_num_11" ;
	public final static java.lang.String CS_EIGHT_NUM_11 = "eight_num_11" ;
	public final static java.lang.String CS_NINE_NUM_11 = "nine_num_11" ;
	public final static java.lang.String CS_ZERO_NUM_11 = "zero_num_11" ;
	public final static java.lang.String CS_TOTAL_NUM_11 = "total_num_11" ;
	public final static java.lang.String CS_SIX_NUM_12 = "six_num_12" ;
	public final static java.lang.String CS_SEVEN_NUM_12 = "seven_num_12" ;
	public final static java.lang.String CS_EIGHT_NUM_12 = "eight_num_12" ;
	public final static java.lang.String CS_NINE_NUM_12 = "nine_num_12" ;
	public final static java.lang.String CS_ZERO_NUM_12 = "zero_num_12" ;
	public final static java.lang.String CS_TOTAL_NUM_12 = "total_num_12" ;

	public final static java.lang.String ALL_CAPTIONS = "业务部门,年份,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

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

	public java.math.BigDecimal getSixNum1() {
		return this.__six_num_1;
	}

	public void setSixNum1( java.math.BigDecimal value ) {
		this.__six_num_1 = value;
	}

	public java.math.BigDecimal getSevenNum1() {
		return this.__seven_num_1;
	}

	public void setSevenNum1( java.math.BigDecimal value ) {
		this.__seven_num_1 = value;
	}

	public java.math.BigDecimal getEightNum1() {
		return this.__eight_num_1;
	}

	public void setEightNum1( java.math.BigDecimal value ) {
		this.__eight_num_1 = value;
	}

	public java.math.BigDecimal getNineNum1() {
		return this.__nine_num_1;
	}

	public void setNineNum1( java.math.BigDecimal value ) {
		this.__nine_num_1 = value;
	}

	public java.math.BigDecimal getZeroNum1() {
		return this.__zero_num_1;
	}

	public void setZeroNum1( java.math.BigDecimal value ) {
		this.__zero_num_1 = value;
	}

	public java.math.BigDecimal getTotalNum1() {
		return this.__total_num_1;
	}

	public void setTotalNum1( java.math.BigDecimal value ) {
		this.__total_num_1 = value;
	}

	public java.math.BigDecimal getSixNum2() {
		return this.__six_num_2;
	}

	public void setSixNum2( java.math.BigDecimal value ) {
		this.__six_num_2 = value;
	}

	public java.math.BigDecimal getSevenNum2() {
		return this.__seven_num_2;
	}

	public void setSevenNum2( java.math.BigDecimal value ) {
		this.__seven_num_2 = value;
	}

	public java.math.BigDecimal getEightNum2() {
		return this.__eight_num_2;
	}

	public void setEightNum2( java.math.BigDecimal value ) {
		this.__eight_num_2 = value;
	}

	public java.math.BigDecimal getNineNum2() {
		return this.__nine_num_2;
	}

	public void setNineNum2( java.math.BigDecimal value ) {
		this.__nine_num_2 = value;
	}

	public java.math.BigDecimal getZeroNum2() {
		return this.__zero_num_2;
	}

	public void setZeroNum2( java.math.BigDecimal value ) {
		this.__zero_num_2 = value;
	}

	public java.math.BigDecimal getTotalNum2() {
		return this.__total_num_2;
	}

	public void setTotalNum2( java.math.BigDecimal value ) {
		this.__total_num_2 = value;
	}

	public java.math.BigDecimal getSixNum3() {
		return this.__six_num_3;
	}

	public void setSixNum3( java.math.BigDecimal value ) {
		this.__six_num_3 = value;
	}

	public java.math.BigDecimal getSevenNum3() {
		return this.__seven_num_3;
	}

	public void setSevenNum3( java.math.BigDecimal value ) {
		this.__seven_num_3 = value;
	}

	public java.math.BigDecimal getEightNum3() {
		return this.__eight_num_3;
	}

	public void setEightNum3( java.math.BigDecimal value ) {
		this.__eight_num_3 = value;
	}

	public java.math.BigDecimal getNineNum3() {
		return this.__nine_num_3;
	}

	public void setNineNum3( java.math.BigDecimal value ) {
		this.__nine_num_3 = value;
	}

	public java.math.BigDecimal getZeroNum3() {
		return this.__zero_num_3;
	}

	public void setZeroNum3( java.math.BigDecimal value ) {
		this.__zero_num_3 = value;
	}

	public java.math.BigDecimal getTotalNum3() {
		return this.__total_num_3;
	}

	public void setTotalNum3( java.math.BigDecimal value ) {
		this.__total_num_3 = value;
	}

	public java.math.BigDecimal getSixNum4() {
		return this.__six_num_4;
	}

	public void setSixNum4( java.math.BigDecimal value ) {
		this.__six_num_4 = value;
	}

	public java.math.BigDecimal getSevenNum4() {
		return this.__seven_num_4;
	}

	public void setSevenNum4( java.math.BigDecimal value ) {
		this.__seven_num_4 = value;
	}

	public java.math.BigDecimal getEightNum4() {
		return this.__eight_num_4;
	}

	public void setEightNum4( java.math.BigDecimal value ) {
		this.__eight_num_4 = value;
	}

	public java.math.BigDecimal getNineNum4() {
		return this.__nine_num_4;
	}

	public void setNineNum4( java.math.BigDecimal value ) {
		this.__nine_num_4 = value;
	}

	public java.math.BigDecimal getZeroNum4() {
		return this.__zero_num_4;
	}

	public void setZeroNum4( java.math.BigDecimal value ) {
		this.__zero_num_4 = value;
	}

	public java.math.BigDecimal getTotalNum4() {
		return this.__total_num_4;
	}

	public void setTotalNum4( java.math.BigDecimal value ) {
		this.__total_num_4 = value;
	}

	public java.math.BigDecimal getSixNum5() {
		return this.__six_num_5;
	}

	public void setSixNum5( java.math.BigDecimal value ) {
		this.__six_num_5 = value;
	}

	public java.math.BigDecimal getSevenNum5() {
		return this.__seven_num_5;
	}

	public void setSevenNum5( java.math.BigDecimal value ) {
		this.__seven_num_5 = value;
	}

	public java.math.BigDecimal getEightNum5() {
		return this.__eight_num_5;
	}

	public void setEightNum5( java.math.BigDecimal value ) {
		this.__eight_num_5 = value;
	}

	public java.math.BigDecimal getNineNum5() {
		return this.__nine_num_5;
	}

	public void setNineNum5( java.math.BigDecimal value ) {
		this.__nine_num_5 = value;
	}

	public java.math.BigDecimal getZeroNum5() {
		return this.__zero_num_5;
	}

	public void setZeroNum5( java.math.BigDecimal value ) {
		this.__zero_num_5 = value;
	}

	public java.math.BigDecimal getTotalNum5() {
		return this.__total_num_5;
	}

	public void setTotalNum5( java.math.BigDecimal value ) {
		this.__total_num_5 = value;
	}

	public java.math.BigDecimal getSixNum6() {
		return this.__six_num_6;
	}

	public void setSixNum6( java.math.BigDecimal value ) {
		this.__six_num_6 = value;
	}

	public java.math.BigDecimal getSevenNum6() {
		return this.__seven_num_6;
	}

	public void setSevenNum6( java.math.BigDecimal value ) {
		this.__seven_num_6 = value;
	}

	public java.math.BigDecimal getEightNum6() {
		return this.__eight_num_6;
	}

	public void setEightNum6( java.math.BigDecimal value ) {
		this.__eight_num_6 = value;
	}

	public java.math.BigDecimal getNineNum6() {
		return this.__nine_num_6;
	}

	public void setNineNum6( java.math.BigDecimal value ) {
		this.__nine_num_6 = value;
	}

	public java.math.BigDecimal getZeroNum6() {
		return this.__zero_num_6;
	}

	public void setZeroNum6( java.math.BigDecimal value ) {
		this.__zero_num_6 = value;
	}

	public java.math.BigDecimal getTotalNum6() {
		return this.__total_num_6;
	}

	public void setTotalNum6( java.math.BigDecimal value ) {
		this.__total_num_6 = value;
	}

	public java.math.BigDecimal getSixNum7() {
		return this.__six_num_7;
	}

	public void setSixNum7( java.math.BigDecimal value ) {
		this.__six_num_7 = value;
	}

	public java.math.BigDecimal getSevenNum7() {
		return this.__seven_num_7;
	}

	public void setSevenNum7( java.math.BigDecimal value ) {
		this.__seven_num_7 = value;
	}

	public java.math.BigDecimal getEightNum7() {
		return this.__eight_num_7;
	}

	public void setEightNum7( java.math.BigDecimal value ) {
		this.__eight_num_7 = value;
	}

	public java.math.BigDecimal getNineNum7() {
		return this.__nine_num_7;
	}

	public void setNineNum7( java.math.BigDecimal value ) {
		this.__nine_num_7 = value;
	}

	public java.math.BigDecimal getZeroNum7() {
		return this.__zero_num_7;
	}

	public void setZeroNum7( java.math.BigDecimal value ) {
		this.__zero_num_7 = value;
	}

	public java.math.BigDecimal getTotalNum7() {
		return this.__total_num_7;
	}

	public void setTotalNum7( java.math.BigDecimal value ) {
		this.__total_num_7 = value;
	}

	public java.math.BigDecimal getSixNum8() {
		return this.__six_num_8;
	}

	public void setSixNum8( java.math.BigDecimal value ) {
		this.__six_num_8 = value;
	}

	public java.math.BigDecimal getSevenNum8() {
		return this.__seven_num_8;
	}

	public void setSevenNum8( java.math.BigDecimal value ) {
		this.__seven_num_8 = value;
	}

	public java.math.BigDecimal getEightNum8() {
		return this.__eight_num_8;
	}

	public void setEightNum8( java.math.BigDecimal value ) {
		this.__eight_num_8 = value;
	}

	public java.math.BigDecimal getNineNum8() {
		return this.__nine_num_8;
	}

	public void setNineNum8( java.math.BigDecimal value ) {
		this.__nine_num_8 = value;
	}

	public java.math.BigDecimal getZeroNum8() {
		return this.__zero_num_8;
	}

	public void setZeroNum8( java.math.BigDecimal value ) {
		this.__zero_num_8 = value;
	}

	public java.math.BigDecimal getTotalNum8() {
		return this.__total_num_8;
	}

	public void setTotalNum8( java.math.BigDecimal value ) {
		this.__total_num_8 = value;
	}

	public java.math.BigDecimal getSixNum9() {
		return this.__six_num_9;
	}

	public void setSixNum9( java.math.BigDecimal value ) {
		this.__six_num_9 = value;
	}

	public java.math.BigDecimal getSevenNum9() {
		return this.__seven_num_9;
	}

	public void setSevenNum9( java.math.BigDecimal value ) {
		this.__seven_num_9 = value;
	}

	public java.math.BigDecimal getEightNum9() {
		return this.__eight_num_9;
	}

	public void setEightNum9( java.math.BigDecimal value ) {
		this.__eight_num_9 = value;
	}

	public java.math.BigDecimal getNineNum9() {
		return this.__nine_num_9;
	}

	public void setNineNum9( java.math.BigDecimal value ) {
		this.__nine_num_9 = value;
	}

	public java.math.BigDecimal getZeroNum9() {
		return this.__zero_num_9;
	}

	public void setZeroNum9( java.math.BigDecimal value ) {
		this.__zero_num_9 = value;
	}

	public java.math.BigDecimal getTotalNum9() {
		return this.__total_num_9;
	}

	public void setTotalNum9( java.math.BigDecimal value ) {
		this.__total_num_9 = value;
	}

	public java.math.BigDecimal getSixNum10() {
		return this.__six_num_10;
	}

	public void setSixNum10( java.math.BigDecimal value ) {
		this.__six_num_10 = value;
	}

	public java.math.BigDecimal getSevenNum10() {
		return this.__seven_num_10;
	}

	public void setSevenNum10( java.math.BigDecimal value ) {
		this.__seven_num_10 = value;
	}

	public java.math.BigDecimal getEightNum10() {
		return this.__eight_num_10;
	}

	public void setEightNum10( java.math.BigDecimal value ) {
		this.__eight_num_10 = value;
	}

	public java.math.BigDecimal getNineNum10() {
		return this.__nine_num_10;
	}

	public void setNineNum10( java.math.BigDecimal value ) {
		this.__nine_num_10 = value;
	}

	public java.math.BigDecimal getZeroNum10() {
		return this.__zero_num_10;
	}

	public void setZeroNum10( java.math.BigDecimal value ) {
		this.__zero_num_10 = value;
	}

	public java.math.BigDecimal getTotalNum10() {
		return this.__total_num_10;
	}

	public void setTotalNum10( java.math.BigDecimal value ) {
		this.__total_num_10 = value;
	}

	public java.math.BigDecimal getSixNum11() {
		return this.__six_num_11;
	}

	public void setSixNum11( java.math.BigDecimal value ) {
		this.__six_num_11 = value;
	}

	public java.math.BigDecimal getSevenNum11() {
		return this.__seven_num_11;
	}

	public void setSevenNum11( java.math.BigDecimal value ) {
		this.__seven_num_11 = value;
	}

	public java.math.BigDecimal getEightNum11() {
		return this.__eight_num_11;
	}

	public void setEightNum11( java.math.BigDecimal value ) {
		this.__eight_num_11 = value;
	}

	public java.math.BigDecimal getNineNum11() {
		return this.__nine_num_11;
	}

	public void setNineNum11( java.math.BigDecimal value ) {
		this.__nine_num_11 = value;
	}

	public java.math.BigDecimal getZeroNum11() {
		return this.__zero_num_11;
	}

	public void setZeroNum11( java.math.BigDecimal value ) {
		this.__zero_num_11 = value;
	}

	public java.math.BigDecimal getTotalNum11() {
		return this.__total_num_11;
	}

	public void setTotalNum11( java.math.BigDecimal value ) {
		this.__total_num_11 = value;
	}

	public java.math.BigDecimal getSixNum12() {
		return this.__six_num_12;
	}

	public void setSixNum12( java.math.BigDecimal value ) {
		this.__six_num_12 = value;
	}

	public java.math.BigDecimal getSevenNum12() {
		return this.__seven_num_12;
	}

	public void setSevenNum12( java.math.BigDecimal value ) {
		this.__seven_num_12 = value;
	}

	public java.math.BigDecimal getEightNum12() {
		return this.__eight_num_12;
	}

	public void setEightNum12( java.math.BigDecimal value ) {
		this.__eight_num_12 = value;
	}

	public java.math.BigDecimal getNineNum12() {
		return this.__nine_num_12;
	}

	public void setNineNum12( java.math.BigDecimal value ) {
		this.__nine_num_12 = value;
	}

	public java.math.BigDecimal getZeroNum12() {
		return this.__zero_num_12;
	}

	public void setZeroNum12( java.math.BigDecimal value ) {
		this.__zero_num_12 = value;
	}

	public java.math.BigDecimal getTotalNum12() {
		return this.__total_num_12;
	}

	public void setTotalNum12( java.math.BigDecimal value ) {
		this.__total_num_12 = value;
	}

	public void cloneCopy(BaseReportOnEmployeeAgeTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setSixNum1(getSixNum1());
		__bean.setSevenNum1(getSevenNum1());
		__bean.setEightNum1(getEightNum1());
		__bean.setNineNum1(getNineNum1());
		__bean.setZeroNum1(getZeroNum1());
		__bean.setTotalNum1(getTotalNum1());
		__bean.setSixNum2(getSixNum2());
		__bean.setSevenNum2(getSevenNum2());
		__bean.setEightNum2(getEightNum2());
		__bean.setNineNum2(getNineNum2());
		__bean.setZeroNum2(getZeroNum2());
		__bean.setTotalNum2(getTotalNum2());
		__bean.setSixNum3(getSixNum3());
		__bean.setSevenNum3(getSevenNum3());
		__bean.setEightNum3(getEightNum3());
		__bean.setNineNum3(getNineNum3());
		__bean.setZeroNum3(getZeroNum3());
		__bean.setTotalNum3(getTotalNum3());
		__bean.setSixNum4(getSixNum4());
		__bean.setSevenNum4(getSevenNum4());
		__bean.setEightNum4(getEightNum4());
		__bean.setNineNum4(getNineNum4());
		__bean.setZeroNum4(getZeroNum4());
		__bean.setTotalNum4(getTotalNum4());
		__bean.setSixNum5(getSixNum5());
		__bean.setSevenNum5(getSevenNum5());
		__bean.setEightNum5(getEightNum5());
		__bean.setNineNum5(getNineNum5());
		__bean.setZeroNum5(getZeroNum5());
		__bean.setTotalNum5(getTotalNum5());
		__bean.setSixNum6(getSixNum6());
		__bean.setSevenNum6(getSevenNum6());
		__bean.setEightNum6(getEightNum6());
		__bean.setNineNum6(getNineNum6());
		__bean.setZeroNum6(getZeroNum6());
		__bean.setTotalNum6(getTotalNum6());
		__bean.setSixNum7(getSixNum7());
		__bean.setSevenNum7(getSevenNum7());
		__bean.setEightNum7(getEightNum7());
		__bean.setNineNum7(getNineNum7());
		__bean.setZeroNum7(getZeroNum7());
		__bean.setTotalNum7(getTotalNum7());
		__bean.setSixNum8(getSixNum8());
		__bean.setSevenNum8(getSevenNum8());
		__bean.setEightNum8(getEightNum8());
		__bean.setNineNum8(getNineNum8());
		__bean.setZeroNum8(getZeroNum8());
		__bean.setTotalNum8(getTotalNum8());
		__bean.setSixNum9(getSixNum9());
		__bean.setSevenNum9(getSevenNum9());
		__bean.setEightNum9(getEightNum9());
		__bean.setNineNum9(getNineNum9());
		__bean.setZeroNum9(getZeroNum9());
		__bean.setTotalNum9(getTotalNum9());
		__bean.setSixNum10(getSixNum10());
		__bean.setSevenNum10(getSevenNum10());
		__bean.setEightNum10(getEightNum10());
		__bean.setNineNum10(getNineNum10());
		__bean.setZeroNum10(getZeroNum10());
		__bean.setTotalNum10(getTotalNum10());
		__bean.setSixNum11(getSixNum11());
		__bean.setSevenNum11(getSevenNum11());
		__bean.setEightNum11(getEightNum11());
		__bean.setNineNum11(getNineNum11());
		__bean.setZeroNum11(getZeroNum11());
		__bean.setTotalNum11(getTotalNum11());
		__bean.setSixNum12(getSixNum12());
		__bean.setSevenNum12(getSevenNum12());
		__bean.setEightNum12(getEightNum12());
		__bean.setNineNum12(getNineNum12());
		__bean.setZeroNum12(getZeroNum12());
		__bean.setTotalNum12(getTotalNum12());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getSixNum1() == null ? "" : getSixNum1());
		sb.append(",");
		sb.append(getSevenNum1() == null ? "" : getSevenNum1());
		sb.append(",");
		sb.append(getEightNum1() == null ? "" : getEightNum1());
		sb.append(",");
		sb.append(getNineNum1() == null ? "" : getNineNum1());
		sb.append(",");
		sb.append(getZeroNum1() == null ? "" : getZeroNum1());
		sb.append(",");
		sb.append(getTotalNum1() == null ? "" : getTotalNum1());
		sb.append(",");
		sb.append(getSixNum2() == null ? "" : getSixNum2());
		sb.append(",");
		sb.append(getSevenNum2() == null ? "" : getSevenNum2());
		sb.append(",");
		sb.append(getEightNum2() == null ? "" : getEightNum2());
		sb.append(",");
		sb.append(getNineNum2() == null ? "" : getNineNum2());
		sb.append(",");
		sb.append(getZeroNum2() == null ? "" : getZeroNum2());
		sb.append(",");
		sb.append(getTotalNum2() == null ? "" : getTotalNum2());
		sb.append(",");
		sb.append(getSixNum3() == null ? "" : getSixNum3());
		sb.append(",");
		sb.append(getSevenNum3() == null ? "" : getSevenNum3());
		sb.append(",");
		sb.append(getEightNum3() == null ? "" : getEightNum3());
		sb.append(",");
		sb.append(getNineNum3() == null ? "" : getNineNum3());
		sb.append(",");
		sb.append(getZeroNum3() == null ? "" : getZeroNum3());
		sb.append(",");
		sb.append(getTotalNum3() == null ? "" : getTotalNum3());
		sb.append(",");
		sb.append(getSixNum4() == null ? "" : getSixNum4());
		sb.append(",");
		sb.append(getSevenNum4() == null ? "" : getSevenNum4());
		sb.append(",");
		sb.append(getEightNum4() == null ? "" : getEightNum4());
		sb.append(",");
		sb.append(getNineNum4() == null ? "" : getNineNum4());
		sb.append(",");
		sb.append(getZeroNum4() == null ? "" : getZeroNum4());
		sb.append(",");
		sb.append(getTotalNum4() == null ? "" : getTotalNum4());
		sb.append(",");
		sb.append(getSixNum5() == null ? "" : getSixNum5());
		sb.append(",");
		sb.append(getSevenNum5() == null ? "" : getSevenNum5());
		sb.append(",");
		sb.append(getEightNum5() == null ? "" : getEightNum5());
		sb.append(",");
		sb.append(getNineNum5() == null ? "" : getNineNum5());
		sb.append(",");
		sb.append(getZeroNum5() == null ? "" : getZeroNum5());
		sb.append(",");
		sb.append(getTotalNum5() == null ? "" : getTotalNum5());
		sb.append(",");
		sb.append(getSixNum6() == null ? "" : getSixNum6());
		sb.append(",");
		sb.append(getSevenNum6() == null ? "" : getSevenNum6());
		sb.append(",");
		sb.append(getEightNum6() == null ? "" : getEightNum6());
		sb.append(",");
		sb.append(getNineNum6() == null ? "" : getNineNum6());
		sb.append(",");
		sb.append(getZeroNum6() == null ? "" : getZeroNum6());
		sb.append(",");
		sb.append(getTotalNum6() == null ? "" : getTotalNum6());
		sb.append(",");
		sb.append(getSixNum7() == null ? "" : getSixNum7());
		sb.append(",");
		sb.append(getSevenNum7() == null ? "" : getSevenNum7());
		sb.append(",");
		sb.append(getEightNum7() == null ? "" : getEightNum7());
		sb.append(",");
		sb.append(getNineNum7() == null ? "" : getNineNum7());
		sb.append(",");
		sb.append(getZeroNum7() == null ? "" : getZeroNum7());
		sb.append(",");
		sb.append(getTotalNum7() == null ? "" : getTotalNum7());
		sb.append(",");
		sb.append(getSixNum8() == null ? "" : getSixNum8());
		sb.append(",");
		sb.append(getSevenNum8() == null ? "" : getSevenNum8());
		sb.append(",");
		sb.append(getEightNum8() == null ? "" : getEightNum8());
		sb.append(",");
		sb.append(getNineNum8() == null ? "" : getNineNum8());
		sb.append(",");
		sb.append(getZeroNum8() == null ? "" : getZeroNum8());
		sb.append(",");
		sb.append(getTotalNum8() == null ? "" : getTotalNum8());
		sb.append(",");
		sb.append(getSixNum9() == null ? "" : getSixNum9());
		sb.append(",");
		sb.append(getSevenNum9() == null ? "" : getSevenNum9());
		sb.append(",");
		sb.append(getEightNum9() == null ? "" : getEightNum9());
		sb.append(",");
		sb.append(getNineNum9() == null ? "" : getNineNum9());
		sb.append(",");
		sb.append(getZeroNum9() == null ? "" : getZeroNum9());
		sb.append(",");
		sb.append(getTotalNum9() == null ? "" : getTotalNum9());
		sb.append(",");
		sb.append(getSixNum10() == null ? "" : getSixNum10());
		sb.append(",");
		sb.append(getSevenNum10() == null ? "" : getSevenNum10());
		sb.append(",");
		sb.append(getEightNum10() == null ? "" : getEightNum10());
		sb.append(",");
		sb.append(getNineNum10() == null ? "" : getNineNum10());
		sb.append(",");
		sb.append(getZeroNum10() == null ? "" : getZeroNum10());
		sb.append(",");
		sb.append(getTotalNum10() == null ? "" : getTotalNum10());
		sb.append(",");
		sb.append(getSixNum11() == null ? "" : getSixNum11());
		sb.append(",");
		sb.append(getSevenNum11() == null ? "" : getSevenNum11());
		sb.append(",");
		sb.append(getEightNum11() == null ? "" : getEightNum11());
		sb.append(",");
		sb.append(getNineNum11() == null ? "" : getNineNum11());
		sb.append(",");
		sb.append(getZeroNum11() == null ? "" : getZeroNum11());
		sb.append(",");
		sb.append(getTotalNum11() == null ? "" : getTotalNum11());
		sb.append(",");
		sb.append(getSixNum12() == null ? "" : getSixNum12());
		sb.append(",");
		sb.append(getSevenNum12() == null ? "" : getSevenNum12());
		sb.append(",");
		sb.append(getEightNum12() == null ? "" : getEightNum12());
		sb.append(",");
		sb.append(getNineNum12() == null ? "" : getNineNum12());
		sb.append(",");
		sb.append(getZeroNum12() == null ? "" : getZeroNum12());
		sb.append(",");
		sb.append(getTotalNum12() == null ? "" : getTotalNum12());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOnEmployeeAgeTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__six_num_1);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_1);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_1);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_1);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_1);
		hash = 97 * hash + Objects.hashCode(this.__total_num_1);
		hash = 97 * hash + Objects.hashCode(this.__six_num_2);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_2);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_2);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_2);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_2);
		hash = 97 * hash + Objects.hashCode(this.__total_num_2);
		hash = 97 * hash + Objects.hashCode(this.__six_num_3);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_3);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_3);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_3);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_3);
		hash = 97 * hash + Objects.hashCode(this.__total_num_3);
		hash = 97 * hash + Objects.hashCode(this.__six_num_4);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_4);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_4);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_4);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_4);
		hash = 97 * hash + Objects.hashCode(this.__total_num_4);
		hash = 97 * hash + Objects.hashCode(this.__six_num_5);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_5);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_5);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_5);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_5);
		hash = 97 * hash + Objects.hashCode(this.__total_num_5);
		hash = 97 * hash + Objects.hashCode(this.__six_num_6);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_6);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_6);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_6);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_6);
		hash = 97 * hash + Objects.hashCode(this.__total_num_6);
		hash = 97 * hash + Objects.hashCode(this.__six_num_7);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_7);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_7);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_7);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_7);
		hash = 97 * hash + Objects.hashCode(this.__total_num_7);
		hash = 97 * hash + Objects.hashCode(this.__six_num_8);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_8);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_8);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_8);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_8);
		hash = 97 * hash + Objects.hashCode(this.__total_num_8);
		hash = 97 * hash + Objects.hashCode(this.__six_num_9);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_9);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_9);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_9);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_9);
		hash = 97 * hash + Objects.hashCode(this.__total_num_9);
		hash = 97 * hash + Objects.hashCode(this.__six_num_10);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_10);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_10);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_10);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_10);
		hash = 97 * hash + Objects.hashCode(this.__total_num_10);
		hash = 97 * hash + Objects.hashCode(this.__six_num_11);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_11);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_11);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_11);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_11);
		hash = 97 * hash + Objects.hashCode(this.__total_num_11);
		hash = 97 * hash + Objects.hashCode(this.__six_num_12);
		hash = 97 * hash + Objects.hashCode(this.__seven_num_12);
		hash = 97 * hash + Objects.hashCode(this.__eight_num_12);
		hash = 97 * hash + Objects.hashCode(this.__nine_num_12);
		hash = 97 * hash + Objects.hashCode(this.__zero_num_12);
		hash = 97 * hash + Objects.hashCode(this.__total_num_12);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOnEmployeeAgeTotal o = (BaseReportOnEmployeeAgeTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__six_num_1, o.getSixNum1())) return false;
		if(!Objects.equals(this.__seven_num_1, o.getSevenNum1())) return false;
		if(!Objects.equals(this.__eight_num_1, o.getEightNum1())) return false;
		if(!Objects.equals(this.__nine_num_1, o.getNineNum1())) return false;
		if(!Objects.equals(this.__zero_num_1, o.getZeroNum1())) return false;
		if(!Objects.equals(this.__total_num_1, o.getTotalNum1())) return false;
		if(!Objects.equals(this.__six_num_2, o.getSixNum2())) return false;
		if(!Objects.equals(this.__seven_num_2, o.getSevenNum2())) return false;
		if(!Objects.equals(this.__eight_num_2, o.getEightNum2())) return false;
		if(!Objects.equals(this.__nine_num_2, o.getNineNum2())) return false;
		if(!Objects.equals(this.__zero_num_2, o.getZeroNum2())) return false;
		if(!Objects.equals(this.__total_num_2, o.getTotalNum2())) return false;
		if(!Objects.equals(this.__six_num_3, o.getSixNum3())) return false;
		if(!Objects.equals(this.__seven_num_3, o.getSevenNum3())) return false;
		if(!Objects.equals(this.__eight_num_3, o.getEightNum3())) return false;
		if(!Objects.equals(this.__nine_num_3, o.getNineNum3())) return false;
		if(!Objects.equals(this.__zero_num_3, o.getZeroNum3())) return false;
		if(!Objects.equals(this.__total_num_3, o.getTotalNum3())) return false;
		if(!Objects.equals(this.__six_num_4, o.getSixNum4())) return false;
		if(!Objects.equals(this.__seven_num_4, o.getSevenNum4())) return false;
		if(!Objects.equals(this.__eight_num_4, o.getEightNum4())) return false;
		if(!Objects.equals(this.__nine_num_4, o.getNineNum4())) return false;
		if(!Objects.equals(this.__zero_num_4, o.getZeroNum4())) return false;
		if(!Objects.equals(this.__total_num_4, o.getTotalNum4())) return false;
		if(!Objects.equals(this.__six_num_5, o.getSixNum5())) return false;
		if(!Objects.equals(this.__seven_num_5, o.getSevenNum5())) return false;
		if(!Objects.equals(this.__eight_num_5, o.getEightNum5())) return false;
		if(!Objects.equals(this.__nine_num_5, o.getNineNum5())) return false;
		if(!Objects.equals(this.__zero_num_5, o.getZeroNum5())) return false;
		if(!Objects.equals(this.__total_num_5, o.getTotalNum5())) return false;
		if(!Objects.equals(this.__six_num_6, o.getSixNum6())) return false;
		if(!Objects.equals(this.__seven_num_6, o.getSevenNum6())) return false;
		if(!Objects.equals(this.__eight_num_6, o.getEightNum6())) return false;
		if(!Objects.equals(this.__nine_num_6, o.getNineNum6())) return false;
		if(!Objects.equals(this.__zero_num_6, o.getZeroNum6())) return false;
		if(!Objects.equals(this.__total_num_6, o.getTotalNum6())) return false;
		if(!Objects.equals(this.__six_num_7, o.getSixNum7())) return false;
		if(!Objects.equals(this.__seven_num_7, o.getSevenNum7())) return false;
		if(!Objects.equals(this.__eight_num_7, o.getEightNum7())) return false;
		if(!Objects.equals(this.__nine_num_7, o.getNineNum7())) return false;
		if(!Objects.equals(this.__zero_num_7, o.getZeroNum7())) return false;
		if(!Objects.equals(this.__total_num_7, o.getTotalNum7())) return false;
		if(!Objects.equals(this.__six_num_8, o.getSixNum8())) return false;
		if(!Objects.equals(this.__seven_num_8, o.getSevenNum8())) return false;
		if(!Objects.equals(this.__eight_num_8, o.getEightNum8())) return false;
		if(!Objects.equals(this.__nine_num_8, o.getNineNum8())) return false;
		if(!Objects.equals(this.__zero_num_8, o.getZeroNum8())) return false;
		if(!Objects.equals(this.__total_num_8, o.getTotalNum8())) return false;
		if(!Objects.equals(this.__six_num_9, o.getSixNum9())) return false;
		if(!Objects.equals(this.__seven_num_9, o.getSevenNum9())) return false;
		if(!Objects.equals(this.__eight_num_9, o.getEightNum9())) return false;
		if(!Objects.equals(this.__nine_num_9, o.getNineNum9())) return false;
		if(!Objects.equals(this.__zero_num_9, o.getZeroNum9())) return false;
		if(!Objects.equals(this.__total_num_9, o.getTotalNum9())) return false;
		if(!Objects.equals(this.__six_num_10, o.getSixNum10())) return false;
		if(!Objects.equals(this.__seven_num_10, o.getSevenNum10())) return false;
		if(!Objects.equals(this.__eight_num_10, o.getEightNum10())) return false;
		if(!Objects.equals(this.__nine_num_10, o.getNineNum10())) return false;
		if(!Objects.equals(this.__zero_num_10, o.getZeroNum10())) return false;
		if(!Objects.equals(this.__total_num_10, o.getTotalNum10())) return false;
		if(!Objects.equals(this.__six_num_11, o.getSixNum11())) return false;
		if(!Objects.equals(this.__seven_num_11, o.getSevenNum11())) return false;
		if(!Objects.equals(this.__eight_num_11, o.getEightNum11())) return false;
		if(!Objects.equals(this.__nine_num_11, o.getNineNum11())) return false;
		if(!Objects.equals(this.__zero_num_11, o.getZeroNum11())) return false;
		if(!Objects.equals(this.__total_num_11, o.getTotalNum11())) return false;
		if(!Objects.equals(this.__six_num_12, o.getSixNum12())) return false;
		if(!Objects.equals(this.__seven_num_12, o.getSevenNum12())) return false;
		if(!Objects.equals(this.__eight_num_12, o.getEightNum12())) return false;
		if(!Objects.equals(this.__nine_num_12, o.getNineNum12())) return false;
		if(!Objects.equals(this.__zero_num_12, o.getZeroNum12())) return false;
		if(!Objects.equals(this.__total_num_12, o.getTotalNum12())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getSixNum1() != null) sb.append(__wrapDecimal(count++, "sixNum1", getSixNum1()));
		if(getSevenNum1() != null) sb.append(__wrapDecimal(count++, "sevenNum1", getSevenNum1()));
		if(getEightNum1() != null) sb.append(__wrapDecimal(count++, "eightNum1", getEightNum1()));
		if(getNineNum1() != null) sb.append(__wrapDecimal(count++, "nineNum1", getNineNum1()));
		if(getZeroNum1() != null) sb.append(__wrapDecimal(count++, "zeroNum1", getZeroNum1()));
		if(getTotalNum1() != null) sb.append(__wrapDecimal(count++, "totalNum1", getTotalNum1()));
		if(getSixNum2() != null) sb.append(__wrapDecimal(count++, "sixNum2", getSixNum2()));
		if(getSevenNum2() != null) sb.append(__wrapDecimal(count++, "sevenNum2", getSevenNum2()));
		if(getEightNum2() != null) sb.append(__wrapDecimal(count++, "eightNum2", getEightNum2()));
		if(getNineNum2() != null) sb.append(__wrapDecimal(count++, "nineNum2", getNineNum2()));
		if(getZeroNum2() != null) sb.append(__wrapDecimal(count++, "zeroNum2", getZeroNum2()));
		if(getTotalNum2() != null) sb.append(__wrapDecimal(count++, "totalNum2", getTotalNum2()));
		if(getSixNum3() != null) sb.append(__wrapDecimal(count++, "sixNum3", getSixNum3()));
		if(getSevenNum3() != null) sb.append(__wrapDecimal(count++, "sevenNum3", getSevenNum3()));
		if(getEightNum3() != null) sb.append(__wrapDecimal(count++, "eightNum3", getEightNum3()));
		if(getNineNum3() != null) sb.append(__wrapDecimal(count++, "nineNum3", getNineNum3()));
		if(getZeroNum3() != null) sb.append(__wrapDecimal(count++, "zeroNum3", getZeroNum3()));
		if(getTotalNum3() != null) sb.append(__wrapDecimal(count++, "totalNum3", getTotalNum3()));
		if(getSixNum4() != null) sb.append(__wrapDecimal(count++, "sixNum4", getSixNum4()));
		if(getSevenNum4() != null) sb.append(__wrapDecimal(count++, "sevenNum4", getSevenNum4()));
		if(getEightNum4() != null) sb.append(__wrapDecimal(count++, "eightNum4", getEightNum4()));
		if(getNineNum4() != null) sb.append(__wrapDecimal(count++, "nineNum4", getNineNum4()));
		if(getZeroNum4() != null) sb.append(__wrapDecimal(count++, "zeroNum4", getZeroNum4()));
		if(getTotalNum4() != null) sb.append(__wrapDecimal(count++, "totalNum4", getTotalNum4()));
		if(getSixNum5() != null) sb.append(__wrapDecimal(count++, "sixNum5", getSixNum5()));
		if(getSevenNum5() != null) sb.append(__wrapDecimal(count++, "sevenNum5", getSevenNum5()));
		if(getEightNum5() != null) sb.append(__wrapDecimal(count++, "eightNum5", getEightNum5()));
		if(getNineNum5() != null) sb.append(__wrapDecimal(count++, "nineNum5", getNineNum5()));
		if(getZeroNum5() != null) sb.append(__wrapDecimal(count++, "zeroNum5", getZeroNum5()));
		if(getTotalNum5() != null) sb.append(__wrapDecimal(count++, "totalNum5", getTotalNum5()));
		if(getSixNum6() != null) sb.append(__wrapDecimal(count++, "sixNum6", getSixNum6()));
		if(getSevenNum6() != null) sb.append(__wrapDecimal(count++, "sevenNum6", getSevenNum6()));
		if(getEightNum6() != null) sb.append(__wrapDecimal(count++, "eightNum6", getEightNum6()));
		if(getNineNum6() != null) sb.append(__wrapDecimal(count++, "nineNum6", getNineNum6()));
		if(getZeroNum6() != null) sb.append(__wrapDecimal(count++, "zeroNum6", getZeroNum6()));
		if(getTotalNum6() != null) sb.append(__wrapDecimal(count++, "totalNum6", getTotalNum6()));
		if(getSixNum7() != null) sb.append(__wrapDecimal(count++, "sixNum7", getSixNum7()));
		if(getSevenNum7() != null) sb.append(__wrapDecimal(count++, "sevenNum7", getSevenNum7()));
		if(getEightNum7() != null) sb.append(__wrapDecimal(count++, "eightNum7", getEightNum7()));
		if(getNineNum7() != null) sb.append(__wrapDecimal(count++, "nineNum7", getNineNum7()));
		if(getZeroNum7() != null) sb.append(__wrapDecimal(count++, "zeroNum7", getZeroNum7()));
		if(getTotalNum7() != null) sb.append(__wrapDecimal(count++, "totalNum7", getTotalNum7()));
		if(getSixNum8() != null) sb.append(__wrapDecimal(count++, "sixNum8", getSixNum8()));
		if(getSevenNum8() != null) sb.append(__wrapDecimal(count++, "sevenNum8", getSevenNum8()));
		if(getEightNum8() != null) sb.append(__wrapDecimal(count++, "eightNum8", getEightNum8()));
		if(getNineNum8() != null) sb.append(__wrapDecimal(count++, "nineNum8", getNineNum8()));
		if(getZeroNum8() != null) sb.append(__wrapDecimal(count++, "zeroNum8", getZeroNum8()));
		if(getTotalNum8() != null) sb.append(__wrapDecimal(count++, "totalNum8", getTotalNum8()));
		if(getSixNum9() != null) sb.append(__wrapDecimal(count++, "sixNum9", getSixNum9()));
		if(getSevenNum9() != null) sb.append(__wrapDecimal(count++, "sevenNum9", getSevenNum9()));
		if(getEightNum9() != null) sb.append(__wrapDecimal(count++, "eightNum9", getEightNum9()));
		if(getNineNum9() != null) sb.append(__wrapDecimal(count++, "nineNum9", getNineNum9()));
		if(getZeroNum9() != null) sb.append(__wrapDecimal(count++, "zeroNum9", getZeroNum9()));
		if(getTotalNum9() != null) sb.append(__wrapDecimal(count++, "totalNum9", getTotalNum9()));
		if(getSixNum10() != null) sb.append(__wrapDecimal(count++, "sixNum10", getSixNum10()));
		if(getSevenNum10() != null) sb.append(__wrapDecimal(count++, "sevenNum10", getSevenNum10()));
		if(getEightNum10() != null) sb.append(__wrapDecimal(count++, "eightNum10", getEightNum10()));
		if(getNineNum10() != null) sb.append(__wrapDecimal(count++, "nineNum10", getNineNum10()));
		if(getZeroNum10() != null) sb.append(__wrapDecimal(count++, "zeroNum10", getZeroNum10()));
		if(getTotalNum10() != null) sb.append(__wrapDecimal(count++, "totalNum10", getTotalNum10()));
		if(getSixNum11() != null) sb.append(__wrapDecimal(count++, "sixNum11", getSixNum11()));
		if(getSevenNum11() != null) sb.append(__wrapDecimal(count++, "sevenNum11", getSevenNum11()));
		if(getEightNum11() != null) sb.append(__wrapDecimal(count++, "eightNum11", getEightNum11()));
		if(getNineNum11() != null) sb.append(__wrapDecimal(count++, "nineNum11", getNineNum11()));
		if(getZeroNum11() != null) sb.append(__wrapDecimal(count++, "zeroNum11", getZeroNum11()));
		if(getTotalNum11() != null) sb.append(__wrapDecimal(count++, "totalNum11", getTotalNum11()));
		if(getSixNum12() != null) sb.append(__wrapDecimal(count++, "sixNum12", getSixNum12()));
		if(getSevenNum12() != null) sb.append(__wrapDecimal(count++, "sevenNum12", getSevenNum12()));
		if(getEightNum12() != null) sb.append(__wrapDecimal(count++, "eightNum12", getEightNum12()));
		if(getNineNum12() != null) sb.append(__wrapDecimal(count++, "nineNum12", getNineNum12()));
		if(getZeroNum12() != null) sb.append(__wrapDecimal(count++, "zeroNum12", getZeroNum12()));
		if(getTotalNum12() != null) sb.append(__wrapDecimal(count++, "totalNum12", getTotalNum12()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getSixNum1() != null) res.put("sixNum1", getSixNum1());
		if(getSevenNum1() != null) res.put("sevenNum1", getSevenNum1());
		if(getEightNum1() != null) res.put("eightNum1", getEightNum1());
		if(getNineNum1() != null) res.put("nineNum1", getNineNum1());
		if(getZeroNum1() != null) res.put("zeroNum1", getZeroNum1());
		if(getTotalNum1() != null) res.put("totalNum1", getTotalNum1());
		if(getSixNum2() != null) res.put("sixNum2", getSixNum2());
		if(getSevenNum2() != null) res.put("sevenNum2", getSevenNum2());
		if(getEightNum2() != null) res.put("eightNum2", getEightNum2());
		if(getNineNum2() != null) res.put("nineNum2", getNineNum2());
		if(getZeroNum2() != null) res.put("zeroNum2", getZeroNum2());
		if(getTotalNum2() != null) res.put("totalNum2", getTotalNum2());
		if(getSixNum3() != null) res.put("sixNum3", getSixNum3());
		if(getSevenNum3() != null) res.put("sevenNum3", getSevenNum3());
		if(getEightNum3() != null) res.put("eightNum3", getEightNum3());
		if(getNineNum3() != null) res.put("nineNum3", getNineNum3());
		if(getZeroNum3() != null) res.put("zeroNum3", getZeroNum3());
		if(getTotalNum3() != null) res.put("totalNum3", getTotalNum3());
		if(getSixNum4() != null) res.put("sixNum4", getSixNum4());
		if(getSevenNum4() != null) res.put("sevenNum4", getSevenNum4());
		if(getEightNum4() != null) res.put("eightNum4", getEightNum4());
		if(getNineNum4() != null) res.put("nineNum4", getNineNum4());
		if(getZeroNum4() != null) res.put("zeroNum4", getZeroNum4());
		if(getTotalNum4() != null) res.put("totalNum4", getTotalNum4());
		if(getSixNum5() != null) res.put("sixNum5", getSixNum5());
		if(getSevenNum5() != null) res.put("sevenNum5", getSevenNum5());
		if(getEightNum5() != null) res.put("eightNum5", getEightNum5());
		if(getNineNum5() != null) res.put("nineNum5", getNineNum5());
		if(getZeroNum5() != null) res.put("zeroNum5", getZeroNum5());
		if(getTotalNum5() != null) res.put("totalNum5", getTotalNum5());
		if(getSixNum6() != null) res.put("sixNum6", getSixNum6());
		if(getSevenNum6() != null) res.put("sevenNum6", getSevenNum6());
		if(getEightNum6() != null) res.put("eightNum6", getEightNum6());
		if(getNineNum6() != null) res.put("nineNum6", getNineNum6());
		if(getZeroNum6() != null) res.put("zeroNum6", getZeroNum6());
		if(getTotalNum6() != null) res.put("totalNum6", getTotalNum6());
		if(getSixNum7() != null) res.put("sixNum7", getSixNum7());
		if(getSevenNum7() != null) res.put("sevenNum7", getSevenNum7());
		if(getEightNum7() != null) res.put("eightNum7", getEightNum7());
		if(getNineNum7() != null) res.put("nineNum7", getNineNum7());
		if(getZeroNum7() != null) res.put("zeroNum7", getZeroNum7());
		if(getTotalNum7() != null) res.put("totalNum7", getTotalNum7());
		if(getSixNum8() != null) res.put("sixNum8", getSixNum8());
		if(getSevenNum8() != null) res.put("sevenNum8", getSevenNum8());
		if(getEightNum8() != null) res.put("eightNum8", getEightNum8());
		if(getNineNum8() != null) res.put("nineNum8", getNineNum8());
		if(getZeroNum8() != null) res.put("zeroNum8", getZeroNum8());
		if(getTotalNum8() != null) res.put("totalNum8", getTotalNum8());
		if(getSixNum9() != null) res.put("sixNum9", getSixNum9());
		if(getSevenNum9() != null) res.put("sevenNum9", getSevenNum9());
		if(getEightNum9() != null) res.put("eightNum9", getEightNum9());
		if(getNineNum9() != null) res.put("nineNum9", getNineNum9());
		if(getZeroNum9() != null) res.put("zeroNum9", getZeroNum9());
		if(getTotalNum9() != null) res.put("totalNum9", getTotalNum9());
		if(getSixNum10() != null) res.put("sixNum10", getSixNum10());
		if(getSevenNum10() != null) res.put("sevenNum10", getSevenNum10());
		if(getEightNum10() != null) res.put("eightNum10", getEightNum10());
		if(getNineNum10() != null) res.put("nineNum10", getNineNum10());
		if(getZeroNum10() != null) res.put("zeroNum10", getZeroNum10());
		if(getTotalNum10() != null) res.put("totalNum10", getTotalNum10());
		if(getSixNum11() != null) res.put("sixNum11", getSixNum11());
		if(getSevenNum11() != null) res.put("sevenNum11", getSevenNum11());
		if(getEightNum11() != null) res.put("eightNum11", getEightNum11());
		if(getNineNum11() != null) res.put("nineNum11", getNineNum11());
		if(getZeroNum11() != null) res.put("zeroNum11", getZeroNum11());
		if(getTotalNum11() != null) res.put("totalNum11", getTotalNum11());
		if(getSixNum12() != null) res.put("sixNum12", getSixNum12());
		if(getSevenNum12() != null) res.put("sevenNum12", getSevenNum12());
		if(getEightNum12() != null) res.put("eightNum12", getEightNum12());
		if(getNineNum12() != null) res.put("nineNum12", getNineNum12());
		if(getZeroNum12() != null) res.put("zeroNum12", getZeroNum12());
		if(getTotalNum12() != null) res.put("totalNum12", getTotalNum12());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("sixNum1")) != null) setSixNum1(__getDecimal(val));  
		if((val = values.get("sevenNum1")) != null) setSevenNum1(__getDecimal(val));  
		if((val = values.get("eightNum1")) != null) setEightNum1(__getDecimal(val));  
		if((val = values.get("nineNum1")) != null) setNineNum1(__getDecimal(val));  
		if((val = values.get("zeroNum1")) != null) setZeroNum1(__getDecimal(val));  
		if((val = values.get("totalNum1")) != null) setTotalNum1(__getDecimal(val));  
		if((val = values.get("sixNum2")) != null) setSixNum2(__getDecimal(val));  
		if((val = values.get("sevenNum2")) != null) setSevenNum2(__getDecimal(val));  
		if((val = values.get("eightNum2")) != null) setEightNum2(__getDecimal(val));  
		if((val = values.get("nineNum2")) != null) setNineNum2(__getDecimal(val));  
		if((val = values.get("zeroNum2")) != null) setZeroNum2(__getDecimal(val));  
		if((val = values.get("totalNum2")) != null) setTotalNum2(__getDecimal(val));  
		if((val = values.get("sixNum3")) != null) setSixNum3(__getDecimal(val));  
		if((val = values.get("sevenNum3")) != null) setSevenNum3(__getDecimal(val));  
		if((val = values.get("eightNum3")) != null) setEightNum3(__getDecimal(val));  
		if((val = values.get("nineNum3")) != null) setNineNum3(__getDecimal(val));  
		if((val = values.get("zeroNum3")) != null) setZeroNum3(__getDecimal(val));  
		if((val = values.get("totalNum3")) != null) setTotalNum3(__getDecimal(val));  
		if((val = values.get("sixNum4")) != null) setSixNum4(__getDecimal(val));  
		if((val = values.get("sevenNum4")) != null) setSevenNum4(__getDecimal(val));  
		if((val = values.get("eightNum4")) != null) setEightNum4(__getDecimal(val));  
		if((val = values.get("nineNum4")) != null) setNineNum4(__getDecimal(val));  
		if((val = values.get("zeroNum4")) != null) setZeroNum4(__getDecimal(val));  
		if((val = values.get("totalNum4")) != null) setTotalNum4(__getDecimal(val));  
		if((val = values.get("sixNum5")) != null) setSixNum5(__getDecimal(val));  
		if((val = values.get("sevenNum5")) != null) setSevenNum5(__getDecimal(val));  
		if((val = values.get("eightNum5")) != null) setEightNum5(__getDecimal(val));  
		if((val = values.get("nineNum5")) != null) setNineNum5(__getDecimal(val));  
		if((val = values.get("zeroNum5")) != null) setZeroNum5(__getDecimal(val));  
		if((val = values.get("totalNum5")) != null) setTotalNum5(__getDecimal(val));  
		if((val = values.get("sixNum6")) != null) setSixNum6(__getDecimal(val));  
		if((val = values.get("sevenNum6")) != null) setSevenNum6(__getDecimal(val));  
		if((val = values.get("eightNum6")) != null) setEightNum6(__getDecimal(val));  
		if((val = values.get("nineNum6")) != null) setNineNum6(__getDecimal(val));  
		if((val = values.get("zeroNum6")) != null) setZeroNum6(__getDecimal(val));  
		if((val = values.get("totalNum6")) != null) setTotalNum6(__getDecimal(val));  
		if((val = values.get("sixNum7")) != null) setSixNum7(__getDecimal(val));  
		if((val = values.get("sevenNum7")) != null) setSevenNum7(__getDecimal(val));  
		if((val = values.get("eightNum7")) != null) setEightNum7(__getDecimal(val));  
		if((val = values.get("nineNum7")) != null) setNineNum7(__getDecimal(val));  
		if((val = values.get("zeroNum7")) != null) setZeroNum7(__getDecimal(val));  
		if((val = values.get("totalNum7")) != null) setTotalNum7(__getDecimal(val));  
		if((val = values.get("sixNum8")) != null) setSixNum8(__getDecimal(val));  
		if((val = values.get("sevenNum8")) != null) setSevenNum8(__getDecimal(val));  
		if((val = values.get("eightNum8")) != null) setEightNum8(__getDecimal(val));  
		if((val = values.get("nineNum8")) != null) setNineNum8(__getDecimal(val));  
		if((val = values.get("zeroNum8")) != null) setZeroNum8(__getDecimal(val));  
		if((val = values.get("totalNum8")) != null) setTotalNum8(__getDecimal(val));  
		if((val = values.get("sixNum9")) != null) setSixNum9(__getDecimal(val));  
		if((val = values.get("sevenNum9")) != null) setSevenNum9(__getDecimal(val));  
		if((val = values.get("eightNum9")) != null) setEightNum9(__getDecimal(val));  
		if((val = values.get("nineNum9")) != null) setNineNum9(__getDecimal(val));  
		if((val = values.get("zeroNum9")) != null) setZeroNum9(__getDecimal(val));  
		if((val = values.get("totalNum9")) != null) setTotalNum9(__getDecimal(val));  
		if((val = values.get("sixNum10")) != null) setSixNum10(__getDecimal(val));  
		if((val = values.get("sevenNum10")) != null) setSevenNum10(__getDecimal(val));  
		if((val = values.get("eightNum10")) != null) setEightNum10(__getDecimal(val));  
		if((val = values.get("nineNum10")) != null) setNineNum10(__getDecimal(val));  
		if((val = values.get("zeroNum10")) != null) setZeroNum10(__getDecimal(val));  
		if((val = values.get("totalNum10")) != null) setTotalNum10(__getDecimal(val));  
		if((val = values.get("sixNum11")) != null) setSixNum11(__getDecimal(val));  
		if((val = values.get("sevenNum11")) != null) setSevenNum11(__getDecimal(val));  
		if((val = values.get("eightNum11")) != null) setEightNum11(__getDecimal(val));  
		if((val = values.get("nineNum11")) != null) setNineNum11(__getDecimal(val));  
		if((val = values.get("zeroNum11")) != null) setZeroNum11(__getDecimal(val));  
		if((val = values.get("totalNum11")) != null) setTotalNum11(__getDecimal(val));  
		if((val = values.get("sixNum12")) != null) setSixNum12(__getDecimal(val));  
		if((val = values.get("sevenNum12")) != null) setSevenNum12(__getDecimal(val));  
		if((val = values.get("eightNum12")) != null) setEightNum12(__getDecimal(val));  
		if((val = values.get("nineNum12")) != null) setNineNum12(__getDecimal(val));  
		if((val = values.get("zeroNum12")) != null) setZeroNum12(__getDecimal(val));  
		if((val = values.get("totalNum12")) != null) setTotalNum12(__getDecimal(val));  
	}

	protected java.lang.Integer  __plate_id ;
	protected java.lang.Integer  __year ;
	protected java.math.BigDecimal  __six_num_1 ;
	protected java.math.BigDecimal  __seven_num_1 ;
	protected java.math.BigDecimal  __eight_num_1 ;
	protected java.math.BigDecimal  __nine_num_1 ;
	protected java.math.BigDecimal  __zero_num_1 ;
	protected java.math.BigDecimal  __total_num_1 ;
	protected java.math.BigDecimal  __six_num_2 ;
	protected java.math.BigDecimal  __seven_num_2 ;
	protected java.math.BigDecimal  __eight_num_2 ;
	protected java.math.BigDecimal  __nine_num_2 ;
	protected java.math.BigDecimal  __zero_num_2 ;
	protected java.math.BigDecimal  __total_num_2 ;
	protected java.math.BigDecimal  __six_num_3 ;
	protected java.math.BigDecimal  __seven_num_3 ;
	protected java.math.BigDecimal  __eight_num_3 ;
	protected java.math.BigDecimal  __nine_num_3 ;
	protected java.math.BigDecimal  __zero_num_3 ;
	protected java.math.BigDecimal  __total_num_3 ;
	protected java.math.BigDecimal  __six_num_4 ;
	protected java.math.BigDecimal  __seven_num_4 ;
	protected java.math.BigDecimal  __eight_num_4 ;
	protected java.math.BigDecimal  __nine_num_4 ;
	protected java.math.BigDecimal  __zero_num_4 ;
	protected java.math.BigDecimal  __total_num_4 ;
	protected java.math.BigDecimal  __six_num_5 ;
	protected java.math.BigDecimal  __seven_num_5 ;
	protected java.math.BigDecimal  __eight_num_5 ;
	protected java.math.BigDecimal  __nine_num_5 ;
	protected java.math.BigDecimal  __zero_num_5 ;
	protected java.math.BigDecimal  __total_num_5 ;
	protected java.math.BigDecimal  __six_num_6 ;
	protected java.math.BigDecimal  __seven_num_6 ;
	protected java.math.BigDecimal  __eight_num_6 ;
	protected java.math.BigDecimal  __nine_num_6 ;
	protected java.math.BigDecimal  __zero_num_6 ;
	protected java.math.BigDecimal  __total_num_6 ;
	protected java.math.BigDecimal  __six_num_7 ;
	protected java.math.BigDecimal  __seven_num_7 ;
	protected java.math.BigDecimal  __eight_num_7 ;
	protected java.math.BigDecimal  __nine_num_7 ;
	protected java.math.BigDecimal  __zero_num_7 ;
	protected java.math.BigDecimal  __total_num_7 ;
	protected java.math.BigDecimal  __six_num_8 ;
	protected java.math.BigDecimal  __seven_num_8 ;
	protected java.math.BigDecimal  __eight_num_8 ;
	protected java.math.BigDecimal  __nine_num_8 ;
	protected java.math.BigDecimal  __zero_num_8 ;
	protected java.math.BigDecimal  __total_num_8 ;
	protected java.math.BigDecimal  __six_num_9 ;
	protected java.math.BigDecimal  __seven_num_9 ;
	protected java.math.BigDecimal  __eight_num_9 ;
	protected java.math.BigDecimal  __nine_num_9 ;
	protected java.math.BigDecimal  __zero_num_9 ;
	protected java.math.BigDecimal  __total_num_9 ;
	protected java.math.BigDecimal  __six_num_10 ;
	protected java.math.BigDecimal  __seven_num_10 ;
	protected java.math.BigDecimal  __eight_num_10 ;
	protected java.math.BigDecimal  __nine_num_10 ;
	protected java.math.BigDecimal  __zero_num_10 ;
	protected java.math.BigDecimal  __total_num_10 ;
	protected java.math.BigDecimal  __six_num_11 ;
	protected java.math.BigDecimal  __seven_num_11 ;
	protected java.math.BigDecimal  __eight_num_11 ;
	protected java.math.BigDecimal  __nine_num_11 ;
	protected java.math.BigDecimal  __zero_num_11 ;
	protected java.math.BigDecimal  __total_num_11 ;
	protected java.math.BigDecimal  __six_num_12 ;
	protected java.math.BigDecimal  __seven_num_12 ;
	protected java.math.BigDecimal  __eight_num_12 ;
	protected java.math.BigDecimal  __nine_num_12 ;
	protected java.math.BigDecimal  __zero_num_12 ;
	protected java.math.BigDecimal  __total_num_12 ;
}
