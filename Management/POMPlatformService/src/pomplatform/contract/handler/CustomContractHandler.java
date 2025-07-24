
package pomplatform.contract.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.pomplatform.db.bean.BaseBusinessLineRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.dao.BusinessLineRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.handler.ContractHandler;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.MapUtils;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import delicacy.system.executor.NewCreateWorkFlow;
import delicacy.system.executor.SelectValueCache;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.bean.BaseGetProcessByTypeAndDepartment;
import pomplatform.workflow.bean.ConditionGetProcessByTypeAndDepartment;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;
import pomplatform.workflow.query.QueryGetProcessByTypeAndDepartment;

public class CustomContractHandler extends ContractHandler {
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public String update(String json) throws Exception {
		BaseContract bean = new BaseContract();
		BaseBusinessLineRecord beanLine =new BaseBusinessLineRecord();
		BusinessLineRecord  Bdao=new BusinessLineRecord();
		bean.setDataFromJSON(json);
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> result = (Map<String, Object>) parser.parse(new BasicHandler());
		if (BaseHelpUtils.getIntValue(result.get("customerId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(result.get("customerId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(result.get("customerId")));
			if(customer.load()) {
				bean.setCustomerName(customer.getCustomerName());
				bean.setCustomerId(BaseHelpUtils.getIntValue(result.get("customerId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}
		
		
		List<Map<String,Object>>  list =(List<Map<String, Object>>) result.get("businessLine");
		int contractId = BaseHelpUtils.getIntValue(result.get("contractId"));
		int operator = BaseHelpUtils.getIntValue(result.get("operator"));
		Bdao.setConditionContractId("=",contractId);
		List<BaseBusinessLineRecord> brList=Bdao.conditionalLoad();
		ThreadConnection.beginTransaction();
		//如果条线记录表存在此合同记录,则更新此合同记录的业态以及金额
		if(!BaseHelpUtils.isNullOrEmpty(list)&&list.size()!=0) {
			for (Map<String, Object> map : list) {
				//获取数据库中的业态ID与前台传过来的对比
				int businessLineId=BaseHelpUtils.getIntValue(map.get("businessLineId"));
				//获取条线的合同金额
				BigDecimal businessAmount = BaseHelpUtils.getBigDecimalValue(map.get("businessAmount"));
				boolean isExit = false;
				for (BaseBusinessLineRecord baseBusinessLineRecord : brList) {
					//如果业态ID相等，说明数据库中已存在，则只需做金额更新
					if(baseBusinessLineRecord.getBusinessLineId()==businessLineId) {
						isExit = true;
						break;
					}

				}
				if(isExit){//说明存在，则只需做金额更新
					Bdao.clear();
					Bdao.setConditionContractId("=",contractId);
					Bdao.setConditionBusinessLineId("=",businessLineId);
					Bdao.setBusinessAmount(businessAmount);
					Bdao.conditionalUpdate();
				}else {//说明该条线数据在库中不存在，则需插入
					Bdao.clear();
					Bdao.setContractId(contractId);
					Bdao.setBusinessLineId(businessLineId);
					Bdao.setBusinessAmount(businessAmount);
					Bdao.save();
				}
			}
			
			//检索数据库中存在，但新列表数据不存在，则需删除
			for(BaseBusinessLineRecord baseBusinessLineRecord : brList) {
				//获取业态ID
				int businessLineId = BaseHelpUtils.getIntValue(baseBusinessLineRecord.getBusinessLineId());
				boolean isExit = false;
				for(Map<String, Object> map : list) {
					if(businessLineId == BaseHelpUtils.getIntValue(map.get("businessLineId"))) {
						isExit = true;
						break;
					}
				}
				if(!isExit){//表示数据库中存在但新列表数据不存在，则需进行删除
					Bdao.clear();
					Bdao.setConditionContractId("=",contractId);
					Bdao.setConditionBusinessLineId("=",businessLineId);
					Bdao.conditionalDelete();
				}
			}

		}else {//如果前台传的空数据，则清除掉数据库中数据
			Bdao.clear();
			Bdao.setConditionContractId("=",contractId);
			Bdao.conditionalDelete();
		}
		Contract dao = new Contract();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){
			Integer originalContractStatus = dao.getContractStatus();
			dao.setDataFromBase(bean); 
			ColumnChangedData change = dao.getColumnChangedData(BaseContract.CS_CONTRACT_SIGNING_STATUS);
			if(null != change){
				
				ContractStatusUtils util = new ContractStatusUtils();
				if(Objects.equals(dao.getContractSigningStatus(), StaticUtils.CONTRACT_SIGING_STATUS_1) && Objects.equals(change.getOriginal(), StaticUtils.CONTRACT_SIGING_STATUS_2)) {
					//合同签约状态从已签订改为已寄出
					throw new Exception("合同签约状态不允许从已签订改为已寄出");
				}else if(Objects.equals(dao.getContractSigningStatus(), StaticUtils.CONTRACT_SIGING_STATUS_2)) {
					//已签约，改合同状态为合同运行
					if(Objects.equals(originalContractStatus, StaticUtils.CONTRACT_STATUS_5)) {
						//如果之前的合同状态为项目暂停，则改为合同暂停
						dao.setContractStatus(StaticUtils.CONTRACT_STATUS_8);
					}else if(Objects.equals(originalContractStatus, StaticUtils.CONTRACT_STATUS_1) || Objects.equals(originalContractStatus, StaticUtils.CONTRACT_STATUS_4)) {
						//如果之前的合同状态为项目缓慢或未出结果，则改为合同运行
						dao.setContractStatus(StaticUtils.CONTRACT_STATUS_6);
					}
					util.updateProjectStatusWithLog(contractId, originalContractStatus, dao.getContractStatus(), operator, "合同签约状态变为已签订");
				}else if(Objects.equals(dao.getContractSigningStatus(), StaticUtils.CONTRACT_SIGING_STATUS_5)) {
					//已关闭，自动触发流程“项目终止”
					NewCreateWorkFlow createWorkFlow = new NewCreateWorkFlow();
					Employee eDao = new Employee();
					eDao.setEmployeeId(operator);
					if(!eDao.load()) {
						throw new SQLException("无法找到操作人的信息，无法发起项目终止流程");
					}
					ConditionGetProcessByTypeAndDepartment condition = new ConditionGetProcessByTypeAndDepartment();
					condition.setProcessTypeId(StaticUtils.PROCESS_TYPE_64);
					condition.setDepartmentId(eDao.getDepartmentId());
					QueryGetProcessByTypeAndDepartment query = new QueryGetProcessByTypeAndDepartment();
					BaseCollection<BaseGetProcessByTypeAndDepartment> collection = query.executeQuery(null, condition);
					if (BaseHelpUtils.isNullOrEmpty(collection) || collection.getCollections().isEmpty()) {
						throw new SQLException(String.format("操作异常：职员(%1$s)所在部门(%2$s)未绑定合同状态变更流程", eDao.getEmployeeName(), SelectValueCache.getSelectValue("all_departments", eDao.getDepartmentId().toString())));
					}
					Map<String, Object> map = new HashMap<>();
					Map<String, Integer> processInfoMap = new HashMap<>();
					Map<String, Object> userData = new HashMap<>();
					processInfoMap.put("processId", collection.getCollections().get(0).getProcessId());
					map.put("processDefinition", processInfoMap);
					userData.put("contractId", dao.getContractId());
					userData.put("originalStatus", dao.getContractStatus());
					userData.put("newStatus", StaticUtils.CONTRACT_STATUS_14);
					userData.put("content", "合同补录页面，修改合同签约状态为已关闭，自动触发流程“项目终止”");
					userData.put("operator", operator);
					map.put("userData", userData);
					createWorkFlow.execute(MapUtils.toJSON(map), operator, false);
				}
			}
			num = dao.update(); 
			ThreadConnection.commit();
			return bean.toOneLineJSON(num, null);
		}else {
			ThreadConnection.rollback();
			return bean.toOneLineJSON(-1, "不存在此合同");
		}
	}


}
