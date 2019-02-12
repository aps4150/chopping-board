package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {


    private BufferedReader READER;

    public InputUtils() {
        READER = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readString(String inputMessage) throws IOException {

        System.out.print(inputMessage);

        String result = READER.readLine();
        return  result;
    }

    public void close() throws IOException {
        READER.close();
    }

    public static String readSingleString(String inputMessage)throws IOException {

        InputUtils inputUtils = new InputUtils();

        String result = inputUtils.readString(inputMessage);
        inputUtils.close();

        return result;
    }

    public static int[] readIntegArray(String inputMessage) throws IOException {

        InputUtils inputUtils = new InputUtils();

        System.out.print("Enter Size: ");
        int size = Integer.parseInt(inputUtils.READER.readLine());

        int[] result = new int[size];

        System.out.print(inputMessage+"\n");
        for (int i = 0; i < size; i++) {
            System.out.print("\tArray["+i+"]: ");
            result[i] = Integer.parseInt(inputUtils.READER.readLine());
        }

        inputUtils.close();
        return  result;
    }


}
