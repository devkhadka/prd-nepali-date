/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nepalidate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author dev
 */
public class NepaliDateConverterUtil {

    /**
     *
     * @param d
     * @return
     */
    public static String convertToNepali(Date d) {
        Calendar currentEngDate = new GregorianCalendar();
        currentEngDate.set(d.getYear() + 1900, d.getMonth(), d.getDate());
        int[] nepdate = NepaliDateConverterResource.convertToNepali(currentEngDate);
        int nepYear = nepdate[0];
        int nepMonth = nepdate[1];
        int nepDay = nepdate[2];
        String nepMonthStr = (nepMonth < 10) ? "0" + nepMonth : String.valueOf(nepMonth);
        String nepDayStr = (nepDay < 10) ? "0" + nepDay : String.valueOf(nepDay);
        return nepYear + "/" + nepMonthStr + "/" + nepDayStr;
    }

    /**
     *
     * @param nepaliDate
     * @return
     * @throws Exception
     */
    public static Date convertToEnglish(String nepaliDate) throws Exception {
        Calendar c;
        try {
            Integer[] nepdate = getNepaliDate(nepaliDate);
            c = NepaliDateConverterResource.convertToEnglish(nepdate[0], nepdate[1], nepdate[2]);

        } catch (Exception ex) {
            if (ex instanceof ClassCastException) {
                throw new ClassCastException("Invalid, date must be number.");
            } else {
                throw new Exception("Invalid date format use YYYY/MM/DD");
            }
        }
        return c.getTime();
    }

    /**
     *
     * @param nepaliDate
     * @return
     */
    public static Integer[] getNepaliDate(String nepaliDate) {
        String[] split = nepaliDate.split("/");
        if (split.length < 3 || split[0].length() < 4 || split[0].length() < 2 || split[2].length() < 2) {
            throw new IllegalArgumentException("Should be in format YYYY/MM/DD.");
        }
        Integer[] nepdate = new Integer[3];

        nepdate[0] = Integer.valueOf(split[0]);

        nepdate[1] = Integer.valueOf(split[1]);

        nepdate[2] = Integer.valueOf(split[2]);
        return nepdate;

    }

   
}
