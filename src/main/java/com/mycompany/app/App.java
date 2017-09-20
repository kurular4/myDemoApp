package com.mycompany.app;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));

          String input1 = "Spain";
	  int input2 = 3;
          String[] inputList = new String[8];
    
          for(String a: inputList)
		System.out.println(a);

          int result = App.moreThan(inputList,input2,input1);

         Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute", (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());


    }

    public static int moreThan(String[] array, int count, String word)
    {
	int a = 0;
	if(array.length == 0) return 2;
	for(int i = 0; i<array.length;i++)
		if(word.equals(array[i]))
			a++;
	if(count > a)
		return 1;
	else if(count == a)
		return 0;
	else
		return -1;
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}
