package pomplatform.employeerescord.handler;

import com.pomplatform.db.bean.BaseEmployeeFundIssuance;
import com.pomplatform.db.bean.BaseEmployeeFundIssuanceDetail;
import com.pomplatform.db.bean.BaseEmployeeSalaryType;
import com.pomplatform.db.dao.EmployeeFundIssuance;
import com.pomplatform.db.dao.EmployeeFundIssuanceDetail;
import com.pomplatform.db.dao.EmployeeSalaryType;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.payment.bean.*;
import pomplatform.payment.query.QueryCurrentMonthSalaryType;

import javax.servlet.http.HttpServletRequest;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: liubin
 * @Description
 * @Date: 9:46 2019/4/19
 */
public class EmployeeSalaryTypeProcess implements GenericProcessor {

    private static final String SAVEEMPLOYEESALARYTYPES = "saveEmployeeSalaryTypes";
    private static final String INQUIREFUNDRAISINGPROJECTTYPE = "inquireFundraisingProjectType";
    private static final String INITIALIZATIONRESULT = "initializationResult";
    private static final String SAVEDATA = "saveData";
    private static final String PREPAYMENTSAVE = "prepaymentSave";
    private static final String SAVEBONUS = "saveBonus";


    @Override
    public String execute(String creteria, HttpServletRequest httpServletRequest) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
            @SuppressWarnings("rawtypes")
            JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "optType");
        if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result)) {
            switch (optType) {
                case SAVEEMPLOYEESALARYTYPES:
                    return saveEmployeeSalaryTypes(result);
                case INQUIREFUNDRAISINGPROJECTTYPE:
                    return inquireFundraisingProjectType(result);
                case INITIALIZATIONRESULT:
                    return initializationResult(result);
                case SAVEDATA:
                    return saveData(result);
                case PREPAYMENTSAVE:
                    return prepaymentSave(result);
                case SAVEBONUS:
                    return saveBonus(result);
                default:
                    break;
            }
        }
        return null;
    }

    /**
     * @Author: liubin
     * @Description : 奖金发放流程保存数据
     * @Date: 15:11 2019/4/29
     */
    private String saveBonus(Map<String, Object> result) throws SQLException {
        ThreadConnection.beginTransaction();
        if (null != result && result.size() != 0) {
            int size = BaseHelpUtils.getIntValue(result.get("size"));
            for (int i = 0; i < size; i++) {
                deleteBonus(GenericBase.__getList(result.get("temp" + i), BaseBonusCommon::new));
            }
            for (int i = 0; i < size; i++) {
                List<BaseBonusCommon> list = GenericBase.__getList(result.get("temp" + i), BaseBonusCommon::new);
                saveEmployeeFundIssuanceIdDetailByBonus(list);
            }
        }
        ThreadConnection.commit();
        return null;
    }

    /**
     * @Author: liubin
     * @Description : 奖金发放的申请的保存
     * @Date: 15:45 2019/4/29
     */
    private void saveEmployeeFundIssuanceIdDetailByBonus(List<BaseBonusCommon> list) throws SQLException {
        if (null != list && list.size() != 0) {
            ArrayList<BaseEmployeeFundIssuanceDetail> beans = new ArrayList<>();
            EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
            //发放人数(主表)
            int payNumberMain = 0;
            //发放金额(主表)
            BigDecimal payMoneyMain = BigDecimal.ZERO;
            //冲账金额(主表)
            BigDecimal amountOfCreditMain = BigDecimal.ZERO;
            //冲账数量(主表)
            int numberOfCreditMain = 0;
            //总计金额(主表)
            BigDecimal totalSum = BigDecimal.ZERO;
            for (int i = 0; i < list.size(); i++) {
                BaseBonusCommon baseBonusCommon = list.get(i);
                BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
                bean.setEmployeeId(BaseHelpUtils.getIntValue(baseBonusCommon.getEmployeeId()));
                bean.setEmployeeNo(BaseHelpUtils.getString(baseBonusCommon.getEmployeeNo()));
                bean.setYear(BaseHelpUtils.getIntValue(baseBonusCommon.getYear()));
                bean.setMonth(BaseHelpUtils.getIntValue(baseBonusCommon.getMonth()));
                bean.setFundraisingTypeId(BaseHelpUtils.getIntValue(baseBonusCommon.getFundraisingProjectType()));
                bean.setPlateId(BaseHelpUtils.getIntValue(baseBonusCommon.getPlateId()));
                bean.setRatio(BaseHelpUtils.getBigDecimalValue(baseBonusCommon.getFundraisingProjectRate()));
                bean.setPersonelBusinessId(BaseHelpUtils.getIntValue(baseBonusCommon.getPersonnelBusinessId()));
                //设置类型为工资
                bean.setFundType(2);
                //总的奖金的金额
                BigDecimal factBonus = BaseHelpUtils.getBigDecimalValue(baseBonusCommon.getFactBonus());

                bean.setTotalMoney(factBonus);
                BigDecimal fundraisingProjectRate = BaseHelpUtils.getBigDecimalValue(baseBonusCommon.getFundraisingProjectRate());
                //冲账金额
                BigDecimal amountOfCredit = (factBonus.subtract(factBonus.multiply(fundraisingProjectRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                bean.setAmountOfCredit(amountOfCredit);
                //实付金额
                BigDecimal subtract = factBonus.subtract(amountOfCredit);
                bean.setIssueMoney(subtract);
                beans.add(bean);

                //主表数据整理
                //记录实发金额大于0 人数
                if (factBonus.compareTo(BigDecimal.ZERO) == 1 || factBonus.compareTo(BigDecimal.ZERO) == 0) {
                    //主表总计发放人数
                    payNumberMain++;
                    //总计金额
                    totalSum = totalSum.add(factBonus);
                }
                //发放比例不为100%时则表示有冲账的金额
                if (fundraisingProjectRate.compareTo(new BigDecimal(100)) != 0) {
                    //冲账金额数量
                    numberOfCreditMain++;
                }
                //计算实发金额
                payMoneyMain = payMoneyMain.add(subtract);
                //计算冲账金额
                amountOfCreditMain = amountOfCreditMain.add(amountOfCredit);
            }
            BaseBonusCommon baseBonusCommon = list.get(0);
            int year = BaseHelpUtils.getIntValue(baseBonusCommon.getYear());
            int month = BaseHelpUtils.getIntValue(baseBonusCommon.getMonth());
            int companyId = BaseHelpUtils.getIntValue(baseBonusCommon.getCompanyId());
            int fundraisingProjectType = BaseHelpUtils.getIntValue(baseBonusCommon.getFundraisingProjectType());
            int prsonnelBusinessId = BaseHelpUtils.getIntValue(baseBonusCommon.getPersonnelBusinessId());
            //发放类型（0募投项目 ，1非募投项目）
            int releaseType = 0;
            if (fundraisingProjectType == 0) {
                releaseType = 1;
            }
            //设置主表的数据
            BaseEmployeeFundIssuance baseEmployeeFundIssuance = new BaseEmployeeFundIssuance();
            EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
            baseEmployeeFundIssuance.setFundType(2);
            baseEmployeeFundIssuance.setYear(year);
            baseEmployeeFundIssuance.setMonth(month);
            baseEmployeeFundIssuance.setCompanyId(companyId);
            baseEmployeeFundIssuance.setPayNumber(payNumberMain);
            baseEmployeeFundIssuance.setPayMoney(payMoneyMain);
            baseEmployeeFundIssuance.setNumberOfCredit(numberOfCreditMain);
            baseEmployeeFundIssuance.setAmountOfCredit(amountOfCreditMain);
            baseEmployeeFundIssuance.setReleaseType(releaseType);
            baseEmployeeFundIssuance.setFundrasingTypeId(fundraisingProjectType);
            baseEmployeeFundIssuance.setAccountingNumber(numberOfCreditMain);
            baseEmployeeFundIssuance.setTotalSum(totalSum);
            baseEmployeeFundIssuance.setPersonelBusinessId(prsonnelBusinessId);
            employeeFundIssuanceDao.setDataFromBase(baseEmployeeFundIssuance);
            employeeFundIssuanceDao.save();
            Integer employeeFundIssuanceId = employeeFundIssuanceDao.generateBase().getEmployeeFundIssuanceId();

            //设置子表的主键
            for (BaseEmployeeFundIssuanceDetail bean : beans) {
                bean.setEmployeeFundIssuanceId(employeeFundIssuanceId);
            }
            dao.save(beans);
        }
    }

    /**
     * @Author: liubin
     * @Description : 奖金发放流程数据删除
     * @Date: 15:18 2019/4/29
     */
    private void deleteBonus(List<BaseBonusCommon> list) throws SQLException {
        if (null != list && list.size() != 0) {
            EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
            EmployeeFundIssuanceDetail employeeFundIssuanceDetailDao = new EmployeeFundIssuanceDetail();
                BaseBonusCommon baseBonusCommon = list.get(0);
                if (null != baseBonusCommon) {
                    int companyId = BaseHelpUtils.getIntValue(baseBonusCommon.getCompanyId());
                    int year = BaseHelpUtils.getIntValue(baseBonusCommon.getYear());
                    int month = BaseHelpUtils.getIntValue(baseBonusCommon.getMonth());
                    int personnelBusinessId = BaseHelpUtils.getIntValue(baseBonusCommon.getPersonnelBusinessId());
                    System.out.println("///////////////////////////////////////////////////////////////////////" + baseBonusCommon.getPersonnelBusinessId());
                    employeeFundIssuanceDao.clear();
                    employeeFundIssuanceDao.setConditionCompanyId("=", companyId);
                    employeeFundIssuanceDao.setConditionYear("=", year);
                    employeeFundIssuanceDao.setConditionMonth("=", month);
                    employeeFundIssuanceDao.setConditionFundType("=", 2);
                    employeeFundIssuanceDao.setConditionPersonelBusinessId("=", personnelBusinessId);
                    List<BaseEmployeeFundIssuance> baseEmployeeFundIssuances = employeeFundIssuanceDao.conditionalLoad();
                    employeeFundIssuanceDao.conditionalDelete();
                    if (null != baseEmployeeFundIssuances && baseEmployeeFundIssuances.size() != 0) {
                        for (BaseEmployeeFundIssuance bean : baseEmployeeFundIssuances) {
                            Integer employeeFundIssuanceId = bean.getEmployeeFundIssuanceId();
                            employeeFundIssuanceDetailDao.clear();
                            employeeFundIssuanceDetailDao.setConditionEmployeeFundIssuanceId("=", employeeFundIssuanceId);
                            employeeFundIssuanceDetailDao.conditionalDelete();
                        }

                    }
                }
            }
    }

    /**
     * @Author: liubin
     * @Description :借款申请前置界面的保存
     * @Date: 12:19 2019/4/26
     */
    private String prepaymentSave(Map<String, Object> result) throws SQLException {
        Integer status = -1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        if (null != result && result.size() != 0) {
            List<BaseResidualwageData> list = GenericBase.__getList(result.get("list"), BaseResidualwageData::new);
            //发放人数
            int totalNumber = 0;
            //发放钱数
            BigDecimal totalMoney = BigDecimal.ZERO;
            //冲账总计数量
            int accountingNumber = 0;
            //总计钱数
            BigDecimal sum = BigDecimal.ZERO;
            //冲账金额总计
            BigDecimal amountOfCredit = BigDecimal.ZERO;
            if (null != list && list.size() != 0) {
                List<BaseEmployeeFundIssuanceDetail> beans = new ArrayList<>();
                EmployeeFundIssuanceDetail employeeFundIssuanceDetailDao = new EmployeeFundIssuanceDetail();
                for (BaseResidualwageData data : list) {
                    BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
                    int employeeId = BaseHelpUtils.getIntValue(data.getEmployeeId());
                    int year = BaseHelpUtils.getIntValue(data.getYear());
                    int month = BaseHelpUtils.getIntValue(data.getMonth());
                    int companyId = BaseHelpUtils.getIntValue(data.getCompanyId());
                    String employeeNo = BaseHelpUtils.getString(data.getEmployeeNo());
                    //本次剩余的发放金额
                    BigDecimal balance = BaseHelpUtils.getBigDecimalValue(data.getBalance());
                    //获取本次的发放比例
                    BigDecimal ratio = BaseHelpUtils.getBigDecimalValue(data.getRatio());
                    //本次发放金额
                    BigDecimal thisIssuance = balance.multiply(ratio.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
                    //本次剩余金额
                    BigDecimal remainingThisTime = balance.subtract(thisIssuance);

                    //主表汇总数据
                    //总计发放人数
                    totalNumber++;
                    //总计发放钱数
                    totalMoney = totalMoney.add(thisIssuance);
                    //冲账人数(发放比例不为100%时代表有冲账金额)
                    if (ratio.compareTo(new BigDecimal("100")) != 0) {
                        accountingNumber++;
                    }
                    //总计冲账金额
                    amountOfCredit = amountOfCredit.add(remainingThisTime);
                    //总计钱数
                    sum = sum.add(balance);

                    bean.setEmployeeId(employeeId);
                    bean.setEmployeeNo(employeeNo);
                    //借款申请
                    bean.setFundType(4);
                    bean.setYear(year);
                    bean.setMonth(month);
                    bean.setIssueMoney(thisIssuance);
                    bean.setRatio(ratio);
                    bean.setAmountOfCredit(remainingThisTime);
                    bean.setTotalMoney(balance);
                    //初始化设置状态为无效状态
                    bean.setProcessStatus(0);
                    beans.add(bean);
                }

                //保存主表的数据
                BaseResidualwageData baseResidualwageData = list.get(0);
                int year = BaseHelpUtils.getIntValue(baseResidualwageData.getYear());
                int month = BaseHelpUtils.getIntValue(baseResidualwageData.getMonth());
                int companyId = BaseHelpUtils.getIntValue(baseResidualwageData.getCompanyId());

                BaseEmployeeFundIssuance baseEmployeeFundIssuance = new BaseEmployeeFundIssuance();
                EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
                baseEmployeeFundIssuance.setFundType(4);
                baseEmployeeFundIssuance.setYear(year);
                baseEmployeeFundIssuance.setMonth(month);
                baseEmployeeFundIssuance.setCompanyId(companyId);
                baseEmployeeFundIssuance.setPayNumber(totalNumber);
                baseEmployeeFundIssuance.setPayMoney(totalMoney);
                baseEmployeeFundIssuance.setNumberOfCredit(accountingNumber);
                baseEmployeeFundIssuance.setAmountOfCredit(amountOfCredit);
                baseEmployeeFundIssuance.setReleaseType(1);
                baseEmployeeFundIssuance.setAccountingNumber(accountingNumber);
                baseEmployeeFundIssuance.setTotalSum(sum);
                employeeFundIssuanceDao.setDataFromBase(baseEmployeeFundIssuance);
                employeeFundIssuanceDao.save();
                Integer employeeFundIssuanceId = employeeFundIssuanceDao.generateBase().getEmployeeFundIssuanceId();

                for (BaseEmployeeFundIssuanceDetail bean : beans) {
                    bean.setEmployeeFundIssuanceId(employeeFundIssuanceId);
                }
                employeeFundIssuanceDetailDao.save(beans);
                //返回主表的主键用于初始化借款申请页面的数据
                status = employeeFundIssuanceId;
            }
        }
        return collection.toJSON(status, null);
    }

    /**
     * @Author: liubin
     * @Description ：更改状态为无效
     * @Date: 16:14 2019/4/27
     */
    public void deletePrepayment(Integer employeeFundIssuanceId) throws SQLException {
        //修改子表的状态
        EmployeeFundIssuanceDetail employeeFundIssuanceDetailDao = new EmployeeFundIssuanceDetail();
        employeeFundIssuanceDetailDao.setConditionEmployeeFundIssuanceId("=", employeeFundIssuanceId);
        employeeFundIssuanceDetailDao.setProcessStatus(0);
        employeeFundIssuanceDetailDao.conditionalUpdate();
        //修改主表的状态
        EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
        employeeFundIssuanceDao.setConditionEmployeeFundIssuanceId("=", employeeFundIssuanceId);
        employeeFundIssuanceDao.setProcessStatus(0);
        employeeFundIssuanceDao.conditionalUpdate();
    }

    /**
     * @Author: liubin
     * @Description : 更新借款申请对用的数据的流程状态
     * @Date: 15:11 2019/4/28
     */
    public void updateLoanApplication(Integer employeeFundIssuanceId) throws SQLException {
        EmployeeFundIssuanceDetail employeeFundIssuanceDetailDao = new EmployeeFundIssuanceDetail();
        employeeFundIssuanceDetailDao.setConditionEmployeeFundIssuanceId("=", employeeFundIssuanceId);
        employeeFundIssuanceDetailDao.setProcessStatus(1);
        employeeFundIssuanceDetailDao.conditionalUpdate();
    }

    /**
     * @Author: liubin
     * @Description : 薪资发放保存数据
     * @Date: 15:03 2019/4/22
     */
    private String saveData(Map<String, Object> result) throws SQLException {
        ThreadConnection.beginTransaction();
        if (null != result && result.size() != 0) {
            int size = BaseHelpUtils.getIntValue(result.get("size"));
            for (int i = 0; i < size; i++) {
                delete(GenericBase.__getList(result.get("temp" + 0), BaseSalaryCommon::new));
            }
            for (int i = 0; i < size; i++) {
                List<BaseSalaryCommon> list = GenericBase.__getList(result.get("temp" + i), BaseSalaryCommon::new);
                saveEmployeeFundIssuanceIdDetail(list);
            }
        }
        ThreadConnection.commit();
        return null;
    }

    /**
     * @Author: liubin
     * @Description :公用的保存主表的数据
     * @Date: 15:20 2019/4/22
     */
    private void commonSave(List<BaseSalaryCommon> list) {
        try {
            ThreadConnection.beginTransaction();
            int status = -1;
            BaseCollection<GenericBase> collection = new BaseCollection<>();
            //保存之前先删除数据
            EmployeeFundIssuance dao = new EmployeeFundIssuance();
            BaseEmployeeFundIssuance bean = new BaseEmployeeFundIssuance();
            //发放人数
            int totalNumber = 0;
            //发放钱数
            BigDecimal totalMoney = BigDecimal.ZERO;
            //冲账总计数量
            int accountingNumber = 0;
            //总计钱数
            BigDecimal sum = BigDecimal.ZERO;
            //冲账金额总计
            BigDecimal amountOfCredit = BigDecimal.ZERO;
            for (int i = 0; i < list.size(); i++) {
                BaseSalaryCommon baseSalaryCommon = list.get(i);
                if (null != baseSalaryCommon) {
                    //实发金额
                    BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(baseSalaryCommon.getFactSalary());
                    //记录实发金额大于0 人数
                    if (factSalary.compareTo(BigDecimal.ZERO) == 1 || factSalary.compareTo(BigDecimal.ZERO) == 0) {
                        totalNumber++;
                        sum = sum.add(factSalary);
                    }
                    //获取发放比例
                    BigDecimal fundraisingProjectRate = BaseHelpUtils.getBigDecimalValue(baseSalaryCommon.getFundraisingProjectRate());
                    //发放比例不为100%时则表示有冲账的金额
                    if (fundraisingProjectRate.compareTo(new BigDecimal("100")) != 0) {
                        accountingNumber++;
//                        BigDecimal temp1 = (factSalary.subtract(factSalary.multiply(fundraisingProjectRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)))).setScale(2, BigDecimal.ROUND_HALF_UP);
//                        amountOfCredit = amountOfCredit.add(temp1);
                    }
                    //计算实发金额
                    BigDecimal temp2 = factSalary.multiply(fundraisingProjectRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP));
                    totalMoney = totalMoney.add(temp2);
                    //计算冲账的金额
                    amountOfCredit = sum.subtract(totalMoney);
                }
            }
            BaseSalaryCommon baseSalaryCommon = list.get(0);
            int year = BaseHelpUtils.getIntValue(baseSalaryCommon.getYear());
            int month = BaseHelpUtils.getIntValue(baseSalaryCommon.getMonth());
            int companyId = BaseHelpUtils.getIntValue(baseSalaryCommon.getCompanyId());
            int fundraisingProjectType = BaseHelpUtils.getIntValue(baseSalaryCommon.getFundraisingProjectType());
            //发放类型（0募投项目 ，1非募投项目）
            int releaseType = 0;
            if (fundraisingProjectType == 0) {
                releaseType = 1;
            }
            bean.setFundType(1);
            bean.setYear(year);
            bean.setMonth(month);
            bean.setCompanyId(companyId);
            bean.setPayMoney(totalMoney);
            bean.setNumberOfCredit(accountingNumber);
            bean.setPayNumber(totalNumber);
            bean.setTotalSum(sum);
            //设置发放类型为工资
            bean.setFundType(1);
            bean.setReleaseType(releaseType);
            bean.setAmountOfCredit(amountOfCredit);
            bean.setAccountingNumber(accountingNumber);
            bean.setFundrasingTypeId(fundraisingProjectType);
            dao.setDataFromBase(bean);
            dao.save();
            //取出主表主键
            BaseEmployeeFundIssuance baseEmployeeFundIssuance = dao.generateBase();
            Integer employeeFundIssuanceId = baseEmployeeFundIssuance.getEmployeeFundIssuanceId();
            System.out.println("==================================================================================================" + employeeFundIssuanceId);
            //保存子表数据
//            saveEmployeeFundIssuanceIdDetail(list , employeeFundIssuanceId);
            status = 1;
            collection.toJSON(status, null);
            ThreadConnection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //事物回滚
            ThreadConnection.rollback();
        }
    }

    /**
     * @Author: liubin
     * @Description ：保存数据之前先删除数据（薪资发放专用）
     * @Date: 17:46 2019/4/22
     */
    private void delete(List<BaseSalaryCommon> list) throws SQLException {
        if (null != list && list.size() != 0) {
            EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
            EmployeeFundIssuanceDetail employeeFundIssuanceDetailDao = new EmployeeFundIssuanceDetail();
                BaseSalaryCommon baseSalaryCommon = list.get(0);
                if (null != baseSalaryCommon) {
                    int companyId = BaseHelpUtils.getIntValue(baseSalaryCommon.getCompanyId());
                    int year = BaseHelpUtils.getIntValue(baseSalaryCommon.getYear());
                    int month = BaseHelpUtils.getIntValue(baseSalaryCommon.getMonth());
                    int personnelBusinessId = BaseHelpUtils.getIntValue(baseSalaryCommon.getPersonnelBusinessId());
                    employeeFundIssuanceDao.clear();
                    employeeFundIssuanceDao.setConditionCompanyId("=", companyId);
                    employeeFundIssuanceDao.setConditionYear("=", year);
                    employeeFundIssuanceDao.setConditionMonth("=", month);
                    employeeFundIssuanceDao.setConditionFundType("=", 1);
                    employeeFundIssuanceDao.setConditionPersonelBusinessId("=", personnelBusinessId);
                    List<BaseEmployeeFundIssuance> baseEmployeeFundIssuances = employeeFundIssuanceDao.conditionalLoad();
                    employeeFundIssuanceDao.conditionalDelete();
                    if (null != baseEmployeeFundIssuances && baseEmployeeFundIssuances.size() != 0) {
                        for (BaseEmployeeFundIssuance bean : baseEmployeeFundIssuances) {
                            Integer employeeFundIssuanceId = bean.getEmployeeFundIssuanceId();
                            employeeFundIssuanceDetailDao.clear();
                            employeeFundIssuanceDetailDao.setConditionEmployeeFundIssuanceId("=", employeeFundIssuanceId);
                            employeeFundIssuanceDetailDao.conditionalDelete();
                        }

                    }
                }
        }
    }

    /**
     * @Author: liubin
     * @Description : 保存子表的数据
     * @Date: 16:23 2019/4/22
     */
    private void saveEmployeeFundIssuanceIdDetail(List<BaseSalaryCommon> list) throws SQLException {
        if (null != list && list.size() != 0) {
            ArrayList<BaseEmployeeFundIssuanceDetail> beans = new ArrayList<>();
            EmployeeFundIssuanceDetail dao = new EmployeeFundIssuanceDetail();
            //发放人数(主表)
            int payNumberMain = 0;
            //发放金额(主表)
            BigDecimal payMoneyMain = BigDecimal.ZERO;
            //冲账金额(主表)
            BigDecimal amountOfCreditMain = BigDecimal.ZERO;
            //冲账数量(主表)
            int numberOfCreditMain = 0;
            //总计金额(主表)
            BigDecimal totalSum = BigDecimal.ZERO;
            for (int i = 0; i < list.size(); i++) {
                BaseSalaryCommon baseSalaryCommon = list.get(i);
                BaseEmployeeFundIssuanceDetail bean = new BaseEmployeeFundIssuanceDetail();
                bean.setEmployeeId(BaseHelpUtils.getIntValue(baseSalaryCommon.getEmployeeId()));
                bean.setEmployeeNo(BaseHelpUtils.getString(baseSalaryCommon.getEmployeeNo()));
                bean.setYear(BaseHelpUtils.getIntValue(baseSalaryCommon.getYear()));
                bean.setMonth(BaseHelpUtils.getIntValue(baseSalaryCommon.getMonth()));
                bean.setFundraisingTypeId(BaseHelpUtils.getIntValue(baseSalaryCommon.getFundraisingProjectType()));
                bean.setPlateId(BaseHelpUtils.getIntValue(baseSalaryCommon.getPlateId()));
                bean.setRatio(BaseHelpUtils.getBigDecimalValue(baseSalaryCommon.getFundraisingProjectRate()));
                bean.setPersonelBusinessId(BaseHelpUtils.getIntValue(baseSalaryCommon.getPersonnelBusinessId()));
                bean.setProcessStatus(1);
                bean.setCreateTime(new Date());
                //设置类型为工资
                bean.setFundType(1);
                //总金额
                BigDecimal factSalary = BaseHelpUtils.getBigDecimalValue(baseSalaryCommon.getFactSalary());

                bean.setTotalMoney(factSalary);
                BigDecimal fundraisingProjectRate = BaseHelpUtils.getBigDecimalValue(baseSalaryCommon.getFundraisingProjectRate());
                //冲账金额
                BigDecimal amountOfCredit = (factSalary.subtract(factSalary.multiply(fundraisingProjectRate.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP)))).setScale(2, BigDecimal.ROUND_HALF_UP);
                bean.setAmountOfCredit(amountOfCredit);
                //实付金额
                BigDecimal subtract = factSalary.subtract(amountOfCredit);
                bean.setIssueMoney(subtract);
                beans.add(bean);

                //主表数据整理
                //记录实发金额大于0 人数
                if (factSalary.compareTo(BigDecimal.ZERO) == 1 || factSalary.compareTo(BigDecimal.ZERO) == 0) {
                    //主表总计发放人数
                    payNumberMain++;
                    //总计金额
                    totalSum = totalSum.add(factSalary);
                }
                //发放比例不为100%时则表示有冲账的金额
                if (fundraisingProjectRate.compareTo(new BigDecimal(100)) != 0) {
                    //冲账金额数量
                    numberOfCreditMain++;
                }
                //计算实发金额
                payMoneyMain = payMoneyMain.add(subtract);
                //计算冲账金额
                amountOfCreditMain = amountOfCreditMain.add(amountOfCredit);
            }
            BaseSalaryCommon baseSalaryCommon = list.get(0);
            int year = BaseHelpUtils.getIntValue(baseSalaryCommon.getYear());
            int month = BaseHelpUtils.getIntValue(baseSalaryCommon.getMonth());
            int companyId = BaseHelpUtils.getIntValue(baseSalaryCommon.getCompanyId());
            int fundraisingProjectType = BaseHelpUtils.getIntValue(baseSalaryCommon.getFundraisingProjectType());
            int personnelBusinessId = BaseHelpUtils.getIntValue(baseSalaryCommon.getPersonnelBusinessId());
            //发放类型（0募投项目 ，1非募投项目）
            int releaseType = 0;
            if (fundraisingProjectType == 0) {
                releaseType = 1;
            }
            //设置主表的数据
            BaseEmployeeFundIssuance baseEmployeeFundIssuance = new BaseEmployeeFundIssuance();
            EmployeeFundIssuance employeeFundIssuanceDao = new EmployeeFundIssuance();
            baseEmployeeFundIssuance.setFundType(1);
            baseEmployeeFundIssuance.setYear(year);
            baseEmployeeFundIssuance.setMonth(month);
            baseEmployeeFundIssuance.setCompanyId(companyId);
            baseEmployeeFundIssuance.setPayNumber(payNumberMain);
            baseEmployeeFundIssuance.setPayMoney(payMoneyMain);
            baseEmployeeFundIssuance.setNumberOfCredit(numberOfCreditMain);
            baseEmployeeFundIssuance.setAmountOfCredit(amountOfCreditMain);
            baseEmployeeFundIssuance.setReleaseType(releaseType);
            baseEmployeeFundIssuance.setFundrasingTypeId(fundraisingProjectType);
            baseEmployeeFundIssuance.setAccountingNumber(numberOfCreditMain);
            baseEmployeeFundIssuance.setTotalSum(totalSum);
            baseEmployeeFundIssuance.setPersonelBusinessId(personnelBusinessId);
            baseEmployeeFundIssuance.setCreateTime(new Date());
            employeeFundIssuanceDao.setDataFromBase(baseEmployeeFundIssuance);
            employeeFundIssuanceDao.setProcessStatus(1);
            employeeFundIssuanceDao.save();
            Integer employeeFundIssuanceId = employeeFundIssuanceDao.getEmployeeFundIssuanceId();

            //设置子表的主键
            for (BaseEmployeeFundIssuanceDetail bean : beans) {
                bean.setEmployeeFundIssuanceId(employeeFundIssuanceId);
            }
            dao.save(beans);
        }
    }

    /**
     * @Author: liubin
     * @Description :
     * @Date: 8:43 2019/4/20
     */
    private String initializationResult(Map<String, Object> result) throws SQLException {
        int status = -1;
        int year = BaseHelpUtils.getIntValue(result.get("year"));
        int month = BaseHelpUtils.getIntValue(result.get("month"));
        QueryCurrentMonthSalaryType query = new QueryCurrentMonthSalaryType();
        ConditionCurrentMonthSalaryType conditon = new ConditionCurrentMonthSalaryType();
        conditon.setMonth(month);
        conditon.setYear(year);
        BaseCollection<BaseCurrentMonthSalaryType> bc = query.executeQuery(null, conditon);
        if (null != bc) {
            status = 1;
        }
        return bc.toJSON(status, null);
    }

    /**
     * @Author: liubin
     * @Description:查询募投项目类型数量
     * @Date: 16:58 2019/4/19
     */
    private String inquireFundraisingProjectType(Map<String, Object> result) throws SQLException {
        int status = -1;
        int year = BaseHelpUtils.getIntValue(result.get("year"));
        int month = BaseHelpUtils.getIntValue(result.get("month"));
        int companyId = BaseHelpUtils.getIntValue(result.get("companyId"));
        QueryCurrentMonthSalaryType query = new QueryCurrentMonthSalaryType();
        ConditionCurrentMonthSalaryType conditon = new ConditionCurrentMonthSalaryType();
        conditon.setMonth(month);
        conditon.setYear(year);
        conditon.setCompanyId(companyId);
        BaseCollection<BaseCurrentMonthSalaryType> bc = query.executeQuery(null, conditon);
        if (null != bc) {
            List<BaseCurrentMonthSalaryType> lists = bc.getCollections();
            if (null != lists && lists.size() != 0) {
//                Map<String, Object> map = new HashMap<>();
//                map.put("count", lists.size());
//                collection.setUserData(map);
                status = BaseHelpUtils.getIntValue(lists.size() + 1);
                BaseCurrentMonthSalaryType bean = new BaseCurrentMonthSalaryType();
                bean.setFundraisingProjectType(0);
                lists.add(bean);
                return bc.toJSON(status, null);
            } else {
                BaseCollection<BaseCurrentMonthSalaryType> collection = query.executeQuery(null, conditon);
                ArrayList<BaseCurrentMonthSalaryType> list = new ArrayList<>();
                BaseCurrentMonthSalaryType bean = new BaseCurrentMonthSalaryType();
                bean.setFundraisingProjectType(0);
                list.add(bean);
                collection.setCollections(list);
                status = 1;
                return collection.toJSON(status, null);
            }
        } else {
            BaseCollection<BaseCurrentMonthSalaryType> collection = query.executeQuery(null, conditon);
            ArrayList<BaseCurrentMonthSalaryType> list = new ArrayList<>();
            BaseCurrentMonthSalaryType bean = new BaseCurrentMonthSalaryType();
            bean.setFundraisingProjectType(0);
            list.add(bean);
            collection.setCollections(list);
            status = 1;
            return collection.toJSON(status, null);
        }
    }

    /**
     * @Author: liubin
     * @Description：批量保存募投项目的数据
     * @Date: 9:43 2019/4/19
     */
    private String saveEmployeeSalaryTypes(Map<String, Object> result) throws SQLException {
        int status = -1;
        BaseCollection<GenericBase> collection = new BaseCollection<>();
        List<Map<String, Object>> lists = (List<Map<String, Object>>) result.get("list");
        List<BaseEmployeeSalaryType> beans = new ArrayList<>();
        EmployeeSalaryType employeeSalaryType = new EmployeeSalaryType();
        if (null != lists && lists.size() != 0) {
            for (Map<String, Object> map : lists) {
                BaseEmployeeSalaryType baseEmployeeSalaryType = new BaseEmployeeSalaryType();
                baseEmployeeSalaryType.setEmployeeId(BaseHelpUtils.getIntValue(map.get("employeeId")));
                baseEmployeeSalaryType.setEmployeeNo(BaseHelpUtils.getString(map.get("employeeNo")));
                baseEmployeeSalaryType.setEmployeeName(BaseHelpUtils.getString(map.get("employeeName")));
                baseEmployeeSalaryType.setPlateId(BaseHelpUtils.getIntValue(map.get("plateId")));
                baseEmployeeSalaryType.setYear(BaseHelpUtils.getIntValue(map.get("year")));
                baseEmployeeSalaryType.setMonth(BaseHelpUtils.getIntValue(map.get("month")));
                baseEmployeeSalaryType.setFundraisingProjectType(BaseHelpUtils.getIntValue(map.get("fundraisingProjectType")));
                baseEmployeeSalaryType.setFundraisingProjectRate(BaseHelpUtils.getBigDecimalValue(map.get("fundraisingProjectRate")));
                beans.add(baseEmployeeSalaryType);
            }
            employeeSalaryType.save(beans);
            status = 0;
        }
        return collection.toJSON(status, null);
    }


    public static void main(String[] args) throws SQLException {
        EmployeeFundIssuance employeeFundIssuance = new EmployeeFundIssuance();
        BaseEmployeeFundIssuance baseEmployeeFundIssuance = new BaseEmployeeFundIssuance();
        baseEmployeeFundIssuance.setCreateTime(new Date());
        baseEmployeeFundIssuance.setCompanyId(1);
        employeeFundIssuance.setDataFromBase(baseEmployeeFundIssuance);
        employeeFundIssuance.save();
        System.out.println(employeeFundIssuance.generateBase().getEmployeeFundIssuanceId());
        System.out.println(employeeFundIssuance.getEmployeeFundIssuanceId());
    }
}
