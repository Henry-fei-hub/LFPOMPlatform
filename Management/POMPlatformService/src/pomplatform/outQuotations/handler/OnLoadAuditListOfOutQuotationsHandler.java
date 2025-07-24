package pomplatform.outQuotations.handler;

import org.apache.log4j.Logger;
import pomplatform.outQuotations.bean.BaseOnLoadAuditListOfOutQuotations;
import pomplatform.outQuotations.bean.ConditionOnLoadAuditListOfOutQuotations;
import pomplatform.outQuotations.query.QueryOnLoadAuditListOfOutQuotations;
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

public class OnLoadAuditListOfOutQuotationsHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(OnLoadAuditListOfOutQuotationsHandler.class);

	public static BaseCollection<BaseOnLoadAuditListOfOutQuotations> executeQueryOnLoadAuditListOfOutQuotations(ConditionOnLoadAuditListOfOutQuotations c, KeyValuePair[] replacements ) throws Exception {
		QueryOnLoadAuditListOfOutQuotations dao = new QueryOnLoadAuditListOfOutQuotations();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseOnLoadAuditListOfOutQuotations> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionOnLoadAuditListOfOutQuotations c = new ConditionOnLoadAuditListOfOutQuotations();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseOnLoadAuditListOfOutQuotations> result = executeQueryOnLoadAuditListOfOutQuotations(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseOnLoadAuditListOfOutQuotations> result;
		ConditionOnLoadAuditListOfOutQuotations c = new ConditionOnLoadAuditListOfOutQuotations();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryOnLoadAuditListOfOutQuotations dao = new QueryOnLoadAuditListOfOutQuotations();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseOnLoadAuditListOfOutQuotations.ALL_CAPTIONS);
			for(BaseOnLoadAuditListOfOutQuotations b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


