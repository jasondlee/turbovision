
import com.steeplesoft.turbovision.internal.TApplication;
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
    }

    public static void main(String argv[]) {
        MyApp app = new MyApp();
        app.run();
    }
}
