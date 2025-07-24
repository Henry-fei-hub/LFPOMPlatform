package pomplatform.workflow.handler;

import com.pomplatform.db.dao.FileManagesWatermark;
import delicacy.connection.ThreadConnection;
import org.apache.log4j.Logger;
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
import pomplatform.workflow.bean.BaseFileManagesWatermark;
import pomplatform.workflow.bean.ConditionFileManagesWatermark;
import pomplatform.workflow.query.QueryFileManagesWatermark;

public class FileManagesWatermarkHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FileManagesWatermarkHandler.class);

	public static BaseCollection<BaseFileManagesWatermark> executeQueryFileManagesWatermark(ConditionFileManagesWatermark c, KeyValuePair[] replacements ) throws Exception {
		QueryFileManagesWatermark dao = new QueryFileManagesWatermark();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFileManagesWatermark> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFileManagesWatermark c = new ConditionFileManagesWatermark();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFileManagesWatermark> result = executeQueryFileManagesWatermark(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFileManagesWatermark> result;
		ConditionFileManagesWatermark c = new ConditionFileManagesWatermark();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFileManagesWatermark dao = new QueryFileManagesWatermark();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFileManagesWatermark.ALL_CAPTIONS);
			for(BaseFileManagesWatermark b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


