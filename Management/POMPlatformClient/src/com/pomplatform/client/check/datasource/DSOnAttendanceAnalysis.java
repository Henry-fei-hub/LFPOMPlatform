package com.pomplatform.client.check.datasource;

import com.delicacy.client.data.DBDataSource;
import com.delicacy.client.data.KeyValueManager;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class DSOnAttendanceAnalysis extends DBDataSource {

    public static DSOnAttendanceAnalysis instance = null;

    public static DSOnAttendanceAnalysis getInstance() {
        if (instance == null) {
            instance = new DSOnAttendanceAnalysis("DSOnAttendanceAnalysis");
        }
        return instance;
    }

    private final DataSourceIntegerField plateIdField;
    private final DataSourceTextField attendanceRateField;
    private final DataSourceIntegerField businessNumField;
    private final DataSourceIntegerField outNumField;
    private final DataSourceIntegerField leaveNumField;
    private final DataSourceIntegerField lateNumField;
    private final DataSourceIntegerField earlyNumField;
    private final DataSourceIntegerField absenceNumField;

    public DSOnAttendanceAnalysis(String dataSourceID) {

        super();
        setID(dataSourceID);
        setActionMode(ACTION_MODE_CUSTOM);
        setActionName("OnShiftManageProcess");

        plateIdField = new DataSourceIntegerField("plateId", "业务部门");
        plateIdField.setLength(11);
        plateIdField.setRequired(false);
        plateIdField.setHidden(false);
        plateIdField.setValueMap(KeyValueManager.getValueMap("system_dictionary_1"));

        attendanceRateField = new DataSourceTextField("attendanceRate", "出勤率");
        attendanceRateField.setLength(64);
        attendanceRateField.setRequired(false);
        attendanceRateField.setHidden(false);
        
        businessNumField = new DataSourceIntegerField("businessNum", "出差");
        businessNumField.setLength(11);
        businessNumField.setEmptyDisplayValue("0");
        businessNumField.setRequired(false);
        businessNumField.setHidden(false);
        
        outNumField = new DataSourceIntegerField("outNum", "外出");
        outNumField.setLength(11);
        outNumField.setEmptyDisplayValue("0");
        outNumField.setRequired(false);
        outNumField.setHidden(false);
        
        leaveNumField = new DataSourceIntegerField("leaveNum", "请假");
        leaveNumField.setLength(11);
        leaveNumField.setEmptyDisplayValue("0");
        leaveNumField.setRequired(false);
        leaveNumField.setHidden(false);
        
        lateNumField = new DataSourceIntegerField("lateNum", "迟到");
        lateNumField.setLength(11);
        lateNumField.setEmptyDisplayValue("0");
        lateNumField.setRequired(false);
        lateNumField.setHidden(false);
        
        earlyNumField = new DataSourceIntegerField("earlyNum", "早退");
        earlyNumField.setLength(11);
        earlyNumField.setEmptyDisplayValue("0");
        earlyNumField.setRequired(false);
        earlyNumField.setHidden(false);
        
        absenceNumField = new DataSourceIntegerField("absenceNum", "旷工");
        absenceNumField.setLength(11);
        absenceNumField.setEmptyDisplayValue("0");
        absenceNumField.setRequired(false);
        absenceNumField.setHidden(false);


        setFields(plateIdField,attendanceRateField,businessNumField, outNumField, leaveNumField, lateNumField, earlyNumField, absenceNumField);
    }

}
