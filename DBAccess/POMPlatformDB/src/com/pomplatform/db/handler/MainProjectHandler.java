package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseMainProject;
import java.util.List;
import com.pomplatform.db.dao.MainProject;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class MainProjectHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectHandler.class);

	public static BaseMainProject getMainProjectById( 
		java.lang.Integer main_project_id
	) throws Exception
	{
		MainProject dao = new MainProject();
		dao.setMainProjectId(main_project_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectExists( com.pomplatform.db.bean.BaseMainProject bean, String additional ) throws Exception {

		MainProject dao = new MainProject();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProject( com.pomplatform.db.bean.BaseMainProject bean, String additional ) throws Exception {

		MainProject dao = new MainProject();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProject> queryMainProject( com.pomplatform.db.bean.BaseMainProject bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProject dao = new MainProject();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProject> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProject> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProject addToMainProject ( BaseMainProject mainproject )  throws Exception {
		return addToMainProject ( mainproject , false);
	}

	public static BaseMainProject addToMainProject ( BaseMainProject mainproject, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProject dao = new MainProject();
		dao.setDataFromBase(mainproject);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProject addUpdateMainProject ( BaseMainProject mainproject ) throws Exception {
		return addUpdateMainProject ( mainproject , false);
	}

	public static BaseMainProject addUpdateMainProject ( BaseMainProject mainproject, boolean singleTransaction  ) throws Exception {
		if(mainproject.getMainProjectId() == null) return addToMainProject(mainproject);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProject dao = new MainProject();
		dao.setDataFromBase(mainproject);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainproject); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProject ( BaseMainProject bean ) throws Exception {
		MainProject dao = new MainProject();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProject updateMainProject ( BaseMainProject mainproject ) throws Exception {
		MainProject dao = new MainProject();
		dao.setMainProjectId( mainproject.getMainProjectId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainproject);
			result = dao.update();
		}
		return result == 1 ? mainproject : null ;
	}

	public static BaseMainProject updateMainProjectDirect( BaseMainProject mainproject ) throws Exception {
		MainProject dao = new MainProject();
		int result = 0;
		dao.setDataFromBase(mainproject);
		result = dao.update();
		return result == 1 ? mainproject : null ;
	}

	public static int setDeleteConditions(BaseMainProject bean, MainProject dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getProjectCode() != null) {
				dao.setConditionProjectCode("=", bean.getProjectCode());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectEnglishName() != null) {
				dao.setConditionProjectEnglishName("=", bean.getProjectEnglishName());
				count++;
			}
			if(bean.getProjectStatus() != null) {
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
				count++;
			}
			if(bean.getDesignStatus() != null) {
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
				count++;
			}
			if(bean.getSignCompany() != null) {
				dao.setConditionSignCompany("=", bean.getSignCompany());
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
			if(bean.getDesignCooperationName() != null) {
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
				count++;
			}
			if(bean.getDesignCooperationEnglishName() != null) {
				dao.setConditionDesignCooperationEnglishName("=", bean.getDesignCooperationEnglishName());
				count++;
			}
			if(bean.getDesignTeam() != null) {
				dao.setConditionDesignTeam("=", bean.getDesignTeam());
				count++;
			}
			if(bean.getIsHighRiseBuilding() != null) {
				dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
				count++;
			}
			if(bean.getHasContract() != null) {
				dao.setConditionHasContract("=", bean.getHasContract());
				count++;
			}
			if(bean.getProjectBaseOn() != null) {
				dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
				count++;
			}
			if(bean.getInfoCode() != null) {
				dao.setConditionInfoCode("=", bean.getInfoCode());
				count++;
			}
			if(bean.getProjectModel() != null) {
				dao.setConditionProjectModel("=", bean.getProjectModel());
				count++;
			}
			if(bean.getDesignQualification() != null) {
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
				count++;
			}
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getFireResistanceRating() != null) {
				dao.setConditionFireResistanceRating("=", bean.getFireResistanceRating());
				count++;
			}
			if(bean.getEstimateTheDesignAreas() != null) {
				dao.setConditionEstimateTheDesignAreas("=", bean.getEstimateTheDesignAreas());
				count++;
			}
			if(bean.getProjectTotalInvestment() != null) {
				dao.setConditionProjectTotalInvestment("=", bean.getProjectTotalInvestment());
				count++;
			}
			if(bean.getActualDesignAreas() != null) {
				dao.setConditionActualDesignAreas("=", bean.getActualDesignAreas());
				count++;
			}
			if(bean.getTotalBuildingAreas() != null) {
				dao.setConditionTotalBuildingAreas("=", bean.getTotalBuildingAreas());
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
			if(bean.getProjectLevel() != null) {
				dao.setConditionProjectLevel("=", bean.getProjectLevel());
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
			if(bean.getCustomerName() != null) {
				dao.setConditionCustomerName("=", bean.getCustomerName());
				count++;
			}
			if(bean.getCustomerAddress() != null) {
				dao.setConditionCustomerAddress("=", bean.getCustomerAddress());
				count++;
			}
			if(bean.getBidProject() != null) {
				dao.setConditionBidProject("=", bean.getBidProject());
				count++;
			}
			if(bean.getConstructionUnit() != null) {
				dao.setConditionConstructionUnit("=", bean.getConstructionUnit());
				count++;
			}
			if(bean.getArchitecturalDesignUnits() != null) {
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
				count++;
			}
			if(bean.getRateOfBidWinning() != null) {
				dao.setConditionRateOfBidWinning("=", bean.getRateOfBidWinning());
				count++;
			}
			if(bean.getEquityedgeRemark() != null) {
				dao.setConditionEquityedgeRemark("=", bean.getEquityedgeRemark());
				count++;
			}
			if(bean.getDesignServiceBook() != null) {
				dao.setConditionDesignServiceBook("=", bean.getDesignServiceBook());
				count++;
			}
			if(bean.getServiceSuggestBook() != null) {
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
				count++;
			}
			if(bean.getHasFormalContracts() != null) {
				dao.setConditionHasFormalContracts("=", bean.getHasFormalContracts());
				count++;
			}
			if(bean.getHasOutQuotations() != null) {
				dao.setConditionHasOutQuotations("=", bean.getHasOutQuotations());
				count++;
			}
			if(bean.getSpecialty() != null) {
				dao.setConditionSpecialty("=", bean.getSpecialty());
				count++;
			}
			if(bean.getProjectSalesTeam() != null) {
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
				count++;
			}
			if(bean.getHasSplitPrice() != null) {
				dao.setConditionHasSplitPrice("=", bean.getHasSplitPrice());
				count++;
			}
			if(bean.getHasOrderRelease() != null) {
				dao.setConditionHasOrderRelease("=", bean.getHasOrderRelease());
				count++;
			}
			if(bean.getHasDeposit() != null) {
				dao.setConditionHasDeposit("=", bean.getHasDeposit());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSerialNumber() != null) {
				dao.setConditionSerialNumber("=", bean.getSerialNumber());
				count++;
			}
			if(bean.getBidType() != null) {
				dao.setConditionBidType("=", bean.getBidType());
				count++;
			}
			if(bean.getBidClassType() != null) {
				dao.setConditionBidClassType("=", bean.getBidClassType());
				count++;
			}
			if(bean.getBidUnitNum() != null) {
				dao.setConditionBidUnitNum("=", bean.getBidUnitNum());
				count++;
			}
			if(bean.getOurOrder() != null) {
				dao.setConditionOurOrder("=", bean.getOurOrder());
				count++;
			}
			if(bean.getBigIsAchieveAmount() != null) {
				dao.setConditionBigIsAchieveAmount("=", bean.getBigIsAchieveAmount());
				count++;
			}
			if(bean.getClientId() != null) {
				dao.setConditionClientId("=", bean.getClientId());
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
			if(bean.getApplyEmployeeId() != null) {
				dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
				count++;
			}
			if(bean.getCustomerContactId() != null) {
				dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
				count++;
			}
			if(bean.getArchitecturalDesignUnitId() != null) {
				dao.setConditionArchitecturalDesignUnitId("=", bean.getArchitecturalDesignUnitId());
				count++;
			}
			if(bean.getArchitecturalDesignUnitContactId() != null) {
				dao.setConditionArchitecturalDesignUnitContactId("=", bean.getArchitecturalDesignUnitContactId());
				count++;
			}
			if(bean.getRegion() != null) {
				dao.setConditionRegion("=", bean.getRegion());
				count++;
			}
			if(bean.getComparisonForm() != null) {
				dao.setConditionComparisonForm("=", bean.getComparisonForm());
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
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getCompanyNo() != null) {
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
				count++;
			}
			if(bean.getOwnerTypeId() != null) {
				dao.setConditionOwnerTypeId("=", bean.getOwnerTypeId());
				count++;
			}
			if(bean.getProjectPhase() != null) {
				dao.setConditionProjectPhase("=", bean.getProjectPhase());
				count++;
			}
			if(bean.getProjectAttribute() != null) {
				dao.setConditionProjectAttribute("=", bean.getProjectAttribute());
				count++;
			}
			if(bean.getProjectNameOne() != null) {
				dao.setConditionProjectNameOne("=", bean.getProjectNameOne());
				count++;
			}
			if(bean.getMainProjectStageId() != null) {
				dao.setConditionMainProjectStageId("=", bean.getMainProjectStageId());
				count++;
			}
			if(bean.getIsModifyProject() != null) {
				dao.setConditionIsModifyProject("=", bean.getIsModifyProject());
				count++;
			}
			if(bean.getGrade() != null) {
				dao.setConditionGrade("=", bean.getGrade());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getProcessStatus() != null) {
				dao.setConditionProcessStatus("=", bean.getProcessStatus());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProject bean, MainProject dao){
		int count = 0;
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
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
		if(bean.getProjectEnglishName() != null) {
			if(bean.getProjectEnglishName().indexOf("%") >= 0)
				dao.setConditionProjectEnglishName("like", bean.getProjectEnglishName());
			else
				dao.setConditionProjectEnglishName("=", bean.getProjectEnglishName());
			count++;
		}
		if(bean.getProjectStatus() != null) {
			if(bean.getProjectStatus().indexOf("%") >= 0)
				dao.setConditionProjectStatus("like", bean.getProjectStatus());
			else
				dao.setConditionProjectStatus("=", bean.getProjectStatus());
			count++;
		}
		if(bean.getDesignStatus() != null) {
			if(bean.getDesignStatus().indexOf("%") >= 0)
				dao.setConditionDesignStatus("like", bean.getDesignStatus());
			else
				dao.setConditionDesignStatus("=", bean.getDesignStatus());
			count++;
		}
		if(bean.getSignCompany() != null) {
			dao.setConditionSignCompany("=", bean.getSignCompany());
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
		if(bean.getDesignCooperationName() != null) {
			if(bean.getDesignCooperationName().indexOf("%") >= 0)
				dao.setConditionDesignCooperationName("like", bean.getDesignCooperationName());
			else
				dao.setConditionDesignCooperationName("=", bean.getDesignCooperationName());
			count++;
		}
		if(bean.getDesignCooperationEnglishName() != null) {
			if(bean.getDesignCooperationEnglishName().indexOf("%") >= 0)
				dao.setConditionDesignCooperationEnglishName("like", bean.getDesignCooperationEnglishName());
			else
				dao.setConditionDesignCooperationEnglishName("=", bean.getDesignCooperationEnglishName());
			count++;
		}
		if(bean.getDesignTeam() != null) {
			dao.setConditionDesignTeam("=", bean.getDesignTeam());
			count++;
		}
		if(bean.getIsHighRiseBuilding() != null) {
			dao.setConditionIsHighRiseBuilding("=", bean.getIsHighRiseBuilding());
			count++;
		}
		if(bean.getInfoRegisterTime() != null) {
			dao.setConditionInfoRegisterTime(">=", bean.getInfoRegisterTime());
			count++;
		}
		if(bean.getProjectApprovalTime() != null) {
			dao.setConditionProjectApprovalTime(">=", bean.getProjectApprovalTime());
			count++;
		}
		if(bean.getHasContract() != null) {
			dao.setConditionHasContract("=", bean.getHasContract());
			count++;
		}
		if(bean.getProjectBaseOn() != null) {
			dao.setConditionProjectBaseOn("=", bean.getProjectBaseOn());
			count++;
		}
		if(bean.getInfoCode() != null) {
			if(bean.getInfoCode().indexOf("%") >= 0)
				dao.setConditionInfoCode("like", bean.getInfoCode());
			else
				dao.setConditionInfoCode("=", bean.getInfoCode());
			count++;
		}
		if(bean.getProjectModel() != null) {
			if(bean.getProjectModel().indexOf("%") >= 0)
				dao.setConditionProjectModel("like", bean.getProjectModel());
			else
				dao.setConditionProjectModel("=", bean.getProjectModel());
			count++;
		}
		if(bean.getDesignQualification() != null) {
			if(bean.getDesignQualification().indexOf("%") >= 0)
				dao.setConditionDesignQualification("like", bean.getDesignQualification());
			else
				dao.setConditionDesignQualification("=", bean.getDesignQualification());
			count++;
		}
		if(bean.getBusinessType() != null) {
			if(bean.getBusinessType().indexOf("%") >= 0)
				dao.setConditionBusinessType("like", bean.getBusinessType());
			else
				dao.setConditionBusinessType("=", bean.getBusinessType());
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
			if(bean.getEstimateTheDesignAreas().indexOf("%") >= 0)
				dao.setConditionEstimateTheDesignAreas("like", bean.getEstimateTheDesignAreas());
			else
				dao.setConditionEstimateTheDesignAreas("=", bean.getEstimateTheDesignAreas());
			count++;
		}
		if(bean.getProjectTotalInvestment() != null) {
			if(bean.getProjectTotalInvestment().indexOf("%") >= 0)
				dao.setConditionProjectTotalInvestment("like", bean.getProjectTotalInvestment());
			else
				dao.setConditionProjectTotalInvestment("=", bean.getProjectTotalInvestment());
			count++;
		}
		if(bean.getActualDesignAreas() != null) {
			if(bean.getActualDesignAreas().indexOf("%") >= 0)
				dao.setConditionActualDesignAreas("like", bean.getActualDesignAreas());
			else
				dao.setConditionActualDesignAreas("=", bean.getActualDesignAreas());
			count++;
		}
		if(bean.getTotalBuildingAreas() != null) {
			if(bean.getTotalBuildingAreas().indexOf("%") >= 0)
				dao.setConditionTotalBuildingAreas("like", bean.getTotalBuildingAreas());
			else
				dao.setConditionTotalBuildingAreas("=", bean.getTotalBuildingAreas());
			count++;
		}
		if(bean.getBuildingHeight() != null) {
			if(bean.getBuildingHeight().indexOf("%") >= 0)
				dao.setConditionBuildingHeight("like", bean.getBuildingHeight());
			else
				dao.setConditionBuildingHeight("=", bean.getBuildingHeight());
			count++;
		}
		if(bean.getBuildingFloors() != null) {
			if(bean.getBuildingFloors().indexOf("%") >= 0)
				dao.setConditionBuildingFloors("like", bean.getBuildingFloors());
			else
				dao.setConditionBuildingFloors("=", bean.getBuildingFloors());
			count++;
		}
		if(bean.getDecorateMoneyControl() != null) {
			if(bean.getDecorateMoneyControl().indexOf("%") >= 0)
				dao.setConditionDecorateMoneyControl("like", bean.getDecorateMoneyControl());
			else
				dao.setConditionDecorateMoneyControl("=", bean.getDecorateMoneyControl());
			count++;
		}
		if(bean.getProjectLevel() != null) {
			dao.setConditionProjectLevel("=", bean.getProjectLevel());
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
		if(bean.getProjectEndTime() != null) {
			dao.setConditionProjectEndTime(">=", bean.getProjectEndTime());
			count++;
		}
		if(bean.getProjectType() != null) {
			dao.setConditionProjectType("=", bean.getProjectType());
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
		if(bean.getBidProject() != null) {
			if(bean.getBidProject().indexOf("%") >= 0)
				dao.setConditionBidProject("like", bean.getBidProject());
			else
				dao.setConditionBidProject("=", bean.getBidProject());
			count++;
		}
		if(bean.getConstructionUnit() != null) {
			if(bean.getConstructionUnit().indexOf("%") >= 0)
				dao.setConditionConstructionUnit("like", bean.getConstructionUnit());
			else
				dao.setConditionConstructionUnit("=", bean.getConstructionUnit());
			count++;
		}
		if(bean.getArchitecturalDesignUnits() != null) {
			if(bean.getArchitecturalDesignUnits().indexOf("%") >= 0)
				dao.setConditionArchitecturalDesignUnits("like", bean.getArchitecturalDesignUnits());
			else
				dao.setConditionArchitecturalDesignUnits("=", bean.getArchitecturalDesignUnits());
			count++;
		}
		if(bean.getRateOfBidWinning() != null) {
			if(bean.getRateOfBidWinning().indexOf("%") >= 0)
				dao.setConditionRateOfBidWinning("like", bean.getRateOfBidWinning());
			else
				dao.setConditionRateOfBidWinning("=", bean.getRateOfBidWinning());
			count++;
		}
		if(bean.getFollowUpDate() != null) {
			dao.setConditionFollowUpDate(">=", bean.getFollowUpDate());
			count++;
		}
		if(bean.getEquityedgeRemark() != null) {
			if(bean.getEquityedgeRemark().indexOf("%") >= 0)
				dao.setConditionEquityedgeRemark("like", bean.getEquityedgeRemark());
			else
				dao.setConditionEquityedgeRemark("=", bean.getEquityedgeRemark());
			count++;
		}
		if(bean.getOrderSignUpTime() != null) {
			dao.setConditionOrderSignUpTime(">=", bean.getOrderSignUpTime());
			count++;
		}
		if(bean.getDesignServiceBook() != null) {
			if(bean.getDesignServiceBook().indexOf("%") >= 0)
				dao.setConditionDesignServiceBook("like", bean.getDesignServiceBook());
			else
				dao.setConditionDesignServiceBook("=", bean.getDesignServiceBook());
			count++;
		}
		if(bean.getServiceSuggestBook() != null) {
			if(bean.getServiceSuggestBook().indexOf("%") >= 0)
				dao.setConditionServiceSuggestBook("like", bean.getServiceSuggestBook());
			else
				dao.setConditionServiceSuggestBook("=", bean.getServiceSuggestBook());
			count++;
		}
		if(bean.getTotalMoney() != null) {
			dao.setConditionTotalMoney("=", bean.getTotalMoney());
			count++;
		}
		if(bean.getCoveredArea() != null) {
			dao.setConditionCoveredArea("=", bean.getCoveredArea());
			count++;
		}
		if(bean.getDesignArea() != null) {
			dao.setConditionDesignArea("=", bean.getDesignArea());
			count++;
		}
		if(bean.getHasFormalContracts() != null) {
			dao.setConditionHasFormalContracts("=", bean.getHasFormalContracts());
			count++;
		}
		if(bean.getHasOutQuotations() != null) {
			dao.setConditionHasOutQuotations("=", bean.getHasOutQuotations());
			count++;
		}
		if(bean.getSpecialty() != null) {
			if(bean.getSpecialty().indexOf("%") >= 0)
				dao.setConditionSpecialty("like", bean.getSpecialty());
			else
				dao.setConditionSpecialty("=", bean.getSpecialty());
			count++;
		}
		if(bean.getProjectSalesTeam() != null) {
			if(bean.getProjectSalesTeam().indexOf("%") >= 0)
				dao.setConditionProjectSalesTeam("like", bean.getProjectSalesTeam());
			else
				dao.setConditionProjectSalesTeam("=", bean.getProjectSalesTeam());
			count++;
		}
		if(bean.getHasSplitPrice() != null) {
			dao.setConditionHasSplitPrice("=", bean.getHasSplitPrice());
			count++;
		}
		if(bean.getHasOrderRelease() != null) {
			dao.setConditionHasOrderRelease("=", bean.getHasOrderRelease());
			count++;
		}
		if(bean.getHasDeposit() != null) {
			dao.setConditionHasDeposit("=", bean.getHasDeposit());
			count++;
		}
		if(bean.getHasRateOfPayment() != null) {
			dao.setConditionHasRateOfPayment("=", bean.getHasRateOfPayment());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSerialNumber() != null) {
			dao.setConditionSerialNumber("=", bean.getSerialNumber());
			count++;
		}
		if(bean.getHasFormalContractTime() != null) {
			dao.setConditionHasFormalContractTime(">=", bean.getHasFormalContractTime());
			count++;
		}
		if(bean.getHasOutQuotationTime() != null) {
			dao.setConditionHasOutQuotationTime(">=", bean.getHasOutQuotationTime());
			count++;
		}
		if(bean.getHasOrderReleaseTime() != null) {
			dao.setConditionHasOrderReleaseTime(">=", bean.getHasOrderReleaseTime());
			count++;
		}
		if(bean.getHasSplitPriceTime() != null) {
			dao.setConditionHasSplitPriceTime(">=", bean.getHasSplitPriceTime());
			count++;
		}
		if(bean.getBidType() != null) {
			dao.setConditionBidType("=", bean.getBidType());
			count++;
		}
		if(bean.getBidDate() != null) {
			dao.setConditionBidDate(">=", bean.getBidDate());
			count++;
		}
		if(bean.getBidClassType() != null) {
			dao.setConditionBidClassType("=", bean.getBidClassType());
			count++;
		}
		if(bean.getBidUnitNum() != null) {
			dao.setConditionBidUnitNum("=", bean.getBidUnitNum());
			count++;
		}
		if(bean.getOurOrder() != null) {
			if(bean.getOurOrder().indexOf("%") >= 0)
				dao.setConditionOurOrder("like", bean.getOurOrder());
			else
				dao.setConditionOurOrder("=", bean.getOurOrder());
			count++;
		}
		if(bean.getBigPayAmount() != null) {
			dao.setConditionBigPayAmount("=", bean.getBigPayAmount());
			count++;
		}
		if(bean.getBigIsAchieveAmount() != null) {
			dao.setConditionBigIsAchieveAmount("=", bean.getBigIsAchieveAmount());
			count++;
		}
		if(bean.getBigAdvanceAmount() != null) {
			dao.setConditionBigAdvanceAmount("=", bean.getBigAdvanceAmount());
			count++;
		}
		if(bean.getClientId() != null) {
			dao.setConditionClientId("=", bean.getClientId());
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
		if(bean.getApplyEmployeeId() != null) {
			dao.setConditionApplyEmployeeId("=", bean.getApplyEmployeeId());
			count++;
		}
		if(bean.getCustomerContactId() != null) {
			dao.setConditionCustomerContactId("=", bean.getCustomerContactId());
			count++;
		}
		if(bean.getArchitecturalDesignUnitId() != null) {
			dao.setConditionArchitecturalDesignUnitId("=", bean.getArchitecturalDesignUnitId());
			count++;
		}
		if(bean.getArchitecturalDesignUnitContactId() != null) {
			dao.setConditionArchitecturalDesignUnitContactId("=", bean.getArchitecturalDesignUnitContactId());
			count++;
		}
		if(bean.getRegion() != null) {
			dao.setConditionRegion("=", bean.getRegion());
			count++;
		}
		if(bean.getComparisonForm() != null) {
			dao.setConditionComparisonForm("=", bean.getComparisonForm());
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
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getCompanyNo() != null) {
			if(bean.getCompanyNo().indexOf("%") >= 0)
				dao.setConditionCompanyNo("like", bean.getCompanyNo());
			else
				dao.setConditionCompanyNo("=", bean.getCompanyNo());
			count++;
		}
		if(bean.getPercent() != null) {
			dao.setConditionPercent("=", bean.getPercent());
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
		if(bean.getProjectPhase() != null) {
			dao.setConditionProjectPhase("=", bean.getProjectPhase());
			count++;
		}
		if(bean.getProjectAttribute() != null) {
			dao.setConditionProjectAttribute("=", bean.getProjectAttribute());
			count++;
		}
		if(bean.getProjectNameOne() != null) {
			if(bean.getProjectNameOne().indexOf("%") >= 0)
				dao.setConditionProjectNameOne("like", bean.getProjectNameOne());
			else
				dao.setConditionProjectNameOne("=", bean.getProjectNameOne());
			count++;
		}
		if(bean.getWinningTime() != null) {
			dao.setConditionWinningTime(">=", bean.getWinningTime());
			count++;
		}
		if(bean.getProjectOutputValue() != null) {
			dao.setConditionProjectOutputValue("=", bean.getProjectOutputValue());
			count++;
		}
		if(bean.getMainProjectStageId() != null) {
			dao.setConditionMainProjectStageId("=", bean.getMainProjectStageId());
			count++;
		}
		if(bean.getIsModifyProject() != null) {
			dao.setConditionIsModifyProject("=", bean.getIsModifyProject());
			count++;
		}
		if(bean.getGrade() != null) {
			if(bean.getGrade().indexOf("%") >= 0)
				dao.setConditionGrade("like", bean.getGrade());
			else
				dao.setConditionGrade("=", bean.getGrade());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getProcessStatus() != null) {
			dao.setConditionProcessStatus("=", bean.getProcessStatus());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProject bean = new BaseMainProject();
		bean.setDataFromJSON(json);
		MainProject dao = new MainProject();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProject> rlist = new BaseCollection<>();
		BaseMainProject bean = new BaseMainProject();
		Map<String, Object> params = (Map<String, Object>) delicacy.common.JsonParser.parse(json);
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProject dao = new MainProject();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProject> result = dao.conditionalLoad(addtion);
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
		BaseMainProject bean = new BaseMainProject();
		bean.setDataFromJSON(json);
		MainProject dao = new MainProject();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProject bean = new BaseMainProject();
		bean.setDataFromJSON(json);
		MainProject dao = new MainProject();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProject bean = new BaseMainProject();
		bean.setDataFromJSON(json);
		MainProject dao = new MainProject();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProject bean = new BaseMainProject();
		bean.setDataFromJSON(json);
		MainProject dao = new MainProject();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


