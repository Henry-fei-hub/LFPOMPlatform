package pomplatform.InspectionReport.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import message.common.ERPWeixinUtils;
import pomplatform.InspectionReport.bean.BaseInspectionReport;
import pomplatform.InspectionReport.bean.ConditionInspectionReport;
import pomplatform.InspectionReport.query.QueryInspectionReport;
import pomplatform.PooledInspectionReport.bean.BasePooledInspectionReport;
import pomplatform.PooledInspectionReport.bean.ConditionPooledInspectionReport;
import pomplatform.PooledInspectionReport.query.QueryPooledInspectionReport;
import pomplatform.reimbursement.bean.BaseSearchReimbursementInfo;
import pomplatform.reimbursement.bean.ConditionSearchReimbursementInfo;
import pomplatform.reimbursement.query.QuerySearchReimbursementInfo;
public class CustomInspectionReport implements GenericProcessor {

	private static final Logger __logger = Logger.getLogger(CustomInspectionReport.class);
	private static final String GET_INSPECTIONREPORT = "getInspectionReport";
	private static final String SENDMSGTODRAFTER = "sendMsgToDrafter";
 
	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_INSPECTIONREPORT:
				return getInspectionReport(result,creteria);
			case SENDMSGTODRAFTER:
				return sendMsgToDrafter(result,creteria);
			}
		}
		return null;
	}
	 
	public String getInspectionReport(Map<String, Object> result,String creteria) throws Exception {
		int isVal=-1;
		ConditionInspectionReport c = new ConditionInspectionReport();
		c.setDataFromJSON(creteria);
		QueryInspectionReport dao = new QueryInspectionReport();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseInspectionReport> res = dao.executeQuery( c.getKeyValues(), c) ;
		List<BaseInspectionReport> l=res.getCollections();
		if(l.size()>0){
			isVal=1;
		}else{
			ConditionPooledInspectionReport cp = new ConditionPooledInspectionReport();
			cp.setDataFromJSON(creteria);
			QueryPooledInspectionReport daoQuery = new QueryPooledInspectionReport();
			daoQuery.setCurrentPage(c.getCurrentPage());
			daoQuery.setPageLines(c.getPageLines());
			BaseCollection<BasePooledInspectionReport> resPool = daoQuery.executeQuery( cp.getKeyValues(), cp) ;
			List<BasePooledInspectionReport> ll=resPool.getCollections();
			if(ll.size()>0){
				for(BasePooledInspectionReport pool:ll){
					BaseInspectionReport b=new BaseInspectionReport();
					b.setActivityId(pool.getActivityId());
					b.setActivityType(pool.getActivityType());
					b.setBackViewName(pool.getBackViewName());
					b.setBusinessId(pool.getBusinessId());
					b.setBusinessName(pool.getBusinessName());
					b.setCode(pool.getCode());
					b.setEmployeeId(pool.getEmployeeId());
					b.setInstanceActivityCreateTime(pool.getInstanceActivityCreateTime());
					b.setMainActivityId(pool.getMainActivityId());
					b.setInstanceActivityId(pool.getInstanceActivityId());
					b.setInstanceActivityStartTime(pool.getInstanceActivityStartTime());
					b.setNextActivityId(pool.getNextActivityId());
					b.setNodeType(pool.getNodeType());
					b.setOperateTime(pool.getOperateTime());
					b.setProcessActivityId(pool.getProcessActivityId());
					b.setProcessComment(pool.getProcessComment());
					b.setProcessId(pool.getProcessId());
					b.setProcessInstanceActivityId(pool.getProcessActivityId());
					b.setProcessInstanceId(pool.getProcessInstanceId());
					b.setProcessStatus(pool.getProcessStatus());
					b.setProcessType(pool.getProcessType());
					b.setStatus(pool.getStatus());
					b.setType(pool.getType());
					l.add(b);
				}
				isVal=1;
				//重新设值
				res.setCollections(l);
			}
		}
		return res.toJSON(isVal,"本单子没有到你这或者不存在");
	}
	
	public String sendMsgToDrafter(Map<String, Object> result,String creteria) throws Exception {
		String code = BaseHelpUtils.getString(result.get("code"));
		ConditionSearchReimbursementInfo condition = new ConditionSearchReimbursementInfo();
		condition.setCode(code);
		QuerySearchReimbursementInfo query = new QuerySearchReimbursementInfo();
		BaseCollection<BaseSearchReimbursementInfo> bc = query.executeQuery(null, condition);
		if(null != bc.getCollections() && !bc.getCollections().isEmpty()){
			int employeeId = BaseHelpUtils.getIntValue(bc.getCollections().get(0).getEmployeeId());
			ERPWeixinUtils.sendWXMsgToUser(employeeId, "您申请的报销单：" + code + " ERP流程尚未至财务部，请尽快追踪处理，谢谢！");
		}
		return bc.toJSON();
	}
}
