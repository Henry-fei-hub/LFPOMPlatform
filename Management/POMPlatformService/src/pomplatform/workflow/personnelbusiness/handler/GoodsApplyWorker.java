package pomplatform.workflow.personnelbusiness.handler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pomplatform.db.bean.BaseEquipmentRecord;
import com.pomplatform.db.bean.BaseEquipmentType;
import com.pomplatform.db.bean.BasePersonnelBusinessLinkEquipment;

import com.pomplatform.db.dao.EquipmentRecord;
import com.pomplatform.db.dao.EquipmentType;
import com.pomplatform.db.dao.PersonnelBusinessLinkEquipment;
import com.pomplatform.db.handler.EquipmentTypeHandler;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.util.ClientUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;
import pomplatform.workflow.personnelbusiness.bean.BasePersonnelBusinesWithP;
import pomplatform.workflow.personnelbusiness.dao.PersonnelBusinesWithP;

public class GoodsApplyWorker implements GenericWorkflowProcessor {

	private static final org.apache.log4j.Logger __logger = Logger.getLogger(GoodsApplyWorker.class);

	protected BasePersonnelBusinesWithP bean = new BasePersonnelBusinesWithP();


	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		int processType = pd.getProcessTypeId();
		bean.setProcessType(processType);
		List<BasePersonnelBusinessLinkEquipment> list = bean.getDetailPersonnelBusinessLinkEquipment();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
		for(BasePersonnelBusinessLinkEquipment obj : list){
			obj.setProcessType(processType);
			__logger.debug("---------------------------------------"+obj.toJSONString()+"---------------------------------------------------");
			//进行锁定库存操作
			BaseEquipmentType baseEquipmentType = new BaseEquipmentType();
			Integer EquipmentId = obj.getType();
			baseEquipmentType.setEquipmentTypeId(EquipmentId);
			String json = equipmentTypeDao.findUsingKey(baseEquipmentType.toJSON());
			baseEquipmentType.setDataFromJSON(json);
			__logger.debug("---------------------------------------"+baseEquipmentType.toJSONString()+"---------------------------------------------------");
			if(baseEquipmentType.getCount()-obj.getAmount()<0){
				throw new Exception("库存不足！");
			}
			baseEquipmentType.setCount(baseEquipmentType.getCount()-obj.getAmount());
			baseEquipmentType.setEquipmentTypeId(EquipmentId);
			equipmentTypeDao.update(baseEquipmentType.toJSON());
		}
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setDataFromBase(bean);
		dao.save();

