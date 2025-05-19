# quarkus-form-interceptor

Project to reproduce a weird behavior with form data and ReaderInterceptor.

See https://github.com/quarkusio/quarkus/issues/47939

## How to run

```sh
./mvnw test
```

Tests `testLoginUsingBeanParam` and `testLoginUsingFormParam` fail, test `testLoginUsingMultivaluedMap` succeeds.
