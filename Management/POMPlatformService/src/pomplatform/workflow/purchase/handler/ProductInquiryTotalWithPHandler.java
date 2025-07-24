package pomplatform.workflow.purchase.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.workflow.purchase.bean.BaseProductInquiryTotalWithP;
import pomplatform.workflow.purchase.dao.ProductInquiryTotalWithP;
import com.pomplatform.db.dao.ProductInquiryDetail;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProductInquiryTotalWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProductInquiryTotalWithPHandler.class);

	public static BaseProductInquiryTotalWithP getProductInquiryTotalWithPById( java.lang.Integer product_inquiry_total_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProductInquiryTotalWithP result;
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			dao.setProductInquiryTotalId(product_inquiry_total_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProductInquiryTotalWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProductInquiryTotalWithPExists( pomplatform.workflow.purchase.bean.BaseProductInquiryTotalWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProductInquiryTotalWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProductInquiryTotalWithP( pomplatform.workflow.purchase.bean.BaseProductInquiryTotalWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProductInquiryTotalWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProductInquiryTotalWithP> queryProductInquiryTotalWithP( BaseProductInquiryTotalWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProductInquiryTotalWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProductInquiryTotalWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProductInquiryTotalWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductInquiryTotalWithP addToProductInquiryTotalWithP ( BaseProductInquiryTotalWithP productinquirytotalwithp ) {
		return addToProductInquiryTotalWithP ( productinquirytotalwithp , false);
	}

	public static BaseProductInquiryTotalWithP addToProductInquiryTotalWithP ( BaseProductInquiryTotalWithP productinquirytotalwithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			dao.setDataFromBase(productinquirytotalwithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProductInquiryTotalWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductInquiryTotalWithP addUpdateProductInquiryTotalWithP ( BaseProductInquiryTotalWithP productinquirytotalwithp ) {
		return addUpdateProductInquiryTotalWithP ( productinquirytotalwithp , false);
	}

	public static BaseProductInquiryTotalWithP addUpdateProductInquiryTotalWithP ( BaseProductInquiryTotalWithP productinquirytotalwithp, boolean singleTransaction  ) {
		if(productinquirytotalwithp.getProductInquiryTotalId() == null) return addToProductInquiryTotalWithP(productinquirytotalwithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			dao.setDataFromBase(productinquirytotalwithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(productinquirytotalwithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProductInquiryTotalWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductInquiryTotalWithP deleteProductInquiryTotalWithP ( BaseProductInquiryTotalWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProductInquiryTotalWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductInquiryTotalWithP updateProductInquiryTotalWithP ( BaseProductInquiryTotalWithP productinquirytotalwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			dao.setProductInquiryTotalId( productinquirytotalwithp.getProductInquiryTotalId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(productinquirytotalwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProductInquiryTotalWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? productinquirytotalwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductInquiryTotalWithP updateProductInquiryTotalWithPDirect( BaseProductInquiryTotalWithP productinquirytotalwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
			int result = 0;
			dao.setDataFromBase(productinquirytotalwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProductInquiryTotalWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? productinquirytotalwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProductInquiryTotalWithP bean, ProductInquiryTotalWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductInquiryTotalId() != null) {
			dao.setProductInquiryTotalId(bean.getProductInquiryTotalId());
			dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMajorTitle() != null) {
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
				count++;
			}
			if(bean.getProcessType() != null) {
				dao.setConditionProcessType("=", bean.getProcessType());
				count++;
			}
			if(bean.getReason() != null) {
				dao.setConditionReason("=", bean.getReason());
				count++;
			}
			if(bean.getEmployeeNo() != null) {
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
				count++;
			}
			if(bean.getDepartmentId() != null) {
				dao.setConditionDepartmentId("=", bean.getDepartmentId());
				count++;
			}
			if(bean.getCreateEmployeeId() != null) {
				dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
				count++;
			}
			if(bean.getDeleteFlag() != null) {
				dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
				count++;
			}
			if(bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseProductInquiryTotalWithP bean, ProductInquiryTotalWithP dao){
		int count = 0;
		if(bean.getProductInquiryTotalId() != null) {
			dao.setConditionProductInquiryTotalId("=", bean.getProductInquiryTotalId());
			count++;
		}
		if(bean.getMajorTitle() != null) {
			if(bean.getMajorTitle().indexOf("%") >= 0)
				dao.setConditionMajorTitle("like", bean.getMajorTitle());
			else
				dao.setConditionMajorTitle("=", bean.getMajorTitle());
			count++;
		}
		if(bean.getProcessType() != null) {
			dao.setConditionProcessType("=", bean.getProcessType());
			count++;
		}
		if(bean.getReason() != null) {
			if(bean.getReason().indexOf("%") >= 0)
				dao.setConditionReason("like", bean.getReason());
			else
				dao.setConditionReason("=", bean.getReason());
			count++;
		}
		if(bean.getEmployeeNo() != null) {
			if(bean.getEmployeeNo().indexOf("%") >= 0)
				dao.setConditionEmployeeNo("like", bean.getEmployeeNo());
			else
				dao.setConditionEmployeeNo("=", bean.getEmployeeNo());
			count++;
		}
		if(bean.getDepartmentId() != null) {
			dao.setConditionDepartmentId("=", bean.getDepartmentId());
			count++;
		}
		if(bean.getCreateEmployeeId() != null) {
			dao.setConditionCreateEmployeeId("=", bean.getCreateEmployeeId());
			count++;
		}
		if(bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if(bean.getDeleteFlag() != null) {
			dao.setConditionDeleteFlag("=", bean.getDeleteFlag());
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
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		bean.setDataFromJSON(json);
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductInquiryTotalWithP> rlist = new BaseCollection<>();
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductInquiryTotalWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		bean.setDataFromJSON(json);
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		bean.setDataFromJSON(json);
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductInquiryTotalWithP bean = new BaseProductInquiryTotalWithP();
		bean.setDataFromJSON(json);
		ProductInquiryTotalWithP dao = new ProductInquiryTotalWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


