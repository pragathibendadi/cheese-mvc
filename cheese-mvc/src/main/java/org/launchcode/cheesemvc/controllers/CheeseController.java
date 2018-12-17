package org.launchcode.cheesemvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    //static  ArrayList<String> cheeses = new ArrayList<>();
   static HashMap<String,String>cheeses =new HashMap<>();

    // Request path : /cheese
    @RequestMapping(value = "")
    public String index(Model model) {

 //         cheeses.add("cheddar");
 //         cheeses.add("parmesan");
 //         cheeses.add("munster");

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title","My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public String dispayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
         cheeses.put(cheeseName,cheeseDescription);
        //cheeses.add(cheeseName);

          return "redirect:";//redirect to /cheese
    }
    @RequestMapping(value = "remove" ,method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        model.addAttribute("cheeses",cheeses.keySet());
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }
    @RequestMapping(value = "remove" ,method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheese){
       for (String  aCheese : cheese){
           cheeses.remove(aCheese);
       }
       return "redirect:";
    }
}