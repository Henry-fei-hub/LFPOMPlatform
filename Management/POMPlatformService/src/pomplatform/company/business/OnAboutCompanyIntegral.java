package pomplatform.company.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompanyIntegralRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BasePlateIntegralAchieve;
import com.pomplatform.db.bean.BasePlateIntegralSend;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAdvanceRecord;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.CompanyIntegralRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.PlateIntegralAchieve;
import com.pomplatform.db.dao.PlateIntegralSend;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAdvanceRecord;
import com.pomplatform.db.dao.SubContract;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.company.bean.BaseCompanyAccount;
import pomplatform.company.bean.BaseCompanyAccountGetSheetTotal;
import pomplatform.company.bean.BaseSheetTotalByBusinessProjectPlate;
import pomplatform.company.bean.BaseSheetTotalByBusinessType;
import pomplatform.company.bean.BaseSheetTotalByPlateId;
import pomplatform.company.bean.BaseSheetTotalByProjectType;
import pomplatform.company.bean.ConditionCompanyAccountGetSheetTotal;
import pomplatform.company.bean.ConditionSheetTotalByBusinessProjectPlate;
import pomplatform.company.bean.ConditionSheetTotalByBusinessType;
import pomplatform.company.bean.ConditionSheetTotalByPlateId;
import pomplatform.company.bean.ConditionSheetTotalByProjectType;
import pomplatform.company.query.QueryCompanyAccountGetSheetTotal;
import pomplatform.company.query.QuerySheetTotalByBusinessProjectPlate;
import pomplatform.company.query.QuerySheetTotalByBusinessType;
import pomplatform.company.query.QuerySheetTotalByPlateId;
import pomplatform.company.query.QuerySheetTotalByProjectType;

/**
 * 计算公司账户项目信息
 * @author lxf
 */
public class OnAboutCompanyIntegral implements GenericProcessor {
    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //计算公司账户汇总信息
    private static final String ON_ACCOUNT_COMPANY_INTEGRAL = "onAccountCompanyIntegral";
    //订单总积分、订单积分的业务类别搜索
    private static final String ON_LOAD_SHEET_INTEGRAL_BUGINESS_TYPE = "onLoadSheetIntegralBusinessType";
    //订单总积分、订单积分的项目类别搜索
    private static final String ON_LOAD_SHEET_INTEGRAL_PROJECT_TYPE = "onLoadSheetIntegralProjectType";
    //订单总积分、订单积分的承接部门搜索
    private static final String ON_LOAD_SHEET_INTEGRAL_PLATE_ID = "onLoadSheetIntegralPlateId";
    //订单总积分、订单积分的默认搜索
    private static final String ON_LOAD_SHEET_INTEGRAL_DEFAULT = "onLoadSheetIntegralDefault";
    //获取公司补贴数据集
    private static final String ON_LOAD_COMPANY_ADVANCE = "onLoadCompanyAdvance";
    //获取公司费用
    private static final String ON_LOAD_COMPANYFEE = "onLoadCompanyFee";
    //加载公司借款和还款
    private static final String ON_LOAD_COMPANY_ADVANCE_OF_REFUND = "onLoadCompanyAdvanceOfRefund";
    //加载项目补贴详情
    private static final String ON_LOAD_PROJECT_ADVANCE = "onLoadProjectAdvance";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        //获取开始年月份
        String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
        Date startDate = new Date(Long.valueOf(startDateStr));
    	//获取结束年月份
        String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
        Date endDate = new Date(Long.valueOf(endDateStr));
        if(ON_ACCOUNT_COMPANY_INTEGRAL.equals(optType)){
        	return onAccountCompanyIntegral(startDate,endDate);
        }else if(ON_LOAD_SHEET_INTEGRAL_DEFAULT.equals(optType)){
        	return onLoadSheetIntegralDefault(param,startDate,endDate);
        }else if(ON_LOAD_SHEET_INTEGRAL_BUGINESS_TYPE.equals(optType)){
        	return onLoadSheetIntegralBusinessType(startDate,endDate);
        }else if(ON_LOAD_SHEET_INTEGRAL_PROJECT_TYPE.equals(optType)){
        	return onLoadSheetIntegralProjectType(startDate,endDate);
        }else if(ON_LOAD_SHEET_INTEGRAL_PLATE_ID.equals(optType)){
        	return onLoadSheetIntegralPlateId(startDate,endDate);
        }else if(ON_LOAD_COMPANY_ADVANCE.equals(optType)){
        	return onLoadCompanyAdvance(startDate,endDate);
        }else if(ON_LOAD_COMPANYFEE.equals(optType)){
        	return onLoadCompanyFee(startDate,endDate);
        }else if(ON_LOAD_COMPANY_ADVANCE_OF_REFUND.equals(optType)){
        	return onLoadCompanyAdvanceOfRefund(startDate,endDate,param);
        }else if(ON_LOAD_PROJECT_ADVANCE.equals(optType)){
        	return onLoadProjectAdvance(startDate,endDate,param);
        }
        
