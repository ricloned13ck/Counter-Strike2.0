public class AnimationWalk extends Thread {
    private static AnimationWalk instance = null;

    public static AnimationWalk getInstance() {
        if (instance == null)
            instance = new AnimationWalk();
        return instance;
    }
    private CharacterGame characterGame = CharacterGame.getInstance();

    private int x;

    @Override
    public void run() {
        while (true) {
            int x1 = characterGame.getX()+x;
            characterGame.setPos(x1, characterGame.getY());
            MainWindow.getInstance().j.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

}
