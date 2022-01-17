package com.chatapplication.services;

import com.chatapplication.constants.SecurityConstants;
import com.chatapplication.models.User;
import com.chatapplication.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class JwtService {

    @Autowired
    UserRepository userRepository;

    public User parseToken(HttpServletRequest request) {
        String token=request.getHeader(SecurityConstants.HEADER_STRING).replace(SecurityConstants.TOKEN_PREFIX, "");
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(SecurityConstants.SECRET)
                    .parseClaimsJws(token)
                    .getBody();

            return userRepository.findUserByUsername(body.getSubject()).orElse(null);

        } catch (JwtException | ClassCastException e) {
            return null;
        }
    }
}
