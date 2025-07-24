package com.pomplatform.client.employeenew.panel;

import com.delicacy.client.data.DataEditEvent;
import com.delicacy.client.data.DataEditedHandler;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.PopupWindow;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.smartgwt.client.data.Record;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.CheckboxItem;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.Map;

public class SearchSelectPanel extends AbstractWizadPage {

    private VLayout mainLayout ;
    private VLayout topLayout ;
    private HLayout bottonLayout ;

    private CheckboxItem selectItem1;
    private CheckboxItem selectItem2;
    private CheckboxItem selectItem3;
    private CheckboxItem selectItem4;
    private CheckboxItem selectItem5;
    private CheckboxItem selectItem6;
    private CheckboxItem selectItem7;
    private CheckboxItem selectItem8;
    private CheckboxItem selectItem9;
    private CheckboxItem selectItem10;
    private CheckboxItem selectItem11;
    private CheckboxItem selectItem12;
    private CheckboxItem selectItem13;
    private CheckboxItem selectItem14;
    private CheckboxItem selectItem15;
    private CheckboxItem selectItem16;
    private CheckboxItem selectItem17;
    private CheckboxItem selectItem18;
    private CheckboxItem selectItem19;
    private CheckboxItem selectItem20;
    private CheckboxItem selectItem21;
    private CheckboxItem selectItem22;
    private CheckboxItem selectItem23;
    private CheckboxItem selectItem24;
    private CheckboxItem selectItem25;
    private CheckboxItem selectItem26;
    private CheckboxItem selectItem27;
    private CheckboxItem selectItem28;
    private CheckboxItem selectItem29;
    private CheckboxItem selectItem30;
    private CheckboxItem selectItem31;
    private CheckboxItem selectItem32;
    private CheckboxItem selectItem33;
    private CheckboxItem selectItem34;
    private CheckboxItem selectItem35;
    private CheckboxItem selectItem36;
    private CheckboxItem selectItem37;
    private CheckboxItem selectItem38;
    private CheckboxItem selectItem39;
    private CheckboxItem selectItem40;
    private CheckboxItem selectItem41;
    private CheckboxItem selectItem42;

    private IButton saveButton;
    private IButton cancelButton;
    private Record record = new Record();
    public PopupWindow window;
    protected final HandlerManager handlerManager = new HandlerManager(this);

