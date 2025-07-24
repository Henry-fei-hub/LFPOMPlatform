
package com.pomplatform.client;

import java.util.HashMap;
import java.util.Map;

import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.ui.SmartGWTMainEntry;
import com.google.gwt.user.client.Cookies;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.BackgroundRepeat;
import com.smartgwt.client.types.VerticalAlignment;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class LoginWindow extends Window {

	private SmartGWTMainEntry entry = null;
	
	String [] imgSrcArra = new String[] {"erp_bg/bgImg_02.jpg", "erp_bg/bgImg_03.jpg", "erp_bg/bgImg_04.jpg",
    		"erp_bg/bgImg_05.jpg", "erp_bg/bgImg_06.jpg"};
	
	String [] dzImgSrcArra = new String[] {
		"erp_bg/dongzhi_01.jpg", "erp_bg/dongzhi_02.jpg"
	};
	
	String [] crSrcArra = new String[] {
			"erp_bg/xms_01.jpg", "erp_bg/xms_02.jpg", "erp_bg/xms_03.gif", "erp_bg/xms_03.jpg", "erp_bg/xms_04.jpg"
		};
	
	String [] NewYearday = new String[] {
			"erp_bg/yuandan_01.jpg", "erp_bg/yuandan_01.jpg", "erp_bg/yuandan_02.jpg", "erp_bg/yuandan_03.jpg"
		};
	
	String [] LabaFestival = new String[] {
			"erp_bg/laba_01.jpg", "erp_bg/laba_02.jpg"
		};
	
	String [] happy = new String[] {
			"erp_bg/dh_01.jpg"
		};
	
	
	String [] new_year = new String[] {
			"erp_bg/newYear_01.jpg", "erp_bg/newYear_02.jpg","erp_bg/newYear_03.jpg", "erp_bg/newYear_04.jpg", "erp_bg/newYear_05.jpg"
		};
	
	String [] yuan_xiao = new String[] {
			"erp_bg/yuanxiao_01.jpg", "erp_bg/yuanxiao_02.jpg","erp_bg/yuanxiao_03.jpg"
		};
	
	String [] springImgs = new String[] {
		"erp_bg/spring_01.jpg", "erp_bg/spring_02.jpg", "erp_bg/spring_03.jpg"
	};

	@Override
	public void destroy() {
		super.destroy();
		removeCookies();
	}
	
	public void removeCookies(){
		Cookies.removeCookie(ClientUtil.OPRERATORID_COOKIE);
		Cookies.removeCookie(ClientUtil.OPRERATORNAME_COOKIE);
		Cookies.removeCookie(ClientUtil.PRIVILEGE_COOKIE);
		Cookies.removeCookie(ClientUtil.AGENCY_COOKIE);
		Cookies.removeCookie(ClientUtil.DUTY_ID_COOKIE);
		Cookies.removeCookie(ClientUtil.COMPANYID_COOKIE);
	}

	public LoginWindow(String appName) {
		setPanel();
	}
	
	public void setPanel(){
		int randomNum = (int)(Math.random() * (springImgs.length));
    	String backImgSrc = springImgs[randomNum];
		String appTitle = "";
		String appName = "深圳市库博建筑设计事务所有限公司";
		//设置页面属性
		setWidth100();
		setHeight100();
		setShowEdges(false);
		setShowCloseButton(false);
		setShowMinimizeButton(false);
		setShowTitle(false);
		setShowHeader(false);
		setAlign(Alignment.CENTER);
		setAlign(VerticalAlignment.CENTER);
		setCanDrag(false);
		setCanDragReposition(false);
		setCanDragResize(false);
		
        Label lb = new Label();  
		lb.setHeight100();  
		lb.setWidth100();
		lb.setBaseStyle("customBackgroundTwo");
		lb.setAlign(Alignment.CENTER);  
		lb.setValign(VerticalAlignment.CENTER); 
		lb.setLayoutAlign(Alignment.CENTER);
        addMember(lb);

		VLayout layout = new VLayout();
		layout.setBackgroundImage(backImgSrc);
		layout.setBackgroundRepeat(BackgroundRepeat.NO_REPEAT);
		layout.setStyleName("login_background");
		layout.setWidth100();
		layout.setHeight100();
		layout.setAlign(Alignment.CENTER);
		layout.setAlign(VerticalAlignment.CENTER);
		
		HLayout centerLayout = new HLayout();
		centerLayout.setBackgroundColor("rgba(51,51,51,0.5)");
		VLayout cleftLayout = new VLayout();
		cleftLayout.setWidth("50%");
		centerLayout.setHeight(480);
		centerLayout.addMember(cleftLayout);
		
		VLayout crightLayout = new VLayout();
		crightLayout.setWidth("50%");
		centerLayout.addMember(crightLayout);
		
		Label titleOne = new Label();  
		titleOne.setHeight("30%");  
		titleOne.setWidth100();
		titleOne.setAlign(Alignment.CENTER);  
		titleOne.setValign(VerticalAlignment.CENTER);  
		titleOne.setContents(appTitle);
		titleOne.setBaseStyle("customRadioTitleTwo");
		layout.addMember(titleOne);
		lb.addChild(layout);
		layout.addMember(centerLayout);
        
		
		String leftLabelContent = "<span style='border-left: 2px solid; font-size: 24px; padding-left: 20; margin-left: 20; margin-right: 40;'>" + appName+ "</span>";
		
		HLayout logoTopBlank = new HLayout();
		logoTopBlank.setWidth100();
		logoTopBlank.setHeight(126);
		cleftLayout.addMember(logoTopBlank);
		
        Label nameLabel = new Label();  
//        nameLabel.setIcon("erp_bg/jalogo.png");
        nameLabel.setIconStyle("login_logo");
        nameLabel.setHeight(60);  
        nameLabel.setWidth100();
        nameLabel.setAlign(Alignment.RIGHT);  
        nameLabel.setValign(VerticalAlignment.TOP); 
        nameLabel.setContents(leftLabelContent);
        nameLabel.setBaseStyle("customRadioTitleThree");
        cleftLayout.addMember(nameLabel);
        
        LoginLayout loginLayout = new LoginLayout();
        loginLayout.setBackgroundColor("rgba(51,51,51,0.45)");
		loginLayout.setLoginWindow(this);
		loginLayout.setStyleName("loginLayoutClass");
		crightLayout.addMember(loginLayout);
		Map<String,Object> bodydefault = new HashMap<>();
		bodydefault.put("opacity", 0);
		this.setBodyDefaults(bodydefault);
		Label label = new Label();
        label.setHeight("30%");
        label.setWidth100();
        layout.addMember(label);
	}

	/**
	 * @return the entry
	 */
	public SmartGWTMainEntry getEntry() {
		return entry;
	}

	/**
	 * @param entry the entry to set
	 */
	public void setEntry(SmartGWTMainEntry entry) {
		this.entry = entry;
	}

}
