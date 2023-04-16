package com.sgic.semita.common.response;

import java.util.HashMap;
import java.util.Map;
import com.sgic.semita.enums.RestApiResponseStatus;

public class ContentResponse<T> extends ApiResponse {
  public ContentResponse(RestApiResponseStatus restApiResponseStatus) {
    super(restApiResponseStatus);
  }

  public ContentResponse() {
    super(RestApiResponseStatus.OK);
  }

  private Map<String, T> results = new HashMap<String, T>();

  public ContentResponse(String key, T dto, RestApiResponseStatus restApiResponseStatus) {
    super(restApiResponseStatus);
    results.put(key, dto);
  }

  public Map<String, T> getResults() {
    return results;
  }

  public void setResults(Map<String, T> results) {
    this.results = results;
  }
}
