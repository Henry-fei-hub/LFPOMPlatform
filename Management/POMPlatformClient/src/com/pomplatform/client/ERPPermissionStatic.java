package com.pomplatform.client;

/**
 *
 * @author cl
 */
public class ERPPermissionStatic {
    //人力资源管理平台****************************************  begin
    //一级菜单 
    //人资管理
    public static final String HR_MANAGEMENT = "AM-00000-000";
        //组织架构
        public static final String ORGANIZATION_MANAGEMENT = "AM-01000-000";
               //部门下人员
                public static final String ORGANIZATION_DEPT_NUM_MANAGEMENT = "AM-00100-000";
               //部门下角色
                public static final String ORGANIZATION_DEPT_ROLE_NUM_MANAGEMENT = "AM-00200-000";
               //角色下人员
                public static final String ORGANIZATION_ROLE_EMP_NUM_MANAGEMENT = "AM-00300-000";
               //角色下功能
                public static final String ORGANIZATION_ROLE_TOOL_MANAGEMENT = "AM-00400-000";
                //部门角色下职员
                public static final String ORGANIZATION_DEPARTMENT_ROLE_EMP_NUM_MANAGEMENT = "AM-00500-000";
               //部门角色下功能
                public static final String ORGANIZATION_DEPARTMENT_ROLE_TOOL_MANAGEMENT = "AM-00600-000";
        //人工成本
        public static final String SALARY_MANAGEMENT = "AM-04000-000";
            //人工成本下载模板按钮
            public static final String SALARY_DOWNLOAD_BUTTON = "AB-04000-001";
            //人工成本导入成本按钮
            public static final String SALARY_IMPORT_BUTTON = "AB-04000-002";
            //人工成本导出成本按钮
            public static final String SALARY_EXPORT_BUTTON = "AB-04000-003";
            //人工成本秘钥重置按钮
            public static final String SALARY_RESET_PWD_BUTTON = "AB-04000-004";
            //人工成本解密搜索按钮
            public static final String SALARY_DECRYPTION_SERACH_BUTTON = "AB-04000-005";

        //考勤管理
        public static final String ATTENDANCE_MANAGE = "AM-05000-000";
        	//节日维护
        	public static final String HOLIDAY_MANAGE = "AM-05100-000";
        	//时段维护
        	public static final String SHIFT_TIME_MANAGE = "AM-05200-000";
        	//班次管理
        	public static final String SHIFT_MANAGE = "AM-05300-000";
        	//员工排班
        	public static final String EMPLOYEE_SHIFT_MANAGE = "AM-05400-000";
	        //考勤数据
	        public static final String CHECK_MANAGEMENT = "AM-05500-000";
	            //考勤数据只查看所有用户数据权限
	            public static final String CHECK_ALL_SHOW_DATA = "AD-05500-001";
	            //考勤数据查看模块用户数据权限
	            public static final String CHECK_PLATE_SHOW_DATA = "AD-05500-002";
	            //考勤数据查看当前用户数据权限
	            public static final String CHECK_ONLY_MINE_SHOW_DATA = "AD-05500-003";

	        //考勤汇总
	        public static final String CHECK_TOTAL_MANAGEMENT = "AM-05600-000";
	            //考勤汇总导出按钮
	            public static final String CHECK_TOTAL_EXPORT_BUTTON = "AB-05600-001";
	            //考勤汇总重新计算按钮
	            public static final String CHECK_TOTAL_RECOUNT_BUTTON = "AB-05600-002";
	            //考勤汇总解锁按钮
	            public static final String CHECK_TOTAL_UNLOCK_BUTTON = "AB-05600-003";
	          //考勤汇总删除按钮
	            public static final String CHECK_TOTAL_DEL_BUTTON = "AB-05600-004";
	            //考勤汇总查看所有用户数据权限
	            public static final String CHECK_TOTAL_ALL_SHOW_DATA = "AD-05600-001";
	            //考勤汇总查看模块用户数据权限
	            public static final String CHECK_TOTAL_PLATE_SHOW_DATA = "AD-05600-002";
	            //考勤汇总查看当前用户数据权限
	            public static final String CHECK_TOTAL_ONLY_MINE_DATA = "AD-05600-003";
	        //实时考勤
            public static final String EMPLOYEE_CHECKINOUT = "AM-05700-000";
	            //查看所有部门考勤权限
	            public static final String CHECK_ALL_DEPARTMENT_CHECKINOUT = "AD-05700-001";
	          //查看自己部门考勤权限
	            public static final String CHECK_OUR_DEPARTMENT_CHECKINOUT = "AD-05700-002";
            //请假类型
            public static final String LEAVE_TYPE = "AM-05800-000";
            //打卡明细
            public static final String CHECK_DETAIL = "AM-05900-000";
            //预计考勤统计
            public static final String ATTENDANCE_MANAGEMENT_STATISTICS = "AM-051000-000";
	//年假统计
	public static final String ANNUAL_LEAVE = "AM-051100-000";
        //转岗汇总
        public static final String CHANGE_PLATE_MANAGEMENT = "AM-07000-000";
            //转岗修改按钮
            public static final String CHANGE_PLATE_UPDATE_BUTTON = "AB-07000-001";
            //转岗新建按钮
            public static final String CHANGE_PLATE_NEW_BUTTON = "AB-07000-002";
            //转岗删除按钮
            public static final String CHANGE_PLATE_DELETE_BUTTON = "AB-07000-003";

        //职员每月所属业务部门记录
        public static final String EMPLOYEE_PLATE_RECORD_MANAGEMENT = "AM-08000-000";
            //导出
            public static final String EMPLOYEE_PLATE_RECORD_DOWNLOAD_BUTTON = "AB-08000-001";
        //职员每日所属业务部门记录
        public static final String EMPLOYEE_DAY_PLATE_RECORD_MANAGEMENT = "AM-13000-000";
        //职员卡号管理
        public static final String CARD_MANAGE_MANAGEMENT = "AM-09000-000";
	        //卡号管理新建按钮
	        public static final String CARD_MANAGE_NEW_BUTTON = "AB-09000-001";
	        //卡号管理修改按钮
	        public static final String CARD_MANAGE_UPDATE_BUTTON = "AB-09000-002";
	        //卡号管理删除按钮
	        public static final String CARD_MANAGE_DELETE_BUTTON = "AB-09000-003";

        //我的团队
        public static final String MY_TEAM_MANAGEMENT = "AM-10000-000";
        //设备管理
        public static final String CLOCK_MANAGE = "AM-02000-000";
           //设备列表
            public static final String CLOCK_LIST = "AM-02100-000";
           //员工指纹
            public static final String EMPLOYEE_FINGERS = "AM-02200-000";
           //测试
            public static final String EMPLOYEE_FACES = "AM-02300-000";
            public static final String ceshi = "AM-02300-001";
		//物品管理
        public static final String EQUIPMENT_MANAGE = "AM-81000-000";
        	//物品库存管理
        	public static final String EQUIPMENT_INVENTORY_MANAGE = "AM-82000-000";
			//采购领用明细表
        	public static final String EQUIPMENT_DETAIL = "AM-83000-000";


        //薪酬管理
        public static final String PAYMENT_MANAGE = "AM-06000-000";
        	//日薪管理
        	public static final String DAY_PAYMENT_MANAGE = "AM-06100-000";
        	//日薪管理 --人工成本调节按钮
        	public static final String DAY_PAYMENT_MANAGE_COST = "AM-06100-001";
        	//日薪管理 --日薪导出按钮
        	public static final String DAY_PAYMENT_EXPORT_COST = "AM-06100-002";
        	//月薪管理
        	public static final String MONTH_PAYMENT_MANAGE = "AM-062000-000";
        	//五险一金
            public static final String SOCIAL_AND_FUND = "AM-06200-000";
            	//下载模板按钮
            	public static final String PAY_DOWNLOAD_TEMPLATE_BUTTON = "AB-06200-001";
            	//导入数据按钮
            	public static final String PAY_IMPORT_DATA_BUTTON = "AB-06200-002";
            	//五险一金删除按钮
                public static final String DELETE_SOCIAL_AND_FUND = "AB-06200-003";
			//五险一金缴费基数
			public static final String SOCIAL_AND_FUND_INFO = "AM-0612000-000";

        	//工龄工资
            public static final String SALARY_OF_WORK_YEARS = "AM-06300-000";
            //奖金管理
            public static final String SALARY_MANAGE = "AM-06400-000";
	            //应发奖金
	            public static final String SALARY_OF_SHOULD_BONUS = "AM-06410-000";
		            //下载模板按钮
		        	public static final String SHOULD_BONUS_DOWNLOAD_TEMPLATE_BUTTON = "AB-06410-001";
		        	//导入数据按钮
		        	public static final String SHOULD_BONUS_IMPORT_DATA_BUTTON = "AB-06410-002";
	            //已发奖金
	            public static final String SALARY_OF_FACT_BONUS = "AM-06420-000";
		            //下载模板按钮
		        	public static final String FACT_BONUS_DOWNLOAD_TEMPLATE_BUTTON = "AB-06420-001";
		        	//导入数据按钮
		        	public static final String FACT_BONUS_IMPORT_DATA_BUTTON = "AB-06420-002";
	            //其他奖金
	            public static final String SALARY_OF_OTHER_BONUS = "AM-06430-000";
		            //下载模板按钮
		        	public static final String OTHER_BONUS_DOWNLOAD_TEMPLATE_BUTTON = "AB-06430-001";
		        	//导入数据按钮
		        	public static final String OTHER_BONUS_IMPORT_DATA_BUTTON = "AB-06430-002";
        	 //异动补发
            public static final String SALARY_SUBSIDY_MANAGE = "AM-06500-000";
	            //补发补扣
	            public static final String SALARY_FILL_SEND_DEDUCT = "AM-06510-000";
	            //岗位补贴
	            public static final String SALARY_JOB_SUBSIDY = "AM-06520-000";
	            //代扣款项
	            public static final String INSTEAD_DEDUCT = "AM-06530-000";
	            //代扣重疾险项
	            public static final String INSTEAD_DEDUCT_ILL = "AM-06540-000";
	            //补发个数ReplacementTax
	            public static final String REPLACEMENT_TAX = "AM-06550-000";
	            //其他扣除other_deduction
	            public static final String OTHER_DEDUCTION = "AM-06560-000";
            //离职补偿
            public static final String SALARY_LEAVE_SUBSIDY = "AM-06600-000";
        //绩效工资
    	public static final String PERFORMANCE_MANAGE = "AM-06700-000";
	    	//绩效等级
	    	public static final String SALARY_EMPLOYEE_EVALUATION = "AM-06710-000";
	    	//员工绩效
	    	public static final String SALARY_EMPLOYEE_PERFORMANCE = "AM-06720-000";
    	//年终奖金
    	public static final String SALARY_ANNUAL_BONUS = "AM-06800-000";

    	//工资表
    	public static final String SALARY_TOTAL = "AM-06900-000";

    	//劳务报酬
    	public static final String LABOR_PAYMENT = "AM-061110-000";

    	//财务报表
    	public static final String CAPITAL_REPORT = "AM-061000-000";
	    	//工资总表
	    	public static final String SALARY_TOTAL_OF_CAPITAL = "AM-061100-000";
		    	//工资总表查看公司和部门权限
		    	public static final String SALARY_TOTAL_CHECK_ALL_DATA = "AD-061100-001";
		    	//工资总表查看部门下成员权限
		    	public static final String SALARY_TOTAL_CHECK_EXCEPT_EMPLOYEE = "AD-061100-002";
	    	//工资分表
	    	public static final String SALARY_DETAIL_OF_CAPITAL = "AM-061200-000";
	    	//工资发放表
	    	public static final String SALARY_SEND_OF_CAPITAL = "AM-061300-000";
	    	//工资报税表
	    	public static final String SALARY_TAX_OF_CAPITAL = "AM-061400-000";
			//募投项目表
			public static final String EMPLOYEE_SALARY_TYPEP = "AM-0611700-000";
	    	//奖金总表
	    	public static final String SALARY_BONUS_TOTAL = "AM-061500-000";
		    	//奖金总表查看全部数据权限
		    	public static final String SALARY_BONUS_CHECK_ALL_DATA = "AD-061500-001";
		    	//奖金总表查看除员工详情外数据权限
		    	public static final String SALARY_BONUS_CHECK_EXCEPT_EMPLOYEE = "AD-061500-002";
	    	//奖金分表
	    	public static final String SALARY_BONUS_DETAIL = "AM-061800-000";
	    	//奖金发放表
	    	public static final String SALARY_BONUS_SEND = "AM-061600-000";
	    	//工资薪酬表
	    	public static final String SALARY_PAYMENT = "AM-061700-000";
	    	//年终奖金总表
	    	public static final String SALARY_ANNUALBONUS_TOTAL = "AM-061900-000";
	    	//年终奖金分表
	    	public static final String SALARY_ANNUALBONUS_DETAIL = "AM-0611000-000";
	    	//年终奖金发放表
	    	public static final String SALARY_ANNUALBONUS_SEND = "AM-0611100-000";
	    	//年终奖金报税表
	    	public static final String SALARY_ANNUALBONUS_TAX = "AM-0611200-000";
	        //个税专项扣除管理special_deduction_records
	        public static final String SPECIAL_DEDUCTION_MAMAGEMENT = "AM-0611300-000";

