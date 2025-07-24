package com.pomplatform.client.common;

public class ClientStaticUtils {

	/**
     * 订单状态：订单运行
     */
    public static final int PROJECT_STATUS_2 = 2;
    /**
     * 订单状态：订单未启动
     */
    public static final int PROJECT_STATUS_4 = 4;
    /**
     * 订单状态：订单无进度
     */
    public static final int PROJECT_STATUS_5 = 5;
	/**
     * 订单状态：订单暂停
     */
    public static final int PROJECT_STATUS_10 = 10;
    /**
     * 订单状态：订单结束
     */
    public static final int PROJECT_STATUS_11 = 11;
    /**
     * 订单状态：落标订单
     */
    public static final int PROJECT_STATUS_13 = 13;
    /**
     * 订单状态：订单终止—结算中
     */
    public static final int PROJECT_STATUS_14 = 14;
    /**
     * 订单状态：订单终止
     */
    public static final int PROJECT_STATUS_15 = 15;
    /**
     * 订单状态：订单收尾
     */
    public static final int PROJECT_STATUS_17 = 17;
    
    /**
     * 项目用车：1
     */
    public static final int PROJECT_USE_CAR = 1;
    /**
     * 前期项目用车：2
     */
    public static final int PRE_PROJECT_USE_CAR = 2;
    /**
     * 部门用车：3
     */
    public static final int DEPARTMENT_USE_CAR = 3;
    /**
     * 成本类型：项目成本
     */
    public static final int PROJECT_COST = 1;
    /**
     * 成本类型：前期项目成本
     */
    public static final int PRE_PROJECT_COST = 2;
    
    /**
     * 成本类型：部门成本
     */
    public static final int DEPARTMENT_COST = 3;
    /**
     * 新建的流程
     */
    public static final int PROCESS_STATUS_NEW_CREATED = 0;
    /**
     * 流程正在工作中
     */
    public static final int PROCESS_STATUS_WORKING = 1;
    /**
     * 流程被取消
     */
    public static final int PROCESS_STATUS_CANCELLED = 2;
    /**
     * 流程完成
     */
    public static final int PROCESS_STATUS_COMPLETED = 3;
    /**
     * 流程暂停，一般发生在无法准确地找到下一个执行流程的人，只能靠认为干预
     * 比如将任务放入任务池，由符合条件的人去认领，或者由主管去分配
     */
    public static final int PROCESS_STATUS_PAUSE = 4;
    /**
     * 流程被驳回
     */
    public static final int PROCESS_STATUS_REJECT = 5;
    /**
     * 项目成本状态：已结算
     */
    public static final int PROJECT_COST_SETTLED = 1;
    /**
     * 项目成本状态：未结算
     */
    public static final int PROJECT_COST_UNSETTLED = 0;
    /**
     * 项目成本状态:成本调节中
     */
    public static final int PROJECT_COST_ADJUSTING = 2;
    /**
     * 信息化中心
     */
    public static final int PLATE_ID_19 = 19;
    /**
     * 财务部
     */
    public static final int PLATE_ID_23 = 23;
    /**
     * 运营中心
     */
    public static final int PLATE_ID_17 = 17;
    /**
  	 * 删除状态：已删除
  	 */
  	public static final int HAS_DELETE = 1;
  	/**
  	 * 删除状态：未删除
  	 */
  	public static final int NO_DELETE = 0;
  	/**
  	 * 请按Ctrl+F5刷新页面后，再执行本操作
  	 */
  	public static final String WARNING = "请按Ctrl+F5刷新页面后，再执行本操作";
  	/**
     * 离职
     */
    public static final int EMPLOYEE_DIMISSION = 1;
    
    /**
     * 在职
     */
    public static final int EMPLOYEE_NORMAL = 0;
    
    /**
     * 角色：大项目经理
     */
    public static final int ROLE_CONTRACT_MANAGER = 80;
    /**
	 * 未审批
	 */
	public static final String CONTRACT_STAGE_AUDIT_STATUS_1 = "1";
	/**
	 * 已审批
	 */
	public static final String CONTRACT_STAGE_AUDIT_STATUS_2 = "2";
	/**
	 * 新建
	 */
	public static final String CONTRACT_STAGE_PROCESS_STATUS_0 = "0";
	/**
	 * 运行中
	 */
	public static final String CONTRACT_STAGE_PROCESS_STATUS_1 = "1";
	/**
	 * 完成
	 */
	public static final String CONTRACT_STAGE_PROCESS_STATUS_3 = "3";
	/**
     * 款项属性：收款/合同款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_1 = 1;
    /**
     * 款项属性：收款/保理
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_11 = 11;
    /**
     * 款项属性：收款/商票
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_13 = 13;
    /**
     * 审批节点类型：普通节点
     */
    public static final int ACTIVITY_TYPE_FLAG_NORMAL = 1;
    /**
     * 审批节点类型：任务池
     */
    public static final int ACTIVITY_TYPE_FLAG_POOL = 2;

  	/**
  	 * k3编码：其他
  	 */
  	public static final int K3_CODE_TYPE_0 = 0;
  	