        return null;
    }
    
    /**
     * 加载公司项目补贴详情
     * @param startDate
     * @param endDate
     * @param param
     * @return
     * @throws SQLException 
     */
    private String onLoadProjectAdvance(Date startDate, Date endDate, Map<String, Object> param) throws SQLException {
		ProjectAdvanceRecord dao = new ProjectAdvanceRecord();
		dao.setConditionFlag("=", 2);
		dao.addCondition(BaseProjectAdvanceRecord.CS_ADVANCE_DATE,"between", startDate,endDate);
		List<BaseProjectAdvanceRecord> list = dao.conditionalLoad(" order by advance_date desc");
		BaseCollection<BaseProjectAdvanceRecord> bc = new BaseCollection<>();
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			bc.setCollections(list);
		}
    	return bc.toJSON(0, null);
	}

	/**
     * 公司账户汇总计算
     * @return
     * @throws SQLException 
     */
    public String onAccountCompanyIntegral(Date startDate,Date endDate) throws SQLException{
    	//积分余额
    	BigDecimal achieveIntegral = BigDecimal.ZERO;
    	//合同总额
    	BigDecimal signingMoneySum = BigDecimal.ZERO;
    	
    	//订单总积分
    	BigDecimal sheetTotalIntegral = BigDecimal.ZERO;
    	//公司补贴
    	BigDecimal companySubsidy = BigDecimal.ZERO;
    	//中标奖金
    	BigDecimal winIntegral = BigDecimal.ZERO;
    	
    	//投诉保证金
    	BigDecimal complaintIntegral = BigDecimal.ZERO;
    	//项目积分提取
    	BigDecimal projectIntegralExtract = BigDecimal.ZERO;
    	//公司费用
    	BigDecimal companyFee = BigDecimal.ZERO;
    	//公司还款
    	BigDecimal companyRefund = BigDecimal.ZERO;
    	
    	//奖金发放
    	BigDecimal awardSend = BigDecimal.ZERO;
    	//公司借款
    	BigDecimal companyAdvance = BigDecimal.ZERO;
    	//研发项目
    	BigDecimal developProject = BigDecimal.ZERO;
    	//管理项目
    	BigDecimal manageProject = BigDecimal.ZERO;
    	//项目补贴
    	BigDecimal projectAdvance = BigDecimal.ZERO;
    	
    	//加载订单数据集
    	QueryCompanyAccountGetSheetTotal q = new QueryCompanyAccountGetSheetTotal();
    	ConditionCompanyAccountGetSheetTotal condition = new ConditionCompanyAccountGetSheetTotal();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	BaseCollection<BaseCompanyAccountGetSheetTotal> contractList = q.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(contractList) && contractList.getCollections().size() > 0){
    		for(BaseCompanyAccountGetSheetTotal e : contractList.getCollections()){
    			//获取订单总积分
    			sheetTotalIntegral = sheetTotalIntegral.add(BaseHelpUtils.getBigDecimalValue(e.getSheetTotalIntegral()));
    			//合同总额
    			signingMoneySum = signingMoneySum.add(BaseHelpUtils.getBigDecimalValue(e.getSigningMoneySum()));
    		}
    	}
    	
    	//加载公司补贴的数据集
    	PlateIntegralSend plateIntegralSentDao = new PlateIntegralSend();
    	plateIntegralSentDao.addCondition(BasePlateIntegralSend.CS_SEND_DATE,"between", startDate,endDate);
    	List<BasePlateIntegralSend> plateIntegralSentList = plateIntegralSentDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(plateIntegralSentList) && !plateIntegralSentList.isEmpty()){
    		for(BasePlateIntegralSend e : plateIntegralSentList){
    			companySubsidy = companySubsidy.add(BaseHelpUtils.getBigDecimalValue(e.getSendIntegral()));
    		}
    	}
    	
    	//加载公司费用的数据
    	PlateIntegralAchieve companyFeeDao = new PlateIntegralAchieve();
    	companyFeeDao.setConditionToPlateId("=", 0);
    	companyFeeDao.addCondition(BasePlateIntegralAchieve.CS_SEND_DATE,"between", startDate,endDate);
    	List<BasePlateIntegralAchieve> companyFeeList = companyFeeDao.conditionalLoad();
    	if(null != companyFeeList && !companyFeeList.isEmpty()){
    		for(BasePlateIntegralAchieve obj : companyFeeList){
    			if(null != obj.getSendIntegral()){
    				companyFee = companyFee.add(BaseHelpUtils.getBigDecimalValue(obj.getSendIntegral()));
    			}
    		}
    	}
    	
    	//加载公司借款和还款数据集
    	CompanyIntegralRecord companyDao = new CompanyIntegralRecord();
    	companyDao.addCondition(BaseCompanyIntegralRecord.CS_RECORD_DATE,"between", startDate,endDate);
    	List<BaseCompanyIntegralRecord> companyList = companyDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(companyList) && !companyList.isEmpty()){
    		for(BaseCompanyIntegralRecord e : companyList){
    			//获取表示字段flag：（1：公司借款；2：公司还款）
    			int flag = BaseHelpUtils.getIntValue(e.getFlag());
    			if(1 == flag){
    				companyAdvance = companyAdvance.add(BaseHelpUtils.getBigDecimalValue(e.getIntegral()));
    			}else{
    				companyRefund = companyRefund.add(BaseHelpUtils.getBigDecimalValue(e.getIntegral()));
    			}
    		}
    	}
    	
    	//加载其它立项，即研发项目和管理项目
    	Project projectDao = new Project();
    	projectDao.setConditionProjectSetupFlag("=",1);//只检索公司立项的研发项目和管理项目
    	projectDao.addCondition(BaseProject.CS_START_DATE,"between",startDate,endDate);
    	List<BaseProject> projectList = projectDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(projectList) && !projectList.isEmpty()){
    		for(BaseProject e : projectList){
    			//获取项目类型标示1:设计项目;2:研发项目;3:管理项目
    			int projectFlag = BaseHelpUtils.getIntValue(e.getProjectFlag());
    			if(projectFlag == 2){
    				developProject = developProject.add(BaseHelpUtils.getBigDecimalValue(e.getProjectIntegral()));
    			}else if(projectFlag == 3){
    				manageProject = manageProject.add(BaseHelpUtils.getBigDecimalValue(e.getProjectIntegral()));
    			}
    		}
    	}
    	
    	//加载项目补贴积分
    	ProjectAdvanceRecord parDao = new ProjectAdvanceRecord();
    	parDao.setConditionFlag("=", 2);
    	parDao.addCondition(BaseProjectAdvanceRecord.CS_ADVANCE_DATE,"between",startDate,endDate);
    	List<BaseProjectAdvanceRecord> parList = parDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(parList) && parList.size() > 0){
    		for(BaseProjectAdvanceRecord obj : parList){
    			projectAdvance = projectAdvance.add(BaseHelpUtils.getBigDecimalValue(obj.getAdvanceIntegral()));
    		}
    	}
    	
    	//设置积分余额，即投诉保证金+项目提取积分+公司费用+公司还款-奖金发放-公司借款-研发项目-管理项目
    	achieveIntegral = complaintIntegral.add(projectIntegralExtract).add(companyFee).add(companyRefund)
		.subtract(awardSend).subtract(companyAdvance).subtract(developProject).subtract(manageProject).subtract(projectAdvance);
    	
    	BaseCompanyAccount bean = new BaseCompanyAccount();
        StringBuilder sb = new StringBuilder();
        BigDecimal tempPercent = BigDecimal.ZERO;
        if(signingMoneySum.compareTo(BigDecimal.ZERO)!=0&&sheetTotalIntegral.compareTo(BigDecimal.ZERO)!=0){
        	tempPercent = sheetTotalIntegral.divide(signingMoneySum,4,BigDecimal.ROUND_DOWN);
        }
        sb.append("订单总积分/合同总额=").append((tempPercent.multiply(new BigDecimal(100)))).append("%");
        //分析***********************
        bean.setPercent(sb.toString());//比率
        bean.setAchieveIntegral(achieveIntegral);//积分余额
        bean.setSigningMoneySum(signingMoneySum);//合同总额
        //印钞机*********************
        bean.setSheetTotalIntegral(sheetTotalIntegral);//订单总积分
        bean.setCompanySubsidy(companySubsidy);//公司补贴
        bean.setWinIntegral(winIntegral);//中标奖金
        //收入***********************
        bean.setComplaintIntegral(complaintIntegral);//投诉保证金
        bean.setProjectIntegralExtract(projectIntegralExtract);//项目积分提取
        bean.setCompanyFee(companyFee);//公司费用
        bean.setCompanyRefund(companyRefund);//公司还款
        //支出***********************
        bean.setAwardSend(awardSend);//奖金发放
        bean.setCompanyAdvance(companyAdvance);//公司借款
        bean.setDevelopProject(developProject);//研发项目
        bean.setManageProject(manageProject);//管理项目
        bean.setProjectAdvance(projectAdvance);//项目补贴
        
        return bean.toOneLineJSON(0,null);
    }
    
    /**
     * 订单总积分、订单积分的默认搜索
     * @return
     * @throws SQLException 
     */
    public String onLoadSheetIntegralDefault(Map<String, Object> param,Date startDate,Date endDate) throws SQLException{
    	//获取业务类别
    	int businessType = BaseHelpUtils.getIntValue(param,"businessType");
    	//获取项目类别
    	int projectType = BaseHelpUtils.getIntValue(param,"projectType");
    	//获取承接部门
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	ConditionSheetTotalByBusinessProjectPlate condition = new ConditionSheetTotalByBusinessProjectPlate();
    	if(businessType > 0){
    		condition.setBusinessType(businessType);
    	}
    	if(projectType > 0){
    		condition.setProjectType(projectType);
    	}
    	if(plateId > 0){
    		condition.setDepartmentId(plateId);
    	}
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QuerySheetTotalByBusinessProjectPlate dao = new QuerySheetTotalByBusinessProjectPlate();
    	dao.executeQuery(null, condition);
    	BaseCollection<BaseSheetTotalByBusinessProjectPlate> result = dao.executeQuery(null,condition);
    	return result.toJSON(null);
    }
    
    /**
     * 订单总积分、订单积分的业务类别搜索
     * @return
     * @throws SQLException 
     */
    public String onLoadSheetIntegralBusinessType(Date startDate,Date endDate) throws SQLException{
    	ConditionSheetTotalByBusinessType condition = new ConditionSheetTotalByBusinessType();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QuerySheetTotalByBusinessType dao = new QuerySheetTotalByBusinessType();
    	BaseCollection<BaseSheetTotalByBusinessType> result = dao.executeQuery(null,condition);
    	return result.toJSON(null);
    }
    
    /**
     * 订单总积分、订单积分的项目类别搜索
     * @return
     * @throws SQLException 
     */
    public String onLoadSheetIntegralProjectType(Date startDate,Date endDate) throws SQLException{
    	ConditionSheetTotalByProjectType condition = new ConditionSheetTotalByProjectType();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QuerySheetTotalByProjectType dao = new QuerySheetTotalByProjectType();
    	BaseCollection<BaseSheetTotalByProjectType> result = dao.executeQuery(null,condition);
    	return result.toJSON(null);
    }
    
    /**
     * 订单总积分、订单积分的承接部门搜索
     * @return
     * @throws SQLException 
     */
    public String onLoadSheetIntegralPlateId(Date startDate,Date endDate) throws SQLException{
    	ConditionSheetTotalByPlateId condition = new ConditionSheetTotalByPlateId();
    	condition.setStartDate(startDate);
    	condition.setEndDate(endDate);
    	QuerySheetTotalByPlateId dao = new QuerySheetTotalByPlateId();
    	BaseCollection<BaseSheetTotalByPlateId> result = dao.executeQuery(null,condition);
    	return result.toJSON(null);
    }
    
    /**
     * 获取公司补贴数据集
     * @return
     * @throws SQLException 
     */
    public String onLoadCompanyAdvance(Date startDate,Date endDate) throws SQLException{
    	StringBuffer plateIntegralSentSql = new StringBuffer();
    	plateIntegralSentSql.append(BasePlateIntegralSend.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralSend.CS_SEND_DATE).append(" < '").append(endDate).append("'").append(" order by "+BasePlateIntegralSend.CS_SEND_INTEGRAL+" desc");
    	PlateIntegralSend dao = new PlateIntegralSend();
    	List<BasePlateIntegralSend> result = dao.conditionalLoad(plateIntegralSentSql.toString());
    	BaseCollection<BasePlateIntegralSend> bc = new BaseCollection<>();
    	bc.setCollections(result);
    	return bc.toJSON(0, "");
    }
    
    /**
     * 获取公司费用数据集
     * @return
     * @throws SQLException 
     */
    public String onLoadCompanyFee(Date startDate,Date endDate) throws SQLException{
    	StringBuffer sql = new StringBuffer();
    	sql.append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" >= '").append(startDate).append("'").append("and ").append(BasePlateIntegralAchieve.CS_SEND_DATE).append(" < '").append(endDate).append("'").append(" order by "+BasePlateIntegralAchieve.CS_SEND_DATE+" desc");
    	PlateIntegralAchieve dao = new PlateIntegralAchieve();
    	dao.setConditionToPlateId("=", 0);
    	List<BasePlateIntegralAchieve> result = dao.conditionalLoad(sql.toString());
    	BaseCollection<BasePlateIntegralAchieve> bc = new BaseCollection<>();
    	bc.setCollections(result);
    	return bc.toJSON(0, "");
    }
    
    /**
     * 加载公司借款和还款
     * @param startDate
     * @param endDate
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadCompanyAdvanceOfRefund(Date startDate,Date endDate,Map<String, Object> param) throws SQLException{
    	int flag = BaseHelpUtils.getIntValue(param,"flag");
    	CompanyIntegralRecord dao = new CompanyIntegralRecord();
    	dao.setConditionFlag("=",flag);
    	dao.addCondition(BaseCompanyIntegralRecord.CS_RECORD_DATE,"between",startDate,endDate);
    	List<BaseCompanyIntegralRecord> result = dao.conditionalLoad(" order by "+BaseCompanyIntegralRecord.CS_RECORD_DATE+" desc");
    	BaseCollection<BaseCompanyIntegralRecord> bc = new BaseCollection<>();
    	bc.setCollections(result);
    	return bc.toJSON(0, "");
    }

}
