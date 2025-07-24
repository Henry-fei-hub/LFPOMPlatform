package pomplatform.report.bean;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import delicacy.common.GenericBase;
import delicacy.common.BaseFactory;

public class BaseReportOnEmployeeBenefitTotalByDepartment extends GenericBase implements BaseFactory<BaseReportOnEmployeeBenefitTotalByDepartment>, Comparable<BaseReportOnEmployeeBenefitTotalByDepartment> 
{


	public static BaseReportOnEmployeeBenefitTotalByDepartment newInstance(){
		return new BaseReportOnEmployeeBenefitTotalByDepartment();
	}

	@Override
	public BaseReportOnEmployeeBenefitTotalByDepartment make(){
		BaseReportOnEmployeeBenefitTotalByDepartment b = new BaseReportOnEmployeeBenefitTotalByDepartment();
		return b;
	}

	public final static java.lang.String CS_DEPARTMENT_ID = "department_id" ;
	public final static java.lang.String CS_YEAR = "year" ;
	public final static java.lang.String CS_ONE_NUM1 = "one_num1" ;
	public final static java.lang.String CS_TWO_NUM1 = "two_num1" ;
	public final static java.lang.String CS_TOTAL_NUM1 = "total_num1" ;
	public final static java.lang.String CS_ONE_NUM2 = "one_num2" ;
	public final static java.lang.String CS_TWO_NUM2 = "two_num2" ;
	public final static java.lang.String CS_TOTAL_NUM2 = "total_num2" ;
	public final static java.lang.String CS_ONE_NUM3 = "one_num3" ;
	public final static java.lang.String CS_TWO_NUM3 = "two_num3" ;
	public final static java.lang.String CS_TOTAL_NUM3 = "total_num3" ;
	public final static java.lang.String CS_ONE_NUM4 = "one_num4" ;
	public final static java.lang.String CS_TWO_NUM4 = "two_num4" ;
	public final static java.lang.String CS_TOTAL_NUM4 = "total_num4" ;
	public final static java.lang.String CS_ONE_NUM5 = "one_num5" ;
	public final static java.lang.String CS_TWO_NUM5 = "two_num5" ;
	public final static java.lang.String CS_TOTAL_NUM5 = "total_num5" ;
	public final static java.lang.String CS_ONE_NUM6 = "one_num6" ;
	public final static java.lang.String CS_TWO_NUM6 = "two_num6" ;
	public final static java.lang.String CS_TOTAL_NUM6 = "total_num6" ;
	public final static java.lang.String CS_ONE_NUM7 = "one_num7" ;
	public final static java.lang.String CS_TWO_NUM7 = "two_num7" ;
	public final static java.lang.String CS_TOTAL_NUM7 = "total_num7" ;
	public final static java.lang.String CS_ONE_NUM8 = "one_num8" ;
	public final static java.lang.String CS_TWO_NUM8 = "two_num8" ;
	public final static java.lang.String CS_TOTAL_NUM8 = "total_num8" ;
	public final static java.lang.String CS_ONE_NUM9 = "one_num9" ;
	public final static java.lang.String CS_TWO_NUM9 = "two_num9" ;
	public final static java.lang.String CS_TOTAL_NUM9 = "total_num9" ;
	public final static java.lang.String CS_ONE_NUM10 = "one_num10" ;
	public final static java.lang.String CS_TWO_NUM10 = "two_num10" ;
	public final static java.lang.String CS_TOTAL_NUM10 = "total_num10" ;
	public final static java.lang.String CS_ONE_NUM11 = "one_num11" ;
	public final static java.lang.String CS_TWO_NUM11 = "two_num11" ;
	public final static java.lang.String CS_TOTAL_NUM11 = "total_num11" ;
	public final static java.lang.String CS_ONE_NUM12 = "one_num12" ;
	public final static java.lang.String CS_TWO_NUM12 = "two_num12" ;
	public final static java.lang.String CS_TOTAL_NUM12 = "total_num12" ;

	public final static java.lang.String ALL_CAPTIONS = "所属部门,年份,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,";

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

	public java.lang.Long getOneNum1() {
		return this.__one_num1;
	}

	public void setOneNum1( java.lang.Long value ) {
		this.__one_num1 = value;
	}

	public java.lang.Long getTwoNum1() {
		return this.__two_num1;
	}

	public void setTwoNum1( java.lang.Long value ) {
		this.__two_num1 = value;
	}

