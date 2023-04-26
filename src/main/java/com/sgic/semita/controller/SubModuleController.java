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
import com.sgic.semita.entities.SubModule;
import com.sgic.semita.entities.Module;
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.SubModuleRequestDto;
import com.sgic.semita.services.SubModuleService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;

@CrossOrigin
@RestController
public class SubModuleController {
  @Autowired
  private SubModuleService subModuleService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create SubModule API || Author: kajanthan || Date: 22-04-2023
   */
  @PostMapping(value = EndPointURI.SUBMODULE)
  public ResponseEntity<Object> createSubModule(
      @RequestBody SubModuleRequestDto subModuleRequestDto) {
    if (subModuleService.isSubModuleExists(subModuleRequestDto.getName())) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.SUBMODULE_ALREADY_EXISTS,
          validationFailureResponseCode.getSubModuleAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    Module module = new Module();
    module.setId(subModuleRequestDto.getModuleId());
    SubModule subModule = new SubModule();
    BeanUtils.copyProperties(subModuleRequestDto, subModule);
    subModule.setModule(module);
    subModuleService.saveSubModule(subModule);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_SUBMODULE_SUCCESS),
        HttpStatus.OK);
  }

  /*
   * Description: Get all SubModule API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.SUBMODULES)
  public ResponseEntity<Object> getAllSubModule() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.SUBMODULES,
        subModuleService.getAllSubModule(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get SubModule by id API || Author: kajanthan || Date: 22-04-2023
   */
  @GetMapping(value = EndPointURI.SUBMODULE_BY_ID)
  public ResponseEntity<Object> getSubModuleById(@PathVariable Long id) {
    if (!subModuleService.existBySubModule(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.SUBMODULE_NOT_EXISTS,
          validationFailureResponseCode.getSubModuleNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.SUBMODULE,
        subModuleService.getSubModuleById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update SubModule API || Author: kajanthan || Date: 22-04-2023
   */
  @PutMapping(value = EndPointURI.SUBMODULE)
  public ResponseEntity<Object> updateSubModule(
      @RequestBody SubModuleRequestDto subModuleRequestDto) {
    if (subModuleService.existBySubModule(subModuleRequestDto.getId())) {
      if (subModuleService.isUpdatedSubModuleNameExist(subModuleRequestDto.getId(),
          subModuleRequestDto.getName())) {
        return new ResponseEntity<>(
            new ValidationFailureResponse(Constants.SUBMODULE_ALREADY_EXISTS,
                validationFailureResponseCode.getSubModuleAlreadyExists()),
            HttpStatus.BAD_REQUEST);
      }
      Module module = new Module();
      module.setId(subModuleRequestDto.getModuleId());
      SubModule subModule = new SubModule();
      BeanUtils.copyProperties(subModuleRequestDto, subModule);
      subModule.setModule(module);
      subModuleService.saveSubModule(subModule);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_SUBMODULE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.SUBMODULE_NOT_EXISTS,
        validationFailureResponseCode.getSubModuleNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete SubModule API || Author: kajanthan || Date: 22-04-2023
   */
  @DeleteMapping(value = EndPointURI.SUBMODULE_BY_ID)
  public ResponseEntity<Object> deleteSubModule(@PathVariable Long id) {
    if (subModuleService.existBySubModule(id)) {
      subModuleService.deleteSubModule(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_SUBMODULE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.SUBMODULE_NOT_EXISTS,
        validationFailureResponseCode.getSubModuleNotExists()), HttpStatus.BAD_REQUEST);
  }
}
