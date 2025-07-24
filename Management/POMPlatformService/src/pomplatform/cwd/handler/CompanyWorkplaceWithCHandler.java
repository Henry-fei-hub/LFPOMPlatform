package pomplatform.cwd.handler;


import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.cwd.bean.BaseCompanyWorkplaceWithC;
import pomplatform.cwd.dao.CompanyWorkplaceWithC;

public class CompanyWorkplaceWithCHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(CompanyWorkplaceWithCHandler.class);

	public static BaseCompanyWorkplaceWithC getCompanyWorkplaceWithCById( java.lang.Integer company_workplace_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseCompanyWorkplaceWithC result;
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			dao.setCompanyWorkplaceId(company_workplace_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get CompanyWorkplaceWithC By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isCompanyWorkplaceWithCExists( pomplatform.cwd.bean.BaseCompanyWorkplaceWithC bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CompanyWorkplaceWithC List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countCompanyWorkplaceWithC( pomplatform.cwd.bean.BaseCompanyWorkplaceWithC bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query CompanyWorkplaceWithC List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseCompanyWorkplaceWithC> queryCompanyWorkplaceWithC( BaseCompanyWorkplaceWithC bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseCompanyWorkplaceWithC> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseCompanyWorkplaceWithC> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query CompanyWorkplaceWithC List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyWorkplaceWithC addToCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC companyworkplacewithc ) {
		return addToCompanyWorkplaceWithC ( companyworkplacewithc , false);
	}

	public static BaseCompanyWorkplaceWithC addToCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC companyworkplacewithc, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			dao.setDataFromBase(companyworkplacewithc);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CompanyWorkplaceWithC time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyWorkplaceWithC addUpdateCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC companyworkplacewithc ) {
		return addUpdateCompanyWorkplaceWithC ( companyworkplacewithc , false);
	}

	public static BaseCompanyWorkplaceWithC addUpdateCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC companyworkplacewithc, boolean singleTransaction  ) {
		if(companyworkplacewithc.getCompanyWorkplaceId() == null) return addToCompanyWorkplaceWithC(companyworkplacewithc);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			dao.setDataFromBase(companyworkplacewithc);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(companyworkplacewithc); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to CompanyWorkplaceWithC time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyWorkplaceWithC deleteCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete CompanyWorkplaceWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyWorkplaceWithC updateCompanyWorkplaceWithC ( BaseCompanyWorkplaceWithC companyworkplacewithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			dao.setCompanyWorkplaceId( companyworkplacewithc.getCompanyWorkplaceId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(companyworkplacewithc);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update CompanyWorkplaceWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? companyworkplacewithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseCompanyWorkplaceWithC updateCompanyWorkplaceWithCDirect( BaseCompanyWorkplaceWithC companyworkplacewithc ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
			int result = 0;
			dao.setDataFromBase(companyworkplacewithc);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update CompanyWorkplaceWithC time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? companyworkplacewithc : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseCompanyWorkplaceWithC bean, CompanyWorkplaceWithC dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getCompanyWorkplaceId() != null) {
			dao.setCompanyWorkplaceId(bean.getCompanyWorkplaceId());
			dao.setConditionCompanyWorkplaceId("=", bean.getCompanyWorkplaceId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getCompanyId() != null) {
				dao.setConditionCompanyId("=", bean.getCompanyId());
				count++;
			}
			if(bean.getWorkplaceName() != null) {
				dao.setConditionWorkplaceName("=", bean.getWorkplaceName());
				count++;
			}
			if(bean.getCountryId() != null) {
				dao.setConditionCountryId("=", bean.getCountryId());
				count++;
			}
			if(bean.getProvinceId() != null) {
				dao.setConditionProvinceId("=", bean.getProvinceId());
				count++;
			}
			if(bean.getCityId() != null) {
				dao.setConditionCityId("=", bean.getCityId());
				count++;
			}
			if(bean.getActive() != null) {
				dao.setConditionActive("=", bean.getActive());
				count++;
			}
			if(bean.getWorkplaceDir() != null) {
				dao.setConditionWorkplaceDir("=", bean.getWorkplaceDir());
				count++;
			}
			if(bean.getWorkplaceType() != null) {
				dao.setConditionWorkplaceType("=", bean.getWorkplaceType());
				count++;
			}
			if(bean.getHasInit() != null) {
				dao.setConditionHasInit("=", bean.getHasInit());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseCompanyWorkplaceWithC bean, CompanyWorkplaceWithC dao){
		int count = 0;
		if(bean.getCompanyWorkplaceId() != null) {
			dao.setConditionCompanyWorkplaceId("=", bean.getCompanyWorkplaceId());
			count++;
		}
		if(bean.getCompanyId() != null) {
			dao.setConditionCompanyId("=", bean.getCompanyId());
			count++;
		}
		if(bean.getWorkplaceName() != null) {
			if(bean.getWorkplaceName().indexOf("%") >= 0)
				dao.setConditionWorkplaceName("like", bean.getWorkplaceName());
			else
				dao.setConditionWorkplaceName("=", bean.getWorkplaceName());
			count++;
		}
		if(bean.getCountryId() != null) {
			dao.setConditionCountryId("=", bean.getCountryId());
			count++;
		}
		if(bean.getProvinceId() != null) {
			dao.setConditionProvinceId("=", bean.getProvinceId());
			count++;
		}
		if(bean.getCityId() != null) {
			dao.setConditionCityId("=", bean.getCityId());
			count++;
		}
		if(bean.getActive() != null) {
			dao.setConditionActive("=", bean.getActive());
			count++;
		}
		if(bean.getWorkplaceDir() != null) {
			if(bean.getWorkplaceDir().indexOf("%") >= 0)
				dao.setConditionWorkplaceDir("like", bean.getWorkplaceDir());
			else
				dao.setConditionWorkplaceDir("=", bean.getWorkplaceDir());
			count++;
		}
		if(bean.getWorkplaceType() != null) {
			dao.setConditionWorkplaceType("=", bean.getWorkplaceType());
			count++;
		}
		if(bean.getHasInit() != null) {
			dao.setConditionHasInit("=", bean.getHasInit());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		bean.setDataFromJSON(json);
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseCompanyWorkplaceWithC> rlist = new BaseCollection<>();
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseCompanyWorkplaceWithC> result = dao.conditionalLoadExt(addtion);
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
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		bean.setDataFromJSON(json);
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		bean.setDataFromJSON(json);
		int num = 0;
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		bean.setDataFromJSON(json);
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseCompanyWorkplaceWithC bean = new BaseCompanyWorkplaceWithC();
		bean.setDataFromJSON(json);
		CompanyWorkplaceWithC dao = new CompanyWorkplaceWithC();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


