package com.hackerrank.sample.controller;

import com.hackerrank.sample.dto.StringResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class SampleController {

    @GetMapping(value = "/defaultHello")
    public ResponseEntity<StringResponse> defHello(@RequestParam(required = false) String message) {
        StringResponse sr;
        if (message != null && !message.isEmpty())
            sr = new StringResponse("Hello " + message);
        else
            sr = new StringResponse("Hello World!");

            return new ResponseEntity<>(sr, HttpStatus.OK);
    }

    @PostMapping(value = "/customHello")
    public ResponseEntity<StringResponse> custHello(@RequestParam String message) {
        if (message == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>(new StringResponse("Custom " + message), HttpStatus.OK);
    }
}
