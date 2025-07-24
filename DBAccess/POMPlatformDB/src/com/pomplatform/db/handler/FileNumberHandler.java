package com.pomplatform.db.handler;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseFileNumber;
import com.pomplatform.db.dao.FileNumber;

import delicacy.common.BaseCollection;
import delicacy.common.GenericDao;
import delicacy.common.PaginationParameter;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FileNumberHandler implements GenericDao {

	private static final Logger __logger = Logger.getLogger(FileNumberHandler.class);

	public static BaseFileNumber getFileNumberById( 
		java.lang.Integer file_number_id
	) throws Exception
	{
		FileNumber dao = new FileNumber();
		dao.setFileNumberId(file_number_id);
		if(dao.load()){
			return dao.generateBase();
		}
		return null;
	}

	public static boolean isFileNumberExists( com.pomplatform.db.bean.BaseFileNumber bean, String additional ) throws Exception {

		FileNumber dao = new FileNumber();
		setConditions(bean, dao);
		boolean res = dao.isExist(additional);
		return res;
	}

	public static int countFileNumber( com.pomplatform.db.bean.BaseFileNumber bean, String additional ) throws Exception {

		FileNumber dao = new FileNumber();
		setConditions(bean, dao);
		int res = dao.countRows(additional);
		return res;
	}

	public static BaseCollection<BaseFileNumber> queryFileNumber( com.pomplatform.db.bean.BaseFileNumber bean, int pageNo, int pageLines, String additionalCondition ) throws Exception {
		FileNumber dao = new FileNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(pageNo);
		dao.setPageLines(pageLines);
		java.util.List<BaseFileNumber> result = dao.conditionalLoad(additionalCondition);
		BaseCollection<BaseFileNumber> col = new BaseCollection<>();
		col.setCollections(result);
		col.setTotalPages(dao.getTotalPages());
		col.setCurrentPage(dao.getCurrentPage());
		col.setPageLines(dao.getPageLines());
		col.setTotalLines(dao.getTotalLines());
		col.setRecordNumber(result.size());
		return col;
	}

	public static BaseFileNumber addToFileNumber ( BaseFileNumber filenumber )  throws Exception {
		return addToFileNumber ( filenumber , false);
	}

	public static BaseFileNumber addToFileNumber ( BaseFileNumber filenumber, boolean singleTransaction ) throws Exception {
		if(singleTransaction) ThreadConnection.beginTransaction();
		FileNumber dao = new FileNumber();
		dao.setDataFromBase(filenumber);
		int result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static BaseFileNumber addUpdateFileNumber ( BaseFileNumber filenumber ) throws Exception {
		return addUpdateFileNumber ( filenumber , false);
	}

	public static BaseFileNumber addUpdateFileNumber ( BaseFileNumber filenumber, boolean singleTransaction  ) throws Exception {
		if(filenumber.getFileNumberId() == null) return addToFileNumber(filenumber);
		if(singleTransaction) ThreadConnection.beginTransaction();
		StringBuilder sb = new StringBuilder();
		FileNumber dao = new FileNumber();
		dao.setDataFromBase(filenumber);
		int result = 0;
		if(dao.load()) {
			dao.setDataFromBase(filenumber); 
			if(dao.isThisObjectModified()) { 
				result = dao.update();
			} else result = 1;
		} else result = dao.save();
		if(singleTransaction) ThreadConnection.commit();
		return result==1?dao.generateBase():null;
	}

	public static int deleteFileNumber ( BaseFileNumber bean ) throws Exception {
		FileNumber dao = new FileNumber();
		if(setDeleteConditions(bean, dao) == 0) return 0;
		int result = dao.conditionalDelete();
		return result ;
	}

	public static BaseFileNumber updateFileNumber ( BaseFileNumber filenumber ) throws Exception {
		FileNumber dao = new FileNumber();
		dao.setFileNumberId( filenumber.getFileNumberId() );
		int result = 0;
		if( dao.load() ) {
			dao.setDataFromBase(filenumber);
			result = dao.update();
		}
		return result == 1 ? filenumber : null ;
	}

	public static BaseFileNumber updateFileNumberDirect( BaseFileNumber filenumber ) throws Exception {
		FileNumber dao = new FileNumber();
		int result = 0;
		dao.setDataFromBase(filenumber);
		result = dao.update();
		return result == 1 ? filenumber : null ;
	}

	public static int setDeleteConditions(BaseFileNumber bean, FileNumber dao){
		int count = 0;
		boolean foundKey = false;
		if(bean.getFileNumberId() != null) {
			dao.setConditionFileNumberId("=", bean.getFileNumberId());
			count++;
			foundKey = true;
		}
		if(!foundKey) {
			if(bean.getFileNumberMax() != null) {
				dao.setConditionFileNumberMax("=", bean.getFileNumberMax());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseFileNumber bean, FileNumber dao){
		int count = 0;
		if(bean.getFileNumberId() != null) {
			dao.setConditionFileNumberId("=", bean.getFileNumberId());
			count++;
		}
		if(bean.getFileNumberMax() != null) {
			dao.setConditionFileNumberMax("=", bean.getFileNumberMax());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception{
		BaseFileNumber bean = new BaseFileNumber();
		bean.setDataFromJSON(json);
		FileNumber dao = new FileNumber();
		dao.setPrimaryKeyFromBase(bean);
		if(dao.load()) { dao.setDataToBase(bean); return bean.toOneLineJSON(1,null); }
		return bean.toOneLineJSON(0,"Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception{
		BaseCollection<BaseFileNumber> rlist = new BaseCollection<>();
		BaseFileNumber bean = new BaseFileNumber();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if(pp != null){
			if(pp.getCurrentPage() > 0) currentPage = pp.getCurrentPage();
			if(pp.getPageSize() > 0) pageSize = pp.getPageSize();
			if(pp.getCondition() != null) addtion = pp.getCondition();
		}
		FileNumber dao = new FileNumber();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseFileNumber> result = dao.conditionalLoad(addtion);
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
		BaseFileNumber bean = new BaseFileNumber();
		bean.setDataFromJSON(json);
		FileNumber dao = new FileNumber();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception{
		BaseFileNumber bean = new BaseFileNumber();
		bean.setDataFromJSON(json);
		FileNumber dao = new FileNumber();
		dao.setPrimaryKeyFromBase(bean);
		int num=0;
		if(dao.load()){dao.setDataFromBase(bean); num = dao.update(); }
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception{
		BaseFileNumber bean = new BaseFileNumber();
		bean.setDataFromJSON(json);
		FileNumber dao = new FileNumber();
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception{
		BaseFileNumber bean = new BaseFileNumber();
		bean.setDataFromJSON(json);
		FileNumber dao = new FileNumber();
		dao.setPrimaryKeyFromBase(bean);
		int ret = 0;
		if(dao.isPrimaryKeyNull()) { dao.setDataFromBase(bean); ret = dao.save(); bean = dao.generateBase(); }
		else if(dao.load()) { dao.setDataFromBase(bean); ret = dao.update(); bean = dao.generateBase(); }
		return bean.toOneLineJSON(ret, null);
	}

}


