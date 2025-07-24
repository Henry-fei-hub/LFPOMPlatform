package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption;
import com.pomplatform.db.dao.OutTempletsLinkOutTempletOption;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OutTempletsLinkOutTempletOptionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutTempletsLinkOutTempletOptionHandler.class);

	public static BaseOutTempletsLinkOutTempletOption getOutTempletsLinkOutTempletOptionById( 
		java.lang.Integer out_templets_link_out_templet_option_id
	) throws Exception
	{
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setOutTempletsLinkOutTempletOptionId(out_templets_link_out_templet_option_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutTempletsLinkOutTempletOptionExists( com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption bean, String additional ) throws Exception {

		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutTempletsLinkOutTempletOption( com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption bean, String additional ) throws Exception {

		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutTempletsLinkOutTempletOption> queryOutTempletsLinkOutTempletOption( com.pomplatform.db.bean.BaseOutTempletsLinkOutTempletOption bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutTempletsLinkOutTempletOption> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutTempletsLinkOutTempletOption> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutTempletsLinkOutTempletOption addToOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption )  throws Exception {
		return addToOutTempletsLinkOutTempletOption ( outtempletslinkouttempletoption , false);
	}

	public static BaseOutTempletsLinkOutTempletOption addToOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setDataFromBase(outtempletslinkouttempletoption);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutTempletsLinkOutTempletOption addUpdateOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption ) throws Exception {
		return addUpdateOutTempletsLinkOutTempletOption ( outtempletslinkouttempletoption , false);
	}

	public static BaseOutTempletsLinkOutTempletOption addUpdateOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption, boolean singleTransaction  ) throws Exception {
		if(outtempletslinkouttempletoption.getOutTempletsLinkOutTempletOptionId() == null) return addToOutTempletsLinkOutTempletOption(outtempletslinkouttempletoption);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setDataFromBase(outtempletslinkouttempletoption);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outtempletslinkouttempletoption); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption bean ) throws Exception {
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutTempletsLinkOutTempletOption updateOutTempletsLinkOutTempletOption ( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption ) throws Exception {
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setOutTempletsLinkOutTempletOptionId( outtempletslinkouttempletoption.getOutTempletsLinkOutTempletOptionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outtempletslinkouttempletoption);
			result = dao.update();
		}
		return result == 1 ? outtempletslinkouttempletoption : null ;
	}

	public static BaseOutTempletsLinkOutTempletOption updateOutTempletsLinkOutTempletOptionDirect( BaseOutTempletsLinkOutTempletOption outtempletslinkouttempletoption ) throws Exception {
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		int result = 0;
		dao.setDataFromBase(outtempletslinkouttempletoption);
		result = dao.update();
		return result == 1 ? outtempletslinkouttempletoption : null ;
	}

	public static int setDeleteConditions(BaseOutTempletsLinkOutTempletOption bean, OutTempletsLinkOutTempletOption dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutTempletsLinkOutTempletOptionId() != null) {
			dao.setConditionOutTempletsLinkOutTempletOptionId("=", bean.getOutTempletsLinkOutTempletOptionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getOutTempletId() != null) {
				dao.setConditionOutTempletId("=", bean.getOutTempletId());
				count++;
			}
			if(bean.getOutTempletOptionId() != null) {
				dao.setConditionOutTempletOptionId("=", bean.getOutTempletOptionId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutTempletsLinkOutTempletOption bean, OutTempletsLinkOutTempletOption dao){
		int count = 0;
		if(bean.getOutTempletsLinkOutTempletOptionId() != null) {
			dao.setConditionOutTempletsLinkOutTempletOptionId("=", bean.getOutTempletsLinkOutTempletOptionId());
			count++;
		}
		if(bean.getOutTempletId() != null) {
			dao.setConditionOutTempletId("=", bean.getOutTempletId());
			count++;
		}
		if(bean.getOutTempletOptionId() != null) {
			dao.setConditionOutTempletOptionId("=", bean.getOutTempletOptionId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutTempletsLinkOutTempletOption> rlist = new BaseCollection<>();
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutTempletsLinkOutTempletOption> result = dao.conditionalLoad(addtion);
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
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutTempletsLinkOutTempletOption bean = new BaseOutTempletsLinkOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletsLinkOutTempletOption dao = new OutTempletsLinkOutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