    public SearchSelectPanel(){
        //主面板
        mainLayout = new VLayout();
        mainLayout.setBackgroundColor("#FFF");
        mainLayout.setHeight("100%");
        mainLayout.setWidth100();
        addMember(mainLayout);

        topLayout = new VLayout();
        topLayout.setHeight("90%");
        topLayout.setWidth("100%");
        mainLayout.addMember(topLayout);

        bottonLayout = new HLayout();
        bottonLayout.setHeight("10%");
        bottonLayout.setWidth("100%");
        mainLayout.addMember(bottonLayout);
        bottonLayout.setLayoutLeftMargin(100);

        saveButton = new IButton("确定");
        bottonLayout.addMember(saveButton);
        saveButton.setAlign(Alignment.CENTER);
        saveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                selectDate();
                DataEditEvent dee = new DataEditEvent();
                dee.setData(record);
                fireEvent(dee);
                if (null == getPanel()){
                    return;
                }
                getPanel().destroy();
            }
        });


        cancelButton = new IButton("取消");
        bottonLayout.addMember(cancelButton);
        cancelButton.setAlign(Alignment.CENTER);
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (null == getPanel()){
                    return;
                }
                getPanel().destroy();
            }
        });

        DynamicForm dynamicForm = new DynamicForm();
        dynamicForm.setWidth("100%");
        dynamicForm.setHeight("100%");
        dynamicForm.setNumCols(4);
        dynamicForm.setMargin(10);
        topLayout.addMember(dynamicForm);

        selectItem1 = new CheckboxItem("员工编号");
        selectItem2 = new CheckboxItem("员工姓名");
        selectItem3 = new CheckboxItem("业务部门");
        selectItem4 = new CheckboxItem("部门");
        selectItem5 = new CheckboxItem("角色");
        selectItem6 = new CheckboxItem("职级");
        selectItem7 = new CheckboxItem("状态");
        selectItem8 = new CheckboxItem("是否为部门负责人");
        selectItem9 = new CheckboxItem("性别");
        selectItem10 = new CheckboxItem("职位名称");
        selectItem11 = new CheckboxItem("入职日期");
        selectItem12 = new CheckboxItem("离职日期");
        selectItem13 = new CheckboxItem("入职年份");
        selectItem14 = new CheckboxItem("入职月份");
        selectItem15 = new CheckboxItem("离职年份");
        selectItem16 = new CheckboxItem("离职月份");
        selectItem17 = new CheckboxItem("出生月份");
        selectItem18 = new CheckboxItem("参与考勤");
        selectItem19 = new CheckboxItem("手机");
        selectItem20 = new CheckboxItem("邮箱");
        selectItem21 = new CheckboxItem("身份证号");
        selectItem22 = new CheckboxItem("家庭地址");
        selectItem23 = new CheckboxItem("学历");
        selectItem24 = new CheckboxItem("学位");
        selectItem25 = new CheckboxItem("名族");
        selectItem26 = new CheckboxItem("婚姻状况");
        selectItem27 = new CheckboxItem("工作地");
        selectItem28 = new CheckboxItem("籍贯");
        selectItem29 = new CheckboxItem("户口所在地");
        selectItem30 = new CheckboxItem("开始工作时间");
        selectItem31 = new CheckboxItem("社保电脑号");
        selectItem32 = new CheckboxItem("公积金账号");
        selectItem33 = new CheckboxItem("转正日期");
        selectItem34 = new CheckboxItem("试用期");
        selectItem35 = new CheckboxItem("合同开始的年份");
        selectItem36 = new CheckboxItem("合同开始的月份");
        selectItem37 = new CheckboxItem("合同结束的年份");
        selectItem38 = new CheckboxItem("合同结束的月份");
        selectItem39 = new CheckboxItem("所属公司");
        selectItem40 = new CheckboxItem("银行卡号");
        selectItem41 = new CheckboxItem("企业微信账号");
        selectItem42= new CheckboxItem("企业邮箱");

        //初始化选中的选项
        initData();

        dynamicForm.setItems(selectItem1 , selectItem2 , selectItem3 , selectItem4 , selectItem5 , selectItem6 , selectItem7 , selectItem8 , selectItem9 , selectItem10 , selectItem11
                            ,selectItem12 , selectItem13 , selectItem14 , selectItem15 , selectItem16 , selectItem17 , selectItem18 , selectItem19 , selectItem20 , selectItem21 , selectItem22
                            ,selectItem23 , selectItem24 , selectItem25 , selectItem26 , selectItem27 , selectItem28 , selectItem29 , selectItem30 , selectItem31 , selectItem32 , selectItem33
                            ,selectItem34 , selectItem35 , selectItem36 , selectItem37 , selectItem38 , selectItem39 , selectItem40 , selectItem41 , selectItem42);
    }

    private void selectDate() {
        if (selectItem1.getValueAsBoolean()){
            record.setAttribute("1",1);
        }
        if (selectItem2.getValueAsBoolean()){
            record.setAttribute("2",2);
        }
        if (selectItem3.getValueAsBoolean()){
            record.setAttribute("3",3);
        }
        if (selectItem4.getValueAsBoolean()){
            record.setAttribute("4",4);
        }
        if (selectItem5.getValueAsBoolean()){
            record.setAttribute("5",5);
        }
        if (selectItem6.getValueAsBoolean()){
            record.setAttribute("6",6);
        }
        if (selectItem7.getValueAsBoolean()){
            record.setAttribute("7",7);
        }
        if (selectItem8.getValueAsBoolean()){
            record.setAttribute("8",8);
        }
        if (selectItem9.getValueAsBoolean()){
            record.setAttribute("9",9);
        }
        if (selectItem10.getValueAsBoolean()){
            record.setAttribute("10",10);
        }
        if (selectItem11.getValueAsBoolean()){
            record.setAttribute("11",11);
        }
        if (selectItem12.getValueAsBoolean()){
            record.setAttribute("12",12);
        }
        if (selectItem13.getValueAsBoolean()){
            record.setAttribute("13",13);
        }
        if (selectItem14.getValueAsBoolean()){
            record.setAttribute("14",14);
        }
        if (selectItem15.getValueAsBoolean()){
            record.setAttribute("15",15);
        }
        if (selectItem16.getValueAsBoolean()){
            record.setAttribute("16",16);
        }
        if (selectItem17.getValueAsBoolean()){
            record.setAttribute("17",17);
        }
        if (selectItem18.getValueAsBoolean()){
            record.setAttribute("18",18);
        }
        if (selectItem19.getValueAsBoolean()){
            record.setAttribute("19",19);
        }
        if (selectItem20.getValueAsBoolean()){
            record.setAttribute("20",20);
        }
        if (selectItem21.getValueAsBoolean()){
            record.setAttribute("21",21);
        }
        if (selectItem22.getValueAsBoolean()){
            record.setAttribute("22",22);
        }
        if (selectItem23.getValueAsBoolean()){
            record.setAttribute("23",23);
        }
        if (selectItem24.getValueAsBoolean()){
            record.setAttribute("24",24);
        }
        if (selectItem25.getValueAsBoolean()){
            record.setAttribute("25",25);
        }
        if (selectItem26.getValueAsBoolean()){
            record.setAttribute("26",26);
        }
        if (selectItem27.getValueAsBoolean()){
            record.setAttribute("27",27);
        }
        if (selectItem28.getValueAsBoolean()){
            record.setAttribute("28",28);
        }
        if (selectItem29.getValueAsBoolean()){
            record.setAttribute("29",29);
        }
        if (selectItem30.getValueAsBoolean()){
            record.setAttribute("30",30);
        }
        if (selectItem31.getValueAsBoolean()){
            record.setAttribute("31",31);
        }
        if (selectItem32.getValueAsBoolean()){
            record.setAttribute("32",32);
        }
        if (selectItem33.getValueAsBoolean()){
            record.setAttribute("33",33);
        }
        if (selectItem34.getValueAsBoolean()){
            record.setAttribute("34",34);
        }
        if (selectItem35.getValueAsBoolean()){
            record.setAttribute("35",35);
        }
        if (selectItem36.getValueAsBoolean()){
            record.setAttribute("36",36);
        }
        if (selectItem37.getValueAsBoolean()){
            record.setAttribute("37",37);
        }
        if (selectItem38.getValueAsBoolean()){
            record.setAttribute("38",38);
        }
        if (selectItem39.getValueAsBoolean()){
            record.setAttribute("39",39);
        }
        if (selectItem40.getValueAsBoolean()){
            record.setAttribute("40",40);
        }
        if (selectItem41.getValueAsBoolean()){
            record.setAttribute("41",41);
        }
        if (selectItem42.getValueAsBoolean()){
            record.setAttribute("42",42);
        }
    }

    @Override
    public Map getValuesAsMap() {
        return null;
    }

    @Override
    public boolean checkData() {
        return false;
    }

    @Override
    public void startEdit() {

    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }

    public HandlerRegistration addDataEditedHandler(DataEditedHandler handler) {
        return handlerManager.addHandler(DataEditEvent.TYPE, handler);
    }

    public PopupWindow getPanel() {
        return window;
    }

    public void setPanel(PopupWindow window) {
        this.window = window;
    }

    /**
     * 初始化加载查询条件
     */
    public void initData(){
        selectItem1.setValue(true);
        selectItem2.setValue(true);
        selectItem3.setValue(true);
        selectItem4.setValue(true);
        selectItem5.setValue(true);
        selectItem6.setValue(true);
        selectItem7.setValue(true);
        selectItem9.setValue(true);
        selectItem10.setValue(true);
        selectItem13.setValue(true);
        selectItem14.setValue(true);
        selectItem15.setValue(true);
        selectItem16.setValue(true);
        selectItem17.setValue(true);
        selectItem18.setValue(true);
    }
}
