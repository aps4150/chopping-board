import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Executor2 {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> inputPropertiesSet = new LinkedHashSet<>();
    static HashMap<String, HashMap<String, String>> locale2FileContentMap = new LinkedHashMap();

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

        //System.out.println("\n\n\n\n");
        //printOnlyNullFileValKeys();
    }

    private static void printOnlyNullFileValKeys() {

        System.out.println("Null values:");

        locale2FileContentMap.entrySet().stream().forEach(es ->{

            HashMap<String, String> esVal = es.getValue();
            if(null == esVal) {
                System.out.println("\n@ " + es.getKey()+"\n");
            }
            if(null != esVal){
                int c=0;
                for( Map.Entry<String, String> x : esVal.entrySet().stream().filter(i->null == i.getValue()).collect(Collectors.toList())) {
                    if(c++==0)
                    {
                        System.out.println("\n@ " + es.getKey()+"\n");
                    }
                    System.out.println("\t"+x.getKey());
                }
            }
        });
    }

    private static void printIt() {

        locale2FileContentMap.entrySet().stream().forEach(es ->{

            System.out.println("\n\n......................................................................................");
            System.out.println("\n"+es.getKey()+"\n");

            HashMap<String, String> esVal = es.getValue();

            if(null != esVal){
                esVal.entrySet().stream().forEach(esv ->{

                    String v = (null == esv.getValue())
                    ?" -- null --   "
                    :esv.getValue();

                    System.out.println(fixKey(esv.getKey()) + "\t|\t " +v);

                });
            }
            else {
                System.out.println( "< NULL >");
            }


        });

    }

    private static String fixKey(String key) {
        String[] k = key.split("\\.");

        String res = "";
        if(k.length>0)res=res+k[k.length-1];
        if(k.length>1)res=k[k.length-2]+"."+res;
        res="................."+res;

        return res.substring(res.length()-15,res.length());
    }

    private static void populateMapWithFileContent(Path filePath, HashMap<String, String> fileContent_Key2ValueMap) {

        String fileName = filePath.getFileName().toString();

        HashMap<String, String> file2PropertyValueMap = locale2FileContentMap.get(fileName);
        if(null == file2PropertyValueMap) {
            file2PropertyValueMap = new LinkedHashMap<>();
        }

        for(String key: inputPropertiesSet) {

            String value = fileContent_Key2ValueMap.get(key);

            if(null != value && value.length() != 0) {
                file2PropertyValueMap.put(key, value);
            }
            else {
                file2PropertyValueMap.put(key, null);
            }
        }
        locale2FileContentMap.put(fileName, file2PropertyValueMap);
    }

    private static void parseFile(Path filePath) throws IOException{

        //System.out.println("......................................................................................");
        //System.out.println("Starting file processing: "+filePath);
        //System.out.println("......................................................................................");

        HashMap<String, String> fileContent_Key2ValueMap = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(filePath);

        lines.stream().forEach(line -> {

            String[] lineArray = line.split("=");
            String key = "";
            String value = "";

            if(lineArray.length > 0) { key = lineArray[0]; }

            if(lineArray.length > 1) { value = lineArray[1]; }

            if(key.length()!=0) { fileContent_Key2ValueMap.put(key, value); }
        });

        populateMapWithFileContent(filePath, fileContent_Key2ValueMap);

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
                properties.stream().forEach( property -> inputPropertiesSet.add(property));

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
