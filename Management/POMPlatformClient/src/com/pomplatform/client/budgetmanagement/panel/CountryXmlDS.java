package com.pomplatform.client.budgetmanagement.panel;

import com.smartgwt.client.data.DataSource;  
import com.smartgwt.client.data.fields.DataSourceBooleanField;  
import com.smartgwt.client.data.fields.DataSourceDateField;  
import com.smartgwt.client.data.fields.DataSourceFloatField;  
import com.smartgwt.client.data.fields.DataSourceIntegerField;  
import com.smartgwt.client.data.fields.DataSourceLinkField;  
import com.smartgwt.client.data.fields.DataSourceTextField;  
  
public class CountryXmlDS extends DataSource {  
  
    private static CountryXmlDS instance = null;  
  
    public static CountryXmlDS getInstance() {  
        if (instance == null) {  
            instance = new CountryXmlDS("countryDS");  
        }  
        return instance;  
    }  
  
    public CountryXmlDS(String id) {  
  
        setID(id);  
        setRecordXPath("/List/country");  
        DataSourceIntegerField pkField = new DataSourceIntegerField("pk");  
        pkField.setHidden(true);  
        pkField.setPrimaryKey(true);  
  
        DataSourceTextField countryCodeField = new DataSourceTextField("countryCode", "Code");  
        countryCodeField.setRequired(true);  
  
        DataSourceTextField countryNameField = new DataSourceTextField("countryName", "Country");  
        countryNameField.setRequired(true);  
  
        DataSourceTextField capitalField = new DataSourceTextField("capital", "Capital");  
        DataSourceTextField governmentField = new DataSourceTextField("government", "Government", 500);  
  
        DataSourceBooleanField memberG8Field = new DataSourceBooleanField("member_g8", "G8");  
  
        DataSourceTextField continentField = new DataSourceTextField("continent", "Continent");  
        continentField.setValueMap("Europe", "Asia", "North America", "Australia/Oceania", "South America", "Africa");  
  
        DataSourceDateField independenceField = new DataSourceDateField("independence", "Nationhood");  
        DataSourceFloatField areaField = new DataSourceFloatField("area", "Area (km²)");   
        DataSourceIntegerField populationField = new DataSourceIntegerField("population", "Population");  
        populationField.setFormat(",0");  
        DataSourceFloatField gdpField = new DataSourceFloatField("gdp", "GDP ($M)");  
        DataSourceLinkField articleField = new DataSourceLinkField("article", "Info");  
  
        setFields(pkField, countryCodeField, countryNameField, capitalField, governmentField,  
                memberG8Field, continentField, independenceField, areaField, populationField,  
                gdpField, articleField);  
  
        setDataURL("ds/test_data/country.data.xml");  
        setClientOnly(true);  
    }  
}  