  	/**
  	 * k3编码：员工
  	 */
  	public static final int K3_CODE_TYPE_1 = 1;

  	/**
  	 * k3编码：公司
  	 */
  	public static final int K3_CODE_TYPE_2 = 2;

  	/**
  	 * k3编码：部门
  	 */
  	public static final int K3_CODE_TYPE_3 = 3;

  	/**
  	 * k3编码：科目
  	 */
  	public static final int K3_CODE_TYPE_4 = 4;

  	/**
  	 * k3编码：银行账号
  	 */
  	public static final int K3_CODE_TYPE_5 = 5;

  	/**
  	 * k3编码：流程类型
  	 */
  	public static final int K3_CODE_TYPE_6 = 6;

  	/**
  	 * k3编码：收款方类型
  	 */
  	public static final int K3_CODE_TYPE_7 = 7;

  	/**
  	 * k3编码：收款单位
  	 */
  	public static final int K3_CODE_TYPE_8 = 8;
  	/**
  	 * k3编码：客户
  	 */
  	public static final int K3_CODE_TYPE_9 = 9;
  	/**
  	 * k3编码：板块区域
  	 */
  	public static final int K3_CODE_TYPE_10 = 10;
  	/**
  	 * k3编码：五险一金
  	 */
  	public static final int K3_CODE_TYPE_11 = 11;
  	/**
  	 * k3编码：工资
  	 */
  	public static final int K3_CODE_TYPE_12 = 12;
  	/**
     * 凭证类型：报销
     */
    public static final int VOUCHER_TYPE_1 = 1;
    /**
     * 凭证类型：发票
     */
    public static final int VOUCHER_TYPE_2 = 2;
    /**
     * 凭证类型：回款
     */
    public static final int VOUCHER_TYPE_3 = 3;
    /**
     * 凭证类型：收入
     */
    public static final int VOUCHER_TYPE_4 = 4;
    /**
     * 凭证类型：确认函
     */
    public static final int VOUCHER_TYPE_5 = 5;
    /**
     * 凭证类型：五险一金
     */
    public static final int VOUCHER_TYPE_6 = 6;
    /**
     * 凭证类型：工资
     */
    public static final int VOUCHER_TYPE_7 = 7;
    /**
     * 合同签约状态：已签约
     */
    public static final int CONTRACT_SIGNING_STATUS_2 = 2;
    /**
     * 报销类型：预付款申请
     */
    public static final int PROCESS_TYPE_7 = 7;
    /**
     * 报销类型：借款申请
     */
    public static final int PROCESS_TYPE_6 = 6;
    /**
     * 报销收款方类型：付款给员工
     */
    public static final int PAY_FOR_EMPLOYEE = 1;
    /**
     * 报销收款方类型：付款给收款单位
     */
    public static final int PAY_FOR_RECEIVE_UNIT = 2;
    
    /**
     * 流程按钮宽度
     */
    public static final int FLOW_IMG_WIDTH = 155;
    
    /**
     * 流程按钮高度
     */
    public static final int FLOW_IMG_HEIGHT = 80;
    /**
     * 货币种类：人民币
     */
    public static final int CURRENCY_0 = 0;
    /**
     * 借款申请
     */
    public static final String BORROW_MONEY_MANAGE = "Borrow_money_manage";
    /**
     * 预付款申请
     */
    public static final String PAY_MONEY_MANAGE = "Pay_money_manage";
    /**
     * 往来账户类型：职员
     */
    public static final int FINANCIAL_ACCOUNT_TYPE_EMPLOYEE = 1;
    /**
     * 往来账户类型：收款单位
     */
    public static final int FINANCIAL_ACCOUNT_TYPE_RECEIVE_UNIT = 2;
    /**
     * 合同状态：项目缓慢
     */
    public static final int CONTRACT_STATUS_4 = 4;
    /**
     * 合同状态：项目暂停
     */
    public static final int CONTRACT_STATUS_5 = 5;
    /**
     * 合同状态：合同运行
     */
    public static final int CONTRACT_STATUS_6 = 6;
    /**
     * 合同状态：合同暂停
     */
    public static final int CONTRACT_STATUS_8 = 8;
    /**
     * 合同状态：合同终止
     */
    public static final int CONTRACT_STATUS_11 = 11;
    /**
     * 合同状态：合同结束
     */
    public static final int CONTRACT_STATUS_12 = 12;
    /**
     * 合同状态：项目终止
     */
    public static final int CONTRACT_STATUS_14 = 14;

  	/**
  	 * 收款方：公司
  	 */
  	public static final int PAY_FOR_COMPANY = 2;
  	
  	/**
     * 出图类型:纸质出图
     */
    public static final int OUTPUT_DRAWING_TYPE_1 = 1; 
    
    /**
     * 出图类型:电子出图
     */
    public static final int OUTPUT_DRAWING_TYPE_2 = 2; 
    
    /**
     * 出图类型:纸质变更
     */
    public static final int OUTPUT_DRAWING_TYPE_3 = 3; 
    
    /**
     * 出图类型:电子变更
     */
    public static final int OUTPUT_DRAWING_TYPE_4 = 4; 
    
}
