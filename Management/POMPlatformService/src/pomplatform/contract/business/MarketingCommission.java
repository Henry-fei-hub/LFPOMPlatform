package pomplatform.contract.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractDistribution;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMarketingCommission;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseTeamBuilding;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractDistribution;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.TeamBuilding;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import pomplatform.employee.bean.BaseLastMarketingCommission;
import pomplatform.employee.bean.ConditionLastMarketingCommission;
import pomplatform.employee.query.QueryLastMarketingCommission;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.bean.ConditionRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.handler.CustomRevenueStatisticalOfRevenueHandler;

/**
 * @Author: liubin
 * @Description: 新的营销提成的类
 * @Date: 12:06 2019/2/27
 */
public class MarketingCommission {

    /**
     * 独立建筑项目
     */
    private final static Integer INDEPENDENTBUILDING = 36;

    /**
     * 税率
     */
    private final static BigDecimal RATEPERCENT = new BigDecimal(1.06);

    /**
     * @Author: liubin
     * @Description: 根据合同Id计算该合同下的每个订单的数据
     * @Date: 10:57 2019/3/1
     */
    public BigDecimal calculateCommission(Integer contractId , Integer plateId) throws SQLException, ParseException {
        if (null != contractId){
            Project project = new Project();
            com.pomplatform.db.dao.MarketingCommission marketingCommissionDao = new com.pomplatform.db.dao.MarketingCommission();
            project.setConditionContractId("=", contractId);
            List<BaseProject> baseProjects = project.conditionalLoad();
            Calendar calendar = Calendar.getInstance();
            //获取当前的年份和月份
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            int currentYear = calendar.get(Calendar.YEAR);
            //合同的签订总金额
            if (null != baseProjects && baseProjects.size() != 0){
                //循环遍历这个合同下面所有的订单
                for (BaseProject baseProject : baseProjects){
                    //获取订单的ID
                    int projectId = BaseHelpUtils.getIntValue(baseProject.getProjectId());
                    //获取订单的提成系数
                    BigDecimal rate = BaseHelpUtils.getBigDecimalValue(baseProject.getCommissionRate());
                    if (rate.compareTo(new BigDecimal("-999999")) == 0) {
                        continue;
                    }
                    //获取订单的金额
                    BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(baseProject.getSheetAmount());
                    //获取订单的业态
                    String businessType = BaseHelpUtils.getString(baseProject.getBusinessType());
                    //计算订单的营收
                    ConditionRevenueStatisticalOfRevenue condition1 = new ConditionRevenueStatisticalOfRevenue();
                    //查询订单当前时间进度
                    condition1.setYear(currentYear);
                    condition1.setMonth(currentMonth);
                    condition1.setProjectId(projectId);
                    BaseCollection<BaseRevenueStatisticalOfRevenue> result = CustomRevenueStatisticalOfRevenueHandler.getResult(condition1);
                    List<BaseRevenueStatisticalOfRevenue> currentResultList = result.getCollections();
                    //当前的项目的进度
                    BigDecimal currentTotalPercent = BigDecimal.ZERO;
                    if (!BaseHelpUtils.isNullOrEmpty(currentResultList)) {
                        BaseRevenueStatisticalOfRevenue bean = currentResultList.get(0);
                        currentTotalPercent = bean.getTotalPercent();
                    }
                    //查询2017年12月的项目进度
                    ConditionRevenueStatisticalOfRevenue condition2 = new ConditionRevenueStatisticalOfRevenue();
                    condition2.setYear(2017);
                    condition2.setMonth(12);
                    condition2.setProjectId(projectId);
                    BaseCollection<BaseRevenueStatisticalOfRevenue> result2 = CustomRevenueStatisticalOfRevenueHandler.getResult(condition2);
                    List<BaseRevenueStatisticalOfRevenue> basicResultList = result2.getCollections();
                    //2017年12月份项目的进度
                    BigDecimal basisTotalPercent = BigDecimal.ZERO;
                    if (!BaseHelpUtils.isNullOrEmpty(basicResultList)) {
                        BaseRevenueStatisticalOfRevenue bean = basicResultList.get(0);
                        basisTotalPercent = bean.getTotalPercent();
                    }
                    //订单的提成 = 订单金额 / 1.06 * 项目的进度差 * 订单系数
                    BigDecimal revenue = (sheetAmount.divide(RATEPERCENT, 2, BigDecimal.ROUND_HALF_DOWN).multiply(rate).multiply(currentTotalPercent.subtract(basisTotalPercent))).setScale(2,BigDecimal.ROUND_HALF_DOWN);
                    //订单的营收 = 订单金额 / 1.06 * 项目进度差
                    BigDecimal income = sheetAmount.divide(RATEPERCENT, 2, BigDecimal.ROUND_HALF_DOWN).multiply(currentTotalPercent.subtract(basisTotalPercent));
                    //查询最后插入的提成数据（本次的计算的提成-最后一条数据的累计提成 = 当天的提成）
                    QueryLastMarketingCommission query = new QueryLastMarketingCommission();
                    ConditionLastMarketingCommission condition = new ConditionLastMarketingCommission();
                    condition.setProjectId(projectId);
                    BaseCollection<BaseLastMarketingCommission> baseLastMarketingCommissions = query.executeQuery(null, condition);
                    List<BaseLastMarketingCommission> collections = baseLastMarketingCommissions.getCollections();
                    BigDecimal cumulativeRevenue = new BigDecimal(0);
                    BigDecimal cumulativeIncome = new BigDecimal(0);
                    if (null != collections && collections.size() != 0){
                        BaseLastMarketingCommission baseLastMarketingCommission = collections.get(0);
                        //判断上次提成与本次计算的提成
                        //取出上次的总的提成
                        cumulativeRevenue = baseLastMarketingCommission.getCumulativeRevenue();
                        //获取上次总的营收
                        cumulativeIncome = BaseHelpUtils.getBigDecimalValue(baseLastMarketingCommission.getTotalIncome());
                    }
                    BigDecimal incomeSubtract = income.subtract(cumulativeIncome);
                    BigDecimal subtract = revenue.subtract(cumulativeRevenue);
                    //上次总计提成和本次总计提成数据一样则表明进度
                    if (subtract.compareTo(BigDecimal.ZERO) == 0){
                        continue;
                    }else {
                        //计算项目的相对进度
                        marketingCommissionDao.clear();
                        BaseMarketingCommission bean = new BaseMarketingCommission();
                        bean.setContractId(contractId);
                        bean.setProjectId(projectId);
                        bean.setCommissionsRate(rate);
                        bean.setDayRevenue(subtract);
                        bean.setCumulativeRevenue(revenue);
                        bean.setPlateId(plateId);
                        bean.setRelativelyProgress(currentTotalPercent.subtract(basisTotalPercent));
                        bean.setRealProgress(currentTotalPercent);
                        bean.setIncome(incomeSubtract);
                        bean.setTotalIncome(income);
                        bean.setBusinessType(businessType);
                        bean.setProjectAmount(sheetAmount);
//                        calendar.clear();
//                        calendar.set(Calendar.YEAR , 2019);
//                        calendar.set(Calendar.MONTH , 2);
//                        calendar.set(Calendar.DATE , 31);
//                        bean.setCommissions(calendar.getTime());
                        marketingCommissionDao.setDataFromBase(bean);
                        marketingCommissionDao.save();
                    }
                }
            }
        }
        return null;
    }

