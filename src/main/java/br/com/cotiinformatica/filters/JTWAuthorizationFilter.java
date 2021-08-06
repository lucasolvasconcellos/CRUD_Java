package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collector;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JTWAuthorizationFilter extends OncePerRequestFilter{
	
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer";
	private final String SECRET = "5eebb082-4046-4d7f-a638-3c16d9dec4";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
	        throws ServletException, IOException {
		try {
			if (checJWTToken(request, response)) {
				Claims claims = validateToken(request);
				
				if(claims.get("authorities") != null) {
					setUpStringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			}else {
				SecurityContextHolder.clearContext();
			}
			
			chain.doFilter(request, response);
		} catch (Exception e) {
			response.setStatus
			(HttpServletResponse.SC_UNAUTHORIZED);
			((HttpServletResponse) response)
			.sendError(HttpServletResponse.SC_UNAUTHORIZED,
					e.getMessage());
			return;
			// TODO: handle exception
		}
	}
	
	private Claims validateToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX,"");
		return Jwts.parser().setSigningKey
				(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}
	
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings({"unchecked", "rawrypes"})
		List<String> authorities = (List)
		claims.get("authorities");
		
		UsernamePasswordAuthenticationToken auth
		= new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream()
				.map(SimpleGrantedAuthority:: new)
				.collect(Collector.toList()));
		SrcurityContextHolder.getContext()
		   .setAuthentication(auth);
		}
	
	private boolean checkJWTToken(HttpServletRequest resquest,
			HttpServletResponse res) {
		String authenticationHeader = Request.getHeader(HEADER);
				if (authenticationHeader == null || 
				!authenticationHeader.startsWith(PREFIX))
        
        return false;
        
        return true;
	}

}
