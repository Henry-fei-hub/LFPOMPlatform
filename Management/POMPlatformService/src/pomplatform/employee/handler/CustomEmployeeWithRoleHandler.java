package pomplatform.employee.handler;

import java.util.Date;

import com.pomplatform.db.bean.BaseEmployeeShiftManage;
import com.pomplatform.db.dao.EmployeeShiftManage;
import com.pomplatform.db.dao.ShiftManage;

import delicacy.connection.ThreadConnection;
import delicacy.system.bean.BaseEmployeeWithE;
import delicacy.system.dao.EmployeeWithE;
import pomplatform.shift.business.OnShiftManageProcess;

public class CustomEmployeeWithRoleHandler extends delicacy.system.handler.EmployeeWithEHandler{
	@Override
	public String save(String json) throws Exception {
		ThreadConnection.beginTransaction();
		BaseEmployeeWithE bean = new BaseEmployeeWithE();
		bean.setDataFromJSON(json);
		EmployeeWithE dao = new EmployeeWithE();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		BaseEmployeeShiftManage esmBean = new BaseEmployeeShiftManage();
		esmBean.setDataFromJSON(json);
		ShiftManage sm = new ShiftManage();
		sm.setConditionShiftManageId("=", esmBean.getShiftManageId());
		OnShiftManageProcess osmp = new OnShiftManageProcess();
		osmp.commonEmployeeShiftSave(dao.getEmployeeName(), dao.getEmployeeId(), new Date(), sm.executeQueryOneRow().getEndDate(), esmBean.getShiftManageId(), esmBean.getOperateEmployeeId());
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}
}
