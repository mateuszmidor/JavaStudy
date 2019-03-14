package mm;

import org.leadpony.justify.api.JsonSchema;
import org.leadpony.justify.api.JsonValidationService;
import org.leadpony.justify.api.ProblemHandler;

import javax.json.stream.JsonParser;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    private static List<Path> listSampleJsons() {
        File[] files = new File("data").listFiles();
        return Stream.of(files).map(File::toPath).filter(p -> p.toString().contains("rq")).collect(Collectors.toList());
    }

    private static Collection<String> validate(Collection<Path> paths) {
        Collection<String> messages = new ArrayList<>();
        JsonValidationService service = JsonValidationService.newInstance();
        JsonSchema schema = service.readSchema(Paths.get("data/schema.json"));

        for (Path path : paths) {
            Consumer<String> msgConsumer = (msg -> messages.add(path.getFileName() + ": " + msg));
            ProblemHandler handler = service.createProblemPrinter(msgConsumer);
            try (JsonParser parser = service.createParser(path, schema, handler)) {
                while (parser.hasNext()) {
                    parser.next();
                }
            }
        }
        return messages;
    }

    public static void main(String[] args) {

        Collection<String> messages = validate(listSampleJsons());
        messages.stream().forEach(System.out::println);
    }
}
