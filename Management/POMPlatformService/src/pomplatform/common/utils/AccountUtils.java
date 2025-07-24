package pomplatform.common.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import com.pomplatform.db.bean.BaseAccount;
import com.pomplatform.db.dao.Account;
import com.pomplatform.db.dao.AccountTransaction;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.Department;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseHelpUtils;
import delicacy.connection.ThreadConnection;
import delicacy.system.dao.Employee;

public class AccountUtils {

	/**
	 * 账户等级：一级账户
	 */
	public static final int ACCOUNT_LEVEL_1 = 1;
	/**
	 * 账户等级：二级账户
	 */
	public static final int ACCOUNT_LEVEL_2 = 2;
    /**
     * 账户类型：个人
     */
    public static final int ACCOUNT_TYPE_EMPLOYEE = 1;
    /**
     * 账户类型：部门
     */
    public static final int ACCOUNT_TYPE_DEPARTMENT = 2;
    /**
     * 账户类型：公司
     */
    public static final int ACCOUNT_TYPE_COMPANY = 3;
    /**
     * 账户类型：收款单位
     */
    public static final int ACCOUNT_TYPE_RECEIEVE_UNIT = 4;
    /**
     * 账户类型：合同
     */
    public static final int ACCOUNT_TYPE_CONTRACT = 5;
    /**
     * 账户类型：订单
     */
    public static final int ACCOUNT_TYPE_PROJECT = 6;
    /**
     * 账户类型：业务部门
     */
    public static final int ACCOUNT_TYPE_PLATE = 7;
    /**
     * 账户状态：活动
     */
    public static final int ACCOUNT_STATUS_ACTIVE = 1;
    /**
     * 账户状态：冻结
     */
    public static final int ACCOUNT_STATUS_FROZEN = 2;
    /**
     * 账户状态：销户
     */
    public static final int ACCOUNT_STATUS_DESTORY = 3;
    /**
     * 账户交易业务类型：奖金发放
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_1 = 1;
    /**
     * 账户交易业务类型：提成支出
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_2 = 2;
    /**
     * 账户交易业务类型：考勤扣款
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_3 = 3;
    /**
     * 账户交易业务类型：确认积分
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_4 = 4;
    /**
     * 账户交易业务类型：分配积分
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_5 = 5;
    /**
     * 账户交易业务类型：项目结项
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_6 = 6;
    /**
     * 账户交易业务类型：资源绩效
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_7 = 7;
    /**
     * 账户交易业务类型：公司补贴
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_8 = 8;
    /**
     * 账户交易业务类型：管理项目
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_9 = 9;
    /**
     * 账户交易业务类型：运营成本
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_10 = 10;
    /**
     * 账户交易业务类型：分配收入
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_11 = 11;
    /**
     * 账户交易业务类型：公司费用
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_12 = 12;
    /**
     * 账户交易业务类型：项目绩效收入
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_13 = 13;
    /**
     * 账户交易业务类型：项目成本
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_14 = 14;
    /**
     * 账户交易业务类型：积分回收
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_15 = 15;
    /**
     * 账户交易业务类型：转岗结算支出
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_16 = 16;
    /**
     * 账户交易业务类型：项目经理绩效奖励
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_17 = 17;
    /**
     * 账户交易业务类型：公司还款
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_18 = 18;
    /**
     * 账户交易业务类型：公司借款
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_19 = 19;
    /**
     * 账户交易业务类型：人工成本
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_20 = 20;
    /**
     * 账户交易业务类型：绩效奖金
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_21 = 21;
    /**
     * 账户交易业务类型：协作费用
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_22 = 22;
    /**
     * 账户交易业务类型：项目补贴
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_23 = 23;
    /**
     * 账户交易业务类型：销售积分
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_24 = 24;
    /**
     * 账户交易业务类型：合同变更
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_25 = 25;
    /**
     * 账户交易业务类型：转岗结算收入
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_26 = 26;
    /**
     * 账户交易业务类型：项目绩效支出
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_27 = 27;
    /**
     * 账户交易业务类型：研发项目
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_28 = 28;
    /**
     * 账户交易业务类型：协作支出
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_29 = 29;
    /**
     * 账户交易业务类型：奖金补贴
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_30 = 30;
    /**
     * 账户交易业务类型：提成收入
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_31 = 31;
    /**
     * 账户交易业务类型：积分还款
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_32 = 32;
    /**
     * 账户交易业务类型：项目经理绩效扣除
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_33 = 33;
    /**
     * 账户交易业务类型：积分借款
     */
    public static final int ACCOUNT_BUSSINESS_TYPE_34 = 34;
    
