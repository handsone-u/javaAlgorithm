package string;

public class Sol72410 {
    public String level1(String str) {
        return str.toLowerCase();
    }

    public String level2(String str) {
        return str.replaceAll("[^-_.a-z0-9]", "");
    }

    public String level3(String str) {
        while (str.contains("..")) str = str.replace("..", ".");
        return str;
    }

    public String level4(String str) {
        if(str.startsWith(".")) str = str.substring(1);
        if(str.endsWith(".")) str = str.substring(0, str.length() - 1);
        return str;
    }

    public String level5(String str) {
        if (str.length() < 1) return "a";
        else return str;
    }

    public String level6(String str) {
        if(str.length()>=16) str = str.substring(0, 15);
        return level4(str);
    }

    public String level7(String str) {
        while (str.length()<=2) str = str + str.charAt(str.length() - 1);
        return str;
    }

    public String solution(String new_id) {
        new_id = level1(new_id);
        new_id = level2(new_id);
        new_id = level3(new_id);
        new_id = level4(new_id);
        new_id = level5(new_id);
        new_id = level6(new_id);
        new_id = level7(new_id);
        return new_id;
    }
}
