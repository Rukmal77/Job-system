/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.rest.service.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import db.Login;
import db.LoginUtils;
import db.TokenUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



@Path("login")
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginUser(String json, @Context HttpServletRequest request) { 

        Gson gson = new GsonBuilder().create();
        Login user = gson.fromJson(json, Login.class);

        LoginUtils utils = new LoginUtils();
        Login loggedInUser = utils.loginUser(user.getEmail(), user.getPassword());

        if (loggedInUser != null) {
            TokenUtils tokenUtils = new TokenUtils();
            Token token = tokenUtils.generateToken(loggedInUser);
            token.setUser(loggedInUser.getUser());

            // Create a session
            HttpSession session = request.getSession(true);
            session.setAttribute("token", token.getToken());
             session.setAttribute("user", loggedInUser.getUser());

           return Response.status(200)
    .entity(token.getToken() + "|" + loggedInUser.getUser())
    .build(); // Successful login
        } else {
            return Response.status(401).build(); // Unauthorized or login failed
        }
    }
}

