package pomplatform.reimbursement.handler;

import org.apache.log4j.Logger;
import pomplatform.reimbursement.bean.BaseK3VoucherSummary;
import pomplatform.reimbursement.bean.ConditionK3VoucherSummary;
import pomplatform.reimbursement.query.QueryK3VoucherSummary;
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

public class K3VoucherSummaryHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(K3VoucherSummaryHandler.class);

	public static BaseCollection<BaseK3VoucherSummary> executeQueryK3VoucherSummary(ConditionK3VoucherSummary c, KeyValuePair[] replacements ) throws Exception {
		QueryK3VoucherSummary dao = new QueryK3VoucherSummary();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseK3VoucherSummary> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionK3VoucherSummary c = new ConditionK3VoucherSummary();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseK3VoucherSummary> result = executeQueryK3VoucherSummary(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseK3VoucherSummary> result;
		ConditionK3VoucherSummary c = new ConditionK3VoucherSummary();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryK3VoucherSummary dao = new QueryK3VoucherSummary();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseK3VoucherSummary.ALL_CAPTIONS);
			for(BaseK3VoucherSummary b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


