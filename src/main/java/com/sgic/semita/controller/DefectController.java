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
import com.sgic.semita.entities.Defect;
import com.sgic.semita.entities.DefectStatus;
import com.sgic.semita.entities.DefectType;
import com.sgic.semita.entities.Employee;
import com.sgic.semita.entities.Module;
import com.sgic.semita.entities.ModuleAllocation;
import com.sgic.semita.entities.Priority;
import com.sgic.semita.entities.Project;
import com.sgic.semita.entities.ProjectAllocation;
import com.sgic.semita.entities.Release;
import com.sgic.semita.entities.Severity;
import com.sgic.semita.entities.SubModule;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.DefectRequestDto;
import com.sgic.semita.request.dto.ModuleAllocationRequestDto;
import com.sgic.semita.request.dto.ProjectAllocationRequestDto;
import com.sgic.semita.services.DefectService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class DefectController {
  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;
  private DefectService defectService;

  /*
   * Description: Create defect API || Author: kajanthan || Date: 23-04-2023
   */
  @PostMapping(value = EndPointURI.DEFECT)
  public ResponseEntity<Object> createDefect(@RequestBody DefectRequestDto defectRequestDto) {
    if (defectService.isDefectExistsByCode(defectRequestDto.getCode())) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.DEFECT_ALREADY_EXISTS,
          validationFailureResponseCode.getDefectAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    Release release = new Release();
    release.setId(defectRequestDto.getReleaseId());
    release.setId(defectRequestDto.getFixedInId());
    Module module = new Module();
    module.setId(defectRequestDto.getModuleId());
    SubModule subModule = new SubModule();
    subModule.setId(defectRequestDto.getSubModuleId());
    DefectType defectType = new DefectType();
    defectType.setId(defectRequestDto.getTypeId());
    Severity severity = new Severity();
    severity.setId(defectRequestDto.getSeverityId());
    Priority priority = new Priority();
    priority.setId(defectRequestDto.getPriorityId());
    DefectStatus defectStatus = new DefectStatus();
    defectStatus.setId(defectRequestDto.getStatusId());
    ProjectAllocation projectAllocation = new ProjectAllocation();
    projectAllocation.setId(defectRequestDto.getAssignToId());
    projectAllocation.setId(defectRequestDto.getFoundById());
    Project project = new Project();
    project.setId(defectRequestDto.getProjectId());

    Defect defect = new Defect();
    BeanUtils.copyProperties(defectRequestDto, defect);
    defect.setRelease(release);
    defect.setFixedIn(release);
    defect.setModule(module);
    defect.setSubModule(subModule);
    defect.setType(defectType);
    defect.setSeverity(severity);
    defect.setPriority(priority);
    defect.setStatus(defectStatus);
    defect.setAssignTo(projectAllocation);
    defect.setFoundBy(projectAllocation);
    defect.setProject(project);

    defectService.saveDefect(defect);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_DEFECT_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Update Defect API || Author: kajanthan || Date:23-04-2023
   */
  @PutMapping(value = EndPointURI.DEFECT)
  public ResponseEntity<Object> updateDefect(@RequestBody DefectRequestDto defectRequestDto) {
    if (defectService.existByDefect(defectRequestDto.getId())) {
      if ((defectService.isUpdatedDefectCodeExist(defectRequestDto.getId(),
          defectRequestDto.getCode()))) {
        return new ResponseEntity<>(new ValidationFailureResponse(Constants.DEFECT_ALREADY_EXISTS,
            validationFailureResponseCode.getDefectAlreadyExists()), HttpStatus.BAD_REQUEST);
      }

      Release release = new Release();
      release.setId(defectRequestDto.getReleaseId());
      release.setId(defectRequestDto.getFixedInId());
      Module module = new Module();
      module.setId(defectRequestDto.getModuleId());
      SubModule subModule = new SubModule();
      subModule.setId(defectRequestDto.getSubModuleId());
      DefectType defectType = new DefectType();
      defectType.setId(defectRequestDto.getTypeId());
      Severity severity = new Severity();
      severity.setId(defectRequestDto.getSeverityId());
      Priority priority = new Priority();
      priority.setId(defectRequestDto.getPriorityId());
      DefectStatus defectStatus = new DefectStatus();
      defectStatus.setId(defectRequestDto.getStatusId());
      ProjectAllocation projectAllocation = new ProjectAllocation();
      projectAllocation.setId(defectRequestDto.getAssignToId());
      projectAllocation.setId(defectRequestDto.getFoundById());
      Project project = new Project();
      project.setId(defectRequestDto.getProjectId());

      Defect defect = new Defect();
      BeanUtils.copyProperties(defectRequestDto, defect);
      defect.setRelease(release);
      defect.setFixedIn(release);
      defect.setModule(module);
      defect.setSubModule(subModule);
      defect.setType(defectType);
      defect.setSeverity(severity);
      defect.setPriority(priority);
      defect.setStatus(defectStatus);
      defect.setAssignTo(projectAllocation);
      defect.setFoundBy(projectAllocation);
      defect.setProject(project);

      defectService.saveDefect(defect);

      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_DEFECT_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(
        new ValidationFailureResponse(Constants.PROJECT_ALLOCATION_NOT_EXISTS,
            validationFailureResponseCode.getDefectNotExists()),
        HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Get defect API || Author: kajanthan || Date: 24-04-2023
   */
  @GetMapping(value = EndPointURI.DEFECTS)
  public ResponseEntity<Object> getAllDefect() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.PROJECT_ALLOCATION,
        defectService.getAllDefect(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Defect_by_id API || Author: kajanthan || Date: 24-04-2023
   */
  @GetMapping(value = EndPointURI.DEFECT_BY_ID)
  public ResponseEntity<Object> getDefectById(@PathVariable Long id) {
    if (!defectService.existByDefect(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.DEFECT_NOT_EXISTS,
          validationFailureResponseCode.getDefectNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.DEFECT,
        defectService.getDefectById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get defect by Project_id API || Author: kajanthan || Date: 24-04-2023
   */
  @GetMapping(value = EndPointURI.DEFECT_PROJECT_BY_ID)
  public ResponseEntity<Object> getDefectByProjectId(@PathVariable Long id) {
    if (!defectService.existByDefect(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.DEFECT_NOT_EXISTS,
          validationFailureResponseCode.getDefectNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.DEFECT,
        defectService.getAllDefectByProjectId(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Delete Defect API || Author: kajanthan || Date: 24-04-2023
   */
  @DeleteMapping(value = EndPointURI.DEFECT_BY_ID)
  public ResponseEntity<Object> deleteDefect(@PathVariable Long id) {
    if (defectService.existByDefect(id)) {
      defectService.deleteDefect(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_DEFECT_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.DEFECT_NOT_EXISTS,
        validationFailureResponseCode.getDefectNotExists()), HttpStatus.BAD_REQUEST);
  }
}
