package com.volley.services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.volley.utility.JsonResult;
import com.volley.utility.UtilsWeb;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import volley.Client.InterfaceCore.CoreArbiterInterface;
import volley.Client.Object.Object_Arbitri;

@Path("/serviceArbiters")
public class ServiceArbiters implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@GET
	@Path("readArbiters")
	@Produces(MediaType.APPLICATION_JSON)
	public Object readAllArbiters(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("readAllArbiters");
		
		try {
			InitialContext cont = new InitialContext();
			
			List<Object_Arbitri> Arbitri = null;
													
			CoreArbiterInterface op = (CoreArbiterInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreArbiter!volley.Client.InterfaceCore.CoreArbiterInterface");//in genere chiamato come "service"
			HashMap<String, Object> params = new HashMap<String, Object>();
			String category = request.getParameter("category");// if present pass the category(arbiters of a specific category), else pass null(all arbiters)
			params.put("category", category);
			Arbitri = op.ArbitersList(params);
			
			result.setRc(0);
			result.setData(Arbitri);
		} catch (Exception e) {
			result.setRc(1);
			result.setData("Error While processing Service");
		}
		response = UtilsWeb.setCORS(response);
		return result;
	}

	
	@POST
	@Path("insertNewArbiter")
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertNewArbiter(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("insertNewArbiter");
		
		try {
			InitialContext cont = new InitialContext();

			CoreArbiterInterface op = (CoreArbiterInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreArbiter!volley.Client.InterfaceCore.CoreArbiterInterface");
			HashMap<String, Object> params = new HashMap<String, Object>();
			{
				
				char category = request.getParameter("category").toString().charAt(0);
				String CF = request.getParameter("CF");
				String name = request.getParameter("name");
				String surname = request.getParameter("surname");
				String birthdayS = request.getParameter("birthday"); //aaaa-mm-dd
				char gender = request.getParameter("gender").toString().charAt(0);
				String nationality =  request.getParameter("nationality");
				
				Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayS);
				
				params.put("surname", surname);
				params.put("birthday", birthday);
				params.put("gender", gender);
				params.put("nationality", nationality);
				params.put("category", category);
				params.put("CF", CF);
				params.put("name", name);

			}
			String res = op.insertNewArbiter(params);
			
			if (res.equals("Arbiter Inserted Correctly")) {
				result.setRc(0);
				result.setData(res);
			}
			else {
				result.setRc(1);
				result.setData("Error While processing Query");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setRc(1);
			result.setData("Error While processing Service");
		}
		response = UtilsWeb.setCORS(response);
		return result;
	}
	
	
}
