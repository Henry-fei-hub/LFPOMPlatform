package pomplatform.scontractreceivabletemplaterrcor.handler;

import org.apache.log4j.Logger;
import pomplatform.scontractreceivabletemplaterrcor.bean.BaseScontractreceivabletemplaterrcor;
import pomplatform.scontractreceivabletemplaterrcor.bean.ConditionScontractreceivabletemplaterrcor;
import pomplatform.scontractreceivabletemplaterrcor.query.QueryScontractreceivabletemplaterrcor;
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

public class ScontractreceivabletemplaterrcorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ScontractreceivabletemplaterrcorHandler.class);

	public static BaseCollection<BaseScontractreceivabletemplaterrcor> executeQueryScontractreceivabletemplaterrcor(ConditionScontractreceivabletemplaterrcor c, KeyValuePair[] replacements ) throws Exception {
		QueryScontractreceivabletemplaterrcor dao = new QueryScontractreceivabletemplaterrcor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseScontractreceivabletemplaterrcor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionScontractreceivabletemplaterrcor c = new ConditionScontractreceivabletemplaterrcor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseScontractreceivabletemplaterrcor> result = executeQueryScontractreceivabletemplaterrcor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseScontractreceivabletemplaterrcor> result;
		ConditionScontractreceivabletemplaterrcor c = new ConditionScontractreceivabletemplaterrcor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryScontractreceivabletemplaterrcor dao = new QueryScontractreceivabletemplaterrcor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseScontractreceivabletemplaterrcor.ALL_CAPTIONS);
			for(BaseScontractreceivabletemplaterrcor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


