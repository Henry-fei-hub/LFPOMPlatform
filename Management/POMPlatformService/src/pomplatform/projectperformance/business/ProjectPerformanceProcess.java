package pomplatform.projectperformance.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseProjectPerformance;
import com.pomplatform.db.dao.ProjectPerformance;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.account.bean.BaseOnLoadLeftIntegralOfAccount;
import pomplatform.account.bean.ConditionOnLoadLeftIntegralOfAccount;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.account.query.QueryOnLoadLeftIntegralOfAccount;
import pomplatform.common.utils.StaticUtils;

public class ProjectPerformanceProcess implements GenericProcessor {
    //操作类型
    private static final String OPT_TYPE = "optType";
    //查看是否有草稿
    private static final String HAS_A_DRAFT = "hasADraft";
    //保存绩效信息
    private static final String SAVE_PERFORMANCE = "savePerformance";
    //查询品质基金的剩余积分
    private static final String GET_LEFT_INTEGER = "getLeftInteger";
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria)); 
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(params,OPT_TYPE);
        if(HAS_A_DRAFT.equals(optType)){
        	return hasADraft(params);
        }else if(SAVE_PERFORMANCE.equals(optType)){
        	return savePerformance(params);
        }else if(GET_LEFT_INTEGER.equals(optType)){
        	return getLeftInteger(params);
        }
        return null;
    }
    
    /**
     * 查看是否有草稿
     * @param params
     * @return
     * @throws Exception
     */
    public String hasADraft(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseProjectPerformance> bc = new BaseCollection<>();
    	if(null != params && !params.isEmpty()){
    		int contractId = BaseHelpUtils.getIntValue(params.get("contractId"));
    		int projectId = BaseHelpUtils.getIntValue(params.get("projectId"));
    		int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
    		int businessType = BaseHelpUtils.getIntValue(params.get("businessType"));
    		int performanceFlag = BaseHelpUtils.getIntValue(params.get("performanceFlag"));
			ProjectPerformance dao = new ProjectPerformance();
			if(contractId > 0){
				dao.setConditionContractId("=", contractId);
				if(projectId > 0){
					dao.setConditionProjectId("=", projectId);
				}
				if(employeeId > 0){
					dao.setConditionEmployeeId("=", employeeId);
				}
				if(businessType > 0){
					dao.setConditionBusinessType("=", businessType);
				}
				if(performanceFlag > 0){
					dao.setConditionPerformanceFlag("=", performanceFlag);
				}
				dao.setConditionIsSubmit("=", false);
				List<BaseProjectPerformance> list = dao.conditionalLoad();
				if(null != list && !list.isEmpty()){
					bc.setCollections(list);
					return bc.toJSON();
				}
			}
    	}
    	return bc.toJSON(-1, null);
	}
    
    /**
     * 保存绩效信息
     * @param params
     * @return
     * @throws Exception
     */
    public String savePerformance(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseProjectPerformance> bc = new BaseCollection<>();
    	BaseProjectPerformance bean = new BaseProjectPerformance();
    	Date date = new Date();
		bean.setDataFromMap(params);
		bean.setOperateTime(date);
		ProjectPerformance dao = new ProjectPerformance();
		ThreadConnection.beginTransaction();
		if(bean.getIsSubmit()){
			//只对想要提交的数据进行验证
			if(bean.getBusinessType().equals(StaticUtils.PERFORMANCE_BUSINESS_TYPE_1)){
				//项目经理绩效
				if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_1)){
					//惩罚
					dao.setConditionContractId("=", bean.getContractId());
					dao.setConditionBusinessType("=", StaticUtils.PERFORMANCE_BUSINESS_TYPE_1);
					dao.setConditionPerformanceFlag("=", StaticUtils.PERFORMANCE_FLAG_1);
					dao.setConditionIsSubmit("=", true);
					dao.unsetSelectFlags();
					dao.setSelectPerformanceIntegral(true);
					List<BaseProjectPerformance> list = dao.conditionalLoad();
					BigDecimal integral = BigDecimal.ZERO;
					for(BaseProjectPerformance obj : list){
						integral = integral.add(obj.getPerformanceIntegral());
					}
					if(bean.getIntegral().subtract(integral).compareTo(bean.getPerformanceIntegral()) < 0){
						return bc.toJSON(-1, "本次能扣除的积分上限为："+bean.getIntegral().subtract(integral));
					}
				}else if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_2)){
					//奖励
					ConditionOnLoadLeftIntegralOfAccount condition = new ConditionOnLoadLeftIntegralOfAccount();
					condition.setAccountTypeId(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT);
					condition.setAccountId(0);
					QueryOnLoadLeftIntegralOfAccount query = new QueryOnLoadLeftIntegralOfAccount();
					BaseCollection<BaseOnLoadLeftIntegralOfAccount> collection = query.executeQuery(null, condition);
					BigDecimal integral = BigDecimal.ZERO;
					if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
						integral = collection.getCollections().get(0).getLeftIntegral();
					}
					if(integral.compareTo(bean.getPerformanceIntegral()) < 0){
						return bc.toJSON(-1, "本次能奖励的积分上限为："+integral);
					}
				}else{
					return bc.toJSON(-1, "绩效类型错误");
				}
			}else if(bean.getBusinessType().equals(StaticUtils.PERFORMANCE_BUSINESS_TYPE_2)){
				//订单绩效
				if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_1)){
					//惩罚
					dao.setConditionProjectId("=", bean.getProjectId());
					dao.setConditionBusinessType("=", StaticUtils.PERFORMANCE_BUSINESS_TYPE_2);
					dao.setConditionPerformanceFlag("=", StaticUtils.PERFORMANCE_FLAG_1);
					dao.setConditionIsSubmit("=", true);
					dao.unsetSelectFlags();
					dao.setSelectPerformanceIntegral(true);
					List<BaseProjectPerformance> list = dao.conditionalLoad();
					BigDecimal integral = BigDecimal.ZERO;
					for(BaseProjectPerformance obj : list){
						integral = integral.add(obj.getPerformanceIntegral());
					}
					if(bean.getIntegral().subtract(integral).compareTo(bean.getPerformanceIntegral()) < 0){
						return bc.toJSON(-1, "本次能扣除的积分上限为："+bean.getIntegral().subtract(integral));
					}
				}else if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_2)){
					//奖励
					ConditionOnLoadLeftIntegralOfAccount condition = new ConditionOnLoadLeftIntegralOfAccount();
					condition.setAccountTypeId(AccountManageProcess.ACCOUNT_PROJECT_ACCOUNT);
					condition.setAccountId(bean.getContractId());
					QueryOnLoadLeftIntegralOfAccount query = new QueryOnLoadLeftIntegralOfAccount();
					BaseCollection<BaseOnLoadLeftIntegralOfAccount> collection = query.executeQuery(null, condition);
					BigDecimal integral = BigDecimal.ZERO;
					if(null != collection && null != collection.getCollections() && !collection.getCollections().isEmpty()){
						integral = collection.getCollections().get(0).getLeftIntegral();
					}
					if(integral.compareTo(bean.getPerformanceIntegral()) < 0){
						return bc.toJSON(-1, "本次能奖励的积分上限为："+integral);
					}
				}else{
					return bc.toJSON(-1, "绩效类型错误");
				}
			}else{
				return bc.toJSON(-1, "业务类型错误");
			}
		}
		dao.clear();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.isPrimaryKeyNull()) { 
			dao.setDataFromBase(bean); 
			dao.save(); 
		}else if(dao.load()) {
			dao.setDataFromBase(bean); 
			dao.update(); 
		}
		if(bean.getIsSubmit()){
			int businessId = dao.getProjectPerformanceId();
			BigDecimal integral = bean.getPerformanceIntegral();
			int operator = bean.getOperateEmployeeId();
			String remark = bean.getRemark();
			if(bean.getBusinessType().equals(StaticUtils.PERFORMANCE_BUSINESS_TYPE_1)){
				//项目经理绩效
				if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_1)){
					//惩罚
					//个人账户(项目经理)支出,品质基金账户收入
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT, 0, businessId, AccountManageProcess.pm_performance_deduct, integral, remark, operator);
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_EMP_ACCOUNT, bean.getEmployeeId(), businessId, AccountManageProcess.pm_performance_deduct, integral, remark, operator);
					AccountManageProcess.onSaveEmployeeAccount(bean.getEmployeeId(), businessId, AccountManageProcess.EMP_BT_PM_PERFORMANCE_DEDUCT, integral, bean.getRecordDate(), remark, operator);
				}else if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_2)){
					//奖励
					//品质基金账户支出,个人账户(项目经理)收入
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT, 0, businessId, AccountManageProcess.pm_performance_award, integral, remark, operator);
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_EMP_ACCOUNT, bean.getEmployeeId(), businessId, AccountManageProcess.pm_performance_award, integral, remark, operator);
					AccountManageProcess.onSaveEmployeeAccount(bean.getEmployeeId(), businessId, AccountManageProcess.EMP_BT_PM_PERFORMANCE_AWARD, integral, bean.getRecordDate(), remark, operator);
				}else{
					return bc.toJSON(-1, "绩效类型错误");
				}
			}else if(bean.getBusinessType().equals(StaticUtils.PERFORMANCE_BUSINESS_TYPE_2)){
				//订单绩效
				if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_1)){
					//惩罚
					//订单账户支出,项目账户收入
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_PROJECT_ACCOUNT, bean.getContractId(), businessId, AccountManageProcess.project_performance_deduct, integral, remark, operator);
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_SHEET_ACCOUNT, bean.getProjectId(), businessId, AccountManageProcess.project_performance_deduct, integral, remark, operator);
				}else if(bean.getPerformanceFlag().equals(StaticUtils.PERFORMANCE_FLAG_2)){
					//奖励
					//项目账户支出,订单账户收入
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_PROJECT_ACCOUNT, bean.getContractId(), businessId, AccountManageProcess.project_performance_award, integral, remark, operator);
					AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_SHEET_ACCOUNT, bean.getProjectId(), businessId, AccountManageProcess.project_performance_award, integral, remark, operator);
				}else{
					return bc.toJSON(-1, "绩效类型错误");
				}
			}else{
				return bc.toJSON(-1, "业务类型错误");
			}
		}
		ThreadConnection.commit();
    	return bc.toJSON();
	}
    
    /**
     * 查询品质基金的剩余积分
     * @param params
     * @return
     * @throws Exception
     */
    public String getLeftInteger(Map<String, Object> params) throws Exception{
    	BaseCollection<BaseOnLoadLeftIntegralOfAccount> bc = new BaseCollection<>();
		ConditionOnLoadLeftIntegralOfAccount condition = new ConditionOnLoadLeftIntegralOfAccount();
		condition.setAccountTypeId(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT);
		condition.setAccountId(0);
		QueryOnLoadLeftIntegralOfAccount query = new QueryOnLoadLeftIntegralOfAccount();
		bc = query.executeQuery(null, condition);
		return bc.toJSON();
    }
}
