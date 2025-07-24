package com.pomplatform.client.plateproductionvaluecoefficients.form;

import com.delicacy.client.MapUtils;
import com.delicacy.client.data.ClientUtil;
import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.ui.AbstractWizadPage;
import com.delicacy.client.ui.DelicacyListGrid;
import com.pomplatform.client.plateproductionvaluecoefficients.datasource.DSProductionValueCoefficient;
import com.pomplatform.client.plateproductionvaluecoefficientstype.datasource.DSProductionValueCoefficientType;
import com.smartgwt.client.data.DSCallback;
import com.smartgwt.client.data.DSRequest;
import com.smartgwt.client.data.DSResponse;
import com.smartgwt.client.data.RecordList;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.ValuesManager;
import com.smartgwt.client.widgets.form.fields.IntegerItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.validator.IsStringValidator;
import com.smartgwt.client.widgets.form.validator.LengthRangeValidator;
import com.smartgwt.client.widgets.grid.ListGridRecord;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * 产值系数的新增和修改界面
 *
 * @author xiaolong
 */
public class ProductionValueCoefficientTypeDetailProductionValueCoefficient extends AbstractWizadPage {

    private static final Logger __logger = Logger.getLogger("产值系数的新增的界面");

    private DSCallback __startLoadedDetail;
    private DSCallback __endLoadedDetail;

    private DelicacyListGrid grid = new DelicacyListGrid(true);

    private final TextItem coefficientTypeItem;
    private final IntegerItem productionValueCoefficientTypeIdItem;
    private final IntegerItem employeeIdItem;

    private String shouldNotBeNull = "<font style=\"color:red;font-weight:bold;font-size:13px;\">＊</font>";

