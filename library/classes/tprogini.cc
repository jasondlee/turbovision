/*
 *      Turbo Vision - Version 2.0
 *
 *      Copyright (c) 1994 by Borland International
 *      All Rights Reserved.
 *

Modified by Robert Hoehne to be used for RHIDE.

 *
 *
 */

#define Uses_TProgram
#define Uses_TStatusLine
#define Uses_TDeskTop
#define Uses_TMenuBar
#define Uses_TScreen
#define Uses_TVConfigFile
#include <tv.h>

TScreen          *TProgInit::tsc=NULL;
TVMainConfigFile *TProgInit::config=NULL;

TProgInit::TProgInit( ) {
 // Load the configuration file
 if (!config)
    config=new TVMainConfigFile();
 config->Load();
 // Read common settings
 long aux;
 if (config->Search("ShowCursorEver",aux))
    TScreen::setShowCursorEver(aux ? True : False);
 if (config->Search("DontMoveHiddenCursor",aux))
    TScreen::setDontMoveHiddenCursor(aux ? True : False);

 tsc=new TScreen();
}

TProgInit::~TProgInit()
{
 delete tsc;
 delete config;
 tsc=NULL;
 config=NULL;
}
