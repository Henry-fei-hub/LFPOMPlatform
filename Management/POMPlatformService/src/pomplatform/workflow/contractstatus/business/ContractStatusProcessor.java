package pomplatform.workflow.contractstatus.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.contractstatus.bean.BaseContractThatCanEnd;
import pomplatform.workflow.contractstatus.bean.BaseContractThatHaveCostInWorkflow;
import pomplatform.workflow.contractstatus.bean.ConditionContractThatCanEnd;
import pomplatform.workflow.contractstatus.bean.ConditionContractThatHaveCostInWorkflow;
import pomplatform.workflow.contractstatus.query.QueryContractThatCanEnd;
import pomplatform.workflow.contractstatus.query.QueryContractThatHaveCostInWorkflow;

public class ContractStatusProcessor implements GenericProcessor{
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params, "optType");
        switch (optType) {
        case "canEndContractInfo":
        	return canEndContractInfo();
        case "getNewContractStatus":
        	return getNewContractStatus(params);
		default:
			break;
		}
        return null;
    }
    
    /**
     * 获取可以发起合同终止流程
     * @param params
     * @return
     * @throws SQLException
     */
	public String canEndContractInfo() throws SQLException {
		//查找100%回款，其下所有项目的项目积分都确认完毕，且项目成本已全部结算的合同
		ConditionContractThatCanEnd canEndCondition = new ConditionContractThatCanEnd();
		canEndCondition.setMoneyAttribute(StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1);
		canEndCondition.setContractStatus(StaticUtils.CONTRACT_STATUS_12);
		canEndCondition.setProjectCostStatus(StaticUtils.SETTLEMENT_STATUS_NO);
		QueryContractThatCanEnd canEndQuery = new QueryContractThatCanEnd();
		BaseCollection<BaseContractThatCanEnd> bc = canEndQuery.executeQuery(null, canEndCondition);
		if(null != bc && null != bc.getCollections() && !bc.getCollections().isEmpty()) {
			Map<Integer, BaseContractThatCanEnd> map = new HashMap<>();
			StringBuilder sb = new StringBuilder();
			for(BaseContractThatCanEnd bean : bc.getCollections()) {
				map.put(bean.getContractId(), bean);
				if(sb.length() > 0) {
					sb.append(",");
				}
				sb.append(bean.getContractId());
			}
			//查找出这些合同是否有还在流程中的成本，如果有，将其剔除
			ConditionContractThatHaveCostInWorkflow haveCostContidion = new ConditionContractThatHaveCostInWorkflow();
			haveCostContidion.setDeleteFlag(StaticUtils.NO_DELETE);
			haveCostContidion.setProcessTypeProjectNormal(StaticUtils.PROCESS_TYPE_2);
			haveCostContidion.setProcessTypeProjectTravel(StaticUtils.PROCESS_TYPE_4);
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("where a.contract_id = ?");
			kv.setValue(String.format("where a.contract_id = ? and a.contract_id in (%1$s)", sb.toString()));
			KeyValuePair[] kvs = {kv};
			QueryContractThatHaveCostInWorkflow haveCostQuery = new QueryContractThatHaveCostInWorkflow();
			BaseCollection<BaseContractThatHaveCostInWorkflow> haveCostBC = haveCostQuery.executeQuery(kvs, haveCostContidion);
			if(null == haveCostBC || null == haveCostBC.getCollections() || haveCostBC.getCollections().isEmpty()) {
				return bc.toJSON();
			}else {
				for(BaseContractThatHaveCostInWorkflow bean : haveCostBC.getCollections()) {
					map.remove(bean.getContractId());
				}
			}
			List<BaseContractThatCanEnd> list = new ArrayList<>();
			for(Integer key : map.keySet()) {
				list.add(map.get(key));
			}
			bc.setCollections(list);
		}
		return bc.toJSON();
	}
	
	public String getNewContractStatus(Map<String, Object> params) throws Exception {
		BaseCollection<BaseSystemDictionary> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
		if(contractId == 0) {
			return bc.toJSON();
		}
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		cDao.unsetSelectFlags();
		cDao.setSelectContractStatus(true);
		if(!cDao.load()) {
			return bc.toJSON();
		}
		Set<Integer> set = new HashSet<>();
		if(Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_1) || Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_4)) {//未出结果、项目缓慢
			set.add(StaticUtils.CONTRACT_STATUS_5);//项目暂停
			set.add(StaticUtils.CONTRACT_STATUS_14);//项目终止
		}else if(Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_5)) {//项目暂停
			set.add(StaticUtils.CONTRACT_STATUS_4);//项目缓慢
			set.add(StaticUtils.CONTRACT_STATUS_14);//项目终止
		}else if(Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_6) || Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_7) || Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_9)) {//合同运行、合同运行-收尾、合同缓慢
			set.add(StaticUtils.CONTRACT_STATUS_8);//合同暂停
			set.add(StaticUtils.CONTRACT_STATUS_11);//合同终止
			if(isContractCanEnd(contractId)) {
				set.add(StaticUtils.CONTRACT_STATUS_12);//合同结束
			}
		}else if(Objects.equals(cDao.getContractStatus(), StaticUtils.CONTRACT_STATUS_8)) {//合同暂停
			set.add(StaticUtils.CONTRACT_STATUS_6);//合同运行
			set.add(StaticUtils.CONTRACT_STATUS_11);//合同终止
			if(isContractCanEnd(contractId)) {
				set.add(StaticUtils.CONTRACT_STATUS_12);//合同结束
			}
		}
		if(!set.isEmpty()) {
			SystemDictionary dao = new SystemDictionary();
			dao.setConditionDicTypeId("=", 35);
			dao.addCondition(BaseSystemDictionary.CS_DIC_TYPE_VALUE_ID, "in", set.toArray());
			List<BaseSystemDictionary> list = dao.conditionalLoad();
			bc.setCollections(list);
		}
		return bc.toJSON();
	}
	
	public boolean isContractCanEnd(int contractId) throws SQLException{
		//查找100%回款，其下所有项目的项目积分都确认完毕，且项目成本已全部结算的合同
		ConditionContractThatCanEnd canEndCondition = new ConditionContractThatCanEnd();
		canEndCondition.setMoneyAttribute(StaticUtils.CAPITAL_MONEY_ATTRIBUTION_1);
		canEndCondition.setContractStatus(StaticUtils.CONTRACT_STATUS_12);
		canEndCondition.setProjectCostStatus(StaticUtils.SETTLEMENT_STATUS_NO);
		canEndCondition.setContractId(contractId);
		QueryContractThatCanEnd canEndQuery = new QueryContractThatCanEnd();
		BaseCollection<BaseContractThatCanEnd> bc = canEndQuery.executeQuery(null, canEndCondition);
		if(null == bc || null == bc.getCollections() || bc.getCollections().isEmpty()) {
			return false;
		}
		//查找出该合同是否有还在流程中的成本，如果有，返回false
		ConditionContractThatHaveCostInWorkflow haveCostContidion = new ConditionContractThatHaveCostInWorkflow();
		haveCostContidion.setDeleteFlag(StaticUtils.NO_DELETE);
		haveCostContidion.setProcessTypeProjectNormal(StaticUtils.PROCESS_TYPE_2);
		haveCostContidion.setProcessTypeProjectTravel(StaticUtils.PROCESS_TYPE_4);
		haveCostContidion.setContractId(contractId);
		QueryContractThatHaveCostInWorkflow haveCostQuery = new QueryContractThatHaveCostInWorkflow();
		BaseCollection<BaseContractThatHaveCostInWorkflow> haveCostBC = haveCostQuery.executeQuery(null, haveCostContidion);
		if(null != haveCostBC && null != haveCostBC.getCollections() && !haveCostBC.getCollections().isEmpty()) {
			return false;
		}
		ProjectAdvanceRecord advanceDao = new ProjectAdvanceRecord();
		advanceDao.setConditionLeftIntegral(">", BigDecimal.ZERO);
		String sql = String.format("project_id in (select project_id from projects where contract_id = %1$s)", contractId);
		if(advanceDao.countRows(sql) > 0){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		try {
			ContractStatusProcessor p = new ContractStatusProcessor();
			System.out.println(p.canEndContractInfo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
