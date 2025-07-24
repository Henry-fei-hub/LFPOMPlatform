package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCompetitionUnit;
import com.pomplatform.db.dao.CompetitionUnit;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class CompetitionUnitHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CompetitionUnitHandler.class);

	public static BaseCompetitionUnit getCompetitionUnitById( 
		java.lang.Integer competition_unit_id
	) throws Exception
	{
		CompetitionUnit dao = new CompetitionUnit();
		dao.setCompetitionUnitId(competition_unit_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCompetitionUnitExists( com.pomplatform.db.bean.BaseCompetitionUnit bean, String additional ) throws Exception {

		CompetitionUnit dao = new CompetitionUnit();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCompetitionUnit( com.pomplatform.db.bean.BaseCompetitionUnit bean, String additional ) throws Exception {

		CompetitionUnit dao = new CompetitionUnit();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCompetitionUnit> queryCompetitionUnit( com.pomplatform.db.bean.BaseCompetitionUnit bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CompetitionUnit dao = new CompetitionUnit();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCompetitionUnit> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCompetitionUnit> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCompetitionUnit addToCompetitionUnit ( BaseCompetitionUnit competitionunit )  throws Exception {
		return addToCompetitionUnit ( competitionunit , false);
	}

	public static BaseCompetitionUnit addToCompetitionUnit ( BaseCompetitionUnit competitionunit, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CompetitionUnit dao = new CompetitionUnit();
		dao.setDataFromBase(competitionunit);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCompetitionUnit addUpdateCompetitionUnit ( BaseCompetitionUnit competitionunit ) throws Exception {
		return addUpdateCompetitionUnit ( competitionunit , false);
	}

	public static BaseCompetitionUnit addUpdateCompetitionUnit ( BaseCompetitionUnit competitionunit, boolean singleTransaction  ) throws Exception {
		if(competitionunit.getCompetitionUnitId() == null) return addToCompetitionUnit(competitionunit);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CompetitionUnit dao = new CompetitionUnit();
		dao.setDataFromBase(competitionunit);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(competitionunit); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCompetitionUnit ( BaseCompetitionUnit bean ) throws Exception {
		CompetitionUnit dao = new CompetitionUnit();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCompetitionUnit updateCompetitionUnit ( BaseCompetitionUnit competitionunit ) throws Exception {
		CompetitionUnit dao = new CompetitionUnit();
		dao.setCompetitionUnitId( competitionunit.getCompetitionUnitId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(competitionunit);
			result = dao.update();
		}
		return result == 1 ? competitionunit : null ;
	}

	public static BaseCompetitionUnit updateCompetitionUnitDirect( BaseCompetitionUnit competitionunit ) throws Exception {
		CompetitionUnit dao = new CompetitionUnit();
		int result = 0;
		dao.setDataFromBase(competitionunit);
		result = dao.update();
		return result == 1 ? competitionunit : null ;
	}

	public static int setDeleteConditions(BaseCompetitionUnit bean, CompetitionUnit dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompetitionUnitId() != null) {
			dao.setConditionCompetitionUnitId("=", bean.getCompetitionUnitId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateTypeName() != null) {
				dao.setConditionPlateTypeName("=", bean.getPlateTypeName());
				count++;
			}
			if(bean.getAreaName() != null) {
				dao.setConditionAreaName("=", bean.getAreaName());
				count++;
			}
			if(bean.getName() != null) {
				dao.setConditionName("=", bean.getName());
				count++;
			}
			if(bean.getAddress() != null) {
				dao.setConditionAddress("=", bean.getAddress());
				count++;
			}
			if(bean.getWebSite() != null) {
				dao.setConditionWebSite("=", bean.getWebSite());
				count++;
			}
			if(bean.getCompanyStockCode() != null) {
				dao.setConditionCompanyStockCode("=", bean.getCompanyStockCode());
				count++;
			}
			if(bean.getCompanyProvince() != null) {
				dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
				count++;
			}
			if(bean.getCompanyCity() != null) {
				dao.setConditionCompanyCity("=", bean.getCompanyCity());
				count++;
			}
			if(bean.getBusinessPlate() != null) {
				dao.setConditionBusinessPlate("=", bean.getBusinessPlate());
				count++;
			}
			if(bean.getProfessionalPlate() != null) {
				dao.setConditionProfessionalPlate("=", bean.getProfessionalPlate());
				count++;
			}
			if(bean.getCompanyParentName() != null) {
				dao.setConditionCompanyParentName("=", bean.getCompanyParentName());
				count++;
			}
			if(bean.getCompanyParentAddress() != null) {
				dao.setConditionCompanyParentAddress("=", bean.getCompanyParentAddress());
				count++;
			}
			if(bean.getCompanyChildName() != null) {
				dao.setConditionCompanyChildName("=", bean.getCompanyChildName());
				count++;
			}
			if(bean.getCompanyEmployeeNum() != null) {
				dao.setConditionCompanyEmployeeNum("=", bean.getCompanyEmployeeNum());
				count++;
			}
			if(bean.getCompanyNature() != null) {
				dao.setConditionCompanyNature("=", bean.getCompanyNature());
				count++;
			}
			if(bean.getCompanyQualification() != null) {
				dao.setConditionCompanyQualification("=", bean.getCompanyQualification());
				count++;
			}
			if(bean.getCompanyOrganizational() != null) {
				dao.setConditionCompanyOrganizational("=", bean.getCompanyOrganizational());
				count++;
			}
			if(bean.getMainWorkCustomer() != null) {
				dao.setConditionMainWorkCustomer("=", bean.getMainWorkCustomer());
				count++;
			}
			if(bean.getMianAchievement() != null) {
				dao.setConditionMianAchievement("=", bean.getMianAchievement());
				count++;
			}
			if(bean.getCompanyBrief() != null) {
				dao.setConditionCompanyBrief("=", bean.getCompanyBrief());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getProjectVolume() != null) {
				dao.setConditionProjectVolume("=", bean.getProjectVolume());
				count++;
			}
			if(bean.getDesignHighlight() != null) {
				dao.setConditionDesignHighlight("=", bean.getDesignHighlight());
				count++;
			}
			if(bean.getDesignFeeStandard() != null) {
				dao.setConditionDesignFeeStandard("=", bean.getDesignFeeStandard());
				count++;
			}
			if(bean.getCoreStrength() != null) {
				dao.setConditionCoreStrength("=", bean.getCoreStrength());
				count++;
			}
			if(bean.getWeaknesses() != null) {
				dao.setConditionWeaknesses("=", bean.getWeaknesses());
				count++;
			}
			if(bean.getOperateEmployeeId() != null) {
				dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompetitionUnit bean, CompetitionUnit dao){
		int count = 0;
		if(bean.getCompetitionUnitId() != null) {
			dao.setConditionCompetitionUnitId("=", bean.getCompetitionUnitId());
			count++;
		}
		if(bean.getPlateTypeName() != null) {
			if(bean.getPlateTypeName().indexOf("%") >= 0)
				dao.setConditionPlateTypeName("like", bean.getPlateTypeName());
			else
				dao.setConditionPlateTypeName("=", bean.getPlateTypeName());
			count++;
		}
		if(bean.getAreaName() != null) {
			if(bean.getAreaName().indexOf("%") >= 0)
				dao.setConditionAreaName("like", bean.getAreaName());
			else
				dao.setConditionAreaName("=", bean.getAreaName());
			count++;
		}
		if(bean.getName() != null) {
			if(bean.getName().indexOf("%") >= 0)
				dao.setConditionName("like", bean.getName());
			else
				dao.setConditionName("=", bean.getName());
			count++;
		}
		if(bean.getAddress() != null) {
			if(bean.getAddress().indexOf("%") >= 0)
				dao.setConditionAddress("like", bean.getAddress());
			else
				dao.setConditionAddress("=", bean.getAddress());
			count++;
		}
		if(bean.getWebSite() != null) {
			if(bean.getWebSite().indexOf("%") >= 0)
				dao.setConditionWebSite("like", bean.getWebSite());
			else
				dao.setConditionWebSite("=", bean.getWebSite());
			count++;
		}
		if(bean.getCompanyStockCode() != null) {
			if(bean.getCompanyStockCode().indexOf("%") >= 0)
				dao.setConditionCompanyStockCode("like", bean.getCompanyStockCode());
			else
				dao.setConditionCompanyStockCode("=", bean.getCompanyStockCode());
			count++;
		}
		if(bean.getCompanyProvince() != null) {
			if(bean.getCompanyProvince().indexOf("%") >= 0)
				dao.setConditionCompanyProvince("like", bean.getCompanyProvince());
			else
				dao.setConditionCompanyProvince("=", bean.getCompanyProvince());
			count++;
		}
		if(bean.getCompanyCity() != null) {
			if(bean.getCompanyCity().indexOf("%") >= 0)
				dao.setConditionCompanyCity("like", bean.getCompanyCity());
			else
				dao.setConditionCompanyCity("=", bean.getCompanyCity());
			count++;
		}
		if(bean.getBusinessPlate() != null) {
			if(bean.getBusinessPlate().indexOf("%") >= 0)
				dao.setConditionBusinessPlate("like", bean.getBusinessPlate());
			else
				dao.setConditionBusinessPlate("=", bean.getBusinessPlate());
			count++;
		}
		if(bean.getProfessionalPlate() != null) {
			if(bean.getProfessionalPlate().indexOf("%") >= 0)
				dao.setConditionProfessionalPlate("like", bean.getProfessionalPlate());
			else
				dao.setConditionProfessionalPlate("=", bean.getProfessionalPlate());
			count++;
		}
		if(bean.getCompanyParentName() != null) {
			if(bean.getCompanyParentName().indexOf("%") >= 0)
				dao.setConditionCompanyParentName("like", bean.getCompanyParentName());
			else
				dao.setConditionCompanyParentName("=", bean.getCompanyParentName());
			count++;
		}
		if(bean.getCompanyParentAddress() != null) {
			if(bean.getCompanyParentAddress().indexOf("%") >= 0)
				dao.setConditionCompanyParentAddress("like", bean.getCompanyParentAddress());
			else
				dao.setConditionCompanyParentAddress("=", bean.getCompanyParentAddress());
			count++;
		}
		if(bean.getCompanyChildName() != null) {
			if(bean.getCompanyChildName().indexOf("%") >= 0)
				dao.setConditionCompanyChildName("like", bean.getCompanyChildName());
			else
				dao.setConditionCompanyChildName("=", bean.getCompanyChildName());
			count++;
		}
		if(bean.getCompanyEmployeeNum() != null) {
			dao.setConditionCompanyEmployeeNum("=", bean.getCompanyEmployeeNum());
			count++;
		}
		if(bean.getCompanySetup() != null) {
			dao.setConditionCompanySetup(">=", bean.getCompanySetup());
			count++;
		}
		if(bean.getCompanyNature() != null) {
			if(bean.getCompanyNature().indexOf("%") >= 0)
				dao.setConditionCompanyNature("like", bean.getCompanyNature());
			else
				dao.setConditionCompanyNature("=", bean.getCompanyNature());
			count++;
		}
		if(bean.getCompanyQualification() != null) {
			if(bean.getCompanyQualification().indexOf("%") >= 0)
				dao.setConditionCompanyQualification("like", bean.getCompanyQualification());
			else
				dao.setConditionCompanyQualification("=", bean.getCompanyQualification());
			count++;
		}
		if(bean.getCompanyOrganizational() != null) {
			if(bean.getCompanyOrganizational().indexOf("%") >= 0)
				dao.setConditionCompanyOrganizational("like", bean.getCompanyOrganizational());
			else
				dao.setConditionCompanyOrganizational("=", bean.getCompanyOrganizational());
			count++;
		}
		if(bean.getMainWorkCustomer() != null) {
			if(bean.getMainWorkCustomer().indexOf("%") >= 0)
				dao.setConditionMainWorkCustomer("like", bean.getMainWorkCustomer());
			else
				dao.setConditionMainWorkCustomer("=", bean.getMainWorkCustomer());
			count++;
		}
		if(bean.getMianAchievement() != null) {
			if(bean.getMianAchievement().indexOf("%") >= 0)
				dao.setConditionMianAchievement("like", bean.getMianAchievement());
			else
				dao.setConditionMianAchievement("=", bean.getMianAchievement());
			count++;
		}
		if(bean.getCompanyBrief() != null) {
			if(bean.getCompanyBrief().indexOf("%") >= 0)
				dao.setConditionCompanyBrief("like", bean.getCompanyBrief());
			else
				dao.setConditionCompanyBrief("=", bean.getCompanyBrief());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getProjectVolume() != null) {
			if(bean.getProjectVolume().indexOf("%") >= 0)
				dao.setConditionProjectVolume("like", bean.getProjectVolume());
			else
				dao.setConditionProjectVolume("=", bean.getProjectVolume());
			count++;
		}
		if(bean.getDesignDate() != null) {
			dao.setConditionDesignDate(">=", bean.getDesignDate());
			count++;
		}
		if(bean.getDesignHighlight() != null) {
			if(bean.getDesignHighlight().indexOf("%") >= 0)
				dao.setConditionDesignHighlight("like", bean.getDesignHighlight());
			else
				dao.setConditionDesignHighlight("=", bean.getDesignHighlight());
			count++;
		}
		if(bean.getDesignFeeStandard() != null) {
			if(bean.getDesignFeeStandard().indexOf("%") >= 0)
				dao.setConditionDesignFeeStandard("like", bean.getDesignFeeStandard());
			else
				dao.setConditionDesignFeeStandard("=", bean.getDesignFeeStandard());
			count++;
		}
		if(bean.getCoreStrength() != null) {
			if(bean.getCoreStrength().indexOf("%") >= 0)
				dao.setConditionCoreStrength("like", bean.getCoreStrength());
			else
				dao.setConditionCoreStrength("=", bean.getCoreStrength());
			count++;
		}
		if(bean.getWeaknesses() != null) {
			if(bean.getWeaknesses().indexOf("%") >= 0)
				dao.setConditionWeaknesses("like", bean.getWeaknesses());
			else
				dao.setConditionWeaknesses("=", bean.getWeaknesses());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		bean.setDataFromJSON(json);
		CompetitionUnit dao = new CompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompetitionUnit> rlist = new BaseCollection<>();
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompetitionUnit dao = new CompetitionUnit();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompetitionUnit> result = dao.conditionalLoad(addtion);
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
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		bean.setDataFromJSON(json);
		CompetitionUnit dao = new CompetitionUnit();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		bean.setDataFromJSON(json);
		CompetitionUnit dao = new CompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		bean.setDataFromJSON(json);
		CompetitionUnit dao = new CompetitionUnit();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompetitionUnit bean = new BaseCompetitionUnit();
		bean.setDataFromJSON(json);
		CompetitionUnit dao = new CompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


