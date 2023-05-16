package importers;

import readers.JsonReader;
import java.util.Map;
import reactors.Reactor;

public class JSONImporter extends Importer {

    public JSONImporter() {
        setReader(new JsonReader());
    }

    @Override
    public Map<String, Reactor> readFile(String path) {
        if (path.endsWith(".json")) {
            return this.getReader().readFile(path);
        }
        return this.getNeighbour().readFile(path);
    }
}
