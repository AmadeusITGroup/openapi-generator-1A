package org.openapitools.api;

import springfox.documentation.annotations.ApiIgnore;
import java.math.BigDecimal;
import org.openapitools.model.ChildWithNullable;
import org.openapitools.model.Client;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.model.FileSchemaTestClass;
import java.time.LocalDate;
import java.util.Map;
import org.openapitools.model.ModelApiResponse;
import java.time.OffsetDateTime;
import org.openapitools.model.OuterComposite;
import org.openapitools.model.ResponseObjectWithDifferentFieldNames;
import org.openapitools.model.User;
import org.openapitools.model.XmlItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link FakeApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.15.0-SNAPSHOT")
public interface FakeApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /fake/create_xml_item : creates an XmlItem
     * this route creates an XmlItem
     *
     * @param xmlItem XmlItem Body (required)
     * @return successful operation (status code 200)
     * @see FakeApi#createXmlItem
     */
    default Mono<ResponseEntity<Void>> createXmlItem(Mono<XmlItem> xmlItem,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(xmlItem).then(Mono.empty());

    }

    /**
     * POST /fake/outer/boolean
     * Test serialization of outer boolean types
     *
     * @param body Input boolean as post body (optional)
     * @return Output boolean (status code 200)
     * @see FakeApi#fakeOuterBooleanSerialize
     */
    default Mono<ResponseEntity<Boolean>> fakeOuterBooleanSerialize(Mono<Boolean> body,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(body).then(Mono.empty());

    }

    /**
     * POST /fake/outer/composite
     * Test serialization of object with outer number type
     *
     * @param outerComposite Input composite as post body (optional)
     * @return Output composite (status code 200)
     * @see FakeApi#fakeOuterCompositeSerialize
     */
    default Mono<ResponseEntity<OuterComposite>> fakeOuterCompositeSerialize(Mono<OuterComposite> outerComposite,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("*/*"))) {
                String exampleString = "{ \"my_string\" : \"my_string\", \"my_number\" : 0.8008281904610115, \"my_boolean\" : true }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(outerComposite).then(Mono.empty());

    }

    /**
     * POST /fake/outer/number
     * Test serialization of outer number types
     *
     * @param body Input number as post body (optional)
     * @return Output number (status code 200)
     * @see FakeApi#fakeOuterNumberSerialize
     */
    default Mono<ResponseEntity<BigDecimal>> fakeOuterNumberSerialize(Mono<BigDecimal> body,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(body).then(Mono.empty());

    }

    /**
     * POST /fake/outer/string
     * Test serialization of outer string types
     *
     * @param body Input string as post body (optional)
     * @return Output string (status code 200)
     * @see FakeApi#fakeOuterStringSerialize
     */
    default Mono<ResponseEntity<String>> fakeOuterStringSerialize(Mono<String> body,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(body).then(Mono.empty());

    }

    /**
     * GET /fake/{petId}/response-object-different-names
     *
     * @param petId ID of pet to update (required)
     * @return successful operation (status code 200)
     * @see FakeApi#responseObjectDifferentNames
     */
    default Mono<ResponseEntity<ResponseObjectWithDifferentFieldNames>> responseObjectDifferentNames(Long petId,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"UPPER_CASE_PROPERTY_SNAKE\" : \"UPPER_CASE_PROPERTY_SNAKE\", \"lower-case-property-dashes\" : \"lower-case-property-dashes\", \"property name with spaces\" : \"property name with spaces\", \"normalPropertyName\" : \"normalPropertyName\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * PUT /fake/body-with-file-schema
     * For this test, the body for this request much reference a schema named &#x60;File&#x60;.
     *
     * @param fileSchemaTestClass  (required)
     * @return Success (status code 200)
     * @see FakeApi#testBodyWithFileSchema
     */
    default Mono<ResponseEntity<Void>> testBodyWithFileSchema(Mono<FileSchemaTestClass> fileSchemaTestClass,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(fileSchemaTestClass).then(Mono.empty());

    }

    /**
     * PUT /fake/body-with-query-params
     *
     * @param query  (required)
     * @param user  (required)
     * @return Success (status code 200)
     * @see FakeApi#testBodyWithQueryParams
     */
    default Mono<ResponseEntity<Void>> testBodyWithQueryParams(String query,
        Mono<User> user,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(user).then(Mono.empty());

    }

    /**
     * PATCH /fake : To test \&quot;client\&quot; model
     * To test \&quot;client\&quot; model
     *
     * @param client client model (required)
     * @return successful operation (status code 200)
     * @see FakeApi#testClientModel
     */
    default Mono<ResponseEntity<Client>> testClientModel(Mono<Client> client,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"client\" : \"client\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(client).then(Mono.empty());

    }

    /**
     * POST /fake : Fake endpoint for testing various parameters  假端點  偽のエンドポイント  가짜 엔드 포인트
     * Fake endpoint for testing various parameters  假端點  偽のエンドポイント  가짜 엔드 포인트
     *
     * @param number None (required)
     * @param _double None (required)
     * @param patternWithoutDelimiter None (required)
     * @param _byte None (required)
     * @param integer None (optional)
     * @param int32 None (optional)
     * @param int64 None (optional)
     * @param _float None (optional)
     * @param string None (optional)
     * @param binary None (optional)
     * @param date None (optional)
     * @param dateTime None (optional)
     * @param password None (optional)
     * @param paramCallback None (optional)
     * @return Invalid username supplied (status code 400)
     *         or User not found (status code 404)
     * @see FakeApi#testEndpointParameters
     */
    default Mono<ResponseEntity<Void>> testEndpointParameters(BigDecimal number,
        Double _double,
        String patternWithoutDelimiter,
        byte[] _byte,
        Integer integer,
        Integer int32,
        Long int64,
        Float _float,
        String string,
        Part binary,
        LocalDate date,
        OffsetDateTime dateTime,
        String password,
        String paramCallback,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

    /**
     * GET /fake : To test enum parameters
     * To test enum parameters
     *
     * @param enumHeaderStringArray Header parameter enum test (string array) (optional)
     * @param enumHeaderString Header parameter enum test (string) (optional, default to -efg)
     * @param enumQueryStringArray Query parameter enum test (string array) (optional)
     * @param enumQueryString Query parameter enum test (string) (optional, default to -efg)
     * @param enumQueryInteger Query parameter enum test (double) (optional)
     * @param enumQueryDouble Query parameter enum test (double) (optional)
     * @param enumFormStringArray Form parameter enum test (string array) (optional, default to $)
     * @param enumFormString Form parameter enum test (string) (optional, default to -efg)
     * @return Invalid request (status code 400)
     *         or Not found (status code 404)
     * @see FakeApi#testEnumParameters
     */
    default Mono<ResponseEntity<Void>> testEnumParameters(List<String> enumHeaderStringArray,
        String enumHeaderString,
        List<String> enumQueryStringArray,
        String enumQueryString,
        Integer enumQueryInteger,
        Double enumQueryDouble,
        List<String> enumFormStringArray,
        String enumFormString,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

    /**
     * DELETE /fake : Fake endpoint to test group parameters (optional)
     * Fake endpoint to test group parameters (optional)
     *
     * @param requiredStringGroup Required String in group parameters (required)
     * @param requiredBooleanGroup Required Boolean in group parameters (required)
     * @param requiredInt64Group Required Integer in group parameters (required)
     * @param stringGroup String in group parameters (optional)
     * @param booleanGroup Boolean in group parameters (optional)
     * @param int64Group Integer in group parameters (optional)
     * @return Something wrong (status code 400)
     * @see FakeApi#testGroupParameters
     */
    default Mono<ResponseEntity<Void>> testGroupParameters(Integer requiredStringGroup,
        Boolean requiredBooleanGroup,
        Long requiredInt64Group,
        Integer stringGroup,
        Boolean booleanGroup,
        Long int64Group,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

    /**
     * POST /fake/inline-additionalProperties : test inline additionalProperties
     * 
     *
     * @param requestBody request body (required)
     * @return successful operation (status code 200)
     * @see FakeApi#testInlineAdditionalProperties
     */
    default Mono<ResponseEntity<Void>> testInlineAdditionalProperties(Mono<Map<String, String>> requestBody,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(requestBody).then(Mono.empty());

    }

    /**
     * GET /fake/jsonFormData : test json serialization of form data
     * 
     *
     * @param param field1 (required)
     * @param param2 field2 (required)
     * @return successful operation (status code 200)
     * @see FakeApi#testJsonFormData
     */
    default Mono<ResponseEntity<Void>> testJsonFormData(String param,
        String param2,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

    /**
     * POST /fake/nullable : test nullable parent property
     * 
     *
     * @param childWithNullable request body (required)
     * @return successful operation (status code 200)
     * @see FakeApi#testNullable
     */
    default Mono<ResponseEntity<Void>> testNullable(Mono<ChildWithNullable> childWithNullable,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(childWithNullable).then(Mono.empty());

    }

    /**
     * PUT /fake/test-query-parameters
     * To test the collection format in query parameters
     *
     * @param pipe  (required)
     * @param http  (required)
     * @param url  (required)
     * @param context  (required)
     * @return Success (status code 200)
     * @see FakeApi#testQueryParameterCollectionFormat
     */
    default Mono<ResponseEntity<Void>> testQueryParameterCollectionFormat(List<String> pipe,
        List<String> http,
        List<String> url,
        List<String> context,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        return result.then(Mono.empty());

    }

    /**
     * GET /fake/response-with-example
     * This endpoint defines an example value for its response schema.
     *
     * @return Success (status code 200)
     * @see FakeApi#testWithResultExample
     */
    default Mono<ResponseEntity<Integer>> testWithResultExample(ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "42";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

    /**
     * POST /fake/{petId}/uploadImageWithRequiredFile : uploads an image (required)
     * 
     *
     * @param petId ID of pet to update (required)
     * @param requiredFile file to upload (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @return successful operation (status code 200)
     * @see FakeApi#uploadFileWithRequiredFile
     */
    default Mono<ResponseEntity<ModelApiResponse>> uploadFileWithRequiredFile(Long petId,
        Part requiredFile,
        String additionalMetadata,
        ServerWebExchange exchange) {
        Mono<Void> result = Mono.empty();
        exchange.getResponse().setStatusCode(HttpStatus.NOT_IMPLEMENTED);
        for (MediaType mediaType : exchange.getRequest().getHeaders().getAccept()) {
            if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                String exampleString = "{ \"code\" : 0, \"type\" : \"type\", \"message\" : \"message\" }";
                result = ApiUtil.getExampleResponse(exchange, MediaType.valueOf("application/json"), exampleString);
                break;
            }
        }
        return result.then(Mono.empty());

    }

}
