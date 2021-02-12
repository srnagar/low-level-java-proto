// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.util.RequestSpec;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.serializer.SerializerAdapter;

/** Initializes a new instance of the asynchronous TextAnalyticsClient type. */
@ServiceClient(builder = TextAnalyticsClientBuilder.class, isAsync = true)
public class TextAnalyticsClient {
    private final SerializerAdapter serializerAdapter;
    private final HttpPipeline httpPipeline;
    private final String endpoint;

    protected SerializerAdapter getSerializerAdapter() {
        return serializerAdapter;
    }

    protected HttpPipeline getHttpPipeline() {
        return httpPipeline;
    }

    protected String getEndpoint() {
        return endpoint;
    }

    /**
     * Initializes an instance of TextAnalyticsClient client.
     *
     */
    TextAnalyticsClient(SerializerAdapter serializerAdapter, HttpPipeline httpPipeline, String endpoint) {
        this.serializerAdapter = serializerAdapter;
        this.httpPipeline = httpPipeline;
        this.endpoint = endpoint;
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public RequestSpec entitiesLinking() {
        return new RequestSpec(serializerAdapter, httpPipeline)
                .url("{Endpoint}/text/analytics/v3.1-preview.3/entities/linking")
                .param("Endpoint", endpoint)
                .httpMethod(HttpMethod.POST)
                .header("Accept", "application/json, text/json");
    }
}
