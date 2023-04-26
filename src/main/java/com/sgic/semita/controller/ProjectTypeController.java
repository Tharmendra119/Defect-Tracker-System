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
import com.sgic.semita.entities.ProjectType;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ProjectTypeRequestDto;
import com.sgic.semita.services.ProjectTypeService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class ProjectTypeController {
  @Autowired
  private ProjectTypeService projectTypeService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create ProjectType API || Author: kajanthan || Date: 21-04-2023
   */
  @PostMapping(value = EndPointURI.PROJECT_TYPE)
  public ResponseEntity<Object> createProjectType(
      @RequestBody ProjectTypeRequestDto projectTypeRequestDto) {
    if (projectTypeService.isProjectTypeExists(projectTypeRequestDto.getName())) {
      return new ResponseEntity<>(
          new ValidationFailureResponse(Constants.PROJECT_TYPE_ALREADY_EXISTS,
              validationFailureResponseCode.getProjectTypeAlreadyExists()),
          HttpStatus.BAD_REQUEST);
    }
    ProjectType projectType = new ProjectType();
    BeanUtils.copyProperties(projectTypeRequestDto, projectType);
    projectTypeService.saveProjectType(projectType);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_PROJECT_TYPE_SUCCESS),
        HttpStatus.OK);
  }

  /*
   * Description: Get all ProjectType API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECT_TYPES)
  public ResponseEntity<Object> getAllProjectType() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT_TYPE,
        projectTypeService.getAllProjectType(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get ProjectType by id API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECT_TYPE_BY_ID)
  public ResponseEntity<Object> getProjectTypeById(@PathVariable Long id) {
    if (!projectTypeService.existByProjectType(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_TYPE_NOT_EXISTS,
          validationFailureResponseCode.getProjectTypeNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT_TYPE,
        projectTypeService.getProjectTypeById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update ProjectType API || Author: kajanthan || Date:21-04-2023
   */
  @PutMapping(value = EndPointURI.PROJECT_TYPE)
  public ResponseEntity<Object> updateProjectType(
      @RequestBody ProjectTypeRequestDto projectTypeRequestDto) {
    if (projectTypeService.existByProjectType(projectTypeRequestDto.getId())) {
      if (projectTypeService.isUpdatedProjectTypeNameExist(projectTypeRequestDto.getId(),
          projectTypeRequestDto.getName())) {
        return new ResponseEntity<>(
            new ValidationFailureResponse(Constants.PROJECT_TYPE_ALREADY_EXISTS,
                validationFailureResponseCode.getProjectTypeAlreadyExists()),
            HttpStatus.BAD_REQUEST);
      }
      ProjectType projectType = new ProjectType();
      BeanUtils.copyProperties(projectTypeRequestDto, projectType);
      projectTypeService.saveProjectType(projectType);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_PROJECT_TYPE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_TYPE_NOT_EXISTS,
        validationFailureResponseCode.getProjectTypeNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete ProjectType API || Author: kajanthan || Date: 21-04-2023
   */
  @DeleteMapping(value = EndPointURI.PROJECT_TYPE_BY_ID)
  public ResponseEntity<Object> deleteProjectType(@PathVariable Long id) {
    if (projectTypeService.existByProjectType(id)) {
      projectTypeService.deleteProjectType(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_PROJECT_TYPE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_TYPE_NOT_EXISTS,
        validationFailureResponseCode.getProjectTypeNotExists()), HttpStatus.BAD_REQUEST);
  }
}
