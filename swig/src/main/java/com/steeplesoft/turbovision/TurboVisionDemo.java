package com.steeplesoft.turbovision;

import com.steeplesoft.turbovision.internal.TApplication;
import com.steeplesoft.turbovision.internal.TMenuBar;
import com.steeplesoft.turbovision.internal.TMenuItem;
import com.steeplesoft.turbovision.internal.TRect;
import com.steeplesoft.turbovision.internal.TStatusDef;
import com.steeplesoft.turbovision.internal.TStatusItem;
import com.steeplesoft.turbovision.internal.TStatusLine;
import com.steeplesoft.turbovision.internal.TSubMenu;
import static com.steeplesoft.turbovision.internal.tvision.newLine;
import com.steeplesoft.turbovision.internal.tvisionJNI;
import static com.steeplesoft.turbovision.internal.tvisionJNI.cmNext_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.cmQuit_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.cmZoom_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.hcNoContext_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbAltF_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbAltW_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbF2_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbF3_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbF4_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbF5_get;
import static com.steeplesoft.turbovision.internal.tvisionJNI.kbF6_get;
import java.io.File;
import java.util.Arrays;

public class TurboVisionDemo extends TApplication {

    static {
        Arrays.asList(
                //"rhtv", 
                new File("../library/makes", "librhtv.so.2.2.1").getAbsolutePath(),
                new File("libtvision.so").getAbsolutePath()
        )
                .forEach(lib -> {
                    try {
                        System.err.println("Loading " + lib);
                        System.load(lib);
                    } catch (UnsatisfiedLinkError e) {
                        System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
                        System.exit(1);
                    }
                });
    }

    private int winNumber = 0;
    
    public TurboVisionDemo() {
        super();
    }

    @Override
    public TStatusLine initStatusLine(TRect r) {
        r.getA().setY(r.getB().getY() - 1);
        return new TStatusLine(r, new TStatusDef(0, 0xFFFF)
                .addItem(new TStatusItem("~Alt-X~ Exit", tvisionJNI.kbAltX_get(), tvisionJNI.cmQuit_get()))
                .addItem(new TStatusItem("~Alt-F3~ Close Dude", tvisionJNI.kbAltF3_get(), tvisionJNI.cmClose_get())));
    }

    @Override
    public TMenuBar initMenuBar(TRect r) {
        r.getB().setY(r.getA().getY() + 1);

        TSubMenu sub1 = new TSubMenu("~F~ile", kbAltF_get());
        sub1.addItem(new TMenuItem("~O~pen", 200, kbF3_get(), hcNoContext_get(), "F3"))
                .addItem(new TMenuItem("~N~ew", 201, kbF4_get(), hcNoContext_get(), "F4"))
                .addItem(newLine())
                .addItem(new TMenuItem("E~x~it", cmQuit_get(), cmQuit_get(), hcNoContext_get(), "Alt-X"));

        TSubMenu sub2 = new TSubMenu("~W~indow", kbAltW_get());
        sub2.addItem(new TMenuItem("~N~ext", cmNext_get(), kbF6_get(), hcNoContext_get(), "F6"))
                .addItem(new TMenuItem("~Z~oom", cmZoom_get(), kbF5_get(), hcNoContext_get(), "F5"))
                .addItem(new TMenuItem( "~D~ialog", 202, kbF2_get(), hcNoContext_get(), "F2" ));

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

/*
class TInterior extends TScroller
{

    public TInterior( TRect bounds, TScrollBar aHScrollBar,
           TScrollBar aVScrollBar ) {
        
    }
    public void draw() {
        
    }
};


class TDemoWindow extends TWindow      // define a new window class
{

    public TDemoWindow( const TRect bounds, String aTitle, short aNumber ) {
    
}
    protected TInterior makeInterior( TRect r, Boolean left ) {
        return null;
    }
    protected void sizeLimits( TPoint minP, TPoint maxP ) {
        
    }
    // override TWindow::sizeLimits

    private TInterior lInterior, rInterior;

};
*/