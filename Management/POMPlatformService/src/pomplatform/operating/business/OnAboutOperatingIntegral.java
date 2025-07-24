package pomplatform.operating.business;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pomplatform.db.bean.BaseBonusPaymentRecord;
import com.pomplatform.db.bean.BaseEmployeeChangePlateRecord;
import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.bean.BaseOperatingReportRecord;
import com.pomplatform.db.bean.BasePlateCostRecord;
import com.pomplatform.db.bean.BasePlateIntegralAchieve;
import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.dao.BonusPaymentRecord;
import com.pomplatform.db.dao.EmployeeChangePlateRecord;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.PlateCostRecord;
import com.pomplatform.db.dao.PlateIntegralAchieve;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.SystemConfig;
import com.pomplatform.db.dao.SystemLog;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import pomplatform.account.bean.BaseOnLoadPlateDataOfAccount;
import pomplatform.account.bean.ConditionOnLoadPlateDataOfAccount;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.account.query.QueryOnLoadPlateDataOfAccount;
import pomplatform.common.utils.StaticUtils;
import pomplatform.operating.bean.BaseAadvanceprojectOnOtherPlateIntegral;
import pomplatform.operating.bean.BaseOperatingOnOtherPlateIntegral;
import pomplatform.operating.bean.BaseOperatingOnPayCommonPlateIntegral;
import pomplatform.operating.bean.ConditionAadvanceprojectOnOtherPlateIntegral;
import pomplatform.operating.bean.ConditionOperatingOnOtherPlateIntegral;
import pomplatform.operating.bean.ConditionOperatingOnPayCommonPlateIntegral;
import pomplatform.operating.query.QueryAadvanceprojectOnOtherPlateIntegral;
import pomplatform.operating.query.QueryOperatingOnOtherPlateIntegral;
import pomplatform.operating.query.QueryOperatingOnPayCommonPlateIntegral;

/**
 * 计算公司账户项目信息
 * @author lxf
 */