	        public static final String SPECIAL_DEDUCTION_EMPLOYEE_MAMAGEMENT = "AM-0611400-000";

	        public static final String SPECIAL_DEDUCTION = "AM-0611500-000";

	        public static final String SPECIAL_DEDUCTION_MONTH_MAMAGEMENT = "AM-0611600-000";

        //员工合同管理
        public static final String EMPLOYEE_CONTRACT_MANAGE = "AM-03000-000";

        //离职员工统计
        public static final String RESIGN_EMPLOYEE = "AM-11000-000";
        //离职员工冻结积分修改
        public static final String UPDATE_FROZEN_INTEGRAL = "AM-020000-000";
        //用车成本汇总
        public static final String CAR_ALLOCATION = "AM-12000-000";
        //入职员工统计
        public static final String ONBOARD_EMPLOYEE = "AM-14000-000";
	    //业务板块维护
        public static final String PLATE_LINK_DEPARTMENT = "AM-15000-000";
        //任务列表查询
        public static final String THREAD_TASK_MANAGE = "AM-16000-000";
        //培训管理模块
        public static final String TRAINING_MANAGERMENT = "AM-17000-000";
	        //培训管理
	        public static final String TRAINING_MANAGEMENTS = "AM-17100-000";
	        //物品领用
	        public static final String GOODS_RECEIVE = "AM-17200-000";
	        //员工积分
	        public static final String EMPLOYEE_INTEGRAL = "AM-17300-000";
	        //讲师积分
	        public static final String COMPERE_INTEGRAL = "AM-17400-000";
	      //培训管理汇总
	        public static final String ABOUT_TRAINING_MANAGEMENTS = "AM-17500-000";
	    //公司管理模块
	    public static final String COMPANY_MAMAGEMENT = "AM-18000-000";
	    	//新增
        	public static final String COMPANY_MAMAGEMENT_ADD = "AB-18000-001";
        	//修改
        	public static final String COMPANY_MAMAGEMENT_UPDATE = "AB-18000-002";
        	//删除
        	public static final String COMPANY_MAMAGEMENT_DEL = "AB-18000-003";
        //岗位管理
        public static final String JOB_MAMAGEMENT = "AM-19000-001";
	//会议室管理
	public static final String MEETING_ROOM_MAMAGEMENT = "AM-19000-000";
	//查看所有记录
	public static final String METING_RECORD_ALL = "AM-19000-100";
	//印章保管维护
	public static final String SEAL_PRESERVATION_MAINTENANCE = "AM-19100-000";
	//职级系数管理
	public static final String RANK_MAINTENANCE = "AM-19200-000";
    //人力资源管理平台****************************************  end


    //营销管理平台***********************************************   begin
    //一级菜单 
    //营销管理平台
    public static final String MARKET_MANAGEMENT = "AM-20000-000";

        //协同项目信息
        public static final String PROJECT_INFO_MANAGEMENT = "AM-21000-000";
            //创建订单按钮
            public static final String PROJECT_INFO_ADD_CONTRACTS_BUTTON = "AB-21000-003";
            //申请合同按钮
            public static final String PROJECT_INFO_ADD_HC_BUTTON = "AB-21000-005";
            //查看报价单
            public static final String PROJECT_INFO_BJD_BUTTON = "AB-21000-001";
            //查看拆分价按钮
            public static final String PROJECT_INFO_CFJ_BUTTON = "AB-21000-002";
            //订单下达按钮
            public static final String PROJECT_INFO_DDXD_BUTTON = "AB-21000-003";
            //正式合同按钮
            public static final String PROJECT_INFO_ZSHT_BUTTON = "AB-21000-005";
            //定金信息按钮
            public static final String PROJECT_INFO_DJXX_BUTTON = "AB-21000-006";
            //查看回款率按钮
            public static final String PROJECT_INFO_HKL_BUTTON = "AB-21000-007";
            //信息补录按钮
            public static final String PROJECT_INFO_UPDATE_PROJECT_BUTTON = "AB-21000-008";
            //查看联系人按钮
            public static final String PROJECT_INFO_VIEW_LINKMAN_BUTTON = "AB-21000-009";
            //投标订单立项按钮
            public static final String PROJECT_INFO_BID_BUTTON = "AB-21000-010";
            //中标按钮
            public static final String PROJECT_INFO_BID_GET_BUTTON = "AB-21000-011";
            //落标按钮
            public static final String PROJECT_INFO_BID_PAY_BUTTON = "AB-21000-012";
            //指定签署人
            public static final String PROJECT_INFO_SIGNATORY_BUTTON = "AB-21000-013";
            //
            public static final String CHANGE_OF_PROJECT_SECRETARY_BUTTON = "AB-21000-014";
	        //查看全部数据权限
	        public static final String PROJECT_INFO_MANAGEMENT_CHECK_ALL_DATA = "AD-21000-001";
	        //查看自己管理部门的数据权限
	        public static final String PROJECT_INFO_MANAGEMENT_CHECK_PLATE_DATA = "AD-21000-002";

        //客户管理
        public static final String CUSTOMER_MANAGEMENT = "AM-22000-000";
	        //查看信息
	        public static final String CUSTOMER_RESOURCES_CHECK_DATA = "AD-22000-001";
	        //查看所有信息
	        public static final String CUSTOMER_RESOURCES_CHECK_ALL_DATA = "AD-22000-002";
	        //新增功能权限
	        public static final String CUSTOMER_RESOURCES_ADD = "AB-22000-001";
	        //修改功能权限
	        public static final String CUSTOMER_RESOURCES_UPDATE = "AB-22000-002";
	        //删除功能权限
	        public static final String CUSTOMER_RESOURCES_DELETE = "AB-22000-003";
        //客户资源
        public static final String CUSTOMER_RESOURCES = "AM-26000-000";
        //节日祝福
        public static final String HOLIDAY_BLESS = "AM-27000-000";
        //区域管理
        public static final String AREA_MANAGE = "AM-28000-000";
        //提成分配
        public static final String COMMISSION_ALLOCATION = "AM-29000-000";
        	//提成分配
        	public static final String COMMISSION_ALLOCATIONS = "AM-29003-000";
        	//分配团队
        	public static final String ALLOCATION_TEAM = "AM-29001-000";
        	//提成计算
        	public static final String SHOW_CONTRACT_DISTRIBUTION = "AM-29004-000";
			public static final String SHOW_CONTRACT_DISTRIBUTION_NEW = "AM-29007-000";
	        	//提成计算查看所有权限
	        	public static final String SHOW_CONTRACT_DISTRIBUTION_ALL_DATA = "AD-29004-001";
	        	//提成计算查看管理部门权限
	        	public static final String SHOW_CONTRACT_DISTRIBUTION_MAN_DATA = "AD-29004-002";
	        	//修改订单的业态的权限
				public static final String MODIFY_PROJECT_RATE = "AB-29004-003";
        	//订单提成
        	public static final String 	OLD_PROJECT_REVENU = "AM-29005-000";
			//订单提成
			public static final String 	CONTRACT_COMMISSION_DETAIL = "AM-29006-000";
        	//合同营收
        	public static final String CONTRACT_REVENUE = "AM-29002-000";
		    //差旅&会议
	    public static final String ACTIVITY_MEET_MANAGE = "AM-29100-000";
	        //查看会议全部信息
	        public static final String ACTIVITY_MEET_ALL_DATE = "AD-29100-001";
	        //查看信息
	        public static final String ACTIVITY_MEET_CHECK_DATE = "AD-29100-002";
	 	//前期项目
        public static final String PRE_PROJECTS = "AM-210000-000";
	      	//项目报备按钮
	        public static final String PRE_PROJECT_REPORT = "AB-210000-001";
	        //修改项目按钮
	        public static final String PRE_PROJECT_EDIT = "AB-210000-002";
	        //新增跟踪台账记录按钮
	        public static final String PRE_PROJECT_RECORD = "AB-210000-003";
	        //项目初始化按钮，即把警示为黑灯的变为绿灯
	        public static final String PRE_PROJECT_INIT = "AB-210000-008";
	        //查看部门前期项目全部报表权限
	        public static final String PRE_PROJECT_DEPARTMENT_REPORT = "AB-210000-009";
	        //查看我的前期项目全部报表权限
	        public static final String PRE_PROJECT_MY_REPORT = "AB-210000-011";
	        //查看投标数据分析全部数据权限
	        public static final String PRE_PROJECT_ANALYSISDATA_REPORT = "AB-210000-010";

	        //前期项目立项按钮
	        public static final String BE_PROJECT_APPLY = "AB-210000-004";
	        //前期项目关闭按钮
	        public static final String CLOSE_PROJECT_APPLY = "AB-210000-005";
	        //前期项目转单按钮
	        public static final String CLOSE_PROJECT_TRANSFER = "AB-210000-006";
	        //前期项目报价按钮
	        public static final String QUOTE_BUTTON = "AB-210000-007";
	        //查看全部数据权限
	        public static final String PRE_PROJECT_CHECK_ALL_DATA = "AD-210000-001";
	        //查看自己管理部门的数据权限
	        public static final String PRE_PROJECT_CHECK_PLATE_DATA = "AD-210000-002";

        //池子管理
        public static final String POOL_MANAGE = "AM-211000-000";
		//产值系数管理
		public static final String PRODUCTION_VALUE_COEFFICIENT="AM-211000-001";
			public static final String PRODUCTION_VALUE_COEFFICIENT_SAVE="AM-211001-001";

		//竞争对手
	    public static final String COMPETITION_UNITS = "AM-29200-000";
	        //查看信息
	        public static final String COMPETITION_UNITS_CHECK_DATA = "AD-29200-001";
	        //新增功能权限
	        public static final String COMPETITION_UNITS_ADD = "AB-29200-001";
	        //修改功能权限
	        public static final String COMPETITION_UNITS_UPDATE = "AB-29200-002";
	        //删除功能权限
	        public static final String COMPETITION_UNITS_DELETE = "AB-29200-003";
        //报价管理
	    public static final String OUT_QUOTATIONS_INFO_MANAGEMENT = "AM-23000-000";
	        //报价单
		    public static final String BJD_MANAGEMENT = "AM-23100-000";
		    	//填写报价单
		    	public static final String BJD_ADD_BTN = "AB-23100-001";
		    	//克隆报价单
		    	public static final String BJD_CLONE_BTN = "AB-23100-002";
		    	//删除
		    	public static final String BJD_DEL_BTN = "AB-23100-003";
		    	//补充协议按钮
		    	public static final String CREATE_AGREEMENT_BTN = "AB-23100-004";
		    //拆分价
		    public static final String CFJ_MANAGEMENT = "AM-23200-000";
			    //拆分价按钮
		    	public static final String CFJ_ADD_BTN = "AB-23200-001";
	    	//标准报价
	    	public static final String STANDARD_QUOTE = "AM-23300-000";
	    	//报价模板
	    	public static final String QUOTE_TEMPLATE = "AM-23400-000";
		    //合同报价单
		    public static final String HTBJB_MANAGEMENT = "AM-23500-000";
        //合同管理
        public static final String FINALLTY_INFO_MANAGEMENT = "AM-24000-000";
	        //创建合同
	        public static final String  FINALLTY_SECOND_INFO_MANAGEMENT= "AM-24100-000";
	            //创建合同按钮
		        public static final String FINALLTY_INFO_MANAGEMENT_CREATE_BUTTON = "AB-24100-001";
		    //收款阶段
	        public static final String SK_MANAGEMENT = "AM-24200-000";
		        //新增节点
		        public static final String CREATE_JD_BUTTON = "AB-24200-001";
		        //新增子节点
		        public static final String CREATE_ZJD_BUTTON = "AB-24200-002";
		        //删除
		        public static final String DEL_JD_AND_ZJD = "AB-24200-003";
		        //保存
		        public static final String SAVE_JD_AND_ZJD = "AB-24200-004";
		    //合同信息
		    public static final String CONTRACT_MANAGEMENT_INFO = "AM-24300-000";
		    //合同跟踪信息汇总
		    public static final String CONTRACTS_RECORDS = "AM-24300-008";
			    //补录合同信息
		        public static final String UPDATE_CONTRACT_INFO_BTN = "AB-24300-001";
		        //上传服务建议书
		        public static final String FINALLTY_INFO_UPLOAD_FILE_BUTTON = "AB-24300-002";
		        //合同录入
		        public static final String CONTRACTS_INPUT_BUTTON = "AB-24300-003";
		        //导出
		        public static final String CONTRACTS_EXPORT_BUTTON = "AB-24300-004";
		        //新增跟踪记录
		        public static final String CONTRACTS_RECORD_BUTTON = "AB-24300-005";
		    	//查看业务部门下的合同
		    	public static final String CONTRACT_MANAGEMENT_INFO_SHOW_PLATE = "AD-24300-001";
		    	//查看个人(专业负责人)
		    	public static final String CONTRACT_MANAGEMENT_INFO_SHOW_MANAGE = "AD-24300-002";
		    	//查看所有
		    	public static final String CONTRACT_MANAGEMENT_INFO_SHOW_ALL = "AD-24300-003";
		    //创建合同编号
	        public static final String CREATE_CONTRACT_CODE = "AM-24400-000";
	        	//新增
	        	public static final String CREATE_CONTRACT_CODE_BTN="AB-24400-001";
        	 //合同维护
	        public static final String CONTRACT_MANAGE = "AM-24500-000";
	        //合同文件库
	        public static final String CONTRACT_ATTACHMENT_MANAGE = "AM-24600-000";
	        	//合同文件库上传文件按钮
		        public static final String CONTRACT_ATTACHMENT_MANAGE_ADD_BTN = "AB-24600-001";
		        //合同文件库绑定合同按钮
		     	public static final String CONTRACT_ATTACHMENT_MANAGE_BIND_BTN = "AB-24600-002";
		     	//合同文件库查看
		        public static final String CONTRACT_ATTACHMENT_MANAGE_CHECK = "AD-24600-001";
			//收款阶段模板
//			public static final String RECEIVABLE_TEMPLATE = "AM-59800-000";
			public static final String RECEIVABLE_TEMPLATE = "AM-24700-000";
	     //前期项目报销
	     public static final String PRE_REIMBURSEMENT_PROJECT = "AM-25000-000";
	     	public static final String PRE_REIMBURSEMENT_PROJECT_ADD_BTN = "AB-25000-001";
	     	public static final String PRE_REIMBURSEMENT_PROJECT_UPDATE_BTN = "AB-25000-002";
	     	public static final String PRE_REIMBURSEMENT_PROJECT_DELETE_BTN = "AB-25000-003";
    //一级菜单 
    //运营管理平台
    public static final String  OPERATE_MANAGEMENT = "AM-30000-000";
        //项目信息数据权限**************
        //查看项目全部信息
        public static final String PROJECT_ALL_INFO_DATA = "AD-30000-001";
        //查看项目重要信息
        public static final String PROJECT_MASTER_INFO_DATA = "AD-30000-002";

