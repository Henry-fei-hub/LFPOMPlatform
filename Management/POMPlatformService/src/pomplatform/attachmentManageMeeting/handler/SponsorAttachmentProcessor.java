package pomplatform.attachmentManageMeeting.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAttachmentManage;
import com.pomplatform.db.bean.BaseAttachmentManageMeeting;
import com.pomplatform.db.dao.AttachmentManage;
import com.pomplatform.db.dao.AttachmentManageMeeting;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;
import pomplatform.attachment.bean.BaseOnLoadAttachmentDataOfAttachment;
import pomplatform.attachment.bean.ConditionOnLoadAttachmentDataOfAttachment;
import pomplatform.attachment.query.QueryOnLoadAttachmentDataOfAttachment;

public class SponsorAttachmentProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";
	// 发起确认函
	private static final String INSERT_DATA = "insertData";
	// 发布确认函
	private static final String PUBLISH_ATTACHMENT = "publishAttachment";
	// 提交确认函
	private static final String SUBMIT_ATTACHMENT = "submitAttachment";
	// 定稿
	private static final String END_ATTACHMENT = "endAttachment";
	// 修改
	private static final String UPDATE_ATTACHMENT = "updateAttachment";
	// 撤销
	private static final String REVOKE_ATTACHMENT = "revokeAttachment";
	// 获取确认函最近的发起时间
	private static final String DATE_ATTACHMENT = "dateAttachment";
	// 确认函删除
	private static final String DELETE_ATTACHMENT = "deleteAttachment";

	// 回收确认函
	private static final String UPDATE_ATTACHMENT_CONFRIMATIONlETTER = "isConfirmationLetter";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {

		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		String dateAttachment = BaseHelpUtils.getStringValue(params, DATE_ATTACHMENT);
		String first = BaseHelpUtils.getStringValue(params, "first");

		if (!BaseHelpUtils.isNullOrEmpty(dateAttachment)) {
			return getDate();
		}
		switch (optType) {
		case INSERT_DATA:
			if (BaseHelpUtils.isNullOrEmpty(first)) {
				endAttachment(params);
			}
			return insertAttachmentManageMeeting(params);
		case PUBLISH_ATTACHMENT:
			return publishAttachment(params);
		case SUBMIT_ATTACHMENT:
			return submitAttachment(params);
		case END_ATTACHMENT:
			return endAttachment(params);
		case UPDATE_ATTACHMENT:
			return updateAttachment(params);
		case REVOKE_ATTACHMENT:
			return revokeAttachment(params);
		case DELETE_ATTACHMENT:
			return deleteAttachment(params);
		case UPDATE_ATTACHMENT_CONFRIMATIONlETTER:
			return upadteAttachmentConfirmationLetter(params);
		default:
			return null;
		}

	}

	/**
	 * 回收确认函
	 * @param params
	 * @return
	 */
	private String upadteAttachmentConfirmationLetter(Map<String, Object> params) throws Exception{
		BaseCollection bc = new BaseCollection<>();
		AttachmentManage dao = new AttachmentManage();

		dao.setAttachmentManageId( BaseHelpUtils.getIntValue(params, "attachmentManageId"));
		if(dao.load()){
			boolean confirmationLetter = BaseHelpUtils.getBoolean(BaseHelpUtils.getStringValue(params, "confirmationLetter"));
			dao.setConfirmationLetter(confirmationLetter);
			int i = dao.update();
			if(i>0){
				return bc.toJSON(1,null);
			}else {
				return bc.toJSON(-1,"回收确认函失败");
			}
		}

		return bc.toJSON(-1,"找不到该订单");
	}

	/**
	 * 确认函表与attachment_manage_meeting关联查数据（发起确认函）
	 * 
	 * @return
	 * @throws Exception 
	 */
	public String insertAttachmentManageMeeting(Map<String, Object> params) throws Exception {
		ConditionOnLoadAttachmentDataOfAttachment c = new ConditionOnLoadAttachmentDataOfAttachment();
		Map<String, Object> result = params;
		c.setDataFromMap(result);
		System.out.println("result ======= " + result.toString());
		String reSql = "AND a.contract_id IN (SELECT contract_id FROM projects WHERE project_manage_id in (replace))";
		KeyValuePair kv = new KeyValuePair();
		int type = BaseHelpUtils.getIntValue(result, "type");
		int checkEmployeeId = BaseHelpUtils.getIntValue(result, "checkEmployeeId");
		int employeeId = BaseHelpUtils.getIntValue(result, "employeeId");
		if(type == 1){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				kv.setKey(reSql);
				kv.setValue("");
			}
		}else if(type == 2){
			if(checkEmployeeId > 0){
				kv.setKey("replace");
				kv.setValue(checkEmployeeId + "");
			}else{
				List<BaseEmployee> list = new ArrayList<>();
				Employee emDao = new Employee();
				emDao.setEmployeeId(employeeId);
				if(emDao.load()){
					Integer departmentId = emDao.getDepartmentId();
					if(null != departmentId){
						emDao.clear();
						list = emDao.conditionalLoad(" department_id in (SELECT child_id FROM department_ids WHERE department_id = " + departmentId + ")");
						
					}
				}
				String ids = "";
				for (int i = 0; i < list.size(); i++) {
					if(i != 0){
						ids += ",";
					}
					ids += list.get(i).getEmployeeId();
				}
				kv.setKey("replace");
				kv.setValue(ids);
			}
		}else if(type == 3){
			kv.setKey("replace");
			kv.setValue(checkEmployeeId + "");
		}
		KeyValuePair[] replacements = new KeyValuePair[3];
		replacements[0] = kv;
		
		KeyValuePair kv1 = new KeyValuePair();
		kv1.setKey("replce11");
		if (null!=result.get("contractStatusM")) {
			kv1.setValue(" b.contract_status in "+BaseHelpUtils.getString(result.get("contractStatusM")));
		}else{
			kv1.setValue(" 1=1");
		}
		replacements[1] = kv1;
		
		KeyValuePair kv2 = new KeyValuePair();
		kv2.setKey("replce12");
		if(null == result.get("checkAmount")){
			kv2.setValue(" 1 = 1 ");
		}else{
			boolean checkAmount = BaseHelpUtils.getBoolean(result.get("checkAmount"));
			if(checkAmount){
				kv2.setValue(" ( A.return_amount = C.invoice_amount AND A.return_amount > 0 ) ");
			}else{
				kv2.setValue(" ( A.return_amount <> C.invoice_amount OR A.return_amount ISNULL OR C.invoice_amount ISNULL )");
			}
		}
		replacements[2] = kv2;
		
		c.setKeyValues(replacements);
		
		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> resultData = executeQueryOnLoadAttachmentDataOfAttachment(c, c.getKeyValues());
		resultData.getCollections();
		
		
		
		BaseCollection<BaseAttachmentManageMeeting> bc = new BaseCollection<>();
		
		List<BaseOnLoadAttachmentDataOfAttachment> amList = resultData.getCollections();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		BaseAttachmentManageMeeting bammBean = null;
		BaseAttachmentManage amBean=null;
		if (BaseHelpUtils.isNullOrEmpty(amList)) {
			return bc.toJSON(-1, "没有数据可以发起");
		}
		for (BaseOnLoadAttachmentDataOfAttachment baseAttachmentManage : amList) {
			if (baseAttachmentManage.getInvoiceAmount().compareTo(baseAttachmentManage.getReturnAmount())<1) {
				continue;
			}
			AttachmentManage amDao=new AttachmentManage();
			amDao.setConditionAttachmentManageId("=",baseAttachmentManage.getAttachmentManageId());
			amBean = amDao.executeQueryOneRow();
			bammBean = new BaseAttachmentManageMeeting();
			bammBean.setOperator(baseAttachmentManage.getOperateEmployeeId());
			bammBean.setAttachmentManageId(baseAttachmentManage.getAttachmentManageId());
			bammBean.setContractId(baseAttachmentManage.getContractId());
			//bammBean.setNeedReturnAmount(baseAttachmentManage.getAmount().subtract(baseAttachmentManage.getReturnAmount()));
			bammBean.setMettingStatus(1);
			bammBean.setOperatorStatus(1);
			bammBean.setProjectManageId(amBean.getProjectManageId());
			bammBean.setYear(BaseHelpUtils.getIntValue(getYearWeek().get("year")));
			bammBean.setWorkNum(BaseHelpUtils.getIntValue(getYearWeek().get("week")));
			bammBean.setStartDate(new Date());
			dao.setDataFromBase(bammBean);
			dao.save();
		}
		return bc.toJSON(1, null);

	}
	public static BaseCollection<BaseOnLoadAttachmentDataOfAttachment> executeQueryOnLoadAttachmentDataOfAttachment(ConditionOnLoadAttachmentDataOfAttachment c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAttachmentDataOfAttachment dao = new QueryOnLoadAttachmentDataOfAttachment();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAttachmentDataOfAttachment> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	/**
	 * 发布确认函
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public String publishAttachment(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		String companyWeixin=null;
		Employee eDao = new Employee();
		List<BaseEmployee> eList =eDao.conditionalLoad();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setConditionMettingStatus("=", 1);
		List<BaseAttachmentManageMeeting> list=dao.conditionalLoad();
		int num=0;
		for (BaseAttachmentManageMeeting baseAttachmentManageMeeting : list) {
			Integer ProjectManageIdpro=baseAttachmentManageMeeting.getProjectManageId();
			if (BaseHelpUtils.isNullOrEmpty(ProjectManageIdpro)) {
				continue;
			}
			for (BaseAttachmentManageMeeting baseAttachmentManageMeeting1 : list) {
				if (ProjectManageIdpro==baseAttachmentManageMeeting1.getProjectManageId()) {
					num++;
				}
			}
			companyWeixin=getCompanyWeixin(baseAttachmentManageMeeting.getProjectManageId(), eList);
			if (!BaseHelpUtils.isNullOrEmpty(companyWeixin)) {
				ERPWeixinUtils.sendTextMsgToUser(companyWeixin,"您好！您有"+num+"条确认函需要回复  ,请登录erp在[运营管理]-->[确认函管理]-->[确认函(会议)]处理。");
			}
		}
		dao.clear();
		dao.setConditionMettingStatus("=", 1);
		dao.setMettingStatus(2);
		dao.setPublishDate(new Date());
		dao.conditionalUpdate();
		return bc.toJSON(1, null);
	}
	
	/**
	 * 根据员工id获取员工的企业微信
	 * @param employeeId
	 * @param eList
	 * @return
	 */
	public String getCompanyWeixin(int employeeId,List<BaseEmployee> eList){
		String companyWeixin = null;
		for (BaseEmployee baseEmployee : eList) {
			if (!BaseHelpUtils.isNullOrEmpty(employeeId)) {
				if (!BaseHelpUtils.isNullOrEmpty(baseEmployee.getEmployeeId())) {
					if (employeeId==baseEmployee.getEmployeeId()) {
						companyWeixin=baseEmployee.getCompanyWeixin();
						break;
					}
				}
			}
		}
		return  companyWeixin;
	}

	/**
	 * 提交确认函
	 * 
	 * @param params
	 * @return
	 * @throws Exception 
	 */
	public String submitAttachment(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();

		dao.setConditionProjectManageId("=", BaseHelpUtils.getIntValue(params, "projectManageId"));
		dao.setConditionMettingStatus("=", 2);
		List<BaseAttachmentManageMeeting> list = dao.conditionalLoad();
		int num=0;
		for (BaseAttachmentManageMeeting baseAttachmentManageMeeting : list) {
			
			if (baseAttachmentManageMeeting.getOperatorStatus() == 2) {
				num++;
				if (list.size()==num) {
					//return "没有可提交的数据";
					return bc.toJSON(-1, "没有可提交的数据");
				}
			}
			if (BaseHelpUtils.isNullOrEmpty(baseAttachmentManageMeeting.getExpectReturnDate())
					&& BaseHelpUtils.isNullOrEmpty(baseAttachmentManageMeeting.getRemark())) {
				return bc.toJSON(-1, "您填写的信息不完善，请核对后再提交");
			}
			if (BaseHelpUtils.isNullOrEmpty(baseAttachmentManageMeeting.getNeedReturnAmount())
					&& BaseHelpUtils.isNullOrEmpty(baseAttachmentManageMeeting.getRemark())) {
				return bc.toJSON(-1, "您填写的信息不完善，请核对后再提交");
			}
		}
		for (BaseAttachmentManageMeeting baseAttachmentManageMeeting : list) {
			if (baseAttachmentManageMeeting.getOperatorStatus() == 1) {
				dao.clear();
				dao.setConditionOperatorStatus("=", 1);
				dao.setConditionProjectManageId("=", BaseHelpUtils.getIntValue(params, "projectManageId"));
				dao.setConditionMettingStatus("=", 2);
				dao.setOperatorStatus(2);
				dao.setSubmitDate(new Date());
				dao.conditionalUpdate();
				ERPWeixinUtils.sendTextMsgToUser("qy01198a3d6874ac0028db2e5ac8|qy012f8aaf6874ac0028482d17f8|qy01128ac86864ac0028067a0211","您好！有新的确认函提交  ,请登录erp在[运营管理]-->[确认函管理]-->[确认函(会议)]处理。");
				return bc.toJSON(1, null);
			}

		}
		return bc.toJSON(-1, "没有可提交的数据");
	}

	/**
	 * 定稿
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String endAttachment(Map<String, Object> params) throws SQLException {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setConditionMettingStatus("!=", 3);
		dao.setMettingStatus(3);
		dao.setEndDate(new Date());
		dao.conditionalUpdate();
		dao.clear();
		dao.setConditionOperatorStatus("=", 1);
		dao.setOperatorStatus(3);
		dao.conditionalUpdate();
		return bc.toJSON(1, null);
	}

	/**
	 * 修改
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	public String updateAttachment(String creteria) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		bean.setDataFromJSON(creteria);
		if (bean.getOperatorStatus() == 2) {
			return bc.toJSON(-1, "您已经提交确认函了，不能再次修改内容");
		}
		dao.setDataFromBase(bean);
		dao.update();
		return bc.toJSON(1, null);
	}

	/**
	 * 修改
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String updateAttachment(Map params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.setConditionAttachmentManageMeetingId("=",BaseHelpUtils.getIntValue(params.get("attachmentManageMeetingId")));
		dao.executeQueryOneRow();
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		if (BaseHelpUtils.getIntValue(params.get("operatorStatus")) == 2) {
			if (BaseHelpUtils.getIntValue(params.get("projectManageId"))==BaseHelpUtils.getIntValue(params.get("employeeId"))) {
				return bc.toJSON(-1, "本条确认函您已经提交了，不能再次修改内容");
			}
		}
		
		dao.setProjectManageId(BaseHelpUtils.getIntValue(params.get("projectManageId")));
		
		if (params.containsKey("expectReturnDate")) {
			String expectReturnDate = BaseHelpUtils.getString(params.get("expectReturnDate"));
			if ("kong".equals(expectReturnDate)) {
				dao.setExpectReturnDate(null);
			} else {
				dao.setExpectReturnDate(GenericBase.__getDate(params.get("expectReturnDate")));
			}
		}
		if (params.containsKey("needReturnAmount")) {
			String needReturnAmount = BaseHelpUtils.getString(params.get("needReturnAmount"));
			if ("kong".equals(needReturnAmount)) {
				dao.setNeedReturnAmount(null);
			} else {
				dao.setNeedReturnAmount(BaseHelpUtils.getBigDecimalValue(params.get("needReturnAmount")));
			}
		}
		if (params.containsKey("remark")) {
			String remark = BaseHelpUtils.getString(params.get("remark"));
			if ("kong".equals(remark)) {
				dao.setRemark(null);
			} else {
				dao.setRemark(remark);
			}
		}
		dao.update();
		return bc.toJSON(1, null);
	}

	/**
	 * 撤销
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String revokeAttachment(Map params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		BaseAttachmentManageMeeting bean = new BaseAttachmentManageMeeting();
		dao.setConditionMettingStatus("=", 2);
	     List<BaseAttachmentManageMeeting> list=dao.conditionalLoad("attachment_manage_meeting_id in (" +BaseHelpUtils.getStringValue(params, "ids")+")");
		for (BaseAttachmentManageMeeting baseAttachmentManageMeeting : list) {
			baseAttachmentManageMeeting.setOperatorStatus(1);
			dao.clear();
			dao.setDataFromBase(baseAttachmentManageMeeting);
			dao.update();
		}
	    //dao.setConditionProjectManageId("=", BaseHelpUtils.getIntValue(params, "projectManageId"));
		//Object[] ids=BaseHelpUtils.getStringValue(params, "ids").split(",");
		//dao.addCondition(BaseAttachmentManageMeeting.CS_ATTACHMENT_MANAGE_MEETING_ID, "in", ids);
		// 单条撤销
		//dao.setConditionAttachmentManageMeetingId("=", BaseHelpUtils.getIntValue(params, "attachmentManageMeetingId"));
		//dao.setOperatorStatus(1);
		//dao.conditionalUpdate();
		return bc.toJSON(1, null);
	}

	/**
	 * 删除确认函
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String deleteAttachment(Map params) throws Exception {
		BaseCollection bc = new BaseCollection<>();
		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		dao.delete("attachment_manage_meeting_id in (" +BaseHelpUtils.getStringValue(params, "ids")+")");
		return bc.toJSON(1, null);
	}
	/**
	 * 获取当前时间的year和week
	 * 
	 * @return
	 */
	public Map getYearWeek() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		int week = cl.get(Calendar.WEEK_OF_YEAR);
		cl.add(Calendar.DAY_OF_MONTH, -7);
		int year = cl.get(Calendar.YEAR);
		if (week < cl.get(Calendar.WEEK_OF_YEAR)) {
			year += 1;
		}
		map.put("year", year);
		map.put("week", week);
		return map;
	}

	/**
	 * 获取最近的确认函发起日期
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String getDate() throws SQLException {

		AttachmentManageMeeting dao = new AttachmentManageMeeting();
		List<BaseAttachmentManageMeeting> list = dao.conditionalLoad();
		Date date = new Date(0);
		if (BaseHelpUtils.isNullOrEmpty(list)) {
			return "1";
		}
		for (BaseAttachmentManageMeeting baseAttachmentManageMeeting : list) {
			Date startDate = baseAttachmentManageMeeting.getStartDate();
			if (!BaseHelpUtils.isNullOrEmpty(startDate)) {
				if (!BaseHelpUtils.isNullOrEmpty(date) && date.compareTo(startDate) < 0) {
					date = startDate;
				}
			}

		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;

	}


}
