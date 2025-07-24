package pomplatform.common.utils;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BaseManageProject;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateIntegralAssignRecord;
import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.bean.BasePlateIntegralTransferRecord;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BasePlateProjectIntegralRecord;
import com.pomplatform.db.bean.BasePlateReportRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.ManageProject;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateIntegralAssignRecord;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.dao.PlateIntegralTransferRecord;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateProjectIntegralRecord;
import com.pomplatform.db.dao.PlateReportRecord;
import com.pomplatform.db.dao.SystemConfig;

import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.date.util.DateUtil;

/**
 *
 * @author lxf
 */
public class CommonHandel {
	private static final Logger __LOGGER = Logger.getLogger("");
    
    /**
     * 获取部门的价值积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     * @throws ParseException 
     * @throws UnsupportedEncodingException 
     */
    public static double getTotalAchieveIntegral(int plateId,Date startDate,Date endDate) throws SQLException, ParseException, UnsupportedEncodingException{
    	//初始化价值积分
    	double totalAchieveIntegral = 0;
    	
    	//如果开始日期为空，则置了2016-01-01
//    	if(BaseHelpUtils.isNullOrEmpty(startDate)){
//    		String startDateStr = "2016-01-01"; 
//    		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//    		startDate = df.parse(startDateStr);
//    	}
//    	//如果结束日期为空，则置为当前月,截止最后一天
//    	if(BaseHelpUtils.isNullOrEmpty(endDate)){
//    		endDate = DateUtil.getLastDay(new Date());
//    	}
//    	//项目结算的价值积分，即项目结算时的获取的可结算预留积分
//    	totalAchieveIntegral += getTotalProjectAccountIntegral(plateId, startDate, endDate);
//    	
//    	//公司补贴的积分
//    	totalAchieveIntegral += getTotalCompanyIntegral(plateId, startDate, endDate);
//    	
//    	//部门发放给管理项目的积分
//    	totalAchieveIntegral -= getTotalAssignIntegral(plateId, startDate, endDate);
//    	
//        //部门的运营成本
//        totalAchieveIntegral -= getTotalCostIntegral(plateId, startDate, endDate);
        
        //获取部门的人工成本
//        totalAchieveIntegral -= getTotalBasicSalary(plateId, startDate, endDate);
    	
        PlateReportRecord plateReportRecordDao = new PlateReportRecord();
        plateReportRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateReportRecord> plateReportRecordList = plateReportRecordDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(plateReportRecordList) && !plateReportRecordList.isEmpty()){
        	for(BasePlateReportRecord e : plateReportRecordList){
        		totalAchieveIntegral += BaseHelpUtils.getDoubleValue(e.getAchieveIntegral());
        	}
        }
        //截取小数点前整数
        DecimalFormat df = new DecimalFormat("#");
        totalAchieveIntegral = BaseHelpUtils.getDoubleValue(df.format(totalAchieveIntegral));
        
