package pomplatform.companyarea.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.companyarea.bean.BaseCompanyAreaWithCa;
import pomplatform.companyarea.dao.CompanyAreaWithCa;
import com.pomplatform.db.dao.CompanyRecord;
import com.pomplatform.db.dao.Area;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class CompanyAreaWithCaHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(CompanyAreaWithCaHandler.class);

	public static BaseCompanyAreaWithCa getCompanyAreaWithCaById( java.lang.Integer company_area_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseCompanyAreaWithCa result;
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			dao.setCompanyAreaId(company_area_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get CompanyAreaWithCa By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isCompanyAreaWithCaExists( pomplatform.companyarea.bean.BaseCompanyAreaWithCa bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CompanyAreaWithCa List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countCompanyAreaWithCa( pomplatform.companyarea.bean.BaseCompanyAreaWithCa bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CompanyAreaWithCa List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseCompanyAreaWithCa> queryCompanyAreaWithCa( BaseCompanyAreaWithCa bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseCompanyAreaWithCa> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseCompanyAreaWithCa> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query CompanyAreaWithCa List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyAreaWithCa addToCompanyAreaWithCa ( BaseCompanyAreaWithCa companyareawithca ) {
		return addToCompanyAreaWithCa ( companyareawithca , false);
	}

	public static BaseCompanyAreaWithCa addToCompanyAreaWithCa ( BaseCompanyAreaWithCa companyareawithca, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			dao.setDataFromBase(companyareawithca);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CompanyAreaWithCa time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyAreaWithCa addUpdateCompanyAreaWithCa ( BaseCompanyAreaWithCa companyareawithca ) {
		return addUpdateCompanyAreaWithCa ( companyareawithca , false);
	}

	public static BaseCompanyAreaWithCa addUpdateCompanyAreaWithCa ( BaseCompanyAreaWithCa companyareawithca, boolean singleTransaction  ) {
		if(companyareawithca.getCompanyAreaId() == null) return addToCompanyAreaWithCa(companyareawithca);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			dao.setDataFromBase(companyareawithca);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(companyareawithca); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CompanyAreaWithCa time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyAreaWithCa deleteCompanyAreaWithCa ( BaseCompanyAreaWithCa bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete CompanyAreaWithCa time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyAreaWithCa updateCompanyAreaWithCa ( BaseCompanyAreaWithCa companyareawithca ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			dao.setCompanyAreaId( companyareawithca.getCompanyAreaId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(companyareawithca);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update CompanyAreaWithCa time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? companyareawithca : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyAreaWithCa updateCompanyAreaWithCaDirect( BaseCompanyAreaWithCa companyareawithca ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyAreaWithCa dao = new CompanyAreaWithCa();
			int result = 0;
			dao.setDataFromBase(companyareawithca);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update CompanyAreaWithCa time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? companyareawithca : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseCompanyAreaWithCa bean, CompanyAreaWithCa dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyAreaId() != null) {
			dao.setCompanyAreaId(bean.getCompanyAreaId());
			dao.setConditionCompanyAreaId("=", bean.getCompanyAreaId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getAreaId() != null) {
				dao.setConditionAreaId("=", bean.getAreaId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyAreaWithCa bean, CompanyAreaWithCa dao){
		int count = 0;
		if(bean.getCompanyAreaId() != null) {
			dao.setConditionCompanyAreaId("=", bean.getCompanyAreaId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getAreaId() != null) {
			dao.setConditionAreaId("=", bean.getAreaId());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		bean.setDataFromJSON(json);
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyAreaWithCa> rlist = new BaseCollection<>();
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyAreaWithCa> result = dao.conditionalLoadExt(addtion);
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
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		bean.setDataFromJSON(json);
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		bean.setDataFromJSON(json);
		int num = 0;
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		bean.setDataFromJSON(json);
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyAreaWithCa bean = new BaseCompanyAreaWithCa();
		bean.setDataFromJSON(json);
		CompanyAreaWithCa dao = new CompanyAreaWithCa();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


