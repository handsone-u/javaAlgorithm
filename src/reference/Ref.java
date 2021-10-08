package reference;

public class Ref {
    static class Member {
        private String name;
        private int num;

        @Override
        public String toString() {
            return "Member{" +
                    "name='" + name + '\'' +
                    ", num=" + num +
                    '}';
        }

        public Member(String name, int num) {
            this.name = name;
            this.num = num;
        }
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Member son = new Member("Son", 1);
        Member kim = new Member("Kim", 2);
        String original = new String("original");

        System.out.println("son.hashCode() = " + son.hashCode());
        settingNums(son);
        settingNums(kim);
        System.out.println("original.hashCode() = " + original.hashCode());
        settingString(original);

        System.out.println("son = " + son);
        System.out.println("kim = " + kim);
        System.out.println("original = " + original);
    }

    static void settingNums(Member tmp) {
        System.out.println("tmp.hashCode() = " + tmp.hashCode());
        tmp.setNum(tmp.getNum() + 1);
    }

    static void settingString(String tmp) {
        System.out.println("tmp.hashCode() = " + tmp.hashCode());
        tmp = "new String!";
    }
}
