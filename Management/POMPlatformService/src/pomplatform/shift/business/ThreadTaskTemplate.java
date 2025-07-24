package pomplatform.shift.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseThreadTaskManage;

import delicacy.common.BaseCollection;
import pomplatform.payment.business.OnPaymentManageProcess;

public class ThreadTaskTemplate extends Thread {

	private Integer threadTaskManageId;

	private Integer taskType;

	private Map<String, Object> params;

	@Override
	public void run() {
		try {
			ThreadTaskUtils.startThreadTask(this.threadTaskManageId);
			switch (this.taskType) {
			case 1:// 月考勤统计
				OnShiftManageProcess.onEmployeeMonthCheck(this.params);
				break;
			case 2:// 日薪推送
				OnPaymentManageProcess.onSendEmpDayPayment(this.params);
				break;
			case 3:// 日薪统计
				OnPaymentManageProcess p = new OnPaymentManageProcess();
				p.onResetEmpDayPayment(this.params);
				break;
			case 4:// 员工排班
				OnShiftManageProcess s = new OnShiftManageProcess();
				s.onSaveEmployeeShift(this.params);
				break;
			}
			// 成功执行完成 根据线程任务管理Id将记录任务结束时间与改变任务状态
			ThreadTaskUtils.completeThreadTask(this.threadTaskManageId);
		} catch (Exception e) {
			e.printStackTrace();
			String errorMsg = e.getMessage();
			ThreadTaskUtils.cancelThreadTask(this.threadTaskManageId, errorMsg);
		}
	}

	public ThreadTaskTemplate(Map<String, Object> params, Integer taskType, Integer threadTaskManageId) {
		this.params = params;
		this.taskType = taskType;
		this.threadTaskManageId = threadTaskManageId;
	}

	public static String runThreadTask(Map<String, Object> params, int taskType, Integer operator,
			Integer operationType) throws Exception {
		int status = 1;
		String errorMessage = null;
		BaseCollection<BaseThreadTaskManage> bc = new BaseCollection<>();
		BaseThreadTaskManage bean = new BaseThreadTaskManage();
		if (ThreadTaskUtils.checkThreadTask(taskType)) {
			BaseThreadTaskManage threadTaskManage = ThreadTaskUtils.newThreadTask(taskType, operator, operationType);
			ThreadTaskTemplate th = new ThreadTaskTemplate(params, taskType, threadTaskManage.getThreadTaskManageId());
			th.start();
			errorMessage = String.format("任务进行中，根据任务ID[%1$s]去查询任务进度。", threadTaskManage.getThreadTaskManageId());
		} else {
			status = -1;
			errorMessage = String.format("任务类型[%1$s]已有正在运行的任务,请稍后再试。详情请去任务列表页面查看", getTaskTypeStr(taskType));
		}
		List<BaseThreadTaskManage> list = new ArrayList<>();
		list.add(bean);
		bc.setCollections(list);
		return bc.toJSON(status, errorMessage);
	}

	private static String getTaskTypeStr(Integer taskType) {
		String taskTypeStr = "";
		switch (taskType) {
		case 1:
			taskTypeStr = "月考勤统计";
			break;
		case 2:
			taskTypeStr = "日薪推送";
			break;
		case 3:
			taskTypeStr = "日薪统计";
			break;
		case 4:
			taskTypeStr = "员工排班";
			break;
		}
		return taskTypeStr;
	}

}
