package com.volley.services;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.volley.utility.JsonResult;
import com.volley.utility.UtilsWeb;

import volley.Client.InterfaceCore.CoreLeagueInterface;
import volley.Client.InterfaceCore.CoreMatchesInterface;
import volley.Client.Object.Object_Matches;
import volley.Client.Object.Object_Ranking;

@Path("/serviceMatches")
public class serviceMatches implements Serializable {
	private static final long serialVersionUID = 1L;

	@GET
	@Path("getRanking")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getRanking(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();
		
		result.setServiceName("getRanking");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");//in genere chiamato come "service"
			String category = request.getParameter("category");
			String committee = request.getParameter("committee");
			char round = request.getParameter("round").toString().charAt(0);
			char gender = request.getParameter("gender").toString().charAt(0);
			
			//first check about validity
			String validity = UtilsWeb.categoryCommitteeMatch(category,committee);
			
			if(validity.equals("")) {
			
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("committee", committee);
				params.put("category", category);
				params.put("round", round);
				params.put("gender", gender);
				
				List<Object_Ranking> res = op.getRanking(params);
				
				result.setRc(0);
				result.setData(res);
			}
			else {
				result.setRc(1);
				result.setData(validity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setRc(1);
			result.setData("Error While processing Service");
		}
		response = UtilsWeb.setCORS(response);
		return result;
	}

	@GET
	@Path("getAllMatches")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAllMatches(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();
		
		result.setServiceName("getAllMatches");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreMatchesInterface op = (CoreMatchesInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreMatches!volley.Client.InterfaceCore.CoreMatchesInterface");//in genere chiamato come "service"
			String category = request.getParameter("category");
			String committee = request.getParameter("committee");
			char round = request.getParameter("round").toString().charAt(0);
			char gender = request.getParameter("gender").toString().charAt(0);
			
			//first check about validity
			String validity = UtilsWeb.categoryCommitteeMatch(category,committee);
			
			if(validity.equals("")) {
			
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("committee", committee);
				params.put("category", category);
				params.put("round", round);
				params.put("gender", gender);
				
				List<Object_Matches> res = op.getAllMatches(params);
				
				result.setRc(0);
				result.setData(res);
			}
			else {
				result.setRc(1);
				result.setData(validity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setRc(1);
			result.setData("Error While processing Service");
		}
		return result;
	}
	
	@GET
	@Path("thisWeekMatch")
	@Produces(MediaType.APPLICATION_JSON)
	public Object thisWeekMatch(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();
		
		result.setServiceName("thisWeekMatch");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreMatchesInterface op = (CoreMatchesInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreMatches!volley.Client.InterfaceCore.CoreMatchesInterface");//in genere chiamato come "service"
			
			//first check about validity
			
			List<Object_Matches> res = op.getWeekMatch();
				
			result.setRc(0);
			result.setData(res);
		
		} catch (Exception e) {
			e.printStackTrace();
			result.setRc(1);
			result.setData("Error While processing Service");
		}
		response = UtilsWeb.setCORS(response);
		return result;
	}
	

}
