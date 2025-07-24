package com.pomplatform.client;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.DES;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.BCollection;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.HttpCookie;
import com.delicacy.client.process.EmployeeWithRF;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.storage.client.Storage;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.BlurbItem;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.KeyPressEvent;
import com.smartgwt.client.widgets.form.fields.events.KeyPressHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

/**
 *
 * @author Cao GX
 */
public class LoginLayout extends VLayout {

    public final static long DAY_TIMEMILLIS = 86400000L;
    private final Logger __logger = Logger.getLogger("");
    final DynamicForm loginForm;
    private LoginWindow loginWindow = null;
    
    
    

    public LoginLayout() {
    	
    	setWidth(590);
        setHeight100();
        setLayoutAlign(Alignment.LEFT);
        setLayoutAlign(VerticalAlignment.CENTER);
        
        Label topLable = new Label();
        topLable.setHeight(130);
        topLable.setAlign(Alignment.CENTER);
        topLable.setContents("<span style='color: #FFF; font-size: 24; font-family: Microsoft YaHei;'>欢迎登录</span>");
        addMember(topLable);
        
        loginForm = new DynamicForm();
        loginForm.setHeight(160);
        loginForm.setWidth("85%");
        loginForm.setNumCols(2);
        loginForm.setLayoutAlign(Alignment.CENTER);
        loginForm.setLayoutAlign(VerticalAlignment.CENTER);
        loginForm.setTitleOrientation(TitleOrientation.TOP); 
        addMember(loginForm);
        
        BlurbItem blurbItem = new BlurbItem("loginFailure");
        blurbItem.setVisible(false);
        blurbItem.setColSpan(2);
        blurbItem.setWidth("*");
        blurbItem.setAlign(Alignment.CENTER);
        blurbItem.setDefaultValue("User name or password error,please re-enter");
        blurbItem.setCellStyle("formCellError");
        
        String employeeNo = Cookies.getCookie(ClientUtil.OPRERATORNO_COOKIE);
        TextItem textItem = new TextItem("username", "<i><span style='color:#FFF;font-family: Microsoft YaHei; font-size: 15px; text-overflow:ellipsis;font-style:normal;font-weight: normal;'>工号/手机号/企业邮箱</span></i>");
        textItem.setStartRow(true);
        textItem.setUsePlaceholderForHint(true);
        textItem.setColSpan(2);
        textItem.setTitleStyle("customRadioTitleOne");
        textItem.setHeight(46);
        textItem.setWidth("*");
        textItem.setRequired(true);
        if (employeeNo != null && employeeNo.trim().length() > 0) {
            textItem.setValue(employeeNo);
        }
        textItem.setRequiredMessage("Please enter user ID.");
        textItem.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent keyPressEvent) {
                if (keyPressEvent.getKeyName() != null && keyPressEvent.getKeyName().equals("Enter")) {
                    loginForm.focusInItem("password");
                }
            }
        });
        
        PasswordItem passwordItem = new PasswordItem("password", "<i><span style='color:#FFF;font-family: Microsoft YaHei; font-size: 15px; text-overflow:ellipsis;font-style:normal;font-weight: normal;'>密码</span></i>");
        passwordItem.setRequired(true);
