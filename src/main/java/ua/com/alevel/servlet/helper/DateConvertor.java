package ua.com.alevel.servlet.helper;

public class DateConvertor {
    public String[] dateFormat(String date) {
        String[] sub = new String[3];
        if (date.contains(".")) {
            sub = date.split("\\.");
            return sub;
        } else if (date.contains("-")) {
            sub = date.split("-");
            return sub;
        } else if (date.contains(" ")) {
            sub = date.split(" ");
            return sub;
        }
        return sub;
    }

    public String dateConverting(String[] arrayDate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(arrayDate[0]);
        stringBuilder.append("-");
        stringBuilder.append(arrayDate[1]);
        stringBuilder.append("-");
        stringBuilder.append(arrayDate[2]);
        return stringBuilder.toString();
    }

}
