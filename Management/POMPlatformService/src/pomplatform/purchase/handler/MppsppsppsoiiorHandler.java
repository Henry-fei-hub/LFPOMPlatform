package pomplatform.purchase.handler;

import org.apache.log4j.Logger;
import pomplatform.purchase.bean.BaseMppsppsppsoiior;
import pomplatform.purchase.bean.ConditionMppsppsppsoiior;
import pomplatform.purchase.query.QueryMppsppsppsoiior;
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

public class MppsppsppsoiiorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MppsppsppsoiiorHandler.class);

	public static BaseCollection<BaseMppsppsppsoiior> executeQueryMppsppsppsoiior(ConditionMppsppsppsoiior c, KeyValuePair[] replacements ) throws Exception {
		QueryMppsppsppsoiior dao = new QueryMppsppsppsoiior();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMppsppsppsoiior> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMppsppsppsoiior c = new ConditionMppsppsppsoiior();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMppsppsppsoiior> result = executeQueryMppsppsppsoiior(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMppsppsppsoiior> result;
		ConditionMppsppsppsoiior c = new ConditionMppsppsppsoiior();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMppsppsppsoiior dao = new QueryMppsppsppsoiior();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMppsppsppsoiior.ALL_CAPTIONS);
			for(BaseMppsppsppsoiior b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


