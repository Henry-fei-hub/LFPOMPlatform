package pomplatform.subjectType.handler;


import java.util.List;
import delicacy.common.BaseCollection;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import java.io.StringReader;
import java.util.Map;
import delicacy.common.PaginationParameter;
import pomplatform.subjectType.bean.BaseSubjectTypeWithS;
import pomplatform.subjectType.dao.SubjectTypeWithS;
import com.pomplatform.db.dao.SubjectDepartment;
import org.apache.log4j.Logger;
import delicacy.common.GenericDao;
import delicacy.connection.ThreadConnection;
import delicacy.date.util.TimeSpanCalculator;

public class SubjectTypeWithSHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(SubjectTypeWithSHandler.class);

	public static BaseSubjectTypeWithS getSubjectTypeWithSById( java.lang.Integer subject_type_id )
	{
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseSubjectTypeWithS result;
			SubjectTypeWithS dao = new SubjectTypeWithS();
			dao.setSubjectTypeId(subject_type_id);
			if(dao.load(true)){
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(String.format("Get SubjectTypeWithS By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isSubjectTypeWithSExists( pomplatform.subjectType.bean.BaseSubjectTypeWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SubjectTypeWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countSubjectTypeWithS( pomplatform.subjectType.bean.BaseSubjectTypeWithS bean, String additional ) {

		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SubjectTypeWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseSubjectTypeWithS> querySubjectTypeWithS( BaseSubjectTypeWithS bean, int pageNo, int pageLines, String additionalCondition ) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseSubjectTypeWithS> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseSubjectTypeWithS> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query SubjectTypeWithS List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSubjectTypeWithS addToSubjectTypeWithS ( BaseSubjectTypeWithS subjecttypewiths ) {
		return addToSubjectTypeWithS ( subjecttypewiths , false);
	}

	public static BaseSubjectTypeWithS addToSubjectTypeWithS ( BaseSubjectTypeWithS subjecttypewiths, boolean singleTransaction ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			dao.setDataFromBase(subjecttypewiths);
			int result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SubjectTypeWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSubjectTypeWithS addUpdateSubjectTypeWithS ( BaseSubjectTypeWithS subjecttypewiths ) {
		return addUpdateSubjectTypeWithS ( subjecttypewiths , false);
	}

	public static BaseSubjectTypeWithS addUpdateSubjectTypeWithS ( BaseSubjectTypeWithS subjecttypewiths, boolean singleTransaction  ) {
		if(subjecttypewiths.getSubjectTypeId() == null) return addToSubjectTypeWithS(subjecttypewiths);
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if(singleTransaction) ThreadConnection.beginTransaction();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			dao.setDataFromBase(subjecttypewiths);
			int result = 0;
			if(dao.load()) {
				dao.setDataFromBase(subjecttypewiths); 
				if(dao.isThisObjectModified()) { 
					result = dao.update();
				} else result = 1;
			} else result = dao.save();
			if(singleTransaction) ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SubjectTypeWithS time used : [%1$d]", tsc.getLastTime()));
			return result==1?dao.generateBaseExt():null;
		} catch(Exception ex) {
			if(singleTransaction) ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSubjectTypeWithS deleteSubjectTypeWithS ( BaseSubjectTypeWithS bean ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete SubjectTypeWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSubjectTypeWithS updateSubjectTypeWithS ( BaseSubjectTypeWithS subjecttypewiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			dao.setSubjectTypeId( subjecttypewiths.getSubjectTypeId() );
			int result = 0;
			if( dao.load() ) {
				dao.setDataFromBase(subjecttypewiths);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update SubjectTypeWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? subjecttypewiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSubjectTypeWithS updateSubjectTypeWithSDirect( BaseSubjectTypeWithS subjecttypewiths ) {
		try{
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SubjectTypeWithS dao = new SubjectTypeWithS();
			int result = 0;
			dao.setDataFromBase(subjecttypewiths);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update SubjectTypeWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? subjecttypewiths : null ;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseSubjectTypeWithS bean, SubjectTypeWithS dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getSubjectTypeId() != null) {
			dao.setSubjectTypeId(bean.getSubjectTypeId());
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getParentId() != null) {
				dao.setConditionParentId("=", bean.getParentId());
				count++;
			}
			if(bean.getSubjectName() != null) {
				dao.setConditionSubjectName("=", bean.getSubjectName());
				count++;
			}
			if(bean.getIsEnabled() != null) {
				dao.setConditionIsEnabled("=", bean.getIsEnabled());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSubjectTypeWithS bean, SubjectTypeWithS dao){
		int count = 0;
		if(bean.getSubjectTypeId() != null) {
			dao.setConditionSubjectTypeId("=", bean.getSubjectTypeId());
			count++;
		}
		if(bean.getParentId() != null) {
			dao.setConditionParentId("=", bean.getParentId());
			count++;
		}
		if(bean.getSubjectName() != null) {
			if(bean.getSubjectName().indexOf("%") >= 0)
				dao.setConditionSubjectName("like", bean.getSubjectName());
			else
				dao.setConditionSubjectName("=", bean.getSubjectName());
			count++;
		}
		if(bean.getIsEnabled() != null) {
			dao.setConditionIsEnabled("=", bean.getIsEnabled());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		bean.setDataFromJSON(json);
		SubjectTypeWithS dao = new SubjectTypeWithS();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1,null);
		}
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseSubjectTypeWithS> rlist = new BaseCollection<>();
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		SubjectTypeWithS dao = new SubjectTypeWithS();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSubjectTypeWithS> result = dao.conditionalLoadExt(addtion);
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
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		bean.setDataFromJSON(json);
		SubjectTypeWithS dao = new SubjectTypeWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		bean.setDataFromJSON(json);
		int num = 0;
		SubjectTypeWithS dao = new SubjectTypeWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if(dao.isPrimaryKeyNull()) num = dao.save();
		else if(dao.load()){ dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		bean.setDataFromJSON(json);
		SubjectTypeWithS dao = new SubjectTypeWithS();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseSubjectTypeWithS bean = new BaseSubjectTypeWithS();
		bean.setDataFromJSON(json);
		SubjectTypeWithS dao = new SubjectTypeWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}


