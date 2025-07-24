package pomplatform.projectstageauditinfo.handler;

import java.io.StringReader;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pomplatform.db.bean.BaseEmployeeAccountRecord;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.bean.BasePlateProjectAccountRecord;
import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseProjectSettlement;
import com.pomplatform.db.bean.BaseProjectSettlementDetail;
import com.pomplatform.db.bean.BaseProjectStage;
import com.pomplatform.db.dao.EmployeeAccountRecord;
import com.pomplatform.db.dao.PersonnelBusines;
import com.pomplatform.db.dao.PlateAccountRecord;
import com.pomplatform.db.dao.PlateProjectAccountRecord;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.ProjectAttachment;
import com.pomplatform.db.dao.ProjectCost;
import com.pomplatform.db.dao.ProjectLinkAttachmentRecord;
import com.pomplatform.db.dao.ProjectSettlement;
import com.pomplatform.db.dao.ProjectSettlementDetail;
import com.pomplatform.db.dao.ProjectStage;
import delicacy.system.dao.SystemProcessInstanceActivity;
import delicacy.system.dao.SystemProcessPooledTask;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseSystemProcessInstance;
import delicacy.system.dao.SystemProcessAttention;
import delicacy.system.dao.SystemProcessInstance;
import pomplatform.common.utils.StaticUtils;

public class AboutProjectStageAudit implements GenericProcessor{
	//操作类型
	private static final String OPT_TYPE = "optType";
	//保存或删除付款序列
	private static final String LODA_DATA = "lodaData";
	//序列收款方类型
	private static final String  CHECK_DATA = "checkDate";
	//删除结算记录
	private static final String  DEL_STE_DATA = "delSetData";
	//修改项目结算日期
	private static final String  UPDATE_SET_DATA ="updateSetData";

