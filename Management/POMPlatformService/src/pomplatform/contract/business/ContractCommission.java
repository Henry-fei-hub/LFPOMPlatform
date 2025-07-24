package pomplatform.contract.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

/**
 * 保存每个月的营销提成的数据的数据
 */
public class ContractCommission extends TimerTask {

    @Override
    public void run() {
        ContractDistribution contractDistribution = null;
        Contract contractDao;
        MainProject mainProjectDao;
        Project projectDao;
        ContractCommissionDetail contractCommissionDetailDao;
        try {
            contractDistribution = new ContractDistribution();
            contractDao = new Contract();
            mainProjectDao = new MainProject();
            projectDao = new Project();
            contractCommissionDetailDao = new ContractCommissionDetail();
            //获取当前的年份和月份
            Calendar calendar = Calendar.getInstance();
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            int currentYear = calendar.get(Calendar.YEAR);
//            contractDistribution.setConditionContractId("=" ,830 );
            List<BaseContractDistribution> baseContractDistributions = contractDistribution.conditionalLoad(" order_id is not null");
            if (null != baseContractDistributions && baseContractDistributions.size() > 0){
                //循环遍历所有的数据
                for (BaseContractDistribution baseContractDistribution : baseContractDistributions){
                    //获取保存的合同的ID
                    int contractId = BaseHelpUtils.getIntValue(baseContractDistribution.getContractId());
                    if (contractId == 0){
                        continue;
                    }
                    //获取业务部门的Id
                    Integer plateId = baseContractDistribution.getPlateId();
                    //查询对应的合同
                    contractDao.clear();
                    contractDao.setConditionContractId("=" , contractId);
                    if (contractDao.isExist()) {
                        String contractCode = null;
                        String contractName = null;
                        String billingRatio = "";
                        String projectCode = null;
                        BigDecimal rate = BigDecimal.ZERO;
                        Boolean isOriginal = null;
                        Boolean isSubProject = null;
                        BigDecimal totalRevenue = BigDecimal.ZERO;
                        BigDecimal totalSheetAmount = BigDecimal.ZERO;
                        //总营收
                        BigDecimal temp = BigDecimal.ZERO;
                        BaseContract baseContract = contractDao.executeQueryOneRow();
                        //获取合同编号
                        contractCode = baseContract.getContractCode();
                        //获取合同的名称
                        contractName = baseContract.getContractName();
                        //获取项目编号
                        projectCode = baseContract.getProjectCode();
                        //查询大项目是否为原创或者建筑院分包项目
                        mainProjectDao.clear();
                        mainProjectDao.setConditionProjectCode("=" , projectCode);
                        BaseMainProject baseMainProject = mainProjectDao.executeQueryOneRow();
                        //获取是否原创或者是否建筑院分包的数据
                        if (null !=baseMainProject){
                            isOriginal = baseMainProject.getIsOriginal();
                            isSubProject = baseMainProject.getIsSubProject();
                        }
                        //查询合同下的订单
                        projectDao.clear();
                        projectDao.setConditionContractId("=" , contractId);
                        if (projectDao.isExist()){
                            for (BaseProject baseProject : projectDao.conditionalLoad()) {
                                //初始化每个订单的提成
                                BigDecimal revenue = BigDecimal.ZERO;
                                //获取订单的ID
                                Integer projectId = baseProject.getProjectId();
                                //获取订单的业态
                                Integer businessType = baseProject.getBusinessType();
                                //获取订单的编号
                                String sheetCode = baseProject.getContractCode();
                                //获取订单的金额
                                BigDecimal sheetAmount = baseProject.getSheetAmount();
                                //计算订单的总金额
                                totalSheetAmount = totalSheetAmount.add(sheetAmount);
                                //取出2017年12月订单的额进度
                                BigDecimal totalPercent2 = getProjectSchedule(2017, 12, projectId);
                                //获取当前年月的订单得我进度
                                BigDecimal totalPercent1 = getProjectSchedule(currentYear, currentMonth, projectId);
                                //获取订单金额扣税之后的金额
                                sheetAmount = sheetAmount.divide(new BigDecimal(1.06), 2, BigDecimal.ROUND_HALF_DOWN);
                                //计算每个订单下的营收（有项目编号的情况）
                                if (!BaseHelpUtils.isNullOrEmpty(projectCode)){
                                    //不是原创项目营收提成系数为1.1%
                                    if(BaseHelpUtils.isNullOrEmpty(isOriginal) || BaseHelpUtils.isNullOrEmpty(isSubProject)){
                                        continue;
                                    }
                                    if (!isOriginal){
                                        revenue = sheetAmount.multiply(new BigDecimal("0.011")).multiply(totalPercent1.subtract(totalPercent2));
                                        billingRatio = billingRatio + sheetCode + "-" + "0.011 , ";
                                        totalRevenue = totalRevenue.add(revenue);
                                    }
                                    //不是原创项目再判断是否为建筑院外包项目
                                    else{
                                        //如果是建筑院外包项目提点比例为1.4%
                                        if (isSubProject){
                                            revenue = sheetAmount.multiply(new BigDecimal("0.014")).multiply(totalPercent1.subtract(totalPercent2)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
                                            billingRatio = billingRatio + sheetCode + "-" + "0.014 , ";
                                            totalRevenue = totalRevenue.add(revenue);
                                        }else{
                                            switch (businessType){
                                                case 1://商业(营收提成系数1.5%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.015")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.015 , ";
                                                    break;
                                                case 2://酒店(营收提成系数1.9%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                case 8://地产(营收提成系数1.9%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                case 3://办公(营收提成系数1.7%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                case 6://公建(营收提成系数1.7%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                case 5://医养(营收提成系数2.5%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.025")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                case 4://轨交(营收提成系数5%)
                                                    revenue = sheetAmount.multiply(new BigDecimal("0.05")).multiply(totalPercent1.subtract(totalPercent2));
                                                    billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                    break;
                                                default:
                                                    revenue = new BigDecimal("0");
                                                    break;
                                            }
                                            totalRevenue = totalRevenue.add(revenue);
                                        }
                                    }
                                }else {
                                    if (!BaseHelpUtils.isNullOrEmpty(businessType)){
                                        switch (businessType) {
                                            case 1://商业(营收提成系数1.5%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.015")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.015 , ";
                                                break;
                                            case 2://酒店(营收提成系数1.9%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                break;
                                            case 8://地产(营收提成系数1.9%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.019")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.019 , ";
                                                break;
                                            case 3://办公(营收提成系数1.7%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.017 , ";
                                                break;
                                            case 6://公建(营收提成系数1.7%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.017")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.017 , ";
                                                break;
                                            case 5://医养(营收提成系数2.5%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.025")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.025 , ";
                                                break;
                                            case 4://轨交(营收提成系数5%)
                                                revenue = sheetAmount.multiply(new BigDecimal("0.05")).multiply(totalPercent1.subtract(totalPercent2));
                                                billingRatio = billingRatio + sheetCode + "-" + "0.05 , ";
                                                break;
                                            default:
                                                revenue = new BigDecimal("0");
                                                break;
                                        }
                                        totalRevenue = totalRevenue.add(revenue);
                                    }
                                }
                                //计算每个订单的营收
                                BigDecimal temp2 = sheetAmount.multiply(totalPercent1.subtract(totalPercent2));
                                temp = temp.add(temp2);

                            }
                        }
                        if (totalRevenue.compareTo(BigDecimal.ZERO) == 0) {
                            rate = new BigDecimal(0);
                        }
                        else {
                            rate = (temp.multiply(new BigDecimal("1.06"))).divide(totalSheetAmount,4,BigDecimal.ROUND_DOWN);
                            //项目的进度
                            rate = rate.multiply(new BigDecimal(100));
                        }
                        //查询当月是否有数据
                        contractCommissionDetailDao.setConditionContractId("=" , contractId);
                        contractCommissionDetailDao.setConditionYear("=" , currentYear);
                        contractCommissionDetailDao.setConditionMonth("=" , currentMonth);
                        BaseContractCommissionDetail bean = contractCommissionDetailDao.executeQueryOneRow();
                        //查询不为空则更新数据
                        if (null != bean){
                            bean.setContractCode(contractCode);
                            bean.setContractId(contractId);
                            bean.setPlateId(plateId);
                            bean.setYear(currentYear);
                            bean.setMonth(currentMonth);
                            bean.setRate(rate);
                            bean.setContractName(contractName);
                            bean.setBillingRatio(billingRatio);
                            bean.setAmount(totalRevenue);
                            bean.setIsSubProject(isSubProject);
                            bean.setIsOriginal(isOriginal);
                            contractCommissionDetailDao.clear();
                            contractCommissionDetailDao.setDataFromBase(bean);
                            contractCommissionDetailDao.update();
                        }else{
                            //保存每月的数据
                            BaseContractCommissionDetail bean1 = new BaseContractCommissionDetail();
                            bean1.setContractCode(contractCode);
                            bean1.setContractId(contractId);
                            bean1.setPlateId(plateId);
                            bean1.setYear(currentYear);
                            bean1.setMonth(currentMonth);
                            bean1.setRate(rate);
                            bean1.setContractName(contractName);
                            bean1.setBillingRatio(billingRatio);
                            bean1.setAmount(totalRevenue);
                            bean1.setIsSubProject(isSubProject);
                            bean1.setIsOriginal(isOriginal);
                            contractCommissionDetailDao.clear();
                            contractCommissionDetailDao.setDataFromBase(bean1);
                            contractCommissionDetailDao.save();
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据年月获取订单的进度
     * @param year
     * @param month
     * @param projectCode
     * @return
     */
    private BigDecimal getProjectSchedule(Integer year , Integer month , Integer projectId) {
        BigDecimal totalPercent = BigDecimal.ZERO;
        try {
            ConditionRevenueStatisticalOfRevenue condition = new ConditionRevenueStatisticalOfRevenue();
            condition.setYear(year);
            condition.setMonth(month);
            condition.setProjectId(projectId);
            CustomRevenueStatisticalOfRevenueHandler cc = new CustomRevenueStatisticalOfRevenueHandler();
            BaseCollection<BaseRevenueStatisticalOfRevenue> result = null;
            result = cc.getResult(condition);
            List<BaseRevenueStatisticalOfRevenue> resultList = result.getCollections();
            if (!BaseHelpUtils.isNullOrEmpty(resultList)) {
                BaseRevenueStatisticalOfRevenue aa = resultList.get(0);
                totalPercent = aa.getTotalPercent();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totalPercent;
    }


    public static void main(String[] args) {
        ContractCommission p = new ContractCommission();
        p.run();
    }
}
