package pomplatform.capatialandinvoice.handler;

import org.apache.log4j.Logger;
import pomplatform.capatialandinvoice.bean.BaseCapitalAndInvoiceTwo;
import pomplatform.capatialandinvoice.bean.ConditionCapitalAndInvoiceTwo;
import pomplatform.capatialandinvoice.query.QueryCapitalAndInvoiceTwo;
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

public class CapitalAndInvoiceTwoHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalAndInvoiceTwoHandler.class);

	public static BaseCollection<BaseCapitalAndInvoiceTwo> executeQueryCapitalAndInvoiceTwo(ConditionCapitalAndInvoiceTwo c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalAndInvoiceTwo dao = new QueryCapitalAndInvoiceTwo();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalAndInvoiceTwo> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalAndInvoiceTwo c = new ConditionCapitalAndInvoiceTwo();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalAndInvoiceTwo> result = executeQueryCapitalAndInvoiceTwo(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalAndInvoiceTwo> result;
		ConditionCapitalAndInvoiceTwo c = new ConditionCapitalAndInvoiceTwo();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalAndInvoiceTwo dao = new QueryCapitalAndInvoiceTwo();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalAndInvoiceTwo.ALL_CAPTIONS);
			for(BaseCapitalAndInvoiceTwo b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


