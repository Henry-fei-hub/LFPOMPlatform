package com.pomplatform.client.preprojects.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSMainProjectSpecialty extends DBDataSource
{


	public static DSMainProjectSpecialty instance = null;

	public static DSMainProjectSpecialty getInstance() {
		if(instance == null) {
			instance = new DSMainProjectSpecialty("DSMainProjectSpecialty");
		}
		return instance;
	}

	private final DataSourceIntegerField mainProjectSpecialtyIdField;
	private final DataSourceIntegerField mainProjectIdField;
	private final DataSourceIntegerField specialtyIdField;
	private final DataSourceIntegerField preProjectIdField;
	private final DataSourceIntegerField registrationSealEmployeeIdField;
	private final DataSourceBooleanField isOutsourcingField;
	public DSMainProjectSpecialty(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_TABLE);
		setActionName("MainProjectSpecialty");


		mainProjectSpecialtyIdField = new DataSourceIntegerField("mainProjectSpecialtyId", "主键编码");
		mainProjectSpecialtyIdField.setLength(11);
		mainProjectSpecialtyIdField.setPrimaryKey(true);
		mainProjectSpecialtyIdField.setRequired(true);
		mainProjectSpecialtyIdField.setHidden(false);


		mainProjectIdField = new DataSourceIntegerField("mainProjectId", "前期项目id");
		mainProjectIdField.setLength(11);
		mainProjectIdField.setRequired(false);
		mainProjectIdField.setHidden(false);


		specialtyIdField = new DataSourceIntegerField("specialtyId", "专业");
		specialtyIdField.setLength(11);
		specialtyIdField.setRequired(false);
		specialtyIdField.setHidden(false);
		
		preProjectIdField = new DataSourceIntegerField("preProjectId", "前期项目id");
		preProjectIdField.setLength(11);
		preProjectIdField.setRequired(false);
		preProjectIdField.setHidden(true);
		
		registrationSealEmployeeIdField = new DataSourceIntegerField("registrationSealEmployeeId", "注册盖章人员");
		registrationSealEmployeeIdField.setLength(11);
		registrationSealEmployeeIdField.setRequired(false);
		registrationSealEmployeeIdField.setHidden(false);
		
		isOutsourcingField = new DataSourceBooleanField("isOutsourcing", "是否外包");
		isOutsourcingField.setLength(11);
		isOutsourcingField.setRequired(false);
		isOutsourcingField.setHidden(true);
		

		setFields(mainProjectSpecialtyIdField, mainProjectIdField, specialtyIdField,preProjectIdField,registrationSealEmployeeIdField,isOutsourcingField);
	}


}

