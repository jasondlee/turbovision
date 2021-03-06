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

#if !defined( __TSubMenu )
#define __TSubMenu

class CLY_EXPORT TSubMenu : public TMenuItem
{

public:

    TSubMenu( const char *, ushort, ushort = hcNoContext );
    TSubMenu& addItem ( TMenuItem& s2 );
    TSubMenu& addSubMenu(TSubMenu& s2);

};

#endif  // Uses_TSubMenu

