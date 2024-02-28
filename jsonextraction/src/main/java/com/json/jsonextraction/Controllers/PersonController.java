package com.json.jsonextraction.Controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.jsonextraction.DTO.PersonDTO;
import com.json.jsonextraction.Responses.ExtractionResponse;
import com.json.jsonextraction.Services.PersonServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/test")
@Slf4j
public class PersonController {


    @Autowired
    private PersonServiceImpl personServiceImpl;

    @Autowired
    private ObjectMapper objectMapper;


    private static final Logger loggerPost = LoggerFactory.getLogger(PersonController.class);
    @PostMapping
    public ExtractionResponse postPerson(@RequestBody PersonDTO personDTO){


        Boolean closeToDate =  personServiceImpl.dateCompare(personDTO);
        try {
            String requestBodyJson = objectMapper.writeValueAsString(personDTO);
            System.out.println(requestBodyJson);
            loggerPost.info(requestBodyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }




        return new ExtractionResponse("Person added ",closeToDate);
    }





}
