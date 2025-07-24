package pomplatform.workflow.contractstatus.utils;

import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;

import com.pomplatform.db.dao.Contract;
import com.pomplatform.db.dao.ContractLog;
import com.pomplatform.db.dao.Project;

import pomplatform.common.utils.StaticUtils;

public class ContractStatusUtils {
	
	public static final String NO_RESULT_MSG = "以下合同自立项至今仍未出结果，请及时跟进：";
	public static final String LOSING_BID_MSG = "以下合同处于未出结果状态已超过6个月，请确定是否强制落标并给予落标补贴：";
	
	public Integer getProectStatusByContractStatus(Integer contractStatus) {
		if(null == contractStatus)
			return null;
		switch(contractStatus) {
		case StaticUtils.CONTRACT_STATUS_1:
			return StaticUtils.PROJECT_STATUS_18;
		case StaticUtils.CONTRACT_STATUS_2:
			return StaticUtils.PROJECT_STATUS_13;
		case StaticUtils.CONTRACT_STATUS_4:
		case StaticUtils.CONTRACT_STATUS_9:
			return StaticUtils.PROJECT_STATUS_16;
		case StaticUtils.CONTRACT_STATUS_5:
		case StaticUtils.CONTRACT_STATUS_8:
			return StaticUtils.PROJECT_STATUS_10;
		case StaticUtils.CONTRACT_STATUS_6:
			return StaticUtils.PROJECT_STATUS_2;
		case StaticUtils.CONTRACT_STATUS_7:
			return StaticUtils.PROJECT_STATUS_17;
		case StaticUtils.CONTRACT_STATUS_10:
		case StaticUtils.CONTRACT_STATUS_13:
			return StaticUtils.PROJECT_STATUS_14;
		case StaticUtils.CONTRACT_STATUS_11:
		case StaticUtils.CONTRACT_STATUS_14:
			return StaticUtils.PROJECT_STATUS_15;
		case StaticUtils.CONTRACT_STATUS_12:
			return StaticUtils.PROJECT_STATUS_11;
		default:
			return null;
		}
	}
	
	/**
	 * 根据合同ID修改该合同的合同状态，同时将其下的订单也都修改成相对应的订单状态
	 * @param contractId
	 * @param contractStatus
	 * @throws SQLException
	 */
	public void updateContractAndProjectStatus(Integer contractId, Integer contractStatus) throws SQLException{
		if(null == contractId || null == contractStatus) {
			return;
		}
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if(!cDao.load()) {
			throw new SQLException("合同不存在");
		}
		cDao.setContractStatus(contractStatus);
		cDao.update();
		Integer projectStatus = getProectStatusByContractStatus(contractStatus);
		if(null == projectStatus) {
			return;
		}
		Project pDao = new Project();
		pDao.setConditionContractId("=", contractId);
		if(Objects.equals(contractStatus, StaticUtils.CONTRACT_STATUS_6)) {
			//合同状态变为合同运行，订单如果处于未启动状态，则不改变该订单的状态
			pDao.setConditionStatus("<>", StaticUtils.PROJECT_STATUS_4);
		}
		pDao.setStatus(projectStatus);
		pDao.conditionalUpdate();
	}
	
	/**
	 * 根据合同ID修改该合同的合同状态，并将其下的订单也都修改成相对应的订单状态，同时记录下合同状态的变更记录
	 * @param contractId
	 * @param contractStatus
	 * @throws SQLException
	 */
	public void updateContractAndProjectStatusWithLog(Integer contractId, Integer contractStatus, Integer operator, String content) throws SQLException{
		if(null == contractId || null == contractStatus) {
			return;
		}
		Contract cDao = new Contract();
		cDao.setContractId(contractId);
		if(!cDao.load()) {
			throw new SQLException("合同不存在");
		}
		if(null != cDao.getContractStatus() && cDao.getContractStatus().equals(contractStatus)) {
			//合同状态未改变
			return;
		}
		ContractLog clDao = new ContractLog();
		clDao.setContractId(contractId);
		clDao.setOriginalStatus(cDao.getContractStatus());
		clDao.setNewStatus(contractStatus);
		clDao.setContent(content);
		clDao.setOperator(operator);
		clDao.setOperateTime(new Date());
		clDao.save();
		cDao.setContractStatus(contractStatus);
		cDao.update();
		Integer projectStatus = getProectStatusByContractStatus(contractStatus);
		if(null == projectStatus) {
			return;
		}
		Project pDao = new Project();
		pDao.setConditionContractId("=", contractId);
		if(Objects.equals(contractStatus, StaticUtils.CONTRACT_STATUS_6)) {
			//合同状态变为合同运行，订单如果处于未启动状态，则不改变该订单的状态
			pDao.setConditionStatus("<>", StaticUtils.PROJECT_STATUS_4);
		}
		pDao.setStatus(projectStatus);
		pDao.conditionalUpdate();
	}
	
	/**
	 * 根据合同ID及其合同状态，将其下所有订单都修改成相对应的订单状态，同时记录下合同状态的变更记录
	 * @param contractId
	 * @param originalContractStatus
	 * @param newContractStatus
	 * @param operator
	 * @param content
	 * @throws SQLException
	 */
	public void updateProjectStatusWithLog(Integer contractId, Integer originalContractStatus, Integer newContractStatus, Integer operator, String content) throws SQLException{
		if(null == contractId || null == newContractStatus) {
			return;
		}
		ContractLog clDao = new ContractLog();
		clDao.setContractId(contractId);
		clDao.setOriginalStatus(originalContractStatus);
		clDao.setNewStatus(newContractStatus);
		clDao.setContent(content);
		clDao.setOperator(operator);
		clDao.setOperateTime(new Date());
		clDao.save();
		Integer projectStatus = getProectStatusByContractStatus(newContractStatus);
		if(null == projectStatus) {
			return;
		}
		Project pDao = new Project();
		pDao.setConditionContractId("=", contractId);
		if(Objects.equals(newContractStatus, StaticUtils.CONTRACT_STATUS_6)) {
			//合同状态变为合同运行，订单如果处于未启动状态，则不改变该订单的状态
			pDao.setConditionStatus("<>", StaticUtils.PROJECT_STATUS_4);
		}
		pDao.setStatus(projectStatus);
		pDao.conditionalUpdate();
	}
}
