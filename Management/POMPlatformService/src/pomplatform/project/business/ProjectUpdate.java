package pomplatform.project.business;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;
import pomplatform.department.bean.BaseOnLoadDepartmentByParentId;
import pomplatform.department.bean.ConditionOnLoadDepartmentByParentId;
import pomplatform.department.query.QueryOnLoadDepartmentByParentId;

/**
 *
 * @author guanxgun
 */
public class ProjectUpdate implements GenericProcessor {

	public static void main(String[] args) {
		try {
			ProjectUpdate pu = new ProjectUpdate();
			pu.execute(
					"{\"projectType\":3,\"oldProjectDiscount\":0,\"commonArea\":\"3000\",\"logisticsArea\":0,\"percentage\":\"0\",\"contractCode\":\"J&A/SJ2016006\",\"projectCode\":\"J&A/SJ2016006-O\",\"projectName\":\"《西安高新NEWorld项目室内设计项目》\",\"projectManageId\":14,\"totalAmount\":20000,\"officeType\":6,\"projectId\":123,\"contractName\":\"《西安高新NEWorld项目室内设计合同》\",\"customerName\":\"西安海科重工 投资有限公司\",\"departmentId\":21,\"status\":0,\"projectIntegral\":\"75000\",\"departmentManagerId\":12,\"plateId\":3,\"totalIntegral\":\"75000\",\"reserveIntegral\":\"0\"}",
					null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/*@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		
        JSON parser = new JSON(new StringReader(creteria));
        Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        boolean isOrNot = false;
//        int initiateDesign = BaseHelpUtils.getIntValue(params.get("initiateDesign"));
        List<Integer> initiateDesignList =new ArrayList<>();
        List<BaseProjectTransition> baseProjectTransitionList =new ArrayList<>();
        
        int operator = BaseHelpUtils.getIntValue(params.get("operator"));
        String projectCode = BaseHelpUtils.getStringValue(params, "projectCode");
        ProjectTransition ptDao =new ProjectTransition();
    	Employee eDao =new Employee();
    	eDao.setConditionEmployeeId("=", operator);
    	eDao.setEmployeeId(operator);
    	if(eDao.load()) {
    		Integer departmentid = eDao.getDepartmentId();
    		
    		QueryOnLoadDepartmentByParentId query =new  QueryOnLoadDepartmentByParentId();
    		ConditionOnLoadDepartmentByParentId condition =new ConditionOnLoadDepartmentByParentId();
    		condition.setDepartmentId(StaticUtils.DEPARTMENT_7);
    		BaseCollection<BaseOnLoadDepartmentByParentId> execute = query.execute(null, condition);
    		if(!BaseHelpUtils.isNullOrEmpty(execute)&&execute.getCollections().size()>0) {
    			List<BaseOnLoadDepartmentByParentId> collections = execute.getCollections();
    			for (BaseOnLoadDepartmentByParentId baseOnLoadDepartmentByParentId : collections) {
    				Integer depId = baseOnLoadDepartmentByParentId.getDepartmentId();
    				if(departmentid == depId) {
    					//发起人属于方案设计部
    	    			isOrNot=true;
    	    			MainProject mDao =new MainProject();
    	    			mDao.setConditionProjectCode("=", projectCode);
    	    			BaseMainProject baseMainProject = mDao.executeQueryOneRow();
    	    			if(!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
    	    				MainProjectEmployee mpeDao =new MainProjectEmployee();
    	    				mpeDao.setConditionMainProjectId("=", baseMainProject.getMainProjectId());
    	    				mpeDao.setConditionRelation("=", 5);
    	    				List<BaseMainProjectEmployee> conditionalLoad = mpeDao.conditionalLoad();
    	    				if(conditionalLoad.size()<=0) {
    	    					throw new SQLException("错误！未设定项目负责人");
    	    				}else {
    	    					for (BaseMainProjectEmployee baseMainProjectEmployee : conditionalLoad) {
    	    						if(baseMainProjectEmployee.getEmployeeId()>0) {
    	    							initiateDesignList.add(baseMainProjectEmployee.getEmployeeId());
    	    						}
    							}
    	    				}
    	    			}else {
    	    				throw new SQLException("错误！ 立项信息获取失败");
    	    			}
    	    			break;
    				}
				}
    		}else {
    			throw new SQLException("错误！ 发起人信息获取失败");
    		}
    	}else {
    		throw new SQLException("错误！ 发起人信息获取失败");
    	}
    	
    	// 创建中间表记录
        BaseProject bp = new BaseProject();
        bp.setDataFromJSON(creteria);
        HttpCookie hc = new HttpCookie(request);
        Project dao = new Project();
        dao.setPrimaryKeyFromBase(bp);
		if (dao.load()) {
			// errorReturnProjectInfo为当发生错误或者因特殊情况不能成功执行本次修改操作的时候，返回到页面上的原始数据
			BaseProject errorReturnProjectInfo = dao.generateBase();
			dao.setDataFromBase(bp);
			// 获取项目ID
			int projectId = BaseHelpUtils.getIntValue(bp.getProjectId());
			ColumnChangedData projectIntegralChange = dao.getColumnChangedData(BaseProject.CS_PROJECT_INTEGRAL);
			*//**
			 * 如果项目积分变动，以下的特殊情况作特殊处理
			 * ①假如该项目已经有结算的记录了，那么不允许修改该项目的项目积分
			 * ②该项目没有结算记录，但是已经将项目积分预分配到项目成员身上，这时候修改项目积分的话，
			 * 只要保证最后计算出来的"新的项目积分">="已分配到成员身上的积分总和" 就可以执行该修改操作，否则，不予以修改
			 *//*
			// 项目积分发生了变动
			if (null != projectIntegralChange && BaseHelpUtils.getBigDecimalValue(projectIntegralChange.getOriginal()).compareTo(BaseHelpUtils.getBigDecimalValue(projectIntegralChange.getValue())) != 0) {
				// 根据项目ID获取该项目的结算记录条数
				ProjectSettlement projectSettlementDao = new ProjectSettlement();
				projectSettlementDao.setConditionProjectId("=", projectId);
				if (projectSettlementDao.countRows() > 0) {
					// 如果该项目已有结算记录，且本次修改了核算比例，则不执行更新操作，直接返回原始数据
					return errorReturnProjectInfo.toOneLineJSON(-1, "该项目已有结算记录，不能修改核算比例");
				}
			}
		}else {
			return bp.toOneLineJSON(-1, "项目信息获取失败!");
		}
        
        
    	if(isOrNot) {
    		for (Integer integer : initiateDesignList) {
    			BaseProjectTransition baseProjectTransition = new BaseProjectTransition();
        		baseProjectTransition.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
        		baseProjectTransition.setProjectManageId( BaseHelpUtils.getIntValue(params.get("projectManageId")));
        		baseProjectTransition.setPercent(BaseHelpUtils.getBigDecimalValue(params.get("percentage")));
        		baseProjectTransition.setIsOrNot(isOrNot);
        		baseProjectTransition.setInitiateDesign(integer);
        		baseProjectTransition.setOperator(operator);
        		baseProjectTransition.setCreateTime(new Date());
        		baseProjectTransition.setStatus(StaticUtils.PROJECT_TRANSITIONS_STAUTS_1);//带审批中
        		baseProjectTransitionList.add(baseProjectTransition);
    		}
            ptDao.save(baseProjectTransitionList);
    		ERPWeixinUtils.sendTextMsgToUser(eDao.getCompanyWeixin(), "更改订单编号("+projectCode+")的专业负责人记录待审批,请尽快处理");
    	}else {
    		BaseProjectTransition baseProjectTransition = new BaseProjectTransition();
    		baseProjectTransition.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
    		baseProjectTransition.setProjectManageId( BaseHelpUtils.getIntValue(params.get("projectManageId")));
    		baseProjectTransition.setPercent(BaseHelpUtils.getBigDecimalValue(params.get("percentage")));
    		baseProjectTransition.setIsOrNot(isOrNot);
//    		baseProjectTransition.setInitiateDesign(0);
    		baseProjectTransition.setOperator(operator);
    		baseProjectTransition.setCreateTime(new Date());
    		baseProjectTransition.setStatus(StaticUtils.PROJECT_TRANSITIONS_STAUTS_0);//用作记录
//    		baseProjectTransitionList.add(baseProjectTransition);

    		//更换项目经理
    		ColumnChangedData ccd = dao.getColumnChangedData(BaseProject.CS_PROJECT_MANAGE_ID);
    		dao.update();
    		if (ccd != null) {
    			ProjectEmployee pe = new ProjectEmployee();
    			if (ccd.getOriginal() != null) {
    				//检索当原专业负责人在该项目上已经有了确认积分记录，则不做删除
    				int employeeId = BaseHelpUtils.getIntValue(ccd.getOriginal());
    				ProjectSettlementDetail settDao = new ProjectSettlementDetail();
    				settDao.setConditionProjectId("=", dao.getProjectId());
    				settDao.setConditionEmployeeId("=",employeeId);
    				if(settDao.countRows() <= 0){
    					pe.setConditionProjectId("=", dao.getProjectId());
    					pe.setConditionEmployeeId("=", employeeId);
    					pe.conditionalDelete();
    				}
    			}
    			if (ccd.getValue() != null) {
    				pe.setProjectId(dao.getProjectId());
    				pe.setEmployeeId(BaseHelpUtils.getIntValue(ccd.getValue()));
    				pe.setPlanStartDate(dao.getPlanStartDate());
    				pe.setPlanEndDate(dao.getPlanEndDate());
    				pe.setStatus(2);
    				pe.setAlternateField2("2");//设置默认值为2，表示已完成。
    				pe.save();
    			}
    		}
    		
    		ProjectLog pl = new ProjectLog();
    		pl.setProjectId(dao.getProjectId());
    		pl.setOperateId(hc.getOperatorId());
    		pl.setOperateTime(new Date());
    		pl.setLogType(0);
    		pl.setDepartmentId(hc.getDepartmentId());
    		pl.setManagerId(hc.getOperatorId());
    		pl.setLogContent(String.format("%1$s修改了%2$s项目", hc.getOperatorName(), dao.getProjectName()));
    		pl.save();
    		
          ptDao.setDataFromBase(baseProjectTransition);  
          ptDao.save();
        
    	}
        
		ThreadConnection.commit();
		return bp.toOneLineJSON(0, null);
	}*/

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();

		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());

		int operator = BaseHelpUtils.getIntValue(params.get("operator"));
		BigDecimal newPercentage = BaseHelpUtils.getBigDecimalValue(params.get("percentage"));
		int newProjectManageId = BaseHelpUtils.getIntValue(params.get("projectManageId"));
		ProfessionalApproval paDao = new ProfessionalApproval();

		BaseProject bp = new BaseProject();
		bp.setDataFromJSON(creteria);
		HttpCookie hc = new HttpCookie(request);
		Project dao = new Project();
		dao.setPrimaryKeyFromBase(bp);
		if (dao.load()) {
			BigDecimal totalIntegral = dao.getTotalIntegral();
			BigDecimal percentage =newPercentage.multiply(new BigDecimal(0.01)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
			//预留积分
			BigDecimal reserveIntegral = totalIntegral.multiply(percentage).setScale(2, BigDecimal.ROUND_HALF_DOWN);
			//项目积分
			BigDecimal projectIntegral = totalIntegral.subtract(reserveIntegral);
			dao.setReserveIntegral(reserveIntegral);
			dao.setProjectIntegral(projectIntegral);
			dao.setProjectManageId(newProjectManageId);
			dao.setPercentage(newPercentage);

		}else{
			return bp.toOneLineJSON(-1, "项目信息获取失败!");
		}

		// 创建中间表记录
		/*BaseProjectTransition baseProjectTransition = new BaseProjectTransition();
		baseProjectTransition.setProjectId(BaseHelpUtils.getIntValue(params.get("projectId")));
		baseProjectTransition.setProjectManageId( BaseHelpUtils.getIntValue(params.get("projectManageId")));
		baseProjectTransition.setPercent(BaseHelpUtils.getBigDecimalValue(params.get("percentage")));
		baseProjectTransition.setIsOrNot(isOrNot);
		baseProjectTransition.setOperator(operator);
		baseProjectTransition.setCreateTime(new Date());
		baseProjectTransition.setStatus(StaticUtils.PROJECT_TRANSITIONS_STAUTS_0);//用作记录*/

		BaseProfessionalApproval baseProfessionalApproval = new BaseProfessionalApproval();
		baseProfessionalApproval.setDataFromMap(params);
		baseProfessionalApproval.setStatus(StaticUtils.PROJECT_TRANSITIONS_STAUTS_0);//用作记录
		//baseProfessionalApproval.setEmployeeId(operator);

		//更换项目经理
		ColumnChangedData ccd = dao.getColumnChangedData(BaseProject.CS_PROJECT_MANAGE_ID);

		if (ccd != null) {
			ProjectEmployee pe = new ProjectEmployee();
			if (ccd.getOriginal() != null) {
				//检索当原专业负责人在该项目上已经有了确认积分记录，则不做删除
				int employeeId = BaseHelpUtils.getIntValue(ccd.getOriginal());
				ProjectSettlementDetail settDao = new ProjectSettlementDetail();
				settDao.setConditionProjectId("=", dao.getProjectId());
				settDao.setConditionEmployeeId("=",employeeId);
				if(settDao.countRows() <= 0){
					pe.setConditionProjectId("=", dao.getProjectId());
					pe.setConditionEmployeeId("=", employeeId);
					pe.conditionalDelete();
				}
			}
			if (ccd.getValue() != null) {
				pe.setProjectId(dao.getProjectId());
				pe.setEmployeeId(BaseHelpUtils.getIntValue(ccd.getValue()));
				pe.setPlanStartDate(dao.getPlanStartDate());
				pe.setPlanEndDate(dao.getPlanEndDate());
				pe.setStatus(2);
				pe.setAlternateField2("2");//设置默认值为2，表示已完成。
				pe.save();
			}
		}
		dao.update();

		Employee pmDao =new Employee();
		pmDao.setEmployeeId(newProjectManageId);
		if(pmDao.load()) {
			paDao.setProjectManageDepartmentId(pmDao.getDepartmentId());
			paDao.setProjectManageName(pmDao.getEmployeeName());
			paDao.setEmployeeId(pmDao.getEmployeeId());
			paDao.setEmployeeNo(pmDao.getEmployeeNo());
			paDao.setContractId(dao.getContractId());
		}else{
			throw new SQLException("错误！ 专业负责人信息获取失败");
		}

		ProjectLog pl = new ProjectLog();
		pl.setProjectId(dao.getProjectId());
		pl.setOperateId(hc.getOperatorId());
		pl.setOperateTime(new Date());
		pl.setLogType(0);
		pl.setDepartmentId(hc.getDepartmentId());
		pl.setManagerId(hc.getOperatorId());
		pl.setLogContent(String.format("%1$s修改了%2$s项目", hc.getOperatorName(), dao.getProjectName()));
		pl.save();

		paDao.setDataFromBase(baseProfessionalApproval);
		paDao.save();

		ThreadConnection.commit();
		return bp.toOneLineJSON(0, null);
	}
	
}
