import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class PropertyWriter {

    static TreeMap<String, String> filePathMap;
    static String FILE_PATH="/Users/I307022/Code/Tetrapak_OFPM/hybris/bin/custom/tetrapak/tetrapakofpmstorefront/web/webroot/WEB-INF/messages/";

    public static void writePropertiesToFiles(HashMap<String, List<KeyJsonPair>> contentEntriesMap) {

        filePathMap = populatePathMap();
        List<KeyJsonPair> localeContentEntries = null;

        for(String localeKey: contentEntriesMap.keySet()) {

            localeContentEntries = contentEntriesMap.get(localeKey);
            writeContentEntriesToFile(localeContentEntries, localeKey);
        }

        //List<KeyJsonPair> englishContent = contentEntriesMap.get("en");
        //writeContentEntriesToFile(englishContent, "en");

    }

    private static void writeContentEntriesToFile(List<KeyJsonPair> localeContentEntries, String localeKey) {
    
        if(localeContentEntries.size()==0)
        {
            return;
        }
        
        String filePath = filePathMap.get(localeKey.toLowerCase());
        if((!filePathMap.containsKey(localeKey.toLowerCase())) || (filePath=="" || filePath.length()==0)) {
        
            System.out.println("ERROR: No filepath found for key "+localeKey.toLowerCase());
            System.out.println("Check file Name: "+"ALERT-base_"+localeKey.toLowerCase()+".properties");
            System.out.println("At path: "+FILE_PATH);
            filePath = FILE_PATH + "ALERT-base_" + localeKey.toLowerCase() + ".properties";
        }
        else {
            filePath = filePathMap.get(localeKey.toLowerCase());
        }

        if(filePath=="" || filePath.length()==0)
        {
            System.out.println("ERROR: No filepath found for key "+localeKey.toLowerCase());
            return;
        }

        String writableContent = "\n";
        for(KeyJsonPair pair : localeContentEntries) {
            writableContent += pair.propertyKey+"="+pair.valueAsJsonOrString+"\n";
        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath, true);
            fileWriter.write(writableContent);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static TreeMap<String,String> populatePathMap() {

        TreeMap<String, String> locale2FilePathMap = new TreeMap<>();

        locale2FilePathMap.put("en", FILE_PATH + "base_en.properties");
        locale2FilePathMap.put("cs", FILE_PATH + "base_cz.properties");
        locale2FilePathMap.put("da", FILE_PATH + "base_da.properties");
        locale2FilePathMap.put("de", FILE_PATH + "base_de.properties");
        locale2FilePathMap.put("es", FILE_PATH + "base_es.properties");
        locale2FilePathMap.put("et", FILE_PATH + "base_et.properties");
        locale2FilePathMap.put("fi", FILE_PATH + "base_fi.properties");
        locale2FilePathMap.put("fr", FILE_PATH + "base_fr.properties");
        locale2FilePathMap.put("hi", FILE_PATH + "base_hi.properties");
        locale2FilePathMap.put("hr", FILE_PATH + "base_hr.properties");
        locale2FilePathMap.put("hu", FILE_PATH + "base_hu.properties");
        locale2FilePathMap.put("id", FILE_PATH + "base_id.properties");
        locale2FilePathMap.put("it", FILE_PATH + "base_it.properties");
        locale2FilePathMap.put("ja", FILE_PATH + "base_ja.properties");
        locale2FilePathMap.put("ko", FILE_PATH + "base_ko.properties");
        locale2FilePathMap.put("lt", FILE_PATH + "base_lt.properties");
        locale2FilePathMap.put("lv", FILE_PATH + "base_lv.properties");
        locale2FilePathMap.put("nl", FILE_PATH + "base_nl.properties");
        locale2FilePathMap.put("no", FILE_PATH + "base_no.properties");
        locale2FilePathMap.put("pl", FILE_PATH + "base_pl.properties");
        locale2FilePathMap.put("pt", FILE_PATH + "base_pt.properties");
        locale2FilePathMap.put("ru", FILE_PATH + "base_ru.properties");
        locale2FilePathMap.put("sh", FILE_PATH + "base_sh.properties");
        locale2FilePathMap.put("sk", FILE_PATH + "base_sk.properties");
        locale2FilePathMap.put("sl", FILE_PATH + "base_sl.properties");
        locale2FilePathMap.put("sv", FILE_PATH + "base_sv.properties");
        locale2FilePathMap.put("tr", FILE_PATH + "base_tr.properties");
        locale2FilePathMap.put("uk", FILE_PATH + "base_uk.properties");
        locale2FilePathMap.put("es-co", FILE_PATH + "base_es_CO.properties");
        locale2FilePathMap.put("zh-tw", FILE_PATH + "base_zh_TW.properties");
        locale2FilePathMap.put("zh", FILE_PATH + "base_zh.properties");

        return locale2FilePathMap;
    }

}
