import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Sentence: Everyone likes trump
 * H(x) = x likes trump
 * Domain: humans
 * Truth set: {"no one"}
 * ∀ x ∈ H, H(x)
 *
 * We left all animals out of the discussion!
 */

public class Assignment {
    public static void main(String[] args) {
        List<Sentient> allDomain = prepareForAllDomain();
        List<Sentient> existDomain = prepareForExistDomain();
        Predicate<Sentient> predicate = preparePredicate();
        boolean resultForAll = forAll(allDomain, predicate);
        boolean resultForAllShouldBeFalse = forAll(existDomain, predicate);
        boolean resultThereExists = thereExists(existDomain, predicate);
        System.out.println("True: " + resultForAll);
        System.out.println("False: " + resultForAllShouldBeFalse);
        System.out.println("True: " + resultThereExists);
    }

    public static List<Sentient> prepareForAllDomain(){
        List<Sentient> allHumans = new ArrayList<>();
        Human trump = new Human("trump");
        for(int i=0; i < 20; i++){
            Human human = new Human("human" + i);
            human.setLikes(trump);
            allHumans.add(human);
        }

        return allHumans;
    };

    public static List<Sentient> prepareForExistDomain(){
        List<Sentient> allHumans = new ArrayList<>();
        Human trump = new Human("trump");
        for(int i=0; i < 20; i++){
            Human human = new Human("human" + i);
            if(i % 2 == 0){
                human.setLikes(trump);
            }
            allHumans.add(human);
        }

        return allHumans;
    };

    public static Predicate<Sentient> preparePredicate(){
        Human trump = new Human("trump");
        return p -> p.likes(trump);
    };
    public static boolean forAll(List<Sentient> humans, Predicate<Sentient> predicate){
        for(Sentient human: humans){
            if(!predicate.test(human)){
                return false;
            }
        }
        return true;
    };
    public static boolean thereExists(List<Sentient> humans, Predicate<Sentient> predicate){
         return humans.stream()
                .anyMatch(predicate);
    }

}