        //订单管理
        public static final String SHEET_INFO_MANAGEMENT = "AM-31000-000";
        	//订单下达
        	public static final String SHEET_SEND_MANAGEMENT = "AM-31100-000";
	        	//订单信息
	            public static final String CONTRACT_INFO_MANAGEMENT = "AM-31110-000";
	    	        //查看订单信息按钮
	    	        public static final String CONTRACT_INFO_SELECT_CONTRACTS_BUTTON = "AB-31110-001";
	    	        //新增子订单信息按钮
	    	        public static final String CONTRACT_INFO_ADD_CONTRACTS_BUTTON = "AB-31110-002";
    	        //价格审核列表
    	    	public static final String YUNY_PRICE_INFO_MANAGEMENT = "AM-31120-001";
    	    	    //同意
    	    		public static final String YUNY_PRICE_AGREE_INFO_BUTTON = "AB-31120-001";
    	    		//不同意
    	    		public static final String YUNY_PRICE_NOT_AGREE_INFO_BUTTON = "AB-31120-002";
    	    		//不同意
    	    		public static final String YUNY_PRICE_DATE_SELF = "AD-31120-001";
	    		//已下达订单
    	    	public static final String SENDED_SHEET_MANAGEMENT = "AM-31130-001";
    	    	//阶段分配
    	    	public static final String MY_STAGE_MANAGEMENT = "AM-31400-000";
    	    	//收款与出图阶段报警记录
    	    	public static final String CONTRACT_MESSAGE = "AM-31420-000";
    	    	//可分配阶段确认
    	    	public static final String CONFIRMABLE_PHASES = "AM-31410-000";
    	    		public static final String CONFIRMABLE_PHASES_LIST_ALLOT_BUTTON = "AB-31410-001";
    	    		//查看所有
    	    		public static final String CONFIRMABLE_PHASES_LIST_ALL_INFO_DATA = "AD-31410-001";
    	    		//查看个人
    	    		public static final String CONFIRMABLE_PHASES_LIST_SELF_INFO_DATA= "AD-31410-002";
        	//我的订单
            public static final String MY_PROJECT_MANAGEMENT = "AM-31200-000";
                //事业部管理项目
                public static final String PLATE_MANAGE_PROJECT_MANAGEMENT = "AM-31210-000";
                    //事业部管理项目积分转移按钮
                    public static final String PLATE_MANAGE_PROJECT_ADD_BUTTON = "AB-31210-001";
                    //事业部管理项目积分调整按钮
                    public static final String PLATE_MANAGE_PROJECT_TRANSFER_BUTTON = "AB-31210-002";
                    //事业部管理项目积分发放按钮
                    public static final String PLATE_MANAGE_PROJECT_GRANT_BUTTON = "AB-31210-003";
                    //事业部管理项目项目成员按钮
                    public static final String PLATE_MANAGE_PROJECT_MEMBER_BUTTON = "AB-31210-004";
                    //事业部管理项目项目时间表按钮
                    public static final String PLATE_MANAGE_PROJECT_TIMER_BUTTON = "AB-31210-005";
                    //事业部管理项目项目日志按钮
                    public static final String PLATE_MANAGE_PROJECT_LOGS_BUTTON = "AB-31210-006";
                    //事业部管理项目部门积分转移按钮
                    public static final String PLATE_MANAGE_PLATE_TRANSFER_BUTTON = "AB-31210-007";
                    //事业部管理项目部门积分发放按钮
                    public static final String PLATE_MANAGE_PLATE_ASSIGN_BUTTON = "AB-31210-008";

                //部门经理项目
                public static final String OPERATE_MANAGE_PROJECT_MANAGEMENT = "AM-31220-000";
                    //部门经理项目项目立项按钮
                    public static final String OPERATE_MANAGE_PROJECT_PROJECT_BUTTON = "AB-31220-001";
                    //部门经理项目修改项目按钮
                    public static final String OPERATE_MANAGE_PROJECT_UPDATE_BUTTON = "AB-31220-002";
                    //部门经理项目移除按钮
                    public static final String OPERATE_MANAGE_PROJECT_DELETE_BUTTON = "AB-31220-003";
                    //部门经理项目项目审核按钮
                    public static final String OPERATE_MANAGE_PROJECT_AGREE_BUTTON = "AB-31220-004";
                    //部门经理项目追加积分按钮
                    public static final String OPERATE_MANAGE_PROJECT_ADDITIONAL_INTEGRATION_BUTTON = "AB-31220-005";
                    //部门经理项目导入经费按钮
                    public static final String OPERATE_MANAGE_PROJECT_IMPORT_FUNDS_BUTTON = "AB-31220-006";
                    //部门经理项目点我修改按钮
                    public static final String OPERATE_MANAGE_PROJECT_ME_UPDATE_BUTTON = "AB-31220-007";
                  //部门经理项目无进度按钮
                	public static final String OPERATE_MANAGE_PROJECT_none_BUTTON = "AB-31220-009";

                //专业负责人项目
                public static final String INTEGRAL_MANAGE_PROJECT_MANAGEMENT = "AM-31230-000";
                    //专业负责人项目修改按钮
                    public static final String INTEGRAL_MANAGE_PROJECT_UPDATE_BUTTON = "AB-31230-001";
                    //专业负责人项目团队组建按钮
                    public static final String INTEGRAL_MANAGE_PROJECT_TEAM_BUTTON = "AB-31230-002";
                    //专业负责人项目提交审核按钮
                    public static final String INTEGRAL_MANAGE_PROJECT_FORMATION_BUTTON = "AB-31230-003";
                    //专业负责人更多操作按钮
                    public static final String INTEGRAL_MANAGE_PROJECT_MORE_BUTTON = "AB-31230-004";
                    //专业负责人项目暂停按钮
                    public static final String INTEGRAL_MANAGE_MANAGEMENT_PAUSE_BUTTON = "AB-31230-007";
                    //专业负责人项目无进度按钮
                	public static final String INTEGRAL_MANAGE_PROJECT_none_BUTTON = "AB-31230-005";

                //订单汇总
            	public static final String PROJECT_GATHER_MANAGEMENT = "AM-31250-000";
    	        	//订单汇总查看所有部门
    	            public static final String PROJECT_GATHER_MANAGEMENT_CHECK_ALL_DATA = "AD-31250-001";
    	            //订单汇总查看自己部门
    	            public static final String PROJECT_GATHER_MANAGEMENT_CHECK_MYPLATE_DATA = "AD-31250-002";
    	            //订单汇总项目暂停按钮
    	            public static final String PROJECT_GATHER_MANAGEMENT_PAUSE_BUTTON = "AB-31250-001";
    	            //订单汇总项目运行按钮
    	            public static final String PROJECT_GATHER_MANAGEMENT_RUN_BUTTON = "AB-31250-002";
    	            //订单汇总项目结束按钮
    	            public static final String PROJECT_GATHER_MANAGEMENT_END_BUTTON = "AB-31250-003";
    	          //订单汇总项目无进度按钮
    	        	public static final String PROJECT_GATHER_MANAGEMENT_none_BUTTON = "AB-31250-005";
    	        	//订单编辑按钮
    	        	public static final String PROJECT_EDIT_BUTTON = "AB-31250-006";
    	        	//订单结算信息编辑
    	        	public static final String PROJECT_SETTLEMENT_EDIT_BUTTON = "AB-31250-007";

                //我参与的项目
                public static final String MY_TAKEPARTIN_PROJECT_MANAGEMENT = "AM-31260-000";
                    //我参与的项目做过的项目按钮
                    public static final String MY_TAKEPARTIN_PROJECT_DONE_BUTTON = "AB-31260-001";

                //我的邀请
                public static final String MY_INVITE_MANAGEMENT = "AM-31270-000";
                    //我的邀请接受邀请按钮
                    public static final String MY_INVITE_ACCEPT_BUTTON = "AB-31270-001";
                    //我的邀请谢绝邀请按钮
                    public static final String MY_INVITE_REFUSE_BUTTON = "AB-31270-002";

                //积分转移记录
//                public static final String INTEGRAL_TRANSFER_MANAGEMENT = "AM-34600-000";
                //积分发放记录
//                public static final String INTEGRAL_ASSIGN_MANAGEMENT = "AM-34700-000";
                //项目成本
                public static final String PROJECT_COST_MANAGEMENT = "AM-31280-000";
                	//查看所有项目成本
                	public static final String PROJECT_COST_CHECK_ALL = "AD-31280-001";
                	//查看自己部门的项目成本
                	public static final String PROJECT_COST_MY_PLATE = "AD-31280-002";
                	//查看自己管理项目权限
                	public static final String PROJECT_COST_MY_PROJECT = "AD-31280-003";
                	//采买项目成本结算按钮
                	public static final String PROJECT_COST_30_BUTTON = "AB-31280-004";
            	 //采买订单汇总
                public static final String PROJECT_BUY_COSTS = "AM-31290-000";
				//项目积分补贴汇总
				public static final String PROJECT_ADVANCE_DETAIL = "AM-31300-000";
					//查看所有的部门数据的权限
					public static final String PROJECT_ADVANCE_DETAIL_ALL = "AD-31300-001";
					//查看自己管理部门的权限
					public static final String PROJECT_ADVANCE_DETAIL_OWNER = "AD-31300-002";
		        //方案主创管理项目
		        public static final String INITIATE_DESIGN_MANAGE_PROJECT_MANAGEMENT = "AM-31310-000";

        //项目价格表
//        public static final String PROJECT_PRICE_MANAGEMENT = "AM-31000-000";
//            //项目价格表新建按钮
//            public static final String PROJECT_PRICE_ADD_BUTTON = "AB-31000-001";
//            //项目价格表修改按钮
//            public static final String PROJECT_UPDATE_ADD_BUTTON = "AB-31000-002";
//            //项目价格表移除按钮
//            public static final String PROJECT_UPDATE_DELETE_BUTTON = "AB-31000-003";

