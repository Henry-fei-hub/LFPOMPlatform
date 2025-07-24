package pomplatform.employee.handler;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.employee.bean.BaseLoginEmployeeInfo;
import delicacy.employee.bean.BaseMemployeeerfeaor;
import delicacy.employee.bean.ConditionLoginEmployeeInfo;
import delicacy.employee.bean.ConditionMemployeeerfeaor;
import delicacy.employee.query.QueryLoginEmployeeInfo;
import delicacy.employee.query.QueryMemployeeerfeaor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.dao.Employee;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.dao.SystemLog;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;
import delicacy.system.executor.EmployeeWithRoleFunction;
import delicacy.system.executor.SystemProcessConstants;
import message.common.ERPWeixinUtils;
import message.common.WeixinUtils;
import pomplatform.common.utils.StaticUtils;

public class CheckUserinfoToLoginProcess implements GenericProcessor{
	
	private final static String CHECK_USERINFO_BY_CODE = "checkUserinfoByCode";//根据微信后台返回的code信息获取员工信息
	
	private final static String CHECK_PROCESS_BY_PROCESSINSTANCEID = "checkProcessByProcessInstanceId";//检测PC端生成的复制链接
	
	private final static String CREATE_QUICK_LINK_TO_PROCESS = "createQuickLinkToProcess";//创建流程快速审批链接

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
			case CHECK_USERINFO_BY_CODE:
				return checkUserinfoByCode(result, request);
			case CHECK_PROCESS_BY_PROCESSINSTANCEID:
				return checkProcessByProcessInstanceId(result);
			case CREATE_QUICK_LINK_TO_PROCESS:
				return createQuickLinkToProcess(result);
			}
		}
		return null;
	}
	
	private String createQuickLinkToProcess(Map<String, Object> params) throws SQLException, UnsupportedEncodingException{
		StringBuilder sb = new StringBuilder();

		int processInstanceId = BaseHelpUtils.getIntValue(params, "processInstanceId");
		String paramStr = "processInstanceId_" + processInstanceId + "__" + "msgType_1";
		sb.append("http://erp.jaid.cn/minindex.html?")
			.append("state=")
			.append(paramStr);
		
//		String redirectUrl = URLEncoder.encode("http://erp.jaid.cn/minindex.html", "UTF-8");		
//		sb.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=")
//			.append(WeixinUtils.CORP_ID)
//			.append("&redirect_uri=")
//			.append(redirectUrl)
//			.append("&response_type=code&scope=snsapi_base&agentid=")
//			.append(WeixinUtils.AGENTID)
//			.append("&state=")
//			.append(paramStr)
//			.append("&connect_redirect=1#wechat_redirect");
		return sb.toString();
	}
	
	private String checkProcessByProcessInstanceId(Map<String, Object> params) throws SQLException{
		int status = 1;
		String errorMsg = "";
		int processInstanceId = BaseHelpUtils.getIntValue(params, "processInstanceId");
		int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
		
		SystemProcessInstance spiDao = new SystemProcessInstance();
		spiDao.setProcessInstanceId(processInstanceId);
		if(employeeId > 0 && spiDao.load()){
			if(spiDao.getDeleteFlag() == 0){
				if(Objects.equals(spiDao.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_NEW_CREATED)
						|| Objects.equals(spiDao.getProcessStatus(), SystemProcessConstants.PROCESS_STATUS_WORKING)){
					Employee eDao = new Employee();
					SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
					spiaDao.setConditionProcessInstanceId("=", processInstanceId);
					spiaDao.setConditionStatus("=", SystemProcessConstants.ACTIVITY_STATUS_ACTIVE);
					spiaDao.setConditionActivityType(">", 1);
					if(null == spiaDao.executeQueryOneRow()){
						status = -4;
						errorMsg = "该流程已结束";
					}else{
						if(null == spiaDao.getEmployeeId()){//任务池
							SystemProcessPooledTask spptDao = new SystemProcessPooledTask();
							spptDao.setConditionActivityId("=", spiaDao.getActivityId());
							spptDao.setConditionProcessInstanceId("=", processInstanceId);
							spptDao.setConditionStatus("=", SystemProcessConstants.POOLED_TASK_STATUS_ACTIVE);
							spptDao.setConditionEmployeeId("=", employeeId);
							if(null == spptDao.executeQueryOneRow()){
								status = -6;
								errorMsg = "该流程现在你不能操作";
							}else{
								return spptDao.generateBase().toOneLineJSON(status, errorMsg);
							}
						}else{
							if(Objects.equals(employeeId, spiaDao.getEmployeeId())){//为当前人
								return spiaDao.generateBase().toOneLineJSON(status, errorMsg);
							}else{
								eDao.clear();
								eDao.setEmployeeId(spiaDao.getEmployeeId());
								if(eDao.load()){
									status = -5;
									errorMsg = String.format("该流程的正在处理人为(%1$s)", eDao.getEmployeeName());
								}
							}
						}
					}
					
				}else{
					status = -3;
					errorMsg = "该流程已经结束(取消、驳回)";
				}
			}else{
				status = -2;
				errorMsg = "该流程被删除";
			}
			
		}else{
			status = -1;
			errorMsg = "没有找到该流程数据";
		}
		return spiDao.generateBase().toOneLineJSON(status, errorMsg);
	}
	
	private String checkUserinfoByCode(Map<String, Object> params, HttpServletRequest request) throws Exception{
		HttpCookie hc = new HttpCookie(request);
		int status = 0;
		String errorMsg = null;
		String code = BaseHelpUtils.getStringValue(params, "code");
		EmployeeWithRoleFunction ewrf = new EmployeeWithRoleFunction();
		if(!BaseHelpUtils.isNullOrEmpty(code)){
			String wxUserId = ERPWeixinUtils.getUserIdByCode(code);
			if(!BaseHelpUtils.isNullOrEmpty(wxUserId)){
				ConditionLoginEmployeeInfo condition = new ConditionLoginEmployeeInfo();
    			condition.setCompanyWeixin(wxUserId);
    			condition.setStatus(StaticUtils.EMPLOYEE_NORMAL);
    			QueryLoginEmployeeInfo query = new QueryLoginEmployeeInfo();
    			BaseCollection<BaseLoginEmployeeInfo> bc = query.executeQuery(null, condition);
    			if(bc.getRecordNumber() == 0) {
    				throw new SQLException("该企业微信用户未在该系统找到员工信息");
    			}
    			BaseLoginEmployeeInfo bed = bc.getCollections().get(0);
		        // 如果查不到
		        if (bed == null) {
		        	status = -1;
					errorMsg = "该企业微信账号没有绑定ERP账号, 请联系人资管理人员";
					return ewrf.toOneLineJSON(status, errorMsg);
		        }
		        bed.cloneCopy(ewrf);
		        ewrf.setEmployeePassword(null);

		        EmployeeRole er = new EmployeeRole();
		        er.setConditionEmployeeId("=", bed.getEmployeeId());
		        List<BaseEmployeeRole> l = er.conditionalLoad();
		        ewrf.setRoles(l);
		        if (l.size() == 0) {
		            ewrf.setRoleId(-1);
		        } else {

		            for (BaseEmployeeRole baseEmployeeRole : l) {
		                if(baseEmployeeRole.getIsDefault()){
		                    ewrf.setRoleId(baseEmployeeRole.getRoleId());
		                    break;
		                }else{
		                    ewrf.setRoleId(-1);
		                }
		            }
		        }

		        // 查询员工所能操作的功能列表
		        ConditionMemployeeerfeaor c = new ConditionMemployeeerfeaor();
		        c.setEmployeeId(bed.getEmployeeId());
		        if (hc.getApplicationId() != 0) {
		            c.setApplicationId(hc.getApplicationId());
		        }
		        QueryMemployeeerfeaor qdao = new QueryMemployeeerfeaor();
		        BaseCollection<BaseMemployeeerfeaor> fs = qdao.executeQuery(null, c);
		        ewrf.setFunctions(generateFunctionCode(fs));

		        SystemLog sl = new SystemLog();
		        sl.setLogTime(new Date());
		        sl.setOperator(bed.getEmployeeId());
		        sl.setOperatorName(bed.getEmployeeName());
		        sl.setFromHost(request.getRemoteAddr());
		        sl.setLogContent(String.format("%1$s login into system", bed.getEmployeeName()));
		        sl.save();
		        
			}else{
				status = -1;
				errorMsg = "在企业中没有找到该企业微信账户";
			}
			
		}else{
			status = -1;
			errorMsg = "参数错误";
		}
		return ewrf.toOneLineJSON(status, errorMsg);
	}
	
	 private Set<String> generateFunctionCode(BaseCollection<BaseMemployeeerfeaor> fs) {
        Set<String> res = new HashSet<>();
        for (BaseMemployeeerfeaor b : fs.getCollections()) {
            res.add(b.getFunctionCode());
        }
        return res;
    }
	 
//		public static void main(String[] args) throws SQLException {
//		Map<String, Object> params = new HashMap<>();
//		params.put("employeeId", 248);
//		params.put("processInstanceId", 5263);
//		System.out.println(checkProcessByProcessInstanceId(params));
//	}

}
