/**
 * 
 */
package codetest.util;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.crypto.Data;

import codetest.model.TickData;

/**
 * @author Apple
 *
 */
public class OHLCData {
	
	

	public String calculateZscore(Map<String, List<TickData>> tickdataMap, String strDate) {
		StringBuilder sb = new StringBuilder();
		Date toDate = DateUtils.convertToDate(strDate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		cal.add(Calendar.MINUTE, -20);
		Date fromDate = cal.getTime();
		
		System.out.println("Stock\t zScore\t time\t");
		sb.append("\n");
		sb.append("Stock\t zScore\t time\t");
		tickdataMap.entrySet().stream().forEach(map ->{
			
			
			List<TickData> ls = map.getValue();
			
			List<TickData> newList = ls.stream()
			.filter(item -> item.getConvertedDate().after(fromDate) && item.getConvertedDate().before(toDate))
			.collect(Collectors.toList());
			
			double average = newList.stream().collect(Collectors.summarizingDouble(TickData::getLtp)).getAverage();
			Double firstValue = newList.stream().findFirst().get().getLtp();
			Double current_close = newList.get(newList.size()-1).getLtp();
			Double standardDeviation = current_close - firstValue;
			Double zScore = (current_close -average)/standardDeviation;
			sb.append("\n");
			System.out.println(map.getKey()+"\t"+zScore+"\t"+strDate);
			sb.append(map.getKey()+"\t"+zScore+"\t"+strDate);
			
		});
		return sb.toString();
	}

}
