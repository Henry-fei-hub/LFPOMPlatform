package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BaseOutDesignConsideration;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectAttachment;
import com.pomplatform.db.bean.BaseProjectCodeRecord;
import com.pomplatform.db.bean.BaseProjectContractChange;
import com.pomplatform.db.bean.BaseProjectContractEmployee;
import com.pomplatform.db.bean.BaseProjectCost;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectEmployeeAuditRecord;
import com.pomplatform.db.bean.BaseProjectManagePerformanceRecord;
import com.pomplatform.db.bean.BaseProjectPerformanceSettlementDetail;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseRevenueStatisticalRecord;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.bean.BaseSystemDictionary;
import com.pomplatform.db.bean.BaseTargetRecord;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.NormalReimbursementLinkProject;
import com.pomplatform.db.dao.OutDesignConsideration;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.ProjectCodeRecord;
import com.pomplatform.db.dao.ProjectContractChange;
import com.pomplatform.db.dao.ProjectContractEmployee;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectEmployeeAuditRecord;
import com.pomplatform.db.dao.ProjectManagePerformanceRecord;
import com.pomplatform.db.dao.ProjectManagePerformanceTotal;
import com.pomplatform.db.dao.ProjectPerformance;
import com.pomplatform.db.dao.ProjectPerformanceSettlement;
import com.pomplatform.db.dao.ProjectPerformanceSettlementDetail;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.RevenueStatisticalRecord;
import com.pomplatform.db.dao.RevenueYearStatisticalRecord;
import com.pomplatform.db.dao.SubContract;
import com.pomplatform.db.dao.SystemDictionary;
import com.pomplatform.db.dao.TargetRecord;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import delicacy.system.executor.SelectValueCache;
import message.common.ERPWeixinUtils;
import pomplatform.account.business.AccountManageProcess;
import pomplatform.common.utils.AccountUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.business.MarketingCommission;
import pomplatform.contract.handler.CustomMainContractHandler;
import pomplatform.mainProjectInfo.bean.BaseMsystemprocessinstanceppcmor;
import pomplatform.mainProjectInfo.bean.ConditionMsystemprocessinstanceppcmor;
import pomplatform.mainProjectInfo.query.QueryMsystemprocessinstanceppcmor;
import pomplatform.project.bean.BaseOnLoadProjectChangeEmployee;
import pomplatform.project.bean.BaseOnLoadProjectEmployeePerformance;
import pomplatform.project.bean.BaseOnLoadStandardQuoteData;
import pomplatform.project.bean.ConditionOnLoadStandardQuoteData;
import pomplatform.project.query.QueryOnLoadStandardQuoteData;
import pomplatform.projectEmployee.bean.BaseSprojectemployeepdsor;
import pomplatform.projectEmployee.bean.ConditionSprojectemployeepdsor;
import pomplatform.projectEmployee.query.QuerySprojectemployeepdsor;
import pomplatform.projectStageTemplate.bean.BaseSprojectstagetemplatepor;
import pomplatform.projectStageTemplate.bean.ConditionSprojectstagetemplatepor;
import pomplatform.projectStageTemplate.query.QuerySprojectstagetemplatepor;
import pomplatform.projectTemplate.bean.BaseSprojecttemplateor;
import pomplatform.projectTemplate.bean.ConditionSprojecttemplateor;
import pomplatform.projectTemplate.query.QuerySprojecttemplateor;
import pomplatform.revenueStatistical.bean.BaseRevenueStatisticalOfRevenue;
import pomplatform.revenueStatistical.business.OnRevenueStatisticalProcess;
import pomplatform.workflow.contractstatus.utils.ContractStatusUtils;

/**
 * 项目(订单)公用的process
 * @author lxf
 */
public class OnProjectCommonProcess implements GenericProcessor {
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
    //价格审核列表数据撤回
    private static final String ON_SHEET_BACKOUT = "onSheetBackout";
    //更新订单金额并更新该订单整个营收的信息
    private static final String ON_UPDATE_SHEET_REVENUE = "onUpdateSheetRevenue";
    //研发项目修改
    private static final String ON_DEVELOP_PROJECT_UPDATE= "onDevelopProjectUpdate";
    //研发项目立项
    private static final String ON_DEVELOP_PROJECT_SAVE= "onDevelopProjectSave";
    //加载研发项目的项目编号
    private static final String ON_LOAD_PROJECT_CODE= "onLoadProjectCode";
    //保存或者更新研发项目的项目编码
    private static final String ON_SAVE_OR_UPDATE_PROJECT_CODE= "onSaveOrUpdateProjectCode";
    //订单拆分
    private static final String ON_SHEET_BREAK= "onSheetBreak";
    //项目合同变更积分不够减分摊保存
    private static final String ON_PROJECT_CONTRACT_SAVE= "onProjectContractSave";
    //设计师同意或驳回项目经理分配负分給他的操作
    private static final String ON_DESIGNER_AGREE_OR_BACK= "onDesignerAgreeOrBack";
    //项目绩效积分确认
    private static final String ON_SAVE_PROJECT_PERFORMANCE= "onSaveProjectPerformance";
    //获取订单编号
    private static final String ON_GET_PROJECT_CODE= "onGetProjectCode";
    //投标订单保存
    private static final String ON_BID_SHEET_PROJECT_SAVE= "onBidSheetProjectSave";
    //落标订单保存
    private static final String ON_BID_PAY_SHEET_PROJECT_SAVE= "onBidPaySheetProjectSave";
    //营收统计加锁
    private static final String ON_REVENUE_STATISTICAL_LOCK= "onRevenueStatisticalLock";
    //加载标准报价单数据集
    private static final String ON_LOAD_STANDARD_QUOTE= "onLoadStandardQuoteData";
    //保存项目阶段成员数据集
    private static final String ON_SAVE_PROJECT_STAGE_EMP= "onSaveProjectStageEmp";
    //删除项目阶段成员数据集
    private static final String ON_DELETE_PROJECT_STAGE_EMP= "onDeleteProjectStageEmp";
    //把草稿保存的成员改为已保存状态
    private static final String CHANGE_PROJECT_EMPLOYEE_FLAG = "changeProjectEmployeeFlag";
    //把草稿保存的成员删除
    private static final String DELETE_PROJECT_EMPLOYEE_FLAG = "deleteProjectEmployeeFlag";
    //保存或更新项目阶段成员预分配积分(第二版)
    private static final String ON_SAVE_OR_UPDATE_STAGE_EMP = "onSaveOrUpdateStageEmp";
    //项目管理绩效积分回退
    private static final String ON_PROJECT_PERFORMANCE_BACK = "onProjectPerformanceBack";
    //获取业务部门下的新订单编号、事业部负责人和部门经理
    private static final String ON_GET_TRUN_PLATE_INFO = "onGetTrunPlateInfo";
    //订单转单，更新订单编号，业务部门，事业部负责人和部门经理
    private static final String ON_TRUN_UPDATE_PROJECT_INFO = "onTrunUpdateProjectInfo";
    //专业负责人项目-阶段策划-更新阶段名称，阶段占比(%)，阶段积分
    private static final String ON_GET_STAGE_OF_PLANNING = "onGetStageOfPlanning";
    //加载项目阶段模板
    private static final String ON_RELOAD_PROJECT_TEMPLATE = "onReloadProjectTemplate";
    //更新project_attachment不合格
    private static final String UPDATE_NONCONFORMITY_ATTACHMENT = "updateNonconformityAttachment";
    private static final String CHECK_NONCONFORMITY_ATTACHMENT = "checkNonconformityAttachment";
    //根据plateID 往下查询相关的部门platemanagerId 和departmentmanageid
    private static final String FIND_PLATE_AND_DEPARTMENT = "findPlateAndDepartmentManagerId";
    
    //保存或更新 订单项目下 contract_code 和业务部门以及业务部门下的部门经理，事业部负责人
    //SELECT contract_code,plate_id,revenue_plate_id,plate_manager_id,department_manager_id,sub_contract_id FROM projects
    //SELECT sub_contract_code,department_id,* FROM sub_contracts 
    private static final String ON_SAVE_OR_UPDATE_PLATE_AND_DEPARTMENT = "onSaveOrUpdatePlateAndDepartmentManagerId";
    //onSaveOrUpdateTargeRecord
    private static final String ON_SAVE_OR_UPDATE_TARGET_RECORD = "onSaveOrUpdateTargetRecord";
    //项目中标
    private static final String WIN_BID = "winBid";
    //校验project_employees 是否处于待审批状态
    private static final String ON_SAVE_OR_UPDATE_STAGE_CHECK= "onSaveOrUpdateStageCheck";    
    //更新project_employees的状态
    private static final String ON_SAVE_OR_UPDATE_STAGE_STATUS= "onSaveOrUpdateStageStatus";
    //校验订单是否有落标流程
    private static final String CHECK_CONTRACT_PROCESS_TYPE_73= "checkContractProcessType73";
    //校验订单成员有那些是有结算积分的 ，团队组建的时候不可以删除
    private static final String CHECK_PROJECT_SETTLEMENT= "checkProjectSettlement";
    //批量替换项目秘书
    private static final String CHANGE_MAIN_PROJECT_EMPLOYEE_REALTION_1= "changeMainProjectEmployeeRelation1";
    
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
        //获取操作类型
        String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
        if(ON_SHEET_BACKOUT.equals(optType)){
        	return onSheetBackout(param);
        }else if(ON_UPDATE_SHEET_REVENUE.equals(optType)){
        	return onUpdateSheetRevenue(param);
        }else if(ON_DEVELOP_PROJECT_UPDATE.equals(optType)){
        	return onDevelopProjectUpdate(creteria);
        }else if(ON_DEVELOP_PROJECT_SAVE.equals(optType)){
        	return onDevelopProjectSave(creteria);
        }else if(ON_LOAD_PROJECT_CODE.equals(optType)){
        	return onLoadProjectCode(param);
        }else if(ON_SAVE_OR_UPDATE_PROJECT_CODE.equals(optType)){
        	return onSaveOrUpdateProjectCode(creteria);
        }else if(ON_SHEET_BREAK.equals(optType)){
        	return onSheetBreak(param);
        }else if(ON_PROJECT_CONTRACT_SAVE.equals(optType)){
        	return onProjectContractSave(param);
        }else if(ON_DESIGNER_AGREE_OR_BACK.equals(optType)){
        	return onDesignerAgreeOrBack(param);
        }else if(ON_SAVE_PROJECT_PERFORMANCE.equals(optType)){
        	return onSaveProjectPerformance(param);
        }else if(ON_GET_PROJECT_CODE.equals(optType)){
        	return onGetProjectCode(param);
        }else if(ON_BID_SHEET_PROJECT_SAVE.equals(optType)){
        	return onBidSheetProjectSave(param);
        }else if(ON_BID_PAY_SHEET_PROJECT_SAVE.equals(optType)){
        	return onBidPaySheetProjectSave(param);
        }else if(ON_REVENUE_STATISTICAL_LOCK.equals(optType)){
        	return onRevenueStatisticalLock(param);
        }else if(ON_LOAD_STANDARD_QUOTE.equals(optType)){
        	return onLoadStandardQuoteData(param);
        }else if(ON_SAVE_PROJECT_STAGE_EMP.equals(optType)){
        	return onSaveProjectStageEmp(param);
        }else if(ON_DELETE_PROJECT_STAGE_EMP.equals(optType)){
        	return onDeleteProjectStageEmp(param);
        }else if(CHANGE_PROJECT_EMPLOYEE_FLAG.equals(optType)){
        	return changeProjectEmployeeFlag(param);
        }else if(DELETE_PROJECT_EMPLOYEE_FLAG.equals(optType)){
        	return deleteProjectEmployeeFlag(param);
        }else if(ON_SAVE_OR_UPDATE_STAGE_EMP.equals(optType)){
        	return onSaveOrUpdateStageEmp(param);
        }else if(ON_PROJECT_PERFORMANCE_BACK.equals(optType)){
        	return onProjectPerformanceBack(param);
        }else if(ON_GET_TRUN_PLATE_INFO.equals(optType)){
        	return onGetTrunPlateInfo(param);
        }else if(ON_TRUN_UPDATE_PROJECT_INFO.equals(optType)){
        	return onTrunUpdateProjectInfo(param);
        }else if(ON_GET_STAGE_OF_PLANNING.equals(optType)) {
        	return onGetStageOfPlanning(param);
        }else if(ON_RELOAD_PROJECT_TEMPLATE.equals(optType)) {
        	return onReloadProjectTemplate(param);
        }else if(UPDATE_NONCONFORMITY_ATTACHMENT.equals(optType)) {
        	return updateNonconformityAttachment(param);
        }else if(CHECK_NONCONFORMITY_ATTACHMENT.equals(optType)) {
        	return checkNonconformityAttachment(param);
        }else if(FIND_PLATE_AND_DEPARTMENT.equals(optType)) {
        	return findPlateAndDepartmentManagerId(param);
        }else if(ON_SAVE_OR_UPDATE_PLATE_AND_DEPARTMENT.equals(optType)) {
        	return onSaveOrUpdatePlateAndDepartmentManagerId(param);
        }else if(ON_SAVE_OR_UPDATE_TARGET_RECORD.equals(optType)) {
        	return onSaveOrUpdateTargetRecord(param);
        }else if(WIN_BID.equals(optType)) {
        	return winBid(param);
        }else if(ON_SAVE_OR_UPDATE_STAGE_CHECK.equals(optType)) {
        	return onSaveOrUpdateStageCheck(param);
        }else if(ON_SAVE_OR_UPDATE_STAGE_STATUS.equals(optType)) {
        	return onSaveOrUpdateStageStatus(param);
        }else if(CHECK_CONTRACT_PROCESS_TYPE_73.equals(optType)) {
        	return checkContractProcessType73(param);
        }else if(CHECK_PROJECT_SETTLEMENT.equals(optType)) {
        	return checkProjectSettlement(param);
        }else if(CHANGE_MAIN_PROJECT_EMPLOYEE_REALTION_1.equals(optType)) {
        	return changeMainProjectEmployeeRelation1(param);
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
    
	}
    
    
    
