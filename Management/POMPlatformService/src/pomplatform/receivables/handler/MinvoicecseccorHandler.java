package pomplatform.receivables.handler;

import org.apache.log4j.Logger;

import pomplatform.receivables.bean.BaseMinvoicecseccor;
import pomplatform.receivables.bean.ConditionMinvoicecseccor;
import pomplatform.receivables.query.QueryMinvoicecseccor;
import delicacy.common.KeyValuePair;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class MinvoicecseccorHandler implements GenericQuery,  GenericDownloadProcessor {
    private static  final long MONTHTIME = 30 * 24 * 60 * 60 * 1000l;
	private static final Logger __logger = Logger.getLogger(MinvoicecseccorHandler.class);

	public static BaseCollection<BaseMinvoicecseccor> executeQueryMinvoicecseccor(ConditionMinvoicecseccor c, KeyValuePair[] replacements ) throws Exception {
		QueryMinvoicecseccor dao = new QueryMinvoicecseccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMinvoicecseccor> result = dao.executeQuery( c.getKeyValues(), c) ;
		if(!delicacy.common.BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			long currentTime = System.currentTimeMillis();
			List<BaseMinvoicecseccor> collections = result.getCollections();
			//循环遍历所有的数据，计算欠款金额以及超期欠款纪额
			for (BaseMinvoicecseccor baseMinvoicecseccor : collections) {
			
				//开票的金额
				BigDecimal invoiceAmount = BaseHelpUtils.getBigDecimalValue(baseMinvoicecseccor.getInvoiceAmount());
				//已回款的金额
				BigDecimal capitalAmount = BaseHelpUtils.getBigDecimalValue(baseMinvoicecseccor.getCapitalAmount());
				//发票的开票时间
				Date invoiceDate = baseMinvoicecseccor.getInvoiceDate();
				if (null != invoiceDate){
					long time = invoiceDate.getTime();
					//间隔的时间
					long intervals = currentTime - time;
					//开票的时间间隔大于30天的
					if (intervals > MONTHTIME){
						//设置逾期的状态
						baseMinvoicecseccor.setOverduePayment(1);
					}else{
						//设置没有逾期的状态
						baseMinvoicecseccor.setOverduePayment(1);
					}
				}
				//计算未回款的金额
				BigDecimal arrears = invoiceAmount.subtract(capitalAmount);
				baseMinvoicecseccor.setArrears(arrears);
			}
		}
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
/*		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> map = (Map<String, Object>) parser.parse(new BasicHandler());*/
		ConditionMinvoicecseccor c = new ConditionMinvoicecseccor();
		c.setDataFromJSON(creteria);
		
/*		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		if(null!=map.get("start")) {
			Object object = map.get("start");
			System.out.println("start====="+object);
			Date startdate = dateFormat.parse(map.get("start").toString());
			System.out.println("startdate====="+startdate);
			String startDate = dateFormat.format(startdate);
			System.out.println("startDate====="+startDate);
			c.setStartDate(startDate);
			
		}
		if(null!=map.get("end")) {
			Object object = map.get("end");
			System.out.println("end====="+object);
			Date enddate = dateFormat.parse(map.get("end").toString());
			System.out.println("enddate====="+enddate);
			String endDate = dateFormat.format(enddate);
			System.out.println("enddate====="+enddate);
			c.setEndDate(endDate);
		}*/
		
		BaseCollection<BaseMinvoicecseccor> result = executeQueryMinvoicecseccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMinvoicecseccor> result;
		ConditionMinvoicecseccor c = new ConditionMinvoicecseccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMinvoicecseccor dao = new QueryMinvoicecseccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(!delicacy.common.BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			long currentTime = System.currentTimeMillis();
			List<BaseMinvoicecseccor> collections = result.getCollections();
			//循环遍历所有的数据，计算欠款金额以及超期欠款纪额
			for (BaseMinvoicecseccor baseMinvoicecseccor : collections) {
			
				//开票的金额
				BigDecimal invoiceAmount = BaseHelpUtils.getBigDecimalValue(baseMinvoicecseccor.getInvoiceAmount());
				//已回款的金额
				BigDecimal capitalAmount = BaseHelpUtils.getBigDecimalValue(baseMinvoicecseccor.getCapitalAmount());
				//发票的开票时间
				Date invoiceDate = baseMinvoicecseccor.getInvoiceDate();
				if (null != invoiceDate){
					long time = invoiceDate.getTime();
					//间隔的时间
					long intervals = currentTime - time;
					//开票的时间间隔大于30天的
					if (intervals > MONTHTIME){
						//设置逾期的状态
						baseMinvoicecseccor.setOverduePayment(1);
					}else{
						//设置没有逾期的状态
						baseMinvoicecseccor.setOverduePayment(1);
					}
				}
				//计算未回款的金额
				BigDecimal arrears = invoiceAmount.subtract(capitalAmount);
				baseMinvoicecseccor.setArrears(arrears);
			}
		}
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMinvoicecseccor.DW_CAPTIONS);
			for(BaseMinvoicecseccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


