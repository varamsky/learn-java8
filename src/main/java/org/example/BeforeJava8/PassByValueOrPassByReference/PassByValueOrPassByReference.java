package org.example.BeforeJava8.PassByValueOrPassByReference;

import java.util.Arrays;
public class PassByValueOrPassByReference {
    /**
     * In java, everything is PASS-BY-VALUE
     *
     * So, when calling a method
     *
     * For primitive arguments (int, long, etc.), the pass by value is the ACTUAL VALUE of the primitive (for example, 3).
     * For objects, the pass by value is the VALUE OF THE REFERENCE to the object.
     *
     * Read about it in [this](https://stackoverflow.com/a/73021/8352695) StackOverflow answer and [this](https://stackoverflow.com/a/12429953/8352695) one below it.
     */
    int number = 10;
    public static void main(String[] args) {
        PassByValueOrPassByReference obj = new PassByValueOrPassByReference();
        /**
         * Commented these out because we don't see any change with primitive types
         */
        // int i = 5;
        // System.out.println("i = " + i);
        // obj.changeInt(i);
        // System.out.println("i = " + i);
        // String s = "abc";
        // System.out.println("s = " + s);
        // obj.changeString(s);
        // System.out.println("s = " + s);
        int[] arr = new int[]{1,2,3};
        System.out.println("raw arr = " + Arrays.toString(arr));
        changeArray(arr);
        System.out.println("after change arr = " + Arrays.toString(arr));
        modifyArray(arr);
        System.out.println("after modify arr = " + Arrays.toString(arr));

        System.out.println("\n\nraw obj = " + obj.toString());
        changeObject(obj);
        System.out.println("\nafter change obj = " + obj.toString());
        modifyObject(obj);
        System.out.println("\nafter modify obj = " + obj.toString());
    }

    static void changeObject(PassByValueOrPassByReference object){
        object = new PassByValueOrPassByReference();
        object.number = 5;
        System.out.println("In change " + object.toString());
    }

    static void modifyObject(PassByValueOrPassByReference object){
        object.number = 5;
        System.out.println("In modify " + object.toString());
    }

    static void changeArray(int[] arr){
        arr = new int[]{4,5,6};
        System.out.println("In change " + Arrays.toString(arr));
    }

    static void modifyArray(int[] arr){
        arr[0] = 5;
        System.out.println("In modify " + Arrays.toString(arr));
    }

    void changeInt(int n){
        n = 1;
        System.out.println("n = " + n);
    }

    void changeString(String a){
        a = "aaaa";
        System.out.println("a = " + a);
    }

    @Override
    public String toString(){
        return "Object = " +
                getClass().getName() + "@" + Integer.toHexString(hashCode())+
                "\nnumber = " + number;
    }
}