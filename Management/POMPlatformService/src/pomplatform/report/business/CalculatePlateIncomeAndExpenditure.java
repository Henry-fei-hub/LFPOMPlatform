package pomplatform.report.business;

import com.pomplatform.db.bean.BasePlateIncomeAndExpenditure;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.dao.PlateIncomeAndExpenditure;
import com.pomplatform.db.dao.PlateRecord;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import pomplatform.report.bean.*;
import pomplatform.report.query.*;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;

/**
 * @Author: liubin
 * @Description :统计部门的收支状况
 * @Date: 10:34 2019/6/11
 */
public class CalculatePlateIncomeAndExpenditure extends TimerTask {

    @Override
    public void run() {
        try {
            //获取当前的年月
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
//            int currentYear = 2017;
//            int currentMonth = 1;

            PlateRecord plateRecordDao = new PlateRecord();
            PlateIncomeAndExpenditure plateIncomeAndExpenditureDao = new PlateIncomeAndExpenditure();

            //查询所有的事业部
            plateRecordDao.setConditionPlateType("=", 1);
            List<BasePlateRecord> basePlateRecords = plateRecordDao.conditionalLoad();
            if (null != basePlateRecords && basePlateRecords.size() != 0) {
                for (BasePlateRecord basePlateRecord : basePlateRecords) {
                    Integer plateId = basePlateRecord.getPlateId();
                    //查询部门的合同存量
                    Map temp1 = queryPlateContractCode(plateId, currentYear, currentMonth);
                    //部门营收
                    BigDecimal currentRevenue = BaseHelpUtils.getBigDecimalValue(temp1.get("currentRevenue"));
                    //合同存量
                    BigDecimal activite = BaseHelpUtils.getBigDecimalValue(temp1.get("activite"));
                    //查询部门账户中每月确认的积分
                    Map temp2 = queryDepartmentAccount(currentYear, currentMonth, plateId);
                    //部门确认积分
                    BigDecimal confirmationPoints = BaseHelpUtils.getBigDecimalValue(temp2.get("confirmationPoints"));
                    //部门成本
                    BigDecimal departmentalCost = BaseHelpUtils.getBigDecimalValue(temp2.get("departmentalCost"));
                    //查询部门下成员的个人账户每月确认的积分
                    Map temp3 = queryEmployeeAccount(currentYear, currentMonth, plateId);
                    //查询个人账户中的人工成本
                    Map temp5 = queryEmployeeAccountCost(currentYear, currentMonth, plateId);
                    //员工的成本
                    BigDecimal employeeCost = BaseHelpUtils.getBigDecimalValue(temp5.get("employeeCost"));
                    //员工的确认积分
                    BigDecimal employeeConfirmationPoints = BaseHelpUtils.getBigDecimalValue(temp3.get("employeeConfirmationPoints"));
                    //查询项目成本
                    Map temp4 = queryProjectCost(currentYear, currentMonth, plateId);
                    BigDecimal projectCost = BaseHelpUtils.getBigDecimalValue(temp4.get("projectCost"));

                    plateIncomeAndExpenditureDao.clear();
                    plateIncomeAndExpenditureDao.setConditionYear("=", currentYear);
                    plateIncomeAndExpenditureDao.setConditionMonth("=", currentMonth);
                    plateIncomeAndExpenditureDao.setConditionPlateId("=", plateId);
                    //当月存在数据则直接更新
                    if (plateIncomeAndExpenditureDao.isExist()) {
                        BasePlateIncomeAndExpenditure bean = plateIncomeAndExpenditureDao.executeQueryOneRow();
                        bean.setContractStock(activite);
                        bean.setRevenue(currentRevenue);
                        bean.setDepartmentConfirmationPoints(confirmationPoints);
                        bean.setEmployeeConfirmationPoints(employeeConfirmationPoints);
                        bean.setEmployeeCost(employeeCost);
                        bean.setPlateCost(departmentalCost);
                        bean.setProjectCost(projectCost);
                        plateIncomeAndExpenditureDao.clear();
                        plateIncomeAndExpenditureDao.setDataFromBase(bean);
                        plateIncomeAndExpenditureDao.update();
                    } else {
                        BasePlateIncomeAndExpenditure bean = new BasePlateIncomeAndExpenditure();
                        bean.setYear(currentYear);
                        bean.setMonth(currentMonth);
                        bean.setPlateId(plateId);
                        bean.setContractStock(activite);
                        bean.setRevenue(currentRevenue);
                        bean.setDepartmentConfirmationPoints(confirmationPoints);
                        bean.setEmployeeConfirmationPoints(employeeConfirmationPoints);
                        bean.setEmployeeCost(employeeCost);
                        bean.setPlateCost(departmentalCost);
                        bean.setProjectCost(projectCost);
                        plateIncomeAndExpenditureDao.clear();
                        plateIncomeAndExpenditureDao.setDataFromBase(bean);
                        plateIncomeAndExpenditureDao.save();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Author: liubin
     * @Description :查询个人账户中的人工成本
     * @Date: 18:38 2019/7/8
     */
    private Map queryEmployeeAccountCost(int currentYear, int currentMonth, Integer plateId) throws SQLException {
        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal employeeCost = new BigDecimal("0");
        QueryEmployeeCost query = new QueryEmployeeCost();
        ConditionEmployeeCost condition = new ConditionEmployeeCost();
        condition.setPlateId(plateId);
        condition.setYear(currentYear);
        condition.setMonth(currentMonth);
        BaseCollection<BaseEmployeeCost> lists = query.executeQuery(null, condition);
        if (null != lists && null != lists.getCollections() && lists.getCollections().size() != 0) {
            BaseEmployeeCost baseEmployeeCost = lists.getCollections().get(0);
            if (null != baseEmployeeCost) {
                employeeCost = BaseHelpUtils.getBigDecimalValue(baseEmployeeCost.getIntegral());
            }
        }
        map.put("employeeCost", employeeCost);
        return map;
    }

    /**
     * @Author: liubin
     * @Description :获取项目成本
     * @Date: 15:25 2019/6/12
     */
    private Map queryProjectCost(int currentYear, int currentMonth, Integer plateId) throws SQLException {
        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal projectCost = new BigDecimal("0");
        QueryProjectAccountIncome query = new QueryProjectAccountIncome();
        ConditionProjectAccountIncome condition = new ConditionProjectAccountIncome();
        condition.setPlateId(plateId);
        condition.setYear(currentYear);
        condition.setMonth(currentMonth);
        BaseCollection<BaseProjectAccountIncome> lists = query.executeQuery(null, condition);
        if (null != lists && null != lists.getCollections() && lists.getCollections().size() != 0) {
            BaseProjectAccountIncome baseProjectAccountIncome = lists.getCollections().get(0);
            if (null != baseProjectAccountIncome) {
                projectCost = BaseHelpUtils.getBigDecimalValue(baseProjectAccountIncome.getSum());
            }
        }
        map.put("projectCost", projectCost);
        return map;
    }

    /**
     * @Author: liubin
     * @Description :获取员工的人工成本以及确认的积分
     * @Date: 15:04 2019/6/12
     */
    private Map queryEmployeeAccount(int currentYear, int currentMonth, Integer plateId) throws SQLException {
        BigDecimal employeeConfirmationPoints = new BigDecimal("0");
//        BigDecimal employeeCost = new BigDecimal("0");
        Map<String, BigDecimal> map = new HashMap<>();
        QueryEmployeeAccountIncome query = new QueryEmployeeAccountIncome();
        ConditionEmployeeAccountIncome condition = new ConditionEmployeeAccountIncome();
        condition.setPlateId(plateId);
        condition.setYear(currentYear);
        condition.setMonth(currentMonth);
        BaseCollection<BaseEmployeeAccountIncome> lists = query.executeQuery(null, condition);
        if (null != lists && null != lists.getCollections() && lists.getCollections().size() != 0) {
            List<BaseEmployeeAccountIncome> collections = lists.getCollections();
            for (BaseEmployeeAccountIncome baseEmployeeAccountIncome : collections) {
                int businessTypeId = BaseHelpUtils.getIntValue(baseEmployeeAccountIncome.getBusinessTypeId());
                if (businessTypeId == 1) {
                    employeeConfirmationPoints = BaseHelpUtils.getBigDecimalValue(baseEmployeeAccountIncome.getIntegral());
                }
//                else if (businessTypeId == 6) {
//                    employeeCost = BaseHelpUtils.getBigDecimalValue(baseEmployeeAccountIncome.getIntegral());
//                }
            }
            map.put("employeeConfirmationPoints", employeeConfirmationPoints);
//            map.put("employeeCost", employeeCost);
        }
        return map;
    }

    /**
     * @Author: liubin
     * @Description :获取部门账户中每月的确认积分以及部门账户中的部门成本
     * @Date: 10:28 2019/6/12
     */
    private Map queryDepartmentAccount(int currentYear, int currentMonth, int plateId) throws SQLException {
        Map<String, BigDecimal> map = new HashMap<>();
        //确认积分
        BigDecimal confirmationPoints = new BigDecimal("0");
        BigDecimal departmentalCost = new BigDecimal("0");
        QueryDepartmentAccountIncome query = new QueryDepartmentAccountIncome();
        ConditionDepartmentAccountIncome condition = new ConditionDepartmentAccountIncome();
        condition.setPlateId(plateId);
        condition.setYear(currentYear);
        condition.setMonth(currentMonth);
        BaseCollection<BaseDepartmentAccountIncome> lists = query.executeQuery(null, condition);
        if (null != lists && null != lists.getCollections() && lists.getCollections().size() != 0) {
            List<BaseDepartmentAccountIncome> baseDepartmentAccountIncomes = lists.getCollections();
            for (BaseDepartmentAccountIncome baseDepartmentAccountIncome : baseDepartmentAccountIncomes) {
                int businessTypeId = BaseHelpUtils.getIntValue(baseDepartmentAccountIncome.getBusinessTypeId());
                if (businessTypeId == 1) {
                    confirmationPoints = BaseHelpUtils.getBigDecimalValue(baseDepartmentAccountIncome.getIntegral());
                } else if (businessTypeId == 7) {
                    departmentalCost = BaseHelpUtils.getBigDecimalValue(baseDepartmentAccountIncome.getIntegral());
                }
            }
            map.put("confirmationPoints", confirmationPoints);
            map.put("departmentalCost", departmentalCost);
        }
        return map;
    }

    /**
     * @Author: liubin
     * @Description ：查询部门的合同活跃量
     * @Date: 11:19 2019/6/11
     */
    private Map queryPlateContractCode(Integer plateId, int currentYear, int currentMonth) throws SQLException {
        Map<String, BigDecimal> map = new HashMap<>();
        QueryContractSaveAndRevenue query = new QueryContractSaveAndRevenue();
        ConditionContractSaveAndRevenue condition = new ConditionContractSaveAndRevenue();
        condition.setPlateId(plateId);
        condition.setYear(currentYear);
        condition.setMonth(currentMonth);
        BaseCollection<BaseContractSaveAndRevenue> lists = query.executeQuery(null, condition);
        if (null != lists && null != lists.getCollections() && lists.getCollections().size() != 0) {
            BaseContractSaveAndRevenue bean = lists.getCollections().get(0);
            //获取部门当月的营收
            BigDecimal currentRevenue = BaseHelpUtils.getBigDecimalValue(bean.getCurrentRevenue());
            //获取部门当月的合同存量
            BigDecimal activite = BaseHelpUtils.getBigDecimalValue(bean.getActive());
            map.put("currentRevenue", currentRevenue);
            map.put("activite", activite);
        }
        return map ;
    }

    public static void main(String[] args) {
        CalculatePlateIncomeAndExpenditure p = new CalculatePlateIncomeAndExpenditure();
        p.run();

    }
}
