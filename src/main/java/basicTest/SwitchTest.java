package basicTest;

public class SwitchTest {



    public static void switchTestNoBreak(int param){
        //没有break，会按顺序依次执行
        switch (param) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
        }
    }

    public static void switchTest(int param){
        //有break，会按顺序依次执行,直到遇到break
        switch (param) {
            case 1:
                System.out.println("1");

            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");

        }
    }

    public static void switchTestHaveDefault(int param){
        //有break会直接跳到default结束处，不执行default
        //没有break会直接一路运行直到执行结束
        switch (param) {
            case 1:
                System.out.println("1");

            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
            default:
                System.out.println("default");
        }
    }

    public static int swithcTestHaveDefault2(int param){
        //jdk 17 特性，注意这边不会存在穿透，比如，当param为3时，不会执行default
        switch (param){
            case 1-> {
                System.out.println("print 1");
                return 1;
            }
            case 2-> {
                System.out.println("print 2");
                return 2;
            }
            case 3 ->
                System.out.println("print 3");

            default -> {
                System.out.println("print default");
                return -2;
            }
        }
        return -1;
    }
    public static int swithcTestHaveDefault3(int param){
        switch (param){
            case 1:
                System.out.println("print 1");
                return 1;

            case 2:
                System.out.println("print 2");
                return 2;

            case 3 :
                System.out.println("print 3");


            default :
                System.out.println("print default");
                return -2;

        }
    }

    public static void main(String[] args) {
        //switchTestNoBreak(1);
        //switchTest(1);
        //switchTestHaveDefault(3);
        System.out.println(swithcTestHaveDefault2(2));
    }
}
