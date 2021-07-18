/**
 * 
 */
package codetest.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import codetest.model.TickData;


/**
 * @author Apple
 *
 */
public class TickDataConvertor {

	public List<TickData> convertToModel(List<String> data) {
		List<TickData> tickDataArr = new ArrayList<>();
		data.forEach(td -> {
			TickData tickData = new TickData();
				String[] tdArr = td.split("\\s");
				tickData.setStock(tdArr[0]);
				tickData.setLtp(Double.parseDouble(tdArr[3]));
				tickData.setTime(tdArr[6] +" " +tdArr[7] +" " +tdArr[8]);
				tickData.setConvertedDate(DateUtils.convertToDate(tdArr[6] +" " +tdArr[7] +" " +tdArr[8]));
				tickDataArr.add(tickData);
		});
		return tickDataArr;
	}

	public Map<String, List<TickData>> groupData(List<TickData> tickdataList) {
		Map<String, List<TickData>> map = tickdataList.stream().collect(Collectors.groupingBy(TickData::getStock));
		return map;
	}
	
	public String ohclData(Map<String, List<TickData>> tickdataMap) {
		StringBuilder sb = new StringBuilder();
		System.out.println("STOCK\t Open\t High\t Low\t Close\t TIME");
		sb.append("STOCK\t Open\t High\t Low\t Close\t TIME");
		tickdataMap.entrySet().stream().forEach(key ->{
			List<TickData> list = key.getValue();
			sb.append("\n");
			System.out.println(key.getKey()+"\t"+list.get(0).getLtp() +"\t"+list.stream().max(Comparator.comparing(TickData::getLtp)).get().getLtp()+ "\t"+list.stream().min(Comparator.comparing(TickData::getLtp)).get().getLtp() +"\t"+list.get(list.size()-1).getLtp()+"\t"+list.get(list.size()-1).getTime());
			sb.append(key.getKey()+"\t"+list.get(0).getLtp() +"\t"+list.stream().max(Comparator.comparing(TickData::getLtp)).get().getLtp()+ "\t"+list.stream().min(Comparator.comparing(TickData::getLtp)).get().getLtp() +"\t"+list.get(list.size()-1).getLtp()+"\t"+list.get(list.size()-1).getTime());
		});
		return sb.toString();
	}
	
}
