package com.hck.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.hck.app.models.entity.Users;
import com.hck.app.models.services.UServiceImpl;

@Component
public class EnhancerInfo implements TokenEnhancer {
	
	@Autowired
	private UServiceImpl userService ;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication auth) {
		// TODO Auto-generated method stub
		
		Users user = userService.findByUsername(auth.getName());
		
		
		Map<String, Object> msg = new HashMap<>(); 
		msg.put("Success Auth",  "Welcome :  " .concat(auth.getName()));
		msg.put("username ", user.getId() + " : " .concat(user.getUsername()));
		msg.put("email",  ":" .concat(user.getEmail()));
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(msg);
		
		return accessToken;
	}

}
