package pomplatform.project.handler;

import org.apache.log4j.Logger;
import pomplatform.project.bean.BaseMprojecttrcccsyyyseyymmymmor;
import pomplatform.project.bean.ConditionMprojecttrcccsyyyseyymmymmor;
import pomplatform.project.query.QueryMprojecttrcccsyyyseyymmymmor;
import delicacy.common.KeyValuePair;
import delicacy.common.GenericQuery;
import delicacy.common.GenericDownloadProcessor;
import delicacy.common.GenericBase;
import java.io.File;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import delicacy.common.BaseCollection;
import delicacy.common.BaseHelpUtils;

public class MprojecttrcccsyyyseyymmymmorHandler implements GenericQuery,  GenericDownloadProcessor {

	private static final Logger __logger = Logger.getLogger(MprojecttrcccsyyyseyymmymmorHandler.class);

	public static BaseCollection<BaseMprojecttrcccsyyyseyymmymmor> executeQueryMprojecttrcccsyyyseyymmymmor(ConditionMprojecttrcccsyyyseyymmymmor c, KeyValuePair[] replacements ) throws Exception {
		QueryMprojecttrcccsyyyseyymmymmor dao = new QueryMprojecttrcccsyyyseyymmymmor();
		dao.setCurrentPage(c.getCurrentPage());
		dao.setPageLines(c.getPageLines());
		BaseCollection<BaseMprojecttrcccsyyyseyymmymmor> result = dao.executeQuery( c.getKeyValues(), c) ;
		return result;
	}

