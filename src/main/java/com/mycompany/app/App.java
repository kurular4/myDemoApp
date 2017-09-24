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
    public static void main(String[] args){
        port(getHerokuAssignedPort());
        get("/", (req, res) -> "Hello, World");
        post("/compute", (req, res) -> {
          //System.out.println(req.queryParams("input1"));
          //System.out.println(req.queryParams("input2"));
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            String value = sc1.next().replaceAll("\\s","");
            inputList.add(value);
          }
          System.out.println(inputList);
          String input2 = req.queryParams("input2").replaceAll("\\s","");
	  String input3 = req.queryParams("input3").replaceAll("\\s","");
	  int input3Int = Integer.parseInt(input3);
          int result = App.moreThan(inputList,input3Int,input2);
          Map map = new HashMap();
          map.put("result", result);
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
}

    public static int moreThan(ArrayList<String> array, int count, String word)
    {
	int a = 0;
	if(array.size() == 0) return 2;
	for(int i = 0; i<array.size();i++)
		if(word.equals(array.get(i)))
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
