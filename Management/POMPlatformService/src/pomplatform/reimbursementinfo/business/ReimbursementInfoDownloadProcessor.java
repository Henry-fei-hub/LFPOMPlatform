package pomplatform.reimbursementinfo.business;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.TravelReimbursement;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.reimbursementinfo.bean.BaseReimbursementInfo;

public class ReimbursementInfoDownloadProcessor implements GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ReimbursementInfoDownloadProcessor.class);

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			List<BaseReimbursementInfo> list = new ArrayList<>();
			Integer drafterId = BaseHelpUtils.getIntValue(params.get("drafterId"));
			String code = BaseHelpUtils.getString(params.get("code"));
			if (null != code && code.length() > 0) {
				code = "%" + code + "%";
			}
			if (!drafterId.equals(0) || (null != code && code.length() > 0)) {
				// 用户查询数据
				searchDataFromTableProjectNormalReimbursement(drafterId, code, list);
				searchDataFromTableTravelReimbursement(drafterId, code, list);
				searchDataFromTableEmployeeMoneyManage(drafterId, code, list);
				searchDataFromTablePayMoneyManage(drafterId, code, list);
			} else {
				// 查询所有的流程实例的ProcessType和BusinessId
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.setConditionProcessInstanceId(">", 0);
				spi.setConditionProcessStatus("!=", SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> spiList = spi.conditionalLoad();
				Map<String, Integer> spiMap = new HashMap<>();
				for (BaseSystemProcessInstance obj : spiList) {
					spiMap.put(obj.getProcessType() + "_" + obj.getBusinessId(), obj.getBusinessId());
				}
				// 查出所有的收款信息的ProcessType和BusinessId
				ProcessBillList pbl = new ProcessBillList();
				pbl.setConditionProcessBillListId(">", 0);
				List<BaseProcessBillList> pblList = pbl.conditionalLoad();
				Map<String, Object> pblMap = new HashMap<>();
				for (BaseProcessBillList obj : pblList) {
					pblMap.put(obj.getProcessType() + "_" + obj.getBusinessId(), null);
				}
				// 只保留没有收款信息的流程实例的ProcessType和BusinessId
				for (String key : pblMap.keySet()) {
					spiMap.remove(key);
				}
				Set<Integer> set2 = new HashSet<>();
				Set<Integer> set3 = new HashSet<>();
				Set<Integer> set8 = new HashSet<>();
				Set<Integer> set10 = new HashSet<>();
				Set<Integer> set4 = new HashSet<>();
				Set<Integer> set5 = new HashSet<>();
				Set<Integer> set9 = new HashSet<>();
				Set<Integer> set6 = new HashSet<>();
				Set<Integer> set7 = new HashSet<>();
				for (String key : spiMap.keySet()) {
					String[] arr = key.split("_");
					switch (arr[0]) {
					case "2":
						set2.add(spiMap.get(key));
						break;
					case "3":
						set3.add(spiMap.get(key));
						break;
					case "8":
						set8.add(spiMap.get(key));
						break;
					case "10":
						set10.add(spiMap.get(key));
						break;

					case "4":
						set4.add(spiMap.get(key));
						break;
					case "5":
						set5.add(spiMap.get(key));
						break;
					case "9":
						set9.add(spiMap.get(key));
						break;

					case "6":
						set6.add(spiMap.get(key));
						break;
					case "7":
						set7.add(spiMap.get(key));
						break;
					default:
						break;
					}
				}
				if (!set2.isEmpty()) {
					getDataFromTableProjectNormalReimbursement(set2, 2, list);
				}
				if (!set3.isEmpty()) {
					getDataFromTableProjectNormalReimbursement(set3, 3, list);
				}
				if (!set8.isEmpty()) {
					getDataFromTableProjectNormalReimbursement(set8, 8, list);
				}
				if (!set10.isEmpty()) {
					getDataFromTableProjectNormalReimbursement(set10, 10, list);
				}
				if (!set4.isEmpty()) {
					getDataFromTableTravelReimbursement(set4, 4, list);
				}
				if (!set5.isEmpty()) {
					getDataFromTableTravelReimbursement(set5, 5, list);
				}
				if (!set9.isEmpty()) {
					getDataFromTableTravelReimbursement(set9, 9, list);
				}
				if (!set6.isEmpty()) {
					EmployeeMoneyManage dao = new EmployeeMoneyManage();
					dao.addCondition(BaseEmployeeMoneyManage.CS_EMPLOYEE_MONEY_MANAGE_ID, "in", set6.toArray());
					dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
					List<BaseEmployeeMoneyManage> tempList = dao.conditionalLoad();
					for (BaseEmployeeMoneyManage obj : tempList) {
						BaseReimbursementInfo bean = new BaseReimbursementInfo();
						bean.setProcessTypeId(6);
						bean.setBusinessId(obj.getEmployeeMoneyManageId());
						bean.setCode(obj.getCode());
						bean.setDrafterId(obj.getOperateEmployeeId());
						bean.setAmount(obj.getBorrowMoney());
						bean.setTitle(obj.getTitleName());
						list.add(bean);
					}
				}
				if (!set7.isEmpty()) {
					PayMoneyManage dao = new PayMoneyManage();
					dao.addCondition(BasePayMoneyManage.CS_PAY_MONEY_MANAGE_ID, "in", set7.toArray());
					dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
					List<BasePayMoneyManage> tempList = dao.conditionalLoad();
					for (BasePayMoneyManage obj : tempList) {
						BaseReimbursementInfo bean = new BaseReimbursementInfo();
						bean.setProcessTypeId(7);
						bean.setBusinessId(obj.getPayMoneyManageId());
						bean.setCode(obj.getCode());
						bean.setDrafterId(obj.getOperateEmployeeId());
						bean.setAmount(obj.getPayAmount());
						bean.setTitle(obj.getTitleName());
						list.add(bean);
					}
				}
			}

			try (PrintStream ps = new PrintStream(downFile, "GBK")) {
				ps.println(BaseReimbursementInfo.ALL_CAPTIONS);
				for (BaseReimbursementInfo b : list) {
					ps.println(b.toCSVString());
				}
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public void searchDataFromTableProjectNormalReimbursement(Integer drafterId, String code,
			List<BaseReimbursementInfo> list) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		if (!drafterId.equals(0)) {
			dao.setConditionApplyEmployeeId("=", drafterId);
		}
		if (null != code && code.length() > 0) {
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseProjectNormalReimbursement> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for (BaseProjectNormalReimbursement obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getProjectNormalReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getApplyEmployeeId());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getReimbursementName());
			map.put(obj.getProjectNormalReimbursementId(), bean);
		}
		if (!map.isEmpty()) {
			Object[] types = { 2, 3, 8, 10 };
			ProcessBillList billDao = new ProcessBillList();
			billDao.addCondition(BaseProcessBillList.CS_PROCESS_TYPE, "in", types);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if (null != billList && !billList.isEmpty()) {
				for (BaseProcessBillList obj : billList) {
					map.remove(obj.getBusinessId());
				}
			}
			if (!map.isEmpty()) {
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", types);
				spi.setConditionProcessStatus("!=", SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if (null != bspiList && !bspiList.isEmpty()) {
					for (BaseSystemProcessInstance obj : bspiList) {
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}

	public void searchDataFromTableTravelReimbursement(Integer drafterId, String code, List<BaseReimbursementInfo> list)
			throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		if (!drafterId.equals(0)) {
			dao.setConditionDrafter("=", drafterId);
		}
		if (null != code && code.length() > 0) {
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseTravelReimbursement> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for (BaseTravelReimbursement obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getTravelReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getDrafter());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getTitle());
			map.put(obj.getTravelReimbursementId(), bean);
		}
		if (!map.isEmpty()) {
			Object[] types = { 4, 5, 9 };
			ProcessBillList billDao = new ProcessBillList();
			billDao.addCondition(BaseProcessBillList.CS_PROCESS_TYPE, "in", types);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if (null != billList && !billList.isEmpty()) {
				for (BaseProcessBillList obj : billList) {
					map.remove(obj.getBusinessId());
				}
			}
			if (!map.isEmpty()) {
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", types);
				spi.setConditionProcessStatus("!=", SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if (null != bspiList && !bspiList.isEmpty()) {
					for (BaseSystemProcessInstance obj : bspiList) {
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}

	public void searchDataFromTableEmployeeMoneyManage(Integer drafterId, String code, List<BaseReimbursementInfo> list)
			throws Exception {
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		if (!drafterId.equals(0)) {
			dao.setConditionOperateEmployeeId("=", drafterId);
		}
		if (null != code && code.length() > 0) {
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseEmployeeMoneyManage> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for (BaseEmployeeMoneyManage obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getEmployeeMoneyManageId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getOperateEmployeeId());
			bean.setAmount(obj.getBorrowMoney());
			bean.setTitle(obj.getTitleName());
			map.put(obj.getEmployeeMoneyManageId(), bean);
		}
		if (!map.isEmpty()) {
			ProcessBillList billDao = new ProcessBillList();
			billDao.setConditionProcessType("=", 6);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if (null != billList && !billList.isEmpty()) {
				for (BaseProcessBillList obj : billList) {
					map.remove(obj.getBusinessId());
				}
			}
			if (!map.isEmpty()) {
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.setConditionProcessType("=", 6);
				spi.setConditionProcessStatus("!=", SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if (null != bspiList && !bspiList.isEmpty()) {
					for (BaseSystemProcessInstance obj : bspiList) {
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}

	public void searchDataFromTablePayMoneyManage(Integer drafterId, String code, List<BaseReimbursementInfo> list)
			throws Exception {
		PayMoneyManage dao = new PayMoneyManage();
		if (!drafterId.equals(0)) {
			dao.setConditionOperateEmployeeId("=", drafterId);
		}
		if (null != code && code.length() > 0) {
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BasePayMoneyManage> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for (BasePayMoneyManage obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getPayMoneyManageId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getOperateEmployeeId());
			bean.setAmount(obj.getPayAmount());
			bean.setTitle(obj.getTitleName());
			map.put(obj.getPayMoneyManageId(), bean);
		}
		if (!map.isEmpty()) {
			ProcessBillList billDao = new ProcessBillList();
			billDao.setConditionProcessType("=", 7);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if (null != billList && !billList.isEmpty()) {
				for (BaseProcessBillList obj : billList) {
					map.remove(obj.getBusinessId());
				}
			}
			if (!map.isEmpty()) {
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.setConditionProcessType("=", 7);
				spi.setConditionProcessStatus("!=", SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if (null != bspiList && !bspiList.isEmpty()) {
					for (BaseSystemProcessInstance obj : bspiList) {
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}

	public void getDataFromTableProjectNormalReimbursement(Set<Integer> set, Integer processTypeId,
			List<BaseReimbursementInfo> list) throws Exception {
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.addCondition(BaseProjectNormalReimbursement.CS_PROJECT_NORMAL_REIMBURSEMENT_ID, "in", set.toArray());
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseProjectNormalReimbursement> tempList = dao.conditionalLoad();
		for (BaseProjectNormalReimbursement obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setProcessTypeId(processTypeId);
			bean.setBusinessId(obj.getProjectNormalReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getApplyEmployeeId());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getReimbursementName());
			list.add(bean);
		}
	}

	public void getDataFromTableTravelReimbursement(Set<Integer> set, Integer processTypeId,
			List<BaseReimbursementInfo> list) throws Exception {
		TravelReimbursement dao = new TravelReimbursement();
		dao.addCondition(BaseTravelReimbursement.CS_TRAVEL_REIMBURSEMENT_ID, "in", set.toArray());
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseTravelReimbursement> tempList = dao.conditionalLoad();
		for (BaseTravelReimbursement obj : tempList) {
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setProcessTypeId(processTypeId);
			bean.setBusinessId(obj.getTravelReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getDrafter());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getTitle());
			list.add(bean);
		}
	}
}
