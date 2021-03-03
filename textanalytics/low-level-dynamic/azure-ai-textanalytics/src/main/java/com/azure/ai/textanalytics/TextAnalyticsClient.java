// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics;

import com.azure.ai.textanalytics.http.DynamicRequest;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.util.serializer.ObjectSerializer;

/** Initializes a new instance of the asynchronous TextAnalyticsClient type. */
@ServiceClient(builder = TextAnalyticsClientBuilder.class, isAsync = true)
public class TextAnalyticsClient {
    private final ObjectSerializer objectSerializer;
    private final HttpPipeline httpPipeline;
    private final String endpoint;

    protected ObjectSerializer getObjectSerializer() {
        return objectSerializer;
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
    TextAnalyticsClient(ObjectSerializer objectSerializer, HttpPipeline httpPipeline, String endpoint) {
        this.objectSerializer = objectSerializer;
        this.httpPipeline = httpPipeline;
        this.endpoint = endpoint;
    }

    /**
     * The API returns a list of recognized entities with links to a well-known knowledge base. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     *     <tr><td>stringIndexType</td><td>String</td><td>Specifies the method used to interpret string offsets.
     *          Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *          https://aka.ms/text-analytics-offsets.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             language: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [
     *         id: String,
     *         entities: [
     *             name: String,
     *             matches [
     *                 text: String,
     *                 confidenceScore: double,
     *                 offset: int,
     *                 length: int
     *             ],
     *             language: String,
     *             id: String,
     *             url: String,
     *             dataSource: String,
     *             bingId: String
     *         ],
     *         warnings: [
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         ],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     ],
     *     errors: [
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     ],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getLinkedEntities() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/entities/linking")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats", "stringIndexType");
    }

    /**
     * The API returns a list of general named entities in a given document. For the list of supported entity types,
     * check &lt;a href="https://aka.ms/taner"&gt;Supported Entity Types in Text Analytics API&lt;/a&gt;. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     *     <tr><td>stringIndexType</td><td>String</td><td>Specifies the method used to interpret string offsets.
     *          Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *          https://aka.ms/text-analytics-offsets.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             language: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [{
     *         id: String,
     *         entities: [{
     *             text: String,
     *             category: String,
     *             subcategory: String,
     *             offset: int,
     *             length: int,
     *             confidenceScore: double
     *         }],
     *         warnings: [{
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         }],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     }],
     *     errors: [{
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     }],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getEntities() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/entities/recognition/general")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats", "stringIndexType");
    }

    /**
     * The API returns a list of entities with personal information (\"SSN\", \"Bank Account\" etc) in the document. For
     * the list of supported entity types, check &lt;a href="https://aka.ms/tanerpii"&gt;Supported Entity Types in Text
     * Analytics API&lt;/a&gt;. See the &lt;a href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics
     * API&lt;/a&gt; for the list of enabled languages.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     *     <tr><td>domain</td><td>String</td><td>if specified, will set the PII domain to include only a subset of the
     *          entity categories. Possible values include: 'PHI', 'none'.</td></tr>
     *     <tr><td>stringIndexType</td><td>String</td><td>Specifies the method used to interpret string offsets.
     *          Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *          https://aka.ms/text-analytics-offsets.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             language: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [{
     *         id: String,
     *         redactedText: String,
     *         entities: [{
     *             text: String,
     *             category: String,
     *             subcategory: String,
     *             offset: int,
     *             length: int,
     *             confidenceScore: double
     *         }],
     *         warnings: [{
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         }],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     }],
     *     errors: [{
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     }],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getEntitiesPii() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/entities/recognition/pii")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats", "domain", "stringIndexType");
    }

    /**
     * The API returns a detailed sentiment analysis for the input text. The analysis is done in multiple levels of
     * granularity, start from the a document level, down to sentence and key terms (aspects) and opinions.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     *     <tr><td>opinionMining</td><td>boolean</td><td>if set to true, response will contain input and document level
     *          statistics including aspect-based sentiment analysis results.</td></tr>
     *     <tr><td>stringIndexType</td><td>String</td><td>Specifies the method used to interpret string offsets.
     *          Defaults to Text Elements (Graphemes) according to Unicode v8.0.0. For additional information see
     *          https://aka.ms/text-analytics-offsets.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             language: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [{
     *         id: String,
     *         sentiment: String,
     *         confidenceScores: {
     *             positive: double,
     *             neutral: double,
     *             negative: double
     *         },
     *         sentences: [{
     *             text: String,
     *             sentiment: String,
     *             confidenceScores: {
     *                 positive: double,
     *                 neutral: double,
     *                 negative: double
     *             }
     *         }],
     *         warnings: [{
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         }],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     }],
     *     errors: [{
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     }],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getSentiment() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/sentiment")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats", "opinionMining", "stringIndexType");
    }

    /**
     * The API returns the detected language and a numeric score between 0 and 1. Scores close to 1 indicate 100%
     * certainty that the identified language is true. See the &lt;a href="https://aka.ms/talangs"&gt;Supported
     * languages in Text Analytics API&lt;/a&gt; for the list of enabled languages.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             countryHint: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [{
     *         id: String,
     *         detectedLanguage: {
     *             name: String,
     *             iso6391Name: String,
     *             confidenceScore: double
     *         },
     *         warnings: [{
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         }],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     }],
     *     errors: [{
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     }],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getlanguages() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/languages")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats");
    }

    /**
     * The API returns a list of strings denoting the key phrases in the input text. See the &lt;a
     * href="https://aka.ms/talangs"&gt;Supported languages in Text Analytics API&lt;/a&gt; for the list of enabled
     * languages.
     *
     * <h2>Optional Query Parameters</h2>
     * <table border="1">
     *     <caption>Optional Query Parameters</caption>
     *     <tr><th>Name</th><th>Type</th><th>Description</th></tr>
     *     <tr><td>model-version</td><td>String</td><td>This value indicates which model will be used for scoring. If a
     *          model-version is not specified, the API should default to the latest, non-preview version.</td></tr>
     *     <tr><td>showStats</td><td>boolean</td><td>if set to true, response will contain request and document level
     *          statistics.</td></tr>
     * </table>
     *
     * <h2>Request Body Schema</h2>
     *
     * {
     *     documents: [
     *         {
     *             id: String (required),
     *             text: String (required),
     *             language: String
     *         }
     *     ] (required)
     * }
     *
     * <h2>Response Body Schema</h2>
     *
     * {
     *     documents: [{
     *         id: String,
     *         keyPhrases: [String],
     *         warnings: [{
     *             code: String,
     *             message: String,
     *             targetRef: String
     *         }],
     *         statistics: {
     *             charactersCount: int,
     *             transactionsCount: int
     *         }
     *     }],
     *     errors: [{
     *         id: String
     *         error: {
     *             code: String,
     *             message: String,
     *             target: String
     *         }
     *     }],
     *     statistics: {
     *         documentsCount: int,
     *         validDocumentsCount: int,
     *         erroneousDocumentsCount: int,
     *         transactionsCount: long
     *     },
     *     modelVersion: String
     * }
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a DynamicRequest where customizations can be made before sent to the service
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public DynamicRequest getKeyPhrases() {
        return new DynamicRequest(objectSerializer, httpPipeline)
                .setUrl("{Endpoint}/text/analytics/v3.1-preview.3/keyPhrases")
                .setPathParam("Endpoint", endpoint)
                .setHttpMethod(HttpMethod.POST)
                .addHeader("Accept", "application/json, text/json")
                .setOptionalQueryParameters("model-version", "showStats");
    }
}
