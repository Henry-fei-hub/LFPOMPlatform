package pomplatform.capitaldistribution.handler;

import org.apache.log4j.Logger;
import pomplatform.capitaldistribution.bean.BaseLeftCapitalAmount;
import pomplatform.capitaldistribution.bean.ConditionLeftCapitalAmount;
import pomplatform.capitaldistribution.query.QueryLeftCapitalAmount;
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

public class LeftCapitalAmountHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(LeftCapitalAmountHandler.class);

	public static BaseCollection<BaseLeftCapitalAmount> executeQueryLeftCapitalAmount(ConditionLeftCapitalAmount c, KeyValuePair[] replacements ) throws Exception {
		QueryLeftCapitalAmount dao = new QueryLeftCapitalAmount();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseLeftCapitalAmount> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionLeftCapitalAmount c = new ConditionLeftCapitalAmount();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseLeftCapitalAmount> result = executeQueryLeftCapitalAmount(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseLeftCapitalAmount> result;
		ConditionLeftCapitalAmount c = new ConditionLeftCapitalAmount();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryLeftCapitalAmount dao = new QueryLeftCapitalAmount();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseLeftCapitalAmount.ALL_CAPTIONS);
			for(BaseLeftCapitalAmount b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


