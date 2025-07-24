package pomplatform.capitalDsitributionemployee.handler;

import org.apache.log4j.Logger;
import pomplatform.capitalDsitributionemployee.bean.BaseMemployeeaccountrecordespemmor;
import pomplatform.capitalDsitributionemployee.bean.ConditionMemployeeaccountrecordespemmor;
import pomplatform.capitalDsitributionemployee.query.QueryMemployeeaccountrecordespemmor;
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

public class MemployeeaccountrecordespemmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MemployeeaccountrecordespemmorHandler.class);

	public static BaseCollection<BaseMemployeeaccountrecordespemmor> executeQueryMemployeeaccountrecordespemmor(ConditionMemployeeaccountrecordespemmor c, KeyValuePair[] replacements ) throws Exception {
		QueryMemployeeaccountrecordespemmor dao = new QueryMemployeeaccountrecordespemmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMemployeeaccountrecordespemmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMemployeeaccountrecordespemmor c = new ConditionMemployeeaccountrecordespemmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMemployeeaccountrecordespemmor> result = executeQueryMemployeeaccountrecordespemmor(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMemployeeaccountrecordespemmor> result;
		ConditionMemployeeaccountrecordespemmor c = new ConditionMemployeeaccountrecordespemmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMemployeeaccountrecordespemmor dao = new QueryMemployeeaccountrecordespemmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMemployeeaccountrecordespemmor.ALL_CAPTIONS);
			for(BaseMemployeeaccountrecordespemmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


