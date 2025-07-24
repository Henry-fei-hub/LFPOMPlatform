package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOnEmployeeGradeTotal extends GenericBase implements BaseFactory<BaseReportOnEmployeeGradeTotal>, Comparable<BaseReportOnEmployeeGradeTotal> 
{


	public static BaseReportOnEmployeeGradeTotal newInstance(){
		return new BaseReportOnEmployeeGradeTotal();
	}

	@Override
	public BaseReportOnEmployeeGradeTotal make(){
		BaseReportOnEmployeeGradeTotal b = new BaseReportOnEmployeeGradeTotal();
		return b;
	}

	public final static String CS_PLATE_ID = "plate_id" ;
	public final static String CS_YEAR = "year" ;
	public final static String CS_A1 = "a1" ;
	public final static String CS_A2 = "a2" ;
	public final static String CS_A3 = "a3" ;
	public final static String CS_A4 = "a4" ;
	public final static String CS_A5 = "a5" ;
	public final static String CS_A6 = "a6" ;
	public final static String CS_A7 = "a7" ;
	public final static String CS_A8 = "a8" ;
	public final static String CS_A9 = "a9" ;
	public final static String CS_A10 = "a10" ;
	public final static String CS_A11 = "a11" ;
	public final static String CS_A12 = "a12" ;
	public final static String CS_A13 = "a13" ;
	public final static String CS_A14 = "a14" ;
	public final static String CS_A15 = "a15" ;
	public final static String CS_A16 = "a16" ;
	public final static String CS_A17 = "a17" ;
	public final static String CS_A18 = "a18" ;
	public final static String CS_A19 = "a19" ;
	public final static String CS_A20 = "a20" ;
	public final static String CS_B1 = "b1" ;
	public final static String CS_B2 = "b2" ;
	public final static String CS_B3 = "b3" ;
	public final static String CS_B4 = "b4" ;
	public final static String CS_B5 = "b5" ;
	public final static String CS_B6 = "b6" ;
	public final static String CS_B7 = "b7" ;
	public final static String CS_B8 = "b8" ;
	public final static String CS_B9 = "b9" ;
	public final static String CS_B10 = "b10" ;
	public final static String CS_B11 = "b11" ;
	public final static String CS_B12 = "b12" ;
	public final static String CS_B13 = "b13" ;
	public final static String CS_B14 = "b14" ;
	public final static String CS_B15 = "b15" ;
	public final static String CS_B16 = "b16" ;
	public final static String CS_B17 = "b17" ;
	public final static String CS_B18 = "b18" ;
	public final static String CS_B19 = "b19" ;
	public final static String CS_B20 = "b20" ;
	public final static String CS_C1 = "c1" ;
	public final static String CS_C2 = "c2" ;
	public final static String CS_C3 = "c3" ;
	public final static String CS_C4 = "c4" ;
	public final static String CS_C5 = "c5" ;
	public final static String CS_C6 = "c6" ;
	public final static String CS_C7 = "c7" ;
	public final static String CS_C8 = "c8" ;
	public final static String CS_C9 = "c9" ;
	public final static String CS_C10 = "c10" ;
	public final static String CS_C11 = "c11" ;
	public final static String CS_C12 = "c12" ;
	public final static String CS_C13 = "c13" ;
	public final static String CS_C14 = "c14" ;
	public final static String CS_C15 = "c15" ;
	public final static String CS_C16 = "c16" ;
	public final static String CS_C17 = "c17" ;
	public final static String CS_C18 = "c18" ;
	public final static String CS_C19 = "c19" ;
	public final static String CS_C20 = "c20" ;
	public final static String CS_OTHER_NUM = "other_num" ;
	public final static String CS_TOTAL_NUM = "total_num" ;

	public final static String ALL_CAPTIONS = "业务部门,年份,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

	public Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId( Integer value ) {
		this.__plate_id = value;
	}

	public Integer getYear() {
		return this.__year;
	}

	public void setYear( Integer value ) {
		this.__year = value;
	}

	public Long getA1() {
		return this.__a1;
	}

	public void setA1( Long value ) {
		this.__a1 = value;
	}

	public Long getA2() {
		return this.__a2;
	}

	public void setA2( Long value ) {
		this.__a2 = value;
	}

	public Long getA3() {
		return this.__a3;
	}

	public void setA3( Long value ) {
		this.__a3 = value;
	}

	public Long getA4() {
		return this.__a4;
	}

	public void setA4( Long value ) {
		this.__a4 = value;
	}

	public Long getA5() {
		return this.__a5;
	}

	public void setA5( Long value ) {
		this.__a5 = value;
	}

	public Long getA6() {
		return this.__a6;
	}

	public void setA6( Long value ) {
		this.__a6 = value;
	}

	public Long getA7() {
		return this.__a7;
	}

	public void setA7( Long value ) {
		this.__a7 = value;
	}

	public Long getA8() {
		return this.__a8;
	}

	public void setA8( Long value ) {
		this.__a8 = value;
	}

	public Long getA9() {
		return this.__a9;
	}

	public void setA9( Long value ) {
		this.__a9 = value;
	}

	public Long getA10() {
		return this.__a10;
	}

	public void setA10( Long value ) {
		this.__a10 = value;
	}

	public Long getA11() {
		return this.__a11;
	}

	public void setA11( Long value ) {
		this.__a11 = value;
	}

	public Long getA12() {
		return this.__a12;
	}

	public void setA12( Long value ) {
		this.__a12 = value;
	}

	public Long getA13() {
		return this.__a13;
	}

	public void setA13( Long value ) {
		this.__a13 = value;
	}

	public Long getA14() {
		return this.__a14;
	}

	public void setA14( Long value ) {
		this.__a14 = value;
	}

	public Long getA15() {
		return this.__a15;
	}

	public void setA15( Long value ) {
		this.__a15 = value;
	}

	public Long getA16() {
		return this.__a16;
	}

	public void setA16( Long value ) {
		this.__a16 = value;
	}

	public Long getA17() {
		return this.__a17;
	}

	public void setA17( Long value ) {
		this.__a17 = value;
	}

	public Long getA18() {
		return this.__a18;
	}

	public void setA18( Long value ) {
		this.__a18 = value;
	}

	public Long getA19() {
		return this.__a19;
	}

	public void setA19( Long value ) {
		this.__a19 = value;
	}

	public Long getA20() {
		return this.__a20;
	}

	public void setA20( Long value ) {
		this.__a20 = value;
	}

	public Long getB1() {
		return this.__b1;
	}

	public void setB1( Long value ) {
		this.__b1 = value;
	}

	public Long getB2() {
		return this.__b2;
	}

	public void setB2( Long value ) {
		this.__b2 = value;
	}

	public Long getB3() {
		return this.__b3;
	}

	public void setB3( Long value ) {
		this.__b3 = value;
	}

	public Long getB4() {
		return this.__b4;
	}

	public void setB4( Long value ) {
		this.__b4 = value;
	}

	public Long getB5() {
		return this.__b5;
	}

	public void setB5( Long value ) {
		this.__b5 = value;
	}

	public Long getB6() {
		return this.__b6;
	}

	public void setB6( Long value ) {
		this.__b6 = value;
	}

	public Long getB7() {
		return this.__b7;
	}

	public void setB7( Long value ) {
		this.__b7 = value;
	}

	public Long getB8() {
		return this.__b8;
	}

	public void setB8( Long value ) {
		this.__b8 = value;
	}

	public Long getB9() {
		return this.__b9;
	}

	public void setB9( Long value ) {
		this.__b9 = value;
	}

	public Long getB10() {
		return this.__b10;
	}

	public void setB10( Long value ) {
		this.__b10 = value;
	}

	public Long getB11() {
		return this.__b11;
	}

	public void setB11( Long value ) {
		this.__b11 = value;
	}

	public Long getB12() {
		return this.__b12;
	}

	public void setB12( Long value ) {
		this.__b12 = value;
	}

	public Long getB13() {
		return this.__b13;
	}

	public void setB13( Long value ) {
		this.__b13 = value;
	}

	public Long getB14() {
		return this.__b14;
	}

	public void setB14( Long value ) {
		this.__b14 = value;
	}

	public Long getB15() {
		return this.__b15;
	}

	public void setB15( Long value ) {
		this.__b15 = value;
	}

	public Long getB16() {
		return this.__b16;
	}

	public void setB16( Long value ) {
		this.__b16 = value;
	}

	public Long getB17() {
		return this.__b17;
	}

	public void setB17( Long value ) {
		this.__b17 = value;
	}

	public Long getB18() {
		return this.__b18;
	}

	public void setB18( Long value ) {
		this.__b18 = value;
	}

	public Long getB19() {
		return this.__b19;
	}

	public void setB19( Long value ) {
		this.__b19 = value;
	}

	public Long getB20() {
		return this.__b20;
	}

	public void setB20( Long value ) {
		this.__b20 = value;
	}

	public Long getC1() {
		return this.__c1;
	}

	public void setC1( Long value ) {
		this.__c1 = value;
	}

	public Long getC2() {
		return this.__c2;
	}

	public void setC2( Long value ) {
		this.__c2 = value;
	}

	public Long getC3() {
		return this.__c3;
	}

	public void setC3( Long value ) {
		this.__c3 = value;
	}

	public Long getC4() {
		return this.__c4;
	}

	public void setC4( Long value ) {
		this.__c4 = value;
	}

	public Long getC5() {
		return this.__c5;
	}

	public void setC5( Long value ) {
		this.__c5 = value;
	}

	public Long getC6() {
		return this.__c6;
	}

	public void setC6( Long value ) {
		this.__c6 = value;
	}

	public Long getC7() {
		return this.__c7;
	}

	public void setC7( Long value ) {
		this.__c7 = value;
	}

	public Long getC8() {
		return this.__c8;
	}

	public void setC8( Long value ) {
		this.__c8 = value;
	}

	public Long getC9() {
		return this.__c9;
	}

	public void setC9( Long value ) {
		this.__c9 = value;
	}

	public Long getC10() {
		return this.__c10;
	}

	public void setC10( Long value ) {
		this.__c10 = value;
	}

	public Long getC11() {
		return this.__c11;
	}

	public void setC11( Long value ) {
		this.__c11 = value;
	}

	public Long getC12() {
		return this.__c12;
	}

	public void setC12( Long value ) {
		this.__c12 = value;
	}

	public Long getC13() {
		return this.__c13;
	}

	public void setC13( Long value ) {
		this.__c13 = value;
	}

	public Long getC14() {
		return this.__c14;
	}

	public void setC14( Long value ) {
		this.__c14 = value;
	}

	public Long getC15() {
		return this.__c15;
	}

	public void setC15( Long value ) {
		this.__c15 = value;
	}

	public Long getC16() {
		return this.__c16;
	}

	public void setC16( Long value ) {
		this.__c16 = value;
	}

	public Long getC17() {
		return this.__c17;
	}

	public void setC17( Long value ) {
		this.__c17 = value;
	}

	public Long getC18() {
		return this.__c18;
	}

	public void setC18( Long value ) {
		this.__c18 = value;
	}

	public Long getC19() {
		return this.__c19;
	}

	public void setC19( Long value ) {
		this.__c19 = value;
	}

	public Long getC20() {
		return this.__c20;
	}

	public void setC20( Long value ) {
		this.__c20 = value;
	}

	public Long getOtherNum() {
		return this.__other_num;
	}

	public void setOtherNum( Long value ) {
		this.__other_num = value;
	}

	public Long getTotalNum() {
		return this.__total_num;
	}

	public void setTotalNum( Long value ) {
		this.__total_num = value;
	}

	public void cloneCopy(BaseReportOnEmployeeGradeTotal __bean){
		__bean.setPlateId(getPlateId());
		__bean.setYear(getYear());
		__bean.setA1(getA1());
		__bean.setA2(getA2());
		__bean.setA3(getA3());
		__bean.setA4(getA4());
		__bean.setA5(getA5());
		__bean.setA6(getA6());
		__bean.setA7(getA7());
		__bean.setA8(getA8());
		__bean.setA9(getA9());
		__bean.setA10(getA10());
		__bean.setA11(getA11());
		__bean.setA12(getA12());
		__bean.setA13(getA13());
		__bean.setA14(getA14());
		__bean.setA15(getA15());
		__bean.setA16(getA16());
		__bean.setA17(getA17());
		__bean.setA18(getA18());
		__bean.setA19(getA19());
		__bean.setA20(getA20());
		__bean.setB1(getB1());
		__bean.setB2(getB2());
		__bean.setB3(getB3());
		__bean.setB4(getB4());
		__bean.setB5(getB5());
		__bean.setB6(getB6());
		__bean.setB7(getB7());
		__bean.setB8(getB8());
		__bean.setB9(getB9());
		__bean.setB10(getB10());
		__bean.setB11(getB11());
		__bean.setB12(getB12());
		__bean.setB13(getB13());
		__bean.setB14(getB14());
		__bean.setB15(getB15());
		__bean.setB16(getB16());
		__bean.setB17(getB17());
		__bean.setB18(getB18());
		__bean.setB19(getB19());
		__bean.setB20(getB20());
		__bean.setC1(getC1());
		__bean.setC2(getC2());
		__bean.setC3(getC3());
		__bean.setC4(getC4());
		__bean.setC5(getC5());
		__bean.setC6(getC6());
		__bean.setC7(getC7());
		__bean.setC8(getC8());
		__bean.setC9(getC9());
		__bean.setC10(getC10());
		__bean.setC11(getC11());
		__bean.setC12(getC12());
		__bean.setC13(getC13());
		__bean.setC14(getC14());
		__bean.setC15(getC15());
		__bean.setC16(getC16());
		__bean.setC17(getC17());
		__bean.setC18(getC18());
		__bean.setC19(getC19());
		__bean.setC20(getC20());
		__bean.setOtherNum(getOtherNum());
		__bean.setTotalNum(getTotalNum());
	}

	public String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPlateId() == null ? "" : getPlateId());
		sb.append(",");
		sb.append(getYear() == null ? "" : getYear());
		sb.append(",");
		sb.append(getA1() == null ? "" : getA1());
		sb.append(",");
		sb.append(getA2() == null ? "" : getA2());
		sb.append(",");
		sb.append(getA3() == null ? "" : getA3());
		sb.append(",");
		sb.append(getA4() == null ? "" : getA4());
		sb.append(",");
		sb.append(getA5() == null ? "" : getA5());
		sb.append(",");
		sb.append(getA6() == null ? "" : getA6());
		sb.append(",");
		sb.append(getA7() == null ? "" : getA7());
		sb.append(",");
		sb.append(getA8() == null ? "" : getA8());
		sb.append(",");
		sb.append(getA9() == null ? "" : getA9());
		sb.append(",");
		sb.append(getA10() == null ? "" : getA10());
		sb.append(",");
		sb.append(getA11() == null ? "" : getA11());
		sb.append(",");
		sb.append(getA12() == null ? "" : getA12());
		sb.append(",");
		sb.append(getA13() == null ? "" : getA13());
		sb.append(",");
		sb.append(getA14() == null ? "" : getA14());
		sb.append(",");
		sb.append(getA15() == null ? "" : getA15());
		sb.append(",");
		sb.append(getA16() == null ? "" : getA16());
		sb.append(",");
		sb.append(getA17() == null ? "" : getA17());
		sb.append(",");
		sb.append(getA18() == null ? "" : getA18());
		sb.append(",");
		sb.append(getA19() == null ? "" : getA19());
		sb.append(",");
		sb.append(getA20() == null ? "" : getA20());
		sb.append(",");
		sb.append(getB1() == null ? "" : getB1());
		sb.append(",");
		sb.append(getB2() == null ? "" : getB2());
		sb.append(",");
		sb.append(getB3() == null ? "" : getB3());
		sb.append(",");
		sb.append(getB4() == null ? "" : getB4());
		sb.append(",");
		sb.append(getB5() == null ? "" : getB5());
		sb.append(",");
		sb.append(getB6() == null ? "" : getB6());
		sb.append(",");
		sb.append(getB7() == null ? "" : getB7());
		sb.append(",");
		sb.append(getB8() == null ? "" : getB8());
		sb.append(",");
		sb.append(getB9() == null ? "" : getB9());
		sb.append(",");
		sb.append(getB10() == null ? "" : getB10());
		sb.append(",");
		sb.append(getB11() == null ? "" : getB11());
		sb.append(",");
		sb.append(getB12() == null ? "" : getB12());
		sb.append(",");
		sb.append(getB13() == null ? "" : getB13());
		sb.append(",");
		sb.append(getB14() == null ? "" : getB14());
		sb.append(",");
		sb.append(getB15() == null ? "" : getB15());
		sb.append(",");
		sb.append(getB16() == null ? "" : getB16());
		sb.append(",");
		sb.append(getB17() == null ? "" : getB17());
		sb.append(",");
		sb.append(getB18() == null ? "" : getB18());
		sb.append(",");
		sb.append(getB19() == null ? "" : getB19());
		sb.append(",");
		sb.append(getB20() == null ? "" : getB20());
		sb.append(",");
		sb.append(getC1() == null ? "" : getC1());
		sb.append(",");
		sb.append(getC2() == null ? "" : getC2());
		sb.append(",");
		sb.append(getC3() == null ? "" : getC3());
		sb.append(",");
		sb.append(getC4() == null ? "" : getC4());
		sb.append(",");
		sb.append(getC5() == null ? "" : getC5());
		sb.append(",");
		sb.append(getC6() == null ? "" : getC6());
		sb.append(",");
		sb.append(getC7() == null ? "" : getC7());
		sb.append(",");
		sb.append(getC8() == null ? "" : getC8());
		sb.append(",");
		sb.append(getC9() == null ? "" : getC9());
		sb.append(",");
		sb.append(getC10() == null ? "" : getC10());
		sb.append(",");
		sb.append(getC11() == null ? "" : getC11());
		sb.append(",");
		sb.append(getC12() == null ? "" : getC12());
		sb.append(",");
		sb.append(getC13() == null ? "" : getC13());
		sb.append(",");
		sb.append(getC14() == null ? "" : getC14());
		sb.append(",");
		sb.append(getC15() == null ? "" : getC15());
		sb.append(",");
		sb.append(getC16() == null ? "" : getC16());
		sb.append(",");
		sb.append(getC17() == null ? "" : getC17());
		sb.append(",");
		sb.append(getC18() == null ? "" : getC18());
		sb.append(",");
		sb.append(getC19() == null ? "" : getC19());
		sb.append(",");
		sb.append(getC20() == null ? "" : getC20());
		sb.append(",");
		sb.append(getOtherNum() == null ? "" : getOtherNum());
		sb.append(",");
		sb.append(getTotalNum() == null ? "" : getTotalNum());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOnEmployeeGradeTotal o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__a1);
		hash = 97 * hash + Objects.hashCode(this.__a2);
		hash = 97 * hash + Objects.hashCode(this.__a3);
		hash = 97 * hash + Objects.hashCode(this.__a4);
		hash = 97 * hash + Objects.hashCode(this.__a5);
		hash = 97 * hash + Objects.hashCode(this.__a6);
		hash = 97 * hash + Objects.hashCode(this.__a7);
		hash = 97 * hash + Objects.hashCode(this.__a8);
		hash = 97 * hash + Objects.hashCode(this.__a9);
		hash = 97 * hash + Objects.hashCode(this.__a10);
		hash = 97 * hash + Objects.hashCode(this.__a11);
		hash = 97 * hash + Objects.hashCode(this.__a12);
		hash = 97 * hash + Objects.hashCode(this.__a13);
		hash = 97 * hash + Objects.hashCode(this.__a14);
		hash = 97 * hash + Objects.hashCode(this.__a15);
		hash = 97 * hash + Objects.hashCode(this.__a16);
		hash = 97 * hash + Objects.hashCode(this.__a17);
		hash = 97 * hash + Objects.hashCode(this.__a18);
		hash = 97 * hash + Objects.hashCode(this.__a19);
		hash = 97 * hash + Objects.hashCode(this.__a20);
		hash = 97 * hash + Objects.hashCode(this.__b1);
		hash = 97 * hash + Objects.hashCode(this.__b2);
		hash = 97 * hash + Objects.hashCode(this.__b3);
		hash = 97 * hash + Objects.hashCode(this.__b4);
		hash = 97 * hash + Objects.hashCode(this.__b5);
		hash = 97 * hash + Objects.hashCode(this.__b6);
		hash = 97 * hash + Objects.hashCode(this.__b7);
		hash = 97 * hash + Objects.hashCode(this.__b8);
		hash = 97 * hash + Objects.hashCode(this.__b9);
		hash = 97 * hash + Objects.hashCode(this.__b10);
		hash = 97 * hash + Objects.hashCode(this.__b11);
		hash = 97 * hash + Objects.hashCode(this.__b12);
		hash = 97 * hash + Objects.hashCode(this.__b13);
		hash = 97 * hash + Objects.hashCode(this.__b14);
		hash = 97 * hash + Objects.hashCode(this.__b15);
		hash = 97 * hash + Objects.hashCode(this.__b16);
		hash = 97 * hash + Objects.hashCode(this.__b17);
		hash = 97 * hash + Objects.hashCode(this.__b18);
		hash = 97 * hash + Objects.hashCode(this.__b19);
		hash = 97 * hash + Objects.hashCode(this.__b20);
		hash = 97 * hash + Objects.hashCode(this.__c1);
		hash = 97 * hash + Objects.hashCode(this.__c2);
		hash = 97 * hash + Objects.hashCode(this.__c3);
		hash = 97 * hash + Objects.hashCode(this.__c4);
		hash = 97 * hash + Objects.hashCode(this.__c5);
		hash = 97 * hash + Objects.hashCode(this.__c6);
		hash = 97 * hash + Objects.hashCode(this.__c7);
		hash = 97 * hash + Objects.hashCode(this.__c8);
		hash = 97 * hash + Objects.hashCode(this.__c9);
		hash = 97 * hash + Objects.hashCode(this.__c10);
		hash = 97 * hash + Objects.hashCode(this.__c11);
		hash = 97 * hash + Objects.hashCode(this.__c12);
		hash = 97 * hash + Objects.hashCode(this.__c13);
		hash = 97 * hash + Objects.hashCode(this.__c14);
		hash = 97 * hash + Objects.hashCode(this.__c15);
		hash = 97 * hash + Objects.hashCode(this.__c16);
		hash = 97 * hash + Objects.hashCode(this.__c17);
		hash = 97 * hash + Objects.hashCode(this.__c18);
		hash = 97 * hash + Objects.hashCode(this.__c19);
		hash = 97 * hash + Objects.hashCode(this.__c20);
		hash = 97 * hash + Objects.hashCode(this.__other_num);
		hash = 97 * hash + Objects.hashCode(this.__total_num);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOnEmployeeGradeTotal o = (BaseReportOnEmployeeGradeTotal)obj;
		if(!Objects.equals(this.__plate_id, o.getPlateId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__a1, o.getA1())) return false;
		if(!Objects.equals(this.__a2, o.getA2())) return false;
		if(!Objects.equals(this.__a3, o.getA3())) return false;
		if(!Objects.equals(this.__a4, o.getA4())) return false;
		if(!Objects.equals(this.__a5, o.getA5())) return false;
		if(!Objects.equals(this.__a6, o.getA6())) return false;
		if(!Objects.equals(this.__a7, o.getA7())) return false;
		if(!Objects.equals(this.__a8, o.getA8())) return false;
		if(!Objects.equals(this.__a9, o.getA9())) return false;
		if(!Objects.equals(this.__a10, o.getA10())) return false;
		if(!Objects.equals(this.__a11, o.getA11())) return false;
		if(!Objects.equals(this.__a12, o.getA12())) return false;
		if(!Objects.equals(this.__a13, o.getA13())) return false;
		if(!Objects.equals(this.__a14, o.getA14())) return false;
		if(!Objects.equals(this.__a15, o.getA15())) return false;
		if(!Objects.equals(this.__a16, o.getA16())) return false;
		if(!Objects.equals(this.__a17, o.getA17())) return false;
		if(!Objects.equals(this.__a18, o.getA18())) return false;
		if(!Objects.equals(this.__a19, o.getA19())) return false;
		if(!Objects.equals(this.__a20, o.getA20())) return false;
		if(!Objects.equals(this.__b1, o.getB1())) return false;
		if(!Objects.equals(this.__b2, o.getB2())) return false;
		if(!Objects.equals(this.__b3, o.getB3())) return false;
		if(!Objects.equals(this.__b4, o.getB4())) return false;
		if(!Objects.equals(this.__b5, o.getB5())) return false;
		if(!Objects.equals(this.__b6, o.getB6())) return false;
		if(!Objects.equals(this.__b7, o.getB7())) return false;
		if(!Objects.equals(this.__b8, o.getB8())) return false;
		if(!Objects.equals(this.__b9, o.getB9())) return false;
		if(!Objects.equals(this.__b10, o.getB10())) return false;
		if(!Objects.equals(this.__b11, o.getB11())) return false;
		if(!Objects.equals(this.__b12, o.getB12())) return false;
		if(!Objects.equals(this.__b13, o.getB13())) return false;
		if(!Objects.equals(this.__b14, o.getB14())) return false;
		if(!Objects.equals(this.__b15, o.getB15())) return false;
		if(!Objects.equals(this.__b16, o.getB16())) return false;
		if(!Objects.equals(this.__b17, o.getB17())) return false;
		if(!Objects.equals(this.__b18, o.getB18())) return false;
		if(!Objects.equals(this.__b19, o.getB19())) return false;
		if(!Objects.equals(this.__b20, o.getB20())) return false;
		if(!Objects.equals(this.__c1, o.getC1())) return false;
		if(!Objects.equals(this.__c2, o.getC2())) return false;
		if(!Objects.equals(this.__c3, o.getC3())) return false;
		if(!Objects.equals(this.__c4, o.getC4())) return false;
		if(!Objects.equals(this.__c5, o.getC5())) return false;
		if(!Objects.equals(this.__c6, o.getC6())) return false;
		if(!Objects.equals(this.__c7, o.getC7())) return false;
		if(!Objects.equals(this.__c8, o.getC8())) return false;
		if(!Objects.equals(this.__c9, o.getC9())) return false;
		if(!Objects.equals(this.__c10, o.getC10())) return false;
		if(!Objects.equals(this.__c11, o.getC11())) return false;
		if(!Objects.equals(this.__c12, o.getC12())) return false;
		if(!Objects.equals(this.__c13, o.getC13())) return false;
		if(!Objects.equals(this.__c14, o.getC14())) return false;
		if(!Objects.equals(this.__c15, o.getC15())) return false;
		if(!Objects.equals(this.__c16, o.getC16())) return false;
		if(!Objects.equals(this.__c17, o.getC17())) return false;
		if(!Objects.equals(this.__c18, o.getC18())) return false;
		if(!Objects.equals(this.__c19, o.getC19())) return false;
		if(!Objects.equals(this.__c20, o.getC20())) return false;
		if(!Objects.equals(this.__other_num, o.getOtherNum())) return false;
		if(!Objects.equals(this.__total_num, o.getTotalNum())) return false;
		return true;
	}

	@Override
	public String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getPlateId() != null) sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getA1() != null) sb.append(__wrapNumber(count++, "a1", getA1()));
		if(getA2() != null) sb.append(__wrapNumber(count++, "a2", getA2()));
		if(getA3() != null) sb.append(__wrapNumber(count++, "a3", getA3()));
		if(getA4() != null) sb.append(__wrapNumber(count++, "a4", getA4()));
		if(getA5() != null) sb.append(__wrapNumber(count++, "a5", getA5()));
		if(getA6() != null) sb.append(__wrapNumber(count++, "a6", getA6()));
		if(getA7() != null) sb.append(__wrapNumber(count++, "a7", getA7()));
		if(getA8() != null) sb.append(__wrapNumber(count++, "a8", getA8()));
		if(getA9() != null) sb.append(__wrapNumber(count++, "a9", getA9()));
		if(getA10() != null) sb.append(__wrapNumber(count++, "a10", getA10()));
		if(getA11() != null) sb.append(__wrapNumber(count++, "a11", getA11()));
		if(getA12() != null) sb.append(__wrapNumber(count++, "a12", getA12()));
		if(getA13() != null) sb.append(__wrapNumber(count++, "a13", getA13()));
		if(getA14() != null) sb.append(__wrapNumber(count++, "a14", getA14()));
		if(getA15() != null) sb.append(__wrapNumber(count++, "a15", getA15()));
		if(getA16() != null) sb.append(__wrapNumber(count++, "a16", getA16()));
		if(getA17() != null) sb.append(__wrapNumber(count++, "a17", getA17()));
		if(getA18() != null) sb.append(__wrapNumber(count++, "a18", getA18()));
		if(getA19() != null) sb.append(__wrapNumber(count++, "a19", getA19()));
		if(getA20() != null) sb.append(__wrapNumber(count++, "a20", getA20()));
		if(getB1() != null) sb.append(__wrapNumber(count++, "b1", getB1()));
		if(getB2() != null) sb.append(__wrapNumber(count++, "b2", getB2()));
		if(getB3() != null) sb.append(__wrapNumber(count++, "b3", getB3()));
		if(getB4() != null) sb.append(__wrapNumber(count++, "b4", getB4()));
		if(getB5() != null) sb.append(__wrapNumber(count++, "b5", getB5()));
		if(getB6() != null) sb.append(__wrapNumber(count++, "b6", getB6()));
		if(getB7() != null) sb.append(__wrapNumber(count++, "b7", getB7()));
		if(getB8() != null) sb.append(__wrapNumber(count++, "b8", getB8()));
		if(getB9() != null) sb.append(__wrapNumber(count++, "b9", getB9()));
		if(getB10() != null) sb.append(__wrapNumber(count++, "b10", getB10()));
		if(getB11() != null) sb.append(__wrapNumber(count++, "b11", getB11()));
		if(getB12() != null) sb.append(__wrapNumber(count++, "b12", getB12()));
		if(getB13() != null) sb.append(__wrapNumber(count++, "b13", getB13()));
		if(getB14() != null) sb.append(__wrapNumber(count++, "b14", getB14()));
		if(getB15() != null) sb.append(__wrapNumber(count++, "b15", getB15()));
		if(getB16() != null) sb.append(__wrapNumber(count++, "b16", getB16()));
		if(getB17() != null) sb.append(__wrapNumber(count++, "b17", getB17()));
		if(getB18() != null) sb.append(__wrapNumber(count++, "b18", getB18()));
		if(getB19() != null) sb.append(__wrapNumber(count++, "b19", getB19()));
		if(getB20() != null) sb.append(__wrapNumber(count++, "b20", getB20()));
		if(getC1() != null) sb.append(__wrapNumber(count++, "c1", getC1()));
		if(getC2() != null) sb.append(__wrapNumber(count++, "c2", getC2()));
		if(getC3() != null) sb.append(__wrapNumber(count++, "c3", getC3()));
		if(getC4() != null) sb.append(__wrapNumber(count++, "c4", getC4()));
		if(getC5() != null) sb.append(__wrapNumber(count++, "c5", getC5()));
		if(getC6() != null) sb.append(__wrapNumber(count++, "c6", getC6()));
		if(getC7() != null) sb.append(__wrapNumber(count++, "c7", getC7()));
		if(getC8() != null) sb.append(__wrapNumber(count++, "c8", getC8()));
		if(getC9() != null) sb.append(__wrapNumber(count++, "c9", getC9()));
		if(getC10() != null) sb.append(__wrapNumber(count++, "c10", getC10()));
		if(getC11() != null) sb.append(__wrapNumber(count++, "c11", getC11()));
		if(getC12() != null) sb.append(__wrapNumber(count++, "c12", getC12()));
		if(getC13() != null) sb.append(__wrapNumber(count++, "c13", getC13()));
		if(getC14() != null) sb.append(__wrapNumber(count++, "c14", getC14()));
		if(getC15() != null) sb.append(__wrapNumber(count++, "c15", getC15()));
		if(getC16() != null) sb.append(__wrapNumber(count++, "c16", getC16()));
		if(getC17() != null) sb.append(__wrapNumber(count++, "c17", getC17()));
		if(getC18() != null) sb.append(__wrapNumber(count++, "c18", getC18()));
		if(getC19() != null) sb.append(__wrapNumber(count++, "c19", getC19()));
		if(getC20() != null) sb.append(__wrapNumber(count++, "c20", getC20()));
		if(getOtherNum() != null) sb.append(__wrapNumber(count++, "otherNum", getOtherNum()));
		if(getTotalNum() != null) sb.append(__wrapNumber(count++, "totalNum", getTotalNum()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getPlateId() != null) res.put("plateId", getPlateId());
		if(getYear() != null) res.put("year", getYear());
		if(getA1() != null) res.put("a1", getA1());
		if(getA2() != null) res.put("a2", getA2());
		if(getA3() != null) res.put("a3", getA3());
		if(getA4() != null) res.put("a4", getA4());
		if(getA5() != null) res.put("a5", getA5());
		if(getA6() != null) res.put("a6", getA6());
		if(getA7() != null) res.put("a7", getA7());
		if(getA8() != null) res.put("a8", getA8());
		if(getA9() != null) res.put("a9", getA9());
		if(getA10() != null) res.put("a10", getA10());
		if(getA11() != null) res.put("a11", getA11());
		if(getA12() != null) res.put("a12", getA12());
		if(getA13() != null) res.put("a13", getA13());
		if(getA14() != null) res.put("a14", getA14());
		if(getA15() != null) res.put("a15", getA15());
		if(getA16() != null) res.put("a16", getA16());
		if(getA17() != null) res.put("a17", getA17());
		if(getA18() != null) res.put("a18", getA18());
		if(getA19() != null) res.put("a19", getA19());
		if(getA20() != null) res.put("a20", getA20());
		if(getB1() != null) res.put("b1", getB1());
		if(getB2() != null) res.put("b2", getB2());
		if(getB3() != null) res.put("b3", getB3());
		if(getB4() != null) res.put("b4", getB4());
		if(getB5() != null) res.put("b5", getB5());
		if(getB6() != null) res.put("b6", getB6());
		if(getB7() != null) res.put("b7", getB7());
		if(getB8() != null) res.put("b8", getB8());
		if(getB9() != null) res.put("b9", getB9());
		if(getB10() != null) res.put("b10", getB10());
		if(getB11() != null) res.put("b11", getB11());
		if(getB12() != null) res.put("b12", getB12());
		if(getB13() != null) res.put("b13", getB13());
		if(getB14() != null) res.put("b14", getB14());
		if(getB15() != null) res.put("b15", getB15());
		if(getB16() != null) res.put("b16", getB16());
		if(getB17() != null) res.put("b17", getB17());
		if(getB18() != null) res.put("b18", getB18());
		if(getB19() != null) res.put("b19", getB19());
		if(getB20() != null) res.put("b20", getB20());
		if(getC1() != null) res.put("c1", getC1());
		if(getC2() != null) res.put("c2", getC2());
		if(getC3() != null) res.put("c3", getC3());
		if(getC4() != null) res.put("c4", getC4());
		if(getC5() != null) res.put("c5", getC5());
		if(getC6() != null) res.put("c6", getC6());
		if(getC7() != null) res.put("c7", getC7());
		if(getC8() != null) res.put("c8", getC8());
		if(getC9() != null) res.put("c9", getC9());
		if(getC10() != null) res.put("c10", getC10());
		if(getC11() != null) res.put("c11", getC11());
		if(getC12() != null) res.put("c12", getC12());
		if(getC13() != null) res.put("c13", getC13());
		if(getC14() != null) res.put("c14", getC14());
		if(getC15() != null) res.put("c15", getC15());
		if(getC16() != null) res.put("c16", getC16());
		if(getC17() != null) res.put("c17", getC17());
		if(getC18() != null) res.put("c18", getC18());
		if(getC19() != null) res.put("c19", getC19());
		if(getC20() != null) res.put("c20", getC20());
		if(getOtherNum() != null) res.put("otherNum", getOtherNum());
		if(getTotalNum() != null) res.put("totalNum", getTotalNum());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("plateId")) != null) setPlateId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("a1")) != null) setA1(__getLong(val)); 
		if((val = values.get("a2")) != null) setA2(__getLong(val)); 
		if((val = values.get("a3")) != null) setA3(__getLong(val)); 
		if((val = values.get("a4")) != null) setA4(__getLong(val)); 
		if((val = values.get("a5")) != null) setA5(__getLong(val)); 
		if((val = values.get("a6")) != null) setA6(__getLong(val)); 
		if((val = values.get("a7")) != null) setA7(__getLong(val)); 
		if((val = values.get("a8")) != null) setA8(__getLong(val)); 
		if((val = values.get("a9")) != null) setA9(__getLong(val)); 
		if((val = values.get("a10")) != null) setA10(__getLong(val)); 
		if((val = values.get("a11")) != null) setA11(__getLong(val)); 
		if((val = values.get("a12")) != null) setA12(__getLong(val)); 
		if((val = values.get("a13")) != null) setA13(__getLong(val)); 
		if((val = values.get("a14")) != null) setA14(__getLong(val)); 
		if((val = values.get("a15")) != null) setA15(__getLong(val)); 
		if((val = values.get("a16")) != null) setA16(__getLong(val)); 
		if((val = values.get("a17")) != null) setA17(__getLong(val)); 
		if((val = values.get("a18")) != null) setA18(__getLong(val)); 
		if((val = values.get("a19")) != null) setA19(__getLong(val)); 
		if((val = values.get("a20")) != null) setA20(__getLong(val)); 
		if((val = values.get("b1")) != null) setB1(__getLong(val)); 
		if((val = values.get("b2")) != null) setB2(__getLong(val)); 
		if((val = values.get("b3")) != null) setB3(__getLong(val)); 
		if((val = values.get("b4")) != null) setB4(__getLong(val)); 
		if((val = values.get("b5")) != null) setB5(__getLong(val)); 
		if((val = values.get("b6")) != null) setB6(__getLong(val)); 
		if((val = values.get("b7")) != null) setB7(__getLong(val)); 
		if((val = values.get("b8")) != null) setB8(__getLong(val)); 
		if((val = values.get("b9")) != null) setB9(__getLong(val)); 
		if((val = values.get("b10")) != null) setB10(__getLong(val)); 
		if((val = values.get("b11")) != null) setB11(__getLong(val)); 
		if((val = values.get("b12")) != null) setB12(__getLong(val)); 
		if((val = values.get("b13")) != null) setB13(__getLong(val)); 
		if((val = values.get("b14")) != null) setB14(__getLong(val)); 
		if((val = values.get("b15")) != null) setB15(__getLong(val)); 
		if((val = values.get("b16")) != null) setB16(__getLong(val)); 
		if((val = values.get("b17")) != null) setB17(__getLong(val)); 
		if((val = values.get("b18")) != null) setB18(__getLong(val)); 
		if((val = values.get("b19")) != null) setB19(__getLong(val)); 
		if((val = values.get("b20")) != null) setB20(__getLong(val)); 
		if((val = values.get("c1")) != null) setC1(__getLong(val)); 
		if((val = values.get("c2")) != null) setC2(__getLong(val)); 
		if((val = values.get("c3")) != null) setC3(__getLong(val)); 
		if((val = values.get("c4")) != null) setC4(__getLong(val)); 
		if((val = values.get("c5")) != null) setC5(__getLong(val)); 
		if((val = values.get("c6")) != null) setC6(__getLong(val)); 
		if((val = values.get("c7")) != null) setC7(__getLong(val)); 
		if((val = values.get("c8")) != null) setC8(__getLong(val)); 
		if((val = values.get("c9")) != null) setC9(__getLong(val)); 
		if((val = values.get("c10")) != null) setC10(__getLong(val)); 
		if((val = values.get("c11")) != null) setC11(__getLong(val)); 
		if((val = values.get("c12")) != null) setC12(__getLong(val)); 
		if((val = values.get("c13")) != null) setC13(__getLong(val)); 
		if((val = values.get("c14")) != null) setC14(__getLong(val)); 
		if((val = values.get("c15")) != null) setC15(__getLong(val)); 
		if((val = values.get("c16")) != null) setC16(__getLong(val)); 
		if((val = values.get("c17")) != null) setC17(__getLong(val)); 
		if((val = values.get("c18")) != null) setC18(__getLong(val)); 
		if((val = values.get("c19")) != null) setC19(__getLong(val)); 
		if((val = values.get("c20")) != null) setC20(__getLong(val)); 
		if((val = values.get("otherNum")) != null) setOtherNum(__getLong(val)); 
		if((val = values.get("totalNum")) != null) setTotalNum(__getLong(val)); 
	}

	protected Integer  __plate_id ;
	protected Integer  __year ;
	protected Long  __a1 ;
	protected Long  __a2 ;
	protected Long  __a3 ;
	protected Long  __a4 ;
	protected Long  __a5 ;
	protected Long  __a6 ;
	protected Long  __a7 ;
	protected Long  __a8 ;
	protected Long  __a9 ;
	protected Long  __a10 ;
	protected Long  __a11 ;
	protected Long  __a12 ;
	protected Long  __a13 ;
	protected Long  __a14 ;
	protected Long  __a15 ;
	protected Long  __a16 ;
	protected Long  __a17 ;
	protected Long  __a18 ;
	protected Long  __a19 ;
	protected Long  __a20 ;
	protected Long  __b1 ;
	protected Long  __b2 ;
	protected Long  __b3 ;
	protected Long  __b4 ;
	protected Long  __b5 ;
	protected Long  __b6 ;
	protected Long  __b7 ;
	protected Long  __b8 ;
	protected Long  __b9 ;
	protected Long  __b10 ;
	protected Long  __b11 ;
	protected Long  __b12 ;
	protected Long  __b13 ;
	protected Long  __b14 ;
	protected Long  __b15 ;
	protected Long  __b16 ;
	protected Long  __b17 ;
	protected Long  __b18 ;
	protected Long  __b19 ;
	protected Long  __b20 ;
	protected Long  __c1 ;
	protected Long  __c2 ;
	protected Long  __c3 ;
	protected Long  __c4 ;
	protected Long  __c5 ;
	protected Long  __c6 ;
	protected Long  __c7 ;
	protected Long  __c8 ;
	protected Long  __c9 ;
	protected Long  __c10 ;
	protected Long  __c11 ;
	protected Long  __c12 ;
	protected Long  __c13 ;
	protected Long  __c14 ;
	protected Long  __c15 ;
	protected Long  __c16 ;
	protected Long  __c17 ;
	protected Long  __c18 ;
	protected Long  __c19 ;
	protected Long  __c20 ;
	protected Long  __other_num ;
	protected Long  __total_num ;
}