	public java.lang.Long getTotalNum1() {
		return this.__total_num1;
	}

	public void setTotalNum1( java.lang.Long value ) {
		this.__total_num1 = value;
	}

	public java.lang.Long getOneNum2() {
		return this.__one_num2;
	}

	public void setOneNum2( java.lang.Long value ) {
		this.__one_num2 = value;
	}

	public java.lang.Long getTwoNum2() {
		return this.__two_num2;
	}

	public void setTwoNum2( java.lang.Long value ) {
		this.__two_num2 = value;
	}

	public java.lang.Long getTotalNum2() {
		return this.__total_num2;
	}

	public void setTotalNum2( java.lang.Long value ) {
		this.__total_num2 = value;
	}

	public java.lang.Long getOneNum3() {
		return this.__one_num3;
	}

	public void setOneNum3( java.lang.Long value ) {
		this.__one_num3 = value;
	}

	public java.lang.Long getTwoNum3() {
		return this.__two_num3;
	}

	public void setTwoNum3( java.lang.Long value ) {
		this.__two_num3 = value;
	}

	public java.lang.Long getTotalNum3() {
		return this.__total_num3;
	}

	public void setTotalNum3( java.lang.Long value ) {
		this.__total_num3 = value;
	}

	public java.lang.Long getOneNum4() {
		return this.__one_num4;
	}

	public void setOneNum4( java.lang.Long value ) {
		this.__one_num4 = value;
	}

	public java.lang.Long getTwoNum4() {
		return this.__two_num4;
	}

	public void setTwoNum4( java.lang.Long value ) {
		this.__two_num4 = value;
	}

	public java.lang.Long getTotalNum4() {
		return this.__total_num4;
	}

	public void setTotalNum4( java.lang.Long value ) {
		this.__total_num4 = value;
	}

	public java.lang.Long getOneNum5() {
		return this.__one_num5;
	}

	public void setOneNum5( java.lang.Long value ) {
		this.__one_num5 = value;
	}

	public java.lang.Long getTwoNum5() {
		return this.__two_num5;
	}

	public void setTwoNum5( java.lang.Long value ) {
		this.__two_num5 = value;
	}

	public java.lang.Long getTotalNum5() {
		return this.__total_num5;
	}

	public void setTotalNum5( java.lang.Long value ) {
		this.__total_num5 = value;
	}

	public java.lang.Long getOneNum6() {
		return this.__one_num6;
	}

	public void setOneNum6( java.lang.Long value ) {
		this.__one_num6 = value;
	}

	public java.lang.Long getTwoNum6() {
		return this.__two_num6;
	}

	public void setTwoNum6( java.lang.Long value ) {
		this.__two_num6 = value;
	}

	public java.lang.Long getTotalNum6() {
		return this.__total_num6;
	}

	public void setTotalNum6( java.lang.Long value ) {
		this.__total_num6 = value;
	}

	public java.lang.Long getOneNum7() {
		return this.__one_num7;
	}

	public void setOneNum7( java.lang.Long value ) {
		this.__one_num7 = value;
	}

	public java.lang.Long getTwoNum7() {
		return this.__two_num7;
	}

	public void setTwoNum7( java.lang.Long value ) {
		this.__two_num7 = value;
	}

	public java.lang.Long getTotalNum7() {
		return this.__total_num7;
	}

	public void setTotalNum7( java.lang.Long value ) {
		this.__total_num7 = value;
	}

	public java.lang.Long getOneNum8() {
		return this.__one_num8;
	}

	public void setOneNum8( java.lang.Long value ) {
		this.__one_num8 = value;
	}

	public java.lang.Long getTwoNum8() {
		return this.__two_num8;
	}

	public void setTwoNum8( java.lang.Long value ) {
		this.__two_num8 = value;
	}

	public java.lang.Long getTotalNum8() {
		return this.__total_num8;
	}

	public void setTotalNum8( java.lang.Long value ) {
		this.__total_num8 = value;
	}

	public java.lang.Long getOneNum9() {
		return this.__one_num9;
	}

	public void setOneNum9( java.lang.Long value ) {
		this.__one_num9 = value;
	}

	public java.lang.Long getTwoNum9() {
		return this.__two_num9;
	}

	public void setTwoNum9( java.lang.Long value ) {
		this.__two_num9 = value;
	}

	public java.lang.Long getTotalNum9() {
		return this.__total_num9;
	}

