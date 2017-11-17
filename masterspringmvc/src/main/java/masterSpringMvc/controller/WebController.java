/*
 * Copyright (C), 1995-2017, 没钱有限公司
 * FileName: WebController
 * Author:   Neo Geng
 * Date:     2017/10/25 12:42
 * Description: 社交网络
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package masterSpringMvc.controller;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 〈社交网络〉
 *
 * @author Neo Geng
 *         Date 2017/10/25
 * @since 1.0.0
 */
@Controller
public class WebController {

    @RequestMapping("/")
    public String home() {
        return "searchPage";
    }

    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(String search, RedirectAttributes redirectAttributes) {
        if (search.toLowerCase().contains("spring")) {
            redirectAttributes.addFlashAttribute("error", "spring is good !");
            return "redirect:/";
        }
        redirectAttributes.addAttribute("search", search);
        return "redirect:/result";
    }

    @SuppressWarnings("deprecation")
    @RequestMapping("/result")
    public String hello(@RequestParam(defaultValue = "masterSpringMVC4") String search, Model model) {
        List<Tweet> twitters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tweet tweet = new Tweet(1L, "1", "Tweeter被墙了，对象是我自己new的", new Date(), "from user", "profileImageUrl", 1L, 1L, "English", "source");
            TwitterProfile user = new TwitterProfile(1L, "screenName", "刘醒", "url", "http://img3.imgtn.bdimg.com/it/u=4200473304,4037194261&fm=214&gp=0.jpg", "description", "location", new Date());
            tweet.setUser(user);
            twitters.add(tweet);
        }
        model.addAttribute("search", search);
        model.addAttribute("tweets", twitters);
        return "resultPage";
    }

}
