package pomplatform.contracticcisiior.handler;

import org.apache.log4j.Logger;
import pomplatform.contracticcisiior.bean.BaseMcontracticcisiior;
import pomplatform.contracticcisiior.bean.ConditionMcontracticcisiior;
import pomplatform.contracticcisiior.query.QueryMcontracticcisiior;
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

public class McontracticcisiiorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontracticcisiiorHandler.class);

	public static BaseCollection<BaseMcontracticcisiior> executeQueryMcontracticcisiior(ConditionMcontracticcisiior c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontracticcisiior dao = new QueryMcontracticcisiior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontracticcisiior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontracticcisiior c = new ConditionMcontracticcisiior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcontracticcisiior> result = executeQueryMcontracticcisiior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontracticcisiior> result;
		ConditionMcontracticcisiior c = new ConditionMcontracticcisiior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontracticcisiior dao = new QueryMcontracticcisiior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontracticcisiior.ALL_CAPTIONS);
			for(BaseMcontracticcisiior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


