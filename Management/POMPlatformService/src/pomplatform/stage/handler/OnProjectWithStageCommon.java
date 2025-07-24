package pomplatform.stage.handler;

/*import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseApproveProjectStageStorage;
import com.pomplatform.db.bean.BaseCarTypePrice;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseProjectStageStorage;
import com.pomplatform.db.bean.BaseProjectTemplate;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.BaseUseCarPrice;
import com.pomplatform.db.dao.ApproveProjectStageStorage;
import com.pomplatform.db.dao.CarTypePrice;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.ProjectStageStorage;
import com.pomplatform.db.dao.ProjectStageTemplate;
import com.pomplatform.db.dao.ProjectTemplate;
import com.pomplatform.db.dao.SystemDictionary;
import com.pomplatform.db.dao.UseCarPrice;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.dao.SystemProcessInstance;
import pomplatform.project.bean.BaseOnLoadProjectStageSettlement;
import pomplatform.project.bean.ConditionOnLoadProjectStageSettlement;
import pomplatform.project.query.QueryOnLoadProjectStageSettlement;
import pomplatform.stage.bean.BaseProjectStageStorageWithP;
import pomplatform.stage.bean.BaseProjectStageTemplateWithP;
import pomplatform.stage.bean.BaseProjectWithP;
import pomplatform.stage.dao.ProjectStageStorageWithP;
import pomplatform.stage.dao.ProjectStageTemplateWithP;
import pomplatform.stage.dao.ProjectWithP;*/
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCarTypePrice;
import com.pomplatform.db.bean.BaseCompanyArea;
import com.pomplatform.db.bean.BaseCompanyRecord;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseEmployeeDayCheck;
import com.pomplatform.db.bean.BaseProjectTemplate;
import com.pomplatform.db.bean.BaseSalaryOfWorkYear;
import com.pomplatform.db.dao.CarTypePrice;
import com.pomplatform.db.dao.CompanyArea;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.EmployeeDayCheck;
import com.pomplatform.db.dao.EmployeeMonthCheck;
import com.pomplatform.db.dao.ProjectStageTemplate;
import com.pomplatform.db.dao.ProjectTemplate;
import com.pomplatform.db.dao.SalaryOfWorkYear;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.common.utils.AccountUtils;
import pomplatform.stage.bean.BaseProjectStageTemplateWithP;
import pomplatform.stage.dao.ProjectStageTemplateWithP;
/**
 *
 * @author cjh
 */
public class OnProjectWithStageCommon implements GenericProcessor {

    private static Logger __logger = Logger.getLogger("");
    //操作类型
    private static final String OPT_TYPE = "optType";
    //项目标示类型**************************************
    public static final int Project_flag_1 = 1;//设计项目
    public static final int Project_flag_2 = 2;//研发项目
    public static final int Project_flag_3 = 3;//管理项目
    //项目编号头部的名称
    public static final String develop_project_title = "RE";//研发项目
    public static final String manage_project_title = "GL";//管理项目
    
  //专业负责人项目--阶段策划    保存已有模板
    private static final String UPDATE_PRPJECT_WITH_STAGE = "UpdateProjectWithStage";
    //专业负责人项目--阶段策划    保存自定义模板提交审批流程
    private static final String SAVE_APPROVAL_PROCESS = "SaveApprovalProcess";
    private static final String NO_CHANGE_PROJECT_WITH_STAGE = "NoChangProjectWithStage";
    //项目阶段模板管理——新增模板（先增加project_template 后增加 project_stage_template）
    private static final String ADD_PROJECT_TEMPLATE_WITH_STAGE = "AddProjecTempletWithStage";
    //项目阶段模板管理——编辑模板
    private static final String UPDATE_PROJECT_TEMPLATE_WITH_STAGE = "UpdateProjecTempletWithStage";
    //项目阶段模板管理——删除模板
    private static final String DEL_PROJECT_TEMPLATE_WITH_STAGE = "DelProjecTempletWithStage";
    //判断该项目是否属于审批流程中，是:提示不允许修改并显示数据    否:显示数据
    private static final String BOOLEAN_GRID_DATE_SOURCE = "BooleanGridDateSource";
    //判断该项目是否为第一次策划
    private static final String BOOLEAN_FIRST_OR_NOT = "booleanFirstOrNot";
    //判断该项目是否属于审批流程中   是：不允许提交多次审批  
    private static final String BOOLEAN_APPROVAL_PROCESS = "BooleanApprovalProcess";
    //现有阶段模板编辑后 判断阶段是否存在问题
    private static final String CHECKPROJECTWITHSTAGE = "CheckProjectWithStage";
    //根据carType 和id 加载 use_car_price数据
    private static final String ON_GET_USE_CAR_PRICE = "onGetUseCarPrice";
    //
    private static final String LOAD_CONTRACTS = "loadContracts";
    //保存或更新公司和区域信息
    private static final String SAVE_OR_UPDATE_COMPANY = "saveorupdatecompany";
    
