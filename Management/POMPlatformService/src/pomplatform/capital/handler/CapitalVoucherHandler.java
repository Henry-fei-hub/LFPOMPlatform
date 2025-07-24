package pomplatform.capital.handler;

import org.apache.log4j.Logger;
import pomplatform.capital.bean.BaseCapitalVoucher;
import pomplatform.capital.bean.ConditionCapitalVoucher;
import pomplatform.capital.query.QueryCapitalVoucher;
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

public class CapitalVoucherHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CapitalVoucherHandler.class);

	public static BaseCollection<BaseCapitalVoucher> executeQueryCapitalVoucher(ConditionCapitalVoucher c, KeyValuePair[] replacements ) throws Exception {
		QueryCapitalVoucher dao = new QueryCapitalVoucher();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCapitalVoucher> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCapitalVoucher c = new ConditionCapitalVoucher();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCapitalVoucher> result = executeQueryCapitalVoucher(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCapitalVoucher> result;
		ConditionCapitalVoucher c = new ConditionCapitalVoucher();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCapitalVoucher dao = new QueryCapitalVoucher();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCapitalVoucher.ALL_CAPTIONS);
			for(BaseCapitalVoucher b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


