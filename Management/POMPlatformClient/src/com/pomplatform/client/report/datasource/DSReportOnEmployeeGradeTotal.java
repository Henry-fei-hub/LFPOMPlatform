package com.pomplatform.client.report.datasource;

import com.smartgwt.client.data.fields.*;
import com.smartgwt.client.data.DataSourceField;
import com.smartgwt.client.types.FieldType;
import com.delicacy.client.data.KeyValueManager;
import com.delicacy.client.data.DBDataSource;

public class DSReportOnEmployeeGradeTotal extends DBDataSource
{


	public static DSReportOnEmployeeGradeTotal instance = null;

	public static DSReportOnEmployeeGradeTotal getInstance() {
		if(instance == null) {
			instance = new DSReportOnEmployeeGradeTotal("DSReportOnEmployeeGradeTotal");
		}
		return instance;
	}

	private final DataSourceIntegerField plateIdField;
	private final DataSourceIntegerField yearField;
	private final DataSourceIntegerField a1Field;
	private final DataSourceIntegerField a2Field;
	private final DataSourceIntegerField a3Field;
	private final DataSourceIntegerField a4Field;
	private final DataSourceIntegerField a5Field;
	private final DataSourceIntegerField a6Field;
	private final DataSourceIntegerField a7Field;
	private final DataSourceIntegerField a8Field;
	private final DataSourceIntegerField a9Field;
	private final DataSourceIntegerField a10Field;
	private final DataSourceIntegerField a11Field;
	private final DataSourceIntegerField a12Field;
	private final DataSourceIntegerField a13Field;
	private final DataSourceIntegerField a14Field;
	private final DataSourceIntegerField a15Field;
	private final DataSourceIntegerField a16Field;
	private final DataSourceIntegerField a17Field;
	private final DataSourceIntegerField a18Field;
	private final DataSourceIntegerField a19Field;
	private final DataSourceIntegerField a20Field;
	private final DataSourceIntegerField b1Field;
	private final DataSourceIntegerField b2Field;
	private final DataSourceIntegerField b3Field;
	private final DataSourceIntegerField b4Field;
	private final DataSourceIntegerField b5Field;
	private final DataSourceIntegerField b6Field;
	private final DataSourceIntegerField b7Field;
	private final DataSourceIntegerField b8Field;
	private final DataSourceIntegerField b9Field;
	private final DataSourceIntegerField b10Field;
	private final DataSourceIntegerField b11Field;
	private final DataSourceIntegerField b12Field;
	private final DataSourceIntegerField b13Field;
	private final DataSourceIntegerField b14Field;
	private final DataSourceIntegerField b15Field;
	private final DataSourceIntegerField b16Field;
	private final DataSourceIntegerField b17Field;
	private final DataSourceIntegerField b18Field;
	private final DataSourceIntegerField b19Field;
	private final DataSourceIntegerField b20Field;
	private final DataSourceIntegerField c1Field;
	private final DataSourceIntegerField c2Field;
	private final DataSourceIntegerField c3Field;
	private final DataSourceIntegerField c4Field;
	private final DataSourceIntegerField c5Field;
	private final DataSourceIntegerField c6Field;
	private final DataSourceIntegerField c7Field;
	private final DataSourceIntegerField c8Field;
	private final DataSourceIntegerField c9Field;
	private final DataSourceIntegerField c10Field;
	private final DataSourceIntegerField c11Field;
	private final DataSourceIntegerField c12Field;
	private final DataSourceIntegerField c13Field;
	private final DataSourceIntegerField c14Field;
	private final DataSourceIntegerField c15Field;
	private final DataSourceIntegerField c16Field;
	private final DataSourceIntegerField c17Field;
	private final DataSourceIntegerField c18Field;
	private final DataSourceIntegerField c19Field;
	private final DataSourceIntegerField c20Field;
	private final DataSourceIntegerField otherNumField;
	private final DataSourceIntegerField totalNumField;

