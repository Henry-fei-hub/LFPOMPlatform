package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.dao.Area;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class AreaHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(AreaHandler.class);

	public static BaseArea getAreaById( 
		java.lang.Integer area_id
	) throws Exception
	{
		Area dao = new Area();
		dao.setAreaId(area_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isAreaExists( com.pomplatform.db.bean.BaseArea bean, String additional ) throws Exception {

		Area dao = new Area();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countArea( com.pomplatform.db.bean.BaseArea bean, String additional ) throws Exception {

		Area dao = new Area();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseArea> queryArea( com.pomplatform.db.bean.BaseArea bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Area dao = new Area();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseArea> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseArea> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseArea addToArea ( BaseArea area )  throws Exception {
		return addToArea ( area , false);
	}

	public static BaseArea addToArea ( BaseArea area, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Area dao = new Area();
		dao.setDataFromBase(area);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseArea addUpdateArea ( BaseArea area ) throws Exception {
		return addUpdateArea ( area , false);
	}

	public static BaseArea addUpdateArea ( BaseArea area, boolean singleTransaction  ) throws Exception {
		if(area.getAreaId() == null) return addToArea(area);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Area dao = new Area();
		dao.setDataFromBase(area);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(area); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteArea ( BaseArea bean ) throws Exception {
		Area dao = new Area();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseArea updateArea ( BaseArea area ) throws Exception {
		Area dao = new Area();
		dao.setAreaId( area.getAreaId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(area);
			result = dao.update();
		}
		return result == 1 ? area : null ;
	}

	public static BaseArea updateAreaDirect( BaseArea area ) throws Exception {
		Area dao = new Area();
		int result = 0;
		dao.setDataFromBase(area);
		result = dao.update();
		return result == 1 ? area : null ;
	}

	public static int setDeleteConditions(BaseArea bean, Area dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getAreaName() != null) {
				dao.setConditionAreaName("=", bean.getAreaName());
				count++;
			}
			if(bean.getAreaNameEn() != null) {
				dao.setConditionAreaNameEn("=", bean.getAreaNameEn());
				count++;
			}
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getAllName() != null) {
				dao.setConditionAllName("=", bean.getAllName());
				count++;
			}
			if(bean.getAreaLevel() != null) {
				dao.setConditionAreaLevel("=", bean.getAreaLevel());
				count++;
			}
			if(bean.getRegion() != null) {
				dao.setConditionRegion("=", bean.getRegion());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseArea bean, Area dao){
		int count = 0;
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
		}
		if(bean.getAreaName() != null) {
			if(bean.getAreaName().indexOf("%") >= 0)
				dao.setConditionAreaName("like", bean.getAreaName());
			else
				dao.setConditionAreaName("=", bean.getAreaName());
			count++;
		}
		if(bean.getAreaNameEn() != null) {
			if(bean.getAreaNameEn().indexOf("%") >= 0)
				dao.setConditionAreaNameEn("like", bean.getAreaNameEn());
			else
				dao.setConditionAreaNameEn("=", bean.getAreaNameEn());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getAllName() != null) {
			if(bean.getAllName().indexOf("%") >= 0)
				dao.setConditionAllName("like", bean.getAllName());
			else
				dao.setConditionAllName("=", bean.getAllName());
			count++;
		}
		if(bean.getAreaLevel() != null) {
			dao.setConditionAreaLevel("=", bean.getAreaLevel());
			count++;
		}
		if(bean.getRegion() != null) {
			dao.setConditionRegion("=", bean.getRegion());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseArea bean = new BaseArea();
		bean.setDataFromJSON(json);
		Area dao = new Area();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseArea> rlist = new BaseCollection<>();
		BaseArea bean = new BaseArea();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Area dao = new Area();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseArea> result = dao.conditionalLoad(addtion);
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
		BaseArea bean = new BaseArea();
		bean.setDataFromJSON(json);
		Area dao = new Area();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseArea bean = new BaseArea();
		bean.setDataFromJSON(json);
		Area dao = new Area();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseArea bean = new BaseArea();
		bean.setDataFromJSON(json);
		Area dao = new Area();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseArea bean = new BaseArea();
		bean.setDataFromJSON(json);
		Area dao = new Area();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


