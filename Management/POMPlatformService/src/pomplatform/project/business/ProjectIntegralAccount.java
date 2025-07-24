package pomplatform.project.business;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseBonusPaymentDetail;
import com.pomplatform.db.bean.BaseEmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.bean.BaseEmployeeReportRecord;
import com.pomplatform.db.bean.BaseEmployeeRole;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BaseEmployeeSalaryReturnRecord;
import com.pomplatform.db.bean.BaseEmployeeViolationCharge;
import com.pomplatform.db.bean.BaseManageProject;
import com.pomplatform.db.bean.BaseManageProjectEmployeeRecord;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateIntegralAchieve;
import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BasePlateReportRecord;
import com.pomplatform.db.bean.BasePlateSalaryAdvanceRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectEmployeeAdvanceRecord;
import com.pomplatform.db.bean.BaseProjectIntegralSumRecord;
import com.pomplatform.db.bean.BaseProjectReportRecord;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.dao.BonusPaymentDetail;
import com.pomplatform.db.dao.EmployeeAchieveIntegralReturnRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeReportRecord;
import com.pomplatform.db.dao.EmployeeRole;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryReturnRecord;
import com.pomplatform.db.dao.EmployeeViolationCharge;
import com.pomplatform.db.dao.ManageProject;
import com.pomplatform.db.dao.ManageProjectEmployeeRecord;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateIntegralAchieve;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.dao.PlateIntegralSumRecord;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateReportRecord;
import com.pomplatform.db.dao.PlateSalaryAdvanceRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployeeAdvanceRecord;
import com.pomplatform.db.dao.ProjectIntegralSumRecord;
import com.pomplatform.db.dao.ProjectReportRecord;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.SystemConfig;
import com.pomplatform.db.dao.SystemDictionary;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.Employee;
import pomplatform.addProjectEmpSalary.bean.BaseMaddProjectEmpSalary;
import pomplatform.addProjectEmpSalary.bean.ConditionMaddProjectEmpSalary;
import pomplatform.addProjectEmpSalary.query.QueryMaddProjectEmpSalary;
import pomplatform.common.utils.StaticUtils;

/**
 * 板块项目积分按每月计算
 *
 * @author lxf
 */
