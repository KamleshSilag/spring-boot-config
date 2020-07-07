package com.kamlesh.springbootconfig.resource;

import com.kamlesh.springbootconfig.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GreetingController {

    @Value("${my.greeting : default value}")
    private String greetingMessage;

    @Value("some random message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listValues;

    @Autowired
    private DbSettings dbSettings;

    @GetMapping("/greeting")
    public String greeting(){
        return dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort();
    }
}
