package com.steeplesoft.turbovision;

import static com.steeplesoft.turbovision.CommandCodes.*;
import static com.steeplesoft.turbovision.SystemCodes.*;
import static com.steeplesoft.turbovision.TKeys.*;
import com.steeplesoft.turbovision.internal.TApplication;
import com.steeplesoft.turbovision.internal.TCheckBoxes;
import com.steeplesoft.turbovision.internal.TDialog;
import com.steeplesoft.turbovision.internal.TDrawBuffer;
import com.steeplesoft.turbovision.internal.TEvent;
import com.steeplesoft.turbovision.internal.TInputLine;
import com.steeplesoft.turbovision.internal.TLabel;
import com.steeplesoft.turbovision.internal.TMenuBar;
import com.steeplesoft.turbovision.internal.TMenuItem;
import com.steeplesoft.turbovision.internal.TPoint;
import com.steeplesoft.turbovision.internal.TRadioButtons;
import com.steeplesoft.turbovision.internal.TRangeValidator;
import com.steeplesoft.turbovision.internal.TRect;
import com.steeplesoft.turbovision.internal.TSItem;
import com.steeplesoft.turbovision.internal.TScrollBar;
import com.steeplesoft.turbovision.internal.TScroller;
import com.steeplesoft.turbovision.internal.TStatusDef;
import com.steeplesoft.turbovision.internal.TStatusItem;
import com.steeplesoft.turbovision.internal.TStatusLine;
import com.steeplesoft.turbovision.internal.TSubMenu;
import com.steeplesoft.turbovision.internal.TValidator;
import com.steeplesoft.turbovision.internal.TView;
import com.steeplesoft.turbovision.internal.TWindow;
import static com.steeplesoft.turbovision.internal.tvision.newLine;

public class TurboVisionDemo extends TApplication {

    private short winNumber = 0;
    private int lineCount = 0;
    private int maxLines = 100;
    private String[] lines = new String[maxLines];
    private final DialogData demoDialogData;

    private static final int cmMyFileOpen = 200;   // assign new command values
    private static final int cmMyNewWin = 201;
    private static final int cmNewDialog = 202;

    public TurboVisionDemo() {
        super();

        demoDialogData = new DialogData();
        demoDialogData.checkBoxData = 1;
        demoDialogData.radioButtonData = 2;
        demoDialogData.inputLineData = "Phone Mum!";
        demoDialogData.inputLineRangeData = "16";
    }

    @Override
    public void handleEvent(TEvent event) {
        super.handleEvent(event);
        if (event.getWhat() == evCommand) {
            switch (event.getMessage().getCommand()) {
                case cmMyNewWin:
                    newWindow();
                    break;
                case cmNewDialog:
                    newDialog();
                    break;
                default:
                    return;
            }
            clearEvent(event);
        }
    }

    protected void newWindow() {
        TRect r = new TRect(0, 0, 45, 13);            // set initial size and position

        /* SS: micro change here */
        r.move(((int) Math.random() % 34), ((int) Math.random() % 11)); // randomly move around screen
        TDemoWindow window = new TDemoWindow(r, "Demo Window", ++winNumber);
        deskTop.insert(window);    // put window into desktop and draw it
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
                .addItem(new TMenuItem("~D~ialog", 202, kbF2, hcNoContext, "F2"));

        TMenuBar menuBar = new TMenuBar(r, sub1.addSubMenu(sub2));
        return menuBar;
    }

    public static void main(String argv[]) {
        TurboVisionDemo app = new TurboVisionDemo();
        app.run();
    }

