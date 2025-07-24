package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BasePreProject;
import java.util.List;
import com.pomplatform.db.dao.PreProject;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class PreProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(PreProjectHandler.class);

	public static BasePreProject getPreProjectById( 
		java.lang.Integer pre_project_id
	) throws Exception
	{
		PreProject dao = new PreProject();
		dao.setPreProjectId(pre_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isPreProjectExists( com.pomplatform.db.bean.BasePreProject bean, String additional ) throws Exception {

		PreProject dao = new PreProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countPreProject( com.pomplatform.db.bean.BasePreProject bean, String additional ) throws Exception {

		PreProject dao = new PreProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BasePreProject> queryPreProject( com.pomplatform.db.bean.BasePreProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		PreProject dao = new PreProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BasePreProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BasePreProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BasePreProject addToPreProject ( BasePreProject preproject )  throws Exception {
		return addToPreProject ( preproject , false);
	}

	public static BasePreProject addToPreProject ( BasePreProject preproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		PreProject dao = new PreProject();
		dao.setDataFromBase(preproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BasePreProject addUpdatePreProject ( BasePreProject preproject ) throws Exception {
		return addUpdatePreProject ( preproject , false);
	}

	public static BasePreProject addUpdatePreProject ( BasePreProject preproject, boolean singleTransaction  ) throws Exception {
		if(preproject.getPreProjectId() == null) return addToPreProject(preproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		PreProject dao = new PreProject();
		dao.setDataFromBase(preproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(preproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deletePreProject ( BasePreProject bean ) throws Exception {
		PreProject dao = new PreProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BasePreProject updatePreProject ( BasePreProject preproject ) throws Exception {
		PreProject dao = new PreProject();
		dao.setPreProjectId( preproject.getPreProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(preproject);
			result = dao.update();
		}
		return result == 1 ? preproject : null ;
	}

	public static BasePreProject updatePreProjectDirect( BasePreProject preproject ) throws Exception {
		PreProject dao = new PreProject();
		int result = 0;
		dao.setDataFromBase(preproject);
		result = dao.update();
		return result == 1 ? preproject : null ;
	}

	public static int setDeleteConditions(BasePreProject bean, PreProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getClientId() != null) {
				dao.setConditionClientId("=", bean.getClientId());
				count++;
			}
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProvince() != null) {
				dao.setConditionProvince("=", bean.getProvince());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
			if(bean.getDetailAddress() != null) {
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
				count++;
			}
			if(bean.getProjectType() != null) {
				dao.setConditionProjectType("=", bean.getProjectType());
				count++;
			}
			if(bean.getProjectOrigination() != null) {
				dao.setConditionProjectOrigination("=", bean.getProjectOrigination());
				count++;
			}
			if(bean.getProjectOriginationRemark() != null) {
				dao.setConditionProjectOriginationRemark("=", bean.getProjectOriginationRemark());
				count++;
			}
			if(bean.getCustomerContactId() != null) {
				dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
				count++;
			}
			if(bean.getContactName() != null) {
				dao.setConditionContactName("=", bean.getContactName());
				count++;
			}
			if(bean.getContactPhone() != null) {
				dao.setConditionContactPhone("=", bean.getContactPhone());
				count++;
			}
			if(bean.getDesignStatus() != null) {
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
				count++;
			}
			if(bean.getProjectSalesTeam() != null) {
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
				count++;
			}
			if(bean.getDesignTeam() != null) {
				dao.setConditionDesignTeam("=", bean.getDesignTeam());
				count++;
			}
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
				count++;
			}
			if(bean.getSignCompany() != null) {
				dao.setConditionSignCompany("=", bean.getSignCompany());
				count++;
			}
			if(bean.getDesignQualification() != null) {
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
				count++;
			}
			if(bean.getProjectBaseOn() != null) {
				dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
				count++;
			}
			if(bean.getIsHighRiseBuilding() != null) {
				dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
				count++;
			}
			if(bean.getDesignCooperationName() != null) {
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
				count++;
			}
			if(bean.getArchitecturalDesignUnits() != null) {
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
				count++;
			}
			if(bean.getFireResistanceRating() != null) {
				dao.setConditionFireResistanceRating("=", bean.getFireResistanceRating());
				count++;
			}
			if(bean.getSpecialty() != null) {
				dao.setConditionSpecialty("=", bean.getSpecialty());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getHasContract() != null) {
				dao.setConditionHasContract("=", bean.getHasContract());
				count++;
			}
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
				count++;
			}
			if(bean.getProjectStatus() != null) {
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
				count++;
			}
			if(bean.getCloseReason() != null) {
				dao.setConditionCloseReason("=", bean.getCloseReason());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getComparisonForm() != null) {
				dao.setConditionComparisonForm("=", bean.getComparisonForm());
				count++;
			}
			if(bean.getRegion() != null) {
				dao.setConditionRegion("=", bean.getRegion());
				count++;
			}
			if(bean.getWinRate() != null) {
				dao.setConditionWinRate("=", bean.getWinRate());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getCloseRemark() != null) {
				dao.setConditionCloseRemark("=", bean.getCloseRemark());
				count++;
			}
			if(bean.getGrade() != null) {
				dao.setConditionGrade("=", bean.getGrade());
				count++;
			}
			if(bean.getIsOriginal() != null) {
				dao.setConditionIsOriginal("=", bean.getIsOriginal());
				count++;
			}
			if(bean.getIsSubProject() != null) {
				dao.setConditionIsSubProject("=", bean.getIsSubProject());
				count++;
			}
			if(bean.getContractStatus() != null) {
				dao.setConditionContractStatus("=", bean.getContractStatus());
				count++;
			}
			if(bean.getIsPubliclyBidding() != null) {
				dao.setConditionIsPubliclyBidding("=", bean.getIsPubliclyBidding());
				count++;
			}
			if(bean.getHaveAgents() != null) {
				dao.setConditionHaveAgents("=", bean.getHaveAgents());
				count++;
			}
			if(bean.getIsWinningBid() != null) {
				dao.setConditionIsWinningBid("=", bean.getIsWinningBid());
				count++;
			}
			if(bean.getBidCompanyNum() != null) {
				dao.setConditionBidCompanyNum("=", bean.getBidCompanyNum());
				count++;
			}
			if(bean.getBidRankingType() != null) {
				dao.setConditionBidRankingType("=", bean.getBidRankingType());
				count++;
			}
			if(bean.getBidRanking() != null) {
				dao.setConditionBidRanking("=", bean.getBidRanking());
				count++;
			}
			if(bean.getOwnerTypeId() != null) {
				dao.setConditionOwnerTypeId("=", bean.getOwnerTypeId());
				count++;
			}
			if(bean.getContactEmail() != null) {
				dao.setConditionContactEmail("=", bean.getContactEmail());
				count++;
			}
			if(bean.getIsOperationDepartment() != null) {
				dao.setConditionIsOperationDepartment("=", bean.getIsOperationDepartment());
				count++;
			}
			if(bean.getProjectNameOne() != null) {
				dao.setConditionProjectNameOne("=", bean.getProjectNameOne());
				count++;
			}
			if(bean.getBusinessTypes() != null) {
				dao.setConditionBusinessTypes("=", bean.getBusinessTypes());
				count++;
			}
			if(bean.getBusinessTypesName() != null) {
				dao.setConditionBusinessTypesName("=", bean.getBusinessTypesName());
				count++;
			}
			if(bean.getParentCustomerName() != null) {
				dao.setConditionParentCustomerName("=", bean.getParentCustomerName());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePreProject bean, PreProject dao){
		int count = 0;
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getProjectCode() != null) {
			if(bean.getProjectCode().indexOf("%") >= 0)
				dao.setConditionProjectCode("like", bean.getProjectCode());
			else
				dao.setConditionProjectCode("=", bean.getProjectCode());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
			count++;
		}
		if(bean.getCustomerName() != null) {
			if(bean.getCustomerName().indexOf("%") >= 0)
				dao.setConditionCustomerName("like", bean.getCustomerName());
			else
				dao.setConditionCustomerName("=", bean.getCustomerName());
			count++;
		}
		if(bean.getCustomerAddress() != null) {
			if(bean.getCustomerAddress().indexOf("%") >= 0)
				dao.setConditionCustomerAddress("like", bean.getCustomerAddress());
			else
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProvince() != null) {
			if(bean.getProvince().indexOf("%") >= 0)
				dao.setConditionProvince("like", bean.getProvince());
			else
				dao.setConditionProvince("=", bean.getProvince());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		if(bean.getDetailAddress() != null) {
			if(bean.getDetailAddress().indexOf("%") >= 0)
				dao.setConditionDetailAddress("like", bean.getDetailAddress());
			else
				dao.setConditionDetailAddress("=", bean.getDetailAddress());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
			count++;
		}
		if(bean.getTotalBuildingAreas() != null) {
			dao.setConditionTotalBuildingAreas("=", bean.getTotalBuildingAreas());
			count++;
		}
		if(bean.getProjectOrigination() != null) {
			if(bean.getProjectOrigination().indexOf("%") >= 0)
				dao.setConditionProjectOrigination("like", bean.getProjectOrigination());
			else
				dao.setConditionProjectOrigination("=", bean.getProjectOrigination());
			count++;
		}
		if(bean.getProjectOriginationRemark() != null) {
			if(bean.getProjectOriginationRemark().indexOf("%") >= 0)
				dao.setConditionProjectOriginationRemark("like", bean.getProjectOriginationRemark());
			else
				dao.setConditionProjectOriginationRemark("=", bean.getProjectOriginationRemark());
			count++;
		}
		if(bean.getCustomerContactId() != null) {
			dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
			count++;
		}
		if(bean.getContactName() != null) {
			if(bean.getContactName().indexOf("%") >= 0)
				dao.setConditionContactName("like", bean.getContactName());
			else
				dao.setConditionContactName("=", bean.getContactName());
			count++;
		}
		if(bean.getContactPhone() != null) {
			if(bean.getContactPhone().indexOf("%") >= 0)
				dao.setConditionContactPhone("like", bean.getContactPhone());
			else
				dao.setConditionContactPhone("=", bean.getContactPhone());
			count++;
		}
		if(bean.getDesignStatus() != null) {
			if(bean.getDesignStatus().indexOf("%") >= 0)
				dao.setConditionDesignStatus("like", bean.getDesignStatus());
			else
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
			count++;
		}
		if(bean.getProjectSalesTeam() != null) {
			if(bean.getProjectSalesTeam().indexOf("%") >= 0)
				dao.setConditionProjectSalesTeam("like", bean.getProjectSalesTeam());
			else
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
			count++;
		}
		if(bean.getDesignTeam() != null) {
			dao.setConditionDesignTeam("=", bean.getDesignTeam());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
			count++;
		}
		if(bean.getSignCompany() != null) {
			dao.setConditionSignCompany("=", bean.getSignCompany());
			count++;
		}
		if(bean.getDesignQualification() != null) {
			if(bean.getDesignQualification().indexOf("%") >= 0)
				dao.setConditionDesignQualification("like", bean.getDesignQualification());
			else
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
			count++;
		}
		if(bean.getProjectBaseOn() != null) {
			dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getIsHighRiseBuilding() != null) {
			dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
			count++;
		}
		if(bean.getDesignCooperationName() != null) {
			if(bean.getDesignCooperationName().indexOf("%") >= 0)
				dao.setConditionDesignCooperationName("like", bean.getDesignCooperationName());
			else
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
			count++;
		}
		if(bean.getArchitecturalDesignUnits() != null) {
			if(bean.getArchitecturalDesignUnits().indexOf("%") >= 0)
				dao.setConditionArchitecturalDesignUnits("like", bean.getArchitecturalDesignUnits());
			else
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
			count++;
		}
		if(bean.getProjectTotalInvestment() != null) {
			dao.setConditionProjectTotalInvestment("=", bean.getProjectTotalInvestment());
			count++;
		}
		if(bean.getFireResistanceRating() != null) {
			if(bean.getFireResistanceRating().indexOf("%") >= 0)
				dao.setConditionFireResistanceRating("like", bean.getFireResistanceRating());
			else
				dao.setConditionFireResistanceRating("=", bean.getFireResistanceRating());
			count++;
		}
		if(bean.getEstimateTheDesignAreas() != null) {
			dao.setConditionEstimateTheDesignAreas("=", bean.getEstimateTheDesignAreas());
			count++;
		}
		if(bean.getActualDesignAreas() != null) {
			dao.setConditionActualDesignAreas("=", bean.getActualDesignAreas());
			count++;
		}
		if(bean.getBuildingHeight() != null) {
			dao.setConditionBuildingHeight("=", bean.getBuildingHeight());
			count++;
		}
		if(bean.getBuildingFloors() != null) {
			dao.setConditionBuildingFloors("=", bean.getBuildingFloors());
			count++;
		}
		if(bean.getDecorateMoneyControl() != null) {
			dao.setConditionDecorateMoneyControl("=", bean.getDecorateMoneyControl());
			count++;
		}
		if(bean.getSpecialty() != null) {
			if(bean.getSpecialty().indexOf("%") >= 0)
				dao.setConditionSpecialty("like", bean.getSpecialty());
			else
				dao.setConditionSpecialty("=", bean.getSpecialty());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getHasContract() != null) {
			dao.setConditionHasContract("=", bean.getHasContract());
			count++;
		}
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getInfoRegisterTime() != null) {
			dao.setConditionInfoRegisterTime(">=", bean.getInfoRegisterTime());
			count++;
		}
		if(bean.getProjectStatus() != null) {
			if(bean.getProjectStatus().indexOf("%") >= 0)
				dao.setConditionProjectStatus("like", bean.getProjectStatus());
			else
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
			count++;
		}
		if(bean.getCloseReason() != null) {
			if(bean.getCloseReason().indexOf("%") >= 0)
				dao.setConditionCloseReason("like", bean.getCloseReason());
			else
				dao.setConditionCloseReason("=", bean.getCloseReason());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getComparisonForm() != null) {
			dao.setConditionComparisonForm("=", bean.getComparisonForm());
			count++;
		}
		if(bean.getRegion() != null) {
			dao.setConditionRegion("=", bean.getRegion());
			count++;
		}
		if(bean.getWinRate() != null) {
			if(bean.getWinRate().indexOf("%") >= 0)
				dao.setConditionWinRate("like", bean.getWinRate());
			else
				dao.setConditionWinRate("=", bean.getWinRate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getCloseRemark() != null) {
			if(bean.getCloseRemark().indexOf("%") >= 0)
				dao.setConditionCloseRemark("like", bean.getCloseRemark());
			else
				dao.setConditionCloseRemark("=", bean.getCloseRemark());
			count++;
		}
		if(bean.getGrade() != null) {
			if(bean.getGrade().indexOf("%") >= 0)
				dao.setConditionGrade("like", bean.getGrade());
			else
				dao.setConditionGrade("=", bean.getGrade());
			count++;
		}
		if(bean.getIsOriginal() != null) {
			dao.setConditionIsOriginal("=", bean.getIsOriginal());
			count++;
		}
		if(bean.getIsSubProject() != null) {
			dao.setConditionIsSubProject("=", bean.getIsSubProject());
			count++;
		}
		if(bean.getContractStatus() != null) {
			dao.setConditionContractStatus("=", bean.getContractStatus());
			count++;
		}
		if(bean.getIsPubliclyBidding() != null) {
			dao.setConditionIsPubliclyBidding("=", bean.getIsPubliclyBidding());
			count++;
		}
		if(bean.getHaveAgents() != null) {
			dao.setConditionHaveAgents("=", bean.getHaveAgents());
			count++;
		}
		if(bean.getIsWinningBid() != null) {
			dao.setConditionIsWinningBid("=", bean.getIsWinningBid());
			count++;
		}
		if(bean.getBidCompanyNum() != null) {
			dao.setConditionBidCompanyNum("=", bean.getBidCompanyNum());
			count++;
		}
		if(bean.getBidRankingType() != null) {
			if(bean.getBidRankingType().indexOf("%") >= 0)
				dao.setConditionBidRankingType("like", bean.getBidRankingType());
			else
				dao.setConditionBidRankingType("=", bean.getBidRankingType());
			count++;
		}
		if(bean.getBidRanking() != null) {
			dao.setConditionBidRanking("=", bean.getBidRanking());
			count++;
		}
		if(bean.getOwnerTypeId() != null) {
			dao.setConditionOwnerTypeId("=", bean.getOwnerTypeId());
			count++;
		}
		if(bean.getEstimatePrice() != null) {
			dao.setConditionEstimatePrice("=", bean.getEstimatePrice());
			count++;
		}
		if(bean.getContactEmail() != null) {
			if(bean.getContactEmail().indexOf("%") >= 0)
				dao.setConditionContactEmail("like", bean.getContactEmail());
			else
				dao.setConditionContactEmail("=", bean.getContactEmail());
			count++;
		}
		if(bean.getIsOperationDepartment() != null) {
			dao.setConditionIsOperationDepartment("=", bean.getIsOperationDepartment());
			count++;
		}
		if(bean.getProjectNameOne() != null) {
			if(bean.getProjectNameOne().indexOf("%") >= 0)
				dao.setConditionProjectNameOne("like", bean.getProjectNameOne());
			else
				dao.setConditionProjectNameOne("=", bean.getProjectNameOne());
			count++;
		}
		if(bean.getBusinessTypes() != null) {
			if(bean.getBusinessTypes().indexOf("%") >= 0)
				dao.setConditionBusinessTypes("like", bean.getBusinessTypes());
			else
				dao.setConditionBusinessTypes("=", bean.getBusinessTypes());
			count++;
		}
		if(bean.getBusinessTypesName() != null) {
			if(bean.getBusinessTypesName().indexOf("%") >= 0)
				dao.setConditionBusinessTypesName("like", bean.getBusinessTypesName());
			else
				dao.setConditionBusinessTypesName("=", bean.getBusinessTypesName());
			count++;
		}
		if(bean.getProjectOutputValue() != null) {
			dao.setConditionProjectOutputValue("=", bean.getProjectOutputValue());
			count++;
		}
		if(bean.getParentCustomerName() != null) {
			if(bean.getParentCustomerName().indexOf("%") >= 0)
				dao.setConditionParentCustomerName("like", bean.getParentCustomerName());
			else
				dao.setConditionParentCustomerName("=", bean.getParentCustomerName());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePreProject bean = new BasePreProject();
		bean.setDataFromJSON(json);
		PreProject dao = new PreProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePreProject> rlist = new BaseCollection<>();
		BasePreProject bean = new BasePreProject();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PreProject dao = new PreProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePreProject> result = dao.conditionalLoad(addtion);
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
		BasePreProject bean = new BasePreProject();
		bean.setDataFromJSON(json);
		PreProject dao = new PreProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePreProject bean = new BasePreProject();
		bean.setDataFromJSON(json);
		PreProject dao = new PreProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePreProject bean = new BasePreProject();
		bean.setDataFromJSON(json);
		PreProject dao = new PreProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePreProject bean = new BasePreProject();
		bean.setDataFromJSON(json);
		PreProject dao = new PreProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


