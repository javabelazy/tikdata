/**
 * 
 */
package codetest.model;

import java.util.Date;

/**
 * @author Apple
 *
 */
//we can use lombok for getters and setters
public class TickData {

	private String stock;
	private String bID;
	private String ask;
	private Double ltp;
	private String volume;
	private String trendValue;
	private String time;
	private Date convertedDate;

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getbID() {
		return bID;
	}

	public void setbID(String bID) {
		this.bID = bID;
	}

	public String getAsk() {
		return ask;
	}

	public void setAsk(String ask) {
		this.ask = ask;
	}



	public Double getLtp() {
		return ltp;
	}

	public void setLtp(Double ltp) {
		this.ltp = ltp;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getTrendValue() {
		return trendValue;
	}

	public void setTrendValue(String trendValue) {
		this.trendValue = trendValue;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getConvertedDate() {
		return convertedDate;
	}

	public void setConvertedDate(Date convertedDate) {
		this.convertedDate = convertedDate;
	}
	
	

}