    /**
     * @Author: liubin
     * @Description:投标订单立项时给订单一个初始的系数(立项管理里面的投标订单立项时候的入口)
     * @Date: 9:41 2019/4/13
     */
    public BigDecimal setProjectRateByProjectId(Integer projectId) throws SQLException {
        //初始化提点的系数
        BigDecimal rate = BigDecimal.ZERO;
        if (null != projectId) {
            Project project = new Project();
            project.setConditionProjectId("=" , projectId);
            BaseProject baseProject = project.executeQueryOneRow();
            if (null != baseProject) {
                //获取是否独立建筑项目
                Integer projectType = BaseHelpUtils.getIntValue(baseProject.getProjectType());
                //确定订单的也态度
                Integer businessType = BaseHelpUtils.getIntValue(baseProject.getBusinessType());
                Integer contractId = baseProject.getContractId();
                if (null != contractId) {
                    Contract contract = new Contract();
                    contract.setConditionContractId("=", contractId);
                    BaseContract baseContract = contract.executeQueryOneRow();
                    if (null != baseContract) {
                        String projectCode = baseContract.getProjectCode();
                        //有projectCode需要判断是否原创订单以及是否独立建筑项目
                        if (null != projectCode) {
                            MainProject mainProject = new MainProject();
                            BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
                            //判断是有原创以及是否独立建筑项目
                            if (null != baseMainProject) {
                                //获取是否原创项目
                                Boolean isOriginal = baseMainProject.getIsOriginal();
                                if (null != isOriginal){
                                    //不是原创项目提成系数为1.1%
                                    if (!isOriginal){
                                        rate = new BigDecimal(0.0110);
                                    }
                                    //是原创项目则判断是否是独立建筑项目
                                    else{
                                        //是独立建项目
                                        if (projectType.equals(INDEPENDENTBUILDING)){
                                            rate = new BigDecimal(0.0200);
                                        }
                                        //不是对立建筑则按照订单的业态分配提成系数
                                        else {
                                            rate = getRateByBusinessType(businessType);
                                        }
                                    }
                                }
                            }
                            //根据projectCode查询不到大项目时直接按照订单的业态来确定提点系数
                            else {
                                rate = getRateByBusinessType(businessType);
                            }
                        }else {
                            rate = getRateByBusinessType(businessType);
                        }
                    }
                }
            }
        }
        return rate;
    }


