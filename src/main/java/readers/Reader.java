
package readers;

import java.util.Map;
import reactors.Reactor;

public abstract class Reader {
    public abstract Map<String, Reactor> readFile(String fileName);
}
