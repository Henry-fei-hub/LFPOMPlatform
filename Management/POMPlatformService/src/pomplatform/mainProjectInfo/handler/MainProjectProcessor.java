package pomplatform.mainProjectInfo.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.*;
import com.pomplatform.db.dao.*;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.contract.handler.CustomMainContractHandler;
import pomplatform.mainProjectInfo.bean.BasePersonnelBusinessWithProject;
import pomplatform.project.business.OnProjectCommonProcess;

public class MainProjectProcessor implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		case "updateMainProject":
			return updateMainProject(params);
		case "updatePreProject":
			return updatePreProject(params);
		default:
			return null;
		}
	}

	/**
	 * @param null
	 * @return
	 * @author liubin
	 * @creed: write code
	 * @date 2020-05-20 14:42
	 * @describe: 落标的时候直接更新状态
	 */
	private String updatePreProject(Map<String, Object> params) throws Exception {
		//关闭前期项目
		PreProject pDao =new 	PreProject();
		String infoCode = BaseHelpUtils.getStringValue(params, "infoCode");
		String projectCode = BaseHelpUtils.getString(params.get("projectCode"));
		pDao.setConditionInfoCode("=", infoCode);
		BasePreProject preProject = pDao.executeQueryOneRow();
		if(!BaseHelpUtils.isNullOrEmpty(preProject)) {
			preProject.setStatus(5);//关闭成功
			preProject.setCloseReason(BaseHelpUtils.getStringValue(params, "projectType"));
			preProject.setCloseRemark(BaseHelpUtils.getStringValue(params, "reason"));
			pDao.clear();
			pDao.setDataFromBase(preProject);
			pDao.update();
		}else {
			throw new SQLException("前期项目查询失败");
		}
		//更新大项目状态为落标
		MainProject mainProject = new MainProject();
		mainProject.setConditionProjectCode("=", projectCode);
		System.out.println("-------------------------------------------------------- `projectCode");
		BaseMainProject baseMainProject = mainProject.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(baseMainProject)) {
			System.out.println("-------------------------------------------------------- `1111111");
			baseMainProject.setBidType(3);
			mainProject.clear();
			mainProject.setDataFromBase(baseMainProject);
			mainProject.update();
		}
		BaseCollection<GenericBase> baseCollection = new BaseCollection<>();
		return baseCollection.toJSON(1, "更新成功");
	}

	public static void main(String[] args) throws Exception {
		MainProjectEmployee empDao = new MainProjectEmployee();
		Object [] a =new Object[3];
		a [0] = 1;  
		a [1] = 3;  
		a [2] = 5;  
		empDao.setConditionMainProjectId("=", 1789);
		empDao.addCondition(BaseMainProjectEmployee.CS_RELATION, "in", a);
		
		List<BaseMainProjectEmployee> conditionalLoad = empDao.conditionalLoad();
		
		
	}

	public static String updateMainProject(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		
		int mainProjectId = BaseHelpUtils.getIntValue(params.get("mainProjectId"));
		if(mainProjectId<=0){
			throw new SQLException("立项信息获取失败！");
		}
		ThreadConnection.beginTransaction();
		
		Customer cusDao = new Customer();
		int clientId = BaseHelpUtils.getIntValue(params.get("clientId"));
		cusDao.setConditionCustomerId("=", clientId);
		cusDao.setCustomerId(clientId);
		// 如果客户不存在则添加
		if (!cusDao.load()) {
			throw new SQLException("客户新增获取失败！");
		}else {
			params.put("clientId", clientId);
			params.put("customerName", cusDao.getCustomerName());
		}
		
		
		MainProject mp = new MainProject();
		BaseMainProject mpBase =new BaseMainProject();
		mpBase.setDataFromMap(params);
		mp.setDataFromBase(mpBase);
		mp.update();
		
		Contract cDao = new Contract();
//		cDao.setConditionInfoCode("=", mpBase.getInfoCode());
		cDao.setConditionProjectCode("=", mpBase.getProjectCode());
		cDao.setProjectLevel(mpBase.getProjectLevel());
		cDao.setSigningCompanyName(mpBase.getSignCompany());
		cDao.setCustomerName(mpBase.getCustomerName());
		cDao.conditionalUpdate();
		
		MainProjectEmployee empDao = new MainProjectEmployee();
		BaseMainProjectEmployee empBean = null;
		List<BaseMainProjectEmployee> salePersonList = GenericBase.__getList(params.get("salePersonReocrd"),
				BaseMainProjectEmployee.newInstance());
		List<BaseEmployee> projectManageList = GenericBase.__getList(params.get("projectManageReocrd"),
				BaseEmployee.newInstance());
		List<BaseEmployee> projectResponsibleList = GenericBase.__getList(params.get("projectResponsibleRecord"), BaseEmployee.newInstance());
		List<BaseProject> projectType16List = GenericBase.__getList(params.get("projectType16Record"), BaseProject.newInstance());
		List<BaseMainProjectSpecialty> specialtyReocrdList = GenericBase.__getList(params.get("specialtyReocrd"), BaseMainProjectSpecialty.newInstance());
		
		
		//参与专业
		if (!BaseHelpUtils.isNullOrEmpty(specialtyReocrdList) && specialtyReocrdList.size() > 0) {
			MainProjectSpecialty mps =new MainProjectSpecialty();
			for (BaseMainProjectSpecialty baseMainProjectSpecialty : specialtyReocrdList) {
				
				mps.clear();
				int mainProjectSpecialtyId = BaseHelpUtils.getIntValue(baseMainProjectSpecialty.getMainProjectSpecialtyId());
				if(mainProjectSpecialtyId>0) {
					mps.setDataFromBase(baseMainProjectSpecialty);
					mps.update();
				}else {
					baseMainProjectSpecialty.setMainProjectId(mainProjectId);
					mps.setDataFromBase(baseMainProjectSpecialty);
					mps.save();	
				}
			}
		}
		
		
		// 项目秘书
		List<BaseMainProjectEmployee> employeeList = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(salePersonList) && salePersonList.size() > 0) {
			for (BaseMainProjectEmployee a : salePersonList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(a.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(1);//项目秘书
				empBean.setMainAndAssistance(a.getMainAndAssistance());
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		
		// 项目经理
		if (!BaseHelpUtils.isNullOrEmpty(projectManageList) && projectManageList.size() > 0) {
			for (BaseEmployee c : projectManageList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(c.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(3);// 项目经理
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 项目负责人
		if (!BaseHelpUtils.isNullOrEmpty(projectResponsibleList) && projectResponsibleList.size() > 0) {
			for (BaseEmployee c : projectResponsibleList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(c.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(5);// 专业负责人
				employeeList.add(empBean);
			}
		}
		
		if (employeeList.size() > 0 && mainProjectId > 0) {
			Object [] a =new Object[3];
			a [0] = 1;  
			a [1] = 3;  
			a [2] = 5;  
			empDao.setConditionMainProjectId("=", mainProjectId);
			empDao.addCondition(BaseMainProjectEmployee.CS_RELATION, "in", a);
			empDao.conditionalDelete();
			empDao.save(employeeList);
		}
		
		Project p =new Project();
		SubContract sc =new SubContract();
		ProjectSettlement ps =new ProjectSettlement();
		for (BaseProject baseProject : projectType16List) {
			
			String SubContractCode = baseProject.getContractCode();
			Integer plateId = baseProject.getPlateId();
			sc.clear();
			sc.setConditionSubContractCode("=", SubContractCode);
			BaseSubContract baseSubContract = sc.executeQueryOneRow();
			
			CustomMainContractHandler csch =new CustomMainContractHandler(); 
			int departmentManageId = BaseHelpUtils.getIntValue(csch.getManageEmployeeId(plateId,StaticUtils.ROLE_OPERATIONS_MANAGER));
			
			p.clear();
			baseProject.setContractCode(SubContractCode);
			baseProject.setDepartmentManagerId(departmentManageId);
			p.setDataFromBase(baseProject);
			p.update();
			
			sc.clear();
			baseSubContract.setDepartmentId(baseProject.getPlateId());
			baseSubContract.setProjectManageId(baseProject.getProjectManageId());
			baseSubContract.setSubContractCode(SubContractCode);
			sc.setDataFromBase(baseSubContract);
			sc.update();
			
		}
		
		
		ThreadConnection.commit();
		return bc.toJSON();
	}
}
