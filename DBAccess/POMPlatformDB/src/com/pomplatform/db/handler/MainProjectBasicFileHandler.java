package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseMainProjectBasicFile;
import com.pomplatform.db.dao.MainProjectBasicFile;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class MainProjectBasicFileHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(MainProjectBasicFileHandler.class);

	public static BaseMainProjectBasicFile getMainProjectBasicFileById( 
		java.lang.Integer main_project_basic_file_id
	) throws Exception
	{
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setMainProjectBasicFileId(main_project_basic_file_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isMainProjectBasicFileExists( com.pomplatform.db.bean.BaseMainProjectBasicFile bean, String additional ) throws Exception {

		MainProjectBasicFile dao = new MainProjectBasicFile();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countMainProjectBasicFile( com.pomplatform.db.bean.BaseMainProjectBasicFile bean, String additional ) throws Exception {

		MainProjectBasicFile dao = new MainProjectBasicFile();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseMainProjectBasicFile> queryMainProjectBasicFile( com.pomplatform.db.bean.BaseMainProjectBasicFile bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		MainProjectBasicFile dao = new MainProjectBasicFile();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseMainProjectBasicFile> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseMainProjectBasicFile> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseMainProjectBasicFile addToMainProjectBasicFile ( BaseMainProjectBasicFile mainprojectbasicfile )  throws Exception {
		return addToMainProjectBasicFile ( mainprojectbasicfile , false);
	}

	public static BaseMainProjectBasicFile addToMainProjectBasicFile ( BaseMainProjectBasicFile mainprojectbasicfile, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setDataFromBase(mainprojectbasicfile);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseMainProjectBasicFile addUpdateMainProjectBasicFile ( BaseMainProjectBasicFile mainprojectbasicfile ) throws Exception {
		return addUpdateMainProjectBasicFile ( mainprojectbasicfile , false);
	}

	public static BaseMainProjectBasicFile addUpdateMainProjectBasicFile ( BaseMainProjectBasicFile mainprojectbasicfile, boolean singleTransaction  ) throws Exception {
		if(mainprojectbasicfile.getMainProjectBasicFileId() == null) return addToMainProjectBasicFile(mainprojectbasicfile);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setDataFromBase(mainprojectbasicfile);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(mainprojectbasicfile); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteMainProjectBasicFile ( BaseMainProjectBasicFile bean ) throws Exception {
		MainProjectBasicFile dao = new MainProjectBasicFile();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseMainProjectBasicFile updateMainProjectBasicFile ( BaseMainProjectBasicFile mainprojectbasicfile ) throws Exception {
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setMainProjectBasicFileId( mainprojectbasicfile.getMainProjectBasicFileId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(mainprojectbasicfile);
			result = dao.update();
		}
		return result == 1 ? mainprojectbasicfile : null ;
	}

	public static BaseMainProjectBasicFile updateMainProjectBasicFileDirect( BaseMainProjectBasicFile mainprojectbasicfile ) throws Exception {
		MainProjectBasicFile dao = new MainProjectBasicFile();
		int result = 0;
		dao.setDataFromBase(mainprojectbasicfile);
		result = dao.update();
		return result == 1 ? mainprojectbasicfile : null ;
	}

	public static int setDeleteConditions(BaseMainProjectBasicFile bean, MainProjectBasicFile dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getMainProjectBasicFileId() != null) {
			dao.setConditionMainProjectBasicFileId("=", bean.getMainProjectBasicFileId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getMainProjectId() != null) {
				dao.setConditionMainProjectId("=", bean.getMainProjectId());
				count++;
			}
			if(bean.getCwdFileId() != null) {
				dao.setConditionCwdFileId("=", bean.getCwdFileId());
				count++;
			}
			if(bean.getOperatorId() != null) {
				dao.setConditionOperatorId("=", bean.getOperatorId());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseMainProjectBasicFile bean, MainProjectBasicFile dao){
		int count = 0;
		if(bean.getMainProjectBasicFileId() != null) {
			dao.setConditionMainProjectBasicFileId("=", bean.getMainProjectBasicFileId());
			count++;
		}
		if(bean.getMainProjectId() != null) {
			dao.setConditionMainProjectId("=", bean.getMainProjectId());
			count++;
		}
		if(bean.getCwdFileId() != null) {
			dao.setConditionCwdFileId("=", bean.getCwdFileId());
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
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		bean.setDataFromJSON(json);
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseMainProjectBasicFile> rlist = new BaseCollection<>();
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		MainProjectBasicFile dao = new MainProjectBasicFile();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseMainProjectBasicFile> result = dao.conditionalLoad(addtion);
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
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		bean.setDataFromJSON(json);
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		bean.setDataFromJSON(json);
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		bean.setDataFromJSON(json);
		MainProjectBasicFile dao = new MainProjectBasicFile();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseMainProjectBasicFile bean = new BaseMainProjectBasicFile();
		bean.setDataFromJSON(json);
		MainProjectBasicFile dao = new MainProjectBasicFile();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


