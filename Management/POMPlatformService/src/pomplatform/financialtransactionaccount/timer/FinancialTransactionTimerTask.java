package pomplatform.financialtransactionaccount.timer;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TimerTask;

import com.pomplatform.db.bean.BaseFinancialTransactionDetail;
import com.pomplatform.db.dao.FinancialTransactionDetail;

import delicacy.common.BaseCollection;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.system.executor.SystemProcessConstants;
import pomplatform.common.utils.StaticUtils;
import pomplatform.financialtransactionaccount.bean.BaseGetTransDetailsNeedToDelete;
import pomplatform.financialtransactionaccount.bean.BaseProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.bean.BaseProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.bean.ConditionGetTransDetailsNeedToDelete;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.bean.ConditionProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.query.QueryGetTransDetailsNeedToDelete;
import pomplatform.financialtransactionaccount.query.QueryProcessInfoInTransDetail;
import pomplatform.financialtransactionaccount.query.QueryProcessInstWithoutTransDetails;
import pomplatform.financialtransactionaccount.utils.FinancialTransactionAccountUtils;

public class FinancialTransactionTimerTask extends TimerTask{

	@Override
	public void run() {
		try {
			//从哪天开始生成往来明细
			Date startDate = DateUtil.createDate(2016, 12, 1);
			//查找需要新增到往来明细表中的数据
			String processTypes = String.format("%1$s,%2$s,%3$s,%4$s,%5$s,%6$s,%7$s,%8$s,%9$s,%10$s,%11$s", StaticUtils.PROCESS_TYPE_2, StaticUtils.PROCESS_TYPE_3, StaticUtils.PROCESS_TYPE_4, StaticUtils.PROCESS_TYPE_5, StaticUtils.PROCESS_TYPE_6, StaticUtils.PROCESS_TYPE_7, StaticUtils.PROCESS_TYPE_8, StaticUtils.PROCESS_TYPE_9, StaticUtils.PROCESS_TYPE_10, StaticUtils.PROCESS_TYPE_28, StaticUtils.PROCESS_TYPE_41);
			ConditionProcessInstWithoutTransDetails piwtdCondition = new ConditionProcessInstWithoutTransDetails();
			piwtdCondition.setStartTime(startDate);
			KeyValuePair piwtdKV = new KeyValuePair();
			piwtdKV.setKey("and process_type = ?");
			piwtdKV.setValue("and process_type = ? and process_type in (" + processTypes + ") ");
			KeyValuePair[] piwtdKVArr = {piwtdKV};
			QueryProcessInstWithoutTransDetails piwtdQuery = new QueryProcessInstWithoutTransDetails();
			BaseCollection<BaseProcessInstWithoutTransDetails> piwtdBC = piwtdQuery.executeQuery(piwtdKVArr, piwtdCondition);
			if(null != piwtdBC && null != piwtdBC.getCollections() && !piwtdBC.getCollections().isEmpty()) {
				for(BaseProcessInstWithoutTransDetails bean : piwtdBC.getCollections()) {
					FinancialTransactionAccountUtils.saveFinancialTransactionDetails(bean.getProcessType(), bean.getBusinessId());
				}
			}
			//找出需要删除的往来明细【流程被删除或者驳回】，将其删除
			ConditionGetTransDetailsNeedToDelete needToDeleteCondition = new ConditionGetTransDetailsNeedToDelete();
			needToDeleteCondition.setTransDetailDeleteFlag(StaticUtils.NO_DELETE);
			needToDeleteCondition.setSpiDeleteFlag(StaticUtils.HAS_DELETE);
			needToDeleteCondition.setProcessStatus(SystemProcessConstants.PROCESS_STATUS_REJECT);
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("b.process_status = ?");
			kv.setValue(String.format("b.process_status = ? or b.process_status = %1$s ", SystemProcessConstants.PROCESS_STATUS_DELAY_REJECT));
			KeyValuePair[] kvs = {kv};
			QueryGetTransDetailsNeedToDelete needToDeleteQuery = new QueryGetTransDetailsNeedToDelete();
			BaseCollection<BaseGetTransDetailsNeedToDelete> needToDeleteBC = needToDeleteQuery.executeQuery(kvs, needToDeleteCondition);
			if(null != needToDeleteBC && null != needToDeleteBC.getCollections() && !needToDeleteBC.getCollections().isEmpty()) {
				Set<Integer> set = new HashSet<>();
				for(BaseGetTransDetailsNeedToDelete bean : needToDeleteBC.getCollections()) {
					set.add(bean.getFinancialTransactionDetailId());
				}
				if(!set.isEmpty()) {
					FinancialTransactionDetail ftdDao = new FinancialTransactionDetail();
					ftdDao.addCondition(BaseFinancialTransactionDetail.CS_FINANCIAL_TRANSACTION_DETAIL_ID, "in", set.toArray());
					ftdDao.setDeleteFlag(StaticUtils.HAS_DELETE);
					ftdDao.conditionalUpdate();
				}
			}
			//查询往来明细中未删除且流程未完成的数据，做修改操作（因为流程中可能会改收款方、冲账金额、借款金额等数据）
			ConditionProcessInfoInTransDetail updateCondition = new ConditionProcessInfoInTransDetail();
			updateCondition.setDeleteFlag(StaticUtils.NO_DELETE);
			updateCondition.setIsCompleted(false);
			QueryProcessInfoInTransDetail updateQuery = new QueryProcessInfoInTransDetail();
			BaseCollection<BaseProcessInfoInTransDetail> updateBC = updateQuery.executeQuery(null, updateCondition);
			if(null != updateBC && null != updateBC.getCollections() && !updateBC.getCollections().isEmpty()) {
				for(BaseProcessInfoInTransDetail bean : updateBC.getCollections()) {
					FinancialTransactionAccountUtils.updateFinancialTransactionDetails(bean.getProcessType(), bean.getBusinessId());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