	public void setTotalNum9( java.lang.Long value ) {
		this.__total_num9 = value;
	}

	public java.lang.Long getOneNum10() {
		return this.__one_num10;
	}

	public void setOneNum10( java.lang.Long value ) {
		this.__one_num10 = value;
	}

	public java.lang.Long getTwoNum10() {
		return this.__two_num10;
	}

	public void setTwoNum10( java.lang.Long value ) {
		this.__two_num10 = value;
	}

	public java.lang.Long getTotalNum10() {
		return this.__total_num10;
	}

	public void setTotalNum10( java.lang.Long value ) {
		this.__total_num10 = value;
	}

	public java.lang.Long getOneNum11() {
		return this.__one_num11;
	}

	public void setOneNum11( java.lang.Long value ) {
		this.__one_num11 = value;
	}

	public java.lang.Long getTwoNum11() {
		return this.__two_num11;
	}

	public void setTwoNum11( java.lang.Long value ) {
		this.__two_num11 = value;
	}

	public java.lang.Long getTotalNum11() {
		return this.__total_num11;
	}

	public void setTotalNum11( java.lang.Long value ) {
		this.__total_num11 = value;
	}

	public java.lang.Long getOneNum12() {
		return this.__one_num12;
	}

	public void setOneNum12( java.lang.Long value ) {
		this.__one_num12 = value;
	}

	public java.lang.Long getTwoNum12() {
		return this.__two_num12;
	}

	public void setTwoNum12( java.lang.Long value ) {
		this.__two_num12 = value;
	}

	public java.lang.Long getTotalNum12() {
		return this.__total_num12;
	}

	public void setTotalNum12( java.lang.Long value ) {
		this.__total_num12 = value;
	}

