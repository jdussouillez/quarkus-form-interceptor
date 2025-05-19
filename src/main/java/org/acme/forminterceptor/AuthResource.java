package org.acme.forminterceptor;

import jakarta.inject.Inject;
import jakarta.ws.rs.BeanParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;

@Path("/auth")
public class AuthResource {

    @Inject
    InterceptorDebugService interceptorDebugService;

    @POST
    @Path("/beanparam")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@BeanParam final LoginForm form) {
        System.out.println("=== @BeanParam: " + form);
        return Response.ok(interceptorDebugService.interceptorCalled()).build();
    }

    @POST
    @Path("/formparam")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(@FormParam("username") final String username, @FormParam("password") final String password) {
        System.out.println("=== @FormParam: " + username + " / " + password);
        return Response.ok(interceptorDebugService.interceptorCalled()).build();
    }

    @POST
    @Path("/multivaluedmap")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response login(final MultivaluedMap<String, Object> form) {
        System.out.println("=== MultivaluedMap: " + form.getFirst("username") + " / " + form.getFirst("password"));
        return Response.ok(interceptorDebugService.interceptorCalled()).build();
    }
}
