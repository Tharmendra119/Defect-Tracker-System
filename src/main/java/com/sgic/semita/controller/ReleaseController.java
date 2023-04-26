package com.sgic.semita.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sgic.semita.common.response.BasicResponse;
import com.sgic.semita.common.response.ContentResponse;
import com.sgic.semita.common.response.ValidationFailureResponse;
import com.sgic.semita.entities.Release;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ReleaseRequestDto;
import com.sgic.semita.services.ReleaseService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class ReleaseController {
  @Autowired
  private ReleaseService releaseService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create Release API || Author: kajanthan || Date: 21-04-2023
   */
  @PostMapping(value = EndPointURI.RELEASE)
  public ResponseEntity<Object> createRelease(@RequestBody ReleaseRequestDto releaseRequestDto) {
    if (releaseService.isReleaseExists(releaseRequestDto.getName())) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.RELEASE_ALREADY_EXISTS,
          validationFailureResponseCode.getReleaseAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    Release release = new Release();
    BeanUtils.copyProperties(releaseRequestDto, release);
    releaseService.saveRelease(release);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_RELEASE_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Get all Release API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.RELEASES)
  public ResponseEntity<Object> getAllRelease() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.RELEASE,
        releaseService.getAllRelease(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Release by id API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.RELEASE_BY_ID)
  public ResponseEntity<Object> getReleaseById(@PathVariable Long id) {
    if (!releaseService.existByRelease(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.RELEASE_NOT_EXISTS,
          validationFailureResponseCode.getReleaseNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.RELEASE,
        releaseService.getReleaseById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update Release API || Author: kajanthan || Date:21-04-2023
   */
  @PutMapping(value = EndPointURI.RELEASE)
  public ResponseEntity<Object> updateRelease(@RequestBody ReleaseRequestDto releaseRequestDto) {
    if (releaseService.existByRelease(releaseRequestDto.getId())) {
      if (releaseService.isUpdatedReleaseNameExist(releaseRequestDto.getId(),
          releaseRequestDto.getName())) {
        return new ResponseEntity<>(new ValidationFailureResponse(Constants.RELEASE_ALREADY_EXISTS,
            validationFailureResponseCode.getReleaseAlreadyExists()), HttpStatus.BAD_REQUEST);
      }
      Release release = new Release();
      BeanUtils.copyProperties(releaseRequestDto, release);
      releaseService.saveRelease(release);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_RELEASE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.RELEASE_NOT_EXISTS,
        validationFailureResponseCode.getReleaseNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete Release API || Author: kajanthan || Date: 21-04-2023
   */
  @DeleteMapping(value = EndPointURI.RELEASE_BY_ID)
  public ResponseEntity<Object> deleteRelease(@PathVariable Long id) {
    if (releaseService.existByRelease(id)) {
      releaseService.deleteRelease(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_RELEASE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.RELEASE_NOT_EXISTS,
        validationFailureResponseCode.getReleaseNotExists()), HttpStatus.BAD_REQUEST);
  }
}