	public void cloneCopy(BaseReportOnEmployeeBenefitTotalByDepartment __bean){
		__bean.setDepartmentId(getDepartmentId());
		__bean.setYear(getYear());
		__bean.setOneNum1(getOneNum1());
		__bean.setTwoNum1(getTwoNum1());
		__bean.setTotalNum1(getTotalNum1());
		__bean.setOneNum2(getOneNum2());
		__bean.setTwoNum2(getTwoNum2());
		__bean.setTotalNum2(getTotalNum2());
		__bean.setOneNum3(getOneNum3());
		__bean.setTwoNum3(getTwoNum3());
		__bean.setTotalNum3(getTotalNum3());
		__bean.setOneNum4(getOneNum4());
		__bean.setTwoNum4(getTwoNum4());
		__bean.setTotalNum4(getTotalNum4());
		__bean.setOneNum5(getOneNum5());
		__bean.setTwoNum5(getTwoNum5());
		__bean.setTotalNum5(getTotalNum5());
		__bean.setOneNum6(getOneNum6());
		__bean.setTwoNum6(getTwoNum6());
		__bean.setTotalNum6(getTotalNum6());
		__bean.setOneNum7(getOneNum7());
		__bean.setTwoNum7(getTwoNum7());
		__bean.setTotalNum7(getTotalNum7());
		__bean.setOneNum8(getOneNum8());
		__bean.setTwoNum8(getTwoNum8());
		__bean.setTotalNum8(getTotalNum8());
		__bean.setOneNum9(getOneNum9());
		__bean.setTwoNum9(getTwoNum9());
		__bean.setTotalNum9(getTotalNum9());
		__bean.setOneNum10(getOneNum10());
		__bean.setTwoNum10(getTwoNum10());
		__bean.setTotalNum10(getTotalNum10());
		__bean.setOneNum11(getOneNum11());
		__bean.setTwoNum11(getTwoNum11());
		__bean.setTotalNum11(getTotalNum11());
		__bean.setOneNum12(getOneNum12());
		__bean.setTwoNum12(getTwoNum12());
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
		sb.append(getTotalNum1() == null ? "" : getTotalNum1());
		sb.append(",");
		sb.append(getOneNum2() == null ? "" : getOneNum2());
		sb.append(",");
		sb.append(getTwoNum2() == null ? "" : getTwoNum2());
		sb.append(",");
		sb.append(getTotalNum2() == null ? "" : getTotalNum2());
		sb.append(",");
		sb.append(getOneNum3() == null ? "" : getOneNum3());
		sb.append(",");
		sb.append(getTwoNum3() == null ? "" : getTwoNum3());
		sb.append(",");
		sb.append(getTotalNum3() == null ? "" : getTotalNum3());
		sb.append(",");
		sb.append(getOneNum4() == null ? "" : getOneNum4());
		sb.append(",");
		sb.append(getTwoNum4() == null ? "" : getTwoNum4());
		sb.append(",");
		sb.append(getTotalNum4() == null ? "" : getTotalNum4());
		sb.append(",");
		sb.append(getOneNum5() == null ? "" : getOneNum5());
		sb.append(",");
		sb.append(getTwoNum5() == null ? "" : getTwoNum5());
		sb.append(",");
		sb.append(getTotalNum5() == null ? "" : getTotalNum5());
		sb.append(",");
		sb.append(getOneNum6() == null ? "" : getOneNum6());
		sb.append(",");
		sb.append(getTwoNum6() == null ? "" : getTwoNum6());
		sb.append(",");
		sb.append(getTotalNum6() == null ? "" : getTotalNum6());
		sb.append(",");
		sb.append(getOneNum7() == null ? "" : getOneNum7());
		sb.append(",");
		sb.append(getTwoNum7() == null ? "" : getTwoNum7());
		sb.append(",");
		sb.append(getTotalNum7() == null ? "" : getTotalNum7());
		sb.append(",");
		sb.append(getOneNum8() == null ? "" : getOneNum8());
		sb.append(",");
		sb.append(getTwoNum8() == null ? "" : getTwoNum8());
		sb.append(",");
		sb.append(getTotalNum8() == null ? "" : getTotalNum8());
		sb.append(",");
		sb.append(getOneNum9() == null ? "" : getOneNum9());
		sb.append(",");
		sb.append(getTwoNum9() == null ? "" : getTwoNum9());
		sb.append(",");
		sb.append(getTotalNum9() == null ? "" : getTotalNum9());
		sb.append(",");
		sb.append(getOneNum10() == null ? "" : getOneNum10());
		sb.append(",");
		sb.append(getTwoNum10() == null ? "" : getTwoNum10());
		sb.append(",");
		sb.append(getTotalNum10() == null ? "" : getTotalNum10());
		sb.append(",");
		sb.append(getOneNum11() == null ? "" : getOneNum11());
		sb.append(",");
		sb.append(getTwoNum11() == null ? "" : getTwoNum11());
		sb.append(",");
		sb.append(getTotalNum11() == null ? "" : getTotalNum11());
		sb.append(",");
		sb.append(getOneNum12() == null ? "" : getOneNum12());
		sb.append(",");
		sb.append(getTwoNum12() == null ? "" : getTwoNum12());
		sb.append(",");
		sb.append(getTotalNum12() == null ? "" : getTotalNum12());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseReportOnEmployeeBenefitTotalByDepartment o) {
		return __department_id == null ? -1 : __department_id.compareTo(o.getDepartmentId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__department_id);
		hash = 97 * hash + Objects.hashCode(this.__year);
		hash = 97 * hash + Objects.hashCode(this.__one_num1);
		hash = 97 * hash + Objects.hashCode(this.__two_num1);
		hash = 97 * hash + Objects.hashCode(this.__total_num1);
		hash = 97 * hash + Objects.hashCode(this.__one_num2);
		hash = 97 * hash + Objects.hashCode(this.__two_num2);
		hash = 97 * hash + Objects.hashCode(this.__total_num2);
		hash = 97 * hash + Objects.hashCode(this.__one_num3);
		hash = 97 * hash + Objects.hashCode(this.__two_num3);
		hash = 97 * hash + Objects.hashCode(this.__total_num3);
		hash = 97 * hash + Objects.hashCode(this.__one_num4);
		hash = 97 * hash + Objects.hashCode(this.__two_num4);
		hash = 97 * hash + Objects.hashCode(this.__total_num4);
		hash = 97 * hash + Objects.hashCode(this.__one_num5);
		hash = 97 * hash + Objects.hashCode(this.__two_num5);
		hash = 97 * hash + Objects.hashCode(this.__total_num5);
		hash = 97 * hash + Objects.hashCode(this.__one_num6);
		hash = 97 * hash + Objects.hashCode(this.__two_num6);
		hash = 97 * hash + Objects.hashCode(this.__total_num6);
		hash = 97 * hash + Objects.hashCode(this.__one_num7);
		hash = 97 * hash + Objects.hashCode(this.__two_num7);
		hash = 97 * hash + Objects.hashCode(this.__total_num7);
		hash = 97 * hash + Objects.hashCode(this.__one_num8);
		hash = 97 * hash + Objects.hashCode(this.__two_num8);
		hash = 97 * hash + Objects.hashCode(this.__total_num8);
		hash = 97 * hash + Objects.hashCode(this.__one_num9);
		hash = 97 * hash + Objects.hashCode(this.__two_num9);
		hash = 97 * hash + Objects.hashCode(this.__total_num9);
		hash = 97 * hash + Objects.hashCode(this.__one_num10);
		hash = 97 * hash + Objects.hashCode(this.__two_num10);
		hash = 97 * hash + Objects.hashCode(this.__total_num10);
		hash = 97 * hash + Objects.hashCode(this.__one_num11);
		hash = 97 * hash + Objects.hashCode(this.__two_num11);
		hash = 97 * hash + Objects.hashCode(this.__total_num11);
		hash = 97 * hash + Objects.hashCode(this.__one_num12);
		hash = 97 * hash + Objects.hashCode(this.__two_num12);
		hash = 97 * hash + Objects.hashCode(this.__total_num12);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		final BaseReportOnEmployeeBenefitTotalByDepartment o = (BaseReportOnEmployeeBenefitTotalByDepartment)obj;
		if(!Objects.equals(this.__department_id, o.getDepartmentId())) return false;
		if(!Objects.equals(this.__year, o.getYear())) return false;
		if(!Objects.equals(this.__one_num1, o.getOneNum1())) return false;
		if(!Objects.equals(this.__two_num1, o.getTwoNum1())) return false;
		if(!Objects.equals(this.__total_num1, o.getTotalNum1())) return false;
		if(!Objects.equals(this.__one_num2, o.getOneNum2())) return false;
		if(!Objects.equals(this.__two_num2, o.getTwoNum2())) return false;
		if(!Objects.equals(this.__total_num2, o.getTotalNum2())) return false;
		if(!Objects.equals(this.__one_num3, o.getOneNum3())) return false;
		if(!Objects.equals(this.__two_num3, o.getTwoNum3())) return false;
		if(!Objects.equals(this.__total_num3, o.getTotalNum3())) return false;
		if(!Objects.equals(this.__one_num4, o.getOneNum4())) return false;
		if(!Objects.equals(this.__two_num4, o.getTwoNum4())) return false;
		if(!Objects.equals(this.__total_num4, o.getTotalNum4())) return false;
		if(!Objects.equals(this.__one_num5, o.getOneNum5())) return false;
		if(!Objects.equals(this.__two_num5, o.getTwoNum5())) return false;
		if(!Objects.equals(this.__total_num5, o.getTotalNum5())) return false;
		if(!Objects.equals(this.__one_num6, o.getOneNum6())) return false;
		if(!Objects.equals(this.__two_num6, o.getTwoNum6())) return false;
		if(!Objects.equals(this.__total_num6, o.getTotalNum6())) return false;
		if(!Objects.equals(this.__one_num7, o.getOneNum7())) return false;
		if(!Objects.equals(this.__two_num7, o.getTwoNum7())) return false;
		if(!Objects.equals(this.__total_num7, o.getTotalNum7())) return false;
		if(!Objects.equals(this.__one_num8, o.getOneNum8())) return false;
		if(!Objects.equals(this.__two_num8, o.getTwoNum8())) return false;
		if(!Objects.equals(this.__total_num8, o.getTotalNum8())) return false;
		if(!Objects.equals(this.__one_num9, o.getOneNum9())) return false;
		if(!Objects.equals(this.__two_num9, o.getTwoNum9())) return false;
		if(!Objects.equals(this.__total_num9, o.getTotalNum9())) return false;
		if(!Objects.equals(this.__one_num10, o.getOneNum10())) return false;
		if(!Objects.equals(this.__two_num10, o.getTwoNum10())) return false;
		if(!Objects.equals(this.__total_num10, o.getTotalNum10())) return false;
		if(!Objects.equals(this.__one_num11, o.getOneNum11())) return false;
		if(!Objects.equals(this.__two_num11, o.getTwoNum11())) return false;
		if(!Objects.equals(this.__total_num11, o.getTotalNum11())) return false;
		if(!Objects.equals(this.__one_num12, o.getOneNum12())) return false;
		if(!Objects.equals(this.__two_num12, o.getTwoNum12())) return false;
		if(!Objects.equals(this.__total_num12, o.getTotalNum12())) return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if(getDepartmentId() != null) sb.append(__wrapNumber(count++, "departmentId", getDepartmentId()));
		if(getYear() != null) sb.append(__wrapNumber(count++, "year", getYear()));
		if(getOneNum1() != null) sb.append(__wrapNumber(count++, "oneNum1", getOneNum1()));
		if(getTwoNum1() != null) sb.append(__wrapNumber(count++, "twoNum1", getTwoNum1()));
		if(getTotalNum1() != null) sb.append(__wrapNumber(count++, "totalNum1", getTotalNum1()));
		if(getOneNum2() != null) sb.append(__wrapNumber(count++, "oneNum2", getOneNum2()));
		if(getTwoNum2() != null) sb.append(__wrapNumber(count++, "twoNum2", getTwoNum2()));
		if(getTotalNum2() != null) sb.append(__wrapNumber(count++, "totalNum2", getTotalNum2()));
		if(getOneNum3() != null) sb.append(__wrapNumber(count++, "oneNum3", getOneNum3()));
		if(getTwoNum3() != null) sb.append(__wrapNumber(count++, "twoNum3", getTwoNum3()));
		if(getTotalNum3() != null) sb.append(__wrapNumber(count++, "totalNum3", getTotalNum3()));
		if(getOneNum4() != null) sb.append(__wrapNumber(count++, "oneNum4", getOneNum4()));
		if(getTwoNum4() != null) sb.append(__wrapNumber(count++, "twoNum4", getTwoNum4()));
		if(getTotalNum4() != null) sb.append(__wrapNumber(count++, "totalNum4", getTotalNum4()));
		if(getOneNum5() != null) sb.append(__wrapNumber(count++, "oneNum5", getOneNum5()));
		if(getTwoNum5() != null) sb.append(__wrapNumber(count++, "twoNum5", getTwoNum5()));
		if(getTotalNum5() != null) sb.append(__wrapNumber(count++, "totalNum5", getTotalNum5()));
		if(getOneNum6() != null) sb.append(__wrapNumber(count++, "oneNum6", getOneNum6()));
		if(getTwoNum6() != null) sb.append(__wrapNumber(count++, "twoNum6", getTwoNum6()));
		if(getTotalNum6() != null) sb.append(__wrapNumber(count++, "totalNum6", getTotalNum6()));
		if(getOneNum7() != null) sb.append(__wrapNumber(count++, "oneNum7", getOneNum7()));
		if(getTwoNum7() != null) sb.append(__wrapNumber(count++, "twoNum7", getTwoNum7()));
		if(getTotalNum7() != null) sb.append(__wrapNumber(count++, "totalNum7", getTotalNum7()));
		if(getOneNum8() != null) sb.append(__wrapNumber(count++, "oneNum8", getOneNum8()));
		if(getTwoNum8() != null) sb.append(__wrapNumber(count++, "twoNum8", getTwoNum8()));
		if(getTotalNum8() != null) sb.append(__wrapNumber(count++, "totalNum8", getTotalNum8()));
		if(getOneNum9() != null) sb.append(__wrapNumber(count++, "oneNum9", getOneNum9()));
		if(getTwoNum9() != null) sb.append(__wrapNumber(count++, "twoNum9", getTwoNum9()));
		if(getTotalNum9() != null) sb.append(__wrapNumber(count++, "totalNum9", getTotalNum9()));
		if(getOneNum10() != null) sb.append(__wrapNumber(count++, "oneNum10", getOneNum10()));
		if(getTwoNum10() != null) sb.append(__wrapNumber(count++, "twoNum10", getTwoNum10()));
		if(getTotalNum10() != null) sb.append(__wrapNumber(count++, "totalNum10", getTotalNum10()));
		if(getOneNum11() != null) sb.append(__wrapNumber(count++, "oneNum11", getOneNum11()));
		if(getTwoNum11() != null) sb.append(__wrapNumber(count++, "twoNum11", getTwoNum11()));
		if(getTotalNum11() != null) sb.append(__wrapNumber(count++, "totalNum11", getTotalNum11()));
		if(getOneNum12() != null) sb.append(__wrapNumber(count++, "oneNum12", getOneNum12()));
		if(getTwoNum12() != null) sb.append(__wrapNumber(count++, "twoNum12", getTwoNum12()));
		if(getTotalNum12() != null) sb.append(__wrapNumber(count++, "totalNum12", getTotalNum12()));
		return sb.toString();
	}

