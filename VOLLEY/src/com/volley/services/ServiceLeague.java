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
import volley.Client.Object.Object_League;
import volley.Client.Object.Object_Ranking;

@Path("/serviceLeague")
public class ServiceLeague implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GET
	@Path("getProvincialCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getProvincialCategory(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();
		
		result.setServiceName("getProvincialCategory");
		
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
	@Path("getProvincialCommittee")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getProvincialCommittee(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();
		
		result.setServiceName("getProvincialCommittee");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");
				
			List<String> res = op.getProvincialCommittee();
				
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
	
	@GET
	@Path("getDistinctCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getDistinctCategory(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getDistinctCategory");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");//in genere chiamato come "service"
			List<String> res = op.getDistinctCategory();
			
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
	
	@GET
	@Path("getLeagueForThisCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getLeagueForThisCategory(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getLeagueForThisCategory");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");//in genere chiamato come "service"
			String category = request.getParameter("category");
			String committee = request.getParameter("committee");
			
			
			//first check
			String validity = UtilsWeb.categoryCommitteeMatch(category,committee);
			
			
			
			if(validity.equals("")) {
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("committee", committee);
			params.put("category", category);
			
			List<Object_League> res = op.getLeagueForThisCategory(params);
			
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
	@Path("getAllCommittee")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAllCommittee(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getAllCommittee");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");
			
			List<String> res = op.getAllCommittee();
			
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
	
	@GET
	@Path("getCategoryLeague")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getCategoryLeague(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getCategoryLeague");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");//in genere chiamato come "service"
			String committee = request.getParameter("committee");
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("committee", committee);
			
			List<String> res = op.getCategoryLeague(params);
			
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

	@GET
	@Path("getRoundCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getRoundCategory(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getRoundCategory");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreLeagueInterface op = (CoreLeagueInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreLeague!volley.Client.InterfaceCore.CoreLeagueInterface");//in genere chiamato come "service"
			String committee = request.getParameter("committee");
			String category = request.getParameter("category");
			String gender = request.getParameter("gender");
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("committee", committee);
			params.put("category", category);
			params.put("gender", gender);
			
			List<String> res = op.getRoundCategory(params);
			
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
