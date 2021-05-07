package com.everis.filter;

import java.io.IOException;
import java.security.Key;
import java.security.Principal;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Provider
@Secured
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter{

	public static final Key KEY = MacProvider.generateKey();
	private String roles;
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		
		try {
			String token = authorizationHeader.substring("Bearer".length()).trim();
			Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
			roles = (String) claims.getBody().get("roles");
		}	
		catch (Exception e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}	
		
		final SecurityContext currentSecurityContext = requestContext.getSecurityContext();
		requestContext.setSecurityContext(new SecurityContext() {

	        @Override
	        public Principal getUserPrincipal() {
	            return currentSecurityContext.getUserPrincipal();
	        }

		    @Override
		    public boolean isUserInRole(String role) {
		    	if(roles.contains(role)){
		    		return true;
		    	}
		        return false;
		    }

		    @Override
		    public boolean isSecure() {
		        return currentSecurityContext.isSecure();
		    }

		    @Override
		    public String getAuthenticationScheme() {
		        return currentSecurityContext.getAuthenticationScheme();
		    }
		});
	}
	
}
