package pomplatform.outQuotations.handler;

import org.apache.log4j.Logger;
import pomplatform.outQuotations.bean.BaseMoutquotationooor;
import pomplatform.outQuotations.bean.ConditionMoutquotationooor;
import pomplatform.outQuotations.query.QueryMoutquotationooor;
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

public class MoutquotationooorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MoutquotationooorHandler.class);

	public static BaseCollection<BaseMoutquotationooor> executeQueryMoutquotationooor(ConditionMoutquotationooor c, KeyValuePair[] replacements ) throws Exception {
		QueryMoutquotationooor dao = new QueryMoutquotationooor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMoutquotationooor> result = dao.execute( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMoutquotationooor c = new ConditionMoutquotationooor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMoutquotationooor> result = executeQueryMoutquotationooor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMoutquotationooor> result;
		ConditionMoutquotationooor c = new ConditionMoutquotationooor();
		c.setDataFromJSON(creteria);
		QueryMoutquotationooor dao = new QueryMoutquotationooor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.execute( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.execute( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMoutquotationooor.ALL_CAPTIONS);
			for(BaseMoutquotationooor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


