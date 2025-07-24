package pomplatform.mcapitalsubcontractscoor.handler;

import org.apache.log4j.Logger;
import pomplatform.mcapitalsubcontractscoor.bean.BaseMcapitalsubcontractscoor;
import pomplatform.mcapitalsubcontractscoor.bean.ConditionMcapitalsubcontractscoor;
import pomplatform.mcapitalsubcontractscoor.query.QueryMcapitalsubcontractscoor;
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

public class McapitalsubcontractscoorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitalsubcontractscoorHandler.class);

	public static BaseCollection<BaseMcapitalsubcontractscoor> executeQueryMcapitalsubcontractscoor(ConditionMcapitalsubcontractscoor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcapitalsubcontractscoor dao = new QueryMcapitalsubcontractscoor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcapitalsubcontractscoor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitalsubcontractscoor c = new ConditionMcapitalsubcontractscoor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitalsubcontractscoor> result = executeQueryMcapitalsubcontractscoor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitalsubcontractscoor> result;
		ConditionMcapitalsubcontractscoor c = new ConditionMcapitalsubcontractscoor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcapitalsubcontractscoor dao = new QueryMcapitalsubcontractscoor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitalsubcontractscoor.ALL_CAPTIONS);
			for(BaseMcapitalsubcontractscoor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


