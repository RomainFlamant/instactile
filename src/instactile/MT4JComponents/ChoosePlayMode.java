package instactile.MT4JComponents;

import antlr.collections.impl.Vector;
import instactile.factories.BattleZonesGraphicFactory;
import instactile.models.BattleGround;
import java.awt.Component;
import java.util.List;
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
import org.mt4j.util.MTColor;
import org.mt4j.util.math.Vector3D;
import processing.core.PImage;

/**
 * @author Benjamin MILHAU b.milhau@insta.fr
 */
public class ChoosePlayMode extends AbstractScene {
    PImage ChooseModeMessage = null;
    MTImage MTChooseModeMessage = null;
    PImage TwoKillerMessage = null;
    MTImage MTTwoKillerMessage = null;
    PImage FourKillerMessage = null;
    MTImage MTFourKillerMessage = null;
    PImage SixKillerMessage = null;
    MTImage MTSixKillerMessage = null;
    PImage ChoosePlayMessage = null;
    MTImage MTChoosePlayMessage = null;
    PImage DevilMessage = null;
    MTImage MTDevilMessage = null;
    PImage MetroidMessage = null;
    MTImage MTMetroidMessage = null;
    PImage SoulMessage = null;
    MTImage MTSoulMessage = null;
    PImage PlayMessage = null;
    MTImage MTPlayMessage = null;
    PImage Selector = null;
    MTImage MTSelector = null;
    int WIDTH;
    int HEIGHT;
    int NbrPlayer = 4;
    
    AbstractMTApplication mtApplication = null;
    
    public ChoosePlayMode(AbstractMTApplication _mtApplication, String name) {
        super(_mtApplication, name);
        mtApplication = _mtApplication;
        this.HEIGHT = mtApplication.height;
        this.WIDTH = mtApplication.width;
        this.setClearColor(MTColor.WHITE);
        this.getCanvas().unregisterAllInputProcessors();
        initImage();
        getCanvas().addChild(MTSelector);
        getCanvas().addChild(MTChooseModeMessage);
        getCanvas().addChild(MTTwoKillerMessage);
        getCanvas().addChild(MTFourKillerMessage);
        getCanvas().addChild(MTSixKillerMessage);
        getCanvas().addChild(MTChoosePlayMessage);
        getCanvas().addChild(MTDevilMessage);
        getCanvas().addChild(MTSoulMessage);
        getCanvas().addChild(MTMetroidMessage);
        getCanvas().addChild(MTPlayMessage);
        
    }

