/**
 * 
 */
package codetest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import codetest.model.TickData;
import codetest.util.DataReader;
import codetest.util.DataWriter;
import codetest.util.OHLCData;
import codetest.util.TickDataConvertor;

/**
 * @author Apple
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DataReader dataReader = new DataReader();
		List<String> dataList = dataReader.readData();
		
		TickDataConvertor convertor = new TickDataConvertor();
		List<TickData> tickdataList = convertor.convertToModel(dataList);
		Map<String, List<TickData>> tickdataMap = convertor.groupData(tickdataList);
		String ohclData = convertor.ohclData(tickdataMap);
		
		
		// to find zscore for the folowing date
		String date = "01-NOV-18 09.12.00.00 AM";
		
		OHLCData ohlc = new OHLCData();
		String zScoreData = ohlc.calculateZscore(tickdataMap, date);
		
		
		DataWriter writer = new DataWriter();
		try {
			writer.writeData(ohclData,zScoreData );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
