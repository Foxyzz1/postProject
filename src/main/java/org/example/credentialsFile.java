package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class credentialsFile {

    private JsonNode node;

    public credentialsFile() throws IOException {
        File file = new File("C:\\Users\\Felle\\IdeaProjects\\program\\src\\main\\java\\org\\example\\credentials.json");
        ObjectMapper mapper = new ObjectMapper();
        node = mapper.readTree(file);
    }

    public String getEmail() {
        return node.get("facebookCred").get("email").asText();
    }

    public String getPassword() {
        return node.get("facebookCred").get("password").asText();
    }

}