        //项目合同
//        public static final String PROJECT_CONTRACT_MANAGEMENT = "AM-32000-000";
            //项目合同新建按钮
//            public static final String PROJECT_CONTRACT_ADD_BUTTON ="AB-32000-001";
//            //项目合同修改按钮
//            public static final String PROJECT_CONTRACT_UPDATE_BUTTON = "AB-32000-002";
//            //项目合同取消按钮
//            public static final String PROJECT_CONTRACT_CANCEL_BUTTON = "AB-32000-003";

        //公司项目
//        public static final String COMPANY_PROJECT_MANAGEMENT = "AM-33000-000";

            //部门积分转移记录
//            public static final String PLATE_INTEGRAL_TRANSFER_MANAGEMENT = "AM-34900-000";
                //查看所有部门积分转移纪录
//                public static final String PLATE_INTEGRAL_TRANSFER_ALL_DATA = "AD-34900-001";
                //查看自己部门积分转移纪录
//                public static final String PLATE_INTEGRAL_TRANSFER_MYSELF_DATA = "AD-34900-002";
            //部门积分发放纪录
//            public static final String PLATE_INTEGRAL_ASSIGN_MANAGEMENT = "AM-341000-000";
                //查看所有部门积分发放纪录
//                public static final String PLATE_INTEGRAL_ASSIGN_ALL_DATA = "AD-341000-001";
                //查看自己部门积分发放纪录
//                public static final String PLATE_INTEGRAL_ASSIGN_MYSELF_DATA = "AD-341000-002";

        //部门补贴
        public static final String PLATE_SEND_MANAGEMENT = "AM-36000-000";
            //部门补贴新建
            public static final String PLATE_SEND_SAVE_BUTTON = "AB-36000-001";
            //部门补贴修改
            public static final String PLATE_SEND_UPDATE_BUTTON = "AB-36000-002";
            //部门补贴删除
            public static final String PLATE_SEND_DELETE_BUTTON = "AB-36000-003";
            //部门补贴查看所有部门
            public static final String PLATE_SEND_CHECK_ALL_DATA = "AD-36000-001";
            //部门补贴查看自己部门
            public static final String PLATE_SEND_CHECK_MYSELF_DATA = "AD-36000-002";

        //进度管理
        public static final String REVENUE_INFO_MANAGEMENT = "AM-32000-000";
        	//项目进度表
        	public static final String REVENUE_PROJECT_PROGRESS_MANAGEMENT = "AM-32100-000";
		      	//项目进度表查看所有部门
		        public static final String REVENUE_PROJECT_PROGRESS_CHECK_ALL_DATA = "AD-32100-001";
		        //项目进度表查看自己部门
		        public static final String REVENUE_PROJECT_PROGRESS_CHECK_MYSELF_DATA = "AD-32100-002";
	        //会计权重表
	        public static final String REVENUE_ACCOUNT_WEIGHT_MANAGEMENT = "AM-32200-000";
	        //会计业态表
	        public static final String REVENUE_BUSINESS_STATE_MANAGEMENT = "AM-32300-000";
	        //完工确认表
	        public static final String REVENUE_FINISH_SURE_MANAGEMENT = "AM-32400-000";
	        //会计营收表
	        public static final String REVENUE_ACCOUNT_REVENUE_MANAGEMENT = "AM-32500-000";
	        //确认函管理
	        public static final String REVENUE_ATTACHMENT_MANAGE_MANAGEMENT = "AM-32600-000";
	        	//确认函管理查看所有部门的信息
	        	public static final String REVENUE_ATTACHMENT_CHECK_ALL = "AD-32600-001";
	        	//确认函管理查看自己管理部门的信息
	        	public static final String REVENUE_ATTACHMENT_CHECK_MYSELF = "AD-32600-002";

        //运营营收
        public static final String OPERATE_REVENUE_MANAGEMENT = "AM-33000-000";
        	//部门税率
        	public static final String PLATE_RATE_MANAGEMENT = "AM-33100-000";
        	//订单金额
        	public static final String SHEET_AMOUNT_MANAGEMENT = "AM-33200-000";
        	//营收统计
        	public static final String REVENUE_STATISTICAL_MANAGEMENT = "AM-33300-000";
		      	//营收统计修改保存按钮
		        public static final String REVENUE_STATISTICAL_UPDATEORSAVE = "AB-33300-001";
		        //营收统计拆分订单按钮
		        public static final String REVENUE_STATISTICAL_BREAK_SHEET = "AB-33300-002";
		        //营收统计提取销售积分按钮
		        public static final String REVENUE_STATISTICAL_SALE_INTEGRAL = "AB-33300-003";
		        //营收统计加锁按钮
		        public static final String REVENUE_STATISTICAL_LOCK = "AB-33300-004";
		        //营收统计查看所有部门信息
		        public static final String REVENUE_STATISTICAL_CHECK_ALL_DATA = "AD-33300-001";
		        //营收统计查看自己管理部门信息
		        public static final String REVENUE_STATISTICAL_CHECK_MYSELF_DATA = "AD-33300-002";
	        //外部收入确认表
        	public static final String OUT_ACHIEVE_SURE = "AM-33400-000";
        	//内部收入明细表
        	public static final String IN_ACHIEVE_DETAIL = "AM-33500-000";
        	//营收和回款
        	public static final String REVENUE_CAPITALS = "AM-33600-000";

		//人员配置表
        public static final String TALENTS_MINIMUM_ARRANGEMENT = "AM-34000-000";
        //账户管理
        public static final String ACCOUNT_MANAGEMENT = "AM-39000-000";
        	//公司账户
        	public static final String COMPANY_ACCOUNT_MANAGEMENT = "AM-39100-000";
	        	//公司账户查看
	            public static final String COMPANY_ACCOUNT_DATA = "AD-39100-001";
	            //公司账户公司补贴按钮
	            public static final String COMPANY_ACCOUNT_COMPANY_ADVANCE = "AB-39100-001";
	            //公司账户中标奖金按钮
	            public static final String COMPANY_ACCOUNT_WIN_AWARD = "AB-39100-002";
	            //公司账户投诉处理按钮
	            public static final String COMPANY_ACCOUNT_COMPLAINT_HANDEL = "AB-39100-003";
	            //公司账户公司借款按钮
	            public static final String COMPANY_ACCOUNT_COMPANY_LOAN = "AB-39100-004";
	            //公司账户公司补贴新建按钮
	            public static final String ADD_COMPANY_ACCOUNT_COMPANY_ADVANCE = "AB-39100-005";
	            //公司账户公司补贴删除按钮
	            public static final String DELETE_COMPANY_ACCOUNT_COMPANY_ADVANCE = "AB-39100-006";
	            //公司账户项目补贴按钮
	            public static final String COMPANY_PROJECT_ADVANCE_BUTTON = "AB-39100-007";

        	//部门账户
	        public static final String PLATE_ACCOUNT_MANAGEMENT = "AM-39200-000";
		        //部门账户查看所有部门
	            public static final String PLATE_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA = "AD-39200-001";
	            //部门账户查看自己部门
	            public static final String PLATE_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA = "AD-39200-002";
	            //部门账户汇总计算按钮
	            public static final String PLATE_ACCOUNT_CALCULATE_BUTTON = "AB-39200-001";
	            //部门账户汇总加锁按钮
	            public static final String PLATE_ACCOUNT_LOCK_BUTTON = "AB-39200-002";
	            //部门账户汇总解锁按钮
	            public static final String PLATE_ACCOUNT_MOVE_LOCK_BUTTON = "AB-39200-003";
	            //导出部门账户数据
	            public static final String PLATE_ACCOUNT_DOWNLOAD_BUTTON = "AB-39200-004";
	            //部门账户成本补贴按钮
	            public static final String PLATE_ACCOUNT_ADVINCE_BUTTON = "AB-39200-005";
	            //部门账户项目补贴按钮
	            public static final String PLATE_ACCOUNT_PROJECT_ADVANCE_BUTTON = "AB-39200-006";
	            //部门账户积分回收按钮
	            public static final String PLATE_ACCOUNT_ACHIEVE_INTEGRAL_RETURN_BUTTON = "AB-39200-007";
	            //部门账户品质管理按钮
	            public static final String PLATE_ACCOUNT_QUALITY_MANAGE_BUTTON = "AB-39200-008";
	            //部门账户公司费用按钮
	            public static final String PLATE_ACCOUNT_COMPANY_FEE_BUTTON = "AB-39200-009";
	            //部门账户绩效奖金按钮
	            public static final String PLATE_ACCOUNT_PORGER_MANCE_BUTTON = "AB-39200-010";
	            //部门账户积分还款按钮
	            public static final String PLATE_ACCOUNT_RETURN_INTEGRAL_BUTTON = "AB-39200-011";
	            //部门账户公司还款按钮
	            public static final String PLATE_ACCOUNT_COMPANY_RETURN_BUTTON = "AB-39200-012";
	            //部门账户项目违约金按钮
	            public static final String PLATE_ACCOUNT_VIOLATION_BUTTON = "AB-39200-013";
	            //部门账户分配积分按钮
	            public static final String PLATE_ACCOUNT_INTEGRAL_DISTRIBUTION_BUTTON = "AB-39200-014";
	            //部门账户协作费用按钮
	            public static final String PLATE_ACCOUNT_COLLABORATIVE_FEE_BUTTON = "AB-39200-015";
				//部门账户部门调配按钮
				public static final String PLATE_ACCOUNT_DEP_DEPLOY_BUTTON = "AB-39200-016";
				//部门账户产值结算按钮
				public static final String PLATE_ACCOUNT_OUTPUT_ACCOUNT_BUTTON = "AB-39200-017";
	        //个人账户
	        public static final String PERSONAL_ACCOUNT_MANAGEMENT = "AM-39300-000";
		        //个人账户查看所有部门
	            public static final String PERSONAL_ACCOUNT_MANAGEMENT_CHECK_ALL_DATA = "AD-39300-001";
	            //个人账户查看自己部门
	            public static final String PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYPLATE_DATA = "AD-39300-002";
	            //个人账户只能查看自己数据
	            public static final String PERSONAL_ACCOUNT_MANAGEMENT_CHECK_MYSELF_DATA = "AD-39300-003";
	            //导出所有的数据
	            public static final String EXPORT_ALL_DATE = "AB-39300-004";

            //奖金管理
            public static final String AWARD_SEND_MANAGEMENT = "AM-39400-000";
				//奖金发放
				public static final String BONUS_PAYMENT_MANAGEMENT = "AM-39410-000";
					//申请奖金发放
					public static final String BONUS_PAYMENT_APPLY_BUTTON = "AB-39410-001";
					//审核奖金发放信息
					public static final String BONUS_PAYMENT_AUDIT_BUTTON = "AB-39410-002";
					//查看所有部门的信息
					public static final String BONUS_PAYMENT_CHECK_ALL = "AD-39410-001";
					//查看自己管理部门的信息
					public static final String BONUS_PAYMENT_CHECK_MYSELF = "AD-39410-002";
					//二级账户申请奖金发放
					public static final String HAVE_LEVEL_TWO_PLATE_BONUS_APPLY_BUTTON = "AB-39410-003";
				//奖金汇总
				public static final String  AWARD_SEND_REPORT_MANAGEMENT  = "AM-39420-000";
					//奖金汇总查看所有部门
		            public static final String AWARD_SEND_CHECK_ALL_DATA = "AD-39420-001";
		            //奖金汇总查看自己部门
		            public static final String AWARD_SEND_CHECK_MYPLATE_DATA = "AD-39420-002";
	            //奖金补贴
                public static final String MANAGE_PROJECT_MANAGEMENT = "AM-39430-000";
        	        //奖金补贴新建
        	        public static final String MANAGE_PROJECT_SAVE_BUTTON = "AB-39430-001";
        	        //奖金补贴修改
        	        public static final String MANAGE_PROJECT_UPDATE_BUTTON = "AB-39430-002";
        	        //奖金补贴删除
        	        public static final String MANAGE_PROJECT_DELETE_BUTTON = "AB-39430-003";
        	        //奖金补贴积分发放
        	        public static final String MANAGE_PROJECT_ASSIGN_INTEGRAL_BUTTON = "AB-39430-004";
        	        //奖金补贴发放人员
        	        public static final String MANAGE_PROJECT_EMPLOYEE_BUTTON = "AB-39430-005";
        	        //奖金补贴查看所有部门
                    public static final String MANAGE_PROJECT_CHECK_ALL_DATA = "AD-39430-001";
                    //奖金补贴查看自己部门
                    public static final String MANAGE_PROJECT_CHECK_MYSELF_DATA = "AD-39430-002";
            //品质基金账户
            public static final String QUALITY_FUND_ACCOUNT = "AM-39500-000";
            //项目账户
            public static final String PROJECT_ACCOUNT = "AM-39600-000";
            //订单账户
            public static final String SHEET_ACCOUNT = "AM-39700-000";
	            //订单账户查看所有的数据
	        	public static final String SHEET_ACCOUNT_CHECK_ALL = "AD-39700-001";
	        	//订单账户查看自己管理的数据
	        	public static final String SHEET_ACCOUNT_CHECK_MYSELF = "AD-39700-002";

