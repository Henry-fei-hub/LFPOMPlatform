package pomplatform.reimbursementinfo.business;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeMoneyManage;
import com.pomplatform.db.bean.BasePayMoneyManage;
import com.pomplatform.db.bean.BaseProcessBillList;
import com.pomplatform.db.bean.BaseProjectNormalReimbursement;
import com.pomplatform.db.bean.BaseTravelReimbursement;
import com.pomplatform.db.dao.EmployeeMoneyManage;
import com.pomplatform.db.dao.PayMoneyManage;
import com.pomplatform.db.dao.ProcessBillList;
import com.pomplatform.db.dao.ProjectNormalReimbursement;
import com.pomplatform.db.dao.ProjectNormalReimbursementDetail;
import com.pomplatform.db.dao.TravelReimbursement;
import com.pomplatform.db.dao.TravelReimbursementDetail;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.reimbursementinfo.bean.BaseReimbursementInfo;

public class ReimbursementInfoProcessor implements GenericProcessor {

	public static void main(String[] args) {
		try{
			ReimbursementInfoProcessor a = new ReimbursementInfoProcessor();
			a.execute("{\"drafterId\":\"297\",\"optType\":\"loadInfo\"}", null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		BaseCollection<BaseEmployeeAchieveIntegralReturnRecord> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			JSON parser = new JSON(new StringReader(creteria));
			Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
			String optType = BaseHelpUtils.getString(params.get("optType"));
			switch (optType) {
			case "loadInfo":
				return loadInfo(params);
			case "completeInfo":
				return completeInfo(params);
			case "loadDetail":
				return loadDetail(params);
			case "needToComplete":
				return needToComplete(params);
			default:
				return null;
			}
		}
		return bc.toJSON(-1,"参数不能为空");
	}
	
	public String loadInfo(Map<String, Object> params) throws Exception {
		List<BaseReimbursementInfo> list = new ArrayList<>();
		Integer drafterId = BaseHelpUtils.getIntValue(params.get("drafterId"));
		String code = BaseHelpUtils.getString(params.get("code"));
		if(null != code && code.length() > 0){
			code = "%"+code+"%";
		}
		if (!drafterId.equals(0) || (null != code && code.length() > 0)) {
			//用户查询数据
			searchDataFromTableProjectNormalReimbursement(drafterId, code, list);
			searchDataFromTableTravelReimbursement(drafterId, code, list);
			searchDataFromTableEmployeeMoneyManage(drafterId, code, list);
			searchDataFromTablePayMoneyManage(drafterId, code, list);
		} else {
			// 查询所有的流程实例的ProcessType和BusinessId
			SystemProcessInstance spi = new SystemProcessInstance();
			spi.setConditionProcessInstanceId(">", 0);
			spi.setConditionProcessStatus("!=",SystemProcessConstants.PROCESS_STATUS_REJECT);
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
		BaseCollection<BaseReimbursementInfo> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON();
	}
	
	public void getDataFromTableProjectNormalReimbursement(Set<Integer> set, Integer processTypeId, List<BaseReimbursementInfo> list) throws Exception{
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		dao.addCondition(BaseProjectNormalReimbursement.CS_PROJECT_NORMAL_REIMBURSEMENT_ID, "in", set.toArray());
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseProjectNormalReimbursement> tempList = dao.conditionalLoad();
		for(BaseProjectNormalReimbursement obj : tempList){
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
	
	public void getDataFromTableTravelReimbursement(Set<Integer> set, Integer processTypeId, List<BaseReimbursementInfo> list) throws Exception{
		TravelReimbursement dao = new TravelReimbursement();
		dao.addCondition(BaseTravelReimbursement.CS_TRAVEL_REIMBURSEMENT_ID, "in", set.toArray());
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseTravelReimbursement> tempList = dao.conditionalLoad();
		for(BaseTravelReimbursement obj : tempList){
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

	public void searchDataFromTableProjectNormalReimbursement(Integer drafterId, String code, List<BaseReimbursementInfo> list) throws Exception{
		ProjectNormalReimbursement dao = new ProjectNormalReimbursement();
		if(!drafterId.equals(0)){
			dao.setConditionApplyEmployeeId("=", drafterId);
		}
		if(null != code && code.length() > 0){
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseProjectNormalReimbursement> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for(BaseProjectNormalReimbursement obj : tempList){
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getProjectNormalReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getApplyEmployeeId());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getReimbursementName());
			map.put(obj.getProjectNormalReimbursementId(), bean);
		}
		if(!map.isEmpty()){
			Object[] types = {2,3,8,10};
			ProcessBillList billDao = new ProcessBillList();
			billDao.addCondition(BaseProcessBillList.CS_PROCESS_TYPE, "in", types);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if(null != billList && !billList.isEmpty()){
				for(BaseProcessBillList obj : billList){
					map.remove(obj.getBusinessId());
				}
			}
			if(!map.isEmpty()){
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", types);
				spi.setConditionProcessStatus("!=",SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if(null != bspiList && !bspiList.isEmpty()){
					for(BaseSystemProcessInstance obj : bspiList){
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}
	
	public void searchDataFromTableTravelReimbursement(Integer drafterId, String code, List<BaseReimbursementInfo> list) throws Exception{
		TravelReimbursement dao = new TravelReimbursement();
		if(!drafterId.equals(0)){
			dao.setConditionDrafter("=", drafterId);
		}
		if(null != code && code.length() > 0){
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseTravelReimbursement> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for(BaseTravelReimbursement obj : tempList){
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getTravelReimbursementId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getDrafter());
			bean.setAmount(obj.getAmount());
			bean.setTitle(obj.getTitle());
			map.put(obj.getTravelReimbursementId(), bean);
		}
		if(!map.isEmpty()){
			Object[] types = {4,5,9};
			ProcessBillList billDao = new ProcessBillList();
			billDao.addCondition(BaseProcessBillList.CS_PROCESS_TYPE, "in", types);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if(null != billList && !billList.isEmpty()){
				for(BaseProcessBillList obj : billList){
					map.remove(obj.getBusinessId());
				}
			}
			if(!map.isEmpty()){
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.addCondition(BaseSystemProcessInstance.CS_PROCESS_TYPE, "in", types);
				spi.setConditionProcessStatus("!=",SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if(null != bspiList && !bspiList.isEmpty()){
					for(BaseSystemProcessInstance obj : bspiList){
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}
	
	public void searchDataFromTableEmployeeMoneyManage(Integer drafterId, String code, List<BaseReimbursementInfo> list) throws Exception{
		EmployeeMoneyManage dao = new EmployeeMoneyManage();
		if(!drafterId.equals(0)){
			dao.setConditionOperateEmployeeId("=", drafterId);
		}
		if(null != code && code.length() > 0){
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BaseEmployeeMoneyManage> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for(BaseEmployeeMoneyManage obj : tempList){
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getEmployeeMoneyManageId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getOperateEmployeeId());
			bean.setAmount(obj.getBorrowMoney());
			bean.setTitle(obj.getTitleName());
			map.put(obj.getEmployeeMoneyManageId(), bean);
		}
		if(!map.isEmpty()){
			ProcessBillList billDao = new ProcessBillList();
			billDao.setConditionProcessType("=", 6);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if(null != billList && !billList.isEmpty()){
				for(BaseProcessBillList obj : billList){
					map.remove(obj.getBusinessId());
				}
			}
			if(!map.isEmpty()){
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.setConditionProcessType("=", 6);
				spi.setConditionProcessStatus("!=",SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if(null != bspiList && !bspiList.isEmpty()){
					for(BaseSystemProcessInstance obj : bspiList){
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}
	public void searchDataFromTablePayMoneyManage(Integer drafterId, String code, List<BaseReimbursementInfo> list) throws Exception{
		PayMoneyManage dao = new PayMoneyManage();
		if(!drafterId.equals(0)){
			dao.setConditionOperateEmployeeId("=", drafterId);
		}
		if(null != code && code.length() > 0){
			dao.setConditionCode("like", code);
		}
		dao.setConditionDeleteFlag("=", StaticUtils.NO_DELETE);
		List<BasePayMoneyManage> tempList = dao.conditionalLoad();
		Map<Integer, BaseReimbursementInfo> map = new HashMap<>();
		for(BasePayMoneyManage obj : tempList){
			BaseReimbursementInfo bean = new BaseReimbursementInfo();
			bean.setBusinessId(obj.getPayMoneyManageId());
			bean.setCode(obj.getCode());
			bean.setDrafterId(obj.getOperateEmployeeId());
			bean.setAmount(obj.getPayAmount());
			bean.setTitle(obj.getTitleName());
			map.put(obj.getPayMoneyManageId(), bean);
		}
		if(!map.isEmpty()){
			ProcessBillList billDao = new ProcessBillList();
			billDao.setConditionProcessType("=", 7);
			billDao.addCondition(BaseProcessBillList.CS_BUSINESS_ID, "in", map.keySet().toArray());
			List<BaseProcessBillList> billList = billDao.conditionalLoad();
			if(null != billList && !billList.isEmpty()){
				for(BaseProcessBillList obj : billList){
					map.remove(obj.getBusinessId());
				}
			}
			if(!map.isEmpty()){
				SystemProcessInstance spi = new SystemProcessInstance();
				spi.addCondition(BaseSystemProcessInstance.CS_BUSINESS_ID, "in", map.keySet().toArray());
				spi.setConditionProcessType("=", 7);
				spi.setConditionProcessStatus("!=",SystemProcessConstants.PROCESS_STATUS_REJECT);
				List<BaseSystemProcessInstance> bspiList = spi.conditionalLoad();
				if(null != bspiList && !bspiList.isEmpty()){
					for(BaseSystemProcessInstance obj : bspiList){
						BaseReimbursementInfo bean = map.get(obj.getBusinessId());
						bean.setProcessTypeId(obj.getProcessType());
						list.add(bean);
					}
				}
			}
		}
	}
	
	public String completeInfo(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection();
		Integer processTypeId = BaseHelpUtils.getIntValue(params.get("processTypeId"));
		Integer businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
		Integer employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
		List<BaseProcessBillList> list = GenericBase.__getList(
				params.get("detailList"), BaseProcessBillList.newInstance());
		if(null != processTypeId && processTypeId.compareTo(0) > 0 && null != businessId && businessId.compareTo(0) > 0 && null != list && !list.isEmpty()){
			for(BaseProcessBillList obj : list){
				obj.setProcessType(processTypeId);
				obj.setBusinessId(businessId);
				obj.setOperator(employeeId);
			}
			ProcessBillList dao = new ProcessBillList();
			dao.save(list);
			return bc.toJSON();
		}
		return bc.toJSON(-1,"数据不全，保存失败");
	}
	
	public String loadDetail(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection();
		Integer processTypeId = BaseHelpUtils.getIntValue(params.get("processTypeId"));
		Integer businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
		if(null != processTypeId && processTypeId.compareTo(0) > 0 && null != businessId && businessId.compareTo(0) > 0){
			switch (processTypeId) {
			case StaticUtils.PROCESS_TYPE_2:
			case StaticUtils.PROCESS_TYPE_3:
			case StaticUtils.PROCESS_TYPE_8:
			case StaticUtils.PROCESS_TYPE_10:
				ProjectNormalReimbursementDetail dao1 = new ProjectNormalReimbursementDetail();
				dao1.setConditionProjectNormalReimbursementId("=", businessId);
				bc.setCollections(dao1.conditionalLoad());
				break;
			case StaticUtils.PROCESS_TYPE_4:
			case StaticUtils.PROCESS_TYPE_5:
			case StaticUtils.PROCESS_TYPE_9:
				TravelReimbursementDetail dao2 = new TravelReimbursementDetail();
				dao2.setConditionTravelReimbursementId("=", businessId);
				bc.setCollections(dao2.conditionalLoad());
				break;
			case StaticUtils.PROCESS_TYPE_6:
				EmployeeMoneyManage dao3 = new EmployeeMoneyManage();
				dao3.setConditionEmployeeMoneyManageId("=", businessId);
				bc.setCollections(dao3.conditionalLoad());
				break;
			case StaticUtils.PROCESS_TYPE_7:
				PayMoneyManage dao4 = new PayMoneyManage();
				dao4.setConditionPayMoneyManageId("=", businessId);
				bc.setCollections(dao4.conditionalLoad());
				break;
			default:
				break;
			}
			return bc.toJSON();
		}
		return bc.toJSON(-1,"数据不全，保存失败");
	}
	
	public String needToComplete(Map<String, Object> params) throws Exception {
		BaseCollection bc = new BaseCollection();
		Integer processTypeId = BaseHelpUtils.getIntValue(params.get("processTypeId"));
		Integer businessId = BaseHelpUtils.getIntValue(params.get("businessId"));
		if(null != processTypeId && processTypeId.compareTo(0) > 0 && null != businessId && businessId.compareTo(0) > 0){
			ProcessBillList dao = new ProcessBillList();
			dao.setConditionProcessType("=", processTypeId);
			dao.setConditionBusinessId("=", businessId);
			if(dao.countRows()>0){
				return bc.toJSON(-1,"该记录已有收款信息，无需再次补全");
			}else{
				return bc.toJSON();
			}
		}
		return bc.toJSON(-1,"数据不全，保存失败");
	}
}