public class ProjectIntegralAccount implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger("");
    private static final int DIC_TYPE_ID = 1;//系统字典表中的数据类型(项目类型，即业务部门ID)
    private static final int IS_LOCK = 1;//数据被锁定标示
    private static final int TYPE_FLAG_0 = 0;//项目汇总
    private static final int TYPE_FLAG_1 = 1;//部门汇总

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        ThreadConnection.beginTransaction();
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取当前计算人的所属业务部门
        int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
        //获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        Date startDate = new Date(Long.valueOf(startDateStr));
        //设置开始日期的第一天的日期
        startDate = DateUtil.getFirstDay(startDate);
        //获取当前计算的结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        //设置结束日期的最后一天的日期
        endDate = DateUtil.getLastDay(endDate);
        //判断结束月份是否大于开始月份，否则抛出异常
        if(startDate.after(endDate)){
        	throw new SQLException("计算的开始日期不可大于结束日期,请重置");
        }
        
        int result = execAccount(plateId,startDate,endDate);
        BaseCollection bc = new BaseCollection();
        return bc.toJSON(result, null);
    }
    
    
    public int execAccount(int plateId,Date startDate,Date endDate) throws Exception{
    	ThreadConnection.beginTransaction();
        int result = 0;//初始化计算后的返回参数为0：表示成功;-1表示失败
        //需要计算回收积分的角色ID
        Object[] integralReturnRoleArr = {StaticUtils.ROLE_INTEGRAL_EXECUTIVE, StaticUtils.ROLE_ANNUAL_SALARY_EMPLOYEE};
        //检索所有项目预留积分的确认积分
        StringBuilder plateProjectAccountRecordSql = new StringBuilder();
        plateProjectAccountRecordSql.append(BasePlateProjectAccountRecord.CS_ACCOUNT_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateProjectAccountRecord.CS_ACCOUNT_DATE).append(" <= '").append(endDate).append("'");
        PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
        plateProjectAccountRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateProjectAccountRecord> plateProjectAccountRecordList = plateProjectAccountRecordDao.conditionalLoad(plateProjectAccountRecordSql.toString());
        
        //检索公司给部门补贴的积分
        StringBuilder plateIntegralSendSql = new StringBuilder();
    	plateIntegralSendSql.append(BasePlateIntegralSend.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralSend.CS_SEND_DATE).append(" <= '").append(endDate).append("'");
        PlateIntegralSend plateIntegralSendDao = new PlateIntegralSend();
        plateIntegralSendDao.setConditionPlateId("=", plateId);
        List<BasePlateIntegralSend> plateIntegralSendList = plateIntegralSendDao.conditionalLoad(plateIntegralSendSql.toString());
        
        //离职员工每月价值积分回收记录表数据集
        StringBuilder employeeAchieveIntegralReturnRecordSql = new StringBuilder();
        employeeAchieveIntegralReturnRecordSql.append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" <= '").append(endDate).append("'");
        EmployeeAchieveIntegralReturnRecord employeeAchieveIntegralReturnRecordDao = new EmployeeAchieveIntegralReturnRecord();
        employeeAchieveIntegralReturnRecordDao.setConditionPlateId("=", plateId);
        List<BaseEmployeeAchieveIntegralReturnRecord> employeeAchieveIntegralReturnRecordList = employeeAchieveIntegralReturnRecordDao.conditionalLoad(employeeAchieveIntegralReturnRecordSql.toString());
        
        //员工每月积分还款记录表数据集
        StringBuilder employeeSalaryReturnRecordSql = new StringBuilder();
        employeeSalaryReturnRecordSql.append(BaseEmployeeSalaryReturnRecord.CS_RECORD_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseEmployeeSalaryReturnRecord.CS_RECORD_DATE).append(" <= '").append(endDate).append("'");
        EmployeeSalaryReturnRecord employeeSalaryReturnRecordDao = new EmployeeSalaryReturnRecord();
        employeeSalaryReturnRecordDao.setConditionPlateId("=", plateId);
        List<BaseEmployeeSalaryReturnRecord> employeeSalaryReturnRecordList = employeeSalaryReturnRecordDao.conditionalLoad(employeeSalaryReturnRecordSql.toString());
        
        //部门发放给管理项目的积分
        StringBuilder mangetProjectSql = new StringBuilder();
    	mangetProjectSql.append(BaseManageProject.CS_PROJECT_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseManageProject.CS_PROJECT_DATE).append(" <= '").append(endDate).append("'");
        ManageProject mangetProjectDao = new ManageProject();
        mangetProjectDao.setConditionPlateId("=",plateId);
        List<BaseManageProject> mangetProjectList = mangetProjectDao.conditionalLoad(mangetProjectSql.toString());
        
        //部门的运营成本
        StringBuilder plateCostRecordSql = new StringBuilder();
    	plateCostRecordSql.append(BasePlateCostRecord.CS_COST_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateCostRecord.CS_COST_DATE).append(" <= '").append(endDate).append("'");
        PlateCostRecord plateCostRecordDao = new PlateCostRecord();
        plateCostRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateCostRecord> plateCostRecordList = plateCostRecordDao.conditionalLoad(plateCostRecordSql.toString());
        
        //部门每月人工成本补偿记录表数据集
        StringBuilder plateSalaryAdvanceRecordSql = new StringBuilder();
        plateSalaryAdvanceRecordSql.append(BasePlateSalaryAdvanceRecord.CS_RECORD_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateSalaryAdvanceRecord.CS_RECORD_DATE).append(" <= '").append(endDate).append("'");
        PlateSalaryAdvanceRecord plateSalaryAdvanceRecordDao = new PlateSalaryAdvanceRecord();
        plateSalaryAdvanceRecordDao.setConditionPlateId("=", plateId);
        List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceRecordList = plateSalaryAdvanceRecordDao.conditionalLoad(plateSalaryAdvanceRecordSql.toString());
       
        //部门项目补贴记录表数据集
        StringBuilder projectAdvanceRecordSql = new StringBuilder();
        projectAdvanceRecordSql.append(BaseProjectAdvanceRecord.CS_ADVANCE_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseProjectAdvanceRecord.CS_ADVANCE_DATE).append(" <= '").append(endDate).append("'");
        ProjectAdvanceRecord projectAdvanceRecordDao = new ProjectAdvanceRecord();
        projectAdvanceRecordDao.setConditionPlateId("=", plateId);
        List<BaseProjectAdvanceRecord> projectAdvanceRecordList = projectAdvanceRecordDao.conditionalLoad(projectAdvanceRecordSql.toString());
        
        //部门发给品管部门的品质管理费
        StringBuilder qualityFeeSql = new StringBuilder();
        qualityFeeSql.append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" <= '").append(endDate).append("'");
        PlateIntegralAchieve qualityFeeDao = new PlateIntegralAchieve();
        qualityFeeDao.setConditionFromPlateId("=", plateId);
        qualityFeeDao.setConditionToPlateId(">", 0);
        List<BasePlateIntegralAchieve> qualityList = qualityFeeDao.conditionalLoad(qualityFeeSql.toString());
        
        //部门发给公司账户的公司费用
        StringBuilder companyFeeSql = new StringBuilder();
        qualityFeeSql.append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" <= '").append(endDate).append("'");
        PlateIntegralAchieve companyFeeDao = new PlateIntegralAchieve();
        companyFeeDao.setConditionFromPlateId("=", plateId);
        companyFeeDao.setConditionToPlateId("=", 0);
        List<BasePlateIntegralAchieve> companyFeeList = companyFeeDao.conditionalLoad(companyFeeSql.toString());
        
        //部门从员工账户上收取的项目违规金
        StringBuilder violationChargesSql = new StringBuilder();
        violationChargesSql.append(BaseEmployeeViolationCharge.CS_VIOLATION_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseEmployeeViolationCharge.CS_VIOLATION_DATE).append(" <= '").append(endDate).append("'");
        EmployeeViolationCharge violationChargesDao = new EmployeeViolationCharge();
        violationChargesDao.setConditionPlateId("=", plateId);
        violationChargesDao.unsetSelectFlags();
        violationChargesDao.setSelectViolationCharges(true);
        violationChargesDao.setSelectViolationDate(true);
        List<BaseEmployeeViolationCharge> violationChargesList = violationChargesDao.conditionalLoad(violationChargesSql.toString());
        
        //检索所有的项目信息
        Project projectDao = new Project();
        projectDao.unsetSelectFlags();
        projectDao.setSelectProjectId(true);
        projectDao.setSelectPlateId(true);//业务部门
        projectDao.setConditionPlateId("=",plateId);
        List<BaseProject> projectList = projectDao.conditionalLoad();
        Object[] projectIds = new Object[projectList.size()];
        int k = 0;
        if(!BaseHelpUtils.isNullOrEmpty(projectList) && !projectList.isEmpty()){
        	for(BaseProject e : projectList){
        		projectIds[k] = BaseHelpUtils.getIntValue(e.getProjectId());
        		k++;
        	}
        }

        //检索项目成本信息
        StringBuilder projectCostSql = new StringBuilder();
        projectCostSql.append(BaseProjectCost.CS_COST_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseProjectCost.CS_COST_DATE).append(" <= '").append(endDate).append("'");
        ProjectCost projectCostDao = new ProjectCost();
        if(projectIds.length>0){
        	projectCostDao.addCondition(BaseProjectCost.CS_PROJECT_ID,"in", projectIds);
        }else{
        	projectCostDao.addCondition(BaseProjectCost.CS_PROJECT_ID,"in", 0);
        }
        List<BaseProjectCost> projectCostList = projectCostDao.conditionalLoad();

        //检索项目结算记录信息
        StringBuilder projectSettlementsql = new StringBuilder();
        projectSettlementsql.append(BaseProjectSettlement.CS_SETTLEMENT_DATE).append(" >= '").append(startDate).append("' and ").append(BaseProjectSettlementDetail.CS_SETTLEMENT_DATE).append(" <= '").append(endDate).append("'");
        ProjectSettlement projectSettlementDao = new ProjectSettlement();
        if(projectIds.length>0){
        	projectSettlementDao.addCondition(BaseProjectSettlement.CS_PROJECT_ID,"in", projectIds);
        }else{
        	projectSettlementDao.addCondition(BaseProjectSettlement.CS_PROJECT_ID,"in", 0);
        }
        List<BaseProjectSettlement> projectSettlementList = projectSettlementDao.conditionalLoad(projectSettlementsql.toString());
        
        //获取开始日期和结束日期相差的月数
        int months = DateUtil.getCompareMonths(startDate, endDate)+1;
        Date customDate = startDate;
        
        //按月份遍历，计算每一个月每一个业务部门的数据
        PlateReportRecord plateReportRecordDao = new PlateReportRecord();//部门汇总表
        ProjectReportRecord projectReportRecordDao = new ProjectReportRecord();//项目汇总表
        EmployeeReportRecord employeeReportRecordDao = new EmployeeReportRecord();//职员汇总表
        BasePlateReportRecord plateReportRecordBean;
        BaseProjectReportRecord projectReportRecordBean;
        BaseEmployeeReportRecord employeeReportRecordBean;
        
        //根据当前计算开始日期和结束日期去检索未加锁的数据
        StringBuilder plateReportRecordSql = new StringBuilder();
        plateReportRecordSql.append(BasePlateReportRecord.CS_RECORD_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateReportRecord.CS_RECORD_DATE).append(" <= '").append(endDate).append("'");
        plateReportRecordDao.setConditionPlateId("=", plateId);
        plateReportRecordDao.setConditionIsLock("=",Boolean.FALSE);
        List<BasePlateReportRecord> plateReportRecordList = plateReportRecordDao.conditionalLoad(plateReportRecordSql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateReportRecordList) && !plateReportRecordList.isEmpty()){
        	for(BasePlateReportRecord e : plateReportRecordList){
        		Date recordDate = e.getRecordDate();
        		//先清除掉当前计算月,部门汇总的数据
                plateReportRecordDao.clear();
            	plateReportRecordDao.setConditionPlateId("=",plateId);
            	plateReportRecordDao.setConditionRecordDate("=", recordDate);
            	plateReportRecordDao.conditionalDelete();
            	//先清除掉当前计算月,项目汇总的数据
            	projectReportRecordDao.clear();
            	projectReportRecordDao.setConditionPlateId("=",plateId);
            	projectReportRecordDao.setConditionRecordDate("=", recordDate);
            	projectReportRecordDao.conditionalDelete();
            	//先清除掉当前计算月,成员汇总的数据
            	employeeReportRecordDao.clear();
            	employeeReportRecordDao.setConditionPlateId("=",plateId);
            	employeeReportRecordDao.setConditionRecordDate("=", recordDate);
            	employeeReportRecordDao.conditionalDelete();
            	
            	//清除积分还款记录表数据
        		employeeSalaryReturnRecordDao.clear();
        		employeeSalaryReturnRecordDao.setConditionPlateId("=",plateId);
        		employeeSalaryReturnRecordDao.setConditionRecordDate("=",recordDate);
        		employeeSalaryReturnRecordDao.conditionalDelete();
        		
        		//清除积分借款记录表数据
        		plateSalaryAdvanceRecordDao.clear();
        		plateSalaryAdvanceRecordDao.setConditionPlateId("=",plateId);
        		plateSalaryAdvanceRecordDao.setConditionRecordDate("=",recordDate);
        		plateSalaryAdvanceRecordDao.conditionalDelete();
        		
        	}
        }
        
        //获取工资秘钥
        SystemConfig systemConfigDao = new SystemConfig();
        systemConfigDao.setSystemConfigId(2);
        systemConfigDao.load();
        String key = systemConfigDao.getImagePath();
        DES des = new DES(key);
        //按日期去遍历计算
        for (int i = 0;i<months;i++) {
        	//获取当前日期的年份
        	int year = DateUtil.getYear(customDate);
        	//获取当前日期的月份
        	int month = DateUtil.getMonth(customDate);
        	//根据当前月份去检索是否当前月份的数据有被上锁，如果已上锁，则不可再进行计算
        	plateReportRecordDao.clear();
        	plateReportRecordDao.setConditionPlateId("=",plateId);
        	plateReportRecordDao.setConditionRecordDate("=", customDate);
            //检索当前计算月是否被上锁;0:未锁定;1:锁定
        	plateReportRecordDao.setConditionIsLock("=", Boolean.TRUE);
            if (plateReportRecordDao.countRows() > 0) {
            	//每遍历一次，都将当期日期都累加一个月
            	customDate = DateUtil.getNextMonth(customDate);
                continue;
            } 
            
        	int yearCompare = 0;
        	int monthCompare = 0;
        	
    		//****************************************************人员汇总开始*******************
        	
            //初始化成员积分还款到部门的总积分
        	BigDecimal salaryReturnBig = BigDecimal.ZERO;
            //获取该部门当前月下的所有职员的数据集
            Object[] empArr = getEmpArrOfPlate(plateId, year, month);
            if(!BaseHelpUtils.isNullOrEmpty(empArr)){
            	//获取当前计算月的最后一天的日期
            	Date endCustomDate = DateUtil.getLastDay(customDate);
            	for(Object obj : empArr){
            		int employeeId = BaseHelpUtils.getIntValue(obj);
            		Employee employeeDao = new Employee();
            		employeeDao.setEmployeeId(employeeId);
            		if(employeeDao.load()){
            			boolean integralReturnStatus = false;//是否为积分回收对象（积分回收对象包括：离职员工、年薪员工和积分高管）
            			if(!employeeDao.getStatus().equals(StaticUtils.EMPLOYEE_NORMAL)){
            				integralReturnStatus = true;
            			}else{
	            			EmployeeRole er = new EmployeeRole();
		            		er.setConditionEmployeeId("=", employeeId);
		            		er.addCondition(BaseEmployeeRole.CS_ROLE_ID, "in", integralReturnRoleArr);
		            		if(employeeDao.getStatus()!=0 || er.countRows() > 0){
		            			integralReturnStatus = true;
		            		}
            			}
	            		//获取该人员在当前计算月在项目上确认的积分
	            		StringBuilder projectSettlementDetailSql = new StringBuilder();
	            		projectSettlementDetailSql.append(BaseProjectSettlementDetail.CS_SETTLEMENT_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseProjectSettlementDetail.CS_SETTLEMENT_DATE).append(" <= '").append(endCustomDate).append("'");
	            		ProjectSettlementDetail projectSettlementDetailDao = new ProjectSettlementDetail();
	            		projectSettlementDetailDao.setConditionEmployeeId("=",employeeId);
	            		List<BaseProjectSettlementDetail> projectSettlementDetailList = projectSettlementDetailDao.conditionalLoad(projectSettlementDetailSql.toString());
	            		//项目确认积分
	            		BigDecimal sureIntegralEmpBig = BigDecimal.ZERO;
	            		//项目成本
	            		BigDecimal projectCostEmpBig = BigDecimal.ZERO;
						if (!BaseHelpUtils.isNullOrEmpty(projectSettlementDetailList)
								&& !projectSettlementDetailList.isEmpty()) {
							for (BaseProjectSettlementDetail e : projectSettlementDetailList) {
								sureIntegralEmpBig = null == e.getRealAmount() ? sureIntegralEmpBig : sureIntegralEmpBig.add(e.getRealAmount());
								projectCostEmpBig = null == e.getProjectCost() ? projectCostEmpBig : projectCostEmpBig.add(e.getProjectCost());
							}
						}
	            		
	            		//获取该人员在当前计算月在管理项目上获取的发放积分
	            		StringBuilder manageProjectEmployeeRecordSql = new StringBuilder();
	            		manageProjectEmployeeRecordSql.append(BaseManageProjectEmployeeRecord.CS_ASSIGN_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseManageProjectEmployeeRecord.CS_ASSIGN_DATE).append(" <= '").append(endCustomDate).append("'");
	            		ManageProjectEmployeeRecord manageProjectEmployeeRecordDao = new ManageProjectEmployeeRecord();
	            		manageProjectEmployeeRecordDao.setConditionEmployeeId("=",employeeId);
	            		List<BaseManageProjectEmployeeRecord> manageProjectEmployeeRecordList = manageProjectEmployeeRecordDao.conditionalLoad(manageProjectEmployeeRecordSql.toString());
	            		//奖金补贴
	            		BigDecimal managerProjectIntegralEmpBig = BigDecimal.ZERO;
	            		if(!BaseHelpUtils.isNullOrEmpty(manageProjectEmployeeRecordList) && !manageProjectEmployeeRecordList.isEmpty()){
	            			for(BaseManageProjectEmployeeRecord e : manageProjectEmployeeRecordList){
	            				managerProjectIntegralEmpBig = null == e.getAssignedIntegral() ? managerProjectIntegralEmpBig : managerProjectIntegralEmpBig.add(e.getAssignedIntegral());
	            			}
	            		}
	            		
	            		//获取该人员在当前计算月部门给他填充的积分
	//            		StringBuilder plateSalaryAdvanceRecordEmpSql = new StringBuilder();
	//            		plateSalaryAdvanceRecordEmpSql.append(BasePlateSalaryAdvanceRecord.CS_RECORD_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BasePlateSalaryAdvanceRecord.CS_RECORD_DATE).append(" <= '").append(endCustomDate).append("'");
	//            		PlateSalaryAdvanceRecord plateSalaryAdvanceRecordEmpDao = new PlateSalaryAdvanceRecord();
	//            		plateSalaryAdvanceRecordEmpDao.setConditionEmployeeId("=",employeeId);
	//            		List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceRecordEmpList = plateSalaryAdvanceRecordEmpDao.conditionalLoad(plateSalaryAdvanceRecordEmpSql.toString());
	//            		//成本填充
	//            		double salaryAdvanceEmp =0;
	//            		if(!BaseHelpUtils.isNullOrEmpty(plateSalaryAdvanceRecordEmpList) && !plateSalaryAdvanceRecordEmpList.isEmpty()){
	//            			for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceRecordEmpList){
	//            				salaryAdvanceEmp += BaseHelpUtils.getDoubleValue(e.getSalaryReturn());
	//            			}
	//            		}
	            		
	            		//获取该人员在当前计算月补贴项目补贴給他的积分
	            		StringBuilder projectEmployeeAdvanceRecordSql = new StringBuilder();
	            		projectEmployeeAdvanceRecordSql.append(BaseProjectEmployeeAdvanceRecord.CS_ADVANCE_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseProjectEmployeeAdvanceRecord.CS_ADVANCE_DATE).append(" <= '").append(endCustomDate).append("'");
	            		ProjectEmployeeAdvanceRecord projectEmployeeAdvanceRecordDao = new ProjectEmployeeAdvanceRecord();
	            		projectEmployeeAdvanceRecordDao.setConditionEmployeeId("=",employeeId);
	            		List<BaseProjectEmployeeAdvanceRecord> projectEmployeeAdvanceRecordList = projectEmployeeAdvanceRecordDao.conditionalLoad(projectEmployeeAdvanceRecordSql.toString());
	            		//项目补贴
	            		BigDecimal projectAdvanceEmpBig = BigDecimal.ZERO;
	            		if(!BaseHelpUtils.isNullOrEmpty(projectEmployeeAdvanceRecordList) && !projectEmployeeAdvanceRecordList.isEmpty()){
	            			for(BaseProjectEmployeeAdvanceRecord e : projectEmployeeAdvanceRecordList){
	            				projectAdvanceEmpBig = null == e.getAdvancedIntegral() ? projectAdvanceEmpBig : projectAdvanceEmpBig.add(e.getAdvancedIntegral());
	            			}
	            		}
	                    
	            		//获取人员的人工成本
	            		EmployeeSalaryDetail employeeSalaryDetailDao = new EmployeeSalaryDetail();
	            		employeeSalaryDetailDao.setConditionEmployeeId("=",employeeId);
	            		employeeSalaryDetailDao.setConditionSalaryYear("=",year);
	            		employeeSalaryDetailDao.setConditionSalaryMonth("=",month);
	            		BaseEmployeeSalaryDetail employeeSalaryDetailBean = employeeSalaryDetailDao.executeQueryOneRow();
	            		double basicSalaryEmp = 0;
	            		BigDecimal basicSalaryEmpBig = BigDecimal.ZERO;
	            		if(!BaseHelpUtils.isNullOrEmpty(employeeSalaryDetailBean)){
	            			String basicSalary = employeeSalaryDetailBean.getBasicSalary();
	            			//解密职员的人工成本
	            			basicSalaryEmp = BaseHelpUtils.getDoubleValue(des.DEC(basicSalary));
	            		}
	            		basicSalaryEmpBig = BigDecimal.valueOf(basicSalaryEmp);
	            		
	            		//先获取部门截止当前月给该职员填充的总的积分，再获取该人员截止当前月返回到部门的总的积分
	//            		plateSalaryAdvanceRecordEmpDao.clear();
	//            		plateSalaryAdvanceRecordEmpDao.setConditionEmployeeId("=",employeeId);
	//            		plateSalaryAdvanceRecordEmpDao.setConditionRecordDate("<=",endCustomDate);
	//            		List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceRecordEmpEmpList = plateSalaryAdvanceRecordEmpDao.conditionalLoad();
	//            		double comeIntegral = 0;
	//            		if(!BaseHelpUtils.isNullOrEmpty(plateSalaryAdvanceRecordEmpEmpList) && !plateSalaryAdvanceRecordEmpEmpList.isEmpty()){
	//            			for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceRecordEmpEmpList){
	//            				comeIntegral += BaseHelpUtils.getDoubleValue(e.getSalaryReturn());
	//            			}
	//            		}
	            		
	//            		employeeSalaryReturnRecordDao.clear();
	//            		employeeSalaryReturnRecordDao.setConditionEmployeeId("=",employeeId);
	//            		employeeSalaryReturnRecordDao.setConditionRecordDate("<",customDate);
	//            		List<BaseEmployeeSalaryReturnRecord> employeeSalaryReturnRecordEmpList = employeeSalaryReturnRecordDao.conditionalLoad();
	//            		double toIntegral = 0;
	//            		if(!BaseHelpUtils.isNullOrEmpty(employeeSalaryReturnRecordEmpList) && !employeeSalaryReturnRecordEmpList.isEmpty()){
	//            			for(BaseEmployeeSalaryReturnRecord e : employeeSalaryReturnRecordEmpList){
	//            				toIntegral += BaseHelpUtils.getDoubleValue(e.getSalaryReturn());
	//            			}
	//            		}
	            		
	            		//奖金发放
						BigDecimal bonusPaymentEmpBig = BigDecimal.ZERO;
	            		//获取当前职员在当前月份的奖金发放总额
	            		StringBuilder bonusPaymentDetailSql = new StringBuilder();
	            		bonusPaymentDetailSql.append(BaseBonusPaymentDetail.CS_PAY_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseBonusPaymentDetail.CS_PAY_DATE).append(" <= '").append(endCustomDate).append("'");
	            		BonusPaymentDetail bonusPaymentDetailDao = new BonusPaymentDetail();
	            		bonusPaymentDetailDao.setConditionEmployeeId("=",employeeId);
	            		bonusPaymentDetailDao.setConditionState("=", StaticUtils.BONUS_PAYMENT_AGREE);
	            		bonusPaymentDetailDao.unsetSelectFlags();
	            		bonusPaymentDetailDao.setSelectPayIntegral(true);
	            		List<BaseBonusPaymentDetail> bonusPaymentDetailList = bonusPaymentDetailDao.conditionalLoad(bonusPaymentDetailSql.toString());
	            		if(null != bonusPaymentDetailList && !bonusPaymentDetailList.isEmpty()){
	            			for(BaseBonusPaymentDetail detailObj : bonusPaymentDetailList){
	            				bonusPaymentEmpBig = null == detailObj.getPayIntegral() ? bonusPaymentEmpBig : bonusPaymentEmpBig.add(detailObj.getPayIntegral());
	            			}
	            		}
	            		
	            		//积分回收
	            		BigDecimal integralReturn = BigDecimal.ZERO;
	            		//非在职人员、年薪员工和积分高管才需要计算当月的积分回收总额
	            		if(integralReturnStatus){
		            		StringBuilder integralReturnSql = new StringBuilder();
		            		integralReturnSql.append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseEmployeeAchieveIntegralReturnRecord.CS_RECORD_DATE).append(" <= '").append(endCustomDate).append("'");
		            		EmployeeAchieveIntegralReturnRecord integralReturnDao = new EmployeeAchieveIntegralReturnRecord();
		            		integralReturnDao.setConditionEmployeeId("=", employeeId);
		            		integralReturnDao.unsetSelectFlags();
		            		integralReturnDao.setSelectAchieveIntegral(true);
		            		List<BaseEmployeeAchieveIntegralReturnRecord> integralReturnList = integralReturnDao.conditionalLoad(integralReturnSql.toString());
		            		if(null != integralReturnList && !integralReturnList.isEmpty()){
		            			for(BaseEmployeeAchieveIntegralReturnRecord tempObj : integralReturnList){
		            				integralReturn = null == tempObj.getAchieveIntegral() ? integralReturn : integralReturn.add(tempObj.getAchieveIntegral());
		            			}
		            		}
	            		}

	            		//员工当前计算月的项目违规金
	            		StringBuilder violationChargesMonthlySql = new StringBuilder();
	            		violationChargesMonthlySql.append(BaseEmployeeViolationCharge.CS_VIOLATION_DATE).append(" >= '").append(customDate).append("'").append("and ").append(BaseEmployeeViolationCharge.CS_VIOLATION_DATE).append(" <= '").append(endCustomDate).append("'");
	            		EmployeeViolationCharge violationChargesMonthlyDao = new EmployeeViolationCharge();
	                    violationChargesMonthlyDao.setConditionPlateId("=", plateId);
	                    violationChargesMonthlyDao.setConditionEmployeeId("=", employeeId);
	                    violationChargesMonthlyDao.unsetSelectFlags();
	                    violationChargesMonthlyDao.setSelectViolationCharges(true);
	                    List<BaseEmployeeViolationCharge> violationChargesMonthlyList = violationChargesMonthlyDao.conditionalLoad(violationChargesMonthlySql.toString());
	                    BigDecimal violationChargesMonthly = BigDecimal.ZERO;
	                    if(null != violationChargesMonthlyList && !violationChargesMonthlyList.isEmpty()){
	                    	for(BaseEmployeeViolationCharge e : violationChargesMonthlyList){
	                    		violationChargesMonthly = violationChargesMonthly.add(e.getViolationCharges());
	                    	}
	                    }
	                    
	            		//获取当前职员在当前计算月的价值积分，即确认积分+奖金补贴(管理项目的补贴)+项目补贴-人工成本-项目成本-奖金发放-积分回收-项目违规金
	            		BigDecimal  achieveIntegralEmpBig = sureIntegralEmpBig.add(managerProjectIntegralEmpBig).add(projectAdvanceEmpBig).subtract(basicSalaryEmpBig).subtract(projectCostEmpBig).subtract(bonusPaymentEmpBig).subtract(integralReturn).subtract(violationChargesMonthly);
	            		//先获取部门给该人员补平的总积分
	            		BigDecimal comeIntegralBig = BigDecimal.ZERO;
	            		//获取该人员已回流的总积分
	            		BigDecimal toIntegralBig = BigDecimal.ZERO;
	            		//初始化人员当月需要还款的积分
	            		BigDecimal salaryReturnEmpBig = BigDecimal.ZERO;
	            		//只有没有回收积分的人，才需要考虑积分借款、还款的事情
	            		if(!integralReturnStatus){
		            		//如果当前人员在当前计算月的价值积分大于0，则检索人员是否还欠部门的积分(部门积分借款的总积分-积分还款的总积分)
		            		if(achieveIntegralEmpBig.compareTo(BigDecimal.ZERO) > 0){//先判读当前人员在当前计算月的价值积分是否为正
			            		plateSalaryAdvanceRecordDao.clear();
			            		plateSalaryAdvanceRecordDao.setConditionPlateId("=",plateId);
			            		plateSalaryAdvanceRecordDao.setConditionEmployeeId("=",employeeId);
			            		List<BasePlateSalaryAdvanceRecord> plateSalaryAdvanceRecordTotalList = plateSalaryAdvanceRecordDao.conditionalLoad();
			            		if(!BaseHelpUtils.isNullOrEmpty(plateSalaryAdvanceRecordTotalList) && !plateSalaryAdvanceRecordTotalList.isEmpty()){
			            			for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceRecordTotalList){
			            				comeIntegralBig = comeIntegralBig.add(e.getSalaryReturn());
			            			}
			            		}
			            		employeeSalaryReturnRecordDao.clear();
			            		employeeSalaryReturnRecordDao.setConditionPlateId("=",plateId);
			            		employeeSalaryReturnRecordDao.setConditionEmployeeId("=",employeeId);
			            		List<BaseEmployeeSalaryReturnRecord> employeeSalaryReturnRecordTotalList = employeeSalaryReturnRecordDao.conditionalLoad();
			            		if(!BaseHelpUtils.isNullOrEmpty(employeeSalaryReturnRecordTotalList) && !employeeSalaryReturnRecordTotalList.isEmpty()){
			            			for(BaseEmployeeSalaryReturnRecord e : employeeSalaryReturnRecordTotalList){
			            				toIntegralBig = toIntegralBig.add(e.getSalaryReturn());
			            			}
			            		}
			            		
			            		//获取人员还欠部门的积分(部门积分借款的总积分-积分还款的总积分)
			            		BigDecimal leftIntegralBig = comeIntegralBig.subtract(toIntegralBig);
		            			if(leftIntegralBig.compareTo(BigDecimal.ZERO) > 0){//再判是否还欠部门的积分
		            				if(achieveIntegralEmpBig.compareTo(leftIntegralBig) > 0){//再判读当前人员的价值积分是否大于欠部门的总积分
		            					//如果当前人员的价值积分大于欠部门的总积分，则还掉欠部门的积分
		            					salaryReturnEmpBig = leftIntegralBig;
		            					achieveIntegralEmpBig = achieveIntegralEmpBig.subtract(leftIntegralBig);
		            				}else{
		            					salaryReturnEmpBig = achieveIntegralEmpBig;
		            					achieveIntegralEmpBig = BigDecimal.ZERO;
		            				}
		            			}
		            			salaryReturnBig = salaryReturnBig.add(salaryReturnEmpBig);
			            		
			            		//当人员积分还款大于0时，表示该人员有积分还款到部门，则需往积分还款记录表中插入数据
			            		if(salaryReturnEmpBig.compareTo(BigDecimal.ZERO) > 0){
			            			//插入积分还款
			            			employeeSalaryReturnRecordDao.clear();
			            			BaseEmployeeSalaryReturnRecord employeeSalaryReturnRecordBean = new BaseEmployeeSalaryReturnRecord();
			            			employeeSalaryReturnRecordBean.setEmployeeId(employeeId);
			            			employeeSalaryReturnRecordBean.setEmployeeName(employeeDao.getEmployeeName());
			            			employeeSalaryReturnRecordBean.setEmployeeNo(employeeDao.getEmployeeNo());
			            			employeeSalaryReturnRecordBean.setPlateId(plateId);
			            			employeeSalaryReturnRecordBean.setSalaryReturn(salaryReturnEmpBig);
			            			employeeSalaryReturnRecordBean.setRecordDate(customDate);
			            			employeeSalaryReturnRecordDao.setDataFromBase(employeeSalaryReturnRecordBean);
			            			employeeSalaryReturnRecordDao.save();
			            		}
		            		}
	            		}
	            		//人员汇总表插入数据
	            		employeeReportRecordBean = new BaseEmployeeReportRecord();
	            		employeeReportRecordBean.setPlateId(plateId);
	            		employeeReportRecordBean.setEmployeeId(employeeId);
	            		employeeReportRecordBean.setEmployeeName(employeeDao.getEmployeeName());
	            		employeeReportRecordBean.setEmployeeNo(employeeDao.getEmployeeNo());
	            		employeeReportRecordBean.setAchieveIntegral(achieveIntegralEmpBig);
	            		employeeReportRecordBean.setSureIntegral(sureIntegralEmpBig);
	            		employeeReportRecordBean.setManagerProjectIntegral(managerProjectIntegralEmpBig);
	            		employeeReportRecordBean.setSalaryAdvance(BigDecimal.ZERO);
	            		employeeReportRecordBean.setSalaryReturn(salaryReturnEmpBig);
	            		employeeReportRecordBean.setSalary(BigDecimal.ZERO);
	            		employeeReportRecordBean.setProjectCost(projectCostEmpBig);
	            		employeeReportRecordBean.setProjectAdvance(projectAdvanceEmpBig);
	            		employeeReportRecordBean.setRecordDate(customDate);
	            		employeeReportRecordBean.setIsLock(Boolean.FALSE);
	            		employeeReportRecordBean.setBonusPayment(bonusPaymentEmpBig);
	            		employeeReportRecordBean.setIntegralReturn(integralReturn);
	            		employeeReportRecordBean.setViolationCharges(violationChargesMonthly);
	            		employeeReportRecordDao.clear();
	            		employeeReportRecordDao.setDataFromBase(employeeReportRecordBean);
	            		employeeReportRecordDao.save();
	            	}	
            	}
            }
            
            //****************************************************人员汇总结束*******************
        	
        	
            //****************************************************部门汇总开始*******************
            
            //获取当前计算月项目确认的总的预留积分
            double projectSettlement = 0;
            BigDecimal projectSettlementBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(plateProjectAccountRecordList) && !plateProjectAccountRecordList.isEmpty()){
            	for(BasePlateProjectAccountRecord e : plateProjectAccountRecordList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getAccountDate());
            		monthCompare = DateUtil.getMonth(e.getAccountDate());
            		if(year == yearCompare && month == monthCompare){
            			projectSettlement += BaseHelpUtils.getDoubleValue(e.getAccountIntegral());
            		}
            	}
            }
            projectSettlementBig = BigDecimal.valueOf(projectSettlement);
            
            //获取当前计算月公司补贴的积分
            double companySubsidy = 0;
            BigDecimal companySubsidyBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(plateIntegralSendList) && !plateIntegralSendList.isEmpty()){
            	for(BasePlateIntegralSend e : plateIntegralSendList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getSendDate());
            		monthCompare = DateUtil.getMonth(e.getSendDate());
            		if(year == yearCompare && month == monthCompare){
            			companySubsidy += BaseHelpUtils.getDoubleValue(e.getSendIntegral());
            		}
            	}
            }
            companySubsidyBig = BigDecimal.valueOf(companySubsidy);
            
            //离职员工每月价值积分还款记录表数据集，即积分回收
            double employeeAchieveIntegralReturn = 0;
            BigDecimal employeeAchieveIntegralReturnBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(employeeAchieveIntegralReturnRecordList) && !employeeAchieveIntegralReturnRecordList.isEmpty()){
            	for(BaseEmployeeAchieveIntegralReturnRecord e : employeeAchieveIntegralReturnRecordList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getRecordDate());
            		monthCompare = DateUtil.getMonth(e.getRecordDate());
            		if(year == yearCompare && month == monthCompare){
            			employeeAchieveIntegralReturn += BaseHelpUtils.getDoubleValue(e.getAchieveIntegral());
            		}
            	}
            }
            employeeAchieveIntegralReturnBig = BigDecimal.valueOf(employeeAchieveIntegralReturn);
            
            //员工每月积分还款记录表数据集
