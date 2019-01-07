package com.volley.services;

import java.io.Serializable;
import java.util.HashMap;

import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.volley.utility.JsonResult;
import com.volley.utility.UtilsWeb;

import volley.Client.InterfaceCore.CoreTeamInterface;

@Path("/serviceTeam")
public class ServiceTeam  implements Serializable {
	private static final long serialVersionUID = 1L;


	@POST
	@Path("insertNewTeam")
	@Produces(MediaType.APPLICATION_JSON)
	public Object insertNewTeam(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("insertNewTeam");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreTeamInterface op = (CoreTeamInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreTeam!volley.Client.InterfaceCore.CoreTeamInterface");//in genere chiamato come "service"
			HashMap<String, Object> params = new HashMap<String, Object>();
			{
				String category = request.getParameter("category").toUpperCase();
				String committee = request.getParameter("committee").toUpperCase();
				String round = request.getParameter("round").toUpperCase();
				String societyName = request.getParameter("societyName");
				String teamName = request.getParameter("teamName");
				String genderLeague = request.getParameter("genderLeague");
				
				params.put("category", category);
				params.put("committee", committee);
				params.put("round", round);
				params.put("societyName", societyName);
				params.put("teamName", teamName);
				params.put("genderLeague", genderLeague);
			}
			String res = op.insertNewTeam(params);
			
			if (res.equals("Team Inserted correctly")) {
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
