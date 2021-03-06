%module(directors="1") tvision
%feature("director") TApplication;
%feature("director") TProgram;
%feature("director") TProgInit;
%feature("director") TWindow;
%feature("director") TWindowInit;
%feature("director") TView;
%feature("director") TGroup;
%feature("director") TFrame;
%feature("director") TEvent;
%feature("director") TValidator;
%feature("director") TFilterValidator;
%feature("director") TLookupValidator;
%feature("director") TPXPictureValidator;
%feature("director") TRangeValidator;
%feature("director") TStringLookupValidator;
%feature("director") TScrollBar;
%feature("director") TScroller;
%feature("director") TDialog;
%feature("director") TCluster;
%feature("director") TCheckBoxes;
%feature("director") TSItem;
%feature("director") TStaticText;
%feature("director") TLabel;
%feature("director") TRadioButtons;
%feature("director") TInputLineBase;
%feature("director") TInputLineBaseT;
%feature("director") TInputLine;
%feature("director") TInputLine16;
%feature("director") TInputLineBaseT<char,TDrawBuffer>;
%feature("director") TButton;

%{
#define CLY_EXPORT
#define Uses_EventCodes 
#define Uses_MsgBox 
#define Uses_T1Label 
#define Uses_T1StaticText
#define Uses_TApplication
#define Uses_TBackground 
#define Uses_TButton 
#define Uses_TCalcDisplay
#define Uses_TCalculator
#define Uses_TChDirDialog 
#define Uses_TCheckBoxes 
#define Uses_TCluster 
#define Uses_TCollection 
#define Uses_TColorCommands
#define Uses_TColorDialog 
#define Uses_TColorDisplay 
#define Uses_TColorGroup 
#define Uses_TColorGroupList 
#define Uses_TColorItem 
#define Uses_TColorItemList 
#define Uses_TColorSelector 
#define Uses_TCommandSet 
#define Uses_TDeskTop 
#define Uses_TDialog 
#define Uses_TDirCollection 
#define Uses_TDirEntry 
#define Uses_TDirListBox 
#define Uses_TDrawBuffer 
#define Uses_TEditWindow
#define Uses_TEditor
#define Uses_TEvent 
#define Uses_TEventQueue 
#define Uses_TFileCollection 
#define Uses_TFileDialog 
#define Uses_TFileEditor
#define Uses_TFileInfoPane 
#define Uses_TFileInputLine 
#define Uses_TFileList 
#define Uses_TFileViewer 
#define Uses_TFilterValidator 
#define Uses_TFindDialogRec 
#define Uses_TFrame 
#define Uses_TGKey 
#define Uses_TGroup 
#define Uses_THelpFile
#define Uses_THelpViewer
#define Uses_THelpWindow
#define Uses_THistory 
#define Uses_THistoryViewer 
#define Uses_THistoryWindow 
#define Uses_TIndicator 
#define Uses_TInput1Line 
#define Uses_TInputLineBase
#define Uses_TInputLine 
#define Uses_TInputLine16
#define Uses_TKeys 
#define Uses_TLabel 
#define Uses_TListBox 
#define Uses_TListViewer 
#define Uses_TLookupValidator 
#define Uses_TMemo
#define Uses_TMenu 
#define Uses_TMenuBar 
#define Uses_TMenuBox 
#define Uses_TMenuItem 
#define Uses_TMenuView 
#define Uses_TMonoSelector 
#define Uses_TNSCollection 
#define Uses_TNSSortedCollection 
#define Uses_TObject 
#define Uses_TPReadObjects 
#define Uses_TPWrittenObjects 
#define Uses_TPXPictureValidator 
#define Uses_TPalette 
#define Uses_TParamText 
#define Uses_TPoint 
#define Uses_TProgram 
#define Uses_TRadioButtons 
#define Uses_TRangeValidator 
#define Uses_TRect 
#define Uses_TReplaceDialogRec 
#define Uses_TResourceCollection 
#define Uses_TResourceFile 
#define Uses_TResourceItem 
#define Uses_TSItem 
#define Uses_TScreen 
#define Uses_TScrollBar 
#define Uses_TScroller 
#define Uses_TSearchRec 
#define Uses_TSortedCollection 
#define Uses_TSortedListBox 
#define Uses_TStaticText 
#define Uses_TStatusDef 
#define Uses_TStatusItem 
#define Uses_TStatusLine 
#define Uses_TStrIndexRec 
#define Uses_TStrListMaker 
#define Uses_TStreamable 
#define Uses_TStreamableClass 
#define Uses_TStreamableTypes 
#define Uses_TStringCollection 
#define Uses_TStringList 
#define Uses_TStringLookupValidator 
#define Uses_TSubMenu 
#define Uses_TTerminal 
#define Uses_TTextDevice 
#define Uses_TVCodePage 
#define Uses_TVConfigFile
#define Uses_TVFontCollection 
#define Uses_TVOSClipboard
#define Uses_TVPartitionTree556 
#define Uses_TValidator 
#define Uses_TView 
#define Uses_TWindow 
#define Uses_ViewCommands 
#define Uses_fpbase 
#define Uses_fpstream 
#define Uses_ifpstream 
#define Uses_iopstream 
#define Uses_ipstream 
#define Uses_ofpstream 
#define Uses_opstream
#define Uses_pstream 

#include "tv.h"

%}

%pragma(java) jniclasscode=%{
    static {
        java.util.Arrays.asList("tvision","rhtv").forEach(lib -> {
                try {
                    System.loadLibrary(lib);
                } catch (UnsatisfiedLinkError e) {
                    System.err.println(String.format("Native code library '%1$s' failed to load.\n", lib) + e);
                    System.exit(-1);
                }
            });
    }

%}

%define NO_STREAM1
%enddef

%define CLY_BROKEN_WATCOM_SCOPE
public
%enddef

%define ushort
unsigned short
%enddef

%define uchar
unsigned char
%enddef

%define CLY_EXPORT
%enddef

%define int32
int
%enddef

%define int8
signed char 
%enddef

%define int16
short
%enddef

%define uint8
unsigned char
%enddef

%define uint16
unsigned short
%enddef

%define uint32
unsigned int
%enddef

%define uint64
unsigned long long
%enddef

%define int64
long long
%enddef

%include "tv.h"
//%include "tv/backgrnd.h"
//%include "tv/desktop.h"
%include "tv/rect.h"
%include "tv/views.h"
%include "tv/view.h"
%include "tv/window.h"
%include "tv/drawbuf.h"

%include "tv/tkeys.h"
%include "tv/cmdset.h"
%include "tv/palette.h"
%include "tv/streambl.h"
%include "tv/object.h"
%include "tv/event.h"
%include "tv/group.h"
%include "tv/point.h"
%include "tv/screen.h"
%include "tv/validate.h"
%include "tv/dialog.h"
%include "tv/sitem.h"
%include "tv/cluster.h"
%include "tv/checkbox.h"
%include "tv/menuview.h"
%include "tv/menuitem.h"
%include "tv/menubar.h"
%include "tv/submenu.h"
%include "tv/menu.h"
%include "tv/sttctext.h"
%include "tv/label.h"
%include "tv/radiobtn.h"
%include "tv/inputln.h"
%include "tv/statsdef.h"
%include "tv/statsitm.h"
%include "tv/statslin.h"
%include "tv/backgrnd.h"
%include "tv/scroller.h"
%include "tv/scrlbar.h"
%include "tv/button.h"

%include "tv/desktop.h"
%include "tv/program.h"
%include "tv/applictn.h"