	public Map<String, Object> toMap() {
		Map<String, Object> res = new HashMap<>();
		if(getDepartmentId() != null) res.put("departmentId", getDepartmentId());
		if(getYear() != null) res.put("year", getYear());
		if(getOneNum1() != null) res.put("oneNum1", getOneNum1());
		if(getTwoNum1() != null) res.put("twoNum1", getTwoNum1());
		if(getTotalNum1() != null) res.put("totalNum1", getTotalNum1());
		if(getOneNum2() != null) res.put("oneNum2", getOneNum2());
		if(getTwoNum2() != null) res.put("twoNum2", getTwoNum2());
		if(getTotalNum2() != null) res.put("totalNum2", getTotalNum2());
		if(getOneNum3() != null) res.put("oneNum3", getOneNum3());
		if(getTwoNum3() != null) res.put("twoNum3", getTwoNum3());
		if(getTotalNum3() != null) res.put("totalNum3", getTotalNum3());
		if(getOneNum4() != null) res.put("oneNum4", getOneNum4());
		if(getTwoNum4() != null) res.put("twoNum4", getTwoNum4());
		if(getTotalNum4() != null) res.put("totalNum4", getTotalNum4());
		if(getOneNum5() != null) res.put("oneNum5", getOneNum5());
		if(getTwoNum5() != null) res.put("twoNum5", getTwoNum5());
		if(getTotalNum5() != null) res.put("totalNum5", getTotalNum5());
		if(getOneNum6() != null) res.put("oneNum6", getOneNum6());
		if(getTwoNum6() != null) res.put("twoNum6", getTwoNum6());
		if(getTotalNum6() != null) res.put("totalNum6", getTotalNum6());
		if(getOneNum7() != null) res.put("oneNum7", getOneNum7());
		if(getTwoNum7() != null) res.put("twoNum7", getTwoNum7());
		if(getTotalNum7() != null) res.put("totalNum7", getTotalNum7());
		if(getOneNum8() != null) res.put("oneNum8", getOneNum8());
		if(getTwoNum8() != null) res.put("twoNum8", getTwoNum8());
		if(getTotalNum8() != null) res.put("totalNum8", getTotalNum8());
		if(getOneNum9() != null) res.put("oneNum9", getOneNum9());
		if(getTwoNum9() != null) res.put("twoNum9", getTwoNum9());
		if(getTotalNum9() != null) res.put("totalNum9", getTotalNum9());
		if(getOneNum10() != null) res.put("oneNum10", getOneNum10());
		if(getTwoNum10() != null) res.put("twoNum10", getTwoNum10());
		if(getTotalNum10() != null) res.put("totalNum10", getTotalNum10());
		if(getOneNum11() != null) res.put("oneNum11", getOneNum11());
		if(getTwoNum11() != null) res.put("twoNum11", getTwoNum11());
		if(getTotalNum11() != null) res.put("totalNum11", getTotalNum11());
		if(getOneNum12() != null) res.put("oneNum12", getOneNum12());
		if(getTwoNum12() != null) res.put("twoNum12", getTwoNum12());
		if(getTotalNum12() != null) res.put("totalNum12", getTotalNum12());
		return res;
	}

