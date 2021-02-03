package observer.pattern;

import Model.Subject;

public class CasesObserver extends Observer {
    public CasesObserver(Subject subject){
        this.subject = subject;
        this.subject.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Lower case :" + countLowercase());
        System.out.println("Upper case :" + countUppercase());
    }

    private Long countLowercase(){
        String state = subject.getState();
        /*int count = 0;
        for(int i=0;i< state.length();i++){
            if(Character.isLowerCase(state.charAt(i))){
                count++;
            }
        }*/
        return state.chars().filter((character)->Character.isLowerCase(character)).count();
    }

    private Long countUppercase(){
        String state = subject.getState();
        /*int count = 0;
        for(int i=0;i< state.length();i++){
            if(Character.isUpperCase(state.charAt(i))){
                count++;
            }
        }*/

        return state.chars().filter((character)->Character.isUpperCase(character)).count();
    }
}
