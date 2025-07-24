package pomplatform.employeenew.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericBase;
import delicacy.common.GenericProcessor;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.OnTelMobile;
import message.common.SendEmailTemplate;

/**
 *
 * @author Peter
 */
public class LoginProcessor implements GenericProcessor {
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
		switch(optType){
		case "OnCheckEmployeeInfo":
			return OnCheckEmployeeInfo(params);
		case "OnUpdateEmpPwd":
			return OnUpdateEmpPwd(params);
		default:
			return null;
		}
    }
    
    /**
     * 员工密码重置
     * @param params
     * @return
     * @throws Exception
     */
    public String OnUpdateEmpPwd(Map<String, Object> params) throws Exception{
    	//获取员工Id和新密码
    	int employeeId = BaseHelpUtils.getIntValue(params, "employeeId");
    	if(employeeId == 0){
    		throw new SQLException("操作异常:未加载到职员信息");
    	}
    	String password = BaseHelpUtils.getStringValue(params, "password");

    	//校验员工的密码
		//获取员工的密码
		if (!isMatcherFinded("^(?![^a-zA-Z]+$)(?!\\D+$).{8,16}$", password)) {
			throw new SQLException("请输入包括数字和字母、长度8到16位的密码组合");
		}

    	if(BaseHelpUtils.isNullOrEmpty(password)){
    		throw new SQLException("操作异常:重置的新密码不可为空");
    	}
    	Employee dao = new Employee();
    	dao.setEmployeeId(employeeId);
    	if(dao.load()){
    		dao.setEmployeePassword(DES.string2MD5(password));
    		dao.update();
    	}else{
    		throw new SQLException("操作异常:未加载到职员信息");
    	}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		return bc.toJSON(0, "");
	}

	/**
	 * 校验密码
	 * @param patternStr
	 * @param input
	 * @return
	 */
	public static boolean isMatcherFinded(String patternStr, CharSequence input) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			return true;
		}
		return false;
	}
    
    /**
     * 员工根据手机号码和企业邮箱进行验证
     * @param params
     * @return
     * @throws Exception
     */
    public String OnCheckEmployeeInfo(Map<String, Object> params) throws Exception{
    	//获取验证手机号码、企业邮箱和验证方式
    	String mobile = BaseHelpUtils.getStringValue(params, "mobile");
    	if(BaseHelpUtils.isNullOrEmpty(mobile)){
    		throw new SQLException("请输入您的手机号码进行验证");
    	}
    	String companyEmail = BaseHelpUtils.getStringValue(params,"companyEmail");
    	if(BaseHelpUtils.isNullOrEmpty(companyEmail)){
    		throw new SQLException("请输入您的企业邮箱进行验证");
    	}
    	String codeType = BaseHelpUtils.getStringValue(params,"codeType");
    	if(BaseHelpUtils.isNullOrEmpty(codeType)){
    		throw new SQLException("请选择您的验证方式");
    	}
    	//定义map来存放返回的数据集
    	Map<String,Object> param = new HashMap<>();
    	Employee dao = new Employee();
    	//先根据手机号码和企业邮箱进行验证，看是否有这个员工信息
    	dao.setConditionMobile("=",mobile);
    	dao.setConditionCompanyEmail("=",companyEmail);
    	dao.setConditionStatus("=",0);//只检索在职的职员信息
    	int counts = dao.countRows();
    	if(counts == 0){//如果不存在，则抛出异常提示
    		throw new SQLException("根据您输入的手机号码和企业邮箱未检索到您的相关信息");
    	}else if(counts > 1){
    		throw new SQLException("根据您输入的手机号码和企业邮箱检索到多个人员信息");
    	}else if(counts == 1){
    		//生成6位随机数
    		int code = BaseHelpUtils.getIntValue((Math.random()*9+1)*100000);
    		//获取职员Id
    		BaseEmployee bean = dao.executeQueryOneRow();
    		int employeeId = BaseHelpUtils.getIntValue(bean.getEmployeeId());
    		String sendMsg = String.format("您正在ERP系统进行账户信息的验证，验证码:%1$s。如果不是您本人操作，请忽略此信息！",code);
    		//根据验证方式，将验证码发送至手机号码或者企业邮箱去
    		if(codeType.equals("手机短息")){//手机短息验证
    			OnTelMobile.onTelMobileSendMeg(employeeId,sendMsg);
    		}else{//企业邮箱验证
    			SendEmailTemplate.sendEmail(companyEmail, null,sendMsg, "账户信息验证");
    		}
    		param.put("code",code);
    		param.put("employeeId", employeeId);
    	}
		BaseCollection<GenericBase> bc = new BaseCollection<>();
		bc.setUserData(param);
		return bc.toJSON(0, "");
	}
    
}
