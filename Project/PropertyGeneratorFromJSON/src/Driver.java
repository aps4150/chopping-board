import java.util.HashMap;
import java.util.List;

public class Driver {

    public static void main(String args[])
    {
        HashMap<String, List<KeyJsonPair>> locale2localeLineEntriesMap = PropertyAggregatorAndMapper.getMappedData();

        PropertyWriter.writePropertiesToFiles(locale2localeLineEntriesMap);

        //printMap(locale2localeLineEntriesMap);
    }

    private static void printMap(HashMap<String, List<KeyJsonPair>> locale2localeLineEntriesMap) {
        locale2localeLineEntriesMap.keySet().stream().forEach(k->{

            System.out.println(k);
            locale2localeLineEntriesMap.get(k).stream().forEach(pair->System.out.println(pair.propertyKey+"="+pair.valueAsJsonOrString));
            System.out.println("\n");
        });
    }
}
