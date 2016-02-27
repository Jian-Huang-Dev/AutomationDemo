/**
 * General methods to help writing automated test scripts
 *
 * @author  Jian Huang
 * @since   2015-07-06
 */

package jian.huang.exinda.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Helper {

	/**
	 * Return the starting time of the test
	 * 
	 * @return The start of the test
	 */
	public static long TimeStart() {
		long time_start = System.currentTimeMillis();
		AppendText("*** TEST STARTS ***");
		return time_start;
	}

	/**
	 * An indication of the ending time of the test, and execution time
	 * 
	 * @param time_start
	 */
	public static void TimeEnd(long time_start) {
		long time_end = System.currentTimeMillis();
		long time_duration = (time_end - time_start) / 1000;
		AppendText("Test ends at: " + CurrentDateTime()
				+ " --> Time Duration: " + String.valueOf(time_duration) + " s");
	}

	/**
	 * Display current date and time
	 * 
	 * @return current date and time
	 */
	public static String CurrentDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.date_format);
		dateFormat.setTimeZone(TimeZone.getTimeZone(Constant.time_zone));
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * Add text to the report file
	 * 
	 * @param string
	 */
	public static void AppendText(String string) {
		FileWriter fileOutput = null;
		File file;
		try {
			file = new File(Constant.report_file);
			fileOutput = new FileWriter(file, true);

			if (!file.exists()) {
				file.createNewFile();
			}

			fileOutput
					.write("\n" + CurrentDateTime() + " --> " + string + "\n");
			fileOutput.flush();
			fileOutput.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutput != null) {
					fileOutput.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
