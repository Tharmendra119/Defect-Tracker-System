package com.sgic.semita.common.response;

import com.sgic.semita.enums.RestApiResponseStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
  public static final ApiResponse OK = new ApiResponse(RestApiResponseStatus.OK);

  public ApiResponse(RestApiResponseStatus restApiResponseStatus) {
    this.status = restApiResponseStatus.getStatus();
    this.statusCode = restApiResponseStatus.getCode();
  }

  private String status;
  private Integer statusCode;
}
