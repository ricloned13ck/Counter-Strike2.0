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
            if (characterGame.getX()<=0){
                characterGame.setPos(1, characterGame.getY());
            }
            else if (characterGame.getX()>=MainWindow.getInstance().j.getWidth() - CharacterGame.getInstance().character.getWidth(null)){
                characterGame.setPos(MainWindow.getInstance().j.getWidth()- CharacterGame.getInstance().character.getWidth(null), characterGame.getY());
            }
            else{
                characterGame.setPos(x1, characterGame.getY());
            }
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
