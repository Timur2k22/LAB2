package importers;

import java.util.Map;
import reactors.Reactor;


public class ImporterBuilder {
    private Importer xml;
    private Importer yaml;
    private Importer json;

    public Map<String, Reactor> getData(String path) {
        this.xml = new XMLImporter();
        this.yaml = new YAMLImporter();
        this.json = new JSONImporter();
        setParam();
        return json.readFile(path);
    }

    private void setParam() {
        json.setNeighbour(xml);
        xml.setNeighbour(yaml);
        yaml.setNeighbour(null);
    }
}


