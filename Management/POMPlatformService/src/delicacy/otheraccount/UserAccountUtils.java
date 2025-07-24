package delicacy.otheraccount;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.pomplatform.db.dao.Department;

import delicacy.common.BaseHelpUtils;
import delicacy.common.MapUtils;
import delicacy.system.bean.BaseEmployee;
import delicacy.system.dao.Employee;
import message.common.TencentEmailUtils;
import message.common.WeixinUtils;
import net.sf.json.JSONObject;
import pomplatform.workflow.personnelbusiness.bean.BaseEmployeeWithEeeee;

public class UserAccountUtils {
	
	/**
	 * 
	 * @Title: createUserAccount 
	 * @Description: 创建ERP用户第三方账号   企业微信/企业邮箱/ECMC
	 * @param @param bean
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public static String createUserAccount(BaseEmployeeWithEeeee bean) throws Exception{
		String errorMsg = "";
		String companyEmail = bean.getCompanyEmail();
		String companyNo = bean.getEmployeeNo();
		String employeeName = bean.getEmployeeName();
		String mobile = bean.getMobile();
		Integer employeeId = bean.getEmployeeId();
		Integer departmentId = bean.getDepartmentId();
		
		if(null != employeeId && employeeId > 0 && null != departmentId && departmentId > 0){
			Department dptDao = new Department();
			Employee eDao = new Employee();
			eDao.setEmployeeId(employeeId);
			dptDao.setDepartmentId(departmentId);
			if(dptDao.load() && eDao.load()){
//				//创建邮箱账号
//				if(!BaseHelpUtils.isNullOrZero(dptDao.getEmailDepartmentId()) && !BaseHelpUtils.isNullOrEmpty(companyEmail) 
//						&& !BaseHelpUtils.isNullOrEmpty(companyNo) && !BaseHelpUtils.isNullOrEmpty(mobile) && !BaseHelpUtils.isNullOrEmpty(employeeName)){
//					//检测邮箱账号是否存在
//					JSONObject info =  TencentEmailUtils.getUserByUserId(companyEmail);
//					if(null != info){ //防止账号重复
//						companyEmail = departmentId + companyEmail;
//					}
//					
//					Map<String, Object> params = new HashMap<String, Object>();
//					Object [] department = new Object []{dptDao.getEmailDepartmentId()};
////					{
////					   	"userid": " zhangsan@gzdev.com ",
////					   	"name": "张三",
////					   	"department": [1, 2],
////					   	"position": "产品经理",
////					   	"mobile": "15913215XXX",
////					   	"tel": "123456",
////					   	"extid": "01",
////					   	"gender": "1",
////					　 	"slaves": [zhangsan@gz.com, zhangsan@bjdev.com],
////						"password":"******",
////						"cpwd_login":0 // 用户重新登录时是否重设密码, 登陆重设密码后，该标志位还原。0表示否，1表示是，缺省为0
////					}
//					if(null != bean.getGender() && (bean.getGender() == 1 || bean.getGender() == 2)){
//						params.put("gender",  bean.getGender().toString());
//					}
//					
//					params.put("userid", companyEmail);
//					params.put("name", employeeName);
//					params.put("mobile", mobile);
//					params.put("password", "Ja123456");//密码默认为工号
//					params.put("department", department);
//					params.put("cpwd_login", 1);
//					boolean flag = TencentEmailUtils.createUser(params);
//					if(!flag){
//						eDao.setCompanyEmail(null);
//						eDao.update();
//						errorMsg += "创建邮箱账号失败, 请登录企业邮箱后台创建企业邮箱账号  | ";
//					}else{
//						if(null != info){ //更新最新的企业邮箱
//							bean.setCompanyEmail(companyEmail);
//							eDao.setCompanyEmail(companyEmail);
//							eDao.update();
//						}
//					}
//				}else{
//					errorMsg += "创建企业邮箱账号参数错误 无法创建企业邮箱账号 bean = " + bean.toJSONString() + " | ";
//				}
				//创建微信账号
//				
				if(!BaseHelpUtils.isNullOrZero(dptDao.getWeixinDepartmentId()) && !BaseHelpUtils.isNullOrEmpty(companyEmail) 
						&& !BaseHelpUtils.isNullOrEmpty(companyNo) && !BaseHelpUtils.isNullOrEmpty(mobile) && !BaseHelpUtils.isNullOrEmpty(employeeName)){
//					{
//						   "userid": "zhangsan",
//						   "name": "张三",
//						   "english_name": "jackzhang"
//						   "mobile": "15913215421",
//						   "department": [1, 2],
//						   "order":[10,40],
//						   "position": "产品经理",
//						   "gender": "1",
//						   "email": "zhangsan@gzdev.com",
//						   "isleader": 1,
//						   "enable":1,
//						   "avatar_mediaid": "2-G6nrLmr5EC3MNb_-zL1dDdzkd0p7cNliYu9V5w7o8K0",
//						   "telephone": "020-123456"，
//						   "extattr": {"attrs":[{"name":"爱好","value":"旅游"},{"name":"卡号","value":"1234567234"}]}
//						}
					Map<String, Object> params = new HashMap<String, Object>();
					Object [] department = new Object []{dptDao.getWeixinDepartmentId()};
					if(null != bean.getGender() && (bean.getGender() == 1 || bean.getGender() == 2)){
						params.put("gender",  bean.getGender().toString());
					}
					if(!BaseHelpUtils.isNullOrEmpty(bean.getPhone())){
						params.put("telephone", bean.getPhone());
					}
					if(!BaseHelpUtils.isNullOrEmpty(bean.getEmployeeNameEn())){
						params.put("english_name", bean.getEmployeeNameEn());
					}
					params.put("email", companyEmail);
					params.put("userid", employeeId + "");
					params.put("name", employeeName);
					params.put("mobile", mobile);
					params.put("department", department);
					boolean flag = WeixinUtils.createUser(params);
					if(flag){
						//将微信userid更新到员工表
						eDao.setCompanyWeixin(employeeId + "");
						eDao.update();
					}else{
						errorMsg += "创建企业微信账号失败, 请登录企业邮箱后台创建企业微信账号  | ";
					}
				}else{
					errorMsg += "创建企业微信账号参数错误 无法创建企业微信账号 bean = " + bean.toJSONString() + " | ";
				}
			}else{
				errorMsg += "初始创建账号参数错误 无法创建任何账号 bean = " + bean.toJSONString() + " | ";
			}
			//创建微信账户
		}
		
		return errorMsg;
	}
	
	/**
	 * 
	 * @Title: deleteUserAccount 
	 * @Description: 删除ERP用户第三方账号   企业微信/企业邮箱
	 * @param @param employeeId
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public static String deleteUserAccount(Integer employeeId) throws Exception{
		String errorMsg = "";
		if(null != employeeId && employeeId > 0){
			Employee dao = new Employee();
			dao.setEmployeeId(employeeId);
			if(dao.load()){
				String wxuserId = dao.getCompanyWeixin();
				//删除企业微信账号
				if(!BaseHelpUtils.isNullOrEmpty(wxuserId)){
					JSONObject json = WeixinUtils.getUserByUserId(wxuserId);
					if(null != json){//检测账号是否存在
						boolean wxflag = WeixinUtils.deleteUserById(wxuserId);
						if(!wxflag){
							errorMsg += "该员工企业微信账号删除失败, 请登录企业微信账号后台进行删除  | ";
						}
					}
				}
				//删除企业邮箱账号
				String email = dao.getCompanyEmail();
				if(!BaseHelpUtils.isNullOrEmpty(email)){
					Map<String, Object> params = new HashMap<>();
					params.put("userid", email);
					params.put("enable", 0);
					if(!TencentEmailUtils.updateUser(params)){
						errorMsg += "禁用邮箱账号出错{" + MapUtils.toJSON(params) + "}";
					}
//					JSONObject json = TencentEmailUtils.getUserByUserId(email);
//					if(null != json){//检测账号是否存在
//						boolean emflag = TencentEmailUtils.deleteUserById(email);
//						if(!emflag){
//							errorMsg += "该员工企业邮箱账号删除失败, 请登录企业邮箱账号后台进行删除  | ";
//						}
//					}
				}
			}else{
				errorMsg = "该员工不存在";
			}
		}else{
			errorMsg = "该员工不存在";
		}
		return errorMsg;
	}
	
	/**
	 * 
	 * @Title: updateUserAccount 
	 * @Description: 更新用户数据
	 * @param @param bean
	 * @param @param updateType    1:表示部门有改动
	 * @param @return
	 * @param @throws Exception   
	 * @return String   
	 * @throws
	 */
	public static String updateUserAccount(BaseEmployee bean, Integer updateType) throws Exception{
		String errorMsg = "";
		//微信数据更新
		if(!BaseHelpUtils.isNullOrEmpty(bean.getCompanyWeixin())){
			Map<String, Object> params = new HashMap<>();
			if(updateType == 1){//改变部门归属
				if(!BaseHelpUtils.isNullOrEmpty(bean.getDepartmentId())){
					Department dDao = new Department();
					dDao.setDepartmentId(bean.getDepartmentId());
					if(dDao.load()){
						if(!BaseHelpUtils.isNullOrEmpty(dDao.getWeixinDepartmentId())){
							Object[] department = new Object[]{dDao.getWeixinDepartmentId()};
							params.put("department", department);
						}
					}
				}
			}
			params.put("email", bean.getCompanyEmail());
			params.put("userid", bean.getCompanyWeixin());
			params.put("name", bean.getEmployeeName());
			if(null != bean.getEmployeeNameEn()){
				params.put("english_name", bean.getEmployeeNameEn().trim());
			}
			params.put("gender", bean.getGender().toString());
			if(!WeixinUtils.updateUser(params)){
				errorMsg += "更新微信部门数据出错{" + MapUtils.toJSON(params) + "}";
			}
		}
		//邮箱数据更新
		if(!BaseHelpUtils.isNullOrEmpty(bean.getCompanyEmail())){
			Map<String, Object> params = new HashMap<>();
			if(updateType == 1){//改变部门归属
				if(!BaseHelpUtils.isNullOrEmpty(bean.getDepartmentId())){
					Department dDao = new Department();
					dDao.setDepartmentId(bean.getDepartmentId());
					if(dDao.load()){
						if(!BaseHelpUtils.isNullOrEmpty(dDao.getEmailDepartmentId())){
							Object[] department = new Object[]{dDao.getEmailDepartmentId()};
							params.put("department", department);
						}
					}
				}
			}
			params.put("userid", bean.getCompanyEmail());
			params.put("name", bean.getEmployeeName());
			params.put("gender", bean.getGender().toString());
			if(!BaseHelpUtils.isNullOrEmpty(bean.getMobile())){
				params.put("mobile", bean.getMobile().trim());
			}
			if(!TencentEmailUtils.updateUser(params)){
				errorMsg += "更新邮箱部门数据出错{" + MapUtils.toJSON(params) + "}";
			}
			
		}
		return errorMsg;
	}
	
