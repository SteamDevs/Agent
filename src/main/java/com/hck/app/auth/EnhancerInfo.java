package com.hck.app.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

public class EnhancerInfo implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication auth) {
		// TODO Auto-generated method stub
		
		Map<String, Object> msg = new HashMap<>(); 
		msg.put("Success Auth",  "Welcome :  " .concat(auth.getName()));
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(msg);
		
		return accessToken;
	}

}
