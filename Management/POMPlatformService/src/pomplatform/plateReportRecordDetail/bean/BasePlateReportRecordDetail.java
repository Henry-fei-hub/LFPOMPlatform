package pomplatform.plateReportRecordDetail.bean;

import java.util.Map;
import java.util.Objects;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;

public class BasePlateReportRecordDetail extends GenericBase
		implements BaseFactory<BasePlateReportRecordDetail>, Comparable<BasePlateReportRecordDetail> {

	public static BasePlateReportRecordDetail newInstance() {
		return new BasePlateReportRecordDetail();
	}

	@Override
	public BasePlateReportRecordDetail make() {
		BasePlateReportRecordDetail b = new BasePlateReportRecordDetail();
		return b;
	}

	public final static java.lang.String CS_PLATE_ID = "plate_id";
	public final static java.lang.String CS_ACHIEVE_INTEGRAL = "achieve_integral";
	public final static java.lang.String CS_PROJECT_SETTLEMENT = "project_settlement";
	public final static java.lang.String CS_COMPANY_SUBSIDY = "company_subsidy";
	public final static java.lang.String CS_EMPLOYEE_ACHIEVE_INTEGRAL_RETURN = "employee_achieve_integral_return";
	public final static java.lang.String CS_SALARY_RETURN = "salary_return";
	public final static java.lang.String CS_SALARY_ADVANCE = "salary_advance";
	public final static java.lang.String CS_MANAGER_PROJECT_INTEGRAL = "manager_project_integral";
	public final static java.lang.String CS_PLATE_COST = "plate_cost";
	public final static java.lang.String CS_PROJECT_ADVANCE = "project_advance";
	public final static java.lang.String CS_QUALITY_FEE = "quality_fee";
	public final static java.lang.String CS_COMPANY_FEE = "company_fee";
	public final static java.lang.String CS_VIOLATION_CHARGES = "violation_charges";

	public final static java.lang.String ALL_CAPTIONS = "业务部门,价值积分,项目结算,公司补贴,积分回收,积分还款,积分借款,奖金补贴,运营成本,项目补贴,品质管理费,公司费用,项目违规金";

	public java.lang.Integer getPlateId() {
		return this.__plate_id;
	}

	public void setPlateId(java.lang.Integer value) {
		this.__plate_id = value;
	}

	public java.math.BigDecimal getAchieveIntegral() {
		return this.__achieve_integral;
	}

	public void setAchieveIntegral(java.math.BigDecimal value) {
		this.__achieve_integral = value;
	}

	public java.math.BigDecimal getProjectSettlement() {
		return this.__project_settlement;
	}

	public void setProjectSettlement(java.math.BigDecimal value) {
		this.__project_settlement = value;
	}

	public java.math.BigDecimal getCompanySubsidy() {
		return this.__company_subsidy;
	}

	public void setCompanySubsidy(java.math.BigDecimal value) {
		this.__company_subsidy = value;
	}

	public java.math.BigDecimal getEmployeeAchieveIntegralReturn() {
		return this.__employee_achieve_integral_return;
	}

	public void setEmployeeAchieveIntegralReturn(java.math.BigDecimal value) {
		this.__employee_achieve_integral_return = value;
	}

	public java.math.BigDecimal getSalaryReturn() {
		return this.__salary_return;
	}

	public void setSalaryReturn(java.math.BigDecimal value) {
		this.__salary_return = value;
	}

	public java.math.BigDecimal getSalaryAdvance() {
		return this.__salary_advance;
	}

	public void setSalaryAdvance(java.math.BigDecimal value) {
		this.__salary_advance = value;
	}

	public java.math.BigDecimal getManagerProjectIntegral() {
		return this.__manager_project_integral;
	}

	public void setManagerProjectIntegral(java.math.BigDecimal value) {
		this.__manager_project_integral = value;
	}

	public java.math.BigDecimal getPlateCost() {
		return this.__plate_cost;
	}

	public void setPlateCost(java.math.BigDecimal value) {
		this.__plate_cost = value;
	}

	public java.math.BigDecimal getProjectAdvance() {
		return this.__project_advance;
	}

	public void setProjectAdvance(java.math.BigDecimal value) {
		this.__project_advance = value;
	}
	
	public java.math.BigDecimal getQualityFee() {
		return __quality_fee;
	}

	public void setQualityFee(java.math.BigDecimal value) {
		this.__quality_fee = value;
	}

	public java.math.BigDecimal getCompanyFee() {
		return __company_fee;
	}

	public void setCompanyFee(java.math.BigDecimal value) {
		this.__company_fee = value;
	}

	public java.math.BigDecimal getViolationCharges() {
		return __violation_charges;
	}

	public void setViolationCharges(java.math.BigDecimal value) {
		this.__violation_charges = value;
	}

	public void cloneCopy(BasePlateReportRecordDetail __bean) {
		__bean.setPlateId(getPlateId());
		__bean.setAchieveIntegral(getAchieveIntegral());
		__bean.setProjectSettlement(getProjectSettlement());
		__bean.setCompanySubsidy(getCompanySubsidy());
		__bean.setEmployeeAchieveIntegralReturn(getEmployeeAchieveIntegralReturn());
		__bean.setSalaryReturn(getSalaryReturn());
		__bean.setSalaryAdvance(getSalaryAdvance());
		__bean.setManagerProjectIntegral(getManagerProjectIntegral());
		__bean.setPlateCost(getPlateCost());
		__bean.setProjectAdvance(getProjectAdvance());
		__bean.setQualityFee(getQualityFee());
		__bean.setCompanyFee(getCompanyFee());
		__bean.setViolationCharges(getViolationCharges());
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1",
				String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		sb.append(getAchieveIntegral() == null ? "" : getAchieveIntegral());
		sb.append(",");
		sb.append(getProjectSettlement() == null ? "" : getProjectSettlement());
		sb.append(",");
		sb.append(getCompanySubsidy() == null ? "" : getCompanySubsidy());
		sb.append(",");
		sb.append(getEmployeeAchieveIntegralReturn() == null ? "" : getEmployeeAchieveIntegralReturn());
		sb.append(",");
		sb.append(getSalaryReturn() == null ? "" : getSalaryReturn());
		sb.append(",");
		sb.append(getSalaryAdvance() == null ? "" : getSalaryAdvance());
		sb.append(",");
		sb.append(getManagerProjectIntegral() == null ? "" : getManagerProjectIntegral());
		sb.append(",");
		sb.append(getPlateCost() == null ? "" : getPlateCost());
		sb.append(",");
		sb.append(getProjectAdvance() == null ? "" : getProjectAdvance());
		sb.append(",");
		sb.append(getQualityFee() == null ? "" : getQualityFee());
		sb.append(",");
		sb.append(getCompanyFee() == null ? "" : getCompanyFee());
		sb.append(",");
		sb.append(getViolationCharges() == null ? "" : getViolationCharges());
		return sb.toString();
	}

	@Override
	public int compareTo(BasePlateReportRecordDetail o) {
		return __plate_id == null ? -1 : __plate_id.compareTo(o.getPlateId());
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 97 * hash + Objects.hashCode(this.__plate_id);
		hash = 97 * hash + Objects.hashCode(this.__achieve_integral);
		hash = 97 * hash + Objects.hashCode(this.__project_settlement);
		hash = 97 * hash + Objects.hashCode(this.__company_subsidy);
		hash = 97 * hash + Objects.hashCode(this.__employee_achieve_integral_return);
		hash = 97 * hash + Objects.hashCode(this.__salary_return);
		hash = 97 * hash + Objects.hashCode(this.__salary_advance);
		hash = 97 * hash + Objects.hashCode(this.__manager_project_integral);
		hash = 97 * hash + Objects.hashCode(this.__plate_cost);
		hash = 97 * hash + Objects.hashCode(this.__project_advance);
		hash = 97 * hash + Objects.hashCode(this.__quality_fee);
		hash = 97 * hash + Objects.hashCode(this.__company_fee);
		hash = 97 * hash + Objects.hashCode(this.__violation_charges);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final BasePlateReportRecordDetail o = (BasePlateReportRecordDetail) obj;
		if (!Objects.equals(this.__plate_id, o.getPlateId()))
			return false;
		if (!Objects.equals(this.__achieve_integral, o.getAchieveIntegral()))
			return false;
		if (!Objects.equals(this.__project_settlement, o.getProjectSettlement()))
			return false;
		if (!Objects.equals(this.__company_subsidy, o.getCompanySubsidy()))
			return false;
		if (!Objects.equals(this.__employee_achieve_integral_return, o.getEmployeeAchieveIntegralReturn()))
			return false;
		if (!Objects.equals(this.__salary_return, o.getSalaryReturn()))
			return false;
		if (!Objects.equals(this.__salary_advance, o.getSalaryAdvance()))
			return false;
		if (!Objects.equals(this.__manager_project_integral, o.getManagerProjectIntegral()))
			return false;
		if (!Objects.equals(this.__plate_cost, o.getPlateCost()))
			return false;
		if (!Objects.equals(this.__project_advance, o.getProjectAdvance()))
			return false;
		if (!Objects.equals(this.__quality_fee, o.getQualityFee()))
			return false;
		if (!Objects.equals(this.__company_fee, o.getCompanyFee()))
			return false;
		if (!Objects.equals(this.__violation_charges, o.getViolationCharges()))
			return false;
		return true;
	}

	@Override
	public java.lang.String toJSONString() {

		StringBuilder sb = new StringBuilder();
		int count = 0;
		if (getPlateId() != null)
			sb.append(__wrapNumber(count++, "plateId", getPlateId()));
		if (getAchieveIntegral() != null)
			sb.append(__wrapDecimal(count++, "achieveIntegral", getAchieveIntegral()));
		if (getProjectSettlement() != null)
			sb.append(__wrapDecimal(count++, "projectSettlement", getProjectSettlement()));
		if (getCompanySubsidy() != null)
			sb.append(__wrapDecimal(count++, "companySubsidy", getCompanySubsidy()));
		if (getEmployeeAchieveIntegralReturn() != null)
			sb.append(__wrapDecimal(count++, "employeeAchieveIntegralReturn", getEmployeeAchieveIntegralReturn()));
		if (getSalaryReturn() != null)
			sb.append(__wrapDecimal(count++, "salaryReturn", getSalaryReturn()));
		if (getSalaryAdvance() != null)
			sb.append(__wrapDecimal(count++, "salaryAdvance", getSalaryAdvance()));
		if (getManagerProjectIntegral() != null)
			sb.append(__wrapDecimal(count++, "managerProjectIntegral", getManagerProjectIntegral()));
		if (getPlateCost() != null)
			sb.append(__wrapDecimal(count++, "plateCost", getPlateCost()));
		if (getProjectAdvance() != null)
			sb.append(__wrapDecimal(count++, "projectAdvance", getProjectAdvance()));
		if (getQualityFee() != null)
			sb.append(__wrapDecimal(count++, "qualityFee", getQualityFee()));
		if (getCompanyFee() != null)
			sb.append(__wrapDecimal(count++, "companyFee", getCompanyFee()));
		if (getViolationCharges() != null)
			sb.append(__wrapDecimal(count++, "violationCharges", getViolationCharges()));
		return sb.toString();
	}

	@Override
	public void setDataFromMap(Map<String, Object> values) {
		Object val;
		if ((val = values.get("plateId")) != null)
			setPlateId(__getInt(val));
		if ((val = values.get("achieveIntegral")) != null)
			setAchieveIntegral(__getDecimal(val));
		if ((val = values.get("projectSettlement")) != null)
			setProjectSettlement(__getDecimal(val));
		if ((val = values.get("companySubsidy")) != null)
			setCompanySubsidy(__getDecimal(val));
		if ((val = values.get("employeeAchieveIntegralReturn")) != null)
			setEmployeeAchieveIntegralReturn(__getDecimal(val));
		if ((val = values.get("salaryReturn")) != null)
			setSalaryReturn(__getDecimal(val));
		if ((val = values.get("salaryAdvance")) != null)
			setSalaryAdvance(__getDecimal(val));
		if ((val = values.get("managerProjectIntegral")) != null)
			setManagerProjectIntegral(__getDecimal(val));
		if ((val = values.get("plateCost")) != null)
			setPlateCost(__getDecimal(val));
		if ((val = values.get("projectAdvance")) != null)
			setProjectAdvance(__getDecimal(val));
		if ((val = values.get("qualityFee")) != null)
			setQualityFee(__getDecimal(val));
		if ((val = values.get("companyFee")) != null)
			setCompanyFee(__getDecimal(val));
		if ((val = values.get("violationCharges")) != null)
			setViolationCharges(__getDecimal(val));
	}

	protected java.lang.Integer __plate_id;
	protected java.math.BigDecimal __achieve_integral;
	protected java.math.BigDecimal __project_settlement;
	protected java.math.BigDecimal __company_subsidy;
	protected java.math.BigDecimal __employee_achieve_integral_return;
	protected java.math.BigDecimal __salary_return;
	protected java.math.BigDecimal __salary_advance;
	protected java.math.BigDecimal __manager_project_integral;
	protected java.math.BigDecimal __plate_cost;
	protected java.math.BigDecimal __project_advance;
	protected java.math.BigDecimal __quality_fee;
	protected java.math.BigDecimal __company_fee;
	protected java.math.BigDecimal __violation_charges;
}
