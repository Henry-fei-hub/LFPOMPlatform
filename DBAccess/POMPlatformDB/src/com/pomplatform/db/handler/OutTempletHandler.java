package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseOutTemplet;
import com.pomplatform.db.dao.OutTemplet;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class OutTempletHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(OutTempletHandler.class);

	public static BaseOutTemplet getOutTempletById( 
		java.lang.Integer out_templet_id
	) throws Exception
	{
		OutTemplet dao = new OutTemplet();
		dao.setOutTempletId(out_templet_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isOutTempletExists( com.pomplatform.db.bean.BaseOutTemplet bean, String additional ) throws Exception {

		OutTemplet dao = new OutTemplet();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countOutTemplet( com.pomplatform.db.bean.BaseOutTemplet bean, String additional ) throws Exception {

		OutTemplet dao = new OutTemplet();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseOutTemplet> queryOutTemplet( com.pomplatform.db.bean.BaseOutTemplet bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		OutTemplet dao = new OutTemplet();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseOutTemplet> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseOutTemplet> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseOutTemplet addToOutTemplet ( BaseOutTemplet outtemplet )  throws Exception {
		return addToOutTemplet ( outtemplet , false);
	}

	public static BaseOutTemplet addToOutTemplet ( BaseOutTemplet outtemplet, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		OutTemplet dao = new OutTemplet();
		dao.setDataFromBase(outtemplet);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseOutTemplet addUpdateOutTemplet ( BaseOutTemplet outtemplet ) throws Exception {
		return addUpdateOutTemplet ( outtemplet , false);
	}

	public static BaseOutTemplet addUpdateOutTemplet ( BaseOutTemplet outtemplet, boolean singleTransaction  ) throws Exception {
		if(outtemplet.getOutTempletId() == null) return addToOutTemplet(outtemplet);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		OutTemplet dao = new OutTemplet();
		dao.setDataFromBase(outtemplet);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(outtemplet); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteOutTemplet ( BaseOutTemplet bean ) throws Exception {
		OutTemplet dao = new OutTemplet();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseOutTemplet updateOutTemplet ( BaseOutTemplet outtemplet ) throws Exception {
		OutTemplet dao = new OutTemplet();
		dao.setOutTempletId( outtemplet.getOutTempletId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(outtemplet);
			result = dao.update();
		}
		return result == 1 ? outtemplet : null ;
	}

	public static BaseOutTemplet updateOutTempletDirect( BaseOutTemplet outtemplet ) throws Exception {
		OutTemplet dao = new OutTemplet();
		int result = 0;
		dao.setDataFromBase(outtemplet);
		result = dao.update();
		return result == 1 ? outtemplet : null ;
	}

	public static int setDeleteConditions(BaseOutTemplet bean, OutTemplet dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getOutTempletId() != null) {
			dao.setConditionOutTempletId("=", bean.getOutTempletId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getBusinessType() != null) {
				dao.setConditionBusinessType("=", bean.getBusinessType());
				count++;
			}
			if(bean.getTempletName() != null) {
				dao.setConditionTempletName("=", bean.getTempletName());
				count++;
			}
			if(bean.getDefaultTemplet() != null) {
				dao.setConditionDefaultTemplet("=", bean.getDefaultTemplet());
				count++;
			}
			if(bean.getDisableType() != null) {
				dao.setConditionDisableType("=", bean.getDisableType());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseOutTemplet bean, OutTemplet dao){
		int count = 0;
		if(bean.getOutTempletId() != null) {
			dao.setConditionOutTempletId("=", bean.getOutTempletId());
			count++;
		}
		if(bean.getBusinessType() != null) {
			dao.setConditionBusinessType("=", bean.getBusinessType());
			count++;
		}
		if(bean.getTempletName() != null) {
			if(bean.getTempletName().indexOf("%") >= 0)
				dao.setConditionTempletName("like", bean.getTempletName());
			else
				dao.setConditionTempletName("=", bean.getTempletName());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDefaultTemplet() != null) {
			dao.setConditionDefaultTemplet("=", bean.getDefaultTemplet());
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
		BaseOutTemplet bean = new BaseOutTemplet();
		bean.setDataFromJSON(json);
		OutTemplet dao = new OutTemplet();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseOutTemplet> rlist = new BaseCollection<>();
		BaseOutTemplet bean = new BaseOutTemplet();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		OutTemplet dao = new OutTemplet();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseOutTemplet> result = dao.conditionalLoad(addtion);
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
		BaseOutTemplet bean = new BaseOutTemplet();
		bean.setDataFromJSON(json);
		OutTemplet dao = new OutTemplet();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseOutTemplet bean = new BaseOutTemplet();
		bean.setDataFromJSON(json);
		OutTemplet dao = new OutTemplet();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseOutTemplet bean = new BaseOutTemplet();
		bean.setDataFromJSON(json);
		OutTemplet dao = new OutTemplet();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseOutTemplet bean = new BaseOutTemplet();
		bean.setDataFromJSON(json);
		OutTemplet dao = new OutTemplet();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


