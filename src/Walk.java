public class Walk extends Thread {
    private static Walk instance = null;

    public static Walk getInstance() {
        if (instance == null)
            instance = new Walk();
        return instance;
    }

    private CharacterGame characterGame = CharacterGame.getInstance();

    public int x;

    @Override
    public void run() {
        while (true) {
            int x1 = characterGame.getX() + x;
            characterGame.setPos(x1, characterGame.getY());
            try {
                Thread.sleep(7);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

}
