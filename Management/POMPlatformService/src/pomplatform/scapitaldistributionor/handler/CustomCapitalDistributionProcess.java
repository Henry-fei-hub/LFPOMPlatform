package pomplatform.scapitaldistributionor.handler;

import java.io.File;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCapital;
import com.pomplatform.db.bean.BaseContract;
import com.pomplatform.db.bean.BaseMainProject;
import com.pomplatform.db.bean.BasePlateRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.dao.Capital;
import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.MainProject;
import com.pomplatform.db.dao.MainProjectEmployee;
import com.pomplatform.db.dao.PlateRecord;
import com.pomplatform.db.dao.Project;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.domain.bean.BaseSemployeepdror;
import pomplatform.getEmployeeIdByRoleId.bean.BasegetEmployeeIdByRoleId;
import pomplatform.getEmployeeIdByRoleId.bean.ConditiongetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.getEmployeeIdByRoleId.query.QuerygetEmployeeIdByRoleIdWithoutPlateRecord;
import pomplatform.sprocessbilllistpppor.handler.CustomSprocessbilllistppporProcess;

public class CustomCapitalDistributionProcess implements GenericProcessor, GenericDownloadProcessor {

	@SuppressWarnings("unused")
	private static final Logger __logger = Logger.getLogger(CustomSprocessbilllistppporProcess.class);

	private final static String GET_CAPITALS_BY_CONTRACT_ID = "getCapitalsByContractId";// 根据合同主键获取合同的回款

	private final static String GET_CONTRACT_INFO_BY_ID = "getContractInfoById";// 根据合同主键获取合同信息

	private final static String GET_PLATES_BY_CONTRACT_ID = "getPlatesByContractId";// 根据合同主键获取相关的业务部门

	private final static String GET_CAPITAL_INFO_BY_ID = "getCapitalInfoById";// 根据资金ID获取资金信息

	private final static String GET_PROJECT_BY_CONTRACT_ID = "getProjectByContractId";// 根据合同主键获取相关的project信息

	private final static String GET_RELEVANT_PERSONNEL_BY_CONTRACT_ID = "getRelevantPersonnelByContractId";// 根据合同主键获取相关的人员信息
	
	//0 未处于流程  1：审批中 2：审批完成
	public static final int CAPITAL_PROCESS_STATUS_ZERO = 0;
	public static final int CAPITAL_PROCESS_STATUS_ONE = 1;
	public static final int CAPITAL_PROCESS_STATUS_TWO = 2;

