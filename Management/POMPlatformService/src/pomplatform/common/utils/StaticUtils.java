package pomplatform.common.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.pomplatform.db.bean.BaseSystemConfig;

/**
 *
 * @author lxf
 */
public class StaticUtils {
	//设置系统配置参数
	public static Map<Integer, BaseSystemConfig> configMap = new HashMap<>();


	/**
	 * 日志类型（system_logs）：项目无进度
	 */
	public static final Integer PROJECT_NO_PROGRESS = 5;

	/**
	 * 流程节点类型：处理节点
	 */
	public static final Integer ACTIVITY_TYPE_HANDEL = 3;
	/**
	 * 流程节点名称：
	 */
	public static final String NODE_NAME_ONE = "财务会计";
	/**
	 * 系统配置参数：企业微信配置信息
	 */
	public static final Integer CONFIG_TYPE_1 = 1;
	/**
	 * 系统配置参数：企业邮箱配置信息
	 */
	public static final Integer CONFIG_TYPE_2 = 2;
	/**
	 * 系统配置参数：发送邮件配置信息
	 */
	public static final Integer CONFIG_TYPE_3 = 3;
	/**
	 * 系统配置参数：考勤计算配置信息
	 */
	public static final Integer CONFIG_TYPE_4 = 4;
	/**
	 * 系统配置参数：手机短息配置信息
	 */
	public static final Integer CONFIG_TYPE_5 = 5;
	/**
	 * 系统配置参数：考勤设备通讯配置信息
	 */
	public static final Integer CONFIG_TYPE_6 = 6;

	/**
	 * 系统配置参数：超级密码配置信息
	 */
	public static final Integer CONFIG_TYPE_7 = 7;
	/**
	 * 离职申请信息配置
	 */
	public static final Integer CONFIG_TYPE_9 = 9;
	public static final Integer CONFIG_TYPE_10 = 10;
    //秘钥键值(对应数据库系统表的ID值)
    public static final Integer SYSTEM_KEY = 2;
    //秘钥键值(页面数据加密)
    public static final Integer SYSTEM_KEY2 = 26;
    /**
     * 投标立项
     */
    public static final Integer PROJECT_BASE_ON_1 = 1;

    /**
     * 合同立项
     */
    public static final Integer PROJECT_BASE_ON_2 = 2;

    /**
     * 委托函立项
     */
    public static final Integer PROJECT_BASE_ON_3 = 3;

    /**
     * 方案比选立项
     */
    public static final Integer PROJECT_BASE_ON_4 = 4;

    /**
     * 客户
     */
    public static final Integer CLIENT_ROLE_0 = 0;

    /**
     * 建筑设计单位联系人
     */
    public static final Integer CLIENT_ROLE_1 = 1;

    /**
     * 签约公司：深圳市杰恩创意设计股份有限公司
     */
    public static final int SIGN_COMPANY_0 = 0;

    /**
     * 签约公司：深圳市博普森机电顾问有限公司
     */
    public static final int SIGN_COMPANY_1 = 1;

    /**
     * 签约公司：姜峰设计（深圳）有限公司
     */
    public static final int SIGN_COMPANY_2 = 2;

    /**
     * 签约公司：深圳杰加设计有限公司
     */
    public static final int SIGN_COMPANY_3 = 3;

    /**
     * 签约公司：深圳市杰恩创意设计股份有限公司武汉分公司
     */
    public static final int SIGN_COMPANY_4 = 4;
    /**
     * 签约公司：上海姜峰室内设计有限公司
     */
    public static final int SIGN_COMPANY_5 = 5;

    /**
     * 签约公司：北京姜峰室内设计有限公司
     */
    public static final int SIGN_COMPANY_6 = 6;

    /**
     * 签约公司：大连姜峰设计有限公司
     */
    public static final int SIGN_COMPANY_7 = 7;

    /**
     * 签约公司：杰拓设计国际有限公司
     */
    public static final int SIGN_COMPANY_8 = 8;

    /**
     * 签约公司：姜峰室内设计香港有限公司
     */
    public static final int SIGN_COMPANY_9 = 9;

    /**
     * 签约公司：深圳市杰恩创意设计股份有限公司大连分公司
     */
    public static final int SIGN_COMPANY_10 = 10;

    /**
     * 签约公司：深圳市杰恩创意设计股份有限公司北京分公司
     */
    public static final int SIGN_COMPANY_12 = 12;

    /**
     * 签约公司：深圳市杰恩创意设计股份有限公司上海分公司
     */
    public static final int SIGN_COMPANY_13 = 13;


    /**
     * 项目等级：特级
     */
    public static final Integer PROJECT_LEVEL_1 = 1;

    /**
     * 项目等级：一级
     */
    public static final Integer PROJECT_LEVEL_2 = 2;

    /**
     * 项目等级：二级
     */
    public static final Integer PROJECT_LEVEL_3 = 3;

    /**
     * 项目等级：三级
     */
    public static final Integer PROJECT_LEVEL_4 = 4;

    /**
     * 项目等级：四级
     */
    public static final Integer PROJECT_LEVEL_5 = 5;

    /**
     * 项目等级：其他
     */
    public static final Integer PROJECT_LEVEL_6 = 6;

    /**
     * 项目等级：精品项目
     */
    public static final Integer PROJECT_LEVEL_7 = 7;

    /**
     * 离职
     */
    public static final Integer EMPLOYEE_DIMISSION = 1;

    /**
     * 在职
     */
    public static final Integer EMPLOYEE_NORMAL = 0;

    /**
     * 主项目的项目营销专员
     */
    public static final int RELATION_1 = 1;

    /**
     * 主项目的项目营销团队负责人
     */
    public static final int RELATION_2 = 2;

    /**
     * 主项目的项目经理
     */
    public static final int RELATION_3 = 3;

    /**
     * 主项目的项目主管领导
     */
    public static final int RELATION_4 = 4;

    /**
     * 主项目的项目负责人
     */
    public static final int RELATION_5 = 5;

    /**
     * 主项目的项目营销专员的ECMC roleId
     */
    public static final int RELATION_1_ECMC_ROLE_ID = 190;

    /**
     * 主项目的项目营销团队负责人的ECMC roleId
     */
    public static final int RELATION_2_ECMC_ROLE_ID = 200;

    /**
     * 主项目的项目经理的ECMC roleId
     */
    public static final int RELATION_3_ECMC_ROLE_ID = 187;

    /**
     * 主项目的项目主管领导的ECMC roleId
     */
    public static final int RELATION_4_ECMC_ROLE_ID = 4;

    /**
     * 主项目的项目设计总监的ECMC roleId
     */
    public static final int RELATION_188_ECMC_ROLE_ID = 188;

    /**
     * 未审核通过
     */
    public static final Integer FLOW_STATUS_0 = 0;

    /**
     * 审核通过
     */
    public static final Integer FLOW_STATUS_1 = 1;

    /**
     * 通过ECMC同步项目后自动创建合同的合同状态
     */
    public static final Integer FLOW_STATUS_99 = 99;

    /**
     * 项目类别：方案
     */
    public static final int PROJECT_TYPE_1 = 1;

    /**
     * 项目类别：深化
     */
    public static final int PROJECT_TYPE_2 = 2;

    /**
     * 项目类别：方案+深化
     */
    public static final int PROJECT_TYPE_3 = 3;

    /**
     * 项目类别：机电灯光普通配合
     */
    public static final int PROJECT_TYPE_4 = 4;

    /**
     * 项目类别：机电二次设计
     */
    public static final int PROJECT_TYPE_5 = 5;

