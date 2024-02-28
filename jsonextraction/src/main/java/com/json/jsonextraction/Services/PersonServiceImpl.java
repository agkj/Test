package com.json.jsonextraction.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.jsonextraction.DTO.PersonDTO;
import com.json.jsonextraction.Model.Person;
import com.json.jsonextraction.Repository.PersonRepository;
import com.json.jsonextraction.Responses.ExtractionResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;


    private static final Logger loggerResponse = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Boolean dateCompare(PersonDTO personDTO) {

        try {
            String requestBodyJson = objectMapper.writeValueAsString(new ExtractionResponse("Person added",true));
            loggerResponse.info(requestBodyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return true;
    }
}
