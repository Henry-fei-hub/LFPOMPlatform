package pomplatform.purchase.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.purchase.bean.BasePurchaseContractWithPp;
import pomplatform.purchase.dao.PurchaseContractWithPp;
import com.pomplatform.db.dao.PurchasePayment;
import com.pomplatform.db.dao.PurchaseProductDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class PurchaseContractWithPpHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(PurchaseContractWithPpHandler.class);

	public static BasePurchaseContractWithPp getPurchaseContractWithPpById( java.lang.Integer purchase_contract_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BasePurchaseContractWithPp result;
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			dao.setPurchaseContractId(purchase_contract_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get PurchaseContractWithPp By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isPurchaseContractWithPpExists( pomplatform.purchase.bean.BasePurchaseContractWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PurchaseContractWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countPurchaseContractWithPp( pomplatform.purchase.bean.BasePurchaseContractWithPp bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query PurchaseContractWithPp List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BasePurchaseContractWithPp> queryPurchaseContractWithPp( BasePurchaseContractWithPp bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BasePurchaseContractWithPp> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BasePurchaseContractWithPp> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query PurchaseContractWithPp List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePurchaseContractWithPp addToPurchaseContractWithPp ( BasePurchaseContractWithPp purchasecontractwithpp ) {
		return addToPurchaseContractWithPp ( purchasecontractwithpp , false);
	}

	public static BasePurchaseContractWithPp addToPurchaseContractWithPp ( BasePurchaseContractWithPp purchasecontractwithpp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			dao.setDataFromBase(purchasecontractwithpp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PurchaseContractWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePurchaseContractWithPp addUpdatePurchaseContractWithPp ( BasePurchaseContractWithPp purchasecontractwithpp ) {
		return addUpdatePurchaseContractWithPp ( purchasecontractwithpp , false);
	}

	public static BasePurchaseContractWithPp addUpdatePurchaseContractWithPp ( BasePurchaseContractWithPp purchasecontractwithpp, boolean singleTransaction  ) {
		if(purchasecontractwithpp.getPurchaseContractId() == null) return addToPurchaseContractWithPp(purchasecontractwithpp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			dao.setDataFromBase(purchasecontractwithpp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(purchasecontractwithpp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to PurchaseContractWithPp time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePurchaseContractWithPp deletePurchaseContractWithPp ( BasePurchaseContractWithPp bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete PurchaseContractWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePurchaseContractWithPp updatePurchaseContractWithPp ( BasePurchaseContractWithPp purchasecontractwithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			dao.setPurchaseContractId( purchasecontractwithpp.getPurchaseContractId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(purchasecontractwithpp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update PurchaseContractWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? purchasecontractwithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BasePurchaseContractWithPp updatePurchaseContractWithPpDirect( BasePurchaseContractWithPp purchasecontractwithpp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			PurchaseContractWithPp dao = new PurchaseContractWithPp();
			int result = 0;
			dao.setDataFromBase(purchasecontractwithpp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update PurchaseContractWithPp time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? purchasecontractwithpp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BasePurchaseContractWithPp bean, PurchaseContractWithPp dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getPurchaseContractId() != null) {
			dao.setPurchaseContractId(bean.getPurchaseContractId());
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getContractName() != null) {
				dao.setConditionContractName("=", bean.getContractName());
				count++;
			}
			if(bean.getContractCode() != null) {
				dao.setConditionContractCode("=", bean.getContractCode());
				count++;
			}
			if(bean.getSupplierId() != null) {
				dao.setConditionSupplierId("=", bean.getSupplierId());
				count++;
			}
			if(bean.getPurchasePerson() != null) {
				dao.setConditionPurchasePerson("=", bean.getPurchasePerson());
				count++;
			}
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getProjectName() != null) {
				dao.setConditionProjectName("=", bean.getProjectName());
				count++;
			}
			if(bean.getQualityAssurance() != null) {
				dao.setConditionQualityAssurance("=", bean.getQualityAssurance());
				count++;
			}
			if(bean.getTermOfPayment() != null) {
				dao.setConditionTermOfPayment("=", bean.getTermOfPayment());
				count++;
			}
			if(bean.getAfterSaleRequirements() != null) {
				dao.setConditionAfterSaleRequirements("=", bean.getAfterSaleRequirements());
				count++;
			}
			if(bean.getContractAttachment() != null) {
				dao.setConditionContractAttachment("=", bean.getContractAttachment());
				count++;
			}
			if(bean.getPersonnelBusinessId() != null) {
				dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BasePurchaseContractWithPp bean, PurchaseContractWithPp dao){
		int count = 0;
		if(bean.getPurchaseContractId() != null) {
			dao.setConditionPurchaseContractId("=", bean.getPurchaseContractId());
			count++;
		}
		if(bean.getContractName() != null) {
			if(bean.getContractName().indexOf("%") >= 0)
				dao.setConditionContractName("like", bean.getContractName());
			else
				dao.setConditionContractName("=", bean.getContractName());
			count++;
		}
		if(bean.getContractCode() != null) {
			if(bean.getContractCode().indexOf("%") >= 0)
				dao.setConditionContractCode("like", bean.getContractCode());
			else
				dao.setConditionContractCode("=", bean.getContractCode());
			count++;
		}
		if(bean.getSupplierId() != null) {
			dao.setConditionSupplierId("=", bean.getSupplierId());
			count++;
		}
		if(bean.getPurchasePerson() != null) {
			dao.setConditionPurchasePerson("=", bean.getPurchasePerson());
			count++;
		}
		if(bean.getContractAmount() != null) {
			dao.setConditionContractAmount("=", bean.getContractAmount());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getProjectName() != null) {
			if(bean.getProjectName().indexOf("%") >= 0)
				dao.setConditionProjectName("like", bean.getProjectName());
			else
				dao.setConditionProjectName("=", bean.getProjectName());
			count++;
		}
		if(bean.getQualityAssurance() != null) {
			if(bean.getQualityAssurance().indexOf("%") >= 0)
				dao.setConditionQualityAssurance("like", bean.getQualityAssurance());
			else
				dao.setConditionQualityAssurance("=", bean.getQualityAssurance());
			count++;
		}
		if(bean.getContractDate() != null) {
			dao.setConditionContractDate(">=", bean.getContractDate());
			count++;
		}
		if(bean.getTermOfPayment() != null) {
			if(bean.getTermOfPayment().indexOf("%") >= 0)
				dao.setConditionTermOfPayment("like", bean.getTermOfPayment());
			else
				dao.setConditionTermOfPayment("=", bean.getTermOfPayment());
			count++;
		}
		if(bean.getAfterSaleRequirements() != null) {
			if(bean.getAfterSaleRequirements().indexOf("%") >= 0)
				dao.setConditionAfterSaleRequirements("like", bean.getAfterSaleRequirements());
			else
				dao.setConditionAfterSaleRequirements("=", bean.getAfterSaleRequirements());
			count++;
		}
		if(bean.getAmountPaid() != null) {
			dao.setConditionAmountPaid("=", bean.getAmountPaid());
			count++;
		}
		if(bean.getAmountUnpaid() != null) {
			dao.setConditionAmountUnpaid("=", bean.getAmountUnpaid());
			count++;
		}
		if(bean.getHaveInvoiceAmount() != null) {
			dao.setConditionHaveInvoiceAmount("=", bean.getHaveInvoiceAmount());
			count++;
		}
		if(bean.getLackInvoiceAmount() != null) {
			dao.setConditionLackInvoiceAmount("=", bean.getLackInvoiceAmount());
			count++;
		}
		if(bean.getContractAttachment() != null) {
			dao.setConditionContractAttachment("=", bean.getContractAttachment());
			count++;
		}
		if(bean.getPersonnelBusinessId() != null) {
			dao.setConditionPersonnelBusinessId("=", bean.getPersonnelBusinessId());
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
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		bean.setDataFromJSON(json);
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BasePurchaseContractWithPp> rlist = new BaseCollection<>();
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BasePurchaseContractWithPp> result = dao.conditionalLoadExt(addtion);
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
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		bean.setDataFromJSON(json);
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		bean.setDataFromJSON(json);
		int num = 0;
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		bean.setDataFromJSON(json);
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BasePurchaseContractWithPp bean = new BasePurchaseContractWithPp();
		bean.setDataFromJSON(json);
		PurchaseContractWithPp dao = new PurchaseContractWithPp();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