    public ProductionValueCoefficientTypeDetailProductionValueCoefficient() {

        VLayout mainLayout = new VLayout();
        mainLayout.setWidth100();
        mainLayout.setHeight100();

        DSProductionValueCoefficientType ds = DSProductionValueCoefficientType.getInstance();

        __form.setWidth100();
        __form.setHeight(60);

        coefficientTypeItem = new TextItem("coefficientType", shouldNotBeNull + "产值类型");
        coefficientTypeItem.setRequired(true);
        coefficientTypeItem.setWidth("*");

        IsStringValidator coefficientTypeValidator = new IsStringValidator();
        LengthRangeValidator coefficientTypeLengthValidator = new LengthRangeValidator();
        coefficientTypeLengthValidator.setMax(255);
        coefficientTypeItem.setValidators(coefficientTypeValidator, coefficientTypeLengthValidator);

        productionValueCoefficientTypeIdItem = new IntegerItem("productionValueCoefficientTypeId", "主键id");
        productionValueCoefficientTypeIdItem.setRequired(true);
        productionValueCoefficientTypeIdItem.setWidth("*");
        productionValueCoefficientTypeIdItem.setHidden(true);

        employeeIdItem = new IntegerItem("employeeId", "员工id");
        employeeIdItem.setDefaultValue(ClientUtil.getEmployeeId());
        employeeIdItem.setRequired(true);
        employeeIdItem.setWidth("*");
        employeeIdItem.setHidden(true);

        __formItems.add(coefficientTypeItem);
        __formItems.add(productionValueCoefficientTypeIdItem);
        __formItems.add(employeeIdItem);

        __form.setItems(getFormItemArray());
        __form.setDataSource(ds);
        __form.setNumCols(4);
        ClientUtil.DynamicFormProcessAccordingToDevice(__form);


        HLayout productionValueCoefficients = new HLayout();
        productionValueCoefficients.setWidth100();
        productionValueCoefficients.setHeight100();

        grid.setDataSource(DSProductionValueCoefficient.getInstance());

        grid.setAutoFitFieldWidths(false);
        grid.setCanRemoveRecords(true);
        grid.setCanEdit(true);
        grid.setEditOnFocus(true);

        productionValueCoefficients.addMember(grid);

        VLayout productionValueCoefficientsControls = new VLayout();
        productionValueCoefficientsControls.setHeight100();
        productionValueCoefficientsControls.setWidth(60);
        productionValueCoefficientsControls.setLayoutTopMargin(30);
        productionValueCoefficientsControls.setLayoutLeftMargin(5);
        productionValueCoefficientsControls.setLayoutRightMargin(5);
        productionValueCoefficientsControls.setMembersMargin(10);
        productionValueCoefficients.addMember(productionValueCoefficientsControls);

        mainLayout.addMember(__form);
        mainLayout.addMember(productionValueCoefficients);
        addMember(mainLayout);

        IButton productionValueCoefficientsNewButton = new IButton("新增");
        productionValueCoefficientsNewButton.setIcon("[SKIN]/actions/add.png");
        productionValueCoefficientsNewButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.startEditingNew();
            }
        });

        IButton productionValueCoefficientsRemoveButton = new IButton("删除所有");
        productionValueCoefficientsRemoveButton.setIcon("[SKIN]/actions/remove.png");
        productionValueCoefficientsRemoveButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                grid.setData(new RecordList());
            }
        });

        productionValueCoefficientsControls.addMember(productionValueCoefficientsNewButton);
        productionValueCoefficientsControls.addMember(productionValueCoefficientsRemoveButton);
    }

    @Override
    public void startEdit() {
        if (getRecord() != null) {
            __form.editRecord(getRecord());
            reloadDetailTableData();
        } else {
            __form.editNewRecord();
        }
    }


    /**
     * 加载表格数据详情
     */
    public void reloadDetailTableData() {
        Map condition = new HashMap(0);
        condition.put("productionValueCoefficientTypeId", getRecord().getAttribute("productionValueCoefficientTypeId"));
        DBDataSource.callOperation("ST_ProductionValueCoefficient", "find", condition, new DSCallback() {
            @Override
            public void execute(DSResponse dsResponse, Object data, DSRequest dsRequest) {
                if (dsResponse.getStatus() >= 0) {
                    if (__startLoadedDetail != null) __startLoadedDetail.execute(dsResponse, data, dsRequest);
                    grid.setData(dsResponse.getData());
                    if (__endLoadedDetail != null) __endLoadedDetail.execute(dsResponse, data, dsRequest);
                }
            }
        });
    }

    @Override
    public boolean checkData() {
        __logger.info("checkData方法被调用了");
        if (!__form.validate()) {
            SC.say("产值类型错误");
            return false;
        }
        for (ListGridRecord r : grid.getRecords()) {
            __logger.info("返回的数据" + MapUtils.convertRecordToMap(grid.getDataSource(), r).toString());
        }
        return true;
    }

    /**
     * 传值进来的地方
     *
     * @param manager
     */
    @Override
    public void setValueManage(ValuesManager manager) {

        manager.setDataSource(DSProductionValueCoefficientType.getInstance());
        manager.addMember(__form);

        manager.setDataSource(DSProductionValueCoefficient.getInstance());
        manager.addMember(grid);
    }

    @Override
    public Set<String> getItemNames() {
        Set<String> res = new HashSet<>();
        res.add("detailProductionValueCoefficient");
        return res;
    }

    @Override
    public boolean isTheValuesEmpty() {
        ListGridRecord[] rows = grid.getRecords();
        return rows == null || rows.length == 0;
    }


    /**
     * 填充数据的地方
     *
     * @return
     */
    @Override
    public Map getValuesAsMap() {
        Map param = new HashMap(0);
        ListGridRecord[] rows = grid.getRecords();
        MapUtils.convertRecordToMap(grid.getDataSource(), rows, param, "detailProductionValueCoefficient");
        return param;
    }

    @Override
    public String getName() {
        return "";
    }

    public DSCallback getStartLoadedDetail() {
        return this.__startLoadedDetail;
    }

    public void setStartLoadedDetail(DSCallback value) {
        this.__startLoadedDetail = value;
    }

    public DSCallback getEndLoadedDetail() {
        return this.__endLoadedDetail;
    }

    public void setEndLoadedDetail(DSCallback value) {
        this.__endLoadedDetail = value;
    }

    public DelicacyListGrid getGrid() {
        return this.grid;
    }

    public void setGrid(DelicacyListGrid value) {
        this.grid = value;
    }


}