    /** 
     * @param creteria
     * @return
     * @throws Exception 
     */
    public static String changeMainProjectEmployeeRelation1(Map<String, Object> param) throws Exception{
    	BaseCollection<BaseProjectEmployee> bc = new BaseCollection<>();
    	ThreadConnection.beginTransaction();
    	int status = -1;
    	String msg ="";
    	MainProjectEmployee dao =new MainProjectEmployee();
    	
    	int source = BaseHelpUtils.getIntValue(param.get("source"));
    	int target = BaseHelpUtils.getIntValue(param.get("target"));
		List<BaseMainProjectEmployee> detailProjectStageList = GenericBase.__getList(param.get("detailMainProjectEmployee"),BaseMainProjectEmployee.newInstance());
		if(source<=0) {
			msg="目标项目人员不能为空";
		}else if(target<=0) {
			msg="替换项目人员不能为空";
		}else if(detailProjectStageList.size()<=0) {
			msg="合同列表不能为空";
		}else {
			status = 1;
			for (BaseMainProjectEmployee baseMainProjectEmployee : detailProjectStageList) {
				dao.clear();
				dao.setConditionMainProjectEmployeeId("=",baseMainProjectEmployee.getMainProjectEmployeeId());
				dao.setEmployeeId(target);
				dao.conditionalUpdate();
			}
		}
    	
    	ThreadConnection.commit();
    	return bc.toJSON(status,msg);
    }
    
    
    
    
    /** 校验订单成员有那些是有结算积分的 ，团队组建的时候不可以删除
     * @param creteria
     * @return
     * @throws Exception 
     */
    public static String checkProjectSettlement(Map<String, Object> param) throws Exception{
    	BaseCollection<BaseProjectEmployee> bc = new BaseCollection<>();
    	ThreadConnection.beginTransaction();
    	ProjectSettlementDetail psd =new ProjectSettlementDetail();
    	int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
    	if(projectId>0) {
    		List<BaseProjectEmployee> out =new  ArrayList<>();
    		ProjectEmployee pe =new ProjectEmployee();
    		pe.setConditionStatus("=", 2);
    		pe.setConditionProjectId("=", projectId);
    		List<BaseProjectEmployee> list = pe.conditionalLoad("business_id ISNULL ");
    		
    		if(list.size()>0) {
    			out.addAll(list);
    		}
    		
    		psd.setConditionProjectId("=", projectId);
    		psd.setConditionSettlementStatus("=", 2);//结算成功的
    		List<BaseProjectSettlementDetail> conditionalLoad = psd.conditionalLoad();
    		if(conditionalLoad.size()>0&&!BaseHelpUtils.isNullOrEmpty(conditionalLoad)) {
    			for (BaseProjectSettlementDetail baseProjectSettlementDetail : conditionalLoad) {
    				Integer employeeId = baseProjectSettlementDetail.getEmployeeId();
    				BaseProjectEmployee base =new BaseProjectEmployee();
    				base.setEmployeeId(employeeId);
					out.add(base);
				}
    		}
    		bc.setCollections(out);
    	}
    	
    	ThreadConnection.commit();
    	return bc.toJSON(0,"");
    }
    
    
    /** 校验订单是否有落标流程
     * @param creteria
     * @return
     * @throws Exception 
     */
    public static String checkContractProcessType73(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	QueryMsystemprocessinstanceppcmor query =new QueryMsystemprocessinstanceppcmor();
    	ConditionMsystemprocessinstanceppcmor condition =new ConditionMsystemprocessinstanceppcmor();
    	BaseCollection<BaseMsystemprocessinstanceppcmor> executeQuery = query.executeQuery(null, condition);
    	String str ="";
    	if(!BaseHelpUtils.isNullOrEmpty(executeQuery)&&executeQuery.getCollections().size()>0) {
    		int processStatus = executeQuery.getCollections().get(0).getProcessStatus();
    		if(processStatus==3) {
    			str="该订单已有落标流程";
    		}else if(processStatus==5) {
    			
    		}else {
    			str="该订单落标流程正在进行";
    		}
    	}
    	ThreadConnection.commit();
    	return executeQuery.toJSON(0,str);
    }
    
    
    /**
     * @param creteria
     * @return
     * @throws Exception 
     */
    public static String onSaveOrUpdateStageStatus(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	//获取项目Id
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	if(projectId == 0){
    		throw new SQLException("操作异常:项目不可为空");
    	}
    	//获取职员Id
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	if(employeeId == 0){
    		throw new SQLException("操作异常:成员不可为空");
    	}
    	
    	//获取stageId
    	int stageId = BaseHelpUtils.getIntValue(param, "stageId");
    	
    	//状态值  1 待确定  2同意  3不同意
    	int alternateField2 = BaseHelpUtils.getIntValue(param, "status");
    	
    	ProjectEmployeeAuditRecord pear =new ProjectEmployeeAuditRecord();
    	ProjectEmployee dao = new ProjectEmployee();
    	
    	//更新子表状态
    	pear.clear();
    	pear.setConditionEmployeeId("=", employeeId);
    	pear.setConditionProjectId("=", projectId);
    	pear.setConditionStageId("=",stageId);
    	pear.setStatus(alternateField2);
    	pear.conditionalUpdate();
    	
     	StringBuffer msg =new StringBuffer();
    	String projectName = SelectValueCache.getSelectValue("projects", String.valueOf(projectId));
    	msg.append("("+projectName+")预分配积分进度情况：");
    	if(alternateField2==3) {//表示该员工不同意，则直接更新ProjectEmployee的状态为不同意
    		dao.clear();
			dao.setConditionProjectId("=", projectId);
			dao.setConditionEmployeeId("=", employeeId);
			dao.setConditionStageId("=",stageId);
			dao.setAlternateField2(alternateField2+"");
			dao.conditionalUpdate();
			
        	String employeeName = SelectValueCache.getSelectValue("employees", String.valueOf(employeeId));
        	String stageName = SelectValueCache.getSelectValue("system_dictionary_7", String.valueOf(stageId));
        	msg.append(employeeName+"已拒绝"+stageName+"阶段");
        	
        	//获取专业负责人id
        	Project pDao =new Project();
        	pDao.setConditionProjectId("=", projectId);
        	BaseProject executeQueryOneRow = pDao.executeQueryOneRow();
        	Integer projectManageId = executeQueryOneRow.getProjectManageId();
        	ERPWeixinUtils.sendWXMsgToUser(projectManageId, msg.toString());
			
    	}else if(alternateField2==2){
    		dao.clear();
			dao.setConditionProjectId("=", projectId);
			dao.setConditionEmployeeId("=", employeeId);
			dao.setConditionStageId("=",stageId);
			dao.setAlternateField2(alternateField2+"");
			dao.conditionalUpdate();
        	
        	dao.clear();
    		dao.setConditionProjectId("=", projectId);
    		dao.setConditionAlternateField2("=", "1");//全部通过则通知专业负责人
    		if(dao.conditionalLoad().size()==0) {
    			dao.setConditionAlternateField2("=", "3");//全部通过则通知专业负责人
    			if(dao.conditionalLoad().size()==0) {
    				msg.append("已全部通过");
    				//获取专业负责人id
    				Project pDao =new Project();
    				pDao.setConditionProjectId("=", projectId);
    				BaseProject executeQueryOneRow = pDao.executeQueryOneRow();
    				Integer projectManageId = executeQueryOneRow.getProjectManageId();
    				ERPWeixinUtils.sendWXMsgToUser(projectManageId, msg.toString());
    			}
    		}
    	}
    	
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    
    
    /**
     * @param creteria
     * @return
     * @throws Exception 
     * 
     */
    public static String onSaveOrUpdateStageCheck(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	ProjectEmployee dao = new ProjectEmployee();
    	//获取项目Id
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	if(projectId == 0){
    		throw new SQLException("操作异常:项目不可为空");
    	}
    	//获取职员Id
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	if(employeeId == 0){
    		throw new SQLException("操作异常:成员不可为空");
    	}
       	//获取阶段Id
    	int stageId = BaseHelpUtils.getIntValue(param,"stageId");
		
		String msg ="";
		int status = 1;
    	if(stageId<0) {//判断所有阶段
    		dao.setConditionProjectId("=", projectId);
    		dao.setConditionEmployeeId("=",employeeId);
    		List<BaseProjectEmployee> conditionalLoad = dao.conditionalLoad();
    		if(conditionalLoad.size()>0) {
    			for (BaseProjectEmployee baseProjectEmployee : conditionalLoad) {
        			String alternateField2 = baseProjectEmployee.getAlternateField2();
        			//状态值不为空并且状态值不等于1
        			if(!BaseHelpUtils.isNullOrEmpty(alternateField2)&&alternateField2.equals("1")) {
        				msg="操作异常:该成员未进行审批,无法更改预分配积分";
        				status=-1;
        				break;
        			}
				}
    		}
    	}else {
    		dao.setConditionProjectId("=", projectId);
    		dao.setConditionStageId("=",stageId);
    		dao.setConditionEmployeeId("=",employeeId);
    		BaseProjectEmployee base = dao.executeQueryOneRow();

    		if(!BaseHelpUtils.isNullOrEmpty(base)) {
    			String alternateField2 = base.getAlternateField2();
    			//状态值不为空并且状态值不等于1
    			if(!BaseHelpUtils.isNullOrEmpty(alternateField2)&&alternateField2.equals("1")) {
    				msg="操作异常:该成员未进行审批,无法更改预分配积分";
    				status=-1;
    			}
    		}
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(status,msg);
    }
    
    
    
    
    /**
     * @param creteria
     * @return
     * @throws Exception 
     * 
     */
    public static String onSaveOrUpdateTargetRecord(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	
    	BaseTargetRecord base =new BaseTargetRecord();
    	
    	int businessLine = BaseHelpUtils.getIntValue(param, "businessLine");
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	BigDecimal target = BaseHelpUtils.getBigDecimalValue(param.get("target"));
    	int type = BaseHelpUtils.getIntValue(param, "type");
    	String remark = BaseHelpUtils.getStringValue(param, "remark");
    	
    	TargetRecord tr =new TargetRecord();
    	tr.setConditionBusinessLine("=", businessLine);
    	tr.setConditionYear("=", year);
    	tr.setConditionType("=", type);
    	BaseTargetRecord executeQueryOneRow = tr.executeQueryOneRow();
    	
    	BigDecimal bd =new BigDecimal("10000");
    	//不为空则更新  否则新增
    	if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
    		base.setTargetRecordId(executeQueryOneRow.getTargetRecordId());
    		base.setBusinessLine(businessLine);
    		base.setYear(year);
    		base.setType(type);
    		base.setTarget(target);
    		base.setTargetStr(BaseHelpUtils.getString(target.divide(bd,BigDecimal.ROUND_HALF_UP)));
    		base.setRemark(BaseHelpUtils.isNullOrEmpty(remark)!=true?remark:"");
    		base.setOperateDate(new Date());
    		tr.clear();
    		tr.setDataFromBase(base);
    		tr.update();
    	}else {
    		base.setBusinessLine(businessLine);
    		base.setYear(year);
    		base.setType(type);
    		base.setTarget(target);
    		base.setTargetStr(BaseHelpUtils.getString(target.divide(bd,BigDecimal.ROUND_HALF_UP)));
    		base.setRemark(BaseHelpUtils.isNullOrEmpty(remark)!=true?remark:"");
    		base.setOperateDate(new Date());
    		tr.clear();
    		tr.setDataFromBase(base);
    		tr.save();
    	}
    	
    	ThreadConnection.commit();
       	BaseCollection<GenericBase> bc = new BaseCollection<>();
       	bc.setStatus(1);
       	return bc.toJSON(1,"");
    }
    
    /**
     * 
     * @param param
     * @return
     * @throws SQLException
     */
    private static String checkNonconformityAttachment(Map<String, Object> param) throws SQLException {
    	ThreadConnection.beginTransaction();
    	PlateRecord pDao = new PlateRecord();
    	ProjectManagePerformanceTotal pmptDao = new ProjectManagePerformanceTotal();
    	Employee dao = new Employee();
    	Project ptDao =new Project();
    	StringBuffer title=new StringBuffer("本次扣款详情如下：");
    	
		int userId = BaseHelpUtils.getIntValue(param.get("userId"));
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	int employeeId = BaseHelpUtils.getIntValue(param.get("operateEmployeeId"));
    	
    	//专业负责人
    	dao.setConditionEmployeeId("=",employeeId);
    	BaseEmployee generateBase = dao.executeQueryOneRow();
    	title.append("1.订单负责人:"+generateBase.getEmployeeName()+"扣除2000积分。"+"\n");
    	//对employeeId(改项目订单的专业负责人扣取2000积分) 以及 plateId 下的一二级部门扣取积分 (有一二级部门的则分别扣取1500积分；只有一级部门则扣取3000积分)
    	//设置这一次累计扣款金额
		BigDecimal totalDeduct = BigDecimal.ZERO;
    	//设置当前专业负责人扣款金额
		BigDecimal peopleDeduct = BigDecimal.ZERO;
		//设置当前部门扣款积分
		BigDecimal currentPlatedeductMoney = BigDecimal.ZERO;
		//设置上级部门扣款金额
		BigDecimal parentPlatedeductMoney = BigDecimal.ZERO;
		//扣除个人账户2000积分
		peopleDeduct = peopleDeduct.add(StaticUtils.DEDUCT_MONEY_2000);
		//获取上级部门ID
		int parentId = 0;
		pDao.clear();
		pDao.setConditionPlateId("=",plateId);
		pDao.setSelectPlateName(true);
		BasePlateRecord pBean = pDao.executeQueryOneRow();
		BasePlateRecord parentBean=null;
		if(!BaseHelpUtils.isNullOrEmpty(pBean)){
			parentId = BaseHelpUtils.getIntValue(pBean.getParentId());
			pDao.clear();
			pDao.setConditionPlateId("=",parentId);
			pDao.setSelectPlateName(true);
			parentBean = pDao.executeQueryOneRow();
		}
		if(parentId > 0){
			currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1500;
			parentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1500;
			title.append("2.订单所在一级部门："+parentBean.getPlateName()+"扣除1500积分;"+"订单所在二级部门："+pBean.getPlateName()+"扣除1500积分。"+"\n");
		}else{
			currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_3000;
			title.append("2.订单所在部门："+pBean.getPlateName()+"扣除3000积分。"+"\n");
		}
		totalDeduct=totalDeduct.add(peopleDeduct).add(currentPlatedeductMoney).add(parentPlatedeductMoney);

    	//获取为 project_type in (16,33)
        int listGridRecordLength = BaseHelpUtils.getIntValue(param.get("length"));
        if(listGridRecordLength>0) {
        	Map<String,Object> map =(Map<String, Object>) param.get("listGridRecord");
        	for(int i =0;i<listGridRecordLength;i++) {
                Map<String,Object> kv  = (Map<String, Object>) map .get(i+"");
                if(!BaseHelpUtils.isNullOrEmpty(kv )) {
                	int intValue = BaseHelpUtils.getIntValue(kv.get("projectId"));
                	int intValue2 = BaseHelpUtils.getIntValue(kv.get("plateId"));
                	int intValue5 = BaseHelpUtils.getIntValue(kv.get("projectType"));
                	Integer plateManagerId=0;
                	if(intValue5==16) {//项目管理订单
                		//获取该项目管理订单下的大项目经理扣取1000积分
                		ptDao.clear();
                		ptDao.setConditionProjectId("=", intValue);
                		ptDao.setSelectPlateManagerId(true);
                		BaseProject bproject = ptDao.executeQueryOneRow();
                		plateManagerId= BaseHelpUtils.getIntValue(bproject.getPlateManagerId());
                		totalDeduct=totalDeduct.add(StaticUtils.DEDUCT_MONEY_1000);
                		dao.clear();
                		dao.setConditionEmployeeId("=", plateManagerId);
                		dao.setSelectEmployeeName(true);
                		title.append("3.订单所在项目的大项目经理："+dao.executeQueryOneRow().getEmployeeName()+"扣除1000积分。"+"\n");
                	}else if(intValue5==33) {//条线管理 
                		//获取该项条线管理订单的大项目经理扣取1000积分  并且 该订单所在的项目的条线账户扣取2000积分
                		ptDao.clear();
                		ptDao.setConditionProjectId("=", intValue);
                		ptDao.setSelectPlateManagerId(true);
                		BaseProject bproject = ptDao.executeQueryOneRow();
                		plateManagerId= BaseHelpUtils.getIntValue(bproject.getPlateManagerId());
                		totalDeduct=totalDeduct.add(StaticUtils.DEDUCT_MONEY_1000).add(StaticUtils.DEDUCT_MONEY_2000);
                		dao.clear();
                		dao.setConditionEmployeeId("=", plateManagerId);
                		dao.setSelectEmployeeName(true);
                		pDao.clear();
            			pDao.setConditionPlateId("=",intValue2);
            			pDao.setSelectPlateName(true);
                		title.append("3.订单所在项目的大项目经理："+dao.executeQueryOneRow().getEmployeeName()+"扣除1000积分。"+"\n");
                		title.append("4.订单所在项目的条线账户："+pDao.executeQueryOneRow().getPlateName()+"扣除2000积分。"+"\n");
                	}
                }
        	}
        }
        title.append("本次扣款合计："+totalDeduct+"积分\n");
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	bc.setStatus(1);
    	return bc.toJSON(1,title.toString());
    }
    
    
    /**
     * 更新project_attachment不合格 和罚款信息
     * @param param
     * @return
     * @throws SQLException
     */
    private static String updateNonconformityAttachment(Map<String, Object> param) throws SQLException {
    	ThreadConnection.beginTransaction();
    	PlateRecord pDao = new PlateRecord();
    	ProjectManagePerformanceTotal pmptDao = new ProjectManagePerformanceTotal();
    	Employee dao = new Employee();
    	Project ptDao =new Project();
    	
		//定义map来存放部门及扣款数据
		Map<Integer,BigDecimal> plateMap = new HashMap<>();
		//定义map来存放人员信息
		Map<Integer,BaseEmployee> empDataMap = new HashMap<>();
		
		int userId = BaseHelpUtils.getIntValue(param.get("userId"));
    	int projectAttachmentId = BaseHelpUtils.getIntValue(param.get("projectAttachmentId"));
    	int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
    	String projectName = BaseHelpUtils.getString(param.get("projectName"));
    	String sheetCode = BaseHelpUtils.getString(param.get("sheetCode"));
    	String remark = BaseHelpUtils.getString(param.get("remark"));
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	int employeeId = BaseHelpUtils.getIntValue(param.get("operateEmployeeId"));
    	int stageId = BaseHelpUtils.getIntValue(param.get("stageId"));
    	
    	//专业负责人
    	dao.setConditionEmployeeId("=",employeeId);
    	List<BaseEmployee> conditionalLoad = dao.conditionalLoad();
    	if(BaseHelpUtils.isNullOrEmpty(conditionalLoad)||conditionalLoad.size()<=0) {
    		throw new SQLException("参数异常：操作人不能为空"); 
    	}
    	BaseEmployee generateBase =conditionalLoad.get(0);
    	
    	//stageId
    	SystemDictionary sd =new SystemDictionary();
    	sd.setConditionDicTypeId("=",StaticUtils.SYSTEM_DICTIONARY_7);
    	sd.setConditionDicTypeValueId("=", stageId);
    	BaseSystemDictionary executeQueryOneRow = sd.executeQueryOneRow();
    	String stageName="";
    	if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
    		stageName = executeQueryOneRow.getDicTypeValue();
    	}
    	
    	//更新project_attachment的IsQualified为false不合格
    	ProjectAttachment pa =new ProjectAttachment();
    	BaseProjectAttachment bpa =new BaseProjectAttachment();
    	bpa.setProjectAttachmentId(projectAttachmentId);//主键id
    	bpa.setIsQualified(Boolean.FALSE);//不合格状态
    	bpa.setRemark(remark);//不合格原因
    	pa.setDataFromBase(bpa);
    	pa.update();
		
    	//对employeeId(改项目订单的专业负责人扣取2000积分) 以及 plateId 下的一二级部门扣取积分 (有一二级部门的则分别扣取1500积分；只有一级部门则扣取3000积分)
    	//设置这一次累计扣款金额
		BigDecimal totalDeduct = BigDecimal.ZERO;
    	//设置当前专业负责人扣款金额
		BigDecimal peopleDeduct = BigDecimal.ZERO;
		//设置当前部门扣款积分
		BigDecimal currentPlatedeductMoney = BigDecimal.ZERO;
		//设置上级部门扣款金额
		BigDecimal parentPlatedeductMoney = BigDecimal.ZERO;
		//扣除个人账户2000积分
		peopleDeduct = peopleDeduct.add(StaticUtils.DEDUCT_MONEY_2000);
		//获取上级部门ID
		int parentId = 0;
		pDao.setConditionPlateId("=",plateId);
		BasePlateRecord pBean = pDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(pBean)){
			parentId = BaseHelpUtils.getIntValue(pBean.getParentId());
		}
		if(parentId > 0){
			currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1500;
			parentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_1500;
		}else{
			currentPlatedeductMoney = StaticUtils.DEDUCT_MONEY_3000;
		}
		Date currentDate = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		String format = sdf.format(currentDate);
		String	businessName = String.format("%1$s-%2$s-%3$s",StaticUtils.POROJECT_PERFORMANCE_BUSINESS_5,projectName,format);
		String	remark2 = String.format("因项目(%1$s-%2$s-%3$s)在确认函管理阶段审核不合格，进行项目绩效扣除",sheetCode,projectName,stageName);
		totalDeduct=totalDeduct.add(peopleDeduct).add(currentPlatedeductMoney).add(parentPlatedeductMoney);

    	//获取为 project_type in (16,33)
        int listGridRecordLength = BaseHelpUtils.getIntValue(param.get("length"));
        if(listGridRecordLength>0) {
        	Map<String,Object> map =(Map<String, Object>) param.get("listGridRecord");
        	for(int i =0;i<listGridRecordLength;i++) {
                Map<String,Object> kv  = (Map<String, Object>) map .get(i+"");
                if(!BaseHelpUtils.isNullOrEmpty(kv )) {
                	int intValue = BaseHelpUtils.getIntValue(kv.get("projectId"));
                	int intValue2 = BaseHelpUtils.getIntValue(kv.get("plateId"));
                	int intValue4 = BaseHelpUtils.getIntValue(kv.get("contractId"));
                	int intValue5 = BaseHelpUtils.getIntValue(kv.get("projectType"));
                	Integer plateManagerId=0;
                	if(intValue5==16) {//项目管理订单
                		//获取该项目管理订单下的大项目经理扣取1000积分
                		ptDao.clear();
                		ptDao.setConditionProjectId("=", intValue);
                		BaseProject bproject = ptDao.executeQueryOneRow();
                		plateManagerId= BaseHelpUtils.getIntValue(bproject.getPlateManagerId());
                		totalDeduct=totalDeduct.add(StaticUtils.DEDUCT_MONEY_1000);
                	}else if(intValue5==33) {//条线管理 
                		//获取该项条线管理订单的大项目经理扣取1000积分  并且 该订单所在的项目的条线账户扣取2000积分
                		ptDao.clear();
                		ptDao.setConditionProjectId("=", intValue);
                		BaseProject bproject = ptDao.executeQueryOneRow();
                		plateManagerId= BaseHelpUtils.getIntValue(bproject.getPlateManagerId());
                		totalDeduct=totalDeduct.add(StaticUtils.DEDUCT_MONEY_1000).add(StaticUtils.DEDUCT_MONEY_2000);
                		plateMap.put(intValue2, StaticUtils.DEDUCT_MONEY_2000);
                	}
                	if(plateManagerId>0) {
                		dao.clear();
                		dao.setEmployeeId(plateManagerId);
                		empDataMap.put(plateManagerId, dao.executeQueryOneRow());
                	}
                }
        	}
        }
		
