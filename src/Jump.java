public class Jump extends Thread {


    private CharacterGame characterGame = CharacterGame.getInstance();

    private int y = -1;
    private int highJump = MainWindow.getInstance().j.getHeight() / 5;

    @Override
    public void run() {
        int b = 0;
        MainWindow.getInstance().isJump =true;
        while (true) {
            MainWindow.getInstance().isIdle=false;
            MainWindow.getInstance().isWalk=false;
//            if (b == (int) highJump / 4 - 2) {
//                y = -2;
//                b1 = 2;
//            } else if (b == (int) highJump / 2) {
//                y = -1;
//                b1 = 1;
//            } else if (b == highJump) {
//                y = 1;
//                b1 = 1;
//            } else if (b == (int) (highJump + highJump / 4)) {
//                y = 2;
//                b1 = 2;
//            } else if (b == (int) (highJump + highJump / 2)) {
//                y = 4;
//                b1 = 4;
//            }
            if (b==highJump){
                y=1;
            }
            if (b >= 2 * highJump) {
                characterGame.setPos(characterGame.getX(), MainWindow.getInstance().j.getHeight()-CharacterGame.getInstance().character.getHeight(null)*2 - 70);
                if (Walk.getInstance().x!=0){
                    MainWindow.getInstance().isIdle=false;
                    MainWindow.getInstance().isWalk=true;
                }
                else{
                    MainWindow.getInstance().isIdle=true;
                    MainWindow.getInstance().isWalk=false;
                }

                MainWindow.getInstance().isJump =false;
                return;
            }
            b += 1;

            int y1 = characterGame.getY() + y;
            characterGame.setPos(characterGame.getX(), y1);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

}
