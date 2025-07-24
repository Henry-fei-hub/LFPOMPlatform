package pomplatform.itemCollection.handler;

import org.apache.log4j.Logger;
import pomplatform.itemCollection.bean.BaseMItemCollection;
import pomplatform.itemCollection.bean.ConditionMItemCollection;
import pomplatform.itemCollection.query.QueryMItemCollection;
import pomplatform.itemCollection.query.QueryReceivablesMItemCollection;
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
import delicacy.common.BaseHelpUtils;

public class MItemCollectionHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MItemCollectionHandler.class);

	public static BaseCollection<BaseMItemCollection> executeQueryMItemCollection(ConditionMItemCollection c, KeyValuePair[] replacements ) throws Exception {
		if(BaseHelpUtils.getBoolean(c.getHasContractParagraph())){
			QueryReceivablesMItemCollection dao = new QueryReceivablesMItemCollection();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			BaseCollection<BaseMItemCollection> result = dao.executeQuery( c.getKeyValues(), c) ;
			return result;
		}else{
			QueryMItemCollection dao = new QueryMItemCollection();
			dao.setCurrentPage(c.getCurrentPage());
			dao.setPageLines(c.getPageLines());
			BaseCollection<BaseMItemCollection> result = dao.executeQuery( c.getKeyValues(), c) ;
			return result;
		}
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMItemCollection c = new ConditionMItemCollection();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMItemCollection> result = executeQueryMItemCollection(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMItemCollection> result;
		ConditionMItemCollection c = new ConditionMItemCollection();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMItemCollection dao = new QueryMItemCollection();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMItemCollection.ALL_CAPTIONS);
			for(BaseMItemCollection b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