    /**
     * 项目类别：灯光设计
     */
    public static final int PROJECT_TYPE_6 = 6;

    /**
     * 项目类别：导向标识
     */
    public static final int PROJECT_TYPE_7 = 7;

    /**
     * 项目类别：陈设设计
     */
    public static final int PROJECT_TYPE_8 = 8;

    /**
     * 项目类别：采买
     */
    public static final int PROJECT_TYPE_9 = 9;

    /**
     * 项目类别：外包
     */
    public static final int PROJECT_TYPE_10 = 10;

    /**
     * 项目类别：智能化
     */
    public static final int PROJECT_TYPE_11 = 11;

    /**
     * 项目类别：机电顾问
     */
    public static final int PROJECT_TYPE_12 = 12;

    /**
     * 项目类别：现场配合
     */
    public static final int PROJECT_TYPE_13 = 13;

    /**
     * 项目类别：深化+现场配合
     */
    public static final int PROJECT_TYPE_14 = 14;

    /**
     * 项目类别：方案+深化+现场配合
     */
    public static final int PROJECT_TYPE_15 = 15;

    /**
     * 项目类别：项目管理
     */
    public static final int PROJECT_TYPE_16 = 16;

    /**
     * 项目类别：物料费
     */
    public static final int PROJECT_TYPE_27 = 27;

    /**
     * 项目类别：采买成本
     */
    public static final int PROJECT_TYPE_30 = 30;

    /**
     * 项目类别：条线管理
     */
    public static final int PROJECT_TYPE_33 = 33;

    /**
     * 项目类别：部门预留
     */
    public static final int PROJECT_TYPE_88 = 88;

    /**
     * 精装
     */
    public static final int DECORATION_STATUS_0 = 0;
    /**
     * 简装
     */
    public static final int DECORATION_STATUS_1 = 1;

    /**
     * 业务类别：商业
     */
    public static final int BUSINESS_TYPE_1 = 1;

    /**
     * 业务类别：酒店
     */
    public static final int BUSINESS_TYPE_2 = 2;

    /**
     * 业务类别：办公
     */
    public static final int BUSINESS_TYPE_3 = 3;

    /**
     * 业务类别：轨道交通
     */
    public static final int BUSINESS_TYPE_4 = 4;

    /**
     * 业务类别：医养
     */
    public static final int BUSINESS_TYPE_5 = 5;

    /**
     * 业务类别：公共建筑
     */
    public static final int BUSINESS_TYPE_6 = 6;

    /**
     * 业务类别：综合体
     */
    public static final int BUSINESS_TYPE_7 = 7;

    /**
     * 业务类别：采买
     */
    public static final int BUSINESS_TYPE_91 = 91;

    /**
     * 业务类别：其他
     */
    public static final int BUSINESS_TYPE_99 = 99;

    /**
     * 业务类别：住宅
     */
    public static final int BUSINESS_TYPE_8 = 8;

    /**
     * 合同信息初始状态
     */
    public static final int MAIN_CONTART_FLOW_ZERO = 0;

    /**
     * 承接部门
     */
    public static final int MAIN_CONTART_FLOW_ONE = 1;

    /**
     * 运营价格
     */
    public static final int MAIN_CONTART_FLOW_TWO = 2;

    /**
     * 价格审核
     */
    public static final int MAIN_CONTART_FLOW_THREE = 3;

    /**
     * 奖金发放审核状态：未处理
     */
    public static final int BONUS_PAYMENT_NO_DEAL = 0;

    /**
     * 奖金发放审核状态：审核通过
     */
    public static final int BONUS_PAYMENT_AGREE = 1;

    /**
     * 奖金发放审核状态：审核不通过
     */
    public static final int BONUS_PAYMENT_DISAGREE = 2;

    /**
     * 事业部负责人积分回收
     */
    public static final int PLATE_ACHIEVE_INTEGRAL_RETURN = 1;
    /**
     * 项目成本状态:已结算
     */
    public static final int SETTLEMENT_STATUS_YES = 1;
    /**
     * 项目成本状态:未结算
     */
    public static final int SETTLEMENT_STATUS_NO = 0;
    /**
     * 项目成本状态:成本调节中
     */
    public static final int SETTLEMENT_STATUS_ADJUSTING = 2;
    /**
     * 报价中
     */
    public static final int QUOTATION_STATUS = 3;
    /**
     * 成功报价单
     */
    public static final int QUOTATION_STATUS_ONE = 1;
    /**
     * 历史版本
     */
    public static final int QUOTATION_STATUS_TWO = 2;

    /**
     * main_project_business_types  无意义
     */
    public static final int BUSINESS_TYPE_STATUS_0 = 0;
    /**
     * main_project_business_types 报价单审批中
     */
    public static final int BUSINESS_TYPE_STATUS_1 = 1;
    /**
     * main_project_business_types 报价单审批成功
     */
    public static final int BUSINESS_TYPE_STATUS_2 = 2;
    /**
     * main_project_business_types 已拆分(成子订单)
     */
    public static final int BUSINESS_TYPE_STATUS_3 = 3;
    /**
     * 角色：专业负责人角色
     */
    public static final int ROLE_PROJECT_MANAGER = 4;
    /**
     * 角色：方案主创
     */
    public static final int ROLE_INITIATE_DESIGN = 137;

    /**
     * 角色：印章保管员角色
     */
    public static final int ROLE_PROJECT_ONEHUNDREDANDTEN = 110;

    /**
     * 角色：印章知会人角色
     */
    public static final int ROLE_PROJECT_ONEHUNDREDANDELEVEN = 111;

    /**
     * 角色：新部门经理
     */
    public static final int ROLE_OPERATIONS_MANAGER = 3;
    /**
     * 角色：事业部负责人
     */
    public static final int ROLE_PLATE_MANAGER = 2;

    /**
     * 角色：事业部助理
     */
	public static final int ROLE_PLATE_ASSISTANT = 69;

	/**
	 * 角色：部门行政负责人
	 */
 	public static final int ROLE_PLATE_MANAGE_MANAGER = 61;

    /**
     * 角色：年薪员工
     */
    public static final int ROLE_ANNUAL_SALARY_EMPLOYEE = 41;
    /**
     * 角色：积分高管
     */
    public static final int ROLE_INTEGRAL_EXECUTIVE = 42;
    /**
     * 角色：部门助理
     */
    public static final int ROLE_DEPARTMENT_ASSISTANT = 9;
    /**
     * 角色：其他部门经理
     */
    public static final int ROLE_OTHER_DEPARTMENT_MANAGER = 30;
    /**
     * 角色：部门经理
     */
    public static final int ROLE_DEPARTMENT_MANAGER = 158;
    /**
     * 角色：回款分配专员
     */
    public static final int ROLE_CAPITAL_DISTRIBUTION_MANAGER = 53;

    /**
     * 角色：分管合伙人（人力）
     */
    public static final int MANAGING_PARTNER_HR = 127;

    /**
     * 角色： 合伙人
     */
    public static final int MANAGING_PARTNER = 129;

    /**
     * 角色： 运营董事
     */
    public static final int OPERATE_DIRECTOR = 142;


    /**
     * 角色： 合伙人（职能）
     */
    public static final int MANAGING_PARTNER_160 = 160;

    /**
     * 角色：回款确认专员
     */
    public static final int ROLE_CAPITAL_CONFIRM_MANAGER = 54;

    /**
     * 角色：当前申请人
     */
    public static final int ROLE_OWN = 11;

