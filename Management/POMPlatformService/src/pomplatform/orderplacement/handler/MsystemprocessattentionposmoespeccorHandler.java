package pomplatform.orderplacement.handler;

import org.apache.log4j.Logger;
import pomplatform.orderplacement.bean.BaseMsystemprocessattentionposmoespeccor;
import pomplatform.orderplacement.bean.ConditionMsystemprocessattentionposmoespeccor;
import pomplatform.orderplacement.query.QueryMsystemprocessattentionposmoespeccor;
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

public class MsystemprocessattentionposmoespeccorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MsystemprocessattentionposmoespeccorHandler.class);

	public static BaseCollection<BaseMsystemprocessattentionposmoespeccor> executeQueryMsystemprocessattentionposmoespeccor(ConditionMsystemprocessattentionposmoespeccor c, KeyValuePair[] replacements ) throws Exception {
		QueryMsystemprocessattentionposmoespeccor dao = new QueryMsystemprocessattentionposmoespeccor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMsystemprocessattentionposmoespeccor> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMsystemprocessattentionposmoespeccor c = new ConditionMsystemprocessattentionposmoespeccor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMsystemprocessattentionposmoespeccor> result = executeQueryMsystemprocessattentionposmoespeccor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMsystemprocessattentionposmoespeccor> result;
		ConditionMsystemprocessattentionposmoespeccor c = new ConditionMsystemprocessattentionposmoespeccor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMsystemprocessattentionposmoespeccor dao = new QueryMsystemprocessattentionposmoespeccor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMsystemprocessattentionposmoespeccor.ALL_CAPTIONS);
			for(BaseMsystemprocessattentionposmoespeccor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


