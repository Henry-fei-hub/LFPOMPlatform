package pomplatform.receivables.handler;

import org.apache.log4j.Logger;
import pomplatform.receivables.bean.BaseMcapitalhyhor;
import pomplatform.receivables.bean.ConditionMcapitalhyhor;
import pomplatform.receivables.query.QueryMcapitalhyhor;
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

public class McapitalhyhorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitalhyhorHandler.class);

	public static BaseCollection<BaseMcapitalhyhor> executeQueryMcapitalhyhor(ConditionMcapitalhyhor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcapitalhyhor dao = new QueryMcapitalhyhor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcapitalhyhor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitalhyhor c = new ConditionMcapitalhyhor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitalhyhor> result = executeQueryMcapitalhyhor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitalhyhor> result;
		ConditionMcapitalhyhor c = new ConditionMcapitalhyhor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcapitalhyhor dao = new QueryMcapitalhyhor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitalhyhor.ALL_CAPTIONS);
			for(BaseMcapitalhyhor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


