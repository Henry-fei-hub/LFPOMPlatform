package pomplatform.selectgrid.handler;

import org.apache.log4j.Logger;
import pomplatform.selectgrid.bean.BaseSelectGridInvoiceTypeValue;
import pomplatform.selectgrid.bean.ConditionSelectGridInvoiceTypeValue;
import pomplatform.selectgrid.query.QuerySelectGridInvoiceTypeValue;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;

public class SelectGridInvoiceTypeValueHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SelectGridInvoiceTypeValueHandler.class);

	public static BaseCollection<BaseSelectGridInvoiceTypeValue> executeQuerySelectGridInvoiceTypeValue(ConditionSelectGridInvoiceTypeValue c, KeyValuePair[] replacements ) throws Exception {
		QuerySelectGridInvoiceTypeValue dao = new QuerySelectGridInvoiceTypeValue();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSelectGridInvoiceTypeValue> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSelectGridInvoiceTypeValue c = new ConditionSelectGridInvoiceTypeValue();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSelectGridInvoiceTypeValue> result = executeQuerySelectGridInvoiceTypeValue(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSelectGridInvoiceTypeValue> result;
		ConditionSelectGridInvoiceTypeValue c = new ConditionSelectGridInvoiceTypeValue();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySelectGridInvoiceTypeValue dao = new QuerySelectGridInvoiceTypeValue();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSelectGridInvoiceTypeValue.ALL_CAPTIONS);
			for(BaseSelectGridInvoiceTypeValue b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