    private void initImage() {
        ChooseModeMessage = mtApplication.loadImage("data/image/ChooseMode.png");
        MTChooseModeMessage = new MTImage(mtApplication, ChooseModeMessage);
        MTChooseModeMessage.setSizeXYGlobal(WIDTH, 130);
        MTChooseModeMessage.unregisterAllInputProcessors();
        MTChooseModeMessage.setPositionGlobal(new Vector3D(WIDTH/2, 60));
        
        TwoKillerMessage = mtApplication.loadImage("data/image/2Killer.png");
        MTTwoKillerMessage = new MTImage(mtApplication, TwoKillerMessage);
        MTTwoKillerMessage.unregisterAllInputProcessors();
        MTTwoKillerMessage.setSizeXYGlobal(WIDTH / 5f , 150);
        MTTwoKillerMessage.setPositionGlobal(new Vector3D(300, 300));
        addTapProcessor(MTTwoKillerMessage, "2PlayerTap");
        
        
        FourKillerMessage = mtApplication.loadImage("data/image/4Killer.png");
        MTFourKillerMessage = new MTImage(mtApplication, FourKillerMessage);
        MTFourKillerMessage.unregisterAllInputProcessors();
        MTFourKillerMessage.setSizeXYGlobal(WIDTH / 5f , 150);
        MTFourKillerMessage.setPositionGlobal(new Vector3D(WIDTH/2, 300));
        
        
        SixKillerMessage = mtApplication.loadImage("data/image/6Killer.png");
        MTSixKillerMessage = new MTImage(mtApplication, SixKillerMessage);
        MTSixKillerMessage.unregisterAllInputProcessors();
        MTSixKillerMessage.setSizeXYGlobal(WIDTH / 5f , 150);
        MTSixKillerMessage.setPositionGlobal(new Vector3D(WIDTH-300, 300));
        
        
        ChoosePlayMessage = mtApplication.loadImage("data/image/ChoosePlayList.png");
        MTChoosePlayMessage = new MTImage(mtApplication, ChoosePlayMessage);
        MTChoosePlayMessage.setSizeXYGlobal(WIDTH, 130);
        MTChoosePlayMessage.unregisterAllInputProcessors();
        MTChoosePlayMessage.setPositionGlobal(new Vector3D(WIDTH/2, 500));
        
        
        MetroidMessage = mtApplication.loadImage("data/image/MetroidPlayList.png");
        MTMetroidMessage = new MTImage(mtApplication, MetroidMessage);
        MTMetroidMessage.unregisterAllInputProcessors();
        MTMetroidMessage.setSizeXYGlobal(WIDTH / 5f , 130);
        MTMetroidMessage.setPositionGlobal(new Vector3D(300, 650));
        
        
        DevilMessage = mtApplication.loadImage("data/image/DevilMayCryPlayList.png");
        MTDevilMessage = new MTImage(mtApplication, DevilMessage);
        MTDevilMessage.unregisterAllInputProcessors();
        MTDevilMessage.setSizeXYGlobal(WIDTH / 5f , 130);
        MTDevilMessage.setPositionGlobal(new Vector3D(WIDTH/2, 650));
        
        SoulMessage = mtApplication.loadImage("data/image/SoulCaliburPlayList.png");
        MTSoulMessage = new MTImage(mtApplication, SoulMessage);
        MTSoulMessage.unregisterAllInputProcessors();
        MTSoulMessage.setSizeXYGlobal(WIDTH / 5f , 130);
        MTSoulMessage.setPositionGlobal(new Vector3D(WIDTH-300, 650));
        
        PlayMessage = mtApplication.loadImage("data/image/Start.png");
        MTPlayMessage = new MTImage(mtApplication, PlayMessage);
        MTPlayMessage.unregisterAllInputProcessors();
        MTPlayMessage.setSizeXYGlobal(WIDTH / 5f , 130);
        MTPlayMessage.setPositionGlobal(new Vector3D(WIDTH/2, 800));
        
        
        Selector = mtApplication.loadImage("data/image/Selector.png");
        MTSelector = new MTImage(mtApplication, Selector);
        MTSelector.unregisterAllInputProcessors();
        MTSelector.setSizeXYGlobal(WIDTH / 4f , 220);
        if (NbrPlayer == 2)
            MTSelector.setPositionGlobal(new Vector3D(WIDTH/2, 300));
        else if (NbrPlayer == 4)
            MTSelector.setPositionGlobal(new Vector3D(WIDTH/2, 300));
        else
            MTSelector.setPositionGlobal(new Vector3D(WIDTH/2, 300));
    }

    private void addTapProcessor(MTComponent mtComp, String playerTap) {
        mtComp.registerInputProcessor(new TapProcessor(mtApplication, 15));
        
        if (playerTap == "2PlayerTap")
        {
            mtComp.addGestureListener(TapProcessor.class, new IGestureEventListener() {
                    public boolean processGestureEvent(MTGestureEvent ge) {
                        TapEvent te = (TapEvent) ge;
                        if (te.isTapped()) {
                            final BattleGroundScene sceneWindow = new BattleGroundScene(mtApplication, "BattleGroundScene", 6);
                            sceneWindow.setTransition(new BlendTransition(mtApplication, 300));
                            mtApplication.addScene(sceneWindow);
                        }
                        return false;
                    }
                });
        }
        //switch (playerTap) {
        //    case "2PlayerTap":
        //        
        //        break;
        //    default:
        //        break;
        //}
    }
    

}
