package pomplatform.reimbursement.bean;

public class BaseSearchReimbursementInfoExport extends BaseSearchReimbursementInfo 
{

	public final static java.lang.String ALL_CAPTIONS = "打包汇总编号,报销编号,预算编号,流程类型,归属公司,编号,费用承担主体,业务部门,申请人,申请人所在部门,货币种类,报销金额,进项税,成本,流程状态,备注,申请时间,完成时间";

	public static BaseSearchReimbursementInfoExport newInstance(){
		return new BaseSearchReimbursementInfoExport();
	}

	@Override
	public BaseSearchReimbursementInfoExport make(){
		BaseSearchReimbursementInfoExport b = new BaseSearchReimbursementInfoExport();
		return b;
	}

	public java.lang.String toCSVString() {

		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getPackageCode() == null ? "" : getPackageCode());
		sb.append(",");
		sb.append(getCode() == null ? "" : getCode());
		sb.append(",");
		sb.append(getBdCode() == null ? "" : getBdCode());
		sb.append(",");
		String strProcessType = delicacy.system.executor.SelectValueCache.getSelectValue("system_process_types", String.valueOf(getProcessType()));
		sb.append(strProcessType == null ? "" : strProcessType);
		sb.append(",");
		String strCompanyId = delicacy.system.executor.SelectValueCache.getSelectValue("company_records", String.valueOf(getCompanyId()));
		sb.append(strCompanyId == null ? "" : strCompanyId);
		sb.append(",");
		sb.append(getBearFeeCode() == null ? "" : getBearFeeCode().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(",", "，"));
		sb.append(",");
		sb.append(getBearFeeName() == null ? "" : getBearFeeName().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(",", "，"));
		sb.append(",");
		String strPlateId = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(getPlateId()));
		sb.append(strPlateId == null ? "" : strPlateId);
		sb.append(",");
		String strEmployeeId = delicacy.system.executor.SelectValueCache.getSelectValue("employees", String.valueOf(getEmployeeId()));
		sb.append(strEmployeeId == null ? "" : strEmployeeId);
		sb.append(",");
		String strDepartmentId = delicacy.system.executor.SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(strDepartmentId == null ? "" : strDepartmentId);
		sb.append(",");		
		String strCurrency = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_40", String.valueOf(getCurrency()));
		sb.append(strCurrency == null ? "" : strCurrency);
		sb.append(",");
		sb.append(getAmount() == null ? "" : getAmount());
		sb.append(",");
		sb.append(getInputTax() == null ? "" : getInputTax());
		sb.append(",");
		sb.append(getFinalAmount() == null ? "" : getFinalAmount());
		sb.append(",");
		String strProcessStatus = delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_120", String.valueOf(getProcessStatus()));
		sb.append(strProcessStatus == null ? "" : strProcessStatus);
		sb.append(",");
		sb.append(getRemark() == null ? "" : getRemark().replaceAll("\r\n", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll(",", "，"));
		sb.append(",");
		sb.append(getCreateTime() == null ? "" : sdf.format(getCreateTime()));
		sb.append(",");
		sb.append(getCompleteTime() == null ? "" : sdf.format(getCompleteTime()));
		return sb.toString();
	}
	
}
