 
package villaincarnage;


import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

public class VillainCarnage {

    
    private UserView view;
    private int level;
    private GameLevel world;
    private Controller controller;
    private LavaControl lavaControl;
    private LavaControl lavaControl2;
    private JFrame frame;
    private SoundClip gameMusic;
    private boolean mute = false; 
     
    
    
    
    
     
    
    public VillainCarnage(){
        
          
     
    level = 1;
        world = new Level1();
        world.populate(this );
     // Intitiate game with new world as level 1 and populate the level
          
         
         JFrame debugView = new DebugViewer(world, 500, 500);
         
        view = new MyView(world, world.getVillain(), 1000, 700);
       // view.setGridResolution(1.0f);
          
            frame = new JFrame("City");
            frame.setFocusable(true);
            
             Container buttons = new ControlPanel(this);
             buttons.setFocusable(false);
              frame.add(buttons, BorderLayout.WEST);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationByPlatform(true);
            frame.add(view);
            view.addMouseListener(new GiveFocus(frame));
        
          controller = new Controller(world.getVillain());
          lavaControl = new LavaControl(world.getLava());
          lavaControl2  = new LavaControl(world.getLava2());
          
        frame.addKeyListener(controller);
        frame.addKeyListener(lavaControl);
        frame.addKeyListener(lavaControl2 );
        
        // Initialises new controllers for villain, and lava objects in the current world and 
        // associates the appropriate key listener class to the objects
        
         try{
            gameMusic = new SoundClip("data/backgroundmusic1.wav");
            gameMusic.play();
            
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }
         // Sets the background muscic SoundClip for level 1
       
                frame.setResizable(true); 
                frame.pack();
                frame.setVisible(true);
                 
              
        world.start();
        
    }
    public static void main(String[] args) {
        new VillainCarnage();
         

    }
    
    public Villain getVillain(){
        return world.getVillain();
    }
    public Controller getController(){
        return controller;
    }
    public void goNextLevel() {
        
              
         gameMusic.stop();
          
                world.stop();
        if (level == 4) {
            System.exit(0);
            // If current level is 4 and goNextLevel method is called the game will exit as there is no next level
        } else if (level == 1) {
            level = level +1;
            // get a new world
            world = new Level2();
                       try{
            gameMusic = new SoundClip("data/backgroundmusic2.wav");
            // Change background music to music for level 2
            gameMusic.play();
            // If current level is 1 the game will proceed to level 2 and background music soundclip
            // will change to the soundclip appropriate for this level 
            
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }
                     
            // fill it with bodies
            world.populate(this );
            UserView view2 = new MyView2(world, world.getVillain(), 1000, 500);
             frame.remove(view);
              
             view = view2;
            
             frame.add(view);
             
         
             frame.pack();
             frame.setVisible(true);
             
            // switch the keyboard control to the new player
            controller.setBody(world.getVillain());
            // show the new world in the view
             
             
            view.setWorld(world);
           
            world.start();
        } else if( level ==2){
            // If current level is 2 when increment player to level 3 and load new world
            level = level +1;
            // get a new world
            world = new Level3();
            // fill it with bodies
                    try{
            gameMusic = new SoundClip("data/backgroundmusic3.wav");
            // load background music for level 3
            gameMusic.play();
            
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }
            
            world.populate(this );
            UserView view3 = new MyView3(world, world.getVillain(), 1000, 500);
            frame.remove(view);
            view = view3;
            frame.add(view);
            frame.pack();
            frame.setVisible(true);
            // switch the keyboard control to the new player
            controller.setBody(world.getVillain());
            // show the new world in the view
             
           
            view.setWorld(world);

            world.start();
        }else if(level == 3){
            // If current level is level 3 then increment player to next level
            level = level +1;
             
            // get a new world
            world = new Level4();
            // fill it with bodies
                    try{
            gameMusic = new SoundClip("data/backgroundmusic4.wav");
            // Change background music to music for level 4
            gameMusic.play();
            
        }catch(UnsupportedAudioFileException|IOException|LineUnavailableException e){
            System.out.println(e);
        }
            
            world.populate(this );
            UserView view4 = new MyView4(world, world.getVillain(), 1000, 500);
            frame.remove(view);
            view = view4;
            frame.add(view);
            frame.pack();
            frame.setVisible(true);
            // switch the keyboard control to the new player
            controller.setBody(world.getVillain());
            // show the new world in the view
             
            System.out.println(level);
            view.setWorld(world);

            world.start();
        }
    
    }
    public int getLevel(){
        return level;
    }
    public void stopMusic(){
        if(!mute)
            {
            //gameMusic.setVolume(0);
            gameMusic.stop();
            mute = true;
            }
        else
        {
            gameMusic.play();
            mute = false;
        }
    }
    
    public World getWorld(){
        return world;
    }
}
