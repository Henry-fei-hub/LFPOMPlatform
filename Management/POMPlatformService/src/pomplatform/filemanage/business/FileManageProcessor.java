package pomplatform.filemanage.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.file.db.bean.BaseFileManage;
import com.file.db.dao.FileManage;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;

public class FileManageProcessor implements GenericProcessor {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		String optType = BaseHelpUtils.getStringValue(params, "optType");
		switch(optType) {
		case "addTimes":
			return addTimes(params);
		case "subtractTimes":
			return subtractTimes(params);
		default :
			return null;
		}
	}

	public String addTimes(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String id = BaseHelpUtils.getStringValue(params, "id");
		if(BaseHelpUtils.isNullOrEmpty(id)) {
			return bc.toJSON(-1, "需要增加引用次数的ID为空");
		}
		FileManage dao = new FileManage();
		List<BaseFileManage> list = dao.conditionalLoad(String.format("%1$s in (%2$s)", BaseFileManage.CS_FILE_ID, id));
		if(null == list || list.isEmpty()) {
			return bc.toJSON(-1, "没有找到需要增加引用次数的记录");
		}
		for(BaseFileManage bean : list) {
			dao.clear();
			dao.setPrimaryKeyFromBase(bean);
			dao.setCitationTimes(BaseHelpUtils.getIntValue(bean.getCitationTimes()) + 1);
			dao.update();
		}
		return bc.toJSON();
	}
	
	public String subtractTimes(Map<String, Object> params) throws Exception {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		String id = BaseHelpUtils.getStringValue(params, "id");
		if(BaseHelpUtils.isNullOrEmpty(id)) {
			return bc.toJSON(-1, "需要减少引用次数的ID为空");
		}
		FileManage dao = new FileManage();
		List<BaseFileManage> list = dao.conditionalLoad(String.format("%1$s in (%2$s)", BaseFileManage.CS_FILE_ID, id));
		if(null == list || list.isEmpty()) {
			return bc.toJSON(-1, "没有找到需要减少引用次数的记录");
		}
		for(BaseFileManage bean : list) {
			dao.clear();
			dao.setPrimaryKeyFromBase(bean);
			dao.setCitationTimes(BaseHelpUtils.getIntValue(bean.getCitationTimes()) - 1);
			dao.update();
		}
		return bc.toJSON();
	}
	
	/**
	 * 根据主键，增加该记录的引用次数
	 * @param id
	 * @throws SQLException
	 */
	public static void addTimesById(Integer id) throws SQLException {
		if(null == id)
			return;
		FileManage dao = new FileManage();
		dao.setFileId(id);
		dao.unsetSelectFlags();
		dao.setSelectFileId(true);
		dao.setSelectCitationTimes(true);
		if(dao.load()) {
			dao.setCitationTimes(BaseHelpUtils.getIntValue(dao.getCitationTimes()) + 1);
			dao.update();
		}
	}
	
	/**
	 * 根据主键，增加该记录的引用次数
	 * @param id
	 * @throws SQLException
	 */
	public static void addTimesByIds(Integer... ids) throws SQLException {
		if(null == ids || ids.length == 0)
			return;
		for(Integer id : ids) {
			addTimesById(id);
		}
	}
	
	/**
	 * 根据主键，减少该记录的引用次数
	 * @param id
	 * @throws SQLException
	 */
	public static void subtractTimesById(Integer id) throws SQLException {
		if(null == id)
			return;
		FileManage dao = new FileManage();
		dao.setFileId(id);
		dao.unsetSelectFlags();
		dao.setSelectFileId(true);
		dao.setSelectCitationTimes(true);
		if(dao.load()) {
			dao.setCitationTimes(BaseHelpUtils.getIntValue(dao.getCitationTimes()) - 1);
			dao.update();
		}
	}
	
	/**
	 * 根据主键，减少原ID的引用次数，并增加新ID的引用次数
	 * @param columnChangedData
	 * @throws SQLException
	 */
	public static void upadteTimesByColumnChangedData(ColumnChangedData columnChangedData) throws SQLException {
		if(null == columnChangedData)
			return;
		FileManage dao = new FileManage();
		dao.unsetSelectFlags();
		dao.setSelectFileId(true);
		dao.setSelectCitationTimes(true);
		if(null != columnChangedData.getOriginal()) {
			dao.setFileId(BaseHelpUtils.getIntValue(columnChangedData.getOriginal()));
			if(dao.load()) {
				dao.setCitationTimes(BaseHelpUtils.getIntValue(dao.getCitationTimes()) - 1);
				dao.update();
			}
		}
		if(null != columnChangedData.getValue()) {
			dao.setFileId(BaseHelpUtils.getIntValue(columnChangedData.getValue()));
			if(dao.load()) {
				dao.setCitationTimes(BaseHelpUtils.getIntValue(dao.getCitationTimes()) + 1);
				dao.update();
			}
		}
	}
	
	/**
	 * 根据fileId获取fileUrl
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static String getFileUrlById(Integer id) throws SQLException {
		if(null == id)
			return null;
		FileManage dao = new FileManage();
		dao.unsetSelectFlags();
		dao.setSelectFileUrl(true);
		dao.setFileId(id);
		if(dao.load()) {
			return dao.getFileUrl();
		}
		return null;
	}
}