//        passwordItem.setShowTitle(false);
        passwordItem.setWidth("*");
        passwordItem.setColSpan(2);
        passwordItem.setUsePlaceholderForHint(true);
        passwordItem.setTitleStyle("customRadioTitleOne");
        passwordItem.setHeight(46);
        passwordItem.setStartRow(true);
        passwordItem.setRequiredMessage("Please enter password.");
        passwordItem.addKeyPressHandler(new KeyPressHandler() {
            @Override
            public void onKeyPress(KeyPressEvent keyPressEvent) {
                if (keyPressEvent.getKeyName() != null && keyPressEvent.getKeyName().equals("Enter")) {
                    if (loginForm.validate()) {
                        try {
                            doLogin();
                        } catch (Exception ex) {
                            Logger.getLogger(LoginLayout.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        });

        if (!GWT.isProdMode()) {
            // 开发模式
            textItem.setDefaultValue("jsh");
            passwordItem.setDefaultValue("1");
        }

        loginForm.setFields(textItem, passwordItem, blurbItem);
        
        HLayout msgLayout = new HLayout();
        msgLayout.setHeight(73);
        msgLayout.setWidth("85%");
        msgLayout.setLayoutAlign(Alignment.CENTER);
        addMember(msgLayout);
        
        Label codeBtn = new Label();
        codeBtn.setWidth("60%");
        codeBtn.setHeight100();
        codeBtn.setIcon("erp_bg/scanCode.png");
        codeBtn.setContents("<i><span style='color:#FFF;font-family: Microsoft YaHei; font-size: 16px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>扫码登录</span></i>");
        codeBtn.setAlign(Alignment.LEFT);
        codeBtn.setLayoutAlign(Alignment.CENTER);
        codeBtn.setLayoutAlign(VerticalAlignment.CENTER);
        msgLayout.addMember(codeBtn);
        codeBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Map<String, Object> params = new HashMap<>();
            	params.put("systemConfigId", 3);
            	DBDataSource.callOperation("ST_SystemConfig", "findUsingKey", params, new DSCallback() {
					
					@Override
					public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
						if(dsResponse.getStatus() >= 0){
							String goUrl = dsResponse.getData()[0].getAttribute("imagePath");
							if(BaseHelpUtils.isNullOrEmpty(goUrl)){
								SC.say("未设置跳转链接，请联系管理员");
							}else{
								Window.Location.replace(goUrl);
							}
							
						}else{
							SC.say("该系统暂未开通该功能, 请联系管理员。");
						}
						
					}
				});
			}
		});
        
        Label forgerBtn = new Label();
        forgerBtn.setWidth("40%");
        forgerBtn.setHeight100();
        forgerBtn.setContents("<i><span style='color:#FFF;font-family: Microsoft YaHei; font-size:16px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>忘记密码?</span></i>");
        forgerBtn.setAlign(Alignment.RIGHT);
        forgerBtn.setLayoutAlign(Alignment.CENTER);
        msgLayout.addMember(forgerBtn);
        forgerBtn.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				GWT.runAsync(new RunAsyncCallback() {
					@Override
					public void onFailure(Throwable reason) {
						SC.say("failure to download code");
					}
					@Override
					public void onSuccess() {
						PopupWindow popupWindow = new PopupWindow("忘记密码信息验证及密码重置");
						popupWindow.setWidth("30%");
						popupWindow.setHeight("30%");
						ForgetPwdLayout panel = new ForgetPwdLayout();
						panel.setParWindow(popupWindow);
						popupWindow.addItem(panel);
						popupWindow.centerInPage();
						popupWindow.show();
					}
				});
			}
		});
        
        Label loginBtn = new Label();
        loginBtn.setBackgroundColor("#3da8f5");
        loginBtn.setWidth("85%");
        loginBtn.setHeight(58);
        loginBtn.setBorder("solid 2px #3da8f5; border-radius: 8px");
        loginBtn.setContents("<i><span style='color:#FFF;font-family: Microsoft YaHei; font-size:22px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>登&nbsp;&nbsp;录</span></i>");
        loginBtn.setAlign(Alignment.CENTER);
        loginBtn.setLayoutAlign(Alignment.CENTER);
        addMember(loginBtn);
        loginBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if (loginForm.validate()) {
                    try {
                        doLogin();
                    } catch (Exception ex) {
                        Logger.getLogger(LoginLayout.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        
    }
    
    /**
     * 登录方法
     *
     * @throws java.lang.Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void doLogin() throws Exception {
        Map param = new LinkedHashMap();
        param.put("employeeNo", loginForm.getValueAsString("username"));
        param.put("employeePassword", loginForm.getValueAsString("password"));
        param.put("applicationId", ClientUtil.getApplicationID());
        param.put("loginType", 1);

        String message = MapUtils.toJSON(param);
        DES des = new DES(DBDataSource.PUBLIC_KEY);

        //新登录方法 
        DBDataSource.callOperation("EP_EmployeeLogin", "login", des.ENC(message), new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    BCollection<EmployeeWithRF> bc = new BCollection<>();
                    Storage sta = Storage.getLocalStorageIfSupported();
                    if (sta != null) {
                        sta.setItem("EMPLOYEEINFO", bc.toJSON());
                    }
                    Record result = dsResponse.getData()[0];
                    String employeeNo = result.getAttribute("employeeNo");
                    String employeeName = result.getAttribute("employeeName");
                    String[] privileges = result.getAttributeAsStringArray("functions");
                    String agency = result.getAttribute("agency");
                    String employeeId = result.getAttribute("employeeId");
                    String departmentId = result.getAttribute("departmentId");
                    String roleTypeId = result.getAttribute("roleId");
                    String plateId = result.getAttribute("plateId");
                    String companyId = result.getAttribute("companyId");
                    String dutyId = result.getAttribute("dutyId");
                    String companyNo = result.getAttribute("companyNo");
                    String photo = result.getAttribute("photo");
                    HttpCookie hc = new HttpCookie();
                    hc.setOperatorId(ClientUtil.checkAndGetIntValue(result.getAttribute("employeeId")));
                    hc.setOperatorName(result.getAttribute("employeeName"));
                    hc.setOperatorNo(result.getAttribute("employeeNo"));
                    hc.setDepartmentId(ClientUtil.checkAndGetIntValue(result.getAttribute("departmentId")));
                    hc.setRoleTypeId(ClientUtil.checkAndGetIntValue(result.getAttribute("roleId")));
                    hc.setPlateId(ClientUtil.checkAndGetIntValue(plateId));
                    hc.setHeadImg(photo);
                    hc.setToCookies();
                    StringBuilder sb = new StringBuilder();
                    if (privileges != null) {
                        for (int i = 0; i < privileges.length; i++) {
                            if (i > 0) {
                                sb.append(",");
                            }
                            sb.append(privileges[i]);
                        }
                    }
                    setCookies(employeeNo, employeeName, sb.toString(), agency, employeeId, departmentId, roleTypeId, plateId, companyId,
                    		dutyId, companyNo, photo);

                    getLoginWindow().hide();

                    if (getLoginWindow().getEntry() != null) {
                        getLoginWindow().getEntry().drawMainLayout();
                    }

                } else {
                    Map errors = dsResponse.getErrors();
                    SC.say("Login failure" + errors.get("errorMsg"));
                }
            }
        });
    }

    /**
     * 设置Cookie
     *
     * @param employeeno
     * @param employee
     * @param privilege
     * @param agency
     * @param employeeId
     * @param departmentId
     * @param roleTypeId
     */
    protected void setCookies(String employeeno, String employee, String privilege, String agency, String employeeId,
    		String departmentId, String roleTypeId, String plateId, String companyId,String dutyId, String companyNo, String headImg) {
        Date expires = new Date(System.currentTimeMillis() + DAY_TIMEMILLIS*60);
        Storage sta = Storage.getLocalStorageIfSupported();
        if (sta != null) {
            sta.setItem(ClientUtil.PRIVILEGE_COOKIE, privilege);
            if (agency != null && agency.length() > 0) {
                sta.setItem(ClientUtil.AGENCY_COOKIE, agency);
            } else {
                sta.removeItem(ClientUtil.AGENCY_COOKIE);
            }
            sta.setItem(ClientUtil.LAST_USED_TIME, String.valueOf(System.currentTimeMillis() + DAY_TIMEMILLIS));
            //向LocalStorage设置基础数据
            sta.setItem(ClientUtil.OPRERATORNO_COOKIE, employeeno);
            sta.setItem(ClientUtil.OPRERATORID_COOKIE, employeeId);
            sta.setItem(ClientUtil.OPRERATORNAME_COOKIE, employee);
            sta.setItem(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE, departmentId);
            sta.setItem(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE, roleTypeId);
            sta.setItem(ClientUtil.OPRERATOR_PLATEID_COOKIE, plateId);
            sta.setItem(ClientUtil.COMPANYID_COOKIE, companyId);
            sta.setItem(ClientUtil.COMPANYNO_COOKIE, companyNo);
            sta.setItem(ClientUtil.DUTY_ID_COOKIE, dutyId);
            sta.setItem(ClientUtil.HEAD_IMG, headImg);
        } else {
            Cookies.setCookie(ClientUtil.PRIVILEGE_COOKIE, privilege, expires);
            if (agency != null && agency.length() > 0) {
                Cookies.setCookie(ClientUtil.AGENCY_COOKIE, agency, expires);
            } else {
                Cookies.removeCookie(ClientUtil.AGENCY_COOKIE);
            }
        }

        Cookies.setCookie(ClientUtil.OPRERATORNO_COOKIE, employeeno, expires);
        Cookies.setCookie(ClientUtil.OPRERATORID_COOKIE, employeeId, expires);
        Cookies.setCookie(ClientUtil.OPRERATORNAME_COOKIE, employee, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_DEPARTMENTID_COOKIE, departmentId, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_ROLETYPEID_COOKIE, roleTypeId, expires);
        Cookies.setCookie(ClientUtil.OPRERATOR_PLATEID_COOKIE, plateId, expires);
        Cookies.setCookie(ClientUtil.COMPANYID_COOKIE, companyId, expires);
        Cookies.setCookie(ClientUtil.COMPANYNO_COOKIE, companyNo, expires);
        Cookies.setCookie(ClientUtil.DUTY_ID_COOKIE, dutyId, expires);
        Cookies.setCookie(ClientUtil.HEAD_IMG, headImg, expires);

    }

    public static String getUserName() {
        return Cookies.getCookie(ClientUtil.OPRERATORNAME_COOKIE);
    }

    /**
     * @return the loginWindow
     */
    public LoginWindow getLoginWindow() {
        return loginWindow;
    }

    /**
     * @param loginWindow the loginWindow to set
     */
    public void setLoginWindow(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;
    }

}
