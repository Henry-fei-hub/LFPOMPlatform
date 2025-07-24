package pomplatform.preProjects.business;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.*;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessInstance;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.CommonParams;

import com.mysql.fabric.xmlrpc.base.Array;
import com.pomplatform.db.bean.BaseArea;
import com.pomplatform.db.bean.BaseCustomer;
import com.pomplatform.db.bean.BaseCustomerContact;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BaseMainProjectBusinessType;
import com.pomplatform.db.bean.BaseMainProjectEmployee;
import com.pomplatform.db.bean.BaseMainProjectStage;
import com.pomplatform.db.bean.BasePoolManage;
import com.pomplatform.db.bean.BasePoolManageEmployee;
import com.pomplatform.db.bean.BasePreProject;
import com.pomplatform.db.bean.BasePreProjectTransferRecord;
import com.pomplatform.db.bean.BaseProductionValueCoefficient;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.Area;
import com.pomplatform.db.dao.Customer;
import com.pomplatform.db.dao.CustomerContact;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectBusinessType;
import com.pomplatform.db.dao.MainProjectCompetitionUnit;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.MainProjectSpecialty;
import com.pomplatform.db.dao.MainProjectStage;
import com.pomplatform.db.dao.PmSpecial;
import com.pomplatform.db.dao.PoolManage;
import com.pomplatform.db.dao.PoolManageEmployee;
import com.pomplatform.db.dao.PreProject;
import com.pomplatform.db.dao.PreProjectTransferRecord;
import com.pomplatform.db.dao.ProductionValueCoefficient;
import com.pomplatform.db.dao.ProductionValueCoefficientType;
import com.pomplatform.db.dao.ProjectStage;


import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.MapUtils;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.common.KeyValuePair;

import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.solr.SolrUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.Employee;
import delicacy.system.dao.SystemProcessInstance;
import delicacy.system.executor.SelectValueCache;
import pomplatform.poolmanage.bean.BaseOnloadPoolEmployeeData;
import pomplatform.preProjects.bean.*;
import pomplatform.preProjects.bean.BaseOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.BaseSearchMainProjectEmployeeData;
import pomplatform.preProjects.bean.ConditionOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.ConditionSearchMainProjectEmployeeData;
import pomplatform.preProjects.bean.BaseOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.BaseSearchMainProjectEmployeeData;
import pomplatform.preProjects.bean.BaseprojectPreInfomations;
import pomplatform.preProjects.bean.ConditionOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.bean.ConditionSearchMainProjectEmployeeData;
import pomplatform.preProjects.bean.ConditionprojectPreInfomations;
import pomplatform.preProjects.query.QueryOnloadPreprojectDataForMobile2;
import pomplatform.preProjects.query.QuerySearchMainProjectEmployeeData;
import pomplatform.preProjects.query.QueryprojectPreInfomations;

