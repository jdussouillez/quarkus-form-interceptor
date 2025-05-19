package org.acme.forminterceptor;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class InterceptorDebugService {

    private boolean interceptorCalled;

    public boolean interceptorCalled() {
        return interceptorCalled;
    }

    public void interceptorCalled(boolean interceptorCalled) {
        this.interceptorCalled = interceptorCalled;
    }
}
