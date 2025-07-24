package pomplatform.workflow.personnelbusiness.handler;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.EquipmentRecord;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;
import com.pomplatform.db.dao.PersonnelBusinessLinkReturn;
import com.pomplatform.db.handler.AttachmentLinkContractReceivableHandler;
import com.pomplatform.db.handler.EquipmentTypeHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import org.apache.log4j.Logger;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithP;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ReturnOfItemsWorker implements GenericWorkflowProcessor {

	private static final org.apache.log4j.Logger __logger = Logger.getLogger(ReturnOfItemsWorker.class);

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		Integer personnelBusinessId = dao.generateBase().getPersonnelBusinessId();
		saveLinkReturn(params, personnelBusinessId);
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		//添加物品归还记录
		addEquipmentcord( personnelBusinessId,employeeId,SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
		return ba;
	}



	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		Integer personnelBusinessId = bean.getPersonnelBusinessId();
		if(!modified) {
			updateEquipmentcord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_WORKING);
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
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);

		if (completed) {
			//流程驳回(将数据返还)
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				__logger.info("--------------------------- personnelBusinessId:" + personnelBusinessId);
				updateEquipmentcord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_REJECT);
				deleteLinkReturn(personnelBusinessId);
			}
			//流程完成
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				updateEquipmentcord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_COMPLETED);
			}
			//流程进行中
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_WORKING)) {
				updateEquipmentcord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_WORKING);
			}
		}
		//流程驳回
		if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
			updateEquipmentcord(personnelBusinessId,SystemProcessConstants.PROCESS_STATUS_REJECT);
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}



	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		e = OnWrokflowProcess.setExpression(expression, e, employeeId,null, null, null);
		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	/**
	 * @author liubin
	 * @date 2019/12/24 12:22
	 * @param personnelBusinessId
	 * @return void
	 * @description: 流程驳回返还数据
	 */
	public void deleteLinkReturn(Integer personnelBusinessId) throws SQLException {
		PersonnelBusinessLinkReturn personnelBusinessLinkReturn = new PersonnelBusinessLinkReturn();
		personnelBusinessLinkReturn.setConditionPersonnelBusinessId("=", personnelBusinessId);
		PersonnelBusinessLinkEquipment personnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
		List<BasePersonnelBusinessLinkReturn> basePersonnelBusinessLinkReturns = personnelBusinessLinkReturn.conditionalLoad();
		if (!BaseHelpUtils.isNullOrEmpty(basePersonnelBusinessLinkReturns) && basePersonnelBusinessLinkReturns.size() != 0) {
			for (BasePersonnelBusinessLinkReturn basePersonnelBusinessLinkReturn : basePersonnelBusinessLinkReturns) {
				__logger.info("------------------------ basePersonnelBusinessLinkReturn:" + basePersonnelBusinessLinkReturn);
				Integer personnelBusinessLinkEquipmentId = basePersonnelBusinessLinkReturn.getPersonnelBusinessLinkEquipmentId();
				__logger.info("------------------------ personnelBusinessLinkEquipmentId:" + personnelBusinessLinkEquipmentId);
				//获取本次的还物品的数量
				Integer currentReturn = basePersonnelBusinessLinkReturn.getReturnAmount();
				__logger.info("------------------------ currentReturn:" + currentReturn);
				personnelBusinessLinkEquipment.clear();
				personnelBusinessLinkEquipment.setPersonnelBusinessLinkEquipmentId(personnelBusinessLinkEquipmentId);
				if (personnelBusinessLinkEquipment.load()) {
					BasePersonnelBusinessLinkEquipment basePersonnelBusinessLinkEquipment = personnelBusinessLinkEquipment.generateBase();
					//获取借物品的总数量
					int amount = BaseHelpUtils.getIntValue(basePersonnelBusinessLinkEquipment.getAmount());
					//获取已经归还的数量
					int returnAmount = BaseHelpUtils.getIntValue(basePersonnelBusinessLinkEquipment.getReturnAmount());
					//获取剩余的归还的数量
					int remainingReturn = BaseHelpUtils.getIntValue(basePersonnelBusinessLinkEquipment.getRemainingReturn());
					//回退数据之后已经归还的数量
					int temp1 = returnAmount - currentReturn;
					//回退之后剩余归还的数量
					int temp2 = remainingReturn + currentReturn;
					basePersonnelBusinessLinkEquipment.setIsReturn(false);
					basePersonnelBusinessLinkEquipment.setReturnAmount(temp1);
					basePersonnelBusinessLinkEquipment.setRemainingReturn(temp2);
					personnelBusinessLinkEquipment.clear();
					personnelBusinessLinkEquipment.setPrimaryKeyFromBase(basePersonnelBusinessLinkEquipment);
					personnelBusinessLinkEquipment.setDataFromBase(basePersonnelBusinessLinkEquipment);
					__logger.info("------------------------ personnelBusinessLinkEquipment:" + personnelBusinessLinkEquipment);
					personnelBusinessLinkEquipment.update();

					//删除业务表的数据
					Integer personnelBusinessLinkReturnId = basePersonnelBusinessLinkReturn.getPersonnelBusinessLinkReturnId();
					personnelBusinessLinkReturn.clear();
					personnelBusinessLinkReturn.setConditionPersonnelBusinessLinkReturnId("=", personnelBusinessLinkReturnId);
					personnelBusinessLinkReturn.conditionalDelete();
				}
			}
		}
	}

	/**
	 * @param params
	 * @return void
	 * @author liubin
	 * @date 2019/12/24 9:37
	 * @description: 更新借款物品的状态
	 */
	private void saveLinkReturn(Map params, Integer personnelBusinessId) throws SQLException {
		if (!BaseHelpUtils.isNullOrEmpty(params)) {
			__logger.info("------------------ params：" + params);
			List<Map> maps = (List<Map>) params.get("returnOfItemDetail");
			Date startDate = BaseHelpUtils.getDateValue(params.get("startDate"));
			PersonnelBusinessLinkEquipment detailDao = new PersonnelBusinessLinkEquipment();
			PersonnelBusinessLinkReturn personnelBusinessLinkReturn = new PersonnelBusinessLinkReturn();
			if (!BaseHelpUtils.isNullOrEmpty(maps) && maps.size() != 0) {
				for (Map map : maps) {
					BasePersonnelBusinessLinkEquipment detailBean = new BasePersonnelBusinessLinkEquipment();
					detailBean.setDataFromMap(map);
					__logger.info("------------------ detailBean：" + detailBean);
					//获取本次归还的数量
					Integer currentReturn = BaseHelpUtils.getIntValue(map.get("currentReturn"));
					//获取剩余的归还的数量
					int remainingReturn = BaseHelpUtils.getIntValue(detailBean.getRemainingReturn());
					if (remainingReturn < 0) {
						throw new SQLException("数据异常: 本次规划你的数量");
					}
					//剩余归还的数量的为0则表明数据已经归还完成
					else if (remainingReturn == 0) {
						detailBean.setIsReturn(true);
					}
					detailDao.clear();
					detailDao.setPrimaryKeyFromBase(detailBean);
					detailDao.setDataFromBase(detailBean);
					detailDao.update();

					//保存物品归还的详情
					Integer personnelBusinessLinkEquipmentId = detailBean.getPersonnelBusinessLinkEquipmentId();
					BasePersonnelBusinessLinkReturn basePersonnelBusinessLinkReturn = new BasePersonnelBusinessLinkReturn();
					basePersonnelBusinessLinkReturn.setPersonnelBusinessId(personnelBusinessId);
					basePersonnelBusinessLinkReturn.setPersonnelBusinessLinkEquipmentId(personnelBusinessLinkEquipmentId);
					basePersonnelBusinessLinkReturn.setReturnAmount(currentReturn);
					basePersonnelBusinessLinkReturn.setType(detailBean.getType());
					basePersonnelBusinessLinkReturn.setRemark(detailBean.getRemark());
					basePersonnelBusinessLinkReturn.setReturnTime(startDate);
					personnelBusinessLinkReturn.clear();
					personnelBusinessLinkReturn.setDataFromBase(basePersonnelBusinessLinkReturn);
					personnelBusinessLinkReturn.save();
				}
			}
		}

	}

	/**
	 * 物品归还流程取消时删除此次物品操作记录
	 */
	public void deleteEquipmentCord(Integer personnelBusinessId) throws SQLException {
		EquipmentRecord recordDao = new EquipmentRecord();
		recordDao.clear();
		recordDao.setConditionFollowId("=",personnelBusinessId);
		try {
			recordDao.conditionalDelete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 *添加物品申请流程记录
	 */
	private void addEquipmentcord(Integer personnelBusinessId, Integer employeeId, Integer followerStatus) throws Exception {
		PersonnelBusinessLinkReturn personnelBusinessLinkReturn = new PersonnelBusinessLinkReturn();
		personnelBusinessLinkReturn.setConditionPersonnelBusinessId("=", personnelBusinessId);
		PersonnelBusinessLinkEquipment personnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
		List<BasePersonnelBusinessLinkReturn> basePersonnelBusinessLinkReturns = personnelBusinessLinkReturn.conditionalLoad();
		//物品操作类型
		EquipmentRecord recordDao = new EquipmentRecord();
		if (!BaseHelpUtils.isNullOrEmpty(basePersonnelBusinessLinkReturns) && basePersonnelBusinessLinkReturns.size() != 0) {
			for (BasePersonnelBusinessLinkReturn basePersonnelBusinessLinkReturn : basePersonnelBusinessLinkReturns) {
				__logger.info("------------------------ basePersonnelBusinessLinkReturn:" + basePersonnelBusinessLinkReturn);
				Integer personnelBusinessLinkEquipmentId = basePersonnelBusinessLinkReturn.getPersonnelBusinessLinkEquipmentId();
				__logger.info("------------------------ personnelBusinessLinkEquipmentId:" + personnelBusinessLinkEquipmentId);
				//获取本次的还物品的数量
				Integer currentReturn = basePersonnelBusinessLinkReturn.getReturnAmount();
				__logger.info("------------------------ currentReturn:" + currentReturn);
				personnelBusinessLinkEquipment.clear();
				personnelBusinessLinkEquipment.setPersonnelBusinessLinkEquipmentId(personnelBusinessLinkEquipmentId);
				if (personnelBusinessLinkEquipment.load()) {
					BasePersonnelBusinessLinkEquipment basePersonnelBusinessLinkEquipment = personnelBusinessLinkEquipment.generateBase();
					BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
					//物品id
					baseEquipmentRecord.setEquipmentId(basePersonnelBusinessLinkEquipment.getType());
					//流程id
					baseEquipmentRecord.setFollowId(personnelBusinessId);
					//操作类型（归还）
					baseEquipmentRecord.setOperationType((short)2);
					//当前操作人id
					if(!BaseHelpUtils.isNullOrZero(employeeId))
						baseEquipmentRecord.setOperationPerson(employeeId);
					if(BaseHelpUtils.isNullOrEmpty(basePersonnelBusinessLinkReturn.getReturnTime())){
						baseEquipmentRecord.setOperationTime(new Date());
					}else{
						baseEquipmentRecord.setOperationTime(basePersonnelBusinessLinkReturn.getReturnTime());
					}
					baseEquipmentRecord.setCount(currentReturn);
					baseEquipmentRecord.setFollowStatus(followerStatus.shortValue());
					recordDao.clear();
					recordDao.setDataFromBase(baseEquipmentRecord);
					try {
						recordDao.save();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 *更新物品流程操作记录
	 */
	private void updateEquipmentcord(Integer personnelBusinessId,Integer followerStatus) throws SQLException {
		EquipmentRecord recordDao = new EquipmentRecord();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
		//流程发起 遍历 存入物品申请记录
		PersonnelBusinessLinkReturn personnelBusinessLinkReturn = new PersonnelBusinessLinkReturn();
		personnelBusinessLinkReturn.setConditionPersonnelBusinessId("=", personnelBusinessId);
		PersonnelBusinessLinkEquipment personnelBusinessLinkEquipment = new PersonnelBusinessLinkEquipment();
		List<BasePersonnelBusinessLinkReturn> basePersonnelBusinessLinkReturns = personnelBusinessLinkReturn.conditionalLoad();
		//物品操作类型
		if (!BaseHelpUtils.isNullOrEmpty(basePersonnelBusinessLinkReturns) && basePersonnelBusinessLinkReturns.size() != 0) {
			for (BasePersonnelBusinessLinkReturn basePersonnelBusinessLinkReturn : basePersonnelBusinessLinkReturns) {
				//获取本次的还物品的数量
				Integer currentReturn = basePersonnelBusinessLinkReturn.getReturnAmount();
				__logger.info("------------------------ basePersonnelBusinessLinkReturn:" + basePersonnelBusinessLinkReturn);
				Integer personnelBusinessLinkEquipmentId = basePersonnelBusinessLinkReturn.getPersonnelBusinessLinkEquipmentId();
				__logger.info("------------------------ personnelBusinessLinkEquipmentId:" + personnelBusinessLinkEquipmentId);
				personnelBusinessLinkEquipment.clear();
				personnelBusinessLinkEquipment.setPersonnelBusinessLinkEquipmentId(personnelBusinessLinkEquipmentId);
				if (personnelBusinessLinkEquipment.load()) {
					BasePersonnelBusinessLinkEquipment b = personnelBusinessLinkEquipment.generateBase();
					BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
					if(BaseHelpUtils.isNullOrEmpty(b.getCreateTime()))
						baseEquipmentRecord.setOperationTime(new Date());
					else
						baseEquipmentRecord.setOperationTime(b.getCreateTime());
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
							baseEquipmentType.setCount(baseEquipmentType.getCount()+currentReturn);
							__logger.debug("-----------------------"+baseEquipmentType.toJSONString()+"-------------------");
							equipmentTypeDao.update(baseEquipmentType.toJSON());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}


}
