package instactile.MT4JComponents;

import antlr.collections.impl.Vector;
import com.sun.opengl.impl.mipmap.Mipmap;
import instactile.factories.BattleZonesGraphicFactory;
import instactile.models.BattleGround;
import java.awt.Component;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.mt4j.AbstractMTApplication;
import org.mt4j.MTApplication;
import org.mt4j.components.MTComponent;
import org.mt4j.components.visibleComponents.shapes.MTRectangle;
import org.mt4j.components.visibleComponents.widgets.MTImage;
import org.mt4j.input.inputProcessors.IGestureEventListener;
import org.mt4j.input.inputProcessors.MTGestureEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapEvent;
import org.mt4j.input.inputProcessors.componentProcessors.tapProcessor.TapProcessor;
import org.mt4j.sceneManagement.AbstractScene;
import org.mt4j.sceneManagement.Iscene;
import org.mt4j.sceneManagement.transition.BlendTransition;
import org.mt4j.sceneManagement.transition.FlipTransition;
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import processing.core.PImage;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class StartScreenScene extends AbstractScene {
    
    Timer t; 
    AbstractMTApplication mtApplication = null;
    PImage StartScreenImageWithMessage = null;
    PImage StartScreenImageWithOutMessage = null;
    MTImage mtImage = null;
    MTImage mtImageBis = null;
    int image = 0;
    
    /**
     *
     * @param mtApplication
     * @param name
     */
    public StartScreenScene(AbstractMTApplication _mtApplication, String name) {
        super(_mtApplication, name);
        mtApplication = _mtApplication;
        this.setClearColor(MTColor.WHITE);
        this.setTransition(new FlipTransition(mtApplication, 800));
        setImage();
        t = new Timer();
        t.schedule(new TimerAction(), 0, 800);
    }
    
    
    
    private void addTapProcessor(MTComponent mtComp, final AbstractMTApplication mtApplication, StartScreenScene aThis) {
        mtComp.registerInputProcessor(new TapProcessor(mtApplication, 15));
        mtComp.addGestureListener(TapProcessor.class, new IGestureEventListener() {
            public boolean processGestureEvent(MTGestureEvent ge) {
                TapEvent te = (TapEvent) ge;
                if (te.isTapped()) {
                    System.out.println("Tap detect");
                    final ChoosePlayMode choosePlayMode = new ChoosePlayMode(mtApplication, "ChoosePlayMode");
                    choosePlayMode.setTransition(new FlipTransition(mtApplication, 1500000));
                    mtApplication.addScene(choosePlayMode);
                    mtApplication.pushScene(); 
                    mtApplication.changeScene(choosePlayMode);
                    
                    
                }
                return false;
            }
        });
    }

    private void setImage() {
        StartScreenImageWithMessage = mtApplication.loadImage("data/image/StartMessageOn.png");
        StartScreenImageWithOutMessage = mtApplication.loadImage("data/image/StartMessageOff.png");
        mtImage = new MTImage(mtApplication, StartScreenImageWithMessage);
        mtImageBis = new MTImage(mtApplication, StartScreenImageWithOutMessage);
        mtImage.unregisterAllInputProcessors();
        mtImageBis.unregisterAllInputProcessors();
        mtImage.setPositionGlobal(new Vector3D(mtApplication.width / 2f, mtApplication.height / 2f));
        mtImageBis.setPositionGlobal(new Vector3D(mtApplication.width / 2f, mtApplication.height / 2f));
        addTapProcessor(mtImageBis, mtApplication, this);
        addTapProcessor(mtImage, mtApplication, this);
    }
    
    

    class TimerAction extends TimerTask {
        
    public void run() {
        reloadImage();
    }

        private void reloadImage() {
            if (image == 1){
            getCanvas().addChild(mtImageBis);
            image--;
            }
            else
            {
                getCanvas().addChild(mtImage);
                image++;
            }
        }
    }
    
    
}


