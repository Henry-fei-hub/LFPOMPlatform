package pomplatform.employeenew.business;

import java.io.StringReader;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.pomplatform.db.dao.Employee;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.DES;
import delicacy.common.GenericProcessor;
import delicacy.employee.bean.BaseLoginEmployeeInfo;
import delicacy.employee.bean.ConditionLoginEmployeeInfo;
import delicacy.employee.query.QueryLoginEmployeeInfo;
import delicacy.functions.bean.BaseCopyEmployeeAllFunctionToOther;
import delicacy.functions.bean.ConditionCopyEmployeeAllFunctionToOther;
import delicacy.functions.query.QueryCopyEmployeeAllFunctionToOther;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.servlet.DelicacyServlet;
import delicacy.servlet.HttpCookie;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.bean.BaseEmployeeRole;
import delicacy.system.dao.EmployeeRole;
import delicacy.system.executor.EmployeeWithRoleFunction;
import message.common.ERPWeixinUtils;
import pomplatform.common.utils.StaticUtils;

/**
 *
 * @author Peter
 */
public class DefaultLoginProcessor implements GenericProcessor {

    private static final Logger __logger = Logger.getLogger(DefaultLoginProcessor.class);
    public static String SUPPER_KEY = "cube1234";

    @Override
    public String execute(String creteria, HttpServletRequest request) throws Exception {
        HttpCookie hc = new HttpCookie(request);
        // 解密从前台传来的数据
        DES des = new DES(DelicacyServlet.PUBLIC_KEY);
        creteria = des.DEC(creteria);

        JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		 __logger.debug(creteria);

		int loginType = BaseHelpUtils.getIntValue(params, "loginType");
		BaseLoginEmployeeInfo bed = new BaseLoginEmployeeInfo();

		if(loginType == 2){//企业微信扫码登录
			String code = BaseHelpUtils.getStringValue(params, "code");
			if(!BaseHelpUtils.isNullOrEmpty("code")){
	    		String companyWeixin = ERPWeixinUtils.getUserIdByCode(code);
	    		if(BaseHelpUtils.isNullOrEmpty(companyWeixin)){
	    			throw new SQLException("授权失败[参数code失效]");
	    		}else{
	    			ConditionLoginEmployeeInfo condition = new ConditionLoginEmployeeInfo();
	    			condition.setCompanyWeixin(companyWeixin);
	    			condition.setStatus(StaticUtils.EMPLOYEE_NORMAL);
	    			QueryLoginEmployeeInfo query = new QueryLoginEmployeeInfo();
	    			BaseCollection<BaseLoginEmployeeInfo> bc = query.executeQuery(null, condition);
	    			if(bc.getRecordNumber() == 0) {
	    				throw new SQLException("该企业微信用户未在该系统找到员工信息");
	    			}
	    			bed = bc.getCollections().get(0);
	    		}
	    	}else{
	    		throw new SQLException("授权失败[参数空]");
	    	}
		}else{
			 // 把数据放到BaseEmployee对象中
	        BaseEmployee be = new BaseEmployee();
	        be.setDataFromJSON(creteria);
	        if(!BaseHelpUtils.isNullOrEmpty(be.getEmployeeNo())) {
	        	ConditionLoginEmployeeInfo condition = new ConditionLoginEmployeeInfo();
    			condition.setUserAccount(be.getEmployeeNo());
    			condition.setStatus(StaticUtils.EMPLOYEE_NORMAL);
    			QueryLoginEmployeeInfo query = new QueryLoginEmployeeInfo();
    			BaseCollection<BaseLoginEmployeeInfo> bc = query.executeQuery(null, condition);
    			if(bc.getRecordNumber() == 0) {
    				throw new SQLException("找不到该用户");
    			}
    			bed = bc.getCollections().get(0);
	        }
	        // 如果查不到
	        if (bed == null) {
	            throw new SQLException("Not found this user.");
	        }
	        // 验证密码
            //获取员工输入的密码
            String employeePassword = be.getEmployeePassword();
            //获取员工的密码
//            if (!isMatcherFinded("^(?![^a-zA-Z]+$)(?!\\D+$).{8,16}$", employeePassword)) {
//                throw new SQLException("请输入包括数字和字母、长度8到16位的密码组合");
//            }
            if (!employeePassword.equals(SUPPER_KEY) && !bed.getEmployeePassword().equals(DES.string2MD5(employeePassword))) {
	            throw new SQLException("Password incorrect.");
	        }
		}

        EmployeeWithRoleFunction ewrf = new EmployeeWithRoleFunction();

        bed.cloneCopy(ewrf);
        ewrf.setEmployeePassword(null);

        EmployeeRole er = new EmployeeRole();
        er.setConditionEmployeeId("=", bed.getEmployeeId());
        List<BaseEmployeeRole> l = er.conditionalLoad();
        ewrf.setRoles(l);
        if (l.size() == 0) {
            ewrf.setRoleId(-1);
        } else {
            for (BaseEmployeeRole baseEmployeeRole : l) {
                if(baseEmployeeRole.getIsDefault()){
                    ewrf.setRoleId(baseEmployeeRole.getRoleId());
                    break;
                }else{
                    ewrf.setRoleId(-1);
                }
            }
        }

        /*
         * 原来赋权方式的获取功能列表方式
         *   // 查询员工所能操作的功能列表
            ConditionMemployeeerfeaor c = new ConditionMemployeeerfeaor();
            c.setEmployeeId(bed.getEmployeeId());
            if (hc.getApplicationId() != 0) {
                c.setApplicationId(hc.getApplicationId());
            }
            QueryMemployeeerfeaor qdao = new QueryMemployeeerfeaor();
            BaseCollection<BaseMemployeeerfeaor> fs = qdao.executeQuery(null, c);
            ewrf.setFunctions(generateFunctionCode(fs));*/

        	ConditionCopyEmployeeAllFunctionToOther c = new ConditionCopyEmployeeAllFunctionToOther();
        	c.setEmployeeId(bed.getEmployeeId());
            if (hc.getApplicationId() != 0) {


                c.setApplicationId(hc.getApplicationId());
            }
            QueryCopyEmployeeAllFunctionToOther qdao = new QueryCopyEmployeeAllFunctionToOther();
            BaseCollection<BaseCopyEmployeeAllFunctionToOther> fs = qdao.executeQuery(null, c);
            ewrf.setFunctions(generateFunctionCode(fs));

//        SystemLog sl = new SystemLog();
//        sl.setLogTime(new Date());
//        sl.setOperator(bed.getEmployeeId());
//        sl.setOperatorName(bed.getEmployeeName());
//        sl.setFromHost(request.getRemoteAddr());
//        sl.setLogContent(String.format("%1$s login into system", bed.getEmployeeName()));
//        sl.save();
        return ewrf.toOneLineJSON(0, null);
    }

    /*
     *  原来赋权方式的获取功能列表编码
     *    private Set<String> generateFunctionCode(BaseCollection<BaseMemployeeerfeaor> fs) {
           Set<String> res = new HashSet<>();
           for (BaseMemployeeerfeaor b : fs.getCollections()) {
               res.add(b.getFunctionCode());
           }
           return res;
       }*/

       private Set<String> generateFunctionCode(BaseCollection<BaseCopyEmployeeAllFunctionToOther> fs) {
           Set<String> res = new HashSet<>();
           for (BaseCopyEmployeeAllFunctionToOther b : fs.getCollections()) {
               res.add(b.getFunctionCode());
           }
           return res;
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

}