	@Override
	public void setDataFromMap(Map<String, Object> values){
		Object val;
		if((val = values.get("departmentId")) != null) setDepartmentId(__getInt(val)); 
		if((val = values.get("year")) != null) setYear(__getInt(val)); 
		if((val = values.get("oneNum1")) != null) setOneNum1(__getLong(val)); 
		if((val = values.get("twoNum1")) != null) setTwoNum1(__getLong(val)); 
		if((val = values.get("totalNum1")) != null) setTotalNum1(__getLong(val)); 
		if((val = values.get("oneNum2")) != null) setOneNum2(__getLong(val)); 
		if((val = values.get("twoNum2")) != null) setTwoNum2(__getLong(val)); 
		if((val = values.get("totalNum2")) != null) setTotalNum2(__getLong(val)); 
		if((val = values.get("oneNum3")) != null) setOneNum3(__getLong(val)); 
		if((val = values.get("twoNum3")) != null) setTwoNum3(__getLong(val)); 
		if((val = values.get("totalNum3")) != null) setTotalNum3(__getLong(val)); 
		if((val = values.get("oneNum4")) != null) setOneNum4(__getLong(val)); 
		if((val = values.get("twoNum4")) != null) setTwoNum4(__getLong(val)); 
		if((val = values.get("totalNum4")) != null) setTotalNum4(__getLong(val)); 
		if((val = values.get("oneNum5")) != null) setOneNum5(__getLong(val)); 
		if((val = values.get("twoNum5")) != null) setTwoNum5(__getLong(val)); 
		if((val = values.get("totalNum5")) != null) setTotalNum5(__getLong(val)); 
		if((val = values.get("oneNum6")) != null) setOneNum6(__getLong(val)); 
		if((val = values.get("twoNum6")) != null) setTwoNum6(__getLong(val)); 
		if((val = values.get("totalNum6")) != null) setTotalNum6(__getLong(val)); 
		if((val = values.get("oneNum7")) != null) setOneNum7(__getLong(val)); 
		if((val = values.get("twoNum7")) != null) setTwoNum7(__getLong(val)); 
		if((val = values.get("totalNum7")) != null) setTotalNum7(__getLong(val)); 
		if((val = values.get("oneNum8")) != null) setOneNum8(__getLong(val)); 
		if((val = values.get("twoNum8")) != null) setTwoNum8(__getLong(val)); 
		if((val = values.get("totalNum8")) != null) setTotalNum8(__getLong(val)); 
		if((val = values.get("oneNum9")) != null) setOneNum9(__getLong(val)); 
		if((val = values.get("twoNum9")) != null) setTwoNum9(__getLong(val)); 
		if((val = values.get("totalNum9")) != null) setTotalNum9(__getLong(val)); 
		if((val = values.get("oneNum10")) != null) setOneNum10(__getLong(val)); 
		if((val = values.get("twoNum10")) != null) setTwoNum10(__getLong(val)); 
		if((val = values.get("totalNum10")) != null) setTotalNum10(__getLong(val)); 
		if((val = values.get("oneNum11")) != null) setOneNum11(__getLong(val)); 
		if((val = values.get("twoNum11")) != null) setTwoNum11(__getLong(val)); 
		if((val = values.get("totalNum11")) != null) setTotalNum11(__getLong(val)); 
		if((val = values.get("oneNum12")) != null) setOneNum12(__getLong(val)); 
		if((val = values.get("twoNum12")) != null) setTwoNum12(__getLong(val)); 
		if((val = values.get("totalNum12")) != null) setTotalNum12(__getLong(val)); 
	}

