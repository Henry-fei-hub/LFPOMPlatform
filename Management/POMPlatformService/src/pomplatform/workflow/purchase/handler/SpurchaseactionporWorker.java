package pomplatform.workflow.purchase.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePurchaseContract;
import com.pomplatform.db.bean.BasePurchasePayment;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PurchaseContract;
import com.pomplatform.db.dao.PurchasePayment;
import com.pomplatform.db.dao.PurchasePlan;
import com.pomplatform.db.dao.PurchaseProductDetail;

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

public class SpurchaseactionporWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@SuppressWarnings("unchecked")
	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		List<BasePurchasePayment> detailList = GenericBase.__getList(params.get("detailPurchasePaymentDetail"),
				BasePurchasePayment.newInstance());
		if (null != detailList) {
			Date currentDate = new Date();
			for (BasePurchasePayment basePurchasePayment : detailList) {
				basePurchasePayment.setCreateTime(currentDate);
				basePurchasePayment.setPersonInCharge(dao.getDrafter());
				basePurchasePayment.setOperatorId(dao.getDrafter());
			}
		}
		updatePurchasePlan(dao.getParentId(), 1, null, dao.getPersonnelBusinessId());
		saveOrUpdateChildData(detailList, dao.getPersonnelBusinessId());
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
		List<BasePurchasePayment> detailList = GenericBase.__getList(params.get("detailPurchasePaymentDetail"),
				BasePurchasePayment.newInstance());
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				// 插入采购合同
				BasePurchaseContract contractBase = savePurchaseContract(dao.generateBase());
				updatePurchasePlan(dao.getParentId(), 3, contractBase.getPurchaseContractId(), dao.getPersonnelBusinessId());
				updateLinkDetailData(dao.generateBase(), contractBase);
				// 更新关联字表数据
				for (BasePurchasePayment basePurchasePayment : detailList) {
					basePurchasePayment.setPurchasePaymentStatus(SystemProcessConstants.PROCESS_STATUS_COMPLETED);
					basePurchasePayment.setPurchaseContractId(contractBase.getPurchaseContractId());
				}
				dao.setIsCompleted(Boolean.TRUE);
			} else if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_REJECT)) {
				updatePurchasePlan(dao.getParentId(), 2, null, dao.getPersonnelBusinessId());
			}
		}
		dao.update();
		
		saveOrUpdateChildData(detailList, dao.getPersonnelBusinessId());
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
//			if (Objects.equals(StaticUtils.ROLE_ID_101, roleId)) {
//				Employee eDao = new Employee();
//				eDao.setConditionStatus("=", 0);// 在职
//				StringBuilder sql = new StringBuilder();
//				sql.append(
//						" employee_id in (SELECT person_in_charge FROM product_inquiry_details WHERE personnel_business_id =")
//						.append(bean.getPersonnelBusinessId()).append(")");
//				List<BaseEmployee> eList = eDao.conditionalLoad(sql.toString());
//				if (null != eList && eList.size() > 0) {
//					int size = eList.size();
//					int[] arr = new int[size];
//					for (int i = 0; i < size; i++) {
//						arr[i] = eList.get(i).getEmployeeId();
//					}
//					return arr;
//				} else {
//					throw new SQLException("没有找到询价人员");
//				}
//			} else
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
	public void saveOrUpdateChildData(List<BasePurchasePayment> list, int businessId) throws SQLException {
		setDetailPurchasePayment(list);
		deleteAndSaveDetailTables(businessId);
	}

	private void deleteAndSaveDetailTables(int businessId) throws java.sql.SQLException {
		// instantiate 产品询价详情表 DAO
		PurchasePayment productinquirydetail = new PurchasePayment();
		// load the original details.
		productinquirydetail.setConditionPersonnelBusinessId("=", businessId);
		List<BasePurchasePayment> originalproductinquirydetail = productinquirydetail.conditionalLoad(null);
		// if current detail is not empty.
		if (getDetailPurchasePayment() != null) {
			// need to delete list.
			List<BasePurchasePayment> needToDeletePurchasePayment = new ArrayList<>();
			// need to add list.
			List<BasePurchasePayment> needToAddPurchasePayment = new ArrayList<>();
			// find the record that exists in the original list and update.
			for (BasePurchasePayment __productinquirydetail : getDetailPurchasePayment()) {
				// set the relative field.
				__productinquirydetail.setPersonnelBusinessId(businessId);
				// set find flag
				boolean foundPurchasePayment = false;
				// find the original list.
				for (BasePurchasePayment __originalproductinquirydetail : originalproductinquirydetail) {
					// if found the original record
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						// set found flag to true
						foundPurchasePayment = true;
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
				if (!foundPurchasePayment)
					needToAddPurchasePayment.add(__productinquirydetail);
			}
			// find the records that exists in the original list and not in the current
			// list.
			for (BasePurchasePayment __originalproductinquirydetail : originalproductinquirydetail) {
				boolean foundPurchasePayment = false;
				for (BasePurchasePayment __productinquirydetail : getDetailPurchasePayment()) {
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						foundPurchasePayment = true;
						break;
					}
				}
				if (!foundPurchasePayment)
					needToDeletePurchasePayment.add(__originalproductinquirydetail);
			}
			// process need-to-add list
			for (BasePurchasePayment __productinquirydetail : needToAddPurchasePayment) {
				productinquirydetail.clearCurrentData();
				productinquirydetail.setDataFromBase(__productinquirydetail);
				productinquirydetail.save();
				__productinquirydetail.setPurchasePaymentId(productinquirydetail.getPurchasePaymentId());
			}
			// process need-to-delete list
			for (BasePurchasePayment __productinquirydetail : needToDeletePurchasePayment) {
				deleteFromPurchasePayment(__productinquirydetail, productinquirydetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for (BasePurchasePayment __productinquirydetail : originalproductinquirydetail) {
				deleteFromPurchasePayment(__productinquirydetail, productinquirydetail);
			}
		}
	}

	private void deleteFromPurchasePayment(BasePurchasePayment bean, PurchasePayment dao)
			throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.delete();
	}

	protected List<BasePurchasePayment> __detail_productinquirydetail;

	public List<BasePurchasePayment> getDetailPurchasePayment() {
		return this.__detail_productinquirydetail;
	}

	public void setDetailPurchasePayment(List<BasePurchasePayment> value) {
		this.__detail_productinquirydetail = value;
	}
	
	/**
	 * 插入采购合同
	 * @param base
	 * @return
	 * @throws SQLException
	 */
	private BasePurchaseContract savePurchaseContract(BasePersonnelBusines base) throws SQLException {
		PurchaseContract pcDao = new PurchaseContract();
		pcDao.setPurchasePerson(base.getDrafter());
		pcDao.setContractAmount(base.getFee());
		pcDao.setPersonnelBusinessId(base.getPersonnelBusinessId());
		pcDao.setContractAttachment(base.getLinkId());
		pcDao.setContractCode(base.getCard());
		pcDao.setSupplierId(base.getDutyId());
		pcDao.setContractName(base.getProjectName());
		pcDao.setQualityAssurance(base.getPlan());
		pcDao.setTermOfPayment(base.getReason());
		pcDao.setAfterSaleRequirements(base.getRemark());
		pcDao.setMainProjectId(base.getProjectId());
		pcDao.setCreateTime(new Date());
		pcDao.setContractDate(base.getStartDate());
		pcDao.setProjectName(base.getProjectName());
		pcDao.save();
		return pcDao.generateBase();
	}
	
	/**
	 * 修改采购计划表数据
	 * @param purchasePlanId
	 * @param dealStatus
	 * @param purchaseContractId
	 * @throws SQLException
	 */
	private void updatePurchasePlan(Integer purchasePlanId, Integer dealStatus, Integer purchaseContractId, Integer toPersonnelBusinessId) throws SQLException {
		PurchasePlan dao = new PurchasePlan();
		dao.setPurchasePlanId(purchasePlanId);
		if(dao.load()) {
			dao.setDealStatus(dealStatus);
			dao.setPurchaseContractId(purchaseContractId);
			dao.setToPersonnelBusinessId(toPersonnelBusinessId);
			dao.update();
		}
	}
	
	/**
	 * 关联相关数据
	 * @param pbBean
	 * @param pcBean
	 * @throws SQLException
	 */
	private void updateLinkDetailData(BasePersonnelBusines pbBean, BasePurchaseContract pcBean) throws SQLException {
		// 关联采购产品详情表
		PurchaseProductDetail dao = new PurchaseProductDetail();
		dao.setConditionPersonnelBusinessId("=", pbBean.getCompanyProvince());
		dao.setConditionSupplierId("=", pbBean.getDutyId());
		dao.setPurchaseContractId(pcBean.getPurchaseContractId());
		dao.conditionalUpdate();
	}
}
