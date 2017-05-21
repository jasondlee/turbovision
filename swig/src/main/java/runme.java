
import com.steeplesoft.turbovision.internal.TApplication;
import com.steeplesoft.turbovision.internal.TRect;
import com.steeplesoft.turbovision.internal.TStatusDef;
import com.steeplesoft.turbovision.internal.TStatusItem;
import com.steeplesoft.turbovision.internal.TStatusLine;
import com.steeplesoft.turbovision.internal.tvisionJNI;
import java.util.Arrays;

public class runme {

    static {
        Arrays.asList(
                //"rhtv", 
                "tvision").forEach(lib -> {
                    try {
                        System.out.println("Loading " + lib);
                        System.loadLibrary(lib);
                    } catch (UnsatisfiedLinkError e) {
                        System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
                        System.exit(1);
                    }
                });
    }

    private static class MyApp extends TApplication {

        public MyApp() {
            super();
        }

        @Override
        public TStatusLine initStatusLine(TRect r) {
            r.getA().setY(r.getB().getY() - 1);     // move top to 1 line above bottom
            final TStatusDef statusDef = new TStatusDef(0, 0xFFFF);
            System.out.println("adding exit");
            statusDef.addItem(new TStatusItem("~Alt-X~ Exit", tvisionJNI.kbAltX_get(), tvisionJNI.cmQuit_get()));
            System.out.println("adding close");
            statusDef.addItem(new TStatusItem("~Alt-F3~ Close", tvisionJNI.kbAltF3_get(), tvisionJNI.cmClose_get()));
            return new TStatusLine(r, statusDef);
        }
    }

    public static void main(String argv[]) {
        MyApp app = new MyApp();
        app.run();
    }
}
