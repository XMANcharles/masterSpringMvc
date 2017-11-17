/*
 * Copyright (C), 1995-2017, 没钱有限公司
 * FileName: USLocalDateFormatter
 * Author:   Neo Geng
 * Date:     2017/11/7 20:27
 * Description: 美国本地时间
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterSpringMvc.date;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 〈本地时间转换类〉
 *
 * @author Neo Geng
 *         Date 2017/11/7
 * @since 1.0.0
 */
public class LocalDateFormatter implements Formatter<LocalDate> {

    public static final String US_PATTERN = "MM/dd/yyyy";
    public static final String NORMAL_PATTERN = "dd/MM/yyyy";
    public static final String ZH_PATTERN = "yyyy/MM/dd";

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return LocalDate.parse(text, DateTimeFormatter.ofPattern(getPattern(locale)));
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return DateTimeFormatter.ofPattern(getPattern(locale)).format(object);
    }

    /**
     * 获取本地Date-Pattern
     * @param locale
     * @return
     */
    public static String getPattern(Locale locale){
        if(Locale.CHINA.equals(locale)){
            return ZH_PATTERN;
        }else if(Locale.US.equals(locale)){
            return US_PATTERN;
        }else{
            return NORMAL_PATTERN;
        }
    }

    /**
     * 本地区是否为US
     * @param locale
     * @return
     */
    public static boolean isUnitedStates(Locale locale){
        return Locale.US.getCountry().equals(locale.getCountry());
    }

}
