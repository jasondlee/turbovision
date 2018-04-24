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

public class TurboVisionDemo {

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

    private static class MyApp extends TApplication {

        public MyApp() {
            super();
//            TProgram.setStatusLine(createStatusLine(new TRect(0, 0, TScreen.getScreenWidth(), TScreen.getScreenHeight())));
        }

        @Override
        public TStatusLine initStatusLine(TRect r) {
            return createStatusLine(r);
//            return null;
        }

        @Override
        public TMenuBar initMenuBar(TRect r) {
            r.getB().setY(r.getA().getY() + 1);    // set bottom line 1 line below top line
            
            TSubMenu sub1 = new TSubMenu("~F~ile", kbAltF_get());
            sub1.addItem(new TMenuItem("~O~pen", 200, kbF3_get(), hcNoContext_get(), "F3"))
                    .addItem(new TMenuItem("~N~ew", 201, kbF4_get(), hcNoContext_get(), "F4"))
                    .addItem(newLine())
                            .addItem(new TMenuItem("E~x~it", cmQuit_get(), cmQuit_get(), hcNoContext_get(), "Alt-X"));
            
            TSubMenu sub2 = new TSubMenu("~W~indow", kbAltW_get());
            sub2.addItem(new TMenuItem("~N~ext", cmNext_get(), kbF6_get(), hcNoContext_get(), "F6"))
                    .addItem(new TMenuItem("~Z~oom", cmZoom_get(), kbF5_get(), hcNoContext_get(), "F5"));
            
            
            TMenuBar menuBar = new TMenuBar(r, sub1.addSubMenu(sub2));
            
            /*
            return new TMenuBar(r,
                    new TSubMenu("~F~ile", kbAltF_get())
                    + new TMenuItem("~O~pen", 200, kbF3_get(), hcNoContext_get(), "F3")
//                    + new TMenuItem("~N~ew", cmMyNewWin_get(), kbF4_get(), hcNoContext_get(), "F4")
                    + newLine()
                    + new TMenuItem("E~x~it", cmQuit_get(), cmQuit_get(), hcNoContext_get(), "Alt-X")
                    + new TSubMenu("~W~indow", kbAltW_get())
                    + new TMenuItem("~N~ext", cmNext_get(), kbF6_get(), hcNoContext_get(), "F6")
                    + new TMenuItem("~Z~oom", cmZoom_get(), kbF5_get(), hcNoContext_get(), "F5")
//                    + new TMenuItem("~D~ialog", cmNewDialog_get(), kbF2_get(), hcNoContext_get(), "F2")
            // new dialog menu added here
            );
*/
            return menuBar;
        }

        private TStatusLine createStatusLine(TRect r) {
            System.err.println("initStatusLine");
            r.getA().setY(r.getB().getY() - 1);     // move top to 1 line above bottom
            final TStatusDef statusDef = new TStatusDef(0, 0xFFFF);
            System.err.println("adding exit");
            statusDef.addItem(new TStatusItem("~Alt-X~ Exit", tvisionJNI.kbAltX_get(), tvisionJNI.cmQuit_get()));
            System.err.println("adding close");
            statusDef.addItem(new TStatusItem("~Alt-F3~ Close Dude", tvisionJNI.kbAltF3_get(), tvisionJNI.cmClose_get()));
            return new TStatusLine(r, statusDef);
        }
    }

    public static void main(String argv[]) {
        MyApp app = new MyApp();
        app.run();
    }
}
