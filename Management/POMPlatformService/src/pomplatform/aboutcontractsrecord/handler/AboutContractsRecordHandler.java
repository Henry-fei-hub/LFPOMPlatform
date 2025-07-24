package pomplatform.aboutcontractsrecord.handler;

import org.apache.log4j.Logger;
import pomplatform.aboutcontractsrecord.bean.BaseAboutContractsRecord;
import pomplatform.aboutcontractsrecord.bean.ConditionAboutContractsRecord;
import pomplatform.aboutcontractsrecord.query.QueryAboutContractsRecord;
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

public class AboutContractsRecordHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(AboutContractsRecordHandler.class);

	public static BaseCollection<BaseAboutContractsRecord> executeQueryAboutContractsRecord(ConditionAboutContractsRecord c, KeyValuePair[] replacements ) throws Exception {
		QueryAboutContractsRecord dao = new QueryAboutContractsRecord();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseAboutContractsRecord> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionAboutContractsRecord c = new ConditionAboutContractsRecord();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseAboutContractsRecord> result = executeQueryAboutContractsRecord(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseAboutContractsRecord> result;
		ConditionAboutContractsRecord c = new ConditionAboutContractsRecord();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryAboutContractsRecord dao = new QueryAboutContractsRecord();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseAboutContractsRecord.ALL_CAPTIONS);
			for(BaseAboutContractsRecord b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


