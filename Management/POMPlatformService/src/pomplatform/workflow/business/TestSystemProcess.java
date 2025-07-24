package pomplatform.workflow.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.ThreadTaskManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;

public class TestSystemProcess implements GenericProcessor {
	private static Logger __logger = Logger.getLogger("");
  	
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch(optType) {
		case "testByProcessId":
			return testByProcessId(params);
		case "testAllProcess":
			return testAllProcess(params);
		}
		return null;
	}
	
	public String testByProcessId(Map<String, Object> params) throws Exception{
		Integer threadId = saveThreadTask(params);
		TestProcessThread thread = new TestProcessThread();
		thread.setThreadId(threadId);
		thread.setProcessId(BaseHelpUtils.getStringValue(params, "processId"));
		thread.start();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, String.format("任务ID：%1$s正在执行中，请在流程测试结果页面查看详细数据", threadId));
	}
	
	public String testAllProcess(Map<String, Object> params) throws Exception{
		Integer threadId = saveThreadTask(params);
		TestProcessThread thread = new TestProcessThread();
		thread.setThreadId(threadId);
		thread.start();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, String.format("任务ID：%1$s正在执行中，请在流程测试结果页面查看详细数据", threadId));
	}
	
	public Integer saveThreadTask(Map<String, Object> params) throws SQLException{
		ThreadTaskManage dao = new ThreadTaskManage();
		dao.setTaskType(StaticUtils.THREAD_TASK_TYPE_5);
		dao.setStatus(StaticUtils.THREAD_TASK_MANAGE_STATUS_0);
		dao.setOperator(BaseHelpUtils.getIntValue(params.get("operator")));
		dao.setOperationType(1);
		dao.setBeginTime(new Date());
		dao.setCreateTime(new Date());
		dao.save();
		return dao.getThreadTaskManageId();
	}
	
}
