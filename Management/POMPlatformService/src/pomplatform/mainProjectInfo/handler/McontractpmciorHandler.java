package pomplatform.mainProjectInfo.handler;

import org.apache.log4j.Logger;
import pomplatform.mainProjectInfo.bean.BaseMcontractpmcior;
import pomplatform.mainProjectInfo.bean.ConditionMcontractpmcior;
import pomplatform.mainProjectInfo.query.QueryMcontractpmcior;
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

public class McontractpmciorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McontractpmciorHandler.class);

	public static BaseCollection<BaseMcontractpmcior> executeQueryMcontractpmcior(ConditionMcontractpmcior c, KeyValuePair[] replacements ) throws Exception {
		QueryMcontractpmcior dao = new QueryMcontractpmcior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcontractpmcior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcontractpmcior c = new ConditionMcontractpmcior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcontractpmcior> result = executeQueryMcontractpmcior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcontractpmcior> result;
		ConditionMcontractpmcior c = new ConditionMcontractpmcior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcontractpmcior dao = new QueryMcontractpmcior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcontractpmcior.ALL_CAPTIONS);
			for(BaseMcontractpmcior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


