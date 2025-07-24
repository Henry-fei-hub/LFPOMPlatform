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
import delicacy.workflow.bean.BaseReimbursement;
import delicacy.workflow.dao.Reimbursement;

public class ReimbursementHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(ReimbursementHandler.class);

	public static BaseReimbursement getReimbursementById( 
		java.lang.Integer reimbursement_id
	) throws Exception
	{
		Reimbursement dao = new Reimbursement();
		dao.setReimbursementId(reimbursement_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isReimbursementExists( delicacy.workflow.bean.BaseReimbursement bean, String additional ) throws Exception {

		Reimbursement dao = new Reimbursement();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countReimbursement( delicacy.workflow.bean.BaseReimbursement bean, String additional ) throws Exception {

		Reimbursement dao = new Reimbursement();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseReimbursement> queryReimbursement( delicacy.workflow.bean.BaseReimbursement bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		Reimbursement dao = new Reimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseReimbursement> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseReimbursement> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseReimbursement addToReimbursement ( BaseReimbursement reimbursement )  throws Exception {
		return addToReimbursement ( reimbursement , false);
	}

	public static BaseReimbursement addToReimbursement ( BaseReimbursement reimbursement, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		Reimbursement dao = new Reimbursement();
		dao.setDataFromBase(reimbursement);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseReimbursement addUpdateReimbursement ( BaseReimbursement reimbursement ) throws Exception {
		return addUpdateReimbursement ( reimbursement , false);
	}

	public static BaseReimbursement addUpdateReimbursement ( BaseReimbursement reimbursement, boolean singleTransaction  ) throws Exception {
		if(reimbursement.getReimbursementId() == null) return addToReimbursement(reimbursement);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		Reimbursement dao = new Reimbursement();
		dao.setDataFromBase(reimbursement);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(reimbursement); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteReimbursement ( BaseReimbursement bean ) throws Exception {
		Reimbursement dao = new Reimbursement();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseReimbursement updateReimbursement ( BaseReimbursement reimbursement ) throws Exception {
		Reimbursement dao = new Reimbursement();
		dao.setReimbursementId( reimbursement.getReimbursementId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(reimbursement);
			result = dao.update();
		}
		return result == 1 ? reimbursement : null ;
	}

	public static BaseReimbursement updateReimbursementDirect( BaseReimbursement reimbursement ) throws Exception {
		Reimbursement dao = new Reimbursement();
		int result = 0;
		dao.setDataFromBase(reimbursement);
		result = dao.update();
		return result == 1 ? reimbursement : null ;
	}

	public static int setDeleteConditions(BaseReimbursement bean, Reimbursement dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getReimbursementId() != null) {
			dao.setConditionReimbursementId("=", bean.getReimbursementId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if(bean.getReimbursementType() != null) {
				dao.setConditionReimbursementType("=", bean.getReimbursementType());
				count++;
			}
			if(bean.getStatus() != null) {
				dao.setConditionStatus("=", bean.getStatus());
				count++;
			}
			if(bean.getProcessInstanceId() != null) {
				dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
				count++;
			}
			if(bean.getSubject() != null) {
				dao.setConditionSubject("=", bean.getSubject());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseReimbursement bean, Reimbursement dao){
		int count = 0;
		if(bean.getReimbursementId() != null) {
			dao.setConditionReimbursementId("=", bean.getReimbursementId());
			count++;
		}
		if(bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if(bean.getApplicationDate() != null) {
			dao.setConditionApplicationDate(">=", bean.getApplicationDate());
			count++;
		}
		if(bean.getReimbursementType() != null) {
			dao.setConditionReimbursementType("=", bean.getReimbursementType());
			count++;
		}
		if(bean.getStatus() != null) {
			dao.setConditionStatus("=", bean.getStatus());
			count++;
		}
		if(bean.getAmount() != null) {
			dao.setConditionAmount("=", bean.getAmount());
			count++;
		}
		if(bean.getCompleteDate() != null) {
			dao.setConditionCompleteDate(">=", bean.getCompleteDate());
			count++;
		}
		if(bean.getProcessInstanceId() != null) {
			dao.setConditionProcessInstanceId("=", bean.getProcessInstanceId());
			count++;
		}
		if(bean.getSubject() != null) {
			if(bean.getSubject().indexOf("%") >= 0)
				dao.setConditionSubject("like", bean.getSubject());
			else
				dao.setConditionSubject("=", bean.getSubject());
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
		BaseReimbursement bean = new BaseReimbursement();
		bean.setDataFromJSON(json);
		Reimbursement dao = new Reimbursement();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseReimbursement> rlist = new BaseCollection<>();
		BaseReimbursement bean = new BaseReimbursement();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		Reimbursement dao = new Reimbursement();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseReimbursement> result = dao.conditionalLoad(addtion);
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
		BaseReimbursement bean = new BaseReimbursement();
		bean.setDataFromJSON(json);
		Reimbursement dao = new Reimbursement();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseReimbursement bean = new BaseReimbursement();
		bean.setDataFromJSON(json);
		Reimbursement dao = new Reimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseReimbursement bean = new BaseReimbursement();
		bean.setDataFromJSON(json);
		Reimbursement dao = new Reimbursement();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseReimbursement bean = new BaseReimbursement();
		bean.setDataFromJSON(json);
		Reimbursement dao = new Reimbursement();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