	@SuppressWarnings("unchecked")
	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		Map<String, Object> result = null;
		if (!BaseHelpUtils.isNullOrEmpty(creteria)) {
			@SuppressWarnings("rawtypes")
			JSON parser = new JSON(new StringReader(creteria));
			result = (Map<String, Object>) parser.parse(new BasicHandler());
		}
		String optType = BaseHelpUtils.getStringValue(result, "opt_type");
		if (!BaseHelpUtils.isNullOrEmpty(result) && !BaseHelpUtils.isNullOrEmpty(optType)) {
			switch (optType) {
			case GET_PLATES_BY_CONTRACT_ID:
				return getPlatesByContractId(result);
			case GET_CONTRACT_INFO_BY_ID:
				return getContractInfoById(result);
			case GET_CAPITALS_BY_CONTRACT_ID:
				return getCapitalsByContractId(result);
			case GET_CAPITAL_INFO_BY_ID:
				return getCapitalInfoById(result);
			case GET_PROJECT_BY_CONTRACT_ID:
				return getProjectByContractId(result);
			case GET_RELEVANT_PERSONNEL_BY_CONTRACT_ID:
				return getRelevantPersonnelByContractId(result);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: passDoCapitalProcess 
	 * @Description: 回款通过审核
	 * @param @param capitalId
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public static void passDoCapitalProcess(int capitalId) throws SQLException{
		Capital dao = new Capital();
		dao.setCapitalId(capitalId);
		if(dao.load()){
			dao.setProcessStatus(CAPITAL_PROCESS_STATUS_TWO);
			dao.update();
		}
	}
	
	/**
	 * 
	 * @Title: doCapitalsProcess 
	 * @Description: 将回款数据改成流程进行中
	 * @param @param capitalDistributionId
	 * @param @param capitalId
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public static void doCapitalProcess(int capitalDistributionId, int capitalId) throws SQLException{
		Capital dao = new Capital();
		if(capitalId > 0){
			dao.setCapitalId(capitalId);
			if(dao.load()){
				dao.setCapitalDistributionId(capitalDistributionId);
				dao.setProcessStatus(CAPITAL_PROCESS_STATUS_ONE);
				dao.update();
			}
		}
	}
	
	/**
	 * 
	 * @Title: updateDoCapitalProcess 
	 * @Description: 更改流程中的回款选择
	 * @param @param capitalDistributionId
	 * @param @param capitalId
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public static void updateDoCapitalProcess(int capitalDistributionId, int capitalId) throws SQLException{
		//如果流程中的回款金额选择没有改变 则不进行更改  
			//如果改变 则将原有的回款 重置  将现有的回款改为进行中
		Capital dao = new Capital();
		dao.setConditionCapitalDistributionId("=", capitalDistributionId);
		BaseCapital bean = dao.executeQueryOneRow();
		if(null != bean){
			if(!Objects.equals(capitalId, dao.getCapitalId())){
				//重置原有
				dao.setProcessStatus(CAPITAL_PROCESS_STATUS_ZERO);
				dao.setCapitalDistributionId(null);
				dao.update();
				dao.clear();
				dao.setCapitalId(capitalId);
				if(dao.load()){
					dao.setProcessStatus(CAPITAL_PROCESS_STATUS_ONE);
					dao.setCapitalDistributionId(capitalDistributionId);
					dao.update();
				}
			}
		}
	}
	
	/**
	 * 
	 * @Title: unDoCapitalProcess 
	 * @Description: 删除回款申请时将回款数据状态重置
	 * @param @param capitalDistributionId
	 * @param @param capitalId
	 * @param @throws SQLException   
	 * @return void   
	 * @throws
	 */
	public static void unDoCapitalProcess(int capitalId) throws SQLException{
		Capital dao = new Capital();
		dao.setCapitalId(capitalId);
		if(dao.load()){
			dao.setProcessStatus(CAPITAL_PROCESS_STATUS_ZERO);
			dao.setCapitalDistributionId(null);
			dao.update();
		}
	}

	/**
	 * 
	 * @Title: getRelevantPersonnelByContractId 
	 * @Description: 根据合同主键获取相关人员信息
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getRelevantPersonnelByContractId(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMessage = null;
		BaseCollection<BaseEmployee> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
		int plateId = BaseHelpUtils.getIntValue(params, "plateId");
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if (cDao.load() && !BaseHelpUtils.isNullOrEmpty(cDao.getContractCode())) {
			List<BaseProject> pList = getProjectListByContractCodeOrContractId(null, cDao.getContractCode());
			if (pList.size() > 0) {
				Set<Integer> ownerSet = new HashSet<>();

				Integer manageId = null;// 大项目经理ID
				String infoCode = cDao.getInfoCode();
				MainProject mpDao = new MainProject();
				mpDao.setConditionInfoCode("=", infoCode);
				BaseMainProject pBean = mpDao.executeQueryOneRow();
				if (null != pBean) {// 可能有项目经理
					MainProjectEmployee mpeDao = new MainProjectEmployee();
					mpeDao.setConditionMainProjectId("=", pBean.getMainProjectId());
					mpeDao.setConditionRelation("=", 3);
					mpeDao.executeQueryOneRow();
					manageId = mpeDao.getEmployeeId();
				}
				if (null == manageId) {// 没有大项目经理 找主专业经理
					for (BaseProject baseProject : pList) {
						if (Objects.equals(baseProject.getPlateId(), plateId)) {
							manageId = baseProject.getProjectManageId();
							break;
						}
					}
				}
				if (null != manageId) {
					ownerSet.add(manageId);
				}
				if (pList.size() > 0) {
					Set<Integer> plateIds = new HashSet<>();
					// 找出所有项目的项目经理且不包含大项目经理
					for (BaseProject baseProject : pList) {
						if (!Objects.equals(baseProject.getProjectManageId(), manageId)) {
							if (null != baseProject.getProjectManageId()) {
								ownerSet.add(baseProject.getProjectManageId());
							}
						}
						plateIds.add(baseProject.getPlateId());
					}
					// 所有回款确认专员
					for (Integer integer : plateIds) {
						if(null != integer){
							ConditiongetEmployeeIdByRoleIdWithoutPlateRecord condition = new ConditiongetEmployeeIdByRoleIdWithoutPlateRecord();
							condition.setPlateId(integer);
							condition.setRoleId(StaticUtils.ROLE_CAPITAL_CONFIRM_MANAGER);
							QuerygetEmployeeIdByRoleIdWithoutPlateRecord query = new QuerygetEmployeeIdByRoleIdWithoutPlateRecord();
							BaseCollection<BasegetEmployeeIdByRoleId> __bc = query.executeQuery(null, condition);
							if (null != __bc && null != __bc.getCollections()) {
								for (BasegetEmployeeIdByRoleId obj : __bc.getCollections()) {
									if (null != obj.getEmployeeId()) {
										ownerSet.add(obj.getEmployeeId());
									}
								}
							}
						}
					}

					if (!ownerSet.isEmpty()) {
						Employee e = new Employee();
						e.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
						e.addCondition(BaseEmployee.CS_EMPLOYEE_ID, "in", ownerSet.toArray());
						List<BaseEmployee> employeeList = e.conditionalLoad();
						for (BaseEmployee baseEmployee : employeeList) {
							if(null != manageId && Objects.equals(manageId, baseEmployee.getEmployeeId())){
								baseEmployee.setRoleId(StaticUtils.ROLE_CAPITAL_DISTRIBUTION_MANAGER);
							} else {
								baseEmployee.setRoleId(StaticUtils.ROLE_CAPITAL_CONFIRM_MANAGER);
							}
						}
						bc.setCollections(employeeList);
					}
				}
			} else {
				status = -1;
				errorMessage = "没有找到该合同或者没有合同编号 contractId = " + contractId;
			}
		}
		return bc.toJSON(status, errorMessage);
	}

	/**
	 * 
	 * @Title: getProjectByContractId 
	 * @Description: 根据合同所有相关的人员信息
	 * @param @param params
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	private String getProjectByContractId(Map<String, Object> params) throws Exception {
		int status = 1;
		String errorMessage = null;
		BaseCollection<BaseProject> bc = new BaseCollection<>();
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if (cDao.load() && !BaseHelpUtils.isNullOrEmpty(cDao.getContractCode())) {
			List<BaseProject> pList = getProjectListByContractCodeOrContractId(null, cDao.getContractCode());
			if(pList.size() > 0){
				bc.setCollections(pList);
			}else {
				status = -1;
				errorMessage = "没有找到订单 contractId = " + contractId;
			}
			
		} else {
			status = -1;
			errorMessage = "没有找到该合同或者没有合同编号 contractId = " + contractId;
		}
		return bc.toJSON(status, errorMessage);
	}

	/**
	 * 
	 * @Title: getCapitalInfoById @Description: 根据资金ID获取资金信息 @param @param
	 *         params @param @return @param @throws Exception @return
	 *         String @throws
	 */
	private String getCapitalInfoById(Map<String, Object> params) throws Exception {
		BaseCollection<BaseCapital> bc = new BaseCollection<>();
		int status = 1;
		String errorMessage = null;
		Capital dao = new Capital();
		dao.setConditionCapitalId("=", BaseHelpUtils.getIntValue(params, "capitalId"));
		List<BaseCapital> list = dao.conditionalLoad();
		if (list.size() > 0) {
			bc.setCollections(list);
		} else {
			status = -1;
			errorMessage = "没有找到资金信息";
		}

		return bc.toJSON(status, errorMessage);

	}

	/**
	 * 
	 * @Title: getCapitalsByContractId @Description: 根据合同主键获取合同的回款 @param @param
	 *         params @param @return @param @throws Exception @return
	 *         String @throws
	 */
	private String getCapitalsByContractId(Map<String, Object> params) throws Exception {
		BaseCollection<BaseSemployeepdror> bc = new BaseCollection<>();
		int status = 1;
		String errorMessage = null;
		Capital dao = new Capital();
		dao.setConditionContractId("=", BaseHelpUtils.getIntValue(params, "contractId"));
		dao.setConditionProcessStatus("=", BaseHelpUtils.getIntValue(params, "processStatus"));
		List<BaseCapital> list = dao.conditionalLoad();
		List<BaseSemployeepdror> dataList = new ArrayList<>();
		for (BaseCapital baseCapital : list) {
			BaseSemployeepdror tmpBean = new BaseSemployeepdror();
			StringBuilder sb = new StringBuilder();
			tmpBean.setIdd(baseCapital.getCapitalId());
			sb.append(baseCapital.getOtherName()).append("-").append(baseCapital.getBorrowMoney()).append("-")
					.append(baseCapital.getRemark());
			String valStr = sb.toString();
			valStr = valStr.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\r\n", "");
			tmpBean.setVal(valStr);
			dataList.add(tmpBean);
		}
		bc.setCollections(dataList);
		return bc.toJSON(status, errorMessage);
	}

	/**
	 * 
	 * @Title: getContractInfoById @Description: 根据合同主键获取合同信息 @param @param
	 *         params @param @return @param @throws Exception @return
	 *         String @throws
	 */
	private String getContractInfoById(Map<String, Object> params) throws Exception {
		BaseCollection<BaseContract> bc = new BaseCollection<>();
		int status = 1;
		String errorMessage = null;
		Contract dao = new Contract();
		dao.setConditionContractId("=", BaseHelpUtils.getIntValue(params, "contractId"));
		bc.setCollections(dao.conditionalLoad());
		return bc.toJSON(status, errorMessage);
	}

	
	/**
	 * 
	 * @Title: getPlatesByContractId @Description: 根据合同主键获取相关的业务部门 @param @param
	 *         params @param @return @param @throws Exception @return
	 *         String @throws
	 */
	private String getPlatesByContractId(Map<String, Object> params) throws Exception {
		BaseCollection<BaseSemployeepdror> bc = new BaseCollection<>();
		int status = 1;
		String errorMessage = null;
		Contract cDao = new Contract();
		int contractId = BaseHelpUtils.getIntValue(params, "contractId");
		cDao.setContractId(contractId);
		if (cDao.load() && !BaseHelpUtils.isNullOrEmpty(cDao.getContractCode())) {
			List<BaseProject> pList = getProjectListByContractCodeOrContractId(null, cDao.getContractCode());
			if (pList.size() > 0) {
				if (pList.size() > 0) {
					Object[] oArra = new Object[pList.size()];
					PlateRecord prDao = new PlateRecord();

					for (int i = 0; i < pList.size(); i++) {
						oArra[i] = pList.get(i).getPlateId();
					}
					prDao.addCondition(BasePlateRecord.CS_PLATE_RECORD_ID, "in", oArra);
					List<BasePlateRecord> prList = prDao.conditionalLoad();
					List<BaseSemployeepdror> dataList = new ArrayList<>();
					for (BasePlateRecord basePlateRecord : prList) {
						BaseSemployeepdror tmpBean = new BaseSemployeepdror();
						tmpBean.setIdd(basePlateRecord.getPlateId());
						tmpBean.setVal(basePlateRecord.getPlateName());
						dataList.add(tmpBean);
					}
					bc.setCollections(dataList);
				} else {
					status = -1;
				}

			} else {
				status = -1;
			}
			// String code = cDao.getContractCode();
			// Project pDao = new Project();
			// pDao.setConditionContractCode("like", "%" + code + "%");
			// List<BaseProject> list = pDao.conditionalLoad();
			//
			// if(list.size() > 0){
			// Object [] oArra = new Object[list.size()];
			// PlateRecord prDao = new PlateRecord();
			//
			// for (int i = 0; i < list.size(); i++) {
			// oArra [i] = list.get(i).getPlateId();
			// }
			// prDao.addCondition(BasePlateRecord.CS_PLATE_RECORD_ID, "in",
			// oArra);
			// List<BasePlateRecord> prList = prDao.conditionalLoad();
			// List<BaseSemployeepdror> dataList = new ArrayList<>();
			// for (BasePlateRecord basePlateRecord : prList) {
			// BaseSemployeepdror tmpBean = new BaseSemployeepdror();
			// tmpBean.setIdd(basePlateRecord.getPlateId());
			// tmpBean.setVal(basePlateRecord.getPlateName());
			// dataList.add(tmpBean);
			// }
			// bc.setCollections(dataList);
			// } else {
			// status = -1;
			// }

		} else {
			status = -1;
			errorMessage = "没有找到该合同 或合同编号为空 contractID = " + contractId;
		}

		return bc.toJSON(status, errorMessage);
	}
	
	/**
	 * 
	 * @Title: getProjectListByContractCodeOrContractId 
	 * @Description: 获取合同下的项目信息 project
	 * @param @param contractId
	 * @param @param contractCode
	 * @param @return
	 * @param @throws SQLException   
	 * @return List<BaseProject>   
	 * @throws
	 */
	public static List<BaseProject> getProjectListByContractCodeOrContractId(Integer contractId, String contractCode) throws SQLException{
		Project pDao = new Project();
		List<BaseProject> list = new ArrayList<>();
		if( null == contractId){
			pDao.setConditionContractCode("like", "%" + contractCode + "%");
			list = pDao.conditionalLoad();
			for (int i = 0; i < list.size(); i++) {
				if(contractCode.indexOf("(") == -1 && contractCode.indexOf(")") == -1){ //证明该合同是为主合同 需要去除补充合同
					String subContractCode = list.get(i).getContractCode();
					if (subContractCode.indexOf("(") != -1 || subContractCode.indexOf(")") != -1) {
						list.remove(i);
						i --;
					}
				}
			}
		} else {
			pDao.setConditionContractId("=", contractId);
			list = pDao.conditionalLoad();
		}
		return list;
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public String getDownloadFileExtension() {
		// TODO Auto-generated method stub
		return null;
	}

}