	    addEquipmentcord(dao,employeeId,SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);

		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		Integer processId = pi.getProcessInstance().getBusinessId();
		//执行流程
		if(!modified) {
			updateEquipmentcord(processId,SystemProcessConstants.PROCESS_STATUS_WORKING);
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
//			updateEquipmentcord(processId,pi.getProcessInstance().getProcessStatus());

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
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		//修改流程
		if(modified){
			ThreadConnection.beginTransaction();
			deleteEquipmentCord(processId);
			List<BasePersonnelBusinessLinkEquipment> list = bean.getDetailPersonnelBusinessLinkEquipment();
			EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
			for(BasePersonnelBusinessLinkEquipment obj : list){
				__logger.debug("---------------------------------------"+obj.toJSONString()+"---------------------------------------------------");
				//进行锁定库存操作
				BaseEquipmentType baseEquipmentType = new BaseEquipmentType();
				Integer equipmentId = obj.getType();
				baseEquipmentType.setEquipmentTypeId(equipmentId);
				String json = equipmentTypeDao.findUsingKey(baseEquipmentType.toJSON());
				//剩余库存
				baseEquipmentType.setDataFromJSON(json);
				__logger.debug("---------------------------------------"+baseEquipmentType.toJSONString()+"---------------------------------------------------");
				if(baseEquipmentType.getCount()-obj.getAmount()<0){
					throw new Exception("库存不足！");
				}
				baseEquipmentType.setCount(baseEquipmentType.getCount()-obj.getAmount());
				baseEquipmentType.setEquipmentTypeId(equipmentId);
				equipmentTypeDao.update(baseEquipmentType.toJSON());
			}
			addEquipmentcord(dao,employeeId,SystemProcessConstants.PROCESS_STATUS_NEW_CREATED);
			ThreadConnection.commit();
		}
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				bean.setIsCompleted(true);
			}
		}
		if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)||
				pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)||
				pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_WORKING)) {
			updateEquipmentcord(processId,pi.getProcessInstance().getProcessStatus());
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
		List<BasePersonnelBusinessLinkEquipment> list = bean.getDetailPersonnelBusinessLinkEquipment();
		BigDecimal amount = BigDecimal.ZERO;
		if(null != list && !list.isEmpty()){
			for(BasePersonnelBusinessLinkEquipment obj : list){
				if(null != obj.getTotalPrice()){
					amount = amount.add(obj.getTotalPrice());
				}
			}
		}
		if(expression.contains("类型")){
			if(!BaseHelpUtils.isNullOrEmpty(bean.getType())){
				if(bean.getType()==1){
					e.setValue("类型","借用");
				}else if(bean.getType()==0){
					e.setValue("类型","领用");
				}
			}else{
				e.setValue("类型","");
			}

		}
		int nextAuditor = BaseHelpUtils.getIntValue(bean.getNextAuditor());
		if(expression.contains("物品类型")){
			if(!BaseHelpUtils.isNullOrEmpty(bean.getNextAuditor())){
				if(nextAuditor==1){
					e.setValue("物品类型","低值易耗品");
				}else if(nextAuditor==0){
					e.setValue("物品类型","IT物品");
				}else if (nextAuditor==2){
					e.setValue("物品类型","电子产品");
				}
			}else{
				e.setValue("物品类型","");
			}

		}

		e =OnWrokflowProcess.setExpression(expression, e, employeeId,amount, null, null);

		return delicacy.system.executor.ProcessUtil.executeExpression(e, expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusinesWithP dao = new PersonnelBusinesWithP();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBaseExt().toJSON();
	}

	/**
	 * 删除物品申请流程的操作
	 */
	public void deleteEquipmentCord(Integer followId) throws SQLException {

		EquipmentRecord recordDao = new EquipmentRecord();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();

		recordDao.setConditionFollowId("=",followId);
		List<BaseEquipmentRecord> baseEquipmentRecordList = recordDao.conditionalLoad();
		baseEquipmentRecordList.forEach(baseEquipmentRecord -> {
			//删除物品使用记录
			recordDao.clear();
			recordDao.setConditionFollowId("=",followId);
			try {
				recordDao.conditionalDelete();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//释放库存
			try {
				String json = equipmentTypeDao.findUsingKey("{\"equipmentTypeId\" : "+baseEquipmentRecord.getEquipmentId()+"}");
				BaseEquipmentType baseEquipmentType = new BaseEquipmentType();
				baseEquipmentType.setDataFromJSON(json);
				baseEquipmentType.setCount(baseEquipmentType.getCount()+baseEquipmentRecord.getCount());
				__logger.debug("-----------------------"+baseEquipmentType.toJSONString()+"-------------------");
				equipmentTypeDao.update(baseEquipmentType.toJSON());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * 新增物品申请流程记录
	 */
	private void addEquipmentcord(PersonnelBusinesWithP dao,Integer employeeId,Integer followerStatus) throws Exception {
        //物品操作类型
        short operationType = dao.getType().shortValue();
        int followerId = dao.getPersonnelBusinessId();
        EquipmentRecord recordDao = new EquipmentRecord();
        //流程发起 遍历 存入物品申请记录
        List<BasePersonnelBusinessLinkEquipment> basePersonnelBusinessLinkEquipments = bean.getDetailPersonnelBusinessLinkEquipment();
        basePersonnelBusinessLinkEquipments.forEach(b->{
            BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
            //物品id
            baseEquipmentRecord.setEquipmentId(b.getType());
            //流程id
            baseEquipmentRecord.setFollowId(followerId);
            //操作类型（借用 领用。。。）
            baseEquipmentRecord.setOperationType(operationType);
            //当前操作人id
            if(!BaseHelpUtils.isNullOrZero(employeeId))
                baseEquipmentRecord.setOperationPerson(employeeId);
            if(BaseHelpUtils.isNullOrEmpty(dao.getCreateTime())){
				baseEquipmentRecord.setOperationTime(new Date());
			}else{
				baseEquipmentRecord.setOperationTime(dao.getCreateTime());
			}
            baseEquipmentRecord.setCount(b.getAmount());
            baseEquipmentRecord.setFollowStatus(followerStatus.shortValue());
            __logger.debug("-----------------------------------"+baseEquipmentRecord.toJSONString()+"----------------------------");
            recordDao.clear();
            recordDao.setDataFromBase(baseEquipmentRecord);
            try {
                recordDao.save();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

	/**
	 *物品流程操作记录
	 */
	private void updateEquipmentcord(Integer followId,Integer followerStatus) throws SQLException {
		EquipmentRecord recordDao = new EquipmentRecord();
		EquipmentTypeHandler equipmentTypeDao = new EquipmentTypeHandler();
		//流程发起 遍历 存入物品申请记录
		List<BasePersonnelBusinessLinkEquipment> basePersonnelBusinessLinkEquipments = bean.getDetailPersonnelBusinessLinkEquipment();
		basePersonnelBusinessLinkEquipments.forEach(b->{
			BaseEquipmentRecord baseEquipmentRecord = new BaseEquipmentRecord();
			//物品id
			if(BaseHelpUtils.isNullOrEmpty(b.getCreateTime()))
				baseEquipmentRecord.setOperationTime(new Date());
			baseEquipmentRecord.setOperationTime(b.getCreateTime());
			baseEquipmentRecord.setFollowStatus(followerStatus.shortValue());
			__logger.debug("-----------------------------------"+baseEquipmentRecord.toJSONString()+"----------------------------");
			recordDao.clear();
			recordDao.setDataFromBase(baseEquipmentRecord);
			recordDao.setConditionFollowId("=",followId);
			try {
				recordDao.conditionalUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//流程驳回或者取消
			if(followerStatus==SystemProcessConstants.PROCESS_STATUS_REJECT
					||followerStatus==SystemProcessConstants.PROCESS_STATUS_DELAY_REJECT||followerStatus==SystemProcessConstants.PROCESS_STATUS_CANCELLED){
				//释放库存 "equipment_type_id" : b.getType();
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
