package com.pomplatform.client;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.PasswordItem;
import com.smartgwt.client.widgets.form.fields.RadioGroupItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;

public class ForgetPwdLayout extends VLayout {

    public final static long DAY_TIMEMILLIS = 86400000L;
    private final Logger __logger = Logger.getLogger("");
    private DynamicForm form;
    private Label achieveCodeBtn;
    private Label yzBtn;
    private Label sureBtn;

    public ForgetPwdLayout() {
        setWidth100();
        setHeight100();
        setLayoutAlign(Alignment.CENTER);
        setLayoutAlign(VerticalAlignment.CENTER);
        setBackgroundColor("#4286B7");
        setMembersMargin(10);
        setPadding(10);
        
        form = new DynamicForm();
        form.setHeight("80%");
        form.setWidth("80%");
        form.setNumCols(2);
        form.setLayoutAlign(Alignment.CENTER);
        form.setLayoutAlign(VerticalAlignment.CENTER);
        form.setTitleOrientation(TitleOrientation.LEFT); 
        addMember(form);
        TextItem mobileItem = new TextItem("mobile", "<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;'>手机号码</span></i>");
        mobileItem.setStartRow(true);
        mobileItem.setColSpan(2);
        mobileItem.setHeight(35);
        mobileItem.setWidth(300);
        mobileItem.setTitleStyle("customRadioTitleOne");
        mobileItem.setRequired(true);
        mobileItem.setRequiredMessage("请输入手机号码");
        
        TextItem companyEmailItem = new TextItem("companyEmail", "<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;'>企业邮箱</span></i>");
        companyEmailItem.setRequired(true);
        companyEmailItem.setWidth(300);
        companyEmailItem.setColSpan(2);
        companyEmailItem.setTitleStyle("customRadioTitleOne");
        companyEmailItem.setHeight(35);
        companyEmailItem.setStartRow(true);
        companyEmailItem.setRequiredMessage("请输入企业邮箱");

        RadioGroupItem radios = new RadioGroupItem("验证方式");
        radios.setStartRow(true);
        radios.setWidth(300);
        radios.setHeight(35);
        radios.setTitleStyle("customRadioTitleFour");
        radios.setVertical(false);
        radios.setValueMap("手机短息","企业邮箱");
        
        TextItem codeItem = new TextItem("code", "<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;'>验证码</span></i>");
        codeItem.setWidth(300);
        codeItem.hide();
        codeItem.setColSpan(2);
        codeItem.setTitleStyle("customRadioTitleOne");
        codeItem.setHeight(35);
        codeItem.setStartRow(true);
        
        PasswordItem passwordItem = new PasswordItem("password", "<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;'>新密码</span></i>");
        passwordItem.setWidth(300);
        passwordItem.setColSpan(2);
        passwordItem.hide();
        passwordItem.setTitleStyle("customRadioTitleOne");
        passwordItem.setHeight(35);
        passwordItem.setStartRow(true);
        
        PasswordItem rePasswordItem = new PasswordItem("rePassword", "<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;'>确认密码</span></i>");
        rePasswordItem.setWidth(300);
        rePasswordItem.setColSpan(2);
        rePasswordItem.hide();
        rePasswordItem.setTitleStyle("customRadioTitleOne");
        rePasswordItem.setHeight(35);
        rePasswordItem.setStartRow(true);
        
        form.setFields(mobileItem, companyEmailItem,radios,codeItem,passwordItem,rePasswordItem);
        
        achieveCodeBtn = new Label();
        achieveCodeBtn.setBorder("solid 2px #FFF;border-radius:5px");
        achieveCodeBtn.setWidth("50%");
        achieveCodeBtn.setHeight(35);
        achieveCodeBtn.setContents("<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>获取验证码</span></i>");
        achieveCodeBtn.setAlign(Alignment.CENTER);
        achieveCodeBtn.setLayoutAlign(Alignment.CENTER);
        addMember(achieveCodeBtn);
        achieveCodeBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	//获取验证手机号码、企业邮箱和验证方式
            	String mobile = BaseHelpUtils.getString(mobileItem.getValue());
            	if(BaseHelpUtils.isNullOrEmpty(mobile)){
            		SC.say("提示","请输入您的手机号码进行验证");
            		return;
            	}
            	String companyEmail = BaseHelpUtils.getString(companyEmailItem.getValue());
            	if(BaseHelpUtils.isNullOrEmpty(companyEmail)){
            		SC.say("提示","请输入您的企业邮箱进行验证");
            		return;
            	}
            	String codeType = BaseHelpUtils.getString(radios.getValue());
            	if(BaseHelpUtils.isNullOrEmpty(codeType)){
            		SC.say("提示","请选择您的验证方式");
            		return;
            	}
            	Map<String,Object> param = new HashMap<>();
        		param.put("mobile",mobile);
        		param.put("companyEmail",companyEmail);
        		param.put("codeType",codeType);
        		param.put("optType","OnCheckEmployeeInfo");
                //验证方法 
                DBDataSource.callOperation("EP_LoginProcessor", "find",param, new DSCallback() {
                    @SuppressWarnings({ "unchecked", "rawtypes" })
					@Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                        	//获取返回信息
                        	Map<String,Object> map = dsResponse.getAttributeAsMap("userData");
                			if(!BaseHelpUtils.isNullOrEmpty(map)){
                				//获取验证码和职员Id
                				setCode(BaseHelpUtils.getString(map.get("code")));
                				setEmployeeId(BaseHelpUtils.getIntValue(map.get("employeeId")));
                				achieveCodeBtn.hide();
                            	yzBtn.show();
                            	mobileItem.setDisabled(true);
                            	companyEmailItem.setDisabled(true);
                            	codeItem.show();
                            	radios.hide();
                			}
                        }else {
                        	Map errors = dsResponse.getErrors();
                        	SC.say("验证失败：" + errors.get("errorMsg"));
                        }
                    }
                });
            }
        });
        
        yzBtn = new Label();
        yzBtn.hide();
        yzBtn.setBorder("solid 2px #FFF;border-radius:5px");
        yzBtn.setWidth("50%");
        yzBtn.setHeight(35);
        yzBtn.setContents("<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>验证</span></i>");
        yzBtn.setAlign(Alignment.CENTER);
        yzBtn.setLayoutAlign(Alignment.CENTER);
        addMember(yzBtn);
        yzBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	//获取输入的验证码
            	String inputCode = BaseHelpUtils.getString(codeItem.getValue());
            	if(BaseHelpUtils.isNullOrEmpty(getCode()) || getEmployeeId() ==0){
            		SC.say("提示","操作异常，无法进行验证");
            		return;
				}
            	if(inputCode != getCode()){//验证通过
            		SC.say("提示","操作异常，您输入的验证码有误");
            		return;
            	}
            	yzBtn.hide();
            	sureBtn.show();
            	codeItem.hide();
            	passwordItem.show();
            	rePasswordItem.show();
            }
        });
        
        sureBtn = new Label();
        sureBtn.hide();
        sureBtn.setBorder("solid 2px #FFF;border-radius:5px");
        sureBtn.setWidth("50%");
        sureBtn.setHeight(35);
        sureBtn.setContents("<i><span style='color:#FFF;font-family:FangSong; font-size:18px; text-overflow:ellipsis;font-style:normal;cursor:pointer;'>重置</span></i>");
        sureBtn.setAlign(Alignment.CENTER);
        sureBtn.setLayoutAlign(Alignment.CENTER);
        addMember(sureBtn);
        sureBtn.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
            	//获取输入的新密码和确认密码
            	String password = BaseHelpUtils.getString(passwordItem.getValue());
            	String rePassword = BaseHelpUtils.getString(rePasswordItem.getValue());
            	if(BaseHelpUtils.isNullOrEmpty(password)){
            		SC.say("提示","请输入您的新密码！");
            		return;
            	}
            	if(BaseHelpUtils.isNullOrEmpty(rePassword)){
            		SC.say("提示","请输入您的确认密码！");
            		return;
            	}
            	if(password != rePassword){
            		SC.say("提示","您输入的新密码和确认密码不一致");
            		return;
            	}
            	Map<String,Object> param = new HashMap<>();
        		param.put("employeeId",getEmployeeId());
        		param.put("password",password);
        		param.put("optType","OnUpdateEmpPwd");
                //验证方法 
                DBDataSource.callOperation("EP_LoginProcessor", "find",param, new DSCallback() {
                    @SuppressWarnings({"rawtypes" })
					@Override
                    public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                        	SC.say("重置成功");
                        	if (getParWindow() == null) {
            					return;
            				}
            				getParWindow().destroy();
                        }else {
                        	Map errors = dsResponse.getErrors();
                        	SC.say("操作失败：" + errors.get("errorMsg"));
                        }
                    }
                });
            }
        });
        
    }

    /**
     * 验证方法
     *
     * @throws java.lang.Exception
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void doLogin() throws Exception {
        Map param = new LinkedHashMap();
        param.put("employeeNo", form.getValueAsString("username"));
        param.put("employeePassword", form.getValueAsString("password"));
        param.put("applicationId", ClientUtil.getApplicationID());

        String message = MapUtils.toJSON(param);
        //新登录方法 
        DBDataSource.callOperation("EP_EmployeeLogin", "login",message, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {

                } else {
                    Map errors = dsResponse.getErrors();
                    SC.say("Login failure" + errors.get("errorMsg"));
                }
            }
        });
    }

    private String code;
    private int employeeId;
    private Window parWindow;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public Window getParWindow() {
		return parWindow;
	}

	public void setParWindow(Window parentWindow) {
		this.parWindow = parentWindow;
	}

}
