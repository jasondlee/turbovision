package com.steeplesoft.turbovision;

import com.steeplesoft.turbovision.internal.TApplication;
import com.steeplesoft.turbovision.internal.TProgram;
import com.steeplesoft.turbovision.internal.TRect;
import com.steeplesoft.turbovision.internal.TScreen;
import com.steeplesoft.turbovision.internal.TStatusDef;
import com.steeplesoft.turbovision.internal.TStatusItem;
import com.steeplesoft.turbovision.internal.TStatusLine;
import com.steeplesoft.turbovision.internal.tvisionJNI;
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
//              return createStatusLine(arg0);
            return null;
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
