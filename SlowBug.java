import javax.swing.JFrame; // for JFrame
import javax.swing.ImageIcon; // for ImageIcon

class SlowBug extends Bug {
    public SlowBug(JFrame myJFrame, int hitsNeeded, int directionChangeProbability){
        super(myJFrame, hitsNeeded, directionChangeProbability);//call Bug constructor
        // set up images for slow bug
        bugImageName[UP]="slowBugUp.jpg";
        bugImageName[DOWN]="slowBugDown.jpg";
        bugImageName[LEFT]="slowBugLeft.jpg";
        bugImageName[RIGHT]="slowBugRight.jpg";

        for (int i = UP; i <= RIGHT; i++){// up =0, right = 3
            bugImage[i] = new ImageIcon (bugImageName[i]);
        }
        
        // movement is arbitrarily based on size of image
        horizontalMovement = bugImage[RIGHT].getIconWidth()/ 10; // arbitrary 1/10th of width
        verticalMovement = bugImage[UP].getIconHeight()/ 10; // arbitrary 1/10th of height;     
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
        
        //hit edge of window and need to turn around?
        if (bugDirection == UP && atTopEdge()){
            bugDirection = DOWN;    
        }
        else if (bugDirection == DOWN && atBottomEdge()){
            bugDirection = UP;  
        }
        else if (bugDirection == LEFT && atLeftEdge()){
            bugDirection = RIGHT;   
        }
        else if (bugDirection == RIGHT && atRightEdge()){
            bugDirection = LEFT;    
        }
    }
}

