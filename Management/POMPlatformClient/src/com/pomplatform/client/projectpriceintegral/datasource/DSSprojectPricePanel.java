package com.pomplatform.client.projectpriceintegral.datasource;

import com.smartgwt.client.data.fields.*;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSSprojectPricePanel extends DBDataSource {

    public static DSSprojectPricePanel instance = null;

    public static DSSprojectPricePanel getInstance() {
        if (instance == null) {
            instance = new DSSprojectPricePanel("DSSprojectPricePanel");
        }
        return instance;
    }

    private final DataSourceIntegerField projectUnitPriceIdField;
    private final DataSourceIntegerField plateIdField;
    private final DataSourceIntegerField areaIdField;
    private final DataSourceIntegerField gradeIdField;
    private final DataSourceIntegerField squareIdField;
    private final DataSourceFloatField minSquareField;
    private final DataSourceFloatField maxSquareField;
    private final DataSourceFloatField unitPriceField;

    public DSSprojectPricePanel(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_QUERY);
        setActionName("SprojectPricePanel");

        projectUnitPriceIdField = new DataSourceIntegerField("projectUnitPriceId", "项目单价");
        projectUnitPriceIdField.setLength(11);
        projectUnitPriceIdField.setPrimaryKey(true);
        projectUnitPriceIdField.setRequired(true);
        projectUnitPriceIdField.setHidden(true);

        plateIdField = new DataSourceIntegerField("plateId", "板块");
        plateIdField.setLength(64);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        areaIdField = new DataSourceIntegerField("areaId", "区域");
        areaIdField.setLength(64);
        areaIdField.setRequired(false);
        areaIdField.setHidden(false);
        areaIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_13"));

        gradeIdField = new DataSourceIntegerField("gradeId", "项目级别");
        gradeIdField.setLength(64);
        gradeIdField.setRequired(false);
        gradeIdField.setHidden(false);
        gradeIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_2"));

        squareIdField = new DataSourceIntegerField("squareId", "面积区间");
        squareIdField.setLength(64);
        squareIdField.setRequired(false);
        squareIdField.setHidden(false);
        squareIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_14"));

        minSquareField = new DataSourceFloatField("minSquare", "最小面积");
        minSquareField.setLength(64);
        minSquareField.setDecimalPad(2);
        minSquareField.setFormat("##,###,##0.00");
        minSquareField.setRequired(false);
        minSquareField.setHidden(false);

        maxSquareField = new DataSourceFloatField("maxSquare", "最大面积");
        maxSquareField.setLength(64);
        maxSquareField.setDecimalPad(2);
        maxSquareField.setFormat("##,###,##0.00");
        maxSquareField.setRequired(false);
        maxSquareField.setHidden(false);

        unitPriceField = new DataSourceFloatField("unitPrice", "单价");
        unitPriceField.setLength(64);
        unitPriceField.setDecimalPad(2);
        unitPriceField.setFormat("##,###,##0.00");
        unitPriceField.setRequired(false);
        unitPriceField.setHidden(false);

        setFields(projectUnitPriceIdField, plateIdField, areaIdField, gradeIdField, squareIdField, minSquareField, maxSquareField, unitPriceField);
    }

}