    /**
     * 角色：部门负责人
     */
    public static final int ROLE_DEPARTMENT_LEADER = 31;

    /**
     * 角色：薪酬专员
     */
    public static final int ROLE_COMPENSATION_COMMISSIONERS = 63;

    /**
     * 角色：总经理
     */
    public static final int ROLE_COMPANY_MANAGER = 27;

    /**
     * 角色：总经理秘书
     */
    public static final int ROLE_COMPANY_MANAGER_SECRETARY = 71;

    /**
     * 角色：大项目经理
     */
    public static final int ROLE_CONTRACT_MANAGER = 80;

    /**
     * 角色：项目主管领导
     */
    public static final int ROLE_PROJECT_LEADER = 81;

    /**
     * 角色：项目相关领导
     */
    public static final int ROLE_PROJECT_RELATE_LEADER = 82;

    /**
     * 角色：人资行政经理
     */
    public static final int ROLE_HUMAN_RESOURCES_MANAGER = 22;

    /**
     * 角色：部门负责人（人资）
     */
    public static final int DEPARTMENT_HEAD_HR = 78;

    /**
     * 角色：前期项目报备人
     */
    public static final int ROLE_PRE_PROJECT_APPLICANT = 113;

    /**
     * 角色：普通职员
     */
    public static final int ROLE_NORMAL_EMPLOYEE = 15;

    /**
     * 项目日常报销
     */
    public static final int PROCESS_TYPE_2 = 2;
    /**
     * 普通日常报销
     */
  	public static final int PROCESS_TYPE_3 = 3;
  	/**
  	 * 项目差旅报销
  	 */
  	public static final int PROCESS_TYPE_4 = 4;
  	/**
  	 * 普通差旅报销
  	 */
  	public static final int PROCESS_TYPE_5 = 5;
  	/**
  	 * 借款申请
  	 */
  	public static final int PROCESS_TYPE_6 = 6;
  	/**
  	 * 预付款申请
  	 */
  	public static final int PROCESS_TYPE_7 = 7;
  	/**
  	 * 前期项目日常报销
  	 */
  	public static final int PROCESS_TYPE_8 = 8;
  	/**
  	 * 前期项目差旅报销
  	 */
  	public static final int PROCESS_TYPE_9 = 9;
  	/**
  	 * 公司日常报销
  	 */
  	public static final int PROCESS_TYPE_10 = 10;
  	/**
  	 * 请假申请
  	 */
  	public static final int PROCESS_TYPE_13 = 13;
  	/**
  	 * 出差申请
  	 */
  	public static final int PROCESS_TYPE_14 = 14;
  	/**
  	 * 打卡申请
  	 */
  	public static final int PROCESS_TYPE_15 = 15;
  	/**
  	 * 外出申请
  	 */
  	public static final int PROCESS_TYPE_16 = 16;
  	/**
  	 * 加班申请
  	 */
  	public static final int PROCESS_TYPE_17 = 17;
  	/**
  	 * 项目出差申请
  	 */
  	public static final int PROCESS_TYPE_18 = 18;
  	/**
  	 * 出差延期申请
  	 */
  	public static final int PROCESS_TYPE_19 = 19;
  	/**
  	 * 出差更改行程申请
  	 */
  	public static final int PROCESS_TYPE_20 = 20;
  	/**
  	 * 项目派驻申请
  	 */
  	public static final int PROCESS_TYPE_21 = 21;
  	/**
  	 * 项目派驻延期申请
  	 */
  	public static final int PROCESS_TYPE_22 = 22;
  	/**
  	 * 项目派驻确认申请
  	 */
  	public static final int PROCESS_TYPE_23 = 23;
  	/**
  	 * 入职申请
  	 */
  	public static final int PROCESS_TYPE_24 = 24;
  	/**
  	 * 离职申请
  	 */
  	public static final int PROCESS_TYPE_25 = 25;
  	/**
  	 * 转岗申请
  	 */
  	public static final int PROCESS_TYPE_26 = 26;
  	/**
  	 * 确认函申请
  	 */
  	public static final int PROCESS_TYPE_27 = 27;
  	/**
  	 * 员工还款申请
  	 */
  	public static final int PROCESS_TYPE_28 = 28;
  	/**
  	 * 转正申请
  	 */
  	public static final int PROCESS_TYPE_29 = 29;
  	/**
  	 * 调薪申请
  	 */
  	public static final int PROCESS_TYPE_30 = 30;
  	/**
  	 * 物品申请
  	 */
  	public static final int PROCESS_TYPE_31 = 31;
  	/**
  	 * 用车申请
  	 */
  	public static final int PROCESS_TYPE_33 = 33;
  	/**
  	 * 名片申请
  	 */
  	public static final int PROCESS_TYPE_34 = 34;
  	/**
  	 * 刻章申请
  	 */
  	public static final int PROCESS_TYPE_35 = 35;
  	/**
  	 * 采购申请
  	 */
  	public static final int PROCESS_TYPE_36 = 36;
  	/**
  	 * 薪资发放申请
  	 */
  	public static final int PROCESS_TYPE_37 = 37;
  	/**
  	 * 成本调节
  	 */
  	public static final int PROCESS_TYPE_39 = 39;
  	/**
  	 * 网络权限
  	 */
  	public static final int PROCESS_TYPE_40 = 40;
  	/**
  	 * 外部公司还款申请
  	 */
  	public static final int PROCESS_TYPE_41 = 41;
  	/**
  	 * 项目报备
  	 */
  	public static final int PROCESS_TYPE_42 = 42;
  	/**
  	 * 前期项目立项
  	 */
  	public static final int PROCESS_TYPE_43 = 43;
  	/**
  	 * 前期项目关闭
  	 */
  	public static final int PROCESS_TYPE_44 = 44;
  	/**
  	 * 工资异常申请
  	 */
  	public static final int PROCESS_TYPE_45 = 45;
  	/**
  	 * 前期项目转单
  	 */
  	public static final int PROCESS_TYPE_46 = 46;
  	/**
  	 * 订单跨阶段评审流程
  	 */
  	public static final int PROCESS_TYPE_51 = 51;
  	/**
  	 * 预算单立项
  	 */
  	public static final int PROCESS_TYPE_52 = 52;
  	/**
  	 * 预算附件审批
  	 */
  	public static final int PROCESS_TYPE_54 = 54;
  	/**
  	 *专项扣除
  	 */
  	public static final int PROCESS_TYPE_58 = 58;
  	public static final int PROCESS_ID_195 = 195;

  	/**
  	 *落标申请
  	 */
  	public static final int PROCESS_TYPE_73 = 73;
  	public static final int PROCESS_ID_210 = 210;
  	/**
  	 * 合同状态变更
  	 */
  	public static final int PROCESS_TYPE_64 = 64;
  	/**
  	 *	订单下达
  	 */
  	public static final int PROCESS_TYPE_86 = 86;
  	/**
  	 * 删除状态：已删除
  	 */
  	public static final int HAS_DELETE = 1;
  	/**
  	 * 删除状态：未删除
  	 */
  	public static final int NO_DELETE = 0;
  	/**
  	 * 公司账户
  	 */
  	public static final int COMPANY_ACCOUNT = 0;
  	/**
  	 * 借款
  	 */
  	public static final int BORROW_MONEY = 1;
  	/**
  	 * 还款
  	 */
  	public static final int RETURN_MONEY = 2;
  	/**
  	 * 报销类型父级1
  	 */
  	public static final int PARENT_PROCESS_TYPE_1 = 1;
  	//考勤中午休息小时数
  	public static final BigDecimal REST_HOURS = new BigDecimal(1.5);
  	//考勤一天上班小时数
  	public static final BigDecimal TOTAL_HOURS = new BigDecimal(7);