//            double salaryReturn = 0;
//            BigDecimal salaryReturnBig = BigDecimal.ZERO;
//            if(!BaseHelpUtils.isNullOrEmpty(employeeSalaryReturnRecordList) && !employeeSalaryReturnRecordList.isEmpty()){
//            	for(BaseEmployeeSalaryReturnRecord e : employeeSalaryReturnRecordList){
//            		//获取当前结算日期的年月
//            		yearCompare = DateUtil.getYear(e.getRecordDate());
//            		monthCompare = DateUtil.getMonth(e.getRecordDate());
//            		if(year == yearCompare && month == monthCompare){
//            			salaryReturn += BaseHelpUtils.getDoubleValue(e.getSalaryReturn());
//            		}
//            	}
//            }
//            salaryReturnBig = BigDecimal.valueOf(salaryReturn);
            
            //部门发放给管理项目的积分,即奖金补贴
            double managerProjectIntegral = 0;
            BigDecimal managerProjectIntegralBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(mangetProjectList) && !mangetProjectList.isEmpty()){
            	for(BaseManageProject e : mangetProjectList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getProjectDate());
            		monthCompare = DateUtil.getMonth(e.getProjectDate());
            		if(year == yearCompare && month == monthCompare){
            			managerProjectIntegral += BaseHelpUtils.getDoubleValue(e.getTotalIntegral());
            		}
            	}
            }
            managerProjectIntegralBig = BigDecimal.valueOf(managerProjectIntegral);
            
            //部门的运营成本
            double plateCost = 0;
            BigDecimal plateCostBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(plateCostRecordList) && !plateCostRecordList.isEmpty()){
            	for(BasePlateCostRecord e : plateCostRecordList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getCostDate());
            		monthCompare = DateUtil.getMonth(e.getCostDate());
            		if(year == yearCompare && month == monthCompare){
            			plateCost += BaseHelpUtils.getDoubleValue(e.getCostIntegral());
            		}
            	}
            }
            plateCostBig = BigDecimal.valueOf(plateCost);
            
            //部门每月人工成本补偿记录表数据集
