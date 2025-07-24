package com.pomplatform.db.handler;

import org.apache.log4j.Logger;
import com.pomplatform.db.bean.BaseCnLabel;
import java.util.List;
import com.pomplatform.db.dao.CnLabel;
import delicacy.connection.ThreadConnection;
import delicacy.common.GenericDao;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import delicacy.common.BaseCollection;

public class CnLabelHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(CnLabelHandler.class);

	public static BaseCnLabel getCnLabelById( 
		java.lang.Integer label_id
	) throws Exception
	{
		CnLabel dao = new CnLabel();
		dao.setLabelId(label_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isCnLabelExists( com.pomplatform.db.bean.BaseCnLabel bean, String additional ) throws Exception {

		CnLabel dao = new CnLabel();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countCnLabel( com.pomplatform.db.bean.BaseCnLabel bean, String additional ) throws Exception {

		CnLabel dao = new CnLabel();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseCnLabel> queryCnLabel( com.pomplatform.db.bean.BaseCnLabel bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		CnLabel dao = new CnLabel();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseCnLabel> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseCnLabel> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseCnLabel addToCnLabel ( BaseCnLabel cnlabel )  throws Exception {
		return addToCnLabel ( cnlabel , false);
	}

	public static BaseCnLabel addToCnLabel ( BaseCnLabel cnlabel, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		CnLabel dao = new CnLabel();
		dao.setDataFromBase(cnlabel);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseCnLabel addUpdateCnLabel ( BaseCnLabel cnlabel ) throws Exception {
		return addUpdateCnLabel ( cnlabel , false);
	}

	public static BaseCnLabel addUpdateCnLabel ( BaseCnLabel cnlabel, boolean singleTransaction  ) throws Exception {
		if(cnlabel.getLabelId() == null) return addToCnLabel(cnlabel);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		CnLabel dao = new CnLabel();
		dao.setDataFromBase(cnlabel);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(cnlabel); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteCnLabel ( BaseCnLabel bean ) throws Exception {
		CnLabel dao = new CnLabel();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseCnLabel updateCnLabel ( BaseCnLabel cnlabel ) throws Exception {
		CnLabel dao = new CnLabel();
		dao.setLabelId( cnlabel.getLabelId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(cnlabel);
			result = dao.update();
		}
		return result == 1 ? cnlabel : null ;
	}

	public static BaseCnLabel updateCnLabelDirect( BaseCnLabel cnlabel ) throws Exception {
		CnLabel dao = new CnLabel();
		int result = 0;
		dao.setDataFromBase(cnlabel);
		result = dao.update();
		return result == 1 ? cnlabel : null ;
	}

	public static int setDeleteConditions(BaseCnLabel bean, CnLabel dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getLabelId() != null) {
			dao.setConditionLabelId("=", bean.getLabelId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getLabelName() != null) {
				dao.setConditionLabelName("=", bean.getLabelName());
				count++;
			}
			if(bean.getOrganizationId() != null) {
				dao.setConditionOrganizationId("=", bean.getOrganizationId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCnLabel bean, CnLabel dao){
		int count = 0;
		if(bean.getLabelId() != null) {
			dao.setConditionLabelId("=", bean.getLabelId());
			count++;
		}
		if(bean.getLabelName() != null) {
			if(bean.getLabelName().indexOf("%") >= 0)
				dao.setConditionLabelName("like", bean.getLabelName());
			else
				dao.setConditionLabelName("=", bean.getLabelName());
			count++;
		}
		if(bean.getOrganizationId() != null) {
			dao.setConditionOrganizationId("=", bean.getOrganizationId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCnLabel bean = new BaseCnLabel();
		bean.setDataFromJSON(json);
		CnLabel dao = new CnLabel();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCnLabel> rlist = new BaseCollection<>();
		BaseCnLabel bean = new BaseCnLabel();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CnLabel dao = new CnLabel();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCnLabel> result = dao.conditionalLoad(addtion);
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
		BaseCnLabel bean = new BaseCnLabel();
		bean.setDataFromJSON(json);
		CnLabel dao = new CnLabel();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCnLabel bean = new BaseCnLabel();
		bean.setDataFromJSON(json);
		CnLabel dao = new CnLabel();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCnLabel bean = new BaseCnLabel();
		bean.setDataFromJSON(json);
		CnLabel dao = new CnLabel();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCnLabel bean = new BaseCnLabel();
		bean.setDataFromJSON(json);
		CnLabel dao = new CnLabel();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