  	/**
  	 * 午休开始时间
  	 */
  	public static final String  REST_START = "12:15";

  	/**
  	 * 午休结束时间
  	 */
  	public static final String REST_END = "13:45";

  	/**
  	 * 普通上班时间
  	 */
  	public static final String WORK_START = "09:00";

  	/**
  	 * 普通下班时间
  	 */
  	public static final String WORK_END = "17:30";

  	/**
  	 * 自定义审核人
  	 */
  	public static final int ROLE_CUSTOM_AUDITOR = 59;

  	/**
  	 * 角色：我的出图——校对人
  	 */
  	public static final int ROLE_OUTPUT_DRAWING_PROOFREADER = 91;

  	/**
  	 * 角色：我的出图——审核人
  	 */
  	public static final int ROLE_OUTPUT_DRAWING_REVIEWER = 93;

  	/**
  	 * 角色：项目秘书
  	 */
  	public static final int ROLE_MAIN_PROJECT_SECRETARY = 143;

  	/**
  	 * 角色：项目负责人
  	 */
  	public static final int ROLE_MAIN_PROJECT_PERSON_IN_CHARGE = 152;

    /**
     * 部门行政负责人
     */
    public static final int DEPARTMENT_CHIEF_EXECUTIVE = 61;

  	/**
  	 * 司龄20年以上的年假天数
  	 */
  	public static final BigDecimal ANNUAL_LEAVE_TWENTY_YEARS = new BigDecimal(10);

  	/**
  	 * 司龄10年以上的年假天数
  	 */
  	public static final BigDecimal ANNUAL_LEAVE_TEN_YEARS = new BigDecimal(5);

  	/**
  	 * 请假类型：产假
  	 */
  	public static final int LEAVE_TYPE_1 = 1;

  	/**
  	 * 请假类型：产检假
  	 */
  	public static final int LEAVE_TYPE_6 = 6;

  	/**
  	 * 请假类型：陪护假
  	 */
  	public static final int LEAVE_TYPE_7 = 7;

  	/**
  	 * 请假类型：婚假
  	 */
  	public static final int LEAVE_TYPE_8 = 8;

  	/**
  	 * 请假类型：丧假
  	 */
  	public static final int LEAVE_TYPE_9 = 9;

  	/**
  	 * 请假类型：计划生育假
  	 */
  	public static final int LEAVE_TYPE_12 = 12;

  	/**
  	 * 请假类型：事假
  	 */
  	public static final int LEAVE_TYPE_19 = 19;

  	/**
  	 * 请假类型：病假
  	 */
  	public static final int LEAVE_TYPE_20 = 20;

  	/**
  	 * 请假类型：调休
  	 */
  	public static final int LEAVE_TYPE_21 = 21;

  	/**
  	 * 请假类型：年假
  	 */
  	public static final int LEAVE_TYPE_22 = 22;

  	/**
  	 * 请假类型：其他假期
  	 */
  	public static final int LEAVE_TYPE_23 = 23;

  	/**
  	 * 合同变更和项目变更的记录状态：草稿
  	 */
  	public static final int CONTRACT_OR_PROJECT_CHANGE_FLAG_1 = 1;

  	/**
  	 * 合同变更和项目变更的记录状态：驳回
  	 */
  	public static final int CONTRACT_OR_PROJECT_CHANGE_FLAG_2 = 2;

  	/**
  	 * 合同变更和项目变更的记录状态：待审核
  	 */
  	public static final int CONTRACT_OR_PROJECT_CHANGE_FLAG_3 = 3;

  	/**
  	 * 合同变更和项目变更的记录状态：已审核
  	 */
  	public static final int CONTRACT_OR_PROJECT_CHANGE_FLAG_4 = 4;

  	/**
  	 * 绩效类型:扣除
  	 */
  	public static final int PERFORMANCE_FLAG_1 = 1;

  	/**
  	 * 绩效类型:奖励
  	 */
  	public static final int PERFORMANCE_FLAG_2 = 2;

  	/**
  	 * 项目绩效的业务类别：项目经理绩效
  	 */
  	public static final int PERFORMANCE_BUSINESS_TYPE_1 = 1;

  	/**
  	 * 项目绩效的业务类别：项目绩效
  	 */
  	public static final int PERFORMANCE_BUSINESS_TYPE_2 = 2;

  	/**
  	 * 收款方：个人
  	 */
  	public static final int PAY_FOR_PERSON = 1;

  	/**
  	 * 收款方：公司
  	 */
  	public static final int PAY_FOR_COMPANY = 2;

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
     * 部门分管领导
     */
    public static final int ROLE_DEPARTMENT_CHARGE_LEADER = 60;


    /**
     * 财务出纳（人资）
     */
    public static final int ROLE_HUMAN_RESOURCE_CASHIER = 76;

    /**
     * 考勤管理员
     */
    public static final int ROLE_ATTENDANCE_ADMINISTRATOR = 16;

    /**
     * 运营专员
     */
    public static final int ROLE_OPERATION_SPECIALIST = 29;

    /**
     * 主项目的项目经理
     */
    public static final int ROLE_MAIN_PROJECT_MANAGER = 66;

    /**
     * 差旅费
     */
    public static final int TRAVEL_FEE = 13;

    /**
     * 部门类型：营销部门
     */
    public static final int DEPARTMENT_TYPE_0 = 0;

    /**
     * 部门类型：职能部门
     */
    public static final int DEPARTMENT_TYPE_1 = 1;

    /**
     * 部门类型：业务部门
     */
    public static final int DEPARTMENT_TYPE_2 = 2;
    /**
     * 性别：男
     */
    public static final int GENDER_MAN = 1;
    /**
     * 性别：女
     */
    public static final int GENDER_WOMAN = 2;
    /**
     * 入职员工状态：实习生
     */
    public static final int ONBOARD_STATUS_0 = 0;
    /**
     * 入职员工状态：试用期
     */
    public static final int ONBOARD_STATUS_1 = 1;
    /**
     * 入职员工状态：正式员工
     */
    public static final int ONBOARD_STATUS_2 = 2;

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
     * 订单状态：订单缓慢
     */
    public static final int PROJECT_STATUS_16 = 16;

    /**
     * 订单状态：订单收尾
     */
    public static final int PROJECT_STATUS_17 = 17;

    /**
     * 订单状态：未出结果
     */
    public static final int PROJECT_STATUS_18 = 18;

