package pomplatform.workflow.purchase.handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BaseProductInquiryDetail;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.ProductInquiryDetail;

import delicacy.common.BaseHelpUtils;
import delicacy.common.BusinessAbstract;
import delicacy.common.GenericBase;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.dao.Employee;
import delicacy.system.executor.ProcessUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;

public class SproductinquirytotalporWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		List<BaseProductInquiryDetail> detailList = GenericBase.__getList(params.get("detailProductInquiryDetail"),
				BaseProductInquiryDetail.newInstance());
		if (null != detailList) {
			for (BaseProductInquiryDetail baseProductInquiryDetail : detailList) {
				baseProductInquiryDetail.setMainProjectId(dao.getProjectId());
			}
		}
		saveOrUpdateChildData(detailList, dao.getPersonnelBusinessId());
		bean.setPersonnelBusinessId(dao.getPersonnelBusinessId());
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified,
			boolean completed) throws Exception {
		int inquiryType = BaseHelpUtils.getIntValue(params, "inquiryType");
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
		List<BaseProductInquiryDetail> finalList = new ArrayList<>();
		if (inquiryType == 1) {// 表示为询价人员操作 询价人员操作时需要查询出其他人的数据加入到详情表
			ProductInquiryDetail pidDao = new ProductInquiryDetail();
			pidDao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
			List<BaseProductInquiryDetail> allList = pidDao.conditionalLoad();

			List<BaseProductInquiryDetail> oriList = GenericBase.__getList(params.get("detailProductInquiryDetail"),
					BaseProductInquiryDetail.newInstance());
			if (null != oriList && oriList.size() > 0) {
				int checkPersion = oriList.get(0).getPersonInCharge();
				for (BaseProductInquiryDetail baseProductInquiryDetail : allList) {
					if (!Objects.equals(baseProductInquiryDetail.getPersonInCharge(), checkPersion)) {
						oriList.add(baseProductInquiryDetail);
					}
				}
				finalList = oriList;
			} else {
				finalList = allList;
			}

		} else {
			finalList = GenericBase.__getList(params.get("detailProductInquiryDetail"),
					BaseProductInquiryDetail.newInstance());
		}

		dao.setDataFromBase(bean);
		if (completed) {
			if (pi.getProcessInstance().getProcessStatus().equals(SystemProcessConstants.PROCESS_STATUS_COMPLETED)) {
				for (BaseProductInquiryDetail baseProductInquiryDetail : finalList) {
					baseProductInquiryDetail.setIsPass(true);
				}
				dao.setIsCompleted(Boolean.TRUE);
			}
		}
		dao.update();
		if (null != finalList) {
			for (BaseProductInquiryDetail baseProductInquiryDetail : finalList) {
				baseProductInquiryDetail.setMainProjectId(dao.getProjectId());
			}
		}
		saveOrUpdateChildData(finalList, dao.getPersonnelBusinessId());
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
			if (Objects.equals(StaticUtils.ROLE_ID_101, roleId)) {
				Employee eDao = new Employee();
				eDao.setConditionStatus("=", 0);// 在职
				StringBuilder sql = new StringBuilder();
				sql.append(
						" employee_id in (SELECT person_in_charge FROM product_inquiry_details WHERE personnel_business_id =")
						.append(bean.getPersonnelBusinessId()).append(")");
				List<BaseEmployee> eList = eDao.conditionalLoad(sql.toString());
				if (null != eList && eList.size() > 0) {
					int size = eList.size();
					int[] arr = new int[size];
					for (int i = 0; i < size; i++) {
						arr[i] = eList.get(i).getEmployeeId();
					}
					return arr;
				} else {
					throw new SQLException("没有找到询价人员");
				}
			} else if (Objects.equals(StaticUtils.ROLE_CUSTOM_AUDITOR, roleId)) {// 自定义审核人为申请人审批
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
	public void saveOrUpdateChildData(List<BaseProductInquiryDetail> list, int businessId) throws SQLException {
		setDetailProductInquiryDetail(list);
		deleteAndSaveDetailTables(businessId);
	}

	private void deleteAndSaveDetailTables(int businessId) throws java.sql.SQLException {
		// instantiate 产品询价详情表 DAO
		ProductInquiryDetail productinquirydetail = new ProductInquiryDetail();
		// load the original details.
		productinquirydetail.setConditionPersonnelBusinessId("=", businessId);
		List<BaseProductInquiryDetail> originalproductinquirydetail = productinquirydetail.conditionalLoad(null);
		// if current detail is not empty.
		if (getDetailProductInquiryDetail() != null) {
			// need to delete list.
			List<BaseProductInquiryDetail> needToDeleteProductInquiryDetail = new ArrayList<>();
			// need to add list.
			List<BaseProductInquiryDetail> needToAddProductInquiryDetail = new ArrayList<>();
			// find the record that exists in the original list and update.
			for (BaseProductInquiryDetail __productinquirydetail : getDetailProductInquiryDetail()) {
				// set the relative field.
				__productinquirydetail.setPersonnelBusinessId(businessId);
				// set find flag
				boolean foundProductInquiryDetail = false;
				// find the original list.
				for (BaseProductInquiryDetail __originalproductinquirydetail : originalproductinquirydetail) {
					// if found the original record
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						// set found flag to true
						foundProductInquiryDetail = true;
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
				if (!foundProductInquiryDetail)
					needToAddProductInquiryDetail.add(__productinquirydetail);
			}
			// find the records that exists in the original list and not in the current
			// list.
			for (BaseProductInquiryDetail __originalproductinquirydetail : originalproductinquirydetail) {
				boolean foundProductInquiryDetail = false;
				for (BaseProductInquiryDetail __productinquirydetail : getDetailProductInquiryDetail()) {
					if (__productinquirydetail.compareTo(__originalproductinquirydetail) == 0) {
						foundProductInquiryDetail = true;
						break;
					}
				}
				if (!foundProductInquiryDetail)
					needToDeleteProductInquiryDetail.add(__originalproductinquirydetail);
			}
			// process need-to-add list
			for (BaseProductInquiryDetail __productinquirydetail : needToAddProductInquiryDetail) {
				productinquirydetail.clearCurrentData();
				productinquirydetail.setDataFromBase(__productinquirydetail);
				productinquirydetail.save();
				__productinquirydetail.setProductInquiryDetailId(productinquirydetail.getProductInquiryDetailId());
			}
			// process need-to-delete list
			for (BaseProductInquiryDetail __productinquirydetail : needToDeleteProductInquiryDetail) {
				deleteFromProductInquiryDetail(__productinquirydetail, productinquirydetail);
			}
		} else {
			// if current list is empty, then delete all original list.
			for (BaseProductInquiryDetail __productinquirydetail : originalproductinquirydetail) {
				deleteFromProductInquiryDetail(__productinquirydetail, productinquirydetail);
			}
		}
	}

	private void deleteFromProductInquiryDetail(BaseProductInquiryDetail bean, ProductInquiryDetail dao)
			throws java.sql.SQLException {
		dao.setDataFromBase(bean);
		dao.clearModifiedFlags();
		dao.delete();
	}

	protected List<BaseProductInquiryDetail> __detail_productinquirydetail;

	public List<BaseProductInquiryDetail> getDetailProductInquiryDetail() {
		return this.__detail_productinquirydetail;
	}

	public void setDetailProductInquiryDetail(List<BaseProductInquiryDetail> value) {
		this.__detail_productinquirydetail = value;
	}
}
