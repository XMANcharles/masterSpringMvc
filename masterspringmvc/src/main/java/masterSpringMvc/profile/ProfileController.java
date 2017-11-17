/*
 * Copyright (C), 1995-2017, 没钱有限公司
 * FileName: ProfileController
 * Author:   Neo Geng
 * Date:     2017/10/26 18:59
 * Description: 表单控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterSpringMvc.profile;

import masterSpringMvc.date.LocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

/**
 * 〈表单控制器〉
 *
 * @author Neo Geng
 *         Date 2017/10/26
 * @since 1.0.0
 */
@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String displayProfile(ProfileForm profileForm){//此处切记不要忘记这个参数，否则thymeleaf,${profileForm}无法绑定对象
        return "profile/profilePage";
    }

    @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/profile/profilePage";
        }
        System.out.println("save ok"+profileForm);
        return "redirect:/profile";
    }

    @ModelAttribute("dataFormat")
    public String LocaleFormat(Locale locale){
        return LocalDateFormatter.getPattern(locale);
    }

}