    /**
     * 印章类型：项目章
     */
    public static final int SIGNET_TYPE_10 = 10;
    /**
     * 部门账户业务功能类型：项目结项
     */
    public static final int PLATE_ACCOUNT_BUSINESS_TYPE_20 = 20;
    /**
     * 固定的K3科目代码businessId：应收账款-应收发票
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_1 = 1;
    /**
     * 固定的K3科目代码businessId：应收账款-应收确认函
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_2 = 2;
    /**
     * 固定的K3科目代码businessId：应交税费-百分比
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_3 = 3;
    /**
     * 固定的K3科目代码businessId：应交税费-应交增值税（销项税额）
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_4 = 4;
    /**
     * 固定的K3科目代码businessId：应收账款-确认
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_5 = 5;
    /**
     * 固定的K3科目代码businessId：应收账款-百分比
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_6 = 6;
    /**
     * 固定的K3科目代码businessId：应交税费-百分比
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_7 = 7;
    /**
     * 固定的K3科目代码businessId：进项税额
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_8 = 8;
    /**
     * 固定的K3科目代码businessId：进项税转出金额
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_9 = 9;
    /**
     * 固定的K3科目代码businessId：收款/合同款
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_10 = 10;
    /**
     * 固定的K3科目代码businessId：收款/房租
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_11 = 11;
    /**
     * 固定的K3科目代码businessId：收款/个人往来款
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_12 = 12;
    /**
     * 固定的K3科目代码businessId：收款/公司往来款
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_13 = 13;
    /**
     * 固定的K3科目代码businessId：收款/利息
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_14 = 14;
    /**
     * 固定的K3科目代码businessId：收款/内部往来款
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_15 = 15;
    /**
     * 固定的K3科目代码businessId：收款/政府补贴
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_16 = 16;
    /**
     * 固定的K3科目代码businessId：收款/其他
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_17 = 17;
    /**
     * 固定的K3科目代码businessId：收款/保证金
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_18 = 18;
    /**
     * 固定的K3科目代码businessId：收款/押金
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_19 = 19;
    /**
     * 固定的K3科目代码businessId：收款/保理+商票
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_20 = 20;
    /**
     * 固定的K3科目代码businessId：收款/借款
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_21 = 21;
    /**
     * 固定的K3科目代码businessId：奖金（借方）
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_22 = 22;
    /**
     * 固定的K3科目代码businessId：奖金（贷方[个税]）
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_24 = 24;
    /**
     * 固定的K3科目代码businessId：银行手续费
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_25 = 25;
    /**
     * 固定的K3科目代码businessId：利息收入
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_26 = 26;
    /**
     * 固定的K3科目代码businessId：内部往来-资金往来
     */
    public static final int K3_CODE_TYPE_0_BUSINESS_ID_27 = 27;

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
     * 凭证类型：奖金
     */
    public static final int VOUCHER_TYPE_8 = 8;
    /**
     * 凭证类型：银行手续费
     */
    public static final int VOUCHER_TYPE_9 = 9;
    /**
     * 用车类型：项目用车
     */
    public static final int PROJECT_USE_CAR = 1;
    /**
     * 用车类型：前期项目用车
     */
    public static final int PRE_PROJECT_USE_CAR = 2;
    /**
     * 用车类型：部门用车
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
     * 五险一金：基本养老保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_1 = 1;
    /**
     * 五险一金：基本医疗保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_2 = 2;
    /**
     * 五险一金：失业保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_3 = 3;
    /**
     * 五险一金：工伤保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_4 = 4;
    /**
     * 五险一金：生育保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_5 = 5;
    /**
     * 五险一金：大病保险
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_6 = 6;
    /**
     * 五险一金：公积金
     */
    public static final int K3_CODE_TYPE_11_BUSINESS_ID_7 = 7;
    /**
     * 工资：工资
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_1 = 1;
    /**
     * 工资：应付工资
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_2 = 2;
    /**
     * 工资：个人所得税
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_3 = 3;
    /**
     * 工资：个人养老保险
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_4 = 4;
    /**
     * 工资：个人医疗保险
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_5 = 5;
    /**
     * 工资：个人失业保险
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_6 = 6;
    /**
     * 工资：个人大病保险
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_7 = 7;
    /**
     * 工资：个人采暖
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_8 = 8;
    /**
     * 工资：个人部分住房公积金
     */
    public static final int K3_CODE_TYPE_12_BUSINESS_ID_9 = 9;
    /**
     * 工资薪酬类型：预提
     */
    public static final int K3_CODE_SALARY_TYPE_01 = 1;
    /**
     * 工资薪酬类型：已审
     */
    public static final int K3_CODE_SALARY_TYPE_02 = 2;
    /**
     * 工资薪酬类型：调整
     */
    public static final int K3_CODE_SALARY_TYPE_03 = 3;
    /**
     * 工资：发放工资的银行代码[深圳市杰恩创意设计股份有限公司专用]
     */
    public static final String K3_CODE_PAY_BANK_JA = "1002.01.01";
    /**
     * 工资：发放工资的银行代码[通用]
     */
    public static final String K3_CODE_PAY_BANK_COMMON = "1002.01";
    /**
     * 回款分配类型：部门回款分配
     */
    public static final int CAPITAL_DISTRIBUTION_TYPE_1 = 1;
    /**
     * 回款分配类型：订单回款分配
     */
    public static final int CAPITAL_DISTRIBUTION_TYPE_2 = 2;
    /**
     * 货币种类：人民币
     */
    public static final int CURRENCY_0 = 0;
    /**
     * 货币种类：港币
     */
    public static final int CURRENCY_1 = 1;
    /**
     * 货币种类：美元
     */
    public static final int CURRENCY_2 = 2;
    /**
     * 货币种类：欧元
     */
    public static final int CURRENCY_3 = 3;
    /**
     * 货币种类在字典表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_CURRENCY = 40;
    /**
     * 货币种类在字典表中的dic_type_name
     */
    public static final String SYSTEM_DICTIONARY_CURRENCY_STR = "货币种类";
    /**
     * 按期转正
     */
    public static final int POSITIVE_TYPE_1 = 1;
    /**
     * 提前转正
     */
    public static final int POSITIVE_TYPE_2 = 2;
    /**
     * 调薪类型：入职
     */
    public static final int PAYMENT_CHANGE_TYPE_1 = 1;
    /**
     * 调薪类型：转正
     */
    public static final int PAYMENT_CHANGE_TYPE_2 = 2;
    /**
     * 调薪类型：调薪
     */
    public static final int PAYMENT_CHANGE_TYPE_3 = 3;
    /**
     * 调薪类型：调岗
     */
    public static final int PAYMENT_CHANGE_TYPE_4 = 4;
    /**
     * 账单流水流程状态：未分配
     */
    public static final int CAPITAL_PROCESS_STATUS_0 = 0;
    /**
     * 账单流水流程状态：分配中
     */
    public static final int CAPITAL_PROCESS_STATUS_1 = 1;
    /**
     * 账单流水流程状态：分配完成
     */
    public static final int CAPITAL_PROCESS_STATUS_2 = 2;
    /**
     * 账单流水流程状态：(财务)完成分配
     */
    public static final int CAPITAL_PROCESS_STATUS_3 = 3;
    /**
     * 部门账户业务功能类型：提成收入
     */
    public static final int PLATE_ACCOUNT_BUSINESS_TYPE_25 = 25;
    /**
     * 部门账户业务功能类型：提成支出
     */
    public static final int PLATE_ACCOUNT_BUSINESS_TYPE_26 = 26;
    /**
     * 发票状态：未使用
     */
    public static final int INVOICE_STATUS_0 = 0;
    /**
     * 发票状态：正常发票
     */
    public static final int INVOICE_STATUS_1 = 1;
    /**
     * 发票状态：负数发票
     */
    public static final int INVOICE_STATUS_2 = 2;
    /**
     * 发票状态：填开作废
     */
    public static final int INVOICE_STATUS_3 = 3;
    /**
     * 发票状态：负数作废
     */
    public static final int INVOICE_STATUS_4 = 4;
    /**
     * 发票状态：空白作废
     */
    public static final int INVOICE_STATUS_5 = 5;
    /**
     * 款项属性：收款/合同款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_1 = 1;
    /**
     * 款项属性：收款/房租
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_2 = 2;
    /**
     * 款项属性：收款/个人往来款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_3 = 3;
    /**
     * 款项属性：收款/公司往来款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_4 = 4;
    /**
     * 款项属性：收款/利息
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_5 = 5;
    /**
     * 款项属性：收款/内部往来款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_6 = 6;
    /**
     * 款项属性：收款/政府补贴
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_7 = 7;
    /**
     * 款项属性：收款/其他
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_8 = 8;
    /**
     * 款项属性：收款/保证金
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_9 = 9;
    /**
     * 款项属性：收款/押金
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_10 = 10;
    /**
     * 款项属性：收款/保理
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_11 = 11;
    /**
     * 款项属性：收款/借款
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_12 = 12;
    /**
     * 款项属性：收款/商票
     */
    public static final int CAPITAL_MONEY_ATTRIBUTION_13 = 13;
    /**
     * 合同签订状态：已寄出
     */
    public static final int CONTRACT_SIGING_STATUS_1 = 1;
    /**
     * 合同签订状态：已签订
     */
    public static final int CONTRACT_SIGING_STATUS_2 = 2;
    /**
     * 合同签订状态：已关闭
     */
    public static final int CONTRACT_SIGING_STATUS_5 = 5;
    /**
     * 合同状态：未出结果
     */
    public static final int CONTRACT_STATUS_1 = 1;
    /**
     * 合同状态：落标项目
     */
    public static final int CONTRACT_STATUS_2 = 2;
    /**
     * 合同状态：无效项目
     */
    public static final int CONTRACT_STATUS_3 = 3;
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
     * 合同状态：合同运行-收尾
     */
    public static final int CONTRACT_STATUS_7 = 7;
    /**
     * 合同状态：合同暂停
     */
    public static final int CONTRACT_STATUS_8 = 8;
    /**
     * 合同状态：合同缓慢
     */
    public static final int CONTRACT_STATUS_9 = 9;
    /**
     * 合同状态：合同终止-结算中
     */
    public static final int CONTRACT_STATUS_10 = 10;
    /**
     * 合同状态：合同终止
     */
    public static final int CONTRACT_STATUS_11 = 11;
    /**
     * 合同状态：合同结束
     */
    public static final int CONTRACT_STATUS_12 = 12;
    /**
     * 合同状态：项目终止-结算中
     */
    public static final int CONTRACT_STATUS_13 = 13;
    /**
     * 合同状态：项目终止
     */
    public static final int CONTRACT_STATUS_14 = 14;
    /**
     * 【项目等级】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PROJECT_LEVEL = 2;
    /**
     * 【设计阶段】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_7 = 7;
    /**
     * 【立项依据】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PROJECT_BASE_ON = 28;
    /**
     * 【项目状态】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PROJECT_STATUS = 154;
    /**
     * 【设计状态】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_DESIGN_STATUS = 155;
    /**
     * 【前期跟踪记录-信息类型】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PRE_PROJECT_INFO_TYPE = 153;
    /**
     * 【前期项目合同状态】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PRE_PROJECT_CONTRACT_STATUS = 172;
    /**
     * 【前期项目立项/关闭状态】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_PRE_PROJECT_CLOSE_STATUS = 161;
    /**
     * 【预算类型】在system_dictionary表中的dic_type_id
     */
    public static final int SYSTEM_DICTIONARY_BUDGET_TYPE = 191;
    /**
     * ERP系统的application_id
     */
    public static final int ERP_APPLICATION_ID = 1;
    /**
     * 应陈浩要求，绑定合同和重新绑定的时候，发消息给陈浩、陈亚辉、贾小娟，此处的值为这三位职员的企业微信ID
     */
    public static final String BINDING_CONTRACT_TO_NOTIFY_EMPLOYEES = "qy012f8aaf6874ac0028482d17f8|qy01128ac86864ac0028067a0211|qy01198a3d6874ac0028db2e5ac8";

