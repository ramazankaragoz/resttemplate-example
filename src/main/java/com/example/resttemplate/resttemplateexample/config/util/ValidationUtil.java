package com.example.resttemplate.resttemplateexample.config.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ramazan Karagöz
 * @date 9/6/2019
 */

public class ValidationUtil {

    private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_IP_ADDRESS_REGEX = Pattern.compile("^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$");
    private static final Pattern VALID_PHONE_NUMBER_REGEX = Pattern.compile("(([\\+]90?)|([0]?))([ ]?)((\\([0-9]{3}\\))|([0-9]{3}))([ ]?)([0-9]{3})(\\s*[\\-]?)([0-9]{2})(\\s*[\\-]?)([0-9]{2})");

    public static Boolean ipAddressValidation(String ipAddress) {

        if (ipAddress!=null) {
            Matcher matcher = VALID_IP_ADDRESS_REGEX.matcher(ipAddress);

            if (!matcher.matches()) {
                return false;
            } else {
                for (int i = 1; i <= 4; i++) {
                    int octet = Integer.valueOf(matcher.group(i));
                    if (octet > 255) {
                        return false;
                    }
                }
                return true;
            }
        }

        return false;

    }

    public static Boolean tcNoValidation(Long tcNo) {


        if (tcNo != null) {
            String temp = tcNo.toString();
            if (temp.length() == 11) {

                //1, 3, 5, 7, ve 9. basamaktaki sayıların toplamı
                //2, 4, 6 ve 8. basamaktaki sayıların toplamın
                int totalOdd = 0, totalEven = 0, val, i = 0, total, lastDigit, check;

                while (i < 9) {
                    val = Integer.valueOf(temp.substring(i, i + 1));
                    if (i % 2 == 0) {
                        totalOdd += val;
                    } else {
                        totalEven += val;
                    }
                    i++;
                }

                //1, 2, 3, 4, 5, 6, 7, 8, 9 ve 10. basamaktaki rakamların toplamından elde edilen sonuç 10’a
                // bölündüğünde elde ettiğimiz kalan, 11. basamaktaki rakama eşit olmalıdır.
                total = totalOdd + totalEven + Integer.valueOf(temp.substring(9, 10));
                lastDigit = total % 10;

                if (temp.substring(10).equals(String.valueOf(lastDigit))) {
                    check = (totalOdd * 7 - totalEven) % 10;
                    if (temp.substring(9, 10).equals(String.valueOf(check))) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    public static Boolean emailAddressValidation(String emailAddress) {

        if (emailAddress != null) {
            Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailAddress);
            if (matcher.matches()) {
                return true;
            }
        } else if (emailAddress == null) {
            return true;
        }

        return false;
    }

    /**
     * 0(216) 472 15 30
     * +90(216) 4721530
     * 03124751530
     * 0312 482 15 30
     * 0312 482-15-30
     * 0312 482 1530
     * @param phoneNumber
     * @return
     */
    public static Boolean phoneNumberValidation(String phoneNumber){

        if (phoneNumber!=null){
            Matcher matcher=VALID_PHONE_NUMBER_REGEX.matcher(phoneNumber);

            if (matcher.matches()){
                return true;
            }
        }

        return false;

    }
}
