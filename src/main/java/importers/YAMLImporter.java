package importers;

import exceptions.WrongFormatException;
import reactors.Reactor;
import readers.YamlReader;

import java.util.Map;

public class YAMLImporter extends Importer {
    public YAMLImporter() {
        setReader(new YamlReader());
    }
    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".yaml")) {
            return this.getReader().readFile(path);
        } else {
            String[] split = path.split("\\.");
            throw new WrongFormatException(split[split.length - 1]);
        }

    }
}
