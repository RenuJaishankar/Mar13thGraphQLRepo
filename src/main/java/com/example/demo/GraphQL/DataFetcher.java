package com.example.demo.GraphQL;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcher<T> {
    //this is accepting the generic type and returning it.
T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
