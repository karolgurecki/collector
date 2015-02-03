package org.karolgureecki.collector.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by goreckik on 2015-02-03.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "k", method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return "hh";
    }
}
