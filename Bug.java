import javax.swing.JFrame; // for JFrame
import javax.swing.JLabel; // for JLabel
import javax.swing.ImageIcon; // for ImageIcon

class Bug {
     //----------------------------------------
     //     Data members
    //--------------------------------------
    public final static int UP = 0;
    public final static int DOWN = 1;
    public final static int LEFT = 2;
    public final static int RIGHT = 3;
    public final static int NUMBER_OF_DIRECTIONS = 4;
    protected JFrame bugJFrame;
    protected JLabel bugJLabel; // the container for the Image (of a bug)
    
    protected String bugImageName[] = new String[NUMBER_OF_DIRECTIONS];
    protected ImageIcon bugImage[] = new ImageIcon[NUMBER_OF_DIRECTIONS];
    protected int horizontalMovement;
    protected int verticalMovement;
    protected int hitsTaken;
    protected int hitsRequired;
    protected int directionChangeProbability;
    protected int bugDirection=UP;
    protected int xPosition=0;  // top left corner of Image
    protected int yPosition=0;  // top left corner of Image
    
    protected void drawBug(){ 
        bugJLabel.setIcon(bugImage[bugDirection]);
        bugJLabel.setBounds(xPosition,yPosition,bugImage[bugDirection].getIconWidth(),bugImage[bugDirection].getIconHeight());  
       bugJLabel.setVisible(true);
    }

    protected void eraseBug(){
        bugJLabel.setVisible(false);
    }   
    
    protected boolean atRightEdge(){
        return (xPosition+bugJLabel.getWidth()+horizontalMovement > bugJFrame.getContentPane().getWidth());
    }
    
    protected boolean atLeftEdge(){
        return (xPosition - horizontalMovement < 0); // horizontalMovement variable is alway positive
    }
    
    protected boolean atTopEdge(){
        return (yPosition - verticalMovement < 0); // vertical Movement variable is always positive 
    }
    
    protected boolean atBottomEdge(){
        return (yPosition+bugJLabel.getHeight()+verticalMovement > bugJFrame.getContentPane().getHeight());
    }
    
    //---------------------------------
    //  Public Methods
    //---------------------------------
    //constructor:
    public Bug(JFrame passedInJFrame, int passedInHitsRequired, int passedInDirectionChangeProbability){
        bugJFrame = passedInJFrame;
        hitsRequired = passedInHitsRequired;
        directionChangeProbability = passedInDirectionChangeProbability;

        bugJLabel = new JLabel();
        bugJLabel.setBounds (10, 10, 10, 10); // arbitrary, will change later
        bugJFrame.getContentPane().add(bugJLabel);
        bugJLabel.setVisible(false);
        bugJLabel.setVisible(true);

        horizontalMovement = 0;
        verticalMovement = 0;
        hitsTaken = 0;
        bugDirection = UP;
        xPosition = 20; // arbitrary starting point
        yPosition = 20; // arbitrary starting point        
    }
   
    public boolean isBugHit(int xMousePosition, int yMousePosition){
        if ((xPosition <= xMousePosition 
            && xMousePosition <= xPosition + bugImage[bugDirection].getIconWidth())
            && (yPosition <= yMousePosition 
            && yMousePosition <= yPosition + bugImage[bugDirection].getIconHeight())){
                return true;
        }
        else {
            return false;
        }
    }
    
   public void gotHit(){
      hitsTaken++; 
    }
     
    public boolean isDying(){
        return hitsTaken >= hitsRequired;
    }
    
    public void create(){   
        hitsTaken = 0;
        drawBug();
    }
    
    public void kill(){
        eraseBug();
    }
    
    public void move(){
    }

}
