package pomplatform.contract.business;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.MarketingCommission;
import com.pomplatform.db.dao.*;
import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import pomplatform.account.business.AccountManageProcess;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.TimerTask;

/**
 * @Author: liubin
 * @Description: 分配每天的提成
 * @Date: 17:33 2019/3/4
 */
public class DistributionCommissionTask extends TimerTask {

    @Override
    public void run() {
        try {
            //查询已经分配了营销团队的合同
            BaseMarketingCommissionDetail baseMarketingCommissionDetail = null;
            MarketingCommissionDetail marketingCommissionDetail = new MarketingCommissionDetail();
            ContractDistribution contractDistribution = new ContractDistribution();
            TeamBuilding teamBuilding = new TeamBuilding();
            Contract contract = new Contract();
            PlateRecord plateRecord = new PlateRecord();
            MarketingCommission marketingCommissionDao = new MarketingCommission();
            Project project = new Project();
//            contractDistribution.setConditionContractId("=" , 988 );
            List<BaseContractDistribution> baseContractDistributions = contractDistribution.conditionalLoad(" plate_id is not null ");
            if (null != baseContractDistributions && baseContractDistributions.size() != 0){
                for (BaseContractDistribution baseContractDistribution : baseContractDistributions) {
                    ThreadConnection.beginTransaction();
                    //获取合同ID
                    int contractId = BaseHelpUtils.getIntValue(baseContractDistribution.getContractId());
                    //获取合同的信息
                    contract.clear();
                    contract.setConditionContractId("=" , contractId);
                    BaseContract baseContract = contract.executeQueryOneRow();
                    String contractCode = baseContract.getContractCode();
                    String contractName = baseContract.getContractName();
//                    //获取提成的编号
//                    String orderId = BaseHelpUtils.getString(baseContractDistribution.getOrderId());
                    //获取营销团队的信息
                    Integer plateId = baseContractDistribution.getPlateId();
                    plateRecord.setConditionPlateId("=" , plateId);
                    BasePlateRecord basePlateRecord = plateRecord.executeQueryOneRow();
                    String plateName = basePlateRecord.getPlateName();
                    //查询项目是否有组建团队(没有组建团队就不分配积分)
                    teamBuilding.clear();
                    teamBuilding.setConditionContractId("=" , contractId);
                    if (!teamBuilding.isExist()){
                        continue;
                    }
                    //查询该合同下的所有的订单
                    project.clear();
                    project.setConditionContractId("=", contractId);
                    List<BaseProject> baseProjects = project.conditionalLoad();
                    if (null != baseProjects && baseProjects.size() != 0) {
                        for (BaseProject baseProject : baseProjects) {
                            //获取订单的ID
                            Integer projectId = baseProject.getProjectId();
                            //查询该订单下的所有没有分配积分的提成
                            marketingCommissionDao.clear();
                            marketingCommissionDao.setConditionProjectId("=", projectId);
                            marketingCommissionDao.setConditionSettlementIdentifier("=" , 0);
                            List<BaseMarketingCommission> result = marketingCommissionDao.conditionalLoad();
                            if (null != result) {
                                for (BaseMarketingCommission bean : result) {
                                    //获取订单的当次的营收
                                    BigDecimal dayRevenue = BaseHelpUtils.getBigDecimalValue(bean.getDayRevenue());
                                    int flag = dayRevenue.compareTo(new BigDecimal("0"));
                                    int marketingCommissionId = bean.getMarketingCommissionId();
                                    //更新订单的结算标识
                                    bean.setSettlementIdentifier(1);
                                    marketingCommissionDao.clear();
                                    marketingCommissionDao.setDataFromBase(bean);
                                    marketingCommissionDao.update();

                                    /***************分配积分****************/
//                                    Calendar instance = Calendar.getInstance();
//                                    instance.set(Calendar.YEAR, 2019);
//                                    instance.set(Calendar.MONTH , 2);
//                                    instance.set(Calendar.DATE , 31);
//                                    Date time = instance.getTime();

                                    //营销一级账户所需要结算的积分
                                    //记录营销中心的流水
                                    dayRevenue = dayRevenue.abs();
                                    marketingCommissionDetail.clear();
                                    marketingCommissionDetail = new MarketingCommissionDetail();
                                    baseMarketingCommissionDetail = new BaseMarketingCommissionDetail();
                                    baseMarketingCommissionDetail.setProjectId(projectId);
                                    baseMarketingCommissionDetail.setUserId(14);
                                    baseMarketingCommissionDetail.setContractId(contractId);
                                    baseMarketingCommissionDetail.setRevenue(dayRevenue);
                                    baseMarketingCommissionDetail.setMarketingCommissionId(marketingCommissionId);
                                    marketingCommissionDetail.setDataFromBase(baseMarketingCommissionDetail);

//                                    baseMarketingCommissionDetail.setCommissionDate(time);
                                    marketingCommissionDetail.save();
                                    //获取流水表的主键
                                    BaseMarketingCommissionDetail tempBean = marketingCommissionDetail.generateBase();
                                    //积分为正数则是营销一级账户支出积分
                                    if (flag == 1){
                                        AccountManageProcess.onSavePlateAccount1(14 , tempBean.getMarketingCommissionDetailId() , 26 , dayRevenue ,
                                                tempBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配支出" + "(" + plateId + ")" , -1);
                                        //更新状态
                                        tempBean.setType(2);
//                                        tempBean.setCommissionDate(time);
                                        marketingCommissionDetail.setDataFromBase(tempBean);
                                        marketingCommissionDetail.update();
                                    }
                                    //积分为负数则是营销中心一级账户收入积分
                                    if (flag == -1) {
                                        dayRevenue = dayRevenue.abs();
                                        AccountManageProcess.onSavePlateAccount1(14 , tempBean.getMarketingCommissionDetailId() , 25 , dayRevenue ,
                                                tempBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配收入" + "(" + plateId + ")" , -1);
                                        //更新状态
                                        tempBean.setType(1);
//                                        tempBean.setCommissionDate(time);
                                        marketingCommissionDetail.setDataFromBase(tempBean);
                                        marketingCommissionDetail.update();
                                    }

                                    //根据组建的团队给给部门或者个人分配积分
                                    List<BaseTeamBuilding> baseTeamBuildings = teamBuilding.conditionalLoad();
                                    if (null != baseTeamBuildings && baseTeamBuildings.size() != 0) {
                                        for (BaseTeamBuilding baseTeamBuilding : baseTeamBuildings) {
                                            //根据部门预留的比例分配部门的积分
                                            Integer departmentId = baseTeamBuilding.getDepartmentId();
                                            //部门ID不为空则表示部门有预留比例
                                            if (null != departmentId) {
                                                //获取部门预留的比例
                                                BigDecimal departmentRate = (BaseHelpUtils.getBigDecimalValue(baseTeamBuilding.getRate())).divide(new BigDecimal(100) , 2 , BigDecimal.ROUND_HALF_DOWN);
                                                //计算部门分配的积分
                                                BigDecimal departmentSettlement = dayRevenue.multiply(departmentRate);
                                                //记录部门的分配积分的流水记录
                                                marketingCommissionDetail.clear();
                                                baseMarketingCommissionDetail = new BaseMarketingCommissionDetail();
                                                baseMarketingCommissionDetail.setProjectId(projectId);
                                                baseMarketingCommissionDetail.setContractId(contractId);
                                                baseMarketingCommissionDetail.setUserId(departmentId);
                                                baseMarketingCommissionDetail.setMarketingCommissionId(marketingCommissionId);
                                                baseMarketingCommissionDetail.setRevenue(departmentSettlement);
                                                marketingCommissionDetail.setDataFromBase(baseMarketingCommissionDetail);

//                                                baseMarketingCommissionDetail.setCommissionDate(time);
                                                marketingCommissionDetail.save();
                                                BaseMarketingCommissionDetail departmentTempBean = marketingCommissionDetail.generateBase();
                                                //积分为正数则是部门账户收入积分
                                                if (flag == 1){
                                                    AccountManageProcess.onSavePlateAccount1(plateId , departmentTempBean.getMarketingCommissionDetailId() ,25 , departmentSettlement ,
                                                            departmentTempBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配收入", -1);
                                                    //更新状态
                                                    departmentTempBean.setType(1);
//                                                    departmentTempBean.setCommissionDate(time);
                                                    marketingCommissionDetail.setDataFromBase(departmentTempBean);
                                                    marketingCommissionDetail.update();
                                                }
                                                //积分为负数则是部门账户支出积分
                                                if (flag == -1){
                                                    dayRevenue = dayRevenue.abs();
                                                    AccountManageProcess.onSavePlateAccount1(plateId , departmentTempBean.getMarketingCommissionDetailId() ,26 , departmentSettlement ,
                                                            departmentTempBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配支出", -1);
                                                    //更新状态
                                                    departmentTempBean.setType(2);
//                                                    departmentTempBean.setCommissionDate(time);
                                                    marketingCommissionDetail.setDataFromBase(departmentTempBean);
                                                    marketingCommissionDetail.update();
                                                }
                                            }

                                            //根据个人预留的比例分配个人的积分
                                            Integer employeeId = baseTeamBuilding.getEmployeeId();
                                            if (null != employeeId) {
                                                //获取个人的预留比例
                                                BigDecimal employeeRate = (BaseHelpUtils.getBigDecimalValue(baseTeamBuilding.getRate())).divide(new BigDecimal(100) , 2 , BigDecimal.ROUND_HALF_DOWN);
                                                //计算个人分配的积分
                                                BigDecimal employeeSettlement = dayRevenue.multiply(employeeRate);
                                                //记录个人账户的流水信息
                                                marketingCommissionDetail.clear();
                                                baseMarketingCommissionDetail = new BaseMarketingCommissionDetail();
                                                baseMarketingCommissionDetail.setProjectId(projectId);
                                                baseMarketingCommissionDetail.setContractId(contractId);
                                                baseMarketingCommissionDetail.setRevenue(employeeSettlement);
                                                baseMarketingCommissionDetail.setUserId(employeeId);
                                                baseMarketingCommissionDetail.setMarketingCommissionId(marketingCommissionId);
                                                marketingCommissionDetail.setDataFromBase(baseMarketingCommissionDetail);

//                                                baseMarketingCommissionDetail.setCommissionDate(time);
                                                marketingCommissionDetail.save();
                                                BaseMarketingCommissionDetail employeeTemBean = marketingCommissionDetail.generateBase();

                                                //积分为正数则是个人账户收入积分
                                                if (flag == 1) {
                                                    AccountManageProcess.onSaveEmployeeAccount1(employeeId , employeeTemBean.getMarketingCommissionDetailId() , 20 , employeeSettlement ,
                                                            employeeTemBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配收入" , -1);
                                                    //更新状态
                                                    employeeTemBean.setType(1);
//                                                    employeeTemBean.setCommissionDate(time);
                                                    marketingCommissionDetail.setDataFromBase(employeeTemBean);
                                                    marketingCommissionDetail.update();
                                                }

                                                //积分为负数则是个人账户支出积分
                                                if (flag == -1) {
                                                    dayRevenue = dayRevenue.abs();
                                                    AccountManageProcess.onSaveEmployeeAccount1(employeeId , employeeTemBean.getMarketingCommissionDetailId() , 21 , employeeSettlement ,
                                                            employeeTemBean.getCommissionDate() , contractCode + "——" + contractName + "——" + "提成分配支出" , -1);
                                                    //更新状态
                                                    employeeTemBean.setType(2);
//                                                    employeeTemBean.setCommissionDate(time);
                                                    marketingCommissionDetail.setDataFromBase(employeeTemBean);
                                                    marketingCommissionDetail.update();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    ThreadConnection.commit();
                }
            }
        } catch (SQLException e) {
            ThreadConnection.rollback();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DistributionCommissionTask p = new DistributionCommissionTask();
        p.run();
    }

}
