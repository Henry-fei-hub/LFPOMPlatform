package pomplatform.contract.business;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractDistribution;
import delicacy.common.BaseHelpUtils;

import java.util.List;
import java.util.TimerTask;

/**
 * @Author: liubin
 * @Description ：新的营销提成的定时器
 * @Date: 16:08 2019/2/28
 */
public class MarketingCommissionTask extends TimerTask {
    @Override
    public void run() {
            try {
                Contract contract = new Contract();
                MarketingCommission marketingCommission = new MarketingCommission();
                //查询所有的已经分配了营销团队的合同
                ContractDistribution contractDistribution = new ContractDistribution();
//                contractDistribution.setConditionContractId("=" , 988);
                List<BaseContractDistribution> baseContractDistributions = contractDistribution.conditionalLoad(" plate_id is not null ");
                if (null != baseContractDistributions && baseContractDistributions.size() != 0){
                    //循环遍历所有已经分配了营销团队的合同
                    for (BaseContractDistribution baseContractDistribution : baseContractDistributions){
                        //获取合同ID
                        int contractId = BaseHelpUtils.getIntValue(baseContractDistribution.getContractId());
                        contract.clear();
                        contract.setConditionContractId("=" , contractId);
                        BaseContract baseContract = contract.executeQueryOneRow();
                        //获取分配的团队的信息
                        int plateId = BaseHelpUtils.getIntValue(baseContractDistribution.getPlateId());
                        marketingCommission.calculateCommission(contractId, plateId);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public static void main(String[] args) {
        MarketingCommissionTask marketingCommissionTask = new MarketingCommissionTask();
        marketingCommissionTask.run();
    }
}
