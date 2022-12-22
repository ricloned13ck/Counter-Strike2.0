package controller.observers;

public class CharacterEvent {
    private final float x;
    private final float y;

    public CharacterEvent(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
