package pomplatform.workflow.handler;

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
import pomplatform.workflow.bean.BaseFileManages;
import pomplatform.workflow.bean.ConditionFileManages;
import pomplatform.workflow.query.QueryFileManages;

public class FileManagesHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(FileManagesHandler.class);

	public static BaseCollection<BaseFileManages> executeQueryFileManages(ConditionFileManages c, KeyValuePair[] replacements ) throws Exception {
		QueryFileManages dao = new QueryFileManages();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseFileManages> result = dao.executeQuery( c.getKeyValues(), c) ;


		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionFileManages c = new ConditionFileManages();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseFileManages> result = executeQueryFileManages(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseFileManages> result;
		ConditionFileManages c = new ConditionFileManages();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryFileManages dao = new QueryFileManages();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseFileManages.ALL_CAPTIONS);
			for(BaseFileManages b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


