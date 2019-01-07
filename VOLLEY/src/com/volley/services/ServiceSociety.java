package com.volley.services;

import java.io.Serializable;
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

import volley.Client.InterfaceCore.CoreSocietyInterface;


@Path("/serviceSociety")
public class ServiceSociety  implements Serializable {
	private static final long serialVersionUID = 1L;


	@GET
	@Path("getAllSocietyName")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getAllSocietyName(@Context HttpServletRequest request, @Context HttpServletResponse response) {
		JsonResult result = new JsonResult();

		result.setServiceName("getAllSocietyName");
		
		try {
			InitialContext cont = new InitialContext();
			
			CoreSocietyInterface op = (CoreSocietyInterface)cont.lookup("java:global/Volley_EJB_EAR/volley_Ejb/CoreSociety!volley.Client.InterfaceCore.CoreSocietyInterface");
			
			List<String> res = op.getAllSocietyName();
			
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