    /**
     * 项目绩效管理扣除金额
     */
    public static final BigDecimal DEDUCT_MONEY_500 = new BigDecimal(500);
    public static final BigDecimal DEDUCT_MONEY_1000 = new BigDecimal(1000);
    public static final BigDecimal DEDUCT_MONEY_1500 = new BigDecimal(1500);
    public static final BigDecimal DEDUCT_MONEY_2000 = new BigDecimal(2000);
    public static final BigDecimal DEDUCT_MONEY_3000 = new BigDecimal(3000);
    /**
     * 项目绩效管理扣款环节模块名称
     */
    public static final String POROJECT_PERFORMANCE_BUSINESS_1 = "报价单";
    public static final String POROJECT_PERFORMANCE_BUSINESS_2 = "拆分价";
    public static final String POROJECT_PERFORMANCE_BUSINESS_3 = "订单下达";
    public static final String POROJECT_PERFORMANCE_BUSINESS_4 = "确认积分";
    public static final String POROJECT_PERFORMANCE_BUSINESS_5 = "确认函管理";

    /**
     * 项目绩效管理扣款环节模块ID
     */
    public static final int POROJECT_PERFORMANCE_BUSINESS_TYPE_1 = 1;
    public static final int POROJECT_PERFORMANCE_BUSINESS_TYPE_2 = 2;
    public static final int POROJECT_PERFORMANCE_BUSINESS_TYPE_3 = 3;
    public static final int POROJECT_PERFORMANCE_BUSINESS_TYPE_4 = 4;
    public static final int POROJECT_PERFORMANCE_BUSINESS_TYPE_5 = 5;

    /**
     *项目费用类型   预付款
     */
    public static final int PROJECT_COST_TYPE_6=6;

    /**
     *项目费用类型   借款
     */
    public static final int PROJECT_COST_TYPE_7=7;
    /**
     *项目费用类型   员工还款申请
     */
    public static final int PROJECT_COST_TYPE_8=8;
    /**
     *项目费用类型   外部公司还款申请
     */
    public static final int PROJECT_COST_TYPE_9=9;
    /**
     *项目费用类型   项目报销冲账
     */
    public static final int PROJECT_COST_TYPE_10=10;
    /**
     *项目费用类型   项目报销
     */
    public static final int PROJECT_COST_TYPE_11=11;
    /**
     * 文件类型：未知文件类型
     */
    public static final int FILE_TYPE_UNKNOWN = -1;
    /**
     * 文件类型：文件夹
     */
    public static final int FILE_TYPE_FOLDER = 0;
    /**
     * 文件类型：文本txt
     */
    public static final int FILE_TYPE_TXT = 1;
    /**
     * 文件类型：PDF
     */
    public static final int FILE_TYPE_PDF = 2;
    /**
     * 文件类型：表格excel
     */
    public static final int FILE_TYPE_EXCEL = 3;
    /**
     * 文件类型：文档word
     */
    public static final int FILE_TYPE_WORD = 4;
    /**
     * 文件类型：图片
     */
    public static final int FILE_TYPE_IMAGE = 5;
    /**
     * 文件类型：音频文件
     */
    public static final int FILE_TYPE_VOICE = 6;
    /**
     * 文件类型：ppt
     */
    public static final int FILE_TYPE_PPT = 7;
    /**
     * 文件类型：autoCad
     */
    public static final int FILE_TYPE_CAD = 8;
    /**
     * 文件类型：exe
     */
    public static final int FILE_TYPE_EXE = 9;
    /**
     * 文件类型：zip
     */
    public static final int FILE_TYPE_ZIP = 10;
    /**
     * 文件类型：视频
     */
    public static final int FILE_TYPE_VIDEO = 11;
    /**
     * 文件版本上传状态:上传完成
     */
    public static final int FILE_VERSION_UPLOAD_STATUS_3 = 3;

