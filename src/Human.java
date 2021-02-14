import java.util.ArrayList;
import java.util.List;

public class Human implements Sentient{
    private final String identity;
    private final List<Sentient> likes;

    public Human(String identity) {
        this.identity = identity;
        this.likes = new ArrayList<>();
    }

    @Override
    public boolean likes(Sentient other) {
        return this.likes.contains(other);
    }

    @Override
    public void setLikes(Sentient other) {
        this.likes.add(other);
    }

    @Override
    public String getIdentity() {
        return this.identity;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass().equals(this.getClass())){
            Human human = (Human) obj;

            return this.identity.equals(human.getIdentity());
        }

        return false;
    }
}
