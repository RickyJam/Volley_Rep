package com.volley.services;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import volley.Client.InterfaceCore.CorePlayerInterface;

@Path("/servicePlayer")
public class ServicePlayers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@POST
	@Path("insertNewPlayer")
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertNewPlayer(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("insertNewPlayer");
		
		try {
			InitialContext cont = new InitialContext();

			CorePlayerInterface op = (CorePlayerInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CorePlayer!volley.Client.InterfaceCore.CorePlayerInterface");
			HashMap<String, Object> params = new HashMap<String, Object>();
			{
				
				int height = Integer.parseInt(request.getParameter("height"));
				int weight = Integer.parseInt(request.getParameter("weight"));
				String CF = request.getParameter("CF");
				String teamName = request.getParameter("teamName");
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
				params.put("height", height);
				params.put("weight", weight);
				params.put("CF", CF);
				params.put("name", name);
				params.put("teamName", teamName);
			}
			String res = op.insertNewPlayer(params);
			
			if (res.equals("Player Inserted Correctly")) {
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
