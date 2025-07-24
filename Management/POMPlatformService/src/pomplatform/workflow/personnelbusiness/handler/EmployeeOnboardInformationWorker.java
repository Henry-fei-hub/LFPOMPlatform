package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.bean.BaseEmployeePayment;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.DepartmentRole;
import com.pomplatform.db.dao.Duty;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeContractAttachment;
import com.pomplatform.db.dao.EmployeeDayPlateRecord;
import com.pomplatform.db.dao.EmployeePayment;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.PlateRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.DES;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.date.util.DateUtil;
import delicacy.email.SendEmailUtils;
import delicacy.expression.Expression;
import delicacy.otheraccount.UserAccountUtils;
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
import message.common.OnTelMobile;
import pomplatform.clocks.business.ClockMsgProcess;
import pomplatform.common.utils.AccountUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeByRoleIdAndDepartmentId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeByRoleIdAndDepartmentId;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeByRoleIdAndDepartmentId;
import pomplatform.shift.business.OnShiftManageProcess;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.dao.EmployeeWithEeeee;

public class EmployeeOnboardInformationWorker implements GenericWorkflowProcessor {

	protected BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
	private Logger __logger = Logger.getLogger("");
	private int departmentId;
	private int employeeId;
	/**
	 * 劳动合同
	 */
	private final int CONTRACT_TYPE_0 = 0;
	/**
	 * 新签合同
	 */
	private final int SIGN_TYPE_0 = 0;

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		//新员工入职的部门id
		setDepartmentId(bean.getDepartmentId());
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		dao.setDataFromBase(bean);
		//所属公司
		dao.setCompanyId(BaseHelpUtils.getIntValue(bean.getOwnedCompany()));
		dataValidate(dao, true);
		//用员工编号作为密码
		dao.setEmployeePassword(DES.string2MD5(dao.getEmployeeNo()));
		//所属公司
		dao.setCompanyId(BaseHelpUtils.getIntValue(dao.getOwnedCompany()));
		dao.setStatus(0);//默认设置为在职
		//增加头像、劳动合同附件、身份证附件、职称证明、学历证、学位证，银行卡的引用次数
		FileManageProcessor.addTimesByIds(dao.getPhotoId(), dao.getLaborAttachmentId(), dao.getCardAttachmentId(), dao.getTechnicalAttachmentId(), dao.getEducationProofId(), dao.getDegreeProofId(),dao.getBankCardAttachmentId());
		dao.save();
		//获取职员id
		int empId = dao.getEmployeeId();

		//如果银行卡号不为空，往card_manage表里插入数据
		if(!BaseHelpUtils.isNullOrEmpty(dao.getBankCardNum())){
			CardManage cardDao = new CardManage();
			cardDao.setObjectId(empId);
			cardDao.setObjectType(1);//类型:个人
			cardDao.setBankId(4);//默认中国银行(4)
			cardDao.setBankAccount(dao.getBankCardNum());
			cardDao.setCardType(1);//卡号类型:银行卡
			cardDao.setCurrencyType(0);//货币类型:人民币
			cardDao.save();
		}

		//获取部门id
		int departmentId = dao.getDepartmentId();
		//向employeeRoles表插入默认角色普通员工(15)
		int roleId = BaseHelpUtils.getIntValue(dao.getRoleId());
		if(roleId <= 0){
			roleId = 15;
		}
		EmployeeRole erDao = new EmployeeRole();
		erDao.setEmployeeId(empId);
		erDao.setDepartmentId(departmentId);
		erDao.setRoleId(roleId);
		erDao.save();
		bean.setEmployeeId(empId);
		boolean testProcessor = BaseHelpUtils.getBoolean(params.get(StaticUtils.TEST_PROCESSOR));
		//如果是测试流程，就不走下面的方法
		if(!testProcessor) {
			//创建账户
			AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_EMPLOYEE, dao.getEmployeeId(), AccountUtils.ACCOUNT_LEVEL_1, dao.getEmployeeName(), dao.getApplyEmployeeId(), true);
			//创建ERP用户第三方账号   企业微信/企业邮箱
			UserAccountUtils.createUserAccount(bean);
			//下发员工到考勤机
			ClockMsgProcess.addEmployeeOfAllClock(bean.getEmployeeId().intValue());
			//插入数据到k3科目代码表中
			K3Code k3CodeDao = new K3Code();
			k3CodeDao.setType(StaticUtils.K3_CODE_TYPE_1);
			k3CodeDao.setBusinessId(bean.getEmployeeId());
			k3CodeDao.save();
			//发送欢迎邮件
			String toEmail = bean.getCompanyEmail();

