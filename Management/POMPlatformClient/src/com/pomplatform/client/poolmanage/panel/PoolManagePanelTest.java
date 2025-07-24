package com.pomplatform.client.poolmanage.panel;

import java.util.ArrayList;
import java.util.List;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.Img;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.HStack; 

public class PoolManagePanelTest extends HLayout implements HasHandlers {

    private Window parentWindow;
    private int imgNum = 5;
    private HStack starsLayout = null;

    public void initComponents() {
    	Canvas canvas = new Canvas();  
    	  
        starsLayout = new HStack();  
        starsLayout.setTop(50);  
        starsLayout.setMembersMargin(10);  
        starsLayout.setLayoutMargin(10);  
        starsLayout.setShowEdges(true);  
        starsLayout.setAnimateMembers(true);  
  
        final Img img_1 = createImage("star_blue.png","1"); 
        img_1.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int num = BaseHelpUtils.getIntValue(img_1.getAltText());
				setImgSrc(num);
			}
		});
        final Img img_2 = createImage("star_blue.png","2"); 
        img_2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int num = BaseHelpUtils.getIntValue(img_2.getAltText());
				setImgSrc(num);
			}
		});
        
        final Img img_3 = createImage("star_blue.png","3"); 
        img_3.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int num = BaseHelpUtils.getIntValue(img_3.getAltText());
				setImgSrc(num);
			}
		});
        final Img img_4 = createImage("star_blue.png","4"); 
        img_4.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int num = BaseHelpUtils.getIntValue(img_4.getAltText());
				setImgSrc(num);
			}
		});
        final Img img_5 = createImage("star_blue.png","5"); 
        img_5.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int num = BaseHelpUtils.getIntValue(img_5.getAltText());
				setImgSrc(num);
			}
		});
        starsLayout.addMember(img_1);  
        starsLayout.addMember(img_2);  
        starsLayout.addMember(img_3);  
        starsLayout.addMember(img_4);
        starsLayout.addMember(img_5);
  
        IButton showButton = new IButton();  
        showButton.setTitle("Show");  
        showButton.setIconOrientation("right");  
        showButton.setIcon("pieces/16/star_green.png");  
  
        IButton hideButton = new IButton();  
        hideButton.setTitle("Hide");  
        hideButton.setIcon("pieces/16/star_green.png");  
        hideButton.setIconOrientation("right");  
        hideButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
//                starsLayout.hideMember(greenImg);  
            }  
        });  
  
        showButton.addClickHandler(new ClickHandler() {  
            public void onClick(ClickEvent event) {  
//                starsLayout.showMember(greenImg);  
            }  
        });  
  
        HLayout hLayout = new HLayout();  
        hLayout.setMembersMargin(10);  
        hLayout.addMember(hideButton);  
        hLayout.addMember(showButton);  
        hLayout.setHeight(1);  
  
        canvas.addChild(hLayout);  
        canvas.addChild(starsLayout);  
        canvas.draw();
        
        addMember(canvas);
    }
    
    private void setImgSrc(int num) {
    	for(int i = 1;i<=imgNum;i++) {
			Img img = (Img) starsLayout.getMember(i-1);
			if(i <= num) {
				img.setSrc("star_yellow.png");
			}else {
				img.setSrc("star_blue.png");
			}
		}
    }
    
    private Img createImage(String src,String num) {  
        Img img = new Img(src);  
        img.setAppImgDir("pieces/48/");  
        img.setWidth(48);  
        img.setHeight(48); 
        img.setAltText(num);
        img.setLayoutAlign(Alignment.CENTER);  
        return img;  
    }  
    
    protected final HandlerManager handlerManager = new HandlerManager(this);
    protected final List<DataEditedHandler> __dataEditedHandler = new ArrayList<>();

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    public Window getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(Window parentWindow) {
        this.parentWindow = parentWindow;
    }
    
    
}
