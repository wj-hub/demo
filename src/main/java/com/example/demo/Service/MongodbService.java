package com.example.demo.Service;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MongodbService {
    @Resource
    MongoClient mongoClient;
    public MongoTemplate getMongoTemplate(String dbName){
      return new MongoTemplate(mongoClient,dbName);
    }
}