	@Override
	public String find(String creteria) throws Exception {
		ConditionMprojecttrcccsyyyseyymmymmor c = new ConditionMprojecttrcccsyyyseyymmymmor();
		c.setDataFromJSON(creteria);
		BaseCollection<BaseMprojecttrcccsyyyseyymmymmor> result = executeQueryMprojecttrcccsyyyseyymmymmor(c, c.getKeyValues());
		//统计合同额 ，  营收完成值，营收指标值，营收完成率，现金流完成值，现金流指标值，现金流完成率的合计
		//存放合计的各个值
		BaseMprojecttrcccsyyyseyymmymmor base =new BaseMprojecttrcccsyyyseyymmymmor();
		//11 = 合计
		base.setBusinessLine(12);
		BigDecimal sumSheetAmount =BigDecimal.ZERO;//合同额
		BigDecimal sumCurrentRevenue =BigDecimal.ZERO;//  营收完成值
		BigDecimal targetType1 =BigDecimal.ZERO;//营收指标值
		String percentageComplete1 ="0";//营收完成率
		BigDecimal sumDistributionAmount =BigDecimal.ZERO;//现金流完成值
		BigDecimal targetType2 =BigDecimal.ZERO;//现金流指标值
		String percentageComplete2 ="0";//现金流完成率
		BigDecimal hundred =new BigDecimal(100);
		
		BigDecimal divide=BigDecimal.ZERO;
		BigDecimal divide6=BigDecimal.ZERO;
		
		List<BigDecimal> rank_1 =new ArrayList<>();
		List<BigDecimal> rank_2 =new ArrayList<>();
		
		if(!BaseHelpUtils.isNullOrEmpty(result)) {
			List<BaseMprojecttrcccsyyyseyymmymmor> collections = result.getCollections();
			if(!BaseHelpUtils.isNullOrEmpty(collections)&&collections.size()>0) {
				for (BaseMprojecttrcccsyyyseyymmymmor baseMprojecttrcccsyyyseyymmymmor : collections) {
					sumSheetAmount=sumSheetAmount.add(BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumSheetAmount()));
					sumCurrentRevenue=sumCurrentRevenue.add(BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumCurrentRevenue()));
					targetType1= targetType1.add(BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getTargetType1()));
					sumDistributionAmount=sumDistributionAmount.add(BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumDistributionAmount())) ;
					targetType2= targetType2.add(BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getTargetType2()));
				}
			}
		}else {
			return result.toJSON(-1, "查询异常");
		}
		
		//完成值/指标=完成率
		if(targetType1.compareTo(BigDecimal.ZERO)==1) {
			divide = sumCurrentRevenue.divide(targetType1, 4, BigDecimal.ROUND_HALF_UP);
		}
		
		if(targetType2.compareTo(BigDecimal.ZERO)==1) {
			divide6 = sumDistributionAmount.divide(targetType2, 4, BigDecimal.ROUND_HALF_UP);//完成值/指标=完成率
		}
		
		base.setSumSheetAmount(sumSheetAmount);
		base.setSumCurrentRevenue(sumCurrentRevenue);
		base.setTargetType1(targetType1);
		base.setSumDistributionAmount(sumDistributionAmount);
		base.setTargetType2(targetType2);
		
		base.setPercentageComplete1(divide.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		base.setPercentageComplete2(divide6.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
		
		
		//统计营收完成值占比   指标占比   排名   完成率
		//统计现金流排名    完成率
		List<BaseMprojecttrcccsyyyseyymmymmor> collections = result.getCollections();
		for (BaseMprojecttrcccsyyyseyymmymmor baseMprojecttrcccsyyyseyymmymmor : collections) {
			BigDecimal SheetAmount =BigDecimal.ZERO;
			BigDecimal CurrentRevenue =BigDecimal.ZERO;
			BigDecimal TargetType1 = BigDecimal.ZERO;
			BigDecimal DistributionAmount =BigDecimal.ZERO;
			BigDecimal TargetType2 =BigDecimal.ZERO;
			
			BigDecimal divide2=BigDecimal.ZERO;
			BigDecimal divide3=BigDecimal.ZERO;
			BigDecimal divide4=BigDecimal.ZERO;
			BigDecimal divide5=BigDecimal.ZERO;
			
			if(!BaseHelpUtils.isNullOrEmpty(baseMprojecttrcccsyyyseyymmymmor.getSumSheetAmount())&& baseMprojecttrcccsyyyseyymmymmor.getSumSheetAmount().compareTo(BigDecimal.ZERO)==1) {
				SheetAmount = BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumSheetAmount());
			}
			if(!BaseHelpUtils.isNullOrEmpty(baseMprojecttrcccsyyyseyymmymmor.getSumCurrentRevenue())&&baseMprojecttrcccsyyyseyymmymmor.getSumCurrentRevenue().compareTo(BigDecimal.ZERO)==1) {
				CurrentRevenue = BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumCurrentRevenue());
			}
			if(!BaseHelpUtils.isNullOrEmpty(baseMprojecttrcccsyyyseyymmymmor.getTargetType1())&&baseMprojecttrcccsyyyseyymmymmor.getTargetType1().compareTo(BigDecimal.ZERO)==1) {
				TargetType1 = BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getTargetType1());
			}
			if(!BaseHelpUtils.isNullOrEmpty(baseMprojecttrcccsyyyseyymmymmor.getSumDistributionAmount())&&baseMprojecttrcccsyyyseyymmymmor.getSumDistributionAmount().compareTo(BigDecimal.ZERO)==1) {
				DistributionAmount = BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getSumDistributionAmount());
			}
			if(!BaseHelpUtils.isNullOrEmpty(baseMprojecttrcccsyyyseyymmymmor.getTargetType2())&&baseMprojecttrcccsyyyseyymmymmor.getTargetType2().compareTo(BigDecimal.ZERO)==1) {
				TargetType2 = BaseHelpUtils.getBigDecimalValue(baseMprojecttrcccsyyyseyymmymmor.getTargetType2());
			}
			
			if(sumCurrentRevenue.compareTo(BigDecimal.ZERO)==1) {
				 divide2 = CurrentRevenue.divide(sumCurrentRevenue, 4, BigDecimal.ROUND_HALF_UP);//完成/完成值总和=完成占比
			}
			if(targetType1.compareTo(BigDecimal.ZERO)==1) {
				 divide3 = TargetType1.divide(targetType1, 4, BigDecimal.ROUND_HALF_UP); //指标/指标总和=指标占比
			}
			if(TargetType1.compareTo(BigDecimal.ZERO)==1) {
				 divide4 = CurrentRevenue.divide(TargetType1, 4, BigDecimal.ROUND_HALF_UP);//完成值/指标=完成率
			}
			if(TargetType2.compareTo(BigDecimal.ZERO)==1) {
				 divide5 = DistributionAmount.divide(TargetType2, 4, BigDecimal.ROUND_HALF_UP);//完成值/指标=完成率
			}
			
			rank_1.add(divide4);
			rank_2.add(divide5);
			
			baseMprojecttrcccsyyyseyymmymmor.setSumCurrentRevenueProportion(divide2.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			baseMprojecttrcccsyyyseyymmymmor.setTargetType1Proportion(divide3.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			baseMprojecttrcccsyyyseyymmymmor.setPercentageComplete1(divide4.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			baseMprojecttrcccsyyyseyymmymmor.setPercentageComplete2(divide5.multiply(hundred).setScale(2, BigDecimal.ROUND_HALF_UP)+"%");
			baseMprojecttrcccsyyyseyymmymmor.setBack1(divide4+"");
			baseMprojecttrcccsyyyseyymmymmor.setBack2(divide5+"");
			
		}
		
		List<BaseMprojecttrcccsyyyseyymmymmor> sort = sort(collections, rank_1, 1);
		List<BaseMprojecttrcccsyyyseyymmymmor> sort2 = sort(sort, rank_2, 2);
		sort2.add(base);
		
		result.setCollections(sort2);
		
		return result.toJSON(null);
	}
	
	//排序方法
	private List<BaseMprojecttrcccsyyyseyymmymmor> sort(List<BaseMprojecttrcccsyyyseyymmymmor> collections,List<BigDecimal> rank,int type) {
		if(rank.size()==collections.size()) {
			for (int i = 0; i < rank.size(); i++) {//排序轮数
				 for(int j=0;j<rank.size()-1-i;j++){//比较次数
					 BigDecimal d1 = rank.get(j);
					 BigDecimal d2 = rank.get(j+1);
					 if(d1.compareTo(d2)==-1) {
						 BigDecimal temp = d2;
						 rank.set(j+1, d1);
						 rank.set(j, temp);
					 }
		        }
			}
			
			if(type==1) {
				for (BaseMprojecttrcccsyyyseyymmymmor base : collections) {
					BigDecimal back1 = BaseHelpUtils.getBigDecimalValue(base.getBack1());
						for (int i = 0; i < rank.size(); i++) {
							if(rank.get(i).compareTo(back1)==0) {
								base.setRank1(i+1);
							}
							if(back1.compareTo(new BigDecimal("0.0000"))==0) {
								base.setRank1(i+1);
							}
						}
					}
				}else {
					for (BaseMprojecttrcccsyyyseyymmymmor base : collections) {
						BigDecimal back2 = BaseHelpUtils.getBigDecimalValue(base.getBack2());
							for (int i = 0; i < rank.size(); i++) {
								if(rank.get(i).compareTo(back2)==0) {
									base.setRank2(i+1);
								}
								if(back2.compareTo(new BigDecimal("0.0000"))==0) {
									base.setRank2(i+1);
								}
							}
					}
				}
			}
			return collections;
		}

	@Override
	public void execute(String creteria, File downFile, HttpServletRequest request, HttpServletResponse response) throws Exception {
		BaseCollection<BaseMprojecttrcccsyyyseyymmymmor> result;
		ConditionMprojecttrcccsyyyseyymmymmor c = new ConditionMprojecttrcccsyyyseyymmymmor();
		c.setDataFromJSON(creteria);
		c.setCurrentPage(0);
		QueryMprojecttrcccsyyyseyymmymmor dao = new QueryMprojecttrcccsyyyseyymmymmor();
		dao.setCurrentPage(1);
		dao.setPageLines(1);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		if(result.getTotalLines() > GenericBase.MAX_EXPORT_LINES){
			throw new SQLException(String.format("Too many data to export : %1$d", result.getTotalLines()));
		}
		dao.setCurrentPage(0);
		result = dao.executeQuery( c.getKeyValues(), c) ;
		try(PrintStream ps = new PrintStream(downFile, "GBK")){
			ps.println(BaseMprojecttrcccsyyyseyymmymmor.ALL_CAPTIONS);
			for(BaseMprojecttrcccsyyyseyymmymmor b : result.getCollections()){
				ps.println(b.toCSVString());
			}
		}
	}

	@Override
	public String getDownloadFileExtension() {
		return "csv";
	}
	


}


