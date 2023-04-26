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
import com.sgic.semita.enums.RestApiResponseStatus;
import com.sgic.semita.request.dto.ModuleRequestDto;
import com.sgic.semita.services.ModuleService;
import com.sgic.semita.utils.Constants;
import com.sgic.semita.utils.EndPointURI;
import com.sgic.semita.utils.ValidationFailureResponseCode;
import com.sgic.semita.entities.Module;

@CrossOrigin
@RestController
public class ModuleController {
  @Autowired
  private ModuleService moduleService;

  @Autowired
  private ValidationFailureResponseCode validationFailureResponseCode;

  /*
   * Description: Create Module API || Author: kajanthan || Date: 21-04-2023
   */
  @PostMapping(value = EndPointURI.MODULE)
  public ResponseEntity<Object> createModule(@RequestBody ModuleRequestDto moduleRequestDto) {
    if (moduleService.isModuleExists(moduleRequestDto.getName())) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.MODULE_ALREADY_EXISTS,
          validationFailureResponseCode.getModuleAlreadyExists()), HttpStatus.BAD_REQUEST);
    }
    Module module = new Module();
    BeanUtils.copyProperties(moduleRequestDto, module);
    moduleService.saveModule(module);
    return new ResponseEntity<>(
        new BasicResponse(RestApiResponseStatus.OK, Constants.ADD_MODULE_SUCCESS), HttpStatus.OK);
  }

  /*
   * Description: Get all Module API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.MODULES)
  public ResponseEntity<Object> getAllModule() {
    return new ResponseEntity<>(new ContentResponse<>(Constants.MODULE,
        moduleService.getAllModule(), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Get Module by id API || Author: kajanthan || Date: 21-04-2023
   */
  @GetMapping(value = EndPointURI.MODULE_BY_ID)
  public ResponseEntity<Object> getModuleById(@PathVariable Long id) {
    if (!moduleService.existByModule(id)) {
      return new ResponseEntity<>(new ValidationFailureResponse(Constants.MODULE_NOT_EXISTS,
          validationFailureResponseCode.getModuleNotExists()), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(new ContentResponse<>(Constants.MODULE,
        moduleService.getModuleById(id), RestApiResponseStatus.OK), null, HttpStatus.OK);
  }

  /*
   * Description: Update Module API || Author: kajanthan || Date:21-04-2023
   */
  @PutMapping(value = EndPointURI.MODULE)
  public ResponseEntity<Object> updateModule(@RequestBody ModuleRequestDto moduleRequestDto) {
    if (moduleService.existByModule(moduleRequestDto.getId())) {
      if (moduleService.isUpdatedModuleNameExist(moduleRequestDto.getId(),
          moduleRequestDto.getName())) {
        return new ResponseEntity<>(new ValidationFailureResponse(Constants.MODULE_ALREADY_EXISTS,
            validationFailureResponseCode.getModuleAlreadyExists()), HttpStatus.BAD_REQUEST);
      }
      Module module = new Module();
      BeanUtils.copyProperties(moduleRequestDto, module);
      moduleService.saveModule(module);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.UPDATE_MODULE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.MODULE_NOT_EXISTS,
        validationFailureResponseCode.getModuleNotExists()), HttpStatus.BAD_REQUEST);
  }

  /*
   * Description: Delete Module API || Author: kajanthan || Date: 21-04-2023
   */
  @DeleteMapping(value = EndPointURI.MODULE_BY_ID)
  public ResponseEntity<Object> deleteModule(@PathVariable Long id) {
    if (moduleService.existByModule(id)) {
      moduleService.deleteModule(id);
      return new ResponseEntity<>(
          new BasicResponse(RestApiResponseStatus.OK, Constants.DELETE_MODULE_SUCCESS),
          HttpStatus.OK);
    }
    return new ResponseEntity<>(new ValidationFailureResponse(Constants.MODULE_NOT_EXISTS,
        validationFailureResponseCode.getModuleNotExists()), HttpStatus.BAD_REQUEST);
  }
}
