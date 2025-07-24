package pomplatform.supplierworkflow.handler;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BaseReceiveUnitManage;
import com.pomplatform.db.dao.K3Code;
import com.pomplatform.db.dao.ReceiveUnitManage;
import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.filemanage.business.FileManageProcessor;
import pomplatform.supplierworkflow.bean.BaseSupplierWithSs;
import pomplatform.supplierworkflow.dao.SupplierWithSs;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class SupplierComeInWorker implements GenericWorkflowProcessor {

	protected BaseSupplierWithSs bean = new BaseSupplierWithSs();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		SupplierWithSs dao = new SupplierWithSs();
		dao.setDataFromBase(bean);
		dao.save();
		int fileId=BaseHelpUtils.getIntValue(params.get("fileId"));
		if(fileId>0) {
			//增加附件的引用次数
			FileManageProcessor.addTimesById(bean.getFileId());
		}
		if(params.containsKey("receiveInfo")) {
			Map<String,Object> result=(Map<String, Object>) params.get("receiveInfo");
			ReceiveUnitManage rdao = new ReceiveUnitManage();
			BaseReceiveUnitManage baseReceiveUnitManage = new BaseReceiveUnitManage();
			baseReceiveUnitManage.setDataFromMap(result);
			rdao.setDataFromBase(baseReceiveUnitManage);
			rdao.setOperateTime(new Date());
			rdao.setOperateEmployeeId(dao.getOperateEmployeeId());
			rdao.setSupplierId(dao.getSupplierId());
			rdao.save();
			K3Code k3CodeDao = new K3Code();
			k3CodeDao.setType(StaticUtils.K3_CODE_TYPE_8);// 收款单位
			k3CodeDao.setBusinessId(rdao.getReceiveUnitManageId());
			k3CodeDao.save();
		}else {
			throw new Exception("找不到供应商收款信息");
		}
		BusinessAbstract ba = new BusinessAbstract(dao.getSupplierId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
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
		SupplierWithSs dao = new SupplierWithSs();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		ColumnChangedData attachmentIdData = dao.getColumnChangedData(BaseEmployeeMoneyManage.CS_FILE_ID);
		//修改附件的引用次数
		FileManageProcessor.upadteTimesByColumnChangedData(attachmentIdData);
		if(completed){
			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)){
				dao.setIsUse(StaticUtils.SUPPLIER_USE_STATUS_ENABLE);
			}

			if(pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)){
				dao.setIsUse(StaticUtils.SUPPLIER_USE_STATUS_DISENABLE);
			}
		}
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getSupplierId(), "");
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
		SupplierWithSs dao = new SupplierWithSs();
		dao.setSupplierId(businessId);
		dao.load();
		dao.setAttachment(FileManageProcessor.getFileUrlById(dao.getFileId()));
		return dao.generateBaseExt().toJSON();
	}
	public static void main(String[] args) throws SQLException {
		SupplierWithSs dao = new SupplierWithSs();
		dao.setSupplierId(14);
		dao.load();
	}
}
