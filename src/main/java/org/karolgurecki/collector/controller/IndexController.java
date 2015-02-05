package org.karolgurecki.collector.controller;

import org.karolgurecki.collector.Buu;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by goreckik on 2015-02-03.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showIndex() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "k", method = RequestMethod.GET)
    public Buu test() {
        return new Buu("hh");

    }
}
