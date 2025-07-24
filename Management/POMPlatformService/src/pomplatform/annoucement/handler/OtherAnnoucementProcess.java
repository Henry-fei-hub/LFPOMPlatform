package pomplatform.annoucement.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseAnnoucement;
import com.pomplatform.db.dao.Annoucement;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.ERPWeixinUtils;

public class OtherAnnoucementProcess implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";
	// 发起确认函
	private static final String FIND_ANNOUCEMENT = "findAnnoucement";
	// 发布确认函
	private static final String PUBLISH_ANNOUCEMENT = "publishAnnoucement";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {

		case FIND_ANNOUCEMENT:
			return findAnnoucement(params);
		case PUBLISH_ANNOUCEMENT:
			return publishAnnoucement(params);

		default:
			return null;
		}
	}

	public String findAnnoucement(Map params) throws SQLException {
		List<BaseAnnoucement> list = null;
		Annoucement dao = new Annoucement();
		if (!BaseHelpUtils.isNullOrEmpty(params.get("annoucementTitle"))) {
			dao.setConditionAnnoucementTitle("like", "%" + params.get("annoucementTitle").toString() + "%");
		}
		if (!BaseHelpUtils.isNullOrEmpty(params.get("annoucementContent"))) {
			dao.setConditionAnnoucementContent("like", "%" + params.get("annoucementContent").toString() + "%");
		}
		if (!BaseHelpUtils.isNullOrEmpty(params.get("annoucementTime"))) {
			// dao.setConditionAnnoucementTime("=", params.get("annoucementTime"));
		}
		if (!BaseHelpUtils.isNullOrEmpty(params.get("operateEmployeeId"))) {
			dao.setConditionOperateEmployeeId("=", BaseHelpUtils.getIntValue(params.get("operateEmployeeId")));
		}
		if (!BaseHelpUtils.isNullOrEmpty(params.get("remark"))) {
			dao.setConditionRemark("like", "%" + params.get("remark").toString() + "%");
		}
		list = dao.conditionalLoad();
		List<BaseAnnoucement> resultList = new ArrayList<BaseAnnoucement>();
		if (!BaseHelpUtils.isNullOrEmpty(params.get("selfEmployeeId"))) {
			for (BaseAnnoucement baseAnnoucement : list) {
				if (!BaseHelpUtils.isNullOrEmpty(baseAnnoucement.getAnnoucementEmployeeIds())) {
					String arr[] = baseAnnoucement.getAnnoucementEmployeeIds().split(",");
					for (String string : arr) {
						if (string.equals(params.get("selfEmployeeId").toString())) {
							resultList.add(baseAnnoucement);
							break;
						}
					}
				}
			}
		}
		BaseCollection<BaseAnnoucement> bc = new BaseCollection<>();
		if (!BaseHelpUtils.isNullOrEmpty(resultList)) {
			bc.setCollections(resultList);
		}
		return bc.toJSON(0, null);
	}


	/**
	 * 发布公告
	 * 
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	public String publishAnnoucement(Map param) throws Exception {
		String employeeIds = BaseHelpUtils.getString(param.get("annoucementEmployeeIds"));
		int annoucementId = BaseHelpUtils.getIntValue(param.get("annoucementId"));
		String annoucementContent = BaseHelpUtils.getString(param.get("annoucementContent"));
		Annoucement dao = new Annoucement();
		dao.setConditionAnnoucementId("=", annoucementId);
		dao.setStatus(2);
		dao.conditionalUpdate();
		if (!BaseHelpUtils.isNullOrEmpty(employeeIds)) {
			String  companyWeixin=  getCompanyWeixin(employeeIds);
			if (!BaseHelpUtils.isNullOrEmpty(companyWeixin)&&!BaseHelpUtils.isNullOrEmpty(annoucementContent)) {
				ERPWeixinUtils.sendTextMsgToUser(companyWeixin,annoucementContent);
			}
			
		}
		BaseCollection<BaseAnnoucement> bc = new BaseCollection<>();
		return bc.toJSON(0, null);

	}
	
	/**
	 * 根据员工ids获取员工的企业微信
	 * 
	 * @param employeeId
	 * @param eList
	 * @return
	 * @throws SQLException
	 */
	public String getCompanyWeixin(String employeeIds) throws SQLException {

		Employee dao = new Employee();
		BaseEmployee bean = null;
		if (BaseHelpUtils.isNullOrEmpty(employeeIds)) {
			return null;
		}
		List<BaseEmployee> eList = dao.conditionalLoad(" employee_id in(" + employeeIds + ")");
		String companyWeixin = "";
		for (int i = 0; i < eList.size(); i++) {
			bean = eList.get(i);
			if (i == eList.size() - 1) {
				if (!BaseHelpUtils.isNullOrEmpty(bean.getCompanyWeixin())) {
					companyWeixin = companyWeixin + bean.getCompanyWeixin();
				}
				
			} else {
				if (!BaseHelpUtils.isNullOrEmpty(bean.getCompanyWeixin())) {
					companyWeixin = companyWeixin + bean.getCompanyWeixin() + "|";
				}
				
			}
		}
		return companyWeixin;
	}


}
