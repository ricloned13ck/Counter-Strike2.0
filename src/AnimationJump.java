public class AnimationJump extends Thread {


    private CharacterGame characterGame = CharacterGame.getInstance();

    private int y=-1;
    private int highJump = MainWindow.getInstance().j.getHeight()/10;


    @Override
    public void run() {
        int b=0;
        characterGame.flag=false;
        while (true) {
            if (b==highJump)
                y=1;
            else if (b==2*highJump){
                characterGame.flag=true;
                characterGame.setPos(characterGame.getX(), characterGame.getY()-1);
                return;
            }

            int y1 = characterGame.getY() + y;
            characterGame.setPos(characterGame.getX(), y1);
            b++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
