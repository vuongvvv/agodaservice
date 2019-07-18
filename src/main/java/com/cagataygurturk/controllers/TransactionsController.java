package com.cagataygurturk.controllers;

import com.cagataygurturk.controllers.requestmodels.TransactionRequest;
import com.cagataygurturk.services.transaction.TransactionNotFoundException;
import com.cagataygurturk.services.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("/agodaservice")
public class TransactionsController {

    @Autowired
    protected TransactionService transactionService;

    @Context
    UriInfo uri;
    
    @PUT
    @Path("changepassword")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changePassword(TransactionRequest transactionRequest) {

        Boolean changePasswordResult;
        
        try {
        	changePasswordResult = transactionService.changePassword(transactionRequest.oldPassword, transactionRequest.newPassword);
        } catch (TransactionNotFoundException e) {
            /**
             * It means parent transaction could not be found
             * We should throw a NotAcceptableException
             */
            throw new NotAcceptableException(e.getMessage());
        }


        return Response.status(200).entity(changePasswordResult).build();
    }

}
