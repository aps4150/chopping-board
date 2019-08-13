import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {

    public static void  main(String args[]) throws Exception
    {
        String keys[] = "breakfast beach citycenter location metro view staff price".split(" ");

        String review = "This hotel has a nice view of the citycenter. The location is perfect.\n" +
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.\n" +
                "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.\n" +
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.\n" +
                "Very friendly staff and good cost-benefit ratio. Its location is a bit far from citycenter.";

        int count = 0;
        review.replaceAll("[,.]", "");

        for (String k: keys)
        {
                    Pattern pattern = Pattern.compile(k);
                    Matcher matcher = pattern.matcher(review.toLowerCase());
                    while (matcher.find()){count++;}
        }

        System.out.println(count);


        review.replaceAll(".", "");
        System.out.println(review);
    }
}
