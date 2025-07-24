package pomplatform.report.bean;

import delicacy.common.BaseFactory;
import delicacy.common.GenericBase;
import delicacy.system.executor.SelectValueCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BaseEmployeesOrdersCustom extends BaseEmployeesOrders
{

	public final static String ALL_CAPTIONS = "员工编号,员工姓名,所属部门,在职状态,订单编号,订单名称,订单状态";

	public String toCSVString() {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		StringBuilder sb = new StringBuilder();
		sb.append(getEmployeeNo() == null ? "" : getEmployeeNo());
		sb.append(",");
		sb.append(getEmployeeName() == null ? "" : getEmployeeName());
		sb.append(",");
		String departmentId = SelectValueCache.getSelectValue("departments", String.valueOf(getDepartmentId()));
		sb.append(departmentId == null ? "" : departmentId);
		sb.append(",");
		String estatus = SelectValueCache.getSelectValue("system_dictionary_11", String.valueOf(getEstatus()));
		sb.append(estatus == null ? "" : estatus);
		sb.append(",");
		sb.append(getContractCode() == null ? "" : getContractCode());
		sb.append(",");
		sb.append(getProjectName() == null ? "" : getProjectName());
		sb.append(",");
		String pstatus = SelectValueCache.getSelectValue("system_dictionary_4", String.valueOf(getPstatus()));
		sb.append(pstatus == null ? "" : pstatus);
		return sb.toString();
	}
}
