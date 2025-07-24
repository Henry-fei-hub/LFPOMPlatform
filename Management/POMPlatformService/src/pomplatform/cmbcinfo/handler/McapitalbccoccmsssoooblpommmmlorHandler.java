package pomplatform.cmbcinfo.handler;

import org.apache.log4j.Logger;
import pomplatform.cmbcinfo.bean.BaseMcapitalbccoccmsssoooblpommmmlor;
import pomplatform.cmbcinfo.bean.ConditionMcapitalbccoccmsssoooblpommmmlor;
import pomplatform.cmbcinfo.query.QueryMcapitalbccoccmsssoooblpommmmlor;
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

public class McapitalbccoccmsssoooblpommmmlorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(McapitalbccoccmsssoooblpommmmlorHandler.class);

	public static BaseCollection<BaseMcapitalbccoccmsssoooblpommmmlor> executeQueryMcapitalbccoccmsssoooblpommmmlor(ConditionMcapitalbccoccmsssoooblpommmmlor c, KeyValuePair[] replacements ) throws Exception {
		QueryMcapitalbccoccmsssoooblpommmmlor dao = new QueryMcapitalbccoccmsssoooblpommmmlor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMcapitalbccoccmsssoooblpommmmlor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMcapitalbccoccmsssoooblpommmmlor c = new ConditionMcapitalbccoccmsssoooblpommmmlor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMcapitalbccoccmsssoooblpommmmlor> result = executeQueryMcapitalbccoccmsssoooblpommmmlor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMcapitalbccoccmsssoooblpommmmlor> result;
		ConditionMcapitalbccoccmsssoooblpommmmlor c = new ConditionMcapitalbccoccmsssoooblpommmmlor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMcapitalbccoccmsssoooblpommmmlor dao = new QueryMcapitalbccoccmsssoooblpommmmlor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMcapitalbccoccmsssoooblpommmmlor.ALL_CAPTIONS);
			for(BaseMcapitalbccoccmsssoooblpommmmlor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


