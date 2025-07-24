package delicacy.oa;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import delicacy.common.BaseCollection;
import delicacy.common.KeyValuePair;
import delicacy.system.dao.Employee;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.employee.bean.BaseInServiceEmployeeResignationInfo;
import pomplatform.employee.bean.ConditionInServiceEmployeeResignationInfo;
import pomplatform.employee.query.QueryInServiceEmployeeResignationInfo;

public class InServiceEmployeeResignationTask extends TimerTask {

	@Override
	public void run() {
		try {
			ConditionInServiceEmployeeResignationInfo condition = new ConditionInServiceEmployeeResignationInfo();
			condition.setStatus(StaticUtils.EMPLOYEE_NORMAL);
			KeyValuePair[] arr = new KeyValuePair[1];
			KeyValuePair keyValue = new KeyValuePair();
			keyValue.setKey("c.process_status = ?");
			keyValue.setValue(String.format("c.process_status = ? and c.process_status in (%1$s, %2$s)", SystemProcessConstants.PROCESS_STATUS_NEW_CREATED, SystemProcessConstants.PROCESS_STATUS_WORKING));
			arr[0] = keyValue;
			QueryInServiceEmployeeResignationInfo query = new QueryInServiceEmployeeResignationInfo();
			BaseCollection<BaseInServiceEmployeeResignationInfo> bc = query.executeQuery(arr, condition);
			if(null == bc) {
				return;
			}
			List<BaseInServiceEmployeeResignationInfo> list = bc.getCollections();
			if(null == list || list.isEmpty()) {
				return;
			}
			Date date = new Date();
			for(BaseInServiceEmployeeResignationInfo obj : list) {
				if(null != obj.getEmployeeId() && obj.getEndDate().before(date)) {
					Employee eDao = new Employee();
					eDao.setConditionEmployeeId("=", obj.getEmployeeId());
					eDao.setStatus(StaticUtils.EMPLOYEE_DIMISSION);
					eDao.setResignationDate(obj.getEndDate());
					eDao.conditionalUpdate();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