    protected void newDialog() {
        TDialog pd = new TDialog(new TRect(20, 4, 60, 20), "Demo Dialog");
        TView b = new TCheckBoxes(new TRect(3, 3, 18, 6),
                new TSItem("~H~varti",
                        new TSItem("~T~ilset",
                                new TSItem("~J~arlsberg", null)
                        )));
        pd.insert(b);
        pd.insert(new TLabel(new TRect(2, 2, 10, 3), "Cheeses", b));

        b = new TRadioButtons(new TRect(22, 3, 34, 6),
                new TSItem("~S~olid",
                        new TSItem("~R~unny",
                                new TSItem("~M~elted", null)
                        )));
        pd.insert(b);
        pd.insert(new TLabel(new TRect(21, 2, 33, 3), "Consistency", b));

        // add input line
        b = new TInputLine(new TRect(3, 8, 37, 9), 128);
        pd.insert(b);
        pd.insert(new TLabel(new TRect(2, 7, 24, 8),
                "Delivery Instructions", b));

        // add input line with range validation
        TInputLine inp = new TInputLine(new TRect(3, 11, 37, 12), 32);
        pd.insert(inp);
        pd.insert(new TLabel(new TRect(2, 10, 26, 11),
                "A value from -20 to 590", inp));
        TValidator vld = new TRangeValidator(-20, 590);
        inp.setValidator(vld);
        pd.insert(new TButton(new TRect(15, 13, 25, 15), "~O~K", cmOK,
                bfDefault));
        pd.insert(new TButton(new TRect(28, 13, 38, 15), "~C~ancel", cmCancel,
                bfNormal));
        // we save the dialog data:
        pd.setData(demoDialogData);

        short control = deskTop.execView(pd);

        // and read it back when the dialog box is successfully closed
        if (control != cmCancel) {
            char *end;
            pd.getData(demoDialogData);
            // this is a message box with arguments like printf
            messageBox(mfInformation | mfOKButton, "Deliver: %s value %ld",
                    demoDialogData.inputLineData,
                    strtol(demoDialogData.inputLineRangeData,  & end, 0));
        }
        CLY_destroy(pd);
    }

    private class TInterior extends TScroller {

        public TInterior(TRect bounds, TScrollBar aHScrollBar, TScrollBar aVScrollBar) {
            super(bounds, aHScrollBar, aVScrollBar);

            setOptions(getOptions() | ofFramed);
            setLimit(maxLineLength, lineCount);
        }

        @Override
        public void draw() {
            int color = getColor(0x0301);
            for (int i = 0; i < getSize().getY(); i++) // for each line:
            {
                TDrawBuffer b = new TDrawBuffer();
                b.moveChar(0, ' ', color, getSize().getX());
                // fill line buffer with spaces
                int j = getDelta().getY() + i;
                if (j < lineCount && lines[j] != null) {
                    String s;
                    if (getDelta().getX() > lines[j].length()) {
                        s = null;
                    } else {
                        s = lines[j].substring(getDelta().getX(), getSize().getX());
                    }
                    b.moveCStr(0, s, color);
                }
                writeLine(0, i, getSize().getX(), 1, b);
            }
        }
    };

    private class TDemoWindow extends TWindow {

        public TDemoWindow(TRect bounds, String aTitle, short aNumber) {
            super(bounds, aTitle, aNumber);
        }

        protected TInterior makeInterior(TRect bounds, Boolean left) {
            TRect r = new TRect(bounds.getB().getX() - 1, bounds.getA().getY() + 1,
                    bounds.getB().getX(), bounds.getB().getY() - 1);
            TScrollBar vScrollBar = new TScrollBar(r);
            // production code would display error dialog box
            vScrollBar.setOptions(vScrollBar.getOptions() | ofPostProcess);
            if (left) {
                vScrollBar.setGrowMode(gfGrowHiY);
            }
            insert(vScrollBar);

            r = new TRect(bounds.getA().getX() + 2, bounds.getB().getY() - 1,
                    bounds.getB().getX() - 2, bounds.getB().getY());
            TScrollBar hScrollBar = new TScrollBar(r);
            hScrollBar.setOptions(hScrollBar.getOptions() | ofPostProcess);
            if (left) {
                hScrollBar.setGrowMode((short) (gfGrowHiY | gfGrowLoY));
            }
            insert(hScrollBar);

            r = bounds;
            r.grow(-1, -1);
            return new TInterior(r, hScrollBar, vScrollBar);
        }

        @Override
        public void sizeLimits(TPoint minP, TPoint maxP) {
            super.sizeLimits(minP, maxP);
            minP.setX(lInterior.getSize().getX() + 9);
        }

        private TInterior lInterior, rInterior;

    };

    private class DialogData {

        short checkBoxData;
        short radioButtonData;
        String inputLineData;
        String inputLineRangeData;
    };
}
