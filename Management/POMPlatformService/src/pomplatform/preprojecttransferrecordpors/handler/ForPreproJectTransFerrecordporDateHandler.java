package pomplatform.preprojecttransferrecordpors.handler;

import org.apache.log4j.Logger;
import pomplatform.preprojecttransferrecordpors.bean.BaseForPreproJectTransFerrecordporDate;
import pomplatform.preprojecttransferrecordpors.bean.ConditionForPreproJectTransFerrecordporDate;
import pomplatform.preprojecttransferrecordpors.query.QueryForPreproJectTransFerrecordporDate;
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

public class ForPreproJectTransFerrecordporDateHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(ForPreproJectTransFerrecordporDateHandler.class);

	public static BaseCollection<BaseForPreproJectTransFerrecordporDate> executeQueryForPreproJectTransFerrecordporDate(ConditionForPreproJectTransFerrecordporDate c, KeyValuePair[] replacements ) throws Exception {
		QueryForPreproJectTransFerrecordporDate dao = new QueryForPreproJectTransFerrecordporDate();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseForPreproJectTransFerrecordporDate> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionForPreproJectTransFerrecordporDate c = new ConditionForPreproJectTransFerrecordporDate();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseForPreproJectTransFerrecordporDate> result = executeQueryForPreproJectTransFerrecordporDate(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseForPreproJectTransFerrecordporDate> result;
		ConditionForPreproJectTransFerrecordporDate c = new ConditionForPreproJectTransFerrecordporDate();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryForPreproJectTransFerrecordporDate dao = new QueryForPreproJectTransFerrecordporDate();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseForPreproJectTransFerrecordporDate.ALL_CAPTIONS);
			for(BaseForPreproJectTransFerrecordporDate b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


