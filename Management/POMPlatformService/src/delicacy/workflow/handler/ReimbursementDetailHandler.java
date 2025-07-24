package delicacy.workflow.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.workflow.bean.BaseReimbursementDetail;
import delicacy.workflow.dao.ReimbursementDetail;

public class ReimbursementDetailHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementDetailHandler.class);

	public static BaseReimbursementDetail getReimbursementDetailById( 
		java.lang.Integer reimbursement_detail_id
	) throws Exception
	{
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setReimbursementDetailId(reimbursement_detail_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementDetailExists( delicacy.workflow.bean.BaseReimbursementDetail bean, String additional ) throws Exception {

		ReimbursementDetail dao = new ReimbursementDetail();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursementDetail( delicacy.workflow.bean.BaseReimbursementDetail bean, String additional ) throws Exception {

		ReimbursementDetail dao = new ReimbursementDetail();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursementDetail> queryReimbursementDetail( delicacy.workflow.bean.BaseReimbursementDetail bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		ReimbursementDetail dao = new ReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursementDetail> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursementDetail> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursementDetail addToReimbursementDetail ( BaseReimbursementDetail reimbursementdetail )  throws Exception {
		return addToReimbursementDetail ( reimbursementdetail , false);
	}

	public static BaseReimbursementDetail addToReimbursementDetail ( BaseReimbursementDetail reimbursementdetail, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setDataFromBase(reimbursementdetail);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursementDetail addUpdateReimbursementDetail ( BaseReimbursementDetail reimbursementdetail ) throws Exception {
		return addUpdateReimbursementDetail ( reimbursementdetail , false);
	}

	public static BaseReimbursementDetail addUpdateReimbursementDetail ( BaseReimbursementDetail reimbursementdetail, boolean singleTransaction  ) throws Exception {
		if(reimbursementdetail.getReimbursementDetailId() == null) return addToReimbursementDetail(reimbursementdetail);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setDataFromBase(reimbursementdetail);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursementdetail); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursementDetail ( BaseReimbursementDetail bean ) throws Exception {
		ReimbursementDetail dao = new ReimbursementDetail();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursementDetail updateReimbursementDetail ( BaseReimbursementDetail reimbursementdetail ) throws Exception {
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setReimbursementDetailId( reimbursementdetail.getReimbursementDetailId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursementdetail);
			result = dao.update();
		}
		return result == 1 ? reimbursementdetail : null ;
	}

	public static BaseReimbursementDetail updateReimbursementDetailDirect( BaseReimbursementDetail reimbursementdetail ) throws Exception {
		ReimbursementDetail dao = new ReimbursementDetail();
		int result = 0;
		dao.setDataFromBase(reimbursementdetail);
		result = dao.update();
		return result == 1 ? reimbursementdetail : null ;
	}

	public static int setDeleteConditions(BaseReimbursementDetail bean, ReimbursementDetail dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementDetailId() != null) {
			dao.setConditionReimbursementDetailId("=", bean.getReimbursementDetailId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getReimbursementId() != null) {
				dao.setConditionReimbursementId("=", bean.getReimbursementId());
				count++;
			}
			if(bean.getItemId() != null) {
				dao.setConditionItemId("=", bean.getItemId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursementDetail bean, ReimbursementDetail dao){
		int count = 0;
		if(bean.getReimbursementDetailId() != null) {
			dao.setConditionReimbursementDetailId("=", bean.getReimbursementDetailId());
			count++;
		}
		if(bean.getReimbursementId() != null) {
			dao.setConditionReimbursementId("=", bean.getReimbursementId());
			count++;
		}
		if(bean.getItemId() != null) {
			dao.setConditionItemId("=", bean.getItemId());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getHappenDate() != null) {
			dao.setConditionHappenDate(">=", bean.getHappenDate());
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
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		bean.setDataFromJSON(json);
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursementDetail> rlist = new BaseCollection<>();
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ReimbursementDetail dao = new ReimbursementDetail();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursementDetail> result = dao.conditionalLoad(addtion);
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
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		bean.setDataFromJSON(json);
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		bean.setDataFromJSON(json);
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		bean.setDataFromJSON(json);
		ReimbursementDetail dao = new ReimbursementDetail();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursementDetail bean = new BaseReimbursementDetail();
		bean.setDataFromJSON(json);
		ReimbursementDetail dao = new ReimbursementDetail();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


