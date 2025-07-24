package delicacy.otheraccount;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import delicacy.common.BaseHelpUtils;
import delicacy.common.MapUtils;
import delicacy.system.bean.BaseDepartment;
import delicacy.system.dao.Department;
import message.common.TencentEmailUtils;
import message.common.WeixinUtils;

public class DepartmentAccountUtils {

	private static final Logger LOGGER = Logger.getLogger(DepartmentAccountUtils.class);

	/**
	 * @Title: createDepartment 
	 * @Description: 创建第三方部门
	 * @param bean 
	 * @throws Exception 
	 * @return String
	 */
	public static String createDepartment(BaseDepartment bean) throws Exception {
		String errorMsg = "";
		Long wxId = null;
		Long emailId = null;
		Department dao = new Department();

		if (null != bean.getParentId()) {
			dao.clear();
			dao.setDepartmentId(bean.getParentId());
			if (dao.load()) {
				// 创建微信部门数据
				if (!BaseHelpUtils.isNullOrEmpty(dao.getWeixinDepartmentId())) {
					Long parentid = dao.getWeixinDepartmentId();
					Map<String, Object> params = new HashMap<>();
					params.put("name", bean.getDepartmentName());
					params.put("parentid", parentid);
					wxId = WeixinUtils.createDepartment(params);
					if (null == wxId) {
						errorMsg += String.format("创建微信部门失败{%1$s}  |", MapUtils.toJSON(params));
					}
				} else {
					errorMsg += String.format("创建微信部门失败{父级部门不存在微信邮箱ID parentId=%1$s }  |", bean.getParentId());
				}
				// 创建邮箱部门数据
				if (!BaseHelpUtils.isNullOrEmpty(dao.getEmailDepartmentId())) {
					Long parentid = dao.getEmailDepartmentId();
					Map<String, Object> params = new HashMap<>();
					params.put("name", bean.getDepartmentName());
					params.put("parentid", parentid);
					emailId = TencentEmailUtils.createDepartment(params);
					if (null == emailId) {
						errorMsg += String.format("创建邮箱部门失败{%1$s}  |", MapUtils.toJSON(params));
					}
				} else {
					errorMsg += String.format("创建邮箱部门失败{父级部门不存在企业邮箱ID parentId=%1$s }  |", bean.getParentId());
				}
			} else {
				errorMsg += String.format("创建部门失败{不存在父级departmentId =%1$s }  |", bean.getParentId());
			}
		}
		dao.clear();
		dao.setDepartmentId(bean.getDepartmentId());
		if (dao.load()) {
			if (null != wxId || null != emailId) {
				dao.setWeixinDepartmentId(wxId);
				dao.setEmailDepartmentId(emailId);
				dao.update();
			}
		}
		if (!BaseHelpUtils.isNullOrEmpty(errorMsg)) {
			LOGGER.info(errorMsg);
		}
		return errorMsg;
	}

	/**
	 * @Title: updateDepartment 
	 * @Description: 修改部门数据
	 * @param bean 
	 * @param type type == 1:表示需要改变部门归属父级部门 
	 * @throws Exception 
	 * @return String
	 */
	public static String updateDepartment(BaseDepartment bean, Integer type) throws Exception {
		String errorMsg = "";
		Department dao = new Department();
		if (null != bean.getParentId() && type == 1) {
			dao.setDepartmentId(bean.getParentId());
			dao.load();
		}
		// 改变微信部门数据
		if (!BaseHelpUtils.isNullOrEmpty(bean.getWeixinDepartmentId())) {
			Map<String, Object> params = new HashMap<>();
			params.put("id", bean.getWeixinDepartmentId());
			params.put("name", bean.getDepartmentName());
			if (type == 1) {
				if (!BaseHelpUtils.isNullOrEmpty(dao.getWeixinDepartmentId())) {
					params.put("parentid", dao.getWeixinDepartmentId());
				}
			}
			WeixinUtils.updateDepartment(params);
		}
		// 改变邮箱部门数据
		if (!BaseHelpUtils.isNullOrEmpty(bean.getEmailDepartmentId())) {
			Map<String, Object> params = new HashMap<>();
			params.put("id", bean.getEmailDepartmentId());
			params.put("name", bean.getDepartmentName());
			if (type == 1) {
				if (!BaseHelpUtils.isNullOrEmpty(dao.getEmailDepartmentId())) {
					params.put("parentid", dao.getEmailDepartmentId());
				}
			}
			TencentEmailUtils.updateDepartment(params);
		}
		return errorMsg;
	}

	/**
	 * @Title: deleteDepartment 
	 * @Description: 删除第三方部门数据 
	 * @param departmentId 
	 * @throws Exception 
	 * @return String
	 */
	public static String deleteDepartment(int departmentId) throws Exception {
		String errorMsg = "";
		Department dao = new Department();
		dao.setDepartmentId(departmentId);
		if (dao.load()) {
			// 删除微信部门 当微信部门下有子部门或有人员时是无法删除成功
			if (!BaseHelpUtils.isNullOrEmpty(dao.getWeixinDepartmentId())) {
				WeixinUtils.deleteDepartmentById(dao.getWeixinDepartmentId());
			}
			// 删除企业邮箱部门 当企业邮箱部门下有子部门或有人员时是无法删除成功
			if (!BaseHelpUtils.isNullOrEmpty(dao.getEmailDepartmentId())) {
				TencentEmailUtils.deleteDepartmentById(dao.getEmailDepartmentId());
			}
		}
		return errorMsg;
	}
}
