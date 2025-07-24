package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOutTempletOption;
import com.pomplatform.db.dao.OutTempletOption;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OutTempletOptionHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutTempletOptionHandler.class);

	public static BaseOutTempletOption getOutTempletOptionById( 
		java.lang.Integer out_templet_option_id
	) throws Exception
	{
		OutTempletOption dao = new OutTempletOption();
		dao.setOutTempletOptionId(out_templet_option_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutTempletOptionExists( com.pomplatform.db.bean.BaseOutTempletOption bean, String additional ) throws Exception {

		OutTempletOption dao = new OutTempletOption();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutTempletOption( com.pomplatform.db.bean.BaseOutTempletOption bean, String additional ) throws Exception {

		OutTempletOption dao = new OutTempletOption();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutTempletOption> queryOutTempletOption( com.pomplatform.db.bean.BaseOutTempletOption bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutTempletOption dao = new OutTempletOption();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutTempletOption> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutTempletOption> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutTempletOption addToOutTempletOption ( BaseOutTempletOption outtempletoption )  throws Exception {
		return addToOutTempletOption ( outtempletoption , false);
	}

	public static BaseOutTempletOption addToOutTempletOption ( BaseOutTempletOption outtempletoption, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutTempletOption dao = new OutTempletOption();
		dao.setDataFromBase(outtempletoption);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutTempletOption addUpdateOutTempletOption ( BaseOutTempletOption outtempletoption ) throws Exception {
		return addUpdateOutTempletOption ( outtempletoption , false);
	}

	public static BaseOutTempletOption addUpdateOutTempletOption ( BaseOutTempletOption outtempletoption, boolean singleTransaction  ) throws Exception {
		if(outtempletoption.getOutTempletOptionId() == null) return addToOutTempletOption(outtempletoption);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutTempletOption dao = new OutTempletOption();
		dao.setDataFromBase(outtempletoption);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outtempletoption); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutTempletOption ( BaseOutTempletOption bean ) throws Exception {
		OutTempletOption dao = new OutTempletOption();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutTempletOption updateOutTempletOption ( BaseOutTempletOption outtempletoption ) throws Exception {
		OutTempletOption dao = new OutTempletOption();
		dao.setOutTempletOptionId( outtempletoption.getOutTempletOptionId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outtempletoption);
			result = dao.update();
		}
		return result == 1 ? outtempletoption : null ;
	}

	public static BaseOutTempletOption updateOutTempletOptionDirect( BaseOutTempletOption outtempletoption ) throws Exception {
		OutTempletOption dao = new OutTempletOption();
		int result = 0;
		dao.setDataFromBase(outtempletoption);
		result = dao.update();
		return result == 1 ? outtempletoption : null ;
	}

	public static int setDeleteConditions(BaseOutTempletOption bean, OutTempletOption dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutTempletOptionId() != null) {
			dao.setConditionOutTempletOptionId("=", bean.getOutTempletOptionId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getOptionType() != null) {
				dao.setConditionOptionType("=", bean.getOptionType());
				count++;
			}
			if(bean.getOptionName() != null) {
				dao.setConditionOptionName("=", bean.getOptionName());
				count++;
			}
			if(bean.getDisableType() != null) {
				dao.setConditionDisableType("=", bean.getDisableType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutTempletOption bean, OutTempletOption dao){
		int count = 0;
		if(bean.getOutTempletOptionId() != null) {
			dao.setConditionOutTempletOptionId("=", bean.getOutTempletOptionId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getOptionType() != null) {
			dao.setConditionOptionType("=", bean.getOptionType());
			count++;
		}
		if(bean.getOptionName() != null) {
			if(bean.getOptionName().indexOf("%") >= 0)
				dao.setConditionOptionName("like", bean.getOptionName());
			else
				dao.setConditionOptionName("=", bean.getOptionName());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDisableType() != null) {
			dao.setConditionDisableType("=", bean.getDisableType());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseOutTempletOption bean = new BaseOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletOption dao = new OutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutTempletOption> rlist = new BaseCollection<>();
		BaseOutTempletOption bean = new BaseOutTempletOption();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutTempletOption dao = new OutTempletOption();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutTempletOption> result = dao.conditionalLoad(addtion);
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
		BaseOutTempletOption bean = new BaseOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletOption dao = new OutTempletOption();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutTempletOption bean = new BaseOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletOption dao = new OutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutTempletOption bean = new BaseOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletOption dao = new OutTempletOption();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutTempletOption bean = new BaseOutTempletOption();
		bean.setDataFromJSON(json);
		OutTempletOption dao = new OutTempletOption();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


