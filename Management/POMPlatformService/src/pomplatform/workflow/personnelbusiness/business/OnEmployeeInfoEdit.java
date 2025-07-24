package pomplatform.workflow.personnelbusiness.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.bean.BaseCardManage;
import com.pomplatform.db.bean.BaseEmployeeContractAttachment;
import com.pomplatform.db.bean.BaseSalaryTotal;
import com.pomplatform.db.dao.CardManage;
import com.pomplatform.db.dao.EmployeeContractAttachment;
import com.pomplatform.db.dao.SalaryTotal;

import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericProcessor;
import delicacy.connection.ThreadConnection;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.otheraccount.UserAccountUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import pomplatform.common.utils.StaticUtils;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;
import pomplatform.workflow.personnelbusiness.dao.EmployeeWithEeeee;

/**
 * 
 * @author 
 */
public class OnEmployeeInfoEdit implements GenericProcessor {
	private static final Logger __logger = Logger.getLogger("");
	protected BaseEmployeeWithEeeee bean = new BaseEmployeeWithEeeee();
	
    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        @SuppressWarnings("rawtypes")
		JSON parser = new JSON(new StringReader(creteria));
        @SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
        if(!BaseHelpUtils.isNullOrEmpty(params)){
    		ThreadConnection.beginTransaction();
			bean.setDataFromMap(params);
			EmployeeWithEeeee dao = new EmployeeWithEeeee();
			dao.setPrimaryKeyFromBase(bean);
			if(!dao.load()) throw new SQLException("Business data not found");
			dao.setDataFromBase(bean);
			//所属公司
			dao.setCompanyId(BaseHelpUtils.getIntValue(bean.getOwnedCompany()));
			setEmployeeId(dao.getEmployeeId());
			dataValidate(false);
			dao.update();
			try {
				UserAccountUtils.updateUserAccount(dao.generateBase(), 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//入职员工的id
			int newEmployeeId = dao.getEmployeeId();
			
			//操作人
//			int OperateEmployeeId = BaseHelpUtils.getIntValue(params, "OperateEmployeeId");
//			EmployeeContractAttachment contractDao = new EmployeeContractAttachment();
//			contractDao.setConditionEmployeeId("=",newEmployeeId);
//			contractDao.setConditionContractType("=", 0);
////			contractDao.setConditionSignType("=", 0);
//			List<BaseEmployeeContractAttachment> contractBean = contractDao.conditionalLoad(" order by sign_type desc");
			//向员工合同管理表插入劳动合同路径数据
//			if(!BaseHelpUtils.isNullOrEmpty(dao.getLaborAttachments())){
//				if(!BaseHelpUtils.isNullOrEmpty(contractBean) && contractBean.size() > 0){
//					contractDao.clear();
//					contractDao.setDataFromBase(contractBean.get(0));
//					contractDao.setAttachmentUrl(dao.getLaborAttachments());
//					contractDao.setOperateEmployeeId(OperateEmployeeId);
//					contractDao.setOperateTime(new Date());
//					contractDao.update();
//				}else{
//					contractDao.clear();
//					contractDao.setEmployeeId(newEmployeeId);
//					contractDao.setAttachmentName("劳动合同");
//					contractDao.setAttachmentUrl(dao.getLaborAttachments());
//					contractDao.setContractType(0);//劳动合同
//					contractDao.setSignType(0);//新签
//					contractDao.setStartDate(dao.getContractStartDate());
//					contractDao.setEndDate(dao.getContractEndDate());
//					contractDao.setOperateEmployeeId(OperateEmployeeId);
//					contractDao.setOperateTime(new Date());
//					contractDao.save();
//				}
//			}
			
			//如果银行卡号不为空，往card_manage表里插入或更新数据(有默认卡号就更新没有默认卡号就添加默认卡号)
			//同步更新到工资表当月未发放的工资
			if(!BaseHelpUtils.isNullOrEmpty(dao.getBankCardNum())){
				Calendar cal =Calendar.getInstance();
				cal.setTime(new Date());
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH);
				SalaryTotal stDao =new SalaryTotal();
				stDao.setConditionEmployeeId("=", newEmployeeId);
				stDao.setConditionYear("=", year);
				stDao.setConditionMonth("=", month);
				stDao.setConditionIsSended("=" , false);
				List<BaseSalaryTotal> list = stDao.conditionalLoad();
				if(list.size()==1) {//只有一条数据
					BaseSalaryTotal baseSalary = list.get(0);
					baseSalary.setBankAccount(dao.getBankCardNum());
					stDao.setDataFromBase(baseSalary);
					stDao.update();
				}
				
				CardManage cardDao = new CardManage();
				cardDao.setConditionObjectId("=", newEmployeeId);
				cardDao.setConditionDefaultCard("=" , true);
				BaseCardManage cardBean = cardDao.executeQueryOneRow();
				if(BaseHelpUtils.isNullOrEmpty(cardBean)){
					cardDao.setObjectId(newEmployeeId);
					cardDao.setObjectType(1);//类型:个人
					cardDao.setBankId(4);//默认中国银行(4)
					cardDao.setBankAccount(dao.getBankCardNum());
					cardDao.setCardType(1);//卡号类型:银行卡
					cardDao.setCurrencyType(0);//货币类型:人民币
					cardDao.save();
				}else {
					cardBean.setBankAccount(dao.getBankCardNum());
					cardDao.clear();
					cardDao.setDataFromBase(cardBean);
					cardDao.update();
				}
			}
			ThreadConnection.commit();
		}else{
			return null;
		}
        return null;
    }
    
    public void dataValidate(Boolean checkEmail) throws Exception{
		Employee dao = new Employee();
		String email = bean.getCompanyEmail();
		String mobile = bean.getMobile();
		//只查询在职的
		dao.setConditionStatus("=", StaticUtils.EMPLOYEE_NORMAL);
		List<BaseEmployee> bes = dao.conditionalLoad("order by "+BaseEmployee.CS_EMPLOYEE_NO+" asc");
		if(checkEmail){
			String emailSuffix = email.substring(email.indexOf("@")+1);
			if(!emailSuffix.equals("jaid.cn")){
				throw new Exception("企业邮箱后缀应为 @jaid.cn");
			}
			for(BaseEmployee e : bes){
				if(!Objects.equals(email,e.getCompanyEmail())){
					continue;
				}else{
					throw new Exception("该企业邮箱已存在");
				}
			}
		}
		for(BaseEmployee e : bes){
			if(!Objects.equals(employeeId, e.getEmployeeId())){
				if(!BaseHelpUtils.isNullOrEmpty(mobile)){
					if(!Objects.equals(mobile,e.getMobile())){
						continue;
					}else{
						throw new Exception("该手机号码已存在");
					}
				}
			}
		}
		
	}
    
    private int employeeId;
    
    public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
    
}
