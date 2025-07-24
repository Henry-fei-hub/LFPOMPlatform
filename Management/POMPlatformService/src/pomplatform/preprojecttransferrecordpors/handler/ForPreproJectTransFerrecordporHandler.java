package pomplatform.preprojecttransferrecordpors.handler;

import org.apache.log4j.Logger;
import pomplatform.preprojecttransferrecordpors.bean.BaseForPreproJectTransFerrecordpor;
import pomplatform.preprojecttransferrecordpors.bean.ConditionForPreproJectTransFerrecordpor;
import pomplatform.preprojecttransferrecordpors.query.QueryForPreproJectTransFerrecordpor;
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

public class ForPreproJectTransFerrecordporHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ForPreproJectTransFerrecordporHandler.class);

	public static BaseCollection<BaseForPreproJectTransFerrecordpor> executeQueryForPreproJectTransFerrecordpor(ConditionForPreproJectTransFerrecordpor c, KeyValuePair[] replacements ) throws Exception {
		QueryForPreproJectTransFerrecordpor dao = new QueryForPreproJectTransFerrecordpor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseForPreproJectTransFerrecordpor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionForPreproJectTransFerrecordpor c = new ConditionForPreproJectTransFerrecordpor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseForPreproJectTransFerrecordpor> result = executeQueryForPreproJectTransFerrecordpor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseForPreproJectTransFerrecordpor> result;
		ConditionForPreproJectTransFerrecordpor c = new ConditionForPreproJectTransFerrecordpor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryForPreproJectTransFerrecordpor dao = new QueryForPreproJectTransFerrecordpor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseForPreproJectTransFerrecordpor.ALL_CAPTIONS);
			for(BaseForPreproJectTransFerrecordpor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