	@Override
	public String execute(String creteria, HttpServletRequest request) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> param = (Map<String, Object>) parser.parse(new BasicHandler());
		//获取操作类型
		String optType = BaseHelpUtils.getStringValue(param,OPT_TYPE);
		if(LODA_DATA.equals(optType)){
			return lodaData(param);
		}else if(CHECK_DATA.equals(optType)){
			return CheckData(param);
		}else if(DEL_STE_DATA.equals(optType)){
			return delSetData(param);
		}else if(UPDATE_SET_DATA.equals(optType)) {
			return updateSetData(param);
		}
		return null;
	}

	public String lodaData(Map<String,Object> params) throws SQLException {
		BaseCollection bc = new BaseCollection<>();
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		//当前阶段
		int currentStageId=BaseHelpUtils.getIntValue(params.get("stageId"));

		//下一个阶段
		Integer nextStageId = null;	
		String contractCode="";
		String projectName="";
		int plateId=0;
		int projectManageId=0;		
		Project prDao=new Project();
		prDao.setProjectId(projectId);
		if(prDao.load()) {
			BaseProject prbean=prDao.generateBase();
			contractCode=prbean.getContractCode();
			projectName=prbean.getProjectName();
			plateId=prbean.getPlateId();
			projectManageId=prbean.getProjectManageId();
		}
		ProjectStage  psDao=new ProjectStage();
		psDao.setConditionProjectId("=", projectId);
		psDao.setConditionStageId("=", currentStageId);
		BaseProjectStage bean=psDao.executeQueryOneRow();
		//获取主键
		int projectStageId=BaseHelpUtils.getIntValue(bean.getProjectStageId());
		psDao.clear();
		psDao.setConditionProjectId("=", projectId);
		psDao.setConditionProjectStageId(">", projectStageId);
		List<BaseProjectStage> pslist=psDao.conditionalLoad("ORDER BY project_stage_id");
		if(!BaseHelpUtils.isNullOrEmpty(pslist) && pslist.size() > 0) {
			nextStageId=BaseHelpUtils.getIntValue(pslist.get(0).getStageId());//下一个阶段阶段
		}
		Map<String,Object>  map=new HashMap<>();
		map.put("contractCode", contractCode);//订单编号
		map.put("projectName", projectName);//订单名称
		map.put("plateId", plateId);//业务部门
		map.put("projectManageId", projectManageId);//专业负责人
		map.put("nextStageId", nextStageId);//下个阶段
		bc.setUserData(map);
		return bc.toJSON(0,"");
	}

	public String CheckData(Map<String,Object> params) throws SQLException {
		BaseCollection bc = new BaseCollection<>();
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		int currentStageId=BaseHelpUtils.getIntValue(params.get("stageId"));
		PersonnelBusines  dao=new PersonnelBusines();
		boolean isCompleted=false;
		dao.setConditionProjectId("=", projectId);
		dao.setConditionStageId("=", currentStageId);
		if(dao.countRows()<=0) {
			return bc.toJSON(0,"");
		}else {
			BasePersonnelBusines  bean=dao.generateBase();
			isCompleted=bean.getIsCompleted();
			if(isCompleted==true) {
				return bc.toJSON(-1,"确认函已申请或者正在申请中");
			}
		}
		return bc.toJSON(0,"");
	}

	/**
	 * 修改项目结算日期
	 * @param params
	 * @return
	 * @throws SQLException
	 * @throws ParseException 
	 */
	public String updateSetData(Map<String,Object> params) throws SQLException, ParseException {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		int settlementId=BaseHelpUtils.getIntValue(params.get("settlementId"));
		//获取结算日期
		Date settlementDate=new Date(BaseHelpUtils.getLongValue(params.get("settlementDate")));
		if(projectId <= 0) {
			throw new SQLException("操作异常：获取项目编码失败");
		}

		if(settlementId <= 0) {
			throw new SQLException("操作异常：获取结算总表编码失败");
		}

		if(BaseHelpUtils.isNullOrEmpty(settlementDate)) {
			throw new SQLException("操作异常：获取修改的结算日期失败");
		}

		ThreadConnection.beginTransaction();


		ProjectSettlement psDao = new ProjectSettlement();
		psDao.setSettlementId(settlementId);
		if(!psDao.load()) {
			throw new SQLException("操作异常：加载结算总表数据失败");
		}
		BaseProjectSettlement psBean = psDao.generateBase();

		int flag=BaseHelpUtils.getIntValue(psBean.getFlag());
		if(flag==1) {
			throw new SQLException("操作异常：当前结算记录为历史数据，不支持此操作");
		}

		//更新总表数据
		psDao.setSettlementDate(settlementDate);
		psDao.update();

		ProjectSettlementDetail  psdDao=new ProjectSettlementDetail();
		psdDao.setConditionProjectId("=", projectId);
		psdDao.setConditionSettlementId("=", settlementId);
		List<BaseProjectSettlementDetail> pdlist=psdDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(pdlist)&&pdlist.size()>0){
			//更新个人账户表
			EmployeeAccountRecord eaDao=new EmployeeAccountRecord();
			Integer[] edarr=new Integer[2];
			edarr[0]=1;
			edarr[1]=7;
			for (BaseProjectSettlementDetail baseProjectSettlementDetail : pdlist) {
				int businessId=BaseHelpUtils.getIntValue(baseProjectSettlementDetail.getSettlementDetailId());
				eaDao.clear();
				eaDao.setConditionBusinessId("=", businessId);
				eaDao.addCondition(BaseEmployeeAccountRecord.CS_BUSINESS_TYPE_ID, "in", edarr);
				if(eaDao.isExist()) {
					eaDao.setRecordDate(settlementDate);
					eaDao.conditionalUpdate();
				}
			}
			//更新项目结算明细表
			psdDao.setSettlementDate(settlementDate);
			psdDao.conditionalUpdate();
		}

		//项目部门结算表
		PlateProjectAccountRecord ppaDao=new PlateProjectAccountRecord();
		ppaDao.setConditionSettlementId("=", settlementId);
		ppaDao.setConditionProjectId("=",projectId);

		//部门账户表
		PlateAccountRecord  parDao=new PlateAccountRecord();
		List<BasePlateProjectAccountRecord>  ppaList=ppaDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(ppaList)&&ppaList.size()>0) {
			for (BasePlateProjectAccountRecord basePlateProjectAccountRecord : ppaList) {
				int plateProjectAccountRecordId=BaseHelpUtils.getIntValue(basePlateProjectAccountRecord.getPlateProjectAccountRecordId());
				parDao.clear();
				//更新部门账户表
				parDao.setConditionBusinessId("=", plateProjectAccountRecordId);
				parDao.setConditionBusinessTypeId("=",1);
				parDao.setRecordDate(settlementDate);
				parDao.conditionalUpdate();
			}
			//更新项目部门结算表
			ppaDao.setAccountDate(settlementDate);;
			ppaDao.conditionalUpdate();
		}
		ThreadConnection.commit();
		return bc.toJSON(0,"");
	}


	/**
	 * 删除结算记录
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public String delSetData(Map<String,Object> params) throws SQLException {
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		int projectId=BaseHelpUtils.getIntValue(params.get("projectId"));
		int settlementId=BaseHelpUtils.getIntValue(params.get("settlementId"));
		ThreadConnection.beginTransaction();
		if(projectId <= 0) {
			throw new SQLException("操作异常：获取项目编码失败");
		}
		if(settlementId <= 0) {
			throw new SQLException("操作异常：获取结算总表编码失败");
		}

		//先获取当前这次结算归属哪个阶段
		ProjectSettlement psDao = new ProjectSettlement();
		psDao.setSettlementId(settlementId);
		if(!psDao.load()) {
			throw new SQLException("操作异常：加载结算总表数据失败");
		}
		BaseProjectSettlement psBean = psDao.generateBase();

		int flag=BaseHelpUtils.getIntValue(psBean.getFlag());
		if(flag==1) {
			throw new SQLException("操作异常：当前结算记录为历史数据，不支持此操作");
		}
		//获取结算状态
		int settlementStatus = BaseHelpUtils.getIntValue(psBean.getSettlementStatus());
		if(settlementStatus != 2) {
			throw new SQLException("操作异常：这次结算不可进行次操作");
		}
		//获取阶段ID
		int stageId = BaseHelpUtils.getIntValue(psBean.getStageId());

		//获取项目处于哪一个结算阶段，即取该项目最后一次结算所处的阶段
		Integer currentStageId = null;

		psDao.clear();
		psDao.setConditionProjectId("=",projectId);
		List<BaseProjectSettlement> psList = psDao.conditionalLoad("order by settlement_id desc");
		if(!BaseHelpUtils.isNullOrEmpty(psList) && psList.size() > 0) {
			currentStageId = BaseHelpUtils.getIntValue(psList.get(0).getStageId());
		}
		if(BaseHelpUtils.isNullOrEmpty(currentStageId)) {
			throw new SQLException("操作异常：获取该项目目前所处阶段失败");
		}
		//如果这一次结算所属的阶段和项目目前所处阶段不一致，则说明这个阶段已结算完毕，不可进行次操作
		if(stageId != currentStageId) {
			throw new SQLException("操作异常：这一次结算所属阶段已完成，不可进行次操作");
		}
		ThreadConnection.beginTransaction();
		//先判断这个阶段是否有上传确认函，如果有上传确认函，则删除确认函
		ProjectAttachment paDao = new ProjectAttachment();
		paDao.setConditionProjectId("=",projectId);
		paDao.setConditionStageId("=",stageId);
		if(paDao.isExist()) {//如果存在，则说明已上传确认函，需删除确认函表数据
			//删除流程关联表数据
			PersonnelBusines pbDao = new PersonnelBusines();
			pbDao.setConditionProjectId("=",projectId);
			pbDao.setConditionStageId("=",stageId);
			pbDao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_51);
			List<BasePersonnelBusines> pbList = pbDao.conditionalLoad();
			if(!BaseHelpUtils.isNullOrEmpty(pbList) && pbList.size() > 0) {
				//流程实例
				SystemProcessInstance spiDao = new SystemProcessInstance();
				//流程审批表
				SystemProcessInstanceActivity spiaDao = new SystemProcessInstanceActivity();
				//流程知会表
				SystemProcessAttention spaDao = new SystemProcessAttention();
				//流程任务池表
				SystemProcessPooledTask spptDao = new SystemProcessPooledTask();
				for(BasePersonnelBusines e : pbList) {
					//获取业务ID
					int businessId = BaseHelpUtils.getIntValue(e.getPersonnelBusinessId());
					spiDao.clear();
					spiDao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_51);
					spiDao.setConditionBusinessId("=",businessId);
					if(!BaseHelpUtils.isNullOrEmpty(spiDao)) {
						BaseSystemProcessInstance spiBean = spiDao.executeQueryOneRow();
						//获取流程实例ID
						int processInstanceId = BaseHelpUtils.getIntValue(spiBean.getProcessInstanceId());
						//删除审批表数据
						spiaDao.clear();
						spiaDao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_51);
						spiaDao.setConditionProcessInstanceId("=",processInstanceId);
						spiaDao.conditionalDelete();

						//删除知会表数据
						spaDao.clear();
						spaDao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_51);
						spaDao.setConditionProcessInstanceId("=",processInstanceId);
						spaDao.conditionalDelete();

						//删除任务池表数据
						spptDao.clear();
						spptDao.setConditionProcessType("=",StaticUtils.PROCESS_TYPE_51);
						spptDao.setConditionProcessInstanceId("=",processInstanceId);
						spptDao.conditionalDelete();

						//删除流程实例表数据
						spiDao.conditionalDelete();
					}
				}
				//删除业务表数据
				pbDao.conditionalDelete();
				ProjectLinkAttachmentRecord plaDao = new ProjectLinkAttachmentRecord();
				plaDao.setConditionProjectId("=",projectId);
				plaDao.setConditionStageId("=",stageId);
				plaDao.conditionalDelete();
			}
			//删除确认绑定表数据
			paDao.conditionalDelete();
		}
		//到目前为止已删除确认函绑定流程及相关业务表数据************************************************

		ProjectSettlementDetail  psdDao=new ProjectSettlementDetail();
		psdDao.setConditionProjectId("=", projectId);
		psdDao.setConditionSettlementId("=", settlementId);
		List<BaseProjectSettlementDetail> pdlist=psdDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(pdlist)&&pdlist.size()>0){
			//删除个人账户表
			EmployeeAccountRecord eaDao=new EmployeeAccountRecord();
			Integer[] edarr=new Integer[2];
			edarr[0]=1;
			edarr[1]=7;
			for (BaseProjectSettlementDetail baseProjectSettlementDetail : pdlist) {
				int businessId=BaseHelpUtils.getIntValue(baseProjectSettlementDetail.getSettlementDetailId());
				eaDao.clear();
				eaDao.setConditionBusinessId("=", businessId);
				eaDao.addCondition(BaseEmployeeAccountRecord.CS_BUSINESS_TYPE_ID, "in", edarr);
				if(eaDao.isExist()) {
					eaDao.conditionalDelete();
				}
			}
			//删除项目结算明细表
			psdDao.conditionalDelete();
		}

		//项目部门结算表
		PlateProjectAccountRecord ppaDao=new PlateProjectAccountRecord();
		ppaDao.setConditionSettlementId("=", settlementId);
		ppaDao.setConditionProjectId("=",projectId);

	
		//部门账户表
		PlateAccountRecord  parDao=new PlateAccountRecord();

		List<BasePlateProjectAccountRecord>  ppaList=ppaDao.conditionalLoad();
		if(!BaseHelpUtils.isNullOrEmpty(ppaList)&&ppaList.size()>0) {
			for (BasePlateProjectAccountRecord basePlateProjectAccountRecord : ppaList) {
				int plateProjectAccountRecordId=BaseHelpUtils.getIntValue(basePlateProjectAccountRecord.getPlateProjectAccountRecordId());
				parDao.clear();
				//删除部门账户表
				parDao.setConditionBusinessId("=", plateProjectAccountRecordId);
				parDao.setConditionBusinessTypeId("=",1);
				parDao.conditionalDelete();
			}
			//删除项目部门结算表
			ppaDao.conditionalDelete();
		}
		

		//成本
		ProjectCost pcDao=new ProjectCost();
		pcDao.setConditionProjectId("=", projectId);
		pcDao.setConditionSettlementId("=", settlementId);
		if(pcDao.isExist()) {
			pcDao.setStatus(0);//恢复成本
			pcDao.conditionalUpdate();
		}

		//删除结算总表
		psDao.clear();
		psDao.setSettlementId(settlementId);
		if(psDao.load()) {
			psDao.delete();
		}

		ThreadConnection.commit();
		return bc.toJSON(0,"");
	}

}
