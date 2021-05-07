package com.everis.filter;

import java.util.Date;
import java.util.Calendar;

import javax.naming.AuthenticationException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;



@Path("/login")
public class AuthenticationEndpoint {
	
	@POST
	public Response authenticateUser(@QueryParam("user") String user, @QueryParam("pass") String pass) {
		try {
			String rol = authenticate(user, pass);
			String token = generateToken(user, rol);
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();
		}
		catch(Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}
	
	private String generateToken(String user, String rol) {
		Date issueDate = new Date();
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(issueDate);
    	calendar.add(Calendar.MINUTE, 60);
        Date expireDate = calendar.getTime();
        
        String jwtToken = Jwts.builder()
        		.claim("roles", rol)
                .setSubject(user)
                .setIssuer("Jota")
                .setIssuedAt(issueDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, JWTFilter.KEY)
                .compact();
        return jwtToken;	
	}
	
	private String authenticate(String user, String pass) throws AuthenticationException{
		if ("user".equals(user) && "user".equals(pass)) {
            return "USER";
        } else if ("admin".equals(user) && "admin".equals(pass)) {
            return "ADMIN";
        } else {
            throw new AuthenticationException();
        }
	}
}
