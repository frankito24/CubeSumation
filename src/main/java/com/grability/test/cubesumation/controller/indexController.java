/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.controller;

import org.apache.log4j.Logger;
import com.grability.test.cubesumation.bf.CubeBf;
import com.grability.test.cubesumation.modelForm.indexForm;
import com.grability.test.cubesumation.to.CubeTo;
import com.grability.test.cubesumation.to.RequestCube;
import com.grability.test.cubesumation.to.ResponseCube;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Frank
 */
@Controller
@RequestMapping("/index")
public class indexController {

    private static final Logger logger = Logger.getLogger(indexController.class);

    @RequestMapping(method = RequestMethod.GET)
    protected String viewIndexGet(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute viewIndexGet");
        }
        model.addAttribute("indexForm", new indexForm());
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String viewIndexPost(Model model,
                                   @ModelAttribute("indexForm") indexForm form) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute viewIndexPost");
        }
        RequestCube rqc = new RequestCube();
        ResponseCube rsc = new ResponseCube();
        StringBuilder sb = new StringBuilder();
        CubeBf cubeBf = new CubeBf();
        rsc.setCube(new CubeTo());
        String lines[] = form.getRequest().split("\\r?\\n");
        for (String next : lines) {
            String[] split = next.split("\\s+");
            rqc.setOperation(split);
            rqc.setCube(rsc.getCube());
            rsc = cubeBf.action(rqc);
            sb.append("\n").append(rsc.getResponse());
        }
        form.setResponse(sb.toString());
        model.addAttribute("indexForm", form);
        return "/index";
    }
}