        //研发管理(研发项目)
        public static final String DEVELOP_PROJECT_MANAGEMENT_MENU = "AM-320000-000";
        	//研发管理公司研发立项按钮
        	public static final String DEVELOP_PROJECT_COMPANY_NEW = "AB-320000-001";
        	//研发管理部门研发立项按钮
        	public static final String DEVELOP_PROJECT_DEPARTMENT_NEW = "AB-320000-002";
        	//研发管理修改按钮
        	public static final String DEVELOP_PROJECT_UPDATE = "AB-320000-003";
        	//研发管理查看所有部门数据
        	public static final String DEVELOP_PROJECT_CHECK_ALL = "AD-320000-001";
        	//研发管理查看自己管理部门数据
        	public static final String DEVELOP_PROJECT_CHECK_MYSELF = "AD-320000-002";
        //资源管理(管理项目)
        public static final String MANAGE_PROJECT_MANAGEMENT_MENU = "AM-330000-000";
        	//资源管理公司研发立项按钮
	    	public static final String MANAGE_PROJECT_COMPANY_NEW = "AB-330000-001";
	    	//资源管理部门研发立项按钮
	    	public static final String MANAGE_PROJECT_DEPARTMENT_NEW = "AB-330000-002";
	    	//资源管理修改按钮
	    	public static final String MANAGE_PROJECT_UPDATE = "AB-330000-003";
	    	//资源管理查看所有部门数据
	    	public static final String MANAGE_PROJECT_CHECK_ALL = "AD-330000-001";
	    	//资源管理查看自己管理部门数据
	    	public static final String MANAGE_PROJECT_CHECK_MYSELF = "AD-330000-002";
	    //合同与订单
	    public static final String MANAGE_CONTRACT_LINK_PROJECT = "AM-380000-000";
	    	//关联订单
	    	public static final String MANAGE_CONTRACT_BIND = "AB-380000-001";
	    	//合同变更
	    	public static final String MANAGE_CONTRACT_CHANGE = "AB-380000-002";
	    	//解绑订单
	    	public static final String MANAGE_CONTRACT_UNBIND = "AB-380000-003";
	    	//查看未绑定订单
	    	public static final String MANAGE_CONTRACT_SHOW_UNBIND = "AB-380000-004";
	    	//查看项目积分
	    	public static final String MANAGE_CONTRACT_PROJECT_INTGRAL = "AD-380000-001";
	    	//查看业务部门下的合同
	    	public static final String MANAGE_CONTRACT_SHOW_PLATE = "AD-380000-002";
	    	//查看个人(专业负责人)
	    	public static final String MANAGE_CONTRACT_SHOW_MANAGE = "AD-380000-003";
	    	//查看所有
	    	public static final String MANAGE_CONTRACT_SHOW_ALL = "AD-380000-004";
	    //确认函管理
	    public static final String ATTACHMENT_MANAGE = "AM-390000-000";
		    //确认函列表
		    public static final String ATTACHMENT_LIST = "AM-391000-000";
			    //查看所有权限
	    		public static final String AL_VIEW_ALL_DATA = "AD-391000-001";
		    	//查看当前部门下
	    		public static final String AL_VIEW_DPT_DATA = "AD-391000-002";
		    	//查看个人
	    		public static final String AL_VIEW_OWN_DATA = "AD-391000-003";
		    //确认函与合同关联管理
		    public static final String ATTACHMENT_CONTRACT_MANAGE = "AM-392000-000";
		    	//查看所有权限
	    		public static final String AT_VIEW_ALL_DATA = "AD-392000-001";
		    	//查看当前部门下
	    		public static final String AT_VIEW_DPT_DATA = "AD-392000-002";
		    	//查看个人
	    		public static final String AT_VIEW_OWN_DATA = "AD-392000-003";
	    		//删除确认函
	    		public static final String AT_DELETE_BTN = "AB-392000-001";
	    		//修改确认函
	    		public static final String AT_UPDATE_BTN = "AB-392000-002";
	    		//修改确认函的成员信息
	    		public static final String AT_UPDATE_EMP_BTN = "AB-392000-003";
	    		//查看确认函
	    		public static final String AT_CHECK_BTN = "AB-392000-004";
	    	//合同资金
    		public static final String ATTACHMENT_CONTRACT_CAPITAL = "AM-393000-000";
    			//查看所有
    			public static final String ACC_VIEW_ALL_DATA = "AD-393000-001";
    			//查看项目负责人数据
    			public static final String ACC_VIEW_MANAGE_DATA = "AD-393000-002";
    			//查看大项目负责人数据
    			public static final String ACC_VIEW_SUPER_MANAGE_DATA = "AD-393000-003";
    			//查看总监数据
    			public static final String ACC_VIEW_MAJORDOMO_DATA = "AD-393000-004";
			//流程中的确认函
    		public static final String ATTACHMENT_WORKPROCESS = "AM-394000-000";
    		//确认函(会议)
    		public static final String ATTACHMENT_CONFERENCE = "AM-395000-000";
    	    	//财务
	    		public static final String AC_ALL_DATA = "AD-395000-001";
	    		//个人
	    		public static final String AC_OWN = "AD-395000-002";
	    		//发布确认函
	    		public static final String AC_PUBLISH_BUTTON = "AB-395000-001";
	    		//提交确认函
	    		public static final String AC_SUBMIT_BUTTON = "AB-395000-002";
	    		//定稿
	    		public static final String AC_END_BUTTON = "AB-395000-003";
	    		//撤销
	    		public static final String AC_REVOKE_BUTTON = "AB-395000-004";
	    		//发起确认函
	    		public static final String AC_START_BUTTON = "AB-395000-005";
	    		//删除确认函
	    		public static final String AC_DELETE_BUTTON = "AB-395000-006";
    		//确认函确认
    		public static final String ATTACHMENT_SURE = "AM-396000-000";
			//回收确认函
			public static final String RECOVERY_ATTACHMENT_SURE = "AB-396000-001";
		//运营变更信息
	    public static final String CONTRACT_CHANGE_LIST = "AM-3100000-000";
		    //编辑运营变更信息
		    public static final String CONTRACT_CHANGE_EDITOR = "AD-3100000-001";
		    //审核运营变更信息
		    public static final String CONTRACT_CHANGE_AUDITOR = "AD-3100000-002";
	    //绩效管理
	    public static final String PERFORMANCE_MANAGEMENT = "AM-3110000-000";
		    //查看所有数据
		    public static final String VIEW_ALL_DATA = "AD-3110000-001";
		    //查看个人的数据
		    public static final String VIEW_SELF_DATA = "AD-3110000-002";
		    //项目经理绩效奖励按钮
	    	public static final String CONTRACT_PERFORMANCE_AWARD_BUTTON = "AB-3110000-001";
	    	//项目经理绩效扣除按钮
	    	public static final String CONTRACT_PERFORMANCE_DEDUCT_BUTTON = "AB-3110000-002";
	    	//订单绩效奖励按钮
	    	public static final String PROJECT_PERFORMANCE_AWARD_BUTTON = "AB-3110000-003";
	    	//订单绩效扣除按钮
	    	public static final String PROJECT_PERFORMANCE_DEDUCT_BUTTON = "AB-3110000-004";
    	//成本二次调节
	    public static final String RESET_REIMBURSEMENT_COST = "AM-3120000-000";
	    //调节后的成本查询
	    public static final String REIMBURSEMENT_COST_AFTER_RESET = "AM-3130000-000";
	    	//成本二次调节查看所有数据
	    	public static final String RESET_REIMBURSEMENT_COST_CHECK_ALL = "AD-3120000-001";
	    	//成本二次调节查看自己所能查看的部门数据
	    	public static final String RESET_REIMBURSEMENT_COST_CHECK_MYPLATE = "AD-3120000-002";
	    //历史合同状态
	    public static final String CONTRACT_HISTORY_STATUS = "AM-3140000-000";
	    //团队管理
	    public static final String TEAM_MANAGEMENT = "AM-3150000-000";
		    //资源状态
		    public static final String EMPLOYEE_PROJECT_ANALYSIS = "AM-3151000-000";
		    	//查看所有部门成员数据
		    	public static final String EMPLOYEE_PROJECT_ANALYSIS_ALL_PLATE = "AD-3151000-001";
		    	//查看自己有权限的部门数据
		    	public static final String EMPLOYEE_PROJECT_ANALYSIS_SOME_PLATE = "AD-3151000-002";
		    //跨部门协作审批
	    	public static final String PROJECT_EMPLOYEE_AUDIT = "AM-3152000-000";
	    		//跨部门协作审批查看所有数据权限
	    		public static final String PROJECT_EMPLOYEE_AUDIT_ALL_PLATE = "AD-3152000-001";
	    		//跨部门协作审批查看本部门数据权限
	    		public static final String PROJECT_EMPLOYEE_AUDIT_MY_PLATE = "AD-3152000-002";
	    	//跨部门协作汇总
	    	public static final String PROJECT_EMPLOYEE_REPORT = "AM-3153000-000";
		    	//跨部门协作汇总查看所有数据权限
				public static final String PROJECT_EMPLOYEE_REPORT_ALL_PLATE = "AD-3153000-001";
				//跨部门协作汇总查看本部门数据权限
				public static final String PROJECT_EMPLOYEE_REPORT_MY_PLATE = "AD-3153000-002";
    	//合同状态变动日志
    	public static final String CONTRACT_STATUS_LOG = "AM-3160000-000";
    	//条线管理
    	public static final String PROJECT_MANAGE_LINE = "AM-3170000-000";
    	//营收确认管控
    	public static final String REVENUE_SURE_MANAGE = "AM-3180000-000";
	    	//营收确认预警
	    	public static final String REVENUE_SURE_WARN = "AM-3181000-000";
		    	//营收确认预警查看所有权限
		    	public static final String REVENUE_SURE_WARN_CHECK_ALL = "AD-3181000-001";
		    	//营收确认预警查看自己管理部门权限
		    	public static final String REVENUE_SURE_WARN_CHECK_PLATE = "AD-3181000-002";
	    	//项目绩效记录
	    	public static final String PROJECT_PERFORMANCE_RECORD = "AM-3182000-000";
	    	//绩效节点维护
	    	public static final String PROJECT_PERFORMANCE_NODE = "AM-3183000-000";
	    //项目阶段模板管理Project Stage Template Management
	    public static final String PROJECT_STAGE_TMEPLATE_MANAGEMENT = "AM-3190000-000";
	    	//编辑按钮
	    	public static final String PROJECT_STAGE_TMEPLATE_MANAGEMENT_UPDATE = "AB-3190000-001";
	    	//新增按钮
	    	public static final String PROJECT_STAGE_TMEPLATE_MANAGEMENT_ADD = "AB-3190000-002";
	    	//删除按钮
	    	public static final String PROJECT_STAGE_TMEPLATE_MANAGEMENT_DEL = "AB-3190000-003";
	    //定价管理
		public static final String PRICING_MANAGEMENT = "AM-3200000-000";
			//订单定价维护列表
			public static final String PRICING_MAINTAIN_MANAGEMENT = "AM-3210000-000";

    //运营管理平台***********************************************   end 


    //OA管理平台*************************************************   begin 
    //一级菜单 
    //OA管理平台
    public static final String  OA_MANAGEMENT = "AM-40000-000";
    //OA管理平台*************************************************   end


    //财务管理平台*********************************************   begin
    //一级菜单 
    //财务管理平台
	//账户管理测试
	public static final String ACCOUNTS_MANAGE = "AM-580001-000";
	//账户查询
	public static final String ACCOUNTS_QUERRY = "AM-580002-000";
	//查看账户所有流水
	public static final String ACCOUNTS_ALL_TRANSACTION = "AM-580003-000";