	/**
	 * 同步员工座机号码
	 * 
	 * @param weixinId
	 * @param telephone
	 * @return
	 * @throws SQLException
	 */
	public static void updateEmployeeTelephone(int employeeId) throws SQLException{
		Employee dao = new Employee();
		dao.setEmployeeId(employeeId);
		if(dao.load()){
			if(!BaseHelpUtils.isNullOrEmpty(dao.getCompanyWeixin())){
				Map<String, Object> params = new HashMap<>();
				params.put("userid", dao.getCompanyWeixin());
				params.put("telephone", dao.getPhone());
				WeixinUtils.updateUser(params);
			}
			if(!BaseHelpUtils.isNullOrEmpty(dao.getCompanyEmail())){
				Map<String, Object> params = new HashMap<>();
				params.put("userid", dao.getCompanyEmail());
				params.put("tel", dao.getPhone());
				TencentEmailUtils.updateUser(params);
			}
		}		
	}
	
	/**
	 * 同步员工英文名称
	 * @param employeeId
	 * @throws SQLException
	 */
	public static void updateEmployeeEnglishName(int employeeId) throws SQLException{
		Employee dao = new Employee();
		dao.setEmployeeId(employeeId);
		if(dao.load()){
			if(!BaseHelpUtils.isNullOrEmpty(dao.getCompanyWeixin())){
				Map<String,Object> param = new HashMap<>();
				param.put("userid", dao.getCompanyWeixin());
				param.put("english_name", dao.getEmployeeNameEn());
				WeixinUtils.updateUser(param);
			}
		}
	}
}
