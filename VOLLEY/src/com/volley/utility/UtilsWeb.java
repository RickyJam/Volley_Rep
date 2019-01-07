package com.volley.utility;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

public class UtilsWeb {
	
	/*
	 *java:global/Volley_EJB_EAR/volley_Ejb/Core!volley.Client.InterfaceCore.coreInterface   NO
	 *java:app/volley_Ejb/Core!volley.Client.InterfaceCore.coreInterface   NO
	 *java:module/Core!volley.Client.InterfaceCore.coreInterface   NO
	 *java:jboss/exported/Volley_EJB_EAR/volley_Ejb/Core!volley.Client.InterfaceCore.coreInterface   NO
	 *java:global/Volley_EJB_EAR/volley_Ejb/Core   NO
	 *ejb:Volley_EJB_EAR/volley_Ejb//Core!volley.Client.InterfaceCore.coreInterface NO
	*/
	public boolean checkFieldNotNull(HashMap<String, Object> params){
		Iterator it = params.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry thisIT = (Map.Entry)it.next();
			if(thisIT.getValue() == null)
				return false;
		}
		return true;
	}

	public static String categoryCommitteeMatch(String category, String committee) {
		switch(category)
		{
			case "A":
				if(committee.contains("C.T."))
					return "";
				break;
			case "B":
				if(committee.contains("C.T."))
					return "";
				break;
			case "C":
				if(committee.contains("C.R."))
					return "";
				break;
			case "D":
				if(committee.contains("C.R."))
					return "";
				break;
			default:
				if(committee.contains("C.P."))
					return "";
				break;
		}
		return "Attention, this League can't Exist";
	}
	
	public static HttpServletResponse setCORS(@Context HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
		return response;
	}
	
	
	
}