    public static final String K3_MANAGEMENT = "AM-50000-000";
	    //发票管理
	    public static final String INVOICES_MANAGMENT = "AM-51000-000";
	        //购买发票
	        public static final String ADD_INVOICES_MANAGEMENT = "AM-51100-000";
	        //填开发票
	        public static final String UPDATE_INVOICES_MANAGEMENT = "AM-51200-000";
	        //发出快递
	        public static final String SEND_INVOICES_MANAGEMENT = "AM-51300-000";
	        	//查看详情
	        	public static final String SIM_VIEW_DETAIL = "AB-51300-001";
	        	//发出快递
	        	public static final String SIM_SEND = "AB-51300-002";
	        	//确认寄出
	        	public static final String SIM_SEND_COMFIRM = "AB-51300-003";
	        	//修改快递
	        	public static final String SIM_UPDATE = "AB-51300-004";
	        	//签收登记
	        	public static final String SIM_SIGN = "AB-51300-005";
	        	//查询所有
	        	public static final String SIM_DATA_ALL = "AD-51300-001";
	        	//项目经理查询
	        	public static final String SIM_DATA_PROJECT_MANAGE = "AD-51300-002";
	        	//部门助理查询
	        	public static final String SIM_DATA_DEPARTMENT = "AD-51300-003";
		    //发票汇总
		    public static final String COUNT_INVOICES_MANAGEMENT = "AM-51400-000";
		    	//发票汇总查看所有数据
		    	public static final String INVOICES_MANAGEMENT_VIEW_ALL_DATA = "AD-51400-001";
		    	//发票汇总查看部门数据
		    	public static final String INVOICES_MANAGEMENT_VIEW_DEPARTMENT_DATA = "AD-51400-002";
		    	//发票汇总查看个人数据
		    	public static final String INVOICES_MANAGEMENT_VIEW_MINE_DATA = "AD-51400-003";
		    	//发票汇总关联合同按钮
		    	public static final String INVOICES_MANAGEMENT_LINK_CONTRACT = "AB-51400-001";
		    	//发票汇总负数发票按钮
		    	public static final String INVOICES_MANAGEMENT_NEGATIVE_INVOICE = "AB-51400-002";
		    	//发票汇总填开作废按钮
		    	public static final String INVOICES_MANAGEMENT_INVALID_INVOICE = "AB-51400-003";
		    	//发票汇总负数作废按钮
		    	public static final String INVOICES_MANAGEMENT_INVALID_NEGATIVE_INVOICE = "AB-51400-004";

		    //发票申请
		    public static final String APPLY_INVOICES_MANAGEMENT = "AM-51500-000";
		    	//新增申请
		    	public static final String ADD_APPLY_INVOICES_BTN = "AB-51500-001";
		    	//修改申请
		    	public static final String UPDATE_APPLY_INVOICES_BTN = "AB-51500-002";
		    	//驳回申请
		    	public static final String REJECT_APPLY_INVOICES_BTN = "AB-51500-003";
		    	//确认开票
		    	public static final String CONFIRM_ADD_INVOICES_BTN = "AB-51500-004";
		    	//查看所有申请
		    	public static final String VIEW_APPLY_INVOICES_ALL_DATA = "AD-51500-001";
	    	//进项税发票
		    public static final String TAX_INVOICES_MANAGEMENT = "AM-51600-000";
		    //进项税发票核对
		    public static final String TAX_INVOICES_MANAGEMENT_CHECK = "AM-51700-000";
		    //查看进项税记录
		    public static final String TAX_INVOICES_MANAGEMENT_RECORD = "AM-51800-000";
		    //进项税记录编辑
		    public static final String TAX_INVOICES_EDIT_RECORD = "AM-51800-001";
		    //进销核对表
		    public static final String REIMBURMENT_INVOICES_MANAGEMENT_RECORD = "AM-51900-000";

    	//发票管理平台***********************************************   end

        //收款管理
    	public static final String COLLECTION_PROJECT = "AM-52000-000";
    		//账单流水
    		public static final String ZD_LS = "AM-52100-000";
	    		//流水登记
	    		public static final String LS_DJ = "AB-52100-001";
	    		//绑定合同
	    		public static final String BING_HT = "AB-52100-002";
	    		//修改账单
	    		public static final String UPDATE_ZD = "AB-52100-003";
	    		//导出
	    		public static final String DC_LS = "AB-52100-004";
	    		//删除
	    		public static final String DEL_LS = "AB-52100-005";
	    		//回款分配
	    		public static final String HKFP_LS = "AB-52100-006";
	    		//手动回款分配
	    		public static final String SD_HKFP_LS = "AB-52100-007";
	    		//生成凭证
	    		public static final String ZD_SCPZ = "AB-52100-008";
	    		//删除凭证
	    		public static final String ZD_DPZ = "AB-52100-009";
//	    		//部门助理查看
//	    		public static final String BMZL_DATA = "AD-52100-001";
//	    		// 营销部门查看保证金权限
//	    		public static final String MK_DEPARTMENT_DATA = "AD-52100-002";
	    		//查看所有
	    		public static final String ZD_LS_ALL_DATA = "AD-52100-001";
	    		//查看部门
	    		public static final String ZD_LS_DEPRTMENT_DATA = "AD-52100-002";
	    		//查看个人
	    		public static final String ZD_LS_SELF_DATA = "AD-52100-003";
	    		
	    		
	    		
	    		
    		//项目回款
    		public static final String PROJECT_HK = "AM-52200-000";
    		//回款与发票
			public static final String PROJECT_HK_AND_FP = "AM-52300-000";
			//回款报表
			public static final String PROJECT_HK_REPORT = "AM-52400-000";
			//开票回款分析Billing collection analysis
			public static final String BILLING_COLLECTION_ANALYSIS = "AM-52500-000";
	    		//阶段回款
	    		public static final String JD_HK = "AB-52200-001";
	    		//发票回款
	    		public static final String FP_HK = "AB-52200-002";
	    		//回款报表查看所有数据权限
	    		public static final String PROJECT_HK_REPORT_CHECK_ALL = "AD-52400-001";
	    		//回款报表查看管理部门数据权限
	    		public static final String PROJECT_HK_REPORT_CHECK_MANAGE = "AD-52400-002";
	    		//回款报表查看个人管理数据权限
	    		public static final String PROJECT_HK_REPORT_CHECK_MYSELF = "AD-52400-003";

		//报销科目
		public static final String SUBJECT_TYPE = "AM-53000-000";
		//借款额度
		public static final String BORROW_LIMIT = "AM-54000-000";
		//收款单位
		public static final String RECEIVE_UNIT = "AM-55000-000";
		//收款单位
		public static final String BANK_UNIT = "AM-55100-000";
		//合同收款明细
		public static final String CONTRACT_MONEY_DETAIL_MANAGMENT = "AM-56000-000";
		//报销打包汇总
		public static final String REIMBURSEMENT_PACKAGE = "AM-57000-000";
			//查看所有打包数据的权限
			public static final String RP_VIEW_ALL_DATA = "AD-57000-001";
			//付款补充
			public static final String RP_ADD_PAYMENTINFO = "AB-57000-001";
			//通过打包审核
			public static final String RP_APPROVE_PROCESS = "AB-57000-002";
			//可添加打包
			public static final String RP_ADD_PACKAGE = "AB-57000-003";
			//删除打包
			public static final String RP_DELETE_PACKAGE = "AB-57000-004";
			//修改冲账金额
			public static final String RP_UPDATE_BLANCE = "AB-57000-005";
			//操作账单流水(财务经理)
			public static final String RP_UPDATE_BILL_LIST = "AB-57000-006";
			//打包完成后可修改付款方信息
			public static final String RP_UPDATE_COMPLETE = "AB-57000-007";
			//银企直连在线支付
			public static final String RP_CMB_PAY = "AB-57000-008";
		//报销入账指定
		public static final String FINANCIAL_ACCOUNTING = "AM-58000-000";
			//查看详情
			public static final String FA_VIEW = "AB-58000-001";
			//修改入账日期
			public static final String FA_UPDATE_DATE = "AB-58000-002";
			//导出
			public static final String FA_EXPORT = "AB-58000-003";