			String employeeName = dao.getEmployeeName();
			String employeeNo = dao.getEmployeeNo();
			Department depDao = new Department();
			depDao.setDepartmentId(departmentId);
			depDao.load();
			String departmentName = depDao.getDepartmentName();
			String jobs = "";
			if(!BaseHelpUtils.isNullOrEmpty(dao.getDutyId())){
				Duty dutyDao = new Duty();
				dutyDao.setDutyId(dao.getDutyId());
				dutyDao.load();
				jobs = dutyDao.getDutyName();
			}
			SendEmailUtils.sendWelcomeEmail(toEmail, employeeName, employeeNo, departmentName, jobs);
			//给员工发送企业微信确认员工的卡号，身份证号，手机号
			String ERPmsg = String.format(WeixinStatics.MSG_ERPWEIXIN_ONBOARD, employeeName, bean.getCard(), bean.getMobile(), bean.getBankCardNum());
			ERPWeixinUtils.sendWXMsgToUser(bean.getEmployeeId(),ERPmsg);
//			//发送短信到入职员工手机
			String msg = String.format(WeixinStatics.MSG_MOBILE_ONBOARD,employeeName,departmentName,jobs,employeeNo,toEmail);
			OnTelMobile.onTelMobileSendMeg(empId,msg);
			//入职员工的id
			int newEmployeeId = dao.getEmployeeId();
			//操作人
			int applyEmployeeId = dao.getApplyEmployeeId();
			//向员工合同管理表插入劳动合同路径数据
			EmployeeContractAttachment contractDao = new EmployeeContractAttachment();
			contractDao.setEmployeeId(newEmployeeId);
			contractDao.setAttachmentName("劳动合同");
			contractDao.setContractType(CONTRACT_TYPE_0);
			contractDao.setSignType(SIGN_TYPE_0);//新签
			contractDao.setStartDate(dao.getContractStartDate());
			contractDao.setEndDate(dao.getContractEndDate());
			contractDao.setAttachmentUrl(dao.getLaborAttachments());
			contractDao.setOperateEmployeeId(applyEmployeeId);
			contractDao.setOperateTime(new Date());
			contractDao.setAttachmentId(dao.getLaborAttachmentId());
			contractDao.save();
			//向员工每月归属业务部门表插入数据
			int plateId = dao.getPlateId();
			Date onBoardDate = dao.getOnboardDate()==null?new Date():dao.getOnboardDate();
			if(plateId > 0){
				//获取入职日期
				//获取年月份
				int year = DateUtil.getYear(onBoardDate);
				int month = DateUtil.getMonth(onBoardDate);
				EmployeeChangePlateRecord ecpDao = new EmployeeChangePlateRecord();
				ecpDao.setEmployeeId(newEmployeeId);
				ecpDao.setPlateId(plateId);
				ecpDao.setDepartmentId(departmentId);
				ecpDao.setYear(year);
				ecpDao.setMonth(month);
				ecpDao.setCreateTime(onBoardDate);
				ecpDao.setUpdateTime(onBoardDate);
				ecpDao.setChangePlateDate(onBoardDate);
				ecpDao.save();
			}
			//根据入职日期，录入当前月的日归属
			//获取入职日期
			if(!BaseHelpUtils.isNullOrEmpty(onBoardDate)) {
				EmployeeDayPlateRecord dayDao = new EmployeeDayPlateRecord();
				Date endDate = DateUtil.getLastDay(onBoardDate);
				int year = DateUtil.getYear(onBoardDate);
				int month = DateUtil.getMonth(onBoardDate);
				for(Date recordDate = DateUtil.getFirstDay(onBoardDate); recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
					dayDao.clear();
					dayDao.setConditionEmployeeId("=",newEmployeeId);
					dayDao.setConditionRecordDate("=",recordDate);
					if(dayDao.isExist()) {
						continue;
					}else {
						dayDao.clear();
						dayDao.setYear(year);
						dayDao.setMonth(month);
						dayDao.setRecordDate(recordDate);
						dayDao.setEmployeeId(newEmployeeId);
						dayDao.setPlateId(dao.getPlateId());
						dayDao.setDepartmentId(dao.getDepartmentId());
						dayDao.setCompanyId(dao.getCompanyId());
						dayDao.setEmployeeNo(dao.getEmployeeNo());
						dayDao.setEmployeeName(dao.getEmployeeName());
						dayDao.save();
					}
				}
			}
			//取当年最后一天
			Calendar cal = Calendar.getInstance();
			Date date = new Date();
			cal.setTime(date);
			cal.set(Calendar.MONTH, 11);
			Date lastDate = DateUtil.getLastDay(cal.getTime());
	