	protected java.lang.Integer  __department_id ;
	protected java.lang.Integer  __year ;
	protected java.lang.Long  __one_num1 ;
	protected java.lang.Long  __two_num1 ;
	protected java.lang.Long  __total_num1 ;
	protected java.lang.Long  __one_num2 ;
	protected java.lang.Long  __two_num2 ;
	protected java.lang.Long  __total_num2 ;
	protected java.lang.Long  __one_num3 ;
	protected java.lang.Long  __two_num3 ;
	protected java.lang.Long  __total_num3 ;
	protected java.lang.Long  __one_num4 ;
	protected java.lang.Long  __two_num4 ;
	protected java.lang.Long  __total_num4 ;
	protected java.lang.Long  __one_num5 ;
	protected java.lang.Long  __two_num5 ;
	protected java.lang.Long  __total_num5 ;
	protected java.lang.Long  __one_num6 ;
	protected java.lang.Long  __two_num6 ;
	protected java.lang.Long  __total_num6 ;
	protected java.lang.Long  __one_num7 ;
	protected java.lang.Long  __two_num7 ;
	protected java.lang.Long  __total_num7 ;
	protected java.lang.Long  __one_num8 ;
	protected java.lang.Long  __two_num8 ;
	protected java.lang.Long  __total_num8 ;
	protected java.lang.Long  __one_num9 ;
	protected java.lang.Long  __two_num9 ;
	protected java.lang.Long  __total_num9 ;
	protected java.lang.Long  __one_num10 ;
	protected java.lang.Long  __two_num10 ;
	protected java.lang.Long  __total_num10 ;
	protected java.lang.Long  __one_num11 ;
	protected java.lang.Long  __two_num11 ;
	protected java.lang.Long  __total_num11 ;
	protected java.lang.Long  __one_num12 ;
	protected java.lang.Long  __two_num12 ;
	protected java.lang.Long  __total_num12 ;
}