		//银行资金对账
		public static final String BANK_CAPITALS = "AM-59000-000";
			//银行资金对账--查看所有数据
			public static final String BANK_CAPITALS_CHECK_ALL = "AD-59000-001";
			//银行资金对账--查看所在公司数据
			public static final String BANK_CAPITALS_CHECK_MY_COMPANY = "AD-59000-002";
		//员工资金对账
		public static final String EMPLOYEE_CAPITALS = "AM-59100-000";
			//查看所有
			public static final String EC_SHOW_ALL = "AD-59100-001";
			//查看个人
			public static final String EC_SHOW_OWN = "AD-59100-002";
			//查看详情
			public static final String SHOW_DETAIL = "AB-59100-001";
			//进行对冲
			public static final String EC_BIND = "AB-59100-002";
			//取消对冲
			public static final String EC_UNBIND = "AB-59100-003";
			//隐藏已冲销
			public static final String EC_HIDE_BIND = "AB-59100-004";
			//完成冲销显示
			public static final String EC_SHOW_BIND = "AB-59100-005";
		//订单回款
		public static final String ORDER_HK = "AM-59200-000";
		//员工积分与回款
		public static final String EMPLOYEE_JF_HK = "AM-59300-000";
			//查看所有
			public static final String EMPLOYEE_JF_HK_VIEW_ALL_DATA = "AD-59300-001";
			//查看业务部门
			public static final String EMPLOYEE_JF_HK_VIEW_PLATE_DATA = "AD-59300-002";
			//查看自己
			public static final String EMPLOYEE_JF_HK_VIEW_OWN_DATA = "AD-59300-003";
		//合同与联系人关联与备注修改
		public static final String CONTRACT_REMARK_AND_CONTACTS = "AM-59400-000";
		//K3凭证
		public static final String K3_VOUCHER = "AM-59500-000";
			//成本K3凭证
			public static final String K3_VOUCHER_COST = "AM-59501-000";
			//收入/收款K3凭证
			public static final String K3_VOUCHER_INCOME = "AM-59502-000";
			//营收凭证
			public static final String K3_VOUCHER_REVENUE = "AM-59503-000";
			//确认函凭证
			public static final String K3_VOUCHER_ATTACHMENT = "AM-59504-000";
			//五险一金凭证
			public static final String K3_VOUCHER_INSURANCE_AND_HOUSING_FUND = "AM-59505-000";
			//工资凭证
			public static final String K3_VOUCHER_SALARY = "AM-59506-000";
			//所有凭证
			public static final String K3_VOUCHER_ALL = "AM-59507-000";
		//K3代码维护
		public static final String K3_CODE = "AM-59600-000";
			//公司K3代码维护
			public static final String COMPANY_K3_CODE = "AM-59601-000";
			//部门K3代码维护
			public static final String DEPARTMENT_K3_CODE = "AM-59602-000";
			//员工K3代码维护
			public static final String EMPLOYEE_K3_CODE = "AM-59603-000";
			//银行账号K3代码维护
			public static final String BANK_ACCOUNT_K3_CODE = "AM-59604-000";
			//科目K3代码维护
			public static final String SUBJECT_TYPE_K3_CODE = "AM-59605-000";
			//收款单位K3代码维护
			public static final String RECEIVE_UNIT_K3_CODE = "AM-59606-000";
			//客户K3代码维护
			public static final String CUSTOMER_K3_CODE = "AM-59607-000";
			//业务板块K3代码维护
			public static final String PLATE_AREA_K3_CODE = "AM-59608-000";
			//特定K3代码维护
			public static final String SPECIFIC_K3_CODE = "AM-59609-000";
		//财务资金报表
		public static final String CAPITAL_ANALYSIS = "AM-59700-000";
	    //汇总资金查询
	    public static final String CAPITAL_SUMMARY = "AM-59900-000";
	    //收款单位资金对账
	    public static final String RECEIVE_UNIT_CAPITALS = "AM-59910-000";
		    //查看所有
			public static final String RUC_SHOW_ALL = "AD-59910-001";
			//查看个人
			public static final String RUC_SHOW_OWN = "AD-59910-002";
		//报销查询
	    public static final String SEARCH_REIMBURSEMENT = "AM-510000-000";
		    //滞留单驳回按钮
		    public static final String SEARCH_REIMBURSEMENT_DISAGREE_BUTTON = "AB-510000-001";
	    //账户查询
	    public static final String Accounts_querry = "AM-510000-019";
	    //回款分配
	    public static final String CAPITAL_DISTRIBUTION = "AM-511000-000";
		    //回款分配信息列表
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST = "AM-511001-000";
		  //回款分配
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_DISTRIBUTION = "AB-511001-001";
		  //删除回款分配
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_DEL_DISTRIBUTION = "AB-511001-002";
		  //回款分配锁定
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_LOCK = "AB-511001-003";
		  //回款分配解锁
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_UNLOCK = "AB-511001-004";
		  //导出
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_EXPORT = "AB-511001-005";
		    //自动分配
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_AUTO_DISTRIBUTION = "AB-511001-006";
		    //回款分配信息列表  -- 产看所有
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_ALL = "AD-511001-001";
		    //回款分配信息列表  -- 查看部门
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_PLATE = "AD-511001-002";
		    //回款分配信息列表  -- 查看个人
		    public static final String ALL_CAPITAL_DISTRIBUTION_INFO_LIST_PROJECT_MANAGER = "AD-511001-003";
		    //部门回款分配
		    public static final String CAPITAL_DISTRIBUTION_OF_DEPARTMENT = "AM-511002-000";
		    //订单回款分配
		    public static final String CAPITAL_DISTRIBUTION_OF_PROJECT = "AM-511003-000";
		    //回款分配日志
		    public static final String CAPITAL_DISTRIBUTION_LOG = "AM-511004-000";
		    //回款分配差额明细
		    public static final String CAPITAL_DISTRIBUTION_ANALYZE = "AM-511005-000";
		    //回款分配查看所有部门数据权限
		    public static final String CAPITAL_DISTRIBUTION_CHECK_ALL = "AD-511000-001";
		    //回款分配只能看所在部门的数据权限
		    public static final String CAPITAL_DISTRIBUTION_CHECK_PLATE = "AD-511000-002";
		    //回款分配专业负责人只能查看自己的订单的回款数据权限
		    public static final String CAPITAL_DISTRIBUTION_CHECK_BY_PROJECT_MANAGER = "AD-511000-003";
	    //汇率维护
	    public static final String EXCHANGE_RATE = "AM-512000-000";
	    //报销单收单
	    public static final String FINANCE_RECEIVE_BILL = "AM-513000-000";
	    //人员收款单位对账
	    public static final String RECEIVE_UNIT_EMPLOYEE_CAPITALS = "AM-520000-000";
	    //公司银行卡维护
	    public static final String COMPANY_CARD_MANAGE = "AM-530000-000";
	    //合同小节点
	    public static final String STAGE_MODEL = "AM-540000-000";
	    //合同小节点模板
	    public static final String STAGE_MODEL_MANAGE = "AM-540001-000";
	    //合同小节点详情
	    public static final String CONTRACT_STAGE_MODEL_MANAGE = "AM-540002-000";
	    //合同小节点流程状态
	    public static final String CONTRACT_STAGE_PROCESS_LIST = "AM-540003-000";
	    //合同小节点项目经理审批
	    public static final String CONTRACT_STAGE_AUDIT_MANAGER = "AM-540004-000";
	    //合同小节点设计总监审批
	    public static final String CONTRACT_STAGE_AUDIT_DESIGNER = "AM-540005-000";
	    //招商银行数据
	    public static final String CMBC_MANAGE = "AM-550000-000";
		    //银行账户数据
		    public static final String CM_ACCOUNT_INFO = "AM-550001-000";
		    //银行交易数据
		    public static final String CM_TRANS_INFO = "AM-550002-000";
		    //银行收入资金核对
		    public static final String CM_CAPITAL_RECEIVE_CHECK = "AM-550003-000";
		    //银行支出核对
		    public static final String CM_CAPITAL_PAY_CHECK = "AM-550004-000";
	    //合同收入台账
		public static final String CONTRACT_INCOME_LEDGER = "AM-570000-000";
			//合同收入台账页面，查看所有数据
			public static final String CONTRACT_INCOME_LEDGER_VIEW_ALL = "AD-570000-001";
			//合同收入台账页面，仅查看与自己有关的数据
			public static final String CONTRACT_INCOME_LEDGER_VIEW_MINE = "AD-570000-002";
			//合同收入台账页面,加锁
			public static final String CONTRACT_INCOME_LEDGER_ON_LOCK = "AB-570000-003";
			//合同收入台账页面,解锁
			public static final String CONTRACT_INCOME_LEDGER_UP_LOCK = "AB-570000-004";
		//财务往来模块
		public static final String FINANCE_TRANS = "AM-580000-000";
			//财务往来汇总
			public static final String TRANS_DETAIL_SUMMARY = "AM-580001-000";
				//财务往来汇总查看所有数据
				public static final String TRANS_DETAIL_SUMMARY_VIEW_ALL = "AD-580001-001";
				//财务往来汇总查看部门数据
				public static final String TRANS_DETAIL_SUMMARY_VIEW_DEPARTMENT = "AD-580001-002";
				//财务往来汇总查看个人数据
				public static final String TRANS_DETAIL_SUMMARY_VIEW_MYSELF = "AD-580001-003";
			//财务往来明细
			public static final String TRANS_DETAILS = "AM-580002-000";
				//财务往来明细查看所有数据
				public static final String TRANS_DETAILS_VIEW_ALL = "AD-580002-001";
				//财务往来明细查看部门数据
				public static final String TRANS_DETAILS_VIEW_DEPARTMENT = "AD-580002-002";
				//财务往来明细查看个人数据
				public static final String TRANS_DETAILS_VIEW_MYSELF = "AD-580002-003";
				//往来明细-设置期初余额按钮
				public static final String TRANS_DETAILS_INIT = "AB-580002-001";
				//往来明细-新建按钮
				public static final String TRANS_DETAILS_CREATE_BUTTON = "AB-580002-002";
				//往来明细-修改按钮
				public static final String TRANS_DETAILS_UPDATE_BUTTON = "AB-580002-003";
				//往来明细-删除按钮
				public static final String TRANS_DETAILS_DELETE_BUTTON = "AB-580002-004";
			//经办往来汇总
			public static final String HANDING_TRANS_DETAIL_SUMMARY = "AM-580003-000";
				//经办往来汇总查看所有数据
				public static final String HANDING_TRANS_DETAIL_SUMMARY_VIEW_ALL = "AD-580003-001";
				//经办往来汇总查看部门数据
				public static final String HANDING_TRANS_DETAIL_SUMMARY_VIEW_DEPARTMENT = "AD-580003-002";
				//经办往来汇总查看个人数据
				public static final String HANDING_TRANS_DETAIL_SUMMARY_VIEW_MYSELF = "AD-580003-003";
			//经办往来明细
			public static final String HANDING_TRANS_DETAILS = "AM-580004-000";
				//经办往来明细查看所有数据
				public static final String HANDING_TRANS_DETAILS_VIEW_ALL = "AD-580004-001";
				//经办往来明细查看部门数据
				public static final String HANDING_TRANS_DETAILS_VIEW_DEPARTMENT = "AD-580004-002";
				//经办往来明细查看个人数据
				public static final String HANDING_TRANS_DETAILS_VIEW_MYSELF = "AD-580004-003";

    //财务K3管理平台*********************************************   end


    //预算管理*********************************************   begin
    //预算管理
	public static final String BUDGET_MANAGMENT = "AM-560000-000";
	//预算单管理
	public static final String BUDGET_APPLY = "AM-560000-001";
	//供应商管理
	public static final String SUPPLIER = "AM-560000-002";
	//预算管理查看个人
	public static final String BD_SETTLEMENT ="AB-560000-001";
	//预算管理查看自己部门
	public static final String BD_SETTLEMENT_DEPARTMENT ="AB-560000-003";
	//预算单查看所有
	public static final String BD_SETTLEMENT_ALL ="AB-560000-004";
	//预算编辑报销编号
	public static final String BD_EDIT_REIMBURSEMENT ="AB-560000-002";








    //预算管理*********************************************   end





    //个人管理****************   **********************************   begin
    //一级菜单 
    //个人管理 (我的J&A)
    public static final String MYSELF_MANAGEMENT = "AM-60000-000";
        //我的资料
        public static final String MY_INFO_MANAGEMENT = "AM-61000-000";
            //我的资料保存修改按钮
            public static final String MY_INFO_UPDATE_MANAGEMENT = "AB-61000-001";
            //我的资料上传头像按钮
            public static final String MY_INFO_UPLOAD_HEADIMG_MANAGEMENT = "AB-61000-002";

        //我的积分
        public static final String MY_INTEGRAL_MANAGEMENT = "AM-62000-000";
        //我的事务
        public static final String MY_TASK = "AM-63000-000";
	        //我的财务
	        public static final String MY_FINANCIAL = "AM-63100-000";
	        	//待办审批收单情况显示
	        	public static final String MY_FINANCIAL_RECEIVE_BILL = "AD-63100-001";
	        	//我的财务扫描
	        	public static final String MY_FINANCIAL_SEARCH_BILL = "AD-63100-002";
	        //我的人事
	        public static final String MY_PERSONNEL = "AM-63200-000";
	        	//我的人事辞退员工权限
	        	public static final String MY_PERSONNEL_RESIGN_EMPLOYEE = "AD-63200-001";
	        	//我的人事调薪查看所有人数据权限
	        	public static final String SALARY_ADJUSTMENT_APPLY_ALL = "AD-63200-002";
	        	//我的人事调薪查看本部门数据权限
	        	public static final String SALARY_ADJUSTMENT_APPLY_PLATE = "AD-63200-003";
	        	//我的人事薪资发放查询总金额权限
	        	public static final String SALARY_SHOW_TOTAL_FEE = "AD-63200-005";
	        	//我的人事入职申请按钮权限
	        	public static final String MY_PERSONNEL_ONBOARD_BUTTON = "AB-63200-001";
	        	//我的人事调薪申请按钮权限
	        	public static final String MY_PERSONNEL_SALARY_ADJUSTMENT_BUTTON = "AB-63200-002";
	        	//我的人事转正申请按钮权限
	        	public static final String MY_PERSONNEL_REGULAR_EMPLOYEE_BUTTON = "AB-63200-003";
	        	//我的人事资金发放按钮权限
	        	public static final String MY_PERSONNEL_PAYROLL_APPLY_BUTTON = "AB-63200-004";
	        	//我的人事培训申请按钮权限 trainingManagementsApply
	        	public static final String MY_PERSONNEL_TRAINING_APPLY_BUTTON = "AB-63200-005";


	    	//我的行政
	        public static final String MY_ADMINISTRATION = "AM-63300-000";
	        	//我的行政物品申请申请权限
	        	public static final String MY_ADMINISTRATION_GOODS_APPLY_BUTTON = "AB-63300-001";
	        	//我的行政采购申请权限
	        	public static final String MY_ADMINISTRATION_PURCHASE_APPLY_BUTTON = "AB-63300-002";
        	//运营流程
        	public static final String OPERATION_PROCESSOR = "AM-63400-000";
	        //我的考勤
		    public static final String MY_ATTENDANCE = "AM-66000-000";
			 //我的公告
		    public static final String MY_ANNOUCEMENT = "AM-67000-000";
			//会议室预约
		    public static final String  MY_MEETING_ROOM_RESERVATION_RECORD="AM-68000-000";
		    //我的工作
		    public static final String MY_WORK = "AM-63500-000";
		    //我的工时
		    public static final String MY_WORK_HOUR = "AM-63600-000";
		    	//我的工时--修改权限
				public static final String MY_WORK_HOUR_UPDATE = "AM-63600-004";
			  	//我的工时——查看所有
				public static final String MY_WORK_HOUR_VIEW_ALL_DATA = "AD-63600-001";
				//我的工时——查看业务部门
				public static final String MY_WORK_HOUR_VIEW_PLATE_DATA = "AD-63600-002";
				//我的工时——查看自己
				public static final String MY_WORK_HOUR_VIEW_OWN_DATA = "AD-63600-003";
				//我的工时——加锁按钮
				public static final String MY_WORK_HOUR_LOCK_BUTTON = "AB-63600-001";
				//我的工时——解锁按钮
				public static final String MY_WORK_HOUR_UNLOCK_BUTTON = "AB-63600-002";
        //我的待办
        public static final String MY_TO_DO_LIST = "AM-64000-000";
	        //审批事项
	        public static final String MY_TO_DO_LIST_APPROVAL_ITEMS = "AM-64100-000";
	        //知会事项
	        public static final String MY_TO_DO_LIST_INFORMED_ITEMS = "AM-64200-000";
	        //任务池
	        public static final String MY_TO_DO_LIST_TASK_POOL = "AM-64300-000";

        //我的已办
        public static final String MY_DONE_LIST = "AM-65000-000";
	        //审批事项
	        public static final String MY_DONE_LIST_APPROVAL_ITEMS = "AM-65100-000";
	        //知会事项
	        public static final String MY_DONE_LIST_INFORMED_ITEMS = "AM-65200-000";
	        //任务池
	        public static final String MY_DONE_LIST_TASK_POOL = "AM-65300-000";
	        //复制发起
	        public static final String MY_DONE_COPY_START = "AB-65000-000";
	    //可查看借款与预付款数据
	    public static final String VIEW_ALL_MONEY = "AD-60000-001";

    //个人管理**************************************************   end


    //系统管理**************************************************   begin
    //一级菜单 
    //系统管理
    public static final String SYSTEM_MANAGEMENT = "AM-70000-000";
    //系统管理**************************************************   end    


    //报表管理**************************************************   begin
    //一级菜单 
    //报表管理
    public static final String REPORT_MANAGEMENT = "AM-70000-000";
    	//二级菜单
		//人事报表
		public static final String THE_PERSONNEL_MANAGEMENT = "AM-70000-100";
		//营销报表
		public static final String MARKETING_MANAGEMENT = "AM-70000-200";
		//运营报表
		public static final String OPERATING_MANAGEMENT = "AM-70000-300";
			//工时报表
			public static final String WORKING_HOURS_MANAGEMENT = "AM-70000-301";
			//出图报表
			public static final String THE_FIGURE_MANAGEMENT = "AM-70000-302";
		//财务报表
		public static final String FINANCIAL_MANAGEMENT = "AM-70000-400";


