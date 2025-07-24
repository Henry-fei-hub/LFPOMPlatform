package pomplatform.account.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.IntegralReturnOfPlate.bean.BaseIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.bean.ConditionIntegralReturnOfPlate;
import pomplatform.IntegralReturnOfPlate.query.QueryIntegralReturnOfPlate;
import pomplatform.account.bean.*;
import pomplatform.account.query.*;
import pomplatform.common.utils.AccountUtils;
import pomplatform.revenue.bean.BaseOnLoadSaleIntegralFromPlate;

/**
 * 账户管理
 * @author lxf
 */
public class AccountManageProcess implements GenericProcessor,GenericDownloadProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    //加载部门账户数据集
    private static final String ON_LOAD_PLATE_ACCOUNT_DATA = "onLoadPlateAccountData";
    //保存品质管理发放
    private static final String ON_SAVE_PLATE_INTEGRAL_ACHIEVE= "onSavePlateIntegralAchieve";
    //加載部門下發放獎金的成員的數據集
    private static final String ON_LOAD_PLATE_PERFORMANCE_BONUS_DATA= "onLoadPlateEmpPerformanceBonusData";
    //部门成员绩效奖金的发放保存
    private static final String ON_SAVE_PLATE_PERFORMANCE_BONUS= "onSavePlateEmpPerformanceBonus";
    //加载部门账户的剩余总积分
    private static final String ON_LOAD_PLATE_ACCOUNT_TOTAL_INTEGRAL= "onLoadPlateAccountTotalIntegral";
    //加载部门账户积分数据集
    private static final String ON_LOAD_PLATE_INTEGRAL_DATA= "onLoadPlateIntegralData";
    //保存部门提取积分到公司账户
    private static final String ON_SAVE_PLATE_GIVE_INTEGRAL_TO_COMPANY = "onSavePlateGiveIntegralToCompany";
    //加载个人账户数据集
    private static final String ON_LOAD_EMPLOYEE_ACCOUNT_DATA = "onLoadEmployeeAccountData";
    //加载个人账户数据集(处理后的)
    private static final String ON_LOAD_EMPLOYEE_ACCOUNT_CUSTOM_DATA = "onLoadEmployeeAccountCustomData";
    //加载年度个人效益指数
    private static final String ON_LOAD_BENEFITS_DATA = "onLoadBenefitsData";
    //加载每月统计数据集
    private static final String ON_LOAD_MONTH_REPORT_DATA = "onLoadMonthReportData";
    //个人账户数据导出
    private static final String ON_EMPLOYEE_ACCOUNT_EXPORT_DATA = "onEmployeeAccountExportData";
    //部门账户数据导出
    private static final String ON_PLATE_ACCOUNT_EXPORT_DATA = "onPlateAccountExportData";
    //部门账户积分收款人员数据加载
    private static final String ON_PLATE_ACCOUNT_INTEGRAL_RETURN_EMP_DATA = "onPlateAccountIntegralReturnEmpData";
    //部门账户公司还款部门欠款数据加载
    private static final String ON_COMPANY_REPAYMENT_DATA = "onCompanyRepaymentData";
    //部门账户加载月统计数据
    private static final String ON_LOAD_MONTH_STATATISTIC_OF_PLATE_ACCOUNT = "onLoadMonthStatisticOfPlateAccount";
    //部门账户公司还款插入数据
    private static final String ON_COMPANY_REPAYMENT = "onCompanyRepayment";
    //部门账户公司借款插入数据
    private static final String ON_COMPANY_LOAN = "onCompanyLoan";
    //加载部门实时余额积分
    private static final String ON_LOAD_LEFT_INTEGRAL_OF_PLATE = "onLoadLeftIntegralOFPlate";
    //加载员工实时余额积分和个人效益指数
    private static final String ON_LOAD_LEFT_INTEGRAL_AND_BENEFITS = "onLoadLeftIntegralAndBenefits";
    //积分回收保存
    private static final String ON_SAVE_INTEGRAL_RETURN = "onSaveIntegralReturn";
    //积分借款保存
    private static final String ON_SAVE_INTEGRAL_ADVANCE = "OnSavePlateAdvince";
    //加载项目账户的数据集
    private static final String ON_LOAD_PROJECT_ACCOUNT_DATA = "onLoadProjectAccountData";
    //加载订单账户的数据集
    private static final String ON_LOAD_SHEET_ACCOUNT_DATA = "onLoadSheetAccountData";
    //获取员工的账户实时余额
    private static final String ON_GET_LEFT_INTEGRAL_OF_EMPLOYEE = "onGetLeftIntegralOfEmployee";
    //保存分配积分
    private static final String ON_SAVE_PLATE_INTEGRAL_DISTRIBUTION = "onSavePlateIntegralDistribution";
    //营销部门销售积分提取
    private static final String ON_SAVE_SALE_INTEGRAL = "onSaveSaleIntegral";
    //检索是否有部门是一级部门
    private static final String ON_CHECK_IS_HAS_PARENT = "onCheckIsHasParent";
    //加载部门实时余额积分(带时间维度)
    private static final String ON_LOAD_LEFT_INTEGRAL_OF_PLATE_BY_TIME = "onLoadLeftIntegralOFPlateByTime";
    //公司账户---公司补贴---关联到部门账户
    private static final String ON_SAVE_PLATE_ACCOUNT_DATA="onSavePlateAccountData";
    //部门账户---部门调配保存
	private static final String ON_PLATE_DEPLOY_SAVE = "onPlateDeploySave";
	//部门账户---产值结算数据加载
	private static final String ON_LOAD_OUTPUT_ACCOUNT_DATA = "onLoadOutputAccountData";
    //部门账户---产值结算保存
    private static final String ON_OUTPUT_ACCOUNT_SAVE = "onOutputAccountSave";
    
    //**************************定义部门账户的业务功能类型*************     此数据严禁修改               此数据严禁删除          
    public static final int PLATE_BT_SURE_INTEGRAL = 1;//确认积分(收入)
    public static final int PLATE_BT_COMPANY_SUBSIDY = 2;//公司补贴(收入)
    public static final int PLATE_BT_INTEGRAL_RECYCLE = 3;//积分回收(收入)
    public static final int PLATE_BT_SALAEY_REFUND = 4;//积分还款(收入)
    public static final int PLATE_BT_INTEGRAL_ADVANCE = 5;//积分借款(支出)
    public static final int PLATE_BT_BONUS_SUBSIDY = 6;//奖金补贴(支出)
    public static final int PLATE_BT_PLATE_COST = 7;//运营成本(支出)
    public static final int PLATE_BT_PROJECT_SUBSIDY = 8;//项目补贴(支出)
    public static final int PLATE_BT_COLLABORATIVE_ACHIEVE = 9;//协作收入(收入)
    public static final int PLATE_BT_COLLABORATIVE_PAY = 10;//协作支出(支出)
    public static final int PLATE_BT_PERFORMANCE_BONUS = 11;//绩效奖金(支出)
    public static final int PLATE_BT_COMPANY_FEE = 12;//公司费用(支出)
    public static final int PLATE_BT_VIOLATION_CHARGES = 13;//资源绩效(收入)
    public static final int PLATE_BT_COMPANY_REFUND = 14;//公司还款(支出)
    public static final int PLATE_BT_COMPANY_ADVANCE = 15;//公司借款(收入)
    public static final int PLATE_BT_DEVELOP_PROJECT = 16;//研发项目(支出)
    public static final int PLATE_BT_MANAGE_PROJECT = 17;//管理项目(支出)
    public static final int PLATE_BT_ATTENDANCE_DEDUCT = 18;//考勤扣款(收入)
    public static final int PLATE_BT_CONTRACT_CHANGE = 19;//合同变更(支出)
    public static final int PLATE_BT_END_PROJECT = 20;//项目结项（收入）
    public static final int PLATE_BT_SALE_INTEGRAL = 21;//销售积分（收入）
    public static final int PLATE_BT_SEND_ACHIEVE = 22;//分配收入（收入）
    public static final int PLATE_BT_SEND_PAY = 23;//分配支出（支出）
    public static final int PLATE_BT_EMPLOYEE_COST = 24;//人工成本（支出）
    public static final int PLATE_BT_CONTRACT_DISTRIBUTION_INCOME = 25;//提成收入
    public static final int PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE = 26;//提成支出
    public static final int PLATE_BT_PROJECT_PERFORMANCE = 27;//项目绩效收入
    public static final int PLATE_BT_PROJECT_PERFORMANCE_PAY = 28;//项目绩效支出
	public static final int PLATE_BT_DEP_DEPLOY = 29;//部门调配支出
	public static final int PLATE_BT_OUTPUT_ACCOUNT = 30;//产值结算支出
    
    //**************************定义个人账户的业务功能类型*************     此数据严禁修改               此数据严禁删除                 
    public static final int EMP_BT_SURE_INTEGRAL = 1;//确认积分(收入)
    public static final int EMP_BT_BONUS_SUBSIDY = 2;//奖金补贴(收入)
    public static final int EMP_BT_INTEGRAL_ADVANCE = 3;//积分借款(收入)
    public static final int EMP_BT_PROJECT_SUBSIDY = 4;//项目补贴(收入)
    public static final int EMP_BT_SALAEY_REFUND = 5;//积分还款(支出)
    public static final int EMP_BT_EMPLOYEE_COST = 6;//人工成本(支出)
    public static final int EMP_BT_PROJECT_COST = 7;//项目成本(支出)
    public static final int EMP_BT_BONUS_SEND = 8;//奖金发放(支出)
    public static final int EMP_BT_INTEGRAL_RECYCLE = 9;//积分回收(支出)
    public static final int EMP_BT_PERFORMANCE_BONUS = 10;//绩效奖金(收入)
    public static final int EMP_BT_VIOLATION_CHARGES = 11;//资源绩效(支出)
    public static final int EMP_BT_ATTENDANCE_DEDUCT = 12;//考勤扣款(支出)
    public static final int EMP_BT_PM_PERFORMANCE_AWARD = 13;//项目经理绩效奖励(收入)
    public static final int EMP_BT_PM_PERFORMANCE_DEDUCT = 14;//项目经理绩效扣除(支出)
    public static final int EMP_BT_PROJECT_PERFORMANCE = 15;//项目绩效(收入)
    public static final int EMP_BT_CONTRACT_CHANGE = 16;//合同变更(支出)
    public static final int EMP_BT_PLATE_CHANGE_ACHIEVE = 17;//转岗结算收入(收入)
    public static final int EMP_BT_PLATE_CHANGE_PAY = 18;//转岗结算支出(支出)
    public static final int EMP_BT_PROJECT_PERFORMANCE_PAY = 19;//项目绩效支出(支出)
    public static final int EMP_BT_CONTRACT_DISTRIBUTION_INCOME = 20;//提成收入
    public static final int EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE = 21;//提成支出
	public static final int EMP_BT_DEP_DEPLOY = 22;//部门调配收入
	public static final int EMP_BT_OUTPUT_ACCOUNT = 23;//产值结算支出
    
    //**************************定义账户类型**********************     此数据严禁修改               此数据严禁删除
    public static final int ACCOUNT_EMP_ACCOUNT = 1;//个人账户
    public static final int ACCOUNT_PLATE_ACCOUNT = 2;//部门账户
    public static final int ACCOUNT_QUALITY_ACCOUNT = 3;//品质基金账户
    public static final int ACCOUNT_PROJECT_ACCOUNT = 4;//项目账户
    public static final int ACCOUNT_SHEET_ACCOUNT = 5;//订单账户
    
    //**************************定义账户业务类型*******************     此数据严禁修改               此数据严禁删除
    public static final int pm_performance_award = 1;//项目经理绩效奖励
    public static final int pm_performance_deduct = 2;//项目经理绩效扣除
    public static final int project_performance_award = 3;//项目绩效奖励
    public static final int project_performance_deduct = 4;//项目绩效扣除
    public static final int project_performance_remain = 5;//项目绩效结余
    public static final int project_performance_achieve = 6;//项目绩效收入
    public static final int project_performance = 7;//项目绩效支出
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_LOAD_PLATE_ACCOUNT_DATA.equals(optType)){
        	return onLoadPlateAccountData(param);
        }else if(ON_SAVE_PLATE_INTEGRAL_ACHIEVE.equals(optType)){
        	return onSavePlateIntegralAchieve(creteria);
        }else if(ON_LOAD_PLATE_PERFORMANCE_BONUS_DATA.equals(optType)){
        	return onLoadPlateEmpPerformanceBonusData(param);
        }else if(ON_SAVE_PLATE_PERFORMANCE_BONUS.equals(optType)){
        	return onSavePlateEmpPerformanceBonus(param);
        }else if(ON_LOAD_PLATE_ACCOUNT_TOTAL_INTEGRAL.equals(optType)){
        	return onLoadPlateAccountTotalIntegral(param);
        }else if(ON_LOAD_PLATE_INTEGRAL_DATA.equals(optType)){
        	return onLoadPlateIntegralData(param);
        }else if(ON_SAVE_PLATE_GIVE_INTEGRAL_TO_COMPANY.equals(optType)){
        	return onSavePlateGiveIntegralToCompany(creteria);
        }else if(ON_LOAD_EMPLOYEE_ACCOUNT_DATA.equals(optType)){
        	return onLoadEmployeeAccountData(param);
        }else if(ON_LOAD_BENEFITS_DATA.equals(optType)){
        	return onLoadBenefitsData(param);
        }else if(ON_LOAD_MONTH_REPORT_DATA.equals(optType)){
        	return onLoadMonthReportData(param);
        }else if(ON_LOAD_EMPLOYEE_ACCOUNT_CUSTOM_DATA.equals(optType)){
        	return onLoadEmployeeAccountCustomData(param);
        }else if(ON_PLATE_ACCOUNT_INTEGRAL_RETURN_EMP_DATA.equals(optType)){
        	return onPlateAccountIntegralReturnEmpData(param);
        }else if(ON_COMPANY_REPAYMENT_DATA.equals(optType)){
        	return onCompanyRepaymentData(param);
        }else if(ON_LOAD_MONTH_STATATISTIC_OF_PLATE_ACCOUNT.equals(optType)){
        	return onLoadMonthStatisticOfPlateAccount(param);
        }else if(ON_COMPANY_REPAYMENT.equals(optType)){
        	return onCompanyRepayment(creteria);
        }else if(ON_COMPANY_LOAN.equals(optType)){
        	return onCompanyLoan(creteria);
        }else if(ON_LOAD_LEFT_INTEGRAL_OF_PLATE.equals(optType)){
        	return onLoadLeftIntegralOFPlate(param);
        }else if(ON_LOAD_LEFT_INTEGRAL_AND_BENEFITS.equals(optType)){
        	return onLoadLeftIntegralAndBenefits(param);
        }else if(ON_SAVE_INTEGRAL_RETURN.equals(optType)){
        	return onSaveIntegralReturn(param);
        }else if(ON_SAVE_INTEGRAL_ADVANCE.equals(optType)){
        	return onSaveIntegralAdvance(param);
        }else if(ON_LOAD_PROJECT_ACCOUNT_DATA.equals(optType)){
        	return onLoadProjectAccountData(param);
        }else if(ON_LOAD_SHEET_ACCOUNT_DATA.equals(optType)){
        	return onLoadSheetAccountData(param);
        }else if(ON_GET_LEFT_INTEGRAL_OF_EMPLOYEE.equals(optType)){
        	return onGetLeftIntegralOfEmployee(BaseHelpUtils.getIntValue(param.get("employeeId")));
        }else if(ON_SAVE_PLATE_INTEGRAL_DISTRIBUTION.equals(optType)){
        	return onSavePlateIntegralDistribution(param);
        }else if(ON_SAVE_SALE_INTEGRAL.equals(optType)){
        	return onSaveSaleIntegral(param);
        }else if(ON_CHECK_IS_HAS_PARENT.equals(optType)){
        	return onCheckIsHasParent(param);
        }else if(ON_LOAD_LEFT_INTEGRAL_OF_PLATE_BY_TIME.equals(optType)){
        	return onLoadLeftIntegralOFPlateByTime(param);
        }else if(ON_SAVE_PLATE_ACCOUNT_DATA.equals(optType)) {
        	return onSavePlateAccountData(param);
        }else if(ON_PLATE_DEPLOY_SAVE.equals(optType)) {
			return onPlateDeploySave(param);
		}else if(ON_LOAD_OUTPUT_ACCOUNT_DATA.equals(optType)) {
			return onLoadOutputAccountData(param);
		}else if(ON_OUTPUT_ACCOUNT_SAVE.equals(optType)) {
            return onOutputAccountSave(param);
        }
        return null;
    }

    /**
     * 部门账户---产值结算保存
     * @param param
     * @return
     * @throws Exception
     * @throws ParseException
     */
    public String onOutputAccountSave(Map<String, Object> param) throws Exception, ParseException{
        int plateId = BaseHelpUtils.getIntValue(param, "plateId");
        if(plateId <= 0){
            throw new SQLException("数据加载异常：获取部门编码失败");
        }
        //获取开始日期和结束日期
        String startDateStr = BaseHelpUtils.getStringValue(param,"startDate");
        if(BaseHelpUtils.isNullOrEmpty(startDateStr)){
            throw new SQLException("数据加载异常：获取开始日期失败");
        }
        String endDateStr = BaseHelpUtils.getStringValue(param,"endDate");
        if(BaseHelpUtils.isNullOrEmpty(endDateStr)){
            throw new SQLException("数据加载异常：获取结束日期失败");
        }
        Date startDate = new Date(Long.valueOf(startDateStr));
        Date endDate = new Date(Long.valueOf(endDateStr));
        //设置结束日期即为结算日期
        Date accountDate = endDate;
        //获取部门结算总产值和人员结算总产值
        BigDecimal depAccountIntegral = BaseHelpUtils.getBigDecimalValue(param.get("depAccountIntegral"));
        BigDecimal empAccountIntegral = BaseHelpUtils.getBigDecimalValue(param.get("empAccountIntegral"));
        //获取结算成员列表数据集
        List<BaseOnLoadEmployeeAccountByBusinessTypeData> list = GenericBase.__getList(param.get("detailList"),BaseOnLoadEmployeeAccountByBusinessTypeData.newInstance());
        //取每个成员的结算累计金额
        BigDecimal totalIntegral = BigDecimal.ZERO;
        if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
            for(BaseOnLoadEmployeeAccountByBusinessTypeData e : list){
                //获取成员的结算总金额
                BigDecimal accountIntegral = BaseHelpUtils.getBigDecimalValue(e.getAccountIntegral());
                totalIntegral = totalIntegral.add(accountIntegral);
            }
        }
        if(empAccountIntegral.compareTo(totalIntegral) != 0){
            throw new SQLException("操作异常：成员结算累计数不一致");
        }
        //获取结算年月份
        int year = DateUtil.getYear(accountDate);
        int month = DateUtil.getMonth(accountDate);
        Date currentTime = new Date();
        ThreadConnection.beginTransaction();
        //保存总表数据
        OutputAccountRecord dao = new OutputAccountRecord();
        OutputAccountDetail daoDetail = new OutputAccountDetail();
        BaseOutputAccountRecord bean = new BaseOutputAccountRecord();
        BaseOutputAccountDetail beanDetail = null;
        bean.setDataFromMap(param);
        bean.setStartDate(startDate);
        bean.setEndDate(endDate);
        bean.setAccountDate(accountDate);
        bean.setYear(year);
        bean.setMonth(month);
        bean.setOperateTime(currentTime);
        dao.setDataFromBase(bean);
        dao.save();
        int totalId = dao.getOutputAccountRecordId();
        String remark = bean.getRemark();
        int operateId = bean.getOperateEmployeeId();
        //保存部门账户数据
        if(depAccountIntegral.compareTo(BigDecimal.ZERO) != 0){
            AccountManageProcess.onSavePlateAccount(plateId,totalId,AccountManageProcess.PLATE_BT_OUTPUT_ACCOUNT,depAccountIntegral,accountDate,remark,operateId);
        }
        //保存成员数据集
        if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
            for(BaseOnLoadEmployeeAccountByBusinessTypeData e : list){
                //获取成员的结算总金额
                BigDecimal accountIntegral = BaseHelpUtils.getBigDecimalValue(e.getAccountIntegral());
                int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
                beanDetail = new BaseOutputAccountDetail();
                beanDetail.setEmployeeId(empId);
                beanDetail.setOutputAccountRecordId(totalId);
                beanDetail.setAccountIntegral(accountIntegral);
                beanDetail.setStartDate(startDate);
                beanDetail.setEndDate(endDate);
                beanDetail.setAccountDate(accountDate);
                beanDetail.setYear(year);
                beanDetail.setMonth(month);
                daoDetail.clear();
                daoDetail.setDataFromBase(beanDetail);
                daoDetail.save();
                int businessId = daoDetail.getOutputAccountDetailId();
                //保存个人账户
                AccountManageProcess.onSaveEmployeeAccount(empId,businessId,AccountManageProcess.EMP_BT_OUTPUT_ACCOUNT,accountIntegral,accountDate,remark,operateId);
            }
        }
        ThreadConnection.commit();
        BaseCollection<GenericBase> bc = new BaseCollection<>();
        return bc.toJSON(0,null);
    }

	/**
	 * 部门账户---产值结算数据加载
	 * @param param
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public String onLoadOutputAccountData(Map<String, Object> param) throws Exception, ParseException{
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		if(plateId <= 0){
			throw new SQLException("数据加载异常：获取部门编码失败");
		}
		//获取开始日期和结束日期
		String startDateStr = BaseHelpUtils.getStringValue(param,"startDate");
		if(BaseHelpUtils.isNullOrEmpty(startDateStr)){
			throw new SQLException("数据加载异常：获取开始日期失败");
		}
		String endDateStr = BaseHelpUtils.getStringValue(param,"endDate");
		if(BaseHelpUtils.isNullOrEmpty(endDateStr)){
			throw new SQLException("数据加载异常：获取结束日期失败");
		}
		Date startDate = new Date(Long.valueOf(startDateStr));
		Date endDate = new Date(Long.valueOf(endDateStr));
		//加载该部门下个人账户数据集
		QueryOnLoadEmployeeAccountByBusinessTypeData query = new QueryOnLoadEmployeeAccountByBusinessTypeData();
		ConditionOnLoadEmployeeAccountByBusinessTypeData con = new ConditionOnLoadEmployeeAccountByBusinessTypeData();
		con.setPlateId(plateId);
		con.setStartDate(startDate);
		con.setEndDate(endDate);
		BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> result = query.executeQuery(null,con);
		//定义list来存放返回的数据集
		List<BaseOnLoadEmployeeAccountByBusinessTypeData> resultList = new ArrayList<>();
		//定义map来存放个人数据集
		Map<Integer,BaseOnLoadEmployeeAccountByBusinessTypeData> empMap = new HashMap<>();
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			List<BaseOnLoadEmployeeAccountByBusinessTypeData> list = result.getCollections();
			for(BaseOnLoadEmployeeAccountByBusinessTypeData e : list){
				int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
				BaseOnLoadEmployeeAccountByBusinessTypeData bean = empMap.get(empId);
				if(BaseHelpUtils.isNullOrEmpty(bean)){
					bean = new BaseOnLoadEmployeeAccountByBusinessTypeData();
					bean.setDataFromJSON(e.toJSON());
					bean.setBusinessTypeId(null);
					bean.setParentId(null);
				}else{
					BigDecimal accountIntegral = BaseHelpUtils.getBigDecimalValue(bean.getAccountIntegral());
					BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAccountIntegral());
					int parentId = BaseHelpUtils.getIntValue(e.getParentId());
					if(parentId == -1){
						if(integral.compareTo(BigDecimal.ZERO) < 0){
							integral = integral.abs();
						}
						accountIntegral = accountIntegral.subtract(integral);
					}else{
						accountIntegral = accountIntegral.add(integral);
					}
					bean.setAccountIntegral(accountIntegral);
				}
				empMap.put(empId,bean);
			}
		}
		//定义该部门下所有成员产值总积分
		BigDecimal empOutputIntegral = BigDecimal.ZERO;
		if(!BaseHelpUtils.isNullOrEmpty(empMap) && empMap.size() > 0){
			for(Integer id : empMap.keySet()){
				BaseOnLoadEmployeeAccountByBusinessTypeData be = empMap.get(id);
                BigDecimal integral = BaseHelpUtils.getBigDecimalValue(be.getAccountIntegral());
                if(integral.compareTo(BigDecimal.ZERO) > 0){
                    resultList.add(be);
                    empOutputIntegral = empOutputIntegral.add(integral);
                }
			}
		}
		//加载该部门下的总产值
		QueryonLoadAccountInfoOfPlateAccount queryPlate = new QueryonLoadAccountInfoOfPlateAccount();
		ConditiononLoadAccountInfoOfPlateAccount conPlate = new ConditiononLoadAccountInfoOfPlateAccount();
		conPlate.setPlateId(plateId);
		conPlate.setStartDate(startDate);
		conPlate.setEndDate(endDate);
		BaseCollection<BaseonLoadAccountInfoOfPlateAccount> resultPlate = queryPlate.executeQuery(null,conPlate);
		//定义该部门产值总积分
		BigDecimal depOutputIntegral = BigDecimal.ZERO;
		if(!BaseHelpUtils.isNullOrEmpty(resultPlate)){
			List<BaseonLoadAccountInfoOfPlateAccount> listPlate = resultPlate.getCollections();
			for(BaseonLoadAccountInfoOfPlateAccount e : listPlate){
				BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getIntegral());
				int parentId = BaseHelpUtils.getIntValue(e.getTypeParentId());
				if(parentId == -1){
					if(integral.compareTo(BigDecimal.ZERO) < 0){
						integral = integral.abs();
					}
					depOutputIntegral = depOutputIntegral.subtract(integral);
				}else{
					depOutputIntegral = depOutputIntegral.add(integral);
				}
			}
		}
		if(depOutputIntegral.compareTo(BigDecimal.ZERO) < 0){
            depOutputIntegral = BigDecimal.ZERO;
        }
		//定义map来存放返回的个人账户总产值和部门账户总产值
		Map<String,BigDecimal> userData = new HashMap<>();
		userData.put("empOutputIntegral",empOutputIntegral);
		userData.put("depOutputIntegral",depOutputIntegral);
		BaseCollection<BaseOnLoadEmployeeAccountByBusinessTypeData> bc = new BaseCollection<>();
		bc.setCollections(resultList);
		bc.setUserData(userData);
		return bc.toJSON(0,null);
	}

	/**
	 * 部门账户---部门调配保存
	 * @param param
	 * @return
	 * @throws SQLException
	 * @throws ParseException
	 */
	public String onPlateDeploySave(Map<String, Object> param) throws SQLException, ParseException{
		int plateId = BaseHelpUtils.getIntValue(param, "plateId");
		if(plateId <= 0){
			throw new SQLException("操作异常：获取部门编码失败");
		}
		//获取调配积分
		BigDecimal advanceIntegral = BaseHelpUtils.getBigDecimalValue(param.get("advanceIntegral"));
		if(advanceIntegral.compareTo(BigDecimal.ZERO) <= 0){
			throw new SQLException("操作异常：调配积分不可小于或等于0");
		}
		//获取成员列表数据集
		List<BasePlateDeployDetail> detailList = GenericBase.__getList(param.get("detailList"),BasePlateDeployDetail.newInstance());
		if(BaseHelpUtils.isNullOrEmpty(detailList) || detailList.size() == 0){
			throw new SQLException("操作异常：获取调配成员列表数据集失败");
		}
		BigDecimal totalIntegral = BigDecimal.ZERO;
		//获取每个成员调配的积分
		for(BasePlateDeployDetail e : detailList){
			BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAdvanceIntegral());
			if(integral.compareTo(BigDecimal.ZERO) == 0){
				continue;
			};
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			if(empId <= 0){
				continue;
			};
			totalIntegral = totalIntegral.add(integral);
		}
		if(advanceIntegral.compareTo(totalIntegral) != 0){
			throw new SQLException("操作异常：调配积分与成员累计调配积分不等");
		}
		Date operateTime = new Date();
		//获取调配日期
		Date advanceDate = operateTime;
		String advanceDateStr = BaseHelpUtils.getStringValue(param,"advanceDate");
		if(!BaseHelpUtils.isNullOrEmpty(advanceDateStr)){
			advanceDate = new Date(Long.valueOf(advanceDateStr));
		}
		PlateDeployRecord totalDao = new PlateDeployRecord();
		BasePlateDeployRecord totalBean = new BasePlateDeployRecord();
		PlateDeployDetail detailDao = new PlateDeployDetail();
		ThreadConnection.beginTransaction();
		//保存总表数据集
		totalBean.setDataFromMap(param);
		totalBean.setAdvanceDate(advanceDate);
		totalBean.setOperateTime(operateTime);
		totalDao.setDataFromBase(totalBean);
		totalDao.save();
		int totalId = totalDao.getPlateDeployRecordId();
		String remark = BaseHelpUtils.getString(totalBean.getRemark());
		int operateId = BaseHelpUtils.getIntValue(totalBean.getOperateEmployeeId());
		//保存到部门账户
		AccountManageProcess.onSavePlateAccount(plateId,totalId,AccountManageProcess.PLATE_BT_DEP_DEPLOY,advanceIntegral,advanceDate,remark,operateId);
		//保存调配人员表
		for(BasePlateDeployDetail e : detailList){
			BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getAdvanceIntegral());
			if(integral.compareTo(BigDecimal.ZERO) == 0){
				continue;
			}
			int empId = BaseHelpUtils.getIntValue(e.getEmployeeId());
			if(empId <= 0){
				continue;
			}
			detailDao.clear();
			detailDao.setPlateDeployRecordId(totalId);
			detailDao.setEmployeeId(empId);
			detailDao.setAdvanceIntegral(integral);
			detailDao.setAdvanceDate(advanceDate);
			detailDao.setOperateEmployeeId(operateId);
			detailDao.setOperateTime(operateTime);
			detailDao.setRemark(remark);
			detailDao.save();
			int businessId = detailDao.getPlateDeployDetailId();
			//保存个人账户
			AccountManageProcess.onSaveEmployeeAccount(empId,businessId,AccountManageProcess.EMP_BT_DEP_DEPLOY,integral,advanceDate,remark,operateId);
		}
		ThreadConnection.commit();
		BaseCollection<BaseOnGetLeftIntegralOfPlate> bc = new BaseCollection<>();
		return bc.toJSON(0,null);
	}
    
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_EMPLOYEE_ACCOUNT_EXPORT_DATA.equals(optType)){
        	onEmployeeAccountExportData(param,downFile);
        }else if(ON_PLATE_ACCOUNT_EXPORT_DATA.equals(optType)){
        	onPlateAccountExportData(param, downFile);
        }
	}
	
	/**
     * 加载部门实时余额积分(带时间维度)
     * @param param
     * @return
     * @throws SQLException 
	 * @throws ParseException 
     */
    public String onLoadLeftIntegralOFPlateByTime(Map<String, Object> param) throws SQLException, ParseException{
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	Date payDate = GenericBase.__getDate(param.get("payDate"));
    	Calendar calendar = Calendar.getInstance();
		calendar.setTime(payDate);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 2);
    	Date startDate =  DateUtil.getFirstDay(calendar.getTime());
    	Date endDate = DateUtil.getLastDay(payDate);
    	
    	ConditionOnGetLeftIntegralOfPlate condition = new ConditionOnGetLeftIntegralOfPlate();
    	List<BaseOnGetLeftIntegralOfPlate> resultList = new ArrayList<>();
    	if(plateId > 0){
    		condition.setPlateId(plateId);
    		condition.setStartDate(startDate);
    		condition.setEndDate(endDate);
    		QueryOnGetLeftIntegralOfPlate dao = new QueryOnGetLeftIntegralOfPlate();
    		BaseCollection<BaseOnGetLeftIntegralOfPlate> result = dao.executeQuery(null, condition);
    		if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result.getCollections())){
    			resultList = result.getCollections();
    		}
    	}
    	BaseCollection<BaseOnGetLeftIntegralOfPlate> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
    	return bc.toJSON(0,null);
    }
	
	
	/**
	 * 检索是否有部门是一级部门
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	private String onCheckIsHasParent(Map<String, Object> param) throws SQLException {
		int backResult = -1;
		String plateIds = BaseHelpUtils.getStringValue(param, "plateIds");
		if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
			String[] plateIdArr = plateIds.split(",");
			Object[] obj = new Object[plateIdArr.length];
			int i = 0;
			for(String id : plateIdArr){
				obj[i] = BaseHelpUtils.getIntValue(id);
				i++;
			}
			PlateRecord dao = new PlateRecord();
			dao.setConditionParentId("=",0);
			dao.addCondition(BasePlateRecord.CS_PLATE_ID,"in",obj);
			if(dao.countRows() > 0){
				backResult = 1;
			}else{
				backResult = 0;
			}
		}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(backResult,null);
	}
	
	
	/**
	 * 营销部门销售积分提取
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	@SuppressWarnings({"unchecked" })
	private String onSaveSaleIntegral(Map<String, Object> param) throws SQLException {
		ThreadConnection.beginTransaction();
		List<BaseOnLoadSaleIntegralFromPlate> saleIntegralRecords = GenericBase.__getList(param.get("saleIntegralRecords"),
		BaseOnLoadSaleIntegralFromPlate.newInstance());
		//获取年份,月份
		int year = BaseHelpUtils.getIntValue(param, "year");
		int month = BaseHelpUtils.getIntValue(param, "month");
		//获取备注
		String remark = BaseHelpUtils.getStringValue(param, "remark");
		//获取操作人
		int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
		//设置日期
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.YEAR,year);
		ca.set(Calendar.MONTH,month-1);
		Date recordDate = ca.getTime();
		SaleIntegralRecord dao = new SaleIntegralRecord();
		BaseSaleIntegralRecord bean = null;
		if(!BaseHelpUtils.isNullOrEmpty(saleIntegralRecords) && saleIntegralRecords.size() > 0){
			Date currentTime = new Date();
			int plateId = 14;
			for(BaseOnLoadSaleIntegralFromPlate e : saleIntegralRecords){
				bean = new BaseSaleIntegralRecord();
				bean.setBusinessName(e.getBusinessName());
				bean.setPlateId(plateId);//指定给营销中心
				bean.setYear(year);
				bean.setMonth(month);
				bean.setCurrentRevenue(e.getCurrentRevenue());
				bean.setPercent(e.getPercent());
				bean.setSaleIntegral(e.getSaleIntegral());
				bean.setRecordDate(recordDate);
				bean.setOperateEmployeeId(operateEmployeeId);
				bean.setOperateTime(currentTime);
				bean.setRemark(remark);
				dao.clear();
				dao.setDataFromBase(bean);
				dao.save();
				//插入部门账户
				int businessId = dao.getSaleIntegralRecordId();
				//积分借款入部门账户表
				onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_SALE_INTEGRAL, e.getSaleIntegral(),recordDate,remark,operateEmployeeId);
			}
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
	}
	
	
	/**
	 * 保存分配积分
	 * @param param
	 * @return
	 * @throws SQLException 
	 */
	private String onSavePlateIntegralDistribution(Map<String, Object> param) throws Exception {
		ThreadConnection.beginTransaction();
		PlateIntegralDistribution dao = new PlateIntegralDistribution();
		int fromPlateId = BaseHelpUtils.getIntValue(param.get("fromPlateId"));
		int toPlateId = BaseHelpUtils.getIntValue(param.get("toPlateId"));
		BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(param.get("sendIntegral"));
		Date currentDate = new Date();
		
		dao.setFromPlateId(fromPlateId);
		dao.setToPlateId(toPlateId);
		dao.setSendIntegral(sendIntegral);
		dao.setSendDate(currentDate);
		dao.setOperateEmployeeId(BaseHelpUtils.getIntValue(param.get("operateEmployeeId")));
		dao.setOperateTime(currentDate);
		dao.setRemark(BaseHelpUtils.getString(param.get("remark")));
		dao.save();
		//插入部门账户
		Integer businessId = dao.getPlateIntegralDistributionId();
		String remark = dao.getRemark();
		AccountManageProcess.onSavePlateAccount(fromPlateId, businessId, AccountManageProcess.PLATE_BT_SEND_PAY, sendIntegral, currentDate, remark, -1);
		AccountManageProcess.onSavePlateAccount(toPlateId, businessId, AccountManageProcess.PLATE_BT_SEND_ACHIEVE, sendIntegral, currentDate, remark, -1);
		//账户系统：借业务部门toPlateId
		AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, toPlateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_5, businessId, businessId, sendIntegral, true, currentDate, null, remark);
		//账户系统：贷业务部门fromPlateId
		AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, fromPlateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_5, businessId, businessId, sendIntegral, false, currentDate, null, remark);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
	}
    
	
    /**
     * 积分借款保存
     * @param param
     * @return
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
	public String onSaveIntegralAdvance(Map<String, Object> param) throws Exception{
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	//如果业务部门为空，则抛出异常
    	if(plateId == 0){
    		throw new SQLException("操作异常：业务部门不可为空");
    	}
    	PlateRecord prDao = new PlateRecord();
    	prDao.setConditionPlateId("=",plateId);
    	BasePlateRecord prBean = prDao.executeQueryOneRow();
    	if(BaseHelpUtils.isNullOrEmpty(prBean)) {
    		throw new SQLException("操作异常：加载业务部门信息失败");
    	}
		List<BaseOnLoadIntegralAdvanceOfAccount> resultList = GenericBase.__getList(param.get("plateAdvinceEmployee"),BaseOnLoadIntegralAdvanceOfAccount.newInstance());
    	if(BaseHelpUtils.isNullOrEmpty(resultList) || resultList.size() == 0){
    		throw new SQLException("操作异常：没有可借款的人员");
    	}
    	//操作人
    	int operator = BaseHelpUtils.getIntValue(param, "operator");
    	//获取业务部门名称
    	String plateName = BaseHelpUtils.getString(prBean.getPlateName());
    	Date recordDate = new Date(BaseHelpUtils.getLongValue(param.get("recordDate")));
    	PlateSalaryAdvanceRecord dao = new PlateSalaryAdvanceRecord();
    	BasePlateSalaryAdvanceRecord bean = null;
    	Employee eDao = new Employee();
    	String remark = String.format("来自%1$s于%2$s的积分借款",plateName,DateUtil.formatDateString(recordDate));
    	String plateRemark = "";
    	for(BaseOnLoadIntegralAdvanceOfAccount e : resultList){
    		//如果是离职人员，则借款日期自动设置为离职日期
        	Date advanceDate = recordDate;
    		bean = new BasePlateSalaryAdvanceRecord();
    		//获取回收的价值积分
    		BigDecimal achieveIntegral = e.getAchieveintegral()==null?BigDecimal.ZERO:e.getAchieveintegral();
    		if(achieveIntegral.compareTo(BigDecimal.ZERO) < 0){//只借款价值积分小于0的人员数据
    			//将该人员的负数的价值积分变成正数
    			achieveIntegral = achieveIntegral.abs();
    			int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    			eDao.clear();
    			eDao.setEmployeeId(employeeId);
    			if(!eDao.load()) {
    				continue;
    			}
    			//获取离职日期
    			Date resignationDate = eDao.getResignationDate();
    			if(!BaseHelpUtils.isNullOrEmpty(resignationDate)) {
    				//如果借款日期在离职日期之后，则借款日期即为离职日期
    				if(resignationDate.before(recordDate)) {
    					advanceDate = resignationDate;
    				}
    			}
    			plateRemark = String.format("该借款的填平日期为%1$s",DateUtil.formatDateString(advanceDate));
    			bean.setPlateId(plateId);
    			bean.setEmployeeId(employeeId);
    			bean.setEmployeeName(e.getEmployeeName());
    			bean.setEmployeeNo(e.getEmployeeNo());
    			bean.setSalaryReturn(achieveIntegral);
    			bean.setRecordDate(advanceDate);
    			dao.clear();
    			dao.setDataFromBase(bean);
    			dao.save();
    			int businessId = dao.getPlateSalaryAdvanceRecordId();
    			//积分借款插入个人账户表
    			onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_INTEGRAL_ADVANCE, achieveIntegral, advanceDate, remark, operator);
    			//积分借款入部门账户表
    			onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_INTEGRAL_ADVANCE, achieveIntegral, recordDate,plateRemark, -1);
    			//账户系统：借员工
    			AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_34, businessId, businessId, achieveIntegral, true, recordDate, operator, remark);
    			//账户系统：贷业务部门
    			AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_34, businessId, businessId, achieveIntegral, false, recordDate, operator, plateRemark);
    		}
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
    }
    
    /**
     * 积分回收保存
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onSaveIntegralReturn(Map<String, Object> param) throws Exception{
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	//如果业务部门为空，则抛出异常
    	if(plateId == 0){
    		throw new SQLException("业务部门不可为空");
    	}
    	//操作人																																																	```````````````````````								
    	int operator = BaseHelpUtils.getIntValue(param, "operator");
    	//回收日期默认为当前系统日期
    	Date recordDate = new Date();
    	EmployeeAchieveIntegralReturnRecord dao = new EmployeeAchieveIntegralReturnRecord();
    	BaseEmployeeAchieveIntegralReturnRecord bean = null;
    	@SuppressWarnings("unchecked")
		List<BaseOnLoadIntegralReturnOfAccount> resultList = GenericBase.__getList(param.get("integralReturnOfPlate"),BaseOnLoadIntegralReturnOfAccount.newInstance());
    	if(!BaseHelpUtils.isNullOrEmpty(resultList) && resultList.size() > 0){
    		for(BaseOnLoadIntegralReturnOfAccount e : resultList){
    			bean = new BaseEmployeeAchieveIntegralReturnRecord();
    			//获取回收的价值积分
    			BigDecimal achieveIntegral = e.getAchieveintegral()==null?BigDecimal.ZERO:e.getAchieveintegral();
    			if(achieveIntegral.compareTo(BigDecimal.ZERO) > 0){//只回收价值积分大于0的人员数据
    				int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
    				bean.setPlateId(plateId);
    				bean.setEmployeeId(employeeId);
    				bean.setEmployeeName(e.getEmployeeName());
    				bean.setEmployeeNo(e.getEmployeeNo());
    				bean.setAchieveIntegral(achieveIntegral);
    				bean.setRecordDate(recordDate);
    				bean.setCreateTime(new Date());
    				dao.clear();
    				dao.setDataFromBase(bean);
    				dao.save();
    				int businessId = dao.getEmployeeAchieveIntegralReturnRecordId();
					//积分回收入个人账户表
					onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_INTEGRAL_RECYCLE, achieveIntegral, recordDate, "", operator);
					//积分回收入部门账户表
					onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_INTEGRAL_RECYCLE, achieveIntegral, recordDate, "", operator);
					//账户系统：借部门账户
					AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_15, businessId, businessId, achieveIntegral, true, recordDate, operator, null);
					//账户系统：贷个人账户
					AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_15, businessId, businessId, achieveIntegral, false, recordDate, operator, null);
    			}
    		}
    	}else{
    		throw new SQLException("没有可回收的人员");
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,null);
    }
    
    /**
     * 加载部门实时余额积分
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onLoadLeftIntegralOFPlate(Map<String, Object> param) throws SQLException{
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	Map<Integer,BigDecimal> paramMap = getLeftIntegralOfPlate(plateId);
    	List<BaseOnGetLeftIntegralOfPlate> resultList = new ArrayList<>();
    	BaseOnGetLeftIntegralOfPlate bean = new BaseOnGetLeftIntegralOfPlate();
    	BigDecimal integral = BigDecimal.ZERO;
    	if(!BaseHelpUtils.isNullOrEmpty(paramMap)){
    		integral = paramMap.get(plateId)==null?BigDecimal.ZERO:paramMap.get(plateId);
    	}
    	bean.setPlateId(plateId);
    	bean.setIntegral(integral);
    	resultList.add(bean);
    	BaseCollection<BaseOnGetLeftIntegralOfPlate> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
    	return bc.toJSON(0,null);
    }
    
    /**
     * 加载员工实时余额积分和年度个人效益指数
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onLoadLeftIntegralAndBenefits(Map<String, Object> param) throws SQLException{
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	//获取员工实时余额
    	Map<Integer,BigDecimal> paramMap = getLeftIntegralOfEmployee(employeeId);
    	//获取员工年度个人效益指数
    	Map<Integer,BigDecimal> map = getBenefitsOfEmployee(employeeId, DateUtil.getYear());
    	//定义实时余额和个人效益指数
    	BigDecimal leftIntegral = BigDecimal.ZERO;
    	BigDecimal benefits = BigDecimal.ZERO;
    	List<BaseCustomEmployeeAccount> resultList = new ArrayList<>();
    	BaseCustomEmployeeAccount bean = new BaseCustomEmployeeAccount();
    	if(!BaseHelpUtils.isNullOrEmpty(paramMap)){
    		leftIntegral = paramMap.get(employeeId)==null?BigDecimal.ZERO:paramMap.get(employeeId);
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(map)){
    		benefits = map.get(employeeId)==null?BigDecimal.ZERO:map.get(employeeId);
    	}
    	bean.setEmployeeId(employeeId);
    	bean.setLeftIntegral(leftIntegral);
    	bean.setBenefits(benefits);
    	resultList.add(bean);
    	BaseCollection<BaseCustomEmployeeAccount> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
    	return bc.toJSON(0,null);
    }
    
    /**
     * 加载员工年度个人效益指数
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onLoadBenefitsOFEmployee(Map<String, Object> param) throws SQLException{
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	Map<Integer,BigDecimal> paramMap = getBenefitsOfEmployee(employeeId, DateUtil.getYear());
    	List<BaseOnGetLeftIntegralOfEmployee> resultList = new ArrayList<>();
    	BaseOnGetLeftIntegralOfEmployee bean = new BaseOnGetLeftIntegralOfEmployee();
    	BigDecimal integral = BigDecimal.ZERO;
    	if(!BaseHelpUtils.isNullOrEmpty(paramMap)){
    		integral = paramMap.get(employeeId)==null?BigDecimal.ZERO:paramMap.get(employeeId);
    	}
    	bean.setEmployeeId(employeeId);
    	bean.setIntegral(integral);
    	resultList.add(bean);
    	BaseCollection<BaseOnGetLeftIntegralOfEmployee> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
    	return bc.toJSON(0,null);
    }
    
    /**
     * 获取业务部门的实时余额积分
     * @param plateId
     * @return
     * @throws SQLException
     */
    public Map<Integer,BigDecimal> getLeftIntegralOfPlate(int plateId) throws SQLException{
    	Map<Integer,BigDecimal> paramMap = new HashMap<>();
    	ConditionOnGetLeftIntegralOfPlate condition = new ConditionOnGetLeftIntegralOfPlate();
    	if(plateId > 0)condition.setPlateId(plateId);
    	QueryOnGetLeftIntegralOfPlate dao = new QueryOnGetLeftIntegralOfPlate();
    	BaseCollection<BaseOnGetLeftIntegralOfPlate> result = dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result.getCollections())){
    		List<BaseOnGetLeftIntegralOfPlate> resultList = result.getCollections();
    		for(BaseOnGetLeftIntegralOfPlate bean : resultList){
    			paramMap.put(bean.getPlateId(),bean.getIntegral());
    		}
    	}
    	return paramMap;
    }
    
    /**
     * 获取员工的实时余额积分
     * @param employeeId
     * @return
     * @throws SQLException
     */
    public Map<Integer,BigDecimal> getLeftIntegralOfEmployee(int employeeId) throws SQLException{
    	Map<Integer,BigDecimal> paramMap = new HashMap<>();
    	ConditionOnGetLeftIntegralOfEmployee condition = new ConditionOnGetLeftIntegralOfEmployee();
    	if(employeeId > 0)condition.setEmployeeId(employeeId);
    	QueryOnGetLeftIntegralOfEmployee dao = new QueryOnGetLeftIntegralOfEmployee();
    	BaseCollection<BaseOnGetLeftIntegralOfEmployee> result = dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result.getCollections())){
    		List<BaseOnGetLeftIntegralOfEmployee> resultList = result.getCollections();
    		for(BaseOnGetLeftIntegralOfEmployee bean : resultList){
    			paramMap.put(bean.getEmployeeId(),bean.getIntegral());
    		}
    	}
    	return paramMap;
    }
    
    /**
     * 获取员工在本年度的个人效益指数
     * @param employeeId
     * @return
     * @throws SQLException
     */
    public Map<Integer,BigDecimal> getBenefitsOfEmployee(int employeeId, Integer year) throws SQLException{
    	Map<Integer,BigDecimal> paramMap = new HashMap<>();
    	ConditionOnGetBenefitsOfEmployee condition = new ConditionOnGetBenefitsOfEmployee();
    	if(employeeId > 0)condition.setEmployeeId(employeeId);
    	if(null == year) {
	    	Calendar calendar = Calendar.getInstance();
	    	year = calendar.get(Calendar.YEAR);
	    	if(calendar.get(Calendar.MONTH) == 0) {
	    		year--;
	    	}
    	}
    	condition.setYear(year);
    	QueryOnGetBenefitsOfEmployee dao = new QueryOnGetBenefitsOfEmployee();
    	BaseCollection<BaseOnGetBenefitsOfEmployee> result = dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(result.getCollections())){
    		List<BaseOnGetBenefitsOfEmployee> resultList = result.getCollections();
    		Map<Integer,BaseCustomEmployeeAccount> beanMap = new HashMap<>();
    		for(BaseOnGetBenefitsOfEmployee e : resultList){
    			if(null == e.getEmployeeId())
    				continue;
    			//获取职员ID
    			int empId = e.getEmployeeId();
    			//获取业务类型ID
    			if(null == e.getBusinessTypeId())
    				continue;
    			int businessTypeId = e.getBusinessTypeId();
    			BigDecimal integral = e.getIntegral()==null?BigDecimal.ZERO:e.getIntegral();
    			BaseCustomEmployeeAccount bean = beanMap.get(empId);
    			//定义效益指数值(效益指数的收入/效益指数的支出)
				BigDecimal benefits = BigDecimal.ZERO;
    			if(BaseHelpUtils.isNullOrEmpty(bean)){//说明是空的
    				bean = new BaseCustomEmployeeAccount();
    				bean.setAchieveIntegral(BigDecimal.ZERO);//设置收入项的积分
    				bean.setLeftIntegral(BigDecimal.ZERO);//设置支出想项的积分
    				bean.setBenefits(BigDecimal.ZERO);//设置个人效益指数
    				beanMap.put(empId,bean);
    			}
    			//从新计算收入项、支出项和个人效益指数
    			if(EMP_BT_SURE_INTEGRAL == businessTypeId || EMP_BT_PROJECT_SUBSIDY == businessTypeId){
    				bean.setAchieveIntegral(bean.getAchieveIntegral().add(integral));
    			}else if(EMP_BT_PROJECT_COST == businessTypeId){
    				bean.setAchieveIntegral(bean.getAchieveIntegral().subtract(integral));
    			}else if(EMP_BT_EMPLOYEE_COST == businessTypeId){
    				bean.setLeftIntegral(integral);
    			}else{
    				continue;
    			}
    			//定义效益指数的收入(确认积分+项目补贴-项目成本)
    			BigDecimal benefitsAchieve = bean.getAchieveIntegral();
    			//定义效益指数的支出(人工成本)
    			BigDecimal benefitsPay = bean.getLeftIntegral();
    			if(benefitsPay.compareTo(BigDecimal.ZERO) != 0){
    				benefits = benefitsAchieve.divide(benefitsPay,2,BigDecimal.ROUND_DOWN);
    			}
    			paramMap.put(empId,benefits);
    		}
    	}
    	return paramMap;
    }
    
    
    /**
     * 部门账户公司还款数据加载
     * @param param
     * @return
     */
	public String onCompanyRepaymentData(Map<String, Object> param) throws Exception{
    	BaseCollection<BaseCompanyIntegralRecord> bc = new BaseCollection<>();
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	if(plateId > 0){
    		CompanyIntegralRecord dao = new CompanyIntegralRecord();
        	dao.setConditionPlateId("=",plateId);
        	List<BaseCompanyIntegralRecord> list = dao.conditionalLoad();
        	BigDecimal plateOfArrears = BigDecimal.ZERO;
        	BigDecimal integralOfLoan = BigDecimal.ZERO;
        	BigDecimal integralOfRepayment = BigDecimal.ZERO;
        	if(!list.isEmpty()){
        		for(BaseCompanyIntegralRecord e : list){
        			int flag = BaseHelpUtils.getIntValue(e.getFlag());
        			BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getIntegral());
        			if(flag == 1){//说明是借款
        				integralOfLoan = integralOfLoan.add(integral);
        			}else{//说明是还款
        				integralOfRepayment = integralOfRepayment.subtract(integral);
        			}
        		}
        		plateOfArrears = integralOfLoan.add(integralOfRepayment);
        	}
        	BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
        	bean.setPlateId(plateId);
        	bean.setIntegral(plateOfArrears);
        	List<BaseCompanyIntegralRecord> resultList = new ArrayList<>();
        	resultList.add(bean);
        	bc.setCollections(resultList);
        	return bc.toJSON(0,"");
	    	}
    	
        return bc.toJSON(-1,"参数不全");
    }
    
    /**
     * 部门账户积分收款人员数据加载
     * @param param
     * @return
     */
    public String onPlateAccountIntegralReturnEmpData(Map<String, Object> param) throws Exception{
    	BaseCollection<BaseIntegralReturnOfPlate> bc = new BaseCollection<>();
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	if(plateId > 0){
	    	ConditionIntegralReturnOfPlate condition = new ConditionIntegralReturnOfPlate();
	    	condition.setPlateId(plateId);
	    	QueryIntegralReturnOfPlate query = new QueryIntegralReturnOfPlate();
	    	BaseCollection<BaseIntegralReturnOfPlate> result = query.executeQuery(null, condition);
	    	if(null != result){
	    		List<BaseIntegralReturnOfPlate> list = result.getCollections();
	    		if(null != list && !list.isEmpty()){
	    			List<BaseIntegralReturnOfPlate> tempList = new ArrayList<>();
	    			for(BaseIntegralReturnOfPlate obj : list){
	    				if(obj.getIntegralreturnofplate().compareTo(BigDecimal.ZERO)>0){
	    					tempList.add(obj);
	    				}
	    			}
	    			result.setCollections(tempList);
	    		}
	    	}
	    	return result.toJSON();
    	}
        return bc.toJSON(-1,"参数不全");
    }
    
    /**
     * 部门账户加载月统计数据
     * @param param
     * @return
     * @throws ParseException
     * @throws SQLException
     */
    public String onLoadMonthStatisticOfPlateAccount(Map<String, Object> param) throws ParseException, SQLException{
    	//获取部门id
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	//获取业务类型
    	int businessTypeId = BaseHelpUtils.getIntValue(param.get("businessTypeId"));
    	//获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        ConditionOnLoadMonthStatisticOfPlateAccount condition = new ConditionOnLoadMonthStatisticOfPlateAccount();
        if(plateId > 0)condition.setPlateId(plateId);
        if(businessTypeId > 0)condition.setBusinessTypeId(businessTypeId);
        if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
        	Date startDate = new Date(Long.valueOf(startDateStr));
            //设置开始日期的第一天的日期
            startDate = DateUtil.getFirstDay(startDate);
        	condition.setStartDate(startDate);
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
        	Date endDate = new Date(Long.valueOf(endDateStr));
            //设置结束日期的最后一天的日期
            endDate = DateUtil.getLastDay(endDate);
        	condition.setEndDate(endDate);
        }
        QueryOnLoadMonthStatisticOfPlateAccount dao = new QueryOnLoadMonthStatisticOfPlateAccount();
    	BaseCollection<BaseOnLoadMonthStatisticOfPlateAccount> result = dao.executeQuery(null, condition) ;
        return result.toJSON(0,"");
    }
    
    
    /**
     * 加载个人账户数据集（处理后的）
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onLoadEmployeeAccountCustomData(Map<String, Object> param) throws SQLException, ParseException{
		BaseCollection<BaseOnLoadEmployeeAccountData> result = onCommonLoadData(param) ;
		List<BaseCustomEmployeeAccount> resultList = getEmployeeAccountCustomData(result);
		BaseCollection<BaseCustomEmployeeAccount> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
        return bc.toJSON(0,"");
    }
    
    public List<BaseCustomEmployeeAccount> getEmployeeAccountCustomData(BaseCollection<BaseOnLoadEmployeeAccountData> result) throws SQLException{
    	List<BaseCustomEmployeeAccount> resultList = new ArrayList<>();
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
			//定义map来存放转换后的数据集
        	Map<Integer,BaseCustomEmployeeAccount> map = new HashMap<>();
        	//获取员工实时积分余额
        	Map<Integer,BigDecimal> paramMap = getLeftIntegralOfEmployee(0);
        	//获取员工的本年度的个人效益指数
        	Map<Integer,BigDecimal> bifMap = getBenefitsOfEmployee(0, DateUtil.getYear());
        	for(BaseOnLoadEmployeeAccountData e : result.getCollections()){
        		//获取人员ID
        		int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
        		//获取业务类型ID
        		int businessTypeId = BaseHelpUtils.getIntValue(e.getBusinessTypeId());
        		//获取金额
        		BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getIntegral());
        		//根据employeeId去map中检索，看是否有数据，有则对应更新，没有则插入
        		BaseCustomEmployeeAccount record = map.get(employeeId);
        		if(BaseHelpUtils.isNullOrEmpty(record)){//为空，则赋予职员编号，名称等值
        			record = new BaseCustomEmployeeAccount();
        			record.setEmployeeId(employeeId);
        			record.setEmployeeNo(e.getEmployeeNo());
        			record.setEmployeeName(e.getEmployeeName());
        			record.setPlateId(e.getPlateId());
        			record.setStatus(e.getStatus());
        			record.setGradeId(e.getGradeId());
        		}
        		if(businessTypeId > 0){
        			switch (businessTypeId) {
        			case EMP_BT_SURE_INTEGRAL:
        				BigDecimal sureIntegral = record.getSureIntegral()==null?BigDecimal.ZERO:record.getSureIntegral();
        				record.setSureIntegral(sureIntegral.add(integral));
        				break;
        			case EMP_BT_BONUS_SUBSIDY:
        				BigDecimal managerProjectIntegral = record.getManagerProjectIntegral()==null?BigDecimal.ZERO:record.getManagerProjectIntegral();
        				record.setManagerProjectIntegral(managerProjectIntegral.add(integral));
        				break;
        			case EMP_BT_INTEGRAL_ADVANCE:
        				BigDecimal salaryAdvance = record.getSalaryAdvance()==null?BigDecimal.ZERO:record.getSalaryAdvance();
        				record.setSalaryAdvance(salaryAdvance.add(integral));
        				break;
        			case EMP_BT_PROJECT_SUBSIDY:
        				BigDecimal projectAdvance = record.getProjectAdvance()==null?BigDecimal.ZERO:record.getProjectAdvance();
        				record.setProjectAdvance(projectAdvance.add(integral));
        				break;
        			case EMP_BT_SALAEY_REFUND:
        				BigDecimal salaryReturn = record.getSalaryReturn()==null?BigDecimal.ZERO:record.getSalaryReturn();
        				record.setSalaryReturn(salaryReturn.add(integral));
        				break;
        			case EMP_BT_EMPLOYEE_COST:
        				BigDecimal salary = record.getSalary()==null?BigDecimal.ZERO:record.getSalary();
        				record.setSalary(salary.add(integral));
        				break;
        			case EMP_BT_PROJECT_COST:
        				BigDecimal projectCost = record.getProjectCost()==null?BigDecimal.ZERO:record.getProjectCost();
        				record.setProjectCost(projectCost.add(integral));
        				break;
        			case EMP_BT_BONUS_SEND:
        				BigDecimal bonusPayment = record.getBonusPayment()==null?BigDecimal.ZERO:record.getBonusPayment();
        				record.setBonusPayment(bonusPayment.add(integral));
        				break;
        			case EMP_BT_INTEGRAL_RECYCLE:
        				BigDecimal integralReturn = record.getIntegralReturn()==null?BigDecimal.ZERO:record.getIntegralReturn();
        				record.setIntegralReturn(integralReturn.add(integral));
        				break;
        			case EMP_BT_VIOLATION_CHARGES:
        				BigDecimal violationCharges = record.getViolationCharges()==null?BigDecimal.ZERO:record.getViolationCharges();
        				record.setViolationCharges(violationCharges.add(integral));
        				break;
        			case EMP_BT_PERFORMANCE_BONUS:
        				BigDecimal performanceBonus = record.getPerformanceBonus()==null?BigDecimal.ZERO:record.getPerformanceBonus();
        				record.setPerformanceBonus(performanceBonus.add(integral));
        				break;
        			case EMP_BT_ATTENDANCE_DEDUCT:
        				BigDecimal attendanceDeduct = record.getAttendanceDeduct()==null?BigDecimal.ZERO:record.getAttendanceDeduct();
        				record.setAttendanceDeduct(attendanceDeduct.add(integral));
        				break;
        			case EMP_BT_PM_PERFORMANCE_AWARD:
        				BigDecimal pmPerformanceAward = record.getPmPerformanceAward()==null?BigDecimal.ZERO:record.getPmPerformanceAward();
        				record.setPmPerformanceAward(pmPerformanceAward.add(integral));
        				break;
        			case EMP_BT_PM_PERFORMANCE_DEDUCT:
        				BigDecimal pmPerformanceDeduct = record.getPmPerformanceDeduct()==null?BigDecimal.ZERO:record.getPmPerformanceDeduct();
        				record.setPmPerformanceDeduct(pmPerformanceDeduct.add(integral));
        				break;
        			case EMP_BT_PROJECT_PERFORMANCE:
        				BigDecimal projectPerformance = record.getProjectPerformance()==null?BigDecimal.ZERO:record.getProjectPerformance();
        				record.setProjectPerformance(projectPerformance.add(integral));
        				break;
        			case EMP_BT_CONTRACT_CHANGE:
        				BigDecimal contractChange = record.getContractChange()==null?BigDecimal.ZERO:record.getContractChange();
        				record.setContractChange(contractChange.add(integral));
        				break;
        			case EMP_BT_PLATE_CHANGE_ACHIEVE:
        				BigDecimal plateChangeAchieve = record.getPlateChangeAchieve()==null?BigDecimal.ZERO:record.getPlateChangeAchieve();
        				record.setPlateChangeAchieve(plateChangeAchieve.add(integral));
        				break;
        			case EMP_BT_PLATE_CHANGE_PAY:
        				BigDecimal plateChangePay = record.getPlateChangePay()==null?BigDecimal.ZERO:record.getPlateChangePay();
        				record.setPlateChangePay(plateChangePay.add(integral));
        				break;
        			case EMP_BT_PROJECT_PERFORMANCE_PAY:
        				BigDecimal projectPerformancePay = record.getProjectPerformancePay()==null?BigDecimal.ZERO:record.getProjectPerformancePay();
        				record.setProjectPerformancePay(projectPerformancePay.add(integral));
        				break;
        			case EMP_BT_CONTRACT_DISTRIBUTION_INCOME:
        				BigDecimal contractDistributionIncome = record.getContractDistributionIncome()==null?BigDecimal.ZERO:record.getContractDistributionIncome();
        				record.setContractDistributionIncome(contractDistributionIncome.add(integral));
        				break;
        			case EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
        				BigDecimal contractDistributionExpenditure = record.getContractDistributionExpenditure()==null?BigDecimal.ZERO:record.getContractDistributionExpenditure();
        				record.setContractDistributionExpenditure(contractDistributionExpenditure.add(integral));
        				break;
					case EMP_BT_DEP_DEPLOY:
						BigDecimal depDeployIntegral = BaseHelpUtils.getBigDecimalValue(record.getDepDeploy());
						record.setDepDeploy(depDeployIntegral.add(integral));
						break;
					case EMP_BT_OUTPUT_ACCOUNT:
						BigDecimal outputAccount = BaseHelpUtils.getBigDecimalValue(record.getOutputAccount());
						record.setOutputAccount(outputAccount.add(integral));
						break;
        			default:
        				break;
        			}
        		}
        		map.put(employeeId, record);
        	}
        	
        	for(Integer empId : map.keySet()){
        		BaseCustomEmployeeAccount e = map.get(empId);
        		if(!BaseHelpUtils.isNullOrEmpty(paramMap))e.setLeftIntegral(paramMap.get(empId)==null?BigDecimal.ZERO:paramMap.get(empId));
        		BigDecimal sureIntegral = e.getSureIntegral()==null?BigDecimal.ZERO:e.getSureIntegral();
        		e.setSureIntegral(sureIntegral);
        		BigDecimal managerProjectIntegral = e.getManagerProjectIntegral()==null?BigDecimal.ZERO:e.getManagerProjectIntegral();
        		e.setManagerProjectIntegral(managerProjectIntegral);
        		BigDecimal salaryAdvance = e.getSalaryAdvance()==null?BigDecimal.ZERO:e.getSalaryAdvance();
        		e.setSalaryAdvance(salaryAdvance);
        		BigDecimal projectAdvance = e.getProjectAdvance()==null?BigDecimal.ZERO:e.getProjectAdvance();
        		e.setProjectAdvance(projectAdvance);
        		BigDecimal salaryReturn = e.getSalaryReturn()==null?BigDecimal.ZERO:e.getSalaryReturn();
        		e.setSalaryReturn(salaryReturn);
        		BigDecimal salary = e.getSalary()==null?BigDecimal.ZERO:e.getSalary();
        		e.setSalary(salary);
        		BigDecimal projectCost = e.getProjectCost()==null?BigDecimal.ZERO:e.getProjectCost();
        		e.setProjectCost(projectCost);
        		BigDecimal bonusPayment = e.getBonusPayment()==null?BigDecimal.ZERO:e.getBonusPayment();
        		e.setBonusPayment(bonusPayment);
        		BigDecimal integralReturn = e.getIntegralReturn()==null?BigDecimal.ZERO:e.getIntegralReturn();
        		e.setIntegralReturn(integralReturn);
        		BigDecimal violationCharges = e.getViolationCharges()==null?BigDecimal.ZERO:e.getViolationCharges();
        		e.setViolationCharges(violationCharges);
        		BigDecimal performanceBonus = e.getPerformanceBonus()==null?BigDecimal.ZERO:e.getPerformanceBonus();
        		e.setPerformanceBonus(performanceBonus);
        		BigDecimal attendanceDeduct = e.getAttendanceDeduct()==null?BigDecimal.ZERO:e.getAttendanceDeduct();
        		e.setAttendanceDeduct(attendanceDeduct);
        		BigDecimal pmPerformanceAward = e.getPmPerformanceAward()==null?BigDecimal.ZERO:e.getPmPerformanceAward();
        		e.setPmPerformanceAward(pmPerformanceAward);
        		BigDecimal pmPerformanceDeduct = e.getPmPerformanceDeduct()==null?BigDecimal.ZERO:e.getPmPerformanceDeduct();
        		e.setPmPerformanceDeduct(pmPerformanceDeduct);
        		BigDecimal projectPerformance = e.getProjectPerformance()==null?BigDecimal.ZERO:e.getProjectPerformance();
        		e.setProjectPerformance(projectPerformance);
        		BigDecimal contractChange = e.getContractChange()==null?BigDecimal.ZERO:e.getContractChange();
        		e.setContractChange(contractChange);
        		BigDecimal plateChangeAchieve = e.getPlateChangeAchieve()==null?BigDecimal.ZERO:e.getPlateChangeAchieve();
        		e.setPlateChangeAchieve(plateChangeAchieve);
        		BigDecimal plateChangePay = e.getPlateChangePay()==null?BigDecimal.ZERO:e.getPlateChangePay();
        		e.setPlateChangePay(plateChangePay);
        		BigDecimal projectPerformancePay = e.getProjectPerformancePay()==null?BigDecimal.ZERO:e.getProjectPerformancePay();
        		e.setProjectPerformancePay(projectPerformancePay);
        		BigDecimal contractDistributionIncome = e.getContractDistributionIncome()==null?BigDecimal.ZERO:e.getContractDistributionIncome();
        		e.setContractDistributionIncome(contractDistributionIncome);
        		BigDecimal contractDistributionExpenditure = e.getContractDistributionExpenditure()==null?BigDecimal.ZERO:e.getContractDistributionExpenditure();
        		//获取部门调配积分
				BigDecimal depDeploy = BaseHelpUtils.getBigDecimalValue(e.getDepDeploy());
				e.setDepDeploy(depDeploy);
				//获取产值结算积分
				BigDecimal outputAccount = BaseHelpUtils.getBigDecimalValue(e.getOutputAccount());
				e.setOutputAccount(outputAccount);
        		//设置价值积分，即积分余额
        		BigDecimal achieveIntegral = sureIntegral.add(managerProjectIntegral).add(salaryAdvance).add(projectAdvance).add(performanceBonus)
				.add(pmPerformanceAward).add(projectPerformance).add(plateChangeAchieve).add(contractDistributionIncome)
				.subtract(salaryReturn).subtract(salary).subtract(projectCost).subtract(contractChange).subtract(plateChangePay).subtract(projectPerformancePay)
				.subtract(bonusPayment).subtract(integralReturn).subtract(violationCharges).subtract(attendanceDeduct).subtract(pmPerformanceDeduct)
				.subtract(contractDistributionExpenditure).add(depDeploy).subtract(outputAccount);
        		e.setAchieveIntegral(achieveIntegral);
        		
    			//定义效益指数的收入(确认积分+项目补贴-项目成本)
    			BigDecimal benefitsAchieve = sureIntegral.add(projectAdvance).subtract(projectCost);
    			//定义效益指数的支出(人工成本)
    			BigDecimal benefitsPay = salary;
    			//计算个人效益指数(效益指数的收入/效益指数的支出)
    			BigDecimal benefits = BigDecimal.ZERO;
    			if(benefitsPay.compareTo(BigDecimal.ZERO) != 0){
    				benefits = benefitsAchieve.divide(benefitsPay,2,BigDecimal.ROUND_DOWN);
    			}
				e.setBenefits(benefits);
				BigDecimal benefitsYear = BaseHelpUtils.getBigDecimalValue(bifMap.get(empId));
				e.setBenefitsYear(benefitsYear);
				resultList.add(e);
        	}
    	}
    	return resultList;
    }
    
    /**
     * 导出人员账户数据集
     * @param param
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws SQLException 
     * @throws ParseException 
     */
    public void onPlateAccountExportData(Map<String, Object> param, File downFile) throws FileNotFoundException, UnsupportedEncodingException, ParseException, SQLException{
    	List<BaseCustomPlateAccount> resultList = onLoadPlateAccountDataCommon(param);
		if(!resultList.isEmpty() && resultList.size() > 0){
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseCustomPlateAccount.ALL_CAPTIONS);
				for(BaseCustomPlateAccount b : resultList){
					ps.println(b.toCSVString());
				}
			}
		}
    }
    
    /**
     * 导出人员账户数据集
     * @param param
     * @throws UnsupportedEncodingException 
     * @throws FileNotFoundException 
     * @throws SQLException 
     * @throws ParseException 
     */
    public void onEmployeeAccountExportData(Map<String, Object> param, File downFile) throws FileNotFoundException, UnsupportedEncodingException, ParseException, SQLException{
		BaseCollection<BaseOnLoadEmployeeAccountData> result = onCommonLoadData(param);
		List<BaseCustomEmployeeAccount> resultList = getEmployeeAccountCustomData(result);
		if(!resultList.isEmpty() && resultList.size() > 0){
			try(PrintStream ps = new PrintStream(downFile, "GBK")){
				ps.println(BaseCustomEmployeeAccount.ALL_CAPTIONS_CUSTOM);
				for(BaseCustomEmployeeAccount b : resultList){
					ps.println(b.toCSVString());
				}
			}
		}
    }
    
    /**
     * 加载每月统计数据集
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onLoadMonthReportData(Map<String, Object> param) throws SQLException, ParseException{
    	//获取部门id
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	//获取人员id
    	int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
    	//获取业务类型
    	int businessTypeId = BaseHelpUtils.getIntValue(param.get("businessTypeId"));
    	//获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        ConditionOnLoadMonthReportData condition = new ConditionOnLoadMonthReportData();
        if(plateId > 0)condition.setPlateId(plateId);
        if(employeeId > 0)condition.setEmployeeId(employeeId);
        if(businessTypeId > 0)condition.setBusinessTypeId(businessTypeId);
        if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
        	Date startDate = new Date(Long.valueOf(startDateStr));
            //设置开始日期的第一天的日期
            startDate = DateUtil.getFirstDay(startDate);
        	condition.setStartDate(startDate);
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
        	Date endDate = new Date(Long.valueOf(endDateStr));
            //设置结束日期的最后一天的日期
            endDate = DateUtil.getLastDay(endDate);
        	condition.setEndDate(endDate);
        }
        QueryOnLoadMonthReportData dao = new QueryOnLoadMonthReportData();
		BaseCollection<BaseOnLoadMonthReportData> result = dao.executeQuery(null,condition) ;
        return result.toJSON(0, "");
    }
    
    /**
     * 加载个人账户数据集
     * @param param
     * @return
     * @throws ParseException
     * @throws SQLException
     */
    public BaseCollection<BaseOnLoadEmployeeAccountData> onCommonLoadData(Map<String, Object> param) throws ParseException, SQLException{
    	//获取部门id
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	//获取人员id
    	int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
    	//获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        //获取职员姓名
        String employeeName = BaseHelpUtils.getStringValue(param,"employeeName");
        //获取职员编号
        String employeeNo = BaseHelpUtils.getStringValue(param, "employeeNo");
        //获取职员状态
        int status = BaseHelpUtils.getIntValue(param, "status");
        ConditionOnLoadEmployeeAccountData condition = new ConditionOnLoadEmployeeAccountData();
        if(plateId > 0)condition.setPlateId(plateId);
        if(employeeId > 0)condition.setEmployeeId(employeeId);
        if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
        	Date startDate = new Date(Long.valueOf(startDateStr));
        	condition.setStartDate(startDate);
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
        	Date endDate = new Date(Long.valueOf(endDateStr));
        	condition.setEndDate(endDate);
        }
        if(status >= 0){
        	condition.setStatus(status);
        }
        List<Map<String, Object>> ll = (List<Map<String, Object>>) param.get("keyValues");
        if (ll != null) {
        	KeyValuePair[] __keyValues = new KeyValuePair[ll.size()];
        	int count = 0;
        	for (Map<String, Object> value : ll) {
        		KeyValuePair kvp = new KeyValuePair();
        		kvp.setDataFromMap(value);
        		__keyValues[count++] = kvp;
        	}
        	condition.setKeyValues(__keyValues);
        }
        if(!BaseHelpUtils.isNullOrEmpty(employeeName))condition.setEmployeeName(employeeName);
        if(!BaseHelpUtils.isNullOrEmpty(employeeNo))condition.setEmployeeNo(employeeNo);
        QueryOnLoadEmployeeAccountData dao = new QueryOnLoadEmployeeAccountData();
		BaseCollection<BaseOnLoadEmployeeAccountData> result = dao.executeQuery(condition.getKeyValues(), condition) ;
		return result;
    }
    
    /**
     * 加载年度个人效益指数
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onLoadBenefitsData(Map<String, Object> param) throws SQLException, ParseException{
    	//获取人员id
    	int employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
    	//获取年份
    	int year = BaseHelpUtils.getIntValue(param, "year");
        ConditionOnLoadBenefitsData condition = new ConditionOnLoadBenefitsData();
        if(employeeId > 0)condition.setEmployeeId(employeeId);
        if(year > 0)condition.setYear(year);
        QueryOnLoadBenefitsData dao = new QueryOnLoadBenefitsData();
		BaseCollection<BaseOnLoadBenefitsData> result = dao.executeQuery(null,condition) ;
        return result.toJSON(0, "");
    }
    
    
    /**
     * 加载个人账户积分数据集
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onLoadEmployeeAccountData(Map<String, Object> param) throws SQLException, ParseException{
		BaseCollection<BaseOnLoadEmployeeAccountData> result = onCommonLoadData(param) ;
        return result.toJSON(0, "");
    }
    
    /**
     * 业务部门提取积分到公司账户（还没做实时数据处理）
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onSavePlateGiveIntegralToCompany(String creteria) throws Exception{
    	BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
    	bean.setDataFromJSON(creteria);
    	//toPlateId为0的时候，才是提取积分到公司账户
    	if(bean.getToPlateId().equals(0)){
    		ThreadConnection.beginTransaction();
	    	bean.setOperateTime(new Date());
	    	bean.setSendDate(new Date());
	    	PlateIntegralAchieve dao = new PlateIntegralAchieve();
	    	dao.setDataFromBase(bean);
	    	dao.save();
	    	//获取发放积分
	    	BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(dao.getSendIntegral());
	    	//获取提取积分的事业部ID
	    	Integer plateId = BaseHelpUtils.getIntValue(dao.getFromPlateId());
	    	int businessId = dao.getPlateIntegralAchieveId();
	    	//公司费用插入部门账户表
	    	AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_COMPANY_FEE, sendIntegral,dao.getSendDate(), dao.getRemark(), dao.getOperateEmployeeId());
	    	//如果存在记录，则修改业务部门某个月份的价值积分和公司费用，否则，新建一条记录
//	    	updatePlateReportRecord(dao.getSendDate(), plateId, sendIntegral);
			ThreadConnection.commit();
	        return dao.generateBase().toJSON();
    	}else{
    		BaseCollection<GenericBase> bc = new BaseCollection<>();
    		return bc.toJSON(-1, "本次提取公司费用的结果并不是提取积分到公司账户");
    	}
    }
    
    /**
     * 公司还款插入数据
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onCompanyRepayment(String creteria) throws Exception{
    	BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
    	bean.setDataFromJSON(creteria);
		ThreadConnection.beginTransaction();
    	bean.setOperateTime(new Date());
    	bean.setRecordDate(new Date());
    	CompanyIntegralRecord dao = new CompanyIntegralRecord();
    	dao.setDataFromBase(bean);
    	dao.save();
    	//获取还款积分
    	BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(dao.getIntegral());
    	//获取还款部门id
    	Integer plateId = BaseHelpUtils.getIntValue(dao.getPlateId());
    	int businessId = dao.getCompanyIntegralRecordId();
    	//还款记录插入部门账户表
    	AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_COMPANY_REFUND, sendIntegral,dao.getRecordDate(), dao.getRemark(), dao.getOperateEmployeeId());
		ThreadConnection.commit();
        return dao.generateBase().toJSON();
    }
    
    /**
     * 公司借款款插入数据
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onCompanyLoan(String creteria) throws Exception{
    	BaseCompanyIntegralRecord bean = new BaseCompanyIntegralRecord();
    	bean.setDataFromJSON(creteria);
		ThreadConnection.beginTransaction();
    	bean.setOperateTime(new Date());
    	bean.setRecordDate(new Date());
    	CompanyIntegralRecord dao = new CompanyIntegralRecord();
    	dao.setDataFromBase(bean);
    	dao.save();
    	//获取借款积分
    	BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(dao.getIntegral());
    	//获取借款部门的id
    	Integer plateId = BaseHelpUtils.getIntValue(dao.getPlateId());
    	int businessId = dao.getCompanyIntegralRecordId();
    	//借款记录插入部门账户表
    	AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_COMPANY_ADVANCE, sendIntegral,dao.getRecordDate(), dao.getRemark(), dao.getOperateEmployeeId());
		ThreadConnection.commit();
        return dao.generateBase().toJSON();
    }
    
    
    
    //如果存在记录，则修改业务部门某个月份的价值积分和公司费用，否则，新建一条记录
	public void updatePlateReportRecord(Date recordDate, Integer plateId, BigDecimal integral) throws Exception {
		if (null != recordDate && null != plateId && null != integral) {
			PlateReportRecord recordDao = new PlateReportRecord();
			recordDao.setConditionPlateId("=", plateId);
			recordDao.setConditionRecordDate("=", recordDate);
			BasePlateReportRecord record = recordDao.executeQueryOneRow();
			if (null != record) {
				record.setCompanyFee(null == record.getCompanyFee() ? integral : record.getCompanyFee().add(integral));
				record.setAchieveIntegral(record.getAchieveIntegral().subtract(integral));
				recordDao.setDataFromBase(record);
				recordDao.update();
			} else {
				recordDao.clear();
				recordDao.setRecordDate(recordDate);
				recordDao.setPlateId(plateId);
				recordDao.setCompanyFee(integral);
				recordDao.setAchieveIntegral(BigDecimal.ZERO.subtract(integral));
				recordDao.save();
			}
		} else {
			throw new Exception("参数不完整");
		}
	}
    
    /**
     * 加载部门账户信息(查看单个部门信息)
     * @param param
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    public String onLoadPlateIntegralData(Map<String, Object> param) throws SQLException, ParseException{
    	//获取部门id
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	//获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        ConditiononLoadAccountInfoOfPlateAccount condition = new ConditiononLoadAccountInfoOfPlateAccount();
        if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
        	Date startDate = new Date(Long.valueOf(startDateStr));
            //设置开始日期的第一天的日期
            startDate = DateUtil.getFirstDay(startDate);
        	condition.setStartDate(startDate);
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
        	Date endDate = new Date(Long.valueOf(endDateStr));
            //设置结束日期的最后一天的日期
            endDate = DateUtil.getLastDay(endDate);
        	condition.setEndDate(endDate);
        }
        if(plateId>0)condition.setPlateId(plateId);
        QueryonLoadAccountInfoOfPlateAccount dao = new QueryonLoadAccountInfoOfPlateAccount();
		BaseCollection<BaseonLoadAccountInfoOfPlateAccount> result = dao.executeQuery(null,condition) ;
        return result.toJSON(0, "");
    }
    
    /**
     * 加载部门账户信息(查看所有部门信息)
     * @return
     * @throws SQLException 
     * @throws ParseException 
     */
    public String onLoadPlateAccountData(Map<String, Object> param) throws SQLException, ParseException{
    	List<BaseCustomPlateAccount> resultList = onLoadPlateAccountDataCommon(param);
		BaseCollection<BaseCustomPlateAccount> result = new BaseCollection<>();
		result.setCollections(resultList);
        return result.toJSON(0, "");
    }
    
    /**
     * 加载部门账户处理后的数据封装
     * @param param
     * @return
     * @throws ParseException
     * @throws SQLException
     */
    public List<BaseCustomPlateAccount> onLoadPlateAccountDataCommon(Map<String, Object> param) throws ParseException, SQLException{
    	//获取查看权限类型:1:查看所有部门权限;2:查看自己管理部门的权限
    	int checkType = BaseHelpUtils.getIntValue(param, "checkType");
    	//获取父级ID
    	Integer parentId = null;
    	if(param.containsKey("parentId")) {
    		parentId = BaseHelpUtils.getIntValue(param,"parentId");
    	}
    	//获取业务部门
    	int plateIdValue = BaseHelpUtils.getIntValue(param, "plateId");
    	//获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        ConditiononLoadAccountInfoOfPlateAccount condition = new ConditiononLoadAccountInfoOfPlateAccount();
        if(null != parentId) {
        	condition.setParentId(parentId);
        }
        if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
        	Date startDate = new Date(Long.valueOf(startDateStr));
            //设置开始日期的第一天的日期
            startDate = DateUtil.getFirstDay(startDate);
        	condition.setStartDate(startDate);
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
        	Date endDate = new Date(Long.valueOf(endDateStr));
            //设置结束日期的最后一天的日期
            endDate = DateUtil.getLastDay(endDate);
        	condition.setEndDate(endDate);
        }
        if(plateIdValue>0)condition.setPlateId(plateIdValue);
        QueryonLoadAccountInfoOfPlateAccount dao = new QueryonLoadAccountInfoOfPlateAccount();
    	List<BaseonLoadAccountInfoOfPlateAccount> list = dao.executeQuery(null, condition).getCollections();
    	List<BaseCustomPlateAccount> resultList = new ArrayList<>();
    	BaseCustomPlateAccount bean = null;
    	if(!list.isEmpty() && list.size() > 0){
    		//如果只能查看自己管理部门的权限的话，获取自己管理部门的数据集
    		//定义map来封装自己管理部门的数据集
    		Map<Integer,Integer> plateMap = new HashMap<>();
    		if(checkType == 2){//说明只查看自己管理部门的权限
    			String plateIds = BaseHelpUtils.getStringValue(param, "plateIds");
    			if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
    				String[] plateIdArr = plateIds.split(",");
    				for(String id : plateIdArr){
    					int idd = BaseHelpUtils.getIntValue(id);
    					plateMap.put(idd, idd);
    				}
    			}
    		}
        	//获取业务部门的实时余额积分
        	Map<Integer,BigDecimal> paramMap = getLeftIntegralOfPlate(0);
        	//定义map用于存放每个业务部门数据集
        	Map<Integer,BaseCustomPlateAccount> map = new HashMap<>();
        	for(BaseonLoadAccountInfoOfPlateAccount e : list){
        		//获取部门
        		int plateId = BaseHelpUtils.getIntValue(e.getPlateId());
        		if(checkType == 2){//说明只查看自己管理部门的权限
        			//判断该业务部门是否在自己管理的部门
        			if(!plateMap.containsKey(plateId)){
        				continue;
        			}
        		}
        		//获取业务类型ID
        		int businessTypeId = BaseHelpUtils.getIntValue(e.getBusinessTypeId());
        		//获取金额
        		BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getIntegral());
        		bean = map.get(plateId);
        		if(BaseHelpUtils.isNullOrEmpty(bean)){
        			bean = new BaseCustomPlateAccount();
        			//获取该业务部门的实时余额
        			BigDecimal leftIntegral = BaseHelpUtils.getBigDecimalValue(paramMap.get(plateId));
        			bean.setPlateId(plateId);
        			bean.setLeftIntegral(leftIntegral);
        		}
        		//获取积分余额
        		BigDecimal achieveIntegral = bean.getAchieveIntegral()==null?BigDecimal.ZERO:bean.getAchieveIntegral();
        		map.put(plateId,bean);
        		if(businessTypeId == 0){
        			continue;
        		}
        		if(getDepIsAchieve(businessTypeId)){//说明是收入项
    				achieveIntegral = achieveIntegral.add(integral);
    			}else{//说明是支出项
    				achieveIntegral = achieveIntegral.subtract(integral);
    			}
        		bean.setAchieveIntegral(achieveIntegral);
        		switch (businessTypeId) {
				case PLATE_BT_SURE_INTEGRAL:
					bean.setProjectSettlement(integral);
					break;
				case PLATE_BT_COMPANY_SUBSIDY:
					bean.setCompanySubsidy(integral);
					break;
				case PLATE_BT_INTEGRAL_RECYCLE:
					bean.setEmployeeAchieveIntegralReturn(integral);
					break;
				case PLATE_BT_SALAEY_REFUND:
					bean.setSalaryReturn(integral);
					break;
				case PLATE_BT_INTEGRAL_ADVANCE:
					bean.setSalaryAdvance(integral);
					break;
				case PLATE_BT_BONUS_SUBSIDY:
					bean.setManagerProjectIntegral(integral);
					break;
				case PLATE_BT_PLATE_COST:
					bean.setPlateCost(integral);
					break;
				case PLATE_BT_PROJECT_SUBSIDY:
					bean.setProjectAdvance(integral);
					break;
				case PLATE_BT_COLLABORATIVE_ACHIEVE:
					bean.setCollaborativeAchieve(integral);
					break;
				case PLATE_BT_COLLABORATIVE_PAY:
					bean.setCollaborativePay(integral);
					break;
				case PLATE_BT_COMPANY_FEE:
					bean.setCompanyFee(integral);
					break;
				case PLATE_BT_VIOLATION_CHARGES:
					bean.setViolationCharges(integral);
					break;
				case PLATE_BT_COMPANY_ADVANCE:
					bean.setCompanyAdvance(integral);
					break;
				case PLATE_BT_COMPANY_REFUND:
					bean.setCompanyRefund(integral);
					break;
				case PLATE_BT_DEVELOP_PROJECT:
					bean.setDevelopProject(integral);
					break;
				case PLATE_BT_MANAGE_PROJECT:
					bean.setManageProject(integral);
					break;
				case PLATE_BT_PERFORMANCE_BONUS:
					bean.setPerformanceBonus(integral);
					break;
				case PLATE_BT_ATTENDANCE_DEDUCT:
					bean.setAttendanceDeduct(integral);
					break;
				case PLATE_BT_CONTRACT_CHANGE:
					bean.setContractChange(integral);
					break;
				case PLATE_BT_END_PROJECT:
					bean.setEndProject(integral);
					break;
				case PLATE_BT_SALE_INTEGRAL:
					bean.setSaleIntegral(integral);
					break;
				case PLATE_BT_SEND_ACHIEVE:
					bean.setSendAchieve(integral);
					break;
				case PLATE_BT_SEND_PAY:
					bean.setSendPay(integral);
					break;
				case PLATE_BT_EMPLOYEE_COST:
					bean.setEmployeeCost(integral);
					break;
				case PLATE_BT_CONTRACT_DISTRIBUTION_INCOME:
					bean.setContractDistributionIncome(integral);
					break;
				case PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
					bean.setContractDistributionExpenditure(integral);
					break;
				case PLATE_BT_PROJECT_PERFORMANCE:
					bean.setProjectPerformance(integral);
					break;
				case PLATE_BT_PROJECT_PERFORMANCE_PAY:
					bean.setProjectPerformancePay(integral);
					break;
				case PLATE_BT_DEP_DEPLOY:
					bean.setDepDeploy(integral);
					break;
				case PLATE_BT_OUTPUT_ACCOUNT:
					bean.setOutputAccount(integral);
					break;
				default:
					break;
				}
        	}
        	
        	if(!BaseHelpUtils.isNullOrEmpty(map) && map.size() > 0){
        		for(Integer plateId : map.keySet()){
        			resultList.add(map.get(plateId));
        		}
        	}
    	}
    	return resultList;
    }
    
    /**
     * 加载部门账户的剩余总积分
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadPlateAccountTotalIntegral(Map<String, Object> param) throws SQLException{
    	//獲取業務部門ID
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	if(plateId == 0){
    		throw new SQLException("业务部门不可为空");
    	}
    	PlateAccountRecord dao = new PlateAccountRecord();
    	dao.setConditionPlateId("=",plateId);
    	List<BasePlateAccountRecord> list = dao.conditionalLoad();
    	BigDecimal achieveIntegral = BigDecimal.ZERO;
    	if(!list.isEmpty()){
    		for(BasePlateAccountRecord e : list){
    			int businessTypeId = BaseHelpUtils.getIntValue(e.getBusinessTypeId());
    			BigDecimal integral = BaseHelpUtils.getBigDecimalValue(e.getIntegral());
    			if(getDepIsAchieve(businessTypeId)){//说明是收入项
    				achieveIntegral = achieveIntegral.add(integral);
    			}else{//说明是支出项
    				achieveIntegral = achieveIntegral.subtract(integral);
    			}
    		}
    	}
    	BasePlateAccountRecord bean = new BasePlateAccountRecord();
    	bean.setPlateId(plateId);
    	bean.setIntegral(achieveIntegral);
    	List<BasePlateAccountRecord> resultList = new ArrayList<>();
    	resultList.add(bean);
    	BaseCollection<BasePlateAccountRecord> bc = new BaseCollection<>();
    	bc.setCollections(resultList);
        return bc.toJSON(0,"");
    }
    
    /**
     * 加載部門下發放獎金的成員的數據集
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onLoadPlateEmpPerformanceBonusData(Map<String, Object> param) throws SQLException{
    	//獲取業務部門ID
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	if(plateId == 0){
    		throw new SQLException("业务部门不可为空");
    	}
    	//定义一个map，用于存放该部门下的所有成员及其获取到的绩效奖金积分
    	Map<Integer,BigDecimal> map = new HashMap<>();
    	//加載改业务部门下的所有在职的职员
    	Employee employeeDao = new Employee();
    	employeeDao.setConditionPlateId("=",plateId);
    	employeeDao.setConditionStatus("=",0);//只加载在职的人员
    	List<BaseEmployee> employeeList = employeeDao.conditionalLoad();
    	if(employeeList.isEmpty()){//如果为空，则说明该部门下未设定人员
    		throw new SQLException("该部门下设定人员,请先设定人员的归属业务部门");
    	}else{
    		//遍历将该部门下的所有职员都存放到map中，并初始化每个职员的所得绩效奖金为0
    		for(BaseEmployee e : employeeList){
    			map.put(BaseHelpUtils.getIntValue(e.getEmployeeId()),BigDecimal.ZERO);
    		}
    		//加载所有部门职员已经发放绩效奖金的人员和积分
    		PlatePerformanceBonusDetail dao = new PlatePerformanceBonusDetail();
    		dao.setConditionPlateId("=",plateId);
    		List<BasePlatePerformanceBonusDetail> list = dao.conditionalLoad();
    		if(!list.isEmpty()){
    			for(BasePlatePerformanceBonusDetail bean : list){
    				//获取人员id
    				int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
    				//获取该人员目前已发放并保存到map的积分
    				BigDecimal sendedIntegral = BaseHelpUtils.getBigDecimalValue(map.get(employeeId));
    				sendedIntegral = sendedIntegral.add(BaseHelpUtils.getBigDecimalValue(bean.getSendedIntegral()));
    				map.put(employeeId,sendedIntegral);
    			}
    		}
    	}
    	
        List<BasePlatePerformanceBonusDetail> resultList = new ArrayList<>();
        BasePlatePerformanceBonusDetail bean ;
        //检索项目成员已经补贴的积分
        if(!map.isEmpty()){
        	for(Integer empId : map.keySet()){
        		employeeDao.clear();
        		employeeDao.setEmployeeId(empId);
        		employeeDao.load();
        		bean = new BasePlatePerformanceBonusDetail();
        		bean.setPlateId(plateId);
        		bean.setEmployeeId(empId);
        		bean.setSendIntegral(BigDecimal.ZERO);
        		bean.setSendedIntegral(map.get(empId));
        		//用备注暂存职员的编号
        		bean.setRemark(BaseHelpUtils.getString(employeeDao.getEmployeeNo()));
        		resultList.add(bean);
        	}
        }
        Map<String,Object> userData = new HashMap();
        userData.put("avg",25);
        BaseCollection<BasePlatePerformanceBonusDetail> bc = new BaseCollection<>();
        bc.setCollections(resultList);
        bc.setUserData(userData);
        return bc.toJSON();
    }
    
    /**
     * 部门成员绩效奖金的发放保存
     * @param param
     * @return
     * @throws SQLException
     */
    public String onSavePlateEmpPerformanceBonus(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	//獲取業務部門ID
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	if(plateId == 0){
    		throw new SQLException("业务部门不可为空");
    	}
		//获取当前操作人ID
		int operateEmployeeId = BaseHelpUtils.getIntValue(param,"operateEmployeeId"); 
		//设置发放日期为当前系统日期
        Date sendDate = new Date();
        //获取备注
        String remark = BaseHelpUtils.getStringValue(param,"remark");
        //获取发放总积分
        BigDecimal totalSendIntegral = BaseHelpUtils.getBigDecimalValue(param.get("totalSendIntegral"));
        PlatePerformanceBonus dao = new PlatePerformanceBonus();
		// 获取到职员发放的grid数据
		@SuppressWarnings("unchecked")
		List<BasePlatePerformanceBonusDetail> resultList = GenericBase.__getList(param.get("plateEmpPermanceBonus"),BasePlatePerformanceBonusDetail.newInstance());
		if (!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()) {
			//保存总表数据
			dao.setPlateId(plateId);
			dao.setSendIntegral(totalSendIntegral);
			dao.setSendDate(sendDate);
			dao.setRemark(remark);
			dao.setOperateEmployeeId(operateEmployeeId);
			dao.setOperateTime(new Date());
			dao.save();
			int businessIdTotal = BaseHelpUtils.getIntValue(dao.getPlatePerformanceBonusId());
			//向部门账户中插入数据
			onSavePlateAccount(plateId, businessIdTotal, PLATE_BT_PERFORMANCE_BONUS, totalSendIntegral, sendDate, remark, operateEmployeeId);
			//部门账户：贷业务部门
			AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_21, businessIdTotal, businessIdTotal, totalSendIntegral, false, sendDate, operateEmployeeId, remark);
			PlatePerformanceBonusDetail detailDao = new PlatePerformanceBonusDetail();
			for (BasePlatePerformanceBonusDetail e : resultList) {
				//获取当次发放的积分
				BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(e.getSendIntegral());
				if(sendIntegral.compareTo(BigDecimal.ZERO) != 0){
					//获取职员id
					int employeeId = BaseHelpUtils.getIntValue(e.getEmployeeId());
					e.setPlatePerformanceBonusId(businessIdTotal);
					e.setPlateId(plateId);
					e.setSendIntegral(BigDecimal.ZERO);
					e.setSendedIntegral(sendIntegral);
					e.setSendDate(sendDate);
					e.setOperateEmployeeId(operateEmployeeId);
					e.setOperateTime(new Date());
					e.setRemark(remark);
					detailDao.clear();
					detailDao.setDataFromBase(e);
					detailDao.save();
					int businessId = BaseHelpUtils.getIntValue(dao.getPlatePerformanceBonusId());
					//向个人账户表中插入数据
					onSaveEmployeeAccount(employeeId, businessId,EMP_BT_PERFORMANCE_BONUS, sendIntegral, sendDate, remark, operateEmployeeId);
					//账户系统：借个人账户
					AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_EMPLOYEE, employeeId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_21, businessIdTotal, businessId, sendIntegral, true, sendDate, operateEmployeeId, remark);
				}
			}
		}
		ThreadConnection.commit();
		return dao.generateBase().toOneLineJSON(0, null);
    }
    
    
    /**
     * 品质管理积分发放给部门
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onSavePlateIntegralAchieve(String creteria) throws Exception{
    	ThreadConnection.beginTransaction();
    	BasePlateIntegralAchieve bean = new BasePlateIntegralAchieve();
    	bean.setDataFromJSON(creteria);
    	bean.setOperateTime(new Date());
//    	bean.setSendDate(new Date());
    	PlateIntegralAchieve dao = new PlateIntegralAchieve();
    	dao.setDataFromBase(bean);
    	dao.save();
    	//获取当前发放部门id
    	int fromPlateId = BaseHelpUtils.getIntValue(dao.getFromPlateId());
    	//获取获取积分部门id
    	int toPlateId = BaseHelpUtils.getIntValue(dao.getToPlateId());
    	//获取发放积分
    	BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(dao.getSendIntegral());
    	//获取发放日期
    	Date sendDate = dao.getSendDate();
    	//获取操作人
    	int operateEmployeeId = BaseHelpUtils.getIntValue(dao.getOperateEmployeeId());
    	//获取备注
    	String remark = BaseHelpUtils.getString(dao.getRemark());
    	//获取业务功能id
    	int businessId = BaseHelpUtils.getIntValue(dao.getPlateIntegralAchieveId());
    	//发放部门发放的积分记录到部门账户表中
    	onSavePlateAccount(fromPlateId, businessId,PLATE_BT_COLLABORATIVE_PAY, sendIntegral,sendDate, remark, operateEmployeeId);
    	//获取积分部门获取的积分记录到部门账户表中
    	onSavePlateAccount(toPlateId, businessId,PLATE_BT_COLLABORATIVE_ACHIEVE, sendIntegral,sendDate, remark, operateEmployeeId);
    	//部门账户：借业务部门toPlateId
    	AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, toPlateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_22, businessId, businessId, sendIntegral, true, sendDate, operateEmployeeId, remark);
    	//部门账户：贷业务部门fromPlateId
    	AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, fromPlateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_22, businessId, businessId, sendIntegral, false, sendDate, operateEmployeeId, remark);
    	//如果存在记录，则修改业务部门某个月份的价值积分和公司费用，否则，新建一条记录（PS：这里只是暂时使用，后续部门账户做成实时的之后，这下面的一行代码要删除）
//    	updatePlateReportRecord(sendDate, fromPlateId, sendIntegral);
		ThreadConnection.commit();
        return dao.generateBase().toJSON();
    }
    
    
    /**
     * 
     * @Title: onDeletePalteAccount 
     * @Description: 删除部门账户积分数据
     * @param @param businessId
     * @param @param businessTypeId
     * @param @throws SQLException   
     * @return void   
     * @throws
     */
    public static void onDeletePalteAccount(Integer businessId, Integer businessTypeId) throws SQLException{
    	if(null == businessId){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(null == businessTypeId){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	PlateAccountRecord dao = new PlateAccountRecord();
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionBusinessId("=", businessId);
    	if(dao.countRows() > 0){
    		dao.conditionalDelete();
    	}
    }
    
    /**
     * 部门账户数据插入
     * @param plateId
     * @param businessId
     * @param businessTypeId
     * @param integral
     * @param recordDate
     * @param remark
     * @param operateEmployeeId
     * @throws SQLException
     */
    public static void onSavePlateAccount(int plateId,int businessId,int businessTypeId,BigDecimal integral,Date recordDate,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(plateId) <= 0){
    		throw new SQLException("业务部门不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(recordDate == null){
    		throw new SQLException("日期不可以为空");
    	}
    	if(null == integral){
    		throw new SQLException("积分不能为空");
    	}
    	if(null == getDepIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
        //判断该人员在当前年度是否已做左后一次结算，如果已做最后一次结算，则不可再进行账户数据操作
        int year = DateUtil.getYear(recordDate);
        int month = DateUtil.getMonth(recordDate);
        OutputAccountRecord oDao = new OutputAccountRecord();
        oDao.setConditionPlateId("=",plateId);
        oDao.setConditionYear("=",year);
        oDao.setConditionMonth("=",month);
        oDao.setConditionIsYearFinalAccount("=",Boolean.TRUE);
        if(oDao.isExist()){
            throw new SQLException("账户操作异常：部门在当前年度已做最后一次结算，不可进行当前年度的账户数据操作");
        }
    	PlateAccountRecord dao = new PlateAccountRecord();
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionBusinessId("=", businessId);
    	dao.setConditionPlateId("=", plateId);
    	BasePlateAccountRecord bean = new BasePlateAccountRecord();
    	bean.setPlateId(plateId);
    	bean.setBusinessId(businessId);
    	bean.setBusinessTypeId(businessTypeId);
    	bean.setIntegral(integral);
    	bean.setRecordDate(recordDate);
    	bean.setRemark(remark);
    	bean.setOperateEmployeeId(operateEmployeeId);
    	bean.setOperateTime(new Date());
    	if(dao.countRows() > 0){
    		dao.executeQueryOneRow();
    		dao.setDataFromBase(bean);
    		dao.update();
    	}else{
    		if(integral.compareTo(BigDecimal.ZERO) != 0){//只有积分不等于0的实时才保存
    			dao.setDataFromBase(bean);
    			dao.save();
    		}
    	}
    }
    
    /**
     * 部门账户数据插入(提成计算)
     * @param plateId
     * @param businessId
     * @param businessTypeId
     * @param integral
     * @param recordDate
     * @param remark
     * @param operateEmployeeId
     * @throws SQLException
     */
    public static void onSavePlateAccount1(int plateId,int businessId,int businessTypeId,BigDecimal integral,Date recordDate,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(plateId) <= 0){
    		throw new SQLException("业务部门不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(recordDate == null){
    		throw new SQLException("日期不可以为空");
    	}
    	if(null == integral){
    		throw new SQLException("积分不能为空");
    	}
    	if(null == getDepIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
    	PlateAccountRecord dao = new PlateAccountRecord();
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionBusinessId("=", businessId);
    	dao.setConditionPlateId("=", plateId);
    	BasePlateAccountRecord bean = new BasePlateAccountRecord();
    	bean.setPlateId(plateId);
    	bean.setBusinessId(businessId);
    	bean.setBusinessTypeId(businessTypeId);
    	bean.setIntegral(integral);
    	bean.setRecordDate(recordDate);
    	bean.setRemark(remark);
    	bean.setOperateEmployeeId(operateEmployeeId);
    	bean.setOperateTime(new Date());
    		if(integral.compareTo(BigDecimal.ZERO) != 0){//只有积分不等于0的实时才保存
    			dao.setDataFromBase(bean);
    			dao.save();
    		}
    }
    /**
     * 个人账户数据插入
     * @param employeeId
     * @param businessId
     * @param businessTypeId
     * @param integral
     * @param recordDate
     * @param remark
     * @param operateEmployeeId
     * @throws SQLException
     */
    public static void onSaveEmployeeAccount(int employeeId,int businessId,int businessTypeId,BigDecimal integral,Date recordDate,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(employeeId) <= 0){
    		throw new SQLException("职员ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(recordDate == null){
    		throw new SQLException("日期不可以为空");
    	}
    	if(null == getEmpIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
    	//判断该人员在当前年度是否已做左后一次结算，如果已做最后一次结算，则不可再进行账户数据操作
        int year = DateUtil.getYear(recordDate);
    	int month = DateUtil.getMonth(recordDate);
        OutputAccountDetail oDao = new OutputAccountDetail();
        oDao.setConditionEmployeeId("=",employeeId);
        oDao.setConditionYear("=",year);
        oDao.setConditionMonth("=",month);
        oDao.setConditionIsYearFinalAccount("=",Boolean.TRUE);
        if(oDao.isExist()){
            throw new SQLException("账户操作异常：人员在当前年度已做最后一次结算，不可进行当前年度的账户数据操作");
        }
    	//获取当前职员的业务部门id
    	Employee eDao = new Employee();
    	eDao.setEmployeeId(employeeId);
    	eDao.load();
    	int plateId = BaseHelpUtils.getIntValue(eDao.getPlateId());
    	BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
    	bean.setEmployeeId(employeeId);
    	bean.setPlateId(plateId);
    	bean.setBusinessId(businessId);
    	bean.setBusinessTypeId(businessTypeId);
    	bean.setIntegral(integral);
    	bean.setRecordDate(recordDate);
    	bean.setRemark(remark);
    	bean.setOperateEmployeeId(operateEmployeeId);
    	bean.setOperateTime(new Date());
    	
    	EmployeeAccountRecord dao = new EmployeeAccountRecord();
    	dao.setConditionBusinessId("=", businessId);
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionEmployeeId("=", employeeId);
    	if(dao.countRows() > 0){
    		dao.executeQueryOneRow();
    		dao.setDataFromBase(bean);
    		dao.update();
    	}else {
    		if(integral.compareTo(BigDecimal.ZERO) != 0){
    			dao.setDataFromBase(bean);
    			dao.save();
    		}
    	}
    	//插入账户是需要查看当日是否有日归属如果没有则插入日归属（解决插入人员账户数据时没有日归属导致的积分余额和实时余额不相等的问题）
		EmployeeDayPlateRecord employeeDayPlateRecord = new EmployeeDayPlateRecord();
		employeeDayPlateRecord.setConditionEmployeeId("=", employeeId);
		employeeDayPlateRecord.setConditionRecordDate("=", recordDate);
		if (!employeeDayPlateRecord.isExist()) {
			BaseEmployeeDayPlateRecord baseEmployeeDayPlateRecord = new BaseEmployeeDayPlateRecord();
			baseEmployeeDayPlateRecord.setEmployeeId(eDao.getEmployeeId());
			baseEmployeeDayPlateRecord.setEmployeeNo(eDao.getEmployeeNo());
			baseEmployeeDayPlateRecord.setEmployeeName(eDao.getEmployeeName());
			baseEmployeeDayPlateRecord.setRecordDate(recordDate);
			baseEmployeeDayPlateRecord.setYear(year);
			baseEmployeeDayPlateRecord.setMonth(month);
			baseEmployeeDayPlateRecord.setCompanyId(eDao.getCompanyId());
			baseEmployeeDayPlateRecord.setPlateId(eDao.getPlateId());
			baseEmployeeDayPlateRecord.setDepartmentId(eDao.getDepartmentId());
			baseEmployeeDayPlateRecord.setOnboardStatus(eDao.getStatus());
			employeeDayPlateRecord.clear();
			employeeDayPlateRecord.setDataFromBase(baseEmployeeDayPlateRecord);
			employeeDayPlateRecord.save();
		}
	}
    
    /**
     * 个人账户数据插入(提成)
     * @param employeeId
     * @param businessId
     * @param businessTypeId
     * @param integral
     * @param recordDate
     * @param remark
     * @param operateEmployeeId
     * @throws SQLException
     */
    public static void onSaveEmployeeAccount1(int employeeId,int businessId,int businessTypeId,BigDecimal integral,Date recordDate,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(employeeId) <= 0){
    		throw new SQLException("职员ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(recordDate == null){
    		throw new SQLException("日期不可以为空");
    	}
    	if(null == getEmpIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
    	//获取当前职员的业务部门id
    	Employee eDao = new Employee();
    	eDao.setEmployeeId(employeeId);
    	eDao.load();
    	int plateId = BaseHelpUtils.getIntValue(eDao.getPlateId());
    	BaseEmployeeAccountRecord bean = new BaseEmployeeAccountRecord();
    	bean.setEmployeeId(employeeId);
    	bean.setPlateId(plateId);
    	bean.setBusinessId(businessId);
    	bean.setBusinessTypeId(businessTypeId);
    	bean.setIntegral(integral);
    	bean.setRecordDate(recordDate);
    	bean.setRemark(remark);
    	bean.setOperateEmployeeId(operateEmployeeId);
    	bean.setOperateTime(new Date());
    	
    	EmployeeAccountRecord dao = new EmployeeAccountRecord();
    	dao.setConditionBusinessId("=", businessId);
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionEmployeeId("=", employeeId);
    		if(integral.compareTo(BigDecimal.ZERO) != 0){
    			dao.setDataFromBase(bean);
    			dao.save();
    		}
    }
    
    /**
     * 个人账户数据更新
     * @param employeeId
     * @param businessId
     * @param businessTypeId
     * @param integral
     * @param recordDate
     * @param remark
     * @param operateEmployeeId
     * @throws SQLException
     */
    public static void onUpdateEmployeeAccount(int employeeId,int businessId,int businessTypeId,BigDecimal integral,Date recordDate,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(employeeId) <= 0){
    		throw new SQLException("职员ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(recordDate == null){
    		throw new SQLException("日期不可以为空");
    	}
    	if(null == getEmpIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
    	
    	if(integral.compareTo(BigDecimal.ZERO) != 0){//只有积分不等于0的实时才保存
    		EmployeeAccountRecord dao = new EmployeeAccountRecord();
    		dao.setConditionBusinessId("=",businessId);
    		dao.setConditionBusinessTypeId("=",businessTypeId);
    		dao.setConditionEmployeeId("=",employeeId);
    		BaseEmployeeAccountRecord bean = dao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(bean)){
    			bean.setIntegral(integral);
    			bean.setRecordDate(recordDate);	
    			dao.setDataFromBase(bean);
    			dao.conditionalUpdate();
    		}
    	}
    	
    }
    
    /**
     * 
     * @Title: getDepIsAchieve 
     * @Description: 根据业务ID获取  部门数据操作是支出还是收入
     * @param @param businessTypeId
     * @param @return   
     * @return Boolean   
     * @throws
     */
    public static Boolean getDepIsAchieve(int businessTypeId){
    	Boolean flag = null ;
    	switch (businessTypeId) {
		case PLATE_BT_SURE_INTEGRAL:
			flag = true;
			break;
		case PLATE_BT_COMPANY_SUBSIDY:
			flag = true;
			break;
		case PLATE_BT_INTEGRAL_RECYCLE:
			flag = true;
			break;
		case PLATE_BT_SALAEY_REFUND:
			flag = true;
			break;
		case PLATE_BT_INTEGRAL_ADVANCE:
			flag = false;
			break;
		case PLATE_BT_BONUS_SUBSIDY:
			flag = false;
			break;
		case PLATE_BT_PLATE_COST:
			flag = false;
			break;
		case PLATE_BT_PROJECT_SUBSIDY:
			flag = false;
			break;
		case PLATE_BT_COLLABORATIVE_ACHIEVE:
			flag = true;
			break;
		case PLATE_BT_COLLABORATIVE_PAY:
			flag = false;
			break;
		case PLATE_BT_PERFORMANCE_BONUS:
			flag = false;
			break;	
		case PLATE_BT_COMPANY_FEE:
			flag = false;
			break;	
		case PLATE_BT_VIOLATION_CHARGES:
			flag = true;
			break;	
		case PLATE_BT_COMPANY_REFUND:
			flag = false;
			break;	
		case PLATE_BT_COMPANY_ADVANCE:
			flag = true;
			break;	
		case PLATE_BT_DEVELOP_PROJECT:
			flag = false;
			break;	
		case PLATE_BT_MANAGE_PROJECT:
			flag = false;
			break;	
		case PLATE_BT_ATTENDANCE_DEDUCT:
			flag = true;
			break;	
		case PLATE_BT_CONTRACT_CHANGE:
			flag = false;
			break;	
		case PLATE_BT_END_PROJECT:
			flag = true;
			break;
		case PLATE_BT_SALE_INTEGRAL:
			flag = true;
			break;
		case PLATE_BT_SEND_ACHIEVE:
			flag = true;
			break;
		case PLATE_BT_SEND_PAY:
			flag = false;
			break;
		case PLATE_BT_EMPLOYEE_COST:
			flag = false;
			break;
		case PLATE_BT_CONTRACT_DISTRIBUTION_INCOME:
			flag = true;
			break;
		case PLATE_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
			flag = false;
			break;
		case PLATE_BT_PROJECT_PERFORMANCE:
			flag = true;
			break;
		case PLATE_BT_PROJECT_PERFORMANCE_PAY:
			flag = false;
			break;
		case PLATE_BT_DEP_DEPLOY:
			flag = false;
			break;
		case PLATE_BT_OUTPUT_ACCOUNT:
			flag = false;
			break;
		default:
			break;
		}
    	return flag;
    }
    
    /**
     * 
     * @Title: getEmpIsAchieve 
     * @Description: 据业务ID获取  员工数据操作是支出还是收入
     * @param @param businessTypeId
     * @param @return   
     * @return Boolean   
     * @throws
     */
    public static Boolean getEmpIsAchieve(int businessTypeId){
    	Boolean flag = null ;
    	switch (businessTypeId) {
		case EMP_BT_SURE_INTEGRAL:
			flag = true;
			break;
		case EMP_BT_BONUS_SUBSIDY:
			flag = true;
			break;
		case EMP_BT_INTEGRAL_ADVANCE:
			flag = true;
			break;
		case EMP_BT_PROJECT_SUBSIDY:
			flag = true;
			break;
		case EMP_BT_SALAEY_REFUND:
			flag = false;
			break;
		case EMP_BT_EMPLOYEE_COST:
			flag = false;
			break;
		case EMP_BT_PROJECT_COST:
			flag = false;
			break;
		case EMP_BT_BONUS_SEND:
			flag = false;
			break;
		case EMP_BT_INTEGRAL_RECYCLE:
			flag = false;
			break;
		case EMP_BT_PERFORMANCE_BONUS:
			flag = true;
			break;
		case EMP_BT_VIOLATION_CHARGES:
			flag = false;
			break;
		case EMP_BT_ATTENDANCE_DEDUCT:
			flag = false;
			break;
		case EMP_BT_PM_PERFORMANCE_AWARD:
			flag = true;
			break;
		case EMP_BT_PM_PERFORMANCE_DEDUCT:
			flag = false;
			break;
		case EMP_BT_PROJECT_PERFORMANCE:
			flag = true;
			break;
		case EMP_BT_CONTRACT_CHANGE:
			flag = false;
			break;
		case EMP_BT_PLATE_CHANGE_ACHIEVE:
			flag = true;
			break;
		case EMP_BT_PLATE_CHANGE_PAY:
			flag = false;
			break;
		case EMP_BT_PROJECT_PERFORMANCE_PAY:
			flag = false;
			break;
		case EMP_BT_CONTRACT_DISTRIBUTION_INCOME:
			flag = true;
			break;
		case EMP_BT_CONTRACT_DISTRIBUTION_EXPENDITURE:
			flag = false;
		case EMP_BT_DEP_DEPLOY:
			flag = true;
			break;
		case EMP_BT_OUTPUT_ACCOUNT:
			flag = false;
			break;
		default:
			break;
		}
    	return flag;
    }
    
    /**
     * 个人账户数据同步
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
	public static void onEmpAccount() throws SQLException, UnsupportedEncodingException{
		ThreadConnection.beginTransaction();
	    //个人账户确认积分和项目成本同步
		ProjectSettlementDetail projectSettlmentDetailDao = new ProjectSettlementDetail();
		List<BaseProjectSettlementDetail> projectSettlmentDetailList = projectSettlmentDetailDao.conditionalLoad();
		if(!projectSettlmentDetailList.isEmpty() && projectSettlmentDetailList.size() > 0){
			for(BaseProjectSettlementDetail e : projectSettlmentDetailList){
				//获取主键ID，即业务ID
				int businessId = e.getSettlementDetailId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取确认积分
				BigDecimal sureIntegral = e.getRealAmount();
				//获取项目成本
				BigDecimal projectCost = e.getProjectCost();
				//获取日期
				Date recordDate = e.getSettlementDate();
				//确认积分插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_SURE_INTEGRAL, sureIntegral, recordDate, "", -1);
				//项目成本插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_PROJECT_COST, projectCost, recordDate, "", -1);
			}
		}
		//个人账户奖金补贴同步
		ManageProjectEmployeeRecord manageProjectEmployeeDao = new ManageProjectEmployeeRecord();
		List<BaseManageProjectEmployeeRecord> manageProjectEmployeeList = manageProjectEmployeeDao.conditionalLoad();
		if(!manageProjectEmployeeList.isEmpty() && manageProjectEmployeeList.size() > 0){
			for(BaseManageProjectEmployeeRecord e : manageProjectEmployeeList){
				//获取主键ID，即业务ID
				int businessId = e.getManageProjectEmployeeRecordId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getAssignedIntegral();
				//获取日期
				Date recordDate = e.getAssignDate();
				//奖金补贴插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_BONUS_SUBSIDY, integral, recordDate,e.getRemark(), e.getOperateEmployeeId());
			}
		}
		//个人账户积分借款同步
		PlateSalaryAdvanceRecord plateSalaryAdvanceDao = new PlateSalaryAdvanceRecord();
		List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceList = plateSalaryAdvanceDao.conditionalLoad();
		if(!plateSalaryAdvanceList.isEmpty() && plateSalaryAdvanceList.size() > 0){
			for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateSalaryAdvanceRecordId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getSalaryReturn();
				//获取日期
				Date recordDate = e.getRecordDate();
				//积分借款插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_INTEGRAL_ADVANCE, integral, recordDate,"",-1);
			}
		}
		//个人账户项目补贴同步
		ProjectEmployeeAdvanceRecord projectEmployeeAdvanceDao = new ProjectEmployeeAdvanceRecord();
		List<BaseProjectEmployeeAdvanceRecord> projectEmployeeAdvanceList = projectEmployeeAdvanceDao.conditionalLoad();
		if(!projectEmployeeAdvanceList.isEmpty() && projectEmployeeAdvanceList.size() > 0){
			for(BaseProjectEmployeeAdvanceRecord e : projectEmployeeAdvanceList){
				//获取主键ID，即业务ID
				int businessId = e.getProjectEmployeeAdvanceRecordId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getAdvancedIntegral();
				//获取日期
				Date recordDate = e.getAdvanceDate();
				//项目补贴插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_PROJECT_SUBSIDY, integral, recordDate, e.getRemark(), e.getOperateEmployeeId());
			}
		}
		//个人账户积分还款同步
		EmployeeSalaryReturnRecord employeeSalaryReturnDao = new EmployeeSalaryReturnRecord();
		List<BaseEmployeeSalaryReturnRecord> employeeSalaryReturnList = employeeSalaryReturnDao.conditionalLoad();
		if(!employeeSalaryReturnList.isEmpty() && employeeSalaryReturnList.size() > 0){
			for(BaseEmployeeSalaryReturnRecord e : employeeSalaryReturnList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeSalaryReturnRecordId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getSalaryReturn();
				//获取日期
				Date recordDate = e.getRecordDate();
				//项目补贴插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_SALAEY_REFUND, integral, recordDate,"",-1);
			}
		}
		//个人账户人工成本同步
		EmployeeSalaryDetail employeeSalaryDetailDao = new EmployeeSalaryDetail();
		List<BaseEmployeeSalaryDetail> employeeSalaryDetailList = employeeSalaryDetailDao.conditionalLoad();
		if(!employeeSalaryDetailList.isEmpty() && employeeSalaryDetailList.size() > 0){
			SystemConfig systemConfigDao = new SystemConfig();
	        systemConfigDao.setSystemConfigId(2);
	        systemConfigDao.load();
	        DES des = new DES(systemConfigDao.getImagePath());
	        for(BaseEmployeeSalaryDetail e : employeeSalaryDetailList){
	        	//获取主键ID，即业务ID
				int businessId = e.getEmployeeSalaryDetailId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = BaseHelpUtils.getBigDecimalValue(des.DEC(e.getBasicSalary()));
				//获取日期
				Date recordDate = e.getEntryDate();
				//个人账户插入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_EMPLOYEE_COST, integral, recordDate,"",-1);
	        }
		}
		//个人账户奖金发放同步
		BonusPaymentDetail bonusPaymentDetailDao = new BonusPaymentDetail();
		bonusPaymentDetailDao.setConditionState("=",1);
		List<BaseBonusPaymentDetail> bonusPaymentDetailList = bonusPaymentDetailDao.conditionalLoad();
		if(!bonusPaymentDetailList.isEmpty() && bonusPaymentDetailList.size() > 0){
			for(BaseBonusPaymentDetail e : bonusPaymentDetailList){
				//获取主键ID，即业务ID
				int businessId = e.getBonusPaymentDetailId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getPayIntegral();
				//获取日期
				Date recordDate = e.getPayDate();
				//奖金发放入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_BONUS_SEND, integral, recordDate,"",-1);
			}
		}
		//个人账积分回收同步
		EmployeeAchieveIntegralReturnRecord employeeAchieveIntegralReturnDao = new EmployeeAchieveIntegralReturnRecord();
		List<BaseEmployeeAchieveIntegralReturnRecord> employeeAchieveIntegralReturnList = employeeAchieveIntegralReturnDao.conditionalLoad();
		if(!employeeAchieveIntegralReturnList.isEmpty() && employeeAchieveIntegralReturnList.size() > 0){
			for(BaseEmployeeAchieveIntegralReturnRecord e : employeeAchieveIntegralReturnList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeAchieveIntegralReturnRecordId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getAchieveIntegral();
				//获取日期
				Date recordDate = e.getRecordDate();
				//积分回收入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_INTEGRAL_RECYCLE, integral, recordDate, "", -1);
			}
		}
		//个人账项目违约金同步
		EmployeeViolationCharge employeeViolationChargeDao = new EmployeeViolationCharge();
		List<BaseEmployeeViolationCharge> employeeViolationChargeList = employeeViolationChargeDao.conditionalLoad();
		if(!employeeViolationChargeList.isEmpty() && employeeViolationChargeList.size() > 0){
			for(BaseEmployeeViolationCharge e : employeeViolationChargeList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeViolationChargesId();
				//获取人员id
				int employeeId = e.getEmployeeId();
				//获取积分
				BigDecimal integral = e.getViolationCharges();
				//获取日期
				Date recordDate = e.getViolationDate();
				//积分回收入个人账户表
				onSaveEmployeeAccount(employeeId, businessId, EMP_BT_VIOLATION_CHARGES, integral, recordDate,e.getRemark(),e.getOperator());
			}
		}
		ThreadConnection.commit();
    }
	
	/**
     * 部门账户数据同步
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
	public static void onPlateAccount() throws SQLException, UnsupportedEncodingException{
		ThreadConnection.beginTransaction();
	    //部门账户确认积分
		PlateProjectAccountRecord plateProjectAccountDao = new PlateProjectAccountRecord();
		List<BasePlateProjectAccountRecord> plateProjectAccountList = plateProjectAccountDao.conditionalLoad();
		if(!plateProjectAccountList.isEmpty() && plateProjectAccountList.size() > 0){
			for(BasePlateProjectAccountRecord e : plateProjectAccountList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateProjectAccountRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getAccountIntegral();
				//获取日期
				Date recordDate = e.getAccountDate();
				//操作人
				int operateEmpId = -1;
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_SURE_INTEGRAL, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户公司补贴
		PlateIntegralSend plateIntegralSendDao = new PlateIntegralSend();
		List<BasePlateIntegralSend> plateIntegralSendList = plateIntegralSendDao.conditionalLoad();
		if(!plateIntegralSendList.isEmpty() && plateIntegralSendList.size() > 0){
			for(BasePlateIntegralSend e : plateIntegralSendList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateIntegralSendId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getSendIntegral();
				//获取日期
				Date recordDate = e.getSendDate();
				//操作人
				int operateEmpId = e.getEmployeeId();
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_COMPANY_SUBSIDY, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户积分回收
		EmployeeAchieveIntegralReturnRecord employeeAchieveIntegralDao = new EmployeeAchieveIntegralReturnRecord();
		List<BaseEmployeeAchieveIntegralReturnRecord> employeeAchieveIntegralList = employeeAchieveIntegralDao.conditionalLoad();
		if(!employeeAchieveIntegralList.isEmpty() && employeeAchieveIntegralList.size() > 0){
			for(BaseEmployeeAchieveIntegralReturnRecord e : employeeAchieveIntegralList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeAchieveIntegralReturnRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getAchieveIntegral();
				//获取日期
				Date recordDate = e.getRecordDate();
				//操作人
				int operateEmpId = -1;
				//备注
				String remark = "";
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_INTEGRAL_RECYCLE, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户积分还款
		EmployeeSalaryReturnRecord employeeSalaryReturnDao = new EmployeeSalaryReturnRecord();
		List<BaseEmployeeSalaryReturnRecord> employeeSalaryReturnList = employeeSalaryReturnDao.conditionalLoad();
		if(!employeeSalaryReturnList.isEmpty() && employeeSalaryReturnList.size() > 0){
			for(BaseEmployeeSalaryReturnRecord e : employeeSalaryReturnList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeSalaryReturnRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getSalaryReturn();
				//获取日期
				Date recordDate = e.getRecordDate();
				//操作人
				int operateEmpId = -1;
				//备注
				String remark = "";
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_SALAEY_REFUND, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户积分借款
		PlateSalaryAdvanceRecord plateSalaryAdvanceDao = new PlateSalaryAdvanceRecord();
		List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceList = plateSalaryAdvanceDao.conditionalLoad();
		if(!plateSalaryAdvanceList.isEmpty() && plateSalaryAdvanceList.size() > 0){
			for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateSalaryAdvanceRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getSalaryReturn();
				//获取日期
				Date recordDate = e.getRecordDate();
				//操作人
				int operateEmpId = -1;
				//备注
				String remark = "";
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_INTEGRAL_ADVANCE, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户奖金补贴
		ManageProjectEmployeeRecord manageProjectEmployeeDao = new ManageProjectEmployeeRecord();
		List<BaseManageProjectEmployeeRecord> manageProjectEmployeeList = manageProjectEmployeeDao.conditionalLoad();
		if(!manageProjectEmployeeList.isEmpty() && manageProjectEmployeeList.size() > 0){
			ManageProject manageProjectDao = new ManageProject();
			for(BaseManageProjectEmployeeRecord e : manageProjectEmployeeList){
				//获取主键ID，即业务ID
				int businessId = e.getManageProjectEmployeeRecordId();
				//获取管理项目的id
				int manageProjectId = e.getManageProjectId();
				//根据管理项目的ID去检索该项目归属的业务部门
				manageProjectDao.clear();
				manageProjectDao.setManageProjectId(manageProjectId);
				//获取部门id
				int plateId = 0;
				if(manageProjectDao.load()){
					plateId = manageProjectDao.getPlateId();
				}
				//获取确认积分
				BigDecimal integral = e.getAssignedIntegral();
				//获取日期
				Date recordDate = e.getAssignDate();
				//操作人
				int operateEmpId = e.getOperateEmployeeId();
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_BONUS_SUBSIDY, integral, recordDate, remark, operateEmpId);
			}
		}
		
		//部门账户运营成本
		PlateCostRecord plateCostDao = new PlateCostRecord();
		List<BasePlateCostRecord> plateCostList = plateCostDao.conditionalLoad();
		if(!plateCostList.isEmpty() && plateCostList.size() > 0){
			for(BasePlateCostRecord e : plateCostList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateCostRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getCostIntegral();
				//获取日期
				Date recordDate = e.getCostDate();
				//操作人
				int operateEmpId = -1;
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_PLATE_COST, integral, recordDate, remark, operateEmpId);
			}
		}
		//部门账户项目补贴
		ProjectAdvanceRecord projectAdvanceDao = new ProjectAdvanceRecord();
		List<BaseProjectAdvanceRecord> projectAdvanceList = projectAdvanceDao.conditionalLoad();
		if(!projectAdvanceList.isEmpty() && projectAdvanceList.size() > 0){
			for(BaseProjectAdvanceRecord e : projectAdvanceList){
				//获取主键ID，即业务ID
				int businessId = e.getProjectAdvanceRecordId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getAdvanceIntegral();
				//获取日期
				Date recordDate = e.getAdvanceDate();
				//操作人
				int operateEmpId = e.getOperateEmployeeId();
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_PROJECT_SUBSIDY, integral, recordDate, remark, operateEmpId);
			}
		}
		//部门账户品质管理(支出、收入和公司费用)
		PlateIntegralAchieve plateIntegralAchieveDao = new PlateIntegralAchieve();
		List<BasePlateIntegralAchieve> plateIntegralAchieveList = plateIntegralAchieveDao.conditionalLoad();
		if(!plateIntegralAchieveList.isEmpty() && plateIntegralAchieveList.size() > 0){
			for(BasePlateIntegralAchieve e : plateIntegralAchieveList){
				//获取主键ID，即业务ID
				int businessId = e.getPlateIntegralAchieveId();
				//获取部门id
				int fromPlateId = e.getFromPlateId();
				int toPlateId = e.getToPlateId();
				//获取确认积分
				BigDecimal integral = e.getSendIntegral();
				//获取日期
				Date recordDate = e.getSendDate();
				//操作人
				int operateEmpId = e.getOperateEmployeeId();
				//备注
				String remark = e.getRemark();
				if(toPlateId > 0){
					//支出插入个人账户表
					onSavePlateAccount(fromPlateId, businessId, PLATE_BT_COLLABORATIVE_PAY, integral, recordDate, remark, operateEmpId);
					//收入插入个人账户表
					onSavePlateAccount(toPlateId, businessId, PLATE_BT_COLLABORATIVE_ACHIEVE, integral, recordDate, remark, operateEmpId);
				}else{
					//公司费用插入个人账户表
					onSavePlateAccount(fromPlateId, businessId, PLATE_BT_COMPANY_FEE, integral, recordDate, remark, operateEmpId);
				}
				
			}
		}
		
		//部门账户项目违约金
		EmployeeViolationCharge employeeViolationChargeDao = new EmployeeViolationCharge();
		List<BaseEmployeeViolationCharge> employeeViolationChargeList = employeeViolationChargeDao.conditionalLoad();
		if(!employeeViolationChargeList.isEmpty() && employeeViolationChargeList.size() > 0){
			for(BaseEmployeeViolationCharge e : employeeViolationChargeList){
				//获取主键ID，即业务ID
				int businessId = e.getEmployeeViolationChargesId();
				//获取部门id
				int plateId = e.getPlateId();
				//获取确认积分
				BigDecimal integral = e.getViolationCharges();
				//获取日期
				Date recordDate = e.getViolationDate();
				//操作人
				int operateEmpId = e.getOperator();
				//备注
				String remark = e.getRemark();
				//插入个人账户表
				onSavePlateAccount(plateId, businessId, PLATE_BT_VIOLATION_CHARGES, integral, recordDate, remark, operateEmpId);
			}
		}
		
		ThreadConnection.commit();
    }
	
	/**
	 * 账户更新或者插入
	 * @param accountTypeId
	 * @param accountId
	 * @param businessId
	 * @param businessTypeId
	 * @param integral
	 * @param remark
	 * @param operateEmployeeId
	 * @throws SQLException
	 */
	public static void onSaveOrUpdateAccount(int accountTypeId,int accountId,int businessId,int businessTypeId,BigDecimal integral,String remark,int operateEmployeeId) throws SQLException{
    	if(BaseHelpUtils.getIntValue(accountTypeId) <= 0){
    		throw new SQLException("账户类型不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessId) <= 0){
    		throw new SQLException("业务ID不可以为空");
    	}
    	if(BaseHelpUtils.getIntValue(businessTypeId) <= 0){
    		throw new SQLException("业务类型ID不可以为空");
    	}
    	if(null == integral){
    		throw new SQLException("积分不能为空");
    	}
    	if(null == getDepIsAchieve(businessTypeId)){
    		throw new SQLException("业务类型Id不属于插入范围");
    	}
    	Date date = new Date();
    	AccountRecord dao = new AccountRecord();
    	dao.setConditionAccountTypeId("=",accountTypeId);
    	dao.setConditionAccountId("=",accountId);
    	dao.setConditionBusinessTypeId("=", businessTypeId);
    	dao.setConditionBusinessId("=", businessId);
    	BaseAccountRecord bean = new BaseAccountRecord();
    	bean.setAccountTypeId(accountTypeId);
    	bean.setAccountId(accountId);
    	bean.setBusinessTypeId(businessTypeId);
    	bean.setBusinessId(businessId);
    	bean.setRecordDate(date);
    	bean.setRecordTime(date);
    	bean.setOperateEmployeeId(operateEmployeeId);
    	bean.setOperateTime(date);
    	bean.setRemark(remark);
    	if(getIsAchieve(accountTypeId, businessTypeId)){//说明是收入
    		bean.setAchieveIntegral(integral);
    	}else{//说明是支出
    		bean.setPayIntegral(integral);
    	}
    	if(dao.countRows() > 0){
    		dao.executeQueryOneRow();
    		dao.setDataFromBase(bean);
    		dao.update();
    	}else{
    		if(integral.compareTo(BigDecimal.ZERO) != 0){//只有积分不等于0的实时才保存
    			dao.setDataFromBase(bean);
    			dao.save();
    		}
    	}
    }
	
	/**
	 * 判断业务列表在不同的账户下是收入还是支出
	 * @param accountTypeId
	 * @param businessTypeId
	 * @return
	 */
	public static Boolean getIsAchieve(int accountTypeId,int businessTypeId){
    	Boolean flag = false ;
    	switch (accountTypeId) {
		case ACCOUNT_EMP_ACCOUNT://个人账户
			switch (businessTypeId) {
			case pm_performance_award://项目经理绩效奖励
				flag = true;
				break;
			case project_performance://项目绩效
				flag = true;
				break;
			case pm_performance_deduct://项目经理绩效扣除
				flag = false;
				break;
			default:
				break;
			}
			break;
		case ACCOUNT_QUALITY_ACCOUNT://品质基金账户
			switch (businessTypeId) {
			case pm_performance_award://项目经理绩效奖励
				flag = false;
				break;
			case project_performance_remain://项目绩效结余
				flag = true;
				break;
			case pm_performance_deduct://项目经理绩效扣除
				flag = true;
				break;
			case project_performance_achieve://项目绩效收入
				flag = true;
				break;
			case project_performance://项目绩效支出
				flag = false;
				break;
			default:
				break;
			}
			break;
		case ACCOUNT_PROJECT_ACCOUNT://项目账户
			switch (businessTypeId) {
			case project_performance_award://项目绩效奖励
				flag = false;
				break;
			case project_performance_deduct://项目绩效扣除
				flag = true;
				break;
			case project_performance_remain://项目绩效结余
				flag = false;
				break;
			default:
				break;
			}
			break;
		case ACCOUNT_SHEET_ACCOUNT://订单账户
			switch (businessTypeId) {
			case project_performance_award://项目绩效奖励
				flag = true;
				break;
			case project_performance_deduct://项目绩效扣除
				flag = false;
				break;
			case project_performance_achieve://项目绩效收入
				flag = true;
				break;
			case project_performance://项目绩效
				flag = false;
				break;
			default:
				break;
			}
			break;

		default:
			break;
		}
    	return flag;
    }
	
	/**
	 * 加载项目账户数据集
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String onLoadProjectAccountData(Map<String, Object> param) throws Exception{
		//获取合同名称
		String contractName = BaseHelpUtils.getStringValue(param,"contractName");
		String contractCode = BaseHelpUtils.getStringValue(param, "contractCode");
		//获取开始日期和结束日期
		String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
		String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
		//获取合同ID
		int contractId = BaseHelpUtils.getIntValue(param, "contractId");
		//加载项目账户数据集
		ConditionOnLoadBusinessTypeDataOfAccount condition = new ConditionOnLoadBusinessTypeDataOfAccount();
		condition.setAccountTypeId(ACCOUNT_PROJECT_ACCOUNT);
		if(contractId>0)condition.setAccountId(contractId);
		if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
			Date startDate = new Date(Long.valueOf(startDateStr));
			condition.setStartDate(startDate);
		}
		if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
			Date endDate = new Date(Long.valueOf(endDateStr));
			condition.setEndDate(endDate);
		}
		QueryOnLoadBusinessTypeDataOfAccount dao = new QueryOnLoadBusinessTypeDataOfAccount();
		BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> result = dao.executeQuery(null, condition);
		List<BaseCustomProjectAccount> resultList = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			//加载合同数据集
			Contract conDao = new Contract();
			conDao.unsetSelectFlags();
			conDao.setSelectContractId(true);
			conDao.setSelectContractCode(true);
			conDao.setSelectContractName(true);
			if(contractId>0)conDao.setConditionContractId("=",contractId);
			if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
				conDao.setConditionContractCode("like", "%"+contractCode+"%");
			}
			if(!BaseHelpUtils.isNullOrEmpty(contractName)){
				conDao.setConditionContractName("like", "%"+contractName+"%");
			}
			List<BaseContract> contractList = conDao.conditionalLoad();
			Map<Integer,BaseContract> mapBeans = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(contractList) && contractList.size() > 0){
				for(BaseContract e : contractList){
					mapBeans.put(e.getContractId(),e);
				}
			}
			Map<Integer,BaseCustomProjectAccount> resultMap = new HashMap<>();
			BaseCustomProjectAccount bean = null;
			for(BaseOnLoadBusinessTypeDataOfAccount e : result.getCollections()){
				//获取合同ID
				int accountId = e.getAccountId();
				if(!BaseHelpUtils.isNullOrEmpty(mapBeans) && mapBeans.containsKey(accountId)){
					bean = resultMap.get(accountId);
					if(BaseHelpUtils.isNullOrEmpty(bean)){
						bean = new BaseCustomProjectAccount();
						bean.setDataFromJSON(mapBeans.get(accountId).toJSON());
						bean.setLeftIntegral(BigDecimal.ZERO);
						bean.setPmPerformanceAward(BigDecimal.ZERO);
						bean.setPmPerformanceDeduct(BigDecimal.ZERO);
						bean.setProjectPerformanceRemian(BigDecimal.ZERO);
					}
					BigDecimal leftIntegral = bean.getLeftIntegral()==null?BigDecimal.ZERO:bean.getLeftIntegral();
					//获取业务类型
					int businessTypeId = e.getBusinessTypeId();
					BigDecimal payIntegral = e.getPayIntegral()==null?BigDecimal.ZERO:e.getPayIntegral();
					BigDecimal achieveIntegral = e.getAchieveIntegral()==null?BigDecimal.ZERO:e.getAchieveIntegral();
					switch (businessTypeId) {
					case pm_performance_award://项目经理绩效奖励
						bean.setPmPerformanceAward(payIntegral);
						leftIntegral = leftIntegral.subtract(payIntegral);
						break;
					case pm_performance_deduct://项目经理绩效扣除
						bean.setPmPerformanceDeduct(achieveIntegral);
						leftIntegral = leftIntegral.add(achieveIntegral);
						break;
					case project_performance_remain://项目绩效结余
						bean.setProjectPerformanceRemian(payIntegral);
						leftIntegral = leftIntegral.subtract(payIntegral);
						break;

					default:
						break;
					}
					bean.setLeftIntegral(leftIntegral);
					resultMap.put(accountId, bean);
				}
			}
			
			if(!BaseHelpUtils.isNullOrEmpty(resultMap)){
				for(Integer accountId : resultMap.keySet()){
					resultList.add(resultMap.get(accountId));
				}
			}
		}
		BaseCollection<BaseCustomProjectAccount> bc = new BaseCollection<>();
		bc.setCollections(resultList);
		return bc.toJSON(0,null);
	}
	
	
	/**
	 * 加载订单账户数据集
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String onLoadSheetAccountData(Map<String, Object> param) throws Exception{
		//获取订单编号和名称
		String sheetName = BaseHelpUtils.getStringValue(param,"sheetName");
		String sheetCode = BaseHelpUtils.getStringValue(param, "sheetCode");
		//获取开始日期和结束日期
		String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
		String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
		//获取订单ID
		int projectId = BaseHelpUtils.getIntValue(param, "projectId");
		int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
		//加载项目账户数据集
		ConditionOnLoadBusinessTypeDataOfAccount condition = new ConditionOnLoadBusinessTypeDataOfAccount();
		condition.setAccountTypeId(ACCOUNT_SHEET_ACCOUNT);
		if(projectId>0)condition.setAccountId(projectId);
		if(!BaseHelpUtils.isNullOrEmpty(startDateStr)){
			Date startDate = new Date(Long.valueOf(startDateStr));
			condition.setStartDate(startDate);
		}
		if(!BaseHelpUtils.isNullOrEmpty(endDateStr)){
			Date endDate = new Date(Long.valueOf(endDateStr));
			condition.setEndDate(endDate);
		}
		QueryOnLoadBusinessTypeDataOfAccount dao = new QueryOnLoadBusinessTypeDataOfAccount();
		BaseCollection<BaseOnLoadBusinessTypeDataOfAccount> result = dao.executeQuery(null, condition);
		List<BaseCustomSheetAccount> resultList = new ArrayList<>();
		if(!BaseHelpUtils.isNullOrEmpty(result)){
			//加载订单数据集
			Project conDao = new Project();
			conDao.unsetSelectFlags();
			conDao.setSelectProjectId(true);
			conDao.setSelectContractCode(true);
			conDao.setSelectProjectName(true);
			conDao.setConditionProjectFlag("=",1);//只检索设计项目
			conDao.setConditionPlateId(">",0);
			String sql ="";
			if(employeeId > 0){
				sql = String.format("(plate_manager_id = %1$s or department_manager_id = %2$s or project_manage_id = %3$s)", employeeId,employeeId,employeeId);
			}
			if(projectId>0)conDao.setConditionProjectId("=",projectId);
			if(!BaseHelpUtils.isNullOrEmpty(sheetCode)){
				conDao.setConditionContractCode("like", "%"+sheetCode+"%");
			}
			if(!BaseHelpUtils.isNullOrEmpty(sheetName)){
				conDao.setConditionProjectName("like", "%"+sheetName+"%");
			}
			List<BaseProject> projectList = conDao.conditionalLoad(sql);
			Map<Integer,BaseProject> mapBeans = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(projectList) && projectList.size() > 0){
				for(BaseProject e : projectList){
					mapBeans.put(e.getProjectId(),e);
				}
			}
			Map<Integer,BaseCustomSheetAccount> resultMap = new HashMap<>();
			BaseCustomSheetAccount bean = null;
			for(BaseOnLoadBusinessTypeDataOfAccount e : result.getCollections()){
				//获取合同ID
				int accountId = e.getAccountId();
				if(!BaseHelpUtils.isNullOrEmpty(mapBeans) && mapBeans.containsKey(accountId)){
					bean = resultMap.get(accountId);
					if(BaseHelpUtils.isNullOrEmpty(bean)){
						bean = new BaseCustomSheetAccount();
						bean.setDataFromJSON(mapBeans.get(accountId).toJSON());
						bean.setLeftIntegral(BigDecimal.ZERO);
						bean.setProjectPerformanceAward(BigDecimal.ZERO);
						bean.setProjectPerformanceAchieve(BigDecimal.ZERO);
						bean.setProjectPerformanceDeduct(BigDecimal.ZERO);
						bean.setProjectPerformance(BigDecimal.ZERO);
					}
					BigDecimal leftIntegral = bean.getLeftIntegral()==null?BigDecimal.ZERO:bean.getLeftIntegral();
					//获取业务类型
					int businessTypeId = e.getBusinessTypeId();
					BigDecimal payIntegral = e.getPayIntegral()==null?BigDecimal.ZERO:e.getPayIntegral();
					BigDecimal achieveIntegral = e.getAchieveIntegral()==null?BigDecimal.ZERO:e.getAchieveIntegral();
					switch (businessTypeId) {
					case project_performance_award://项目绩效奖励
						bean.setProjectPerformanceAward(achieveIntegral);
						leftIntegral = leftIntegral.add(achieveIntegral);
						break;
					case project_performance_achieve://项目绩效收入
						bean.setProjectPerformanceAchieve(achieveIntegral);
						leftIntegral = leftIntegral.add(achieveIntegral);
						break;
					case project_performance_deduct://项目绩效扣除
						bean.setProjectPerformanceDeduct(payIntegral);
						leftIntegral = leftIntegral.subtract(payIntegral);
						break;
					case project_performance://项目绩效
						bean.setProjectPerformance(payIntegral);
						leftIntegral = leftIntegral.subtract(payIntegral);
						break;

					default:
						break;
					}
					bean.setLeftIntegral(leftIntegral);
					resultMap.put(accountId, bean);
				}
			}
			
			if(!BaseHelpUtils.isNullOrEmpty(resultMap)){
				for(Integer accountId : resultMap.keySet()){
					resultList.add(resultMap.get(accountId));
				}
			}
		}
		BaseCollection<BaseCustomSheetAccount> bc = new BaseCollection<>();
		bc.setCollections(resultList);
		return bc.toJSON(0,null);
	}
	
	/**
	 * 公司账户---公司补贴---关联到部门账户
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public String onSavePlateAccountData(Map<String, Object> param) throws Exception{
		int status=-1;
		ThreadConnection.beginTransaction();
		PlateIntegralSend psDao=new PlateIntegralSend();
		BasePlateIntegralSend  baseSendBean=new BasePlateIntegralSend();
		baseSendBean.setDataFromMap(param);
		psDao.setDataFromBase(baseSendBean);
		psDao.save();
    	//获取补贴积分
    	BigDecimal sendIntegral = BaseHelpUtils.getBigDecimalValue(psDao.getSendIntegral());
    	//获取还款部门id
    	Integer plateId = BaseHelpUtils.getIntValue(psDao.getPlateId());
    	int businessId = BaseHelpUtils.getIntValue(psDao.getPlateIntegralSendId());
    	//部门账户表
    	AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY, sendIntegral,psDao.getSendDate(),psDao.getRemark(),psDao.getEmployeeId());
		ThreadConnection.commit();
		status=0;
		BaseCollection<BaseCustomSheetAccount> bc = new BaseCollection<>();
		return bc.toJSON(status,null);
	}
	
	/**
     * 获取员工的实时余额积分
     * @param employeeId
     * @return
     * @throws SQLException
     */
    public String onGetLeftIntegralOfEmployee(int employeeId) throws SQLException{
    	ConditionOnGetLeftIntegralOfEmployee condition = new ConditionOnGetLeftIntegralOfEmployee();
    	if(employeeId > 0)condition.setEmployeeId(employeeId);
    	QueryOnGetLeftIntegralOfEmployee dao = new QueryOnGetLeftIntegralOfEmployee();
    	BaseCollection<BaseOnGetLeftIntegralOfEmployee> result = dao.executeQuery(null, condition);
    	return result.toJSON();
    }
	
	public static void main(String[] args) throws UnsupportedEncodingException, SQLException {
		AccountManageProcess ss = new AccountManageProcess();
		Map param = new HashMap<>();
		param.put("plateIds","1,2,3");
		String dd = ss.onCheckIsHasParent(param);
		System.out.println(dd);
	}


	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
}
