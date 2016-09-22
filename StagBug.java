import javax.swing.JFrame; // for JFrame
import javax.swing.ImageIcon; // for ImageIcon


class StagBug extends Bug {
    public StagBug(JFrame myJFrame, int hitsNeeded, int directionChangeProbability){
        super(myJFrame, hitsNeeded, directionChangeProbability);//call Bug constructor
        // set up images for fast bug
        bugImageName[UP]="StagBugUp.jpg";
        bugImageName[DOWN]="StagBugDown.jpg";
        bugImageName[LEFT]="StagBugLeft.jpg";
        bugImageName[RIGHT]="StagBugRight.jpg";

      for (int i = UP; i <= RIGHT; i++){
            bugImage[i] = new ImageIcon (bugImageName[i]);
        }
        
        // movement is arbitrarily based on size of image
        horizontalMovement = bugImage[RIGHT].getIconWidth()/ 5; // arbitrary 1/5th of width
        verticalMovement = bugImage[UP].getIconHeight()/ 5; // arbitrary 1/5th of height;       
    }
    
    public void move(){
        // change direction?
        if (Math.random()*100 < directionChangeProbability) // Math.random gives 0 to .9999
            bugDirection = (int) Math.floor(Math.random()*NUMBER_OF_DIRECTIONS); 
        
        if (bugDirection == LEFT)
            xPosition -= horizontalMovement;
        else if (bugDirection == RIGHT)
            xPosition += horizontalMovement;            
        else if (bugDirection == UP)
            yPosition -= verticalMovement;
        else if (bugDirection == DOWN)
            yPosition += verticalMovement;
 
        drawBug();          
        
        //if hit edge of window, then wrap around to the other side immediately
        if (bugDirection == UP && atTopEdge()){
            eraseBug();
            yPosition = bugJFrame.getContentPane().getHeight()-bugImage[UP].getIconHeight();
            drawBug();
        }
        else if (bugDirection == DOWN && atBottomEdge()) {
            eraseBug();
            yPosition = 0;
            drawBug();
        }
        else if (bugDirection == LEFT && atLeftEdge()){
            eraseBug();
            xPosition = bugJFrame.getContentPane().getWidth()-bugImage[LEFT].getIconWidth();
            drawBug();
        }
        else if (bugDirection == RIGHT && atRightEdge()){
            eraseBug();
            xPosition = 0;
            drawBug();
        }
    }
}
