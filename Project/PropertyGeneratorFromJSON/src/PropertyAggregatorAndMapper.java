import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PropertyAggregatorAndMapper {

    public static HashMap<String, List<KeyJsonPair>> getMappedData() {

        List<KeyJsonPair> inputDataList = PropertyAggregatorAndMapper.getInputDataAsList_Console();
        HashMap<String, List<KeyJsonPair>> locale2localeLineEntriesMap = new HashMap<>();
        getInputDataAsMap(inputDataList, locale2localeLineEntriesMap);

        populateDuplicateEntries(locale2localeLineEntriesMap);

        return locale2localeLineEntriesMap;
    }

    private static void populateDuplicateEntries(HashMap<String,List<KeyJsonPair>> property2JsonMap) {

        List<KeyJsonPair> es_Properties = property2JsonMap.get("es");
        if(null != es_Properties){
            property2JsonMap.put("es-co", es_Properties);
        }

        List<KeyJsonPair> hr_Properties = property2JsonMap.get("hr");
        if(null != hr_Properties){
            property2JsonMap.put("sh", hr_Properties);
        }
    }

    private static List<KeyJsonPair> getInputDataAsList_Console() throws IOException {

        List<KeyJsonPair> list = new ArrayList<>();

        String key = "";
        String json = "";
        int i = 1;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nPress \u21b5 for Key or Value to complete input.");
        while(true) {

            System.out.println("\n\t"+i++ + ".\tKey | Value:");

            try {
                System.out.print("\tKey:\t");
                key = reader.readLine();

                System.out.print("\tValue:\t");
                json = reader.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (reader != null)
                    reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            if(key.length()==0 || json.length()==0)
            { break; }

            KeyJsonPair pair = new KeyJsonPair(key, json);
            list.add(pair);
        }

        return list;

    }
    private static List<KeyJsonPair> getInputDataAsList() {

        /**
         * This method may call method of other Class:
         *  for reading data from file and generating in below format.
         *
         *  OUTPUT FORMAT: List of {@KeyJsonPair}
         *  i.e. [<key, JSON>, <key, JSON>, <key, JSON>, ...]
         */

        String key1 = "basket.page.OrderSummarys.pricetext";
        String json1 = "[{\"locale\":\"de\",\"country\":\"German\",\"string\":\"Die Preise für Bündelprodukte sind unter Verpackungsmaterial angegeben.\"},{\"locale\":\"en\",\"country\":\"English\",\"string\":\"Prices for bundle products are shown under packaging material.\"},{\"locale\":\"es\",\"country\":\"Spanish\",\"string\":\"Los precios de los productos combinados se muestran en el material de embalaje.\"},{\"locale\":\"fr\",\"country\":\"French\",\"string\":\"Les prix des produits groupés sont indiqués sous le matériel d’emballage\"},{\"locale\":\"hi\",\"country\":\"Hindi\",\"string\":\"बंडल उत्पादों के लिए कीमतों को पैकेजिंग सामग्री के तहत दिखाया गया है।\"},{\"locale\":\"zh-TW\",\"country\":\"Chinese (Traditional)\",\"string\":\"捆綁產品的價格顯示在包裝材料下。\"}]";
        KeyJsonPair inputData1 = new KeyJsonPair(key1, json1);

        String key2 = "report.orderdetail.price.text";
        String json2 = "[{\"locale\":\"en\",\"country\":\"English\",\"string\":\"Indicated prices are specific for the product. Additional prices details can be find in the Order Acknowledgment.\"},{\"locale\":\"fr\",\"country\":\"French\",\"string\":\"Les prix indiqués sont spécifiques au produit. Des informations supplémentaires sur les prix sont disponibles dans la confirmation de commande.\"},{\"locale\":\"hi\",\"country\":\"Hindi\",\"string\":\"उत्पाद के लिए संकेतित मूल्य विशिष्ट हैं। अतिरिक्त मूल्य विवरण ऑर्डर पावती में पाया जा सकता है।\"},{\"locale\":\"ja\",\"country\":\"Japanese\",\"string\":\"表示価格は製品に固有のものです。追加の価格の詳細は注文確認書に記載されています。\"},{\"locale\":\"pt\",\"country\":\"Portuguese\",\"string\":\"Os preços indicados são específicos para o produto. Detalhes adicionais de preços podem ser encontrados no Reconhecimento da Ordem.\"},{\"locale\":\"ru\",\"country\":\"Russian\",\"string\":\"Указанные цены являются специфическими для продукта. Дополнительную информацию о ценах можно найти в подтверждении заказа.\"},{\"locale\":\"zh-CN\",\"country\":\"Chinese (Simplified)\",\"string\":\"指示价格是产品的特定价格。其他价格详细信息可在订单确认中找到。\"}]";
        KeyJsonPair inputData2 = new KeyJsonPair(key2, json2);


        List<KeyJsonPair> list = new ArrayList<>();
        list.add(inputData1);
        list.add(inputData2);

        return list;
    }

    private static void getInputDataAsMap(List<KeyJsonPair> inputDataList, HashMap<String, List<KeyJsonPair>> property2JsonMap) {

        for(KeyJsonPair pair: inputDataList)
        {
            populateMapFromJSON(property2JsonMap, pair);
        }
    }

    private static void populateMapFromJSON(HashMap<String, List<KeyJsonPair>> map, KeyJsonPair KeyJsonPair) {

        /**
         *         JSON -> List<Language - Value Object>
         *         Add List values to Map < languageCode, List<KeyJsonPair(property, value in languageCode) >>
         */
        String property = KeyJsonPair.propertyKey;
        String json = KeyJsonPair.valueAsJsonOrString;

        List<LocalizedObject> valuesForALlLanguages = getLocalizedObjectsFromJson(json);

        for(LocalizedObject obj: valuesForALlLanguages) {

            List<KeyJsonPair> localeLineEntries = map.get(obj.locale);
            if(null == localeLineEntries) {
                localeLineEntries = new ArrayList<>();
            }

            localeLineEntries.add(new KeyJsonPair(property, obj.string));
            map.put(obj.locale, localeLineEntries);
        }
    }

    private static List<LocalizedObject> getLocalizedObjectsFromJson(String json) {

        ObjectMapper mapper = new ObjectMapper();
        LocalizedObject[] jsonObject = null;

        try {
            jsonObject = mapper.readValue(json, LocalizedObject[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Arrays.asList(jsonObject);
    }
}