    /**
     * @Author: liubin
     * @Description: 根据合同的ID设置合同下多有的订单的提成系数（2019新的规则）
     * @Date: 18:06 2019/2/27
     */
    public void getProjectRateByContractId(Integer contractId) throws SQLException {
        if (null != contractId && contractId != 0){
            Contract contract = new Contract();
            Project project = new Project();
            contract.setConditionContractId("=" , contractId);
            BaseContract baseContract = contract.executeQueryOneRow();
            if (null != baseContract){
                //获取项目编号
                String projectCode = baseContract.getProjectCode();
                MainProject mainProject = new MainProject();
                mainProject.setConditionProjectCode("=" , projectCode);
                BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
                if (baseMainProject != null){
                    Boolean isOriginal = baseMainProject.getIsOriginal();
                    project.clear();
                    project.setConditionContractId("=" , contractId);
                    List<BaseProject> baseProjects = project.conditionalLoad();
                    if (null != baseProjects && baseProjects.size() != 0){
                        //设置改合同下的每一个订单的提成的系数
                        for (BaseProject baseProject : baseProjects){
                            BigDecimal rate = BigDecimal.ZERO;
                            Integer projectType = BaseHelpUtils.getIntValue(baseProject.getProjectType());
                            Integer businessType = BaseHelpUtils.getIntValue(baseProject.getBusinessType());
                            if (null != isOriginal){
                                //不是原创项目提成系数为1.1%
                                if (!isOriginal){
                                    rate = new BigDecimal(0.0110);
                                }
                                //是原创项目则判断是否是独立建筑项目
                                else{
                                    //是独立建项目
                                    if (projectType.equals(INDEPENDENTBUILDING)){
                                        rate = new BigDecimal(0.0200);
                                    }
                                    //不是对立建筑则按照订单的业态分配提成系数
                                    else { 
                                         rate = getRateByBusinessType(businessType);
                                    }
                                }
                            }
                            project.clear();
                            baseProject.setCommissionRate(rate);
                            project.setDataFromBase(baseProject);
                            project.update();
                        }
                    }
                }
            }
        }
    }
    
    /**
     * @Author: liubin
     * @Description: 根据订单的业态来确定提成的系数（2019）
     * @Date: 10:46 2019/3/1
     */
    private BigDecimal getRateByBusinessType(Integer businessType) {
        BigDecimal rate = BigDecimal.ZERO;
        switch (businessType){
            //商业(提成系数为1.5%)
            case 1:
                rate = new BigDecimal(0.0150);
                break;
            //酒店(提成系数为1.9%)
            case 2:
                rate = new BigDecimal(0.0190);
                break;
            //办公(提成系数为1.7%)
            case 3:
                rate = new BigDecimal(0.0170);
                break;
            //轨交(提成系数为5%)
            case 4:
                rate = new BigDecimal(0.0550);
                break;
            //医养(提成系数为2.5%)
            case 5:
                rate = new BigDecimal(0.0250);
                break;
            //文教(提成系数为2.0%)
            case 6:
                rate = new BigDecimal(0.0120);
                break;
            //地产(提成系数为1.9%)
            case 8:
                rate = new BigDecimal(0.0190);
                break;
            default:
                break;
        }
        return rate;
    }


    /**
     * @Author: liubin
     * @Description: 初始化营销提成的系数
     * @Date: 12:09 2019/2/27
     */
    private void initProjectRateOld() throws SQLException {
        ContractDistribution contractDistribution = new ContractDistribution();
        List<BaseContractDistribution> baseContractDistributions = contractDistribution.conditionalLoad(" plate_id is not null");
        if (null != baseContractDistributions && baseContractDistributions.size() != 0){
            //循环遍历所有的已经分配团队的合同
            for (BaseContractDistribution baseContractDistribution : baseContractDistributions){
                //获取已经分配了团队的合同ID
               if (null != baseContractDistribution){
                   Integer contractId = baseContractDistribution.getContractId();
                   getProjectRateOld(contractId);
               }
            }
        }
    }

