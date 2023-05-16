
package readers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import reactors.Reactor;

public class XMLReader extends Reader{

    @Override
    public Map<String, Reactor> readFile(String fileName) {
        Map<String, Reactor> map;
        XmlMapper objectMapper = new XmlMapper();
        if (fileName.endsWith(".xml")) {
            try {
                map = objectMapper.readValue(new File(fileName), new TypeReference<Map<String, Reactor>>() {
                });
                for (Map.Entry<String, Reactor> entry : map.entrySet()) {
                    entry.getValue().setSource(fileName);
                }
            } catch (IOException e) {
                throw new RuntimeException();
            }
        }else{
            YamlReader reader = new YamlReader();
            return reader.readFile(fileName);
        }
        return map;
    }
    
}
