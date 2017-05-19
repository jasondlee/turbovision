/* File : example.i */
%module tvision

%{
#define Uses_EventCodes 
#define Uses_fpbase 
#define Uses_fpstream 
#define Uses_ifpstream 
#define Uses_iopstream 
#define Uses_ipstream 
#define Uses_MsgBox 
#define Uses_ofpstream 
#define Uses_opstream
#define Uses_pstream 
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
#define Uses_TEditor
#define Uses_TEditorApp
#define Uses_TEditWindow
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
#define Uses_TInputLine 
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
#define Uses_TPalette 
#define Uses_TParamText 
#define Uses_TPoint 
#define Uses_TPReadObjects 
#define Uses_TProgram 
#define Uses_TPWrittenObjects 
#define Uses_TPXPictureValidator 
#define Uses_TRadioButtons 
#define Uses_TRangeValidator 
#define Uses_TRect 
#define Uses_TReplaceDialogRec 
#define Uses_TResourceCollection 
#define Uses_TResourceFile 
#define Uses_TResourceItem 
#define Uses_TScreen 
#define Uses_TScrollBar 
#define Uses_TScroller 
#define Uses_TSearchRec 
#define Uses_TSItem 
#define Uses_TSortedCollection 
#define Uses_TSortedListBox 
#define Uses_TStaticText 
#define Uses_TStatusDef 
#define Uses_TStatusItem 
#define Uses_TStatusLine 
#define Uses_TStreamable 
#define Uses_TStreamableClass 
#define Uses_TStreamableTypes 
#define Uses_TStrIndexRec 
#define Uses_TStringCollection 
#define Uses_TStringList 
#define Uses_TStringLookupValidator 
#define Uses_TStrListMaker 
#define Uses_TSubMenu 
#define Uses_TTerminal 
#define Uses_TTextDevice 
#define Uses_TValidator 
#define Uses_TVCodePage 
#define Uses_TVConfigFile
#define Uses_TVFontCollection 
#define Uses_TView 
#define Uses_TVOSClipboard
#define Uses_TVPartitionTree556 
#define Uses_TWindow 
#define Uses_ViewCommands 
#define CLY_EXPORT

#include "tv.h"
#include "tv/applictn.h"
%}

%define CLY_EXPORT
%enddef
//%define Uses_TApplication
//%enddef
//%include "tv.h"
//%include "tv/backgrnd.h"
//%include "tv/desktop.h"
%include "tv/streambl.h"
%include "tv/object.h"
%include "tv/view.h"
%include "tv/group.h"
%include "tv/menubar.h"
%include "tv/program.h"
%include "tv/applictn.h"

/*
class TApplication : public TProgram
{

protected:

    TApplication();
    virtual ~TApplication();

    virtual void suspend();
    virtual void resume();

};
*/