    /**
     * 文件目录各区类型值:基础资料
     */
    public static final int FILE_ATTRIBUTION_BASIC = 1;
    /**
     * 文件目录各区类型值:设计区
     */
    public static final int FILE_ATTRIBUTION_DESIGN = 2;
    /**
     * 文件目录各区类型值:审核区
     */
    public static final int FILE_ATTRIBUTION_AUDIT= 3;
    /**
     * 文件目录各区类型值:提资区
     */
    public static final int FILE_ATTRIBUTION_RAISE = 4;
    /**
     * 文件目录各区类型值:交付区
     */
    public static final int FILE_ATTRIBUTION_DELIVERY = 5;
    /**
     * 文件目录各区类型值:出版区
     */
    public static final int FILE_ATTRIBUTION_PUBLISH = 6;
    /**
     * 文件目录各区类型值:协同区
     */
    public static final int FILE_ATTRIBUTION_COORDINATION = 7;
    /**
     * 基础文件夹名称:基础资料
     */
    public static final String FOLDER_NAME_BASIC = "依据文件区";
    /**
     * 基础文件夹名称:设计区
     */
    public static final String FOLDER_NAME_DESIGN = "过程文件区";
    /**
     * 基础文件夹名称:审核区
     */
    public static final String FOLDER_NAME_AUDIT= "审核区";
    /**
     * 基础文件夹名称:提资区
     */
    public static final String FOLDER_NAME_RAISE = "提资区";
    /**
     * 基础文件夹名称:交付区
     */
    public static final String FOLDER_NAME_DELIVERY = "成果文件区";
    /**
     * 基础文件夹名称:出版区
     */
    public static final String FOLDER_NAME_PUBLISH = "出版区";
    /**
     * 基础文件夹名称: 协同区
     */
    public static final String FOLDER_NAME_COORDINATION = "设计协同区";


    /**
     * 公用序列号类型:项目编号和合同模块
     */
    public static final Integer SERIAL_TYPE_ONE = 1;

    /**
     * 预算相关
     */
    public static final Integer BD_PAY_STATUS_ONE=1;//预算付款状态 未付款

    public static final Integer BD_PAY_STATUS_TWO=2;//预算付款状态 已付款

    public static final Integer BD_PAY_STATUS_THREE=3;//预算付款状态 付款申请中

    public static final Integer BD_BIND_STATUS_ALREADY=1;//预算付款序列已绑定

    public static final Integer BD_BIND_STATUS_NO=0;//预算付款序列未绑定

    public static final Integer BD_BILL_STATUS_ONGOING=1; //预算单状态，立项进行中

    public static final Integer BD_BILL_STATUS_ALREADYUSE=2; //预算单状态，已立项

    public static final Integer BD_BILL_STATUS_ONSETTLEMENT=3; //预算单状态，结算中

    public static final Integer BD_BILL_STATUS_ALREDYSETTLEMENT=4; //预算单状态，已结算

    public static final Integer BD_BILL_STATUS_REFUSE=5; //预算单状态，被驳回

    public static final Integer ATTACHMENT_APPROVAL_STATUS_NO=0;//预算附件审批状态  未审批

    public static final Integer ATTACHMENT_APPROVAL_STATUS_ONGOING=1;//预算附件审批状态  审批中

    public static final Integer ATTACHMENT_APPROVAL_STATUS_ALREADY=2;//预算附件审批状态  已审批
    /**
     * 角色：项目主管领导
     */
    public static final int ROLE_81 = 81;
    /**
     * 角色：总监
     */
    public static final int ROLE_67 = 67;

    /**
     * 角色：审核人
     */
    public static final int ROLE_93 = 93;
    /**
     * 角色：项目秘书
     */
    public static final int ROLE_143 = 143;
    /**
     * 角色：项目负责人
     */
    public static final int ROLE_152 = 152;
    /**
     * 角色：质量检查
     */
    public static final int ROLE_176 = 176;
    
    /**
     * 角色：人事助理
     */
    public static final int ROLE_64 = 64;
    /**
     * 角色：招聘专员
     */
    public static final int ROLE_57 = 57;
    /**
     * 审批节点类型：普通节点
     */
    public static final int ACTIVITY_TYPE_FLAG_NORMAL = 1;
    /**
     * 审批节点类型：任务池
     */
    public static final int ACTIVITY_TYPE_FLAG_POOL = 2;

    /**
     * 项目报价相关
     *
     */
    public static final Integer QUOTE_STATUS_NO=1;//项目报价状态：未报价

    public static final Integer QUOTE_STATUS_RUN=2;//项目报价状态：报价进行中

    public static final Integer QUOTE_STATUS_END=3;//项目报价状态：已报价


    /**
     * 项目人员关联关系：待定项目成员
     */
    public static final int PROJECT_EMPLOYEE_FLAG_1 = 1;
    /**
     * 项目人员关联关系：正式项目成员
     */
    public static final int PROJECT_EMPLOYEE_FLAG_2 = 2;

    /**
     * 流程测试标志的key
     */
    public static final String TEST_PROCESSOR = "testProcessor";
    /**
     * 外出申请类型：项目外出
     */
    public static final int STAY_AWAY_APPLY_TYPE_1 = 1;
    /**
     * 外出申请类型：前期项目外出
     */
    public static final int STAY_AWAY_APPLY_TYPE_2 = 2;
    /**
     * 外出申请类型：非项目外出
     */
    public static final int STAY_AWAY_APPLY_TYPE_3 = 3;
    /**
     * 加班申请类型：项目加班
     */
    public static final int OVER_TIME_APPLY_TYPE_1 = 1;
    /**
     * 加班申请类型：前期项目加班
     */
    public static final int OVER_TIME_APPLY_TYPE_2 = 2;
    /**
     * 加班申请类型：非项目加班
     */
    public static final int OVER_TIME_APPLY_TYPE_3 = 3;
    /**
     * 项目出差申请类型：项目出差
     */
    public static final int BUSINESS_PROJECT_TRIP_APPLY_TYPE_1 = 1;
    /**
     * 项目出差申请类型：前期项目出差
     */
    public static final int BUSINESS_PROJECT_TRIP_APPLY_TYPE_2 = 2;
    /**
     * 线程任务类型：流程测试
     */
    public static final int THREAD_TASK_TYPE_5 = 5;
    /**
     * 流程测试结果：成功
     */
    public static final int PROCESSOR_TEST_RESULT_1 = 1;
    /**
     * 流程测试结果：失败
     */
    public static final int PROCESSOR_TEST_RESULT_2 = 2;
    /**
     * 线程任务状态：新建
     */
    public static final int THREAD_TASK_MANAGE_STATUS_0 = 0;
    /**
     * 线程任务状态：运行中
     */
    public static final int THREAD_TASK_MANAGE_STATUS_1 = 1;
    /**
     * 线程任务状态：完成
     */
    public static final int THREAD_TASK_MANAGE_STATUS_2 = 2;
    /**
     * 线程任务状态：失败
     */
    public static final int THREAD_TASK_MANAGE_STATUS_3 = 3;

    /**
     * 供应商状态
     */
    public static final int SUPPLIER_USE_STATUS_ENABLE = 1;

    public static final int SUPPLIER_USE_STATUS_DISENABLE = 0;

    /**
     * 业务部门:运营组
     */
    public static final int plate_59= 59;
    /**
     * 员工劳动合同状态：未到期
     */
    public static final int EMPLOYEE_CONTRACT_WILL_END_0 = 0;




    /**
     * 专项扣除类型：子女扣款special_deduction
     */
    public static final int SPECIAL_DEDUCTION_1 = 1;

