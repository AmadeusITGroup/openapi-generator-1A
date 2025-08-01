package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;


import java.util.*;
import javax.annotation.Generated;

/**
 * OuterComposite
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.15.0-SNAPSHOT")
public class OuterComposite {

  private @Nullable BigDecimal myNumber;

  private @Nullable String myString;

  private @Nullable Boolean myBoolean;

  public OuterComposite() {
    super();
  }

  /**
   * Constructor with all args parameters
   */
  public OuterComposite(@Nullable BigDecimal myNumber, @Nullable String myString, @Nullable Boolean myBoolean) {
      this.myNumber = myNumber;
      this.myString = myString;
      this.myBoolean = myBoolean;
  }

  public OuterComposite myNumber(@Nullable BigDecimal myNumber) {
    this.myNumber = myNumber;
    return this;
  }

  /**
   * Get myNumber
   * @return myNumber
   */
  @Valid 
  @ApiModelProperty(value = "")
  @JsonProperty("my_number")
  public @Nullable BigDecimal getMyNumber() {
    return myNumber;
  }

  public void setMyNumber(@Nullable BigDecimal myNumber) {
    this.myNumber = myNumber;
  }

  public OuterComposite myString(@Nullable String myString) {
    this.myString = myString;
    return this;
  }

  /**
   * Get myString
   * @return myString
   */
  
  @ApiModelProperty(value = "")
  @JsonProperty("my_string")
  public @Nullable String getMyString() {
    return myString;
  }

  public void setMyString(@Nullable String myString) {
    this.myString = myString;
  }

  public OuterComposite myBoolean(@Nullable Boolean myBoolean) {
    this.myBoolean = myBoolean;
    return this;
  }

  /**
   * Get myBoolean
   * @return myBoolean
   */
  
  @ApiModelProperty(value = "")
  @JsonProperty("my_boolean")
  public @Nullable Boolean getMyBoolean() {
    return myBoolean;
  }

  public void setMyBoolean(@Nullable Boolean myBoolean) {
    this.myBoolean = myBoolean;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OuterComposite outerComposite = (OuterComposite) o;
    return Objects.equals(this.myNumber, outerComposite.myNumber) &&
        Objects.equals(this.myString, outerComposite.myString) &&
        Objects.equals(this.myBoolean, outerComposite.myBoolean);
  }

  @Override
  public int hashCode() {
    return Objects.hash(myNumber, myString, myBoolean);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OuterComposite {\n");
    sb.append("    myNumber: ").append(toIndentedString(myNumber)).append("\n");
    sb.append("    myString: ").append(toIndentedString(myString)).append("\n");
    sb.append("    myBoolean: ").append(toIndentedString(myBoolean)).append("\n");
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
}

