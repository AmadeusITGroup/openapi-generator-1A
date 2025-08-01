/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * ModelList
 */
@JsonPropertyOrder({
  ModelList.JSON_PROPERTY_123LIST
})
@JsonTypeName("List")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.15.0-SNAPSHOT")
public class ModelList {
  public static final String JSON_PROPERTY_123LIST = "123-list";
  @javax.annotation.Nullable
  private String _123list;

  public ModelList() {
  }

  /**
   * Constructor with all args parameters
   */
  public ModelList(@JsonProperty(JSON_PROPERTY_123LIST) String _123list) {
    this._123list = _123list;
  }

  public ModelList _123list(@javax.annotation.Nullable String _123list) {
    
    this._123list = _123list;
    return this;
  }

  /**
   * Get _123list
   * @return _123list
   */
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_123LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String get123list() {
    return _123list;
  }


  @JsonProperty(JSON_PROPERTY_123LIST)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void set123list(@javax.annotation.Nullable String _123list) {
    this._123list = _123list;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelList _list = (ModelList) o;
    return Objects.equals(this._123list, _list._123list);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_123list);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelList {\n");
    sb.append("    _123list: ").append(toIndentedString(_123list)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  public static class Builder {

    private ModelList instance;

    public Builder() {
      this(new ModelList());
    }

    protected Builder(ModelList instance) {
      this.instance = instance;
    }

    public ModelList.Builder _123list(String _123list) {
      this.instance._123list = _123list;
      return this;
    }


    /**
    * returns a built ModelList instance.
    *
    * The builder is not reusable.
    */
    public ModelList build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field.
  */
  public static ModelList.Builder builder() {
    return new ModelList.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ModelList.Builder toBuilder() {
    return new ModelList.Builder()
      ._123list(get123list());
  }


}

