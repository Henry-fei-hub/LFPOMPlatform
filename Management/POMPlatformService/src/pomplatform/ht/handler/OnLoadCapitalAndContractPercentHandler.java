package pomplatform.ht.handler;

import org.apache.log4j.Logger;
import pomplatform.ht.bean.BaseOnLoadCapitalAndContractPercent;
import pomplatform.ht.bean.ConditionOnLoadCapitalAndContractPercent;
import pomplatform.ht.query.QueryOnLoadCapitalAndContractPercent;
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

public class OnLoadCapitalAndContractPercentHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadCapitalAndContractPercentHandler.class);

	public static BaseCollection<BaseOnLoadCapitalAndContractPercent> executeQueryOnLoadCapitalAndContractPercent(ConditionOnLoadCapitalAndContractPercent c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadCapitalAndContractPercent dao = new QueryOnLoadCapitalAndContractPercent();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadCapitalAndContractPercent> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadCapitalAndContractPercent c = new ConditionOnLoadCapitalAndContractPercent();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadCapitalAndContractPercent> result = executeQueryOnLoadCapitalAndContractPercent(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadCapitalAndContractPercent> result;
		ConditionOnLoadCapitalAndContractPercent c = new ConditionOnLoadCapitalAndContractPercent();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadCapitalAndContractPercent dao = new QueryOnLoadCapitalAndContractPercent();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadCapitalAndContractPercent.ALL_CAPTIONS);
			for(BaseOnLoadCapitalAndContractPercent b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


