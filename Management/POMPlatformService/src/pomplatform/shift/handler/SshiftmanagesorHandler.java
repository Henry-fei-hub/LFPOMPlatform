package pomplatform.shift.handler;

import org.apache.log4j.Logger;

import pomplatform.shift.bean.BaseSshiftmanagesor;
import pomplatform.shift.bean.ConditionSshiftmanagesor;
import pomplatform.shift.query.QuerySshiftmanagesor;
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

public class SshiftmanagesorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(SshiftmanagesorHandler.class);

	public static BaseCollection<BaseSshiftmanagesor> executeQuerySshiftmanagesor(ConditionSshiftmanagesor c, KeyValuePair[] replacements ) throws Exception {
		QuerySshiftmanagesor dao = new QuerySshiftmanagesor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseSshiftmanagesor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionSshiftmanagesor c = new ConditionSshiftmanagesor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseSshiftmanagesor> result = executeQuerySshiftmanagesor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseSshiftmanagesor> result;
		ConditionSshiftmanagesor c = new ConditionSshiftmanagesor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QuerySshiftmanagesor dao = new QuerySshiftmanagesor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseSshiftmanagesor.ALL_CAPTIONS);
			for(BaseSshiftmanagesor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


