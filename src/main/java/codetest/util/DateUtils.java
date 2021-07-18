/**
 * 
 */
package codetest.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static codetest.constants.Constants.DATE_FORMAT;

/**
 * @author Apple
 *
 */
public class DateUtils {

	public static Date convertToDate(String strDate) {

		Date date = null;
		try {
			date = new SimpleDateFormat(DATE_FORMAT).parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

}