		//插入总表数据
		pmptDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_5);
		pmptDao.setBusinessName(businessName);
		pmptDao.setMainProjectId(projectId);
		pmptDao.setEmployeeId(userId);
		pmptDao.setPerformanceMoney(totalDeduct);
		pmptDao.setRecordDate(currentDate);
		pmptDao.setRecordTime(currentDate);
		pmptDao.setRemark(remark2);
		pmptDao.save();
		int totalBusinessId = pmptDao.getProjectManagePerformanceTotalId();
		//插入品质基金账户
		AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT,0, totalBusinessId, AccountManageProcess.project_performance_achieve,totalDeduct,remark2,-1);
		
		//插入专业负责人个人明细表
		onSaveEmployeeAccount(generateBase, totalBusinessId, peopleDeduct, businessName, currentDate, remark2);	
		onSavePlateAccount(plateId, totalBusinessId, currentPlatedeductMoney, businessName, currentDate, remark2);
		if(parentId > 0) {
			onSavePlateAccount(parentId, totalBusinessId, parentPlatedeductMoney, businessName, currentDate, remark2);
		}
		//插入其余个人或部门明细表
		if(empDataMap.size()>0) {
			for(Integer empId : empDataMap.keySet()){
				BaseEmployee empBean = empDataMap.get(empId);
				onSaveEmployeeAccount(empBean, totalBusinessId, StaticUtils.DEDUCT_MONEY_1000, businessName, currentDate, remark2);	
			}
		}
		if(plateMap.size()>0) {
			for(Integer plateMapId : plateMap.keySet()){
				onSavePlateAccount(plateMapId, totalBusinessId, StaticUtils.DEDUCT_MONEY_2000, businessName, currentDate, remark2);
			}
		}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    //插入个人账户
    private static void onSaveEmployeeAccount(BaseEmployee be,int totalBusinessId,BigDecimal money,String businessName,Date currentDate ,String remark) throws SQLException {
    	ProjectManagePerformanceRecord pmfrDao = new ProjectManagePerformanceRecord();
		pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
		pmfrDao.setObjectId(be.getEmployeeId());
		pmfrDao.setObjectNo(be.getEmployeeNo());
		pmfrDao.setObjectName(be.getEmployeeName());
		pmfrDao.setObjectType(1);//1：人员；2：部门
		pmfrDao.setPerformanceMoney(money);
		pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
		pmfrDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_5);
		pmfrDao.setBusinessName(businessName);
		pmfrDao.setRecordDate(currentDate);
		pmfrDao.setRecordTime(currentDate);
		pmfrDao.setRemark(remark);
		pmfrDao.save();
		int businessId = pmfrDao.getProjectManagePerformanceRecordId();
		//插入个人账户
		AccountManageProcess.onSaveEmployeeAccount(be.getEmployeeId(), businessId,AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE_PAY, money, currentDate, remark, -1);
    }
    
    //插入部门账户
    private static void onSavePlateAccount(Integer plateId,int totalBusinessId,BigDecimal money,String businessName,Date currentDate ,String remark) throws SQLException {
    	ProjectManagePerformanceRecord pmfrDao = new ProjectManagePerformanceRecord();
    	PlateRecord pDao = new PlateRecord();
		pDao.setConditionPlateId("=",plateId);
		BasePlateRecord plateBean = pDao.executeQueryOneRow();
		pmfrDao.setProjectManagePerformanceTotalId(totalBusinessId);
		pmfrDao.setObjectId(plateId);
		pmfrDao.setObjectNo(plateBean.getPlateCode());
		pmfrDao.setObjectName(plateBean.getPlateName());
		pmfrDao.setObjectType(2);//1：人员；2：部门
		pmfrDao.setPerformanceMoney(money);
		pmfrDao.setPerformanceStatus(1);//1：扣款；2：回款
		pmfrDao.setBusinessType(StaticUtils.POROJECT_PERFORMANCE_BUSINESS_TYPE_5);
		pmfrDao.setBusinessName(businessName);
		pmfrDao.setRecordDate(currentDate);
		pmfrDao.setRecordTime(currentDate);
		pmfrDao.setRemark(remark);
		pmfrDao.save();
		int businessId = pmfrDao.getProjectManagePerformanceRecordId();
		//插入部门账户
		AccountManageProcess.onSavePlateAccount(plateId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE_PAY,money,currentDate, remark, -1);
    }
    
    
    /**
     * 加载项目阶段模板
     * @param param
     * @return
     * @throws SQLException
     */
    private static String onReloadProjectTemplate(Map<String, Object> param) throws SQLException {
    	
    	//projectType,plateId,businessType
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	if(projectId<0) {
    		throw new SQLException("操作异常:获取项目ID或业务类型失败");
    	}
    	int projectType = BaseHelpUtils.getIntValue(param,"projectType");
    	if(projectType<0) {
    		throw new SQLException("操作异常:获取项目类型ID失败");
    	}
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	if(plateId<0) {
    		throw new SQLException("操作异常:获取业务部门ID失败");
    	}
    	Project dao =new Project();
    	dao.setConditionProjectId("=", projectId);
    	List<BaseProject> conditionalLoad = dao.conditionalLoad();
    	Integer businessType = 0 ;
    	if(conditionalLoad.size()>0&&!BaseHelpUtils.isNullOrEmpty(conditionalLoad)) {
    		 businessType = conditionalLoad.get(0).getBusinessType();
    		if(businessType<0) {
    			throw new SQLException("操作异常:获取业务类型失败");
    		}
    	}
    	QuerySprojecttemplateor query = new QuerySprojecttemplateor();
    	ConditionSprojecttemplateor condition =new ConditionSprojecttemplateor();
    	condition.setBusinessType(businessType);
    	condition.setPlateId(plateId);
    	condition.setProjectType(projectType);
    	BaseCollection<BaseSprojecttemplateor> executeQuery = query.executeQuery(null, condition);
    	return executeQuery.toJSON(0,"");
    }
    /**
     * 专业负责人项目-阶段策划-更新阶段名称，阶段占比(%)，阶段积分
     * @param param
     * @return
     * @throws SQLException
     */
    private static String onGetStageOfPlanning(Map<String, Object> param) throws SQLException {
    	
    	//projectTemplateId
    	int projectTemplateId = BaseHelpUtils.getIntValue(param,"projectTemplateId");
    	if(projectTemplateId<0) {
    		throw new SQLException("操作异常:获取模板ID失败");
    	}
    	//projectIntegral
    	BigDecimal projectIntegral = BaseHelpUtils.getBigDecimalValue(param.get("projectIntegral"));
    	if(projectIntegral.compareTo(BigDecimal.ZERO)<0) {
    		throw new SQLException("操作异常:获取项目积分失败");
    	}
    	QuerySprojectstagetemplatepor query = new QuerySprojectstagetemplatepor();
    	ConditionSprojectstagetemplatepor condition =new ConditionSprojectstagetemplatepor();
    	condition.setProjectTemplateId(projectTemplateId);
    	BaseCollection<BaseSprojectstagetemplatepor> executeQuery = query.executeQuery(null, condition);
    	if(!BaseHelpUtils.isNullOrEmpty(executeQuery)) {
    		List<BaseSprojectstagetemplatepor> list = executeQuery.getCollections();
    		if(list.size()>0&&!BaseHelpUtils.isNullOrEmpty(list)) {
    			BigDecimal sum =BigDecimal.ZERO;
    			for (int i = 0; i < list.size(); i++) {
    				BaseSprojectstagetemplatepor base = list.get(i);
    				if(i < list.size()-1) {
    					BigDecimal percent = (!BaseHelpUtils.isNullOrEmpty(base.getPercent())&&base.getPercent()>0) ?BaseHelpUtils.getBigDecimalValue(base.getPercent()) :BigDecimal.ZERO; 
    					BigDecimal multiply = percent.divide(new BigDecimal(100)).multiply(projectIntegral);
    					sum=sum.add(multiply);
    					base.setProjectAmount(multiply);
    				}else {
    					BigDecimal multiply=projectIntegral.subtract(sum);
    					base.setProjectAmount(multiply);
    				}
    			}
    		}
    	}
    	return executeQuery.toJSON(0,"");
    }
    /**
     * 订单转单，更新订单编号，业务部门，事业部负责人和部门经理
     * @param param
     * @return
     * @throws SQLException
     */
    private String onTrunUpdateProjectInfo(Map<String, Object> param) throws SQLException {
    	//获取项目Id
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	if(projectId <= 0){
    		throw new SQLException("操作异常:获取项目ID失败");
    	}
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	//获取新的订单编号
    	String contractCode = BaseHelpUtils.getStringValue(param,"contractCode");
    	if(BaseHelpUtils.isNullOrEmpty(contractCode)){
    		throw new SQLException("操作异常：获取新的订单编号失败");
    	}
    	//获取新的事业部负责人
    	int plateManagerId = BaseHelpUtils.getIntValue(param, "plateManagerId");
    	if(plateManagerId <= 0){
    		throw new SQLException("操作异常：获取新的事业部负责人失败");
    	}
    	//获取新的部门经理
    	int departmentManagerId = BaseHelpUtils.getIntValue(param, "departmentManagerId");
    	if(departmentManagerId <= 0){
    		throw new SQLException("操作异常：获取新的部门经理失败");
    	}
    	//检索该项目是否有结算
    	ProjectSettlement psDao = new ProjectSettlement();
    	psDao.setConditionProjectId("=",projectId);
    	if(psDao.isExist()){//说明已经结算了
    		throw new SQLException("操作异常：该项目已有结算，不可进行转单操作");
    	}
    	//检索该项目是否有发起报销
    	NormalReimbursementLinkProject linkProjectDao = new NormalReimbursementLinkProject();
    	linkProjectDao.setConditionProjectId("=",projectId);
    	if(linkProjectDao.isExist()){//说明有进行报销操作，不可进行转单
    		throw new SQLException("操作异常：该项目已有过报销，不可进行转单操作");
    	}
    	Project dao = new Project();
    	dao.setProjectId(projectId);
    	if(!dao.load()){
    		throw new SQLException("操作异常:加载项目失败");
    	}
    	dao.setPlateId(plateId);
    	dao.setRevenuePlateId(plateId);
    	dao.setContractCode(contractCode);
    	dao.setPlateManagerId(plateManagerId);
    	dao.setDepartmentManagerId(departmentManagerId);
    	dao.update();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}
    
    /**
     * 获取业务部门下的新订单编号、事业部负责人和部门经理
     * @param param
     * @return
     * @throws SQLException
     */
    private String onGetTrunPlateInfo(Map<String, Object> param) throws SQLException {
    	//获取项目Id
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	if(projectId <= 0){
    		throw new SQLException("操作异常:获取项目ID失败");
    	}
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param, "plateId");
    	Project dao = new Project();
    	dao.setProjectId(projectId);
    	if(!dao.load()){
    		throw new SQLException("操作异常:加载项目失败");
    	}
    	PlateRecord prDao = new PlateRecord();
    	prDao.setConditionPlateId("=",plateId);
    	BasePlateRecord prBean = prDao.executeQueryOneRow();
    	if(BaseHelpUtils.isNullOrEmpty(prBean)){
    		throw new SQLException("操作异常:加载业务部门失败");
    	}
    	String plateName = BaseHelpUtils.getString(prBean.getPlateName());
    	//根据承接部门，去检索该业务部门下的事业部负责人和部门经理(找到该部门下角色为事业部负责人，再找到该角色下的人员，部门经理同理)
		int plateManagerIdNew = CustomMainContractHandler.getManageEmployeeId(plateId,StaticUtils.ROLE_PLATE_MANAGER);
		//如果该承接部门未设定事业部负责人，则抛出异常
		if(plateManagerIdNew <= 0){
			throw new SQLException("操作异常:转单部门("+plateName+")未设定事业部负责人,请先设定");
		}
		//获取该部门下的部门经理
		int departmentManagerIdNew = CustomMainContractHandler.getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER);
		//如果该承接部门未设定部门经理，则抛出异常
		if(departmentManagerIdNew <= 0){
			throw new SQLException("操作异常:转单部门("+plateName+")未设定部门经理,请先设定");
		}
		//获取业务部门编号
		String plateCode = BaseHelpUtils.getString(prBean.getPlateCode());
		if(BaseHelpUtils.isNullOrEmpty(plateCode)){
			throw new SQLException("操作异常:新业务部门编号为空");
		}
		//获取该项目的订单编号
		String contractCode = BaseHelpUtils.getString(dao.getContractCode());
		if(BaseHelpUtils.isNullOrEmpty(contractCode)){
			throw new SQLException("操作异常:获取原订单编号失败");
		}
		String[] codeArr = contractCode.split("-");
		int len = codeArr.length;
		String contractCodeNew = contractCode.replace("-"+codeArr[len-1], "-"+plateCode);
    	Map<String,Object> userdata = new HashMap<>();
    	userdata.put("contractCodeNew",contractCodeNew);
    	userdata.put("plateManagerIdNew",plateManagerIdNew);
    	userdata.put("departmentManagerIdNew",departmentManagerIdNew);
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	bc.setUserData(userdata);
    	return bc.toJSON(0,"");
	}
    
    /**
     * 项目管理绩效积分回退
     * @param param
     * @return
     * @throws SQLException
     */
    private String onProjectPerformanceBack(Map<String, Object> param) throws SQLException {
    	ThreadConnection.beginTransaction();
    	//获取项目绩效总表Id
    	int projectManagePerformanceTotalId = BaseHelpUtils.getIntValue(param,"projectManagePerformanceTotalId");
    	if(projectManagePerformanceTotalId == 0){
    		throw new SQLException("操作异常:项目绩效编码为空");
    	}
    	ProjectManagePerformanceTotal totalDao = new ProjectManagePerformanceTotal();
    	totalDao.setProjectManagePerformanceTotalId(projectManagePerformanceTotalId);
    	if(totalDao.load()){
    		//获取回退的备注原因
    		String remark = BaseHelpUtils.getStringValue(param, "remark");
    		if(BaseHelpUtils.isNullOrEmpty(remark)){
    			throw new SQLException("操作异常:回退的缘由为空");
    		}
    		//获取累计扣款金额
    		BigDecimal performanceMoney = BaseHelpUtils.getBigDecimalValue(totalDao.getPerformanceMoney());
    		//如果累计扣款金额等于0，说明已经回退过款，则无需再次退款
    		if(performanceMoney.compareTo(BigDecimal.ZERO) == 0) {
    			throw new SQLException("操作异常:该笔扣款已回退过，无需再次进行回退操作");
    		}
    		//转换为负数
    		Date currentDate = new Date();
    		totalDao.setRemark(remark);
    		totalDao.setPerformanceMoney(BigDecimal.ZERO);//更新金额为0
    		totalDao.setRecordTime(currentDate);
    		totalDao.update();
    		//品质基金插入一条支出数据
    		AccountManageProcess.onSaveOrUpdateAccount(AccountManageProcess.ACCOUNT_QUALITY_ACCOUNT,0, projectManagePerformanceTotalId, AccountManageProcess.project_performance,performanceMoney,remark,-1);
    		//查询字表数据
    		ProjectManagePerformanceRecord dao = new ProjectManagePerformanceRecord();
    		dao.setConditionProjectManagePerformanceTotalId("=",projectManagePerformanceTotalId);
    		List<BaseProjectManagePerformanceRecord> list = dao.conditionalLoad();
    		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    			BaseProjectManagePerformanceRecord bean = null;
    			for(BaseProjectManagePerformanceRecord e : list){
    				bean = e;
    				//获取对象Id
    				int objectId = BaseHelpUtils.getIntValue(e.getObjectId());
    				//获取对象类型
    				int objectType = BaseHelpUtils.getIntValue(e.getObjectType());
    				//获取绩效金额
    				BigDecimal money = BaseHelpUtils.getBigDecimalValue(e.getPerformanceMoney());
    				//设置绩效金额负数
    				BigDecimal moneyTwo = money.multiply(new BigDecimal("-1"));
    				//插入明细表
    				bean.setPerformanceMoney(moneyTwo);
    				bean.setRecordTime(currentDate);
    				bean.setPerformanceStatus(2);
    				bean.setRemark(remark);
    				dao.clear();
    				dao.setDataFromBase(bean);
    				dao.save();
    				int businessId = dao.getProjectManagePerformanceRecordId();
    				if(objectType == 1){//人员
    					//向人员账户插入数据
    					AccountManageProcess.onSaveEmployeeAccount(objectId, businessId,AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE,money, currentDate, remark, -1);
    				}else if(objectType == 2){//部门
    					//插入部门账户
    					AccountManageProcess.onSavePlateAccount(objectId, businessId,AccountManageProcess.PLATE_BT_PROJECT_PERFORMANCE,money,currentDate, remark, -1);
    				}
    				
    			}
    		}
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}
    
    
    /**
     * 保存或更新项目阶段成员预分配积分(第二版)
     * @param param
     * @return
     * @throws SQLException
     */
    private static String onSaveOrUpdateStageEmp(Map<String, Object> param) throws SQLException {
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	ThreadConnection.beginTransaction();
    	List<Map<String,Object>> resultList= (List<Map<String, Object>>) param.get("resultList");
    	if(resultList.size()>0) {
    		Set set = new HashSet();
    		Set<Integer> hset =new HashSet<>();
    		set.add(-1);//后续删除stageId小于0的所有数据
        	for (Map<String, Object> map : resultList) {
        		int intValue = BaseHelpUtils.getIntValue(map.get("stageId"));
        		set.add(intValue);
    		}
    		Employee eDao =new Employee();
    		ProjectEmployee dao = new ProjectEmployee();
    		Project pDao = new Project();
    		ProjectEmployeeAuditRecord peDao =new ProjectEmployeeAuditRecord();
    		ProjectStage psDao =new ProjectStage();
    		int projectId=0;
			for (Map<String, Object> map : resultList) {
				// 获取项目Id
				projectId = BaseHelpUtils.getIntValue(map, "projectId");
				if (projectId == 0) {
					throw new SQLException("操作异常:项目不可为空");
				}
				// 获取阶段Id
				int stageId = BaseHelpUtils.getIntValue(map, "stageId");
				// 获取职员Id
				int employeeId = BaseHelpUtils.getIntValue(map, "employeeId");
				if (employeeId == 0) {
					throw new SQLException("操作异常:成员不可为空");
				}else {
					hset.add(employeeId);
				}
				// 获取预分配积分
				BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(map.get("planIntegral"));
				if (planIntegral.compareTo(BigDecimal.ZERO) < 0) {
					throw new SQLException("操作异常:成员预分配积分不可小于0");
				}

				dao.clear();
				dao.setConditionProjectId("=", projectId);
				dao.setConditionStageId("=", stageId);
				dao.setConditionEmployeeId("=", employeeId);
				if (dao.conditionalLoad().size() > 0) {
					BaseProjectEmployee baseProjectEmployee = dao.conditionalLoad().get(0);
					// 获取上一次预分配积分
					BigDecimal oldPlanIntegral = BaseHelpUtils.getBigDecimalValue(baseProjectEmployee.getPlanIntegral())
							.setScale(2);
					if (BaseHelpUtils.isNullOrEmpty(baseProjectEmployee.getAlternateField2())
							|| !baseProjectEmployee.getAlternateField2().equals("1")) {
						dao.setPlanIntegral(planIntegral);
						dao.setAlternateField1(oldPlanIntegral + "");
						dao.setAlternateField2(1 + "");// 状态值 1：待审批 2：同意 3：不同意
						dao.conditionalUpdate();
					}
				} else {
					dao.clear();
					dao.setProjectId(projectId);
					dao.setStageId(stageId);
					dao.setEmployeeId(employeeId);
					dao.setPlanIntegral(planIntegral);
					dao.setAlternateField1(0 + "");
					dao.setAlternateField2(1 + "");// 状态值 1：待审批 2：同意 3：不同意
					eDao.clear();
					eDao.setEmployeeId(employeeId);
					if (!eDao.load()) {
						return bc.toJSON(-1, "加载不到员工数据");
					}

					pDao.clear();
					pDao.setProjectId(projectId);
					if (!pDao.load()) {
						return bc.toJSON(-1, "加载不到项目数据");
					}
					if (Objects.equals(eDao.getPlateId(), pDao.getPlateId())) {
						// 员工所在业务部门和订单所在业务部门一致，则直接成为项目的正式成员
						dao.setFlag(StaticUtils.PROJECT_EMPLOYEE_FLAG_2);
					} else {
						// 如果不一致，则成为待定成员，需要经员工所在业务部门的一级事业部负责人审批通过，才能成为正式成员
						dao.setFlag(StaticUtils.PROJECT_EMPLOYEE_FLAG_1);
					}
					dao.save();
				}
			}
    		
    		dao.clear();
    		dao.setConditionProjectId("=", projectId);
    		dao.setConditionStageId("<", 0);
    		dao.conditionalDelete();
    		
    		dao.clear();
    		dao.setConditionProjectId("=", projectId);
    		List<BaseProjectEmployee> load = dao.conditionalLoad();
    		if(load.size()>0) {
    			for (BaseProjectEmployee baseProjectEmployee : load) {
    				Integer employeeId = baseProjectEmployee.getEmployeeId();
    				eDao.clear();
					eDao.setConditionEmployeeId("=",baseProjectEmployee.getEmployeeId());
					eDao.setConditionStatus("=", 1);
					if(eDao.executeQueryOneRow()!=null) {
						dao.clear();
						dao.setConditionProjectId("=", projectId);
						dao.setConditionEmployeeId("=", baseProjectEmployee.getEmployeeId());
						dao.setAlternateField2(2+"");
						dao.conditionalUpdate();
					}
				}
    		}
    		
    		for (Object object : set) {
    			if(BaseHelpUtils.getIntValue(object)<0) {
    				continue;
    			}
    			
            	//清除现有的数据子表
    			peDao.clear();
    			peDao.setConditionProjectId("=", projectId);
    			peDao.setConditionStageId("=", BaseHelpUtils.getIntValue(object));
    			peDao.conditionalDelete();
       			//新增子表数据，并且离职人员的状态为通过
    			psDao.clear();
    			psDao.setConditionProjectId("=", projectId);
    			psDao.setConditionStageId("=", BaseHelpUtils.getIntValue(object));
    			List<BaseProjectStage> list = psDao.conditionalLoad();
    			if(list.size()>0) {
    				for (BaseProjectStage baseProjectStage : list) {
    					//新增子表的各个阶段的数据
    					dao.clear();
    					dao.setConditionProjectId("=", projectId);
    					dao.setConditionStageId("=", baseProjectStage.getStageId());
    					List<BaseProjectEmployee> conditionalLoad = dao.conditionalLoad();
    					if(conditionalLoad.size()>0) {
    						for (int i = 0; i < conditionalLoad.size(); i++) {
    							BaseProjectEmployee projectEmployee = conditionalLoad.get(i);
    							for (int j = 0; j < conditionalLoad.size(); j++) {
    								BaseProjectEmployee projectEmployee2 = conditionalLoad.get(j);
    								
    								eDao.clear();
    								eDao.setConditionEmployeeId("=",projectEmployee.getEmployeeId());
    								BaseEmployee employee = eDao.executeQueryOneRow();
    								int status = 1;
    								if(employee!=null&&employee.getStatus()==1) {//离职人员直接审批通过
    									status=2;
    								}
    								BaseProjectEmployeeAuditRecord peBase =new BaseProjectEmployeeAuditRecord();
    								peBase.setProjectId(projectId);
    								peBase.setStageId(baseProjectStage.getStageId());
    								peBase.setEmployeeId(projectEmployee.getEmployeeId());
    								peBase.setCheckEmployeeId(projectEmployee2.getEmployeeId());
    								peBase.setPlanIntegral(projectEmployee2.getPlanIntegral());
    								peBase.setOldPlanIntegral(BaseHelpUtils.getBigDecimalValue(projectEmployee2.getAlternateField1()));
    								peBase.setStatus(status);
    								peDao.clear();
    								peDao.setDataFromBase(peBase);
    								peDao.save();
    							}
    						}
    					}
    				}
    			}
			}
    		
    	}else {
    		throw new SQLException("操作异常:变动数据为空");
    	}
    	ThreadConnection.commit();
    	return bc.toJSON(1,"");
	}
    
    /**
     * 把草稿保存的成员删除
     * @param param
     * @return
     * @throws SQLException 
     */
    private String deleteProjectEmployeeFlag(Map<String, Object> param) throws SQLException {
    	int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
    	ProjectEmployee dao = new ProjectEmployee();
    	dao.setConditionProjectId("=", projectId);
    	dao.setConditionFlag("=", 1);
    	if(dao.isExist()){
    		dao.conditionalDelete();
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}

	/**
     * 把草稿保存的成员改为已保存状态
     * @param param
     * @return
     * @throws SQLException 
     */
    private String changeProjectEmployeeFlag(Map<String, Object> param) throws SQLException {
    	int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
    	ProjectEmployee dao = new ProjectEmployee();
    	dao.setConditionProjectId("=", projectId);
    	dao.setConditionFlag("=", 1);
    	if(dao.isExist()){
    		dao.setFlag(2);
    		dao.conditionalUpdate();
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
	}

	/**
     * 删除项目阶段成员数据集
     * @param param
     * @return
     * @throws SQLException 
     */
	public String onDeleteProjectStageEmp(Map<String, Object> param) throws SQLException{
		ThreadConnection.beginTransaction();
    	//获取项目Id和成员Id
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	if(projectId == 0){
    		throw new SQLException("操作异常:该项目Id不可为空");
    	}
    	if(employeeId == 0){
    		throw new SQLException("操作异常:该项目成员不可为空");
    	}
    	ProjectEmployee peDao = new ProjectEmployee();
    	peDao.setConditionProjectId("=",projectId);
    	peDao.setConditionEmployeeId("=",employeeId);
    	peDao.conditionalDelete();
    	
    	ProjectEmployeeAuditRecord pear =new ProjectEmployeeAuditRecord();
    	pear.setConditionProjectId("=",projectId);
    	pear.setConditionEmployeeId("=",employeeId);
    	pear.setDeleteFlag(0);
    	pear.conditionalUpdate();
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 保存项目阶段成员数据集
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onSaveProjectStageEmp(Map<String, Object> param) throws SQLException{
    	//获取项目Id和阶段Id
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	int stageId = BaseHelpUtils.getIntValue(param, "stageId");
    	if(projectId == 0){
    		throw new SQLException("操作异常:该项目Id不可为空");
    	}
    	@SuppressWarnings("unchecked")
		List<BaseProjectEmployee> projectStageList = GenericBase.__getList(param.get("projectStageList"),BaseProjectEmployee.newInstance());
    	if(!BaseHelpUtils.isNullOrEmpty(projectStageList) && projectStageList.size() > 0){
    		//判断该项目是否存在
    		Project dao = new Project();
    		dao.setProjectId(projectId);
    		if(!dao.load()){
    			throw new SQLException("操作异常:该项目不存在");
    		}
    		//获取该项目在该阶段的阶段积分
    		ProjectStage psDao = new ProjectStage();
    		psDao.setConditionProjectId("=",projectId);
    		psDao.setConditionStageId("=",stageId);
    		BaseProjectStage psBean = psDao.executeQueryOneRow();
    		if(BaseHelpUtils.isNullOrEmpty(psBean)){
    			throw new SQLException("操作异常:该项目不存在该阶段");
    		}
    		ProjectSettlement pssDao = new ProjectSettlement();
    		//检索该项目在该阶段的确认积分总表数据集
    		pssDao.setConditionProjectId("=",projectId);
    		pssDao.setConditionStageId("=",stageId);
    		pssDao.setConditionSettlementStatus("=",2);
    		List<BaseProjectSettlement> pssList = pssDao.conditionalLoad();
			//定义map来存放所有成员在该阶段上已经确认的积分
			Map<Integer,BigDecimal> sureMap = new HashMap<>();
			if(!BaseHelpUtils.isNullOrEmpty(pssList) && pssList.size() > 0){
				ProjectSettlementDetail psdDao = new ProjectSettlementDetail();
	    		List<BaseProjectSettlementDetail> psdList = null;
				for(BaseProjectSettlement pssBean : pssList){
					//获取结算总表Id
					int settlementId = BaseHelpUtils.getIntValue(pssBean.getSettlementId());
					psdDao.clear();
					psdDao.setConditionSettlementId("=",settlementId);
					psdList = psdDao.conditionalLoad();
					if(!BaseHelpUtils.isNullOrEmpty(psdList) && psdList.size() > 0){
						for(BaseProjectSettlementDetail psdBean : psdList){
							//获取成员Id
							int employeeId = BaseHelpUtils.getIntValue(psdBean.getEmployeeId());
							//获取确认积分
							BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(psdBean.getRealAmount());
							sureMap.put(employeeId,BaseHelpUtils.getBigDecimalValue(sureMap.get(employeeId)).add(sureIntegral));
						}
					}
				}
			}
    		//获取阶段积分
    		BigDecimal stageIntegral = BaseHelpUtils.getBigDecimalValue(psBean.getProjectAmount());
    		Employee eDao = new Employee();
    		ProjectEmployee peDao = new ProjectEmployee();
    		ThreadConnection.beginTransaction();
    		for(BaseProjectEmployee peBean : projectStageList){
    			//获取成员Id
    			int employeeId = BaseHelpUtils.getIntValue(peBean.getEmployeeId());
    			eDao.clear();
				eDao.setEmployeeId(employeeId);
				String empName ="";
				if(eDao.load()){
					empName = eDao.getEmployeeName();
				}else{
					throw new SQLException("操作异常:该项目有成员不存在");
				}
    			//获取成员预分配积分
    			BigDecimal planIntegral = BaseHelpUtils.getBigDecimalValue(peBean.getPlanIntegral());
    			stageIntegral = stageIntegral.subtract(planIntegral);
    			//如果成员的预分配积分超过了该阶段的阶段积分，则抛出异常
    			if(stageIntegral.compareTo(BigDecimal.ZERO) < 0){
    				throw new SQLException("操作异常:该项目预分配到成员的积分超出了该阶段的阶段积分");
    			}
    			//获取该成员在该阶段上确认的积分
    			BigDecimal sureInegral = BaseHelpUtils.getBigDecimalValue(sureMap.get(employeeId));
    			//如果该成员的预分配积分<已确认积分，则抛出异常
    			if(planIntegral.compareTo(sureInegral) < 0){
    				throw new SQLException("操作异常:成员("+empName+")的预分配积分不可小于已确认积分");
    			}
    			peDao.clear();
    			peDao.setConditionProjectId("=",projectId);
    			peDao.setConditionStageId("=",stageId);
    			peDao.setConditionEmployeeId("=",employeeId);
    			peDao.setPlanIntegral(planIntegral);
    			if(peDao.isExist()){
    				continue;
    			}else{
    				peDao.setProjectId(projectId);
					peDao.setStageId(stageId);
					peDao.setEmployeeId(employeeId);
					peDao.setFlag(1);//草稿保存
					peDao.save();
    			}
    		}
    		ThreadConnection.commit();
    	}
    	QuerySprojectemployeepdsor query = new QuerySprojectemployeepdsor();
    	ConditionSprojectemployeepdsor condition = new ConditionSprojectemployeepdsor();
    	condition.setProjectId(projectId);
    	condition.setStageId(stageId);
    	BaseCollection<BaseSprojectemployeepdsor> employeeList = query.executeQuery(null, condition);
    	return employeeList.toJSON(0,"");
    }
    
    /**
     * 加载标准报价单数据集
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadStandardQuoteData(Map<String, Object> param) throws SQLException{
    	//获取开始日期和结束日期
    	String startDateStr = BaseHelpUtils.getStringValue(param, "startDate");
    	String endDateStr = BaseHelpUtils.getStringValue(param, "endDate");
    	//获取客户名称
    	String clientName = BaseHelpUtils.getStringValue(param, "customName");
    	//获取业务类别
    	String businessType = BaseHelpUtils.getStringValue(param, "businessType");
    	ConditionOnLoadStandardQuoteData con = new ConditionOnLoadStandardQuoteData();
    	if(!BaseHelpUtils.isNullOrEmpty(startDateStr) && !BaseHelpUtils.isNullOrEmpty(endDateStr)){
    		Date startDate = new Date(Long.valueOf(startDateStr));
    		Date endDate = new Date(Long.valueOf(endDateStr));
    		con.setStartDate(startDate);
    		con.setEndDate(endDate);
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(clientName)){
    		con.setClientName(clientName);
    	}
    	if(!BaseHelpUtils.isNullOrEmpty(businessType)){
    		con.setBusinessType(businessType);
    	}
    	QueryOnLoadStandardQuoteData dao = new QueryOnLoadStandardQuoteData();
    	BaseCollection<BaseOnLoadStandardQuoteData> result = dao.executeQuery(null, con);
    	if(!BaseHelpUtils.isNullOrEmpty(result)){
    		List<BaseOnLoadStandardQuoteData> list = result.getCollections();
    		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    			//获取项目等级
    			int projectLevelType = BaseHelpUtils.getIntValue(param, "projectLevelType");
    			//获取客户等级
    			int customLevelType = BaseHelpUtils.getIntValue(param, "customLevelType");
    			//获取区域等级
    			int areaLevelType = BaseHelpUtils.getIntValue(param, "areaLevelType");
    			//获取面积区间
    			int sizeType = BaseHelpUtils.getIntValue(param, "sizeType");
    			Map<BigDecimal,BigDecimal> sizeMap = new HashMap<>();
    			if(sizeType > 0){
    				if(sizeType == 1){
    					sizeMap.put(BigDecimal.ZERO, BigDecimal.valueOf(5000));
    				}else if(sizeType == 2){
    					sizeMap.put(BigDecimal.valueOf(5000), BigDecimal.valueOf(10000));
    				}else if(sizeType == 3){
    					sizeMap.put(BigDecimal.valueOf(10000), BigDecimal.valueOf(20000));
    				}else if(sizeType == 3){
    					sizeMap.put(BigDecimal.valueOf(20000), BigDecimal.valueOf(30000));
    				}else{
    					sizeMap.put(BigDecimal.valueOf(30000), BigDecimal.valueOf(99999999));
    				}
    			}
    			
    			//定义相似度区间在(0-20]的list
    			List<BaseOnLoadStandardQuoteData> oneList = new ArrayList<>();
    			//定义相似度区间在(20-40]的list
    			List<BaseOnLoadStandardQuoteData> twoList = new ArrayList<>();
    			//定义相似度区间在(40-60]的list
    			List<BaseOnLoadStandardQuoteData> threeList = new ArrayList<>();
    			//定义相似度区间在(60-80]的list
    			List<BaseOnLoadStandardQuoteData> fourList = new ArrayList<>();
    			//定义相似度区间在(80-100]的list
    			List<BaseOnLoadStandardQuoteData> fiveList = new ArrayList<>();
    			BigDecimal percent = BigDecimal.valueOf(25);
    			for(BaseOnLoadStandardQuoteData e : list){
    				//获取相似度
    				BigDecimal samePercent = BaseHelpUtils.getBigDecimalValue(e.getSamePercent());
    				//获取面积
    				BigDecimal area = BaseHelpUtils.getBigDecimalValue(e.getArea());
    				if(area.compareTo(BigDecimal.ZERO) > 0 && sizeMap.size() > 0){
    					for(BigDecimal size : sizeMap.keySet()){
    						BigDecimal maxSize = BaseHelpUtils.getBigDecimalValue(sizeMap.get(size));
    						//如果在区间内则相似度为25%，如果不在区间内，则按1000的度向上或向下递减
    						BigDecimal cha = BigDecimal.ZERO;
    						if(area.compareTo(size) >= 0 && area.compareTo(maxSize) <= 0){
    							samePercent = samePercent.add(percent);
    							break;
    						}else if(area.compareTo(size) < 0){
    							cha = size.subtract(area);
    						}else{
    							cha = area.subtract(maxSize);
    						}
    						if(cha.compareTo(BigDecimal.valueOf(1000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.9)));
    						}else if(cha.compareTo(BigDecimal.valueOf(2000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.8)));
    						}else if(cha.compareTo(BigDecimal.valueOf(3000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.7)));
    						}else if(cha.compareTo(BigDecimal.valueOf(4000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.6)));
    						}else if(cha.compareTo(BigDecimal.valueOf(5000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.5)));
    						}else if(cha.compareTo(BigDecimal.valueOf(6000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.4)));
    						}else if(cha.compareTo(BigDecimal.valueOf(7000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.3)));
    						}else if(cha.compareTo(BigDecimal.valueOf(8000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.2)));
    						}else if(cha.compareTo(BigDecimal.valueOf(9000)) <= 0){
    							samePercent = samePercent.add(percent.multiply(BigDecimal.valueOf(0.1)));
    						}
    						
    					}
    				}
    				//获取项目等级
    				int projectLevelValue = BaseHelpUtils.getIntValue(e.getProjectLevel());
    				if(projectLevelValue > 0 && projectLevelValue > 0 && projectLevelType == projectLevelValue){
    					samePercent = samePercent.add(percent);
    				}
    				//获取城市等级
    				int areaLevel = BaseHelpUtils.getIntValue(e.getAreaLevel());
    				if(areaLevelType > 0 && areaLevel > 0 && areaLevelType == areaLevel){
    					samePercent = samePercent.add(percent);
    				}
    				e.setSamePercent(samePercent);
    				if(samePercent.compareTo(BigDecimal.valueOf(20)) <= 0){
    					oneList.add(e);
    				}else if(samePercent.compareTo(BigDecimal.valueOf(40)) <= 0){
    					twoList.add(e);
    				}else if(samePercent.compareTo(BigDecimal.valueOf(60)) <= 0){
    					threeList.add(e);
    				}else if(samePercent.compareTo(BigDecimal.valueOf(80)) <= 0){
    					fourList.add(e);
    				}else if(samePercent.compareTo(BigDecimal.valueOf(100)) <= 0){
    					fiveList.add(e);
    				}
    			}
    			if(fiveList.size() > 0){
    				list = fiveList;
    			}else if(fourList.size() > 0){
    				list = fourList;
    			}else if(threeList.size() > 0){
    				list = threeList;
    			}else if(twoList.size() > 0){
    				list = twoList;
    			}else if(oneList.size() > 0){
    				list = oneList;
    			}
    			Collections.sort(list);
    			int size = list.size();
    			if(size > 0){
    				//初始化最高报价、最低报价、平均单价和最近报价
    				BigDecimal maxPrice = BigDecimal.ZERO;
    				BigDecimal minPrice = BigDecimal.ZERO;
    				BigDecimal avgPrice = BigDecimal.ZERO;
    				BigDecimal recentPrice = BigDecimal.ZERO;
    				BigDecimal avgPriceTotal = BigDecimal.ZERO;
    				//定义最高报价的项目的每个专业的单价和占比
    				BigDecimal maxZsTotalPrice = BigDecimal.ZERO;
    				BigDecimal maxZsPrice = BigDecimal.ZERO;
    				BigDecimal maxZsPricePercent = BigDecimal.ZERO;
    				BigDecimal maxJdTotalPrice = BigDecimal.ZERO;
    				BigDecimal maxJdPrice = BigDecimal.ZERO;
					BigDecimal maxJdPricePercent = BigDecimal.ZERO;
					BigDecimal maxDgTotalPrice = BigDecimal.ZERO;
					BigDecimal maxDgPrice = BigDecimal.ZERO;
					BigDecimal maxDgPricePercent = BigDecimal.ZERO;
					BigDecimal maxCsTotalPrice = BigDecimal.ZERO;
					BigDecimal maxCsPrice = BigDecimal.ZERO;
					BigDecimal maxCsPricePercent = BigDecimal.ZERO;
					BigDecimal maxPmTotalPrice = BigDecimal.ZERO;
					BigDecimal maxPmPrice = BigDecimal.ZERO;
					BigDecimal maxPmPricePercent = BigDecimal.ZERO;
					BigDecimal maxHjTotalPrice = BigDecimal.ZERO;
					BigDecimal maxHjPrice = BigDecimal.ZERO;
					BigDecimal maxHjPricePercent = BigDecimal.ZERO;
					
					//定义最低报价的项目的每个专业的单价和占比
					BigDecimal minZsTotalPrice = BigDecimal.ZERO;
					BigDecimal minZsPrice = BigDecimal.ZERO;
    				BigDecimal minZsPricePercent = BigDecimal.ZERO;
    				BigDecimal minJdTotalPrice = BigDecimal.ZERO;
    				BigDecimal minJdPrice = BigDecimal.ZERO;
					BigDecimal minJdPricePercent = BigDecimal.ZERO;
					BigDecimal minDgTotalPrice = BigDecimal.ZERO;
					BigDecimal minDgPrice = BigDecimal.ZERO;
					BigDecimal minDgPricePercent = BigDecimal.ZERO;
					BigDecimal minCsTotalPrice = BigDecimal.ZERO;
					BigDecimal minCsPrice = BigDecimal.ZERO;
					BigDecimal minCsPricePercent = BigDecimal.ZERO;
					BigDecimal minPmTotalPrice = BigDecimal.ZERO;
					BigDecimal minPmPrice = BigDecimal.ZERO;
					BigDecimal minPmPricePercent = BigDecimal.ZERO;
					BigDecimal minHjTotalPrice = BigDecimal.ZERO;
					BigDecimal minHjPrice = BigDecimal.ZERO;
					BigDecimal minHjPricePercent = BigDecimal.ZERO;
					//定义平均报价的单价和占比
					BigDecimal avgZsTotalPrice = BigDecimal.ZERO;
					BigDecimal avgZsPrice = BigDecimal.ZERO;
    				BigDecimal avgZsPricePercent = BigDecimal.ZERO;
    				BigDecimal avgJdTotalPrice = BigDecimal.ZERO;
    				BigDecimal avgJdPrice = BigDecimal.ZERO;
					BigDecimal avgJdPricePercent = BigDecimal.ZERO;
					BigDecimal avgDgTotalPrice = BigDecimal.ZERO;
					BigDecimal avgDgPrice = BigDecimal.ZERO;
					BigDecimal avgDgPricePercent = BigDecimal.ZERO;
					BigDecimal avgCsTotalPrice = BigDecimal.ZERO;
					BigDecimal avgCsPrice = BigDecimal.ZERO;
					BigDecimal avgCsPricePercent = BigDecimal.ZERO;
					BigDecimal avgPmTotalPrice = BigDecimal.ZERO;
					BigDecimal avgPmPrice = BigDecimal.ZERO;
					BigDecimal avgPmPricePercent = BigDecimal.ZERO;
					BigDecimal avgHjTotalPrice = BigDecimal.ZERO;
					BigDecimal avgHjPrice = BigDecimal.ZERO;
					BigDecimal avgHjPricePercent = BigDecimal.ZERO;
					//定义最近报价的项目的每个专业的单价和占比
					BigDecimal recentZsTotalPrice = BigDecimal.ZERO;
					BigDecimal recentZsPrice = BigDecimal.ZERO;
					BigDecimal recentZsPricePercent = BigDecimal.ZERO;
					BigDecimal recentJdTotalPrice = BigDecimal.ZERO;
					BigDecimal recentJdPrice = BigDecimal.ZERO;
					BigDecimal recentJdPricePercent = BigDecimal.ZERO;
					BigDecimal recentDgTotalPrice = BigDecimal.ZERO;
					BigDecimal recentDgPrice = BigDecimal.ZERO;
					BigDecimal recentDgPricePercent = BigDecimal.ZERO;
					BigDecimal recentCsTotalPrice = BigDecimal.ZERO;
					BigDecimal recentCsPrice = BigDecimal.ZERO;
					BigDecimal recentCsPricePercent = BigDecimal.ZERO;
					BigDecimal recentPmTotalPrice = BigDecimal.ZERO;
					BigDecimal recentPmPrice = BigDecimal.ZERO;
					BigDecimal recentPmPricePercent = BigDecimal.ZERO;
					BigDecimal recentHjTotalPrice = BigDecimal.ZERO;
					BigDecimal recentHjPrice = BigDecimal.ZERO;
					BigDecimal recentHjPricePercent = BigDecimal.ZERO;
					
					//定义每个专业的累加单价和占比
					BigDecimal zsPriceTotal = BigDecimal.ZERO;
					BigDecimal zsPricePercentTotal = BigDecimal.ZERO;
					BigDecimal jdPriceTotal = BigDecimal.ZERO;
					BigDecimal jdPricePercentTotal = BigDecimal.ZERO;
					BigDecimal dgPriceTotal = BigDecimal.ZERO;
					BigDecimal dgPricePercentTotal = BigDecimal.ZERO;
					BigDecimal csPriceTotal = BigDecimal.ZERO;
					BigDecimal csPricePercentTotal = BigDecimal.ZERO;
					BigDecimal pmPriceTotal = BigDecimal.ZERO;
					BigDecimal pmPricePercentTotal = BigDecimal.ZERO;
					
					//定义每个专业累加数
					BigDecimal zsPriceNum = BigDecimal.ZERO;
					BigDecimal zsPricePercentNum = BigDecimal.ZERO;
					BigDecimal jdPriceNum = BigDecimal.ZERO;
					BigDecimal jdPricePercentNum = BigDecimal.ZERO;
					BigDecimal dgPriceNum = BigDecimal.ZERO;
					BigDecimal dgPricePercentNum = BigDecimal.ZERO;
					BigDecimal csPriceNum = BigDecimal.ZERO;
					BigDecimal csPricePercentNum = BigDecimal.ZERO;
					BigDecimal pmPriceNum = BigDecimal.ZERO;
					BigDecimal pmPricePercentNum = BigDecimal.ZERO;
					
    				Date compareDate = null;
    				OutDesignConsideration outDao = new OutDesignConsideration();
    				List<BaseOutDesignConsideration> outList = null;
    				BigDecimal hundred = BigDecimal.valueOf(100);
    				for(BaseOnLoadStandardQuoteData e : list){
    					//这个金额为项目的总金额
    					BigDecimal moneySum = BaseHelpUtils.getBigDecimalValue(e.getMoneySum());
    					//这个面积为装饰的累加面积
    					BigDecimal area = BaseHelpUtils.getBigDecimalValue(e.getArea());
    					//获取成功报价单的主键Id
    					int outQuotationId = BaseHelpUtils.getIntValue(e.getOutQuotationId());
    					/**
    					 * 分析每一个项目的专业(装饰、机电、灯光、陈设、平面)单价和金额占比
    					 * 装饰:取option_type=2的那些数据集
    					 * 机电:按main_design_area_name模糊查询(机电)
    					 * 灯光:按main_design_area_name模糊查询(灯光)
    					 * 陈设:按main_design_area_name模糊查询(陈设或软装)
    					 * 平面:按main_design_area_name模糊查询(平面)
    					 * 单价:对应专业的累加金额/累加面积
    					 * 金额占比:对应专业的累加金额/项目总金额
    					 */
    					//初始化单价和金额占比
    					BigDecimal zsPrice = BigDecimal.ZERO;
    					BigDecimal zsPricePercent = BigDecimal.ZERO;
    					BigDecimal jdPrice = BigDecimal.ZERO;
    					BigDecimal jdPricePercent = BigDecimal.ZERO;
    					BigDecimal dgPrice = BigDecimal.ZERO;
    					BigDecimal dgPricePercent = BigDecimal.ZERO;
    					BigDecimal csPrice = BigDecimal.ZERO;
    					BigDecimal csPricePercent = BigDecimal.ZERO;
    					BigDecimal pmPrice = BigDecimal.ZERO;
    					BigDecimal pmPricePercent = BigDecimal.ZERO;
    					//获取装饰的报价单
    					outDao.clear();
    					outDao.setConditionOutQuotationId("=",outQuotationId);
    					outDao.setConditionOptionType("=",2);
    					outList = outDao.conditionalLoad();
    					BigDecimal totalAmountZs = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0){
    						BigDecimal totalArea = BigDecimal.ZERO;
    						for(BaseOutDesignConsideration outBean : outList){
    							totalAmountZs = totalAmountZs.add(BaseHelpUtils.getBigDecimalValue(outBean.getMoneySum()));
    							totalArea = totalArea.add(BaseHelpUtils.getBigDecimalValue(outBean.getDesignArea()));
    						}
    						if(totalAmountZs.compareTo(BigDecimal.ZERO) > 0 && totalArea.compareTo(BigDecimal.ZERO) > 0){
    							zsPrice = totalAmountZs.divide(totalArea,2,BigDecimal.ROUND_DOWN);
    							zsPriceNum = zsPriceNum.add(BigDecimal.ONE);
    							zsPriceTotal = zsPriceTotal.add(zsPrice);
    						}
    						if(totalAmountZs.compareTo(BigDecimal.ZERO) > 0){
    							zsPricePercent = totalAmountZs.multiply(hundred).divide(moneySum, 2,BigDecimal.ROUND_DOWN);
    							zsPricePercentNum = zsPricePercentNum.add(BigDecimal.ONE);
    							zsPricePercentTotal = zsPricePercentTotal.add(zsPricePercent);
    						}
    						avgZsTotalPrice = totalAmountZs;
    					}
    					//获取机电的报价单
    					outDao.setConditionOptionType("=",1);
    					outList = outDao.conditionalLoad(BaseOutDesignConsideration.CS_MAIN_DESIGN_AREA_NAME+" like '%机电%'");
    					BigDecimal totalAmountJd = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0){
    						BigDecimal totalArea = BigDecimal.ZERO;
    						for(BaseOutDesignConsideration outBean : outList){
    							totalAmountJd = totalAmountJd.add(BaseHelpUtils.getBigDecimalValue(outBean.getMoneySum()));
    							totalArea = totalArea.add(BaseHelpUtils.getBigDecimalValue(outBean.getDesignArea()));
    						}
    						if(totalAmountJd.compareTo(BigDecimal.ZERO) > 0 && totalArea.compareTo(BigDecimal.ZERO) > 0){
    							jdPrice = totalAmountJd.divide(totalArea,2,BigDecimal.ROUND_DOWN);
    							jdPriceNum = jdPriceNum.add(BigDecimal.ONE);
    							jdPriceTotal = jdPriceTotal.add(jdPrice);
    						}
    						if(totalAmountJd.compareTo(BigDecimal.ZERO) > 0){
    							jdPricePercent = totalAmountJd.multiply(hundred).divide(moneySum, 2,BigDecimal.ROUND_DOWN);
    							jdPricePercentNum = jdPricePercentNum.add(BigDecimal.ONE);
    							jdPricePercentTotal = jdPricePercentTotal.add(jdPricePercent);
    						}
    						avgJdTotalPrice = totalAmountJd;
    					}
    					//获取灯光的报价单
    					outList = outDao.conditionalLoad(BaseOutDesignConsideration.CS_MAIN_DESIGN_AREA_NAME+" like '%灯光%'");
    					BigDecimal totalAmountDg = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0){
    						BigDecimal totalArea = BigDecimal.ZERO;
    						for(BaseOutDesignConsideration outBean : outList){
    							totalAmountDg = totalAmountDg.add(BaseHelpUtils.getBigDecimalValue(outBean.getMoneySum()));
    							totalArea = totalArea.add(BaseHelpUtils.getBigDecimalValue(outBean.getDesignArea()));
    						}
    						if(totalAmountDg.compareTo(BigDecimal.ZERO) > 0 && totalArea.compareTo(BigDecimal.ZERO) > 0){
    							dgPrice = totalAmountDg.divide(totalArea,2,BigDecimal.ROUND_DOWN);
    							dgPriceNum = dgPriceNum.add(BigDecimal.ONE);
    							dgPriceTotal = dgPriceTotal.add(dgPrice);
    						}
    						if(totalAmountDg.compareTo(BigDecimal.ZERO) > 0){
    							dgPricePercent = totalAmountDg.multiply(hundred).divide(moneySum, 2,BigDecimal.ROUND_DOWN);
    							dgPricePercentNum = dgPricePercentNum.add(BigDecimal.ONE);
    							dgPricePercentTotal = dgPricePercentTotal.add(dgPricePercent);
    						}
    						avgDgTotalPrice = totalAmountDg;
    					}
    					//获取陈设的报价单
    					outList = outDao.conditionalLoad("(main_design_area_name like '%陈设%' or main_design_area_name like '%软装%')");
    					BigDecimal totalAmountCs = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0){
    						BigDecimal totalArea = BigDecimal.ZERO;
    						for(BaseOutDesignConsideration outBean : outList){
    							totalAmountCs = totalAmountCs.add(BaseHelpUtils.getBigDecimalValue(outBean.getMoneySum()));
    							totalArea = totalArea.add(BaseHelpUtils.getBigDecimalValue(outBean.getDesignArea()));
    						}
    						if(totalAmountCs.compareTo(BigDecimal.ZERO) > 0 && totalArea.compareTo(BigDecimal.ZERO) > 0){
    							csPrice = totalAmountCs.divide(totalArea,2,BigDecimal.ROUND_DOWN);
    							csPriceNum = csPriceNum.add(BigDecimal.ONE);
    							csPriceTotal = csPriceTotal.add(csPrice);
    						}
    						if(totalAmountCs.compareTo(BigDecimal.ZERO) > 0){
    							csPricePercent = totalAmountCs.multiply(hundred).divide(moneySum, 2,BigDecimal.ROUND_DOWN);
    							csPricePercentNum = csPricePercentNum.add(BigDecimal.ONE);
    							csPricePercentTotal = csPricePercentTotal.add(csPricePercent);
    						}
    						avgCsTotalPrice = totalAmountCs;
    					}
    					//获取平面的报价单
    					outList = outDao.conditionalLoad(BaseOutDesignConsideration.CS_MAIN_DESIGN_AREA_NAME+" like '%平面%'");
    					BigDecimal totalAmountPm = BigDecimal.ZERO;
    					if(!BaseHelpUtils.isNullOrEmpty(outList) && outList.size() > 0){
    						BigDecimal totalArea = BigDecimal.ZERO;
    						for(BaseOutDesignConsideration outBean : outList){
    							totalAmountPm = totalAmountPm.add(BaseHelpUtils.getBigDecimalValue(outBean.getMoneySum()));
    							totalArea = totalArea.add(BaseHelpUtils.getBigDecimalValue(outBean.getDesignArea()));
    						}
    						if(totalAmountPm.compareTo(BigDecimal.ZERO) > 0 && totalArea.compareTo(BigDecimal.ZERO) > 0){
    							pmPrice = totalAmountPm.divide(totalArea,2,BigDecimal.ROUND_DOWN);
    							pmPriceNum = pmPriceNum.add(BigDecimal.ONE);
    							pmPriceTotal = pmPriceTotal.add(pmPrice);
    						}
    						if(totalAmountPm.compareTo(BigDecimal.ZERO) > 0){
    							pmPricePercent = totalAmountPm.multiply(hundred).divide(moneySum, 2,BigDecimal.ROUND_DOWN);
    							pmPricePercentNum = pmPricePercentNum.add(BigDecimal.ONE);
    							pmPricePercentTotal = pmPricePercentTotal.add(pmPricePercent);
    						}
    						avgPmTotalPrice = totalAmountPm;
    					}
    					//设置单价
    					BigDecimal price = BigDecimal.ZERO;
    					if(moneySum.compareTo(BigDecimal.ZERO) > 0 && area.compareTo(BigDecimal.ZERO) > 0){
    						price = moneySum.divide(area,2,BigDecimal.ROUND_DOWN);
    						avgPriceTotal = avgPriceTotal.add(price);
    						avgHjTotalPrice = avgHjTotalPrice.add(moneySum);
    					}
    					if(maxPrice.compareTo(moneySum) < 0){
    						maxPrice = moneySum;
    						maxZsTotalPrice = totalAmountZs;
    						maxZsPrice = zsPrice;
    						maxZsPricePercent = zsPricePercent;
    						
    						maxJdTotalPrice = totalAmountJd;
    						maxJdPrice = jdPrice;
    						maxJdPricePercent = jdPricePercent;
    						
    						maxDgTotalPrice = totalAmountDg;
    						maxDgPrice = dgPrice;
    						maxDgPricePercent = dgPricePercent;
    						
    						maxCsTotalPrice = totalAmountCs;
    						maxCsPrice = csPrice;
    						maxCsPricePercent = csPricePercent;
    						
    						maxPmTotalPrice = totalAmountPm;
    						maxPmPrice = pmPrice;
    						maxPmPricePercent = pmPricePercent;
    						
    						maxHjTotalPrice = moneySum;
    						maxHjPrice = price;
    						maxHjPricePercent = hundred;
    					}
    					if(minPrice.compareTo(moneySum) > 0 || minPrice.compareTo(BigDecimal.ZERO) == 0){
    						minPrice = moneySum;
    						minZsTotalPrice = totalAmountZs;
    						minZsPrice = zsPrice;
    						minZsPricePercent = zsPricePercent;
    						
    						minJdTotalPrice = totalAmountJd;
    						minJdPrice = jdPrice;
    						minJdPricePercent = jdPricePercent;
    						
    						minDgTotalPrice = totalAmountDg;
    						minDgPrice = dgPrice;
    						minDgPricePercent = dgPricePercent;
    						
    						minCsTotalPrice = totalAmountCs;
    						minCsPrice = csPrice;
    						minCsPricePercent = csPricePercent;
    						
    						minPmTotalPrice = totalAmountPm;
    						minPmPrice = pmPrice;
    						minPmPricePercent = pmPricePercent;
    						
    						minHjTotalPrice = moneySum;
    						minHjPrice = price;
    						minHjPricePercent = hundred;
    					}
    					//获取立项时间
    					Date date = e.getProjectApprovalTime();
    					if(BaseHelpUtils.isNullOrEmpty(compareDate)){
    						compareDate = date;
    						recentPrice = moneySum;
    						recentZsTotalPrice = totalAmountZs;
    						recentZsPrice = zsPrice;
    						recentZsPricePercent = zsPricePercent;

    						recentJdTotalPrice = totalAmountJd;
    						recentJdPrice = jdPrice;
    						recentJdPricePercent = jdPricePercent;
    						
    						recentDgTotalPrice = totalAmountDg;
    						recentDgPrice = dgPrice;
    						recentDgPricePercent = dgPricePercent;
    						
    						recentCsTotalPrice = totalAmountCs;
    						recentCsPrice = csPrice;
    						recentCsPricePercent = csPricePercent;
    						
    						recentPmTotalPrice = totalAmountPm;
    						recentPmPrice = pmPrice;
    						recentPmPricePercent = pmPricePercent;
    						
    						recentHjTotalPrice = moneySum;
    						recentHjPrice = price;
    						recentHjPricePercent = hundred;
    					}else{
    						if(compareDate.before(date)){
    							compareDate = date;
    							recentPrice = moneySum;
    							recentZsTotalPrice = totalAmountZs;
        						recentZsPrice = zsPrice;
        						recentZsPricePercent = zsPricePercent;

        						recentJdTotalPrice = totalAmountJd;
        						recentJdPrice = jdPrice;
        						recentJdPricePercent = jdPricePercent;
        						
        						recentDgTotalPrice = totalAmountDg;
        						recentDgPrice = dgPrice;
        						recentDgPricePercent = dgPricePercent;
        						
        						recentCsTotalPrice = totalAmountCs;
        						recentCsPrice = csPrice;
        						recentCsPricePercent = csPricePercent;
        						
        						recentPmTotalPrice = totalAmountPm;
        						recentPmPrice = pmPrice;
        						recentPmPricePercent = pmPricePercent;
        						
        						recentHjTotalPrice = moneySum;
        						recentHjPrice = price;
        						recentHjPricePercent = hundred;
    						}
    					}
    				}//for循环结束
    				avgHjPrice = avgPriceTotal.divide(BigDecimal.valueOf(size),2,BigDecimal.ROUND_DOWN);
    				avgHjTotalPrice = avgHjTotalPrice.divide(BigDecimal.valueOf(size),2,BigDecimal.ROUND_DOWN);
    				avgHjPricePercent = hundred;
    				if(zsPriceNum.compareTo(BigDecimal.ZERO)>0)avgZsTotalPrice = avgZsTotalPrice.divide(zsPriceNum,2,BigDecimal.ROUND_DOWN);
    				if(jdPriceNum.compareTo(BigDecimal.ZERO)>0)avgJdTotalPrice = avgJdTotalPrice.divide(jdPriceNum,2,BigDecimal.ROUND_DOWN);
    				if(dgPriceNum.compareTo(BigDecimal.ZERO)>0)avgDgTotalPrice = avgDgTotalPrice.divide(dgPriceNum,2,BigDecimal.ROUND_DOWN);
    				if(csPriceNum.compareTo(BigDecimal.ZERO)>0)avgCsTotalPrice = avgCsTotalPrice.divide(csPriceNum,2,BigDecimal.ROUND_DOWN);
    				if(pmPriceNum.compareTo(BigDecimal.ZERO)>0)avgPmTotalPrice = avgPmTotalPrice.divide(pmPriceNum,2,BigDecimal.ROUND_DOWN);
    				
    				if(zsPriceNum.compareTo(BigDecimal.ZERO) > 0){
    					avgZsPrice = zsPriceTotal.divide(zsPriceNum,2,BigDecimal.ROUND_DOWN);
    				}
    				if(zsPricePercentNum.compareTo(BigDecimal.ZERO) > 0){
    					avgZsPricePercent = zsPricePercentTotal.divide(zsPricePercentNum,2,BigDecimal.ROUND_DOWN);
    				}
    				
    				if(jdPriceNum.compareTo(BigDecimal.ZERO) > 0){
    					avgJdPrice = jdPriceTotal.divide(jdPriceNum,2,BigDecimal.ROUND_DOWN);
    				}
    				if(jdPricePercentNum.compareTo(BigDecimal.ZERO) > 0){
    					avgJdPricePercent = jdPricePercentTotal.divide(jdPricePercentNum,2,BigDecimal.ROUND_DOWN);
    				}
    				
    				if(dgPriceNum.compareTo(BigDecimal.ZERO) > 0){
    					avgDgPrice = dgPriceTotal.divide(dgPriceNum,2,BigDecimal.ROUND_DOWN);
    				}
    				if(dgPricePercentNum.compareTo(BigDecimal.ZERO) > 0){
    					avgDgPricePercent = dgPricePercentTotal.divide(dgPricePercentNum,2,BigDecimal.ROUND_DOWN);
    				}
    				
    				if(csPriceNum.compareTo(BigDecimal.ZERO) > 0){
    					avgCsPrice = csPriceTotal.divide(csPriceNum,2,BigDecimal.ROUND_DOWN);
    				}
    				if(csPricePercentNum.compareTo(BigDecimal.ZERO) > 0){
    					avgCsPricePercent = csPricePercentTotal.divide(csPricePercentNum,2,BigDecimal.ROUND_DOWN);
    				}
    				
    				if(pmPriceNum.compareTo(BigDecimal.ZERO) > 0){
    					avgPmPrice = pmPriceTotal.divide(pmPriceNum,2,BigDecimal.ROUND_DOWN);
    				}
    				if(pmPricePercentNum.compareTo(BigDecimal.ZERO) > 0){
    					avgPmPricePercent = pmPricePercentTotal.divide(pmPricePercentNum,2,BigDecimal.ROUND_DOWN);
    				}
    				//设置最高报价、最低报价、平均单价和最近报价
    				Map<String,BigDecimal> map = new HashMap<>();
    				map.put("maxPrice",maxPrice);
    				map.put("minPrice",minPrice);
    				map.put("avgPrice",avgPrice);
    				map.put("recentPrice",recentPrice);
    				//最高报价模块***********************************
    				map.put("maxZsTotalPrice",maxZsTotalPrice);
    				map.put("maxZsPrice",maxZsPrice);
    				map.put("maxZsPricePercent",maxZsPricePercent);
    				
    				map.put("maxJdTotalPrice",maxJdTotalPrice);
    				map.put("maxJdPrice",maxJdPrice);
    				map.put("maxJdPricePercent",maxJdPricePercent);
    				
    				map.put("maxDgTotalPrice",maxDgTotalPrice);
    				map.put("maxDgPrice",maxDgPrice);
    				map.put("maxDgPricePercent",maxDgPricePercent);
    				
    				map.put("maxCsTotalPrice",maxCsTotalPrice);
    				map.put("maxCsPrice",maxCsPrice);
    				map.put("maxCsPricePercent",maxCsPricePercent);
    				
    				map.put("maxPmTotalPrice",maxPmTotalPrice);
    				map.put("maxPmPrice",maxPmPrice);
    				map.put("maxPmPricePercent",maxPmPricePercent);
    				
    				map.put("maxHjTotalPrice",maxHjTotalPrice);
    				map.put("maxHjPrice",maxHjPrice);
    				map.put("maxHjPricePercent",maxHjPricePercent);
    				
    				//最低报价模块***********************************
    				map.put("minZsTotalPrice",minZsTotalPrice);
    				map.put("minZsPrice",minZsPrice);
    				map.put("minZsPricePercent",minZsPricePercent);
    				
    				map.put("minJdTotalPrice",minJdTotalPrice);
    				map.put("minJdPrice",minJdPrice);
    				map.put("minJdPricePercent",minJdPricePercent);
    				
    				map.put("minDgTotalPrice",minDgTotalPrice);
    				map.put("minDgPrice",minDgPrice);
    				map.put("minDgPricePercent",minDgPricePercent);
    				
    				map.put("minCsTotalPrice",minCsTotalPrice);
    				map.put("minCsPrice",minCsPrice);
    				map.put("minCsPricePercent",minCsPricePercent);
    				
    				map.put("minPmTotalPrice",minPmTotalPrice);
    				map.put("minPmPrice",minPmPrice);
    				map.put("minPmPricePercent",minPmPricePercent);
    				
    				map.put("minHjTotalPrice",minHjTotalPrice);
    				map.put("minHjPrice",minHjPrice);
    				map.put("minHjPricePercent",minHjPricePercent);
    				
    				
    				//平均报价模块***********************************
    				map.put("avgZsTotalPrice",avgZsTotalPrice);
    				map.put("avgZsPrice",avgZsPrice);
    				map.put("avgZsPricePercent",avgZsPricePercent);
    				
    				map.put("avgJdTotalPrice",avgJdTotalPrice);
    				map.put("avgJdPrice",avgJdPrice);
    				map.put("avgJdPricePercent",avgJdPricePercent);
    				
    				map.put("avgDgTotalPrice",avgDgTotalPrice);
    				map.put("avgDgPrice",avgDgPrice);
    				map.put("avgDgPricePercent",avgDgPricePercent);
    				
    				map.put("avgCsTotalPrice",avgCsTotalPrice);
    				map.put("avgCsPrice",avgCsPrice);
    				map.put("avgCsPricePercent",avgCsPricePercent);
    				
    				map.put("avgPmTotalPrice",avgPmTotalPrice);
    				map.put("avgPmPrice",avgPmPrice);
    				map.put("avgPmPricePercent",avgPmPricePercent);
    				
    				map.put("avgHjTotalPrice",avgHjTotalPrice);
    				map.put("avgHjPrice",avgHjPrice);
    				map.put("avgHjPricePercent",avgHjPricePercent);
    				
    				
    				//最近报价模块***********************************
    				map.put("recentZsTotalPrice",recentZsTotalPrice);
    				map.put("recentZsPrice",recentZsPrice);
    				map.put("recentZsPricePercent",recentZsPricePercent);
    				
    				map.put("recentJdTotalPrice",recentJdTotalPrice);
    				map.put("recentJdPrice",recentJdPrice);
    				map.put("recentJdPricePercent",recentJdPricePercent);
    				
    				map.put("recentDgTotalPrice",recentDgTotalPrice);
    				map.put("recentDgPrice",recentDgPrice);
    				map.put("recentDgPricePercent",recentDgPricePercent);
    				
    				map.put("recentCsTotalPrice",recentCsTotalPrice);
    				map.put("recentCsPrice",recentCsPrice);
    				map.put("recentCsPricePercent",recentCsPricePercent);
    				
    				map.put("recentPmTotalPrice",recentPmTotalPrice);
    				map.put("recentPmPrice",recentPmPrice);
    				map.put("recentPmPricePercent",recentPmPricePercent);
    				
    				map.put("recentHjTotalPrice",recentHjTotalPrice);
    				map.put("recentHjPrice",recentHjPrice);
    				map.put("recentHjPricePercent",recentHjPricePercent);
    				result.setUserData(map);
    				result.setCollections(list);
    			}
    		}
    	}
    	return result.toJSON(0,"");
    }
    
    /**
     * 营收统计加锁
     * @param param
     * @return
     * @throws SQLException
     */
    public String onRevenueStatisticalLock(Map<String, Object> param) throws SQLException{
    	//获取年月份
    	int year = BaseHelpUtils.getIntValue(param, "year");
    	int month = BaseHelpUtils.getIntValue(param, "month");
    	//获取操作人
    	int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
    	if(year == 0){
    		throw new SQLException("操作异常:加锁年份不可为空");
    	}
    	if(month == 0){
    		throw new SQLException("操作异常:加锁月份不可为空");
    	}
    	RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
    	dao.setConditionYear("=",year);
    	dao.setConditionMonth("=",month);
    	dao.setConditionIsLocked("=",Boolean.TRUE);
    	if(dao.isExist()){
    		throw new SQLException("操作异常:当前年月份数据已加锁过,无需再进行重复操作");
    	}else{
    		dao.clear();
    		dao.setConditionYear("=",year);
        	dao.setConditionMonth("=",month);
    		dao.setIsLocked(Boolean.TRUE);
    		dao.setOperateEmployeeId(operateEmployeeId);
    		dao.setOperateTime(new Date());
    		dao.conditionalUpdate();
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 落标订单保存
     * @param param
     * @return
     * @throws Exception 
     */
    public String onBidPaySheetProjectSave(Map<String, Object> param) throws Exception{
    	//获取合同ID
    	int contractId = BaseHelpUtils.getIntValue(param, "contractId");
    	if(contractId == 0){
    		throw new SQLException("操作异常:合同不可为空");
    	}
    	//获取主项目表ID
    	int mainProjectId = BaseHelpUtils.getIntValue(param, "mainProjectId");
    	if(mainProjectId == 0){
    		throw new SQLException("操作异常:主项目表ID不可为空");
    	}
    	//获取投标金额
    	BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(param.get("signingMoneySum"));
    	if(signingMoneySum.compareTo(BigDecimal.ZERO) <= 0){
    		throw new SQLException("操作异常:该项目的投标金额不可小于或等于0");
    	}
    	ThreadConnection.beginTransaction();
    	//主表更新
    	MainProject mDao = new MainProject();
    	mDao.setMainProjectId(mainProjectId);
    	if(mDao.load()){
    		BaseMainProject mBean = new BaseMainProject();
    		mBean.setDataFromMap(param);
    		mBean.setProjectCode(null);//不做更新
    		mBean.setProjectName(null);//不做更新
    		mBean.setBidType(3);
    		mDao.setDataFromBase(mBean);
    		mDao.update();
    		//更新合同的合同金额
    		Contract cDao = new Contract();
    		cDao.setContractId(contractId);
    		if(cDao.load()){
    			cDao.setSigningMoneySum(signingMoneySum);
    			cDao.update();
    		}
    		//获取落标补偿金，給到项目组进行积分的确认
    		//获取项目ID
//    		int projectId = BaseHelpUtils.getIntValue(param, "projectId");
			Project dao = new Project();
    		List<BaseProject> projectRecords = (List<BaseProject>) param.get("projectRecords");
    		if(!BaseHelpUtils.isNullOrEmpty(projectRecords)&&projectRecords.size()>0) {
    			for (BaseProject baseProject : projectRecords) {
    				int projectId = BaseHelpUtils.getIntValue(baseProject.getProjectId());
    				if(projectId<=0) {
    					continue;
    				}
    		   		//企业微信通知
    	    		dao.clear();
    	    		dao.setConditionProjectId("=", projectId);
    	    		BaseProject executeQueryOneRow = dao.executeQueryOneRow();
    	    		mDao.clear();
    	    		mDao.setConditionMainProjectId("=", mainProjectId);
    	    		BaseMainProject executeQueryOneRow2 = mDao.executeQueryOneRow();
    	    		if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow)) {
    	    			if(!BaseHelpUtils.isNullOrEmpty(executeQueryOneRow.getProjectManageId())&&executeQueryOneRow.getProjectManageId()>0) {
    	    				Employee edao =new Employee();
    	    				Integer projectManageId = executeQueryOneRow.getProjectManageId();
    	    				edao.setConditionEmployeeId("=", projectManageId);
    	    				edao.setConditionStatus("=", 0);
    	    				BaseEmployee projectManage = edao.executeQueryOneRow();
    	    				//在职
    	    				if(!BaseHelpUtils.isNullOrEmpty(projectManage)) {
    	    					ERPWeixinUtils.sendWXMsgToUser(projectManageId, "项目编号("+executeQueryOneRow2.getProjectCode()+")的"+ executeQueryOneRow2.getProjectName()+"项目落标补偿已下达");
    	    				}else {
    	    					Integer plateId = executeQueryOneRow.getPlateId();
    	    					PlateRecord pdao =new PlateRecord();
    	    					pdao.setConditionPlateId("=", plateId);
    	    					BasePlateRecord plate = pdao.executeQueryOneRow();
    	    					if(!BaseHelpUtils.isNullOrEmpty(plate)) {
    	    						Integer plateManagerId = plate.getPlateManagerId();
    	    						ERPWeixinUtils.sendWXMsgToUser(plateManagerId,"项目编号("+executeQueryOneRow2.getProjectCode()+")的"+ executeQueryOneRow2.getProjectName()+"项目落标补偿已下达");
    	    					}
    	    				}
    	    			}
    	    		}
				}
    		}
			
    		//修改合同和相关订单的状态为落标，同时保存合同状态变动日志
    		ContractStatusUtils util = new ContractStatusUtils();
    		util.updateContractAndProjectStatus(contractId, StaticUtils.CONTRACT_STATUS_2);
    		ContractLog logDao = new ContractLog();
    		logDao.setContractId(contractId);
    		logDao.setOriginalStatus(cDao.getContractStatus());
    		logDao.setNewStatus(StaticUtils.CONTRACT_STATUS_2);
    		logDao.setOperator(BaseHelpUtils.getIntValue(param.get("operator")));
    		logDao.setOperateTime(new Date());
    		logDao.save();
    	}else{
    		throw new SQLException("操作异常:主项目表未加载到信息");
    	}
		ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 中标订单保存
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onBidSheetProjectSave(Map<String, Object> param) throws SQLException{
    	//获取合同ID
    	int contractId = BaseHelpUtils.getIntValue(param, "contractId");
    	if(contractId == 0){
    		throw new SQLException("操作异常:合同不可为空");
    	}
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	if(plateId == 0){
    		throw new SQLException("操作异常:业务部门不可为空");
    	}
    	//获取业务类别
    	int businessType = BaseHelpUtils.getIntValue(param, "businessType");
    	if(businessType == 0){
    		throw new SQLException("操作异常:业务类别不可为空");
    	}
    	//获取项目类别
    	int projectType = BaseHelpUtils.getIntValue(param, "projectType");
    	if(projectType == 0){
    		throw new SQLException("操作异常:项目类别不可为空");
    	}
    	//获取投标金额
    	BigDecimal signingMoneySum = BaseHelpUtils.getBigDecimalValue(param.get("signingMoneySum"));
    	if(signingMoneySum.compareTo(BigDecimal.ZERO) <= 0){
    		throw new SQLException("操作异常:该项目的投标金额不可小于或等于0");
    	}
    	//获取订单编号
    	String sheetCode = BaseHelpUtils.getStringValue(param, "contractCode");
    	ThreadConnection.beginTransaction();

		Project dao = new Project();
    	//检索该订单编号是否存在，如果存在则返回
    	dao.setConditionContractCode("=",sheetCode);
    	if(dao.countRows() > 0){//说明存在
    		throw new SQLException("操作异常:该项目的订单编号已经存在");
    	}
    	//更新合同的合同金额，即投标金额
    	Contract cDao = new Contract();
    	cDao.setContractId(contractId);
    	if(cDao.load()){
    		cDao.setSigningMoneySum(signingMoneySum);
    		cDao.update();
    	}else{
    		throw new SQLException("操作异常:未加载到合同信息");
    	}
    	BaseProject bean = new BaseProject();
		bean.setDataFromMap(param);
    	//向子合同中加入一天数据
    	SubContract sDao = new SubContract();
    	BaseSubContract sBean = new BaseSubContract();
    	sBean.setDataFromMap(param);
    	sBean.setParentId(contractId);
    	sBean.setDepartmentId(plateId);
    	sBean.setSubContractCode(bean.getContractCode());
    	sBean.setSubContractName(bean.getProjectName());
    	sBean.setComplaintPercentage(BigDecimal.ZERO);
    	sBean.setCreateTime(new Date());
    	sDao.setDataFromBase(sBean);
    	sDao.save();
    	int subContractId = sDao.getSubContractId();
    	bean.setSubContractId(subContractId);
    	bean.setPercentage(BigDecimal.ZERO);
    	bean.setComplaintPercentage(BigDecimal.ZERO);
    	bean.setCreateTime(new Date());
    	bean.setRevenuePlateId(bean.getPlateId());
    	dao.clear();
    	dao.setDataFromBase(bean);
    	dao.save();
    	int projectId = dao.getProjectId();

		//给订单新增一个提点的系数用于营销提成的计算
		MarketingCommission marketingCommission = new MarketingCommission();
		BigDecimal rate = marketingCommission.setProjectRateByProjectId(projectId);
		BaseProject baseProject = dao.generateBase();
		baseProject.setCommissionRate(rate);
		dao.clear();
		dao.setDataFromBase(baseProject);
		dao.update();

		//插入一个投标全阶段
    	ProjectStage psDao = new ProjectStage();
    	psDao.setProjectId(projectId);
    	psDao.setStageId(32);
    	psDao.setStageName("投标全阶段");
    	psDao.setPercent(new BigDecimal(100));
    	psDao.setProjectAmount(BigDecimal.ZERO);
    	psDao.save();
		ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 获取订单编号
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onGetProjectCode(Map<String, Object> param) throws SQLException{
    	//获取合同ID
    	int contractId = BaseHelpUtils.getIntValue(param, "contractId");
    	if(contractId == 0){
    		throw new SQLException("操作异常:合同不可为空");
    	}
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	if(plateId == 0){
    		throw new SQLException("操作异常:业务部门不可为空");
    	}
    	//获取业务类别
    	int businessType = BaseHelpUtils.getIntValue(param, "businessType");
    	if(businessType == 0){
    		throw new SQLException("操作异常:业务类别不可为空");
    	}
    	//获取项目类别
    	int projectType = BaseHelpUtils.getIntValue(param, "projectType");
    	if(projectType == 0){
    		throw new SQLException("操作异常:项目类别不可为空");
    	}
    	//初始化订单编号为空
    	String sheetCode = "";
    	Contract cDao = new Contract();
    	cDao.setContractId(contractId);
    	if(cDao.load()){
    		//获取合同编号
    		String contractCode = cDao.getContractCode();
    		//根据业务部门获取业务部门编码
    		PlateRecord dao = new PlateRecord();
    		dao.setConditionPlateId("=",plateId);
    		BasePlateRecord bean = dao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(bean)){
    			//获取业务部门编码
    			String plateCode = bean.getPlateCode();
    			sheetCode = String.format("%1$s.%2$s-%3$s-%4$s", contractCode,String.format("%02d",businessType),String.format("%02d",projectType),plateCode);
    		}
    	}else{
    		throw new SQLException("操作异常:未检索到合同信息");
    	}
    	Map<String,String> map = new HashMap<>();
    	map.put("sheetCode",sheetCode);
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	bc.setUserData(map);
    	return bc.toJSON(0,"");
    }
    
    /**
     * 项目绩效积分确认
     * @param param
     * @return
     * @throws SQLException 
     */
    @SuppressWarnings({ "unchecked" })
	public String onSaveProjectPerformance(Map<String, Object> param) throws SQLException{
    	ThreadConnection.beginTransaction();
    	//获取项目ID
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	Project dao = new Project();
    	dao.setProjectId(projectId);
    	if(!dao.load()){
    		throw new SQLException("操作异常:项目ID加载有误");
    	}
    	String sheetName = dao.getProjectName();
    	String sheetCode = dao.getContractCode();
    	//获取项目绩效表主键ID
    	int projectPerformanceId = BaseHelpUtils.getIntValue(param, "projectPerformanceId");
    	if(projectPerformanceId == 0){
    		throw new SQLException("操作异常:项目绩效主键ID加载有误");
    	}
    	//获取绩效类型:1:扣除;2:奖励
    	int performanceFlag = BaseHelpUtils.getIntValue(param, "performanceFlag");
    	//获取操作人呢
    	int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
    	//获取备注
    	String remark = BaseHelpUtils.getStringValue(param, "remark");
    	//更新项目绩效表数据为已计算
    	ProjectPerformance ppDao = new ProjectPerformance();
    	ppDao.setProjectPerformanceId(projectPerformanceId);
    	if(ppDao.load()){
    		ppDao.setIsSettlement(Boolean.TRUE);
    		ppDao.update();
    		Date recordDate = new Date();
    		//获取本次计算的总积分
    		BigDecimal integral = ppDao.getIntegral();
    		//插入项目绩效结算总表数据
    		ProjectPerformanceSettlement ppsDao = new ProjectPerformanceSettlement();
    		ppsDao.setProjectId(projectId);
    		ppsDao.setPerformanceFlag(performanceFlag);
    		ppsDao.setIntegral(integral);
    		ppsDao.setRecordDate(recordDate);
    		ppsDao.setOperateEmployeeId(operateEmployeeId);
    		ppsDao.setOperateTime(recordDate);
    		ppsDao.setRemark(remark);
    		ppsDao.save();
    		//获取总表主键ID
    		int projectPerformanceSettlementId = ppsDao.getProjectPerformanceSettlementId();
    		//插入项目绩效详情表
			List<BaseOnLoadProjectEmployeePerformance> list = GenericBase.__getList(param.get("projectPerformanceEmployees"),BaseOnLoadProjectEmployeePerformance.newInstance());
			if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
				ProjectPerformanceSettlementDetail ppsdDao = new ProjectPerformanceSettlementDetail();
				BaseProjectPerformanceSettlementDetail ppsdBean = null;
				for(BaseOnLoadProjectEmployeePerformance e : list){
					int status = e.getStatus();
					if(status == 0){//只保存在职人员的数据
						//获取积分
						BigDecimal performanceIntegral = e.getIntegral()==null?BigDecimal.ZERO:e.getIntegral();
						if(performanceIntegral.compareTo(BigDecimal.ZERO) > 0){
							ppsdBean = new BaseProjectPerformanceSettlementDetail();
							int employeeId = e.getEmployeeId();
							ppsdBean.setProjectPerformanceSettlementId(projectPerformanceSettlementId);
							ppsdBean.setProjectId(projectId);
							ppsdBean.setEmployeeId(employeeId);
							ppsdBean.setRecordDate(recordDate);
							ppsdBean.setIntegral(performanceIntegral);
							ppsdBean.setPerformanceFlag(performanceFlag);
							ppsdBean.setOperateEmployeeId(operateEmployeeId);
							ppsdBean.setOperateTime(recordDate);
							ppsdBean.setRemark(remark);
							ppsdDao.clear();
							ppsdDao.setDataFromBase(ppsdBean);
							ppsdDao.save();
							int businessId = ppsdDao.getProjectPerformanceSettlementDetailId();
							//入个人账户
							if(performanceFlag == 1){//说明是绩效扣除
								remark = String.format("本次结算来自项目(%1$s(编号:%2$s))绩效扣除", sheetName,sheetCode);
								AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE_PAY, performanceIntegral, recordDate, remark, operateEmployeeId);
							}else if(performanceFlag == 2){//说明是绩效奖励
								remark = String.format("本次结算来自项目(%1$s(编号:%2$s))绩效奖励", sheetName,sheetCode);
								AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_PROJECT_PERFORMANCE, performanceIntegral, recordDate, remark, operateEmployeeId);
							}
						}
					}
					
				}
			}
    	}else{
    		throw new SQLException("操作异常:项目绩效数据加载失败");
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 设计师同意或驳回项目经理分配负分給他的操作
     * @param param
     * @return
     * @throws SQLException 
     */
    public String onDesignerAgreeOrBack(Map<String, Object> param) throws SQLException{
    	//获取项目ID
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	if(projectId == 0){
    		throw new SQLException("操作异常:未获取到项目信息");
    	}
    	Project dao = new Project();
    	dao.setProjectId(projectId);
    	boolean isHave = dao.load();
		if (!isHave) {
			throw new SQLException("操作异常:没有这个项目");
		}
    	//获取职员ID
    	int employeeId = BaseHelpUtils.getIntValue(param, "employeeId");
    	if(employeeId == 0){
    		throw new SQLException("操作异常:未获取到职员信息");
    	}
    	//获取结算状态
    	int settlementStatus = BaseHelpUtils.getIntValue(param, "settlementStatus");
    	ThreadConnection.beginTransaction();
    	//检索该职员在该项目处于待确认的数据
    	ProjectSettlementDetail psdDao = new ProjectSettlementDetail();
    	psdDao.setConditionProjectId("=",projectId);
    	psdDao.setConditionEmployeeId("=",employeeId);
    	psdDao.setConditionSettlementStatus("=",1);//处于待确认状态的数据
    	//如果是驳回，则更新当前结算状态为驳回
    	BaseProjectSettlementDetail psdBean = psdDao.executeQueryOneRow();
    	int settlementId = 0;
    	if(!BaseHelpUtils.isNullOrEmpty(psdBean)){
    		//获取这一次结算的总表主键ID
    		settlementId = psdBean.getSettlementId();
    	}
    	psdDao.setSettlementStatus(settlementStatus);
    	psdDao.conditionalUpdate();
    	ProjectSettlement psDao = new ProjectSettlement();
    	ProjectCost pcDao = new ProjectCost();
    	if(settlementStatus == 3){//说明是驳回
    		psDao.setSettlementId(settlementId);
    		if(psDao.load()){
    			BigDecimal totalIntegral = psDao.getTotalAmount();
    			BigDecimal leftIntegral = psDao.getLeftAmount().add(totalIntegral);
    			psDao.setLeftAmount(leftIntegral);
    			psDao.setSettlementStatus(settlementStatus);
    			psDao.update();
    		}
    		//更新项目成本为驳回状态
    		pcDao.setConditionProjectId("=",projectId);
    		pcDao.setConditionSettlementStatus("=",1);//只检索待确认的数据集
    		pcDao.setSettlementStatus(settlementStatus);
    		pcDao.conditionalUpdate();
    		
    		psdDao.clear();
    		psdDao.setConditionSettlementId("=",settlementId);
    		psdDao.setSettlementStatus(settlementStatus);
    		psdDao.conditionalUpdate();
    		
    	}else if(settlementStatus == 2){//说明是同意
    		//如果是同意，检索是否为最后一人同意，如果是最后一人的同意的话，则更新这一次所有人员的操作都同意流转下去
    		//先检索是否有驳回的
    		psdDao.clear();
    		psdDao.setConditionSettlementId("=",settlementId);
        	psdDao.setConditionEmployeeId("<>",employeeId);
        	psdDao.setConditionSettlementStatus("=",3);//处于驳回
        	if(psdDao.countRows() == 0){//说明没有驳回
        		//再检索是否还有别人未同意
        		psdDao.clear();
        		psdDao.setConditionSettlementId("=",settlementId);
            	psdDao.setConditionEmployeeId("<>",employeeId);
            	psdDao.setConditionSettlementStatus("=",1);//处于待确认
            	if(psdDao.countRows() == 0){//说明没有待确认了，则更改总表的结算状态，项目成本的结算状态，以及入相关账户
            		//更新结算总表的结算状态为已确认
            		psDao.clear();
            		psDao.setSettlementId(settlementId);
            		if(psDao.load()){
            			psDao.setSettlementStatus(2);//已确认
            			psDao.update();
            		}
            		//更新项目成本表的数据集
            		pcDao.clear();
            		pcDao.setConditionProjectId("=",projectId);
            		pcDao.setConditionSettlementStatus("=",1);
            		pcDao.setSettlementStatus(2);
            		pcDao.setStatus(1);//设置为已计算
            		pcDao.conditionalUpdate();
            		//计算部门上可确认的积分=当次结算的总的确认积分/项目积分*预留积分
            		BigDecimal accountReserveIntegral = BigDecimal.ZERO;
            		//获取项目积分
            		BigDecimal projectIntegral = dao.getProjectIntegral()==null?BigDecimal.ZERO:dao.getProjectIntegral();
            		//获取预留积分
            		BigDecimal reserveIntegral = dao.getReserveIntegral()==null?BigDecimal.ZERO:dao.getReserveIntegral();
            		//获取这一次总的确认积分
            		BigDecimal totalAmountToSettle = psDao.getTotalAmount()==null?BigDecimal.ZERO:psDao.getTotalAmount();
            		//获取结算日期
            		Date settlementDate = psDao.getSettlementDate();
            		//获取阶段ID
            		int stageId = psDao.getStageId();
            		//获取备注
            		String settlementRemark = psDao.getRemark();
            		// 获取当前项目归属部门id
            		int plateId = BaseHelpUtils.getIntValue(dao.getPlateId());
            		// 只有当次结算的确认积分不为0和项目总积分不为0时，方可记录这一次结算的预留积分
            		if (projectIntegral.compareTo(BigDecimal.ZERO) != 0) {
            			accountReserveIntegral = totalAmountToSettle.multiply(reserveIntegral).divide(projectIntegral,2,BigDecimal.ROUND_DOWN);
            			if(accountReserveIntegral.compareTo(BigDecimal.ZERO) != 0){
            				// 往部门项目的结算预留积分的记录表中插入一条记录
            				PlateProjectAccountRecord plateProjectAccountRecordDao = new PlateProjectAccountRecord();
            				plateProjectAccountRecordDao.setPlateId(plateId);
            				plateProjectAccountRecordDao.setProjectId(projectId);
            				plateProjectAccountRecordDao.setAccountIntegral(accountReserveIntegral);
            				plateProjectAccountRecordDao.setAccountDate(settlementDate);
            				plateProjectAccountRecordDao.setStageId(stageId);
            				plateProjectAccountRecordDao.setRemark(settlementRemark);
            				plateProjectAccountRecordDao.save();
            				int businessId = plateProjectAccountRecordDao.getPlateProjectAccountRecordId();
            				//往部门账户表中插入数据
            				AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_SURE_INTEGRAL, accountReserveIntegral, settlementDate, settlementRemark, -1);
            			}
            		}
            		//检索项目成员，并入个人账户
            		psdDao.clear();
            		psdDao.setConditionSettlementId("=",settlementId);
            		List<BaseProjectSettlementDetail> psdList = psdDao.conditionalLoad();
            		if(!BaseHelpUtils.isNullOrEmpty(psdList) && psdList.size() > 0){
            			for(BaseProjectSettlementDetail e : psdList){
            				//获取职员id
            				int empId = e.getEmployeeId();
            				//获取确认积分
            				BigDecimal realIntegral = e.getRealAmount()==null?BigDecimal.ZERO:e.getRealAmount();
            				//获取项目成本
            				BigDecimal projectCost = e.getProjectCost()==null?BigDecimal.ZERO:e.getProjectCost();
            				//获取主键ID，即业务ID
        					int businessId = e.getSettlementDetailId();
        					//确认积分插入个人账户表
        					if(realIntegral.compareTo(BigDecimal.ZERO) != 0){
        						AccountManageProcess.onSaveEmployeeAccount(empId, businessId, AccountManageProcess.EMP_BT_SURE_INTEGRAL, realIntegral, settlementDate, settlementRemark, -1);
        					}
        					if(projectCost.compareTo(BigDecimal.ZERO)>0){
        						//项目成本插入个人账户表
        						AccountManageProcess.onSaveEmployeeAccount(empId, businessId, AccountManageProcess.EMP_BT_PROJECT_COST, projectCost, settlementDate, settlementRemark, -1);
        					}else if(projectCost.compareTo(BigDecimal.ZERO)<0){
        						throw new SQLException("项目成本不可为负数");
        					}
            			}
            		}
            		//根据该项目归属的合同完工百分比，去自动计算该合同下的项目管理费的积分确认值(即給到大项目经理的数据集)
            		ProjectAccount pa = new ProjectAccount();
        			pa.onSettlementProjectManageIntegral(projectId, employeeId, settlementRemark);
            	}
        	}
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	return bc.toJSON(0,"");
    }
    
    /**
     * 项目合同变更积分不够减分摊保存
     * @param param
     * @return
     * @throws SQLException
     */
    @SuppressWarnings({ "unchecked" })
	public String onProjectContractSave(Map<String, Object> param) throws SQLException{
    	ThreadConnection.beginTransaction();
    	//获取项目ID
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	if(projectId == 0){//说明未获取到项目，则抛出异常
    		throw new SQLException("操作异常：未检索到项目");
    	}
    	//获取部门分摊积分
    	BigDecimal plateIntegral = BaseHelpUtils.getBigDecimalValue(param.get("plateIntegral"));
    	//获取操作人
    	int operateEmployeeId = BaseHelpUtils.getIntValue(param, "operateEmployeeId");
    	//获取备注信息
    	String remark = BaseHelpUtils.getStringValue(param, "remark");
    	//获取成员列表数据
    	List<BaseOnLoadProjectChangeEmployee> projectEmployees = GenericBase.__getList(param.get("projectChangeEmployeeList"),
    			BaseOnLoadProjectChangeEmployee.newInstance());
    	//更新项目合同变更表
    	ProjectContractChange pccDao = new ProjectContractChange();
    	pccDao.setConditionProjectId("=",projectId);
    	BaseProjectContractChange pccBean = pccDao.executeQueryOneRow();
    	if(!BaseHelpUtils.isNullOrEmpty(pccBean)){
    		//加载项目信息
    		Project pDao = new Project();
    		pDao.unsetSelectFlags();
    		pDao.setSelectContractCode(true);
    		pDao.setSelectProjectName(true);
    		pDao.setProjectId(projectId);
    		if(pDao.load()) {
    			//获取项目编号和名称
    			String projectCode = BaseHelpUtils.getString(pDao.getContractCode());
    			String projectName = BaseHelpUtils.getString(pDao.getProjectName());
    			//注：来自xxx(xxx)的合同变更扣减积分
    			remark = String.format("%1$s 注：来自%2$s(%3$s)的合同变更扣减积分", remark,projectName,projectCode);
    		}
    		pccDao.setPlateIntegral(plateIntegral);
    		pccDao.setIsCompleted(Boolean.TRUE);
    		pccDao.conditionalUpdate();
    		//设置操作日期为默认当前系统日期
    		Date recordDate = new Date();
    		//如果部门承担积分不为0，则入部门账户
    		//获取主键ID
    		int projectContractChangeId = pccBean.getProjectContractChangeId();
    		if(plateIntegral.compareTo(BigDecimal.ZERO) > 0){
    			//获取业务部门ID
    			int plateId = pccBean.getPlateId();
    			if(plateId == 0){
    				throw new SQLException("分摊的业务部门不可为空");
    			}
    			AccountManageProcess.onSavePlateAccount(plateId, projectContractChangeId, AccountManageProcess.PLATE_BT_CONTRACT_CHANGE, plateIntegral, recordDate,remark, operateEmployeeId);
    		}
    		
    		//检索看项目成员是否有分摊成本
    		if(!BaseHelpUtils.isNullOrEmpty(projectEmployees) && projectEmployees.size() > 0){
    			ProjectContractEmployee pceDao = new ProjectContractEmployee();
    			BaseProjectContractEmployee pceBean =null;
    			for(BaseOnLoadProjectChangeEmployee e : projectEmployees){
    				//获取成员分摊积分
    				BigDecimal integral = e.getIntegral()==null?BigDecimal.ZERO:e.getIntegral();
    				if(integral.compareTo(BigDecimal.ZERO) > 0){//说明该成员有分摊积分，则保存表和入个人账户
    					int employeeId = e.getEmployeeId();
    					pceBean = new BaseProjectContractEmployee();
    					pceBean.setProjectContractChangeId(projectContractChangeId);
    					pceBean.setProjectId(projectId);
    					pceBean.setEmployeeId(employeeId);
    					pceBean.setIntegral(integral);
    					pceBean.setRecordDate(recordDate);
    					pceBean.setOperateEmployeeId(operateEmployeeId);
    					pceBean.setOperateTime(recordDate);
    					pceBean.setRemark(remark);
    					pceDao.clear();
    					pceDao.setDataFromBase(pceBean);
    					pceDao.save();
    					int businessId = pceDao.getProjectContractEmployeeId();
    					//保存个人账户表
    					AccountManageProcess.onSaveEmployeeAccount(employeeId, businessId, AccountManageProcess.EMP_BT_CONTRACT_CHANGE, integral, recordDate, remark, operateEmployeeId);
    				}
    			}
    		}
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    /**
     * 订单拆分
     * @return
     * @throws Exception
     */
    public String onSheetBreak(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(param.get("sheetAmount"));
		@SuppressWarnings("unchecked")
		List<BaseRevenueStatisticalOfRevenue> sheetList = GenericBase.__getList(param.get("sheetList"),
		BaseRevenueStatisticalOfRevenue.newInstance());
		//更新拆分后的订单金额
		Project projectDao = new Project();
		projectDao.setProjectId(projectId);
		if(projectDao.load()){
			BaseProject projectBean = projectDao.generateBase();
			projectDao.setSheetAmount(sheetAmount);
			projectDao.update();
			int plateId = projectBean.getPlateId();
			//删除该订单在营收表中的数据记录
			RevenueStatisticalRecord dao = new RevenueStatisticalRecord();
			dao.setConditionProjectId("=",projectId);
			dao.conditionalDelete();
			RevenueYearStatisticalRecord yearDao = new RevenueYearStatisticalRecord();
			yearDao.setConditionProjectId("=",projectId);
			yearDao.conditionalDelete();
			//将拆分的订单插入订单表
			if(!BaseHelpUtils.isNullOrEmpty(sheetList) && sheetList.size() > 0){
				BaseRevenueStatisticalOfRevenue e = sheetList.get(0);
				//先检索拆分的订单是否已经操作过，如果已经操作过，则不进行操作
				projectDao.clear();
				projectDao.setConditionContractCode("=",e.getSheetCode());
				if(projectDao.countRows() > 0){//说明有存在
					throw new SQLException("该订单已进行拆分过,不可再进行拆分");
				}
				projectBean.setProjectId(0);
				projectBean.setContractCode(e.getSheetCode());
				projectBean.setPlateId(0);
				projectBean.setRevenuePlateId(plateId);
				projectBean.setSheetAmount(e.getSheetAmount());
				projectBean.setTotalIntegral(e.getSheetAmount());
				projectBean.setProjectIntegral(BigDecimal.ZERO);
				projectBean.setPercentage(BigDecimal.ZERO);
				projectBean.setReserveIntegral(BigDecimal.ZERO);
				projectBean.setComplaintIntegral(BigDecimal.ZERO);
				projectBean.setComplaintPercentage(BigDecimal.ZERO);
				projectDao.clear();
				projectDao.setDataFromBase(projectBean);
				projectDao.save();
				//插入营收统计表
				BaseRevenueStatisticalRecord bean = new BaseRevenueStatisticalRecord();
				bean.setDataFromJSON(e.toJSON());
				dao.clear();
				bean.setProjectId(projectDao.getProjectId());
				bean.setModifyPercent(bean.getTotalPercent());
				dao.setDataFromBase(bean);
				dao.save();
				yearDao.clear();
				OnRevenueStatisticalProcess revenue= new OnRevenueStatisticalProcess();
				revenue.onSetRevenue(e.getMonth(), e.getCurrentRevenue(), yearDao);
				yearDao.setProjectId(projectDao.getProjectId());
				yearDao.setYear(e.getYear());
				yearDao.setOperateTime(new Date());
				yearDao.save();
			}
		}
		
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    /**
     * 保存或者更新项目编码
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onSaveOrUpdateProjectCode(String creteria) throws Exception{
    	BaseProjectCodeRecord bean = new BaseProjectCodeRecord();
    	bean.setDataFromJSON(creteria);
    	//获取主键,当主键大于0时说明是有保存，只做更新操作，否则插入
    	int projectCodeId = BaseHelpUtils.getIntValue(bean.getProjectCodeRecordId());
    	ProjectCodeRecord dao = new ProjectCodeRecord();
    	if(projectCodeId > 0){//说明有数据，则做更新操作
    		dao.setProjectCodeRecordId(projectCodeId);
    		if(dao.load()){
    			dao.setDataFromBase(bean);
    			dao.update();
    		}
    	}else{
    		dao.setDataFromBase(bean);
    		dao.save();
    	}
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    /**
     * 根据plateID 往下查询相关的部门platemanagerId 和departmentmanageid
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String findPlateAndDepartmentManagerId(Map<String, Object> param) throws Exception{
    	BaseCollection<BaseEmployee> bc = new BaseCollection<>();
    	List<BaseEmployee> list =new ArrayList<>();
    	PlateRecord plateRecordDao = new PlateRecord();
    	Employee dao =new Employee();
    	BaseEmployee base =null;
    	
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	int projectId = BaseHelpUtils.getIntValue(param,"projectId");
    	String contractCode= BaseHelpUtils.getStringValue(param,"contractCode");
    	
    	//获取承接部门名称
		plateRecordDao.setConditionPlateId("=",plateId);
		BasePlateRecord plateRecordBean = plateRecordDao.executeQueryOneRow();
		String plateCode = plateRecordBean.getPlateCode();
		String plateName = "";
		if(!BaseHelpUtils.isNullOrEmpty(plateRecordBean)){
			plateName = BaseHelpUtils.getString(plateRecordBean.getPlateName());
		}
    	//根据承接部门，去检索该业务部门下的事业部负责人和部门经理(找到该部门下角色为事业部负责人，再找到该角色下的人员，部门经理同理)
		int plateManageId = CustomMainContractHandler.getManageEmployeeId(plateId,StaticUtils.ROLE_PLATE_MANAGER);
		//如果该承接部门未设定事业部负责人，则抛出异常
		if(plateManageId <= 0){
			throw new SQLException("承接部门("+plateName+")未设定事业部负责人,请先设定");
		}
		//获取该部门下的部门经理
		int departmentManageId = CustomMainContractHandler.getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER);
		//如果该承接部门未设定部门经理，则抛出异常
		if(departmentManageId <= 0){
			throw new SQLException("承接部门("+plateName+")未设定部门经理,请先设定");
		}
		
    	//判断项目是否有确认的项目成本 ，如果有项目成本的情况下，不许修改contractCode但是plate_id可修改
    	ProjectCost pcDao =new ProjectCost();
    	pcDao.setConditionProjectId("=", projectId);
    	List<BaseProjectCost> BaseProjectCostList = pcDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(BaseProjectCostList)&&BaseProjectCostList.size()>0) {
    		base=new BaseEmployee();
    		//使用原有的contarctCode 
    		base.setAlternateField3(contractCode);
    		//订单编号没有重复  
			base.setAnnualPerformance("true");
    	}else {
    		base = checkContractCode(contractCode,plateCode,projectId);
    	}
    	base.setAlternateField1(plateManageId+"");
		base.setAlternateField2(departmentManageId+"");
    	bc.setStatus(1);
    	list.add(base);
		bc.setCollections(list);
		return bc.toJSON(1, "");
    }
    
    //检查contractCode是否有重复
    public static BaseEmployee checkContractCode(String contractCode,String plateCode,int projectId) throws SQLException {
    	Project pDao =new Project();
    	BaseEmployee base =new BaseEmployee();
    	StringBuffer contractCodeNew= new StringBuffer();
    	String[] split = contractCode.split("-");
		if(!BaseHelpUtils.isNullOrEmpty(split)&&split.length>0) {
			for (int i = 0; i < split.length-1; i++) {
				String string = split[i];
				contractCodeNew.append(string+"-");
			}
			contractCodeNew.append(plateCode);
		}
		pDao.clear();
		pDao.setConditionContractCode("=", contractCodeNew.toString());
		List<BaseProject> conditionalLoad = pDao.conditionalLoad();
		
		if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()==1) {
			BaseProject baseProject = conditionalLoad.get(0);
			if(projectId==baseProject.getProjectId()) {
				//订单编号没有重复
				base.setAnnualPerformance("true");
			}else {
				//订单编号有重复 
				base.setAnnualPerformance("false");
			}
		}else if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>1) {
			//订单编号有重复 
			base.setAnnualPerformance("false");
		}else {
			//订单编号没有重复
			base.setAnnualPerformance("true");
		}
		base.setAlternateField3(contractCodeNew.toString());
		return base;
    }
    
    
    /**
     * SELECT contract_code,plate_id,revenue_plate_id,plate_manager_id,department_manager_id,sub_contract_id,* FROM projects WHERE project_id = 1100
     * SELECT sub_contract_code,department_id,* FROM sub_contracts WHERE sub_contract_id = 0
     * @param creteria
     * @return
     * @throws Exception 
     */
    public static String onSaveOrUpdatePlateAndDepartmentManagerId(Map<String, Object> param) throws Exception{
    	ThreadConnection.beginTransaction();
    	BaseCollection<BaseEmployee> bc = new BaseCollection<>();
    	Project pDao =new Project();
    	BaseProject bp =new BaseProject();
    	SubContract scDao =new SubContract();
    	BaseSubContract bsc =new BaseSubContract();
    	ProjectSettlement psDao =new ProjectSettlement();
    	ProjectCost pcDao =new ProjectCost();
    	PlateRecord plateRecordDao = new PlateRecord();
    	
    	int plateId = BaseHelpUtils.getIntValue(param.get("plateId"));
    	int plateManagerId = BaseHelpUtils.getIntValue(param.get("plateManagerId"));
    	int departmentManagerId = BaseHelpUtils.getIntValue(param.get("departmentManagerId"));
    	int projectId = BaseHelpUtils.getIntValue(param.get("projectId"));
    	String contractCode = BaseHelpUtils.getString(param.get("contractCode"));
    	//获取订单名称
    	String projectName = BaseHelpUtils.getStringValue(param, "projectName");
    	
    	//获取承接部门名称
    	plateRecordDao.setConditionPlateId("=",plateId);
    	BasePlateRecord plateRecordBean = plateRecordDao.executeQueryOneRow();
    	String plateCode = plateRecordBean.getPlateCode();
//    	BaseEmployee b = checkContractCode(contractCode,plateCode,projectId);
    	pDao.clear();
		pDao.setConditionContractCode("=", contractCode);
		List<BaseProject> conditionalLoad = pDao.conditionalLoad();
		Boolean bool =true;
		if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()==1) {
			BaseProject baseProject = conditionalLoad.get(0);
			if(projectId==baseProject.getProjectId()) {
				//订单编号没有重复
				bool=true;
			}else {
				//订单编号有重复 
				bool=false;
			}
		}else if(!BaseHelpUtils.isNullOrEmpty(conditionalLoad)&&conditionalLoad.size()>1) {
			//订单编号有重复 
			bool=false;
		}else {
			//订单编号没有重复
			bool=true;
		}
    	if(bool.equals("false")) {
    		throw new SQLException("新的订单编号已重复("+contractCode+"),请在新的订单编号往后添加后续标识");
    	}
    	//判断项目是否有确认积分或者待确认积分
/*    	psDao.setConditionProjectId("=", projectId);
    	List<BaseProjectSettlement> BaseProjectSettlementList = psDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(BaseProjectSettlementList)&&BaseProjectSettlementList.size()>0) {
    		for (BaseProjectSettlement baseProjectSettlement : BaseProjectSettlementList) {
    			if(BaseHelpUtils.getIntValue(baseProjectSettlement.getSettlementStatus())==1||BaseHelpUtils.getIntValue(baseProjectSettlement.getSettlementStatus())==2) {
    				throw new SQLException("项目("+contractCode+")有确认积分或者待确认积分，不能调整新的业务部门及人员");
    			}
			}
//    		throw new SQLException("项目("+contractCode+")有确认积分或者待确认积分，不能调整新的业务部门及人员");
    	}*/
    	
    	//判断项目是否有确认的项目成本
/*    	pcDao.setConditionProjectId("=", projectId);
    	List<BaseProjectCost> BaseProjectCostList = pcDao.conditionalLoad();
    	if(!BaseHelpUtils.isNullOrEmpty(BaseProjectCostList)&&BaseProjectCostList.size()>0) {
    			throw new SQLException("项目("+contractCode+")有确认的项目成本，仅能调整新的业务部门及人员，不能修改订单编号");
    	}*/
    	bp.setProjectId(projectId);
    	bp.setPlateId(plateId);
    	bp.setDepartmentId(plateId);
    	bp.setRevenuePlateId(plateId);
    	bp.setPlateManagerId(plateManagerId);
    	bp.setDepartmentManagerId(departmentManagerId);
    	bp.setContractCode(contractCode);
    	if(!BaseHelpUtils.isNullOrEmpty(projectName)) {
    		bp.setProjectName(projectName);
    		bsc.setSubContractName(projectName);
    	}
    	pDao.setDataFromBase(bp);
    	pDao.update();
    	
    	BaseProject base = pDao.executeQueryOneRow();
    	int subContractId = BaseHelpUtils.getIntValue(base.getSubContractId());
    	if(subContractId>0) {
    		bsc.setSubContractId(subContractId);
    		bsc.setSubContractCode(contractCode);
    		scDao.setDataFromBase(bsc);
    		scDao.update();
    	}
    	ThreadConnection.commit();
    	return bc.toJSON(0, "");
    }
    
    /**
     * 加载研发项目的项目编号的编码
     * @param param
     * @return
     * @throws SQLException
     */
    public String onLoadProjectCode(Map<String, Object> param) throws SQLException{
    	//获取业务部门
    	int plateId = BaseHelpUtils.getIntValue(param,"plateId");
    	//获取项目标示类型;1:设计项目;2:研发项目;3:管理项目
    	int projectFlag = BaseHelpUtils.getIntValue(param,"projectFlag");
    	//获取业务类型
    	int businessType = BaseHelpUtils.getIntValue(param,"businessType");
    	//获取项目类型
    	int projectType = BaseHelpUtils.getIntValue(param, "projectType");
    	String projectCodeValue = BaseHelpUtils.getStringValue(param,"projectCode");
    	//获取当前操作的年月份
    	Date date = new Date();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	int year = calendar.get(Calendar.YEAR);
    	int month = calendar.get(Calendar.MONTH)+1;
    	//根据业务部门去检索对应的编码
    	PlateRecord plateDao = new PlateRecord();
    	plateDao.setConditionPlateId("=",plateId);
    	BasePlateRecord plateBean = plateDao.executeQueryOneRow();
    	if(plateBean == null){
    		throw new SQLException("加载失败,没有检索该业务部门对应的部门编码");
    	}
    	//根据目前的业务部门，年月份去编号记录表中检索数据
    	ProjectCodeRecord dao = new ProjectCodeRecord();
    	dao.setConditionProjectFlag("=",projectFlag);
    	dao.setConditionYear("=",year);
    	dao.setConditionMonth("=",month);
    	BaseProjectCodeRecord bean = dao.executeQueryOneRow();
    	String code ="";
    	if(bean == null){//说明还没有保存数据
    		bean = new BaseProjectCodeRecord();
    		bean.setYear(year);
    		bean.setMonth(month);
    		bean.setSerialNumber(1);//初始化为1
    		//如果是业务部门是研发中心的研发项目的话，则name为RE
    		if(projectFlag == Project_flag_2){
    			bean.setName(develop_project_title);
    		}else if(projectFlag == Project_flag_3){//说明是管理项目
    			bean.setName(manage_project_title);
    		}
    		code = String.format("%1$s.%2$s%3$s%4$s",bean.getName(),year,String.format("%02d",month),String.format("%03d",1));
    	}else{
    		//获取序列号
    		if(BaseHelpUtils.isNullOrEmpty(projectCodeValue)){//说明不是修改,则需要修改序列号
    			int serial = bean.getSerialNumber();
    			serial += 1;
    			bean.setSerialNumber(serial);
    			code = String.format("%1$s.%2$s%3$s%4$s",bean.getName(),year,String.format("%02d",month),String.format("%03d",serial));
    		}else{//说明是修改
    			String[] arr = projectCodeValue.split("\\.");
    			if(arr.length>2){
    				code = String.format("%1$s.%2$s",bean.getName(),arr[1]);
    			}
    		}
    	}
    	bean.setPlateId(plateId);
    	bean.setCode(code);
    	String projectCode = String.format("%1$s.%2$s-%3$s-%4$s",code,String.format("%02d",businessType),String.format("%02d",projectType),plateBean.getPlateCode());
    	bean.setProjectCode(projectCode);
    	List<BaseProjectCodeRecord> list = new ArrayList<>();
    	list.add(bean);
    	BaseCollection<BaseProjectCodeRecord> bc = new BaseCollection<>();
    	bc.setCollections(list);
    	return bc.toJSON(0, null);
    }
    
    /**
     * 研发项目立项
     * @param creteria
     * @return
     * @throws Exception
     */
    public String onDevelopProjectSave(String creteria) throws Exception{
    	ThreadConnection.beginTransaction();
    	Project dao = new Project();
    	BaseProject bean = new BaseProject();
    	bean.setDataFromJSON(creteria);
    	//获取业务部门ID
    	int plateId = BaseHelpUtils.getIntValue(bean.getPlateId());
    	if(plateId <= 0){//业务部门不可为空
    		throw new SQLException("保存失败,业务部门不可为空");
    	}
    	//获取归属部门
    	int departmentId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
    	if(departmentId <= 0){//归属部门不可为空
    		throw new SQLException("保存失败,归属部门不可为空");
    	}
    	//获取项目积分
    	BigDecimal projectIntegral = bean.getProjectIntegral()==null?BigDecimal.ZERO:bean.getProjectIntegral();
    	if(projectIntegral.compareTo(BigDecimal.ZERO) <= 0){//项目积分不可小于0
    		throw new SQLException("保存失败,项目积分不可小于0");
    	}
    	//日期不可为空
    	Date recordDate = bean.getStartDate();
    	if(recordDate == null){
    		throw new SQLException("保存失败,日期不可为空");
    	}
    	bean.setParentId(1);//非630项目
    	dao.setDataFromBase(bean);
    	dao.save();
    	int businessId = dao.getProjectId();
    	//获取当前操作人，即该项目的部门经理
    	int operateEmployeeId = bean.getDepartmentManagerId();
    	Integer accountId = AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_PROJECT, businessId, AccountUtils.ACCOUNT_LEVEL_1, dao.getProjectName(), operateEmployeeId, true);
    	//获取项目标示类型字段：1：设计项目；2：研发项目；3：管理项目
    	int projectFlag = BaseHelpUtils.getIntValue(bean.getProjectFlag());
    	//获取立项标示：如果是公司立项，费用则是由公司支出，如果是部门立项，则费用由部门支出(需向部门账户表插入数据)
    	//获取立项标示：1:是公司立项；2：部门立项
    	int projectSetupFlag = BaseHelpUtils.getIntValue(bean.getProjectSetupFlag());
    	if(2 == projectSetupFlag){//说明是部门立项
    		//向部门账户插入数据***********************
    		String remark = bean.getRemark();
    		if(2 == projectFlag){//说明是研发项目，则部门的费用归集是研发项目
    			AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_DEVELOP_PROJECT, projectIntegral, recordDate, remark, operateEmployeeId);
    			//账户系统：借研发项目
    			AccountUtils.insertAccountTransaction(false, accountId, null, null, AccountUtils.ACCOUNT_BUSSINESS_TYPE_28, businessId, businessId, projectIntegral, true, recordDate, operateEmployeeId, remark);
    			//账户系统：贷业务部门
    			AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_28, businessId, businessId, projectIntegral, false, recordDate, operateEmployeeId, remark);
    		}else if(3 == projectFlag){//说明是管理项目，则部门的费用归集是管理项目
    			AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_MANAGE_PROJECT, projectIntegral, recordDate, remark, operateEmployeeId);
    			//账户系统：借管理项目
    			AccountUtils.insertAccountTransaction(false, accountId, null, null, AccountUtils.ACCOUNT_BUSSINESS_TYPE_9, businessId, businessId, projectIntegral, true, recordDate, operateEmployeeId, remark);
    			//账户系统：贷业务部门
    			AccountUtils.insertAccountTransaction(false, null, AccountUtils.ACCOUNT_TYPE_PLATE, plateId, AccountUtils.ACCOUNT_BUSSINESS_TYPE_9, businessId, businessId, projectIntegral, false, recordDate, operateEmployeeId, remark);
    		}
    	}
    	//研发项目立项的同时设定项目的设计阶段，默认就为研发全阶段(30)
    	ProjectStage stageDao = new ProjectStage();
    	BaseProjectStage stageBean = new BaseProjectStage();
    	stageBean.setProjectId(dao.getProjectId());
    	stageBean.setPercent(new BigDecimal(100));
    	stageBean.setProjectAmount(projectIntegral);
    	if(2 == projectFlag){//说明是研发项目
    		stageBean.setStageId(30);//研发全阶段
    		stageBean.setStageName("研发全阶段");
    	}else if(3 == projectFlag){//说明是管理项目
    		stageBean.setStageId(31);//管理全阶段
    		stageBean.setStageName("管理全阶段");
    	}
    	stageDao.setDataFromBase(stageBean);
    	stageDao.save();
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    /**
     * 研发项目修改
     * @param creteria
     * @return
     * @throws Exception 
     */
    public String onDevelopProjectUpdate(String creteria) throws Exception{
    	ThreadConnection.beginTransaction();
    	Project dao = new Project();
    	BaseProject bean = new BaseProject();
    	bean.setDataFromJSON(creteria);
    	int projectId = BaseHelpUtils.getIntValue(bean.getProjectId());
    	dao.setProjectId(projectId);
    	if(dao.load()){
    		dao.setDataFromBase(bean);
    		//如果项目金额有修改，则判断该项目是否有结算，如果有结算，则不可进行修改
    		ColumnChangedData chanageData = dao.getColumnChangedData(BaseProject.CS_PROJECT_INTEGRAL);
    		if(chanageData !=null && !chanageData.getOriginal().equals(chanageData.getValue())){
    			//检索是否有结算记录，如果有结算记录，则不可修改
    			ProjectSettlement projectSettlementDao = new ProjectSettlement();
    			projectSettlementDao.setConditionProjectId("=",projectId);
    			if(projectSettlementDao.countRows() > 0){//说明有结算记录
    				throw new SQLException("该项目有结算记录，不可进行项目积分修改");
    			}else{
    	    		dao.update();
    	    		int plateId = bean.getPlateId();
    	    		//如果是公司立项，则不插入部门账户信息
    	    		BigDecimal projectIntegral = bean.getProjectIntegral();
    	    		//获取项目标示类型字段：1：设计项目；2：研发项目；3：管理项目
    	        	int projectFlag = BaseHelpUtils.getIntValue(bean.getProjectFlag());
    	        	//获取立项标示：如果是公司立项，费用则是由公司支出，如果是部门立项，则费用由部门支出(需向部门账户表插入数据)
    	        	//获取立项标示：1:是公司立项；2：部门立项
    	        	int projectSetupFlag = BaseHelpUtils.getIntValue(bean.getProjectSetupFlag());
    	        	if(2 == projectSetupFlag){//说明是部门立项
    	        		//修改部门账户的信息入数据***********************
    	        		int businessId = projectId;
    	        		String remark = bean.getRemark();
    	        		Date recordDate = bean.getStartDate();
    	        		//获取当前操作人，即该项目的部门经理
    	        		int operateEmployeeId = bean.getDepartmentManagerId();
    	        		if(2 == projectFlag){//说明是研发项目，则部门的费用归集是研发项目
    	        			AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_DEVELOP_PROJECT, projectIntegral, recordDate, remark, operateEmployeeId);
    	        		}else if(3 == projectFlag){//说明是管理项目，则部门的费用归集是管理项目
    	        			AccountManageProcess.onSavePlateAccount(plateId, businessId, AccountManageProcess.PLATE_BT_MANAGE_PROJECT, projectIntegral, recordDate, remark, operateEmployeeId);
    	        		}
    	        	}
    	        	//修改项目阶段数据
    	        	ProjectStage stageDao = new ProjectStage();
    	        	stageDao.setConditionProjectId("=",projectId);
    	        	stageDao.setProjectAmount(projectIntegral);
    	        	stageDao.conditionalUpdate();
    			}
    		}else{//更新项目基本信息
    			dao.update();
    		}
    		
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    
    public String onUpdateSheetRevenue(Map<String, Object> param) throws SQLException{
    	//获取当前操作人id
    	int operateEmployeeId = BaseHelpUtils.getIntValue(param,"operateEmployeeId");
    	//获取项目id
    	int projectId = BaseHelpUtils.getIntValue(param, "projectId");
    	//获取订单金额
    	BigDecimal sheetAmount = BaseHelpUtils.getBigDecimalValue(param.get("sheetAmount"));
    	ThreadConnection.beginTransaction();
    	if(projectId > 0 && sheetAmount.compareTo(BigDecimal.ZERO) >= 0){
    		Project projectDao = new Project();
    		projectDao.setProjectId(projectId);
    		if(projectDao.load()){
    			projectDao.setSheetAmount(sheetAmount);
    			projectDao.setMoneySum(sheetAmount);
    			projectDao.update();
    			//根据新的订单金额，重新去计算每个月的营收
//    			RevenueStatisticalRecord revenueDao = new RevenueStatisticalRecord();
//    			revenueDao.setConditionProjectId("=",projectId);
//    			List<BaseRevenueStatisticalRecord> revenueList = revenueDao.conditionalLoad("order by year,month asc");
//    			if(!BaseHelpUtils.isNullOrEmpty(revenueList) && revenueList.size() > 0){
//    				//活动该订单的归属业务部门
//    				int plateId = BaseHelpUtils.getIntValue(param, "revenuePlateId");
//    				//根据业务部门ID获取该业务部门对应的税率
//    				PlateRateRecord plateRateDao = new PlateRateRecord();
//    				plateRateDao.setConditionPlateId("=",plateId);
//    				BasePlateRateRecord plateRateBean = plateRateDao.executeQueryOneRow();
//    				BigDecimal ratePercent = new BigDecimal(1.06);//设置默认为1.06
//    				if(!BaseHelpUtils.isNullOrEmpty(plateRateBean)){
//    					ratePercent = plateRateBean.getRatePercent()==null?new BigDecimal(1.06):plateRateBean.getRatePercent();
//    				}
//    				//设置上月累计营收，初始化为0；
//    				BigDecimal lastMonthRevenue = BigDecimal.ZERO;
//    				RevenueYearStatisticalRecord revenueYearDao = new RevenueYearStatisticalRecord();
//    				for(BaseRevenueStatisticalRecord e : revenueList){
//    					//获取主键
//    					int revenueStatisticalRecordId = e.getRevenueStatisticalRecordId();
//    					//获取累计百分比
//    					BigDecimal totalPercent = e.getTotalPercent()==null?BigDecimal.ZERO:e.getTotalPercent();
//    					//计算第一次含税累计营收(累计百分比*订单金额)
//    					BigDecimal totalTaxRevenue = totalPercent.multiply(sheetAmount);
//    					//计算第一次的累计营收(含税累计营收/税率)
//    					BigDecimal totalRevenue = totalTaxRevenue.divide(ratePercent,2,BigDecimal.ROUND_DOWN);
//    					//计算本月营收(累计营收-上月累计营收)
//    					BigDecimal currentRevenue = totalRevenue.subtract(lastMonthRevenue);
//    					//设置上月累计营收
//    					lastMonthRevenue = totalRevenue;
//    					//更新操作
//    					revenueDao.clear();
//    					revenueDao.setRevenueStatisticalRecordId(revenueStatisticalRecordId);
//    					if(revenueDao.load()){
//    						revenueDao.setTotalTaxRevenue(totalTaxRevenue);
//    						revenueDao.setTotalRevenue(totalRevenue);
//    						revenueDao.setCurrentRevenue(currentRevenue);
//    						revenueDao.setOperateTime(new Date());
//    						revenueDao.setOperateEmployeeId(operateEmployeeId);
//    						revenueDao.update();
//    					}
//    					//更新年度营收表数据集
//    					revenueYearDao.clear();
//    					revenueYearDao.setConditionProjectId("=",projectId);
//    					revenueYearDao.setConditionYear("=",e.getYear());
//    					int month = e.getMonth();
//    					switch (month) {
//						case 1:
//							revenueYearDao.setJanuaryRevenue(currentRevenue);
//							break;
//						case 2:
//							revenueYearDao.setFebruaryRevenue(currentRevenue);
//							break;
//						case 3:
//							revenueYearDao.setMarchRevenue(currentRevenue);
//							break;
//						case 4:
//							revenueYearDao.setAprilRevenue(currentRevenue);
//							break;
//						case 5:
//							revenueYearDao.setMayRevenue(currentRevenue);
//							break;
//						case 6:
//							revenueYearDao.setJuneRevenue(currentRevenue);
//							break;
//						case 7:
//							revenueYearDao.setJulyRevenue(currentRevenue);
//							break;
//						case 8:
//							revenueYearDao.setAugustRevenue(currentRevenue);
//							break;
//						case 9:
//							revenueYearDao.setSeptemberRevenue(currentRevenue);
//							break;
//						case 10:
//							revenueYearDao.setOctoberRevenue(currentRevenue);
//							break;
//						case 11:
//							revenueYearDao.setNovemberRevenue(currentRevenue);
//							break;
//						case 12:
//							revenueYearDao.setDecemberRevenue(currentRevenue);
//							break;
//						default:
//							break;
//						}
//    					revenueYearDao.setOperateTime(new Date());
//    					revenueYearDao.setOperateEmployeeId(operateEmployeeId);
//    					revenueYearDao.conditionalUpdate();
//    				}
//    			}
    		}
    		
    	}else{
    		throw new SQLException("数据异常,不可进行操作");
    	}
    	ThreadConnection.commit();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
    }
    
    
    
    /**
     * 价格审核列表数据撤回
     * @param param
     * @return
     * @throws SQLException
     */
    public String onSheetBackout(Map<String, Object> param) throws SQLException{
    	//获取合同编号
    	String contractCode = BaseHelpUtils.getStringValue(param, "contractCode");
    	if(!BaseHelpUtils.isNullOrEmpty(contractCode)){
    		//根据该合同编号去检索合同表数据集，获取到合同id
    		Contract contractDao = new Contract();
    		contractDao.setConditionContractCode("=",contractCode);
    		BaseContract contractBean = contractDao.executeQueryOneRow();
    		if(!BaseHelpUtils.isNullOrEmpty(contractBean)){
    			int contractId = contractBean.getContractId();
    			//根据合同ID去子合同表检索订单信息
    			SubContract subContractDao = new SubContract();
    			subContractDao.setConditionParentId("=",contractId);
    			List<BaseSubContract> subContractList = subContractDao.conditionalLoad();
    			int subContractListSize = subContractList.size();
    			Object[] subContractArr = new Object[subContractListSize];
    			int i = 0;
    			for(BaseSubContract bean : subContractList){
    				subContractArr[i] = bean.getSubContractCode();
    				i++;
    			}
    			//根据订单编号数据集去检索订单信息
    			Project projectDao = new Project();
    			projectDao.addCondition(BaseProject.CS_CONTRACT_CODE,"in", subContractArr);
    			List<BaseProject> projectList = projectDao.conditionalLoad();
    			int projectListSize = projectList.size();
    			Integer[] projectArr = new Integer[projectListSize]; 
    			int j = 0;
    			for(BaseProject e : projectList){
    				projectArr[j] = BaseHelpUtils.getIntValue(e.getProjectId());
    				j++;
    			}
    			//再根据项目ID去检索项目是否有做确认积分的操作，如果有，则不允许撤回订单
    			ProjectSettlement settDao = new ProjectSettlement();
    			settDao.addCondition(BaseProjectSettlement.CS_PROJECT_ID,"=", (Object[]) projectArr);
    			int count = settDao.countRows();
    			//当count>0，表示该合同下达事业部后，有的订单已经做了确认积分的操作，则不可以进行撤回
    		}else{
    			throw new SQLException("未检索到该合同编号");
    		}
    		
    	}else{
    		throw new SQLException("合同编号不能为空");
    	}
        
    	BaseCollection bc = new BaseCollection();
		return bc.toJSON(0, null);
    }
    
    /**
     * 订单变更计算
     * @param projectId:项目ID
     * @param totalChangeIntegral:订单变更的积分
     * @throws Exception 
     */
    public static void onProjectChange(int projectId,BigDecimal totalChangeIntegral, BigDecimal sheetFinalAmount, BigDecimal cadArea, BigDecimal commonArea, BigDecimal logisticsArea) throws Exception{
    	if(projectId > 0){//只针对项目ID大于0的订单进行操作
    		Project projectDao = new Project();
    		projectDao.setProjectId(projectId);
    		if(projectDao.load()){//说明存在该项目
    			if(totalChangeIntegral.compareTo(BigDecimal.ZERO) != 0){//订单总积分发生变化
    				ProjectStage projectStageDao = new ProjectStage();
    				BigDecimal hundred = BigDecimal.valueOf(100);
	    			//获取原项目总积分
	    			BigDecimal oldTotalIntegral = projectDao.getTotalIntegral()==null?BigDecimal.ZERO:projectDao.getTotalIntegral();
	    			//获取核算比例
	    			BigDecimal percentage = BaseHelpUtils.getBigDecimalValue(projectDao.getPercentage());
	    			percentage = percentage.divide(hundred);
	    			//设置变更后的项目总积分
	    			BigDecimal finalTotalIntegral = oldTotalIntegral.add(totalChangeIntegral);
	    			//计算最终的预留积分和项目积分
	    			BigDecimal finalReserveIntegral = BaseHelpUtils.format(finalTotalIntegral.multiply(percentage),2);
	    			BigDecimal finalProjectIntegral = finalTotalIntegral.subtract(finalReserveIntegral);
	    			projectStageDao.clear();
					projectStageDao.setConditionProjectId("=", projectId);
					projectStageDao.setProjectAmount(BigDecimal.ZERO);
					projectStageDao.conditionalUpdate();
					//定义订单项目组和部门预留已经结算的积分
					BigDecimal sureIntegralTotal = BigDecimal.ZERO;
					BigDecimal sureIntegralTotalDep = BigDecimal.ZERO;
					//如果变更导致项目总积分变少的，则需进行回扣，如果变更后的项目组积分和预留积分小于了已经结算的积分，则已结算的积分为准，已经结算的积分，不进行回扣
					if(totalChangeIntegral.compareTo(BigDecimal.ZERO) < 0) {
						ProjectContractChange pccDao = new ProjectContractChange();
						int plateId = projectDao.getPlateId();
						Date currentDate = new Date();
						//检索项目组结算的数据集
						ProjectSettlement psDao = new ProjectSettlement();
						psDao.setConditionProjectId("=",projectId);
						List<BaseProjectSettlement> psList = psDao.conditionalLoad();
						if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0){
							for(BaseProjectSettlement psBean : psList){
								//获取结算的金额
								BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(psBean.getTotalAmount());
								sureIntegralTotal = sureIntegralTotal.add(sureIntegral);
							}
						}
						if(sureIntegralTotal.compareTo(finalProjectIntegral) > 0) {
							BigDecimal changeIntegal = sureIntegralTotal.subtract(finalProjectIntegral);
							//保存到业务表
        					pccDao.clear();
        					pccDao.setPlateId(plateId);
        					pccDao.setProjectId(projectId);
        					pccDao.setIntegral(changeIntegal);
        					pccDao.setRecordDate(currentDate);
        					pccDao.setOperateTime(currentDate);
        					pccDao.setRemark("合同变更减少(项目组)");
        					pccDao.setIsCompleted(Boolean.TRUE);
        					pccDao.save();
						}
						//获取部门结算的数据集
						PlateProjectAccountRecord pparDao = new PlateProjectAccountRecord();
						pparDao.setConditionProjectId("=", projectId);
						List<BasePlateProjectAccountRecord> pparList = pparDao.conditionalLoad();
						if(!BaseHelpUtils.isNullOrEmpty(pparList) && pparList.size() > 0) {
							for(BasePlateProjectAccountRecord pparBean : pparList) {
								//获取结算的金额
								BigDecimal sureIntegral = BaseHelpUtils.getBigDecimalValue(pparBean.getAccountIntegral());
								sureIntegralTotalDep = sureIntegralTotalDep.add(sureIntegral);
							}
						}
						
						if(sureIntegralTotalDep.compareTo(finalReserveIntegral) > 0) {
							BigDecimal changeIntegal = sureIntegralTotalDep.subtract(finalReserveIntegral);
							//保存到业务表
        					pccDao.clear();
        					pccDao.setPlateId(plateId);
        					pccDao.setProjectId(projectId);
        					pccDao.setIntegral(changeIntegal);
        					pccDao.setRecordDate(currentDate);
        					pccDao.setOperateTime(currentDate);
        					pccDao.setRemark("合同变更减少(部门预留)");
        					pccDao.setIsCompleted(Boolean.TRUE);
        					pccDao.save();
						}
					}
					
    				projectDao.setTotalIntegral(finalTotalIntegral);
    				projectDao.setReserveIntegral(finalReserveIntegral);
    				projectDao.setProjectIntegral(finalProjectIntegral);
    			}
    			projectDao.setSheetAmount(sheetFinalAmount);
    			projectDao.setCadArea(cadArea);
    			projectDao.setCommonArea(commonArea);
    			projectDao.setLogisticsArea(logisticsArea);
    			projectDao.update();
    		}else{//说明不存在
    			throw new SQLException("项目不存在");
    		}
    	}
    }
    
    public String winBid(Map<String, Object> params) throws Exception{
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	int mainProjectId = BaseHelpUtils.getIntValue(params.get("mainProjectId"));
    	int operator = BaseHelpUtils.getIntValue(params.get("operator"));
    	MainProject mainProjectDao = new MainProject();
    	mainProjectDao.setMainProjectId(mainProjectId);
    	if(mainProjectDao.load()) {
    		ThreadConnection.beginTransaction();
    		mainProjectDao.setBidType(StaticUtils.BID_TYPE_WIN_BID);
    		mainProjectDao.setWinningTime(new Date());
    		mainProjectDao.update();
    		Contract cDao = new Contract();
    		cDao.setConditionInfoCode("=", mainProjectDao.getInfoCode());
    		BaseContract cBean = cDao.executeQueryOneRow();
    		if(null != cBean) {
    			ContractStatusUtils util = new ContractStatusUtils();
    			if(Objects.equals(cBean.getContractSigningStatus(), StaticUtils.CONTRACT_SIGING_STATUS_2)) {
    				//中标且合同已签订，则合同状态改为合同运行
    				util.updateContractAndProjectStatusWithLog(cBean.getContractId(), StaticUtils.CONTRACT_STATUS_6, operator, "中标修改合同状态");
    			}else {
    				//项目中标，在未有签订合同标记前，自动显示为“项目缓慢”状态
    				util.updateContractAndProjectStatusWithLog(cBean.getContractId(), StaticUtils.CONTRACT_STATUS_4, operator, "中标修改合同状态");
    			}
    		}
    		ThreadConnection.commit();
    	}else {
    		return bc.toJSON(-1, "找不到项目信息");
    	}
    	return bc.toJSON();
    }

}
