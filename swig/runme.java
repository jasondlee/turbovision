// This example illustrates how C++ classes can be used from Java using SWIG.
// The Java class gets mapped onto the C++ class and behaves as if it is a Java class.

public class runme {
  static {
    try {
        System.loadLibrary("tvision");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
      System.exit(1);
    }
  }
  private static class MyApp extends TApplication {
      
  }

  public static void main(String argv[]) 
  {
  }
}

