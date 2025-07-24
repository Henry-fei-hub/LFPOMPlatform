package pomplatform.contractreceivablecipor.handler;

import org.apache.log4j.Logger;
import pomplatform.contractreceivablecipor.bean.BaseScontractreceivablecipor;
import pomplatform.contractreceivablecipor.bean.ConditionScontractreceivablecipor;
import pomplatform.contractreceivablecipor.query.QueryScontractreceivablecipor;
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

public class ScontractreceivableciporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScontractreceivableciporHandler.class);

	public static BaseCollection<BaseScontractreceivablecipor> executeQueryScontractreceivablecipor(ConditionScontractreceivablecipor c, KeyValuePair[] replacements ) throws Exception {
		QueryScontractreceivablecipor dao = new QueryScontractreceivablecipor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScontractreceivablecipor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScontractreceivablecipor c = new ConditionScontractreceivablecipor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScontractreceivablecipor> result = executeQueryScontractreceivablecipor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScontractreceivablecipor> result;
		ConditionScontractreceivablecipor c = new ConditionScontractreceivablecipor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScontractreceivablecipor dao = new QueryScontractreceivablecipor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScontractreceivablecipor.ALL_CAPTIONS);
			for(BaseScontractreceivablecipor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