//            double salaryAdvance = 0;
//            if(!BaseHelpUtils.isNullOrEmpty(plateSalaryAdvanceRecordList) && !plateSalaryAdvanceRecordList.isEmpty()){
//            	for(BasePlateSalaryAdvanceRecord e : plateSalaryAdvanceRecordList){
//            		//获取当前结算日期的年月
//            		yearCompare = DateUtil.getYear(e.getRecordDate());
//            		monthCompare = DateUtil.getMonth(e.getRecordDate());
//            		if(year == yearCompare && month == monthCompare){
//            			salaryAdvance += BaseHelpUtils.getDoubleValue(e.getSalaryReturn());
//            		}
//            	}
//            }
            
            //部门项目补贴记录表数据集
            double projectAdvance = 0;
            BigDecimal projectAdvanceBig = BigDecimal.ZERO;
            if(!BaseHelpUtils.isNullOrEmpty(projectAdvanceRecordList) && !projectAdvanceRecordList.isEmpty()){
            	for(BaseProjectAdvanceRecord e : projectAdvanceRecordList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getAdvanceDate());
            		monthCompare = DateUtil.getMonth(e.getAdvanceDate());
            		if(year == yearCompare && month == monthCompare){
            			projectAdvance += BaseHelpUtils.getDoubleValue(e.getAdvanceIntegral());
            		}
            	}
            }
            projectAdvanceBig = BigDecimal.valueOf(projectAdvance);
            
            //品质管理费
            BigDecimal qualityFee = BigDecimal.ZERO;
            if(null != qualityList && !qualityList.isEmpty()){
            	for(BasePlateIntegralAchieve obj : qualityList){
            		yearCompare = DateUtil.getYear(obj.getSendDate());
            		monthCompare = DateUtil.getMonth(obj.getSendDate());
            		if(year == yearCompare && month == monthCompare){
            			qualityFee = qualityFee.add(obj.getSendIntegral());
            		}
            	}
            }
            
            //公司费用
            BigDecimal companyFee = BigDecimal.ZERO;
            if(null != companyFeeList && !companyFeeList.isEmpty()){
            	for(BasePlateIntegralAchieve obj : companyFeeList){
            		yearCompare = DateUtil.getYear(obj.getSendDate());
            		monthCompare = DateUtil.getMonth(obj.getSendDate());
            		if(year == yearCompare && month == monthCompare){
            			companyFee = companyFee.add(obj.getSendIntegral());
            		}
            	}
            }
            
            //项目违规金
            BigDecimal violationCharges = BigDecimal.ZERO;
            if(null != violationChargesList && !violationChargesList.isEmpty()){
            	for(BaseEmployeeViolationCharge obj : violationChargesList){
            		yearCompare = DateUtil.getYear(obj.getViolationDate());
            		monthCompare = DateUtil.getMonth(obj.getViolationDate());
            		if(year == yearCompare && month == monthCompare){
            			violationCharges = violationCharges.add(obj.getViolationCharges());
            		}
            	}
            }
            
            
            //部门价值积分，即项目结算+公司补贴+积分还款+积分回收+项目违规金-奖金补贴(管理项目)-运营成本-项目补贴-品质管理费-公司费用
            BigDecimal achieveIntegralBig = projectSettlementBig.add(companySubsidyBig).add(salaryReturnBig).add(employeeAchieveIntegralReturnBig).add(violationCharges).subtract(managerProjectIntegralBig).subtract(plateCostBig).subtract(projectAdvanceBig).subtract(qualityFee).subtract(companyFee);
            //插入部门积分汇总数据
            plateReportRecordBean = new BasePlateReportRecord();
            plateReportRecordBean.setPlateId(plateId);
            plateReportRecordBean.setAchieveIntegral(achieveIntegralBig);
            plateReportRecordBean.setProjectSettlement(new BigDecimal(projectSettlement));
            plateReportRecordBean.setCompanySubsidy(new BigDecimal(companySubsidy));
            plateReportRecordBean.setEmployeeAchieveIntegralReturn(new BigDecimal(employeeAchieveIntegralReturn));
            plateReportRecordBean.setSalaryReturn(salaryReturnBig);
            plateReportRecordBean.setManagerProjectIntegral(new BigDecimal(managerProjectIntegral));
            plateReportRecordBean.setPlateCost(new BigDecimal(plateCost));
            plateReportRecordBean.setSalaryAdvance(BigDecimal.ZERO);
            plateReportRecordBean.setProjectAdvance(new BigDecimal(projectAdvance));
            plateReportRecordBean.setRecordDate(customDate);
            plateReportRecordBean.setIsLock(Boolean.FALSE);
            plateReportRecordBean.setQualityFee(qualityFee);
            plateReportRecordBean.setCompanyFee(companyFee);
            plateReportRecordBean.setViolationCharges(violationCharges);
            plateReportRecordDao.clear();
            plateReportRecordDao.setDataFromBase(plateReportRecordBean);
            plateReportRecordDao.save();
            
            //****************************************************部门汇总结束*******************
            
            
            //****************************************************项目汇总开始*******************
            
            //定义一个map，以项目为单位去存放确认确认积分和项目成本
            Map<Integer,BaseProjectReportRecord> projectInfoMap = new HashMap<>();
            if(!BaseHelpUtils.isNullOrEmpty(projectSettlementList) && !projectSettlementList.isEmpty()){
            	for(BaseProjectSettlement e : projectSettlementList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getSettlementDate());
            		monthCompare = DateUtil.getMonth(e.getSettlementDate());
            		if(year == yearCompare && month == monthCompare){
            			int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
            			//获取确认的积分
            			double sureIntegral = BaseHelpUtils.getDoubleValue(e.getTotalAmount());
            			//获取map中该项目已存入的确认积分
            			BaseProjectReportRecord bean = projectInfoMap.get(projectId);
            			double sureIntegralTotal = 0;
            			if(!BaseHelpUtils.isNullOrEmpty(bean)){
            				sureIntegralTotal = BaseHelpUtils.getDoubleValue(bean.getSureIntegral());
            			}else{
            				bean = new BaseProjectReportRecord();
            			}
            			//重新封装实体
            			bean.setProjectId(projectId);
            			bean.setSureIntegral(new BigDecimal(sureIntegralTotal+sureIntegral));
            			bean.setProjectCost(BigDecimal.ZERO);
            			//将map已存入的确认积分+当次循环得到的确认积分，并更新map值
            			projectInfoMap.put(projectId,bean);
            		}
            	}
            }
            
            if(!BaseHelpUtils.isNullOrEmpty(projectCostList) && !projectCostList.isEmpty()){
            	for(BaseProjectCost e : projectCostList){
            		//获取当前结算日期的年月
            		yearCompare = DateUtil.getYear(e.getCostDate());
            		monthCompare = DateUtil.getMonth(e.getCostDate());
            		if(year == yearCompare && month == monthCompare){
            			int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
            			//获取项目成本
            			double projectCost = BaseHelpUtils.getDoubleValue(e.getAmount());
            			//获取map中该项目已存入的项目成本
            			BaseProjectReportRecord bean = projectInfoMap.get(projectId);
            			double projectCostTotal = 0;
            			if(!BaseHelpUtils.isNullOrEmpty(bean)){
            				projectCostTotal = BaseHelpUtils.getDoubleValue(bean.getProjectCost());
            			}else{
            				bean = new BaseProjectReportRecord();
            				bean.setSureIntegral(BigDecimal.ZERO);
            			}
            			//重新封装实体
            			bean.setProjectId(projectId);
            			bean.setProjectCost(new BigDecimal(projectCostTotal+projectCost));
            			//将map已存入的项目成本+当次循环得到的项目成本，并更新map值
            			projectInfoMap.put(projectId,bean);
            		}
            	}
            }
            //遍历map，插入项目汇总表
            if(projectInfoMap.size() > 0){
            	for(Integer projectId : projectInfoMap.keySet()){
            		projectReportRecordDao.clear();
            		projectReportRecordBean = projectInfoMap.get(projectId);
            		projectReportRecordBean.setPlateId(plateId);
            		projectReportRecordBean.setRecordDate(customDate);
            		projectReportRecordBean.setIsLock(Boolean.FALSE);
            		projectReportRecordDao.setDataFromBase(projectReportRecordBean);
            		projectReportRecordDao.save();
            	}
            }
            
            //****************************************************项目汇总结束*******************
            
            
        	//每遍历一次，都将当期日期都累加一个月
        	customDate = DateUtil.getNextMonth(customDate);
        }
        
        ThreadConnection.commit();
        return result;
    }
    
    
    /**
     * 
     * @param operatePlateId
     * @param years
     * @param startMonth
     * @param endMonth
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public int exec(int operatePlateId,int years, int startMonth, int endMonth) throws SQLException, UnsupportedEncodingException {
        ThreadConnection.beginTransaction();
        int result = 0;//初始化计算后的返回参数为0：表示成功;-1表示失败
        //设置开始计算的日期格式
        StringBuilder startDate = new StringBuilder();
        StringBuilder endDate = new StringBuilder();
        startDate.append(years).append("-").append(startMonth).append("-01");
        if(endMonth==13){
            endDate.append(years+1).append("-01-01");
        }else{
            endDate.append(years).append("-").append(endMonth).append("-01");
        }

        //获取所有业务部门的数据
        SystemDictionary sdDao = new SystemDictionary();
        sdDao.setConditionDicTypeId("=", DIC_TYPE_ID);
        if(operatePlateId > 0){//表示只计算当前操作计算的人所属的业务部门数据
            sdDao.setConditionDicTypeValueId("=", operatePlateId);
        }
        List<BaseSystemDictionary> sdList = sdDao.conditionalLoad(" order by " + BaseSystemDictionary.CS_DIC_TYPE_VALUE_ID + " asc");
        if (BaseHelpUtils.isNullOrEmpty(sdList) || sdList.isEmpty()) {
            throw new SQLException("没有可计算的业务部门信息");
        }

        //检索所有的项目信息
        Project pDao = new Project();
        pDao.unsetSelectFlags();
        pDao.setSelectProjectId(true);
        pDao.setSelectPlateId(true);//业务部门
        pDao.setSelectTotalIntegral(true);//项目总积分
        pDao.setSelectProjectIntegral(true);//项目积分
        pDao.setSelectReserveIntegral(true);//项目预留积分
        List<BaseProject> pList = pDao.conditionalLoad(" order by " + BaseProject.CS_PLATE_ID + " asc");

        //检索板块的未结算的运营成本信息
        PlateCostRecord pcrDao = new PlateCostRecord();
        List<BasePlateCostRecord> pcrList = pcrDao.conditionalLoad(" order by " + BasePlateCostRecord.CS_PLATE_ID + " asc");

        //检索项目成本信息
        ProjectCost pcDao = new ProjectCost();
        List<BaseProjectCost> pcList = pcDao.conditionalLoad();

        //检索项目成员信息
        ProjectEmployee peDao = new ProjectEmployee();
        List<BaseProjectEmployee> peList = peDao.conditionalLoad();

        //检索项目结算记录信息
        ProjectSettlement psDao = new ProjectSettlement();
        StringBuilder psdsql = new StringBuilder();
        psdsql.append(BaseProjectSettlement.CS_SETTLEMENT_DATE).append(" >= '").append(startDate).append("' and ").append(BaseProjectSettlementDetail.CS_SETTLEMENT_DATE).append(" < '").append(endDate).append("'");
        List<BaseProjectSettlement> psdList = psDao.conditionalLoad(psdsql.toString());
        
        //获取积分转移的归属项目数据集，如果存在，则表示该项目结算的预留积分不通过计算公式，即该项目的结算的预留积分为0
//        ProjectIntegralTransferRecord projectIntegralTransferRecordDao = new ProjectIntegralTransferRecord();
//        List<BaseProjectIntegralTransferRecord> projectIntegralTransferRecordList = projectIntegralTransferRecordDao.conditionalLoad();
//        Map<Integer,Integer> projectMap = new HashMap<>();
        //把所有的积分转移中的归属项目的项目ID放到map中
//        if(!BaseHelpUtils.isNullOrEmpty(projectIntegralTransferRecordList) && !projectIntegralTransferRecordList.isEmpty()){
//            for(BaseProjectIntegralTransferRecord e : projectIntegralTransferRecordList){
//                //获取归属项目的项目id
//                int toProjectId = BaseHelpUtils.getIntValue(e.getToProjectId());
//                projectMap.put(toProjectId, toProjectId);
//            }
//        }

        //按月份遍历，计算每一个月每一个业务部门的数据
        PlateIntegralSumRecord pisrDao = new PlateIntegralSumRecord();//板块汇总表
        ProjectIntegralSumRecord proDao = new ProjectIntegralSumRecord();//项目汇总表
        BaseProjectIntegralSumRecord proBean;
        for (int i = startMonth; i < endMonth; i++) {
            //根据当前月份去检索是否当前月份的数据有被上锁，如果已上锁，则不可再进行计算
            pisrDao.clear();
            pisrDao.setConditionYear("=", years);
            pisrDao.setConditionMonth("=", i);
            //检索当前计算月是否被上锁;0:未锁定;1:锁定
            pisrDao.setConditionIsLock("=", IS_LOCK);
            if (pisrDao.countRows() > 0) {
                continue;
            } else {
                //按业务部门遍历计算
                for (BaseSystemDictionary sdBean : sdList) {
                    //获取业务部门ID
                    int plateId = BaseHelpUtils.getIntValue(sdBean.getDicTypeValueId());
                    //先清除掉当前计算月,当前部门的所有数据
                    pisrDao.clear();
                    pisrDao.setConditionYear("=", years);
                    pisrDao.setConditionMonth("=", i);
                    pisrDao.setConditionPlateId("=",plateId);
                    pisrDao.conditionalDelete();
                    proDao.clear();
                    proDao.setConditionYear("=", years);
                    proDao.setConditionMonth("=", i);
                    proDao.setConditionPlateId("=",plateId);
                    proDao.conditionalDelete();
                    
                    //获取到当前业务部门下的所有成员
                    Object[] empArr = getEmpArrOfPlate(plateId,years,i);
                    //初始化业务部门项目总积分
                    double projectIntegralSumTotal = 0;
                    //初始化业务部门项目积分
                    double projectIntegralTotal = 0;
                    //初始化业务部门预留积分
                    double reserveIntegralTotal = 0;
                    //初始化业务部门已经结算的项目成本
                    double settledProjectCostTotal = 0;
                    //初始化业务部门已经确认的项目积分
                    double sureIntegralTotal = 0;
                    //初始化业务部门已经确认的预留积分
                    double sureReserveIntegralTotal = 0;
                    //初始化业务部门已经结算的项目积分
                    double settlementIntegralTotal = 0;
                    //获取部门的运营成本
                    double plateCost = 0;
                    if (!BaseHelpUtils.isNullOrEmpty(pcrList) && !pcrList.isEmpty()) {
                        for (BasePlateCostRecord e : pcrList) {
                            if (plateId == BaseHelpUtils.getIntValue(e.getPlateId()) && years == BaseHelpUtils.getIntValue(e.getYear()) && i == BaseHelpUtils.getIntValue(e.getMonth())) {//只匹配当前业务部门的运营成本
                                plateCost = BaseHelpUtils.getDoubleValue(e.getCostIntegral());
                            }
                        }
                    }

                    if (!BaseHelpUtils.isNullOrEmpty(pList) && !pList.isEmpty()) {
                        for (BaseProject e : pList) {
                            if (plateId == BaseHelpUtils.getIntValue(e.getPlateId())) {//只匹配当前业务部门下的项目数据
                                //获取项目Id
                                int projectId = BaseHelpUtils.getIntValue(e.getProjectId());
                                //获取项目总积分
                                double projectIntegralSum = BaseHelpUtils.getDoubleValue(e.getTotalIntegral());
                                //获取项目积分
                                double projectIntegral = BaseHelpUtils.getDoubleValue(e.getProjectIntegral());
                                //获取项目预留积分
                                double reserveIntegral = BaseHelpUtils.getDoubleValue(e.getReserveIntegral());
                                //获取项目的已分配的项目积分
                                double distributedProjectIntegral = getDistributedProjectIntegral(projectId, peList);
                                //获取项目的未分配的项目积分，即项目积分-已分配的项目积分
                                double undistributedProjectIntegral = projectIntegral - distributedProjectIntegral;
                                //获取项目在当前年月份结算的积分数据集合
                                Map<String, Object> resultMap = getIntegralMap(projectId, years, i, psdList);
                                //获取确认积分
                                double sureIntegral = BaseHelpUtils.getDoubleValue(resultMap.get("sureIntegral"));
                                //获取未确认积分，即已分配的项目积分-确认积分
                                double unsureIntegral = distributedProjectIntegral - sureIntegral;
                                //初始化结算积分
                                double settlementIntegral = BaseHelpUtils.getDoubleValue(resultMap.get("settlementIntegral"));
                                //获取项目成本
                                double projectCost = getProjectCost(projectId, pcList);
                                //初始化已结算的项目成本
                                double settledProjectCost = BaseHelpUtils.getDoubleValue(resultMap.get("settledProjectCost"));
                                //初始化未结算的项目成本,即项目成本-已结算的项目成本
                                double unsettledProjectCost = projectCost - settledProjectCost;
                                //获取当前月项目确认预留积分的比例值，即当前月已经确认的确认积分/项目积分
                                //如果当前项目作为归属项目存在于积分转移记录中，则这一次的结算的预留积分置为0
                                double percentage = 0;
//                                if (projectIntegral != 0 && !projectMap.containsKey(projectId)) {
                                if (projectIntegral != 0) {
                                    percentage = sureIntegral / projectIntegral;
                                }
                                //获取已经确认的预留积分，即项目预留积分*确认比例值
                                double sureReserveIntegral = reserveIntegral * percentage;
//                                double sureReserveIntegral = getSureReserveIntegral(projectId,reserveIntegral,percentage,years, i);

                                //设置业务部门汇总的项目数据信息
                                projectIntegralSumTotal += projectIntegralSum;
                                projectIntegralTotal += projectIntegral;
                                reserveIntegralTotal += reserveIntegral;
                                settledProjectCostTotal += settledProjectCost;
                                sureIntegralTotal += sureIntegral;
                                settlementIntegralTotal += settlementIntegral;
                                sureReserveIntegralTotal += sureReserveIntegral;

                                proBean = new BaseProjectIntegralSumRecord();
                                proBean.setPlateId(plateId);
                                proBean.setProjectId(projectId);
                                proBean.setYear(years);
                                proBean.setMonth(i);
                                proBean.setProjectIntegralSum(new BigDecimal(projectIntegralSum));
                                proBean.setProjectIntegral(new BigDecimal(projectIntegral));
                                proBean.setReserveIntegral(new BigDecimal(reserveIntegral));
                                proBean.setDistributedProjectIntegral(new BigDecimal(distributedProjectIntegral));
                                proBean.setUndistributedProjectIntegral(new BigDecimal(undistributedProjectIntegral));
                                proBean.setSureIntegral(new BigDecimal(sureIntegral));
                                proBean.setUnsureIntegral(new BigDecimal(unsureIntegral));
                                proBean.setSettlementIntegral(new BigDecimal(settlementIntegral));
                                proBean.setProjectCost(new BigDecimal(projectCost));
                                proBean.setSettledProjectCost(new BigDecimal(settledProjectCost));
                                proBean.setUnsettledProjectCost(new BigDecimal(unsettledProjectCost));
                                proBean.setCreateTime(new Date());
                                //更新和插入项目信息汇总数据
                                updateOrSaveProjectIntegralSumRecord(proBean);
                            }
                        }
                    }//项目遍历结束
                    //获取当前业务部门下人工成本，即分为参与项目的人工成本和非参与项目的人工成本
                    Map<String, Object> salaryMap = getEmployeeSalaryOfPlate(plateId, years, i, empArr);
                    //参与项目的人工成本
                    double projectEmpSalaryTotal = BaseHelpUtils.getDoubleValue(salaryMap.get("projectEmpSalaryTotal"));
                    //未参与项目的人工成本
                    double plateEmpSalaryTotal = BaseHelpUtils.getDoubleValue(salaryMap.get("plateEmpSalaryTotal"));
                    //更新业务部门其他月份的信息
                    pisrDao.clear();
                    pisrDao.setConditionPlateId("=", plateId);
                    pisrDao.setProjectIntegralSum(new BigDecimal(projectIntegralSumTotal));
                    pisrDao.setProjectIntegral(new BigDecimal(projectIntegralTotal));
                    pisrDao.setReserveIntegral(new BigDecimal(reserveIntegralTotal));
                    pisrDao.setUpdateTime(new Date());
                    pisrDao.conditionalUpdate();
                    //插入部门汇总信息
                    pisrDao.clear();
                    pisrDao.setPlateId(plateId);
                    pisrDao.setYear(years);
                    pisrDao.setMonth(i);
                    //部门汇总标示
                    pisrDao.setTypeFlag(TYPE_FLAG_1);
                    //项目总积分
                    pisrDao.setProjectIntegralSum(new BigDecimal(projectIntegralSumTotal));
                    //项目积分
                    pisrDao.setProjectIntegral(new BigDecimal(projectIntegralTotal));
                    //项目预留积分
                    pisrDao.setReserveIntegral(new BigDecimal(reserveIntegralTotal));
                    //项目确认的预留积分
                    pisrDao.setSureIntegral(new BigDecimal(sureReserveIntegralTotal));
                    //部门运营成本
                    pisrDao.setCostIntegral(new BigDecimal(plateCost));
                    //部门非参与项目的人工成本
                    pisrDao.setSalaryIntegral(new BigDecimal(plateEmpSalaryTotal));
                    //部门结算的预留积分，即确认积分-部门运营成本
                    pisrDao.setSettlementIntegral(new BigDecimal(sureReserveIntegralTotal-plateCost));
                    //部门价值积分，即结算的预留积分-部门运营成本-人工成本
                    pisrDao.setAchieveIntegral(new BigDecimal(sureReserveIntegralTotal - plateCost - plateEmpSalaryTotal));
                    pisrDao.setCreateTime(new Date());
                    pisrDao.save();
                    //插入项目汇总信息
                    pisrDao.clear();
                    pisrDao.setPlateId(plateId);
                    pisrDao.setYear(years);
                    pisrDao.setMonth(i);
                    //项目汇总标示
                    pisrDao.setTypeFlag(TYPE_FLAG_0);
                    //项目总积分
                    pisrDao.setProjectIntegralSum(new BigDecimal(projectIntegralSumTotal));
                    //项目积分
                    pisrDao.setProjectIntegral(new BigDecimal(projectIntegralTotal));
                    //项目预留积分
                    pisrDao.setReserveIntegral(new BigDecimal(reserveIntegralTotal));
                    //项目确认积分
                    pisrDao.setSureIntegral(new BigDecimal(sureIntegralTotal));
                    //项目结算的项目成本
                    pisrDao.setCostIntegral(new BigDecimal(settledProjectCostTotal));
                    //项目人工成本，即参与项目的人的人工成本
                    pisrDao.setSalaryIntegral(new BigDecimal(projectEmpSalaryTotal));
                    //项目结算的积分
                    pisrDao.setSettlementIntegral(new BigDecimal(settlementIntegralTotal));
                    //项目价值积分，即结算的项目积分-人工成本
                    pisrDao.setAchieveIntegral(new BigDecimal(settlementIntegralTotal - projectEmpSalaryTotal));
                    pisrDao.setCreateTime(new Date());
                    pisrDao.save();
                }
            }
        }

        ThreadConnection.commit();
        return result;
    }

    /**
     * 获取业务部门的人工成本
     * @param plateId
     * @param years
     * @param month
     * @param empArr
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public Map getEmployeeSalaryOfPlate(int plateId, int years, int month, Object[] empArr) throws SQLException, UnsupportedEncodingException {
        //根据当前计算的年月份检索到所有人员的人工成本
        EmployeeSalaryDetail esdDao = new EmployeeSalaryDetail();
        esdDao.unsetSelectFlags();
        esdDao.setSelectEmployeeId(true);
        esdDao.setSelectSalaryYear(true);
        esdDao.setSelectSalaryMonth(true);
        esdDao.setSelectBasicSalary(true);
        esdDao.setConditionSalaryYear("=", years);
        esdDao.setConditionSalaryMonth("=", month);
        esdDao.addCondition(BaseEmployeeSalaryDetail.CS_EMPLOYEE_ID, "in", empArr);
        List<BaseEmployeeSalaryDetail> esdList = esdDao.conditionalLoad();
        //获取加密的秘钥
        SystemConfig scDao = new SystemConfig();
        scDao.setSystemConfigId(StaticUtils.SYSTEM_KEY);
        scDao.load();
        String key = scDao.getImagePath();
        DES des = new DES(key);
        double empSalaryTotal = 0;
        if (!BaseHelpUtils.isNullOrEmpty(esdList) && !esdList.isEmpty()) {
            for (BaseEmployeeSalaryDetail e : esdList) {
                empSalaryTotal += BaseHelpUtils.getDoubleValue(des.DEC(e.getBasicSalary()));
            }
        }
        //获取当前业务部门参与项目的人员的项目成本
        ConditionMaddProjectEmpSalary condition = new ConditionMaddProjectEmpSalary();
        condition.setPlateId(plateId);
        condition.setSalaryYear(BaseHelpUtils.getString(years));
        condition.setSalaryMonth(BaseHelpUtils.getString(month));
        QueryMaddProjectEmpSalary dao = new QueryMaddProjectEmpSalary();
        BaseCollection<BaseMaddProjectEmpSalary> result = dao.executeQuery(null, condition);
        double projectEmpSalaryTotal = 0;
        if (!BaseHelpUtils.isNullOrEmpty(result)) {
            List<BaseMaddProjectEmpSalary> resultList = result.getCollections();
            if (!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()) {
                for (BaseMaddProjectEmpSalary e : resultList) {
                    projectEmpSalaryTotal += BaseHelpUtils.getDoubleValue(des.DEC(e.getBasicSalary()));
                }
            }
        }
        //未参与项目的人工成本，即业务部门的人工成本
        double plateEmpSalaryTotal = empSalaryTotal - projectEmpSalaryTotal;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("projectEmpSalaryTotal", projectEmpSalaryTotal);
        resultMap.put("plateEmpSalaryTotal", plateEmpSalaryTotal);
        return resultMap;
    }

    /**
     * 更新和插入项目信息汇总数据
     *
     * @param bean
     * @throws SQLException
     */
    public void updateOrSaveProjectIntegralSumRecord(BaseProjectIntegralSumRecord bean) throws SQLException {
        if (!BaseHelpUtils.isNullOrEmpty(bean)) {
            ProjectIntegralSumRecord proDao = new ProjectIntegralSumRecord();//项目汇总表
            //更新该项目其他月份的项目积分信息
            proDao.clear();
            proDao.setConditionProjectId("=", bean.getProjectId());
            proDao.setProjectIntegralSum(bean.getProjectIntegralSum());
            proDao.setProjectIntegral(bean.getProjectIntegral());
            proDao.setReserveIntegral(bean.getReserveIntegral());
            proDao.setDistributedProjectIntegral(bean.getDistributedProjectIntegral());
            proDao.setUndistributedProjectIntegral(bean.getUndistributedProjectIntegral());
            proDao.setUnsureIntegral(bean.getUnsureIntegral());
            proDao.setProjectCost(bean.getProjectCost());
            proDao.setUnsettledProjectCost(bean.getUnsettledProjectCost());
            proDao.setUpdateTime(new Date());
            proDao.conditionalUpdate();
            //插入当前月份结算的项目积分信息
            proDao.clear();
            proDao.setDataFromBase(bean);
            proDao.save();
        }
    }

    /**
     * 获取目标项目的所有成员的预分配积分，即项目的已分配积分
     *
     * @param projectId
     * @param peList
     * @return
     */
    public double getDistributedProjectIntegral(int projectId, List<BaseProjectEmployee> peList) {
        double distributedProjectIntegral = 0;
        if (!BaseHelpUtils.isNullOrEmpty(peList) && !peList.isEmpty()) {
            for (BaseProjectEmployee e : peList) {
                if (projectId == BaseHelpUtils.getIntValue(e.getProjectId())) {//只匹配目标项目的项目成员信息
                    distributedProjectIntegral += BaseHelpUtils.getDoubleValue(e.getPlanIntegral());
                }
            }
        }
        return distributedProjectIntegral;
    }

    /**
     * 获取项目在当前年月份结算的积分数据集合
     *
     * @param projectId
     * @param year
     * @param month
     * @param psdList
     * @return
     */
    public Map getIntegralMap(int projectId, int year, int month, List<BaseProjectSettlement> psdList) {
        Map<String, Object> resultMap = new HashMap<>();
        //初始化确认积分
        double sureIntegral = 0;
        //初始化结算的项目成本
        double settledProjectCost = 0;
        //初始化结算积分
        double settlementIntegral = 0;
        if (!BaseHelpUtils.isNullOrEmpty(psdList) && !psdList.isEmpty()) {
            Calendar calerdar = Calendar.getInstance();
            for (BaseProjectSettlement e : psdList) {
                calerdar.setTime(e.getSettlementDate());
                if (projectId == BaseHelpUtils.getIntValue(e.getProjectId()) && year == calerdar.get(Calendar.YEAR) && month == (calerdar.get(Calendar.MONTH) + 1)) {
                    sureIntegral += BaseHelpUtils.getDoubleValue(e.getTotalAmount());
                    settledProjectCost += BaseHelpUtils.getDoubleValue(e.getTotalCost());
                }
            }
            settlementIntegral = sureIntegral-settledProjectCost;
        }
        resultMap.put("sureIntegral", sureIntegral);
        resultMap.put("settledProjectCost", settledProjectCost);
        resultMap.put("settlementIntegral", settlementIntegral);
        return resultMap;
    }

    /**
     * 获取项目的项目成本数据
     *
     * @param projectId
     * @param pcList
     * @return
     */
    public double getProjectCost(int projectId, List<BaseProjectCost> pcList) {
        double projectCost = 0;
        if (!BaseHelpUtils.isNullOrEmpty(pcList) && !pcList.isEmpty()) {
            for (BaseProjectCost e : pcList) {
                if (projectId == BaseHelpUtils.getIntValue(e.getProjectId())) {//只匹配目标项目的项目成本
                    projectCost += BaseHelpUtils.getDoubleValue(e.getAmount());
                }
            }
        }
        return projectCost;
    }

    /**
     * 获取指定板块下的成员集合
     *
     * @param plateId
     * @param year
     * @param month
     * @return
     * @throws SQLException
     */
    public Object[] getEmpArrOfPlate(int plateId,int year,int month) throws SQLException {
        //检索所有设置有业务部门的职员信息
        EmployeeChangePlateRecord dao = new EmployeeChangePlateRecord();
        dao.setConditionPlateId("=", plateId);
        dao.setConditionYear("=", year);
        dao.setConditionMonth("=", month);
        List<BaseEmployeeChangePlateRecord> eList = dao.conditionalLoad(" order by " + BaseEmployeeChangePlateRecord.CS_EMPLOYEE_ID + " asc");
        int size = eList.size();
        Object[] empArr = new Object[size];
        int i = 0;
        if (!BaseHelpUtils.isNullOrEmpty(eList) && !eList.isEmpty()) {
            for (BaseEmployeeChangePlateRecord e : eList) {
                empArr[i] = BaseHelpUtils.getIntValue(e.getEmployeeId());
                i++;
            }
        } else {
            empArr = new Object[1];
            empArr[0] = 0;
        }
        return empArr;
    }
    
    public static void main(String[] args) throws Exception {
        ProjectIntegralAccount pa = new ProjectIntegralAccount();
//        pa.exec(0,2016,6,7);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = df.parse("2016-01-01");
        Date endDate = df.parse("2016-12-01");
      //获取开始日期和结束日期相差的月数
//        int months = DateUtil.getCompareMonths(startDate, endDate);
//        System.out.println("months=="+months);
//        for(int i=1;i<11;i++){
        	pa.execAccount(1, startDate, DateUtil.getLastDay(endDate));
//        }
    }

    
}