public class OnAboutOperatingIntegral implements GenericProcessor,GenericDownloadProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //获取运营报表数据集
    private static final String ON_LOAD_GRID_DATA = "onLoadGirdData";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取业务部门
        String plateIds = BaseHelpUtils.getString(param.get("plateId"));
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        //获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        Date startDate = new Date(Long.valueOf(startDateStr));
    	//获取结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        if(ON_LOAD_GRID_DATA.equals(optType)){
        	return onLoadGirdData(plateIds,startDate,endDate);
        }

        
        return null;
    }
    
    /**
     * 获取gird的数据集
     * 如果plateId=0,表示加载所有业务部门的数据集，如果大于0，则表示只加载自己业务部门下的数据集
     * @return
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
    public String onLoadGirdData(String plateIds,Date startDate,Date endDate) throws SQLException, UnsupportedEncodingException{
    	BaseCollection<BaseOperatingReportRecord> bc = new BaseCollection<>();
    	if(plateIds.equals("all")){//表示加载所有业务部门的数据集
    		List<BaseOperatingReportRecord> result = new ArrayList<>();
    		//加载出所有的业务部门
    		PlateRecord dao = new PlateRecord();
    		List<BasePlateRecord> resultList = dao.conditionalLoad(" order by "+BasePlateRecord.CS_PLATE_ID +" asc");
    		if(!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()){
    			for(BasePlateRecord e : resultList){
    				//获取业务部门id
    				int id = BaseHelpUtils.getIntValue(e.getPlateId());
    				BaseOperatingReportRecord bean = onDataAccount(id, startDate, endDate);
    				result.add(bean);
    			}
    		}
    		bc.setCollections(result);
    		return bc.toJSON(1, "");
    	}else{
    		if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
    			String[] arr = plateIds.split(",");
    			List<BaseOperatingReportRecord> list = new ArrayList<>();
    			for(String str : arr){
    				BaseOperatingReportRecord bean = onDataAccount(BaseHelpUtils.getIntValue(str), startDate, endDate);
    				list.add(bean);
    			}
    			bc.setCollections(list);
    			return bc.toJSON(1, "");
    		}
    	}
    	return bc.toJSON(-1, null);
    }
    
    /**
     * 获取业务部门的数据集
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws UnsupportedEncodingException
     * @throws SQLException
     */
    public BaseOperatingReportRecord onDataAccount(int plateId,Date startDate,Date endDate) throws UnsupportedEncodingException, SQLException{
    	//确认积分
    	BigDecimal sureIntegral = BigDecimal.ZERO;
    	//项目上确认的积分
    	BigDecimal sureIntegralOfProject = BigDecimal.ZERO;
    	//部门上确认的积分
    	BigDecimal sureIntegralOfPlate = BigDecimal.ZERO;
    	//公司补贴
    	BigDecimal companySubsidy = BigDecimal.ZERO;
    	//来自其它部门积分
    	BigDecimal achieveOtherPlateIntegral = BigDecimal.ZERO;
    	//研发项目(公司立项給到自己部门成员的积分)
    	BigDecimal developProject  = BigDecimal.ZERO;
    	//管理项目(公司立项給到自己部门成员的积分)
    	BigDecimal manageProject = BigDecimal.ZERO;
    	//公司借款
    	BigDecimal companyAdvance = BigDecimal.ZERO;
    	//协作收入
    	BigDecimal collaborativeAchieve = BigDecimal.ZERO;
    	
    	//人工成本
    	BigDecimal salaryCost = BigDecimal.ZERO;
    	//运营成本
    	BigDecimal plateCost = BigDecimal.ZERO;
    	//项目成本
    	BigDecimal projectCost = BigDecimal.ZERO;
    	//综合部门分摊
    	BigDecimal payCommonPlateIntegral = BigDecimal.ZERO;
    	//给其它部门积分
    	BigDecimal payOtherPlateIntegral = BigDecimal.ZERO;
    	//协作支出
    	BigDecimal collaborativePay = BigDecimal.ZERO;
    	//公司费用
    	BigDecimal companyFee = BigDecimal.ZERO;
    	//公司还款
    	BigDecimal companyRefund = BigDecimal.ZERO;
    	
    	//价值积分
    	BigDecimal achieveIntegral = BigDecimal.ZERO;
    	//奖金发放
    	BigDecimal awardSend = BigDecimal.ZERO;
    	//剩余价值积分
    	BigDecimal leftAchieveIntegral = BigDecimal.ZERO;
    	
    	//加载部门数据集
    	ConditionOnLoadPlateDataOfAccount condition = new ConditionOnLoadPlateDataOfAccount();
    	condition.setPlateId(plateId);
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QueryOnLoadPlateDataOfAccount dao = new QueryOnLoadPlateDataOfAccount();
    	BaseCollection<BaseOnLoadPlateDataOfAccount> result = dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOnLoadPlateDataOfAccount> resultList = result.getCollections();
    		for(BaseOnLoadPlateDataOfAccount e : resultList){
    			//获取业务类型
    			int businessTypeId = e.getBusinessTypeId();
    			BigDecimal integral = e.getIntegral()==null?BigDecimal.ZERO:e.getIntegral();
    			if(AccountManageProcess.PLATE_BT_SURE_INTEGRAL == businessTypeId){//确认积分
    				sureIntegralOfPlate = sureIntegralOfPlate.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COMPANY_SUBSIDY == businessTypeId){//公司补贴
    		        companySubsidy = companySubsidy.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COMPANY_ADVANCE == businessTypeId){//公司借款
    				companyAdvance = companyAdvance.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COLLABORATIVE_ACHIEVE == businessTypeId){//协作收入
    				collaborativeAchieve = collaborativeAchieve.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_PLATE_COST == businessTypeId){//运营成本
    				plateCost = plateCost.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COLLABORATIVE_PAY == businessTypeId){//协作支出
    				collaborativePay = collaborativePay.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COMPANY_FEE == businessTypeId){//公司费用
    				companyFee = companyFee.add(integral);
    			}else if(AccountManageProcess.PLATE_BT_COMPANY_REFUND == businessTypeId){//公司还款
    				companyRefund = companyRefund.add(integral);
    			}
    		}
    	}
    	
    	//获取该部门下的项目的数据集
    	Object[] projectIds = getProjectsOrPlate(plateId);
        //获取业务部门下项目的确认积分
        sureIntegralOfProject = getSureIntegralOfProject(projectIds, startDate, endDate);
    	//获取该部门的确认的积分
//        sureIntegralOfPlate = getSureIntegralOfPlate(plateId, startDate, endDate);
        //设置确认积分，即项目的确认积分+部门的确认的积分
        sureIntegral = sureIntegralOfProject.add(sureIntegralOfPlate);
        //获取该部门下公司补贴的积分
//        companySubsidy = getCompanySubsidy(plateId, startDate, endDate);
        //获取来自其它部门的积分
        achieveOtherPlateIntegral = getAchieveOtherPlateIntegral(plateId, startDate, endDate);
        //获取其它部门的管理项目的积分
        BigDecimal achieveCommonPlateIntegral = getAchieveCommonPlateIntegral(plateId, startDate, endDate);
        achieveOtherPlateIntegral = achieveOtherPlateIntegral.add(achieveCommonPlateIntegral);
        //研发项目(公司立项給到自己部门成员的积分)
        developProject = getDevelopProjectIntegral(plateId,startDate, endDate);
        //管理项目(公司立项給到自己部门成员的积分)
        manageProject = getManageProjectIntegral(plateId,startDate, endDate);
        
        //获取该部门下的人工成本
        salaryCost = getSalayCost(plateId, startDate, endDate);
    	//获取该部门的运营成本
