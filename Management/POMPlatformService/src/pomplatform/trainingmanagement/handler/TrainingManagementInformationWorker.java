package pomplatform.trainingmanagement.handler;

import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import delicacy.QRcode.QRCodeUtil;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.connection.ThreadUtil;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import delicacy.wx.WeixinStatics;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;

import com.file.db.dao.FileManage;
import com.pomplatform.db.bean.BaseDepartment;
import com.pomplatform.db.bean.BaseTrainingManagement;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.TrainingManagement;

public class TrainingManagementInformationWorker implements GenericWorkflowProcessor {

	protected BaseTrainingManagement bean = new BaseTrainingManagement();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		String plateids = bean.getPlateids();
        String str = replaceBlank(plateids);
		if(!BaseHelpUtils.isNullOrEmpty(str)) {
			String replace = str.replace("[", "").replace("]", "").trim();
			bean.setPlateids(replace);
		}
		TrainingManagement dao = new TrainingManagement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		int traningManagementID = dao.getTrainingManagementId();
		QRCodeUtil qrCodeUtil = new QRCodeUtil();
		//生成不带LOGO的二维码http://47.106.186.143:8888/#main
		String textt = "https://2001.cube-architects.com/minindex.html?state=id_"+traningManagementID+"__msgType_3__type_1"; 
		String url = ThreadUtil.getRealPath();
		String imagePath = QRCodeUtil.encode(textt, url, true);
		FileManage fmDao = new FileManage();
		fmDao.setFileUrl(imagePath);
		fmDao.save();
		dao.setFileManageId(fmDao.getFileId());
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getTrainingManagementId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		String s = bean.getPlateids();
        String replaces = replaceBlank(s);
		if(!BaseHelpUtils.isNullOrEmpty(replaces)) {
			String replace = replaces.replace("[", "").replace("]", "").trim();
			bean.setPlateids(replace);
		}
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}
		TrainingManagement dao = new TrainingManagement();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		if(completed){
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				Integer isSend = dao.getIsSend();
				if(isSend==0) {//推送消息
					String[] plateids = dao.getPlateids().split(",");
					if(plateids.length>0) {
						Employee eDao =new Employee();
						Integer[] a =new Integer[plateids.length];
						for (int i = 0; i < plateids.length; i++) {
							a[i]=BaseHelpUtils.getIntValue(plateids[i]);
						}
						eDao.setStatus(0);
						eDao.addCondition("plate_id", "in", a);
						List<BaseEmployee> conditionalLoad = eDao.conditionalLoad();
						if(conditionalLoad.size()>0) {
							String companyWeixin ="";
							//举办部门
							Integer departmentId = dao.getDepartmentId();
							String department="";
							Department dDao =new Department();
							dDao.clear();
	            			dDao.setConditionDepartmentId("=", departmentId);
	            			BaseDepartment baseDepartment = dDao.executeQueryOneRow();
	            			if(!BaseHelpUtils.isNullOrEmpty(baseDepartment)) {
	            				department=	baseDepartment.getDepartmentName();
	            			}
							//主题
							String subject = dao.getSubject();
							//主持人
							Integer compereType = dao.getCompereType();
							String employeeName =dao.getCompere();
							//时间
							SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
							String startTime = sdf.format(dao.getStartTime());
							String endTime = sdf.format(dao.getEndTime());
							String date = startTime+"至"+endTime;
							//培训地点
							String site = dao.getSite();
							//推送消息内容
							String str = String.format(WeixinStatics.MSG_TRAINING_NOTICE, department,subject,employeeName,date,site);
							List<String> wxList = new ArrayList<>();
							for (BaseEmployee baseEmployee : conditionalLoad) {
								companyWeixin = baseEmployee.getCompanyWeixin();
								if(!BaseHelpUtils.isNullOrEmpty(companyWeixin)) {
									wxList.add(companyWeixin);
								}
							}
//							ERPWeixinUtils.sendTextMsgToUser(companyWeixin, str);
							ERPWeixinUtils.sendWXMsgToUser(str, wxList.toArray());
						}
					}
				}
			}
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getTrainingManagementId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		TrainingManagement dao = new TrainingManagement();
		dao.setTrainingManagementId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}
	
	public static void main(String[] args) throws SQLException {
		//推送消息
		String str ="19, 20";
//		String[] plateids = dao.getPlateids().split(",");
		String[] plateids =str.split(",");
		String replaceBlank = replaceBlank(str);
		System.out.println(str+"=========="+replaceBlank);
				
		/*if(plateids.length>0) {
			Employee eDao =new Employee();
			Integer[] a =new Integer[plateids.length];
			for (int i = 0; i < plateids.length; i++) {
				a[i]=BaseHelpUtils.getIntValue(plateids[i]);
			}
			eDao.addCondition("plate_id", "in", a);
			eDao.setStatus(0);
			List<BaseEmployee> conditionalLoad = eDao.conditionalLoad();
			if(conditionalLoad.size()>0) {
				String companyWeixin ="";
				//举办部门
				Integer departmentId = 19;
				String department="";
				Department dDao =new Department();
				dDao.clear();
    			dDao.setConditionDepartmentId("=", departmentId);
    			BaseDepartment baseDepartment = dDao.executeQueryOneRow();
    			if(!BaseHelpUtils.isNullOrEmpty(baseDepartment)) {
    				department=	baseDepartment.getDepartmentName();
    			}
				//主题
				String subject ="测试";
				//主持人
				String employeeName ="";
				Integer compereType =1;
					employeeName="";
				//时间
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
				String startTime ="2015-10-10 17:00:00";
				String endTime ="2015-10-10 18:00:00";
				String date = startTime+"至"+endTime;
				//培训地点
				String site = "大培训室";
				//推送消息内容
				String str = String.format(WeixinStatics.MSG_TRAINING_NOTICE, department,subject,employeeName,date,site);
				for (BaseEmployee baseEmployee : conditionalLoad) {
					companyWeixin = baseEmployee.getCompanyWeixin();
					if(!BaseHelpUtils.isNullOrEmpty(companyWeixin)) {
						ERPWeixinUtils.sendTextMsgToUser(companyWeixin, str);
					}
				}
			}
		}
	*/
	}
	
	public static String replaceBlank(String str) {
		String dest = "";
		if (str!=null) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

}
