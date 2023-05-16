package readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import reactors.Reactor;

public class YamlReader extends Reader {

    @Override
    public Map<String, Reactor> readFile(String fileName) {
        Map<String, Reactor> map;
        YAMLMapper mapper = new YAMLMapper();

        try {
            map = mapper.readValue(
                    new File(fileName), new TypeReference<Map<String, Reactor>>() {
                    });
            for (Map.Entry<String, Reactor> entry : map.entrySet()) {
                entry.getValue().setSource(fileName);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

}
