package pomplatform.workflow.purchase.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProductStorage;
import com.pomplatform.db.bean.BasePurchaseContract;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.ProductStorage;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;

public class PurchaseWarehousingWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@SuppressWarnings("unchecked")
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		List<BaseProductStorage> detailList = GenericBase.__getList(params.get("detailProductStorage"),
				BaseProductStorage.newInstance());
		List<BaseProductStorage> newList = new ArrayList<>();
		if (null != detailList) {
			Date currentDate = new Date();
			for (BaseProductStorage baseProductStorage : detailList) {
				if(null != baseProductStorage.getProductNumber() && baseProductStorage.getProductNumber() > 0) {
					baseProductStorage.setPersonnelBusinessId(dao.getPersonnelBusinessId());
					baseProductStorage.setCreateTime(currentDate);
					baseProductStorage.setPurchaseContractId(dao.getParentId());
					baseProductStorage.setSupplierId(dao.getDutyId());
					baseProductStorage.setIsComplete(Boolean.FALSE);
					if(null != baseProductStorage.getCreateEmployeeId()) {
						baseProductStorage.setCreateEmployeeId(dao.getDrafter());
					}
					newList.add(baseProductStorage);
				}
			}
		}
		saveOrUpdateChildData(newList, dao.getPersonnelBusinessId());
		bean.setPersonnelBusinessId(dao.getPersonnelBusinessId());
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if (!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if (BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}

			// 获取当前审批节点
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if (BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			// 获取当前节点类型
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			// 只有处理节点才可以更改数据
			if (!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {// 处理节点
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if (!dao.load()) {
			throw new SQLException("Business data not found");
		}

		dao.setDataFromBase(bean);
		List<BaseProductStorage> detailList = GenericBase.__getList(params.get("detailProductStorage"),
				BaseProductStorage.newInstance());
		List<BaseProductStorage> newList = new ArrayList<>();
		for (BaseProductStorage baseProductStorage : detailList) {
			if(null != baseProductStorage.getProductNumber() && baseProductStorage.getProductNumber() > 0) {
				newList.add(baseProductStorage);
			}
		}
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				dao.setIsCompleted(Boolean.TRUE);
				for (BaseProductStorage baseProductStorage : newList) {
					baseProductStorage.setIsComplete(Boolean.TRUE);
				}
			} else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
			}
		}
		dao.update();
		
		saveOrUpdateChildData(newList, dao.getPersonnelBusinessId());
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		return ProcessUtil.executeExpression(expression, "name to replace here", "value to replace here");
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId,
			Integer poolType) throws Exception {
		if (null != roleId) {
			if (Objects.equals(StaticUtils.ROLE_CUSTOM_AUDITOR, roleId)) {// 自定义审核人为申请人审批
				return new int[] { bean.getDrafter() };
			}
		}
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
	 * 保存或更改详情表数据集
	 * 
	 * @param params
	 * @param isUpdate
	 * @throws SQLException
	 */
	public void saveOrUpdateChildData(List<BaseProductStorage> list, int businessId) throws SQLException {
		setDetailProductStorage(list);
		deleteAndSaveDetailTables(businessId);
	}

	private void deleteAndSaveDetailTables(int businessId) throws java.sql.SQLException {
		// instantiate 产品询价详情表 DAO
		ProductStorage productinquirydetail = new ProductStorage();
		// load the original details.
		productinquirydetail.setConditionPersonnelBusinessId("=", businessId);
		List<BaseProductStorage> originalproductinquirydetail = productinquirydetail.conditionalLoad(null);
		// if current detail is not empty.
		if (getDetailProductStorage() != null) {
			// need to delete list.
			List<BaseProductStorage> needToDeleteProductStorage = new ArrayList<>();
			// need to add list.
			List<BaseProductStorage> needToAddProductStorage = new ArrayList<>();
			// find the record that exists in the original list and update.
			for (BaseProductStorage __productinquirydetail : getDetailProductStorage()) {
				// set the relative field.
				__productinquirydetail.setPersonnelBusinessId(businessId);
				// set find flag
				boolean foundProductStorage = false;
				// find the original list.
				for (BaseProductStorage __originalproductinquirydetail : originalproductinquirydetail) {
					// if found the original record
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						// set found flag to true
						foundProductStorage = true;
						// update the record.
						// clear DAO's data
						productinquirydetail.clearCurrentData();
						// set original data into DAO
						productinquirydetail.setDataFromBase(__originalproductinquirydetail);
						// clear DAO modification flag, just like the is loaded from DB
						productinquirydetail.clearModifiedFlags();
						// set current data into DAO
						productinquirydetail.setDataFromBase(__productinquirydetail);
						// execute update
						productinquirydetail.update();
						break;
					}
				}
				// if not found, then add it to need-to-add list
				if (!foundProductStorage)
					needToAddProductStorage.add(__productinquirydetail);
			}
			// find the records that exists in the original list and not in the current
			// list.
			for (BaseProductStorage __originalproductinquirydetail : originalproductinquirydetail) {
				boolean foundProductStorage = false;
				for (BaseProductStorage __productinquirydetail : getDetailProductStorage()) {
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						foundProductStorage = true;
						break;
					}
				}
				if (!foundProductStorage)
					needToDeleteProductStorage.add(__originalproductinquirydetail);
			}
			// process need-to-add list
			for (BaseProductStorage __productinquirydetail : needToAddProductStorage) {
				productinquirydetail.clearCurrentData();
				productinquirydetail.setDataFromBase(__productinquirydetail);
				productinquirydetail.save();
				__productinquirydetail.setProductStorageId(productinquirydetail.getProductStorageId());
			}
			// process need-to-delete list
			for (BaseProductStorage __productinquirydetail : needToDeleteProductStorage) {
				deleteFromProductStorage(__productinquirydetail, productinquirydetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for (BaseProductStorage __productinquirydetail : originalproductinquirydetail) {
				deleteFromProductStorage(__productinquirydetail, productinquirydetail);
			}
		}
	}

	private void deleteFromProductStorage(BaseProductStorage bean, ProductStorage dao)
			throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.delete();
	}

	protected List<BaseProductStorage> __detail_productinquirydetail;

	public List<BaseProductStorage> getDetailProductStorage() {
		return this.__detail_productinquirydetail;
	}

	public void setDetailProductStorage(List<BaseProductStorage> value) {
		this.__detail_productinquirydetail = value;
	}
	
	/**
	 * 关联相关数据
	 * @param pbBean
	 * @param pcBean
	 * @throws SQLException
	 */
	private void updateLinkDetailData(BasePersonnelBusines pbBean, BasePurchaseContract pcBean) throws SQLException {
	}
}
