package pomplatform.contract.handler;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseContractCode;
import com.pomplatform.db.bean.BaseContractSerialNumber;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.bean.BaseSubContract;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractCode;
import com.pomplatform.db.dao.ContractSerialNumber;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectContractChange;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.SubContract;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseDepartment;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.dao.Department;
import delicacy.system.dao.EmployeeRole;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.AccountUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.business.MarketingCommission;
import pomplatform.project.business.OnProjectCommonProcess;

/**
 * 
 * @Title: CustomMainContractHandler.java 
 * @Package pomplatform.contract.handler 
 * @Description: 主订单信息处理
 * @author CL  
 * @date 2016年9月21日
 */
public class CustomMainContractHandler implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger(CustomMainContractHandler.class);
    
    private static final String GET_MAIN_CONTRACT = "getMainContract";//根据主合同信息获取子合同信息
    
    private static final String GO_FLOW_MAIN_CONTRACT = "goFlowMainContract";//走项目流程
    
    private static final String CREATE_CONTRACT_CODE = "createContractCode";//创建合同编号

    private static final String CHECKED_DEPARTMENT_MANAGE = "checkedDepartmentManage";//验证承接部门下是否有部门经理

    //主合同流程状态
//    private static final int FLOW_STATUS_ZERO = 0; //创建主合同最开始状态
//    private static final int FLOW_STATUS_ONE = 1;  //
//    private static final int FLOW_STATUS_TWO = 2;  //
//    private static final int FLOW_STATUS_THREE = 3; //
    
	@SuppressWarnings("unchecked")
	@Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        Map<String, Object> result = null;
        if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
            result = (Map<String, Object>) parser.parse(new BasicHandler());
        }
        String optType = BaseHelpUtils.getStringValue(result, "opt_type");
        if(!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)){
        	switch (optType) {
    		case GET_MAIN_CONTRACT:
        		return getMainContract(result);
    		case GO_FLOW_MAIN_CONTRACT:
    			return goFlowMainContract(result);
    		case CREATE_CONTRACT_CODE:
    			return createContractCode(result);
    		case CHECKED_DEPARTMENT_MANAGE:
    			return checkedDepartmentManage(result);
    		}
        }else{
        	return getAllContract();
        }
    	return null;
    }
    
    /**
     * 
     * @Title: getMainContract 
     * @Description: 根据主合同获取子合同信息形成树结构
     * @param @param result
     * @param @return
     * @param @throws SQLException   
     * @return String   
     * @throws
     */
    private String getMainContract(Map<String, Object> result) throws SQLException{
    	int flowStatus = BaseHelpUtils.getIntValue(result, "flowStatus");
    	BaseCollection<BaseContract> bc = new BaseCollection<>();
    	Contract dao = new Contract();
    	dao.setCurrentPage(BaseHelpUtils.getIntValue(result, "currentPage"));
		dao.setPageLines(BaseHelpUtils.getIntValue(result, "pageLines"));
    	//防止越过权限操作
    	if(flowStatus < 0){
    		return bc.toJSON(1, "");
    	}
    	//在处理主合同的过程中 只能查看当前流程的信息
    	if(flowStatus > 0){
    		dao.setConditionFlowStatus("=", flowStatus);
    	}
        List<BaseContract> ds = dao.conditionalLoad();
        bc.setCollections(ds);
    	return bc.toJSON(1, "");
    }

    public String checkedDepartmentManage(Map<String, Object> result) throws Exception{
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		SubContract subDao = new SubContract();
		subDao.setConditionParentId("=", BaseHelpUtils.getIntValue(result.get("")));
		Integer[] ints =new Integer[3];
		ints[0]=16;
		ints[1]=30;
		ints[2]=33;
		subDao.addCondition(BaseSubContract.CS_PROJECT_TYPE, "not in", ints);
		List<BaseSubContract> subContractList = subDao.conditionalLoad();
		PlateRecord plateRecordDao = new PlateRecord();
		BasePlateRecord plateRecordBean;
		for (BaseSubContract baseSubContract : subContractList) {
			//先获取承接部门
			int plateId = BaseHelpUtils.getIntValue(baseSubContract.getDepartmentId());
			//获取承接部门名称
			plateRecordDao.setConditionPlateId("=",plateId);
			plateRecordBean = plateRecordDao.executeQueryOneRow();
			String plateName = "";
			if(!BaseHelpUtils.isNullOrEmpty(plateRecordBean)){
				plateName = BaseHelpUtils.getString(plateRecordBean.getPlateName());
			}
			//根据承接部门，去检索该业务部门下的事业部负责人和部门经理(找到该部门下角色为事业部负责人，再找到该角色下的人员，部门经理同理)
//					int plateManageId = getManageEmployeeId(plateId,StaticUtils.ROLE_PLATE_MANAGER);
//					//如果该承接部门未设定事业部负责人，则抛出异常
//					if(plateManageId <= 0){
//						throw new SQLException("承接部门("+plateName+")未设定事业部负责人,请先设定");
//					}
			//获取该部门下的部门经理
			int departmentManageId = getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER);
			//如果该承接部门未设定部门经理，则抛出异常
			if(departmentManageId <= 0){
				throw new SQLException("承接部门("+plateName+")未设定部门经理,请先设定");
			}
		}
		return bc.toJSON(1, "");
	}


    
    /**
     * @throws Exception 
     * 
     * @Title: goFlowMainContract
     * @Description: 修改主合同项目流程
     * @param @param result
     * @param @return
     * @param @throws SQLException
     * @return String
     * @throws
     */
    /**
     * @param result
     * @return
     * @throws Exception
     */
    public String goFlowMainContract(Map<String, Object> result) throws Exception{
    	ThreadConnection.beginTransaction();
    	BaseCollection<GenericBase> bc = new BaseCollection<>();
    	//获取主合同主键信息
    	int contractId = BaseHelpUtils.getIntValue(result,"contractId");
    	int flowStatus = BaseHelpUtils.getIntValue(result,"flowStatus");
    	Contract dao = new Contract();
    	dao.setContractId(contractId);
    	if( dao.load()){
    		Date currentDate = new Date();
    		int oriFlowStatus = dao.getFlowStatus();
    		//第一次提交  检测是否添加了承接部门和项目积分
    		if(flowStatus ==3){
    			SubContract subDao = new SubContract();
    			subDao.setConditionParentId("=", dao.getContractId());
    			List<BaseSubContract> aList = subDao.conditionalLoad();
    			//如果没有添加子合同，则抛出异常，提示请添加子合同
    			if(BaseHelpUtils.isNullOrEmpty(aList) || aList.size() <= 0){
    				throw new SQLException("请添加子合同");
    			}
    			List<BaseSubContract> bList = subDao.conditionalLoad(" (department_id is null or department_id = 0 or sheet_total_integral is null) ");
    			//如果未选择子合同的承接部门或者未添加子合同的项目积分，则抛出异常
    			if(!BaseHelpUtils.isNullOrEmpty(bList) || bList.size() > 0){
    					throw new SQLException("请选择子合同的承接部门与添加子合同的项目积分");
    			}
    			List<BaseSubContract> paramList = GenericBase.__getList(result.get("twoSubContract"), BaseSubContract.newInstance());
    			Map<Object,Boolean> idMap = (Map<Object, Boolean>) result.get("idMap");
				if (!BaseHelpUtils.isNullOrEmpty(paramList) && paramList.size() > 0) {
					for (BaseSubContract e : paramList) {
						//如果项目管理费、采买成本和条线管理订单不存在则新增  存在则修改
						int projectType = BaseHelpUtils.getIntValue(e.getProjectType());
						if(projectType == 16 || projectType == 30 || projectType == 33){
							subDao.clear();
							if(null != e.getSubContractId() && e.getSubContractId() > 0){
								subDao.setSubContractId(e.getSubContractId());
								if(subDao.load()){
									subDao.setDataFromBase(e);
									subDao.update();
								}else{
									subDao.setDataFromBase(e);
									subDao.setCreateTime(currentDate);
									subDao.setParentId(contractId);
									subDao.save();
								}
							}else{
								subDao.setDataFromBase(e);
								subDao.setCreateTime(currentDate);
								subDao.setParentId(contractId);
								subDao.save();
							}
						}
					}
				}
				//没有勾选的项目管理费或采买成本则进行删除操作
//				for(Object value : idMap.keySet()){
//					if(!idMap.get(value)){
//						subDao.clear();
//						subDao.setSubContractId(BaseHelpUtils.getIntValue(value));
//						if(subDao.load()){
//							subDao.delete();
//						}
//					}
//				}
				
				//排除项目管理费，采买成本，预留订单进行校验承接部门和部门经理
				subDao.clear();
				subDao.setConditionParentId("=", dao.getContractId());
				Integer[] ints =new Integer[3];
				ints[0]=16;
				ints[1]=30;
				ints[2]=33;
				subDao.addCondition(BaseSubContract.CS_PROJECT_TYPE, "not in", ints);
				List<BaseSubContract> subContractList = subDao.conditionalLoad();
   				PlateRecord plateRecordDao = new PlateRecord();
				BasePlateRecord plateRecordBean;
				for (BaseSubContract baseSubContract : subContractList) {
					//先获取承接部门
					int plateId = BaseHelpUtils.getIntValue(baseSubContract.getDepartmentId());
					//获取承接部门名称
					plateRecordDao.setConditionPlateId("=",plateId);
					plateRecordBean = plateRecordDao.executeQueryOneRow();
					String plateName = "";
					if(!BaseHelpUtils.isNullOrEmpty(plateRecordBean)){
						plateName = BaseHelpUtils.getString(plateRecordBean.getPlateName());
					}
					
					//根据承接部门，去检索该业务部门下的事业部负责人和部门经理(找到该部门下角色为事业部负责人，再找到该角色下的人员，部门经理同理)
//					int plateManageId = getManageEmployeeId(plateId,StaticUtils.ROLE_PLATE_MANAGER);
//					//如果该承接部门未设定事业部负责人，则抛出异常
//					if(plateManageId <= 0){
//						throw new SQLException("承接部门("+plateName+")未设定事业部负责人,请先设定");
//					}
					//获取该部门下的部门经理
					int departmentManageId = getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER);
					//如果该承接部门未设定部门经理，则抛出异常
					if(departmentManageId <= 0){
						throw new SQLException("承接部门("+plateName+")未设定部门经理,请先设定");
					}
				}
    		}else if(flowStatus == 4){//表示价格审核同意，流程流转到事业部
    			
    			//更新附件
    			int attachmentId=BaseHelpUtils.getIntValue(result, "attachmentId");//file_id
    			String attachment=BaseHelpUtils.getStringValue(result, "attachment");//file_url
    			if(!BaseHelpUtils.isNullOrEmpty(attachmentId)&&!BaseHelpUtils.isNullOrEmpty(attachment)) {
    				dao.setFileId(attachmentId);
    				dao.setFileUrl(attachment);
    				dao.update();
    			}
    			
    			//根据主订单ID去检索所有的子订单数据集
    			SubContract subContractDao = new SubContract();
    			subContractDao.setConditionParentId("=",contractId);
    			List<BaseSubContract> subContractList = subContractDao.conditionalLoad();
    			//如果未进行子订单的拆分，则抛出异常
    			if(BaseHelpUtils.isNullOrEmpty(subContractList) || subContractList.isEmpty()){
    				throw new SQLException("没有子订单数据,请先进行子订单拆分");
    			}else{
    				Date recordDate = new Date();
    				//更新该合同下的订单的同意日期
    				subContractDao.clear();
    				subContractDao.setConditionParentId("=",contractId);
    				subContractDao.setAgreeDate(recordDate);
    				subContractDao.conditionalUpdate();
    				
    				Department dDao =new Department();
    				PlateRecord plateRecordDao = new PlateRecord();
    				BasePlateRecord plateRecordBean;
    				Project projectDao = new Project();
    				BaseProject projectBean;
    				ProjectContractChange pccDao = new ProjectContractChange();
    				PlateProjectAccountRecord pparDao = new PlateProjectAccountRecord();
    				//获取项目等级
    				int projectLevel = BaseHelpUtils.getIntValue(dao.getProjectLevel());
    				for(BaseSubContract e : subContractList){//遍历获取每一个子订单数据，并插入到项目表中
    					//获取子合同ID
    					int subProjectId = BaseHelpUtils.getIntValue(e.getSubContractId());
    					//获取合同金额
    					BigDecimal moneySum = e.getMoneySum()==null?BigDecimal.ZERO:e.getMoneySum();
    					//先获取承接部门
    					int plateId = BaseHelpUtils.getIntValue(e.getDepartmentId());
    					//归属部门
    					int departmentId = 0; 
    					dDao.clear();
    					dDao.setConditionPlateId("=", plateId);
    					if(!BaseHelpUtils.isNullOrEmpty(dDao.executeQueryOneRow())) {
    						departmentId=dDao.executeQueryOneRow().getDepartmentId();
    					}
    					
    					//获取项目类别
    					int projectType = BaseHelpUtils.getIntValue(e.getProjectType());
    					//获取订单总积分
    					BigDecimal sheetTotalIntegral = BaseHelpUtils.getBigDecimalValue(e.getSheetTotalIntegral());
    					//获取子订单编号
    					String subContractCode = BaseHelpUtils.getString(e.getSubContractCode());
    					//根据子订单编号去检索是否已生成项目，如果有项目，则不插入操作
    					projectDao.clear();
    					projectDao.setConditionSubContractId("=", subProjectId);
    					if(projectDao.countRows() > 0){//表示已经生成订单，则进行订单变更的业务操作
    						BaseProject tmpBean = projectDao.executeQueryOneRow();
    						//判断如果部门预留订单Id和已下达的不一样，则做更新
    						if(BaseHelpUtils.getIntValue(e.getReserveSheetId()) != BaseHelpUtils.getIntValue(tmpBean.getReserveSheetId())){
    							tmpBean.setReserveSheetId(e.getReserveSheetId());
    							projectDao.setDataFromBase(tmpBean);
    							projectDao.update();
    						}
    						BigDecimal totalChangeIntegral = BigDecimal.ZERO;
    						if(null != tmpBean.getTotalIntegral() && null != e.getSheetTotalIntegral()){
    							totalChangeIntegral = e.getSheetTotalIntegral().subtract(tmpBean.getTotalIntegral());
    						}
    						//定义变动的合同额
    						BigDecimal oldSheetAmount = BaseHelpUtils.getBigDecimalValue(tmpBean.getSheetAmount());
    						BigDecimal newSheetAmount = BaseHelpUtils.getBigDecimalValue(e.getMoneySum());
    						BigDecimal changeSheetAmount = oldSheetAmount.subtract(newSheetAmount);
    						
    						if(totalChangeIntegral.compareTo(BigDecimal.ZERO) != 0 || changeSheetAmount.compareTo(BigDecimal.ZERO) != 0){
    							OnProjectCommonProcess.onProjectChange(tmpBean.getProjectId(), totalChangeIntegral, null == e.getMoneySum() ? tmpBean.getSheetAmount() : e.getMoneySum(), e.getDesignArea(), e.getCommonArea(), e.getLogisticsArea());
    						}
    						continue;
    					}
    					
    					//获取承接部门名称
    					plateRecordDao.setConditionPlateId("=",plateId);
    					plateRecordBean = plateRecordDao.executeQueryOneRow();
    					String plateName = "";
    					if(!BaseHelpUtils.isNullOrEmpty(plateRecordBean)){
    						plateName = BaseHelpUtils.getString(plateRecordBean.getPlateName());
    					}
    					//根据承接部门，去检索该业务部门下的事业部负责人和部门经理(找到该部门下角色为事业部负责人，再找到该角色下的人员，部门经理同理)
//    					int plateManageId = getManageEmployeeId(plateId,StaticUtils.ROLE_PLATE_MANAGER);
//    					//如果该承接部门未设定事业部负责人，则抛出异常
//    					if(plateManageId <= 0){
//    						throw new SQLException("承接部门("+plateName+")未设定事业部负责人,请先设定");
//    					}
    					//获取该部门下的部门经理
    					int departmentManageId = BaseHelpUtils.getIntValue(getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER));
//    					//如果该承接部门未设定部门经理，则抛出异常
//    					if(departmentManageId <= 0){
//    						throw new SQLException("承接部门("+plateName+")未设定部门经理,请先设定");
//    					}
    					int projectManageId = BaseHelpUtils.getIntValue(e.getProjectManageId());
    					//插入项目表
    					projectBean = new BaseProject();
    					projectBean.setPlateId(plateId);//业务部门
    					projectBean.setDepartmentId(departmentId);
    					projectBean.setRevenuePlateId(plateId);//统计营收板块
    					projectBean.setContractCode(subContractCode);//子订单编号
    					projectBean.setPlateManagerId(0);//事业部负责人
    					projectBean.setDepartmentManagerId(departmentManageId);//部门经理
    					projectBean.setProjectName(e.getSubContractName());//项目名称，将子订单名称做为项目的名称
    					projectBean.setProjectCode(e.getProjectCode());//项目编号
    					projectBean.setProjectType(projectType);//项目类别
    					projectBean.setDesignType(e.getBusinessType());//业务类别
    					projectBean.setBusinessType(e.getBusinessType());//业务类别
    					projectBean.setBusinessLine(e.getBusinessLine());//业务条线
    					projectBean.setCommonArea(e.getCommonArea());//公区面积
    					projectBean.setLogisticsArea(e.getLogisticsArea());//后勤面积
    					projectBean.setCadArea(e.getDesignArea());//设计面积
    					projectBean.setParentId(1);//设置非630项目，说明是新项目，走新的计算公式
    					projectBean.setIsEcmcProject(Boolean.TRUE);//设置为ECMC流转下去的项目
    					projectBean.setContractId(contractId);//设置合同ID
    					projectBean.setSubContractId(subProjectId);//设置子合同ID
    					projectBean.setProjectLevel(projectLevel);//项目等级
    					projectBean.setTotalIntegral(sheetTotalIntegral);//项目总积分
    					projectBean.setHumanAmount(sheetTotalIntegral);//手工计算出的积分
    					projectBean.setMoneySum(moneySum);//设置合同金额
    					projectBean.setSheetAmount(moneySum);//设置订单金额就是该订单的合同金额
    					projectBean.setProjectManageId(projectManageId);//专业负责人
    					projectBean.setProjectIntegral(sheetTotalIntegral);//项目积分
    					projectBean.setReserveIntegral(BigDecimal.ZERO);//预留积分
    					projectBean.setPercentage(BigDecimal.ZERO);//核算比例
    					projectBean.setComplaintPercentage(BigDecimal.ZERO);//投诉保证金比例
    					projectBean.setComplaintIntegral(BigDecimal.ZERO);//投诉保证金
    					projectBean.setIsAuto(e.getIsAuto());//是否自动结算
    					projectBean.setReserveSheetId(e.getReserveSheetId());//部门预留订单Id
    					projectBean.setStatus(StaticUtils.PROJECT_STATUS_2);//设置项目状态为正在运行
//    					projectBean.setStatus(StaticUtils.PROJECT_STATUS_4);//设置项目状态为未启动
    					projectDao.clear();
    					projectDao.setDataFromBase(projectBean);
    					projectDao.save();
    					
    					//创建订单账户
    					AccountUtils.createAccount(AccountUtils.ACCOUNT_TYPE_PROJECT, projectDao.getProjectId(), AccountUtils.ACCOUNT_LEVEL_1, projectDao.getProjectName(), null, true);
    					
    					ProjectStage projectStageDao = new ProjectStage();
    					BaseProjectStage projectStageBean;
    					int projectId = projectDao.getProjectId();
    					if(projectType == StaticUtils.PROJECT_TYPE_16){
    	    				ProjectEmployee projectEmployeeDao = new ProjectEmployee();
    	    				BaseProjectEmployee projectEmployeeBean;
    						//插入阶段表
    						projectStageBean = new BaseProjectStage();
    						projectStageBean.setProjectId(projectId);
    						projectStageBean.setStageId(31);
    						projectStageBean.setPercent(new BigDecimal(100));
    						projectStageBean.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
    						if(projectType == StaticUtils.PROJECT_TYPE_16){
    							projectStageBean.setProjectAmount(sheetTotalIntegral);
    						}else{
    							projectStageBean.setProjectAmount(BigDecimal.ZERO);
    						}
    						projectStageBean.setStageName("管理全阶段");
    						projectStageDao.setDataFromBase(projectStageBean);
    						projectStageDao.save();
    						
    						if(projectManageId > 0) {
    							projectEmployeeBean = new BaseProjectEmployee();
    							projectEmployeeBean.setProjectId(projectId);
    							projectEmployeeBean.setStageId(31);
    							projectEmployeeBean.setEmployeeId(projectManageId);
    							if(projectType == StaticUtils.PROJECT_TYPE_16){
    								projectEmployeeBean.setPlanIntegral(sheetTotalIntegral);
    							}else{
    								projectEmployeeBean.setPlanIntegral(BigDecimal.ZERO);
    							}
    							projectEmployeeDao.setDataFromBase(projectEmployeeBean);
    							projectEmployeeDao.save();
    						}
    					}else {
    						projectStageDao.clear();
    						projectStageDao.setConditionContractId("=", contractId);
    						//订单已下单成功，那么更改status状态，让他可以进行可分配阶段确认 
    						projectStageDao.setStatus(StaticUtils.PROJECT_STAGES_STAUTS_1);
    						projectStageDao.conditionalUpdate();
    					}

						Set<Integer> set=getDepartmentManageId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER);
						for (Integer emid : set) {
							String content = "您好，订单 【"+e.getSubContractName()+"】，订单编号为 【"+subContractCode+"】的订单下达审批通过，到达 （"+plateName+"）,"+"请您登录ERP系统查看，谢谢！";
							ERPWeixinUtils.sendWXMsgToUser(emid, content);
						}
    				}
    			}
    			
    		}
    		//判断主合同要进入的流程是否至于原流程想差一步 且大于流程  则进入下一步流程 否则提示不可操作
    		if(flowStatus ==0 || flowStatus ==3 || (flowStatus - oriFlowStatus) == 1){
    			dao.setFlowStatus(flowStatus);
    			dao.setUpdateTime(new Date());
    			dao.update();
    		}
    	}
    	//根据合同Id初始化订单的提成系数
		MarketingCommission marketingCommission = new MarketingCommission();
		marketingCommission.getProjectRateByContractId(contractId);
		ThreadConnection.commit();
    	return bc.toJSON(1, null);
    }
    
    /**
     * 获取业务部门下对应的归属部门下的部门负责人和部门经理
     * @param plateId
     * @param roleId
     * @return
     * @throws SQLException 
     */
    public static int getManageEmployeeId(int plateId,int roleId) throws SQLException{
    	int manageEmployeeId =  0;
    	Department dao = new Department();
    	dao.setConditionPlateId("=",plateId);
    	dao.setConditionDeleteFlag("=", 0);
    	List<BaseDepartment> list = dao.conditionalLoad("order by department_id asc");
    	if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
    		EmployeeRole employeeRoleDao = new EmployeeRole();
    		BaseEmployeeRole employeeRoleBean = null;
    		for(BaseDepartment bean : list){
    			//获取部门Id
    			int departmentId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
    			employeeRoleDao.clear();
    			employeeRoleDao.setConditionDepartmentId("=",departmentId);
				employeeRoleDao.setConditionRoleId("=",roleId);
				employeeRoleBean = employeeRoleDao.executeQueryOneRow();
				if(!BaseHelpUtils.isNullOrEmpty(employeeRoleBean)){
					int empId = BaseHelpUtils.getIntValue(employeeRoleBean.getEmployeeId());
					if(empId > 0){
						manageEmployeeId = employeeRoleBean.getEmployeeId();
						break;
					}
				}
    		}
    	}
    	return manageEmployeeId;
    }
    
    /**
     * 
     * @Title: getSerialNumber 
     * @Description: 
     * @param @return
     * @param @throws Exception    
     * @return String   
     * @throws
     */
	private String getSerialNumber() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DATE, 1);
		Date startDate = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		Date endDate = calendar.getTime();
		ContractSerialNumber numberDao = new ContractSerialNumber();
		StringBuilder sql = new StringBuilder();
		sql.append(BaseContractSerialNumber.CS_PRODUCE_DATE).append(" >= '").append(startDate).append("'")
				.append(" and ").append(BaseContractSerialNumber.CS_PRODUCE_DATE).append(" <= '").append(endDate)
				.append("'").append(" order by ").append(BaseContractSerialNumber.CS_SERIAL_NUMBER).append(" desc");
		List<BaseContractSerialNumber> numberList = numberDao.conditionalLoad(sql.toString());
		Integer serialNumber = 1;
		if (null != numberList && !numberList.isEmpty()) {
			serialNumber = numberList.get(0).getSerialNumber() + 1;
		}
		numberDao.clear();
		numberDao.setProduceDate(new Date());
		numberDao.setSerialNumber(serialNumber);
		numberDao.save();
		return String.format("%03d", serialNumber);
	}
    
	private String getAllContract() throws Exception {
		BaseCollection<BaseContract> bc = new BaseCollection<>();
		Contract dao = new Contract();
        List<BaseContract> ds = dao.conditionalLoad();
        bc.setCollections(ds);
		return bc.toJSON(1, "");
	}
	
	/**
	 * 
	 * @Title: getContractCode 
	 * @Description: 
	 * @param @param dao
	 * @param @return
	 * @param @throws Exception    
	 * @return String   
	 * @throws
	 */
	public String getContractCode(Contract dao) throws Exception {
		if (!BaseHelpUtils.isNullOrEmpty(dao) && !BaseHelpUtils.isNullOrEmpty(dao.getSigningCompanyName())) {
			StringBuilder sb = new StringBuilder();
			switch (dao.getSigningCompanyName()) {
			case StaticUtils.SIGN_COMPANY_0:
				sb.append("JA.");
				break;
			case StaticUtils.SIGN_COMPANY_1:
				sb.append("BP.");
				break;
			case StaticUtils.SIGN_COMPANY_2:
				sb.append("JF.");
				break;
			case StaticUtils.SIGN_COMPANY_3:
				sb.append("JK.");
				break;
			case StaticUtils.SIGN_COMPANY_4:
				sb.append("WH.");
				break;
			case StaticUtils.SIGN_COMPANY_5:
				sb.append("SH.");
				break;
			case StaticUtils.SIGN_COMPANY_6:
				sb.append("BJ.");
				break;
			case StaticUtils.SIGN_COMPANY_7:
				sb.append("DL.");
				break;
			case StaticUtils.SIGN_COMPANY_8:
				sb.append("JT.");
				break;
			case StaticUtils.SIGN_COMPANY_9:
				sb.append("JH.");
				break;
			default:
				break;
			}
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dao.getProjectApprovalTime());
			sb.append(calendar.get(Calendar.YEAR));
			sb.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
			sb.append(dao.getSerialNumber());
			Integer orderNo = dao.getOrderNo();
			if (!BaseHelpUtils.isNullOrEmpty(orderNo) && orderNo > 0) {
				sb.append("(").append(String.format("%02d", orderNo)).append(")");
			}
			return sb.toString();
		} else {
			throw new Exception("沒有选择我方签约公司，无法生成主合同编号");
		}
	}
	
	/**
	 * 
	 * @Title: newContractCode 
	 * @Description: 创建合同编号(线下合同先走时创建)
	 * @param @param signCompany
	 * @param @param time
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public String newContractCode(int signCompany, Date time) throws Exception {
		StringBuilder sb = new StringBuilder();
		switch (signCompany) {
		case StaticUtils.SIGN_COMPANY_0:
			sb.append("JA.");
			break;
		case StaticUtils.SIGN_COMPANY_1:
			sb.append("BP.");
			break;
		case StaticUtils.SIGN_COMPANY_2:
			sb.append("JF.");
			break;
		case StaticUtils.SIGN_COMPANY_3:
			sb.append("JK.");
			break;
		case StaticUtils.SIGN_COMPANY_4:
			sb.append("WH.");
			break;
		case StaticUtils.SIGN_COMPANY_5:
			sb.append("SH.");
			break;
		case StaticUtils.SIGN_COMPANY_6:
			sb.append("BJ.");
			break;
		case StaticUtils.SIGN_COMPANY_7:
			sb.append("DL.");
			break;
		case StaticUtils.SIGN_COMPANY_8:
			sb.append("JT.");
			break;
		case StaticUtils.SIGN_COMPANY_9:
			sb.append("JH.");
			break;
		default:
			break;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		sb.append(calendar.get(Calendar.YEAR));
		sb.append(String.format("%02d", calendar.get(Calendar.MONTH) + 1));
		sb.append(newSerialNumber(signCompany,time));
		return sb.toString();
	}
	
	private String newSerialNumber(int signCompany,Date time) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.set(Calendar.DATE, 1);
		Date startDate = calendar.getTime();
		calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
		Date endDate = calendar.getTime();
		ContractSerialNumber numberDao = new ContractSerialNumber();
		StringBuilder sql = new StringBuilder();
		sql.append(BaseContractSerialNumber.CS_PRODUCE_DATE).append(" >= '")
		.append(startDate).append("'")
				.append(" and ").append(BaseContractSerialNumber.CS_PRODUCE_DATE).append(" <= '").append(endDate)
				.append("' and ").append(BaseContractSerialNumber.CS_SIGNING_COMPANY_NAME)
				.append("=").append(signCompany)
				.append(" order by ").append(BaseContractSerialNumber.CS_SERIAL_NUMBER).append(" desc");
		List<BaseContractSerialNumber> numberList = numberDao.conditionalLoad(sql.toString());
		Integer serialNumber = 1;
		if (null != numberList && !numberList.isEmpty()) {
			serialNumber = numberList.get(0).getSerialNumber() + 1;
		}
		numberDao.clear();
		numberDao.setProduceDate(time);
		numberDao.setSerialNumber(serialNumber);
		numberDao.setSigningCompanyName(signCompany);
		numberDao.save();
		return String.format("%03d", serialNumber);
	}
	
	/**
	 * 
	 * @Title: createContractCode 
	 * @Description: 创建合同编号
	 * @param @param result
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public String createContractCode(Map<String, Object> result) throws Exception {
		String errorMessage = null;
		int successed = 1;
		Contract checkDao = new Contract();
		ContractCode dao = new ContractCode();
		BaseContractCode bean = new BaseContractCode();
		bean.setDataFromMap(result);
		String contractCode = newContractCode(bean.getSignCompany(), new Date());
		bean.setContractCode(contractCode);
		checkDao.setConditionContractCode("=", contractCode);
		if(checkDao.countRows() > 0){
			successed = -1;
			errorMessage = "合同编号生成规则出错 contractCode = " + contractCode;
		}else{
			dao.setConditionContractCode("=", contractCode);
			if(dao.countRows() > 0){
				successed = -1;
				errorMessage = "合同编号生成规则出错 contractCode = " + contractCode;
			}else{
				dao.setDataFromBase(bean);
				dao.save();
			}
		}
		return dao.generateBase().toOneLineJSON(successed, errorMessage);
	}

	
	/**
	 * 找业务部门下所有部门经理
	 * @param plateId
	 * @param roleId
	 * @return
	 * @throws SQLException
	 */
	public static Set<Integer>  getDepartmentManageId(int plateId,int roleId) throws SQLException{
		Set<Integer>  set=new HashSet<>();
		Department dao = new Department();
		dao.setConditionPlateId("=",plateId);
		dao.setConditionDeleteFlag("=", 0);
		List<BaseDepartment> list = dao.conditionalLoad("order by department_id asc");
		if(!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0){
			EmployeeRole employeeRoleDao = new EmployeeRole();
			for(BaseDepartment bean : list){
				//获取部门Id
				int departmentId = BaseHelpUtils.getIntValue(bean.getDepartmentId());
				employeeRoleDao.clear();
				employeeRoleDao.setConditionDepartmentId("=",departmentId);
				employeeRoleDao.setConditionRoleId("=",roleId);
				List<BaseEmployeeRole> rlist = employeeRoleDao.conditionalLoad();
				if(!BaseHelpUtils.isNullOrEmpty(rlist)&&rlist.size()>0){
					for (BaseEmployeeRole rbean : rlist) {
						int empId = BaseHelpUtils.getIntValue(rbean.getEmployeeId());
						if(empId > 0){
							set.add(empId);
						}
					}
				}
				break;
			}
		}
		return set;
	}
	
	
	public static void main(String[] args) throws SQLException {
		SubContract subDao  =new SubContract();
		subDao.setConditionParentId("=", 2046);
		Integer[] ints =new Integer[3];
		ints[0]=16;
		ints[1]=30;
		ints[2]=33;
		subDao.addCondition(BaseSubContract.CS_PROJECT_TYPE, "not in", ints);
		List<BaseSubContract> subContractList = subDao.conditionalLoad();
		for (BaseSubContract baseSubContract : subContractList) {
			System.out.println(baseSubContract.toString());
		}
	}
	
}
