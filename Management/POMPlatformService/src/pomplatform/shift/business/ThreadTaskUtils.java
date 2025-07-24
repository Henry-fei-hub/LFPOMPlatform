package pomplatform.shift.business;

import java.sql.SQLException;
import java.util.Date;

import com.pomplatform.db.bean.BaseThreadTaskManage;
import com.pomplatform.db.dao.ThreadTaskManage;

public class ThreadTaskUtils {
	
	/**
	 * 任务类型:手动创建
	 */
	public final static int OPERATION_TYPE_ONE = 1;
	
	/**
	 * 任务类型:系统创建
	 */
	public final static int OPERATION_TYPE_TWO = 2;
	
	/**
	 * 月考勤统计
	 */
	public final static int TASK_TYPE_ONE = 1;
	
	/**
	 * 日薪推送
	 */
	public final static int TASK_TYPE_TWO = 2;
	
	/**
	 * 日薪统计
	 */
	public final static int TASK_TYPE_THREE = 3;
	
	/**
	 * 员工排班
	 */
	public final static int TASK_TYPE_FOUR = 4;
	
	/**
	 * 新建
	 */
	private final static int STATUS_ZERO = 0;
	
	/**
	 * 运行中
	 */
	private final static int STATUS_ONE = 1;
	
	/**
	 * 完成
	 */
	private final static int STATUS_TWO = 2;
	
	/**
	 * 失败
	 */
	private final static int STATUS_THREE = 3;
	
	/**
	 * 记录一个线程任务
	 * @param taskType
	 * @param operator
	 * @param operationType
	 * @return
	 * @throws Exception
	 */
	public static BaseThreadTaskManage newThreadTask(Integer taskType, Integer operator, Integer operationType) throws Exception{
		Date currentDate = new Date();
		ThreadTaskManage ttmDao = new ThreadTaskManage();
		ttmDao.setCreateTime(currentDate);
		ttmDao.setOperator(operator);
		ttmDao.setOperationType(operationType);
		ttmDao.setTaskType(taskType);
		ttmDao.setStatus(STATUS_ZERO);
		ttmDao.save();
		return ttmDao.generateBase();
	}
	
	/**
	 * 开始任务
	 * @param threadTaskManageId
	 * @throws Exception
	 */
	public static void startThreadTask(Integer threadTaskManageId) throws Exception{
		if(null != threadTaskManageId){
			Date currentDate = new Date();
			ThreadTaskManage ttmDao = new ThreadTaskManage();
			ttmDao.setConditionThreadTaskManageId("=", threadTaskManageId);
			ttmDao.setBeginTime(currentDate);
			ttmDao.setStatus(STATUS_ONE);
			ttmDao.conditionalUpdate();
		}
	}
	
	/**
	 * 完成任务
	 * @param threadTaskManageId
	 * @throws Exception
	 */
	public static void completeThreadTask(Integer threadTaskManageId) throws Exception{
		if(null != threadTaskManageId){
			Date currentDate = new Date();
			ThreadTaskManage ttmDao = new ThreadTaskManage();
			ttmDao.setConditionThreadTaskManageId("=", threadTaskManageId);
			ttmDao.setEndTime(currentDate);
			ttmDao.setStatus(STATUS_TWO);
			ttmDao.conditionalUpdate();
		}
	}
	
	/**
	 * 任务失败/取消任务
	 * @param threadTaskManageId
	 * @param errorMsg
	 * @throws Exception
	 */
	public static void cancelThreadTask(Integer threadTaskManageId, String errorMsg) {
		try {
			if(null != threadTaskManageId){
				Date currentDate = new Date();
				ThreadTaskManage ttmDao = new ThreadTaskManage();
				ttmDao.setConditionThreadTaskManageId("=", threadTaskManageId);
				ttmDao.setEndTime(currentDate);
				ttmDao.setStatus(STATUS_THREE);
				ttmDao.setErrorMsg(errorMsg);
				ttmDao.conditionalUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean checkThreadTask(Integer taskType) throws SQLException{
		ThreadTaskManage ttmDao = new ThreadTaskManage();
		ttmDao.setConditionTaskType("=", taskType);
		ttmDao.addCondition(BaseThreadTaskManage.CS_STATUS, "in", STATUS_ZERO, STATUS_ONE);
		if(ttmDao.countRows() > 0){
			return false;
		}else{
			return true;
		}
	}
	
}
