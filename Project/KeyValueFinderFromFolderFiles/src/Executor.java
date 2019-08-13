import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

public class Executor {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<String, HashMap<String, String>> property2FileContentMap = new LinkedHashMap();

    public static void main(String args[])
    {
        populateInputProperties();

        processFolder();

        try {
            if (reader != null)
                reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        printIt();
    }

    private static void printIt() {

        property2FileContentMap.entrySet().stream().forEach(es ->{

            System.out.println("......................................................................................");
            System.out.println("\n"+es.getKey()+"\n");

            HashMap<String, String> esVal = es.getValue();

            if(null != esVal){
                esVal.entrySet().stream().forEach(esv ->{
                    System.out.println(esv.getKey()+" | "+esv.getValue());

                });
            }
            else {
                System.out.println( "< NULL >");
            }


        });

    }

    private static void populateMapWithFileContent(Path filePath, HashMap<String, String> valueMap) {

        String fileName = filePath.getFileName().toString();

        for(String key: property2FileContentMap.keySet()) {

            String value = valueMap.get(key);

            if(null != value && value.length() != 0) {

                HashMap<String, String> file2ValuesMap = property2FileContentMap.get(key);
                if(null == file2ValuesMap) {
                    file2ValuesMap = new LinkedHashMap<>();
                }
                file2ValuesMap.put(fileName, value);
                property2FileContentMap.put(key, file2ValuesMap);
            }
        }

    }

    private static void parseFile(Path filePath) throws IOException{

        //System.out.println("......................................................................................");
        //System.out.println("Starting file processing: "+filePath);
        //System.out.println("......................................................................................");

        HashMap<String, String> propertyKey2ValueMap = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(filePath);

        lines.stream().forEach(line -> {

            String[] lineArray = line.split("=");
            String key = "";
            String value = "";

            if(lineArray.length > 0) { key = lineArray[0]; }

            if(lineArray.length > 1) { value = lineArray[1]; }

            if(key.length()!=0) { propertyKey2ValueMap.put(key, value); }
        });

        populateMapWithFileContent(filePath, propertyKey2ValueMap);

        //System.out.println("......................................................................................");
        //System.out.println("Finishing file processing: "+filePath);
        //System.out.println("......................................................................................");

    }

    private static void processFolder() {

        System.out.print("\n\t Enter Folder location: ");
        String folderPath = readString();

        try(Stream<Path> paths = Files.list(Paths.get(folderPath))) {

            paths.filter(Files::isRegularFile).forEach(filePath -> {

                if (Files.isRegularFile(filePath) && filePath.toString().contains(".properties")) {
                    try {
                        parseFile(filePath);
                        //System.out.println(filePath);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void populateInputProperties() {

        System.out.print("\n\t Enter File path for keys: ");
        String inputFilePath = readString();

        Path inputPath = Paths.get(inputFilePath);

        if (Files.exists(inputPath) && Files.isRegularFile(inputPath)) {

            try {

                List<String> properties = Files.readAllLines(inputPath);
                properties.stream().forEach( property -> property2FileContentMap.put(property, null));

            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private static String readString() {


        String string = "";
        try {
            string = reader.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }

}
