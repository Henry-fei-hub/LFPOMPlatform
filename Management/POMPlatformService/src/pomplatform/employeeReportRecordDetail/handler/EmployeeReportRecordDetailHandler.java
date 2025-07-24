package pomplatform.employeeReportRecordDetail.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseEmployeeSalaryDetail;
import com.pomplatform.db.dao.EmployeeSalaryDetail;
import com.pomplatform.db.dao.SystemConfig;
import com.pomplatform.db.dao.SystemLog;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.HttpCookie;
import pomplatform.employeeReportRecordDetail.bean.BaseEmployeeReportRecordDetail;
import pomplatform.employeeReportRecordDetail.bean.ConditionEmployeeReportRecordDetail;
import pomplatform.employeeReportRecordDetail.query.QueryEmployeeReportRecordDetail;

public class EmployeeReportRecordDetailHandler implements GenericQuery, GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(EmployeeReportRecordDetailHandler.class);

	public static BaseCollection<BaseEmployeeReportRecordDetail> executeQueryEmployeeReportRecordDetail(
			ConditionEmployeeReportRecordDetail c, KeyValuePair[] replacements) throws Exception {
		QueryEmployeeReportRecordDetail dao = new QueryEmployeeReportRecordDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseEmployeeReportRecordDetail> result = dao.executeQuery(c.getKeyValues(), c);
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		return findWithPermission(creteria).toJSON();
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BaseCollection<BaseEmployeeReportRecordDetail> result = findWithPermission(creteria);
		HttpCookie cookie = new HttpCookie(request);
		SystemLog logDao = new SystemLog();
        logDao.setLogContent("导出了事业部的个人账户数据");
        logDao.setOperator(cookie.getOperatorId());
        logDao.setOperatorName(cookie.getOperatorName());
        logDao.setFromHost(request.getRemoteAddr());
        logDao.setLogTime(new Date());
        logDao.save();
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseEmployeeReportRecordDetail.ALL_CAPTIONS);
			for (BaseEmployeeReportRecordDetail b : result.getCollections()) {
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

	public BaseCollection<BaseEmployeeReportRecordDetail> findWithPermission(String creteria) throws Exception {
		BaseCollection<BaseEmployeeReportRecordDetail> result = new BaseCollection<>();
		// list存储所有需要返回到页面的数据
		List<BaseEmployeeReportRecordDetail> list = null;
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		String tempPlateIds = BaseHelpUtils.getString(params.get("plateId"));
		Map<String, Object> map = new HashMap<>();
		map.putAll(params);
		if (tempPlateIds.length() > 0) {
			Object[] arr = tempPlateIds.split(",");
			if (null != arr && arr.length > 0) {
				int length = arr.length;
				// 逐一查询每一个传过来的需要查询的部门的具体数据信息，然后把数据存入list中
				for (int i = 0; i < length; i++) {
					map.put("plateId", arr[i]);
					ConditionEmployeeReportRecordDetail c = new ConditionEmployeeReportRecordDetail();
					c.setDataFromMap(map);
					BaseCollection<BaseEmployeeReportRecordDetail> tempResult = executeQueryEmployeeReportRecordDetail(
							c, c.getKeyValues());
					if (i == 0) {
						list = tempResult.getCollections();
					} else {
						if (null != list) {
							List<BaseEmployeeReportRecordDetail> tempList = tempResult.getCollections();
							if (null != tempList && !tempList.isEmpty()) {
								list.addAll(tempList);
							}
						} else {
							list = tempResult.getCollections();
						}
					}
				}
			}
		} else {// 没有传业务部门Id过来，则只查看自己的数据
			ConditionEmployeeReportRecordDetail c = new ConditionEmployeeReportRecordDetail();
			map.remove("plateId");
			c.setDataFromMap(map);
			BaseCollection<BaseEmployeeReportRecordDetail> tempResult = executeQueryEmployeeReportRecordDetail(c,
					c.getKeyValues());
			list = tempResult.getCollections();
		}
		// 如果list中有数据存在，则从数据库中查出list列表中每个人的人工成本，并填充到list中
		if (null != list && !list.isEmpty()) {
			ConditionEmployeeReportRecordDetail c = new ConditionEmployeeReportRecordDetail();
			map.remove("plateId");
			c.setDataFromMap(map);
			SystemConfig config = new SystemConfig();
			config.setConditionSystemConfigId("=", 2);
			DES des = new DES(config.executeQueryOneRow().getImagePath());
			for (BaseEmployeeReportRecordDetail obj : list) {
				EmployeeSalaryDetail dao = new EmployeeSalaryDetail();
				dao.unsetSelectFlags();
				dao.setSelectBasicSalary(true);
				dao.setConditionEmployeeId("=", obj.getEmployeeId());
				dao.addCondition(BaseEmployeeSalaryDetail.CS_ENTRY_DATE, "between", c.getStartDate(), c.getEndDate());
				List<BaseEmployeeSalaryDetail> tempList = dao.conditionalLoad();
				if (null != tempList && !tempList.isEmpty()) {
					for (BaseEmployeeSalaryDetail salary : tempList) {
						obj.setSalary(obj.getSalary().add(new BigDecimal(des.DEC(salary.getBasicSalary()))));
					}
				}
			}
		}
		result.setCollections(list);
		return result;
	}
}
