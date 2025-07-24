package pomplatform.EmployeeDetail.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BaseSalaryReturnDetail extends GenericBase
		implements BaseFactory<BaseSalaryReturnDetail>, Comparable<BaseSalaryReturnDetail> {

	public static BaseSalaryReturnDetail newInstance() {
		return new BaseSalaryReturnDetail();
	}

	@Override
	public BaseSalaryReturnDetail make() {
		BaseSalaryReturnDetail b = new BaseSalaryReturnDetail();
		return b;
	}

	public final static java.lang.String CS_EMPLOYEE_ID = "employee_id";
	public final static java.lang.String CS_EMPLOYEE_NO = "employee_no";
	public final static java.lang.String CS_SALARY_RETURN = "salary_return";
	public final static java.lang.String CS_PLATE_ID = "plate_id";
	public final static java.lang.String CS_RECORD_DATE = "record_date";

	public final static java.lang.String ALL_CAPTIONS = "员工,工号,积分回流,业务部门,日期";

	public java.lang.Integer getEmployeeId() {
		return this.__employee_id;
	}

	public void setEmployeeId(java.lang.Integer value) {
		this.__employee_id = value;
	}

	public java.lang.String getEmployeeNo() {
		return this.__employee_no;
	}

	public void setEmployeeNo(java.lang.String value) {
		this.__employee_no = value;
	}

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn(java.math.BigDecimal value) {
		this.__salary_return = value;
	}

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.util.Date getRecordDate() {
		return this.__record_date;
	}

	public void setRecordDate(java.util.Date value) {
		this.__record_date = value;
	}

	public void cloneCopy(BaseSalaryReturnDetail __bean) {
		__bean.setEmployeeId(getEmployeeId());
		__bean.setEmployeeNo(getEmployeeNo());
		__bean.setSalaryReturn(getSalaryReturn());
		__bean.setPlateId(getPlateId());
		__bean.setRecordDate(getRecordDate());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees",
				String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1",
				String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getRecordDate() == null ? "" : sdf.format(getRecordDate()));
		return sb.toString();
	}

	@Override
	public int compareTo(BaseSalaryReturnDetail o) {
		return __employee_id == null ? -1 : __employee_id.compareTo(o.getEmployeeId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__employee_id);
		hash = 97 * hash + Objects.hashCode(this.__employee_no);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__record_date);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BaseSalaryReturnDetail o = (BaseSalaryReturnDetail) obj;
		if (!Objects.equals(this.__employee_id, o.getEmployeeId()))
			return false;
		if (!Objects.equals(this.__employee_no, o.getEmployeeNo()))
			return false;
		if (!Objects.equals(this.__salary_return, o.getSalaryReturn()))
			return false;
		if (!Objects.equals(this.__plate_id, o.getPlateId()))
			return false;
		if (!Objects.equals(this.__record_date, o.getRecordDate()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if (getEmployeeId() != null)
			sb.append(__wrapNumber(count++, "employeeId", getEmployeeId()));
		if (getEmployeeNo() != null)
			sb.append(__wrapString(count++, "employeeNo", getEmployeeNo()));
		if (getSalaryReturn() != null)
			sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		if (getPlateId() != null)
			sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if (getRecordDate() != null)
			sb.append(__wrapDate(count++, "recordDate", getRecordDate()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if ((val = values.get("employeeId")) != null)
			setEmployeeId(__getInt(val));
		if ((val = values.get("employeeNo")) != null)
			setEmployeeNo(__getString(val));
		if ((val = values.get("salaryReturn")) != null)
			setSalaryReturn(__getDecimal(val));
		if ((val = values.get("plateId")) != null)
			setPlateId(__getInt(val));
		if ((val = values.get("recordDate")) != null)
			setRecordDate(__getDate(val));
	}

	protected java.lang.Integer __employee_id;
	protected java.lang.String __employee_no;
	protected java.math.BigDecimal __salary_return;
	protected java.lang.Integer __plate_id;
	protected java.util.Date __record_date;
}
