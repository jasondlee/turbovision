package com.steeplesoft.turbovision;

import static com.steeplesoft.turbovision.TCommandCodes.*;
import static com.steeplesoft.turbovision.TKeys.*;
import com.steeplesoft.turbovision.internal.TApplication;
import com.steeplesoft.turbovision.internal.TMenuBar;
import com.steeplesoft.turbovision.internal.TMenuItem;
import com.steeplesoft.turbovision.internal.TPoint;
import com.steeplesoft.turbovision.internal.TRect;
import com.steeplesoft.turbovision.internal.TScrollBar;
import com.steeplesoft.turbovision.internal.TScroller;
import com.steeplesoft.turbovision.internal.TStatusDef;
import com.steeplesoft.turbovision.internal.TStatusItem;
import com.steeplesoft.turbovision.internal.TStatusLine;
import com.steeplesoft.turbovision.internal.TSubMenu;
import com.steeplesoft.turbovision.internal.TWindow;
import static com.steeplesoft.turbovision.internal.tvision.newLine;

public class TurboVisionDemo extends TApplication {

    private int winNumber = 0;
    
    public TurboVisionDemo() {
        super();
    }

    @Override
    public TStatusLine initStatusLine(TRect r) {
        r.getA().setY(r.getB().getY() - 1);
        return new TStatusLine(r, new TStatusDef(0, 0xFFFF)
                .addItem(new TStatusItem("~Alt-X~ Exit", kbAltX, cmQuit))
                .addItem(new TStatusItem("~Alt-F3~ Close Dude", kbAltF3, cmClose)));
    }

    @Override
    public TMenuBar initMenuBar(TRect r) {
        r.getB().setY(r.getA().getY() + 1);

        TSubMenu sub1 = new TSubMenu("~F~ile", kbAltF);
        sub1.addItem(new TMenuItem("~O~pen", 200, kbF3, hcNoContext, "F3"))
                .addItem(new TMenuItem("~N~ew", 201, kbF4, hcNoContext, "F4"))
                .addItem(newLine())
                .addItem(new TMenuItem("E~x~it", cmQuit, cmQuit, hcNoContext, "Alt-X"));

        TSubMenu sub2 = new TSubMenu("~W~indow", kbAltW);
        sub2.addItem(new TMenuItem("~N~ext", cmNext, kbF6, hcNoContext, "F6"))
                .addItem(new TMenuItem("~Z~oom", cmZoom, kbF5, hcNoContext, "F5"))
                .addItem(new TMenuItem( "~D~ialog", 202, kbF2, hcNoContext, "F2" ));

        TMenuBar menuBar = new TMenuBar(r, sub1.addSubMenu(sub2));
        return menuBar;
    }

    void newWindow() {
        TRect r = new TRect ( 0, 0, 45, 13 );            // set initial size and position

    /* SS: micro change here */
//
//    r.move((int)Math.random() % 34, (int)Math.random() % 11); 
//        TDemoWindow window = new TDemoWindow(r, "Demo Window", ++winNumber);
//        deskTop.insert(window);    // put window into desktop and draw it
    }

    public static void main(String argv[]) {
        TurboVisionDemo app = new TurboVisionDemo();
        app.run();
    }
}

class TInterior extends TScroller
{

    public TInterior( TRect bounds, TScrollBar aHScrollBar, TScrollBar aVScrollBar ) {
        super(bounds, aHScrollBar, aVScrollBar);
    }
    
    @Override
    public void draw() {
        
    }
};

/*
class TDemoWindow extends TWindow      // define a new window class
{

    public TDemoWindow( TRect bounds, String aTitle, short aNumber ) {
    
    }
    protected TInterior makeInterior( TRect r, Boolean left ) {
        return null;
    }
    
    @Override
    public void sizeLimits( TPoint minP, TPoint maxP ) {
        
    }
    // override TWindow::sizeLimits

    private TInterior lInterior, rInterior;

};
*/