        //积分汇总
        public static final String INTEGRAL_TOTAL_MANAGEMENT = "AM-71000-000";
        	//查看成员汇总按钮
        	public static final String INTEGRAL_TOTAL_VIEW_MEMBER = "AB-71000-001";
        //成员积分汇总
        public static final String EMPLOYEE_INTEGRAL_TOTAL_MANAGEMENT = "AM-72000-000";
            //成员积分汇总查看所有部门下的成员数据
            public static final String EMPLOYEE_INTEGRAL_TOTAL_CHECK_ALL_DATA = "AD-72000-001";
        //营收统计总表
        public static final String REPORT_OF_SUM_REVENUE_YEAR_RECORD = "AM-73000-000";
        	//营收统计总表查看所有数据权限
        	public static final String REPORT_OF_SUM_REVENUE_CHECK_ALL = "AD-73000-001";
        	//营收统计总表查看管理部门数据权限
        	public static final String REPORT_OF_SUM_REVENUE_CHECK_MANAGE_PLATE = "AD-73000-002";
		//部门收支表
		public static final String DEPARTMENT_INCOME_REPORT = "AM-73200-000";
			public static final String DEPARTMENT_INCOME_REPORT_ALL = "AM-73200-001";
        //确认积分总表
        public static final String REPORT_SURE_INTEGRAL_TOTAL = "AM-74000-000";
        //现金流总表
        public static final String REPORT_CAPITAL_TOTAL = "AM-75000-000";
        //薪酬总表
        public static final String REPORT_OF_SALARY_TOTAL = "AM-76000-000";
        //1	查看所有事业部权限
        public static final String REPORT_OF_SALARY_TOTAL_1 = "AD-76000-001";
        //2	查看所有职能部  权限
        public static final String REPORT_OF_SALARY_TOTAL_2 = "AD-76000-002";
        //3	查看所有营销部  权限
        public static final String REPORT_OF_SALARY_TOTAL_3 = "AD-76000-003";
        //查看所有权限
        public static final String REPORT_OF_SALARY_TOTAL_ALL = "AD-76000-004";
        //新签合同额总表
        public static final String REPORT_NEW_CONTRACT_TOTAL = "AM-77000-000";
        //员工人数总表
        public static final String REPORT_ON_EMPLOYEE_NUM_TOTAL = "AM-78000-000";
         //员工人数总表--查看所有部门的权限
        public static final String REPORT_ON_EMPLOYEE_NUM_TOTAL_ALL = "AD-78000-001";
        //员工人数总表--查看自己部门的权限
        public static final String REPORT_ON_EMPLOYEE_NUM_TOTAL_OUR = "AD-78000-002";
        //成本总表
        public static final String REPORT_COST_TOTAL = "AM-79000-000";
        //报表总表
        public static final String REPORT_TOTAL = "AM-710000-000";
        //性别分析总表
        public static final String REPORT_OF_GENDER_ANALYSIS = "AM-711000-000";
        //司龄分析总表
        public static final String REPORT_EMPLOYEE_WORK_YEARS = "AM-712000-000";
        //工资变动单
        public static final String REPORT_OF_SALARY_CHANGE_NOTICE = "AM-713000-000";
	      	//工资变动单查看全部数据权限
	        public static final String SALARY_CHANGE_NOTICE_CHECK_ALLDATA = "AD-713000-001";
	        //工资变动单查看自己管辖部门数据权限
	        public static final String SALARY_CHANGE_NOTICE_CHECK_SELFDATA = "AD-713000-002";
	    //人工成本对比分析表
        public static final String REPORT_OF_EMPLOYEE_COST_ANALYSIS = "AM-714000-000";
        //现金流收入报表
    	public static final String INCOME_MONEY_FOR_WEEK = "AM-715000-000";
    	//条件营收报表
    	public static final String BUSINESS_LINE_REVENUE = "AM-716000-000";
    	//条件营收明细表
    	public static final String BUSINESS_LINE_REVENUE_DETAIL = "AM-717000-000";
    	//签约合同报表
    	public static final String CONTRACT_AMOUNT_ANALYZE = "AM-718000-000";
	    	//签约合同报表查看所有权限
	    	public static final String CONTRACT_AMOUNT_ANALYZE_CHECK_ALLDATA = "AD-718000-001";
	    	//签约合同报表查看管理部门
	    	public static final String CONTRACT_AMOUNT_ANALYZE_CHECK_SELFDATA = "AD-718000-002";
    	//合同存量报表
    	public static final String CONTRACT_SAVE_ANALYZE = "AM-719000-000";
    	//条线运营报表Business Line Analyze
    	public static final String BUSINESS_LINE_ANALYZE = "AM-720000-000";
    	//定价分析表regular_price_analyze
    	public static final String REGULAR_PRICE_ANALYZE = "AM-721000-000";
    	//回款分析表Collectionrevenue analysis
    	public static final String COLLECTION_REVENUE_ANALYSIS = "AM-722000-000";
    		public static final String COLLECTION_REVENUE_CHECK_ALL_DATA = "AD-722000-001";
    		public static final String COLLECTION_REVENUE_CHECK_MYSELF_DATA = "AD-722000-002";
    	//奖金汇总表
    	public static final String BONUS_SUMMARY = "AM-723000-000";
    	//工资奖金分析表
    	public static final String SALARY_BONUS_ANALYSIS = "AM-724000-000";
    	//工资奖金分析表
    	public static final String PER_CAPITA_SALARY_ANALYSIS = "AM-725000-000";
    	//年龄结构分析总表
    	public static final String REPORT_ON_EMPLOYEE_AGE_TOTAL = "AM-726000-000";
    	//职级结构分析总表
    	public static final String REPORT_ON_EMPLOYEE_GRADE_TOTAL = "AM-727000-000";
    	//学历结构分析总表
    	public static final String REPORT_ON_EMPLOYEE_EDUCATION_TOTAL = "AM-728000-000";
    	//工龄结构分析总表
    	public static final String REPORT_ON_EMPLOYEE_SENIORITY_TOTAL = "AM-729000-000";
    	//人员流动分析总表
    	public static final String REPORT_ON_EMPLOYEE_TURNOVER_TOTAL = "AM-730000-000";
    	//效益指数分析
    	public static final String REPORT_ON_EMPLOYEE_BENEFIT_TOTAL = "AM-731000-000";
    	//落标汇总表 OnLoadBidPaySheetProjectSummary
    	public static final String ON_LOAD_BID_PAY_SHEET_PROJECT_SUMMARY = "AM-732000-000";
		//员工日工时统计表
		public static final String REPORT_EMPLOYEE_DAILY_HOURS_TOTAL = "AM-733000-000";
		//项目工时统计表
		public static final String REPORT_PROJECT_WORK_TIME_TOTAL = "AM-734000-000";
		//出图统计表
		public static final String REPORT_MAP_TOTAL = "AM-735000-000";
			//出图统计表查看所有权限
			public static final String REPORT_MAP_QUERY_ALL = "AM-735000-001";
			//出图统计表查看管理部门权限
			public static final String REPORT_MAP_QUERY_DEPARTNENT = "AM-735000-002";
			//出图统计表查看自己权限
			public static final String REPORT_MAP_QUERY_MYSELF = "AM-735000-003";
		//配合统计表
		public static final String COOPERATE_STATISTICS_TOTAL = "AM-736000-000";
			//配合统计表查看所有权限
			public static final String COOPERATE_STATISTICS_QUERY_ALL = "AD-736000-001";
			//配合统计表查看管理部门权限
			public static final String COOPERATE_STATISTICS_QUERY_DEPARTNENT = "AD-736000-002";
			//配合统计表查看申请人权限
			public static final String COOPERATE_STATISTICS_QUERY_MYSELF = "AM-736000-003";
		//员工参与订单表
		public static final String EMPLOYEES_ORDERS_TOTAL = "AM-737000-000";
			//员工参与订单表查看所有权限
			public static final String EMPLOYEES_ORDERS_QUERY_ALL = "AD-737000-001";
			//员工参与订单表查看管理部门权限
			public static final String EMPLOYEES_ORDERS_QUERY_DEPARTNENT = "AD-737000-002";
		//人员结构总览
		public static final String EMPLOYEES_STRUCTURE_OVERVIEW_TOTAL = "AM-738000-000";
    //报表管理**************************************************   end

    //报销收款信息补全
    public static final String  REIMBURSEMENT_INFO = "AM-80000-000";
    //查看报销收款信息所有信息
    public static final String  CHECK_ALL_REIMBURSEMENT_INFO = "AD-80000-001";
    //查看个人报销收款信息
    public static final String  CHECK_MYSELF_REIMBURSEMENT_INFO = "AD-80000-002";

  //报销收款信息补全
    public static final String  TEST_MENU = "AM-90000-000";

    //杰恩官网
    public static final String JAID_MENU  = "AM-10100-000";
    	//杰恩公告
    	public static final String JAID_GG  = "AM-10100-001";
    	//项目经验
    	public static final String JAID_PROJECT_EXPERIENCE  = "AM-10200-000";
    	//新闻媒体
    	public static final String JAID_NEWS_MEDIA  = "AM-10300-000";

	//cwd_menu
    public static final String CWD_MENU = "AM-110000-000";
    	//OSS配置管理页面
    	public static final String CWD_OSS_CONFIG_MANAGE = "AM-111000-000";
    	//项目策划管理
    	public static final String PROJECT_PLAN_MANAGE = "AM-112000-000";
    		//任务模板管理
    		public static final String TASK_TEMPLATE_MANAGE = "AM-112100-000";
		//公司工作场所配置管理
    	public static final String COMPANY_WORKPLACE_MANAGE = "AM-113000-000";
    	//员工注册地址管理
    	public static final String PERSONAL_REGISTER_ADDRESS_MANAGE = "AM-114000-000";
    	//文件过滤管理
    	public static final String CWD_FILE_FILTER_MANAGE = "AM-115000-000";
    	// 文件归档模板管理
    	public static final String CWD_FILING_TEMPLATE_MANAGE = "AM-116000-000";
    	// 本地系统更新发布
    	public static final String CWD_LOCAL_SYSTEM_UPDATE_MANAGE = "AM-117000-000";
    	// CDC项目监管
    	public static final String CWD_VIEW_PROJECT_MANAGE = "AM-118000-000";
    	// CDC软件安装记录
    	public static final String CWD_VIEW_SOFT_INSTALL_MANAGE = "AM-119000-000";
    	// CDC软件操作记录
    	public static final String CWD_VIEW_SOFT_UPDATE_MANAGE = "AM-1190000-000";
    	// 项目权限管理
    	public static final String CDC_PROJECT_PERMISSION = "AM-11100000-000";


	//供应链管理
	public static final String PURCHASE_MANAGEMENT = "AM-100000-000";
		//供应商管理
		public static final String SUPPLIER_MANAGEMENT = "AM-101000-000";
			//供应商管理新增
			public static final String SUPPLIER_MANAGEMENT_ADD = "AB-101000-001";
			//供应商管理修改
			public static final String SUPPLIER_MANAGEMENT_UPDATE = "AB-101000-002";
			//供应商管理发起评价
			public static final String SUPPLIER_MANAGEMENT_APPRAISE = "AB-101000-003";
		// 产品品类管理
		public static final String PRODUCT_CATEGORY_MANAGEMENT = "AM-102000-000";
			// 产品品类新增
			public static final String PRODUCT_CATEGORY_ADD = "AB-102000-001";
			// 产品品类修改
			public static final String PRODUCT_CATEGORY_UPDATE = "AB-102000-002";
			// 产品品类删除
			public static final String PRODUCT_CATEGORY_DELETE = "AB-102000-003";
		// 产品管理
		public static final String PRODUCT_MANAGEMENT = "AM-103000-000";
			// 产品新增
			public static final String PRODUCT_MANAGEMENT_ADD = "AB-102000-001";
			// 产品修改
			public static final String PRODUCT_MANAGEMENT_UPDATE = "AB-102000-002";
			// 产品删除
		// 采购订单付款模板
		public static final String PURCHASE_PAYMENT_TEMPLATE = "AM-104000-000";
		// 采购计划
		public static final String PURCHASE_PLAN = "AM-105000-000";
		// 采购付款计划
		public static final String PURCHASE_PAYMENT = "AM-106000-000";
		// 采购合同
		public static final String PURCHASE_CONTRACT = "AM-107000-000";
		//仓库管理
		public static final String STORAGE_MANAGE = "AM-108000-000";
		//仓库设置
		public static final String STORAGE_SET = "AM-108100-000";

}