	public DSReportOnEmployeeGradeTotal(String dataSourceID) {

		super();
		setID(dataSourceID);
		setActionMode(ACTION_MODE_QUERY);
		setActionName("ReportOnEmployeeGradeTotal");


		plateIdField = new DataSourceIntegerField("plateId", "业务部门");
		plateIdField.setLength(11);
		plateIdField.setRequired(false);
		plateIdField.setHidden(false);
		plateIdField.setValueMap(KeyValueManager.getValueMap("plate_records"));


		yearField = new DataSourceIntegerField("year", "年份");
		yearField.setLength(11);
		yearField.setRequired(false);
		yearField.setHidden(false);


		a1Field = new DataSourceIntegerField("a1", "A1");
		a1Field.setLength(8);
		a1Field.setRequired(false);
		a1Field.setHidden(false);


		a2Field = new DataSourceIntegerField("a2", "A2");
		a2Field.setLength(8);
		a2Field.setRequired(false);
		a2Field.setHidden(false);


		a3Field = new DataSourceIntegerField("a3", "A3");
		a3Field.setLength(8);
		a3Field.setRequired(false);
		a3Field.setHidden(false);


		a4Field = new DataSourceIntegerField("a4", "A4");
		a4Field.setLength(8);
		a4Field.setRequired(false);
		a4Field.setHidden(false);


		a5Field = new DataSourceIntegerField("a5", "A5");
		a5Field.setLength(8);
		a5Field.setRequired(false);
		a5Field.setHidden(false);


		a6Field = new DataSourceIntegerField("a6", "A6");
		a6Field.setLength(8);
		a6Field.setRequired(false);
		a6Field.setHidden(false);


		a7Field = new DataSourceIntegerField("a7", "A7");
		a7Field.setLength(8);
		a7Field.setRequired(false);
		a7Field.setHidden(false);


		a8Field = new DataSourceIntegerField("a8", "A8");
		a8Field.setLength(8);
		a8Field.setRequired(false);
		a8Field.setHidden(false);


		a9Field = new DataSourceIntegerField("a9", "A9");
		a9Field.setLength(8);
		a9Field.setRequired(false);
		a9Field.setHidden(false);


		a10Field = new DataSourceIntegerField("a10", "A10");
		a10Field.setLength(8);
		a10Field.setRequired(false);
		a10Field.setHidden(false);


		a11Field = new DataSourceIntegerField("a11", "A11");
		a11Field.setLength(8);
		a11Field.setRequired(false);
		a11Field.setHidden(false);


		a12Field = new DataSourceIntegerField("a12", "A12");
		a12Field.setLength(8);
		a12Field.setRequired(false);
		a12Field.setHidden(false);


		a13Field = new DataSourceIntegerField("a13", "A13");
		a13Field.setLength(8);
		a13Field.setRequired(false);
		a13Field.setHidden(false);


		a14Field = new DataSourceIntegerField("a14", "A14");
		a14Field.setLength(8);
		a14Field.setRequired(false);
		a14Field.setHidden(false);


		a15Field = new DataSourceIntegerField("a15", "A15");
		a15Field.setLength(8);
		a15Field.setRequired(false);
		a15Field.setHidden(false);


		a16Field = new DataSourceIntegerField("a16", "A16");
		a16Field.setLength(8);
		a16Field.setRequired(false);
		a16Field.setHidden(false);


		a17Field = new DataSourceIntegerField("a17", "A17");
		a17Field.setLength(8);
		a17Field.setRequired(false);
		a17Field.setHidden(false);


		a18Field = new DataSourceIntegerField("a18", "A18");
		a18Field.setLength(8);
		a18Field.setRequired(false);
		a18Field.setHidden(false);


		a19Field = new DataSourceIntegerField("a19", "A19");
		a19Field.setLength(8);
		a19Field.setRequired(false);
		a19Field.setHidden(false);


		a20Field = new DataSourceIntegerField("a20", "A20");
		a20Field.setLength(8);
		a20Field.setRequired(false);
		a20Field.setHidden(false);


		b1Field = new DataSourceIntegerField("b1", "B1");
		b1Field.setLength(8);
		b1Field.setRequired(false);
		b1Field.setHidden(false);


		b2Field = new DataSourceIntegerField("b2", "B2");
		b2Field.setLength(8);
		b2Field.setRequired(false);
		b2Field.setHidden(false);


		b3Field = new DataSourceIntegerField("b3", "B3");
		b3Field.setLength(8);
		b3Field.setRequired(false);
		b3Field.setHidden(false);


		b4Field = new DataSourceIntegerField("b4", "B4");
		b4Field.setLength(8);
		b4Field.setRequired(false);
		b4Field.setHidden(false);


		b5Field = new DataSourceIntegerField("b5", "B5");
		b5Field.setLength(8);
		b5Field.setRequired(false);
		b5Field.setHidden(false);


		b6Field = new DataSourceIntegerField("b6", "B6");
		b6Field.setLength(8);
		b6Field.setRequired(false);
		b6Field.setHidden(false);


		b7Field = new DataSourceIntegerField("b7", "B7");
		b7Field.setLength(8);
		b7Field.setRequired(false);
		b7Field.setHidden(false);


		b8Field = new DataSourceIntegerField("b8", "B8");
		b8Field.setLength(8);
		b8Field.setRequired(false);
		b8Field.setHidden(false);


		b9Field = new DataSourceIntegerField("b9", "B9");
		b9Field.setLength(8);
		b9Field.setRequired(false);
		b9Field.setHidden(false);


		b10Field = new DataSourceIntegerField("b10", "B10");
		b10Field.setLength(8);
		b10Field.setRequired(false);
		b10Field.setHidden(false);


		b11Field = new DataSourceIntegerField("b11", "B11");
		b11Field.setLength(8);
		b11Field.setRequired(false);
		b11Field.setHidden(false);


		b12Field = new DataSourceIntegerField("b12", "B12");
		b12Field.setLength(8);
		b12Field.setRequired(false);
		b12Field.setHidden(false);


		b13Field = new DataSourceIntegerField("b13", "B13");
		b13Field.setLength(8);
		b13Field.setRequired(false);
		b13Field.setHidden(false);


		b14Field = new DataSourceIntegerField("b14", "B14");
		b14Field.setLength(8);
		b14Field.setRequired(false);
		b14Field.setHidden(false);


		b15Field = new DataSourceIntegerField("b15", "B15");
		b15Field.setLength(8);
		b15Field.setRequired(false);
		b15Field.setHidden(false);


		b16Field = new DataSourceIntegerField("b16", "B16");
		b16Field.setLength(8);
		b16Field.setRequired(false);
		b16Field.setHidden(false);


		b17Field = new DataSourceIntegerField("b17", "B17");
		b17Field.setLength(8);
		b17Field.setRequired(false);
		b17Field.setHidden(false);


		b18Field = new DataSourceIntegerField("b18", "B18");
		b18Field.setLength(8);
		b18Field.setRequired(false);
		b18Field.setHidden(false);


		b19Field = new DataSourceIntegerField("b19", "B19");
		b19Field.setLength(8);
		b19Field.setRequired(false);
		b19Field.setHidden(false);


		b20Field = new DataSourceIntegerField("b20", "B20");
		b20Field.setLength(8);
		b20Field.setRequired(false);
		b20Field.setHidden(false);


		c1Field = new DataSourceIntegerField("c1", "C1");
		c1Field.setLength(8);
		c1Field.setRequired(false);
		c1Field.setHidden(false);


		c2Field = new DataSourceIntegerField("c2", "C2");
		c2Field.setLength(8);
		c2Field.setRequired(false);
		c2Field.setHidden(false);


		c3Field = new DataSourceIntegerField("c3", "C3");
		c3Field.setLength(8);
		c3Field.setRequired(false);
		c3Field.setHidden(false);


		c4Field = new DataSourceIntegerField("c4", "C4");
		c4Field.setLength(8);
		c4Field.setRequired(false);
		c4Field.setHidden(false);


		c5Field = new DataSourceIntegerField("c5", "C5");
		c5Field.setLength(8);
		c5Field.setRequired(false);
		c5Field.setHidden(false);


		c6Field = new DataSourceIntegerField("c6", "C6");
		c6Field.setLength(8);
		c6Field.setRequired(false);
		c6Field.setHidden(false);


		c7Field = new DataSourceIntegerField("c7", "C7");
		c7Field.setLength(8);
		c7Field.setRequired(false);
		c7Field.setHidden(false);


		c8Field = new DataSourceIntegerField("c8", "C8");
		c8Field.setLength(8);
		c8Field.setRequired(false);
		c8Field.setHidden(false);


		c9Field = new DataSourceIntegerField("c9", "C9");
		c9Field.setLength(8);
		c9Field.setRequired(false);
		c9Field.setHidden(false);


		c10Field = new DataSourceIntegerField("c10", "C10");
		c10Field.setLength(8);
		c10Field.setRequired(false);
		c10Field.setHidden(false);


		c11Field = new DataSourceIntegerField("c11", "C11");
		c11Field.setLength(8);
		c11Field.setRequired(false);
		c11Field.setHidden(false);


		c12Field = new DataSourceIntegerField("c12", "C12");
		c12Field.setLength(8);
		c12Field.setRequired(false);
		c12Field.setHidden(false);


		c13Field = new DataSourceIntegerField("c13", "C13");
		c13Field.setLength(8);
		c13Field.setRequired(false);
		c13Field.setHidden(false);


		c14Field = new DataSourceIntegerField("c14", "C14");
		c14Field.setLength(8);
		c14Field.setRequired(false);
		c14Field.setHidden(false);


		c15Field = new DataSourceIntegerField("c15", "C15");
		c15Field.setLength(8);
		c15Field.setRequired(false);
		c15Field.setHidden(false);


		c16Field = new DataSourceIntegerField("c16", "C16");
		c16Field.setLength(8);
		c16Field.setRequired(false);
		c16Field.setHidden(false);


		c17Field = new DataSourceIntegerField("c17", "C17");
		c17Field.setLength(8);
		c17Field.setRequired(false);
		c17Field.setHidden(false);


		c18Field = new DataSourceIntegerField("c18", "C18");
		c18Field.setLength(8);
		c18Field.setRequired(false);
		c18Field.setHidden(false);


		c19Field = new DataSourceIntegerField("c19", "C19");
		c19Field.setLength(8);
		c19Field.setRequired(false);
		c19Field.setHidden(false);


		c20Field = new DataSourceIntegerField("c20", "C20");
		c20Field.setLength(8);
		c20Field.setRequired(false);
		c20Field.setHidden(false);


		otherNumField = new DataSourceIntegerField("otherNum", "其他");
		otherNumField.setLength(8);
		otherNumField.setRequired(false);
		otherNumField.setHidden(false);


		totalNumField = new DataSourceIntegerField("totalNum", "合计");
		totalNumField.setLength(8);
		totalNumField.setRequired(false);
		totalNumField.setHidden(false);


		setFields(plateIdField, yearField, a1Field, a2Field, a3Field, a4Field, a5Field, a6Field, a7Field, a8Field, a9Field, a10Field, a11Field, a12Field, a13Field, a14Field, a15Field, a16Field, a17Field, a18Field, a19Field, a20Field, b1Field, b2Field, b3Field, b4Field, b5Field, b6Field, b7Field, b8Field, b9Field, b10Field, b11Field, b12Field, b13Field, b14Field, b15Field, b16Field, b17Field, b18Field, b19Field, b20Field, c1Field, c2Field, c3Field, c4Field, c5Field, c6Field, c7Field, c8Field, c9Field, c10Field, c11Field, c12Field, c13Field, c14Field, c15Field, c16Field, c17Field, c18Field, c19Field, c20Field, otherNumField, totalNumField);
	}


}

