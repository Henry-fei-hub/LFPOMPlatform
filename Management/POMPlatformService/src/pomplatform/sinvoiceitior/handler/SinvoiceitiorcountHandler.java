package pomplatform.sinvoiceitior.handler;

import java.io.File;
import java.io.PrintStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;
import delicacy.common.GenericBase;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericQuery;
import delicacy.common.KeyValuePair;
import delicacy.date.util.DateUtil;
import delicacy.json.BasicHandler;
import delicacy.json.JSON;
import pomplatform.sinvoiceitior.bean.BaseSinvoiceitiorcount;
import pomplatform.sinvoiceitior.bean.ConditionSinvoiceitiorcount;
import pomplatform.sinvoiceitior.bean.CustomBaseSinvoiceitiorcount;
import pomplatform.sinvoiceitior.query.QuerySinvoiceitiorcount;

public class SinvoiceitiorcountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SinvoiceitiorcountHandler.class);

	public static BaseCollection<BaseSinvoiceitiorcount> executeQuerySinvoiceitiorcount(ConditionSinvoiceitiorcount c, KeyValuePair[] replacements ) throws Exception {
		QuerySinvoiceitiorcount dao = new QuerySinvoiceitiorcount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSinvoiceitiorcount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSinvoiceitiorcount c = generateCondition(creteria);
		BaseCollection<BaseSinvoiceitiorcount> result = executeQuerySinvoiceitiorcount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	public ConditionSinvoiceitiorcount generateCondition(String creteria) throws Exception {
		JSON parser = new JSON(new StringReader(creteria));
		Map<String, Object> params = (Map<String, Object>) parser.parse(new BasicHandler());
		ConditionSinvoiceitiorcount c = new ConditionSinvoiceitiorcount();
		c.setDataFromMap(params);
		if(null != c.getMaxInvoiceDate()){
			c.setMaxInvoiceDate(DateUtil.getNextDayOfDay(c.getMaxInvoiceDate(), 1));
		}
		KeyValuePair[] originalKvs = c.getKeyValues();
		List<KeyValuePair> kvList = new ArrayList<>();
		if(null != originalKvs && originalKvs.length > 0) {
			for(KeyValuePair kv : originalKvs) {
				kvList.add(kv);
			}
		}
		String plateIds = BaseHelpUtils.getString(params.get("plateIds"));
		String projectManager = BaseHelpUtils.getString(params.get("projectManager"));
		if(!BaseHelpUtils.isNullOrEmpty(plateIds)) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("AND ct.contract_id = ?");
			kv.setValue(String.format("AND ct.contract_id = ? and i.contract_id in (select contract_id from projects where plate_id in (%1$s) and contract_id > 0)", plateIds));
			kvList.add(kv);
		}else if(!BaseHelpUtils.isNullOrEmpty(projectManager)) {
			KeyValuePair kv = new KeyValuePair();
			kv.setKey("AND ct.contract_id = ?");
			kv.setValue(String.format("AND ct.contract_id = ? and i.contract_id in (select contract_id from projects where project_manage_id = %1$s and contract_id > 0)", projectManager));
			kvList.add(kv);
		}
		int size = kvList.size();
		if(size > 0) {
			KeyValuePair[] kvs = new KeyValuePair[size];
			for(int i = 0; i < size; i++) {
				kvs[i] = kvList.get(i);
			}
			c.setKeyValues(kvs);
		}
		return c;
	}
	
	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSinvoiceitiorcount> result;
		ConditionSinvoiceitiorcount c = generateCondition(creteria);
		QuerySinvoiceitiorcount dao = new QuerySinvoiceitiorcount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		boolean isUser = c.getMinSign() ==0 && c.getMaxSign() ==0 ? false : true ;
		String allCaptions = isUser ? CustomBaseSinvoiceitiorcount.ALL_CAPTIONS : CustomBaseSinvoiceitiorcount.ALL_CAPTIONS_1;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(allCaptions);
			for(BaseSinvoiceitiorcount b : result.getCollections()){
				CustomBaseSinvoiceitiorcount __b = new CustomBaseSinvoiceitiorcount();
				__b.copyFatherData(b);
				ps.println(isUser ?__b.toCSVString() : __b.toCSV1String());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