			//员工排班
			if(!BaseHelpUtils.isNullOrEmpty(dao.getEmployeeShift())){
				OnShiftManageProcess process = new OnShiftManageProcess();
				process.commonEmployeeShiftSave(employeeName,empId,DateUtil.getFirstDay(dao.getOnboardDate()),lastDate,dao.getEmployeeShift(),applyEmployeeId);
			}
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		if(!BaseHelpUtils.isNullOrEmpty(params)){
			bean.setDataFromMap(params);
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
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setPrimaryKeyFromBase(bean);
			if(!dao.load()) throw new SQLException("Business data not found");
			dao.setDataFromBase(bean);
			ColumnChangedData ownedCompanyChange = dao.getColumnChangedData(BaseEmployeeWithEeeee.CS_OWNED_COMPANY);
			ColumnChangedData plateIdChange = dao.getColumnChangedData(BaseEmployeeWithEeeee.CS_PLATE_ID);
			//所属公司
			if(null != bean.getOwnedCompany()){
				dao.setCompanyId(BaseHelpUtils.getIntValue(bean.getOwnedCompany()));
			}
			//入职员工的id
			int newEmployeeId = dao.getEmployeeId();
			setEmployeeId(newEmployeeId);
			dataValidate(dao, false);
			dao.setStatus(0);
			//修改头像的引用次数
			ColumnChangedData photoData = dao.getColumnChangedData(BaseEmployee.CS_PHOTO_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(photoData);
			//修改劳动合同附件的引用次数
			ColumnChangedData laborAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_LABOR_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(laborAttachmentIdData);
			if(null != laborAttachmentIdData) {
				EmployeeContractAttachment ecaDao = new EmployeeContractAttachment();
				ecaDao.setConditionWillEnd("=", StaticUtils.EMPLOYEE_CONTRACT_WILL_END_0);
				BaseEmployeeContractAttachment ecaBean = ecaDao.executeQueryOneRow();
				ecaDao.clear();
				if(null != ecaBean) {
					ecaDao.setDataFromBase(ecaBean);
					ecaDao.clearModifiedFlags();
					ecaDao.setAttachmentId(dao.getLaborAttachmentId());
					ecaDao.setAttachmentUrl(dao.getLaborAttachments());
					ecaDao.update();
				}else {
					ecaDao.setAttachmentId(dao.getLaborAttachmentId());
					ecaDao.setAttachmentUrl(dao.getLaborAttachments());
					ecaDao.setEmployeeId(dao.getEmployeeId());
					ecaDao.setOperateEmployeeId(dao.getApplyEmployeeId());
					ecaDao.setStartDate(dao.getContractStartDate());
					ecaDao.setEndDate(dao.getContractEndDate());
					ecaDao.setOperateTime(new Date());
					ecaDao.setContractType(CONTRACT_TYPE_0);
					ecaDao.setSignType(SIGN_TYPE_0);
					ecaDao.setAttachmentName("劳动合同");
					ecaDao.save();
				}
			}
			//修改身份证附件的引用次数
			ColumnChangedData cardAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_CARD_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(cardAttachmentIdData);
			//修改职称证明的引用次数
			ColumnChangedData technicalAttachmentIdData = dao.getColumnChangedData(BaseEmployee.CS_TECHNICAL_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(technicalAttachmentIdData);
			//修改学历证的引用次数
			ColumnChangedData educationProofIdData = dao.getColumnChangedData(BaseEmployee.CS_EDUCATION_PROOF_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(educationProofIdData);
			//修改学位证的引用次数
			ColumnChangedData degreeProofIdData = dao.getColumnChangedData(BaseEmployee.CS_DEGREE_PROOF_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(degreeProofIdData);
			//修改银行卡的引用次数
			ColumnChangedData bankCardIdData = dao.getColumnChangedData(BaseEmployee.CS_BANK_CARD_ATTACHMENT_ID);
			FileManageProcessor.upadteTimesByColumnChangedData(bankCardIdData);
			if(completed){
				if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
					//流程被驳回，关闭ERP用户第三方账号   企业微信/企业邮箱， 关闭账户
					try {
						UserAccountUtils.deleteUserAccount(newEmployeeId);
//						AccountUtils.destoryAccount(AccountUtils.ACCOUNT_TYPE_EMPLOYEE, dao.getEmployeeId(), null);
					} catch (Exception e) {
						e.printStackTrace();
					}
					Employee eDao = new Employee();
					eDao.setEmployeeId(newEmployeeId);
					eDao.load();
					eDao.setStatus(1);
					eDao.update();
				}
				if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
					//流程审批完成
					try {
						UserAccountUtils.updateUserAccount(dao.generateBase(), 1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
			//获取节点类型，如果是批处理，则不进行更新操作
			int activityTypes = BaseHelpUtils.getIntValue(params, "activityType");
			if(activityTypes != 2){//说明是单挑审批
				dao.update();
			}

			int departmentId = dao.getDepartmentId();

			//如果银行卡号不为空，往card_manage表里插入或更新数据
			if(!BaseHelpUtils.isNullOrEmpty(dao.getBankCardNum())){
				CardManage cardDao = new CardManage();
				cardDao.setConditionObjectId("=", newEmployeeId);
				BaseCardManage cardBean = cardDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(cardBean) && !cardBean.getBankAccount().equals(dao.getBankCardNum())){
					cardDao.setBankAccount(dao.getBankCardNum());
					cardDao.update();
				}else if(BaseHelpUtils.isNullOrEmpty(cardBean)){
					cardDao.setObjectId(newEmployeeId);
					cardDao.setObjectType(1);//类型:个人
					cardDao.setBankId(4);//默认中国银行
					cardDao.setBankAccount(dao.getBankCardNum());
					cardDao.setCardType(1);//卡号类型:银行卡
					cardDao.setCurrencyType(0);//货币类型:人民币
					cardDao.save();
				}
			}

			//往员工角色表里添加数据
			if (!BaseHelpUtils.isNullOrEmpty(dao.getRoleId())) {
				int roleId = BaseHelpUtils.getIntValue(dao.getRoleId());
				if (roleId > 0) {
					DepartmentRole departmentRole = new DepartmentRole();
					departmentRole.setConditionDepartmentId("=",departmentId);
					departmentRole.setConditionRoleId("=",roleId);
					if (departmentRole.isExist()){//部门下存在这个角色时才能赋值这个角色
						EmployeeRole employeeRole = new EmployeeRole();
						employeeRole.setRoleId(roleId);
						employeeRole.setDepartmentId(departmentId);
						employeeRole.setEmployeeId(newEmployeeId);
						employeeRole.setIsDefault(true);
						employeeRole.save();
					}
				}
			}
			//操作人
			int applyEmployeeId = dao.getApplyEmployeeId();
			setDepartmentId(departmentId);
			//如果归属公司或业务部门发生变动，则发送短信和邮件并变动各个平台的账号信息
			if(null != ownedCompanyChange || null != plateIdChange){
				Department depDao = new Department();
				depDao.setDepartmentId(departmentId);
				depDao.load();
				String departmentName = depDao.getDepartmentName();
				String jobs = "";
				if(!BaseHelpUtils.isNullOrEmpty(dao.getDutyId())){
					Duty dutyDao = new Duty();
					dutyDao.setDutyId(dao.getDutyId());
					dutyDao.load();
					jobs = dutyDao.getDutyName();
				}
				//如果归属公司或业务部门发生变动，则发送短信和邮件
				SendEmailUtils.sendWelcomeEmail(bean.getEmail(), bean.getEmployeeName(), bean.getEmployeeNo(), departmentName, jobs);
				String msg = String.format(WeixinStatics.MSG_MOBILE_ONBOARD, bean.getEmployeeName(),departmentName,jobs, bean.getEmployeeNo(), bean.getEmail());
				OnTelMobile.onTelMobileSendMeg(bean.getEmployeeId(),msg);
				//变动各个平台的账号信息
				UserAccountUtils.updateUserAccount(bean, 0);
			}

			//向员工工资表employee_payments插入数据
			if(!BaseHelpUtils.isNullOrEmpty(dao.getTryTimePay())){//如果试用期工资不为空
				EmployeePayment payDao = new EmployeePayment();
				payDao.setConditionEmployeeId("=", newEmployeeId);
				payDao.setConditionPaymentChangeType("=", 1);
				BaseEmployeePayment payBean = payDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(payBean)){//如果调薪类型为入职的员工工资记录不为空，则更新
					payDao.clear();
					payDao.setDataFromBase(payBean);
					payDao.setChangeDate(dao.getOnboardDate());
					payDao.setMonthPay(dao.getTryTimePay());
					payDao.setMonthBasicPay(dao.getTryTimePay());
					payDao.setTotalPay(dao.getTryTimePay());
					if(!BaseHelpUtils.isNullOrEmpty(dao.getAnnualPerformance())){
						payDao.setAnnualPerformance(dao.getAnnualPerformance());
					}else{
						payDao.setAnnualPerformance("0");
					}
					int intValue = BaseHelpUtils.getIntValue(params.get("costAttribution"));
					if(intValue>0) {
						payDao.setCostAttribution(BaseHelpUtils.getIntValue(params.get("costAttribution")));
					}
					payDao.update();
				}else{//如为空则插入数据
					payDao.clear();
					payDao.setEmployeeId(newEmployeeId);
					payDao.setPaymentChangeType(1);//调薪类型，1为入职
					payDao.setChangeDate(dao.getOnboardDate());
					payDao.setMonthPay(dao.getTryTimePay());
					payDao.setBasicProportionStr("100%");
					payDao.setBasicProportion(BigDecimal.valueOf(1));
					payDao.setMonthBasicPay(dao.getTryTimePay());
					payDao.setMonthPerformancePay("0");
					payDao.setForemanPay("0");
					payDao.setOtherSubsidy("0");
					payDao.setTotalPay(dao.getTryTimePay());
					if(!BaseHelpUtils.isNullOrEmpty(dao.getAnnualPerformance())){
						payDao.setAnnualPerformance(dao.getAnnualPerformance());
					}else{
						payDao.setAnnualPerformance("0");
					}
					payDao.setCostAttribution(BaseHelpUtils.getIntValue(params.get("costAttribution")));
					payDao.save();
				}
			}

			BusinessAbstract ba = new BusinessAbstract(dao.getEmployeeId(), "");
			return ba;
		}else{
			return null;
		}
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null,null,null);
		Employee employeeDao = new Employee();
		employeeDao.unsetSelectFlags();
		employeeDao.setSelectPlateId(true);
		employeeDao.setSelectGradeId(true);
		employeeDao.setEmployeeId(bean.getEmployeeId());
		String plateName ="";
		int gradeId = 0;
		String plateTypeName = "";
		if(employeeDao.load()){
			int plateId = BaseHelpUtils.getIntValue(employeeDao.getPlateId());
			gradeId = BaseHelpUtils.getIntValue(employeeDao.getGradeId());
			PlateRecord plateDao = new PlateRecord();
			plateDao.setConditionPlateId("=",plateId);
			BasePlateRecord plateBean = plateDao.executeQueryOneRow();
			if(!BaseHelpUtils.isNullOrEmpty(plateBean)){
				plateName = BaseHelpUtils.getString(plateBean.getPlateName());
				int plateType = BaseHelpUtils.getIntValue(plateBean.getPlateType());
				if(plateType == 1){
					plateTypeName = "事业部";
				}else if(plateType == 2){
					plateTypeName = "职能部";
				}else if(plateType == 3){
					plateTypeName = "营销部";
				}
			}
		}else{
			throw new Exception("找不到该员工的信息");
		}
		if(expression.indexOf("部门类型") >= 0){
			e.setValue("部门类型", plateTypeName);
		}
		if(expression.indexOf("设计师职级") >= 0){
			e.setValue("设计师职级", gradeId);
		}
		if(expression.indexOf("部门名称") >= 0){
			e.setValue("部门名称", plateName);
		}
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		//根据新员工入职的departmentId获取该部门的分管领导
		if(null != roleId && roleId.equals(StaticUtils.ROLE_DEPARTMENT_CHARGE_LEADER)){
			ConditiongetEmployeeByRoleIdAndDepartmentId condition = new ConditiongetEmployeeByRoleIdAndDepartmentId();
			condition.setRoleId(roleId);
			condition.setDepartmentId(getDepartmentId());
			QuerygetEmployeeByRoleIdAndDepartmentId query = new QuerygetEmployeeByRoleIdAndDepartmentId();
			BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections()){
				List<BasegetEmployeeByRoleIdAndDepartmentId> list = bc.getCollections();
				int size = list.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = list.get(i).getEmployeeId();
				}
				return arr;
			}
		}
		//根据新员工入职的部门获取该部门的，部门负责人（人资）
		if (null != roleId && roleId.equals(StaticUtils.DEPARTMENT_HEAD_HR)) {
			ConditiongetEmployeeByRoleIdAndDepartmentId condition = new ConditiongetEmployeeByRoleIdAndDepartmentId();
			condition.setRoleId(roleId);
			condition.setDepartmentId(getDepartmentId());
			QuerygetEmployeeByRoleIdAndDepartmentId query = new QuerygetEmployeeByRoleIdAndDepartmentId();
			BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections()){
				List<BasegetEmployeeByRoleIdAndDepartmentId> list = bc.getCollections();
				int size = list.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = list.get(i).getEmployeeId();
				}
				return arr;
			}
		}
		//根据新员工入职的departmentId获取该部门的考勤管理员
		if(null != roleId && roleId.equals(StaticUtils.ROLE_ATTENDANCE_ADMINISTRATOR)){
			//获取部门id
			int depId = getDepartmentId();
			Map<Integer,Integer> ids = new HashMap<>();
			//递归获取上级部门id数据集
			getDepartmentIds(ids, depId);
			if(!BaseHelpUtils.isNullOrEmpty(ids) && ids.size() > 0){
				int size = ids.size();
				Object[] arr = new Object[size];
				int i= 0;
				for(Integer id : ids.keySet()){
					arr[i] = id;
					i++;
				}
				//加载人员信息
				EmployeeRole erDao = new EmployeeRole();
				erDao.setConditionRoleId("=",roleId);
				erDao.addCondition(BaseEmployeeRole.CS_DEPARTMENT_ID,"in", arr);
				List<BaseEmployeeRole> erList = erDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(erList) && erList.size() > 0){
					Map<Integer,Integer> empMap = new HashMap<>();
					for(BaseEmployeeRole e : erList){
						int empId = e.getEmployeeId();
						empMap.put(empId, empId);
					}
					int j = 0;
					int[] empArr = new int[empMap.size()];
					for(Integer id : empMap.keySet()){
						empArr[j] = id;
						j++;
					}
					return empArr;
				}
			}
		}
		//根据新员工入职的departmentId获取该部门的事业部助理(知会节点)
		if(null != roleId && roleId.equals(StaticUtils.ROLE_PLATE_ASSISTANT)){
			ConditiongetEmployeeByRoleIdAndDepartmentId condition = new ConditiongetEmployeeByRoleIdAndDepartmentId();
			condition.setRoleId(roleId);
			condition.setDepartmentId(getDepartmentId());
			QuerygetEmployeeByRoleIdAndDepartmentId query = new QuerygetEmployeeByRoleIdAndDepartmentId();
			BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections()){
				List<BasegetEmployeeByRoleIdAndDepartmentId> list = bc.getCollections();
				int size = list.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = list.get(i).getEmployeeId();
				}
				return arr;
			}
		}

		//根据新员工入职的departmentId获取该部门的部门行政负责人(知会节点)
		if(null != roleId && roleId.equals(StaticUtils.ROLE_PLATE_MANAGE_MANAGER)){
			ConditiongetEmployeeByRoleIdAndDepartmentId condition = new ConditiongetEmployeeByRoleIdAndDepartmentId();
			condition.setRoleId(roleId);
			condition.setDepartmentId(getDepartmentId());
			QuerygetEmployeeByRoleIdAndDepartmentId query = new QuerygetEmployeeByRoleIdAndDepartmentId();
			BaseCollection<BasegetEmployeeByRoleIdAndDepartmentId> bc = query.executeQuery(null, condition);
			if(null != bc && null != bc.getCollections()){
				List<BasegetEmployeeByRoleIdAndDepartmentId> list = bc.getCollections();
				int size = list.size();
				int[] arr = new int[size];
				for(int i = 0; i < size; i++){
					arr[i] = list.get(i).getEmployeeId();
				}
				return arr;
			}
		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	/**
	 * 递归获取上级部门id数据集
	 * @param ids
	 * @param departmentId
	 * @throws SQLException
	 */
	public void getDepartmentIds(Map<Integer,Integer> ids,int departmentId) throws SQLException{
		ids.put(departmentId, departmentId);
		//根据当前部门id去加载上级部门
		Department dao = new Department();
		dao.setDepartmentId(departmentId);
		if(dao.load()){
			//获取父级部门id
			int parentId = dao.getParentId();
			if(parentId != 0){//说明不是一级部门，则需继续往上面找
				getDepartmentIds(ids,parentId);
			}else{
				ids.put(departmentId, departmentId);
			}
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		EmployeeWithEeeee dao = new EmployeeWithEeeee();
		dao.setEmployeeId(businessId);
		dao.load();
		dao.setPhoto(FileManageProcessor.getFileUrlById(dao.getPhotoId()));
		dao.setLaborAttachments(FileManageProcessor.getFileUrlById(dao.getLaborAttachmentId()));
		dao.setCardAttachment(FileManageProcessor.getFileUrlById(dao.getCardAttachmentId()));
		dao.setTechnicalAttachment(FileManageProcessor.getFileUrlById(dao.getTechnicalAttachmentId()));
		dao.setEducationProof(FileManageProcessor.getFileUrlById(dao.getEducationProofId()));
		dao.setDegreeProof(FileManageProcessor.getFileUrlById(dao.getDegreeProofId()));
		return dao.generateBaseExt().toJSON();
	}

	public void dataValidate(EmployeeWithEeeee dao, Boolean checkEmail) throws Exception{
		Employee employeeDao = new Employee();
		String email = dao.getCompanyEmail();
		String mobile = dao.getMobile();
		String employeeNo = dao.getEmployeeNo();
		if(checkEmail && !BaseHelpUtils.isNullOrEmpty(email)){
			String emailSuffix = email.substring(email.indexOf("@")+1);
			if(!emailSuffix.equals("cube-architects.com")){
				throw new Exception("企业邮箱后缀应为@cube-architects.com");
			}
			employeeDao.setConditionCompanyEmail("=", email);
			employeeDao.setConditionEmployeeId("!=", dao.getEmployeeId());
			if(employeeDao.isExist()) {
				throw new Exception("该企业邮箱已存在");
			}
		}
		employeeDao.clear();
		employeeDao.setConditionMobile("=", mobile);
		employeeDao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
		if(null != dao.getEmployeeId()) {
			employeeDao.setConditionEmployeeId("!=", dao.getEmployeeId());
		}
		if(employeeDao.isExist()) {
			throw new Exception("该手机号码已存在");
		}
		employeeDao.clear();
		employeeDao.setConditionEmployeeNo("=", employeeNo);
		if(null != dao.getEmployeeId()) {
			employeeDao.setConditionEmployeeId("!=", dao.getEmployeeId());
		}
		if(employeeDao.isExist()) {
			throw new Exception("该工号已经存在");
		}
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public static void main(String[] args) throws ParseException, SQLException {
		Date onBoardDate =new Date();
		//入职员工的id
		int newEmployeeId = 2415;
		
		EmployeeDayPlateRecord dayDao = new EmployeeDayPlateRecord();
		Date endDate = DateUtil.getLastDay(onBoardDate);
		int year = DateUtil.getYear(onBoardDate);
		int month = DateUtil.getMonth(onBoardDate);
		for(Date recordDate = DateUtil.getFirstDay(onBoardDate); recordDate.compareTo(endDate) <= 0; recordDate = DateUtil.getNextDayOfDay(recordDate, 1)) {
			dayDao.clear();
			dayDao.setConditionEmployeeId("=",newEmployeeId);
			dayDao.setConditionRecordDate("=",recordDate);
			
				dayDao.clear();
				dayDao.setYear(year);
				dayDao.setMonth(month);
				dayDao.setRecordDate(recordDate);
				dayDao.setEmployeeId(newEmployeeId);
//				dayDao.setPlateId(dao.getPlateId());
//				dayDao.setDepartmentId(dao.getDepartmentId());
//				dayDao.setCompanyId(dao.getCompanyId());
//				dayDao.setEmployeeNo(dao.getEmployeeNo());
//				dayDao.setEmployeeName(dao.getEmployeeName());
				dayDao.save();
		}
	
	}
	
}
