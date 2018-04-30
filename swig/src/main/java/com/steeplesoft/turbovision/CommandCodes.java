package com.steeplesoft.turbovision;

import static com.steeplesoft.turbovision.SystemCodes.*;

/**
 *
 * @author jdlee
 */
public interface CommandCodes {

    short 
            cmValid = 0,
            cmQuit = 1,
            cmError = 2,
            cmMenu = 3,
            cmClose = 4,
            cmZoom = 5,
            cmResize = 6,
            cmNext = 7,
            cmPrev = 8,
            cmHelp = 9,
            //  TDialog standard commands
            cmOK = 10,
            cmCancel = 11,
            cmYes = 12,
            cmNo = 13,
            cmDefault = 14,
            //  TView State masks 
            sfVisible = 0x001,
            sfCursorVis = 0x002,
            sfCursorIns = 0x004,
            sfShadow = 0x008,
            sfActive = 0x010,
            sfSelected = 0x020,
            sfFocused = 0x040,
            sfDragging = 0x080,
            sfDisabled = 0x100,
            sfModal = 0x200,
            sfDefault = 0x400,
            sfExposed = 0x800,
            // TView Option masks 
            ofSelectable = 0x001,
            ofTopSelect = 0x002,
            ofFirstClick = 0x004,
            ofFramed = 0x008,
            ofPreProcess = 0x010,
            ofPostProcess = 0x020,
            ofBuffered = 0x040,
            ofTileable = 0x080,
            ofCenterX = 0x100,
            ofCenterY = 0x200,
            ofCentered = 0x300,
            // SET: I added it, it means we want the object to send more broadcast
            // than the original TV did. Currently I plan to do it only for a few
            // classes and enable it by default, see TCluster as example.
            ofBeVerbose = 0x400,
            // TView GrowMode masks 
            gfGrowLoX = 0x01,
            gfGrowLoY = 0x02,
            gfGrowHiX = 0x04,
            gfGrowHiY = 0x08,
            gfGrowAll = 0x0f,
            gfGrowRel = 0x10,
            // TView DragMode masks 
            dmDragMove = 0x01,
            dmDragGrow = 0x02,
            dmLimitLoX = 0x10,
            dmLimitLoY = 0x20,
            dmLimitHiX = 0x40,
            dmLimitHiY = 0x80,
            dmLimitAll = dmLimitLoX | dmLimitLoY | dmLimitHiX | dmLimitHiY,
            // TView Help context codes
            hcNoContext = 0,
            hcDragging = 1,
            // TScrollBar part codes 
            sbLeftArrow = 0,
            sbRightArrow = 1,
            sbPageLeft = 2,
            sbPageRight = 3,
            sbUpArrow = 4,
            sbDownArrow = 5,
            sbPageUp = 6,
            sbPageDown = 7,
            sbIndicator = 8,
            // TScrollBar options for TWindow.StandardScrollBar 
            sbHorizontal = 0x000,
            sbVertical = 0x001,
            sbHandleKeyboard = 0x002,
            // TWindow Flags masks
            wfMove = 0x01,
            wfGrow = 0x02,
            wfClose = 0x04,
            wfZoom = 0x08,
            //  TView inhibit flags
            noMenuBar = 0x0001,
            noDeskTop = 0x0002,
            noStatusLine = 0x0004,
            noBackground = 0x0008,
            noFrame = 0x0010,
            noViewer = 0x0020,
            noHistory = 0x0040,
            // TWindow number constants
            wnNoNumber = 0,
            // TWindow palette entries 
            wpBlueWindow = 0,
            wpCyanWindow = 1,
            wpGrayWindow = 2,
            //  Application command codes
            cmCut = 20,
            cmCopy = 21,
            cmPaste = 22,
            cmUndo = 23,
            cmClear = 24,
            cmTile = 25,
            cmCascade = 26,
            // Standard messages 
            cmReceivedFocus = 50,
            cmReleasedFocus = 51,
            cmCommandSetChanged = 52,
            // TScrollBar messages 
            cmScrollBarChanged = 53,
            cmScrollBarClicked = 54,
            // TWindow select messages 
            cmSelectWindowNum = 55,
            //  TListViewer messages
            cmListItemSelected = 56,
            // SET: This is a broadcast that TWindow sends to TProgram::application
            // to notify the window is closing. In this way the application can keep
            // track of closed windows
            cmClosingWindow = 57,
            // SET: Usually the owner doesn't have any information about the state of
            // your TCluster members. I added this to change the situation so you don't
            // need to create a specialized TCluster for it.
            // I think that's how an event/message system should work.
            cmClusterMovedTo = 58,
            cmClusterPress = 59,
            // From TButton::press()
            cmRecordHistory = 60,
            // SET: Here is a broadcast for TListViewer objects. It sends a broadcast
            // when an item is focused.
            cmListItemFocused = 61,
            // SET: Moved here to know they exist
            cmGrabDefault = 62,
            cmReleaseDefault = 63,
            // SET: This is a broadcast sent each time the code page encoding changes.
            //      All objects that uses non ASCII symbols should remap them.
            cmUpdateCodePage = 64,
            // SET: The user screen it not always available. This command is disabled in
            //      this case.
            cmCallShell = 65,
            //  Event masks
            positionalEvents = evMouse,
            focusedEvents = evKeyboard | evCommand,
            
            // Edit Command Code
            ufUpdate = 0x01,
            ufLine = 0x02,
            ufView = 0x04,
            // 
            smExtend = 0x01,
            smDouble = 0x02,
            // 
            sfSearchFailed = Short.MAX_VALUE,
            //
            cmSave = 80,
            cmSaveAs = 81,
            cmFind = 82,
            cmReplace = 83,
            cmSearchAgain = 84,
            //
            cmCharLeft = 500,
            cmCharRight = 501,
            cmWordLeft = 502,
            cmWordRight = 503,
            cmLineStart = 504,
            cmLineEnd = 505,
            cmLineUp = 506,
            cmLineDown = 507,
            cmPageUp = 508,
            cmPageDown = 509,
            cmTextStart = 510,
            cmTextEnd = 511,
            cmNewLine = 512,
            cmBackSpace = 513,
            cmDelChar = 514,
            cmDelWord = 515,
            cmDelStart = 516,
            cmDelEnd = 517,
            cmDelLine = 518,
            cmInsMode = 519,
            cmStartSelect = 520,
            cmHideSelect = 521,
            cmIndentMode = 522,
            cmUpdateTitle = 523,
            cmInsertText = 524,
            //
            edOutOfMemory = 0,
            edReadError = 1,
            edWriteError = 2,
            edCreateError = 3,
            edSaveModify = 4,
            edSaveUntitled = 5,
            edSaveAs = 6,
            edFind = 7,
            edSearchFailed = 8,
            edReplace = 9,
            edReplacePrompt = 10,
            //
            efCaseSensitive = 0x0001,
            efWholeWordsOnly = 0x0002,
            efPromptOnReplace = 0x0004,
            efReplaceAll = 0x0008,
            efDoReplace = 0x0010,
            efBackupFiles = 0x0100,
            //
            maxLineLength = 256,
            // SET: Added these old constants here
            cmOpen = 100,
            cmNew = 101,
            cmChangeDrct = 102,
            cmDosShell = 103,
            cmCalculator = 104,
            cmShowClip = 105,
            cmMacros = 106;
}
