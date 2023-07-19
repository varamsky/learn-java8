package org.example.DefaultAndStaticMethodInInterface;

public class ImplementSimpleInterfaces implements SimpleInterface1, SimpleInterface2{

    @Override // @Override is not required when overriding a method, but the explicit declaration improves code readability
    public void commonMethodInBothSimpleInterfaces() {
        System.out.println("Calling commonMethodInBothSimpleInterfaces()");
    }

    public int getNumberFromInterface(){
        return number;
    }

    public static void main(String[] args) {
        ImplementSimpleInterfaces implementSimpleInterface = new ImplementSimpleInterfaces();

        implementSimpleInterface.commonMethodInBothSimpleInterfaces();
        System.out.println(implementSimpleInterface.getNumberFromInterface());
    }
}