    /**
     * 专项扣除类型：继续教育
     */
    public static final int SPECIAL_DEDUCTION_2 = 2;

    /**
     * 专项扣除类型：住房贷款利息
     */
    public static final int SPECIAL_DEDUCTION_3 = 3;

    /**
     * 专项扣除类型：住房租金
     */
    public static final int SPECIAL_DEDUCTION_4= 4;

    /**
     * 专项扣除类型：赡养老人
     */
    public static final int SPECIAL_DEDUCTION_5 = 5;

    /**
     * 专项扣除类型：大病医疗
     */
    public static final int SPECIAL_DEDUCTION_6 = 6;

    public static final Integer PURCHASE_ACTION_PROCESS_TYPE = 63;//采购实例流程类型

    /**
     * 角色：询价人员(询价流程)
     */
    public static final int ROLE_ID_101 = 101;

    /**
     * system_config 配置类型
     */
    public static final int CONFIG_TYPE_11 = 11;

    /**
     * system_config 配置类型  会议室超时时间type
     */
    public static final int CONFIG_TYPE_12 = 12;

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_1 = "深圳市杰恩创意设计股份有限公司";

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_2 = "深圳市杰恩创意设计股份有限公司北京分公司";


    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_3 = "深圳市杰恩创意设计股份有限公司武汉分公司";

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_4 = "深圳市杰恩创意设计股份有限公司上海分公司";

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_5 = "深圳市杰恩创意设计股份有限公司大连分公司";

    /**
     * main_projects表bid_type字段：未出结果
     */
    public static final int BID_TYPE_NO_RESULT = 1;

    /**
     * main_projects表bid_type字段：中标
     */
    public static final int BID_TYPE_WIN_BID = 2;

    /**
     * main_projects表bid_type字段：落标
     */
    public static final int BID_TYPE_LOSE_BID = 3;

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_6 = "深圳市博普森机电顾问有限公司";

    /**
     * 公司名称
     */
    public static final String CORPORATE_NAME_7 = "杰拓设计（国际）有限公司";

    public static final String COMPANY = "公司";

    public static final String COMPANY_NAME_1 = "杰恩";
    public static final String COMPANY_NAME_2 = "北京";
    public static final String COMPANY_NAME_3 = "武汉";
    public static final String COMPANY_NAME_4 = "上海";
    public static final String COMPANY_NAME_5 = "大连";
    public static final String COMPANY_NAME_6 = "机电";
    public static final String COMPANY_NAME_7 = "杰拓";


    /**
     * 盖章内容
     */
    public static final String SEAL_CONTENT= "盖章内容";

    /**
     * 盖章内容项
     */
    public static final String SEAL_CONTENT_NAME_1= "重大变更";
    public static final String SEAL_CONTENT_NAME_2= "设计变更出图及晒图";
    public static final String SEAL_CONTENT_NAME_3= "项目费用";
    public static final String SEAL_CONTENT_NAME_4= "外包合同";

    /**
     * 盖章类型
     */
    public static final String SEAL_TYPE= "盖章类型";

    /**
     * 盖章类型项
     */
    public static final String SEAL_TYPE_NAME= "商务合同盖章";

    /**
     * 盖章类型项
     */
    public static final String SEAL_TYPE_NAME_TWO= "人资行政盖章";

    /**
     * 盖章类型项
     */
    public static final String SEAL_TYPE_NAME_THREE= "日常投标文件盖章";
    
    /**
     * 盖章类型项
     */
    public static final int DEPARTMENT_7= 7;



    /**
     * 印章种类
     */
    public static final String TYPE_OF_SEAL= "印章种类";


    /**
     * 印章种类项
     */
    public static final String TYPE_OF_SEAL_NAME_1= "公章";
    public static final String TYPE_OF_SEAL_NAME_2= "法人章";
    public static final String TYPE_OF_SEAL_NAME_3= "人事专用章";
    public static final String TYPE_OF_SEAL_NAME_4= "合同专用章";
    public static final String TYPE_OF_SEAL_NAME_5= "财务专用章";
    public static final String TYPE_OF_SEAL_NAME_6= "发票专用章";
    public static final String TYPE_OF_SEAL_NAME_7= "账号专用章";
    public static final String TYPE_OF_SEAL_NAME_8= "出图章";



    /**
     * 报价单审核申请
     */
    public static final int PROCESS_TYPE_75=75;


    /**
     * project_stages status
     * 0:无意义
     * 1:未进行 可分配阶段确认
     * 2:已完成 可分配阶段确认
     * 3:流程中 可分配阶段确认
     *
     */
    public static final int PROJECT_STAGES_STAUTS_0=0;
    public static final int PROJECT_STAGES_STAUTS_1=1;
    public static final int PROJECT_STAGES_STAUTS_2=2;
    public static final int PROJECT_STAGES_STAUTS_3=3;

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

    /**
     * project_transitions status
     * 0:用作记录操作
     * 1:待审批
     * 2:已驳回
     * 3:已完成
     */
    public static final int PROJECT_TRANSITIONS_STAUTS_0=0;
    public static final int PROJECT_TRANSITIONS_STAUTS_1=1;
    public static final int PROJECT_TRANSITIONS_STAUTS_2=2;
    public static final int PROJECT_TRANSITIONS_STAUTS_3=3;


    /**
     * Contract_Messages
     * status 消息状态   0 无意义 ，1 需要进行消息推送   2 已完成，不需要进行消息推送   3 已失效
     */
    public static final int CONTRACT_MESSAGE_STAUTS_0=0;
    public static final int CONTRACT_MESSAGE_STAUTS_1=1;
    public static final int CONTRACT_MESSAGE_STAUTS_2=2;
    public static final int CONTRACT_MESSAGE_STAUTS_3=3;


    /**
     * 项目日常报销类型
     */

    public static final String  REIMBURSEMENT_TYPE="报销类型";
    public static final int REIMBURSEMENT_TYPE_1=1;
    public static final int REIMBURSEMENT_TYPE_2=2;
    public static final int REIMBURSEMENT_TYPE_3=3;
    public static final int REIMBURSEMENT_TYPE_4=4;
    public static final int REIMBURSEMENT_TYPE_5=5;
    public static final int REIMBURSEMENT_TYPE_6=6;
    public static final int REIMBURSEMENT_TYPE_7=7;
    public static final int REIMBURSEMENT_TYPE_8=8;
    public static final String REIMBURSEMENT_TYPE_1_NAME="效果图制作";
    public static final String REIMBURSEMENT_TYPE_2_NAME="模型制作";
    public static final String REIMBURSEMENT_TYPE_3_NAME="打图费";
    public static final String REIMBURSEMENT_TYPE_4_NAME="其他";
    public static final String REIMBURSEMENT_TYPE_5_NAME="分包设计费";

    public static final String REIMBURSEMENT_TYPE_6_NAME="加班交通费";
    public static final String REIMBURSEMENT_TYPE_7_NAME="房租、物管、水电费、快递费";
    public static final String REIMBURSEMENT_TYPE_8_NAME="购办公用品";
    public static final String REIMBURSEMENT_TYPE_9_NAME="购电脑及配件";
    public static final String REIMBURSEMENT_TYPE_10_NAME="购家具";
    public static final String REIMBURSEMENT_TYPE_11_NAME="装修费";
    public static final String REIMBURSEMENT_TYPE_12_NAME="办公费";
    public static final String REIMBURSEMENT_TYPE_13_NAME="其他费用";

    public static final String  BELONGING_COMPANY="归属公司";

}
