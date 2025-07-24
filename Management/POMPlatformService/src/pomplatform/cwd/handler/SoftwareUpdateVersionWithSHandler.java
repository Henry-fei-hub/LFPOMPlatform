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
import pomplatform.cwd.bean.BaseSoftwareUpdateVersionWithS;
import pomplatform.cwd.dao.SoftwareUpdateVersionWithS;

public class SoftwareUpdateVersionWithSHandler implements GenericDao {

	public final static ThreadLocal currentRequest = new ThreadLocal();

	private static final Logger __logger = Logger.getLogger(SoftwareUpdateVersionWithSHandler.class);

	public static BaseSoftwareUpdateVersionWithS getSoftwareUpdateVersionWithSById(
			java.lang.Integer software_update_version_id) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			BaseSoftwareUpdateVersionWithS result;
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			dao.setSoftwareUpdateVersionId(software_update_version_id);
			if (dao.load(true)) {
				result = dao.generateBaseExt();
				tsc.recordTime();
				__logger.info(
						String.format("Get SoftwareUpdateVersionWithS By ID time used : [%1$d]", tsc.getLastTime()));
				return result;
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static boolean isSoftwareUpdateVersionWithSExists(pomplatform.cwd.bean.BaseSoftwareUpdateVersionWithS bean,
			String additional) {

		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			setConditions(bean, dao);
			boolean res = dao.isExist(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SoftwareUpdateVersionWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public static int countSoftwareUpdateVersionWithS(pomplatform.cwd.bean.BaseSoftwareUpdateVersionWithS bean,
			String additional) {

		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			setConditions(bean, dao);
			int res = dao.countRows(additional);
			tsc.recordTime();
			__logger.info(String.format("Query SoftwareUpdateVersionWithS List time used : [%1$d]", tsc.getLastTime()));
			return res;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}
	}

	public static BaseCollection<BaseSoftwareUpdateVersionWithS> querySoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS bean, int pageNo, int pageLines, String additionalCondition) {
		__logger.info(String.format("Current Page No. [%1$d]", pageNo));
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			setConditions(bean, dao);
			dao.setCurrentPage(pageNo);
			dao.setPageLines(pageLines);
			List<BaseSoftwareUpdateVersionWithS> result = dao.conditionalLoadExt(additionalCondition);
			BaseCollection<BaseSoftwareUpdateVersionWithS> col = new BaseCollection<>();
			col.setCollections(result);
			col.setTotalPages(dao.getTotalPages());
			col.setCurrentPage(dao.getCurrentPage());
			col.setPageLines(dao.getPageLines());
			col.setTotalLines(dao.getTotalLines());
			col.setRecordNumber(result.size());
			tsc.recordTime();
			__logger.info(String.format("Query SoftwareUpdateVersionWithS List time used : [%1$d]", tsc.getLastTime()));
			return col;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSoftwareUpdateVersionWithS addToSoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths) {
		return addToSoftwareUpdateVersionWithS(softwareupdateversionwiths, false);
	}

	public static BaseSoftwareUpdateVersionWithS addToSoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths, boolean singleTransaction) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if (singleTransaction)
				ThreadConnection.beginTransaction();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			dao.setDataFromBase(softwareupdateversionwiths);
			int result = dao.save();
			if (singleTransaction)
				ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SoftwareUpdateVersionWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? dao.generateBaseExt() : null;
		} catch (Exception ex) {
			if (singleTransaction)
				ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSoftwareUpdateVersionWithS addUpdateSoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths) {
		return addUpdateSoftwareUpdateVersionWithS(softwareupdateversionwiths, false);
	}

	public static BaseSoftwareUpdateVersionWithS addUpdateSoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths, boolean singleTransaction) {
		if (softwareupdateversionwiths.getSoftwareUpdateVersionId() == null)
			return addToSoftwareUpdateVersionWithS(softwareupdateversionwiths);
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			if (singleTransaction)
				ThreadConnection.beginTransaction();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			dao.setDataFromBase(softwareupdateversionwiths);
			int result = 0;
			if (dao.load()) {
				dao.setDataFromBase(softwareupdateversionwiths);
				if (dao.isThisObjectModified()) {
					result = dao.update();
				} else
					result = 1;
			} else
				result = dao.save();
			if (singleTransaction)
				ThreadConnection.commit();
			tsc.recordTime();
			__logger.info(String.format("Add to SoftwareUpdateVersionWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? dao.generateBaseExt() : null;
		} catch (Exception ex) {
			if (singleTransaction)
				ThreadConnection.rollback();
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSoftwareUpdateVersionWithS deleteSoftwareUpdateVersionWithS(BaseSoftwareUpdateVersionWithS bean) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			setDeleteConditions(bean, dao);
			int result = dao.conditionalDelete();
			tsc.recordTime();
			__logger.info(String.format("Delete SoftwareUpdateVersionWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? bean : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSoftwareUpdateVersionWithS updateSoftwareUpdateVersionWithS(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			dao.setSoftwareUpdateVersionId(softwareupdateversionwiths.getSoftwareUpdateVersionId());
			int result = 0;
			if (dao.load()) {
				dao.setDataFromBase(softwareupdateversionwiths);
				result = dao.update();
			}
			tsc.recordTime();
			__logger.info(String.format("Update SoftwareUpdateVersionWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? softwareupdateversionwiths : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static BaseSoftwareUpdateVersionWithS updateSoftwareUpdateVersionWithSDirect(
			BaseSoftwareUpdateVersionWithS softwareupdateversionwiths) {
		try {
			TimeSpanCalculator tsc = new TimeSpanCalculator();
			tsc.recordTime();
			SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
			int result = 0;
			dao.setDataFromBase(softwareupdateversionwiths);
			result = dao.update();
			tsc.recordTime();
			__logger.info(String.format("Update SoftwareUpdateVersionWithS time used : [%1$d]", tsc.getLastTime()));
			return result == 1 ? softwareupdateversionwiths : null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public static int setDeleteConditions(BaseSoftwareUpdateVersionWithS bean, SoftwareUpdateVersionWithS dao) {
		int count = 0;
		boolean foundKey = false;
		if (bean.getSoftwareUpdateVersionId() != null) {
			dao.setSoftwareUpdateVersionId(bean.getSoftwareUpdateVersionId());
			dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
			count++;
			foundKey = true;
		}
		if (!foundKey) {
			if (bean.getTitle() != null) {
				dao.setConditionTitle("=", bean.getTitle());
				count++;
			}
			if (bean.getRemark() != null) {
				dao.setConditionRemark("=", bean.getRemark());
				count++;
			}
			if (bean.getSoftwareType() != null) {
				dao.setConditionSoftwareType("=", bean.getSoftwareType());
				count++;
			}
			if (bean.getEmployeeId() != null) {
				dao.setConditionEmployeeId("=", bean.getEmployeeId());
				count++;
			}
			if (bean.getSqlScript() != null) {
				dao.setConditionSqlScript("=", bean.getSqlScript());
				count++;
			}
			if (bean.getIsReboot() != null) {
				dao.setConditionIsReboot("=", bean.getIsReboot());
				count++;
			}
		}
		return count;
	}

	public static int setConditions(BaseSoftwareUpdateVersionWithS bean, SoftwareUpdateVersionWithS dao) {
		int count = 0;
		if (bean.getSoftwareUpdateVersionId() != null) {
			dao.setConditionSoftwareUpdateVersionId("=", bean.getSoftwareUpdateVersionId());
			count++;
		}
		if (bean.getVersionNo() != null) {
			dao.setConditionVersionNo("=", bean.getVersionNo());
			count++;
		}
		if (bean.getTitle() != null) {
			if (bean.getTitle().indexOf("%") >= 0)
				dao.setConditionTitle("like", bean.getTitle());
			else
				dao.setConditionTitle("=", bean.getTitle());
			count++;
		}
		if (bean.getRemark() != null) {
			if (bean.getRemark().indexOf("%") >= 0)
				dao.setConditionRemark("like", bean.getRemark());
			else
				dao.setConditionRemark("=", bean.getRemark());
			count++;
		}
		if (bean.getSoftwareType() != null) {
			dao.setConditionSoftwareType("=", bean.getSoftwareType());
			count++;
		}
		if (bean.getEmployeeId() != null) {
			dao.setConditionEmployeeId("=", bean.getEmployeeId());
			count++;
		}
		if (bean.getCreateTime() != null) {
			dao.setConditionCreateTime(">=", bean.getCreateTime());
			count++;
		}
		if (bean.getSqlScript() != null) {
			if (bean.getSqlScript().indexOf("%") >= 0)
				dao.setConditionSqlScript("like", bean.getSqlScript());
			else
				dao.setConditionSqlScript("=", bean.getSqlScript());
			count++;
		}
		if (bean.getIsReboot() != null) {
			dao.setConditionIsReboot("=", bean.getIsReboot());
			count++;
		}
		return count;
	}

	@Override
	public String findUsingKey(String json) throws Exception {
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		dao.setPrimaryKeyFromBase(bean);
		if (dao.load(true)) {
			dao.setDataToBase(bean);
			return bean.toOneLineJSON(1, null);
		}
		return bean.toOneLineJSON(0, "Record not found.");
	}

	@Override
	public String find(String json, int currentPage, int pageSize, String addtion) throws Exception {
		BaseCollection<BaseSoftwareUpdateVersionWithS> rlist = new BaseCollection<>();
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		JSON parser = new JSON(new StringReader(json));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		bean.setDataFromMap(params);
		PaginationParameter pp = PaginationParameter.generateFromMap(params);
		if (pp != null) {
			if (pp.getCurrentPage() > 0)
				currentPage = pp.getCurrentPage();
			if (pp.getPageSize() > 0)
				pageSize = pp.getPageSize();
			if (pp.getCondition() != null)
				addtion = pp.getCondition();
		}
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		setConditions(bean, dao);
		dao.setCurrentPage(currentPage);
		dao.setPageLines(pageSize);
		List<BaseSoftwareUpdateVersionWithS> result = dao.conditionalLoadExt(addtion);
		rlist.setCollections(result);
		rlist.setTotalPages(dao.getTotalPages());
		rlist.setCurrentPage(dao.getCurrentPage());
		rlist.setPageLines(dao.getPageLines());
		rlist.setTotalLines(dao.getTotalLines());
		rlist.setRecordNumber(result.size());
		return rlist.toJSON(null);
	}

	@Override
	public String save(String json) throws Exception {
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		int num = dao.save();
		dao.setDataToBase(bean);
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String saveOrUpdate(String json) throws Exception {
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		int num = 0;
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		if (dao.isPrimaryKeyNull())
			num = dao.save();
		else if (dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String update(String json) throws Exception {
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		ThreadConnection.beginTransaction();
		dao.setPrimaryKeyFromBase(bean);
		int num = 0;
		if (dao.load()) {
			dao.setDataFromBase(bean);
			num = dao.update();
		}
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

	@Override
	public String delete(String json) throws Exception {
		BaseSoftwareUpdateVersionWithS bean = new BaseSoftwareUpdateVersionWithS();
		bean.setDataFromJSON(json);
		SoftwareUpdateVersionWithS dao = new SoftwareUpdateVersionWithS();
		ThreadConnection.beginTransaction();
		dao.setDataFromBase(bean);
		setDeleteConditions(bean, dao);
		int num = dao.conditionalDelete();
		ThreadConnection.commit();
		return bean.toOneLineJSON(num, null);
	}

}
