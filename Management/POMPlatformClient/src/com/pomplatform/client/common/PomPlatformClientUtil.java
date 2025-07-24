package com.pomplatform.client.common;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.GWT;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Cookies;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;

public class PomPlatformClientUtil extends ClientUtil{

    private static final Logger __logger = Logger.getLogger("");

    public static void showMessage(String message) {
        com.google.gwt.user.client.Window.alert(message);
    }
    // 常量
    public static String HOST_URL = GWT.getHostPageBaseURL();
    public static long DAYTIME = 86400000L;
    public static String ROLE_PLATEID_COOKIE = "role_plateId";
    public static String PROCESS_ID_COOKIE = "processId";
    public static String PROCESS_ICON_COOKIE = "processIcon";
    public static String DUTY_ID_COOKIE = "dutyId";
    public static String ROLE_DEPARTMENTID_COOKIE = "role_departmentId";
  	public static final int PARENT_PROCESS_TYPE_1 = 1;//报销类型父级1
  	public static final int PARENT_PROCESS_TYPE_2 = 12;//报销类型父级12
  	public static final int PARENT_PROCESS_TYPE_3 = 32;//报销类型父级32
  	public static final int PARENT_PROCESS_TYPE_4 = 38;//报销类型父级38
  	public static final int PARENT_PROCESS_TYPE_5 = 77;//父级流程——我的工作

    public static void clearCookies() {
    	if (Cookies.isCookieEnabled()) {
            Cookies.removeCookie(PRIVILEGE_COOKIE);
            Cookies.removeCookie(OPRERATORID_COOKIE);
            Cookies.removeCookie(OPRERATORNO_COOKIE);
            Cookies.removeCookie(OPRERATORNAME_COOKIE);
            Cookies.removeCookie(OPRERATOR_DEPARTMENTID_COOKIE);
            Cookies.removeCookie(OPRERATOR_ROLETYPEID_COOKIE);
            Cookies.removeCookie(OPRERATOR_PLATEID_COOKIE);
            Cookies.removeCookie(ROLE_PLATEID_COOKIE);
            Cookies.removeCookie(PROCESS_ID_COOKIE);
        }
        Storage sta = Storage.getLocalStorageIfSupported();
        if (sta != null) {
            sta.removeItem(PRIVILEGE_COOKIE);
            sta.removeItem(AGENCY_COOKIE);
            sta.removeItem(ROLE_PLATEID_COOKIE);
        }
    }

    /**
     * 根据当前登录者的角色获取其角色相关联的业务部门Id
     * @return
     */
    public static String getRolePlateId() {
        String rolePlateId = null;
        Storage sta = Storage.getLocalStorageIfSupported();
        if (sta != null) {
            if (sta.getItem(ROLE_PLATEID_COOKIE) != null) {
                rolePlateId = sta.getItem(ROLE_PLATEID_COOKIE);
            }
        } else if (Cookies.getCookie(ROLE_PLATEID_COOKIE) != null) {
            rolePlateId = Cookies.getCookie(ROLE_PLATEID_COOKIE);
        }
        return rolePlateId == null ? "" : rolePlateId;
    }
    
    /**
     * 根据当前登录者的角色获取其角色相关联的部门Id
     * @return
     */
    public static String getRoleDepartmentId() {
        String roleDepartmentId = null;
        Storage sta = Storage.getLocalStorageIfSupported();
        if (sta != null) {
            if (sta.getItem(ROLE_DEPARTMENTID_COOKIE) != null) {
                roleDepartmentId = sta.getItem(ROLE_DEPARTMENTID_COOKIE);
            }
        } else if (Cookies.getCookie(ROLE_DEPARTMENTID_COOKIE) != null) {
            roleDepartmentId = Cookies.getCookie(ROLE_DEPARTMENTID_COOKIE);
        }
        return roleDepartmentId == null ? "" : roleDepartmentId;
    }

