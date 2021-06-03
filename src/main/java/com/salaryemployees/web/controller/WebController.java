/**@Author: Karen Orozco
 * Date: 02/06/2021
 * Controlador que redirecciona la ruta para la visualización de la información en la WEB */

package com.salaryemployees.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public String homePage(){
        return "index";
    }
}
