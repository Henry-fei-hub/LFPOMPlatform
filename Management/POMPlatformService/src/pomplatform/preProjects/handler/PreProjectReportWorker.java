package pomplatform.preProjects.handler;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseCustomerContact;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.CustomerContact;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectReimbursementNumber;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.handler.CustomMainContractHandler;

public class PreProjectReportWorker implements GenericWorkflowProcessor {

	protected BasePreProject bean = new BasePreProject();
	private Logger __logger = Logger.getLogger("");

	//重入锁，为防止报销编号重复
	private static Lock lock = new ReentrantLock();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd,Map params, int employeeId) throws Exception {
		PreProject dao = new PreProject();
		bean.setDataFromMap(params);
		if (BaseHelpUtils.getIntValue(params.get("clientId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(params.get("clientId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if(customer.load()) {
				bean.setCustomerName(customer.getCustomerName());
				bean.setClientId(BaseHelpUtils.getIntValue(params.get("clientId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}
		bean.setCreateTime(new Date());
		dao.setDataFromBase(bean);
		dao.save();
		int proProject = dao.getPreProjectId();
//		Object object = params.get("ourEmployees");
//		if (object != null && object != "") {
//			String object2 = object.toString();
//			String employeeString1 = object2.substring(1, object2.length()-1);
//			String employeeString2 = employeeString1.trim();
//			String[] bb = employeeString2.split(",");
//			for (String string : bb) {
//				String str1 = string.trim();
//				int em = Integer.parseInt(str1);
//				MainProjectEmployee maDao = new MainProjectEmployee();
//				maDao.setEmployeeId(em);
//				maDao.setRelation(4);
//				maDao.setPreProjectId(proProject);
//				maDao.setIsPlateManager(true);
//				maDao.save();
//			}
//		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi,Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		//传过来的数据customerName可能是客户的id值（因为是下拉原因）
		if (BaseHelpUtils.getIntValue(params.get("clientId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(params.get("clientId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if(customer.load()) {
				bean.setCustomerName(customer.getCustomerName());
				bean.setClientId(BaseHelpUtils.getIntValue(params.get("clientId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			//获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			//获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			//只有处理节点才可以更改数据
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {//处理节点
				return null;
			}
		}
		PreProject dao = new PreProject();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();

		//项目报备流程完成后，把新增的客户和联系人同步到客户和联系人的表
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				//获取报备项目id
				int preProjectId = dao.getPreProjectId();
				//获取报备人
				int applyEmployeeId = dao.getApplyEmployeeId();

//				Customer cdao = new Customer();
//				String customerName = dao.getCustomerName();
//				int customerId = 0;
				int contactId = 0;
//
//				cdao.setConditionCustomerName("=", customerName);
//				BaseCustomer cbean = cdao.executeQueryOneRow();
//				//保存新客户到客户表
//				if(BaseHelpUtils.isNullOrEmpty(cbean)){
//					cdao.clear();
//					cdao.setCustomerName(customerName);
//					cdao.setType(1);//开发商
//					cdao.setReportEmployeeId(applyEmployeeId);
//					cdao.setCustomerType(3);
//					cdao.setCreateTime(new Date());
//					cdao.save();
//					customerId = cdao.getCustomerId();
//				}else{
//					customerId = cbean.getCustomerId();
//				}

				//获取业务类型数组ID
				String[] businessCategoryIds =BaseHelpUtils.getString(bean.getBusinessTypes()).replaceAll("\\[", "").replaceAll("]", "").replaceAll("\"", "").replaceAll(" ", "").split(",");
				if(!BaseHelpUtils.isNullOrEmpty(businessCategoryIds)){
					MainProjectBusinessType typedao = new MainProjectBusinessType();
					for (int i = 0 ; i<businessCategoryIds.length;i++){
						if(BaseHelpUtils.getIntValue(businessCategoryIds[i])>0) {
							typedao.clear();
							typedao.setBusinessType(BaseHelpUtils.getIntValue(businessCategoryIds[i]));
							typedao.setPreProjectId(bean.getPreProjectId());
							typedao.save();
						}
						
					}
				}
				//保存新联系人到联系人表
				CustomerContact ccdao = new CustomerContact();
				ccdao.setConditionCustomerId("=", bean.getClientId());
				ccdao.setConditionName("=", dao.getContactName());
				String contactPhone = dao.getContactPhone();
				List<BaseCustomerContact> cclist = ccdao.conditionalLoad(" (telephone ='"+contactPhone+"' or mobile = '"+ contactPhone +"')");
				if(BaseHelpUtils.isNullOrEmpty(cclist) && cclist.size() == 0){
					ccdao.clear();
					ccdao.setCustomerId(bean.getClientId());
					ccdao.setEmployeeType(1);//主要联系人
					ccdao.setName(dao.getContactName());
					ccdao.setTelephone(contactPhone);
					ccdao.setGrade(dao.getGrade());//职位
					ccdao.save();
					contactId = ccdao.getCustomerContactId();
				}else{
					contactId = cclist.get(0).getCustomerContactId();
				}

				//保存客户id 和  联系人id 到前期项目表
//				bean.setClientId( bean.getClientId());
				bean.setCustomerContactId(contactId);
				dao.setPrimaryKeyFromBase(bean);
				if(!dao.load()) throw new SQLException("Business data not found");
				dao.setDataFromBase(bean);
				dao.update();

				//默认将报备人设为主要跟进人
				MainProjectEmployee medao = new MainProjectEmployee();
				medao.setPreProjectId(preProjectId);
				medao.setRelation(1);//项目跟进人
				medao.setMainAndAssistance(1);//主要跟进人
				medao.setEmployeeId(applyEmployeeId);
				medao.save();
				
				//项目报备流程结束后自动生成报销项目
				//获取信息编号
				String infoCode = BaseHelpUtils.getString(dao.getInfoCode());
				//获取报备人所在的业务部门
				Employee eDao = new Employee();
				eDao.setEmployeeId(applyEmployeeId);
				if(eDao.load()) {
					//获取报备人的业务部门
					int plateId = BaseHelpUtils.getIntValue(eDao.getPlateId());
					PlateRecord prDao = new PlateRecord();
					prDao.setConditionPlateId("=",plateId);
					BasePlateRecord prBean = prDao.executeQueryOneRow();
					if(!BaseHelpUtils.isNullOrEmpty(prBean)) {
						//获取部门编码
						String plateCode = BaseHelpUtils.getString(prBean.getPlateCode());
						//生成订单编码（信息编号-项目编码(33)-部门编码）
						String sheetCode = getCode(infoCode,plateCode);
						//获取订单名称
						PreProjectReimbursementNumber sheetDao = new PreProjectReimbursementNumber();
						//根据信息该编号查询，如果存在，则不插入
						sheetDao.setConditionCustomNumber("=",sheetCode);
						if(sheetDao.isExist()) {
							__logger.info(String.format("生成报销单异常：该编号(%1$s)已存在",sheetCode));
						}else {
							//找项目经理，即当前报备人所在业务部门的项目经理角色的人
							int projectManageId = CustomMainContractHandler.getManageEmployeeId(plateId, StaticUtils.ROLE_MAIN_PROJECT_MANAGER);
							sheetDao.setMainProjectId(preProjectId);
							sheetDao.setCustomNumber(sheetCode);
							sheetDao.setPlateId(plateId);
							sheetDao.setPreProjectType(StaticUtils.PROJECT_TYPE_33);
							sheetDao.setCreateTime(new Date());
							sheetDao.setRemark(dao.getProjectName());
							sheetDao.setOperator(applyEmployeeId);
							if(projectManageId > 0) {
								sheetDao.setProjectManager(projectManageId);
							}
							sheetDao.save();
						}
						
					}else {
						__logger.info("生成报销单异常：未获取到报备人所在业务部门信息");
					}
				}else {
					__logger.info("生成报销单异常：未加载到报备人的职员信息");
				}
				
			}
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPreProjectId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PreProject dao = new PreProject();
		dao.setPreProjectId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

//		判断是否为整数
//   @param str 传入的字符串
//   @return 是整数返回true,否则返回false


	public static String getCode(String infoCode,String plateCode) throws Exception {
		String code = "";
		if (lock.tryLock()) {//尝试获取锁成功获取则返回true
			try {
				code = String.format("%1$s-%2$s-%3$s", infoCode, "33", plateCode);
				return code;
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				lock.unlock();   //释放锁
			}
		}else{
			throw new Exception("网络繁忙，请稍后重试!");
		}
		return code;
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

}
