package example.controller;

import example.application.UserApplication;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserApplication userApplication;

    @GetMapping("/getAll")
    @ApiOperation(value = "getAll", notes = "getAll")
    public ResponseEntity getAll()
            throws Exception {
        logger.info("userData");
        return ResponseEntity.ok(userApplication.getAll());
    }

}
