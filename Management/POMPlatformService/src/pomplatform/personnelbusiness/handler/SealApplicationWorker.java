package pomplatform.personnelbusiness.handler;

import com.pomplatform.db.bean.BaseProject;
import com.pomplatform.db.bean.BaseSealKeeper;
import com.pomplatform.db.dao.Project;
import com.pomplatform.db.dao.SealKeeper;
import delicacy.common.BaseHelpUtils;
import delicacy.expression.Expression;
import delicacy.system.bean.ProcessInstance;
import delicacy.system.bean.ProcessInstanceActivity;
import org.apache.log4j.Logger;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import delicacy.common.BusinessAbstract;
import delicacy.common.GenericWorkflowProcessor;
import delicacy.system.bean.ProcessInformation;
import delicacy.system.bean.SystemProcessDefinition;
import delicacy.system.executor.ProcessUtil;
import com.pomplatform.db.bean.BasePersonnelBusines;
import com.pomplatform.db.dao.PersonnelBusines;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.business.OnWrokflowProcess;

public class SealApplicationWorker implements GenericWorkflowProcessor {

	protected BasePersonnelBusines bean = new BasePersonnelBusines();

	@Override
	public BusinessAbstract startNewWorkflow(SystemProcessDefinition pd, Map params, int employeeId) throws Exception {
		bean.setDataFromMap(params);
		bean.setProcessType(pd.getProcessTypeId());
		PersonnelBusines dao = new PersonnelBusines();
		dao.setDataFromBase(bean);
		dao.save();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public BusinessAbstract executeActivity(ProcessInformation pi, Map params, int employeeId, boolean modified, boolean completed) throws Exception {
		bean.setDataFromMap(params);
		if(!modified) {
			ProcessInstance pIns = pi.getProcessInstance();
			if(BaseHelpUtils.isNullOrEmpty(pIns)) {
				return null;
			}
			ProcessInstanceActivity currentAuditActivity = pIns.getCurrentActivity();
			if(BaseHelpUtils.isNullOrEmpty(currentAuditActivity)) {
				return null;
			}
			int activityType = BaseHelpUtils.getIntValue(currentAuditActivity.getActivityType());
			if(!(activityType == StaticUtils.ACTIVITY_TYPE_HANDEL || completed)) {
				return null;
			}
		}
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPrimaryKeyFromBase(bean);
		if(!dao.load()) throw new SQLException("Business data not found");
		dao.setDataFromBase(bean);
		dao.update();
		BusinessAbstract ba = new BusinessAbstract(dao.getPersonnelBusinessId(), "");
		return ba;
	}

	@Override
	public boolean computeExpression(String expression) throws Exception {
		Expression e = new Expression(expression);
		int nextAuditor = BaseHelpUtils.getIntValue(bean.getNextAuditor());
		int salary2 =  BaseHelpUtils.getIntValue(bean.getSalary2());

		//盖章类型
		if(expression.contains(StaticUtils.SEAL_TYPE)) {
			if (nextAuditor == 0) {
				e.setValue(StaticUtils.SEAL_TYPE, StaticUtils.SEAL_TYPE_NAME);
			}else  if(nextAuditor == 1){
				e.setValue(StaticUtils.SEAL_TYPE, StaticUtils.SEAL_TYPE_NAME_TWO);
			}else  if(nextAuditor == 2){
				e.setValue(StaticUtils.SEAL_TYPE, StaticUtils.SEAL_TYPE_NAME_THREE);
			}else {
				e.setValue(StaticUtils.SEAL_TYPE, "");
			}
		}
		//盖章内容
		if(expression.contains(StaticUtils.SEAL_CONTENT)){
			if(salary2==0 || salary2==1){
				e.setValue(StaticUtils.SEAL_CONTENT, "");
			}else if(salary2==2 ){
				e.setValue(StaticUtils.SEAL_CONTENT, StaticUtils.SEAL_CONTENT_NAME_1);
			}else if(salary2==3){
				e.setValue(StaticUtils.SEAL_CONTENT, StaticUtils.SEAL_CONTENT_NAME_2);
			}else if(salary2==4){
				e.setValue(StaticUtils.SEAL_CONTENT, StaticUtils.SEAL_CONTENT_NAME_3);
			}else if(salary2==5){
				e.setValue(StaticUtils.SEAL_CONTENT, StaticUtils.SEAL_CONTENT_NAME_4);
			}
		}

		String contactPerson = BaseHelpUtils.getString(bean.getContactPerson());
		String[] contactPersons = contactPerson.split(",");
		String[] sbs = new String[contactPersons.length];
		String name = null;

		for (int i = 0; i < contactPersons.length; i++) {
			String[] strings = contactPersons[i].split("/");
			sbs[i] = strings[1];
			name =strings[0];
		}
		Set set = new HashSet();
		for (int i = 0; i < sbs.length; i++) {
			set.add(sbs[i]);
		}
		//公司名称
		if(expression.contains(StaticUtils.COMPANY)){
			if (name.equals(StaticUtils.CORPORATE_NAME_2)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_2);
			} else if (name.equals(StaticUtils.CORPORATE_NAME_3)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_3);
			} else if (name.equals(StaticUtils.CORPORATE_NAME_4)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_4);
			} else if (name.equals(StaticUtils.CORPORATE_NAME_5)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_5);
			}else if (name.equals(StaticUtils.CORPORATE_NAME_6)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_6);
			}else if (name.equals(StaticUtils.CORPORATE_NAME_1)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_1);
			}else if (name.equals(StaticUtils.CORPORATE_NAME_7)) {
				e.setValue(StaticUtils.COMPANY, StaticUtils.COMPANY_NAME_7);
			}else {
				e.setValue(StaticUtils.COMPANY,"");
			}

		}
		String sealName = null;
		//印章种类
		for(Object value: set){
		        if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_2)){
                    sealName = StaticUtils.TYPE_OF_SEAL_NAME_2;
                }
			}
        if(expression.contains(StaticUtils.TYPE_OF_SEAL)){
        	if(BaseHelpUtils.isNullOrEmpty(sealName)){
				e.setValue(StaticUtils.TYPE_OF_SEAL, "");
			}else if(sealName.equals(StaticUtils.TYPE_OF_SEAL_NAME_2)){
                e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_2);
//				} else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_2)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_2);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_3)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_3);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_4)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_4);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_5)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_5);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_6)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_6);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_7)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_7);
//				}else if(value.equals(StaticUtils.TYPE_OF_SEAL_NAME_8)){
//					e.setValue(StaticUtils.TYPE_OF_SEAL, StaticUtils.TYPE_OF_SEAL_NAME_8);
            } else {
                e.setValue(StaticUtils.TYPE_OF_SEAL, "");
            }
		}


		return ProcessUtil.executeExpression(e,expression);
	}

	@Override
	public int[] findActivityOwner(int processCreator, Integer employeeId, Integer departmentId, Integer roleId, Integer poolType) throws Exception {
		if(null != roleId && roleId.equals(StaticUtils.ROLE_CUSTOM_AUDITOR)){
			String contactPerson = BaseHelpUtils.getString(bean.getContactPerson());
			String[] contactPersons = contactPerson.split(",");
			String[] sbs = new String[contactPersons.length];
			String name = null;
			int[] arr = new int[contactPersons.length];
			SealKeeper keeper = new SealKeeper();
			int count = 0;
			for (int i = 0; i < contactPersons.length; i++) {
				keeper.clear();
				String[] strings = contactPersons[i].split("/");
				name =strings[0];
				System.out.println("name==============="+name);
				if(name.equals("深圳市杰恩创意设计股份有限公司")){
					keeper.setConditionCompanyId("=",1);
				}else if(name.equals("姜峰设计（深圳）有限公司")){
					keeper.setConditionCompanyId("=",2);
				}else if(name.equals("深圳市博普森机电顾问有限公司")){
					keeper.setConditionCompanyId("=",3);
				}else if(name.equals("深圳杰加设计有限公司")){
					keeper.setConditionCompanyId("=",4);
				}else if(name.equals("深圳市杰恩创意设计股份有限公司北京分公司")){
					keeper.setConditionCompanyId("=",6);
				}else if(name.equals("深圳市杰恩创意设计股份有限公司上海分公司")){
					keeper.setConditionCompanyId("=",7);
				}else if(name.equals("深圳市杰恩创意设计股份有限公司武汉分公司")){
					keeper.setConditionCompanyId("=",8);
				}else if(name.equals("项目章")){
					keeper.setConditionCompanyId("=",9);
				}else if(name.equals("其他")){
					keeper.setConditionCompanyId("=",10);
				}else if(name.equals("杰拓设计（国际）有限公司")){
					keeper.setConditionCompanyId("=",203);
				}else {
					throw new SQLException("选择的印章有尚未设置保管员,请先设置保管员!!");
				}
				String sealName =  strings[1];
				if(!BaseHelpUtils.isNullOrEmpty(sealName)){
					keeper.setConditionSealName("=",sealName);
				}
				BaseSealKeeper dao= keeper.executeQueryOneRow();
				boolean bool = true;
				if(!BaseHelpUtils.isNullOrEmpty(dao)){
					if(!BaseHelpUtils.isNullOrEmpty(arr)) {
						for (int s = 0; s < arr.length; s++) {
							if (arr[s] == dao.getEmployeeId()) {
								bool = false;
							}
						}
					}
					if(bool){
						arr[i] = dao.getEmployeeId();
						System.out.println("=============== dao.getEmployeeId()==="+ dao.getEmployeeId());
						count+=1;
					}
				}else {
					throw new SQLException(sealName+"尚未设置保管员,请先设置保管员!!");
				}

			}
			int[] arrs = new int[count];
			System.out.println("==============="+count);
			for (int c =0;c<arrs.length;c++){
				arrs[c]=arr[c];
			}
			return arrs;


		}
		return ProcessUtil.findNextOwner(processCreator, employeeId, departmentId, roleId);
	}

	@Override
	public String getBusinessData(Integer businessId) throws Exception {
		PersonnelBusines dao = new PersonnelBusines();
		dao.setPersonnelBusinessId(businessId);
		dao.load();
		return dao.generateBase().toJSON();
	}

	public static void main(String[] args) throws Exception{
		String contactPerson = BaseHelpUtils.getString("深圳市杰恩创意设计股份有限公司/公章/盖印章,深圳市杰恩创意设计股份有限公司/人事专用章/盖印章");
		String[] contactPersons = contactPerson.split(",");
		String[] sbs = new String[contactPersons.length];
		String name = null;
		int[] arr = new int[contactPersons.length];
		SealKeeper keeper = new SealKeeper();
		int count = 0;
		for (int i = 0; i < contactPersons.length; i++) {
			keeper.clear();
			String[] strings = contactPersons[i].split("/");
			name =strings[0];
			if(name.equals("深圳市杰恩创意设计股份有限公司")){
				keeper.setConditionCompanyId("=",1);
			}else if(name.equals("姜峰设计（深圳）有限公司")){
				keeper.setConditionCompanyId("=",2);
			}else if(name.equals("深圳市博普森机电顾问有限公司")){
				keeper.setConditionCompanyId("=",3);
			}else if(name.equals("深圳杰加设计有限公司")){
				keeper.setConditionCompanyId("=",4);
			}else if(name.equals("深圳市杰恩创意设计股份有限公司北京分公司")){
				keeper.setConditionCompanyId("=",6);
			}else if(name.equals("深圳市杰恩创意设计股份有限公司上海分公司")){
				keeper.setConditionCompanyId("=",7);
			}else if(name.equals("深圳市杰恩创意设计股份有限公司武汉分公司")){
				keeper.setConditionCompanyId("=",8);
			}else if(name.equals("项目章")){
				keeper.setConditionCompanyId("=",9);
			}else if(name.equals("其他")){
				keeper.setConditionCompanyId("=",10);
			}else {
			}
			String sealName =  strings[1];
			if(!BaseHelpUtils.isNullOrEmpty(sealName)){
				keeper.setConditionSealName("=",sealName);
			}
			BaseSealKeeper dao= keeper.executeQueryOneRow();
			boolean bool = true;
			if(!BaseHelpUtils.isNullOrEmpty(dao)){
				if(!BaseHelpUtils.isNullOrEmpty(arr)) {
					for (int s = 0; s < arr.length; s++) {
						if (arr[s] == dao.getEmployeeId()) {
							bool = false;
						}
					}
				}
				if(bool){
					arr[i] = dao.getEmployeeId();
					System.out.println("=============== dao.getEmployeeId()==="+ dao.getEmployeeId());
					count+=1;
				}
			}

		}
		int[] arrs = new int[count];
		System.out.println("==============="+count);
		for (int c =0;c<arrs.length;c++){
			arrs[c]=arr[c];
		}

	}

}
