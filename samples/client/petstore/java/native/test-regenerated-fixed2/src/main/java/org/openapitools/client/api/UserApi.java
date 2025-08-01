/*
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package org.openapitools.client.api;

import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;

import java.time.OffsetDateTime;
import org.openapitools.client.model.User;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-08T21:08:28.986952+07:00[Asia/Bangkok]", comments = "Generator version: 7.15.0-SNAPSHOT")
public class UserApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public UserApi() {
    this(Configuration.getDefaultApiClient());
  }

  public UserApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }


  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Create user
   * This can only be done by the logged in user.
   * @param user Created user object (required)
   * @throws ApiException if fails to make API call
   */
  public void createUser(@javax.annotation.Nonnull User user) throws ApiException {
    return createUser(user, null);
  }

  /**
   * Create user
   * This can only be done by the logged in user.
   * @param user Created user object (required)
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void createUser(@javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
          createUserWithHttpInfo(user, headers);
  }

  /**
   * Create user
   * This can only be done by the logged in user.
   * @param user Created user object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUserWithHttpInfo(@javax.annotation.Nonnull User user) throws ApiException {
    return createUserWithHttpInfo(user, null);
  }

  /**
   * Create user
   * This can only be done by the logged in user.
   * @param user Created user object (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUserWithHttpInfo(@javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createUserRequestBuilder(user, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createUser", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createUserRequestBuilder(@javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'user' is set
    if (user == null) {
      throw new ApiException(400, "Missing the required parameter 'user' when calling createUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(user);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @throws ApiException if fails to make API call
   */
  public void createUsersWithArrayInput(@javax.annotation.Nonnull List<User> user) throws ApiException {
    return createUsersWithArrayInput(user, null);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void createUsersWithArrayInput(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
          createUsersWithArrayInputWithHttpInfo(user, headers);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUsersWithArrayInputWithHttpInfo(@javax.annotation.Nonnull List<User> user) throws ApiException {
    return createUsersWithArrayInputWithHttpInfo(user, null);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUsersWithArrayInputWithHttpInfo(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createUsersWithArrayInputRequestBuilder(user, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createUsersWithArrayInput", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createUsersWithArrayInputRequestBuilder(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'user' is set
    if (user == null) {
      throw new ApiException(400, "Missing the required parameter 'user' when calling createUsersWithArrayInput");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/createWithArray";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(user);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @throws ApiException if fails to make API call
   */
  public void createUsersWithListInput(@javax.annotation.Nonnull List<User> user) throws ApiException {
    return createUsersWithListInput(user, null);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void createUsersWithListInput(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
          createUsersWithListInputWithHttpInfo(user, headers);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUsersWithListInputWithHttpInfo(@javax.annotation.Nonnull List<User> user) throws ApiException {
    return createUsersWithListInputWithHttpInfo(user, null);
  }

  /**
   * Creates list of users with given input array
   * 
   * @param user List of user object (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> createUsersWithListInputWithHttpInfo(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createUsersWithListInputRequestBuilder(user, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createUsersWithListInput", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createUsersWithListInputRequestBuilder(@javax.annotation.Nonnull List<User> user, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'user' is set
    if (user == null) {
      throw new ApiException(400, "Missing the required parameter 'user' when calling createUsersWithListInput");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/createWithList";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(user);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Delete user
   * This can only be done by the logged in user.
   * @param username The name that needs to be deleted (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteUser(@javax.annotation.Nonnull String username) throws ApiException {
    return deleteUser(username, null);
  }

  /**
   * Delete user
   * This can only be done by the logged in user.
   * @param username The name that needs to be deleted (required)
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void deleteUser(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
          deleteUserWithHttpInfo(username, headers);
  }

  /**
   * Delete user
   * This can only be done by the logged in user.
   * @param username The name that needs to be deleted (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteUserWithHttpInfo(@javax.annotation.Nonnull String username) throws ApiException {
    return deleteUserWithHttpInfo(username, null);
  }

  /**
   * Delete user
   * This can only be done by the logged in user.
   * @param username The name that needs to be deleted (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteUserWithHttpInfo(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteUserRequestBuilder(username, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteUser", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteUserRequestBuilder(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling deleteUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/{username}"
        .replace("{username}", ApiClient.urlEncode(username.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Get user by user name
   * 
   * @param username The name that needs to be fetched. Use user1 for testing. (required)
   * @return User
   * @throws ApiException if fails to make API call
   */
  public User getUserByName(@javax.annotation.Nonnull String username) throws ApiException {
    return getUserByName(username, null);
  }

  /**
   * Get user by user name
   * 
   * @param username The name that needs to be fetched. Use user1 for testing. (required)
   * @param headers Optional headers to include in the request
   * @return User
   * @throws ApiException if fails to make API call
   */
  public User getUserByName(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
          ApiResponse<User> localVarResponse = getUserByNameWithHttpInfo(username, headers);
    return localVarResponse.getData();
  }

  /**
   * Get user by user name
   * 
   * @param username The name that needs to be fetched. Use user1 for testing. (required)
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<User> getUserByNameWithHttpInfo(@javax.annotation.Nonnull String username) throws ApiException {
    return getUserByNameWithHttpInfo(username, null);
  }

  /**
   * Get user by user name
   * 
   * @param username The name that needs to be fetched. Use user1 for testing. (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;User&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<User> getUserByNameWithHttpInfo(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getUserByNameRequestBuilder(username, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getUserByName", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<User>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<User>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<User>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getUserByNameRequestBuilder(@javax.annotation.Nonnull String username, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling getUserByName");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/{username}"
        .replace("{username}", ApiClient.urlEncode(username.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/xml, application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Logs user into the system
   * 
   * @param username The user name for login (required)
   * @param password The password for login in clear text (required)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String loginUser(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull String password) throws ApiException {
    return loginUser(username, password, null);
  }

  /**
   * Logs user into the system
   * 
   * @param username The user name for login (required)
   * @param password The password for login in clear text (required)
   * @param headers Optional headers to include in the request
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String loginUser(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull String password, Map<String, String> headers) throws ApiException {
          ApiResponse<String> localVarResponse = loginUserWithHttpInfo(username, password, headers);
    return localVarResponse.getData();
  }

  /**
   * Logs user into the system
   * 
   * @param username The user name for login (required)
   * @param password The password for login in clear text (required)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> loginUserWithHttpInfo(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull String password) throws ApiException {
    return loginUserWithHttpInfo(username, password, null);
  }

  /**
   * Logs user into the system
   * 
   * @param username The user name for login (required)
   * @param password The password for login in clear text (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> loginUserWithHttpInfo(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull String password, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = loginUserRequestBuilder(username, password, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("loginUser", localVarResponse);
        }
        if (localVarResponse.body() == null) {
          return new ApiResponse<String>(
              localVarResponse.statusCode(),
              localVarResponse.headers().map(),
              null
          );
        }

        String responseBody = new String(localVarResponse.body().readAllBytes());
        localVarResponse.body().close();

        return new ApiResponse<String>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            responseBody.isBlank()? null: memberVarObjectMapper.readValue(responseBody, new TypeReference<String>() {})
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder loginUserRequestBuilder(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull String password, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling loginUser");
    }
    // verify the required parameter 'password' is set
    if (password == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling loginUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/login";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "username";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("username", username));
    localVarQueryParameterBaseName = "password";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("password", password));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/xml, application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Logs out current logged in user session
   * 
   * @throws ApiException if fails to make API call
   */
  public void logoutUser() throws ApiException {
    return logoutUser(, null);
  }

  /**
   * Logs out current logged in user session
   * 
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void logoutUser(Map<String, String> headers) throws ApiException {
          logoutUserWithHttpInfo(headers);
  }

  /**
   * Logs out current logged in user session
   * 
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> logoutUserWithHttpInfo() throws ApiException {
    return logoutUserWithHttpInfo(, null);
  }

  /**
   * Logs out current logged in user session
   * 
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> logoutUserWithHttpInfo(Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = logoutUserRequestBuilder(headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("logoutUser", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder logoutUserRequestBuilder(Map<String, String> headers) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/logout";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Updated user
   * This can only be done by the logged in user.
   * @param username name that need to be deleted (required)
   * @param user Updated user object (required)
   * @throws ApiException if fails to make API call
   */
  public void updateUser(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull User user) throws ApiException {
    return updateUser(username, user, null);
  }

  /**
   * Updated user
   * This can only be done by the logged in user.
   * @param username name that need to be deleted (required)
   * @param user Updated user object (required)
   * @param headers Optional headers to include in the request
   * @throws ApiException if fails to make API call
   */
  public void updateUser(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
          updateUserWithHttpInfo(username, user, headers);
  }

  /**
   * Updated user
   * This can only be done by the logged in user.
   * @param username name that need to be deleted (required)
   * @param user Updated user object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> updateUserWithHttpInfo(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull User user) throws ApiException {
    return updateUserWithHttpInfo(username, user, null);
  }

  /**
   * Updated user
   * This can only be done by the logged in user.
   * @param username name that need to be deleted (required)
   * @param user Updated user object (required)
   * @param headers Optional headers to include in the request
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> updateUserWithHttpInfo(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateUserRequestBuilder(username, user, headers);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("updateUser", localVarResponse);
        }
        return new ApiResponse<>(
            localVarResponse.statusCode(),
            localVarResponse.headers().map(),
            null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
          // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder updateUserRequestBuilder(@javax.annotation.Nonnull String username, @javax.annotation.Nonnull User user, Map<String, String> headers) throws ApiException {
    // verify the required parameter 'username' is set
    if (username == null) {
      throw new ApiException(400, "Missing the required parameter 'username' when calling updateUser");
    }
    // verify the required parameter 'user' is set
    if (user == null) {
      throw new ApiException(400, "Missing the required parameter 'user' when calling updateUser");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/user/{username}"
        .replace("{username}", ApiClient.urlEncode(username.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(user);
      localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    // Add custom headers if provided
    if (headers != null) {
      for (Map.Entry<String, String> entry : headers.entrySet()) {
        localVarRequestBuilder.header(entry.getKey(), entry.getValue());
      }
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

}