public class PreProjectProcess implements GenericProcessor {
	// 操作类型
	private static final String OPT_TYPE = "optType";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		@SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		// 获取操作类型
		String optType = BaseHelpUtils.getStringValue(params, OPT_TYPE);
		switch (optType) {
		case "loadDataForAddInfo":
			return loadDataForAddInfo(params);
		case "saveDataForAddInfo":
			return saveDataForAddInfo(params);
		case "getCityNames":
			return getCityNames(params);
		case "loadDataForUpdateInfo":
			return loadDataForUpdateInfo(params);
		case "checkSimilarPercent":
			return checkSimilarPercent(params);
		case "getCustomerInfo":
			return getCustomerInfo(params);
		case "transferProject":
			return transferProject(params);
		case "loadPreprojectDataForMobile":
			return loadPreprojectDataForMobile(params);
		case "saveOrUpdatePoolManage":
			return saveOrUpdatePoolManage(params);
		case "deletePoolManage":
			return deletePoolManage(params);
		case "calculateOutputValue":
			return calculateOutputValue(params);
		case "loadCustomerNameByParentId":
			return loadCustomerNameByParentId(params);
		case "loadparentCustomerNameById":
			return loadparentCustomerNameById(params);
		case "updatePreProject":
			return updatePreProject(params);
		default:
			return null;
		}
	}
	
	/**
	 *更新报备流程的数据
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String updatePreProject(Map<String, Object> params) throws Exception {
		ThreadConnection.beginTransaction();
		PreProject pp =new PreProject();
		BasePreProject bean =new BasePreProject();
		bean.setDataFromMap(params);
		if (BaseHelpUtils.getIntValue(params.get("clientId"))>0) {
			Customer customer = new Customer();
			customer.setConditionCustomerId("=",BaseHelpUtils.getIntValue(params.get("clientId")));
			customer.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if(customer.load()) {
				bean.setCustomerName(customer.getCustomerName());
				bean.setClientId(BaseHelpUtils.getIntValue(params.get("clientId")));
			}else {
				throw new SQLException("该客户不存在,请先到客户管理新增。");
			}
		}else {
			throw new SQLException("请选择正确的客户");
		}
		pp.setDataFromBase(bean);
		//获取业务类型数组ID
		String businessTypes = bean.getBusinessTypes();
		if(!BaseHelpUtils.isNullOrEmpty(businessTypes)&&!businessTypes.equals("[]")) {
			String[] businessCategoryIds =businessTypes.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\"", "").replaceAll(" ", "").split(",");
			if(!BaseHelpUtils.isNullOrEmpty(businessCategoryIds)){
				MainProjectBusinessType typedao = new MainProjectBusinessType();
				typedao.setConditionPreProjectId("=", bean.getPreProjectId());
				typedao.conditionalDelete();
				for (int i = 0 ; i<businessCategoryIds.length;i++){
					if(BaseHelpUtils.getIntValue(businessCategoryIds[i])>0) {
						typedao.clear();
						typedao.setBusinessType(BaseHelpUtils.getIntValue(businessCategoryIds[i]));
						typedao.setPreProjectId(bean.getPreProjectId());
						typedao.save();
					}
					
				}
			}
		}
		pp.update();
		ThreadConnection.commit();
		BaseCollection<BaseCustomer> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
	}
	
	/**
	 * 根据parentId 加载对应的customers 数据
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String loadparentCustomerNameById(Map<String, Object> params) throws Exception {
		int stauts = 0;
		int customerId = BaseHelpUtils.getIntValue(params.get("customerId"));
		Customer dao = new Customer();
		dao.setConditionCustomerId("=", customerId);
		List<BaseCustomer> list = dao.conditionalLoad();
		BaseCollection<BaseCustomer> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(stauts, null);
	}

	/**
	 * 根据parentId 加载对应的customers 数据
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String loadCustomerNameByParentId(Map<String, Object> params) throws Exception {
		int stauts = 0;
		int parentId = BaseHelpUtils.getIntValue(params.get("parentId"));
		Customer dao = new Customer();
		dao.setConditionParentId("=", parentId);
		List<BaseCustomer> list = dao.conditionalLoad();
		BaseCollection<BaseCustomer> bc = new BaseCollection<>();
		bc.setCollections(list);
		return bc.toJSON(stauts, null);
	}

	/**
	 * 池子数据 删除
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public String deletePoolManage(Map<String, Object> params) throws Exception {
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromMap(params);
		ThreadConnection.beginTransaction();
		PoolManage dao = new PoolManage();
		dao.setDataFromBase(bean);
		int poolManageId = BaseHelpUtils.getIntValue(bean.getPoolManageId());
		PoolManageEmployee peDao = new PoolManageEmployee();
		if (!BaseHelpUtils.isNullOrEmpty(poolManageId) && poolManageId > 0) {
			if (dao.load()) {
				dao.delete();
				// 清除成员表数据集
				peDao.setConditionPoolManageId("=", poolManageId);
				if (peDao.isExist()) {
					peDao.conditionalDelete();
				}
			}
		}
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
	}

	/**
	 * 池子管理保存
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String saveOrUpdatePoolManage(Map<String, Object> params) throws Exception {
		BasePoolManage bean = new BasePoolManage();
		bean.setDataFromMap(params);
		if (BaseHelpUtils.isNullOrEmpty(bean.getPoolName())) {
			throw new SQLException("池子名称不可为空");
		}
		if (BaseHelpUtils.isNullOrEmpty(bean.getPoolType())) {
			throw new SQLException("池子类型不可为空");
		}
		// 获取成员列表
		List<BaseOnloadPoolEmployeeData> empList = GenericBase.__getList(params.get("poolEmployeeList"),
				BaseOnloadPoolEmployeeData.newInstance());
		if (BaseHelpUtils.isNullOrEmpty(empList) || empList.size() == 0) {
			throw new SQLException("成员列表不可为空");
		}
		ThreadConnection.beginTransaction();
		PoolManage dao = new PoolManage();
		dao.setDataFromBase(bean);
		int poolManageId = BaseHelpUtils.getIntValue(bean.getPoolManageId());
		PoolManageEmployee peDao = new PoolManageEmployee();
		if (!BaseHelpUtils.isNullOrEmpty(poolManageId) && poolManageId > 0) {
			if (dao.load()) {
				dao.setDataFromBase(bean);
				dao.update();
				// 先清除成员表数据集
				peDao.setConditionPoolManageId("=", poolManageId);
				if (peDao.isExist()) {
					peDao.conditionalDelete();
				}
			}
		} else {
			dao.save();
			poolManageId = BaseHelpUtils.getIntValue(dao.getPoolManageId());
		}
		// 获取住建id
		BasePoolManageEmployee peBean = null;
		List<BasePoolManageEmployee> peList = new ArrayList<>();
		// 保存成员表数据集
		for (BaseOnloadPoolEmployeeData e : empList) {
			peBean = new BasePoolManageEmployee();
			peBean.setDataFromMap(e.toMap());
			peBean.setPoolManageId(poolManageId);
			peList.add(peBean);
		}
		peDao.save(peList);
		ThreadConnection.commit();
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, null);
	}

	/**
	 * 加载手机端立项的前期项目信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String loadPreprojectDataForMobile(Map<String, Object> params) throws SQLException {
		int preProjectId = BaseHelpUtils.getIntValue(params.get("preProjectId"));

		QueryOnloadPreprojectDataForMobile2 query = new QueryOnloadPreprojectDataForMobile2();
		ConditionOnloadPreprojectDataForMobile2 condition = new ConditionOnloadPreprojectDataForMobile2();
		condition.setPreProjectId(preProjectId);
		BaseCollection<BaseOnloadPreprojectDataForMobile2> data = query.executeQuery(null, condition);

		MainProjectEmployee mpeDao = new MainProjectEmployee();
		mpeDao.setConditionPreProjectId("=", preProjectId);
		List<BaseMainProjectEmployee> emList = mpeDao.conditionalLoad();
		String salePerson = "", saleLeader = "", projectManage = "", projectLeader = "";
		String employeeName = "";
		if (!BaseHelpUtils.isNullOrEmpty(emList) && emList.size() > 0) {
			for (BaseMainProjectEmployee e : emList) {
				employeeName = SelectValueCache.getSelectValue("employees", String.valueOf(e.getEmployeeId()));
				if (e.getRelation() == 1) {
					if (salePerson.length() > 0) {
						salePerson += ",";
					}
					salePerson += employeeName;
				} else if (e.getRelation() == 2) {
					if (saleLeader.length() > 0) {
						saleLeader += ",";
					}
					saleLeader += employeeName;
				} else if (e.getRelation() == 3) {
					if (projectManage.length() > 0) {
						projectManage += ",";
					}
					projectManage += employeeName;
				} else if (e.getRelation() == 4) {
					if (projectLeader.length() > 0) {
						projectLeader += ",";
					}
					projectLeader += employeeName;
				}
			}
		}
		List<BaseOnloadPreprojectDataForMobile2> result = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(data) && data.getCollections().size() > 0) {
			BaseOnloadPreprojectDataForMobile2 dataResult = data.getCollections().get(0);
			dataResult.setSalePerson(salePerson.length() > 0 ? salePerson : " ");
			dataResult.setSaleLeader(saleLeader.length() > 0 ? saleLeader : " ");
			dataResult.setProjectManage(projectManage.length() > 0 ? projectManage : " ");
			dataResult.setProjectLeader(projectLeader.length() > 0 ? projectLeader : " ");
			if (!BaseHelpUtils.isNullOrEmpty(dataResult.getBidRankingType())) {
				String str = "";
				String[] value = dataResult.getBidRankingType().split(",");
				for (String type : value) {
					if (str.length() > 0) {
						str += ",";
					}
					str += SelectValueCache.getSelectValue("system_dictionary_173", type);
				}
				dataResult.setBidRankingType(str);
			}
			result.add(dataResult);
		}
		BaseCollection<BaseOnloadPreprojectDataForMobile2> bc = new BaseCollection<>();
		bc.setCollections(result);
		return bc.toJSON(0, null);
	}

	/**
	 * 查看相似项目
	 * 
	 * @return
	 * @throws SQLException
	 */
	public String toCheckSimilarPrecent(Map<String, Object> params) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) params.get("preProjectData");
		return checkSimilarPercent(map);
	}

	/**
	 * 项目转单
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	private String transferProject(Map<String, Object> params) throws Exception {
		// 获取原报备人
		int employeeId = BaseHelpUtils.getIntValue(params.get("employeeId"));
		// 获取转交人
		int transferEmployeeId = BaseHelpUtils.getIntValue(params.get("transferEmployeeId"));
		// 往项目转接表中插入数据
		PreProjectTransferRecord ptdao = new PreProjectTransferRecord();
		BasePreProjectTransferRecord ptbean = new BasePreProjectTransferRecord();
		ptbean.setDataFromMap(params);
		ptbean.setOperateTime(new Date());
		ptdao.setDataFromBase(ptbean);
		ptdao.save();

		// 更改前期项目表的报备人
		PreProject dao = new PreProject();
		int preProjectId = BaseHelpUtils.getIntValue(params.get("preProjectId"));
		dao.setPreProjectId(preProjectId);
		if (dao.load()) {
			dao.setApplyEmployeeId(transferEmployeeId);
			dao.update();
		}

		// 更改项目的主要跟进人
		MainProjectEmployee medao = new MainProjectEmployee();
		medao.setConditionPreProjectId("=", preProjectId);
		medao.setConditionEmployeeId("=", employeeId);
		medao.setConditionRelation("=", 1);
		medao.setConditionMainAndAssistance("=", 1);
		medao.setEmployeeId(transferEmployeeId);
		medao.conditionalUpdate();

		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}

	/**
	 * 获取客户信息（是否已入库，是否有战略报价等）
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String getCustomerInfo(Map<String, Object> params) throws SQLException {
		Customer cdao = new Customer();
		Map<String, Object> result = new HashMap<>();
		int customerId = BaseHelpUtils.getIntValue(params.get("customerId"));
		cdao.setConditionCustomerId("=", customerId);
		BaseCustomer cbean = cdao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(cbean)) {
			result.put("customerType", cbean.getCustomerType());
			result.put("isWarehous", cbean.getIsWarehous());
			result.put("isApplyQuote", cbean.getIsApplyQuote());
		}
		result.put("infoCode", makeInfoCode());
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		bc.setUserData(result);
		return bc.toJSON(0, "");
	}

	/**
	 * 查看报备项目信息的相似度
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String checkSimilarPercent(Map<String, Object> params) throws Exception {
		BaseCollection<BasePreProject> bc = new BaseCollection<>();
		BigDecimal score = new BigDecimal("40");
//		List<BasePreProject> list = solrSearch(params, score, 1, 2);
		List<BasePreProject> list = new ArrayList<>();
		bc.setCollections(list);
		return bc.toJSON();
	}

	/**
	 * 
//	 * @param key
	 *            搜索关键字
	 * @param currentPage
	 *            当前页数
	 * @param pageSize
	 *            分页大小
	 * @return
	 * @throws Exception
	 */
	public List<BasePreProject> solrSearch(Map<String, Object> params, BigDecimal score, int currentPage, int pageSize)
			throws Exception {
		if (pageSize <= 0) {
			return null;
		}
		if (currentPage <= 0)
			currentPage = 1;
		String customerName = BaseHelpUtils.getString(params.get("customerName"));
		String projectName = BaseHelpUtils.getString(params.get("projectName"));
		String province = BaseHelpUtils.getString(params.get("province"));
		String city = BaseHelpUtils.getString(params.get("city"));
		String projectType = BaseHelpUtils.getString(params.get("projectType"));
		String contactName = BaseHelpUtils.getString(params.get("contactName"));
		String contactPhone = BaseHelpUtils.getString(params.get("contactPhone"));
		String infoCode = BaseHelpUtils.getString(params.get("infoCode"));
		SolrClient client = SolrUtils.getHttpSolrClient();
		int startIndex = (currentPage - 1) * pageSize;
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setStart(startIndex);
		solrQuery.setRows(pageSize);
		if (!BaseHelpUtils.isNullOrEmpty(infoCode)) {
			solrQuery.addFilterQuery("-infoCode:" + infoCode);
		}
		if (BaseHelpUtils.isNullOrEmpty(customerName) && BaseHelpUtils.isNullOrEmpty(projectName)
				&& BaseHelpUtils.isNullOrEmpty(province) && BaseHelpUtils.isNullOrEmpty(city)
				&& BaseHelpUtils.isNullOrEmpty(projectType) && BaseHelpUtils.isNullOrEmpty(contactName)
				&& BaseHelpUtils.isNullOrEmpty(contactPhone)) {
			return null;
		} else {
			StringBuilder sb = new StringBuilder();
			if (!BaseHelpUtils.isNullOrEmpty(customerName)) {
				sb.append("customerName:").append(customerName);
			}
			if (!BaseHelpUtils.isNullOrEmpty(projectName)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("projectName:").append(projectName);
			}
			if (!BaseHelpUtils.isNullOrEmpty(province)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("province:").append(province);
			}
			if (!BaseHelpUtils.isNullOrEmpty(city)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("city:").append(city);
			}
			if (!BaseHelpUtils.isNullOrEmpty(projectType)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("projectType:").append(projectType);
			}
			if (!BaseHelpUtils.isNullOrEmpty(contactName)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("contactName:").append(contactName);
			}
			if (!BaseHelpUtils.isNullOrEmpty(contactPhone)) {
				if (sb.length() > 0) {
					sb.append(" OR ");
				}
				sb.append("contactPhone:").append(contactPhone);
			}
			solrQuery.setQuery(sb.toString());
		}
		solrQuery.set("defType", "edismax");
		solrQuery.set("qf",
				"customerName^0.25 projectName^0.25 province^0.05 city^0.05 projectType^0.1 contactName^0.1 contactPhone^0.2");
		solrQuery.set(CommonParams.FL, "*,score");
		QueryResponse response = client.query(solrQuery);
		SolrDocument document = null;
		List<BasePreProject> list = new ArrayList<>();
		SolrDocumentList documents = response.getResults();
		for (int i = 0; i < documents.size(); i++) {
			document = documents.get(i);
			if (new BigDecimal(document.getFieldValue("score").toString()).compareTo(score) < 0) {
				break;
			}
			BasePreProject bean = generateBean(document);
			if (null != bean) {
				list.add(bean);
			}
		}
		return list;
	}

	public BasePreProject generateBean(SolrDocument doc) throws IOException {
		if (null == doc) {
			return null;
		}
		int preProjectId = BaseHelpUtils.getIntValue(doc.get("preProjectId"));
		if (preProjectId <= 0) {
			return null;
		}
		BasePreProject bean = new BasePreProject();
		bean.setPreProjectId(preProjectId);
		bean.setCustomerName(BaseHelpUtils.getString(doc.get("customerName")));
		bean.setProjectName(BaseHelpUtils.getString(doc.get("projectName")));
		bean.setProvince(BaseHelpUtils.getString(doc.get("province")));
		bean.setCity(BaseHelpUtils.getString(doc.get("city")));
//		bean.setProjectType(BaseHelpUtils.getString(doc.get("projectType")));
		bean.setContactName(BaseHelpUtils.getString(doc.get("contactName")));
		bean.setContactPhone(BaseHelpUtils.getString(doc.get("contactPhone")));
		bean.setInfoCode(BaseHelpUtils.getString(doc.get("infoCode")));
		bean.setRegion(BaseHelpUtils.getIntValue(doc.get("region")));
		bean.setDetailAddress(BaseHelpUtils.getString(doc.get("detailAddress")));
		bean.setGrade(BaseHelpUtils.getString(doc.get("grade")));
		bean.setTotalBuildingAreas(BaseHelpUtils.getBigDecimalValue(doc.get("totalBuildingAreas")));
		bean.setEstimateTheDesignAreas(BaseHelpUtils.getBigDecimalValue(doc.get("estimateTheDesignAreas")));
		bean.setProjectOrigination(BaseHelpUtils.getString(doc.get("projectOrigination")));
		bean.setIsOperationDepartment(BaseHelpUtils.getBoolean(doc.get("isOperationDepartment")));
		bean.setComparisonForm(BaseHelpUtils.getIntValue(doc.get("comparisonForm")));
		bean.setRemark(BaseHelpUtils.getString(doc.get("remark")));
		bean.setApplyEmployeeId(BaseHelpUtils.getIntValue(doc.get("applyEmployeeId")));
		bean.setCreateTime(new Date(BaseHelpUtils.getLongValue(doc.get("createTime"))));
		return bean;
	}

	/**
	 * 修改项目信息时加载已有的数据
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String loadDataForUpdateInfo(Map<String, Object> params) throws SQLException {
		int PreProjectId = BaseHelpUtils.getIntValue(params.get("preProjectId"));
		QuerySearchMainProjectEmployeeData query = new QuerySearchMainProjectEmployeeData();
		ConditionSearchMainProjectEmployeeData condition = new ConditionSearchMainProjectEmployeeData();
		condition.setPreProjectId(PreProjectId);
		BaseCollection<BaseSearchMainProjectEmployeeData> list = query.executeQuery(null, condition);
		if (!BaseHelpUtils.isNullOrEmpty(list)) {
			List<BaseSearchMainProjectEmployeeData> result = list.getCollections();
			int relation;
			List<BaseSearchMainProjectEmployeeData> salePerson = new ArrayList<>();
			List<BaseSearchMainProjectEmployeeData> saleLeader = new ArrayList<>();
			List<BaseSearchMainProjectEmployeeData> projectManage = new ArrayList<>();
			List<BaseSearchMainProjectEmployeeData> projectLeader = new ArrayList<>();
			for (BaseSearchMainProjectEmployeeData e : result) {
				relation = e.getRelation();
				if (relation == 1) {
					salePerson.add(e);
				} else if (relation == 2) {
					saleLeader.add(e);
				} else if (relation == 3) {
					projectManage.add(e);
				} else if (relation == 4) {
					projectLeader.add(e);
				}
			}
			Map<String, Object> map = new HashMap<>();
			map.put("salePerson", salePerson);
			map.put("saleLeader", saleLeader);
			map.put("projectManage", projectManage);
			map.put("projectLeader", projectLeader);

			BaseCollection<BaseEmployee> bc = new BaseCollection<>();
			bc.setUserData(map);

			// 加载职员信息
			Employee dao = new Employee();
			dao.setConditionEmployeeId(">", 0);
			dao.setConditionStatus("=", 0);
			dao.unsetSelectFlags();
			dao.setSelectEmployeeId(true);
			dao.setSelectEmployeeNo(true);
			dao.setSelectEmployeeName(true);
			dao.setSelectPlateId(true);
			List<BaseEmployee> emList = dao.conditionalLoad();
			bc.setCollections(emList);
			return bc.toJSON(0, "");
		} else {
			return null;
		}
	}

	/**
	 * 根据省份名称获取对应市
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String getCityNames(Map<String, Object> params) throws SQLException {
		BaseCollection<BaseArea> bc = new BaseCollection<>();
		Area adao = new Area();
		String province = BaseHelpUtils.getString(params.get("province"));
		adao.setConditionAllName("=", province);
		BaseArea abean = adao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(abean)) {
			Map<String, Object> map = new HashMap<>();
			map.put("region", abean.getRegion());
			bc.setUserData(map);
		}
		// 获取城市
		adao.clear();
		adao.setConditionAllName("=", province);
		adao.setConditionParentId("=", 0);
		abean = adao.executeQueryOneRow();
		if (!BaseHelpUtils.isNullOrEmpty(abean)) {
			int areaId = abean.getAreaId();
			adao.clear();
			adao.setConditionParentId("=", areaId);
			adao.unsetSelectFlags();
			adao.setSelectAllName(true);
			List<BaseArea> list = adao.conditionalLoad();
			if (!BaseHelpUtils.isNullOrEmpty(list) && list.size() > 0) {
				bc.setCollections(list);
				return bc.toJSON(0, null);
			}
		}
		return null;
	}

	/**
	 * 项目立项--保存pre_project项目信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String savaDataForBeProject(Map<String, Object> params) throws Exception {
		return saveDataForAddInfo(params);
	}

	/**
	 * 项目立项--保存main_project项目信息
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public void savaDataForMainProject(Map<String, Object> params) throws Exception {
		
		int mainProjectId = BaseHelpUtils.getIntValue(params.get("mainProjectId"));
		if(mainProjectId<=0){
			throw new SQLException("项目立项失败！");
		}
		
		MainProject dao =new MainProject();
		BaseMainProject pbean = new BaseMainProject();
		pbean.setMainProjectId(mainProjectId);
		
		// 业务类别
		List<Map<String, String>> businessTypeList = (List<Map<String, String>>) params.get("businessTypeReocrd");
		if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
			int businessTypeId = 0;
			String businessName = "";
//			BusinessCategory bdao = new BusinessCategory();
			ProductionValueCoefficientType bdao =new ProductionValueCoefficientType();
			for (Map<String, String> bt : businessTypeList) {
				businessTypeId = BaseHelpUtils.getIntValue(bt.get("businessType"));
				bdao.clear();
				bdao.setProductionValueCoefficientTypeId(businessTypeId);
				if (bdao.load()) {
					if (BaseHelpUtils.isNullOrEmpty(businessName)) {
						businessName = bdao.getCoefficientType();
					} else {
						businessName = businessName + "," + bdao.getCoefficientType();
					}
				}
			}
			pbean.setBusinessType(businessName);
		}
		// 专业
		List<Map<String, String>> specialtyList = (List<Map<String, String>>) params.get("specialtyReocrd");
		if (!BaseHelpUtils.isNullOrEmpty(specialtyList) && specialtyList.size() > 0) {
			int specialtyId = 0;
			String specialty = "";
			PmSpecial pmdao = new PmSpecial();
			for (Map<String, String> sp : specialtyList) {
				specialtyId = BaseHelpUtils.getIntValue(sp.get("specialtyId"));
				pmdao.clear();
				pmdao.setPmSpecialId(specialtyId);
				if (pmdao.load()) {
					if (BaseHelpUtils.isNullOrEmpty(specialty)) {
						specialty = pmdao.getSpecialName();
					} else {
						specialty = specialty + "," + pmdao.getSpecialName();
					}
				}
			}
			pbean.setSpecialty(specialty);
		}
		// 设置预估价格
		pbean.setEstimatePrice(BaseHelpUtils.getBigDecimalValue(params.get("contractAmount")));
		dao.setDataFromBase(pbean);
		dao.update();
		
		// 竞争单位
		List<Map<String, String>> competitionUnitList = (List<Map<String, String>>) params.get("competitionUnitRecord");
		if (!BaseHelpUtils.isNullOrEmpty(competitionUnitList) && competitionUnitList.size() > 0) {
			MainProjectCompetitionUnit pcdao = new MainProjectCompetitionUnit();
			if (mainProjectId > 0) {
				pcdao.setConditionMainProjectId("=", mainProjectId);
				pcdao.conditionalDelete();
			}
			for (Map<String, String> cp : competitionUnitList) {
				pcdao.clear();
				pcdao.setMainProjectId(mainProjectId);
				pcdao.setCompetitionUnitId(BaseHelpUtils.getIntValue(cp.get("competitionUnitId")));
				pcdao.setBiddingInformation(BaseHelpUtils.getString(cp.get("biddingInformation")));
				pcdao.save();
			}
		}

		List<BaseMainProjectEmployee> salePersonList = GenericBase.__getList(params.get("salePersonReocrd"),
				BaseMainProjectEmployee.newInstance());
		List<BaseEmployee> saleLeaderList = GenericBase.__getList(params.get("saleLeaderReocrd"),
				BaseEmployee.newInstance());
		List<BaseEmployee> projectManageList = GenericBase.__getList(params.get("projectManageReocrd"),
				BaseEmployee.newInstance());
		List<BaseMainProjectEmployee> projectLeaderList = GenericBase.__getList(params.get("projectLeaderReocrd"),
				BaseMainProjectEmployee.newInstance());
		List<BaseMainProjectEmployee> projectResponsibleList = GenericBase.__getList(params.get("projectResponsibleRecord"), BaseMainProjectEmployee.newInstance());

		MainProjectEmployee empDao = new MainProjectEmployee();
		MainProjectBusinessType mbdao = new MainProjectBusinessType();
		MainProjectSpecialty spdao = new MainProjectSpecialty();
		BaseMainProjectEmployee empBean = null;

		// 项目秘书
		List<BaseMainProjectEmployee> employeeList = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(salePersonList) && salePersonList.size() > 0) {
			for (BaseMainProjectEmployee a : salePersonList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(a.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(1);//项目秘书
				empBean.setMainAndAssistance(a.getMainAndAssistance());
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 运营董事
		if (!BaseHelpUtils.isNullOrEmpty(saleLeaderList) && saleLeaderList.size() > 0) {
			for (BaseEmployee b : saleLeaderList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(b.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(2);// 运营董事
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 项目经理
		if (!BaseHelpUtils.isNullOrEmpty(projectManageList) && projectManageList.size() > 0) {
			for (BaseEmployee c : projectManageList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(c.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(3);// 项目经理
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 项目主管领导
		if (!BaseHelpUtils.isNullOrEmpty(projectLeaderList) && projectLeaderList.size() > 0) {
			for (BaseMainProjectEmployee d : projectLeaderList) {
				Boolean isPlateManager = false;
				if (!BaseHelpUtils.isNullOrEmpty(d.getIsPlateManager())) {
					isPlateManager = d.getIsPlateManager();
				}
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(d.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(4);// 项目主管领导
				empBean.setIsPlateManager(isPlateManager);
				employeeList.add(empBean);
			}
		}
		// 项目负责人
		if (!BaseHelpUtils.isNullOrEmpty(projectResponsibleList) && projectResponsibleList.size() > 0) {
			for (BaseMainProjectEmployee e : projectResponsibleList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(e.getEmployeeId());
				empBean.setMainProjectId(mainProjectId);
				empBean.setRelation(5);// 项目负责人
				employeeList.add(empBean);
			}
		}

		if (employeeList.size() > 0 && mainProjectId > 0) {
			empDao.setConditionMainProjectId("=", mainProjectId);
			empDao.conditionalDelete();
			empDao.save(employeeList);
		}

		if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
			if (mainProjectId > 0) {
				mbdao.setConditionMainProjectId("=", mainProjectId);
				mbdao.setConditionOutQuotationId("=", 0);
				mbdao.conditionalDelete();
			}
			for (Map<String, String> btt : businessTypeList) {
				mbdao.clear();
				mbdao.setMainProjectId(mainProjectId);
				mbdao.setOutQuotationId(0);
				mbdao.setBusinessType(BaseHelpUtils.getIntValue(btt.get("businessType")));
				mbdao.setArea(BaseHelpUtils.getBigDecimalValue(btt.get("area")));
				mbdao.setOutputValue(BaseHelpUtils.getBigDecimalValue(btt.get("outputValue")));
				mbdao.save();
			}
		}

		if (!BaseHelpUtils.isNullOrEmpty(specialtyList) && specialtyList.size() > 0) {
			if (mainProjectId > 0) {
				spdao.setConditionMainProjectId("=", mainProjectId);
				spdao.conditionalDelete();
			}
			for (Map<String, String> spp : specialtyList) {
				spdao.clear();
				spdao.setMainProjectId(mainProjectId);
				spdao.setSpecialtyId(BaseHelpUtils.getIntValue(spp.get("specialtyId")));
				spdao.setRegistrationSealEmployeeId(BaseHelpUtils.getIntValue(spp.get("registrationSealEmployeeId")));
				spdao.setIsOutsourcing(BaseHelpUtils.getBoolean(spp.get("isOutsourcing")));
				spdao.save();
			}
		}

		// 阶段策划
		List<BaseProjectStage> detailProjectStageList = GenericBase.__getList(params.get("detailProjectStage"),
				BaseProjectStage.newInstance());
		if (!BaseHelpUtils.isNullOrEmpty(detailProjectStageList) && detailProjectStageList.size() > 0) {
			ProjectStage psDao = new ProjectStage();
			if (mainProjectId > 0) {
				psDao.setConditionMainProjectId("=", mainProjectId);
				psDao.conditionalDelete();
			}
			for (BaseProjectStage baseProjectStage : detailProjectStageList) {
				baseProjectStage.setMainProjectId(mainProjectId);
			}
			psDao.save(detailProjectStageList);
		}

	}

	/**
	 * 保存数据
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String saveDataForAddInfo(Map<String, Object> params) throws Exception {
		PreProject dao = new PreProject();
		BasePreProject bean = new BasePreProject();
		bean.setDataFromMap(params);
		bean.setInfoRegisterTime(new Date());

		// 如果在项目信息这边修改联系人，查询该联系人是否存在，不存在则添加
		String contactName = bean.getContactName();
		CustomerContact ccDao = new CustomerContact();
		ccDao.setConditionName("=", contactName);
		String contactPhone = bean.getContactPhone();
		List<BaseCustomerContact> cclist = ccDao
				.conditionalLoad(" (telephone ='" + contactPhone + "' or mobile = '" + contactPhone + "')");
		if (BaseHelpUtils.isNullOrEmpty(cclist) && cclist.size() == 0) {
			ccDao.setName(bean.getContactName());
			ccDao.setTelephone(contactPhone);
			ccDao.setGrade(bean.getGrade());// 职位
			ccDao.setCustomerId(BaseHelpUtils.getIntValue(params.get("clientId")));
			if (!BaseHelpUtils.isNullOrEmpty(params.get("applyEmployeeId"))) {
				ccDao.setOperateEmployeeId(BaseHelpUtils.getIntValue(params.get("applyEmployeeId")));
			} else {
				ccDao.setOperateEmployeeId(BaseHelpUtils.getIntValue(params.get("activityId")));
			}
			ccDao.save();
			bean.setCustomerContactId(ccDao.getCustomerContactId());
		}

		// 业务类别
		List<Map<String, String>> businessTypeList = (List<Map<String, String>>) params.get("businessTypeReocrd");
		if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
			int businessTypeId = 0;
			String businessName = "";
//			BusinessCategory bdao = new BusinessCategory();
			ProductionValueCoefficientType bdao =new ProductionValueCoefficientType();
			for (Map<String, String> bt : businessTypeList) {
				businessTypeId = BaseHelpUtils.getIntValue(bt.get("businessType"));
				bdao.clear();
				bdao.setProductionValueCoefficientTypeId(businessTypeId);
				if (bdao.load()) {
					if (BaseHelpUtils.isNullOrEmpty(businessName)) {
						businessName = bdao.getCoefficientType();
					} else {
						businessName = businessName + "," + bdao.getCoefficientType();
					}
				}
			}
			bean.setBusinessType(businessName);
		}
		// 专业
		List<Map<String, String>> specialtyList = (List<Map<String, String>>) params.get("specialtyReocrd");
		if (!BaseHelpUtils.isNullOrEmpty(specialtyList) && specialtyList.size() > 0) {
			int specialtyId = 0;
			String specialty = "";
			PmSpecial pmdao = new PmSpecial();
			for (Map<String, String> sp : specialtyList) {
				specialtyId = BaseHelpUtils.getIntValue(sp.get("specialtyId"));
				pmdao.clear();
				pmdao.setPmSpecialId(specialtyId);
				if (pmdao.load()) {
					if (BaseHelpUtils.isNullOrEmpty(specialty)) {
						specialty = pmdao.getSpecialName();
					} else {
						specialty = specialty + "," + pmdao.getSpecialName();
					}
				}
			}
			bean.setSpecialty(specialty);
		}
		// 设置预估价格
		bean.setEstimatePrice(BaseHelpUtils.getBigDecimalValue(params.get("contractAmount")));
		dao.setDataFromBase(bean);
		int PreProjectId = BaseHelpUtils.getIntValue(params.get("preProjectId"));
		if (PreProjectId > 0) {
			dao.update();
		} else {
			dao.save();
			PreProjectId = dao.getPreProjectId();
		}

		// 竞争单位
		List<Map<String, String>> competitionUnitList = (List<Map<String, String>>) params.get("competitionUnitRecord");
		if (!BaseHelpUtils.isNullOrEmpty(competitionUnitList) && competitionUnitList.size() > 0) {
			MainProjectCompetitionUnit pcdao = new MainProjectCompetitionUnit();
			if (PreProjectId > 0) {
				pcdao.setConditionPreProjectId("=", PreProjectId);
				pcdao.conditionalDelete();
			}
			for (Map<String, String> cp : competitionUnitList) {
				pcdao.clear();
				pcdao.setPreProjectId(PreProjectId);
				pcdao.setCompetitionUnitId(BaseHelpUtils.getIntValue(cp.get("competitionUnitId")));
				pcdao.setBiddingInformation(BaseHelpUtils.getString(cp.get("biddingInformation")));
				pcdao.save();
			}
		}

		List<BaseMainProjectEmployee> salePersonList = GenericBase.__getList(params.get("salePersonReocrd"),
				BaseMainProjectEmployee.newInstance());
		List<BaseEmployee> saleLeaderList = GenericBase.__getList(params.get("saleLeaderReocrd"),
				BaseEmployee.newInstance());
		List<BaseEmployee> projectManageList = GenericBase.__getList(params.get("projectManageReocrd"),
				BaseEmployee.newInstance());
		List<BaseMainProjectEmployee> projectLeaderList = GenericBase.__getList(params.get("projectLeaderReocrd"),
				BaseMainProjectEmployee.newInstance());
		List<BaseMainProjectEmployee> projectResponsibleList = GenericBase
				.__getList(params.get("projectResponsibleRecord"), BaseMainProjectEmployee.newInstance());

		MainProjectEmployee empDao = new MainProjectEmployee();
		MainProjectBusinessType mbdao = new MainProjectBusinessType();
		MainProjectSpecialty spdao = new MainProjectSpecialty();
		BaseMainProjectEmployee empBean = null;

		// 项目营销专员
		List<BaseMainProjectEmployee> employeeList = new ArrayList<>();
		if (!BaseHelpUtils.isNullOrEmpty(salePersonList) && salePersonList.size() > 0) {
			for (BaseMainProjectEmployee a : salePersonList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(a.getEmployeeId());
				empBean.setPreProjectId(PreProjectId);
				empBean.setRelation(1);// 项目营销专员
				empBean.setMainAndAssistance(a.getMainAndAssistance());
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 运营董事
		if (!BaseHelpUtils.isNullOrEmpty(saleLeaderList) && saleLeaderList.size() > 0) {
			for (BaseEmployee b : saleLeaderList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(b.getEmployeeId());
				empBean.setPreProjectId(PreProjectId);
				empBean.setRelation(2);// 运营董事
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 项目经理
		if (!BaseHelpUtils.isNullOrEmpty(projectManageList) && projectManageList.size() > 0) {
			for (BaseEmployee c : projectManageList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(c.getEmployeeId());
				empBean.setPreProjectId(PreProjectId);
				empBean.setRelation(3);// 项目经理
				empBean.setIsPlateManager(false);
				employeeList.add(empBean);
			}
		}
		// 项目主管领导
		if (!BaseHelpUtils.isNullOrEmpty(projectLeaderList) && projectLeaderList.size() > 0) {
			for (BaseMainProjectEmployee d : projectLeaderList) {
				Boolean isPlateManager = false;
				if (!BaseHelpUtils.isNullOrEmpty(d.getIsPlateManager())) {
					isPlateManager = d.getIsPlateManager();
				}
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(d.getEmployeeId());
				empBean.setPreProjectId(PreProjectId);
				empBean.setRelation(4);// 项目主管领导
				empBean.setIsPlateManager(isPlateManager);
				employeeList.add(empBean);
			}
		}
		// 项目负责人
		if (!BaseHelpUtils.isNullOrEmpty(projectResponsibleList) && projectResponsibleList.size() > 0) {
			for (BaseMainProjectEmployee e : projectResponsibleList) {
				empBean = new BaseMainProjectEmployee();
				empBean.setEmployeeId(e.getEmployeeId());
				empBean.setPreProjectId(PreProjectId);
				empBean.setRelation(5);// 项目负责人
				employeeList.add(empBean);
			}
		}

		if (employeeList.size() > 0 && PreProjectId > 0) {
			empDao.setConditionPreProjectId("=", PreProjectId);
			empDao.conditionalDelete();
			empDao.save(employeeList);
		}

		if (!BaseHelpUtils.isNullOrEmpty(businessTypeList) && businessTypeList.size() > 0) {
			if (PreProjectId > 0) {
				mbdao.setConditionPreProjectId("=", PreProjectId);
				mbdao.conditionalDelete();
			}
			for (Map<String, String> btt : businessTypeList) {
				mbdao.clear();
				mbdao.setPreProjectId(PreProjectId);
				mbdao.setBusinessType(BaseHelpUtils.getIntValue(btt.get("businessType")));
				mbdao.setArea(BaseHelpUtils.getBigDecimalValue(btt.get("area")));
				mbdao.setOutputValue(BaseHelpUtils.getBigDecimalValue(btt.get("outputValue")));
				mbdao.save();
			}
		}

		if (!BaseHelpUtils.isNullOrEmpty(specialtyList) && specialtyList.size() > 0) {
			if (PreProjectId > 0) {
				spdao.setConditionPreProjectId("=", PreProjectId);
				spdao.conditionalDelete();
			}
			for (Map<String, String> spp : specialtyList) {
				spdao.clear();
				spdao.setPreProjectId(PreProjectId);
				spdao.setSpecialtyId(BaseHelpUtils.getIntValue(spp.get("specialtyId")));
				spdao.setRegistrationSealEmployeeId(BaseHelpUtils.getIntValue(spp.get("registrationSealEmployeeId")));
				spdao.setIsOutsourcing(BaseHelpUtils.getBoolean(spp.get("isOutsourcing")));
				spdao.save();
			}
		}

		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(PreProjectId, null);
	}

	/**
	 * 加载基本数据及计算信息编号
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	private String loadDataForAddInfo(Map<String, Object> params) throws SQLException {
		// 加载职员信息
		Employee dao = new Employee();
		dao.setConditionEmployeeId(">", 0);
		int loadType = BaseHelpUtils.getIntValue(params.get("loadType"));
		if (loadType == 1) {
			dao.setConditionStatus("=", 0);
		}
		//需要加载出离职的人员
//		dao.setConditionStatus("=", 0);
		dao.unsetSelectFlags();
		dao.setSelectEmployeeId(true);
		dao.setSelectEmployeeNo(true);
		dao.setSelectEmployeeName(true);
		dao.setSelectPlateId(true);
		List<BaseEmployee> emList = dao.conditionalLoad();
		BaseCollection<BaseEmployee> bc = new BaseCollection<>();
		bc.setCollections(emList);

		Map<String, String> map = new HashMap<>();
		String code = makeInfoCode();
		map.put("infoCode", code);
		bc.setUserData(map);
		return bc.toJSON(0, "");
	}

	/**
	 * 计算项目信息编号
	 * 
	 * @return
	 * @throws SQLException
	 */
	private String makeInfoCode() throws SQLException {
		// 计算前期项目信息编号
		PreProject pdao = new PreProject();
		Calendar cal = Calendar.getInstance();
		Date currentDate = new Date();
		cal.setTime(currentDate);
		String year = BaseHelpUtils.getString(cal.get(Calendar.YEAR));
		// String month = BaseHelpUtils.getString(cal.get(Calendar.MONTH)+1);
		// if(month.length() == 1){
		// month = "0" + month;
		// }
		String str = year + "-";
		String newCode = "";
		int lastNum = 0;
		List<BasePreProject> pList = pdao.conditionalLoad(" info_code like '" + str + "%' order BY info_code DESC");
		if (!BaseHelpUtils.isNullOrEmpty(pList) && pList.size() > 0) {
			for (BasePreProject basePreProject : pList) {
				String lastCode = basePreProject.getInfoCode();
				// String lastCode = "2019-001";
				if (!BaseHelpUtils.isNullOrEmpty(lastCode)) {
					int num = BaseHelpUtils.getIntValue(lastCode.substring(5, 8));
					num += 1;
					String numStr = BaseHelpUtils.getString(num);
					if (numStr.length() == 1) {
						numStr = "00" + numStr;
					} else if (numStr.length() == 2) {
						numStr = "0" + numStr;
					}
					newCode = str + numStr;
					break;
				}
			}
		} else {
			newCode = str + "001";
		}
		System.out.println("newCode===========" + newCode);
		return newCode;
	}


	public static void main(String[] args) throws SQLException {
		PreProjectProcess a = new PreProjectProcess();
		a.makeInfoCode();
	}


	/**
	 * 通过面积和业务类别计算项目的产值
	 * 
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String calculateOutputValue(Map<String, Object> params) throws SQLException {
		BaseCollection<BaseMainProjectBusinessType> bc = new BaseCollection<>();
		int businessType = BaseHelpUtils.getIntValue(params.get("businessType"));
		if (businessType == 0) {
			return bc.toJSON(-1, "业务类别为空");
		}
		BigDecimal area = BaseHelpUtils.getBigDecimalValue(params.get("area")).setScale(2, BigDecimal.ROUND_HALF_UP);
		/*if (area.compareTo(BigDecimal.ZERO) == 0) {
			return bc.toJSON(-1, "面积为空或者为0");
		}*/
		ProductionValueCoefficient pvcDao = new ProductionValueCoefficient();
		pvcDao.setConditionProductionValueCoefficientTypeId("=", businessType);
		List<BaseProductionValueCoefficient> list = pvcDao
				.conditionalLoad("order by " + BaseProductionValueCoefficient.CS_PRODUCTION_MIN + " desc");
		if (null == list || list.isEmpty()) {
			return bc.toJSON(-1, "该业务类别没有设置系数");
		}
		int size = list.size();
		BigDecimal min = null;
		boolean calculateAll = false;// 是否不做判断，直接计算本区间的全额度
		BigDecimal outputValue = BigDecimal.ZERO;
		int lastOneIndex = size - 1;
		for (int i = 0; i < size; i++) {
			BaseProductionValueCoefficient obj = list.get(i);
			if (null == obj.getCoefficient()) {
				return bc.toJSON(-1, String.format("业务类别的区间额度【%1$s】没有设置系数", obj.getIntervalRange()));
			}
			min = obj.getProductionMin();
			if (min.compareTo(BigDecimal.ZERO) == 0 && i < lastOneIndex) {
				// 还不是最后一条记录，最小值就已经是0了，直接返回错误
				return bc.toJSON(-1, "该业务类别的系数设置有问题");
			}
			if (calculateAll) {
				outputValue = outputValue.add((obj.getIntervalLines().multiply(obj.getCoefficient())));
			} else {
				if (null == obj.getProductionMax()) {
					if (area.compareTo(min) <= 0) {
						continue;
					}
					calculateAll = true;
					outputValue = area.subtract(obj.getProductionMin()).multiply(obj.getCoefficient());
				} else {
					if (area.compareTo(obj.getProductionMax()) > 0) {
						return bc.toJSON(-1, String.format("面积超过本业务类别的最大值%1$s，无法计算出产值", obj.getProductionMax()));
					} else {
						if (area.compareTo(min) <= 0) {
							continue;
						}
						calculateAll = true;
						outputValue = area.subtract(obj.getProductionMin()).multiply(obj.getCoefficient());
					}
				}
			}
		}
		BaseMainProjectBusinessType bean = new BaseMainProjectBusinessType();
		bean.setBusinessType(businessType);
		bean.setArea(area);
		bean.setOutputValue(outputValue.multiply(new BigDecimal("10")).setScale(2, BigDecimal.ROUND_HALF_UP));
		List<BaseMainProjectBusinessType> returnList = new ArrayList<>();
		returnList.add(bean);
		bc.setCollections(returnList);
		return bc.toJSON();
	}


	public PreProjectProcess() {
		super();
	}

//	public static void main(String[] args) throws SQLException {
//
//		Map<String,Integer> map = new HashMap<>();
//
//		MainProjectStage mdao = new MainProjectStage();
//		List<BaseMainProjectStage> conditionalLoad = mdao.conditionalLoad();
//		for (BaseMainProjectStage baseMainProjectStage : conditionalLoad) {
//			map.put(baseMainProjectStage.getMainStageName(), baseMainProjectStage.getMainStageId());
//
//		}
//
//
//		ProjectStage dao = new ProjectStage();
//		List<BaseProjectStage> conditionalLoad2 = dao.conditionalLoad(" stage_id isnull ");
//		if(conditionalLoad2.size()>0) {
//			for (BaseProjectStage baseProjectStage : conditionalLoad2) {
//				Integer stageId = map.get(baseProjectStage.getStageName());
//				baseProjectStage.setStageId(stageId);
//				dao.clear();
//				dao.setDataFromBase(baseProjectStage);
//				dao.update();
//			}
//		}
//	}
	
	
	
	
	
}
