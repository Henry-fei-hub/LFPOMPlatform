package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.EquipmentRecord;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;
import com.pomplatform.db.dao.ReceiveUnitManage;

import com.pomplatform.db.handler.EquipmentTypeHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.expression.Expression;
import delicacy.system.bean.BaseSystemProcess;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.SystemProcess;
import delicacy.system.executor.NewCreateWorkFlow;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithP;

public class PurchaseApplyWorker implements GenericWorkflowProcessor {

	private static final org.apache.log4j.Logger __logger = Logger.getLogger(PurchaseApplyWorker.class);

	protected BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();

	private final static Integer PURCHASE = 5;

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		int processType = pd.getProcessTypeId();
		bean.setProcessType(processType);
		List<BasePersonnelBusinessLinkEquipment> list = bean.getDetailPersonnelBusinessLinkEquipment();
		for(BasePersonnelBusinessLinkEquipment obj : list){
			obj.setProcessType(processType);
		}
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setDataFromBase(bean);
		validator(dao);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		Integer personnelBusinessId = dao.generateBase().getPersonnelBusinessId();
		addEquipmentCord( personnelBusinessId,employeeId,SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		Integer personnelBusinessId = bean.getPersonnelBusinessId();
		Integer processId = pi.getProcessInstance().getBusinessId();
		if(!modified) {
			__logger.debug("========================"+pi+"===="+processId+"="+personnelBusinessId);
			updateEquipmentCord(processId,SystemProcessConstants.PROCESS_STATUS_WORKING);
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
		}else{
			//撤销修改时
			delEquipmentCord(personnelBusinessId);
			addEquipmentCord(personnelBusinessId,employeeId,SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
		}
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		if(null == dao.getDetailPersonnelBusinessLinkEquipment()){
			PersonnelBusinessLinkEquipment linkDao = new PersonnelBusinessLinkEquipment();
			linkDao.setConditionParentId("=", dao.getPersonnelBusinessId());
			dao.setDetailPersonnelBusinessLinkEquipment(linkDao.conditionalLoad());
		}
//		Integer personnelBusinessId = bean.getPersonnelBusinessId();
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				dao.setIsCompleted(true);
				if(dao.getIsRemoteCity()){
					ReceiveUnitManage unitDao = new ReceiveUnitManage();
					unitDao.setReceiveUnitManageId(BaseHelpUtils.getIntValue(dao.getSubType()));
					if(unitDao.load()){
						Map<String, Integer> processInfoMap = new HashMap<>();
						SystemProcess processDao = new SystemProcess();
						processDao.setConditionProcessTypeId("=", StaticUtils.PROCESS_TYPE_7);
						processDao.setConditionDescription("=", "采购流程专用");
						BaseSystemProcess processBean = processDao.executeQueryOneRow();
						if(null != processBean){
							processInfoMap.put("processId", processBean.getProcessId());
							Map userData = new HashMap<>();
							userData.put("payAmount", dao.getFee());
							userData.put("employeeId", dao.getEmployeeId());
							userData.put("departmentId", dao.getDepartmentId());
							userData.put("companyId", dao.getCompanyId());
							userData.put("operateEmployeeId", dao.getDrafter());
							userData.put("operateTime", new Date());
							userData.put("receiveUnit", unitDao.getReceiveUnit());
							userData.put("bankAccount", unitDao.getBankAccount());
							userData.put("bankName", unitDao.getBankName());
							userData.put("titleName", "采购申请（金额："+dao.getFee()+")");
							userData.put("reason", dao.getReason() + "  （PS：该预付款申请是由采购申请流转过来的）");
							BaseProcessBillList bill = new BaseProcessBillList();
							bill.setPayFor(StaticUtils.PAY_FOR_COMPANY);
							bill.setEmployeeOrCompanyId(unitDao.getReceiveUnitManageId());
							bill.setPayeeName(unitDao.getReceiveUnit());
							bill.setSelfBankName(unitDao.getBankName());
							bill.setSelfBankAccount(unitDao.getBankAccount());
							bill.setPayMoney(dao.getFee());
							List<BaseProcessBillList> billList = new ArrayList<>();
							billList.add(bill);
							userData.put("detailProcessBillListApply", billList);
							Map map = new HashMap<>();
							map.put("processDefinition", processInfoMap);
							map.put("userData", userData);
							NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
							createWorkFlow.execute(MapUtils.toJSON(map), dao.getDrafter(), true);
						}
					}
				}
//				updateEquipmentCord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_COMPLETED);
			}
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)||
					pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				updateEquipmentCord(personnelBusinessId,pi.getProcessInstance().getProcessStatus());
			}
		}
		validator(dao);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");

		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		int nextAuditor = BaseHelpUtils.getIntValue(bean.getNextAuditor());
		BigDecimal amount =new BigDecimal(0);
		List<BasePersonnelBusinessLinkEquipment>  list= bean.getDetailPersonnelBusinessLinkEquipment();
		if(!BaseHelpUtils.isNullOrEmpty(list)){
			for (BasePersonnelBusinessLinkEquipment ee:list){
				if(!BaseHelpUtils.isNullOrEmpty(ee.getTotalPrice())){
					amount = amount.add(ee.getTotalPrice());
				}
			}
		}
		if(expression.contains("采购类型")){
			if(!BaseHelpUtils.isNullOrEmpty(bean.getNextAuditor())){
				if(nextAuditor==1){
					e.setValue("采购类型","低值易耗品");
				}else if(nextAuditor==0){
					e.setValue("采购类型","IT物品");
				}else if (nextAuditor==2){
					e.setValue("采购类型","电子产品");
				}
			}else{
				e.setValue("采购类型","");
			}

		}
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,amount, null, null);

		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if(null !=roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			Set<Integer> ownerSet = new HashSet<>();
			EmployeeRole dao = new EmployeeRole();
			dao.setConditionDepartmentId("=",bean.getDepartmentId());
//			dao.addCondition(BaseEmployeeRole.CS_ROLE_ID, "in","3,146");
//			dao.addCondition(BaseEmployeeRole.CS_DEPARTMENT_ID, "=", departmentId);
			List<BaseEmployeeRole> list = dao.conditionalLoad("role_id in (3,146)");
			for(BaseEmployeeRole e :list){
				ownerSet.add(e.getEmployeeId());
			}
			int i =0;
			if (!ownerSet.isEmpty()) {
				int[] ints = new int[ownerSet.size()];
				for (Iterator iter = ownerSet.iterator(); iter.hasNext();) {
					Integer str = (Integer)iter.next();
					ints[i] = str;
					i++;
				}
				return ints;
			} else {
				return new int[0];
			}
		}else{
			return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
		}
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

	public void validator(PersonnelBusinesWithP dao) throws Exception{
		if(null == dao.getEmployeeId()){
			throw new Exception("请重新登录之后再重试");
		}
		if(null == dao.getFee()){
			throw new Exception("请填写预计采购费用");
		}
		if(null == dao.getReason()){
			throw new Exception("请填写申请缘由");
		}
		if(null == dao.getDetailPersonnelBusinessLinkEquipment() || dao.getDetailPersonnelBusinessLinkEquipment().isEmpty()){
			throw new Exception("请填写采购清单");
		}
	}

	/**
	 * 删除物品记录
	 */
	public void delEquipmentCord(Integer personnelBusinessId) throws Exception {
		EquipmentRecord recordDao = new EquipmentRecord();
		recordDao.setConditionFollowId("=",personnelBusinessId);
		recordDao.conditionalDelete();
	}


	/**
	 * 新增采购申请流程记录
	 */
	private void addEquipmentCord(Integer personnelBusinessId, Integer employeeId, Integer followerStatus) throws Exception {
		EquipmentRecord recordDao = new EquipmentRecord();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
		//流程新增 遍历存入物品申请记录
		List<BasePersonnelBusinessLinkEquipment> basePersonnelBusinessLinkEquipments = bean.getDetailPersonnelBusinessLinkEquipment();
		basePersonnelBusinessLinkEquipments.forEach(b->{
			BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
			//物品id
			baseEquipmentRecord.setEquipmentId(b.getType());
			//操作类型（新增）
			baseEquipmentRecord.setOperationType(PURCHASE.shortValue());
			//当前操作人id
			baseEquipmentRecord.setOperationPerson(employeeId);
			baseEquipmentRecord.setFollowStatus(followerStatus.shortValue());
			baseEquipmentRecord.setFollowId(personnelBusinessId);
			if(BaseHelpUtils.isNullOrEmpty(bean.getCreateTime())){
				baseEquipmentRecord.setOperationTime(new Date());
			}else{
				baseEquipmentRecord.setOperationTime(bean.getCreateTime());
			}
			baseEquipmentRecord.setCount(b.getAmount());
			__logger.debug("-----------------------------------"+baseEquipmentRecord.toJSONString()+"----------------------------");
			recordDao.clear();
			recordDao.setDataFromBase(baseEquipmentRecord);
			try {
				recordDao.save();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//更新物品的最近操作时间与操作人
			try {
				String json = equipmentTypeDao.findUsingKey("{\"equipmentTypeId\" : "+b.getType()+"}");
				BaseEquipmentType baseEquipmentType = new BaseEquipmentType();
				baseEquipmentType.setDataFromJSON(json);
				baseEquipmentType.setUpdatePerson(employeeId);
				if(BaseHelpUtils.isNullOrEmpty(bean.getCreateTime())){
					baseEquipmentType.setUpdateTime(new Date());
				}else{
					baseEquipmentType.setUpdateTime(bean.getCreateTime());
				}
				__logger.debug("-----------------------"+baseEquipmentType.toJSONString()+"-------------------");
				equipmentTypeDao.update(baseEquipmentType.toJSON());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 *更新物品流程操作记录
	 */
	private void updateEquipmentCord(Integer personnelBusinessId,Integer followerStatus) throws SQLException {
		EquipmentRecord recordDao = new EquipmentRecord();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
		//流程完成 遍历存入物品申请记录
		List<BasePersonnelBusinessLinkEquipment> basePersonnelBusinessLinkEquipments = bean.getDetailPersonnelBusinessLinkEquipment();
		basePersonnelBusinessLinkEquipments.forEach(b->{
			BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
			if(BaseHelpUtils.isNullOrEmpty(b.getCreateTime())){
				baseEquipmentRecord.setOperationTime(new Date());
			}
			else{
				baseEquipmentRecord.setOperationTime(b.getCreateTime());
			}
			baseEquipmentRecord.setFollowStatus(followerStatus.shortValue());
			__logger.debug("-----------------------------------"+baseEquipmentRecord.toJSONString()+"----------------------------");
			recordDao.clear();
			recordDao.setDataFromBase(baseEquipmentRecord);
			recordDao.setConditionFollowId("=",personnelBusinessId);
			try {
				recordDao.conditionalUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//流程完成
			if(followerStatus==SystemProcessConstants.PROCESS_STATUS_COMPLETED){
				//返回库存
				try {
					String json = equipmentTypeDao.findUsingKey("{\"equipmentTypeId\" : "+b.getType()+"}");
					BaseEquipmentType baseEquipmentType = new BaseEquipmentType();
					baseEquipmentType.setDataFromJSON(json);
					baseEquipmentType.setCount(baseEquipmentType.getCount()+b.getAmount());
					__logger.debug("-----------------------"+baseEquipmentType.toJSONString()+"-------------------");
					equipmentTypeDao.update(baseEquipmentType.toJSON());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
