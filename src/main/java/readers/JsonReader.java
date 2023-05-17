package readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import reactors.Reactor;

public class JsonReader extends Reader {

    @Override
    public Map<String, Reactor> readFile(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Reactor> map;
        try {
            map = objectMapper.readValue(new File(fileName), new TypeReference<Map<String, Reactor>>() {
            });
            for (Map.Entry<String, Reactor> entry : map.entrySet()) {
                entry.getValue().setSource(fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        return map;
    }

}
