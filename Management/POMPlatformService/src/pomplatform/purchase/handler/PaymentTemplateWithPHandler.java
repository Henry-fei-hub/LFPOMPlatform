package pomplatform.purchase.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.purchase.bean.BasePaymentTemplateWithP;
import pomplatform.purchase.dao.PaymentTemplateWithP;
import com.pomplatform.db.dao.PaymentTemplateDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class PaymentTemplateWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(PaymentTemplateWithPHandler.class);

	public static BasePaymentTemplateWithP getPaymentTemplateWithPById( java.lang.Integer payment_template_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BasePaymentTemplateWithP result;
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			dao.setPaymentTemplateId(payment_template_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get PaymentTemplateWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isPaymentTemplateWithPExists( pomplatform.purchase.bean.BasePaymentTemplateWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PaymentTemplateWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countPaymentTemplateWithP( pomplatform.purchase.bean.BasePaymentTemplateWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PaymentTemplateWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BasePaymentTemplateWithP> queryPaymentTemplateWithP( BasePaymentTemplateWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BasePaymentTemplateWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BasePaymentTemplateWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query PaymentTemplateWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePaymentTemplateWithP addToPaymentTemplateWithP ( BasePaymentTemplateWithP paymenttemplatewithp ) {
		return addToPaymentTemplateWithP ( paymenttemplatewithp , false);
	}

	public static BasePaymentTemplateWithP addToPaymentTemplateWithP ( BasePaymentTemplateWithP paymenttemplatewithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			dao.setDataFromBase(paymenttemplatewithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PaymentTemplateWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePaymentTemplateWithP addUpdatePaymentTemplateWithP ( BasePaymentTemplateWithP paymenttemplatewithp ) {
		return addUpdatePaymentTemplateWithP ( paymenttemplatewithp , false);
	}

	public static BasePaymentTemplateWithP addUpdatePaymentTemplateWithP ( BasePaymentTemplateWithP paymenttemplatewithp, boolean singleTransaction  ) {
		if(paymenttemplatewithp.getPaymentTemplateId() == null) return addToPaymentTemplateWithP(paymenttemplatewithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			dao.setDataFromBase(paymenttemplatewithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(paymenttemplatewithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PaymentTemplateWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePaymentTemplateWithP deletePaymentTemplateWithP ( BasePaymentTemplateWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete PaymentTemplateWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePaymentTemplateWithP updatePaymentTemplateWithP ( BasePaymentTemplateWithP paymenttemplatewithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			dao.setPaymentTemplateId( paymenttemplatewithp.getPaymentTemplateId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(paymenttemplatewithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update PaymentTemplateWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? paymenttemplatewithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePaymentTemplateWithP updatePaymentTemplateWithPDirect( BasePaymentTemplateWithP paymenttemplatewithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PaymentTemplateWithP dao = new PaymentTemplateWithP();
			int result = 0;
			dao.setDataFromBase(paymenttemplatewithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update PaymentTemplateWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? paymenttemplatewithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BasePaymentTemplateWithP bean, PaymentTemplateWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPaymentTemplateId() != null) {
			dao.setPaymentTemplateId(bean.getPaymentTemplateId());
			dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getTemplateName() != null) {
				dao.setConditionTemplateName("=", bean.getTemplateName());
				count++;
			}
			if(bean.getPaymentCycle() != null) {
				dao.setConditionPaymentCycle("=", bean.getPaymentCycle());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePaymentTemplateWithP bean, PaymentTemplateWithP dao){
		int count = 0;
		if(bean.getPaymentTemplateId() != null) {
			dao.setConditionPaymentTemplateId("=", bean.getPaymentTemplateId());
			count++;
		}
		if(bean.getTemplateName() != null) {
			if(bean.getTemplateName().indexOf("%") >= 0)
				dao.setConditionTemplateName("like", bean.getTemplateName());
			else
				dao.setConditionTemplateName("=", bean.getTemplateName());
			count++;
		}
		if(bean.getPaymentCycle() != null) {
			dao.setConditionPaymentCycle("=", bean.getPaymentCycle());
			count++;
		}
		if(bean.getRemark() != null) {
			if(bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if(bean.getOperatorId() != null) {
			dao.setConditionOperatorId("=", bean.getOperatorId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		bean.setDataFromJSON(json);
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePaymentTemplateWithP> rlist = new BaseCollection<>();
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePaymentTemplateWithP> result = dao.conditionalLoadExt(addtion);
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
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		bean.setDataFromJSON(json);
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		bean.setDataFromJSON(json);
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePaymentTemplateWithP bean = new BasePaymentTemplateWithP();
		bean.setDataFromJSON(json);
		PaymentTemplateWithP dao = new PaymentTemplateWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


