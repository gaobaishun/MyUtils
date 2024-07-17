package stringutils;


public class StringToOtherUtil{

    enum DataTypeEnum{
        CHARACTER(Character.class),
        INTEGER(Integer.class);

        private final Class clazz;
        DataTypeEnum(Class clazz){
            this.clazz=clazz;
        }

    }
    public static String LeetCodeStringArrayToJavaArray(String stringArray){
        return stringArray.replace('[', '{').replace(']', '}');
    }
    public static String LeetCodeStringArrayToJavaArray(String stringArray,DataTypeEnum dataTypeEnum){

        String s=LeetCodeStringArrayToJavaArray(stringArray);
        return switch (dataTypeEnum){
            case CHARACTER ->s.replaceAll("\"","'");

            case INTEGER -> "Integer";
//            default -> "default";
        };
    }

    public static void main(String[] args) {
        String s="[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]";
        System.out.println(LeetCodeStringArrayToJavaArray(s));
        System.out.println(LeetCodeStringArrayToJavaArray(s,DataTypeEnum.CHARACTER));
    }
}
