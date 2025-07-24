package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectCompetitionUnit;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MainProjectCompetitionUnitHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectCompetitionUnitHandler.class);

	public static BaseMainProjectCompetitionUnit getMainProjectCompetitionUnitById(
			java.lang.Integer main_project_competition_unit_id
	) throws Exception
	{
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setMainProjectCompetitionUnitId(main_project_competition_unit_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectCompetitionUnitExists( com.pomplatform.db.bean.BaseMainProjectCompetitionUnit bean, String additional ) throws Exception {

		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectCompetitionUnit( com.pomplatform.db.bean.BaseMainProjectCompetitionUnit bean, String additional ) throws Exception {

		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectCompetitionUnit> queryMainProjectCompetitionUnit( com.pomplatform.db.bean.BaseMainProjectCompetitionUnit bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectCompetitionUnit> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectCompetitionUnit> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectCompetitionUnit addToMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit mainprojectcompetitionunit )  throws Exception {
		return addToMainProjectCompetitionUnit ( mainprojectcompetitionunit , false);
	}

	public static BaseMainProjectCompetitionUnit addToMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit mainprojectcompetitionunit, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setDataFromBase(mainprojectcompetitionunit);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectCompetitionUnit addUpdateMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit mainprojectcompetitionunit ) throws Exception {
		return addUpdateMainProjectCompetitionUnit ( mainprojectcompetitionunit , false);
	}

	public static BaseMainProjectCompetitionUnit addUpdateMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit mainprojectcompetitionunit, boolean singleTransaction  ) throws Exception {
		if(mainprojectcompetitionunit.getMainProjectCompetitionUnitId() == null) return addToMainProjectCompetitionUnit(mainprojectcompetitionunit);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setDataFromBase(mainprojectcompetitionunit);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectcompetitionunit);
			if(dao.isThisObjectModified()) {
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit bean ) throws Exception {
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectCompetitionUnit updateMainProjectCompetitionUnit ( BaseMainProjectCompetitionUnit mainprojectcompetitionunit ) throws Exception {
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setMainProjectCompetitionUnitId( mainprojectcompetitionunit.getMainProjectCompetitionUnitId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectcompetitionunit);
			result = dao.update();
		}
		return result == 1 ? mainprojectcompetitionunit : null ;
	}

	public static BaseMainProjectCompetitionUnit updateMainProjectCompetitionUnitDirect( BaseMainProjectCompetitionUnit mainprojectcompetitionunit ) throws Exception {
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		int result = 0;
		dao.setDataFromBase(mainprojectcompetitionunit);
		result = dao.update();
		return result == 1 ? mainprojectcompetitionunit : null ;
	}

	public static int setDeleteConditions(BaseMainProjectCompetitionUnit bean, MainProjectCompetitionUnit dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectCompetitionUnitId() != null) {
			dao.setConditionMainProjectCompetitionUnitId("=", bean.getMainProjectCompetitionUnitId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getCompetitionUnitId() != null) {
				dao.setConditionCompetitionUnitId("=", bean.getCompetitionUnitId());
				count++;
			}
			if(bean.getPreProjectId() != null) {
				dao.setConditionPreProjectId("=", bean.getPreProjectId());
				count++;
			}
			if(bean.getBiddingInformation() != null) {
				dao.setConditionBiddingInformation("=", bean.getBiddingInformation());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectCompetitionUnit bean, MainProjectCompetitionUnit dao){
		int count = 0;
		if(bean.getMainProjectCompetitionUnitId() != null) {
			dao.setConditionMainProjectCompetitionUnitId("=", bean.getMainProjectCompetitionUnitId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCompetitionUnitId() != null) {
			dao.setConditionCompetitionUnitId("=", bean.getCompetitionUnitId());
			count++;
		}
		if(bean.getPreProjectId() != null) {
			dao.setConditionPreProjectId("=", bean.getPreProjectId());
			count++;
		}
		if(bean.getBiddingInformation() != null) {
			if(bean.getBiddingInformation().indexOf("%") >= 0)
				dao.setConditionBiddingInformation("like", bean.getBiddingInformation());
			else
				dao.setConditionBiddingInformation("=", bean.getBiddingInformation());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		bean.setDataFromJSON(json);
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectCompetitionUnit> rlist = new BaseCollection<>();
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectCompetitionUnit> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		bean.setDataFromJSON(json);
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		bean.setDataFromJSON(json);
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		bean.setDataFromJSON(json);
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectCompetitionUnit bean = new BaseMainProjectCompetitionUnit();
		bean.setDataFromJSON(json);
		MainProjectCompetitionUnit dao = new MainProjectCompetitionUnit();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}

