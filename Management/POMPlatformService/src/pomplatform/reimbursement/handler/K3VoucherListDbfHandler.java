package pomplatform.reimbursement.handler;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.reimbursement.bean.BaseK3VoucherList;
import pomplatform.reimbursement.bean.ConditionK3VoucherList;
import pomplatform.reimbursement.query.QueryK3VoucherList;

public class K3VoucherListDbfHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(K3VoucherListDbfHandler.class);

	public static BaseCollection<BaseK3VoucherList> executeQueryK3VoucherList(ConditionK3VoucherList c, KeyValuePair[] replacements ) throws Exception {
		QueryK3VoucherList dao = new QueryK3VoucherList();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseK3VoucherList> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionK3VoucherList c = new ConditionK3VoucherList();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseK3VoucherList> result = executeQueryK3VoucherList(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		JSON parser = new JSON(new StringReader(creteria)); 
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		List<BaseK3VoucherList> downloadList = new ArrayList<>();
		String employeeName = null;
		for(String key : params.keySet()){
			if(key.equals("employeeName")){
				employeeName = BaseHelpUtils.getString(params.get(key));
			}else{
				ConditionK3VoucherList c = new ConditionK3VoucherList();
				c.setReimbursementPackageCode(BaseHelpUtils.getString(params.get(key)));
				QueryK3VoucherList dao = new QueryK3VoucherList();
				BaseCollection<BaseK3VoucherList> bc = dao.executeQuery(null, c);
				if(null != bc && null != bc.getCollections()){
					downloadList.addAll(bc.getCollections());
				}
			}
		}
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		if(downloadList.size() > 0){
			
            response.setCharacterEncoding("utf-8");
            //设置响应内容的类型
            response.setContentType("text/plain");
            
            String fileName = format.format(date) + "导出的报销凭证.dat";
            fileName = new String(fileName.getBytes("GBK"), "iso8859-1");
            //设置文件的名称和格式
            response.addHeader("Content-Disposition","attachment; filename="+fileName);//通过后缀可以下载不同的文件格式
            
            String tab = "\t";  
            String enter = "\r\n";  
			OutputStream output = response.getOutputStream();
			Calendar c = Calendar.getInstance();
			BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
//				for (BaseK3VoucherList bean : downloadList) {
					for (int i = 0; i <downloadList.size(); i++) {
					BaseK3VoucherList bean = downloadList.get(i);
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					//借方
					BigDecimal debitSide = BigDecimal.ZERO;
					//贷方
					BigDecimal creditSide = BigDecimal.ZERO;
					BigDecimal sum = BigDecimal.ZERO;
					
					String simplifyRemark = bean.getSimplifyRemark();
					if(simplifyRemark==null) {
						simplifyRemark="";
					}
					if(null != bean.getDebitSide()){
						debitSide = bean.getDebitSide();
					}
					if(null != bean.getCreditSide()){
						creditSide = bean.getCreditSide();
					}
					sum = creditSide.add(debitSide);
					String v="0";
					if(debitSide.compareTo(creditSide)==1) {
						v="1";
					}
					StringBuffer write = new StringBuffer(); 
					write.append(
							//凭证日期,1,4
							format.format(bean.getVestingDate())+tab+
							//会计年度,2,1
							year+tab+
							//会计期间,3,1
							month+tab+
							//凭证字,4,2
							"记"+tab+
							//凭证号,5,1
							bean.getSequenceNumber()+tab+
							//分录数,6,1//附件张数,7,2
							i+tab+0+tab+
							//制单人,8,2//审核人,9,2//过账人,10,2//出纳,11,2 //会计主管,12,2
							employeeName+tab+tab+tab+tab+tab+/*tab+tab+tab+tab+*/
							//凭证序号,13,1 有
							bean.getSequenceNumber()+tab+
							//凭证类型,14,2 空
							tab+/*tab+*/
							//是否过账,15,3 否//是否删除,16,3 否
							"0"+tab+"0"+tab+
							//摘要,17,2     有
							simplifyRemark+tab+
							//科目代码,18,2 有
							bean.getCode()+tab+
							//货币代码,19,2 有//汇率类型,20,1//汇率,21,1//余额方向,22,1
							"RMB"+tab+"1"+tab+"1"+tab+v+tab+
							//原币金额,23,1
							BaseHelpUtils.format(sum, 0)+tab+
							//借方金额,24,1
							BaseHelpUtils.format(debitSide, 0).toString()+tab+
							//贷方金额,25,1
							BaseHelpUtils.format(creditSide, 0).toString()+tab+
							//计量单位,26,2
							tab+/*tab+*/
							//数量,27,1//单价,28,1//结算方式,29,2//结算号,30,2
							"0"+tab+"0"+tab+tab+tab+/*tab+*/
							//业务日期,31,4//业务编号,32,2
							format.format(bean.getVestingDate())+tab/*+tab+tab*/
							);
					if(!BaseHelpUtils.isNullOrEmpty(bean.getSecondaryName())) {
						String[] project = bean.getSecondaryName().split("---");
						if(!BaseHelpUtils.isNullOrEmpty(project)&&project.length>0) {
							//核算项目类型1,33,2
							//核算项目编码1,34,2
							//核算项目名称1,35,2
							write.append(tab);
							for (String string : project) {
								if(!BaseHelpUtils.isNullOrEmpty(string)) {
										write.append(string+tab);
								}
							}
						}
					}else {
						write.append(tab);
						for (int j = 0; j < 3; j++) {
							write.append(tab);
						}
					}
					for (int j = 0; j < 43; j++) {
						write.append(tab);
					}
						write.append("0");
						bufferedOutPut.flush();
						bufferedOutPut.write(write.toString().getBytes("UTF-8"));
						bufferedOutPut.write(enter.getBytes("UTF-8"));
				}
			try {
				bufferedOutPut.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				downloadList.clear();
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	
/*	
	 public static void main(String[] args) throws DBFException, IOException {
		 testWriteAndReadAgain();
	}


	 
		public static void testWriteAndReadAgain() throws DBFException, IOException {
			// let us create field definitions first
			// we will go for 3 fields
			//
			DBFField fields[] = new DBFField[3];
	 
			fields[0] = new DBFField();
			fields[0].setName("emp_code");
			fields[0].setType(DBFDataType.CHARACTER);
			fields[0].setLength(10);
	 
			fields[1] = new DBFField();
			fields[1].setName("emp_name");
			fields[1].setType(DBFDataType.CHARACTER);
			fields[1].setLength(20);
	 
			fields[2] = new DBFField();
			fields[2].setName("salary");
			fields[2].setType(DBFDataType.NUMERIC);
			fields[2].setLength(12);
			fields[2].setDecimalCount(2);
			DBFWriter writer = null;
			DBFReader reader = null;
			FileInputStream fis = null;
			FileOutputStream fos = null;
			File f = new File("C:/Users/Administrator/Desktop/emp.dbf");
			f.createNewFile();
			try {
				// 开始写
				fos = new FileOutputStream(f);
				writer = new DBFWriter(fos);
				writer.setFields(fields);
	 
				// now populate DBFWriter
				//
	 
				Object rowData[] = new Object[3];
				rowData[0] = "1000";
				rowData[1] = "John";
				rowData[2] = new Double(5000.00);
	 
				writer.addRecord(rowData);
	 
				rowData = new Object[3];
				rowData[0] = "1001";
				rowData[1] = "Lalit";
				rowData[2] = new Double(3400.00);
	 
				writer.addRecord(rowData);
	 
				rowData = new Object[3];
				rowData[0] = "1002";
				rowData[1] = "Rohit";
				rowData[2] = new Double(7350.00);
	 
				writer.addRecord(rowData);
	 
				DBFUtils.close(writer);
				System.out.println("The dbf file product success!");
	 
				// 开始读
				fis = new FileInputStream(f);
				reader = new DBFReader(fis);
				Object[] objects = null;
				for (; (objects = reader.nextRecord()) != null;) {
					System.out.println(Arrays.toString(objects));
				}
				DBFUtils.close(reader);
	 
			} finally {
				DBFUtils.close(reader);
				DBFUtils.close(writer);
			}
		}

*/
	

}