    /**
     * @Author: liubin
     * @Description: 2018年之前的订单的提点系数
     * @Date: 14:21 2019/2/27
     */
    private void getProjectRateOld(Integer contractId) throws SQLException {
        //是否原创
        Boolean isOriginal = null;
        //是否建筑院分包
        Boolean isSubProject = null;
        if (null != contractId){
            Contract contract = new Contract();
            contract.setConditionContractId("=", contractId);
            BaseContract baseContract = contract.executeQueryOneRow();
            if (null != baseContract){
                //获取项目编号
                String projectCode = baseContract.getProjectCode();
                //获取项目是否原创已经是否建筑院分包的数据
                if (!BaseHelpUtils.isNullOrEmpty(projectCode)){
                    MainProject mainProject = new MainProject();
                    mainProject.setConditionProjectCode("=" , projectCode);
                    BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
                    if (null != baseMainProject){
                        isOriginal = baseMainProject.getIsOriginal();
                        isSubProject = baseMainProject.getIsSubProject();
                    }
                }
                //查询合同下的订单
                Project project = new Project();
                project.setConditionContractId("=" , contractId);
                List<BaseProject> baseProjects = project.conditionalLoad();
                if (baseProjects != null && baseProjects.size() != 0){
                    BigDecimal rate = BigDecimal.ZERO;
                    //循环遍历所有的订单
                    for (BaseProject baseProject : baseProjects){
                        //获取订单的编号
                        Integer businessType = baseProject.getBusinessType();
                        //有项目编号的按照原有的规则来获取提点系数
                        if (!BaseHelpUtils.isNullOrEmpty(projectCode)){
                            if(delicacy.common.BaseHelpUtils.isNullOrEmpty(isOriginal) || delicacy.common.BaseHelpUtils.isNullOrEmpty(isSubProject)){
                                rate = new BigDecimal("-999999");
                            }else {
                                //不是原创项目(营收提成系数1.1%)
                                if (!isOriginal){
                                    rate = new BigDecimal(0.0110);
                                }
                                //是原创的项目
                                else {
                                    //是建筑院分包项目则提成的系数为1.4%
                                    if (isSubProject){
                                        rate = new BigDecimal(0.0140);
                                    }
                                    //不是建筑院分包项目按照订单的业态来计算
                                    else {
                                        rate = getRateByBusinessTypeOld(businessType);
                                    }
                                }
                            }
                        }
                        //项目编号为null 直接按照订单的业态来获取提成系数
                        else {
                            rate = getRateByBusinessTypeOld(businessType);
                        }
                        project.clear();
                        baseProject.setCommissionRate(rate);
                        project.setDataFromBase(baseProject);
                        project.update();
                    }
                }
            }
        }
    }

    /**
     * @Author: liubin
     * @Description: 根据订单的业态获取订单的提成的系数(2018年的提点规则)
     * @Date: 15:17 2019/2/27
     */
    private static BigDecimal getRateByBusinessTypeOld(Integer businessType) {
        BigDecimal rate = BigDecimal.ZERO;
        switch (businessType){
            //商业(提成系数为1.5%)
            case 1:
                rate = new BigDecimal(0.0150);
                break;
            //酒店(提成系数为1.9%)
            case 2:
                rate = new BigDecimal(0.0190);
                break;
            //办公(提成系数为1.7%)
            case 3:
                rate = new BigDecimal(0.0170);
                break;
            //轨交(提成系数为5%)
            case 4:
                rate = new BigDecimal(0.0500);
                break;
            //医养(提成系数为2.5%)
            case 5:
                rate = new BigDecimal(0.0250);
                break;
            //公建(提成系数为1.7%)
            case 6:
                rate = new BigDecimal(0.0170);
                break;
            //地产(提成系数为1.9%)
            case 8:
                rate = new BigDecimal(0.0190);
                break;
            default:
                break;
        }
        return rate;
    }
    /**
     * @Author: liubin
     * @Description: 初始化团队组建的信息
     * @Date: 9:48 2019/4/3
     */
    private void initTeamBuilding() throws SQLException {
        TeamBuilding teamBuildingDao = new TeamBuilding();
        ContractDistribution contractDistributionDao = new ContractDistribution();
        List<BaseTeamBuilding> baseTeamBuildings = teamBuildingDao.conditionalLoad(" order_id is not null");
        if (null != baseTeamBuildings && baseTeamBuildings.size() != 0) {
            for (BaseTeamBuilding baseTeamBuilding : baseTeamBuildings) {
                String orderId = baseTeamBuilding.getOrderId();
                contractDistributionDao.setConditionOrderId("=" , orderId);
                BaseContractDistribution baseContractDistribution = contractDistributionDao.executeQueryOneRow();
                if (null != baseContractDistribution) {
                    Integer contractId = baseContractDistribution.getContractId();
                    teamBuildingDao.clear();
                    baseTeamBuilding.setContractId(contractId);
                    teamBuildingDao.setDataFromBase(baseTeamBuilding);
                    teamBuildingDao.update();
                }
            }

        }
    }

    public static void main(String[] args) {
        try {
            MarketingCommission p = new MarketingCommission();
//            p.initProjectRateOld();
            p.initTeamBuilding();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