    public static boolean hasAccount = false;
	/**
	 * 
	 * @param needTransaction	是否需要开启事务
	 * @param accountId	账户ID
	 * @param accountType	账户类型
	 * @param ownerId	账户拥有者ID
	 * @param businessTypeId	账户交易业务类型
	 * @param businessId	账户交易业务主表ID
	 * @param detailBusinessId	账户交易业务子表ID	
	 * @param standardCurrency	本位币
	 * @param isDebit	是否为借方
	 * @param recordTime	记录时间
	 * @param operator	操作人
	 * @param remark	备注
	 * @throws Exception
	 */
	public static void insertAccountTransaction(boolean needTransaction, Integer accountId, Integer accountType, Integer ownerId, Integer businessTypeId, Integer businessId, Integer detailBusinessId, BigDecimal standardCurrency, boolean isDebit, Date recordTime, Integer operator, String remark) throws Exception{
		if(!hasAccount) {
			return;
		}
		insertAccountTransaction(needTransaction, accountId, accountType, ownerId, businessTypeId, businessId, detailBusinessId, standardCurrency, BigDecimal.ONE, standardCurrency, isDebit, recordTime, new Date(), operator, remark);
	}
	
	/**
	 * 
	 * @param needTransaction	是否需要开启事务
	 * @param accountId	账户ID
	 * @param accountType	账户类型
	 * @param ownerId	账户拥有者ID
	 * @param businessTypeId	账户交易业务类型
	 * @param businessId	账户交易业务ID
	 * @param originalCurrency	原币
	 * @param exchangeRate	汇率
	 * @param standardCurrency	本位币
	 * @param isDebit	是否为借方
	 * @param recordTime	记录时间
	 * @param operateTime	操作时间
	 * @param operator	操作人
	 * @param remark	备注
	 * @throws Exception
	 */
	public static void insertAccountTransaction(boolean needTransaction, Integer accountId, Integer accountType, Integer ownerId, Integer businessTypeId, Integer businessId, Integer detailBusinessId, BigDecimal originalCurrency, BigDecimal exchangeRate, BigDecimal standardCurrency, boolean isDebit, Date recordTime, Date operateTime, Integer operator, String remark) throws Exception{
		if(!hasAccount) {
			return;
		}
		if(needTransaction) {
			ThreadConnection.beginTransaction();
		}
		try {
			if(null == accountId && (null == accountType || null == ownerId)) {
				throw new Exception("账户信息不全");
			}
			if(null == standardCurrency) {
				throw new Exception("交易金额不能为空");
			}
			Account accountDao = new Account();
			BaseAccount accountBean = null;
			if(null == accountId) {
				accountDao.setConditionAccountType("=", accountType);
				accountDao.setConditionOwnerId("=", ownerId);
				accountDao.setConditionIsDefault("=", true);
				if(isDebit) {
					accountDao.setConditionStatus("!=", ACCOUNT_STATUS_DESTORY);
				}else {
					accountDao.setConditionStatus("=", ACCOUNT_STATUS_ACTIVE);
				}
				accountBean = accountDao.executeQueryOneRow();
				if(null == accountBean || null == accountBean.getAccountId()) {
					accountDao.setConditionIsDefault("=", false);
					accountBean = accountDao.executeQueryOneRow();
					if(null == accountBean || null == accountBean.getAccountId()) {
						throw new Exception("无法找到默认账户信息");
					}
				}
				accountId = accountBean.getAccountId();
			}
			if(null == accountBean) {
				accountDao.clear();
				accountDao.setConditionAccountId("=", accountId);
				accountBean = accountDao.executeQueryOneRow();
				if(null == accountBean) {
					throw new Exception("根据账户ID，无法找到账户");
				}
			}
			BigDecimal finalAmount = null;
			finalAmount = BaseHelpUtils.getBigDecimalValue(accountBean.getBalance());
			AccountTransaction atDao = new AccountTransaction();
			atDao.setAccountId(accountId);
			atDao.setBusinessTypeId(businessTypeId);
			atDao.setBusinessId(businessId);
			atDao.setDetailBusinessId(detailBusinessId);
			atDao.setExchangeRate(exchangeRate);
			if(null == recordTime) {
				atDao.setRecordTime(new Date());
			}else {
				atDao.setRecordTime(recordTime);
			}
			if(null == operateTime) {
				atDao.setOperateTime(new Date());
			}else {
				atDao.setOperateTime(operateTime);
			}
			atDao.setOperateEmployeeId(operator);
			atDao.setRemark(remark);
			if(isDebit) {
				finalAmount = finalAmount.add(standardCurrency);
				atDao.setStandardCurrencyDebit(standardCurrency);
				atDao.setOriginalCurrencyDebit(originalCurrency);
			}else {
				finalAmount = finalAmount.subtract(standardCurrency);
				atDao.setStandardCurrencyCredit(standardCurrency);
				atDao.setOriginalCurrencyCredit(originalCurrency);
			}
			atDao.setBalance(finalAmount);
			accountDao.clear();
			accountDao.setConditionAccountId("=", accountId);
			accountDao.setBalance(finalAmount);
			accountDao.conditionalUpdate();
			atDao.save();
			if(needTransaction) {
				ThreadConnection.commit();
			}
		}catch (Exception e) {
			if(needTransaction) {
				ThreadConnection.rollback();
			}
			throw e;
		}
	}
	
