package org.acme.forminterceptor;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;
import java.io.IOException;

@Provider
@ConstrainedTo(RuntimeType.SERVER)
@Priority(1)
public class FormInterceptor implements ReaderInterceptor {

    @Inject
    InterceptorDebugService interceptorDebugService;

    @Override
    public Object aroundReadFrom(final ReaderInterceptorContext context) throws IOException {
        Object entity = context.proceed();
        System.out.println("===== ReaderInterceptor entity: " + entity);
        interceptorDebugService.interceptorCalled(true);
        return entity;
    }
}