    /**
     * map的key值，是流程的处理名字，value是流程的processId
     * @return
     */
    public static Map<String,String> getUserProcessId(int parentTypeId){
    	Map<String,String> map = new HashMap<>();
    	Storage sta = Storage.getLocalStorageIfSupported();
    	String str = sta.getItem(PROCESS_ID_COOKIE);
    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
    		String[] arr = str.split(",");
    		for(String tempStr : arr){
    			String[] tempArr = tempStr.split(":");
    			//获取父级ID
    			int parentId = BaseHelpUtils.getIntValue(tempArr[2]);
    			if(parentTypeId == parentId){
    				map.put(tempArr[0].replaceAll("\"", ""), tempArr[1]);
    			}
    		}
    	}
    	return map;
    }
    
    /**
     * map的key值，是流程的处理名字，value是流程的icon
     * @return
     */
    public static Map<String,String> getUserProcessIcon(int parentTypeId){
    	Map<String,String> map = new HashMap<>();
    	Storage sta = Storage.getLocalStorageIfSupported();
    	String str = sta.getItem(PROCESS_ICON_COOKIE);
    	if(!PomPlatformClientUtil.isNullOrEmpty(str)){
    		String[] arr = str.split(",");
    		for(String tempStr : arr){
    			String[] tempArr = tempStr.split(":");
    			//获取父级ID
    			int parentId = BaseHelpUtils.getIntValue(tempArr[2]);
    			if(parentTypeId == parentId){
    				map.put(tempArr[0].replaceAll("\"", ""), tempArr[1]);
    			}
    		}
    	}
    	return map;
    }
    
    
    /**
	 * 根据已有的信息，生成默认的主题：部门+姓名+主题+金额
	 * @return
	 */
	public static String getReimbursementTittle(Object departmentId, Object employeeId, Object title, Object amount,
			Object projectId) {
		StringBuilder sb = new StringBuilder();
		if (!ClientUtil.isNullOrZero(departmentId)) {
			String value = KeyValueManager.getValue("departments", departmentId.toString());
			if (null != value) {
				if (value.length() < 12) {
					sb.append(value);
					int length = 12 - value.length();
					if (length > 0) {
						for (int i = 0; i < length; i++) {
							sb.append("　");
						}
					}
				} else {
					sb.append(value.substring(0, 11)).append("　");
				}
			}
		}
		if (!ClientUtil.isNullOrEmpty(employeeId)) {
			String value = KeyValueManager.getValue("employees", employeeId.toString());
			if (null != value) {
				if (value.length() < 10) {
					sb.append(value);
					int length = 10 - value.length();
					if (length > 0) {
						for (int i = 0; i < length; i++) {
							sb.append("　");
						}
					}
				} else {
					sb.append(value.substring(0, 9)).append("　");
				}
			}
		}
		if (!ClientUtil.isNullOrEmpty(title)) {
			String value = title.toString();
			if (value.length() < 20) {
				sb.append(value);
				int length = 20 - value.length();
				if (length > 0) {
					for (int i = 0; i < length; i++) {
						sb.append("　");
					}
				}
			} else {
				sb.append(value.substring(0, 19)).append("　");
			}
		}
		if (!ClientUtil.isNullOrZero(amount)) {
			String value = CommonFormat.doubleFormat(ClientUtil.checkAndGetDoubleValue(amount));
			if (value.length() < 15) {
				sb.append(value);
				int length = 15 - value.length();
				if (length > 0) {
					for (int i = 0; i < length; i++) {
						sb.append("　");
					}
				}
			} else {
				sb.append(value.substring(0, 14)).append("　");
			}
		}

//			String value = KeyValueManager.getValue("projects", projectId.toString());
		String projectName = SyncDataUtil.getProjectName(BaseHelpUtils.getIntValue(projectId));
		sb.append(projectName);
		return sb.toString();
	}
    
	public static String getCompanyShortName() {
		int id = getCompanyId();
		String companyName = "杰恩";
		switch (id) {
		case 0:
			companyName = "杰恩";
			break;
		case 1:
			companyName = "博普森";
			break;
		case 2:
			companyName = "姜峰";
			break;
		case 3:
			companyName = "杰加";
			break;
		case 4:
			companyName = "武汉";
			break;
		case 5:
		case 13:
			companyName = "上海";
			break;
		case 6:
		case 12:
		case 14:
			companyName = "北京";
			break;
		case 7:
		case 10:
			companyName = "大连";
			break;
		case 8:
			companyName = "杰拓";
			break;
		case 9:
			companyName = "香港";
			break;
		default:
			break;
		}
		return companyName;
	}
}
