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
import com.sgic.semita.entities.Project;
import com.sgic.semita.entities.ProjectStatus;
import com.sgic.semita.entities.ProjectType;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ProjectRequestDto;
import com.sgic.semita.services.ProjectService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class ProjectController {
  @Autowired
  private ProjectService projectService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create Project API || Author: kajanthan || Date: 22-04-2023
   */
  @PostMapping(value = EndPointURI.PROJECT)
  public ResponseEntity<Object> createProject(@RequestBody ProjectRequestDto projectRequestDto) {
    if (projectService.isProjectExists(projectRequestDto.getProjectName())) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_ALREADY_EXISTS,
          validationFailureResponseCode.getProjectAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    ProjectStatus projectStatus = new ProjectStatus();
    projectStatus.setId(projectRequestDto.getProjectStatusId());
    ProjectType projectType = new ProjectType();
    projectType.setId(projectRequestDto.getProjectTypeId());
    Project project = new Project();
    BeanUtils.copyProperties(projectRequestDto, project);
    project.setProjectStatus(projectStatus);
    project.setProjectType(projectType);
    projectService.saveProject(project);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_PROJECT_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Get all Project API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECTS)
  public ResponseEntity<Object> getAllProject() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECTS,
        projectService.getAllProject(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Project by id API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.PROJECT_BY_ID)
  public ResponseEntity<Object> getProjectById(@PathVariable Long id) {
    if (!projectService.existByProject(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_NOT_EXISTS,
          validationFailureResponseCode.getProjectNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT,
        projectService.getProjectById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update Project API || Author: kajanthan || Date: 22-04-2023
   */
  @PutMapping(value = EndPointURI.PROJECT)
  public ResponseEntity<Object> updateProject(@RequestBody ProjectRequestDto projectRequestDto) {
    if (projectService.existByProject(projectRequestDto.getId())) {
      if (projectService.isUpdatedProjectNameExist(projectRequestDto.getId(),
          projectRequestDto.getProjectName())) {
        return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_ALREADY_EXISTS,
            validationFailureResponseCode.getProjectAlreadyExists()), HttpStatus.BAD_REQUEST);
      }
      ProjectStatus projectStatus = new ProjectStatus();
      projectStatus.setId(projectRequestDto.getProjectStatusId());
      ProjectType projectType = new ProjectType();
      projectType.setId(projectRequestDto.getProjectTypeId());
      Project project = new Project();
      BeanUtils.copyProperties(projectRequestDto, project);
      project.setProjectStatus(projectStatus);
      project.setProjectType(projectType);
      projectService.saveProject(project);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_PROJECT_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_NOT_EXISTS,
        validationFailureResponseCode.getProjectNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete Project API || Author: kajanthan || Date: 22-04-2023
   */
  @DeleteMapping(value = EndPointURI.PROJECT_BY_ID)
  public ResponseEntity<Object> deleteProject(@PathVariable Long id) {
    if (projectService.existByProject(id)) {
      projectService.deleteProject(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_PROJECT_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.PROJECT_NOT_EXISTS,
        validationFailureResponseCode.getProjectNotExists()), HttpStatus.BAD_REQUEST);
  }
}
