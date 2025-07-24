package pomplatform.project.business;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectEmployee;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectEmployee;
import com.pomplatform.db.dao.ProjectLog;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import com.pomplatform.db.dao.SubContract;
import delicacy.common.BaseHelpUtils;
import delicacy.common.ColumnChangedData;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.servlet.HttpCookie;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import pomplatform.projectprice.ProjectPriceCalculation;

/**
 *
 * @author guanxgun
 */
public class ChangeIntegralProjectUpdate implements GenericProcessor {

	public static void main(String[] args) {
		try {
			ProjectUpdate pu = new ProjectUpdate();
			pu.execute("{\"projectType\":3,\"oldProjectDiscount\":0,\"commonArea\":\"3000\",\"logisticsArea\":0,\"percentage\":\"0\",\"contractCode\":\"J&A/SJ2016006\",\"projectCode\":\"J&A/SJ2016006-O\",\"projectName\":\"《西安高新NEWorld项目室内设计项目》\",\"projectManageId\":14,\"totalAmount\":20000,\"officeType\":6,\"projectId\":123,\"contractName\":\"《西安高新NEWorld项目室内设计合同》\",\"customerName\":\"西安海科重工 投资有限公司\",\"departmentId\":21,\"status\":0,\"projectIntegral\":\"75000\",\"departmentManagerId\":12,\"plateId\":3,\"totalIntegral\":\"75000\",\"reserveIntegral\":\"0\"}", null);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		ThreadConnection.beginTransaction();
		BaseProject bp = new BaseProject();
		bp.setDataFromJSON(creteria);
		HttpCookie hc = new HttpCookie(request);
		bp.setPlateId(hc.getPlateId());
//        bp.setPlateId(3);
		Project dao = new Project();
		dao.setPrimaryKeyFromBase(bp);
		if (dao.load()) {
			BaseProject errorReturnProjectInfo = dao.generateBase();
			ProjectPriceCalculation.calculateProjectPrice(bp);
			dao.setDataFromBase(bp);
			// 获取项目ID
			int projectId = BaseHelpUtils.getIntValue(bp.getProjectId());
			ColumnChangedData percentChangeDate = dao.getColumnChangedData(BaseProject.CS_PERCENTAGE);
			/**
			 * 因为核算比例的变动会引起项目积分和预留积分的变动，所以规定，以下的特殊情况作特殊处理
			 * ①假如该项目已经有结算的记录了，那么不允许修改该项目的核算比例
			 * ②该项目没有结算记录，但是已经将项目积分预分配到项目成员身上，这时候修改核算比例的话，
			 * 只要保证最后计算出来的"新的项目积分">="已分配到成员身上的积分总和" 就可以执行该修改操作，否则，不予以修改
			 */
			// 核算比例发生了变动
			if (null != percentChangeDate && !percentChangeDate.getOriginal().equals(percentChangeDate.getValue())) {
				// 根据项目ID获取该项目的结算记录条数
				ProjectSettlement projectSettlementDao = new ProjectSettlement();
				projectSettlementDao.setConditionProjectId("=", projectId);
				if (projectSettlementDao.countRows() > 0) {
					// 如果该项目已有结算记录，且本次修改了核算比例，则不执行更新操作，直接返回原始数据
					return errorReturnProjectInfo.toOneLineJSON(-1, "该项目已有结算记录，不能修改核算比例");
				}
				// 获取该项目所有成员的预分配积分记录
				ProjectEmployee projectEmployeeDao = new ProjectEmployee();
				projectEmployeeDao.setConditionProjectId("=", projectId);
				List<BaseProjectEmployee> baseProjectEmployeeList = projectEmployeeDao.conditionalLoad();
				// planIntegral存放目前该项目预分配给成员的积分总额
				BigDecimal planIntegral = BigDecimal.ZERO;
				if (null != baseProjectEmployeeList && !baseProjectEmployeeList.isEmpty()) {
					for (BaseProjectEmployee obj : baseProjectEmployeeList) {
						if (null != obj.getPlanIntegral()) {
							planIntegral = planIntegral.add(obj.getPlanIntegral());
						}
					}
				}
				// 核算比例发生变动，则重新修改项目积分和预留积分
				double percent = (dao.getPercentage() == null ? 0.0 : dao.getPercentage().doubleValue()) / 100.0;
				dao.setReserveIntegral(new BigDecimal(Math.round(BaseHelpUtils.getDoubleValue(dao.getTotalIntegral().subtract(dao.getComplaintIntegral())) * percent)));
				dao.setProjectIntegral(dao.getTotalIntegral().subtract(dao.getComplaintIntegral()).subtract(dao.getReserveIntegral()));
				if (dao.getProjectIntegral().compareTo(planIntegral) < 0) {// 特殊情况②
					return errorReturnProjectInfo.toOneLineJSON(-1, "保存失败：修改后的项目积分少于预分配给项目成员的积分总额");
				}
			}
			
			ColumnChangedData ccd = dao.getColumnChangedData(BaseProject.CS_PROJECT_MANAGE_ID);
			ColumnChangedData projectIntegralChange = dao.getColumnChangedData(BaseProject.CS_PROJECT_INTEGRAL);
			dao.update();
			//修改了专业负责人
			if (ccd != null) {
				ProjectEmployee pe = new ProjectEmployee();
				if (ccd.getOriginal() != null) {
					int tempEmployeeId = BaseHelpUtils.getIntValue(ccd.getOriginal());
					ProjectSettlementDetail detailDao = new ProjectSettlementDetail();
					detailDao.setConditionEmployeeId("=", tempEmployeeId);
					detailDao.setConditionProjectId("=", projectId);
					if(detailDao.countRows()==0){
						pe.setConditionProjectId("=", projectId);
						pe.setConditionEmployeeId("=", tempEmployeeId);
						pe.conditionalDelete();
					}
				}
				if (ccd.getValue() != null) {
					int tempEmployeeId = BaseHelpUtils.getIntValue(ccd.getValue());
					pe.clear();
					pe.setConditionProjectId("=", projectId);
					pe.setConditionEmployeeId("=", tempEmployeeId);
					if(BaseHelpUtils.isNullOrEmpty(pe.executeQueryOneRow())){
						pe.setProjectId(projectId);
						pe.setEmployeeId(tempEmployeeId);
						pe.setPlanStartDate(dao.getPlanStartDate());
						pe.setPlanEndDate(dao.getPlanEndDate());
						pe.setStatus(1);
						pe.save();
					}
				}
			}
			//项目积分修改的时候，相对应的变动项目阶段的积分
			if(null != projectIntegralChange){
				ProjectStage stageDao = new ProjectStage();
				BigDecimal projectIntegral = null == dao.getProjectIntegral() ? BigDecimal.ZERO : dao.getProjectIntegral();
				BigDecimal oneHundred = new BigDecimal(100);
				BigDecimal sum = BigDecimal.ZERO;//已经分配的项目积分总和
				stageDao.setConditionProjectId("=", projectId);
				List<BaseProjectStage> stageList = stageDao.conditionalLoad("order by "+BaseProjectStage.CS_PROJECT_STAGE_ID);
				if(null != stageList && !stageList.isEmpty()){
					int size = stageList.size();
					for (int i = 0; i < size; i++) {
						BaseProjectStage obj = stageList.get(i);
						stageDao.clear();
						stageDao.setConditionProjectStageId("=", obj.getProjectStageId());
						if(i == size - 1){
							stageDao.setProjectAmount(projectIntegral.subtract(sum));
						}else{
							BigDecimal percent = null == obj.getPercent() ? BigDecimal.ZERO: BaseHelpUtils.getBigDecimalValue(obj.getPercent());
							stageDao.setProjectAmount(
									percent.multiply(projectIntegral).divide(oneHundred, 2, BigDecimal.ROUND_DOWN));
							sum = sum.add(stageDao.getProjectAmount());
						}
						stageDao.conditionalUpdate();
					}
				}
			}
			ProjectLog pl = new ProjectLog();
			pl.setProjectId(dao.getProjectId());
			pl.setOperateId(hc.getOperatorId());
			pl.setOperateTime(new Date());
			pl.setLogType(0);
			pl.setDepartmentId(hc.getDepartmentId());
			pl.setManagerId(hc.getOperatorId());
			pl.setLogContent(String.format("%1$s修改了%2$s项目", hc.getOperatorName(), dao.getProjectName()));
			pl.save();
		}
		ThreadConnection.commit();
		return bp.toOneLineJSON(0, null);
	}

}
