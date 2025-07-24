package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseSpecialDeductionDetail;
import com.pomplatform.db.dao.SpecialDeductionDetail;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class SpecialDeductionDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(SpecialDeductionDetailHandler.class);

	public static BaseSpecialDeductionDetail getSpecialDeductionDetailById( 
		java.lang.Integer special_deduction_detail_id
	) throws Exception
	{
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setSpecialDeductionDetailId(special_deduction_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isSpecialDeductionDetailExists( com.pomplatform.db.bean.BaseSpecialDeductionDetail bean, String additional ) throws Exception {

		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countSpecialDeductionDetail( com.pomplatform.db.bean.BaseSpecialDeductionDetail bean, String additional ) throws Exception {

		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseSpecialDeductionDetail> querySpecialDeductionDetail( com.pomplatform.db.bean.BaseSpecialDeductionDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseSpecialDeductionDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseSpecialDeductionDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseSpecialDeductionDetail addToSpecialDeductionDetail ( BaseSpecialDeductionDetail specialdeductiondetail )  throws Exception {
		return addToSpecialDeductionDetail ( specialdeductiondetail , false);
	}

	public static BaseSpecialDeductionDetail addToSpecialDeductionDetail ( BaseSpecialDeductionDetail specialdeductiondetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setDataFromBase(specialdeductiondetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseSpecialDeductionDetail addUpdateSpecialDeductionDetail ( BaseSpecialDeductionDetail specialdeductiondetail ) throws Exception {
		return addUpdateSpecialDeductionDetail ( specialdeductiondetail , false);
	}

	public static BaseSpecialDeductionDetail addUpdateSpecialDeductionDetail ( BaseSpecialDeductionDetail specialdeductiondetail, boolean singleTransaction  ) throws Exception {
		if(specialdeductiondetail.getSpecialDeductionDetailId() == null) return addToSpecialDeductionDetail(specialdeductiondetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setDataFromBase(specialdeductiondetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(specialdeductiondetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteSpecialDeductionDetail ( BaseSpecialDeductionDetail bean ) throws Exception {
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseSpecialDeductionDetail updateSpecialDeductionDetail ( BaseSpecialDeductionDetail specialdeductiondetail ) throws Exception {
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setSpecialDeductionDetailId( specialdeductiondetail.getSpecialDeductionDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(specialdeductiondetail);
			result = dao.update();
		}
		return result == 1 ? specialdeductiondetail : null ;
	}

	public static BaseSpecialDeductionDetail updateSpecialDeductionDetailDirect( BaseSpecialDeductionDetail specialdeductiondetail ) throws Exception {
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		int result = 0;
		dao.setDataFromBase(specialdeductiondetail);
		result = dao.update();
		return result == 1 ? specialdeductiondetail : null ;
	}

	public static int setDeleteConditions(BaseSpecialDeductionDetail bean, SpecialDeductionDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSpecialDeductionDetailId() != null) {
			dao.setConditionSpecialDeductionDetailId("=", bean.getSpecialDeductionDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSchooling() != null) {
				dao.setConditionSchooling("=", bean.getSchooling());
				count++;
			}
			if(bean.getNum() != null) {
				dao.setConditionNum("=", bean.getNum());
				count++;
			}
			if(bean.getEducationType() != null) {
				dao.setConditionEducationType("=", bean.getEducationType());
				count++;
			}
			if(bean.getEducationStage() != null) {
				dao.setConditionEducationStage("=", bean.getEducationStage());
				count++;
			}
			if(bean.getHouseFirst() != null) {
				dao.setConditionHouseFirst("=", bean.getHouseFirst());
				count++;
			}
			if(bean.getSingleChild() != null) {
				dao.setConditionSingleChild("=", bean.getSingleChild());
				count++;
			}
			if(bean.getYear() != null) {
				dao.setConditionYear("=", bean.getYear());
				count++;
			}
			if(bean.getSpecialDeductionTypeId() != null) {
				dao.setConditionSpecialDeductionTypeId("=", bean.getSpecialDeductionTypeId());
				count++;
			}
			if(bean.getCity() != null) {
				dao.setConditionCity("=", bean.getCity());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSpecialDeductionDetail bean, SpecialDeductionDetail dao){
		int count = 0;
		if(bean.getSpecialDeductionDetailId() != null) {
			dao.setConditionSpecialDeductionDetailId("=", bean.getSpecialDeductionDetailId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSchooling() != null) {
			dao.setConditionSchooling("=", bean.getSchooling());
			count++;
		}
		if(bean.getStartDate() != null) {
			dao.setConditionStartDate(">=", bean.getStartDate());
			count++;
		}
		if(bean.getEndDate() != null) {
			dao.setConditionEndDate(">=", bean.getEndDate());
			count++;
		}
		if(bean.getDeductionPercentage() != null) {
			dao.setConditionDeductionPercentage("=", bean.getDeductionPercentage());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getNum() != null) {
			dao.setConditionNum("=", bean.getNum());
			count++;
		}
		if(bean.getEducationType() != null) {
			dao.setConditionEducationType("=", bean.getEducationType());
			count++;
		}
		if(bean.getEducationStage() != null) {
			dao.setConditionEducationStage("=", bean.getEducationStage());
			count++;
		}
		if(bean.getHouseFirst() != null) {
			dao.setConditionHouseFirst("=", bean.getHouseFirst());
			count++;
		}
		if(bean.getSingleChild() != null) {
			dao.setConditionSingleChild("=", bean.getSingleChild());
			count++;
		}
		if(bean.getYear() != null) {
			if(bean.getYear().indexOf("%") >= 0)
				dao.setConditionYear("like", bean.getYear());
			else
				dao.setConditionYear("=", bean.getYear());
			count++;
		}
		if(bean.getSpecialDeductionTypeId() != null) {
			dao.setConditionSpecialDeductionTypeId("=", bean.getSpecialDeductionTypeId());
			count++;
		}
		if(bean.getCreateDate() != null) {
			dao.setConditionCreateDate(">=", bean.getCreateDate());
			count++;
		}
		if(bean.getCity() != null) {
			if(bean.getCity().indexOf("%") >= 0)
				dao.setConditionCity("like", bean.getCity());
			else
				dao.setConditionCity("=", bean.getCity());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSpecialDeductionDetail> rlist = new BaseCollection<>();
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSpecialDeductionDetail> result = dao.conditionalLoad(addtion);
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
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSpecialDeductionDetail bean = new BaseSpecialDeductionDetail();
		bean.setDataFromJSON(json);
		SpecialDeductionDetail dao = new SpecialDeductionDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


