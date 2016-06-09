/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grability.test.cubesumation.controller;

import org.apache.log4j.Logger;
import com.grability.test.cubesumation.bf.CubeBf;
import com.grability.test.cubesumation.to.CubeFormTo;
import com.grability.test.cubesumation.to.CubeTo;
import com.grability.test.cubesumation.to.RequestCubeTo;
import com.grability.test.cubesumation.to.ResponseCubeTo;
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
@RequestMapping("/cube")
public class CubeController {

    private static final Logger logger = Logger.getLogger(CubeController.class);

    @RequestMapping(method = RequestMethod.GET)
    protected String viewCubeGet(Model model) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute viewCubeGet");
        }
        model.addAttribute("CubeForm", new CubeFormTo());
        return "/cube";
    }

    @RequestMapping(method = RequestMethod.POST)
    protected String viewCubePost(Model model, @ModelAttribute("CubeForm") CubeFormTo form) {
        if (logger.isDebugEnabled()) {
            logger.debug("Execute viewCubePost");
        }
        RequestCubeTo rqc = new RequestCubeTo();
        ResponseCubeTo rsc = new ResponseCubeTo();
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
        model.addAttribute("CubeForm", form);
        return "/cube";
    }
}
