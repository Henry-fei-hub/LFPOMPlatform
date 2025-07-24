package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseProfessionalApproval;
import java.util.List;
import com.pomplatform.db.dao.ProfessionalApproval;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class ProfessionalApprovalHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ProfessionalApprovalHandler.class);

	public static BaseProfessionalApproval getProfessionalApprovalById( 
		Integer professional_approval__id
	) throws Exception
	{
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setProfessionalApproval_id(professional_approval__id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isProfessionalApprovalExists( BaseProfessionalApproval bean, String additional ) throws Exception {

		ProfessionalApproval dao = new ProfessionalApproval();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countProfessionalApproval( BaseProfessionalApproval bean, String additional ) throws Exception {

		ProfessionalApproval dao = new ProfessionalApproval();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseProfessionalApproval> queryProfessionalApproval( BaseProfessionalApproval bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ProfessionalApproval dao = new ProfessionalApproval();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		List<BaseProfessionalApproval> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseProfessionalApproval> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseProfessionalApproval addToProfessionalApproval ( BaseProfessionalApproval professionalapproval )  throws Exception {
		return addToProfessionalApproval ( professionalapproval , false);
	}

	public static BaseProfessionalApproval addToProfessionalApproval ( BaseProfessionalApproval professionalapproval, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setDataFromBase(professionalapproval);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseProfessionalApproval addUpdateProfessionalApproval ( BaseProfessionalApproval professionalapproval ) throws Exception {
		return addUpdateProfessionalApproval ( professionalapproval , false);
	}

	public static BaseProfessionalApproval addUpdateProfessionalApproval ( BaseProfessionalApproval professionalapproval, boolean singleTransaction  ) throws Exception {
		if(professionalapproval.getProfessionalApproval_id() == null) return addToProfessionalApproval(professionalapproval);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setDataFromBase(professionalapproval);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(professionalapproval); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteProfessionalApproval ( BaseProfessionalApproval bean ) throws Exception {
		ProfessionalApproval dao = new ProfessionalApproval();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseProfessionalApproval updateProfessionalApproval ( BaseProfessionalApproval professionalapproval ) throws Exception {
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setProfessionalApproval_id( professionalapproval.getProfessionalApproval_id() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(professionalapproval);
			result = dao.update();
		}
		return result == 1 ? professionalapproval : null ;
	}

	public static BaseProfessionalApproval updateProfessionalApprovalDirect( BaseProfessionalApproval professionalapproval ) throws Exception {
		ProfessionalApproval dao = new ProfessionalApproval();
		int result = 0;
		dao.setDataFromBase(professionalapproval);
		result = dao.update();
		return result == 1 ? professionalapproval : null ;
	}

	public static int setDeleteConditions(BaseProfessionalApproval bean, ProfessionalApproval dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProfessionalApproval_id() != null) {
			dao.setConditionProfessionalApproval_id("=", bean.getProfessionalApproval_id());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getProjectId() != null) {
				dao.setConditionProjectId("=", bean.getProjectId());
				count++;
			}
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getContractId() != null) {
				dao.setConditionContractId("=", bean.getContractId());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getDesignType() != null) {
				dao.setConditionDesignType("=", bean.getDesignType());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getPlateManagerId() != null) {
				dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getDepartmentManagerId() != null) {
				dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
				count++;
			}
			if(bean.getProjectManageId() != null) {
				dao.setConditionProjectManageId("=", bean.getProjectManageId());
				count++;
			}
			if(bean.getProjectManageName() != null) {
				dao.setConditionProjectManageName("=", bean.getProjectManageName());
				count++;
			}
			if(bean.getProjectManageDepartmentId() != null) {
				dao.setConditionProjectManageDepartmentId("=", bean.getProjectManageDepartmentId());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProfessionalApproval bean, ProfessionalApproval dao){
		int count = 0;
		if(bean.getProfessionalApproval_id() != null) {
			dao.setConditionProfessionalApproval_id("=", bean.getProfessionalApproval_id());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
			count++;
		}
		if(bean.getProjectId() != null) {
			dao.setConditionProjectId("=", bean.getProjectId());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getContractId() != null) {
			dao.setConditionContractId("=", bean.getContractId());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getDesignType() != null) {
			dao.setConditionDesignType("=", bean.getDesignType());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getPlateManagerId() != null) {
			dao.setConditionPlateManagerId("=", bean.getPlateManagerId());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getDepartmentManagerId() != null) {
			dao.setConditionDepartmentManagerId("=", bean.getDepartmentManagerId());
			count++;
		}
		if(bean.getProjectManageId() != null) {
			dao.setConditionProjectManageId("=", bean.getProjectManageId());
			count++;
		}
		if(bean.getProjectManageName() != null) {
			if(bean.getProjectManageName().indexOf("%") >= 0)
				dao.setConditionProjectManageName("like", bean.getProjectManageName());
			else
				dao.setConditionProjectManageName("=", bean.getProjectManageName());
			count++;
		}
		if(bean.getProjectManageDepartmentId() != null) {
			dao.setConditionProjectManageDepartmentId("=", bean.getProjectManageDepartmentId());
			count++;
		}
		if(bean.getCommonArea() != null) {
			dao.setConditionCommonArea("=", bean.getCommonArea());
			count++;
		}
		if(bean.getLogisticsArea() != null) {
			dao.setConditionLogisticsArea("=", bean.getLogisticsArea());
			count++;
		}
		if(bean.getCadArea() != null) {
			dao.setConditionCadArea("=", bean.getCadArea());
			count++;
		}
		if(bean.getTotalIntegral() != null) {
			dao.setConditionTotalIntegral("=", bean.getTotalIntegral());
			count++;
		}
		if(bean.getProjectIntegral() != null) {
			dao.setConditionProjectIntegral("=", bean.getProjectIntegral());
			count++;
		}
		if(bean.getReserveIntegral() != null) {
			dao.setConditionReserveIntegral("=", bean.getReserveIntegral());
			count++;
		}
		if(bean.getPercentage() != null) {
			dao.setConditionPercentage("=", bean.getPercentage());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		bean.setDataFromJSON(json);
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProfessionalApproval> rlist = new BaseCollection<>();
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProfessionalApproval dao = new ProfessionalApproval();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProfessionalApproval> result = dao.conditionalLoad(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception{
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		bean.setDataFromJSON(json);
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		bean.setDataFromJSON(json);
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		bean.setDataFromJSON(json);
		ProfessionalApproval dao = new ProfessionalApproval();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProfessionalApproval bean = new BaseProfessionalApproval();
		bean.setDataFromJSON(json);
		ProfessionalApproval dao = new ProfessionalApproval();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


