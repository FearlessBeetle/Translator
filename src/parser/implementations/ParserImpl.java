package src.parser.implementations;

import src.parser.api.ParserService;
import src.tokens.Tokens;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParserImpl implements ParserService
{
    @Override
    public ArrayList<String> parseArrList(ArrayList<String> arrayList)
    {
        ArrayList<String> resultArrList = new ArrayList<>();
        String patternString = "\\s+";
        String replacementString = "©";
        Pattern pattern = Pattern.compile(patternString);
        StringBuilder stringBuilder = new StringBuilder();
        Matcher matcher;

        for (String token : arrayList) {
            matcher = pattern.matcher(token);
            String modifiedString = matcher.replaceAll(replacementString);
            stringBuilder.append(modifiedString);
            if (!token.contains(";")) {
                continue;
            }
            if (!token.contains("©;")) {  // Добавляем пробел чтобы отделить токен ';' от предыдущего
                stringBuilder.replace(
                        stringBuilder.length(),
                        stringBuilder.length(),
                        "©;");
            }
            resultArrList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return resultArrList;
    }

    @Override
    public String[][] parseToTokens(ArrayList<String> listOfTokens) {
        String[][] resultTokenArrays = new String[listOfTokens.size()][];
        for (String tokens : listOfTokens) {
            String[] tempArr = tokens.split("©");
            for (String token : tempArr) {

            }
        }
        return resultTokenArrays;
    }

//    private Tokens[] defineToken(String tokenString) {
//        switch (tokenString){
//            case ""
//
//        }
//    }
}
