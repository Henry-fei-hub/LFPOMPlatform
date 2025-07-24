package pomplatform.purchase.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.purchase.bean.BaseProductWithP;
import pomplatform.purchase.dao.ProductWithP;
import com.pomplatform.db.dao.ProductAttribute;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class ProductWithPHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(ProductWithPHandler.class);

	public static BaseProductWithP getProductWithPById( java.lang.Integer product_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseProductWithP result;
			ProductWithP dao = new ProductWithP();
			dao.setProductId(product_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get ProductWithP By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isProductWithPExists( pomplatform.purchase.bean.BaseProductWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProductWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countProductWithP( pomplatform.purchase.bean.BaseProductWithP bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query ProductWithP List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseProductWithP> queryProductWithP( BaseProductWithP bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseProductWithP> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseProductWithP> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query ProductWithP List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductWithP addToProductWithP ( BaseProductWithP productwithp ) {
		return addToProductWithP ( productwithp , false);
	}

	public static BaseProductWithP addToProductWithP ( BaseProductWithP productwithp, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProductWithP dao = new ProductWithP();
			dao.setDataFromBase(productwithp);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProductWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductWithP addUpdateProductWithP ( BaseProductWithP productwithp ) {
		return addUpdateProductWithP ( productwithp , false);
	}

	public static BaseProductWithP addUpdateProductWithP ( BaseProductWithP productwithp, boolean singleTransaction  ) {
		if(productwithp.getProductId() == null) return addToProductWithP(productwithp);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			ProductWithP dao = new ProductWithP();
			dao.setDataFromBase(productwithp);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(productwithp); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to ProductWithP time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductWithP deleteProductWithP ( BaseProductWithP bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete ProductWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductWithP updateProductWithP ( BaseProductWithP productwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			dao.setProductId( productwithp.getProductId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(productwithp);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update ProductWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? productwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseProductWithP updateProductWithPDirect( BaseProductWithP productwithp ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			ProductWithP dao = new ProductWithP();
			int result = 0;
			dao.setDataFromBase(productwithp);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update ProductWithP time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? productwithp : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseProductWithP bean, ProductWithP dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getProductId() != null) {
			dao.setProductId(bean.getProductId());
			dao.setConditionProductId("=", bean.getProductId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCategoryId() != null) {
				dao.setConditionCategoryId("=", bean.getCategoryId());
				count++;
			}
			if(bean.getProductName() != null) {
				dao.setConditionProductName("=", bean.getProductName());
				count++;
			}
			if(bean.getProductType() != null) {
				dao.setConditionProductType("=", bean.getProductType());
				count++;
			}
			if(bean.getProductModel() != null) {
				dao.setConditionProductModel("=", bean.getProductModel());
				count++;
			}
			if(bean.getProductUnit() != null) {
				dao.setConditionProductUnit("=", bean.getProductUnit());
				count++;
			}
			if(bean.getProductSpecification() != null) {
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
				count++;
			}
			if(bean.getProductSkinsSize() != null) {
				dao.setConditionProductSkinsSize("=", bean.getProductSkinsSize());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
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

	public static int setConditions(BaseProductWithP bean, ProductWithP dao){
		int count = 0;
		if(bean.getProductId() != null) {
			dao.setConditionProductId("=", bean.getProductId());
			count++;
		}
		if(bean.getCategoryId() != null) {
			dao.setConditionCategoryId("=", bean.getCategoryId());
			count++;
		}
		if(bean.getProductName() != null) {
			if(bean.getProductName().indexOf("%") >= 0)
				dao.setConditionProductName("like", bean.getProductName());
			else
				dao.setConditionProductName("=", bean.getProductName());
			count++;
		}
		if(bean.getProductType() != null) {
			dao.setConditionProductType("=", bean.getProductType());
			count++;
		}
		if(bean.getProductModel() != null) {
			if(bean.getProductModel().indexOf("%") >= 0)
				dao.setConditionProductModel("like", bean.getProductModel());
			else
				dao.setConditionProductModel("=", bean.getProductModel());
			count++;
		}
		if(bean.getProductUnit() != null) {
			if(bean.getProductUnit().indexOf("%") >= 0)
				dao.setConditionProductUnit("like", bean.getProductUnit());
			else
				dao.setConditionProductUnit("=", bean.getProductUnit());
			count++;
		}
		if(bean.getProductSpecification() != null) {
			if(bean.getProductSpecification().indexOf("%") >= 0)
				dao.setConditionProductSpecification("like", bean.getProductSpecification());
			else
				dao.setConditionProductSpecification("=", bean.getProductSpecification());
			count++;
		}
		if(bean.getProductSkinsSize() != null) {
			if(bean.getProductSkinsSize().indexOf("%") >= 0)
				dao.setConditionProductSkinsSize("like", bean.getProductSkinsSize());
			else
				dao.setConditionProductSkinsSize("=", bean.getProductSkinsSize());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
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
		BaseProductWithP bean = new BaseProductWithP();
		bean.setDataFromJSON(json);
		ProductWithP dao = new ProductWithP();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseProductWithP> rlist = new BaseCollection<>();
		BaseProductWithP bean = new BaseProductWithP();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		ProductWithP dao = new ProductWithP();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseProductWithP> result = dao.conditionalLoadExt(addtion);
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
		BaseProductWithP bean = new BaseProductWithP();
		bean.setDataFromJSON(json);
		ProductWithP dao = new ProductWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseProductWithP bean = new BaseProductWithP();
		bean.setDataFromJSON(json);
		int num = 0;
		ProductWithP dao = new ProductWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseProductWithP bean = new BaseProductWithP();
		bean.setDataFromJSON(json);
		ProductWithP dao = new ProductWithP();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseProductWithP bean = new BaseProductWithP();
		bean.setDataFromJSON(json);
		ProductWithP dao = new ProductWithP();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