//        plateCost = getPlateCost(plateId, startDate, endDate);
        //获取项目成本
        projectCost = getProjectCost(projectIds, startDate, endDate);
        //获取综合部门分摊积分
        payCommonPlateIntegral = getPayCommonPlateIntegral(plateId, startDate, endDate);
        //获取給其他部门的积分
        payOtherPlateIntegral = getPayOtherPlateIntegral(plateId, startDate, endDate);
        //获取品质管理费
//        qualityFee = getQualityFee(plateId, startDate, endDate);
        //获取公司费用
//        companyFee = getCompanyFee(plateId, startDate, endDate);
        //价值积分，即确认积分+公司补贴+来自其它部门的积分+研发项目+管理项目+公司借款+协作收入-人工成本-运营成本-综合部门分摊积分-給其他部门的积分-协作支出-公司费用-公司还款
        achieveIntegral = sureIntegral.add(companySubsidy).add(achieveOtherPlateIntegral).add(developProject).add(manageProject).add(companyAdvance).add(collaborativeAchieve)
        		.subtract(salaryCost).subtract(plateCost).subtract(projectCost).subtract(payCommonPlateIntegral)
        		.subtract(payOtherPlateIntegral).subtract(collaborativePay).subtract(companyFee).subtract(companyRefund);
        //获取奖金发放
        awardSend = getAwardSend(plateId, startDate, endDate);
        //剩余价值积分，即价值积分-奖金发放
        leftAchieveIntegral = achieveIntegral.subtract(awardSend);
        
    	BaseOperatingReportRecord bean = new BaseOperatingReportRecord();
    	
    	bean.setPlateId(plateId);
        //收入***********************
    	bean.setSureIntegral(sureIntegral);
    	bean.setCompanySubsidy(companySubsidy);
    	bean.setAchieveOtherPlateIntegral(achieveOtherPlateIntegral);
    	bean.setDevelopProject(developProject);
        bean.setManageProject(manageProject);
        bean.setCompanyAdvance(companyAdvance);
        bean.setCollaborativeAchieve(collaborativeAchieve);
        //支出***********************
        bean.setSalaryCost(salaryCost);
        bean.setPlateCost(plateCost);
        bean.setProjectCost(projectCost);
        bean.setPayCommonPlateIntegral(payCommonPlateIntegral);
        bean.setPayOtherPlateIntegral(payOtherPlateIntegral);
        bean.setCollaborativePay(collaborativePay);
        bean.setCompanyFee(companyFee);
        bean.setCompanyRefund(companyRefund);
        //分析***********************
        bean.setAchieveIntegral(achieveIntegral);
        bean.setAwardSend(awardSend);
        bean.setLeftAchieveIntegral(leftAchieveIntegral);
        return bean;
    }
    
    /**
     * 获取该部门下的项目的数据集
     * @param plateId
     * @return
     * @throws SQLException
     */
    public Object[] getProjectsOrPlate(int plateId) throws SQLException{
    	Project projectDao = new Project();
        projectDao.unsetSelectFlags();
        projectDao.setSelectProjectId(true);
        projectDao.setSelectPlateId(true);//业务部门
        projectDao.setConditionPlateId("=",plateId);
        projectDao.setConditionProjectFlag("=",1);//只检索设计项目的数据
        List<BaseProject> projectList = projectDao.conditionalLoad();
        Object[] projectIds = new Object[projectList.size()];
        int k = 0;
        if(!BaseHelpUtils.isNullOrEmpty(projectList) && !projectList.isEmpty()){
        	for(BaseProject e : projectList){
        		projectIds[k] = BaseHelpUtils.getIntValue(e.getProjectId());
        		k++;
        	}
        }
        return projectIds;
    }
    
    /**
     * 研发项目(公司立项給到自己部门成员的积分)
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getDevelopProjectIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//研发项目
    	BigDecimal developProject = BigDecimal.ZERO;
    	ConditionOperatingOnOtherPlateIntegral condition = new ConditionOperatingOnOtherPlateIntegral();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	KeyValuePair[] keyValues = new KeyValuePair[1];
    	KeyValuePair keyValue1 =new KeyValuePair();
    	Map<String, Object> kv1 = new HashMap<>();
    	kv1.put("key", " and c.project_setup_flag <> 1");
    	kv1.put("value", String.format("%1$s%2$s"," and c.project_flag = 2 and c.project_setup_flag = 1 and b.plate_id = ",plateId));
    	keyValue1.setDataFromMap(kv1);
    	keyValues[0] = keyValue1;
    	QueryOperatingOnOtherPlateIntegral dao = new QueryOperatingOnOtherPlateIntegral();
    	BaseCollection<BaseOperatingOnOtherPlateIntegral> result = dao.executeQuery(keyValues, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnOtherPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnOtherPlateIntegral e : resultList){
    			developProject = developProject.add(e.getFinalAmount()==null?BigDecimal.ZERO:e.getFinalAmount());
    		}
    	}
    	return developProject;
    }
    
    /**
     * 管理项目(公司立项給到自己部门成员的积分)
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getManageProjectIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//管理项目
    	BigDecimal manageProject = BigDecimal.ZERO;
    	ConditionOperatingOnOtherPlateIntegral condition = new ConditionOperatingOnOtherPlateIntegral();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	KeyValuePair[] keyValues = new KeyValuePair[1];
    	KeyValuePair keyValue1 =new KeyValuePair();
    	Map<String, Object> kv1 = new HashMap<>();
    	kv1.put("key", " and c.project_setup_flag <> 1");
    	kv1.put("value", String.format("%1$s%2$s"," and c.project_flag = 3 and c.project_setup_flag = 1 and b.plate_id = ",plateId));
    	keyValue1.setDataFromMap(kv1);
    	keyValues[0] = keyValue1;
    	QueryOperatingOnOtherPlateIntegral dao = new QueryOperatingOnOtherPlateIntegral();
    	BaseCollection<BaseOperatingOnOtherPlateIntegral> result = dao.executeQuery(keyValues, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnOtherPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnOtherPlateIntegral e : resultList){
    			manageProject = manageProject.add(e.getFinalAmount()==null?BigDecimal.ZERO:e.getFinalAmount());
    		}
    	}
    	return manageProject;
    }
    
    /**
     * 获取业务部门下项目的确认积分
     * @param projectIds
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getSureIntegralOfProject(Object[] projectIds,Date startDate,Date endDate) throws SQLException{
    	//项目上确认的积分
    	BigDecimal sureIntegralOfProject = BigDecimal.ZERO;
    	//检索项目结算记录信息
        ProjectSettlement projectSettlementDao = new ProjectSettlement();
        projectSettlementDao.addCondition(BaseProjectSettlement.CS_SETTLEMENT_DATE, "between", startDate, endDate);
        if(projectIds.length>0){
        	projectSettlementDao.addCondition(BaseProjectSettlement.CS_PROJECT_ID,"in", projectIds);
        }else{
        	projectSettlementDao.addCondition(BaseProjectSettlement.CS_PROJECT_ID,"in", 0);
        }
        List<BaseProjectSettlement> projectSettlementList = projectSettlementDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(projectSettlementList) && !projectSettlementList.isEmpty()){
        	for(BaseProjectSettlement e : projectSettlementList){
        		sureIntegralOfProject = sureIntegralOfProject.add(e.getTotalAmount()==null?BigDecimal.ZERO:e.getTotalAmount());
        	}
        }
    	return sureIntegralOfProject;
    }
    
    /**
     * 获取该部门的确认的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getSureIntegralOfPlate(int plateId,Date startDate,Date endDate) throws SQLException{
    	//部门上确认的积分
    	BigDecimal sureIntegralOfPlate = BigDecimal.ZERO;
        PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
        plateProjectAccountRecordDao.addCondition(BasePlateProjectAccountRecord.CS_ACCOUNT_DATE, "between", startDate,endDate);
        plateProjectAccountRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateProjectAccountRecord> plateProjectAccountRecordList = plateProjectAccountRecordDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(plateProjectAccountRecordList) && !plateProjectAccountRecordList.isEmpty()){
        	for(BasePlateProjectAccountRecord e : plateProjectAccountRecordList){
        		sureIntegralOfPlate = sureIntegralOfPlate.add(e.getAccountIntegral()==null?BigDecimal.ZERO:e.getAccountIntegral());
        	}
        }
        return sureIntegralOfPlate;
    }
    
    /**
     * 获取该部门下公司补贴的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getCompanySubsidy(int plateId,Date startDate,Date endDate) throws SQLException{
    	//公司补贴积分
    	BigDecimal companySubsidy = BigDecimal.ZERO;
    	//检索公司给部门补贴的积分
        PlateIntegralSend plateIntegralSendDao = new PlateIntegralSend();
        plateIntegralSendDao.addCondition(BasePlateIntegralSend.CS_SEND_DATE, "between", startDate,endDate);
        plateIntegralSendDao.setConditionPlateId("=", plateId);
        List<BasePlateIntegralSend> plateIntegralSendList = plateIntegralSendDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(plateIntegralSendList) && !plateIntegralSendList.isEmpty()){
        	for(BasePlateIntegralSend e : plateIntegralSendList){
        		companySubsidy = companySubsidy.add(e.getSendIntegral()==null?BigDecimal.ZERO:e.getSendIntegral());
        	}
        }
        return companySubsidy;
    }
    
    /**
     * 获取该部门下的人员的人工成本
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException 
     * @throws UnsupportedEncodingException 
     */
    public BigDecimal getSalayCost(int plateId,Date startDate,Date endDate) throws SQLException, UnsupportedEncodingException{
    	//人工成本
    	BigDecimal salayCost = BigDecimal.ZERO;
        EmployeeSalaryDetail employeeSalaryDetailDao = new EmployeeSalaryDetail();
        //获取秘钥
		SystemConfig systemConfigDao = new SystemConfig();
		systemConfigDao.setSystemConfigId(2);
		systemConfigDao.load();
		String key = systemConfigDao.getImagePath();
		for (Date s = startDate; s.compareTo(endDate) <= 0; s = DateUtil.getNextMonth(s)) { 
			//获取当前日期的年份
			int year = DateUtil.getYear(s);
			//获取当前日期的月份
			int month = DateUtil.getMonth(s);
			//获取该部门下每个月的人员的数据集
			Object[] empIds = getEmpArrOfPlate(plateId, year, month);
			if(!BaseHelpUtils.isNullOrEmpty(empIds)){
				for(Object obj : empIds){
					int employeeId = BaseHelpUtils.getIntValue(obj);
					//获取人员的人工成本
					employeeSalaryDetailDao.clear();
					employeeSalaryDetailDao.setConditionEmployeeId("=",employeeId);
					employeeSalaryDetailDao.setConditionSalaryYear("=",year);
					employeeSalaryDetailDao.setConditionSalaryMonth("=",month);
					BaseEmployeeSalaryDetail employeeSalaryDetailBean = employeeSalaryDetailDao.executeQueryOneRow();
					if(!BaseHelpUtils.isNullOrEmpty(employeeSalaryDetailBean)){
						String basicSalary = employeeSalaryDetailBean.getBasicSalary();
						//解密职员的人工成本
						DES des = new DES(key);
						salayCost = salayCost.add(new BigDecimal(des.DEC(basicSalary)));
					}
					
				}
			}
		}
    	return salayCost;
    }
    
    /**
     * 获取指定板块下的成员集合
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
    
    /**
     * 获取该部门的运营成本
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getPlateCost(int plateId,Date startDate,Date endDate) throws SQLException{
    	//运营成本
    	BigDecimal plateCost = BigDecimal.ZERO;
    	//部门的运营成本
        PlateCostRecord plateCostRecordDao = new PlateCostRecord();
        plateCostRecordDao.addCondition(BasePlateCostRecord.CS_COST_DATE, "between", startDate,endDate);
        plateCostRecordDao.setConditionPlateId("=",plateId);
        List<BasePlateCostRecord> plateCostRecordList = plateCostRecordDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(plateCostRecordList) && !plateCostRecordList.isEmpty()){
        	for(BasePlateCostRecord e : plateCostRecordList){
        		plateCost = plateCost.add(e.getCostIntegral()==null?BigDecimal.ZERO:e.getCostIntegral());
        	}
        }
        return plateCost;
    }
    
    /**
     * 获取项目成本
     * @param projectIds
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getProjectCost(Object[] projectIds,Date startDate,Date endDate) throws SQLException{
    	//项目成本
    	BigDecimal projectCost = BigDecimal.ZERO;
        ProjectCost projectCostDao = new ProjectCost();
        projectCostDao.addCondition(BaseProjectCost.CS_COST_DATE, "between", startDate,endDate);
        if(projectIds.length>0){
        	projectCostDao.addCondition(BaseProjectCost.CS_PROJECT_ID,"in", projectIds);
        }else{
        	projectCostDao.addCondition(BaseProjectCost.CS_PROJECT_ID,"in", 0);
        }
        projectCostDao.setConditionStatus("=",StaticUtils.SETTLEMENT_STATUS_YES);
        List<BaseProjectCost> projectCostList = projectCostDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(projectCostList) && !projectCostList.isEmpty()){
        	for(BaseProjectCost e : projectCostList){
        		projectCost = projectCost.add(e.getAmount()== null?BigDecimal.ZERO:e.getAmount());
        	}
        }
        return projectCost;
    }
    
    /**
     * 获取从其他部门获取的部门分摊积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getAchieveCommonPlateIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//综合部门分摊积分
    	BigDecimal achieveCommonPlateIntegral = BigDecimal.ZERO;
    	ConditionOperatingOnPayCommonPlateIntegral condition = new ConditionOperatingOnPayCommonPlateIntegral();
    	condition.setPlateId(plateId);
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	
    	//更改查询的语句，将不等于改成等于
    	KeyValuePair[] keyValues = new KeyValuePair[2];
    	KeyValuePair keyValue1 =new KeyValuePair();
    	KeyValuePair keyValue2 =new KeyValuePair();
    	Map<String, Object> kv1 = new HashMap<>();
    	Map<String, Object> kv2 = new HashMap<>();
    	kv1.put("key", "c.plate_id = ");
    	kv1.put("value", "c.plate_id <> ");
    	kv2.put("key", "b.plate_id <> ");
    	kv2.put("value", "b.plate_id = ");
    	keyValue1.setDataFromMap(kv1);
    	keyValue2.setDataFromMap(kv2);
    	keyValues[0] = keyValue1;
    	keyValues[1] = keyValue2;
    	
    	QueryOperatingOnPayCommonPlateIntegral dao = new QueryOperatingOnPayCommonPlateIntegral();
    	BaseCollection<BaseOperatingOnPayCommonPlateIntegral> result =  dao.executeQuery(keyValues, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnPayCommonPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnPayCommonPlateIntegral e : resultList){
    			achieveCommonPlateIntegral = achieveCommonPlateIntegral.add(e.getAssignedIntegral()==null?BigDecimal.ZERO:e.getAssignedIntegral());
    		}
    	}
    	return achieveCommonPlateIntegral;
    }
    
    /**
     * 获取该部门下的综合部门分摊积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getPayCommonPlateIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//综合部门分摊积分
    	BigDecimal payCommonPlateIntegral = BigDecimal.ZERO;
    	ConditionOperatingOnPayCommonPlateIntegral condition = new ConditionOperatingOnPayCommonPlateIntegral();
    	condition.setPlateId(plateId);
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QueryOperatingOnPayCommonPlateIntegral dao = new QueryOperatingOnPayCommonPlateIntegral();
    	BaseCollection<BaseOperatingOnPayCommonPlateIntegral> result =  dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnPayCommonPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnPayCommonPlateIntegral e : resultList){
    			payCommonPlateIntegral = payCommonPlateIntegral.add(e.getAssignedIntegral()==null?BigDecimal.ZERO:e.getAssignedIntegral());
    		}
    	}
    	return payCommonPlateIntegral;
    }
    
    /**
     * 获取给其它部门的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getPayOtherPlateIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//给其他部门的积分(项目结算)
    	BigDecimal payOtherPlateIntegral = BigDecimal.ZERO;
    	ConditionOperatingOnOtherPlateIntegral condition = new ConditionOperatingOnOtherPlateIntegral();
    	condition.setPlateId(plateId);
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QueryOperatingOnOtherPlateIntegral dao = new QueryOperatingOnOtherPlateIntegral();
    	BaseCollection<BaseOperatingOnOtherPlateIntegral> result = dao.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnOtherPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnOtherPlateIntegral e : resultList){
    			payOtherPlateIntegral = payOtherPlateIntegral.add(e.getFinalAmount()==null?BigDecimal.ZERO:e.getFinalAmount());
    		}
    	}
    	//给其他部门的积分(项目补贴，即项目补贴给其它部门成员的积分)
    	ConditionAadvanceprojectOnOtherPlateIntegral advanceProjectCondition = new ConditionAadvanceprojectOnOtherPlateIntegral();
    	advanceProjectCondition.setPlateId(plateId);
    	advanceProjectCondition.setStartDate(startDate);
    	advanceProjectCondition.setEndDate(endDate);
    	QueryAadvanceprojectOnOtherPlateIntegral advanceProjectDao = new QueryAadvanceprojectOnOtherPlateIntegral();
    	BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> advanceProjectDaoResult = advanceProjectDao.executeQuery(null, advanceProjectCondition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseAadvanceprojectOnOtherPlateIntegral> resultList = advanceProjectDaoResult.getCollections();
    		for(BaseAadvanceprojectOnOtherPlateIntegral e : resultList){
    			payOtherPlateIntegral = payOtherPlateIntegral.add(e.getAdvancedIntegral()==null?BigDecimal.ZERO:e.getAdvancedIntegral());
    		}
    	}
    	return payOtherPlateIntegral;
    }
    
    /**
     * 获取来自其它部门的积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getAchieveOtherPlateIntegral(int plateId,Date startDate,Date endDate) throws SQLException{
    	//来自其他部门的积分(项目结算)
    	BigDecimal achieveOtherPlateIntegral = BigDecimal.ZERO;
    	//更改查询的语句，将不等于改成等于
    	KeyValuePair[] keyValues = new KeyValuePair[2];
    	KeyValuePair keyValue1 =new KeyValuePair();
    	KeyValuePair keyValue2 =new KeyValuePair();
    	Map<String, Object> kv1 = new HashMap<>();
    	Map<String, Object> kv2 = new HashMap<>();
    	kv1.put("key", "c.plate_id = ");
    	kv1.put("value", "c.plate_id <> ");
    	kv2.put("key", "b.plate_id <> ");
    	kv2.put("value", "b.plate_id = ");
    	keyValue1.setDataFromMap(kv1);
    	keyValue2.setDataFromMap(kv2);
    	keyValues[0] = keyValue1;
    	keyValues[1] = keyValue2;
    	
    	ConditionOperatingOnOtherPlateIntegral condition = new ConditionOperatingOnOtherPlateIntegral();
    	condition.setPlateId(plateId);
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QueryOperatingOnOtherPlateIntegral dao = new QueryOperatingOnOtherPlateIntegral();
    	BaseCollection<BaseOperatingOnOtherPlateIntegral> result = dao.executeQuery(keyValues, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOperatingOnOtherPlateIntegral> resultList = result.getCollections();
    		for(BaseOperatingOnOtherPlateIntegral e : resultList){
    			achieveOtherPlateIntegral = achieveOtherPlateIntegral.add(e.getFinalAmount()==null?BigDecimal.ZERO:e.getFinalAmount());
    		}
    	}
    	//来自其它部门的积分(项目补贴，即项目补贴给其它部门成员的积分)
    	ConditionAadvanceprojectOnOtherPlateIntegral advanceProjectCondition = new ConditionAadvanceprojectOnOtherPlateIntegral();
    	advanceProjectCondition.setPlateId(plateId);
    	advanceProjectCondition.setStartDate(startDate);
    	advanceProjectCondition.setEndDate(endDate);
    	QueryAadvanceprojectOnOtherPlateIntegral advanceProjectDao = new QueryAadvanceprojectOnOtherPlateIntegral();
    	BaseCollection<BaseAadvanceprojectOnOtherPlateIntegral> advanceProjectDaoResult = advanceProjectDao.executeQuery(keyValues, advanceProjectCondition);
    	if(!BaseHelpUtils.isNullOrEmpty(advanceProjectDaoResult)){
    		List<BaseAadvanceprojectOnOtherPlateIntegral> resultList = advanceProjectDaoResult.getCollections();
    		for(BaseAadvanceprojectOnOtherPlateIntegral e : resultList){
    			achieveOtherPlateIntegral = achieveOtherPlateIntegral.add(e.getAdvancedIntegral()==null?BigDecimal.ZERO:e.getAdvancedIntegral());
    		}
    	}
    	return achieveOtherPlateIntegral;
    }
    
    /**
     * 获取奖金发放积分
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getAwardSend(int plateId,Date startDate,Date endDate) throws SQLException{
    	//奖金发放
    	BigDecimal awardSend = BigDecimal.ZERO;
        BonusPaymentRecord awardSendDao = new BonusPaymentRecord();
        awardSendDao.addCondition(BaseBonusPaymentRecord.CS_PAY_DATE, "between", startDate,endDate);
        awardSendDao.setConditionPlateId("=",plateId);
        awardSendDao.setConditionState("=", 1);//审核状态  0:未审核   1:审核通过    2:审核不通过,只筛选审核通过的数据集
        List<BaseBonusPaymentRecord> awardSendList = awardSendDao.conditionalLoad();
        if(!BaseHelpUtils.isNullOrEmpty(awardSendList) && !awardSendList.isEmpty()){
        	for(BaseBonusPaymentRecord e : awardSendList){
        		awardSend = awardSend.add(e.getPayIntegral()==null?BigDecimal.ZERO:e.getPayIntegral());
        	}
        }
    	return awardSend;
    }
    
    /**
     * 获取品质管理费
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getQualityFee(int plateId,Date startDate,Date endDate) throws SQLException{
    	BigDecimal sum = BigDecimal.ZERO;
    	PlateIntegralAchieve dao = new PlateIntegralAchieve();
    	dao.setConditionFromPlateId("=", plateId);
    	dao.setConditionToPlateId("<>", StaticUtils.COMPANY_ACCOUNT);
    	dao.addCondition(BasePlateIntegralAchieve.CS_SEND_DATE, "between", startDate,endDate);
    	List<BasePlateIntegralAchieve> list = dao.conditionalLoad();
    	if(null != list && !list.isEmpty()){
    		for(BasePlateIntegralAchieve obj : list){
    			if(null != obj.getSendIntegral()){
    				sum = sum.add(obj.getSendIntegral());
    			}
    		}
    	}
    	return sum;
    }
    
    /**
     * 获取公司费用
     * @param plateId
     * @param startDate
     * @param endDate
     * @return
     * @throws SQLException
     */
    public BigDecimal getCompanyFee(int plateId,Date startDate,Date endDate) throws SQLException{
    	BigDecimal sum = BigDecimal.ZERO;
    	PlateIntegralAchieve dao = new PlateIntegralAchieve();
    	dao.setConditionFromPlateId("=", plateId);
    	dao.setConditionToPlateId("=", StaticUtils.COMPANY_ACCOUNT);
    	dao.addCondition(BasePlateIntegralAchieve.CS_SEND_DATE, "between", startDate,endDate);
    	List<BasePlateIntegralAchieve> list = dao.conditionalLoad();
    	if(null != list && !list.isEmpty()){
    		for(BasePlateIntegralAchieve obj : list){
    			if(null != obj.getSendIntegral()){
    				sum = sum.add(obj.getSendIntegral());
    			}
    		}
    	}
    	return sum;
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)throws Exception {
		HttpCookie cookie = new HttpCookie(request);
		SystemLog logDao = new SystemLog();
        logDao.setLogContent("导出了事业部的奖金汇总数据");
        logDao.setOperator(cookie.getOperatorId());
        logDao.setOperatorName(cookie.getOperatorName());
        logDao.setFromHost(request.getRemoteAddr());
        logDao.setLogTime(new Date());
        logDao.save();
		JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取业务部门
        String plateIds = BaseHelpUtils.getString(param.get("plateId"));
        //获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        Date startDate = new Date(Long.valueOf(startDateStr));
    	//获取结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        BaseCollection<BaseOperatingReportRecord> bc = new BaseCollection<>();
        List<BaseOperatingReportRecord> result = new ArrayList<>();
    	if(plateIds.equals("all")){//表示加载所有业务部门的数据集
    		//加载出所有的业务部门
    		PlateRecord dao = new PlateRecord();
    		List<BasePlateRecord> resultList = dao.conditionalLoad(" order by "+BasePlateRecord.CS_PLATE_ID +" asc");
    		if(!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()){
    			for(BasePlateRecord e : resultList){
    				//获取业务部门id
    				int id = BaseHelpUtils.getIntValue(e.getPlateId());
    				BaseOperatingReportRecord bean = onDataAccount(id, startDate, endDate);
    				result.add(bean);
    			}
    		}
    	}else{
    		if(!BaseHelpUtils.isNullOrEmpty(plateIds)){
    			String[] arr = plateIds.split(",");
    			for(String str : arr){
    				BaseOperatingReportRecord bean = onDataAccount(BaseHelpUtils.getIntValue(str), startDate, endDate);
    				result.add(bean);
    			}
    		}
    	}
        
        
//        List<BaseOperatingReportRecord> resultList = GenericBase.__getList(param.get("exportData"), BaseOperatingReportRecord.newInstance());
//		BaseCollection<BaseOperatingReportRecord> result=new BaseCollection<>();
//		if(!BaseHelpUtils.isNullOrEmpty(resultList) && !resultList.isEmpty()){
//			result.setCollections(resultList);
//		}
//		try(PrintStream ps = new PrintStream(downFile, "GBK")){
//			ps.println(BaseOperatingReportRecord.ALL_CAPTIONS);
//			for(BaseOperatingReportRecord b : result.getCollections()){
//				ps.println(b.toCSVString());
//			}
//		}
		if(result.size() > 0){
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String headName = BaseOperatingReportRecord.CUSTOM_CAPTIONS;
	    	String headNameArra [] = headName.split(",");
	    	String fileName = format.format(date) + "导出的奖金汇总.xls";
			fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
			response.reset();
			response.setHeader("Content-Disposition", "attachment;filename="
					+ fileName);// 指定下载的文件名
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			OutputStream output = response.getOutputStream();
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);

			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建单元格样式
			HSSFCellStyle cellStyleTitle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 指定单元格垂直居中对齐
			cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyleTitle.setWrapText(false);
			// ------------------------------------------------------------------
			HSSFCellStyle cellStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			// 指定单元格垂直居中对齐
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			cellStyle.setWrapText(false);
			// ------------------------------------------------------------------
			HSSFCellStyle numberStyle = wb.createCellStyle();
			// 指定单元格居中对齐
			numberStyle.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			// 指定单元格垂直居中对齐
			numberStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			// 指定当单元格内容显示不下时自动换行
			numberStyle.setWrapText(false);
			// ------------------------------------------------------------------
			// 设置单元格字体
			HSSFFont font = wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setFontName("宋体");
			font.setFontHeight((short) 200);
			cellStyleTitle.setFont(font);
			
			HSSFSheet sheet = wb.createSheet();
//			ExportExcelUtil exportExcel = new ExportExcelUtil(wb, sheet);
			// 创建报表头部
//			exportExcel.createNormalHead(worksheetTitle, headNameArra.length);
			//设置表头
			HSSFRow row1 = sheet.createRow(0);
			for (int i = 0; i < headNameArra.length; i++) {
				HSSFCell tmpCell = row1.createCell(i);
				tmpCell.setCellStyle(cellStyleTitle);
				tmpCell.setCellValue(new HSSFRichTextString(headNameArra[i]));
			}
			HSSFRow row = sheet.createRow(1);
			HSSFCell cell = row.createCell(1);
			int size = result.size();
			for (int i = 0; i < size; i++) {
				BaseOperatingReportRecord bean = result.get(i);
				row = sheet.createRow(i + 1);
				int j = 0;
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(delicacy.system.executor.SelectValueCache.getSelectValue("system_dictionary_1", String.valueOf(bean.getPlateId()))));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getAchieveIntegral()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getAwardSend() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getLeftAchieveIntegral()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSureIntegral()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCompanySubsidy()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getAchieveOtherPlateIntegral()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getDevelopProject()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getManageProject()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCompanyAdvance() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCollaborativeAchieve()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getSalaryCost() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(numberStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getPlateCost() + ""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getProjectCost()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getPayCommonPlateIntegral()+""));

				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getPayOtherPlateIntegral()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCollaborativePay()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCompanyFee()+""));
				
				cell = row.createCell(j++);
				cell.setCellStyle(cellStyle);
				cell.setCellValue(new HSSFRichTextString(bean.getCompanyRefund()+""));
			}
			try {
				bufferedOutPut.flush();
				wb.write(bufferedOutPut);
				bufferedOutPut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				result.clear();
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return "csv";
	}
    
}
