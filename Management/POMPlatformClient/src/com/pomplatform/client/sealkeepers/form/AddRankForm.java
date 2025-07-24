package com.pomplatform.client.sealkeepers.form;

import com.delicacy.client.BaseHelpUtils;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.PopupWindow;
import com.pomplatform.client.sealkeepers.panel.RankMaintenancePanel;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.types.LayoutPolicy;
import com.smartgwt.client.types.TitleOrientation;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.FormItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.toolbar.ToolStrip;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AddRankForm extends VLayout {
    TitleOrientation titleOrientation = TitleOrientation.LEFT;

    private PopupWindow parentWindow;
    private RankMaintenancePanel parentPanel;

    public PopupWindow getParentWindow() {
        return parentWindow;
    }

    public void setParentWindow(PopupWindow parentWindow) {
        this.parentWindow = parentWindow;
    }

    public RankMaintenancePanel getParentPanel() {
        return parentPanel;
    }

    public void setParentPanel(RankMaintenancePanel parentPanel) {
        this.parentPanel = parentPanel;
    }

    private TextItem dicTypeValueItem;
    private TextItem rateItem;

    public void onModuleLoad() {
        setWidth100();
        setHeight100();

        final DynamicForm form = new DynamicForm();
        form.setWidth100();
        form.setHeight100();

        dicTypeValueItem = new TextItem("dicTypeValue");
        dicTypeValueItem.setTitle("职级名称");
        dicTypeValueItem.setWidth("*");
        dicTypeValueItem.setRequired(true);

        rateItem = new TextItem("rate");
        rateItem.setTitle("职级系数");
        rateItem.setWidth("*");
        rateItem.setRequired(true);

        form.setFields(new FormItem[] {dicTypeValueItem, rateItem});

        addMember(form);

        ToolStrip toolStrip = new ToolStrip();
        toolStrip.setVPolicy(LayoutPolicy.FILL);
        toolStrip.setPadding(5);
        toolStrip.setHeight(40);
        toolStrip.setMembersMargin(5);
        toolStrip.setBottom(2);
        toolStrip.setWidth100();
        toolStrip.addFill();
        addMember(toolStrip);

        IButton sureButton = new IButton("确定");
        sureButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                Map<String, Object> params = new HashMap<>();
                checkData();
                params = form.getValues();
                params.put("opt_type", "addRank");
                DBDataSource.callOperation("EP_ProjectCommonProcess", params, new DSCallback() {
                    @Override
                    public void execute(DSResponse dsResponse, Object o, DSRequest dsRequest) {
                        if (dsResponse.getStatus() >= 0) {
                            getParentWindow().destroy();
                            getParentPanel().commonQuery();
                        }else{
                            SC.say("提示", dsResponse.getErrors().get("errorMsg").toString());
                        }
                    }
                });
            }
        });
        toolStrip.addMember(sureButton);

        IButton cancelButton = new IButton("取消");
        cancelButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {

            }
        });
        toolStrip.addMember(cancelButton);

    }

    /**
     * @author liubin
     * @description //TODO 提交时校验数据
     * @date 14:34 2020/1/10
     * @param []
     * @return void
     **/
    private void checkData() {
        if (null == dicTypeValueItem.getValue()) {
            SC.say("请输入新增的职级名称");
            return;
        }
        if (null == rateItem.getValue()) {
            SC.say("请输入职级系数");
            return;
        } else {
            BigDecimal bigDecimalValue = BaseHelpUtils.getBigDecimalValue(rateItem.getValue());
            if (bigDecimalValue.compareTo(BigDecimal.ZERO) <= 0) {
                SC.say("提示", "请输入大于的0的数据格式");
                return;
            }
        }
    }
}
