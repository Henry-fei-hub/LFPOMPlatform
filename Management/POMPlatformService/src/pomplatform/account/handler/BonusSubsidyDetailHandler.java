package pomplatform.account.handler;

import org.apache.log4j.Logger;
import pomplatform.account.bean.BaseBonusSubsidyDetail;
import pomplatform.account.bean.ConditionBonusSubsidyDetail;
import pomplatform.account.query.QueryBonusSubsidyDetail;
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

public class BonusSubsidyDetailHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(BonusSubsidyDetailHandler.class);

	public static BaseCollection<BaseBonusSubsidyDetail> executeQueryBonusSubsidyDetail(ConditionBonusSubsidyDetail c, KeyValuePair[] replacements ) throws Exception {
		QueryBonusSubsidyDetail dao = new QueryBonusSubsidyDetail();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseBonusSubsidyDetail> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionBonusSubsidyDetail c = new ConditionBonusSubsidyDetail();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseBonusSubsidyDetail> result = executeQueryBonusSubsidyDetail(c, c.getKeyValues());
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseBonusSubsidyDetail> result;
		ConditionBonusSubsidyDetail c = new ConditionBonusSubsidyDetail();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryBonusSubsidyDetail dao = new QueryBonusSubsidyDetail();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseBonusSubsidyDetail.ALL_CAPTIONS);
			for(BaseBonusSubsidyDetail b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


