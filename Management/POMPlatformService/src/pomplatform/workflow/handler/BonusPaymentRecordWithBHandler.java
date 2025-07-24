package pomplatform.workflow.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.workflow.bean.BaseBonusPaymentRecordWithB;
import pomplatform.workflow.dao.BonusPaymentRecordWithB;
import com.pomplatform.db.dao.BonusPaymentDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class BonusPaymentRecordWithBHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(BonusPaymentRecordWithBHandler.class);

	public static BaseBonusPaymentRecordWithB getBonusPaymentRecordWithBById( java.lang.Integer bonus_payment_record_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseBonusPaymentRecordWithB result;
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			dao.setBonusPaymentRecordId(bonus_payment_record_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get BonusPaymentRecordWithB By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isBonusPaymentRecordWithBExists( pomplatform.workflow.bean.BaseBonusPaymentRecordWithB bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query BonusPaymentRecordWithB List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countBonusPaymentRecordWithB( pomplatform.workflow.bean.BaseBonusPaymentRecordWithB bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query BonusPaymentRecordWithB List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseBonusPaymentRecordWithB> queryBonusPaymentRecordWithB( BaseBonusPaymentRecordWithB bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseBonusPaymentRecordWithB> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseBonusPaymentRecordWithB> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query BonusPaymentRecordWithB List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBonusPaymentRecordWithB addToBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb ) {
		return addToBonusPaymentRecordWithB ( bonuspaymentrecordwithb , false);
	}

	public static BaseBonusPaymentRecordWithB addToBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			dao.setDataFromBase(bonuspaymentrecordwithb);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to BonusPaymentRecordWithB time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBonusPaymentRecordWithB addUpdateBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb ) {
		return addUpdateBonusPaymentRecordWithB ( bonuspaymentrecordwithb , false);
	}

	public static BaseBonusPaymentRecordWithB addUpdateBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb, boolean singleTransaction  ) {
		if(bonuspaymentrecordwithb.getBonusPaymentRecordId() == null) return addToBonusPaymentRecordWithB(bonuspaymentrecordwithb);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			dao.setDataFromBase(bonuspaymentrecordwithb);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(bonuspaymentrecordwithb); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to BonusPaymentRecordWithB time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBonusPaymentRecordWithB deleteBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete BonusPaymentRecordWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBonusPaymentRecordWithB updateBonusPaymentRecordWithB ( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			dao.setBonusPaymentRecordId( bonuspaymentrecordwithb.getBonusPaymentRecordId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(bonuspaymentrecordwithb);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update BonusPaymentRecordWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bonuspaymentrecordwithb : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseBonusPaymentRecordWithB updateBonusPaymentRecordWithBDirect( BaseBonusPaymentRecordWithB bonuspaymentrecordwithb ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
			int result = 0;
			dao.setDataFromBase(bonuspaymentrecordwithb);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update BonusPaymentRecordWithB time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bonuspaymentrecordwithb : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseBonusPaymentRecordWithB bean, BonusPaymentRecordWithB dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getBonusPaymentRecordId() != null) {
			dao.setBonusPaymentRecordId(bean.getBonusPaymentRecordId());
			dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getPlateId() != null) {
				dao.setConditionPlateId("=", bean.getPlateId());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getApplicant() != null) {
				dao.setConditionApplicant("=", bean.getApplicant());
				count++;
			}
			if(bean.getState() != null) {
				dao.setConditionState("=", bean.getState());
				count++;
			}
			if(bean.getAuditor() != null) {
				dao.setConditionAuditor("=", bean.getAuditor());
				count++;
			}
			if(bean.getOpinion() != null) {
				dao.setConditionOpinion("=", bean.getOpinion());
				count++;
			}
			if(bean.getIsLevelTwo() != null) {
				dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseBonusPaymentRecordWithB bean, BonusPaymentRecordWithB dao){
		int count = 0;
		if(bean.getBonusPaymentRecordId() != null) {
			dao.setConditionBonusPaymentRecordId("=", bean.getBonusPaymentRecordId());
			count++;
		}
		if(bean.getPlateId() != null) {
			dao.setConditionPlateId("=", bean.getPlateId());
			count++;
		}
		if(bean.getPayIntegral() != null) {
			dao.setConditionPayIntegral("=", bean.getPayIntegral());
			count++;
		}
		if(bean.getPayDate() != null) {
			dao.setConditionPayDate(">=", bean.getPayDate());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getApplicant() != null) {
			dao.setConditionApplicant("=", bean.getApplicant());
			count++;
		}
		if(bean.getApplyTime() != null) {
			dao.setConditionApplyTime(">=", bean.getApplyTime());
			count++;
		}
		if(bean.getState() != null) {
			dao.setConditionState("=", bean.getState());
			count++;
		}
		if(bean.getAuditor() != null) {
			dao.setConditionAuditor("=", bean.getAuditor());
			count++;
		}
		if(bean.getAuditingTime() != null) {
			dao.setConditionAuditingTime(">=", bean.getAuditingTime());
			count++;
		}
		if(bean.getOpinion() != null) {
			if(bean.getOpinion().indexOf("%") >= 0)
				dao.setConditionOpinion("like", bean.getOpinion());
			else
				dao.setConditionOpinion("=", bean.getOpinion());
			count++;
		}
		if(bean.getIsLevelTwo() != null) {
			dao.setConditionIsLevelTwo("=", bean.getIsLevelTwo());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		bean.setDataFromJSON(json);
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseBonusPaymentRecordWithB> rlist = new BaseCollection<>();
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseBonusPaymentRecordWithB> result = dao.conditionalLoadExt(addtion);
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
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		bean.setDataFromJSON(json);
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		bean.setDataFromJSON(json);
		int num = 0;
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		bean.setDataFromJSON(json);
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseBonusPaymentRecordWithB bean = new BaseBonusPaymentRecordWithB();
		bean.setDataFromJSON(json);
		BonusPaymentRecordWithB dao = new BonusPaymentRecordWithB();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