    	return totalAchieveIntegral;
    }
    
    /**
     * 获取项目结算的价值积分，即项目结算时的获取的可结算预留积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public static double getTotalProjectAccountIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//初始化项目结算的预留积分
    	double totalProjectAccountIntegral = 0;
    	StringBuilder plateProjectAccountRecordSql = new StringBuilder();
    	plateProjectAccountRecordSql.append(BasePlateProjectAccountRecord.CS_ACCOUNT_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateProjectAccountRecord.CS_ACCOUNT_DATE).append(" <= '").append(endDate).append("'");
    	PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
    	plateProjectAccountRecordDao.setConditionPlateId("=",plateId);
    	List<BasePlateProjectAccountRecord> plateProjectAccountRecordList = plateProjectAccountRecordDao.conditionalLoad(plateProjectAccountRecordSql.toString());
    	if(!BaseHelpUtils.isNullOrEmpty(plateProjectAccountRecordList) && !plateProjectAccountRecordList.isEmpty()){
    		for(BasePlateProjectAccountRecord e : plateProjectAccountRecordList){
    			totalProjectAccountIntegral += BaseHelpUtils.getDoubleValue(e.getAccountIntegral());
    		}
    	}
    	__LOGGER.info("项目总的结算的预留积分："+totalProjectAccountIntegral);
    	return totalProjectAccountIntegral;
    }
    
    /**
     * 获取公司补贴的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public static double getTotalCompanyIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//初始化公司补贴的积分
    	double totalCompanyIntegral = 0;
    	StringBuilder plateIntegralSendSql = new StringBuilder();
    	plateIntegralSendSql.append(BasePlateIntegralSend.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralSend.CS_SEND_DATE).append(" <= '").append(endDate).append("'");
    	//检索公司给部门补贴的积分
        PlateIntegralSend plateIntegralSendDao = new PlateIntegralSend();
        plateIntegralSendDao.setConditionPlateId("=", plateId);
        List<BasePlateIntegralSend> plateIntegralSendList = plateIntegralSendDao.conditionalLoad(plateIntegralSendSql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralSendList) && !plateIntegralSendList.isEmpty()){
            for(BasePlateIntegralSend e : plateIntegralSendList){
            	totalCompanyIntegral += BaseHelpUtils.getDoubleValue(e.getSendIntegral());
            }
        }
        __LOGGER.info("公司补贴的积分："+totalCompanyIntegral);
    	return totalCompanyIntegral;
    }
    
    /**
     * 获取部门发放给管理项目的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public static double getTotalAssignIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//初始化部门发放给管理项目的积分
    	double totalAssignIntegral = 0;
    	StringBuilder mangetProjectSql = new StringBuilder();
    	mangetProjectSql.append(BaseManageProject.CS_PROJECT_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BaseManageProject.CS_PROJECT_DATE).append(" <= '").append(endDate).append("'");
        ManageProject mangetProjectDao = new ManageProject();
        mangetProjectDao.setConditionPlateId("=",plateId);
        List<BaseManageProject> mangetProjectList = mangetProjectDao.conditionalLoad(mangetProjectSql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(mangetProjectList) && !mangetProjectList.isEmpty()){
        	for(BaseManageProject e : mangetProjectList){
        		totalAssignIntegral += BaseHelpUtils.getDoubleValue(e.getTotalIntegral());
        	}
        }
        __LOGGER.info("部门发放给管理项目的积分："+totalAssignIntegral);
    	return totalAssignIntegral;
    }
    
    /**
     * 获取部门的运营成本
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public static double getTotalCostIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//初始化运营成本
    	double totalCostIntegral = 0;
    	StringBuilder plateCostRecordSql = new StringBuilder();
    	plateCostRecordSql.append(BasePlateCostRecord.CS_COST_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateCostRecord.CS_COST_DATE).append(" <= '").append(endDate).append("'");
        PlateCostRecord plateCostRecordDao = new PlateCostRecord();
        plateCostRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateCostRecord> plateCostRecordList = plateCostRecordDao.conditionalLoad(plateCostRecordSql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateCostRecordList) && !plateCostRecordList.isEmpty()){
        	for(BasePlateCostRecord e : plateCostRecordList){
        		totalCostIntegral += BaseHelpUtils.getDoubleValue(e.getCostIntegral());
        	}
        }
        __LOGGER.info("运营成本："+totalCostIntegral);
    	return totalCostIntegral;
    }
    
    /**
     * 获取部门的人工成本
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     * @throws UnsupportedEncodingException 
     */
    public static double getTotalBasicSalary(int plateId,Date startDate,Date endDate) throws SQLException, UnsupportedEncodingException{
    	//初始化人工成本
    	double totalBasicSalary = 0;
    	//获取开始日期和结束日期的相差月数
    	int months = DateUtil.getCompareMonths(startDate, endDate);
    	Date customDate = startDate;
    	for(int i = 0;i<months;i++){
    		//获取当前日期的年份
        	int year = DateUtil.getYear(customDate);
        	//获取当前日期的月份
        	int month = DateUtil.getMonth(customDate);
        	//获取职员id集合
        	Object[] empIds = getEmpArrOfPlate(plateId, year, month);
        	//获取业务部门的人工成本
        	totalBasicSalary += getEmployeeSalaryOfPlate(plateId, year, month, empIds);
        	//每遍历一次，都将当期日期都累加一个月
        	customDate = DateUtil.getNextMonth(customDate);
    	}
    	__LOGGER.info("人工成本："+totalBasicSalary);
    	return totalBasicSalary;
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
    public static Object[] getEmpArrOfPlate(int plateId,int year,int month) throws SQLException {
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
    public static double getEmployeeSalaryOfPlate(int plateId, int years, int month, Object[] empArr) throws SQLException, UnsupportedEncodingException {
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
        return empSalaryTotal;
    }
    
    /**
     * 根据板块ID和板块的价值积分获取最终的价值积分，即根据获取到计算后得到的价值积分+转移进来的价值积分-转移出去的价值积分+公司补贴的积分+项目给到部门的可结算预留积分
     * @param plateId
     * @param accReserveIntegral
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException 
     */
    public static double getFinalAccReserveIntegral(int plateId,double accReserveIntegral,String startDate,String endDate) throws SQLException{
        //获取该部门已转移走的价值积分
        PlateIntegralTransferRecord plateIntegralTransferRecordDao = new PlateIntegralTransferRecord();
        plateIntegralTransferRecordDao.setConditionFromPlateId("=", plateId);
        StringBuilder sql = new StringBuilder();
        StringBuilder sqls = new StringBuilder();
        StringBuilder plateProjectSql = new StringBuilder();
        if(!BaseHelpUtils.isNullOrEmpty(startDate)){
            sql.append(BasePlateIntegralTransferRecord.CS_TRANSFER_DATE).append(" >= '").append(startDate).append("'");
            sqls.append(BasePlateIntegralAssignRecord.CS_ASSIGN_DATE).append(" >= '").append(startDate).append("'");
            plateProjectSql.append(BasePlateProjectIntegralRecord.CS_SEND_DATE).append(" >= '").append(startDate).append("'");
        }
        if(!BaseHelpUtils.isNullOrEmpty(endDate)){
            sql.append("and ").append(BasePlateIntegralTransferRecord.CS_TRANSFER_DATE).append(" < '").append(endDate).append("'");
            sqls.append("and ").append(BasePlateIntegralAssignRecord.CS_ASSIGN_DATE).append(" < '").append(endDate).append("'");
            plateProjectSql.append("and ").append(BasePlateProjectIntegralRecord.CS_SEND_DATE).append(" < '").append(endDate).append("'");
        }
        List<BasePlateIntegralTransferRecord> plateIntegralTransferRecordList = plateIntegralTransferRecordDao.conditionalLoad(sql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralTransferRecordList) && !plateIntegralTransferRecordList.isEmpty()){
            for(BasePlateIntegralTransferRecord e : plateIntegralTransferRecordList){
                accReserveIntegral -= BaseHelpUtils.getDoubleValue(e.getTransferIntegral());
            }
        }
        //获取该部门转移进来的价值积分
        plateIntegralTransferRecordDao.clear();
        plateIntegralTransferRecordDao.setConditionToPlateId("=", plateId);
        plateIntegralTransferRecordList = plateIntegralTransferRecordDao.conditionalLoad(sql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralTransferRecordList) && !plateIntegralTransferRecordList.isEmpty()){
            for(BasePlateIntegralTransferRecord e : plateIntegralTransferRecordList){
                accReserveIntegral += BaseHelpUtils.getDoubleValue(e.getTransferIntegral());
            }
        }
        //获取该部门发放出去的价值积分
        PlateIntegralAssignRecord plateIntegralAssignRecordDao = new PlateIntegralAssignRecord();
        plateIntegralAssignRecordDao.setConditionPlateId("=", plateId);
        List<BasePlateIntegralAssignRecord> plateIntegralAssignRecordList = plateIntegralAssignRecordDao.conditionalLoad(sqls.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralAssignRecordList) && !plateIntegralAssignRecordList.isEmpty()){
            for(BasePlateIntegralAssignRecord e : plateIntegralAssignRecordList){
                accReserveIntegral -= BaseHelpUtils.getDoubleValue(e.getAssignIntegral());
            }
        }
        //检索公司给部门补贴的积分
        PlateIntegralSend plateIntegralSendDao = new PlateIntegralSend();
        plateIntegralSendDao.setConditionPlateId("=", plateId);
        List<BasePlateIntegralSend> plateIntegralSendList = plateIntegralSendDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralSendList) && !plateIntegralSendList.isEmpty()){
            for(BasePlateIntegralSend e : plateIntegralSendList){
                accReserveIntegral += BaseHelpUtils.getDoubleValue(e.getSendIntegral());
            }
        }
        //获取各项目给到部门的可结算的预留积分
        PlateProjectIntegralRecord plateProjectIntegralRecordDao = new PlateProjectIntegralRecord();
        plateProjectIntegralRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateProjectIntegralRecord> plateProjectIntegralRecordList = plateProjectIntegralRecordDao.conditionalLoad(plateProjectSql.toString());
        if(!BaseHelpUtils.isNullOrEmpty(plateProjectIntegralRecordList) && !plateProjectIntegralRecordList.isEmpty()){
        	for(BasePlateProjectIntegralRecord e : plateProjectIntegralRecordList){
        		accReserveIntegral += BaseHelpUtils.getDoubleValue(e.getSendIntegral());
        	}
        }
        
        return accReserveIntegral;
    };
    
    public static void main(String[] args) throws SQLException, ParseException, UnsupportedEncodingException {
    	double ss = getTotalAchieveIntegral(1, null, null);
    	System.out.println(ss);
    	
//    	double mm = 1110.9898889;
//    	DecimalFormat df = new DecimalFormat("#");
//    	System.out.println(df.format(mm));
	} 
}