    //更新SalaryOfWorkYears 工龄工资
    private static final String UPDATE_SALARY_OF_WORK_YEARS = "updatesalaryofworkyears";
    
    //删除考勤汇总表数据
    private static final String DEL_EMPLOYEE_MONTH_CHECK = "delEmployeeMonthCheck";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        /*if(UPDATE_PRPJECT_WITH_STAGE.equals(optType)){
        	return UpdateProjectWithStage(param);
        }else if(SAVE_APPROVAL_PROCESS.equals(optType)) {
        	return SaveApprovalProcess(param);
        }else if(NO_CHANGE_PROJECT_WITH_STAGE.equals(optType)) {
        	return NoChangProjectWithStage(creteria);
        }else if(BOOLEAN_GRID_DATE_SOURCE.equals(optType)) {
        	return BooleanGridDateSource(param);
        }else  if(BOOLEAN_FIRST_OR_NOT.equals(optType)) {
        	return booleanFirstOrNot(param);
        }else if(BOOLEAN_APPROVAL_PROCESS.equals(optType)) {
        	return BooleanApprovalProcess(param);
        }else if(CHECKPROJECTWITHSTAGE.equals(optType)) {
        	return CheckProjectWithStage(param);
        }else*/
        if(ADD_PROJECT_TEMPLATE_WITH_STAGE.equals(optType)) {
        	return AddProjecTempletWithStage(param);
        }else if(UPDATE_PROJECT_TEMPLATE_WITH_STAGE.equals(optType)) {
        	return UpdateProjecTempletWithStage(param);
        }else if(DEL_PROJECT_TEMPLATE_WITH_STAGE.equals(optType)) {
        	return DelProjecTempletWithStage(param);
        }else if(ON_GET_USE_CAR_PRICE.equals(optType)) {
        	return onGetUseCarPrice(param);
        }else if(LOAD_CONTRACTS.equals(optType)) {
        	return loadContracts(param);
        }else if(SAVE_OR_UPDATE_COMPANY.equals(optType)) {
        	return saveorupdatecompany(param);
        }else if(UPDATE_SALARY_OF_WORK_YEARS.equals(optType)) {
        	return updatesalaryofworkyears(param);
        }else if(DEL_EMPLOYEE_MONTH_CHECK.equals(optType)) {
    	return delEmployeeMonthCheck(param);
    }
        return null;
    }
    
    
    public static void main(String[] args) throws Exception {
    	Map<String,Object> values = new HashMap<>();
    	values.put("year",2017);
    	values.put("month", 5);
    	values.put("employeeId", 4);
//    	values.put("workMoney", 200);
    	delEmployeeMonthCheck(values);
	}
    
    
    /**
     * 删除考勤汇总表数据
     * @param param
     * @return
     * @throws Exception 
     */
    private static  String delEmployeeMonthCheck(Map<String, Object> param) throws Exception {
    	
    	ThreadConnection.beginTransaction();
//    	int num=0;
    	
    	Integer employeeId = BaseHelpUtils.getIntValue(param.get("employeeId"));
    	Integer month = BaseHelpUtils.getIntValue(param.get("month"));
    	Integer year= BaseHelpUtils.getIntValue(param.get("year"));
		BaseEmployeeDayCheck bean = new BaseEmployeeDayCheck();
		EmployeeMonthCheck dao = new EmployeeMonthCheck();
		EmployeeDayCheck dao2 = new EmployeeDayCheck();
		dao.setConditionEmployeeId("=", employeeId);
		dao.setConditionMonth("=", month);
		dao.setConditionYear("=", year);
		
		dao2.setConditionEmployeeId("=", employeeId);
		dao2.setConditionMonth("=", month);
		dao2.setConditionYear("=", year);
		int num = dao.conditionalDelete();
		int i = dao2.conditionalDelete();
    	ThreadConnection.commit();
    	return bean.toOneLineJSON(num, null);
    }
   
    
    /**
     * 更新SalaryOfWorkYears 工龄工资
     * @param param
     * @return
     * @throws Exception 
     */
    private static  String updatesalaryofworkyears(Map<String, Object> param) throws Exception {
    	
    	ThreadConnection.beginTransaction();
		BaseSalaryOfWorkYear bean = new BaseSalaryOfWorkYear();
		SalaryOfWorkYear dao = new SalaryOfWorkYear();
		dao.setConditionEmployeeId("=", BaseHelpUtils.getIntValue(param.get("employeeId")));
		dao.setConditionMonth("=", BaseHelpUtils.getIntValue(param.get("month")));
		dao.setConditionYear("=", BaseHelpUtils.getIntValue(param.get("year")));
		List<BaseSalaryOfWorkYear> conditionalLoad = dao.conditionalLoad();
		int num=0;
		if(conditionalLoad.size()>0&&!BaseHelpUtils.isNullOrEmpty(conditionalLoad)) {
			BaseSalaryOfWorkYear baseSalaryOfWorkYear = conditionalLoad.get(0);
			if(!BaseHelpUtils.isNullOrEmpty(baseSalaryOfWorkYear))
			{
				baseSalaryOfWorkYear.setWorkMoney(BaseHelpUtils.getString(param.get("workMoney")));
				dao.setDataFromBase(baseSalaryOfWorkYear);
				num = dao.update(); 
			}else {
				num=-1;
			}
		}
    	ThreadConnection.commit();
    	return bean.toOneLineJSON(num, null);
    }
    
    /**
     * 
     * @param param
     * @return
     * @throws Exception 
     */
    private static String saveorupdatecompany(Map<String, Object> param) throws Exception {
    	
    	ThreadConnection.beginTransaction();
    	String saveorupdate = BaseHelpUtils.getStringValue(param, "saveorupdate");
    	CompanyRecord cDao =new CompanyRecord();
    	BaseCompanyRecord bc =new BaseCompanyRecord();
    	bc.setDataFromMap(param);
    	cDao.setDataFromBase(bc);
    	
		CompanyArea caDao =new CompanyArea();
		BaseCompanyArea ba =new BaseCompanyArea();
    	if(saveorupdate.equals("save")) {
    		bc.setDataFromMap(param);
        	cDao.setDataFromBase(bc);
    		cDao.save();
    		BaseCompanyRecord generateBase = cDao.generateBase();
    		param.put("companyId", generateBase.getCompanyRecordId());

    		ba.setDataFromMap(param);
    		caDao.setDataFromBase(ba);
    		caDao.save();
    		//创建公司账户
    		AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_COMPANY, cDao.getCompanyRecordId(), AccountUtils.ACCOUNT_LEVEL_1, cDao.getCompanyName(), null, true);
    	}else if(saveorupdate.equals("update")){
    		
    		int companyId = BaseHelpUtils.getIntValue(param, "companyId");
    		cDao.clear();
    		param.put("companyRecordId", companyId);
    		bc.setDataFromMap(param);
        	cDao.setDataFromBase(bc);
    		cDao.update();
    		ba.setDataFromMap(param);
    		caDao.clear();
    		caDao.setDataFromBase(ba);
    		caDao.update();
    	}else if(saveorupdate.equals("del")) {
    		int companyId = BaseHelpUtils.getIntValue(param, "companyId");
    		cDao.clear();
    		cDao.setConditionCompanyRecordId("=", companyId);
    		cDao.conditionalDelete();
    		int companyAreaId = BaseHelpUtils.getIntValue(param, "companyAreaId");
    		caDao.clear();
    		caDao.setConditionCompanyAreaId("=", companyAreaId);
    		caDao.conditionalDelete();
    		//销户：公司账户
    		AccountUtils.destoryAccount(AccountUtils.ACCOUNT_TYPE_COMPANY, companyId, null);
    	}
    	BaseCompanyArea generateBase2 = caDao.generateBase();
    	
    	ThreadConnection.commit();
    	return generateBase2.toOneLineJSON(0, null);
    	
    	
    }	
    /**
     * 
     * @param param
     * @return
     * @throws Exception 
     */
    private static String loadContracts(Map<String, Object> param) throws Exception {
    	Contract dao =new Contract();
    	BaseCollection<BaseContract> bc = new BaseCollection<>();
    	List<BaseContract> list = dao.conditionalLoad();    	
    	bc.setCollections(list);
    	return bc.toJSON(0, null);
    }	
    /**
     * 根据carType 和id 加载 use_car_price数据
     * @param param
     * @return
     * @throws Exception 
     */
    private static String onGetUseCarPrice(Map<String, Object> param) throws Exception {
    	CarTypePrice dao =new CarTypePrice();
    	BaseCollection<BaseCarTypePrice> bc = new BaseCollection<>();
    	if(!BaseHelpUtils.isNullOrEmpty(param.get("carType"))&&!BaseHelpUtils.isNullOrEmpty(param.get("useCarPriceId"))) {
    		dao.setConditionCarType("=",BaseHelpUtils.getIntValue(param.get("carType")));
    		dao.setConditionUseCarPriceId("=", BaseHelpUtils.getIntValue(param.get("useCarPriceId")));
    		List<BaseCarTypePrice> list = dao.conditionalLoad();    	
    		bc.setCollections(list);
    	}
    	return bc.toJSON(0, null);
    }	
    
    
    /**
    * 项目阶段模板管理——删除模板
    * @param param
    * @return
    * @throws Exception 
    */
   private static String DelProjecTempletWithStage(Map<String, Object> param) throws Exception {
   	
   	ThreadConnection.beginTransaction();
   	//先增加project_template
   	ProjectTemplate ptDao =new ProjectTemplate();
   	ptDao.setConditionProjectTemplateId("=", BaseHelpUtils.getIntValue(param.get("projectTemplateId")));
   	ptDao.conditionalDelete();
   	ProjectStageTemplate pstDao =new ProjectStageTemplate();
   	pstDao.setConditionProjectTemplateId("=",  BaseHelpUtils.getIntValue(param.get("projectTemplateId")));
   	ThreadConnection.commit();
   	
   	BaseCollection<BaseProjectTemplate> bc = new BaseCollection<>();
   	return bc.toJSON(0, null);
   	
   }
   
   /**
    * 项目阶段模板管理——新增模板（先增加project_template 后增加 project_stage_template）
    * @param param
    * @return
    * @throws Exception 
    */
   private static String AddProjecTempletWithStage(Map<String, Object> param) throws Exception {
   	ThreadConnection.beginTransaction();
   	//先增加project_template
   	ProjectTemplate ptDao =new ProjectTemplate();
   	BaseProjectTemplate bean =new BaseProjectTemplate();
   	bean.setBusinessType(BaseHelpUtils.getIntValue(param.get("businessType")));
   	bean.setPlateId(BaseHelpUtils.getIntValue(param.get("plateId")));
   	bean.setProjectType(BaseHelpUtils.getIntValue(param.get("projectType")));
   	bean.setProjectTemplateName(BaseHelpUtils.getString(param.get("projectTemplateName")));
   	ptDao.setDataFromBase(bean);
   	ptDao.save();
   	
   	//后增加 project_stage_template
   	BaseProjectTemplate generateBase = ptDao.generateBase();
   	int projectTemplateId = generateBase.getProjectTemplateId();
   	System.out.println(projectTemplateId);
   	BaseProjectStageTemplateWithP p =new BaseProjectStageTemplateWithP();
   	ProjectStageTemplateWithP d =new ProjectStageTemplateWithP();
   	Map<String, Object> param2 =new HashMap<>();
   	if(!BaseHelpUtils.isNullOrEmpty(param)) {
   		List<Map> lm = (List<Map>) param.get("detailProjectStage");
   		if(!BaseHelpUtils.isNullOrEmpty(lm)) {
   			for (Map map : lm) {
   				map.put("projectTemplateId", projectTemplateId);
   				map.put("projectTemplateName", BaseHelpUtils.getString(param.get("projectTemplateName")));
   			}
   			param2.put("detailProjectStage", lm);
   		}
   	}
   	p.setDataFromMap(param2);
   	d.setDataFromBase(p);
   	d.save();
   	
   	ThreadConnection.commit();
   	
   	BaseCollection<BaseProjectTemplate> bc = new BaseCollection<>();
   	return bc.toJSON(0, null);
   	
   }
   /**
    * 项目阶段模板管理——编辑模板
    * @param param
    * @return
    * @throws Exception 
    */
   private static String UpdateProjecTempletWithStage(Map<String, Object> param) throws Exception {
   	
   	ThreadConnection.beginTransaction();
   	//先更新project_template
   	ProjectTemplate ptDao =new ProjectTemplate();
   	BaseProjectTemplate bean =new BaseProjectTemplate();
   	bean.setBusinessType(BaseHelpUtils.getIntValue(param.get("businessType")));
   	bean.setPlateId(BaseHelpUtils.getIntValue(param.get("plateId")));
   	bean.setProjectType(BaseHelpUtils.getIntValue(param.get("projectType")));
   	bean.setProjectTemplateName(BaseHelpUtils.getString(param.get("projectTemplateName")));
   	bean.setProjectTemplateId(BaseHelpUtils.getIntValue(param.get("projectTemplateId")));
   	ptDao.setDataFromBase(bean);
   	ptDao.update();
   	
   	//删除旧的数据  再添加新数据 project_stage_template
   	BaseProjectTemplate generateBase = ptDao.generateBase();
   	int projectTemplateId = generateBase.getProjectTemplateId();
   	String projectTemplateName = generateBase.getProjectTemplateName();
   	
   	ProjectStageTemplate projectStageTemplate = new ProjectStageTemplate();
   	
   	projectStageTemplate.setConditionProjectTemplateId("=", projectTemplateId);
   	projectStageTemplate.conditionalDelete();
   	
   	BaseProjectStageTemplateWithP p =new BaseProjectStageTemplateWithP();
   	ProjectStageTemplateWithP d =new ProjectStageTemplateWithP();
   	Map<String, Object> param2 =new HashMap<>();
   	if(!BaseHelpUtils.isNullOrEmpty(param)) {
   		List<Map> lm = (List<Map>) param.get("detailProjectStage");
   		if(!BaseHelpUtils.isNullOrEmpty(lm)) {
   			for (Map map : lm) {
   				map.put("projectTemplateId", projectTemplateId);
   				map.put("projectTemplateName",projectTemplateName);
   				map.put("projectAmount",null);
   			}
   			param2.put("detailProjectStage", lm);
   		}
   	}
   	p.setDataFromMap(param2);
   	d.setDataFromBase(p);
   	d.save();
   	
   	ThreadConnection.commit();
   	
   	BaseCollection<BaseProjectTemplate> bc = new BaseCollection<>();
   	return bc.toJSON(0, null);
   	
   }
    
   /* *//**
     * 现有阶段模板编辑后 判断阶段是否存在问题
     * @param param
     * @return
     * @throws Exception 
     *//*
    private static String CheckProjectWithStage(Map<String, Object> params) throws Exception {
    	BaseProjectWithP bean = new BaseProjectWithP();
    	bean.setDataFromMap(params);
    	ProjectWithP dao = new ProjectWithP();
    	dao.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
    if (dao.load()) {
    	BigDecimal projectIntegral = null == dao.getProjectIntegral() ? BigDecimal.ZERO : dao.getProjectIntegral();
    	BigDecimal oneHundred = new BigDecimal(100);
    	 List<BaseProjectStage> newDetails = bean.getDetailProjectStage();
        if(null != newDetails){
        	SystemDictionary dictionary = new SystemDictionary();
        	dictionary.setConditionDicTypeId("=", 7);
        	List<BaseSystemDictionary> dictionaryList = dictionary.conditionalLoad();
        	//定义map来存放每个阶段的名称
        	Map<Integer,String> nameMap = new HashMap<>();
        	if(!BaseHelpUtils.isNullOrEmpty(dictionaryList) && dictionaryList.size() > 0){
        		for(BaseSystemDictionary e : dictionaryList){
        			nameMap.put(e.getDicTypeValueId(), e.getDicTypeValue());
        		}
        	}
        	//获取每个阶段的名称
        	Integer projectId = dao.getProjectId();
        	首先，把新的项目阶段记录循环一遍，看看有没有重复的阶段ID，或者有阶段没有选择设计阶段，有则返回错误
        	Map<Integer, Object> map = new HashMap<>();
        	for(BaseProjectStage stage : newDetails){
        		if(null != stage.getStageId()){
        			map.put(stage.getStageId(), null);
        		}
        	}
        	if(map.size()!=newDetails.size()){
        		return bean.toOneLineJSON(-1, "项目阶段有重复的设计阶段或有阶段没有选择设计阶段");
        	}
        	//如果项目积分<=0,则不可进行操作
        	if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
        		return bean.toOneLineJSON(-1, "操作异常:项目积分需大于0");
        	}
        	//获取新的阶段占比总和和阶段总积分
        	BigDecimal stagePercentTotal = BigDecimal.ZERO;
        	BigDecimal stageIntegralTotal = BigDecimal.ZERO;
        	for(BaseProjectStage e : newDetails){
        		//获取阶段占比和阶段积分
        		BigDecimal stagePercent = BaseHelpUtils.getBigDecimalValue(e.getPercent());
        		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectAmount());
        		stagePercentTotal = stagePercentTotal.add(stagePercent);
        		stageIntegralTotal = stageIntegralTotal.add(stageIntegral);
        	}
        	//判断新的阶段占比的总和是否等于100
        	if(stagePercentTotal.compareTo(oneHundred) != 0){
        		return bean.toOneLineJSON(-1, "操作异常:分配的阶段占比总和需等于100");
        	}
        	//判断新的阶段总积分是否等于项目积分
        	if(stageIntegralTotal.compareTo(projectIntegral) != 0){
        		return bean.toOneLineJSON(-1, "操作异常:分配的阶段总积分不等于项目积分("+projectIntegral+")");
        	}
        	//加载原有阶段的数据
        	ConditionOnLoadProjectStageSettlement condition = new ConditionOnLoadProjectStageSettlement();
        	condition.setProjectId(projectId);
        	QueryOnLoadProjectStageSettlement conDao = new QueryOnLoadProjectStageSettlement();
        	BaseCollection<BaseOnLoadProjectStageSettlement> conResult = conDao.executeQuery(null, condition);
        	//定义map来存放该项目已保存的每个阶段的数据集
        	Map<Integer,BaseOnLoadProjectStageSettlement> oldMap = new HashMap<>();
        	if(!BaseHelpUtils.isNullOrEmpty(conResult)){
        		for(BaseOnLoadProjectStageSettlement e : conResult.getCollections()){
        			oldMap.put(e.getStageId(),e);
        		}
        	}
        	//遍历新的阶段，并验证每个阶段的设置是否正确
        	for(BaseProjectStage e : newDetails){
        		int stageId = e.getStageId()==null?0:e.getStageId();
        		//获取阶段名称
        		String stageName = nameMap.get(stageId);
        		e.setStageName(stageName);
        		//获取新的阶段占比
        		int stagePercent = e.getPercent()==null?0:e.getPercent();
        		//获取旧阶段的数据集
        		BaseOnLoadProjectStageSettlement oldBean = oldMap.get(stageId);
        		if(!BaseHelpUtils.isNullOrEmpty(oldBean)){
        			//获取旧的阶段占比
        			int stagePercentOld = oldBean.getPercent()==null?0:oldBean.getPercent();
        			if(stagePercent != stagePercentOld){//如果不相等，则判断该阶段是否上传确认函
        				//获取确认函标示
        				int attachmentNum = oldBean.getAttachmentNum()==null?0:oldBean.getAttachmentNum();
        				if(attachmentNum > 0){//说明该阶段已上传确认函，不可进行修改
        					return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已上传确认函,不可进行阶段占比的调整");
        				}
        				//获取阶段已确认积分
        				BigDecimal stageSettlementIntegral = oldBean.getSettlementIntegral()==null?BigDecimal.ZERO:oldBean.getSettlementIntegral();
        				//如果阶段已确认积分，则新的阶段占比一定要大于旧的阶段占比
        				if(stageSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
        					if(stagePercent < stagePercentOld){
        						return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已确认积分,阶段占比不可下调");
        					}
        				}
        			}
        		}
        	}
        	
        }
    }
    		return null;
    }
    
    
    *//**
     * 判断该项目是否属于审批流程中   是：不允许提交多次审批
     * @param param
     * @return
     * @throws Exception 
     *//*
    private static String BooleanApprovalProcess(Map<String, Object> param) throws Exception {
    	
    	BaseCollection<BaseApproveProjectStageStorage> bc = new BaseCollection<>();
    	ApproveProjectStageStorage dao =new ApproveProjectStageStorage();
    	dao.setConditionProjectId("=", BaseHelpUtils.getIntValue(param.get("projectId")));
    	List<BaseApproveProjectStageStorage> conditionalLoad = dao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>0) {
    		bc.setCollections(conditionalLoad);
    	}
    	return bc.toJSON(0, null);
    	
    	
    	
    }
    *//**
     * 判断该项目是否为第一次策划
     * @param param
     * @return
     * @throws Exception 
     *//*
    private static String booleanFirstOrNot(Map<String, Object> param) throws Exception {
    	
    	ProjectStageStorage pssDao =new ProjectStageStorage();
    	pssDao.setConditionProjectId("=", BaseHelpUtils.getIntValue(param.get("projectId")));
    	List<BaseProjectStageStorage> conditionalLoad = pssDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>0) {
    		BaseCollection<BaseProjectStageStorage> bc = new BaseCollection<>();
    		bc.setCollections(conditionalLoad);
    		return bc.toJSON(0, null);
    	}else {
    		BaseCollection<BaseProjectSettlement> bc = new BaseCollection<>();
    		ProjectSettlement psDao =new ProjectSettlement();
    		psDao.setConditionProjectId("=", BaseHelpUtils.getIntValue(param.get("projectId")));
    		List<BaseProjectSettlement> conditionalLoad2 = psDao.conditionalLoad();
    		bc.setCollections(conditionalLoad2);
    		return bc.toJSON(0, null);
    	}
    	
    }
    *//**
     * 判断该项目是否属于审批流程中，是:提示不允许修改并显示数据    否:显示数据
     * @param param
     * @return
     * @throws Exception 
     *//*
    private static String BooleanGridDateSource(Map<String, Object> param) throws Exception {
    	ProjectStageStorage dao =new ProjectStageStorage();
    	dao.setConditionProjectId("=", BaseHelpUtils.getIntValue(param.get("projectId")));
    	List<BaseProjectStageStorage> conditionalLoad = dao.conditionalLoad();
    	BaseCollection<BaseProjectStageStorage> bc = new BaseCollection<>();
    	bc.setCollections(conditionalLoad);
		return bc.toJSON(0, null);
    }
    
    
    
    *//**
     * 
     * @param creteria
     * @param params 
     * @return
     * @throws Exception 
     *//*
    private static String UpdateProjectWithStage(Map<String, Object> params) throws Exception {
    	BaseProjectWithP bean = new BaseProjectWithP();
    	
        String remark = BaseHelpUtils.getStringValue(params, "remark");
        List<Map> lm = (List<Map>) params.get("detailProjectStage");
        if(!BaseHelpUtils.isNullOrEmpty(remark)) {
           	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
           		for (Map map : lm) {
           			map.put("remark", remark);
           		}
           	}
        }
    	
        int projectTemplateId = BaseHelpUtils.getIntValue(params, "projectTemplateId");
        if(!BaseHelpUtils.isNullOrEmpty(projectTemplateId)&&projectTemplateId>0) {
           	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
           		for (Map map : lm) {
           			map.put("projectTemplateId", projectTemplateId);
           		}
           	}
        }
    	
    	bean.setDataFromMap(params);
    	ProjectWithP dao = new ProjectWithP();
    	dao.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
    if (dao.load()) {
    	BigDecimal projectIntegral = null == dao.getProjectIntegral() ? BigDecimal.ZERO : dao.getProjectIntegral();
    	BigDecimal oneHundred = new BigDecimal(100);
    	 List<BaseProjectStage> newDetails = bean.getDetailProjectStage();
        if(null != newDetails){
        	SystemDictionary dictionary = new SystemDictionary();
        	dictionary.setConditionDicTypeId("=", 7);
        	List<BaseSystemDictionary> dictionaryList = dictionary.conditionalLoad();
        	//定义map来存放每个阶段的名称
        	Map<Integer,String> nameMap = new HashMap<>();
        	if(!BaseHelpUtils.isNullOrEmpty(dictionaryList) && dictionaryList.size() > 0){
        		for(BaseSystemDictionary e : dictionaryList){
        			nameMap.put(e.getDicTypeValueId(), e.getDicTypeValue());
        		}
        	}
        	//获取每个阶段的名称
        	Integer projectId = dao.getProjectId();
        	首先，把新的项目阶段记录循环一遍，看看有没有重复的阶段ID，或者有阶段没有选择设计阶段，有则返回错误
        	Map<Integer, Object> map = new HashMap<>();
        	for(BaseProjectStage stage : newDetails){
        		if(null != stage.getStageId()){
        			map.put(stage.getStageId(), null);
        		}
        	}
        	if(map.size()!=newDetails.size()){
        		return bean.toOneLineJSON(-1, "项目阶段有重复的设计阶段或有阶段没有选择设计阶段");
        	}
        	//如果项目积分<=0,则不可进行操作
        	if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
        		return bean.toOneLineJSON(-1, "操作异常:项目积分需大于0");
        	}
        	//获取新的阶段占比总和和阶段总积分
        	BigDecimal stagePercentTotal = BigDecimal.ZERO;
        	BigDecimal stageIntegralTotal = BigDecimal.ZERO;
        	for(BaseProjectStage e : newDetails){
        		//获取阶段占比和阶段积分
        		BigDecimal stagePercent = BaseHelpUtils.getBigDecimalValue(e.getPercent());
        		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectAmount());
        		stagePercentTotal = stagePercentTotal.add(stagePercent);
        		stageIntegralTotal = stageIntegralTotal.add(stageIntegral);
        	}
        	//判断新的阶段占比的总和是否等于100
        	if(stagePercentTotal.compareTo(oneHundred) != 0){
        		return bean.toOneLineJSON(-1, "操作异常:分配的阶段占比总和需等于100");
        	}
        	//判断新的阶段总积分是否等于项目积分
        	if(stageIntegralTotal.compareTo(projectIntegral) != 0){
        		return bean.toOneLineJSON(-1, "操作异常:分配的阶段总积分不等于项目积分("+projectIntegral+")");
        	}
        	//加载原有阶段的数据
        	ConditionOnLoadProjectStageSettlement condition = new ConditionOnLoadProjectStageSettlement();
        	condition.setProjectId(projectId);
        	QueryOnLoadProjectStageSettlement conDao = new QueryOnLoadProjectStageSettlement();
        	BaseCollection<BaseOnLoadProjectStageSettlement> conResult = conDao.executeQuery(null, condition);
        	//定义map来存放该项目已保存的每个阶段的数据集
        	Map<Integer,BaseOnLoadProjectStageSettlement> oldMap = new HashMap<>();
        	if(!BaseHelpUtils.isNullOrEmpty(conResult)){
        		for(BaseOnLoadProjectStageSettlement e : conResult.getCollections()){
        			oldMap.put(e.getStageId(),e);
        		}
        	}
        	//遍历新的阶段，并验证每个阶段的设置是否正确
        	for(BaseProjectStage e : newDetails){
        		int stageId = e.getStageId()==null?0:e.getStageId();
        		//获取阶段名称
        		String stageName = nameMap.get(stageId);
        		e.setStageName(stageName);
        		//获取新的阶段占比
        		int stagePercent = e.getPercent()==null?0:e.getPercent();
        		//获取旧阶段的数据集
        		BaseOnLoadProjectStageSettlement oldBean = oldMap.get(stageId);
        		if(!BaseHelpUtils.isNullOrEmpty(oldBean)){
        			//获取旧的阶段占比
        			int stagePercentOld = oldBean.getPercent()==null?0:oldBean.getPercent();
        			if(stagePercent != stagePercentOld){//如果不相等，则判断该阶段是否上传确认函
        				//获取确认函标示
        				int attachmentNum = oldBean.getAttachmentNum()==null?0:oldBean.getAttachmentNum();
        				if(attachmentNum > 0){//说明该阶段已上传确认函，不可进行修改
        					return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已上传确认函,不可进行阶段占比的调整");
        				}
        				//获取阶段已确认积分
        				BigDecimal stageSettlementIntegral = oldBean.getSettlementIntegral()==null?BigDecimal.ZERO:oldBean.getSettlementIntegral();
        				//如果阶段已确认积分，则新的阶段占比一定要大于旧的阶段占比
        				if(stageSettlementIntegral.compareTo(BigDecimal.ZERO) > 0){
        					if(stagePercent < stagePercentOld){
        						return bean.toOneLineJSON(-1, "操作异常:阶段("+stageName+")已确认积分,阶段占比不可下调");
        					}
        				}
        			}
        		}
        	}
        	
        }
        

        
        dao.setDataFromBase(bean);
        dao.update();
    }
    return dao.generateBaseExt().toOneLineJSON(0, null);
}
      	
    *//**
     * 
     * @param creteria
     * @return
     * @throws Exception 
     *//*
    private static String SaveApprovalProcess(Map<String, Object> param) throws Exception {
    	
    	
    	//对项目阶段校验
        BaseProjectWithP bean = new BaseProjectWithP();
        bean.setDataFromMap(param);;
        ProjectWithP dao = new ProjectWithP();
        dao.setProjectId(bean.getProjectId());
        if (dao.load()) {
        	BigDecimal projectIntegral = null == dao.getProjectIntegral() ? BigDecimal.ZERO : dao.getProjectIntegral();
        	BigDecimal oneHundred = new BigDecimal(100);
            List<BaseProjectStage> newDetails = bean.getDetailProjectStage();
            if(null != newDetails){
    	SystemDictionary dictionary = new SystemDictionary();
    	dictionary.setConditionDicTypeId("=", 7);
    	List<BaseSystemDictionary> dictionaryList = dictionary.conditionalLoad();
    	//定义map来存放每个阶段的名称
    	Map<Integer,String> nameMap = new HashMap<>();
    	if(!BaseHelpUtils.isNullOrEmpty(dictionaryList) && dictionaryList.size() > 0){
    		for(BaseSystemDictionary e : dictionaryList){
    			nameMap.put(e.getDicTypeValueId(), e.getDicTypeValue());
    		}
    	}
    	//获取每个阶段的名称
    	Integer projectId = dao.getProjectId();
    	//首先，把新的项目阶段记录循环一遍，看看有没有重复的阶段ID，或者有阶段没有选择设计阶段，有则返回错误
    	Map<Integer, Object> map = new HashMap<>();
    	for(BaseProjectStage stage : newDetails){
    		if(null != stage.getStageId()){
    			map.put(stage.getStageId(), null);
    		}
    	}
    	if(map.size()!=newDetails.size()){
    		return bean.toOneLineJSON(-1, "项目阶段有重复的设计阶段或有阶段没有选择设计阶段");
    	}
    	//如果项目积分<=0,则不可进行操作
    	if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){
    		return bean.toOneLineJSON(-1, "操作异常:项目积分需大于0");
    	}
    	//获取新的阶段占比总和和阶段总积分
    	BigDecimal stagePercentTotal = BigDecimal.ZERO;
    	BigDecimal stageIntegralTotal = BigDecimal.ZERO;
    	for(BaseProjectStage e : newDetails){
    		//获取阶段占比和阶段积分
    		BigDecimal stagePercent = BaseHelpUtils.getBigDecimalValue(e.getPercent());
    		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(e.getProjectAmount());
    		stagePercentTotal = stagePercentTotal.add(stagePercent);
    		stageIntegralTotal = stageIntegralTotal.add(stageIntegral);
    	}
    	//判断新的阶段占比的总和是否等于100
    	if(stagePercentTotal.compareTo(oneHundred) != 0){
    		return bean.toOneLineJSON(-1, "操作异常:分配的阶段占比总和需等于100");
    	}
    	//判断新的阶段总积分是否等于项目积分
    	if(stageIntegralTotal.compareTo(projectIntegral) != 0){
    		return bean.toOneLineJSON(-1, "操作异常:分配的阶段总积分不等于项目积分("+projectIntegral+")");
    	}
        }
        }
        
        
        ThreadConnection.beginTransaction();
        
        ProjectStageStorageWithP projectStageStoragedao =new ProjectStageStorageWithP();
        BaseProjectStageStorageWithP p = new BaseProjectStageStorageWithP();
        String remark = BaseHelpUtils.getStringValue(param, "remark");
        
        if(!BaseHelpUtils.isNullOrEmpty(remark)) {
        	List<Map> lm = (List<Map>) param.get("detailProjectStage");
        	if(!BaseHelpUtils.isNullOrEmpty(lm)) {
        		for (Map map : lm) {
        			map.put("remark", remark);
        		}
        	}
//        	p.setRemark(remark);
        }
        p.setDataFromMap(param);
        projectStageStoragedao.setDataFromBase(p);
    	projectStageStoragedao.update();
    	
    	
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    	
    }
    
    
    *//**
     * 
     * @param creteria
     * @return
     * @throws Exception 
     *//*
    private static String NoChangProjectWithStage(String creteria) throws Exception {
    	BaseProjectWithP bean = new BaseProjectWithP();
    	return bean.toOneLineJSON(-1, "操作异常:请选择正确模板");
    }
    */


}