	/**
	 * 生成账户编号
	 * @param accountType	账户类型
	 * @param ownerId		账户的实体ID
	 * @return
	 * @throws Exception
	 */
	public static String generateAccountNo(Integer accountType, Integer ownerId) throws Exception{
		if(!hasAccount) {
			return "";
		}
		if(null == accountType || null == ownerId) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		String unknownCode = "999";
		switch(accountType) {
		case ACCOUNT_TYPE_COMPANY:
			sb.append("CO").append(String.format("%03d", ownerId)).append(unknownCode);
			break;
		case ACCOUNT_TYPE_DEPARTMENT:
			sb.append("DP").append(unknownCode);
			Department depDao = new Department();
			depDao.unsetSelectFlags();
			depDao.setSelectPlateId(true);
			depDao.setDepartmentId(ownerId);
			if(!depDao.load() || null == depDao.getPlateId()) {
				return null;
			}
			sb.append(String.format("%03d", depDao.getPlateId()));
			break;
		case ACCOUNT_TYPE_PLATE:
			sb.append("PL").append(unknownCode).append(String.format("%03d", ownerId));
			break;
		case ACCOUNT_TYPE_RECEIEVE_UNIT:
			sb.append("RU").append(unknownCode).append(unknownCode);
			break;
		case ACCOUNT_TYPE_EMPLOYEE:
			sb.append("EP");
			Employee eDao = new Employee();
			eDao.unsetSelectFlags();
			eDao.setSelectCompanyId(true);
			eDao.setSelectPlateId(true);
			eDao.setEmployeeId(ownerId);
			if(!eDao.load() || null == eDao.getCompanyId() || null == eDao.getPlateId()) {
				return null;
			}
			sb.append(String.format("%03d", eDao.getCompanyId())).append(String.format("%03d", eDao.getPlateId()));
			break;
		case ACCOUNT_TYPE_CONTRACT:
			sb.append("CT");
			Contract cDao = new Contract();
			cDao.unsetSelectFlags();
			cDao.setSelectSigningCompanyName(true);
			cDao.setContractId(ownerId);
			if(!cDao.load() || null == cDao.getSigningCompanyName()) {
				return null;
			}
			sb.append(String.format("%03d", cDao.getSigningCompanyName())).append(unknownCode);
			break;
		case ACCOUNT_TYPE_PROJECT:
			sb.append("PJ");
			Project pDao = new Project();
			pDao.unsetSelectFlags();
			pDao.setSelectPlateId(true);
			pDao.setSelectContractId(true);
			pDao.setProjectId(ownerId);
			if(!pDao.load() || null == pDao.getPlateId()) {
				return null;
			}
			if(null == pDao.getContractId()) {
				sb.append(unknownCode);
			}else {
				Contract ctDao = new Contract();
				ctDao.unsetSelectFlags();
				ctDao.setSelectSigningCompanyName(true);
				ctDao.setContractId(pDao.getContractId());
				if(ctDao.load() && null != ctDao.getSigningCompanyName()) {
					sb.append(String.format("%03d", ctDao.getSigningCompanyName()));
				}else {
					sb.append(unknownCode);
				}
			}
			sb.append(String.format("%03d", pDao.getPlateId()));
			break;
		default:
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String dateCode = format.format(new Date());
		Account accountDao = new Account();
		accountDao.setConditionAccountCode("like", "%" + dateCode + "%");
		int num = accountDao.countRows() + 1;
		return sb.toString() + dateCode + String.format("%04d", num);
	}
	
	/**
	 * 生成账户编号
	 * @param accountType	账户类型
	 * @param ownerId		账户的实体ID
	 * @param accountLevel	账户级别
	 * @param accountName	账户名称
	 * @param operator		操作人ID
	 * @param canSum		该账号数据是否汇总到ownerId
	 * @return
	 * @throws Exception
	 */
	public static Integer createAccount(Integer accountType, Integer ownerId, Integer accountLevel, String accountName, Integer operator, boolean canSum) throws Exception{
		if(!hasAccount) {
			return null;
		}
		if(null == accountType || null == ownerId) {
			throw new Exception(String.format("参数不全[accountType:%1$s, objId:%2$s]，无法创建账户", accountType, ownerId));
		}
		String accountNo = generateAccountNo(accountType, ownerId);
		if(BaseHelpUtils.isNullOrEmpty(accountNo)) {
			throw new Exception("无法生成账户编号");
		}
		Account accountDao = new Account();
		if(canSum) {
			accountDao.setConditionAccountType("=", accountType);
			accountDao.setConditionOwnerId("=", ownerId);
			accountDao.setConditionIsDefault("=", true);
			accountDao.setConditionStatus("!=", ACCOUNT_STATUS_DESTORY);
			if(accountDao.countRows() > 0) {
				accountDao.clear();
				accountDao.setIsDefault(false);
			}else {
				accountDao.clear();
				accountDao.setIsDefault(true);
			}
		}else {
			accountDao.setIsDefault(false);
		}
		accountDao.setCanSum(canSum);
		accountDao.setAccountCode(accountNo);
		accountDao.setAccountName(accountName);
		accountDao.setLeavel(null == accountLevel ? ACCOUNT_LEVEL_1 : accountLevel);
		accountDao.setAccountType(accountType);
		accountDao.setOwnerId(ownerId);
		accountDao.setStatus(ACCOUNT_STATUS_ACTIVE);
		accountDao.setBalance(BigDecimal.ZERO);
		accountDao.setFrozenAmount(BigDecimal.ZERO);
		accountDao.setOperateEmployeeId(operator);
		accountDao.setCreateTime(new Date());
		accountDao.save();
		return accountDao.getAccountId();
	}
	
	/**
	 * 根据账户ID销户
	 * @param accountId		账户ID
	 * @param operator		销户操作人
	 * @throws Exception
	 */
	public static void destoryAccount(Integer accountId, Integer operator) throws Exception{
		if(!hasAccount) {
			return;
		}
		destoryAccount(accountId, null, null, operator);
	}
	
	/**
	 * 根据账户类型和账户拥有者ID来进行销户操作
	 * @param accountType	账户类型
	 * @param ownerId		账户拥有者ID
	 * @param operator		销户操作人
	 * @throws Exception
	 */
	public static void destoryAccount(Integer accountType, Integer ownerId, Integer operator) throws Exception{
		if(!hasAccount) {
			return;
		}
		destoryAccount(null, accountType, ownerId, operator);
	}
	
	/**
	 * 销户
	 * @param accountId		账户ID
	 * @param accountType	账户类型
	 * @param ownerId		账户拥有者ID
	 * @param operator		销户操作人
	 * @throws Exception
	 */
	public static void destoryAccount(Integer accountId, Integer accountType, Integer ownerId, Integer operator) throws Exception{
		if(!hasAccount) {
			return;
		}
		if(null != accountId || (null != accountType && null != ownerId)) {
			if(null != accountId) {
				Account dao = new Account();
				dao.setAccountId(accountId);
				if(!dao.load()) {
					throw new Exception("根据账户ID无法获取账户信息，无法销户");
				}
				if(Objects.equals(dao.getStatus(), ACCOUNT_STATUS_DESTORY)) {
					//如果该账户已经注销了，则不做任何操作
					return;
				}
				dao.setStatus(ACCOUNT_STATUS_DESTORY);
				if(null != operator) {
					dao.setDestoryEmployeeId(operator);
				}
				dao.setDestoryTime(new Date());
				dao.update();
			}else {
				Account dao = new Account();
				dao.setConditionAccountType("=", accountType);
				dao.setConditionOwnerId("=", ownerId);
				dao.setConditionStatus("!=", ACCOUNT_STATUS_DESTORY);
				dao.setStatus(ACCOUNT_STATUS_DESTORY);
				if(null != operator) {
					dao.setDestoryEmployeeId(operator);
				}
				dao.setDestoryTime(new Date());
				dao.conditionalUpdate();
			}
		}else {
			throw new Exception(String.format("参数不全[accountId:%1$s, accountType:%2$s, ownerId:%3$s]，无法删除账户", accountId, accountType, ownerId));
		}
	}
	
}
