package com.ugurdonmez.email.restapi;

/**
 *
 * @author ugurdonmez
 */
import com.google.gson.Gson;
import com.ugurdonmez.email.validation_suggestion.EmailValidationAndSuggestionResult;
import com.ugurdonmez.email.validation_suggestion.EmailValidationAndSuggestionService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/validate")
public class EmailRestApi {

    @GET
    @Path("/{email}")
    public Response getMsg(@PathParam("email") String email) {
        
        EmailValidationAndSuggestionService service = new EmailValidationAndSuggestionService();
        EmailValidationAndSuggestionResult result = service.validateSuggest(email);
        
        Gson gson = new Gson();
        
        String json = gson.toJson(result);

        return Response.ok(json, MediaType.APPLICATION_JSON).header("Access-Control-Allow-Origin", "*").build();
    }

}
