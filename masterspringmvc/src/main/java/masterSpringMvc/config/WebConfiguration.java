/*
 * Copyright (C), 1995-2017, 没钱有限公司
 * FileName: WebConfiguration
 * Author:   Neo Geng
 * Date:     2017/11/7 20:39
 * Description: Web注解配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterSpringMvc.config;


import masterSpringMvc.date.LocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

/**
 * 〈Web注解配置类〉
 *
 * @author Neo Geng
 *         Date 2017/11/7
 * @since 1.0.0
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //注册US时区转换类
        registry.addFormatterForFieldType(LocalDate.class,new LocalDateFormatter());
    }

}
