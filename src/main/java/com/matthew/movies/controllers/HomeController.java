package com.matthew.movies.controllers;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@Controller
public class HomeController {
	String URL = "http://www.omdbapi.com/?apikey=6b2dc8b2&";
	
	@GetMapping("/")
	public String index() {

		
		
		return "index.jsp";
	}
	

	@GetMapping("/search")
	public String results(Model viewModel, @RequestParam("name") String name) {
		try {
			HttpResponse<JsonNode> request = Unirest.get(URL + "s={name}")
					.routeParam("name", name)
					.asJson();
			
			String body = Unirest.get(URL + "s={name}")
					.routeParam("name", name)
					 .asString()
					 .getBody();
			
			System.out.println("string: " + body);
			JSONObject myObj = request.getBody().getObject();
			JSONArray search = myObj.getJSONArray("Search");
			ArrayList<JSONObject> results = new ArrayList<JSONObject>();
			for(int i = 0; i < search.length(); i++) {
				results.add(search.getJSONObject(i));
			}
			System.out.println(results);
			viewModel.addAttribute("results", results);

		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result.jsp";
	}
}
