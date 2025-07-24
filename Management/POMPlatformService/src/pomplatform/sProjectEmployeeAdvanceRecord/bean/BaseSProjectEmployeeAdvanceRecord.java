package pomplatform.sProjectEmployeeAdvanceRecord.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSProjectEmployeeAdvanceRecord extends GenericBase
		implements BaseFactory<BaseSProjectEmployeeAdvanceRecord>, Comparable<BaseSProjectEmployeeAdvanceRecord> {

	public static BaseSProjectEmployeeAdvanceRecord newInstance() {
		return new BaseSProjectEmployeeAdvanceRecord();
	}

	@Override
	public BaseSProjectEmployeeAdvanceRecord make() {
		BaseSProjectEmployeeAdvanceRecord b = new BaseSProjectEmployeeAdvanceRecord();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id";
	public final static java.lang.String CS_ADVANCE_YEAR = "advance_year";
	public final static java.lang.String CS_ADVANCE_MONTH = "advance_month";
	public final static java.lang.String CS_ADVANCE_INTEGRAL = "advance_integral";

	public final static java.lang.String ALL_CAPTIONS = "员工姓名,年份,月份,补贴积分";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId(java.lang.Integer value) {
		this.__employee_id = value;
	}

	public java.lang.Integer getAdvanceYear() {
		return this.__advance_year;
	}

	public void setAdvanceYear(java.lang.Integer value) {
		this.__advance_year = value;
	}

	public java.lang.Integer getAdvanceMonth() {
		return this.__advance_month;
	}

	public void setAdvanceMonth(java.lang.Integer value) {
		this.__advance_month = value;
	}

	public java.math.BigDecimal getAdvanceIntegral() {
		return this.__advance_integral;
	}

	public void setAdvanceIntegral(java.math.BigDecimal value) {
		this.__advance_integral = value;
	}

	public void cloneCopy(BaseSProjectEmployeeAdvanceRecord __bean) {
		__bean.setEmployeeId(getEmployeeId());
		__bean.setAdvanceYear(getAdvanceYear());
		__bean.setAdvanceMonth(getAdvanceMonth());
		__bean.setAdvanceIntegral(getAdvanceIntegral());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees",
				String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getAdvanceYear() == null ? "" : getAdvanceYear());
		sb.append(",");
		sb.append(getAdvanceMonth() == null ? "" : getAdvanceMonth());
		sb.append(",");
		sb.append(getAdvanceIntegral() == null ? "" : getAdvanceIntegral());
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSProjectEmployeeAdvanceRecord o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__advance_year);
		hash = 97 * hash + Objects.hashCode(this.__advance_month);
		hash = 97 * hash + Objects.hashCode(this.__advance_integral);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BaseSProjectEmployeeAdvanceRecord o = (BaseSProjectEmployeeAdvanceRecord) obj;
		if (!Objects.equals(this.__employee_id, o.getEmployeeId()))
			return false;
		if (!Objects.equals(this.__advance_year, o.getAdvanceYear()))
			return false;
		if (!Objects.equals(this.__advance_month, o.getAdvanceMonth()))
			return false;
		if (!Objects.equals(this.__advance_integral, o.getAdvanceIntegral()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if (getEmployeeId() != null)
			sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if (getAdvanceYear() != null)
			sb.append(__wrapNumber(count++, "advanceYear", getAdvanceYear()));
		if (getAdvanceMonth() != null)
			sb.append(__wrapNumber(count++, "advanceMonth", getAdvanceMonth()));
		if (getAdvanceIntegral() != null)
			sb.append(__wrapDecimal(count++, "advanceIntegral", getAdvanceIntegral()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if ((val = values.get("employeeId")) != null)
			setEmployeeId(__getInt(val));
		if ((val = values.get("advanceYear")) != null)
			setAdvanceYear(__getInt(val));
		if ((val = values.get("advanceMonth")) != null)
			setAdvanceMonth(__getInt(val));
		if ((val = values.get("advanceIntegral")) != null)
			setAdvanceIntegral(__getDecimal(val));
	}

	protected java.lang.Integer __employee_id;
	protected java.lang.Integer __advance_year;
	protected java.lang.Integer __advance_month;
	protected java.math.BigDecimal __advance_integral;
}
