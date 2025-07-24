package pomplatform.report.handler;

import org.apache.log4j.Logger;
import pomplatform.report.bean.BaseCollectionrevenueanalysis;
import pomplatform.report.bean.ConditionCollectionrevenueanalysis;
import pomplatform.report.query.QueryCollectionrevenueanalysis;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class CollectionrevenueanalysisHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(CollectionrevenueanalysisHandler.class);

	public static BaseCollection<BaseCollectionrevenueanalysis> executeQueryCollectionrevenueanalysis(ConditionCollectionrevenueanalysis c, KeyValuePair[] replacements ) throws Exception {
		QueryCollectionrevenueanalysis dao = new QueryCollectionrevenueanalysis();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseCollectionrevenueanalysis> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionCollectionrevenueanalysis c = new ConditionCollectionrevenueanalysis();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseCollectionrevenueanalysis> result = executeQueryCollectionrevenueanalysis(c, c.getKeyValues());
		if(!BaseHelpUtils.isNullOrEmpty(result)&&result.getCollections().size()>0) {
			List<BaseCollectionrevenueanalysis> collections = result.getCollections();
			for (BaseCollectionrevenueanalysis baseCollectionrevenueanalysis : collections) {
				
				String str1 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getJanuaryLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str2 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getFebruaryLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str3 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getMarchLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str4 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getAprilLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str5 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getMayLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str6 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getJuneLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str7 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getJulyLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str8 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getAugustLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str9 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getSeptemberLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str10 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getOctoberLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str11 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getNovemberLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str12 =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getDecemberLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				String str =BaseHelpUtils.getBigDecimalValue(baseCollectionrevenueanalysis.getTotalLeft()).setScale(2, BigDecimal.ROUND_DOWN)+"%";
				
				baseCollectionrevenueanalysis.setStr1(str1);
				baseCollectionrevenueanalysis.setStr2(str2);
				baseCollectionrevenueanalysis.setStr3(str3);
				baseCollectionrevenueanalysis.setStr4(str4);
				baseCollectionrevenueanalysis.setStr5(str5);
				baseCollectionrevenueanalysis.setStr6(str6);
				baseCollectionrevenueanalysis.setStr7(str7);
				baseCollectionrevenueanalysis.setStr8(str8);
				baseCollectionrevenueanalysis.setStr9(str9);
				baseCollectionrevenueanalysis.setStr10(str10);
				baseCollectionrevenueanalysis.setStr11(str11);
				baseCollectionrevenueanalysis.setStr12(str12);
				baseCollectionrevenueanalysis.setStr(str);
			}
		}
		return result.toJSON(null);
	}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseCollectionrevenueanalysis> result;
		ConditionCollectionrevenueanalysis c = new ConditionCollectionrevenueanalysis();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryCollectionrevenueanalysis dao = new QueryCollectionrevenueanalysis();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseCollectionrevenueanalysis.ALL_CAPTIONS);
			for(BaseCollectionrevenueanalysis b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}

}


