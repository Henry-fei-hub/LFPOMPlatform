package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseJaidFunctionMaintenance;
import com.pomplatform.db.dao.JaidFunctionMaintenance;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class JaidFunctionMaintenanceHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(JaidFunctionMaintenanceHandler.class);

	public static BaseJaidFunctionMaintenance getJaidFunctionMaintenanceById( 
		java.lang.Integer jaid_function_maintenance_id
	) throws Exception
	{
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setJaidFunctionMaintenanceId(jaid_function_maintenance_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isJaidFunctionMaintenanceExists( com.pomplatform.db.bean.BaseJaidFunctionMaintenance bean, String additional ) throws Exception {

		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countJaidFunctionMaintenance( com.pomplatform.db.bean.BaseJaidFunctionMaintenance bean, String additional ) throws Exception {

		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseJaidFunctionMaintenance> queryJaidFunctionMaintenance( com.pomplatform.db.bean.BaseJaidFunctionMaintenance bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseJaidFunctionMaintenance> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseJaidFunctionMaintenance> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseJaidFunctionMaintenance addToJaidFunctionMaintenance ( BaseJaidFunctionMaintenance jaidfunctionmaintenance )  throws Exception {
		return addToJaidFunctionMaintenance ( jaidfunctionmaintenance , false);
	}

	public static BaseJaidFunctionMaintenance addToJaidFunctionMaintenance ( BaseJaidFunctionMaintenance jaidfunctionmaintenance, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setDataFromBase(jaidfunctionmaintenance);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseJaidFunctionMaintenance addUpdateJaidFunctionMaintenance ( BaseJaidFunctionMaintenance jaidfunctionmaintenance ) throws Exception {
		return addUpdateJaidFunctionMaintenance ( jaidfunctionmaintenance , false);
	}

	public static BaseJaidFunctionMaintenance addUpdateJaidFunctionMaintenance ( BaseJaidFunctionMaintenance jaidfunctionmaintenance, boolean singleTransaction  ) throws Exception {
		if(jaidfunctionmaintenance.getJaidFunctionMaintenanceId() == null) return addToJaidFunctionMaintenance(jaidfunctionmaintenance);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setDataFromBase(jaidfunctionmaintenance);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(jaidfunctionmaintenance); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteJaidFunctionMaintenance ( BaseJaidFunctionMaintenance bean ) throws Exception {
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseJaidFunctionMaintenance updateJaidFunctionMaintenance ( BaseJaidFunctionMaintenance jaidfunctionmaintenance ) throws Exception {
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setJaidFunctionMaintenanceId( jaidfunctionmaintenance.getJaidFunctionMaintenanceId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(jaidfunctionmaintenance);
			result = dao.update();
		}
		return result == 1 ? jaidfunctionmaintenance : null ;
	}

	public static BaseJaidFunctionMaintenance updateJaidFunctionMaintenanceDirect( BaseJaidFunctionMaintenance jaidfunctionmaintenance ) throws Exception {
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		int result = 0;
		dao.setDataFromBase(jaidfunctionmaintenance);
		result = dao.update();
		return result == 1 ? jaidfunctionmaintenance : null ;
	}

	public static int setDeleteConditions(BaseJaidFunctionMaintenance bean, JaidFunctionMaintenance dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getJaidFunctionMaintenanceId() != null) {
			dao.setConditionJaidFunctionMaintenanceId("=", bean.getJaidFunctionMaintenanceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getNameZh() != null) {
				dao.setConditionNameZh("=", bean.getNameZh());
				count++;
			}
			if(bean.getNameEn() != null) {
				dao.setConditionNameEn("=", bean.getNameEn());
				count++;
			}
			if(bean.getProjectAddressZh() != null) {
				dao.setConditionProjectAddressZh("=", bean.getProjectAddressZh());
				count++;
			}
			if(bean.getProjectAddressEn() != null) {
				dao.setConditionProjectAddressEn("=", bean.getProjectAddressEn());
				count++;
			}
			if(bean.getDesignTimeZh() != null) {
				dao.setConditionDesignTimeZh("=", bean.getDesignTimeZh());
				count++;
			}
			if(bean.getDesignTimeEn() != null) {
				dao.setConditionDesignTimeEn("=", bean.getDesignTimeEn());
				count++;
			}
			if(bean.getFinishTimeZh() != null) {
				dao.setConditionFinishTimeZh("=", bean.getFinishTimeZh());
				count++;
			}
			if(bean.getFinishTimeEn() != null) {
				dao.setConditionFinishTimeEn("=", bean.getFinishTimeEn());
				count++;
			}
			if(bean.getProjectArea() != null) {
				dao.setConditionProjectArea("=", bean.getProjectArea());
				count++;
			}
			if(bean.getMainThemeZh() != null) {
				dao.setConditionMainThemeZh("=", bean.getMainThemeZh());
				count++;
			}
			if(bean.getMainThemeEn() != null) {
				dao.setConditionMainThemeEn("=", bean.getMainThemeEn());
				count++;
			}
			if(bean.getMainPicture() != null) {
				dao.setConditionMainPicture("=", bean.getMainPicture());
				count++;
			}
			if(bean.getTurnPictureOne() != null) {
				dao.setConditionTurnPictureOne("=", bean.getTurnPictureOne());
				count++;
			}
			if(bean.getTurnPictureTwo() != null) {
				dao.setConditionTurnPictureTwo("=", bean.getTurnPictureTwo());
				count++;
			}
			if(bean.getTurnPictureThree() != null) {
				dao.setConditionTurnPictureThree("=", bean.getTurnPictureThree());
				count++;
			}
			if(bean.getTurnPictureFour() != null) {
				dao.setConditionTurnPictureFour("=", bean.getTurnPictureFour());
				count++;
			}
			if(bean.getTurnPictureFive() != null) {
				dao.setConditionTurnPictureFive("=", bean.getTurnPictureFive());
				count++;
			}
			if(bean.getTurnPictureSix() != null) {
				dao.setConditionTurnPictureSix("=", bean.getTurnPictureSix());
				count++;
			}
			if(bean.getDescriptionZh() != null) {
				dao.setConditionDescriptionZh("=", bean.getDescriptionZh());
				count++;
			}
			if(bean.getDescriptionEn() != null) {
				dao.setConditionDescriptionEn("=", bean.getDescriptionEn());
				count++;
			}
			if(bean.getBriefZh() != null) {
				dao.setConditionBriefZh("=", bean.getBriefZh());
				count++;
			}
			if(bean.getBriefEn() != null) {
				dao.setConditionBriefEn("=", bean.getBriefEn());
				count++;
			}
			if(bean.getIsAudited() != null) {
				dao.setConditionIsAudited("=", bean.getIsAudited());
				count++;
			}
			if(bean.getClickNum() != null) {
				dao.setConditionClickNum("=", bean.getClickNum());
				count++;
			}
			if(bean.getOrderId() != null) {
				dao.setConditionOrderId("=", bean.getOrderId());
				count++;
			}
			if(bean.getType() != null) {
				dao.setConditionType("=", bean.getType());
				count++;
			}
			if(bean.getTypeDetail() != null) {
				dao.setConditionTypeDetail("=", bean.getTypeDetail());
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

	public static int setConditions(BaseJaidFunctionMaintenance bean, JaidFunctionMaintenance dao){
		int count = 0;
		if(bean.getJaidFunctionMaintenanceId() != null) {
			dao.setConditionJaidFunctionMaintenanceId("=", bean.getJaidFunctionMaintenanceId());
			count++;
		}
		if(bean.getNameZh() != null) {
			if(bean.getNameZh().indexOf("%") >= 0)
				dao.setConditionNameZh("like", bean.getNameZh());
			else
				dao.setConditionNameZh("=", bean.getNameZh());
			count++;
		}
		if(bean.getNameEn() != null) {
			if(bean.getNameEn().indexOf("%") >= 0)
				dao.setConditionNameEn("like", bean.getNameEn());
			else
				dao.setConditionNameEn("=", bean.getNameEn());
			count++;
		}
		if(bean.getProjectAddressZh() != null) {
			if(bean.getProjectAddressZh().indexOf("%") >= 0)
				dao.setConditionProjectAddressZh("like", bean.getProjectAddressZh());
			else
				dao.setConditionProjectAddressZh("=", bean.getProjectAddressZh());
			count++;
		}
		if(bean.getProjectAddressEn() != null) {
			if(bean.getProjectAddressEn().indexOf("%") >= 0)
				dao.setConditionProjectAddressEn("like", bean.getProjectAddressEn());
			else
				dao.setConditionProjectAddressEn("=", bean.getProjectAddressEn());
			count++;
		}
		if(bean.getDesignTimeZh() != null) {
			if(bean.getDesignTimeZh().indexOf("%") >= 0)
				dao.setConditionDesignTimeZh("like", bean.getDesignTimeZh());
			else
				dao.setConditionDesignTimeZh("=", bean.getDesignTimeZh());
			count++;
		}
		if(bean.getDesignTimeEn() != null) {
			if(bean.getDesignTimeEn().indexOf("%") >= 0)
				dao.setConditionDesignTimeEn("like", bean.getDesignTimeEn());
			else
				dao.setConditionDesignTimeEn("=", bean.getDesignTimeEn());
			count++;
		}
		if(bean.getFinishTimeZh() != null) {
			if(bean.getFinishTimeZh().indexOf("%") >= 0)
				dao.setConditionFinishTimeZh("like", bean.getFinishTimeZh());
			else
				dao.setConditionFinishTimeZh("=", bean.getFinishTimeZh());
			count++;
		}
		if(bean.getFinishTimeEn() != null) {
			if(bean.getFinishTimeEn().indexOf("%") >= 0)
				dao.setConditionFinishTimeEn("like", bean.getFinishTimeEn());
			else
				dao.setConditionFinishTimeEn("=", bean.getFinishTimeEn());
			count++;
		}
		if(bean.getProjectArea() != null) {
			if(bean.getProjectArea().indexOf("%") >= 0)
				dao.setConditionProjectArea("like", bean.getProjectArea());
			else
				dao.setConditionProjectArea("=", bean.getProjectArea());
			count++;
		}
		if(bean.getMainThemeZh() != null) {
			if(bean.getMainThemeZh().indexOf("%") >= 0)
				dao.setConditionMainThemeZh("like", bean.getMainThemeZh());
			else
				dao.setConditionMainThemeZh("=", bean.getMainThemeZh());
			count++;
		}
		if(bean.getMainThemeEn() != null) {
			if(bean.getMainThemeEn().indexOf("%") >= 0)
				dao.setConditionMainThemeEn("like", bean.getMainThemeEn());
			else
				dao.setConditionMainThemeEn("=", bean.getMainThemeEn());
			count++;
		}
		if(bean.getMainPicture() != null) {
			if(bean.getMainPicture().indexOf("%") >= 0)
				dao.setConditionMainPicture("like", bean.getMainPicture());
			else
				dao.setConditionMainPicture("=", bean.getMainPicture());
			count++;
		}
		if(bean.getTurnPictureOne() != null) {
			if(bean.getTurnPictureOne().indexOf("%") >= 0)
				dao.setConditionTurnPictureOne("like", bean.getTurnPictureOne());
			else
				dao.setConditionTurnPictureOne("=", bean.getTurnPictureOne());
			count++;
		}
		if(bean.getTurnPictureTwo() != null) {
			if(bean.getTurnPictureTwo().indexOf("%") >= 0)
				dao.setConditionTurnPictureTwo("like", bean.getTurnPictureTwo());
			else
				dao.setConditionTurnPictureTwo("=", bean.getTurnPictureTwo());
			count++;
		}
		if(bean.getTurnPictureThree() != null) {
			if(bean.getTurnPictureThree().indexOf("%") >= 0)
				dao.setConditionTurnPictureThree("like", bean.getTurnPictureThree());
			else
				dao.setConditionTurnPictureThree("=", bean.getTurnPictureThree());
			count++;
		}
		if(bean.getTurnPictureFour() != null) {
			if(bean.getTurnPictureFour().indexOf("%") >= 0)
				dao.setConditionTurnPictureFour("like", bean.getTurnPictureFour());
			else
				dao.setConditionTurnPictureFour("=", bean.getTurnPictureFour());
			count++;
		}
		if(bean.getTurnPictureFive() != null) {
			if(bean.getTurnPictureFive().indexOf("%") >= 0)
				dao.setConditionTurnPictureFive("like", bean.getTurnPictureFive());
			else
				dao.setConditionTurnPictureFive("=", bean.getTurnPictureFive());
			count++;
		}
		if(bean.getTurnPictureSix() != null) {
			if(bean.getTurnPictureSix().indexOf("%") >= 0)
				dao.setConditionTurnPictureSix("like", bean.getTurnPictureSix());
			else
				dao.setConditionTurnPictureSix("=", bean.getTurnPictureSix());
			count++;
		}
		if(bean.getDescriptionZh() != null) {
			if(bean.getDescriptionZh().indexOf("%") >= 0)
				dao.setConditionDescriptionZh("like", bean.getDescriptionZh());
			else
				dao.setConditionDescriptionZh("=", bean.getDescriptionZh());
			count++;
		}
		if(bean.getDescriptionEn() != null) {
			if(bean.getDescriptionEn().indexOf("%") >= 0)
				dao.setConditionDescriptionEn("like", bean.getDescriptionEn());
			else
				dao.setConditionDescriptionEn("=", bean.getDescriptionEn());
			count++;
		}
		if(bean.getBriefZh() != null) {
			if(bean.getBriefZh().indexOf("%") >= 0)
				dao.setConditionBriefZh("like", bean.getBriefZh());
			else
				dao.setConditionBriefZh("=", bean.getBriefZh());
			count++;
		}
		if(bean.getBriefEn() != null) {
			if(bean.getBriefEn().indexOf("%") >= 0)
				dao.setConditionBriefEn("like", bean.getBriefEn());
			else
				dao.setConditionBriefEn("=", bean.getBriefEn());
			count++;
		}
		if(bean.getIsAudited() != null) {
			dao.setConditionIsAudited("=", bean.getIsAudited());
			count++;
		}
		if(bean.getClickNum() != null) {
			dao.setConditionClickNum("=", bean.getClickNum());
			count++;
		}
		if(bean.getOrderId() != null) {
			dao.setConditionOrderId("=", bean.getOrderId());
			count++;
		}
		if(bean.getPublishTime() != null) {
			dao.setConditionPublishTime(">=", bean.getPublishTime());
			count++;
		}
		if(bean.getType() != null) {
			dao.setConditionType("=", bean.getType());
			count++;
		}
		if(bean.getTypeDetail() != null) {
			dao.setConditionTypeDetail("=", bean.getTypeDetail());
			count++;
		}
		if(bean.getOperateEmployeeId() != null) {
			dao.setConditionOperateEmployeeId("=", bean.getOperateEmployeeId());
			count++;
		}
		if(bean.getOperateTime() != null) {
			dao.setConditionOperateTime(">=", bean.getOperateTime());
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
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		bean.setDataFromJSON(json);
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseJaidFunctionMaintenance> rlist = new BaseCollection<>();
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseJaidFunctionMaintenance> result = dao.conditionalLoad(addtion);
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
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		bean.setDataFromJSON(json);
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		bean.setDataFromJSON(json);
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		bean.setDataFromJSON(json);
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseJaidFunctionMaintenance bean = new BaseJaidFunctionMaintenance();
		bean.setDataFromJSON(json);
		JaidFunctionMaintenance dao = new JaidFunctionMaintenance();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


