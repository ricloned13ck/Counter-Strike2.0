public class AnimationJump extends Thread {


    private CharacterGame characterGame = CharacterGame.getInstance();

    private int y = -4;
    private int highJump = MainWindow.getInstance().j.getHeight() / 5;
    private int b1 = 4;

    @Override
    public void run() {
        int b = 0;
        characterGame.flag = false;
        while (true) {
            if (b == (int) highJump / 4 - 2) {
                y = -2;
                b1 = 2;
            } else if (b == (int) highJump / 2) {
                y = -1;
                b1 = 1;
            } else if (b == highJump) {
                y = 1;
                b1 = 1;
            } else if (b == (int) (highJump + highJump / 4)) {
                y = 2;
                b1 = 2;
            } else if (b == (int) (highJump + highJump / 2)) {
                y = 4;
                b1 = 4;
            }

            if (b >= 2 * highJump) {
                characterGame.flag = true;
                characterGame.setPos(characterGame.getX(), MainWindow.getInstance().j.getHeight() - 150);
                return;
            }
            b += b1;

            int y1 = characterGame.getY() + y;
            characterGame.setPos(characterGame.getX(), y1);
            if (b1==4 || b1==-4){
                try {
                    Thread.sleep(4);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (b1==2 || b1==-2){
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (b1==1 || b1==-1){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

}
